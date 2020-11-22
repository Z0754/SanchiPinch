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

        SIZ = siz;
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


    public PlayerCard(int num_samplePC) {
        rand = new Random();
        switch (num_samplePC) {
            case 1:
                name = "Andrew";
                job = "Doctore";
                age = 43;
                biography = "Formless spawn create this phantom to fool players, does not know he already died." +
                        "Long time friend with player, interested in ancient egypt culture. Invite player to his house"+
                        "to celebrate his new discovery, but killed by the formless spawn before players arrive."+
                        " He is the person set up traps to stuck the formless spawn. ";

                STR = 12;
                CON = 14;
                POW = 9;
                DEX = 15;
                APP = 13;

                SIZ = 13;
                INT = 15;
                EDU = 16;

                cthulhu_mythos = 25;
                break;

            case 2:
                name = "Messenger";
                job = "Formless Spawn";
                age = 43;
                biography = "Formless spawn pretend to be the messenger of Thoth (Egypt god of  writing, magic, wisdom, and the moon)"+
                        "it claim that Andrew summon it to get access to wisdom, but the process of summoning is not perfect"+
                        ", which makes both itself, andrew and player stucked in this place. Because of the set up by Andrew, "+
                        "its power is very limited. It does not know how to break it and has to depend on player.";

                STR = 6;
                CON = 12;
                POW = 8;
                DEX = 8;
                APP = 16;

                SIZ = 13;
                INT = 15;
                EDU = 16;

                cthulhu_mythos = 0;
                break;

        }

        valueInit();

    }

}
