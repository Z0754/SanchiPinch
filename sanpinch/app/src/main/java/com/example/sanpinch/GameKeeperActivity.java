package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.data.Script;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GameKeeperActivity extends AppCompatActivity implements onPlayerCardSelectedListener {

    public static Script script;
    public static PlayerCard investigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_keeper);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //   NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public void onPlayerCardSelected(PlayerCard pc, int interact_type) {

    }
    public void JumpChat(View view){
        Intent intent = new Intent(this, GamePlayerActivity.class);
        GamePlayerActivity.isHost = true;
        startActivity(intent);
    }
}