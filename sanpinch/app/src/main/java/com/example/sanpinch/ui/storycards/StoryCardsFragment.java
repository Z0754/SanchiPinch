package com.example.sanpinch.ui.storycards;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanpinch.R;
import com.example.sanpinch.ScriptDetailActivity;
import com.example.sanpinch.data.AbilityCheck;
import com.example.sanpinch.data.StoryCard;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class StoryCardsFragment extends Fragment {


    private View mView;
    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter events_adapter;
    private StoryCard cur_story = ScriptDetailActivity.script.StoryCards.get(ScriptDetailActivity.script.cur_story);
    private ArrayList<AbilityCheck> events = cur_story.events;

    private TextView title;
    private TextView desc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_storycards, container, false);

        updateDisplay();

        final String[] storys = new String[ScriptDetailActivity.script.StoryCards.size()];
        int i = 0;
        for (String k : ScriptDetailActivity.script.StoryCards.keySet()) {
            storys[i] = k;
            i++;
        }

        Spinner storycard_select = mView.findViewById(R.id.storyCard_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, storys);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        storycard_select.setAdapter(adapter);
        storycard_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ScriptDetailActivity.script.cur_story= storys[i];
                updateDisplay();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return mView;
    }

    private void updateDisplay() {
        cur_story = ScriptDetailActivity.script.StoryCards.get(ScriptDetailActivity.script.cur_story);
        title = mView.findViewById(R.id.StoryCardName);
        title.setText(cur_story.title);

        desc = mView.findViewById(R.id.StoryCardDescription);
        desc.setText(cur_story.desc);

        RecyclerView events_rc = mView.findViewById(R.id.StoryCardEvents_rcview);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        events_rc.setLayoutManager(layoutManager);

        events = cur_story.events;
        events_adapter = new Event_rcViewAdapter(events);
        events_rc.setAdapter(events_adapter);
    }
}