package com.grandlynn.storage.accessor;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.documentfile.provider.DocumentFile;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.filetype.base.FileType;
import com.grandlynn.storage.filetype.document.DocFile;
import com.grandlynn.storage.filetype.document.DocTree;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * SAF框架的存储策略，实现了对DocumentFile的封装
 * <p>
 * Created by rookie
 * on 2021-05-13 下午4:10
 */
public class DocumentAccessor extends AbsAccessor {

    private DocumentFile mDocumentFile;

    public DocumentAccessor(ScopedStorage scopedStorage, FileType fileType) {
        super(scopedStorage, fileType);
        Uri uri = Uri.parse(fileType.getFileName());
        if (fileType instanceof DocFile) {
            if (DocumentFile.isDocumentUri(scopedStorage.getContext(), uri)) {
                mDocumentFile = DocumentFile.fromSingleUri(scopedStorage.getContext(), uri);
            }
        } else if (fileType instanceof DocTree) {
            mDocumentFile = DocumentFile.fromTreeUri(scopedStorage.getContext(), uri);
        } else {
            throw new IllegalArgumentException("请传入正确的 Document Uri");
        }
    }


    @Override
    public Uri toUri() {
        return mDocumentFile.getUri();
    }

    @Override
    public String getName() {
        return mDocumentFile.getName();
    }

    @Override
    public boolean isFile() {
        return mDocumentFile.isFile();
    }

    @Override
    public boolean isDirectory() {
        return mDocumentFile.isDirectory();
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public long lastModified() {
        return mDocumentFile.lastModified();
    }

    @Override
    public String[] list() {
        DocumentFile[] files = mDocumentFile.listFiles();
        String[] uris = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            uris[i] = files[i].getUri().toString();
        }
        return uris;
    }

    @Override
    public String[] list(FilenameFilter filter) {
        DocumentFile[] files = mDocumentFile.listFiles();
        List<String> r = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (filter != null) {
                boolean accept = filter.accept(null, files[i].getName());
                if (accept) {
                    r.add(files[i].getUri().toString());
                }
            } else {
                r.add(files[i].getUri().toString());
            }
        }
        return r.toArray(new String[0]);
    }

    @Override
    public long length() {
        return mDocumentFile.length();
    }

    @Override
    public boolean mkdir() {
        try {
            DocumentFile directory = mDocumentFile.createDirectory(mDocumentFile.getName());
            return directory != null && directory.exists() && directory.isDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean mkdirs() {
        return mkdir();
    }

    @Override
    public boolean renameTo(String fileName) {
        return mDocumentFile.renameTo(fileName);
    }

    @Override
    public boolean canRead() {
        return mDocumentFile.canRead();
    }

    //https://developer.android.google.cn/training/data-storage/shared/documents-files#perform-operations
    @Override
    public boolean canWrite() {
        return mDocumentFile.canWrite() && containWriteFlag();
    }

    @Override
    public boolean canExecute() {

        return false;
    }

    @Override
    public boolean setLastModified(long time) {
        return false;
    }

    @Override
    public boolean setReadOnly() {
        return false;
    }

    @Override
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        return false;
    }

    @Override
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        return false;
    }

    @Override
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        return false;
    }

    @Override
    public boolean exists() {
        return mDocumentFile.exists();
    }

    @Override
    public boolean createNewFile() throws IOException {
        if (isDirectory()) {
            return false;
        }
        try {
            DocumentFile file = mDocumentFile.createFile(mFileType.getMimeType(), mDocumentFile.getName());
            if (file != null && file.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete() {
        return mDocumentFile.exists();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        if (isDirectory()) {
            return null;
        }
        Context context = mScopedStorage.getContext();
        ContentResolver resolver = context.getContentResolver();
        return resolver.openInputStream(mDocumentFile.getUri());
    }

    @Override
    public OutputStream getOutputStream() throws FileNotFoundException {
        if (isDirectory()) {
            return null;
        }
        Context context = mScopedStorage.getContext();
        ContentResolver resolver = context.getContentResolver();
        return resolver.openOutputStream(mDocumentFile.getUri());
    }


    public boolean containWriteFlag() {
        int flags = queryForInt(mScopedStorage.getContext(),
                mDocumentFile.getUri(), DocumentsContract.Document.COLUMN_FLAGS, 0);

        return (flags & DocumentsContract.Document.FLAG_SUPPORTS_WRITE) != 0;
    }

    private static int queryForInt(Context context, Uri self, String column,
                                   int defaultValue) {
        return (int) queryForLong(context, self, column, defaultValue);
    }

    private static long queryForLong(Context context, Uri self, String column,
                                     long defaultValue) {
        final ContentResolver resolver = context.getContentResolver();

        Cursor c = null;
        try {
            c = resolver.query(self, new String[]{column}, null, null, null);
            if (c.moveToFirst() && !c.isNull(0)) {
                return c.getLong(0);
            } else {
                return defaultValue;
            }
        } catch (Exception e) {
            Log.w("SafAccessor", "Failed query: " + e);
            return defaultValue;
        } finally {
            closeQuietly(c);
        }
    }

    private static void closeQuietly(@Nullable AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception ignored) {
            }
        }
    }

    private InputStream getInputStreamForVirtualFile(Uri uri, String mimeTypeFilter)
            throws IOException {

        ContentResolver resolver = mScopedStorage.getContext().getContentResolver();

        String[] openableMimeTypes = resolver.getStreamTypes(uri, mimeTypeFilter);

        if (openableMimeTypes == null ||
                openableMimeTypes.length < 1) {
            throw new FileNotFoundException();
        }

        return resolver
                .openTypedAssetFileDescriptor(uri, openableMimeTypes[0], null)
                .createInputStream();
    }
}
