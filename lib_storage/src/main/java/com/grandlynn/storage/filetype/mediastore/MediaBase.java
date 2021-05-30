package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

import com.grandlynn.storage.filetype.document.DocFile;

/**
 * Created by rookie
 * on 2021-05-14 上午11:17
 */
public abstract class MediaBase extends Base {

    @Deprecated
    protected String mData;
    protected long   mSize;
    @RequiresApi(30)
    protected String mAlbum;
    @RequiresApi(30)
    protected String mAlbumArtist;
    @RequiresApi(30)
    protected String mArtist;
    @RequiresApi(30)
    protected String mAuthor;
    @RequiresApi(30)
    protected String mBitrate;
    @RequiresApi(29)
    protected String mBucketDisplayName;
    @RequiresApi(29)
    protected String mBucketId;
    @RequiresApi(30)
    protected String mCaptureFramerate;
    @RequiresApi(30)
    protected String mCdTrackNumber;
    @RequiresApi(30)
    protected String mCompilation;
    @RequiresApi(30)
    protected String mComposer;
    protected String mDateAdded;
    @RequiresApi(29)
    protected String mDateExpires;
    protected String mDateModified;
    @RequiresApi(29)
    protected String mDateTaken;
    @RequiresApi(30)
    protected String mDiscNumber;
    protected String mDisplayName;
    @RequiresApi(29)
    protected String mDocumentId;
    @RequiresApi(29)
    protected String mDuration;
    @RequiresApi(30)
    protected String mGenerationAdded;
    @RequiresApi(30)
    protected String mGenerationModified;
    @RequiresApi(30)
    protected String mGenre;
    protected int    mHeight;
    @RequiresApi(29)
    protected String mInstanceId;
    @RequiresApi(30)
    protected String mIsDownload;
    @RequiresApi(30)
    protected String mIsDrm;
    @RequiresApi(30)
    protected String mIsFavorite;
    @RequiresApi(29)
    protected String mIsPending;
    @RequiresApi(30)
    protected String mIsTrashed;
    protected String mMimeType;
    @RequiresApi(30)
    protected String mNumTracks;
    @RequiresApi(29)
    protected int    mOrientation;
    @RequiresApi(29)
    protected String mOriginalDocumentId;
    @RequiresApi(29)
    protected String mOwnerPackageName;
    @RequiresApi(29)
    protected String mRelativePath;
    @RequiresApi(30)
    protected String mResolution;
    protected String mTitle;
    @RequiresApi(29)
    protected String mVolumeName;
    protected int    mWidth;
    @RequiresApi(30)
    protected String mWriter;
    @RequiresApi(30)
    protected String mXmp;
    @RequiresApi(30)
    protected String mYear;

    public MediaBase(String fileName) {
        super(fileName);
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
//        values.put(MediaStore.MediaColumns.DATA, mData);
//        values.put(MediaStore.MediaColumns.SIZE, mSize);
//        values.put(MediaStore.MediaColumns.DATE_ADDED, mDateAdded);
//        values.put(MediaStore.MediaColumns.DATE_MODIFIED, mDateModified);

        values.put(MediaStore.MediaColumns.DISPLAY_NAME, mDisplayName);
        values.put(MediaStore.MediaColumns.TITLE, mTitle);
        values.put(MediaStore.MediaColumns.MIME_TYPE, mMimeType);
        values.put(MediaStore.MediaColumns.WIDTH, mWidth);
        values.put(MediaStore.MediaColumns.HEIGHT, mHeight);


        if (Build.VERSION.SDK_INT >= 29) {
            values.put(MediaStore.MediaColumns.ORIENTATION, mOrientation);
            values.put(MediaStore.MediaColumns.RELATIVE_PATH, mRelativePath);
            values.put(MediaStore.MediaColumns.BUCKET_DISPLAY_NAME, mBucketDisplayName);
            values.put(MediaStore.MediaColumns.BUCKET_ID, mBucketId);
            values.put(MediaStore.MediaColumns.DATE_EXPIRES, mDateExpires);
            values.put(MediaStore.MediaColumns.DATE_TAKEN, mDateTaken);
            values.put(MediaStore.MediaColumns.DOCUMENT_ID, mDocumentId);
            values.put(MediaStore.MediaColumns.DURATION, mDuration);
            values.put(MediaStore.MediaColumns.IS_PENDING, mIsPending);
            values.put(MediaStore.MediaColumns.INSTANCE_ID, mInstanceId);
            values.put(MediaStore.MediaColumns.ORIGINAL_DOCUMENT_ID, mOriginalDocumentId);
            values.put(MediaStore.MediaColumns.OWNER_PACKAGE_NAME, mOwnerPackageName);
            values.put(MediaStore.MediaColumns.VOLUME_NAME, mVolumeName);
        }

        if (Build.VERSION.SDK_INT >= 30) {
            values.put(MediaStore.MediaColumns.ALBUM_ARTIST, mAlbumArtist);
            values.put(MediaStore.MediaColumns.ARTIST, mArtist);
            values.put(MediaStore.MediaColumns.AUTHOR, mAuthor);
            values.put(MediaStore.MediaColumns.BITRATE, mBitrate);
            values.put(MediaStore.MediaColumns.CAPTURE_FRAMERATE, mCaptureFramerate);
            values.put(MediaStore.MediaColumns.CD_TRACK_NUMBER, mCdTrackNumber);
            values.put(MediaStore.MediaColumns.COMPILATION, mCompilation);
            values.put(MediaStore.MediaColumns.COMPOSER, mComposer);
            values.put(MediaStore.MediaColumns.DISC_NUMBER, mDiscNumber);
            values.put(MediaStore.MediaColumns.GENERATION_ADDED, mGenerationAdded);
            values.put(MediaStore.MediaColumns.GENERATION_MODIFIED, mGenerationModified);
            values.put(MediaStore.MediaColumns.GENRE, mGenre);
            values.put(MediaStore.MediaColumns.IS_DOWNLOAD, mIsDownload);
            values.put(MediaStore.MediaColumns.IS_DRM, mIsDrm);
            values.put(MediaStore.MediaColumns.IS_FAVORITE, mIsFavorite);
            values.put(MediaStore.MediaColumns.IS_TRASHED, mIsTrashed);
            values.put(MediaStore.MediaColumns.NUM_TRACKS, mNumTracks);
            values.put(MediaStore.MediaColumns.RESOLUTION, mResolution);
            values.put(MediaStore.MediaColumns.WRITER, mWriter);
            values.put(MediaStore.MediaColumns.XMP, mXmp);
            values.put(MediaStore.MediaColumns.YEAR, mYear);
            values.put(MediaStore.MediaColumns.ALBUM, mAlbum);
        }
        return values;
    }

    @Override
    public String getMimeType() {
        return mMimeType;
    }

    public String getData() {
        return mData;
    }

    public long getSize() {
        return mSize;
    }

    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    @RequiresApi(29)
    public void setOrientation(int orientation) {
        mOrientation = orientation;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    @RequiresApi(29)
    public void setRelativePath(String relativePath) {
        mRelativePath = relativePath;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setAlbum(String album) {
        mAlbum = album;
    }

    @RequiresApi(30)
    public void setAlbumArtist(String albumArtist) {
        mAlbumArtist = albumArtist;
    }

    @RequiresApi(30)
    public void setArtist(String artist) {
        mArtist = artist;
    }

    @RequiresApi(30)
    public void setAuthor(String author) {
        mAuthor = author;
    }

    @RequiresApi(30)
    public void setBitrate(String bitrate) {
        mBitrate = bitrate;
    }

    @RequiresApi(29)
    public void setBucketDisplayName(String bucketDisplayName) {
        mBucketDisplayName = bucketDisplayName;
    }

    @RequiresApi(29)
    public void setBucketId(String bucketId) {
        mBucketId = bucketId;
    }

    @RequiresApi(30)
    public void setCaptureFramerate(String captureFramerate) {
        mCaptureFramerate = captureFramerate;
    }

    @RequiresApi(30)
    public void setCdTrackNumber(String cdTrackNumber) {
        mCdTrackNumber = cdTrackNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setCompilation(String compilation) {
        mCompilation = compilation;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setComposer(String composer) {
        mComposer = composer;
    }

    @RequiresApi(29)
    public void setDateExpires(String dateExpires) {
        mDateExpires = dateExpires;
    }

    @RequiresApi(29)
    public void setDateTaken(String dateTaken) {
        mDateTaken = dateTaken;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setDiscNumber(String discNumber) {
        mDiscNumber = discNumber;
    }

    @RequiresApi(29)
    public void setDocumentId(String documentId) {
        mDocumentId = documentId;
    }

    @RequiresApi(29)
    public void setDuration(String duration) {
        mDuration = duration;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setGenerationAdded(String generationAdded) {
        mGenerationAdded = generationAdded;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setGenerationModified(String generationModified) {
        mGenerationModified = generationModified;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setGenre(String genre) {
        mGenre = genre;
    }

    @RequiresApi(29)
    public void setInstanceId(String instanceId) {
        mInstanceId = instanceId;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setIsDownload(String isDownload) {
        mIsDownload = isDownload;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setIsDrm(String isDrm) {
        mIsDrm = isDrm;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setIsFavorite(String isFavorite) {
        mIsFavorite = isFavorite;
    }

    @RequiresApi(29)
    public void setIsPending(String isPending) {
        mIsPending = isPending;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setIsTrashed(String isTrashed) {
        mIsTrashed = isTrashed;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setNumTracks(String numTracks) {
        mNumTracks = numTracks;
    }

    @RequiresApi(29)
    public void setOriginalDocumentId(String originalDocumentId) {
        mOriginalDocumentId = originalDocumentId;
    }

    @RequiresApi(29)
    public void setOwnerPackageName(String ownerPackageName) {
        mOwnerPackageName = ownerPackageName;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setResolution(String resolution) {
        mResolution = resolution;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @RequiresApi(29)
    public void setVolumeName(String volumeName) {
        mVolumeName = volumeName;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setWriter(String writer) {
        mWriter = writer;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setXmp(String xmp) {
        mXmp = xmp;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setYear(String year) {
        mYear = year;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getAlbum() {
        return mAlbum;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getAlbumArtist() {
        return mAlbumArtist;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getArtist() {
        return mArtist;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getAuthor() {
        return mAuthor;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getBitrate() {
        return mBitrate;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getBucketDisplayName() {
        return mBucketDisplayName;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getBucketId() {
        return mBucketId;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getCaptureFramerate() {
        return mCaptureFramerate;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getCdTrackNumber() {
        return mCdTrackNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getCompilation() {
        return mCompilation;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getComposer() {
        return mComposer;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getDateExpires() {
        return mDateExpires;
    }

    public String getDateModified() {
        return mDateModified;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getDateTaken() {
        return mDateTaken;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getDiscNumber() {
        return mDiscNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getDocumentId() {
        return mDocumentId;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getDuration() {
        return mDuration;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getGenerationAdded() {
        return mGenerationAdded;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getGenerationModified() {
        return mGenerationModified;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getGenre() {
        return mGenre;
    }

    public int getHeight() {
        return mHeight;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getInstanceId() {
        return mInstanceId;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getIsDownload() {
        return mIsDownload;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getIsDrm() {
        return mIsDrm;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getIsFavorite() {
        return mIsFavorite;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getIsPending() {
        return mIsPending;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getIsTrashed() {
        return mIsTrashed;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getNumTracks() {
        return mNumTracks;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public int getOrientation() {
        return mOrientation;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getOriginalDocumentId() {
        return mOriginalDocumentId;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getOwnerPackageName() {
        return mOwnerPackageName;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getRelativePath() {
        return mRelativePath;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getResolution() {
        return mResolution;
    }

    public String getTitle() {
        return mTitle;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getVolumeName() {
        return mVolumeName;
    }

    public int getWidth() {
        return mWidth;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getWriter() {
        return mWriter;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getXmp() {
        return mXmp;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public String getYear() {
        return mYear;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DocFile convertToDocumentFile(Context context) {
        return new DocFile(MediaStore.getDocumentUri(context, Uri.parse(mDisplayName)).toString());
    }

}
