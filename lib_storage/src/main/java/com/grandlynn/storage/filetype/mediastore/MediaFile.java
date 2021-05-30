package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

/**
 * Created by rookie
 * on 2021-05-13 下午2:26
 */
@RequiresApi(29)
public class MediaFile extends MediaBase {

    public enum MediaType {
        MEDIA_TYPE_NONE(0),
        MEDIA_TYPE_IMAGE(1),
        MEDIA_TYPE_AUDIO(2),
        MEDIA_TYPE_VIDEO(3),
        MEDIA_TYPE_PLAYLIST(4),
        MEDIA_TYPE_SUBTITLE(5),
        MEDIA_TYPE_DOCUMENT(6);

        int value;

        MediaType(int value) {
            this.value = value;
        }
    }

    protected MediaType mMediaType;
    protected String    mParent;

    public MediaFile(String fileName) {
        super(fileName);
        mMediaType = MediaType.MEDIA_TYPE_DOCUMENT;
    }

    public String getParent() {
        return mParent;
    }

    @Override
    public Uri getUri() {
        return MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL);
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MediaStore.Files.FileColumns.MEDIA_TYPE, mMediaType.value);
        return values;
    }


}
