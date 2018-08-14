package com.example.android.jukeplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //code for back arrow button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int nowPlaying = extras.getInt(MainActivity.KEY_POSITION);
            MusicArrayList currentlyPlaying = MainActivity.mMusic.get(nowPlaying);

            TextView nowPlayingMusicNameTextView = (TextView) findViewById(R.id.now_playing_music_name);
            nowPlayingMusicNameTextView.setText(currentlyPlaying.getMusicName());

            ImageView nowPlayingImageView = (ImageView) findViewById(R.id.now_playing_music_image);
            nowPlayingImageView.setImageResource(currentlyPlaying.getImageId());

            TextView nowPlayingMusicArtistTextView = (TextView) findViewById(R.id.now_playing_music_artist);
            nowPlayingMusicArtistTextView.setText(currentlyPlaying.getArtistName());

            TextView nowPlayingMusiAlbumTextView = (TextView) findViewById(R.id.now_playing_music_album);
            nowPlayingMusiAlbumTextView.setText(currentlyPlaying.getAlbumName());
        }
    }
}
