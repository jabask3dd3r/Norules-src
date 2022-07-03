package net.minecraft.util.math;

import java.util.*;

public class MathHelper
{
    private static final /* synthetic */ float[] SIN_TABLE;
    private static final /* synthetic */ double[] ASINE_TAB;
    public static /* synthetic */ boolean fastMath;
    private static final /* synthetic */ float[] SIN_TABLE_FAST;
    private static final /* synthetic */ double FRAC_BIAS;
    private static final /* synthetic */ Random RANDOM;
    private static final /* synthetic */ int[] MULTIPLY_DE_BRUIJN_BIT_POSITION;
    private static final /* synthetic */ double[] COS_TAB;
    
    private static boolean isPowerOfTwo(final int llllllllllllllIlllIlIllIIlIlllll) {
        return llllllllllllllIlllIlIllIIlIlllll != 0 && (llllllllllllllIlllIlIllIIlIlllll & llllllllllllllIlllIlIllIIlIlllll - 1) == 0x0;
    }
    
    public static float positiveModulo(final float llllllllllllllIlllIlIllIlIIllllI, final float llllllllllllllIlllIlIllIlIIllIll) {
        return (llllllllllllllIlllIlIllIlIIllllI % llllllllllllllIlllIlIllIlIIllIll + llllllllllllllIlllIlIllIlIIllIll) % llllllllllllllIlllIlIllIlIIllIll;
    }
    
    public static UUID getRandomUUID() {
        return getRandomUUID(MathHelper.RANDOM);
    }
    
    public static boolean epsilonEquals(final float llllllllllllllIlllIlIllIlIlIlIlI, final float llllllllllllllIlllIlIllIlIlIlIIl) {
        return abs(llllllllllllllIlllIlIllIlIlIlIIl - llllllllllllllIlllIlIllIlIlIlIlI) < 1.0E-5f;
    }
    
    public static float nextFloat(final Random llllllllllllllIlllIlIllIllIIlIlI, final float llllllllllllllIlllIlIllIllIIlIIl, final float llllllllllllllIlllIlIllIllIIlIII) {
        return (llllllllllllllIlllIlIllIllIIlIIl >= llllllllllllllIlllIlIllIllIIlIII) ? llllllllllllllIlllIlIllIllIIlIIl : (llllllllllllllIlllIlIllIllIIlIlI.nextFloat() * (llllllllllllllIlllIlIllIllIIlIII - llllllllllllllIlllIlIllIllIIlIIl) + llllllllllllllIlllIlIllIllIIlIIl);
    }
    
    public static int rgb(final float llllllllllllllIlllIlIllIIlIIllII, final float llllllllllllllIlllIlIllIIlIIlIll, final float llllllllllllllIlllIlIllIIlIIIlll) {
        return rgb(floor(llllllllllllllIlllIlIllIIlIIllII * 255.0f), floor(llllllllllllllIlllIlIllIIlIIlIll * 255.0f), floor(llllllllllllllIlllIlIllIIlIIIlll * 255.0f));
    }
    
    public static float cos(final float llllllllllllllIlllIlIlllIIlllIII) {
        return MathHelper.fastMath ? MathHelper.SIN_TABLE_FAST[(int)((llllllllllllllIlllIlIlllIIlllIII + 1.5707964f) * 651.8986f) & 0xFFF] : MathHelper.SIN_TABLE[(int)(llllllllllllllIlllIlIlllIIlllIII * 10430.378f + 16384.0f) & 0xFFFF];
    }
    
    public static int smallestEncompassingPowerOfTwo(final int llllllllllllllIlllIlIllIIllIIlIl) {
        int llllllllllllllIlllIlIllIIllIIlII = llllllllllllllIlllIlIllIIllIIlIl - 1;
        llllllllllllllIlllIlIllIIllIIlII |= llllllllllllllIlllIlIllIIllIIlII >> 1;
        llllllllllllllIlllIlIllIIllIIlII |= llllllllllllllIlllIlIllIIllIIlII >> 2;
        llllllllllllllIlllIlIllIIllIIlII |= llllllllllllllIlllIlIllIIllIIlII >> 4;
        llllllllllllllIlllIlIllIIllIIlII |= llllllllllllllIlllIlIllIIllIIlII >> 8;
        llllllllllllllIlllIlIllIIllIIlII |= llllllllllllllIlllIlIllIIllIIlII >> 16;
        return llllllllllllllIlllIlIllIIllIIlII + 1;
    }
    
    public static int getInt(final Random llllllllllllllIlllIlIllIllIlIIll, final int llllllllllllllIlllIlIllIllIIllll, final int llllllllllllllIlllIlIllIllIlIIIl) {
        return (llllllllllllllIlllIlIllIllIIllll >= llllllllllllllIlllIlIllIllIlIIIl) ? llllllllllllllIlllIlIllIllIIllll : (llllllllllllllIlllIlIllIllIlIIll.nextInt(llllllllllllllIlllIlIllIllIlIIIl - llllllllllllllIlllIlIllIllIIllll + 1) + llllllllllllllIlllIlIllIllIIllll);
    }
    
    public static int ceil(final float llllllllllllllIlllIlIlllIIIIlllI) {
        final int llllllllllllllIlllIlIlllIIIIllll = (int)llllllllllllllIlllIlIlllIIIIlllI;
        return (llllllllllllllIlllIlIlllIIIIlllI > llllllllllllllIlllIlIlllIIIIllll) ? (llllllllllllllIlllIlIlllIIIIllll + 1) : llllllllllllllIlllIlIlllIIIIllll;
    }
    
    public static double pct(final double llllllllllllllIlllIlIlIllllllIll, final double llllllllllllllIlllIlIlIllllllIlI, final double llllllllllllllIlllIlIlIlllllIllI) {
        return (llllllllllllllIlllIlIlIllllllIll - llllllllllllllIlllIlIlIllllllIlI) / (llllllllllllllIlllIlIlIlllllIllI - llllllllllllllIlllIlIlIllllllIlI);
    }
    
    public static int ceil(final double llllllllllllllIlllIlIlllIIIIlIlI) {
        final int llllllllllllllIlllIlIlllIIIIlIIl = (int)llllllllllllllIlllIlIlllIIIIlIlI;
        return (llllllllllllllIlllIlIlllIIIIlIlI > llllllllllllllIlllIlIlllIIIIlIIl) ? (llllllllllllllIlllIlIlllIIIIlIIl + 1) : llllllllllllllIlllIlIlllIIIIlIIl;
    }
    
    public static float sqrt(final float llllllllllllllIlllIlIlllIIllIlII) {
        return (float)Math.sqrt(llllllllllllllIlllIlIlllIIllIlII);
    }
    
    public static double wrapDegrees(double llllllllllllllIlllIlIllIlIIIllll) {
        llllllllllllllIlllIlIllIlIIIllll %= 360.0;
        if (llllllllllllllIlllIlIllIlIIIllll >= 180.0) {
            llllllllllllllIlllIlIllIlIIIllll -= 360.0;
        }
        if (llllllllllllllIlllIlIllIlIIIllll < -180.0) {
            llllllllllllllIlllIlIllIlIIIllll += 360.0;
        }
        return llllllllllllllIlllIlIllIlIIIllll;
    }
    
    public static double func_191273_b(final double llllllllllllllIlllIlIllIlIIlIllI, final double llllllllllllllIlllIlIllIlIIlIlIl) {
        return (llllllllllllllIlllIlIllIlIIlIllI % llllllllllllllIlllIlIllIlIIlIlIl + llllllllllllllIlllIlIllIlIIlIlIl) % llllllllllllllIlllIlIllIlIIlIlIl;
    }
    
    static {
        SIN_COUNT = 4096;
        SIN_BITS = 12;
        SIN_MASK = 4095;
        SQRT_2 = sqrt(2.0f);
        SIN_TABLE_FAST = new float[4096];
        MathHelper.fastMath = false;
        SIN_TABLE = new float[65536];
        RANDOM = new Random();
        for (int llllllllllllllIlllIlIlllIlIIlIII = 0; llllllllllllllIlllIlIlllIlIIlIII < 65536; ++llllllllllllllIlllIlIlllIlIIlIII) {
            MathHelper.SIN_TABLE[llllllllllllllIlllIlIlllIlIIlIII] = (float)Math.sin(llllllllllllllIlllIlIlllIlIIlIII * 3.141592653589793 * 2.0 / 65536.0);
        }
        for (int llllllllllllllIlllIlIlllIlIIIlll = 0; llllllllllllllIlllIlIlllIlIIIlll < 4096; ++llllllllllllllIlllIlIlllIlIIIlll) {
            MathHelper.SIN_TABLE_FAST[llllllllllllllIlllIlIlllIlIIIlll] = (float)Math.sin((llllllllllllllIlllIlIlllIlIIIlll + 0.5f) / 4096.0f * 6.2831855f);
        }
        for (int llllllllllllllIlllIlIlllIlIIIllI = 0; llllllllllllllIlllIlIlllIlIIIllI < 360; llllllllllllllIlllIlIlllIlIIIllI += 90) {
            MathHelper.SIN_TABLE_FAST[(int)(llllllllllllllIlllIlIlllIlIIIllI * 11.377778f) & 0xFFF] = (float)Math.sin(llllllllllllllIlllIlIlllIlIIIllI * 0.017453292f);
        }
        MULTIPLY_DE_BRUIJN_BIT_POSITION = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
        FRAC_BIAS = Double.longBitsToDouble(4805340802404319232L);
        ASINE_TAB = new double[257];
        COS_TAB = new double[257];
        for (int llllllllllllllIlllIlIlllIlIIIlIl = 0; llllllllllllllIlllIlIlllIlIIIlIl < 257; ++llllllllllllllIlllIlIlllIlIIIlIl) {
            final double llllllllllllllIlllIlIlllIlIIIlII = llllllllllllllIlllIlIlllIlIIIlIl / 256.0;
            final double llllllllllllllIlllIlIlllIlIIIIll = Math.asin(llllllllllllllIlllIlIlllIlIIIlII);
            MathHelper.COS_TAB[llllllllllllllIlllIlIlllIlIIIlIl] = Math.cos(llllllllllllllIlllIlIlllIlIIIIll);
            MathHelper.ASINE_TAB[llllllllllllllIlllIlIlllIlIIIlIl] = llllllllllllllIlllIlIlllIlIIIIll;
        }
    }
    
    public static float abs(final float llllllllllllllIlllIlIlllIIIlIllI) {
        return (llllllllllllllIlllIlIlllIIIlIllI >= 0.0f) ? llllllllllllllIlllIlIlllIIIlIllI : (-llllllllllllllIlllIlIlllIIIlIllI);
    }
    
    public static int floor(final double llllllllllllllIlllIlIlllIIlIIlIl) {
        final int llllllllllllllIlllIlIlllIIlIIlII = (int)llllllllllllllIlllIlIlllIIlIIlIl;
        return (llllllllllllllIlllIlIlllIIlIIlIl < llllllllllllllIlllIlIlllIIlIIlII) ? (llllllllllllllIlllIlIlllIIlIIlII - 1) : llllllllllllllIlllIlIlllIIlIIlII;
    }
    
    public static double clampedLerp(final double llllllllllllllIlllIlIllIlllIlIII, final double llllllllllllllIlllIlIllIlllIIlII, final double llllllllllllllIlllIlIllIlllIIIll) {
        if (llllllllllllllIlllIlIllIlllIIIll < 0.0) {
            return llllllllllllllIlllIlIllIlllIlIII;
        }
        return (llllllllllllllIlllIlIllIlllIIIll > 1.0) ? llllllllllllllIlllIlIllIlllIIlII : (llllllllllllllIlllIlIllIlllIlIII + (llllllllllllllIlllIlIllIlllIIlII - llllllllllllllIlllIlIllIlllIlIII) * llllllllllllllIlllIlIllIlllIIIll);
    }
    
    public static int getInt(final String llllllllllllllIlllIlIllIIlllllll, final int llllllllllllllIlllIlIllIIllllIll, final int llllllllllllllIlllIlIllIIlllllIl) {
        return Math.max(llllllllllllllIlllIlIllIIlllllIl, getInt(llllllllllllllIlllIlIllIIlllllll, llllllllllllllIlllIlIllIIllllIll));
    }
    
    public static int floor(final float llllllllllllllIlllIlIlllIIlIlllI) {
        final int llllllllllllllIlllIlIlllIIlIllIl = (int)llllllllllllllIlllIlIlllIIlIlllI;
        return (llllllllllllllIlllIlIlllIIlIlllI < llllllllllllllIlllIlIlllIIlIllIl) ? (llllllllllllllIlllIlIlllIIlIllIl - 1) : llllllllllllllIlllIlIlllIIlIllIl;
    }
    
    public static int log2DeBruijn(int llllllllllllllIlllIlIllIIlIlllII) {
        llllllllllllllIlllIlIllIIlIlllII = (isPowerOfTwo(llllllllllllllIlllIlIllIIlIlllII) ? llllllllllllllIlllIlIllIIlIlllII : smallestEncompassingPowerOfTwo(llllllllllllllIlllIlIllIIlIlllII));
        return MathHelper.MULTIPLY_DE_BRUIJN_BIT_POSITION[(int)(llllllllllllllIlllIlIllIIlIlllII * 125613361L >> 27) & 0x1F];
    }
    
    public static float sqrt(final double llllllllllllllIlllIlIlllIIllIIlI) {
        return (float)Math.sqrt(llllllllllllllIlllIlIlllIIllIIlI);
    }
    
    public static int normalizeAngle(final int llllllllllllllIlllIlIllIlIlIIIlI, final int llllllllllllllIlllIlIllIlIlIIIIl) {
        return (llllllllllllllIlllIlIllIlIlIIIlI % llllllllllllllIlllIlIllIlIlIIIIl + llllllllllllllIlllIlIllIlIlIIIIl) % llllllllllllllIlllIlIllIlIlIIIIl;
    }
    
    public static int intFloorDiv(final int llllllllllllllIlllIlIllIllIllIlI, final int llllllllllllllIlllIlIllIllIllIIl) {
        return (llllllllllllllIlllIlIllIllIllIlI < 0) ? (-((-llllllllllllllIlllIlIllIllIllIlI - 1) / llllllllllllllIlllIlIllIllIllIIl) - 1) : (llllllllllllllIlllIlIllIllIllIlI / llllllllllllllIlllIlIllIllIllIIl);
    }
    
    public static int abs(final int llllllllllllllIlllIlIlllIIIlIIll) {
        return (llllllllllllllIlllIlIlllIIIlIIll >= 0) ? llllllllllllllIlllIlIlllIIIlIIll : (-llllllllllllllIlllIlIlllIIIlIIll);
    }
    
    public static double clamp(final double llllllllllllllIlllIlIllIllllIIIl, final double llllllllllllllIlllIlIllIllllIIII, final double llllllllllllllIlllIlIllIlllIllII) {
        if (llllllllllllllIlllIlIllIllllIIIl < llllllllllllllIlllIlIllIllllIIII) {
            return llllllllllllllIlllIlIllIllllIIII;
        }
        return (llllllllllllllIlllIlIllIllllIIIl > llllllllllllllIlllIlIllIlllIllII) ? llllllllllllllIlllIlIllIlllIllII : llllllllllllllIlllIlIllIllllIIIl;
    }
    
    public static int log2(final int llllllllllllllIlllIlIllIIlIllIIl) {
        return log2DeBruijn(llllllllllllllIlllIlIllIIlIllIIl) - (isPowerOfTwo(llllllllllllllIlllIlIllIIlIllIIl) ? 0 : 1);
    }
    
    public static int multiplyColor(final int llllllllllllllIlllIlIllIIIlIllll, final int llllllllllllllIlllIlIllIIIlIIIll) {
        final int llllllllllllllIlllIlIllIIIlIllIl = (llllllllllllllIlllIlIllIIIlIllll & 0xFF0000) >> 16;
        final int llllllllllllllIlllIlIllIIIlIllII = (llllllllllllllIlllIlIllIIIlIIIll & 0xFF0000) >> 16;
        final int llllllllllllllIlllIlIllIIIlIlIll = (llllllllllllllIlllIlIllIIIlIllll & 0xFF00) >> 8;
        final int llllllllllllllIlllIlIllIIIlIlIlI = (llllllllllllllIlllIlIllIIIlIIIll & 0xFF00) >> 8;
        final int llllllllllllllIlllIlIllIIIlIlIIl = (llllllllllllllIlllIlIllIIIlIllll & 0xFF) >> 0;
        final int llllllllllllllIlllIlIllIIIlIlIII = (llllllllllllllIlllIlIllIIIlIIIll & 0xFF) >> 0;
        final int llllllllllllllIlllIlIllIIIlIIlll = (int)(llllllllllllllIlllIlIllIIIlIllIl * (float)llllllllllllllIlllIlIllIIIlIllII / 255.0f);
        final int llllllllllllllIlllIlIllIIIlIIllI = (int)(llllllllllllllIlllIlIllIIIlIlIll * (float)llllllllllllllIlllIlIllIIIlIlIlI / 255.0f);
        final int llllllllllllllIlllIlIllIIIlIIlIl = (int)(llllllllllllllIlllIlIllIIIlIlIIl * (float)llllllllllllllIlllIlIllIIIlIlIII / 255.0f);
        return (llllllllllllllIlllIlIllIIIlIllll & 0xFF000000) | llllllllllllllIlllIlIllIIIlIIlll << 16 | llllllllllllllIlllIlIllIIIlIIllI << 8 | llllllllllllllIlllIlIllIIIlIIlIl;
    }
    
    public static UUID getRandomUUID(final Random llllllllllllllIlllIlIllIIIIIIIIl) {
        final long llllllllllllllIlllIlIllIIIIIIIll = (llllllllllllllIlllIlIllIIIIIIIIl.nextLong() & 0xFFFFFFFFFFFF0FFFL) | 0x4000L;
        final long llllllllllllllIlllIlIllIIIIIIIlI = (llllllllllllllIlllIlIllIIIIIIIIl.nextLong() & 0x3FFFFFFFFFFFFFFFL) | Long.MIN_VALUE;
        return new UUID(llllllllllllllIlllIlIllIIIIIIIll, llllllllllllllIlllIlIllIIIIIIIlI);
    }
    
    public static float sin(final float llllllllllllllIlllIlIlllIIlllIlI) {
        return MathHelper.fastMath ? MathHelper.SIN_TABLE_FAST[(int)(llllllllllllllIlllIlIlllIIlllIlI * 651.8986f) & 0xFFF] : MathHelper.SIN_TABLE[(int)(llllllllllllllIlllIlIlllIIlllIlI * 10430.378f) & 0xFFFF];
    }
    
    public static int absFloor(final double llllllllllllllIlllIlIlllIIIllIIl) {
        return (int)((llllllllllllllIlllIlIlllIIIllIIl >= 0.0) ? llllllllllllllIlllIlIlllIIIllIIl : (-llllllllllllllIlllIlIlllIIIllIIl + 1.0));
    }
    
    public static long getPositionRandom(final Vec3i llllllllllllllIlllIlIllIIIIlIlII) {
        return getCoordinateRandom(llllllllllllllIlllIlIllIIIIlIlII.getX(), llllllllllllllIlllIlIllIIIIlIlII.getY(), llllllllllllllIlllIlIllIIIIlIlII.getZ());
    }
    
    public static long getCoordinateRandom(final int llllllllllllllIlllIlIllIIIIIllll, final int llllllllllllllIlllIlIllIIIIIlIlI, final int llllllllllllllIlllIlIllIIIIIllIl) {
        long llllllllllllllIlllIlIllIIIIIllII = (long)(llllllllllllllIlllIlIllIIIIIllll * 3129871) ^ llllllllllllllIlllIlIllIIIIIllIl * 116129781L ^ (long)llllllllllllllIlllIlIllIIIIIlIlI;
        llllllllllllllIlllIlIllIIIIIllII = llllllllllllllIlllIlIllIIIIIllII * llllllllllllllIlllIlIllIIIIIllII * 42317861L + llllllllllllllIlllIlIllIIIIIllII * 11L;
        return llllllllllllllIlllIlIllIIIIIllII;
    }
    
    public static float wrapDegrees(float llllllllllllllIlllIlIllIlIIlIIlI) {
        llllllllllllllIlllIlIllIlIIlIIlI %= (long)360.0f;
        if (llllllllllllllIlllIlIllIlIIlIIlI >= 180.0f) {
            llllllllllllllIlllIlIllIlIIlIIlI -= (long)360.0f;
        }
        if (llllllllllllllIlllIlIllIlIIlIIlI < -180.0f) {
            llllllllllllllIlllIlIllIlIIlIIlI += (long)360.0f;
        }
        return llllllllllllllIlllIlIllIlIIlIIlI;
    }
    
    public static double fastInvSqrt(final double llllllllllllllIlllIlIlIlllIIIlII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //     4: dmul           
        //     5: dstore_2        /* llllllllllllllIlllIlIlIlllIIIIll */
        //     6: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //     7: invokestatic    java/lang/Double.doubleToRawLongBits:(D)J
        //    10: lstore          llllllllllllllIlllIlIlIlllIIIIlI
        //    12: ldc2_w          6910469410427058090
        //    15: lload           llllllllllllllIlllIlIlIlllIIIIlI
        //    17: iconst_1       
        //    18: lshr           
        //    19: lsub           
        //    20: lstore          llllllllllllllIlllIlIlIlllIIIIlI
        //    22: lload           llllllllllllllIlllIlIlIlllIIIIlI
        //    24: invokestatic    java/lang/Double.longBitsToDouble:(J)D
        //    27: dstore_0        /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    28: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    29: ldc2_w          1.5
        //    32: dload_2         /* llllllllllllllIlllIlIlIlllIIIIll */
        //    33: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    34: dmul           
        //    35: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    36: dmul           
        //    37: dsub           
        //    38: dmul           
        //    39: dstore_0        /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    40: dload_0         /* llllllllllllllIlllIlIlIlllIIIIIl */
        //    41: dreturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.ArrayIndexOutOfBoundsException: -1
        //     at java.util.ArrayList.elementData(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.assembler.ir.StackMappingVisitor.getStackValue(StackMappingVisitor.java:68)
        //     at com.strobel.decompiler.ast.AstBuilder.createModifiedStack(AstBuilder.java:2578)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2032)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int roundUp(final int llllllllllllllIlllIlIllIIlIlIlIl, int llllllllllllllIlllIlIllIIlIlIIIl) {
        if (llllllllllllllIlllIlIllIIlIlIIIl == 0) {
            return 0;
        }
        if (llllllllllllllIlllIlIllIIlIlIlIl == 0) {
            return llllllllllllllIlllIlIllIIlIlIIIl;
        }
        if (llllllllllllllIlllIlIllIIlIlIlIl < 0) {
            llllllllllllllIlllIlIllIIlIlIIIl *= -1;
        }
        final int llllllllllllllIlllIlIllIIlIlIIll = llllllllllllllIlllIlIllIIlIlIlIl % llllllllllllllIlllIlIllIIlIlIIIl;
        return (llllllllllllllIlllIlIllIIlIlIIll == 0) ? llllllllllllllIlllIlIllIIlIlIlIl : (llllllllllllllIlllIlIllIIlIlIlIl + llllllllllllllIlllIlIllIIlIlIIIl - llllllllllllllIlllIlIllIIlIlIIll);
    }
    
    public static double atan2(double llllllllllllllIlllIlIlIlllIlIllI, double llllllllllllllIlllIlIlIlllIlIlIl) {
        final double llllllllllllllIlllIlIlIllllIIlII = llllllllllllllIlllIlIlIlllIlIlIl * llllllllllllllIlllIlIlIlllIlIlIl + llllllllllllllIlllIlIlIlllIlIllI * llllllllllllllIlllIlIlIlllIlIllI;
        if (Double.isNaN(llllllllllllllIlllIlIlIllllIIlII)) {
            return Double.NaN;
        }
        final boolean llllllllllllllIlllIlIlIllllIIIll = llllllllllllllIlllIlIlIlllIlIllI < 0.0;
        if (llllllllllllllIlllIlIlIllllIIIll) {
            llllllllllllllIlllIlIlIlllIlIllI = -llllllllllllllIlllIlIlIlllIlIllI;
        }
        final boolean llllllllllllllIlllIlIlIllllIIIlI = llllllllllllllIlllIlIlIlllIlIlIl < 0.0;
        if (llllllllllllllIlllIlIlIllllIIIlI) {
            llllllllllllllIlllIlIlIlllIlIlIl = -llllllllllllllIlllIlIlIlllIlIlIl;
        }
        final boolean llllllllllllllIlllIlIlIllllIIIIl = llllllllllllllIlllIlIlIlllIlIllI > llllllllllllllIlllIlIlIlllIlIlIl;
        if (llllllllllllllIlllIlIlIllllIIIIl) {
            final double llllllllllllllIlllIlIlIllllIIIII = llllllllllllllIlllIlIlIlllIlIlIl;
            llllllllllllllIlllIlIlIlllIlIlIl = llllllllllllllIlllIlIlIlllIlIllI;
            llllllllllllllIlllIlIlIlllIlIllI = llllllllllllllIlllIlIlIllllIIIII;
        }
        final double llllllllllllllIlllIlIlIlllIlllll = fastInvSqrt(llllllllllllllIlllIlIlIllllIIlII);
        llllllllllllllIlllIlIlIlllIlIlIl *= llllllllllllllIlllIlIlIlllIlllll;
        llllllllllllllIlllIlIlIlllIlIllI *= llllllllllllllIlllIlIlIlllIlllll;
        final double llllllllllllllIlllIlIlIlllIllllI = MathHelper.FRAC_BIAS + llllllllllllllIlllIlIlIlllIlIllI;
        final int llllllllllllllIlllIlIlIlllIlllIl = (int)Double.doubleToRawLongBits(llllllllllllllIlllIlIlIlllIllllI);
        final double llllllllllllllIlllIlIlIlllIlllII = MathHelper.ASINE_TAB[llllllllllllllIlllIlIlIlllIlllIl];
        final double llllllllllllllIlllIlIlIlllIllIll = MathHelper.COS_TAB[llllllllllllllIlllIlIlIlllIlllIl];
        final double llllllllllllllIlllIlIlIlllIllIlI = llllllllllllllIlllIlIlIlllIllllI - MathHelper.FRAC_BIAS;
        final double llllllllllllllIlllIlIlIlllIllIIl = llllllllllllllIlllIlIlIlllIlIllI * llllllllllllllIlllIlIlIlllIllIll - llllllllllllllIlllIlIlIlllIlIlIl * llllllllllllllIlllIlIlIlllIllIlI;
        final double llllllllllllllIlllIlIlIlllIllIII = (6.0 + llllllllllllllIlllIlIlIlllIllIIl * llllllllllllllIlllIlIlIlllIllIIl) * llllllllllllllIlllIlIlIlllIllIIl * 0.16666666666666666;
        double llllllllllllllIlllIlIlIlllIlIlll = llllllllllllllIlllIlIlIlllIlllII + llllllllllllllIlllIlIlIlllIllIII;
        if (llllllllllllllIlllIlIlIllllIIIIl) {
            llllllllllllllIlllIlIlIlllIlIlll = 1.5707963267948966 - llllllllllllllIlllIlIlIlllIlIlll;
        }
        if (llllllllllllllIlllIlIlIllllIIIlI) {
            llllllllllllllIlllIlIlIlllIlIlll = 3.141592653589793 - llllllllllllllIlllIlIlIlllIlIlll;
        }
        if (llllllllllllllIlllIlIlIllllIIIll) {
            llllllllllllllIlllIlIlIlllIlIlll = -llllllllllllllIlllIlIlIlllIlIlll;
        }
        return llllllllllllllIlllIlIlIlllIlIlll;
    }
    
    public static double absMax(double llllllllllllllIlllIlIllIlllIIIII, double llllllllllllllIlllIlIllIllIlllIl) {
        if (llllllllllllllIlllIlIllIlllIIIII < 0.0) {
            llllllllllllllIlllIlIllIlllIIIII = -llllllllllllllIlllIlIllIlllIIIII;
        }
        if (llllllllllllllIlllIlIllIllIlllIl < 0.0) {
            llllllllllllllIlllIlIllIllIlllIl = -llllllllllllllIlllIlIllIllIlllIl;
        }
        return (llllllllllllllIlllIlIllIlllIIIII > llllllllllllllIlllIlIllIllIlllIl) ? llllllllllllllIlllIlIllIlllIIIII : llllllllllllllIlllIlIllIllIlllIl;
    }
    
    public static long lFloor(final double llllllllllllllIlllIlIlllIIIlllIl) {
        final long llllllllllllllIlllIlIlllIIIllllI = (long)llllllllllllllIlllIlIlllIIIlllIl;
        return (llllllllllllllIlllIlIlllIIIlllIl < llllllllllllllIlllIlIlllIIIllllI) ? (llllllllllllllIlllIlIlllIIIllllI - 1L) : llllllllllllllIlllIlIlllIIIllllI;
    }
    
    public static int clampAngle(int llllllllllllllIlllIlIllIlIIIllII) {
        llllllllllllllIlllIlIllIlIIIllII %= 360;
        if (llllllllllllllIlllIlIllIlIIIllII >= 180) {
            llllllllllllllIlllIlIllIlIIIllII -= 360;
        }
        if (llllllllllllllIlllIlIllIlIIIllII < -180) {
            llllllllllllllIlllIlIllIlIIIllII += 360;
        }
        return llllllllllllllIlllIlIllIlIIIllII;
    }
    
    public static double getDouble(final String llllllllllllllIlllIlIllIIllIlIlI, final double llllllllllllllIlllIlIllIIllIllII, final double llllllllllllllIlllIlIllIIllIlIll) {
        return Math.max(llllllllllllllIlllIlIllIIllIlIll, getDouble(llllllllllllllIlllIlIllIIllIlIlI, llllllllllllllIlllIlIllIIllIllII));
    }
    
    public static double frac(final double llllllllllllllIlllIlIllIIIIlIlll) {
        return llllllllllllllIlllIlIllIIIIlIlll - Math.floor(llllllllllllllIlllIlIllIIIIlIlll);
    }
    
    public static int clamp(final int llllllllllllllIlllIlIlllIIIIIIII, final int llllllllllllllIlllIlIlllIIIIIIlI, final int llllllllllllllIlllIlIllIlllllllI) {
        if (llllllllllllllIlllIlIlllIIIIIIII < llllllllllllllIlllIlIlllIIIIIIlI) {
            return llllllllllllllIlllIlIlllIIIIIIlI;
        }
        return (llllllllllllllIlllIlIlllIIIIIIII > llllllllllllllIlllIlIllIlllllllI) ? llllllllllllllIlllIlIllIlllllllI : llllllllllllllIlllIlIlllIIIIIIII;
    }
    
    public static int hsvToRGB(final float llllllllllllllIlllIlIlIllIIlIIII, final float llllllllllllllIlllIlIlIllIIIllll, final float llllllllllllllIlllIlIlIllIlIlllI) {
        final int llllllllllllllIlllIlIlIllIlIllIl = (int)(llllllllllllllIlllIlIlIllIIlIIII * 6.0f) % 6;
        final float llllllllllllllIlllIlIlIllIlIllII = llllllllllllllIlllIlIlIllIIlIIII * 6.0f - llllllllllllllIlllIlIlIllIlIllIl;
        final float llllllllllllllIlllIlIlIllIlIlIll = llllllllllllllIlllIlIlIllIlIlllI * (1.0f - llllllllllllllIlllIlIlIllIIIllll);
        final float llllllllllllllIlllIlIlIllIlIlIlI = llllllllllllllIlllIlIlIllIlIlllI * (1.0f - llllllllllllllIlllIlIlIllIlIllII * llllllllllllllIlllIlIlIllIIIllll);
        final float llllllllllllllIlllIlIlIllIlIlIIl = llllllllllllllIlllIlIlIllIlIlllI * (1.0f - (1.0f - llllllllllllllIlllIlIlIllIlIllII) * llllllllllllllIlllIlIlIllIIIllll);
        switch (llllllllllllllIlllIlIlIllIlIllIl) {
            case 0: {
                final float llllllllllllllIlllIlIlIllIlIlIII = llllllllllllllIlllIlIlIllIlIlllI;
                final float llllllllllllllIlllIlIlIllIlIIIIl = llllllllllllllIlllIlIlIllIlIlIIl;
                final float llllllllllllllIlllIlIlIllIIllIlI = llllllllllllllIlllIlIlIllIlIlIll;
                break;
            }
            case 1: {
                final float llllllllllllllIlllIlIlIllIlIIlll = llllllllllllllIlllIlIlIllIlIlIlI;
                final float llllllllllllllIlllIlIlIllIlIIIII = llllllllllllllIlllIlIlIllIlIlllI;
                final float llllllllllllllIlllIlIlIllIIllIIl = llllllllllllllIlllIlIlIllIlIlIll;
                break;
            }
            case 2: {
                final float llllllllllllllIlllIlIlIllIlIIllI = llllllllllllllIlllIlIlIllIlIlIll;
                final float llllllllllllllIlllIlIlIllIIlllll = llllllllllllllIlllIlIlIllIlIlllI;
                final float llllllllllllllIlllIlIlIllIIllIII = llllllllllllllIlllIlIlIllIlIlIIl;
                break;
            }
            case 3: {
                final float llllllllllllllIlllIlIlIllIlIIlIl = llllllllllllllIlllIlIlIllIlIlIll;
                final float llllllllllllllIlllIlIlIllIIllllI = llllllllllllllIlllIlIlIllIlIlIlI;
                final float llllllllllllllIlllIlIlIllIIlIlll = llllllllllllllIlllIlIlIllIlIlllI;
                break;
            }
            case 4: {
                final float llllllllllllllIlllIlIlIllIlIIlII = llllllllllllllIlllIlIlIllIlIlIIl;
                final float llllllllllllllIlllIlIlIllIIlllIl = llllllllllllllIlllIlIlIllIlIlIll;
                final float llllllllllllllIlllIlIlIllIIlIllI = llllllllllllllIlllIlIlIllIlIlllI;
                break;
            }
            case 5: {
                final float llllllllllllllIlllIlIlIllIlIIIll = llllllllllllllIlllIlIlIllIlIlllI;
                final float llllllllllllllIlllIlIlIllIIlllII = llllllllllllllIlllIlIlIllIlIlIll;
                final float llllllllllllllIlllIlIlIllIIlIlIl = llllllllllllllIlllIlIlIllIlIlIlI;
                break;
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder("Something went wrong when converting from HSV to RGB. Input was ").append(llllllllllllllIlllIlIlIllIIlIIII).append(", ").append(llllllllllllllIlllIlIlIllIIIllll).append(", ").append(llllllllllllllIlllIlIlIllIlIlllI)));
            }
        }
        final float llllllllllllllIlllIlIlIllIlIIIlI;
        final int llllllllllllllIlllIlIlIllIIlIIll = clamp((int)(llllllllllllllIlllIlIlIllIlIIIlI * 255.0f), 0, 255);
        final float llllllllllllllIlllIlIlIllIIllIll;
        final int llllllllllllllIlllIlIlIllIIlIIlI = clamp((int)(llllllllllllllIlllIlIlIllIIllIll * 255.0f), 0, 255);
        final float llllllllllllllIlllIlIlIllIIlIlII;
        final int llllllllllllllIlllIlIlIllIIlIIIl = clamp((int)(llllllllllllllIlllIlIlIllIIlIlII * 255.0f), 0, 255);
        return llllllllllllllIlllIlIlIllIIlIIll << 16 | llllllllllllllIlllIlIlIllIIlIIlI << 8 | llllllllllllllIlllIlIlIllIIlIIIl;
    }
    
    public static double nextDouble(final Random llllllllllllllIlllIlIllIlIlllllI, final double llllllllllllllIlllIlIllIlIllllIl, final double llllllllllllllIlllIlIllIlIllllII) {
        return (llllllllllllllIlllIlIllIlIllllIl >= llllllllllllllIlllIlIllIlIllllII) ? llllllllllllllIlllIlIllIlIllllIl : (llllllllllllllIlllIlIllIlIlllllI.nextDouble() * (llllllllllllllIlllIlIllIlIllllII - llllllllllllllIlllIlIllIlIllllIl) + llllllllllllllIlllIlIllIlIllllIl);
    }
    
    public static double getDouble(final String llllllllllllllIlllIlIllIIlllIIll, final double llllllllllllllIlllIlIllIIlllIlIl) {
        try {
            return Double.parseDouble(llllllllllllllIlllIlIllIIlllIIll);
        }
        catch (Throwable llllllllllllllIlllIlIllIIlllIlII) {
            return llllllllllllllIlllIlIllIIlllIlIl;
        }
    }
    
    public static int hash(int llllllllllllllIlllIlIlIllIIIIIII) {
        llllllllllllllIlllIlIlIllIIIIIII ^= llllllllllllllIlllIlIlIllIIIIIII >>> 16;
        llllllllllllllIlllIlIlIllIIIIIII *= -2048144789;
        llllllllllllllIlllIlIlIllIIIIIII ^= llllllllllllllIlllIlIlIllIIIIIII >>> 13;
        llllllllllllllIlllIlIlIllIIIIIII *= -1028477387;
        llllllllllllllIlllIlIlIllIIIIIII ^= llllllllllllllIlllIlIlIllIIIIIII >>> 16;
        return llllllllllllllIlllIlIlIllIIIIIII;
    }
    
    public static int rgb(final int llllllllllllllIlllIlIllIIlIIIIlI, final int llllllllllllllIlllIlIllIIIllllIl, final int llllllllllllllIlllIlIllIIlIIIIII) {
        int llllllllllllllIlllIlIllIIIllllll = (llllllllllllllIlllIlIllIIlIIIIlI << 8) + llllllllllllllIlllIlIllIIIllllIl;
        llllllllllllllIlllIlIllIIIllllll = (llllllllllllllIlllIlIllIIIllllll << 8) + llllllllllllllIlllIlIllIIlIIIIII;
        return llllllllllllllIlllIlIllIIIllllll;
    }
    
    public static int getInt(final String llllllllllllllIlllIlIllIlIIIlIII, final int llllllllllllllIlllIlIllIlIIIIlll) {
        try {
            return Integer.parseInt(llllllllllllllIlllIlIllIlIIIlIII);
        }
        catch (Throwable llllllllllllllIlllIlIllIlIIIIllI) {
            return llllllllllllllIlllIlIllIlIIIIlll;
        }
    }
    
    public static float clamp(final float llllllllllllllIlllIlIllIllllIlll, final float llllllllllllllIlllIlIllIllllIllI, final float llllllllllllllIlllIlIllIllllIlIl) {
        if (llllllllllllllIlllIlIllIllllIlll < llllllllllllllIlllIlIllIllllIllI) {
            return llllllllllllllIlllIlIllIllllIllI;
        }
        return (llllllllllllllIlllIlIllIllllIlll > llllllllllllllIlllIlIllIllllIlIl) ? llllllllllllllIlllIlIllIllllIlIl : llllllllllllllIlllIlIllIllllIlll;
    }
    
    public static double average(final long[] llllllllllllllIlllIlIllIlIllIIlI) {
        long llllllllllllllIlllIlIllIlIllIlII = 0L;
        final boolean llllllllllllllIlllIlIllIlIlIllIl = (Object)llllllllllllllIlllIlIllIlIllIIlI;
        final double llllllllllllllIlllIlIllIlIlIlllI = llllllllllllllIlllIlIllIlIllIIlI.length;
        for (String llllllllllllllIlllIlIllIlIlIllll = (String)0; llllllllllllllIlllIlIllIlIlIllll < llllllllllllllIlllIlIllIlIlIlllI; ++llllllllllllllIlllIlIllIlIlIllll) {
            final long llllllllllllllIlllIlIllIlIllIIll = llllllllllllllIlllIlIllIlIlIllIl[llllllllllllllIlllIlIllIlIlIllll];
            llllllllllllllIlllIlIllIlIllIlII += llllllllllllllIlllIlIllIlIllIIll;
        }
        return llllllllllllllIlllIlIllIlIllIlII / (double)llllllllllllllIlllIlIllIlIllIIlI.length;
    }
    
    public static int fastFloor(final double llllllllllllllIlllIlIlllIIlIlIII) {
        return (int)(llllllllllllllIlllIlIlllIIlIlIII + 1024.0) - 1024;
    }
}
