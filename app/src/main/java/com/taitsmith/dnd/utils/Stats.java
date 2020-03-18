package com.taitsmith.dnd.utils;

import java.util.Random;

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
}
