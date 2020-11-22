package com.example.sanpinch.ui.script;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sanpinch.R;
import com.example.sanpinch.data.AbilityCheck;
import com.example.sanpinch.data.Place;
import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.data.Script;
import com.example.sanpinch.data.StoryCard;
import com.example.sanpinch.ui.playercard.PlayerCard_rcViewAdapter;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScriptListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScriptListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ScriptListType = "isHostGame";

    // TODO: Rename and change types of parameters
    private boolean isHostGame;
    private String mParam2;

    private View view;
    private RecyclerView scripts_rcView;
    private LinearLayoutManager layoutManager;
    private List<Script> Scripts;
    private RecyclerView.Adapter script_adapter;
    private onScriptSelectedListener mListener;

    public ScriptListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param isHostGame if the list is for host game or not
     * @return A new instance of fragment ScriptListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScriptListFragment newInstance(Boolean isHostGame) {
        ScriptListFragment fragment = new ScriptListFragment();
        Bundle args = new Bundle();
        args.putBoolean(ScriptListType, isHostGame);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isHostGame = getArguments().getBoolean(ScriptListType);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_script_list, container, false);

        scripts_rcView = view.findViewById(R.id.ScriptList_RCview);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        scripts_rcView.setLayoutManager(layoutManager);

        // sample script
        Scripts = new ArrayList<Script>();
        Script sampleScript = new Script("Sample Script");
        sampleScript.NPC.add(new PlayerCard(1));
        sampleScript.NPC.add(new PlayerCard(2));
        sampleScript.map.add(new Place("Study", getResources().getString(R.string.studyDescription)));
        StoryCard intro = new StoryCard("Intro", R.integer.intro_storycard);
        intro.branches.add("Finding way out");
        intro.desc = "Players wake up in the study of Andrew, but could not leave the study. A spirit " +
                "in form of a human in ancient custom with halo is looking around with Andrew. " +
                "They are pleased to see player wake up, and Andrew told player that he try to communicate " +
                "with an ancient egypt god, Thoth, but failed. Now they are all stuck in the room, and need "
                + "players help to figure out what happened and get out.";
        intro.events.add(new AbilityCheck("If pass, player will realize Andrew and messenger are lying. ", "IDEA", 50));

        StoryCard stage1 = new StoryCard("Finding way out", R.integer.body_storycard);
        stage1.desc = "Player explore the room and try to find a way out. Andrew does not have any useful info since he is created by the formless spawn. Messenger does not know anything about the enchantment. ";
        stage1.events.add(new AbilityCheck("Activate when player saw the figure. If pass, player realize the figure is used by Andrew to create enchantment to keep him safe during research." +
                "If fail, Andrew will tell player that this is the object that may break the wall and ask player destory it, lead to ending Confusing Escape", "KNOW", 50));
        stage1.events.add(new AbilityCheck("If player realize the function of the figure, player could search the book shelf with this check. " +
                "If pass, player know what Andrew did and know that hold the figure go to shelf will force the spirit back, which lead to ENDING Formless Revenge. If fail, Andrew hurry player to destroy the figure first.",
                "IDEA", 75));

        stage1.branches.add("Confusing escape");
        stage1.branches.add("Formless revenge");
        StoryCard end1 = new StoryCard("Confusing escape", R.integer.end_storycard);
        end1.desc = "Players crush the lion figure on the ground, but lose conscious immediately. " +
                "Players wake up and find nobody else are in the room, only the broken figure remind player that the whole thing is real.";
        end1.events.add(new AbilityCheck("If pass, players get reward of 3 point of Cthulhu Mythos. If fail, get 0 point.", "LUCK", 45));

        StoryCard end2 = new StoryCard("Formless revenge", R.integer.end_storycard);
        end2.desc = "Players force the formless spawn back, but Andrew is nowhere to find. ";
        end2.events.add(new AbilityCheck("If pass, players get reward of 10 point of Cthulhu Mythos. If fail, get 5 point. ", "LUCK", 45));

        sampleScript.StoryCards.put("Intro", intro);
        sampleScript.StoryCards.put("Finding way out", stage1);
        sampleScript.StoryCards.put("Confusing escape", end1);
        sampleScript.StoryCards.put("Formless revenge", end2);

        Scripts.add(sampleScript);

        // specify an adapter (see also next example)
        script_adapter = new Script_rcViewAdapter(Scripts, mListener);
        scripts_rcView.setAdapter(script_adapter);


        Button newPc = view.findViewById(R.id.newScriptButton);

        if (isHostGame) {
            newPc.setVisibility(View.GONE);
        } else {
            newPc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onScriptSelected(new Script(), R.integer.newScript);
                }
            });
        }


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onScriptSelectedListener) {
            mListener = (onScriptSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
}