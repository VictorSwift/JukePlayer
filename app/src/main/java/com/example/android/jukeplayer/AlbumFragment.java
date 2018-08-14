package com.example.android.jukeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class AlbumFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list, container, false);

        AlbumArrayAdapter albumAdapter = new AlbumArrayAdapter(getContext(), MainActivity.mAlbum);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(albumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlbumArrayList albumArrayList = MainActivity.mAlbum.get(position);
                String albumName = albumArrayList.getAlbumName();
                Intent intent = new Intent(getContext(), AlbumTrackListActivity.class);
                intent.putExtra(MainActivity.KEY_POSITION, position);
                intent.putExtra(MainActivity.KEY_ALBUMNAME, albumName);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
