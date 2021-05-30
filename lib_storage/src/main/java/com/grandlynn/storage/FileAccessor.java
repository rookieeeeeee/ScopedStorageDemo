package com.grandlynn.storage;

import android.net.Uri;

import com.grandlynn.storage.accessor.Accessor;
import com.grandlynn.storage.accessor.factory.AccessorFactory;
import com.grandlynn.storage.filetype.base.FileType;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Saf/MediaStore/Legacy存储策略的代理类
 *
 * <p>
 * Created by rookie
 * on 2021-05-13 上午10:19
 */
public class FileAccessor implements Accessor {

    private Accessor mAccessor;

    static Accessor access(ScopedStorage scopedStorage, FileType fileType) {
        return new FileAccessor(scopedStorage, fileType);
    }

    FileAccessor(ScopedStorage scopedStorage, FileType fileType) {
        mAccessor = new AccessorFactory().newAccessor(scopedStorage, fileType);
    }

    @Override
    public Uri toUri() {
        return mAccessor.toUri();
    }

    @Override
    public String getName() {
        return mAccessor.getName();
    }

    @Override
    public boolean isFile() {
        return mAccessor.isFile();
    }

    @Override
    public boolean isDirectory() {
        return mAccessor.isDirectory();
    }

    @Override
    public boolean isHidden() {
        return mAccessor.isHidden();
    }

    @Override
    public long lastModified() {
        return mAccessor.lastModified();
    }

    @Override
    public String[] list() {
        return mAccessor.list();
    }

    @Override
    public String[] list(FilenameFilter filter) {
        return mAccessor.list(filter);
    }

    @Override
    public long length() {
        return mAccessor.length();
    }

    @Override
    public boolean mkdir() {
        return mAccessor.mkdir();
    }

    @Override
    public boolean mkdirs() {
        return mAccessor.mkdirs();
    }

    @Override
    public boolean renameTo(String fileName) {
        return mAccessor.renameTo(fileName);
    }

    @Override
    public boolean canRead() {
        return mAccessor.canRead();
    }

    @Override
    public boolean canWrite() {
        return mAccessor.canWrite();
    }

    @Override
    public boolean canExecute() {
        return mAccessor.canExecute();
    }

    @Override
    public boolean setLastModified(long time) {
        return mAccessor.setLastModified(time);
    }

    @Override
    public boolean setReadOnly() {
        return mAccessor.setReadOnly();
    }

    @Override
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        return mAccessor.setWritable(writable, ownerOnly);
    }

    @Override
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        return mAccessor.setReadable(readable, ownerOnly);
    }

    @Override
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        return mAccessor.setExecutable(executable, ownerOnly);
    }

    @Override
    public boolean exists() {
        return mAccessor.exists();
    }

    @Override
    public boolean createNewFile() throws IOException {
        return mAccessor.createNewFile();
    }

    @Override
    public boolean delete() {
        return mAccessor.delete();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return mAccessor.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws FileNotFoundException {
        return mAccessor.getOutputStream();

    }
}
