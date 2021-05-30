package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

/**
 * Created by rookie
 * on 2021-05-13 上午10:46
 */
@RequiresApi(29)
public class MediaDownload extends MediaBase {

    private String mDownloadUri;
    private String mRefererUri;

    public MediaDownload(String fileName) {
        super(fileName);
    }

    public void setDownloadUri(String downloadUri) {
        mDownloadUri = downloadUri;
    }

    public void setRefererUri(String refererUri) {
        mRefererUri = refererUri;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues contentValues = super.getContentValues();
        contentValues.put(MediaStore.Downloads.DOWNLOAD_URI, mDownloadUri);
        contentValues.put(MediaStore.Downloads.REFERER_URI, mRefererUri);
        return contentValues;
    }

    @Override
    public Uri getUri() {
        return MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL);
    }
}
