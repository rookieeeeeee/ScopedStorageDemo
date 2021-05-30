package com.grandlynn.storage.accessor;

import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 实现了大部分java.io.File的接口
 * <p>
 * Created by rookie
 * on 2021-05-13 上午9:57
 */
public interface Accessor {

    Uri toUri();

    String getName();

    boolean isFile();

    boolean isDirectory();

    boolean isHidden();

    long length();

    boolean exists();

    boolean createNewFile() throws IOException;

    boolean delete();

    InputStream getInputStream() throws FileNotFoundException;

    OutputStream getOutputStream() throws FileNotFoundException;

    boolean mkdir();

    boolean mkdirs();

    boolean renameTo(String fileName);

    long lastModified();

    String[] list();

    String[] list(FilenameFilter filter);

    boolean canRead();

    boolean canWrite();

    boolean canExecute();

    boolean setLastModified(long time);

    boolean setReadOnly();

    boolean setWritable(boolean writable, boolean ownerOnly);

    boolean setReadable(boolean readable, boolean ownerOnly);

    boolean setExecutable(boolean executable, boolean ownerOnly);


}
