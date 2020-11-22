package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.sanpinch.data.Script;
import com.example.sanpinch.ui.playercard.Pclist_Fragment;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;
import com.example.sanpinch.ui.script.ScriptListFragment;
import com.example.sanpinch.ui.script.onScriptSelectedListener;

public class ScriptmngActivity extends AppCompatActivity implements onScriptSelectedListener {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scriptmng);

        this.mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Fragment list = ScriptListFragment.newInstance(false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isHostGame", false);
        list.setArguments(bundle);
        ft.add(R.id.ScriptMngFragementContainer, list);
        ft.commit();
    }

    @Override
    public void onScriptSelected(Script selectedScript, int interact_type) {
        if(interact_type == R.integer.newScript){

        }else if(interact_type == R.integer.displayScriptDetail){
            Intent intent = new Intent(this, ScriptDetailActivity.class);
            ScriptDetailActivity.script = selectedScript;
            startActivity(intent);
        }
    }
}