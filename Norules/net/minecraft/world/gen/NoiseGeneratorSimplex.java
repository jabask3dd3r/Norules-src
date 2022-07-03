package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorSimplex
{
    private static final /* synthetic */ int[][] grad3;
    private static final /* synthetic */ double F2;
    public /* synthetic */ double yo;
    private static final /* synthetic */ double G2;
    public /* synthetic */ double xo;
    private final /* synthetic */ int[] p;
    public static final /* synthetic */ double SQRT_3;
    public /* synthetic */ double zo;
    
    public void add(final double[] lllllllllllllIlIlllllIlIlllIlIII, final double lllllllllllllIlIlllllIlIlllIIlll, final double lllllllllllllIlIlllllIlIlllIIllI, final int lllllllllllllIlIlllllIllIIIlIIlI, final int lllllllllllllIlIlllllIlIlllIIlII, final double lllllllllllllIlIlllllIllIIIlIIII, final double lllllllllllllIlIlllllIllIIIIllll, final double lllllllllllllIlIlllllIllIIIIlllI) {
        int lllllllllllllIlIlllllIllIIIIllIl = 0;
        for (int lllllllllllllIlIlllllIllIIIIllII = 0; lllllllllllllIlIlllllIllIIIIllII < lllllllllllllIlIlllllIlIlllIIlII; ++lllllllllllllIlIlllllIllIIIIllII) {
            final double lllllllllllllIlIlllllIllIIIIlIll = (lllllllllllllIlIlllllIlIlllIIllI + lllllllllllllIlIlllllIllIIIIllII) * lllllllllllllIlIlllllIllIIIIllll + this.yo;
            for (int lllllllllllllIlIlllllIllIIIIlIlI = 0; lllllllllllllIlIlllllIllIIIIlIlI < lllllllllllllIlIlllllIllIIIlIIlI; ++lllllllllllllIlIlllllIllIIIIlIlI) {
                final double lllllllllllllIlIlllllIllIIIIlIIl = (lllllllllllllIlIlllllIlIlllIIlll + lllllllllllllIlIlllllIllIIIIlIlI) * lllllllllllllIlIlllllIllIIIlIIII + this.xo;
                final double lllllllllllllIlIlllllIllIIIIlIII = (lllllllllllllIlIlllllIllIIIIlIIl + lllllllllllllIlIlllllIllIIIIlIll) * NoiseGeneratorSimplex.F2;
                final int lllllllllllllIlIlllllIllIIIIIlll = fastFloor(lllllllllllllIlIlllllIllIIIIlIIl + lllllllllllllIlIlllllIllIIIIlIII);
                final int lllllllllllllIlIlllllIllIIIIIllI = fastFloor(lllllllllllllIlIlllllIllIIIIlIll + lllllllllllllIlIlllllIllIIIIlIII);
                final double lllllllllllllIlIlllllIllIIIIIlIl = (lllllllllllllIlIlllllIllIIIIIlll + lllllllllllllIlIlllllIllIIIIIllI) * NoiseGeneratorSimplex.G2;
                final double lllllllllllllIlIlllllIllIIIIIlII = lllllllllllllIlIlllllIllIIIIIlll - lllllllllllllIlIlllllIllIIIIIlIl;
                final double lllllllllllllIlIlllllIllIIIIIIll = lllllllllllllIlIlllllIllIIIIIllI - lllllllllllllIlIlllllIllIIIIIlIl;
                final double lllllllllllllIlIlllllIllIIIIIIlI = lllllllllllllIlIlllllIllIIIIlIIl - lllllllllllllIlIlllllIllIIIIIlII;
                final double lllllllllllllIlIlllllIllIIIIIIIl = lllllllllllllIlIlllllIllIIIIlIll - lllllllllllllIlIlllllIllIIIIIIll;
                int lllllllllllllIlIlllllIlIllllllll = 0;
                int lllllllllllllIlIlllllIlIllllllIl = 0;
                if (lllllllllllllIlIlllllIllIIIIIIlI > lllllllllllllIlIlllllIllIIIIIIIl) {
                    final int lllllllllllllIlIlllllIllIIIIIIII = 1;
                    final int lllllllllllllIlIlllllIlIlllllllI = 0;
                }
                else {
                    lllllllllllllIlIlllllIlIllllllll = 0;
                    lllllllllllllIlIlllllIlIllllllIl = 1;
                }
                final double lllllllllllllIlIlllllIlIllllllII = lllllllllllllIlIlllllIllIIIIIIlI - lllllllllllllIlIlllllIlIllllllll + NoiseGeneratorSimplex.G2;
                final double lllllllllllllIlIlllllIlIlllllIll = lllllllllllllIlIlllllIllIIIIIIIl - lllllllllllllIlIlllllIlIllllllIl + NoiseGeneratorSimplex.G2;
                final double lllllllllllllIlIlllllIlIlllllIlI = lllllllllllllIlIlllllIllIIIIIIlI - 1.0 + 2.0 * NoiseGeneratorSimplex.G2;
                final double lllllllllllllIlIlllllIlIlllllIIl = lllllllllllllIlIlllllIllIIIIIIIl - 1.0 + 2.0 * NoiseGeneratorSimplex.G2;
                final int lllllllllllllIlIlllllIlIlllllIII = lllllllllllllIlIlllllIllIIIIIlll & 0xFF;
                final int lllllllllllllIlIlllllIlIllllIlll = lllllllllllllIlIlllllIllIIIIIllI & 0xFF;
                final int lllllllllllllIlIlllllIlIllllIllI = this.p[lllllllllllllIlIlllllIlIlllllIII + this.p[lllllllllllllIlIlllllIlIllllIlll]] % 12;
                final int lllllllllllllIlIlllllIlIllllIlIl = this.p[lllllllllllllIlIlllllIlIlllllIII + lllllllllllllIlIlllllIlIllllllll + this.p[lllllllllllllIlIlllllIlIllllIlll + lllllllllllllIlIlllllIlIllllllIl]] % 12;
                final int lllllllllllllIlIlllllIlIllllIlII = this.p[lllllllllllllIlIlllllIlIlllllIII + 1 + this.p[lllllllllllllIlIlllllIlIllllIlll + 1]] % 12;
                double lllllllllllllIlIlllllIlIllllIIll = 0.5 - lllllllllllllIlIlllllIllIIIIIIlI * lllllllllllllIlIlllllIllIIIIIIlI - lllllllllllllIlIlllllIllIIIIIIIl * lllllllllllllIlIlllllIllIIIIIIIl;
                double lllllllllllllIlIlllllIlIllllIIIl = 0.0;
                if (lllllllllllllIlIlllllIlIllllIIll < 0.0) {
                    final double lllllllllllllIlIlllllIlIllllIIlI = 0.0;
                }
                else {
                    lllllllllllllIlIlllllIlIllllIIll *= lllllllllllllIlIlllllIlIllllIIll;
                    lllllllllllllIlIlllllIlIllllIIIl = lllllllllllllIlIlllllIlIllllIIll * lllllllllllllIlIlllllIlIllllIIll * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIlIllllIllI], lllllllllllllIlIlllllIllIIIIIIlI, lllllllllllllIlIlllllIllIIIIIIIl);
                }
                double lllllllllllllIlIlllllIlIllllIIII = 0.5 - lllllllllllllIlIlllllIlIllllllII * lllllllllllllIlIlllllIlIllllllII - lllllllllllllIlIlllllIlIlllllIll * lllllllllllllIlIlllllIlIlllllIll;
                double lllllllllllllIlIlllllIlIlllIlllI = 0.0;
                if (lllllllllllllIlIlllllIlIllllIIII < 0.0) {
                    final double lllllllllllllIlIlllllIlIlllIllll = 0.0;
                }
                else {
                    lllllllllllllIlIlllllIlIllllIIII *= lllllllllllllIlIlllllIlIllllIIII;
                    lllllllllllllIlIlllllIlIlllIlllI = lllllllllllllIlIlllllIlIllllIIII * lllllllllllllIlIlllllIlIllllIIII * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIlIllllIlIl], lllllllllllllIlIlllllIlIllllllII, lllllllllllllIlIlllllIlIlllllIll);
                }
                double lllllllllllllIlIlllllIlIlllIllIl = 0.5 - lllllllllllllIlIlllllIlIlllllIlI * lllllllllllllIlIlllllIlIlllllIlI - lllllllllllllIlIlllllIlIlllllIIl * lllllllllllllIlIlllllIlIlllllIIl;
                double lllllllllllllIlIlllllIlIlllIlIll = 0.0;
                if (lllllllllllllIlIlllllIlIlllIllIl < 0.0) {
                    final double lllllllllllllIlIlllllIlIlllIllII = 0.0;
                }
                else {
                    lllllllllllllIlIlllllIlIlllIllIl *= lllllllllllllIlIlllllIlIlllIllIl;
                    lllllllllllllIlIlllllIlIlllIlIll = lllllllllllllIlIlllllIlIlllIllIl * lllllllllllllIlIlllllIlIlllIllIl * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIlIllllIlII], lllllllllllllIlIlllllIlIlllllIlI, lllllllllllllIlIlllllIlIlllllIIl);
                }
                final int n;
                final int lllllllllllllIlIlllllIlIlllIlIlI = n = lllllllllllllIlIlllllIllIIIIllIl++;
                lllllllllllllIlIlllllIlIlllIlIII[n] += 70.0 * (lllllllllllllIlIlllllIlIllllIIIl + lllllllllllllIlIlllllIlIlllIlllI + lllllllllllllIlIlllllIlIlllIlIll) * lllllllllllllIlIlllllIllIIIIlllI;
            }
        }
    }
    
    public NoiseGeneratorSimplex() {
        this(new Random());
    }
    
    static {
        grad3 = new int[][] { { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 }, { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 }, { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 } };
        SQRT_3 = Math.sqrt(3.0);
        F2 = 0.5 * (NoiseGeneratorSimplex.SQRT_3 - 1.0);
        G2 = (3.0 - NoiseGeneratorSimplex.SQRT_3) / 6.0;
    }
    
    private static int fastFloor(final double lllllllllllllIlIlllllIlllIlIlIII) {
        return (lllllllllllllIlIlllllIlllIlIlIII > 0.0) ? ((int)lllllllllllllIlIlllllIlllIlIlIII) : ((int)lllllllllllllIlIlllllIlllIlIlIII - 1);
    }
    
    public double getValue(final double lllllllllllllIlIlllllIllIlIllIll, final double lllllllllllllIlIlllllIllIlllllIl) {
        final double lllllllllllllIlIlllllIllIlllllII = 0.5 * (NoiseGeneratorSimplex.SQRT_3 - 1.0);
        final double lllllllllllllIlIlllllIllIllllIll = (lllllllllllllIlIlllllIllIlIllIll + lllllllllllllIlIlllllIllIlllllIl) * lllllllllllllIlIlllllIllIlllllII;
        final int lllllllllllllIlIlllllIllIllllIlI = fastFloor(lllllllllllllIlIlllllIllIlIllIll + lllllllllllllIlIlllllIllIllllIll);
        final int lllllllllllllIlIlllllIllIllllIIl = fastFloor(lllllllllllllIlIlllllIllIlllllIl + lllllllllllllIlIlllllIllIllllIll);
        final double lllllllllllllIlIlllllIllIllllIII = (3.0 - NoiseGeneratorSimplex.SQRT_3) / 6.0;
        final double lllllllllllllIlIlllllIllIlllIlll = (lllllllllllllIlIlllllIllIllllIlI + lllllllllllllIlIlllllIllIllllIIl) * lllllllllllllIlIlllllIllIllllIII;
        final double lllllllllllllIlIlllllIllIlllIllI = lllllllllllllIlIlllllIllIllllIlI - lllllllllllllIlIlllllIllIlllIlll;
        final double lllllllllllllIlIlllllIllIlllIlIl = lllllllllllllIlIlllllIllIllllIIl - lllllllllllllIlIlllllIllIlllIlll;
        final double lllllllllllllIlIlllllIllIlllIlII = lllllllllllllIlIlllllIllIlIllIll - lllllllllllllIlIlllllIllIlllIllI;
        final double lllllllllllllIlIlllllIllIlllIIll = lllllllllllllIlIlllllIllIlllllIl - lllllllllllllIlIlllllIllIlllIlIl;
        int lllllllllllllIlIlllllIllIlllIIIl = 0;
        int lllllllllllllIlIlllllIllIllIllll = 0;
        if (lllllllllllllIlIlllllIllIlllIlII > lllllllllllllIlIlllllIllIlllIIll) {
            final int lllllllllllllIlIlllllIllIlllIIlI = 1;
            final int lllllllllllllIlIlllllIllIlllIIII = 0;
        }
        else {
            lllllllllllllIlIlllllIllIlllIIIl = 0;
            lllllllllllllIlIlllllIllIllIllll = 1;
        }
        final double lllllllllllllIlIlllllIllIllIlllI = lllllllllllllIlIlllllIllIlllIlII - lllllllllllllIlIlllllIllIlllIIIl + lllllllllllllIlIlllllIllIllllIII;
        final double lllllllllllllIlIlllllIllIllIllIl = lllllllllllllIlIlllllIllIlllIIll - lllllllllllllIlIlllllIllIllIllll + lllllllllllllIlIlllllIllIllllIII;
        final double lllllllllllllIlIlllllIllIllIllII = lllllllllllllIlIlllllIllIlllIlII - 1.0 + 2.0 * lllllllllllllIlIlllllIllIllllIII;
        final double lllllllllllllIlIlllllIllIllIlIll = lllllllllllllIlIlllllIllIlllIIll - 1.0 + 2.0 * lllllllllllllIlIlllllIllIllllIII;
        final int lllllllllllllIlIlllllIllIllIlIlI = lllllllllllllIlIlllllIllIllllIlI & 0xFF;
        final int lllllllllllllIlIlllllIllIllIlIIl = lllllllllllllIlIlllllIllIllllIIl & 0xFF;
        final int lllllllllllllIlIlllllIllIllIlIII = this.p[lllllllllllllIlIlllllIllIllIlIlI + this.p[lllllllllllllIlIlllllIllIllIlIIl]] % 12;
        final int lllllllllllllIlIlllllIllIllIIlll = this.p[lllllllllllllIlIlllllIllIllIlIlI + lllllllllllllIlIlllllIllIlllIIIl + this.p[lllllllllllllIlIlllllIllIllIlIIl + lllllllllllllIlIlllllIllIllIllll]] % 12;
        final int lllllllllllllIlIlllllIllIllIIllI = this.p[lllllllllllllIlIlllllIllIllIlIlI + 1 + this.p[lllllllllllllIlIlllllIllIllIlIIl + 1]] % 12;
        double lllllllllllllIlIlllllIllIllIIlIl = 0.5 - lllllllllllllIlIlllllIllIlllIlII * lllllllllllllIlIlllllIllIlllIlII - lllllllllllllIlIlllllIllIlllIIll * lllllllllllllIlIlllllIllIlllIIll;
        double lllllllllllllIlIlllllIllIllIIIll = 0.0;
        if (lllllllllllllIlIlllllIllIllIIlIl < 0.0) {
            final double lllllllllllllIlIlllllIllIllIIlII = 0.0;
        }
        else {
            lllllllllllllIlIlllllIllIllIIlIl *= lllllllllllllIlIlllllIllIllIIlIl;
            lllllllllllllIlIlllllIllIllIIIll = lllllllllllllIlIlllllIllIllIIlIl * lllllllllllllIlIlllllIllIllIIlIl * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIllIllIlIII], lllllllllllllIlIlllllIllIlllIlII, lllllllllllllIlIlllllIllIlllIIll);
        }
        double lllllllllllllIlIlllllIllIllIIIlI = 0.5 - lllllllllllllIlIlllllIllIllIlllI * lllllllllllllIlIlllllIllIllIlllI - lllllllllllllIlIlllllIllIllIllIl * lllllllllllllIlIlllllIllIllIllIl;
        double lllllllllllllIlIlllllIllIllIIIII = 0.0;
        if (lllllllllllllIlIlllllIllIllIIIlI < 0.0) {
            final double lllllllllllllIlIlllllIllIllIIIIl = 0.0;
        }
        else {
            lllllllllllllIlIlllllIllIllIIIlI *= lllllllllllllIlIlllllIllIllIIIlI;
            lllllllllllllIlIlllllIllIllIIIII = lllllllllllllIlIlllllIllIllIIIlI * lllllllllllllIlIlllllIllIllIIIlI * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIllIllIIlll], lllllllllllllIlIlllllIllIllIlllI, lllllllllllllIlIlllllIllIllIllIl);
        }
        double lllllllllllllIlIlllllIllIlIlllll = 0.5 - lllllllllllllIlIlllllIllIllIllII * lllllllllllllIlIlllllIllIllIllII - lllllllllllllIlIlllllIllIllIlIll * lllllllllllllIlIlllllIllIllIlIll;
        double lllllllllllllIlIlllllIllIlIlllIl = 0.0;
        if (lllllllllllllIlIlllllIllIlIlllll < 0.0) {
            final double lllllllllllllIlIlllllIllIlIllllI = 0.0;
        }
        else {
            lllllllllllllIlIlllllIllIlIlllll *= lllllllllllllIlIlllllIllIlIlllll;
            lllllllllllllIlIlllllIllIlIlllIl = lllllllllllllIlIlllllIllIlIlllll * lllllllllllllIlIlllllIllIlIlllll * dot(NoiseGeneratorSimplex.grad3[lllllllllllllIlIlllllIllIllIIllI], lllllllllllllIlIlllllIllIllIllII, lllllllllllllIlIlllllIllIllIlIll);
        }
        return 70.0 * (lllllllllllllIlIlllllIllIllIIIll + lllllllllllllIlIlllllIllIllIIIII + lllllllllllllIlIlllllIllIlIlllIl);
    }
    
    public NoiseGeneratorSimplex(final Random lllllllllllllIlIlllllIlllIllIIll) {
        this.p = new int[512];
        this.xo = lllllllllllllIlIlllllIlllIllIIll.nextDouble() * 256.0;
        this.yo = lllllllllllllIlIlllllIlllIllIIll.nextDouble() * 256.0;
        this.zo = lllllllllllllIlIlllllIlllIllIIll.nextDouble() * 256.0;
        for (int lllllllllllllIlIlllllIlllIllIIlI = 0; lllllllllllllIlIlllllIlllIllIIlI < 256; this.p[lllllllllllllIlIlllllIlllIllIIlI] = lllllllllllllIlIlllllIlllIllIIlI++) {}
        for (int lllllllllllllIlIlllllIlllIllIIIl = 0; lllllllllllllIlIlllllIlllIllIIIl < 256; ++lllllllllllllIlIlllllIlllIllIIIl) {
            final int lllllllllllllIlIlllllIlllIllIIII = lllllllllllllIlIlllllIlllIllIIll.nextInt(256 - lllllllllllllIlIlllllIlllIllIIIl) + lllllllllllllIlIlllllIlllIllIIIl;
            final int lllllllllllllIlIlllllIlllIlIllll = this.p[lllllllllllllIlIlllllIlllIllIIIl];
            this.p[lllllllllllllIlIlllllIlllIllIIIl] = this.p[lllllllllllllIlIlllllIlllIllIIII];
            this.p[lllllllllllllIlIlllllIlllIllIIII] = lllllllllllllIlIlllllIlllIlIllll;
            this.p[lllllllllllllIlIlllllIlllIllIIIl + 256] = this.p[lllllllllllllIlIlllllIlllIllIIIl];
        }
    }
    
    private static double dot(final int[] lllllllllllllIlIlllllIlllIlIIIII, final double lllllllllllllIlIlllllIlllIIlllll, final double lllllllllllllIlIlllllIlllIIllllI) {
        return lllllllllllllIlIlllllIlllIlIIIII[0] * lllllllllllllIlIlllllIlllIIlllll + lllllllllllllIlIlllllIlllIlIIIII[1] * lllllllllllllIlIlllllIlllIIllllI;
    }
}
