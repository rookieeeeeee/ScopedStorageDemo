package com.grandlynn.storage.filetype.base;

/**
 * Created by rookie
 * on 2021-05-13 上午10:45
 */
public abstract class FileType {

    protected String mFileName;

    public FileType(String fileName) {
        this.mFileName = fileName;

    }

    public abstract String getMimeType();


    public String getFileName() {
        return mFileName;
    }
}
