package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;

import com.grandlynn.storage.filetype.base.FileType;

public abstract class Base extends FileType {

    protected long   mId;
    protected String mCount;

    public Base(String fileName) {
        super(fileName);
    }

    public abstract Uri getUri();

    public abstract ContentValues getContentValues();


    public long getId() {
        return mId;
    }

    public String getCount() {
        return mCount;
    }
}
