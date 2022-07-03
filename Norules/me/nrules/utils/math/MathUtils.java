package me.nrules.utils.math;

import java.util.*;
import net.minecraft.util.math.*;
import java.math.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;

public class MathUtils
{
    private static final /* synthetic */ Random random;
    
    public static double getRandomInRange(final double lllllllllllllIllIllIlIIllIIIlIlI, final double lllllllllllllIllIllIlIIllIIIlIIl) {
        return lllllllllllllIllIllIlIIllIIIlIIl + (lllllllllllllIllIllIlIIllIIIlIlI - lllllllllllllIllIllIlIIllIIIlIIl) * MathUtils.random.nextDouble();
    }
    
    public static double getIncremental(final double lllllllllllllIllIllIlIIlIIlllllI, final double lllllllllllllIllIllIlIIlIIllllIl) {
        final double lllllllllllllIllIllIlIIlIIllllll = 1.0 / lllllllllllllIllIllIlIIlIIllllIl;
        return Math.round(lllllllllllllIllIllIlIIlIIlllllI * lllllllllllllIllIllIlIIlIIllllll) / lllllllllllllIllIllIlIIlIIllllll;
    }
    
    public static float[] calcAngle(final Vec3d lllllllllllllIllIllIlIIlIlIlllll, final Vec3d lllllllllllllIllIllIlIIlIllIIlII) {
        final double lllllllllllllIllIllIlIIlIllIIIll = lllllllllllllIllIllIlIIlIllIIlII.xCoord - lllllllllllllIllIllIlIIlIlIlllll.xCoord;
        final double lllllllllllllIllIllIlIIlIllIIIlI = (lllllllllllllIllIllIlIIlIllIIlII.yCoord - lllllllllllllIllIllIlIIlIlIlllll.yCoord) * -1.0;
        final double lllllllllllllIllIllIlIIlIllIIIIl = lllllllllllllIllIllIlIIlIllIIlII.zCoord - lllllllllllllIllIllIlIIlIlIlllll.zCoord;
        final double lllllllllllllIllIllIlIIlIllIIIII = MathHelper.sqrt(lllllllllllllIllIllIlIIlIllIIIll * lllllllllllllIllIllIlIIlIllIIIll + lllllllllllllIllIllIlIIlIllIIIIl * lllllllllllllIllIllIlIIlIllIIIIl);
        return new float[] { (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(lllllllllllllIllIllIlIIlIllIIIIl, lllllllllllllIllIllIlIIlIllIIIll)) - 90.0), (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(lllllllllllllIllIllIlIIlIllIIIlI, lllllllllllllIllIllIlIIlIllIIIII))) };
    }
    
    static {
        random = new Random();
    }
    
    public static float[] constrainAngle(final float[] lllllllllllllIllIllIlIIlIIllIlll) {
        lllllllllllllIllIllIlIIlIIllIlll[0] %= 360.0f;
        lllllllllllllIllIllIlIIlIIllIlll[1] %= 360.0f;
        while (lllllllllllllIllIllIlIIlIIllIlll[0] <= -180.0f) {
            lllllllllllllIllIllIlIIlIIllIlll[0] += 360.0f;
        }
        while (lllllllllllllIllIllIlIIlIIllIlll[1] <= -180.0f) {
            lllllllllllllIllIllIlIIlIIllIlll[1] += 360.0f;
        }
        while (lllllllllllllIllIllIlIIlIIllIlll[0] > 180.0f) {
            lllllllllllllIllIllIlIIlIIllIlll[0] -= 360.0f;
        }
        while (lllllllllllllIllIllIlIIlIIllIlll[1] > 180.0f) {
            lllllllllllllIllIllIlIIlIIllIlll[1] -= 360.0f;
        }
        return lllllllllllllIllIllIlIIlIIllIlll;
    }
    
    public static double preciseRound(final double lllllllllllllIllIllIlIIlIlIlIllI, final double lllllllllllllIllIllIlIIlIlIlIlIl) {
        final double lllllllllllllIllIllIlIIlIlIlIlII = Math.pow(10.0, lllllllllllllIllIllIlIIlIlIlIlIl);
        return Math.round(lllllllllllllIllIllIlIIlIlIlIllI * lllllllllllllIllIllIlIIlIlIlIlII) / lllllllllllllIllIllIlIIlIlIlIlII;
    }
    
    public static double roundToDecimalPlace(final double lllllllllllllIllIllIlIIlIIIlllll, final double lllllllllllllIllIllIlIIlIIIllIlI) {
        final double lllllllllllllIllIllIlIIlIIIlllIl = lllllllllllllIllIllIlIIlIIIllIlI / 2.0;
        final double lllllllllllllIllIllIlIIlIIIlllII = Math.floor(lllllllllllllIllIllIlIIlIIIlllll / lllllllllllllIllIllIlIIlIIIllIlI) * lllllllllllllIllIllIlIIlIIIllIlI;
        if (lllllllllllllIllIllIlIIlIIIlllll >= lllllllllllllIllIllIlIIlIIIlllII + lllllllllllllIllIllIlIIlIIIlllIl) {
            return new BigDecimal(Math.ceil(lllllllllllllIllIllIlIIlIIIlllll / lllllllllllllIllIllIlIIlIIIllIlI) * lllllllllllllIllIllIlIIlIIIllIlI, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
        }
        return new BigDecimal(lllllllllllllIllIllIlIIlIIIlllII, MathContext.DECIMAL64).stripTrailingZeros().doubleValue();
    }
    
    public static double roundToPlace(final double lllllllllllllIllIllIlIIlIllIlllI, final int lllllllllllllIllIllIlIIlIlllIIII) {
        if (lllllllllllllIllIllIlIIlIlllIIII < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllIllIllIlIIlIllIllll = new BigDecimal(lllllllllllllIllIllIlIIlIllIlllI);
        lllllllllllllIllIllIlIIlIllIllll = lllllllllllllIllIllIlIIlIllIllll.setScale(lllllllllllllIllIllIlIIlIlllIIII, RoundingMode.HALF_UP);
        return lllllllllllllIllIllIlIIlIllIllll.doubleValue();
    }
    
    public static double randomNumber(final double lllllllllllllIllIllIlIIlIlIIllII, final double lllllllllllllIllIllIlIIlIlIIllIl) {
        return Math.random() * (lllllllllllllIllIllIlIIlIlIIllII - lllllllllllllIllIllIlIIlIlIIllIl) + lllllllllllllIllIllIlIIlIlIIllIl;
    }
    
    public static int randomize(final int lllllllllllllIllIllIlIIlIlIIIllI, final int lllllllllllllIllIllIlIIlIlIIIlIl) {
        return -lllllllllllllIllIllIlIIlIlIIIlIl + (int)(Math.random() * (lllllllllllllIllIllIlIIlIlIIIllI - -lllllllllllllIllIllIlIIlIlIIIlIl + 1));
    }
    
    public static float lerp(final float lllllllllllllIllIllIlIIlIIIlIIIl, final float lllllllllllllIllIllIlIIlIIIlIIll, final float lllllllllllllIllIllIlIIlIIIlIIlI) {
        return lllllllllllllIllIllIlIIlIIIlIIIl + lllllllllllllIllIllIlIIlIIIlIIlI * (lllllllllllllIllIllIlIIlIIIlIIll - lllllllllllllIllIllIlIIlIIIlIIIl);
    }
    
    public static int getRandomInRange(final int lllllllllllllIllIllIlIIlIllllIll, final int lllllllllllllIllIllIlIIlIllllIII) {
        return (int)(lllllllllllllIllIllIlIIlIllllIII + (lllllllllllllIllIllIlIIlIllllIll - lllllllllllllIllIllIlIIlIllllIII) * MathUtils.random.nextDouble());
    }
    
    public static BigDecimal round(final float lllllllllllllIllIllIlIIllIIIIIll, final int lllllllllllllIllIllIlIIlIlllllll) {
        BigDecimal lllllllllllllIllIllIlIIllIIIIIIl = new BigDecimal(Float.toString(lllllllllllllIllIllIlIIllIIIIIll));
        lllllllllllllIllIllIlIIllIIIIIIl = lllllllllllllIllIllIlIIllIIIIIIl.setScale(lllllllllllllIllIllIlIIlIlllllll, 4);
        return lllllllllllllIllIllIlIIllIIIIIIl;
    }
    
    public static boolean isInteger(final Double lllllllllllllIllIllIlIIlIIlllIIl) {
        return lllllllllllllIllIllIlIIlIIlllIIl == Math.floor(lllllllllllllIllIllIlIIlIIlllIIl) && !Double.isInfinite(lllllllllllllIllIllIlIIlIIlllIIl);
    }
    
    public static double[] interpolateEntity(final Entity lllllllllllllIllIllIlIIllIIlIlII) {
        final double lllllllllllllIllIllIlIIllIIlIlIl = Minecraft.getMinecraft().getRenderPartialTicks();
        return new double[] { lllllllllllllIllIllIlIIllIIlIlII.lastTickPosX + (lllllllllllllIllIllIlIIllIIlIlII.posX - lllllllllllllIllIllIlIIllIIlIlII.lastTickPosX) * lllllllllllllIllIllIlIIllIIlIlIl, lllllllllllllIllIllIlIIllIIlIlII.lastTickPosY + (lllllllllllllIllIllIlIIllIIlIlII.posY - lllllllllllllIllIllIlIIllIIlIlII.lastTickPosY) * lllllllllllllIllIllIlIIllIIlIlIl, lllllllllllllIllIllIlIIllIIlIlII.lastTickPosZ + (lllllllllllllIllIllIlIIllIIlIlII.posZ - lllllllllllllIllIllIlIIllIIlIlII.lastTickPosZ) * lllllllllllllIllIllIlIIllIIlIlIl };
    }
    
    public static double randomize(final double lllllllllllllIllIllIlIIlIIlIllll, final double lllllllllllllIllIllIlIIlIIlIlllI) {
        final Random lllllllllllllIllIllIlIIlIIlIllII = new Random();
        final double lllllllllllllIllIllIlIIlIIlIlIll = lllllllllllllIllIllIlIIlIIlIlllI - lllllllllllllIllIllIlIIlIIlIllll;
        double lllllllllllllIllIllIlIIlIIlIlIlI = lllllllllllllIllIllIlIIlIIlIllII.nextDouble() * lllllllllllllIllIllIlIIlIIlIlIll;
        if (lllllllllllllIllIllIlIIlIIlIlIlI > lllllllllllllIllIllIlIIlIIlIlllI) {
            lllllllllllllIllIllIlIIlIIlIlIlI = lllllllllllllIllIllIlIIlIIlIlllI;
        }
        double lllllllllllllIllIllIlIIlIIlIllIl;
        if ((lllllllllllllIllIllIlIIlIIlIllIl = lllllllllllllIllIllIlIIlIIlIlIlI + lllllllllllllIllIllIlIIlIIlIllll) > lllllllllllllIllIllIlIIlIIlIlllI) {
            lllllllllllllIllIllIlIIlIIlIllIl = lllllllllllllIllIllIlIIlIIlIlllI;
        }
        return lllllllllllllIllIllIlIIlIIlIllIl;
    }
    
    public static boolean isEven(final int lllllllllllllIllIllIlIIlIlllIllI) {
        return lllllllllllllIllIllIlIIlIlllIllI % 2 == 0;
    }
    
    public static float clamp(float lllllllllllllIllIllIlIIlIIIIlIII, final float lllllllllllllIllIllIlIIlIIIIIlll, final float lllllllllllllIllIllIlIIlIIIIIllI) {
        if (lllllllllllllIllIllIlIIlIIIIlIII <= lllllllllllllIllIllIlIIlIIIIIlll) {
            lllllllllllllIllIllIlIIlIIIIlIII = lllllllllllllIllIllIlIIlIIIIIlll;
        }
        if (lllllllllllllIllIllIlIIlIIIIlIII >= lllllllllllllIllIllIlIIlIIIIIllI) {
            lllllllllllllIllIllIlIIlIIIIlIII = lllllllllllllIllIllIlIIlIIIIIllI;
        }
        return lllllllllllllIllIllIlIIlIIIIlIII;
    }
    
    public static int ceilToPOT(final int lllllllllllllIllIllIlIIllIIIlllI) {
        int lllllllllllllIllIllIlIIllIIIllll = lllllllllllllIllIllIlIIllIIIlllI;
        lllllllllllllIllIllIlIIllIIIllll = (--lllllllllllllIllIllIlIIllIIIllll | lllllllllllllIllIllIlIIllIIIllll >> 1);
        lllllllllllllIllIllIlIIllIIIllll |= lllllllllllllIllIllIlIIllIIIllll >> 2;
        lllllllllllllIllIllIlIIllIIIllll |= lllllllllllllIllIllIlIIllIIIllll >> 4;
        lllllllllllllIllIllIlIIllIIIllll |= lllllllllllllIllIllIlIIllIIIllll >> 8;
        lllllllllllllIllIllIlIIllIIIllll |= lllllllllllllIllIllIlIIllIIIllll >> 16;
        return ++lllllllllllllIllIllIlIIllIIIllll;
    }
}
