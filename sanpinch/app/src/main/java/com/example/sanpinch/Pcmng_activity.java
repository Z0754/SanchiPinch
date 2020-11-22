package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.ui.playercard.Newpc_Fragment;
import com.example.sanpinch.ui.playercard.PcDetailFragment;
import com.example.sanpinch.ui.playercard.Pclist_Fragment;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

public class Pcmng_activity extends AppCompatActivity implements onPlayerCardSelectedListener {

    private FragmentManager mFragmentManager;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcmng);

        this.mFragmentManager = getSupportFragmentManager();
        ft = mFragmentManager.beginTransaction();
        Fragment list = new Pclist_Fragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isJoinGame", false);
        list.setArguments(bundle);
        ft.add(R.id.pcmng_fragmentcontainer, list);
        ft.commit();
    }

    @Override
    public void onPlayerCardSelected(PlayerCard pc, int interact_type) {
        if(interact_type == R.integer.newPlayerCard){
            Fragment newPcFragment = new Newpc_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("Name", "new name");
            newPcFragment.setArguments(bundle);
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.pcmng_fragmentcontainer, newPcFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(interact_type == R.integer.displayPlayerCard){
            Fragment newPcFragment = PcDetailFragment.newInstance(pc, interact_type);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isJoinGame", false);
            newPcFragment.setArguments(bundle);
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.pcmng_fragmentcontainer, newPcFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}