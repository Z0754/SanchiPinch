package com.example.sanpinch.ui.script;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanpinch.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewScriptFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewScriptFragment extends Fragment {



    public NewScriptFragment() {
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
        return inflater.inflate(R.layout.fragment_new_script, container, false);
    }
}