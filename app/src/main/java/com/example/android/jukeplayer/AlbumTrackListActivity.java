package com.example.android.jukeplayer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class AlbumTrackListActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_playlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //code for back arrow button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            LinearLayout albumPlaylistLinearLayout = (LinearLayout) findViewById(R.id.album_playlist);
            int position = extras.getInt(MainActivity.KEY_POSITION);
            String albumName = extras.getString(MainActivity.KEY_ALBUMNAME);

            /*create textView object to hold dynamic values*/
            TextView textViewAlbum = new TextView(this);
            textViewAlbum.setText(albumName);
            textViewAlbum.setTextAppearance(this, android.R.style.TextAppearance_Large);
            textViewAlbum.setTypeface(null, Typeface.BOLD);
            textViewAlbum.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            textViewAlbum.setPadding(0, 32, 0, 48);
            albumPlaylistLinearLayout.addView(textViewAlbum);

            LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(500, 500);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(MainActivity.mAlbum.get(position).getImageId());
            imageView.setLayoutParams(linearLayout);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setAdjustViewBounds(true);
            linearLayout.gravity = Gravity.CENTER_HORIZONTAL;
            albumPlaylistLinearLayout.addView(imageView);

            for (int i = 0; i < MainActivity.mMusic.size(); i++) {
                if (Objects.equals(albumName, MainActivity.mMusic.get(i).getAlbumName())) {

            /*Programmatically set TextView for the tracks in the album*/
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(80, 26, 80, 16); //left top right bottm
                    TextView textView = new TextView(this);
                    textView.setText(MainActivity.mMusic.get(i).getMusicName());
                    textView.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                    textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                    textView.setPadding(0, 32, 0, 32);
                    textView.setBackgroundResource(R.drawable.background_button);
                    textView.setLayoutParams(layoutParams);
                    textView.setClickable(true);
                    textView.setFocusable(true);
                    albumPlaylistLinearLayout.addView(textView);

                    final int musicPosition = i;
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(AlbumTrackListActivity.this, NowPlayingActivity.class);
                            intent.putExtra(MainActivity.KEY_POSITION, musicPosition);
                            startActivity(intent);
                        }
                    });
                }
            }
        }
    }
}
