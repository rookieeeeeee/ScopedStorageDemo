package com.grandlynn.storage.accessor;

import android.net.Uri;

import com.grandlynn.storage.ScopedStorage;
import com.grandlynn.storage.filetype.base.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Android Q(29)以下传统存储策略，代理了File类的部分方法，接口全部转交给File处理
 * <p>
 * Created by rookie
 * on 2021-05-13 上午10:53
 */
public class LegacyAccessor extends AbsAccessor {

    private File mFile;


    public LegacyAccessor(ScopedStorage scopedStorage, FileType fileType) {
        super(scopedStorage,fileType);
        mFile = new File(scopedStorage.getPrefix(), fileType.getFileName());
    }


    @Override
    public Uri toUri() {
        return Uri.fromFile(mFile);
    }

    @Override
    public String getName() {
        return mFile.getName();
    }

    @Override
    public boolean isFile() {
        return mFile.isFile();
    }

    @Override
    public boolean isDirectory() {
        return mFile.isDirectory();
    }

    @Override
    public boolean isHidden() {
        return mFile.isHidden();
    }

    @Override
    public long lastModified() {
        return mFile.lastModified();
    }

    @Override
    public String[] list() {
        return mFile.list();
    }

    @Override
    public String[] list(FilenameFilter filter) {
        return mFile.list(filter);
    }

    @Override
    public long length() {
        return mFile.length();
    }

    @Override
    public boolean mkdir() {
        return mFile.mkdir();
    }

    @Override
    public boolean mkdirs() {
        return mFile.mkdirs();
    }

    @Override
    public boolean renameTo(String fileName) {
        return mFile.renameTo(new File(fileName));
    }

    @Override
    public boolean canRead() {
        return mFile.canRead();
    }

    @Override
    public boolean canWrite() {
        return mFile.canWrite();
    }

    @Override
    public boolean canExecute() {
        return mFile.canExecute();
    }

    @Override
    public boolean setLastModified(long time) {
        return mFile.setLastModified(time);
    }

    @Override
    public boolean setReadOnly() {
        return mFile.setReadOnly();
    }

    @Override
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        return mFile.setWritable(writable, ownerOnly);
    }

    @Override
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        return mFile.setReadable(readable, ownerOnly);
    }

    @Override
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        return mFile.setExecutable(executable, ownerOnly);
    }

    @Override
    public boolean exists() {
        return mFile.exists();
    }

    @Override
    public boolean createNewFile() throws IOException {
        return mFile.createNewFile();
    }

    @Override
    public boolean delete() {
        return mFile.delete();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(mFile);
    }

    @Override
    public OutputStream getOutputStream() throws FileNotFoundException {
        return new FileOutputStream(mFile);
    }
}
