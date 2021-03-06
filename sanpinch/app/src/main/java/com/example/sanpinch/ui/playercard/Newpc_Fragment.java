package com.example.sanpinch.ui.playercard;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Newpc_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Newpc_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private onPlayerCardSelectedListener mListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mView;


    private EditText name_input;
    private EditText age_input;
    private EditText job_input;
    private EditText desc_input;

    public Newpc_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Newpc_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Newpc_Fragment newInstance(String param1, String param2) {
        Newpc_Fragment fragment = new Newpc_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_newpc, container, false);
        name_input = mView.findViewById(R.id.newpc_name);
        age_input = mView.findViewById(R.id.newpc_age);
        job_input = mView.findViewById(R.id.newpc_job);
        desc_input = mView.findViewById(R.id.newpc_desc);
        Button roll = mView.findViewById(R.id.newpcRoll_button);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerCard pc = newPcCreate();
                mListener.onPlayerCardSelected(pc, R.integer.newPcAdd);
            }
        });


        return mView;
    }

    private PlayerCard newPcCreate() {
        String name = name_input.getText().toString();
        String age = age_input.getText().toString();
        String job = job_input.getText().toString();
        String bio = desc_input.getText().toString();
        PlayerCard pc = new PlayerCard(name, job, Integer.parseInt(age),bio);
        return pc;
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