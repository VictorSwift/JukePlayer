package com.example.android.jukeplayer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<MusicArrayList> mMusic;
    public static ArrayList<AlbumArrayList> mAlbum;
    public static ArrayList<SettingsArrayList> mSettings;
    public static final String KEY_POSITION = "position";
    public static final String KEY_ALBUMNAME = "albumName";
    public static final String KEY_SETTINGSNAME = "albumName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The AlbumArrayList has Album Image, Album Name, Album playlist as arguments
        mAlbum = new ArrayList<>();
        mAlbum.add(new AlbumArrayList(R.drawable.rendezvous, getString(R.string.album_rendezvous), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.high_star, getString(R.string.album_high_star), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.sftos, getString(R.string.album_sftos), 1));
        mAlbum.add(new AlbumArrayList(R.drawable.odysseus, getString(R.string.album_odysseus), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.trip_to_south, getString(R.string.album_trip_to_the_south), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.twenty_seven, getString(R.string.album_27), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.this_is_me, getString(R.string.album_this_is_me), 2));
        mAlbum.add(new AlbumArrayList(R.drawable.bltn, getString(R.string.album_Better_Late_Than_Never), 2));

        // The MusicArrayList ArrayList has Music Image, Artist Name, Music Title and the Album Name as arguments
        mMusic = new ArrayList<>();
        mMusic.add(new MusicArrayList(R.drawable.rendezvous, getString(R.string.your_father), getString(R.string.artist_mi_abaga), getString(R.string.album_rendezvous)));
        mMusic.add(new MusicArrayList(R.drawable.high_star, getString(R.string.music_beautiful_scars), getString(R.string.artist_young_6ix), getString(R.string.album_high_star)));
        mMusic.add(new MusicArrayList(R.drawable.sftos, getString(R.string.music_sweet_love), getString(R.string.artist_wizkid), getString(R.string.album_sftos)));
        mMusic.add(new MusicArrayList(R.drawable.odysseus, getString(R.string.music_rude_boys), getString(R.string.artist_jesse_jagz), getString(R.string.album_odysseus)));
        mMusic.add(new MusicArrayList(R.drawable.trip_to_south, getString(R.string.music_biggie_man), getString(R.string.artist_erriga), getString(R.string.album_trip_to_the_south)));
        mMusic.add(new MusicArrayList(R.drawable.high_star, getString(R.string.music_stay_woke), getString(R.string.artist_young_6ix), getString(R.string.album_high_star)));
        mMusic.add(new MusicArrayList(R.drawable.twenty_seven, getString(R.string.music_the_way), getString(R.string.artist_falz), getString(R.string.album_27)));
        mMusic.add(new MusicArrayList(R.drawable.this_is_me, getString(R.string.music_maradona), getString(R.string.artist_niniola), getString(R.string.album_this_is_me)));
        mMusic.add(new MusicArrayList(R.drawable.trip_to_south, getString(R.string.music_spoil_everywhere), getString(R.string.artist_erriga), getString(R.string.album_trip_to_the_south)));
        mMusic.add(new MusicArrayList(R.drawable.odysseus, getString(R.string.music_awake), getString(R.string.artist_jesse_jagz), getString(R.string.album_odysseus)));
        mMusic.add(new MusicArrayList(R.drawable.bltn, getString(R.string.music_where_you_dey), getString(R.string.artist_yungl), getString(R.string.album_Better_Late_Than_Never)));
        mMusic.add(new MusicArrayList(R.drawable.bltn, getString(R.string.music_anya), getString(R.string.artist_yungl), getString(R.string.album_Better_Late_Than_Never)));
        mMusic.add(new MusicArrayList(R.drawable.rendezvous, getString(R.string.on_code), getString(R.string.artist_mi_abaga), getString(R.string.album_rendezvous)));
        mMusic.add(new MusicArrayList(R.drawable.this_is_me, getString(R.string.music_sicker), getString(R.string.artist_niniola), getString(R.string.album_this_is_me)));

        // The SettingsArrayList ArrayList has just the Settings Namee as argument
        mSettings = new ArrayList<>();
        mSettings.add(new SettingsArrayList(getString(R.string.settings_equalizer)));
        mSettings.add(new SettingsArrayList(getString(R.string.settings_theme)));
        mSettings.add(new SettingsArrayList(getString(R.string.settings_lyrics)));
        mSettings.add(new SettingsArrayList(getString(R.string.settings_headset)));
        mSettings.add(new SettingsArrayList(getString(R.string.settings_notifications)));

        // create a view pager object for swiping fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter object that determines which fragment to display
        HomeFragmentAdapter adapter = new HomeFragmentAdapter(MainActivity.this, getSupportFragmentManager());

        //pass the fragment adapter object to the viewpager object
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        // create the TabLayout object and pass in the viewpager into it
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
