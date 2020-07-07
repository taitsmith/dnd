package com.taitsmith.dnd.utils;


import android.content.Context;

import com.taitsmith.dnd.objects.Player;

import io.realm.Realm;

public class CreatePlayer {

    //TODO remove this, it's just random character for testing
    public static void randomPlayer(Context context) {
        Realm.init(context);
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        Player player = realm.createObject(Player.class);

        player.setLevel(10);
        player.setName("Greg");
        player.setRace("Elf");
        player.setClazz("Cleric");
        player.setBackground("Criminal");
        player.setAlignment("Chaotic Evil");

        player.setIntel(15);
        player.setDex(20);
        player.setStr(3);
        player.setCon(18);
        player.setWis(13);
        player.setCha(10);

        player.setXp(5000);

        player.setHpMax(48);
        player.setHpCurrent(45);
        player.setHpTemp(0);

        player.setHitDice(6);

        realm.commitTransaction();
    }
}
