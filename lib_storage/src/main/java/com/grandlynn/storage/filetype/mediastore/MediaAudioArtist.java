package com.grandlynn.storage.filetype.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

public class MediaAudioArtist extends Base {

    private String mArtist;
    @Deprecated
    private String mArtistKey;
    private String mNumberOfAlbums;
    private String mNumberOfTracks;

    public MediaAudioArtist(String fileName) {
        super(fileName);
    }

    @Override
    public String getMimeType() {
        return "";
    }

    @Override
    public Uri getUri() {
        return MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Audio.ArtistColumns.ARTIST, mArtist);
        values.put(MediaStore.Audio.ArtistColumns.ARTIST_KEY, mArtistKey);
        values.put(MediaStore.Audio.ArtistColumns.NUMBER_OF_ALBUMS, mNumberOfAlbums);
        values.put(MediaStore.Audio.ArtistColumns.NUMBER_OF_TRACKS, mNumberOfTracks);
        return null;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public void setArtistKey(String artistKey) {
        mArtistKey = artistKey;
    }

    public void setNumberOfAlbums(String numberOfAlbums) {
        mNumberOfAlbums = numberOfAlbums;
    }

    public void setNumberOfTracks(String numberOfTracks) {
        mNumberOfTracks = numberOfTracks;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getArtistKey() {
        return mArtistKey;
    }

    public String getNumberOfAlbums() {
        return mNumberOfAlbums;
    }

    public String getNumberOfTracks() {
        return mNumberOfTracks;
    }
}
