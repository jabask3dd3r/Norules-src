package optifine;

import net.minecraft.util.math.*;

public class MathUtils
{
    public static int getAverage(final int[] llllllllllllllIIIIllIlllIlIIlllI) {
        if (llllllllllllllIIIIllIlllIlIIlllI.length <= 0) {
            return 0;
        }
        final int llllllllllllllIIIIllIlllIlIIllIl = getSum(llllllllllllllIIIIllIlllIlIIlllI);
        final int llllllllllllllIIIIllIlllIlIIllII = llllllllllllllIIIIllIlllIlIIllIl / llllllllllllllIIIIllIlllIlIIlllI.length;
        return llllllllllllllIIIIllIlllIlIIllII;
    }
    
    public static int getSum(final int[] llllllllllllllIIIIllIlllIlIIIIII) {
        if (llllllllllllllIIIIllIlllIlIIIIII.length <= 0) {
            return 0;
        }
        int llllllllllllllIIIIllIlllIlIIIIll = 0;
        for (int llllllllllllllIIIIllIlllIlIIIIlI = 0; llllllllllllllIIIIllIlllIlIIIIlI < llllllllllllllIIIIllIlllIlIIIIII.length; ++llllllllllllllIIIIllIlllIlIIIIlI) {
            final int llllllllllllllIIIIllIlllIlIIIIIl = llllllllllllllIIIIllIlllIlIIIIII[llllllllllllllIIIIllIlllIlIIIIlI];
            llllllllllllllIIIIllIlllIlIIIIll += llllllllllllllIIIIllIlllIlIIIIIl;
        }
        return llllllllllllllIIIIllIlllIlIIIIll;
    }
    
    public static int roundDownToPowerOfTwo(final int llllllllllllllIIIIllIlllIIlllIII) {
        final int llllllllllllllIIIIllIlllIIlllIIl = MathHelper.smallestEncompassingPowerOfTwo(llllllllllllllIIIIllIlllIIlllIII);
        return (llllllllllllllIIIIllIlllIIlllIII == llllllllllllllIIIIllIlllIIlllIIl) ? llllllllllllllIIIIllIlllIIlllIIl : (llllllllllllllIIIIllIlllIIlllIIl / 2);
    }
    
    public static boolean equalsDelta(final float llllllllllllllIIIIllIlllIIllIIII, final float llllllllllllllIIIIllIlllIIlIllll, final float llllllllllllllIIIIllIlllIIlIlllI) {
        return Math.abs(llllllllllllllIIIIllIlllIIllIIII - llllllllllllllIIIIllIlllIIlIllll) <= llllllllllllllIIIIllIlllIIlIlllI;
    }
    
    public static float toDeg(final float llllllllllllllIIIIllIlllIIlIlIll) {
        return llllllllllllllIIIIllIlllIIlIlIll * 180.0f / 3.1415927f;
    }
    
    public static float toRad(final float llllllllllllllIIIIllIlllIIlIlIII) {
        return llllllllllllllIIIIllIlllIIlIlIII / 180.0f * 3.1415927f;
    }
}
