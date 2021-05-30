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
public class MediaAudio extends MediaBase {

    private String mAlbumId;
    @Deprecated
    private String mAlbumKey;
    private String mArtistId;
    @Deprecated
    private String mArtistKey;
    private String mBookmark;
    @RequiresApi(30)
    private String mGenreId;
    @RequiresApi(30)
    private String mGenreKey;
    private String mIsAlarm;
    @RequiresApi(29)
    private String mIsAudiobook;
    private String mIsMusic;
    private String mIsNotification;
    private String mIsPodcast;
    private String mIsRingtone;
    @Deprecated
    private String mTitleKey;
    @RequiresApi(30)
    private String mTitleResourceUri;
    private String mTrack;


    public MediaAudio(String fileName) {
        super(fileName);
    }

    @Override
    public Uri getUri() {
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = super.getContentValues();
        values.put(MediaStore.Audio.AudioColumns.ALBUM_ID, mAlbumId);
        values.put(MediaStore.Audio.AudioColumns.ALBUM_KEY, mAlbumKey);
        values.put(MediaStore.Audio.AudioColumns.ARTIST_ID, mArtistId);
        values.put(MediaStore.Audio.AudioColumns.ARTIST_KEY, mArtistKey);
        values.put(MediaStore.Audio.AudioColumns.BOOKMARK, mBookmark);
        values.put(MediaStore.Audio.AudioColumns.IS_ALARM, mIsAlarm);
        values.put(MediaStore.Audio.AudioColumns.IS_MUSIC, mIsMusic);
        values.put(MediaStore.Audio.AudioColumns.IS_NOTIFICATION, mIsNotification);
        values.put(MediaStore.Audio.AudioColumns.IS_PODCAST, mIsPodcast);
        values.put(MediaStore.Audio.AudioColumns.IS_RINGTONE, mIsRingtone);
        values.put(MediaStore.Audio.AudioColumns.TITLE_KEY, mTitleKey);
        values.put(MediaStore.Audio.AudioColumns.TRACK, mTrack);

        if (Build.VERSION.SDK_INT >= 29) {
            values.put(MediaStore.Audio.AudioColumns.IS_AUDIOBOOK, mIsAudiobook);
        }


        if (Build.VERSION.SDK_INT >= 30) {
            values.put(MediaStore.Audio.AudioColumns.GENRE_ID, mGenreId);
            values.put(MediaStore.Audio.AudioColumns.TITLE_RESOURCE_URI, mTitleResourceUri);
            values.put(MediaStore.Audio.AudioColumns.GENRE_KEY, mGenreKey);
        }
        return values;
    }

    public void setAlbumId(String albumId) {
        mAlbumId = albumId;
    }

    public void setAlbumKey(String albumKey) {
        mAlbumKey = albumKey;
    }

    public void setArtistId(String artistId) {
        mArtistId = artistId;
    }

    public void setArtistKey(String artistKey) {
        mArtistKey = artistKey;
    }

    public void setBookmark(String bookmark) {
        mBookmark = bookmark;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setGenreId(String genreId) {
        mGenreId = genreId;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setGenreKey(String genreKey) {
        mGenreKey = genreKey;
    }

    public void setIsAlarm(String isAlarm) {
        mIsAlarm = isAlarm;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void setIsAudiobook(String isAudiobook) {
        mIsAudiobook = isAudiobook;
    }

    public void setIsMusic(String isMusic) {
        mIsMusic = isMusic;
    }

    public void setIsNotification(String isNotification) {
        mIsNotification = isNotification;
    }

    public void setIsPodcast(String isPodcast) {
        mIsPodcast = isPodcast;
    }

    public void setIsRingtone(String isRingtone) {
        mIsRingtone = isRingtone;
    }

    public void setTitleKey(String titleKey) {
        mTitleKey = titleKey;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void setTitleResourceUri(String titleResourceUri) {
        mTitleResourceUri = titleResourceUri;
    }

    public void setTrack(String track) {
        mTrack = track;
    }
}
