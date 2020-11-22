package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.ui.GameLobbyFragment;
import com.example.sanpinch.ui.playercard.PcDetailFragment;
import com.example.sanpinch.ui.playercard.Pclist_Fragment;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

public class JoinActivity extends AppCompatActivity implements onPlayerCardSelectedListener {
    private FragmentManager mFragmentManager;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        this.mFragmentManager = getSupportFragmentManager();
        ft = mFragmentManager.beginTransaction();
        Fragment list = new Pclist_Fragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isJoinGame", true);
        list.setArguments(bundle);
        ft.add(R.id.joinGame_fragmentcontainer, list);
        ft.commit();
    }

    @Override
    public void onPlayerCardSelected(PlayerCard pc, int interact_type) {
        if(interact_type == R.integer.displayPlayerCard){
            Fragment newPcFragment = PcDetailFragment.newInstance(pc, interact_type);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isJoinGame", true);
            newPcFragment.setArguments(bundle);
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.joinGame_fragmentcontainer, newPcFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(interact_type == R.integer.joinGameWithPlayerCard){
            Fragment gamelobbyFragment = GameLobbyFragment.newInstance(pc, interact_type);
            Bundle bundle = new Bundle();

            gamelobbyFragment.setArguments(bundle);
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.joinGame_fragmentcontainer, gamelobbyFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }



    }
}