package com.example.sanpinch.data;

import android.widget.ImageView;
import android.widget.Switch;

import java.util.Random;

/**
 * the rule of profile building is not going to follow any rules, just for fun
 * could add customization templates for it
 */
public class PlayerCard {

    private final Random rand;
    // decide by player
    public String name;
    public String job;
    public int age;
    public String biography;

    public int HP;
    public int HP_max;
    public int MP;
    public int MP_max;

    // POW * 5
    public int LUCK;
    // INT * 5
    public int IDEA;
    // EDU * 5
    public int KNOW;

    public int DB;
    // initially
    public int SAN;
    // initially
    public int SAN_MAX;

    // 3d6 7 pick 5
    public int STR;
    public int CON;
    public int POW;
    public int DEX;
    public int APP;
    // 2d6+6 3 pick 2
    public int SIZ;
    public int INT;
    // 3d6+3 2 pick 1
    public int EDU;

    // initially 0
    public int cthulhu_mythos;

    public PlayerCard() {
        rand = new Random();

    }

    public PlayerCard(String givname, String givjob, int givage, String bio, int str, int con, int pow, int dex, int app, int siz, int inte, int edu, int myth) {
        rand = new Random();

        name = givname;
        job = givjob;
        age = givage;
        biography = bio;

        STR = str;
        CON = con;
        POW = pow;
        DEX = dex;
        APP = app;

        SIZ =siz;
        INT = inte;
        EDU = edu;

        cthulhu_mythos = myth;

        valueInit();

    }

    public PlayerCard(Boolean sample) {
        rand = new Random();

        name = "Ludwig";
        job = "Hunter";
        age = 35;
        biography = "Healing Church";

        STR = 16;
        CON = 16;
        POW = 18;
        DEX = 13;
        APP = 12;

        SIZ = 14;
        INT = 10;
        EDU = 9;

        cthulhu_mythos = 0;

        valueInit();
        HP -= 2;
        MP -= 3;

    }

    public void valueInit() {
        IDEA = INT * 5;
        LUCK = POW * 5;
        KNOW = INT * 5;

        if (STR + SIZ < 17) {
            DB = 0 - 1 - rand.nextInt(4);
        } else if (STR + SIZ < 25) {
            DB = 0;
        } else if (STR + SIZ < 33) {
            DB = 1 + rand.nextInt(4);
        } else {
            DB = 1 + rand.nextInt(6);
        }

        SAN_MAX = 99 - cthulhu_mythos;
        SAN = Math.min(POW * 5, SAN_MAX);

        HP_max = (CON + SIZ) / 2 + (CON + SIZ) % 2;
        HP = HP_max;
        MP_max = POW;
        MP = MP_max;
    }

}
