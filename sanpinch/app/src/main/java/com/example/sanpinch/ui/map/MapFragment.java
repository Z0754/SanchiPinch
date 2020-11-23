package com.example.sanpinch.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sanpinch.R;
import com.example.sanpinch.ScriptDetailActivity;
import com.example.sanpinch.data.Place;
import com.example.sanpinch.data.PlayerCard;

import java.util.ArrayList;

import static com.example.sanpinch.Home_Activity.appViewModel;

public class MapFragment extends Fragment {

    private View mView;
    private ArrayList<Place> map = appViewModel.Scripts.get(appViewModel.curScript).map;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_map, container, false);
        String[] place_names = new String[map.size()];
        for (int i = 0; i < place_names.length; i++) {
            place_names[i] = map.get(i).place_name;
        }
        Spinner place_select = mView.findViewById(R.id.place_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, place_names);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        place_select.setAdapter(adapter);
        place_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updatePlaceDetail(map.get(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        updatePlaceDetail(map.get(0));
        return mView;
    }

    private void updatePlaceDetail(Place place) {
        TextView desc = mView.findViewById(R.id.place_description);
        desc.setText(place.place_desc);
    }
}