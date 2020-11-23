package com.example.sanpinch.data;

import android.widget.Spinner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sanpinch.R;

import java.util.ArrayList;

public class mViewModel  {
    public ArrayList<PlayerCard> Investigators;
    public ArrayList<Script> Scripts;
    public String curStoryCard = "Intro";
    public int curScript = 0;

    public mViewModel() {
        Investigators = new ArrayList<PlayerCard>();
        Investigators.add(new PlayerCard(true));
        Investigators.add(new PlayerCard("Rom", "Student", 35, "", 11, 12, 16, 9, 11, 11, 15, 17, 32));
        Investigators.get(1).biography = "It was following this incident that the split of Byrgenwerth" +
                " happened. One of Willem's students, Laurence, believed that the Old Blood discovered" +
                " in the labyrinth was the way forward for humanity; this clashed with Willem's " +
                "teachings that Insight and the discovery of the Eldritch Truth was the only way " +
                "to better humanity. Though Laurence ignored Willem and continued with his research, " +
                "eventually establishing the Healing Church, he, nevertheless, made an adage with his " +
                "old master: to 'fear the blood'.";


        Scripts = new ArrayList<Script>();

        Script sampleScript = new Script("Sample Script");
        sampleScript.NPC.add(new PlayerCard(1));
        sampleScript.NPC.add(new PlayerCard(2));
        sampleScript.map.add(new Place("Study", "Study of Andrew, a normal room measured 12 ft wide and 12 ft length. \n" +
                " Player once came to this room before, and noticed something is missing from the room." +
                " The player could not saw the window and door, which should be on the north and south side of" +
                " the room. The location of the window and the door are wall right now. East side of the room is a table" +
                " and west side of the room is book shelf. Pass observation check of shelf will let the player noticed that" +
                " some books on the shelf are same, and after asking Andrew those same books will be missing from the shelf." +
                " Important item obsidian lion figure with lead base on the table could be found by player after pass check of observation," +
                " cthulhu mythos or education.However, only if the player pass check of cthulhu mythos, the player could use it" +
                " against the formless spawn."));
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
    }


}