package com.example.sanpinch.ui.npcs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sanpinch.R;
import com.example.sanpinch.ScriptDetailActivity;
import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.ui.playercard.PcDetailFragment;
import com.example.sanpinch.ui.playercard.Pclist_Fragment;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

import java.util.ArrayList;

import static com.example.sanpinch.Home_Activity.appViewModel;

public class NpcFragment extends Fragment {


    private ArrayList<PlayerCard> npcs = appViewModel.Scripts.get(appViewModel.curScript).NPC;
    private View mView;
    private int selected=0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_npcs, container, false);

        String[] npc_names = new String[npcs.size()];
        for (int i = 0; i < npc_names.length; i++) {
            npc_names[i] = npcs.get(i).name;
        }
        Spinner npc_select = mView.findViewById(R.id.npcSelectSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, npc_names);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        npc_select.setAdapter(adapter);
        npc_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateNpcDetail(npcs.get(i));
                selected = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        npc_select.setSelection(selected);


        return mView;
    }

    private void updateNpcDetail(PlayerCard playerCard) {

        TextView npcJob = mView.findViewById(R.id.npcdetail_job_tv);
        TextView npcAge = mView.findViewById(R.id.npcdetail_age_tv);
        TextView npcHP = mView.findViewById(R.id.npcdetail_hp_tv);
        TextView npcMP = mView.findViewById(R.id.npcdetail_mp_tv);
        TextView npcSan = mView.findViewById(R.id.npcdetail_san_tv);

        TextView npcChar = mView.findViewById(R.id.npcdetail_char_tv);
        TextView npcBio = mView.findViewById(R.id.npcdetail_biography_tv);


        npcJob.setText("Job: " + playerCard.job);
        npcAge.setText("Age: " + playerCard.age);

        npcHP.setText(mView.getContext().getResources().getString(
                R.string.hp_format, playerCard.HP, playerCard.HP_max));
        npcMP.setText(mView.getContext().getResources().getString(
                R.string.mp_format, playerCard.MP, playerCard.MP_max));
        npcSan.setText(mView.getContext().getResources().getString(
                R.string.san_format, playerCard.SAN, playerCard.SAN_MAX));
        npcChar.setText(mView.getContext().getResources().getString(
                R.string.character_format,
                playerCard.STR, playerCard.CON, playerCard.DEX, playerCard.APP, playerCard.POW, playerCard.IDEA,
                playerCard.INT, playerCard.SIZ, playerCard.EDU, playerCard.KNOW, playerCard.DB, playerCard.LUCK,
                playerCard.cthulhu_mythos));
        npcBio.setText(playerCard.biography);

    }


}