package me.nrules.utils.player;

import java.util.*;

public class RandomUtils
{
    public static String random(final int llllllllllllllllIlllIIIIIIIllIlI, final char[] llllllllllllllllIlllIIIIIIIlIlIl) {
        final StringBuilder llllllllllllllllIlllIIIIIIIllIII = new StringBuilder();
        for (int llllllllllllllllIlllIIIIIIIlIlll = 0; llllllllllllllllIlllIIIIIIIlIlll < llllllllllllllllIlllIIIIIIIllIlI; ++llllllllllllllllIlllIIIIIIIlIlll) {
            llllllllllllllllIlllIIIIIIIllIII.append(llllllllllllllllIlllIIIIIIIlIlIl[getRandom().nextInt(llllllllllllllllIlllIIIIIIIlIlIl.length)]);
        }
        return String.valueOf(llllllllllllllllIlllIIIIIIIllIII);
    }
    
    public static String randomString(final int llllllllllllllllIlllIIIIIIlIIllI) {
        return random(llllllllllllllllIlllIIIIIIlIIllI, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }
    
    public static Random getRandom() {
        return new Random();
    }
    
    public static double nextDouble(final double llllllllllllllllIlllIIIIIIllIIlI, final double llllllllllllllllIlllIIIIIIllIIll) {
        if (llllllllllllllllIlllIIIIIIllIIlI == llllllllllllllllIlllIIIIIIllIIll || llllllllllllllllIlllIIIIIIllIIll - llllllllllllllllIlllIIIIIIllIIlI <= 0.0) {
            return llllllllllllllllIlllIIIIIIllIIlI;
        }
        return llllllllllllllllIlllIIIIIIllIIlI + (llllllllllllllllIlllIIIIIIllIIll - llllllllllllllllIlllIIIIIIllIIlI) * Math.random();
    }
    
    public static int nextInt(final int llllllllllllllllIlllIIIIIIlllIlI, final int llllllllllllllllIlllIIIIIIllIlll) {
        if (llllllllllllllllIlllIIIIIIlllIlI == llllllllllllllllIlllIIIIIIllIlll || llllllllllllllllIlllIIIIIIllIlll - llllllllllllllllIlllIIIIIIlllIlI <= 0) {
            return llllllllllllllllIlllIIIIIIlllIlI;
        }
        return llllllllllllllllIlllIIIIIIlllIlI + getRandom().nextInt(llllllllllllllllIlllIIIIIIllIlll - llllllllllllllllIlllIIIIIIlllIlI);
    }
    
    public static float nextFloat(final float llllllllllllllllIlllIIIIIIlIllII, final float llllllllllllllllIlllIIIIIIlIlIll) {
        if (llllllllllllllllIlllIIIIIIlIllII == llllllllllllllllIlllIIIIIIlIlIll || llllllllllllllllIlllIIIIIIlIlIll - llllllllllllllllIlllIIIIIIlIllII <= 0.0f) {
            return llllllllllllllllIlllIIIIIIlIllII;
        }
        return (float)(llllllllllllllllIlllIIIIIIlIllII + (llllllllllllllllIlllIIIIIIlIlIll - llllllllllllllllIlllIIIIIIlIllII) * Math.random());
    }
    
    public static String randomNumber(final int llllllllllllllllIlllIIIIIIlIlIII) {
        return random(llllllllllllllllIlllIIIIIIlIlIII, "123456789");
    }
    
    public static String random(final int llllllllllllllllIlllIIIIIIlIIIlI, final String llllllllllllllllIlllIIIIIIlIIIIl) {
        return random(llllllllllllllllIlllIIIIIIlIIIlI, llllllllllllllllIlllIIIIIIlIIIIl.toCharArray());
    }
}
