package me.nrules.utils.math;

import java.util.*;
import java.util.concurrent.*;

public final class RandomUtils
{
    public static Random getRandom() {
        return new Random();
    }
    
    public static int nextInt(final int lllllllllllllIlIllIIIlIllIlllllI, final int lllllllllllllIlIllIIIlIllIllllIl) {
        if (lllllllllllllIlIllIIIlIllIlllllI == lllllllllllllIlIllIIIlIllIllllIl || lllllllllllllIlIllIIIlIllIllllIl - lllllllllllllIlIllIIIlIllIlllllI <= 0) {
            return lllllllllllllIlIllIIIlIllIlllllI;
        }
        return lllllllllllllIlIllIIIlIllIlllllI + getRandom().nextInt(lllllllllllllIlIllIIIlIllIllllIl - lllllllllllllIlIllIIIlIllIlllllI);
    }
    
    public static double nextDouble(final double lllllllllllllIlIllIIIlIllIlllIlI, final double lllllllllllllIlIllIIIlIllIllIlll) {
        if (lllllllllllllIlIllIIIlIllIlllIlI == lllllllllllllIlIllIIIlIllIllIlll || lllllllllllllIlIllIIIlIllIllIlll - lllllllllllllIlIllIIIlIllIlllIlI <= 0.0) {
            return lllllllllllllIlIllIIIlIllIlllIlI;
        }
        return lllllllllllllIlIllIIIlIllIlllIlI + (lllllllllllllIlIllIIIlIllIllIlll - lllllllllllllIlIllIIIlIllIlllIlI) * Math.random();
    }
    
    public static double getRandomDouble(final double lllllllllllllIlIllIIIlIllIlIIIII, final double lllllllllllllIlIllIIIlIllIIlllll) {
        return ThreadLocalRandom.current().nextDouble(lllllllllllllIlIllIIIlIllIlIIIII, lllllllllllllIlIllIIIlIllIIlllll + 1.0);
    }
    
    public static float nextFloat(final float lllllllllllllIlIllIIIlIllIllIIlI, final float lllllllllllllIlIllIIIlIllIllIIIl) {
        if (lllllllllllllIlIllIIIlIllIllIIlI == lllllllllllllIlIllIIIlIllIllIIIl || lllllllllllllIlIllIIIlIllIllIIIl - lllllllllllllIlIllIIIlIllIllIIlI <= 0.0f) {
            return lllllllllllllIlIllIIIlIllIllIIlI;
        }
        return (float)(lllllllllllllIlIllIIIlIllIllIIlI + (lllllllllllllIlIllIIIlIllIllIIIl - lllllllllllllIlIllIIIlIllIllIIlI) * Math.random());
    }
    
    public static String randomString(final int lllllllllllllIlIllIIIlIllIlIllII) {
        return random(lllllllllllllIlIllIIIlIllIlIllII, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }
    
    public static String random(final int lllllllllllllIlIllIIIlIllIIlIllI, final char[] lllllllllllllIlIllIIIlIllIIllIIl) {
        final StringBuilder lllllllllllllIlIllIIIlIllIIllIII = new StringBuilder();
        for (int lllllllllllllIlIllIIIlIllIIlIlll = 0; lllllllllllllIlIllIIIlIllIIlIlll < lllllllllllllIlIllIIIlIllIIlIllI; ++lllllllllllllIlIllIIIlIllIIlIlll) {
            lllllllllllllIlIllIIIlIllIIllIII.append(lllllllllllllIlIllIIIlIllIIllIIl[getRandom().nextInt(lllllllllllllIlIllIIIlIllIIllIIl.length)]);
        }
        return String.valueOf(lllllllllllllIlIllIIIlIllIIllIII);
    }
    
    public static String random(final int lllllllllllllIlIllIIIlIllIlIIllI, final String lllllllllllllIlIllIIIlIllIlIIlIl) {
        return random(lllllllllllllIlIllIIIlIllIlIIllI, lllllllllllllIlIllIIIlIllIlIIlIl.toCharArray());
    }
    
    public static String randomNumber(final int lllllllllllllIlIllIIIlIllIlIllll) {
        return random(lllllllllllllIlIllIIIlIllIlIllll, "123456789");
    }
}
