package com.example.sanpinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sanpinch.data.AbilityCheck;
import com.example.sanpinch.data.Place;
import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.data.Script;
import com.example.sanpinch.data.StoryCard;
import com.example.sanpinch.data.mViewModel;
import com.example.sanpinch.ui.playercard.PcDetailFragment;
import com.example.sanpinch.ui.playercard.Pclist_Fragment;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;
import com.example.sanpinch.ui.script.NewScriptFragment;
import com.example.sanpinch.ui.script.ScriptListFragment;
import com.example.sanpinch.ui.script.onScriptSelectedListener;

import java.util.ArrayList;

public class ScriptmngActivity extends AppCompatActivity implements onScriptSelectedListener {
    public static mViewModel scriptmng_vm;
    private FragmentManager mFragmentManager;
    private boolean added = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scriptmng);

        this.mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Fragment list = ScriptListFragment.newInstance(false);
         ((ScriptListFragment) list).Scripts = scriptmng_vm.Scripts;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isHostGame", false);
        list.setArguments(bundle);
        ft.add(R.id.ScriptMngFragementContainer, list);
        ft.commit();
    }

    @Override
    public void onScriptSelected(Script selectedScript, int interact_type) {
        if(interact_type == R.integer.newScript){

            Fragment newScriptFragment = new NewScriptFragment();

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.ScriptMngFragementContainer, newScriptFragment);

            transaction.commit();

        }else if(interact_type == R.integer.displayScriptDetail){
            Intent intent = new Intent(this, ScriptDetailActivity.class);
            ScriptDetailActivity.script = selectedScript;
            startActivity(intent);
        }else if(interact_type == R.integer.displayScriptList){
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            Fragment list = ScriptListFragment.newInstance(false);
            ((ScriptListFragment) list).Scripts = scriptmng_vm.Scripts;
            Bundle bundle = new Bundle();
            bundle.putBoolean("isHostGame", false);
            list.setArguments(bundle);
            ft.replace(R.id.ScriptMngFragementContainer, list);
            ft.commit();
        }
    }


    public void addScript(View view){

        if(added == true){
            Fragment newScriptFragment = new NewScriptFragment();

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.pcmng_fragmentcontainer, newScriptFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        added = true;

        Script sampleScript = new Script("test script");

        sampleScript.NPC.add(new PlayerCard("Sam","",30,"NPC"));
        sampleScript.NPC.add(new PlayerCard("Bob","",25,"another NPC"));

        sampleScript.map.add(new Place("living room", "my living room"));
        sampleScript.map.add(new Place("yard", "lots of grass"));



        StoryCard intro = new StoryCard("Intro", R.integer.intro_storycard);
        intro.branches.add("In the yard");
        intro.desc = "blablabla";
        intro.events.add(new AbilityCheck("check1", "LUCK", 50));

        StoryCard stage1 = new StoryCard("Finding way out", R.integer.body_storycard);
        stage1.desc = "blablabla";
        stage1.events.add(new AbilityCheck("another check","KNOW", 15));
        stage1.events.add(new AbilityCheck("check again","IDEA", 20));



        sampleScript.StoryCards.put("Intro", intro);
        sampleScript.StoryCards.put("Finding way out", stage1);


        scriptmng_vm.Scripts.add(sampleScript);

        onScriptSelected(new Script(), R.integer.displayScriptList);
    }



}