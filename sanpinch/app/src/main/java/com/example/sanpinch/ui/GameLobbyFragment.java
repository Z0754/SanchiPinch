package com.example.sanpinch.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameLobbyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameLobbyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static PlayerCard playerCard;
    private static int type;

    public GameLobbyFragment() {
        // Required empty public constructor
    }


    public static GameLobbyFragment newInstance(PlayerCard pc, int param) {
        GameLobbyFragment fragment = new GameLobbyFragment();
        playerCard = pc;
        type = param;
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_lobby, container, false);
    }
}