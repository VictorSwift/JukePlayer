package com.example.android.jukeplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VICTOR on 8/9/2018.
 */

public class SettingsArrayAdapter extends ArrayAdapter<SettingsArrayList> {
    /*Here, we initialize the ArrayAdapter's internal storage for the context and the list.
         the second argument is used when the ArrayAdapter is populating a single TextView.
         Because this is a custom adapter for one ImageView and two TextView, the adapter is not
         going to use this second argument, so it can be any value. Here, we used 0.*/
    SettingsArrayAdapter(@NonNull Context context, @NonNull List<SettingsArrayList> objects) {

        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_settings, parent, false);
        }
        SettingsArrayList currentWord = getItem(position);
        if (currentWord != null) {

            TextView mTextView = (TextView) listItemView.findViewById(R.id.settings_name);
            mTextView.setText(currentWord.getSettingsName());

            return listItemView;
        }
        return listItemView;
    }
}
