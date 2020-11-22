package com.example.sanpinch.data;

import com.example.sanpinch.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * story card contain story type, description and events that will include ability check
 * a script will contain several story cards
 */
public class StoryCard {

    /**
     * name of the story card, had to be unique, will also be the key in the hashmap in the script
     */
    public String title;
    /**
     * type of the story card
     * if the story card is intro, then id will be 0
     * if the story card is body, then id will be 1
     * if the story card is end, then id will be -1
     */
    public int type;
    // description of the story card
    public String desc;
    // events of the story card
    public ArrayList<AbilityCheck> events;

    /**
     * all possible branch story cards' name
     */
    public ArrayList<String> branches;

    public StoryCard() {
        branches = new ArrayList<>();
        events = new ArrayList<>();
    }

    public StoryCard(String givenTitle, int givenType) {
        this();
        title = givenTitle;
        type = givenType;

    }

//    private class Event {
//        public String desc;
//        public AbilityCheck abilityChecks;
//        public int state;
//        /**
//         * boolean to mark if this event determine the story branch
//         */
//        public boolean determine_storyBranch;
//        /**
//         * list of different branch ids will go to after this event
//         */
//        public ArrayList<Integer> branches;
//
//        public Event() {
//            branches = new ArrayList<>();
//            state = R.integer.uncheck;
//        }
//    }
}
