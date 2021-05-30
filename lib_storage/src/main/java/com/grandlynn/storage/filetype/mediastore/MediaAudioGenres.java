package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

public class MediaAudioGenres extends Base {

    private String mName = "name";

    public MediaAudioGenres(String fileName) {
        super(fileName);
    }

    @Override
    public String getMimeType() {
        return "";
    }

    @Override
    public Uri getUri() {
        return MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Audio.Genres.NAME, mName);
        return values;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
