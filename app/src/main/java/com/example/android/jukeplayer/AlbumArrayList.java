package com.example.android.jukeplayer;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class AlbumArrayList {

    private int mImageId;
    private String mAlbumName;
    private int mNumOfSongs;

    /*required constructor*/
    AlbumArrayList(int mImageId, String mAlbumName, int mNumOfSongs) {
        this.mImageId = mImageId;
        this.mAlbumName = mAlbumName;
        this.mNumOfSongs = mNumOfSongs;
    }

    int getImageId() {
        return mImageId;
    }

    String getAlbumName() {
        return mAlbumName;
    }

    int getNumOfSongs() {
        return mNumOfSongs;
    }
}
