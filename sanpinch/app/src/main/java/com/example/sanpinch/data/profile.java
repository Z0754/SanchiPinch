package com.example.sanpinch.data;

/**
 * the rule of profile building is not going to follow any rules, just for fun
 * could add customization templates for it
 */
public class profile {

    // decide by player
    public String name;
    public String job;
    public int age;

    // 3d6 * 5
    public int luck;
    // 3d6 * 5
    public int intuition;
    // 3d6 * 5
    public int knowledge;
    // initially 75
    public int san;
    // initially 99
    public int san_max;

    // use 3d6 to decide, min = 3 max = 18
    public int STR;
    public int CON;
    public int POW;
    public int DEX;
    public int APP;
    public int SIZ;
    public int INT;
    public int EDU;

    // initially 0
    public int cthulhu_mythos;

    public profile(){

    }

}
