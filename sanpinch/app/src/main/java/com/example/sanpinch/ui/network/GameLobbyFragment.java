package com.example.sanpinch.ui.network;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

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
    TextView desc;

    private final static int UPDATE_UI = 0;
    private final Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            final int what = msg.what;
            switch(what) {
                case UPDATE_UI: update(); break;
            }
        }
    };
    private onPlayerCardSelectedListener mListener;

    private void update() {
        desc.setVisibility(View.VISIBLE);
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPlayerCardSelected(new PlayerCard(), R.integer.jumpToRoom);
            }
        });
    }

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
        View mView= inflater.inflate(R.layout.fragment_game_lobby, container, false);

        Button refresh = mView.findViewById(R.id.gameLobbyRefresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHandler.sendEmptyMessage(UPDATE_UI);
            }
        });

        desc = mView.findViewById(R.id.roomBrief);
        desc.setVisibility(View.INVISIBLE);



        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onPlayerCardSelectedListener) {
            mListener = (onPlayerCardSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
}