package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
    }

    public void goProfileManagement(View view){
        Intent intent = new Intent(this, Profilelist_Activity.class);

        startActivity(intent);
    }
}