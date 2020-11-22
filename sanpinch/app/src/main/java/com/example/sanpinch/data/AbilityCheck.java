package com.example.sanpinch.data;

import com.example.sanpinch.R;

/**
 * ability check object will be stored in events and used by game
 */
public class AbilityCheck {
    /**
     * description of the check
     */
    public String desc;
    /**
     * the ability name of the player or NPC that will be checked
     */
    public String ability;
    /**
     * difficulty of the check, value between 0 - 99
     */
    public int difficulty;
    /**
     * correction determined by game keeper, could be positive or negative depends on the discussion
     */
    public int correction;
    /**
     * current state of this check, initially uncheck, could be pass or fail
     */
    public int state;
    /**
     * result of the dice roll
     */
    public int result;

    public AbilityCheck(){
        correction = 0;
        state = R.integer.uncheck;
        result = -1;
    }

    public AbilityCheck(String givenDesc, String givenAbi, int givenDiff){
        this();
        desc = givenDesc;
        ability = givenAbi;
        difficulty = givenDiff;
    }
}
