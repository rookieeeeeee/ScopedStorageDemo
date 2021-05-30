package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

/**
 * Created by rookie
 * on 2021-05-13 上午10:46
 */
public class MediaVideo extends MediaBase {
    private static final String[] mimes = {"mp4", "avi", "flv"};

    private String mBookmark;
    private String mCategory;
    @RequiresApi(30)
    private String mColorRange;
    @RequiresApi(30)
    private String mColorStandard;
    @RequiresApi(30)
    private String mColorTransfer;
    private String mDescription;
    private String mIsprivate;
    private String mLanguage;
    @Deprecated
    private String mLatitude;
    @Deprecated
    private String mLongitude;
    @Deprecated
    private String mMiniThumbMagic;
    private String mTags;

    public MediaVideo(String fileName) {
        super(fileName);
    }


    @Override
    public Uri getUri() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MediaStore.Video.VideoColumns.BOOKMARK,mBookmark);
        values.put(MediaStore.Video.VideoColumns.CATEGORY,mCategory);
        values.put(MediaStore.Video.VideoColumns.DESCRIPTION,mDescription);
        values.put(MediaStore.Video.VideoColumns.IS_PRIVATE,mIsprivate);
        values.put(MediaStore.Video.VideoColumns.LANGUAGE,mLanguage);
        values.put(MediaStore.Video.VideoColumns.LATITUDE,mLatitude);
        values.put(MediaStore.Video.VideoColumns.LONGITUDE,mLongitude);
        values.put(MediaStore.Video.VideoColumns.MINI_THUMB_MAGIC,mMiniThumbMagic);
        values.put(MediaStore.Video.VideoColumns.TAGS,mTags);

        if (Build.VERSION.SDK_INT >= 30) {
            values.put(MediaStore.Video.VideoColumns.COLOR_RANGE,mColorRange);
            values.put(MediaStore.Video.VideoColumns.COLOR_STANDARD,mColorStandard);
            values.put(MediaStore.Video.VideoColumns.COLOR_TRANSFER,mColorTransfer);
        }

        return values;
    }


    public void setBookmark(String bookmark) {
        mBookmark = bookmark;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setColorRange(String colorRange) {
        mColorRange = colorRange;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setColorStandard(String colorStandard) {
        mColorStandard = colorStandard;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setColorTransfer(String colorTransfer) {
        mColorTransfer = colorTransfer;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void setIsprivate(String isprivate) {
        mIsprivate = isprivate;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public void setMiniThumbMagic(String miniThumbMagic) {
        mMiniThumbMagic = miniThumbMagic;
    }

    public void setTags(String tags) {
        mTags = tags;
    }

    public static String[] getMimes() {
        return mimes;
    }

    public String getBookmark() {
        return mBookmark;
    }

    public String getCategory() {
        return mCategory;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getColorRange() {
        return mColorRange;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getColorStandard() {
        return mColorStandard;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getColorTransfer() {
        return mColorTransfer;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getIsprivate() {
        return mIsprivate;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public String getMiniThumbMagic() {
        return mMiniThumbMagic;
    }

    public String getTags() {
        return mTags;
    }
}
