package com.id.tick.schedule;

import java.util.Random;

/**
 * Created on 03.08.2015.
 */
public class JobKeyProvider {
    private static Random random = new Random();

    public static String nextKey() {
        return String.valueOf(random.nextLong());
    }
}
