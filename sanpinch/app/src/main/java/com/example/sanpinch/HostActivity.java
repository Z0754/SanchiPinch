package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sanpinch.data.Script;
import com.example.sanpinch.data.mViewModel;
import com.example.sanpinch.ui.script.ScriptListFragment;
import com.example.sanpinch.ui.script.onScriptSelectedListener;


public class HostActivity extends AppCompatActivity implements onScriptSelectedListener {

    private FragmentManager mFragmentManager;
    public static mViewModel host_vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        this.mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Fragment list = ScriptListFragment.newInstance(true);
        ((ScriptListFragment) list).Scripts = host_vm.Scripts;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isHostGame", true);
        list.setArguments(bundle);
        ft.add(R.id.HostGameFragementContainer, list);
        ft.commit();
    }


    @Override
    public void onScriptSelected(Script selectedScript, int interact_type) {
        if(interact_type == R.integer.displayScriptDetail){
            Intent intent = new Intent(this, GameKeeperActivity.class);
            GameKeeperActivity.script = selectedScript;
            startActivity(intent);
        }
    }


}