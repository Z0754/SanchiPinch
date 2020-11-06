package com.example.sanpinch.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;

import java.util.ArrayList;
import java.util.List;


public class Pclist_Fragment extends Fragment {

    private View view;
    private RecyclerView playerCards_rcView;
    private LinearLayoutManager layoutManager;
    private List<PlayerCard> playerCards;
    private RecyclerView.Adapter playerCards_adapter;

    public Pclist_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pclist, container, false);

        playerCards = new ArrayList<>();
        playerCards.add(new PlayerCard(true));
        playerCards.add(new PlayerCard("Rom","Student",35,"",11,12,16,9,11,11,15,17,32));

        playerCards_rcView = (RecyclerView) view.findViewById(R.id.pclist_rcview);


        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        playerCards_rcView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        playerCards_adapter = new PlayerCard_rcViewAdapter(playerCards);
        playerCards_rcView.setAdapter(playerCards_adapter);




        return view;
    }
}