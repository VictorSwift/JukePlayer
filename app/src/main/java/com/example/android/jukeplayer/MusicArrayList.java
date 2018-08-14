package com.example.android.jukeplayer;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class MusicArrayList {
    private int mImageId;
    private String mMusicName;
    private String mArtistName;
    private String mAlbumName;

    MusicArrayList(int mImageId, String mMusicName, String mArtistName, String mAlbumName) {
        this.mImageId = mImageId;
        this.mMusicName = mMusicName;
        this.mArtistName = mArtistName;
        this.mAlbumName = mAlbumName;
    }

    int getImageId() {
        return mImageId;
    }

    String getMusicName() {
        return mMusicName;
    }

    String getArtistName() {
        return mArtistName;
    }

    String getAlbumName() {
        return mAlbumName;
    }
}
