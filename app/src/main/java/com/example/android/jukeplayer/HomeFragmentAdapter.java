package com.example.android.jukeplayer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class HomeFragmentAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    HomeFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // order of fragments for each tab item
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new MusicFragment();
        else if (position == 1)
            return new AlbumFragment();
        else
            return new SettingsFragment();
    }

    // Number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // The Title of each tab item
    @Override
    public CharSequence getPageTitle(int position) {
        // Use the tab item position to render the tab title
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_music);
            case 1:
                return mContext.getString(R.string.title_album);
            case 2:
                return mContext.getString(R.string.title_settings);
            default:
                return null;
        }
    }
}
