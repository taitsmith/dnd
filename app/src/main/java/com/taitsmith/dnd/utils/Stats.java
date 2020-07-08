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
    public static int[] diceRoll(int numberSides, int numberDie, int mod) {

        //result[] includes rolls, modifier,
        int[] result = new int[numberDie + 2];
        int total = 0;

        for (int i = 0; i < numberDie; i++) {
            result[i] = ThreadLocalRandom.current().nextInt(1, numberSides + 1);
            total += result[i];
            Log.d("ROLL " , Integer.toString(result[i]));
        }

        //set next to last index of result to mod
        result[result.length - 2] = mod;

        Log.d("ROLL: MOD ", Integer.toString(mod));

        total += mod;

        //last index of result is total
        result[result.length - 1] = total;

        return result;

    }
}
