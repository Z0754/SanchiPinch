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

    public void goPlayerCardManagement(View view){
        Intent intent = new Intent(this, Pcmng_activity.class);

        startActivity(intent);
    }

    public void goStoryManagement(View view){
        Intent intent = new Intent(this, StorymngActivity.class);

        startActivity(intent);
    }

    public void goJoinGame(View view){
        Intent intent = new Intent(this, JoinActivity.class);

        startActivity(intent);
    }

    public void goHostGame(View view){
        Intent intent = new Intent(this, HostActivity.class);

        startActivity(intent);
    }
}