package com.taitsmith.dnd.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStats {
    public static int[] randomStats() {
        int[] stats = new int[6];

        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            stats[i] = r.nextInt(16) + 3;
            System.out.println(stats[i]);
        }

        return stats;
    }
}
