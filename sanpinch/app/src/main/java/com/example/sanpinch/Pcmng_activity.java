package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class Pcmng_activity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcmng);

        this.mFragmentManager = getSupportFragmentManager();
    }
}