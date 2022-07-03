package me.nrules.utils.render;

import net.minecraft.client.*;

public class AnimUtils
{
    public static /* synthetic */ float speedTarget;
    private static /* synthetic */ float defaultSpeed;
    
    public static float animation(final float lllllllllllllIllllIlIIIlIIIIlIll, final float lllllllllllllIllllIlIIIlIIIIlIIl, final float lllllllllllllIllllIlIIIlIIIIIlll) {
        return animation(lllllllllllllIllllIlIIIlIIIIlIll, lllllllllllllIllllIlIIIlIIIIlIIl, AnimUtils.speedTarget, lllllllllllllIllllIlIIIlIIIIIlll);
    }
    
    public static float moveUD(final float lllllllllllllIllllIlIIIlIIlIIlll, final float lllllllllllllIllllIlIIIlIIlIIlIl, final float lllllllllllllIllllIlIIIlIIIllIIl, final float lllllllllllllIllllIlIIIlIIlIIIIl) {
        float lllllllllllllIllllIlIIIlIIIlllll = (lllllllllllllIllllIlIIIlIIlIIlIl - lllllllllllllIllllIlIIIlIIlIIlll) * lllllllllllllIllllIlIIIlIIIllIIl;
        if (lllllllllllllIllllIlIIIlIIIlllll > 0.0f) {
            lllllllllllllIllllIlIIIlIIIlllll = Math.max(lllllllllllllIllllIlIIIlIIlIIIIl, lllllllllllllIllllIlIIIlIIIlllll);
            lllllllllllllIllllIlIIIlIIIlllll = Math.min(lllllllllllllIllllIlIIIlIIlIIlIl - lllllllllllllIllllIlIIIlIIlIIlll, lllllllllllllIllllIlIIIlIIIlllll);
        }
        else if (lllllllllllllIllllIlIIIlIIIlllll < 0.0f) {
            lllllllllllllIllllIlIIIlIIIlllll = Math.min(-lllllllllllllIllllIlIIIlIIlIIIIl, lllllllllllllIllllIlIIIlIIIlllll);
            lllllllllllllIllllIlIIIlIIIlllll = Math.max(lllllllllllllIllllIlIIIlIIlIIlIl - lllllllllllllIllllIlIIIlIIlIIlll, lllllllllllllIllllIlIIIlIIIlllll);
        }
        return lllllllllllllIllllIlIIIlIIlIIlll + lllllllllllllIllllIlIIIlIIIlllll;
    }
    
    public static double animate(final double lllllllllllllIllllIlIIIIIllllIll, double lllllllllllllIllllIlIIIIlIIIIIIl, double lllllllllllllIllllIlIIIIIllllIIl) {
        final boolean lllllllllllllIllllIlIIIIIllllllI;
        final boolean lllllllllllllIllllIlIIIIIlllllll = lllllllllllllIllllIlIIIIIllllllI = (lllllllllllllIllllIlIIIIIllllIll > lllllllllllllIllllIlIIIIlIIIIIIl);
        if (lllllllllllllIllllIlIIIIIllllIIl < 0.0) {
            lllllllllllllIllllIlIIIIIllllIIl = 0.0;
        }
        else if (lllllllllllllIllllIlIIIIIllllIIl > 1.0) {
            lllllllllllllIllllIlIIIIIllllIIl = 1.0;
        }
        final double lllllllllllllIllllIlIIIIIlllllIl = Math.max(lllllllllllllIllllIlIIIIIllllIll, lllllllllllllIllllIlIIIIlIIIIIIl) - Math.min(lllllllllllllIllllIlIIIIIllllIll, lllllllllllllIllllIlIIIIlIIIIIIl);
        double lllllllllllllIllllIlIIIIIlllllII = lllllllllllllIllllIlIIIIIlllllIl * lllllllllllllIllllIlIIIIIllllIIl;
        if (lllllllllllllIllllIlIIIIIlllllII < 0.1) {
            lllllllllllllIllllIlIIIIIlllllII = 0.1;
        }
        lllllllllllllIllllIlIIIIlIIIIIIl = (lllllllllllllIllllIlIIIIIlllllll ? (lllllllllllllIllllIlIIIIlIIIIIIl += lllllllllllllIllllIlIIIIIlllllII) : (lllllllllllllIllllIlIIIIlIIIIIIl -= lllllllllllllIllllIlIIIIIlllllII));
        return lllllllllllllIllllIlIIIIlIIIIIIl;
    }
    
    public static float calculateCompensation(final float lllllllllllllIllllIlIIIIIllIIlll, float lllllllllllllIllllIlIIIIIllIIllI, long lllllllllllllIllllIlIIIIIllIIlIl, final double lllllllllllllIllllIlIIIIIllIIlII) {
        final float lllllllllllllIllllIlIIIIIllIlIlI = lllllllllllllIllllIlIIIIIllIIllI - lllllllllllllIllllIlIIIIIllIIlll;
        if (lllllllllllllIllllIlIIIIIllIIlIl < 1L) {
            lllllllllllllIllllIlIIIIIllIIlIl = 1L;
        }
        if (lllllllllllllIllllIlIIIIIllIIlIl > 1000L) {
            lllllllllllllIllllIlIIIIIllIIlIl = 16L;
        }
        if (lllllllllllllIllllIlIIIIIllIlIlI > lllllllllllllIllllIlIIIIIllIIlII) {
            final double lllllllllllllIllllIlIIIIIllIlIIl = (lllllllllllllIllllIlIIIIIllIIlII * lllllllllllllIllllIlIIIIIllIIlIl / 16.0 < 0.5) ? 0.5 : (lllllllllllllIllllIlIIIIIllIIlII * lllllllllllllIllllIlIIIIIllIIlIl / 16.0);
            lllllllllllllIllllIlIIIIIllIIllI -= (float)lllllllllllllIllllIlIIIIIllIlIIl;
            if (lllllllllllllIllllIlIIIIIllIIllI < lllllllllllllIllllIlIIIIIllIIlll) {
                lllllllllllllIllllIlIIIIIllIIllI = lllllllllllllIllllIlIIIIIllIIlll;
            }
        }
        else if (lllllllllllllIllllIlIIIIIllIlIlI < -lllllllllllllIllllIlIIIIIllIIlII) {
            final double lllllllllllllIllllIlIIIIIllIlIII = (lllllllllllllIllllIlIIIIIllIIlII * lllllllllllllIllllIlIIIIIllIIlIl / 16.0 < 0.5) ? 0.5 : (lllllllllllllIllllIlIIIIIllIIlII * lllllllllllllIllllIlIIIIIllIIlIl / 16.0);
            lllllllllllllIllllIlIIIIIllIIllI += (float)lllllllllllllIllllIlIIIIIllIlIII;
            if (lllllllllllllIllllIlIIIIIllIIllI > lllllllllllllIllllIlIIIIIllIIlll) {
                lllllllllllllIllllIlIIIIIllIIllI = lllllllllllllIllllIlIIIIIllIIlll;
            }
        }
        else {
            lllllllllllllIllllIlIIIIIllIIllI = lllllllllllllIllllIlIIIIIllIIlll;
        }
        return lllllllllllllIllllIlIIIIIllIIllI;
    }
    
    public static float animation(final float lllllllllllllIllllIlIIIIlllIllII, final float lllllllllllllIllllIlIIIIlllIlIlI, final float lllllllllllllIllllIlIIIIlllIlIII, final float lllllllllllllIllllIlIIIIllIllllI) {
        float lllllllllllllIllllIlIIIIlllIIlII = (lllllllllllllIllllIlIIIIlllIlIlI - lllllllllllllIllllIlIIIIlllIllII) / Math.max((float)Minecraft.getDebugFPS(), 5.0f) * 15.0f;
        if (lllllllllllllIllllIlIIIIlllIIlII > 0.0f) {
            lllllllllllllIllllIlIIIIlllIIlII = Math.max(lllllllllllllIllllIlIIIIllIllllI, lllllllllllllIllllIlIIIIlllIIlII);
            lllllllllllllIllllIlIIIIlllIIlII = Math.min(lllllllllllllIllllIlIIIIlllIlIlI - lllllllllllllIllllIlIIIIlllIllII, lllllllllllllIllllIlIIIIlllIIlII);
        }
        else if (lllllllllllllIllllIlIIIIlllIIlII < 0.0f) {
            lllllllllllllIllllIlIIIIlllIIlII = Math.min(-lllllllllllllIllllIlIIIIllIllllI, lllllllllllllIllllIlIIIIlllIIlII);
            lllllllllllllIllllIlIIIIlllIIlII = Math.max(lllllllllllllIllllIlIIIIlllIlIlI - lllllllllllllIllllIlIIIIlllIllII, lllllllllllllIllllIlIIIIlllIIlII);
        }
        return lllllllllllllIllllIlIIIIlllIllII + lllllllllllllIllllIlIIIIlllIIlII;
    }
    
    public static float moveUD(final float lllllllllllllIllllIlIIIlIlIIIllI, final float lllllllllllllIllllIlIIIlIIllllll, final float lllllllllllllIllllIlIIIlIIllllIl) {
        return moveUD(lllllllllllllIllllIlIIIlIlIIIllI, lllllllllllllIllllIlIIIlIIllllll, AnimUtils.defaultSpeed, lllllllllllllIllllIlIIIlIIllllIl);
    }
    
    static {
        AnimUtils.speedTarget = 0.125f;
        AnimUtils.defaultSpeed = 0.125f;
    }
}
