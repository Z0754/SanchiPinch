package com.example.sanpinch.ui.playercard;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PcDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PcDetailFragment extends Fragment {

    private static PlayerCard playerCard;
    private static int detail_type;
    private onPlayerCardSelectedListener mListener;

    public PcDetailFragment() {
        // Required empty public constructor
    }


    public static PcDetailFragment newInstance(PlayerCard pc, int type) {
        PcDetailFragment fragment = new PcDetailFragment();
        Bundle args = new Bundle();
        playerCard = pc;
        detail_type = type;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_pc_detail, container, false);

        TextView pcName = mView.findViewById(R.id.pcdetail_name_tv);
        TextView pcJob = mView.findViewById(R.id.pcdetail_job_tv);
        TextView pcAge = mView.findViewById(R.id.pcdetail_age_tv);
        TextView pcHP = mView.findViewById(R.id.pcdetail_hp_tv);
        TextView pcMP = mView.findViewById(R.id.pcdetail_mp_tv);
        TextView pcSan = mView.findViewById(R.id.pcdetail_san_tv);

        TextView pcChar = mView.findViewById(R.id.pcdetail_char_tv);
        TextView pcBio = mView.findViewById(R.id.pcdetail_biography_tv);

        pcName.setText(playerCard.name);
        pcJob.append(playerCard.job);
        pcAge.append("" + playerCard.age);

        pcHP.setText(mView.getContext().getResources().getString(
                R.string.hp_format, playerCard.HP, playerCard.HP_max));
        pcMP.setText(mView.getContext().getResources().getString(
                R.string.mp_format, playerCard.MP, playerCard.MP_max));
        pcSan.setText(mView.getContext().getResources().getString(
                R.string.san_format, playerCard.SAN, playerCard.SAN_MAX));
        pcChar.setText(mView.getContext().getResources().getString(
                R.string.character_format,
                playerCard.STR, playerCard.CON, playerCard.DEX, playerCard.APP, playerCard.POW, playerCard.IDEA,
                playerCard.INT, playerCard.SIZ, playerCard.EDU, playerCard.KNOW, playerCard.DB, playerCard.LUCK,
                playerCard.cthulhu_mythos));
        pcBio.setText(playerCard.biography);

        Button action_button = mView.findViewById(R.id.pcdetail_button);
        if (detail_type == R.integer.joinGameWithPlayerCard) {
            action_button.setText("Use this player card");
            action_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onPlayerCardSelected(playerCard, R.integer.joinGameWithPlayerCard);
                }
            });
        } else if (detail_type == R.integer.npcDetail) {
            action_button.setVisibility(View.GONE);
        } else {
            action_button.setText("Retire");
        }

        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onPlayerCardSelectedListener) {
            mListener = (onPlayerCardSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

}