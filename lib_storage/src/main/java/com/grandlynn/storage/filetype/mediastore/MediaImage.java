package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

/**
 * Created by rookie
 * on 2021-05-13 上午10:45
 */
public class MediaImage extends MediaBase {

    private String mDescription;
    @RequiresApi(30)
    private String mExposureTime;
    @RequiresApi(30)
    private String mFNumber;
    @RequiresApi(30)
    private String mIso;
    private String mIsprivate;
    @Deprecated
    private double mLatitude;
    @Deprecated
    private double mLongitude;
    @Deprecated
    private String mMiniThumbMagic;
    @Deprecated
    private String mPicasaId;
    @RequiresApi(30)
    private String mSceneCaptureType;

    public MediaImage(String fileName) {
        super(fileName);
    }

    @Override
    public Uri getUri() {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MediaStore.Images.ImageColumns.DESCRIPTION, mDescription);
        values.put(MediaStore.Images.ImageColumns.IS_PRIVATE, mIsprivate);
        values.put(MediaStore.Images.ImageColumns.LONGITUDE, mLongitude);
        values.put(MediaStore.Images.ImageColumns.LATITUDE, mLatitude);
        values.put(MediaStore.Images.ImageColumns.MINI_THUMB_MAGIC, mMiniThumbMagic);
        values.put(MediaStore.Images.ImageColumns.PICASA_ID, mPicasaId);

        if (Build.VERSION.SDK_INT >= 30) {
            values.put(MediaStore.Images.ImageColumns.EXPOSURE_TIME, mExposureTime);
            values.put(MediaStore.Images.ImageColumns.F_NUMBER, mFNumber);
            values.put(MediaStore.Images.ImageColumns.ISO, mIso);
            values.put(MediaStore.Images.ImageColumns.SCENE_CAPTURE_TYPE, mSceneCaptureType);
        }

        return values;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setExposureTime(String exposureTime) {
        mExposureTime = exposureTime;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setFNumber(String FNumber) {
        mFNumber = FNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setIso(String iso) {
        mIso = iso;
    }

    public void setIsprivate(String isprivate) {
        mIsprivate = isprivate;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public void setMiniThumbMagic(String miniThumbMagic) {
        mMiniThumbMagic = miniThumbMagic;
    }

    public String getDescription() {
        return mDescription;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getExposureTime() {
        return mExposureTime;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getFNumber() {
        return mFNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getIso() {
        return mIso;
    }

    public String getIsprivate() {
        return mIsprivate;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getMiniThumbMagic() {
        return mMiniThumbMagic;
    }

    public String getPicasaId() {
        return mPicasaId;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getSceneCaptureType() {
        return mSceneCaptureType;
    }
}
