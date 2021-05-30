package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

public class MediaAudioAlbum extends Base {

    private String mAlbum;
    @Deprecated
    private String mAlbumArt;
    private String mAlbumId;
    @Deprecated
    private String mAlbumKey;
    private String mArtist;
    @RequiresApi(29)
    private String mArtistId;
    @Deprecated
    private String mArtistKey;
    private String mFirstYear;
    private String mLastYear;
    private String mNumberOfSongs;
    private String mNumberOfSongsForArtist;

    public MediaAudioAlbum(String fileName) {
        super(fileName);
    }

    @Override
    public Uri getUri() {
        return MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Audio.AlbumColumns.ALBUM, mAlbum);
        values.put(MediaStore.Audio.AlbumColumns.ALBUM_ART, mAlbumArt);
        values.put(MediaStore.Audio.AlbumColumns.ALBUM_ID, mAlbumId);
        values.put(MediaStore.Audio.AlbumColumns.ALBUM_KEY, mAlbumKey);
        values.put(MediaStore.Audio.AlbumColumns.ARTIST, mArtist);
        values.put(MediaStore.Audio.AlbumColumns.ALBUM_KEY, mArtistKey);
        values.put(MediaStore.Audio.AlbumColumns.FIRST_YEAR, mFirstYear);
        values.put(MediaStore.Audio.AlbumColumns.LAST_YEAR, mLastYear);
        values.put(MediaStore.Audio.AlbumColumns.NUMBER_OF_SONGS, mNumberOfSongs);
        values.put(MediaStore.Audio.AlbumColumns.NUMBER_OF_SONGS_FOR_ARTIST, mNumberOfSongsForArtist);

        if (Build.VERSION.SDK_INT >= 29) {
            values.put(MediaStore.Audio.AlbumColumns.ARTIST_ID, mArtistId);
        }

        return values;
    }

    @Override
    public String getMimeType() {
        return "";
    }


    public void setAlbum(String album) {
        mAlbum = album;
    }

    public void setAlbumArt(String albumArt) {
        mAlbumArt = albumArt;
    }

    public void setAlbumId(String albumId) {
        mAlbumId = albumId;
    }

    public void setAlbumKey(String albumKey) {
        mAlbumKey = albumKey;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void setArtistId(String artistId) {
        mArtistId = artistId;
    }

    public void setArtistKey(String artistKey) {
        mArtistKey = artistKey;
    }

    public void setFirstYear(String firstYear) {
        mFirstYear = firstYear;
    }

    public void setLastYear(String lastYear) {
        mLastYear = lastYear;
    }

    public void setNumberOfSongs(String numberOfSongs) {
        mNumberOfSongs = numberOfSongs;
    }

    public void setNumberOfSongsForArtist(String numberOfSongsForArtist) {
        mNumberOfSongsForArtist = numberOfSongsForArtist;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getAlbumArt() {
        return mAlbumArt;
    }

    public String getAlbumId() {
        return mAlbumId;
    }

    public String getAlbumKey() {
        return mAlbumKey;
    }

    public String getArtist() {
        return mArtist;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public String getArtistId() {
        return mArtistId;
    }

    public String getArtistKey() {
        return mArtistKey;
    }

    public String getFirstYear() {
        return mFirstYear;
    }

    public String getLastYear() {
        return mLastYear;
    }

    public String getNumberOfSongs() {
        return mNumberOfSongs;
    }

    public String getNumberOfSongsForArtist() {
        return mNumberOfSongsForArtist;
    }
}
