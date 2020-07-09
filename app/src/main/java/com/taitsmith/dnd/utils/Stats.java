package com.taitsmith.dnd.utils;

import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

public class Stats {

    //skill modifiers
    public static int getMod(int statScore) {
        double d = statScore - 10;
        d /= 2;
        return (int) Math.floor(d);
    }

    //returns an int[] of size (number of dice + 2) so we can show the user each individual
    //die roll, plus their modifier (if it exists), plus the total
    //eg possible results for damage roll of 2d6 + 5 == [2,4,5,11] for rolls, mod, total
    public static String[] diceRoll(int numberSides, int numberDie, int mod) {

        //result[] includes rolls, modifier,
        String[] returnString = new String[numberDie + 2];
        int total = 0;
        int j;

        for (int i = 0; i < numberDie; i++) {
            j = ThreadLocalRandom.current().nextInt(1, numberSides + 1);
            total += j;
            returnString[i] = Integer.toString(j);
        }

        //set next to last index of result to mod
        returnString[returnString.length - 2] = Integer.toString(mod);

        Log.d("ROLL: MOD ", Integer.toString(mod));

        total += mod;

        //last index of result is total
        returnString[returnString.length - 1] = Integer.toString(total);

        return returnString;

    }
}
