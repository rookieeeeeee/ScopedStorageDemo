package com.grandlynn.storage.accessor;

import android.content.Context;
import android.net.Uri;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.filetype.mediastore.Base;
import com.grandlynn.storage.filetype.mediastore.MediaBase;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * MediaStore的存储策略，实现了对MediaStore API的封装
 * <p>
 * Created by rookie
 * on 2021-05-13 上午10:53
 */
public class MediaStoreAccessor extends AbsAccessor {


    private Uri  mUri;
    private Base mBase;

    public MediaStoreAccessor(ScopedStorage scopedStorage, MediaBase fileType) {
        super(scopedStorage, fileType);
        mBase = fileType;

    }

    @Override
    public Uri toUri() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public long length() {
        return 0;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean createNewFile() throws IOException {
        Context context = mScopedStorage.getContext();
        mUri = context.getContentResolver().insert(mBase.getUri(), mBase.getContentValues());
        return mUri != null;
    }

    @Override
    public boolean delete() {
        Context context = mScopedStorage.getContext();
        return context.getContentResolver().delete(mBase.getUri(), "", new String[]{""}) > 0;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        if (mUri != null) {
            return mScopedStorage.getContext().getContentResolver().openInputStream(mUri);
        }
        return null;
    }

    @Override
    public OutputStream getOutputStream() throws FileNotFoundException {
        if (mUri != null) {
            return mScopedStorage.getContext().getContentResolver().openOutputStream(mUri);
        }
        return null;
    }

    @Override
    public boolean mkdir() {
        return false;
    }

    @Override
    public boolean mkdirs() {
        return false;
    }

    @Override
    public boolean renameTo(String fileName) {
        return false;
    }

    @Override
    public long lastModified() {
        return 0;
    }

    @Override
    public String[] list() {
        return new String[0];
    }

    @Override
    public String[] list(FilenameFilter filter) {
        return new String[0];
    }

    @Override
    public boolean canRead() {
        return false;
    }

    @Override
    public boolean canWrite() {
        return false;
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
}
