package com.taitsmith.dnd.utils;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Stats {
    public static int[] randomStats() {
        int[] stats = new int[6];

        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            stats[i] = r.nextInt(16) + 3;
            System.out.println(stats[i]);
        }

        return stats;
    }

    public static int getMod(int statScore) {
        double d = statScore - 10;
        d /= 2;
        return (int) Math.floor(d);
    }

    //does this make sense to be in a stats class? does stats need to be
    //renamed? skill checks, etc
    public static int diceRoll(int numberSides, int numberDie, int mod) {
        int total = 0;

        for (int i = 0; i < numberDie; i++) {
            total += ThreadLocalRandom.current().nextInt(1, numberSides + 1);
        }
        Log.d("RANDOM " , Integer.toString(total));
        Log.d("MOD ", Integer.toString(mod));
        return total + mod;

    }
}
