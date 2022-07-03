package com.kisman.nr.cc.util;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class InterpolationUtil
{
    public static Vec3d getInterpolatedAmount(final Entity lllllllllllllIIlllIllIlIlIllllll, final double lllllllllllllIIlllIllIlIlIlllIlI, final double lllllllllllllIIlllIllIlIlIlllIIl, final double lllllllllllllIIlllIllIlIlIlllIII) {
        return new Vec3d((lllllllllllllIIlllIllIlIlIllllll.posX - lllllllllllllIIlllIllIlIlIllllll.lastTickPosX) * lllllllllllllIIlllIllIlIlIlllIlI, (lllllllllllllIIlllIllIlIlIllllll.posY - lllllllllllllIIlllIllIlIlIllllll.lastTickPosY) * lllllllllllllIIlllIllIlIlIlllIIl, (lllllllllllllIIlllIllIlIlIllllll.posZ - lllllllllllllIIlllIllIlIlIllllll.lastTickPosZ) * lllllllllllllIIlllIllIlIlIlllIII);
    }
    
    public static Vec3d getInterpolatedPos(final Entity lllllllllllllIIlllIllIlIllIIlIll, final float lllllllllllllIIlllIllIlIllIIlIlI) {
        return new Vec3d(lllllllllllllIIlllIllIlIllIIlIll.lastTickPosX, lllllllllllllIIlllIllIlIllIIlIll.lastTickPosY, lllllllllllllIIlllIllIlIllIIlIll.lastTickPosZ).add(getInterpolatedAmount(lllllllllllllIIlllIllIlIllIIlIll, lllllllllllllIIlllIllIlIllIIlIlI));
    }
    
    public static Vec3d getInterpolatedAmount(final Entity lllllllllllllIIlllIllIlIllIIIlll, final double lllllllllllllIIlllIllIlIllIIIlII) {
        return getInterpolatedAmount(lllllllllllllIIlllIllIlIllIIIlll, lllllllllllllIIlllIllIlIllIIIlII, lllllllllllllIIlllIllIlIllIIIlII, lllllllllllllIIlllIllIlIllIIIlII);
    }
    
    public static boolean isNearlyEqual(final double lllllllllllllIIlllIllIlIlIlIIlll, final double lllllllllllllIIlllIllIlIlIlIIllI, final double lllllllllllllIIlllIllIlIlIlIIlIl) {
        final double lllllllllllllIIlllIllIlIlIlIlIIl = lllllllllllllIIlllIllIlIlIlIIlll + lllllllllllllIIlllIllIlIlIlIIlIl;
        final double lllllllllllllIIlllIllIlIlIlIlIII = lllllllllllllIIlllIllIlIlIlIIlll - lllllllllllllIIlllIllIlIlIlIIlIl;
        return lllllllllllllIIlllIllIlIlIlIIllI <= lllllllllllllIIlllIllIlIlIlIlIIl && lllllllllllllIIlllIllIlIlIlIIllI >= lllllllllllllIIlllIllIlIlIlIlIII;
    }
    
    public static Vec3d interpolateEntityTime(final Entity lllllllllllllIIlllIllIlIlIllIlIl, final float lllllllllllllIIlllIllIlIlIllIlII) {
        return new Vec3d(lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosX + (lllllllllllllIIlllIllIlIlIllIlIl.posX - lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosX) * lllllllllllllIIlllIllIlIlIllIlII, lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosY + (lllllllllllllIIlllIllIlIlIllIlIl.posY - lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosY) * lllllllllllllIIlllIllIlIlIllIlII, lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosZ + (lllllllllllllIIlllIllIlIlIllIlIl.posZ - lllllllllllllIIlllIllIlIlIllIlIl.lastTickPosZ) * lllllllllllllIIlllIllIlIlIllIlII);
    }
}
