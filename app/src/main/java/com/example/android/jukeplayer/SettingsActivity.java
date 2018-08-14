package com.example.android.jukeplayer;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by VICTOR on 8/9/2018.
 */

public class SettingsActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //code for back arrow button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Use the position of the selected item to display the detail of the item*/
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int activeSetting = extras.getInt(MainActivity.KEY_POSITION);
            SettingsArrayList currentSetting = MainActivity.mSettings.get(activeSetting);
            /*get the textView by creating an object. Then simply set the text to the text of the selected item*/
            TextView nowPlayingMusicNameTextView = (TextView) findViewById(R.id.tv_settings);
            nowPlayingMusicNameTextView.setText(currentSetting.getSettingsName());

        }
    }
}
