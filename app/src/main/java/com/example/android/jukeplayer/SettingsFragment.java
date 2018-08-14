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
 * Created by VICTOR on 8/9/2018.
 */

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list, container, false);

        SettingsArrayAdapter settingsAdapter = new SettingsArrayAdapter(getContext(), MainActivity.mSettings);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(settingsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SettingsArrayList settingsArrayList = MainActivity.mSettings.get(position);
                String settingsName = settingsArrayList.getSettingsName();
                Intent intent = new Intent(getContext(), SettingsActivity.class);
                intent.putExtra(MainActivity.KEY_POSITION, position);
                intent.putExtra(MainActivity.KEY_ALBUMNAME, settingsName);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
