package com.kisman.nr.cc.util;

import net.minecraft.util.math.*;
import java.math.*;

public class MathUtil
{
    public static Vec3d roundVec(final Vec3d lllllllllllllIIlIllllIIlIIIIlIll, final int lllllllllllllIIlIllllIIlIIIIllII) {
        return new Vec3d(round(lllllllllllllIIlIllllIIlIIIIlIll.xCoord, lllllllllllllIIlIllllIIlIIIIllII), round(lllllllllllllIIlIllllIIlIIIIlIll.yCoord, lllllllllllllIIlIllllIIlIIIIllII), round(lllllllllllllIIlIllllIIlIIIIlIll.zCoord, lllllllllllllIIlIllllIIlIIIIllII));
    }
    
    public static double square(final double lllllllllllllIIlIllllIIlIIIllIlI) {
        return lllllllllllllIIlIllllIIlIIIllIlI * lllllllllllllIIlIllllIIlIIIllIlI;
    }
    
    public static float clamp(final float lllllllllllllIIlIllllIIlIIIlIIlI, final float lllllllllllllIIlIllllIIlIIIlIlII, final float lllllllllllllIIlIllllIIlIIIlIIII) {
        return Math.min(Math.max(lllllllllllllIIlIllllIIlIIIlIIlI, lllllllllllllIIlIllllIIlIIIlIlII), lllllllllllllIIlIllllIIlIIIlIIII);
    }
    
    public static double round(final double lllllllllllllIIlIllllIIlIIIIIIll, final int lllllllllllllIIlIllllIIlIIIIIIlI) {
        if (lllllllllllllIIlIllllIIlIIIIIIlI < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllIIlIllllIIlIIIIIlII = BigDecimal.valueOf(lllllllllllllIIlIllllIIlIIIIIIll);
        lllllllllllllIIlIllllIIlIIIIIlII = lllllllllllllIIlIllllIIlIIIIIlII.setScale(lllllllllllllIIlIllllIIlIIIIIIlI, RoundingMode.FLOOR);
        return lllllllllllllIIlIllllIIlIIIIIlII.doubleValue();
    }
}
