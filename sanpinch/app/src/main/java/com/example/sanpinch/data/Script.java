package com.example.sanpinch.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Script will include info of NPCs, map and several story cards
 */
public class Script {
    public String name;

    public ArrayList<PlayerCard> NPC;
    public HashMap<String, StoryCard> StoryCards;
    public ArrayList<Place> map;
    public int TimeEstimate;
    public String cur_story = "Intro";

    public Script(String givenName){
        name = givenName;
        NPC = new ArrayList<>();
        map = new ArrayList<>();
        StoryCards = new HashMap<>();

        TimeEstimate = 1;
    }

    public Script(){
        this("New Script");
    }



}
