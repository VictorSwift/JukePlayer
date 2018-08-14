package com.example.android.jukeplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VICTOR on 8/8/2018.
 */

public class AlbumArrayAdapter extends ArrayAdapter<AlbumArrayList> {
    /*The AlbumsArrayAdapter's internal storage is initialized for the context and the list.*/
    AlbumArrayAdapter(@NonNull Context context, @NonNull List<AlbumArrayList> objects) {

        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflate the view if the existing view is not being reused
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_albums_list_item, parent, false);
        }
        AlbumArrayList currentWord = getItem(position);
        if (currentWord != null) {
            ImageView albumImageView = (ImageView) listItemView.findViewById((R.id.album_image));
            albumImageView.setImageResource(currentWord.getImageId());

            TextView albumNameTextView = (TextView) listItemView.findViewById(R.id.album_name);
            albumNameTextView.setText(currentWord.getAlbumName());

            TextView albumNumOfTracksTextView = (TextView) listItemView.findViewById(R.id.album_no_of_tracks);
            albumNumOfTracksTextView.setText(String.valueOf(currentWord.getNumOfSongs() + " songs"));

            return listItemView;
        }
        return listItemView;
    }
}
