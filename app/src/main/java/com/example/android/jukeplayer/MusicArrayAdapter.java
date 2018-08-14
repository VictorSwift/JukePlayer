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

public class MusicArrayAdapter extends ArrayAdapter<MusicArrayList> {

        /*Here, we initialize the ArrayAdapter's internal storage for the context and the list.
         the second argument is used when the ArrayAdapter is populating a single TextView.
         Because this is a custom adapter for one ImageView and two TextView, the adapter is not
         going to use this second argument, so it can be any value. Here, we used 0.*/

    MusicArrayAdapter(@NonNull Context context, @NonNull List<MusicArrayList> objects) {

        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // //Inflate the view if the existing view is not being reused
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_music_list_item, parent, false);
        }
        MusicArrayList currentWord = getItem(position);
        ImageView musicImageView = (ImageView) listItemView.findViewById((R.id.music_image));
        musicImageView.setImageResource(currentWord.getImageId());

        TextView musicNameTextView = (TextView) listItemView.findViewById(R.id.music_name);
        musicNameTextView.setText(currentWord.getMusicName());

        TextView musicArtistTextView = (TextView) listItemView.findViewById(R.id.music_artist);
        musicArtistTextView.setText(currentWord.getArtistName());

        return listItemView;

    }
}
