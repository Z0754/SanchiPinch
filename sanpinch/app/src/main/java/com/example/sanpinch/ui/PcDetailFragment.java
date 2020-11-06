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
 * Use the {@link PcDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PcDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "player_card";
    private static final String ARG_PARAM2 = "detail_type";

    // TODO: Rename and change types of parameters
    private PlayerCard player_card;
    private int detail_type;

    public PcDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PcDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PcDetailFragment newInstance(PlayerCard pc, int type) {
        PcDetailFragment fragment = new PcDetailFragment();
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
        return inflater.inflate(R.layout.fragment_pc_detail, container, false);
    }
}