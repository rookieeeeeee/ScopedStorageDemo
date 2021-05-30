package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

public class MediaAudioPlaylist extends MediaBase {

    private String mName = "name";

    public MediaAudioPlaylist(String fileName) {
        super(fileName);
    }

    @Override
    public Uri getUri() {
        return MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MediaStore.Audio.Playlists.NAME,mName);
        return values;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
