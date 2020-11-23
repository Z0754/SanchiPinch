package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sanpinch.data.mViewModel;

public class Home_Activity extends AppCompatActivity {

    public static mViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        if (appViewModel == null) {
            appViewModel = new mViewModel();
        }
    }

    public void goPlayerCardManagement(View view) {
        Intent intent = new Intent(this, Pcmng_activity.class);
        Pcmng_activity.pcmng_vm = appViewModel;
        startActivity(intent);
    }

    public void goStoryManagement(View view) {
        Intent intent = new Intent(this, ScriptmngActivity.class);
        ScriptmngActivity.scriptmng_vm = appViewModel;
        startActivity(intent);
    }

    public void goJoinGame(View view) {
        Intent intent = new Intent(this, JoinActivity.class);
        JoinActivity.join_vm = appViewModel;
        startActivity(intent);
    }

    public void goHostGame(View view) {
        Intent intent = new Intent(this, HostActivity.class);
        HostActivity.host_vm = appViewModel;
        startActivity(intent);
    }
}