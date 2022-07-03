package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorImproved extends NoiseGenerator
{
    public /* synthetic */ double xCoord;
    private static final /* synthetic */ double[] GRAD_2Z;
    public /* synthetic */ double zCoord;
    private final /* synthetic */ int[] permutations;
    private static final /* synthetic */ double[] GRAD_Z;
    private static final /* synthetic */ double[] GRAD_Y;
    public /* synthetic */ double yCoord;
    private static final /* synthetic */ double[] GRAD_2X;
    private static final /* synthetic */ double[] GRAD_X;
    
    public final double grad(final int lllllllllllllIllllIlIIIlIllIlllI, final double lllllllllllllIllllIlIIIlIlllIIlI, final double lllllllllllllIllllIlIIIlIllIllII, final double lllllllllllllIllllIlIIIlIllIlIll) {
        final int lllllllllllllIllllIlIIIlIllIllll = lllllllllllllIllllIlIIIlIllIlllI & 0xF;
        return NoiseGeneratorImproved.GRAD_X[lllllllllllllIllllIlIIIlIllIllll] * lllllllllllllIllllIlIIIlIlllIIlI + NoiseGeneratorImproved.GRAD_Y[lllllllllllllIllllIlIIIlIllIllll] * lllllllllllllIllllIlIIIlIllIllII + NoiseGeneratorImproved.GRAD_Z[lllllllllllllIllllIlIIIlIllIllll] * lllllllllllllIllllIlIIIlIllIlIll;
    }
    
    static {
        GRAD_X = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        GRAD_Y = new double[] { 1.0, 1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0 };
        GRAD_Z = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
        GRAD_2X = new double[] { 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0 };
        GRAD_2Z = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0 };
    }
    
    public void populateNoiseArray(final double[] lllllllllllllIllllIlIIIlIIlIIllI, final double lllllllllllllIllllIlIIIlIIlIIlII, final double lllllllllllllIllllIlIIIIllIIIlIl, final double lllllllllllllIllllIlIIIIllIIIlII, final int lllllllllllllIllllIlIIIIllIIIIll, final int lllllllllllllIllllIlIIIIllIIIIlI, final int lllllllllllllIllllIlIIIIllIIIIIl, final double lllllllllllllIllllIlIIIIllIIIIII, final double lllllllllllllIllllIlIIIIlIllllll, final double lllllllllllllIllllIlIIIIlIlllllI, final double lllllllllllllIllllIlIIIlIIIlIIll) {
        if (lllllllllllllIllllIlIIIIllIIIIlI == 1) {
            int lllllllllllllIllllIlIIIlIIIlIIlI = 0;
            int lllllllllllllIllllIlIIIlIIIlIIII = 0;
            int lllllllllllllIllllIlIIIlIIIIllll = 0;
            int lllllllllllllIllllIlIIIlIIIIlllI = 0;
            double lllllllllllllIllllIlIIIlIIIIllII = 0.0;
            double lllllllllllllIllllIlIIIlIIIIlIlI = 0.0;
            int lllllllllllllIllllIlIIIlIIIIlIII = 0;
            final double lllllllllllllIllllIlIIIlIIIIIllI = 1.0 / lllllllllllllIllllIlIIIlIIIlIIll;
            for (int lllllllllllllIllllIlIIIlIIIIIlII = 0; lllllllllllllIllllIlIIIlIIIIIlII < lllllllllllllIllllIlIIIIllIIIIll; ++lllllllllllllIllllIlIIIlIIIIIlII) {
                double lllllllllllllIllllIlIIIlIIIIIIlI = lllllllllllllIllllIlIIIlIIlIIlII + lllllllllllllIllllIlIIIlIIIIIlII * lllllllllllllIllllIlIIIIllIIIIII + this.xCoord;
                int lllllllllllllIllllIlIIIlIIIIIIII = (int)lllllllllllllIllllIlIIIlIIIIIIlI;
                if (lllllllllllllIllllIlIIIlIIIIIIlI < lllllllllllllIllllIlIIIlIIIIIIII) {
                    --lllllllllllllIllllIlIIIlIIIIIIII;
                }
                final int lllllllllllllIllllIlIIIIllllllll = lllllllllllllIllllIlIIIlIIIIIIII & 0xFF;
                lllllllllllllIllllIlIIIlIIIIIIlI -= lllllllllllllIllllIlIIIlIIIIIIII;
                final double lllllllllllllIllllIlIIIIlllllllI = lllllllllllllIllllIlIIIlIIIIIIlI * lllllllllllllIllllIlIIIlIIIIIIlI * lllllllllllllIllllIlIIIlIIIIIIlI * (lllllllllllllIllllIlIIIlIIIIIIlI * (lllllllllllllIllllIlIIIlIIIIIIlI * 6.0 - 15.0) + 10.0);
                for (int lllllllllllllIllllIlIIIIllllllIl = 0; lllllllllllllIllllIlIIIIllllllIl < lllllllllllllIllllIlIIIIllIIIIIl; ++lllllllllllllIllllIlIIIIllllllIl) {
                    double lllllllllllllIllllIlIIIIllllllII = lllllllllllllIllllIlIIIIllIIIlII + lllllllllllllIllllIlIIIIllllllIl * lllllllllllllIllllIlIIIIlIlllllI + this.zCoord;
                    int lllllllllllllIllllIlIIIIlllllIll = (int)lllllllllllllIllllIlIIIIllllllII;
                    if (lllllllllllllIllllIlIIIIllllllII < lllllllllllllIllllIlIIIIlllllIll) {
                        --lllllllllllllIllllIlIIIIlllllIll;
                    }
                    final int lllllllllllllIllllIlIIIIlllllIlI = lllllllllllllIllllIlIIIIlllllIll & 0xFF;
                    lllllllllllllIllllIlIIIIllllllII -= lllllllllllllIllllIlIIIIlllllIll;
                    final double lllllllllllllIllllIlIIIIlllllIIl = lllllllllllllIllllIlIIIIllllllII * lllllllllllllIllllIlIIIIllllllII * lllllllllllllIllllIlIIIIllllllII * (lllllllllllllIllllIlIIIIllllllII * (lllllllllllllIllllIlIIIIllllllII * 6.0 - 15.0) + 10.0);
                    lllllllllllllIllllIlIIIlIIIlIIlI = this.permutations[lllllllllllllIllllIlIIIIllllllll] + 0;
                    lllllllllllllIllllIlIIIlIIIlIIII = this.permutations[lllllllllllllIllllIlIIIlIIIlIIlI] + lllllllllllllIllllIlIIIIlllllIlI;
                    lllllllllllllIllllIlIIIlIIIIllll = this.permutations[lllllllllllllIllllIlIIIIllllllll + 1] + 0;
                    lllllllllllllIllllIlIIIlIIIIlllI = this.permutations[lllllllllllllIllllIlIIIlIIIIllll] + lllllllllllllIllllIlIIIIlllllIlI;
                    lllllllllllllIllllIlIIIlIIIIllII = this.lerp(lllllllllllllIllllIlIIIIlllllllI, this.grad2(this.permutations[lllllllllllllIllllIlIIIlIIIlIIII], lllllllllllllIllllIlIIIlIIIIIIlI, lllllllllllllIllllIlIIIIllllllII), this.grad(this.permutations[lllllllllllllIllllIlIIIlIIIIlllI], lllllllllllllIllllIlIIIlIIIIIIlI - 1.0, 0.0, lllllllllllllIllllIlIIIIllllllII));
                    lllllllllllllIllllIlIIIlIIIIlIlI = this.lerp(lllllllllllllIllllIlIIIIlllllllI, this.grad(this.permutations[lllllllllllllIllllIlIIIlIIIlIIII + 1], lllllllllllllIllllIlIIIlIIIIIIlI, 0.0, lllllllllllllIllllIlIIIIllllllII - 1.0), this.grad(this.permutations[lllllllllllllIllllIlIIIlIIIIlllI + 1], lllllllllllllIllllIlIIIlIIIIIIlI - 1.0, 0.0, lllllllllllllIllllIlIIIIllllllII - 1.0));
                    final double lllllllllllllIllllIlIIIIlllllIII = this.lerp(lllllllllllllIllllIlIIIIlllllIIl, lllllllllllllIllllIlIIIlIIIIllII, lllllllllllllIllllIlIIIlIIIIlIlI);
                    final int n;
                    final int lllllllllllllIllllIlIIIIllllIlll = n = lllllllllllllIllllIlIIIlIIIIlIII++;
                    lllllllllllllIllllIlIIIlIIlIIllI[n] += lllllllllllllIllllIlIIIIlllllIII * lllllllllllllIllllIlIIIlIIIIIllI;
                }
            }
        }
        else {
            int lllllllllllllIllllIlIIIIllllIllI = 0;
            final double lllllllllllllIllllIlIIIIllllIlII = 1.0 / lllllllllllllIllllIlIIIlIIIlIIll;
            int lllllllllllllIllllIlIIIIllllIIlI = -1;
            int lllllllllllllIllllIlIIIIllllIIII = 0;
            int lllllllllllllIllllIlIIIIlllIlllI = 0;
            int lllllllllllllIllllIlIIIIlllIllIl = 0;
            int lllllllllllllIllllIlIIIIlllIlIll = 0;
            int lllllllllllllIllllIlIIIIlllIlIIl = 0;
            int lllllllllllllIllllIlIIIIlllIIlll = 0;
            double lllllllllllllIllllIlIIIIlllIIlIl = 0.0;
            double lllllllllllllIllllIlIIIIlllIIIll = 0.0;
            double lllllllllllllIllllIlIIIIlllIIIIl = 0.0;
            double lllllllllllllIllllIlIIIIllIlllll = 0.0;
            for (int lllllllllllllIllllIlIIIIllIlllIl = 0; lllllllllllllIllllIlIIIIllIlllIl < lllllllllllllIllllIlIIIIllIIIIll; ++lllllllllllllIllllIlIIIIllIlllIl) {
                double lllllllllllllIllllIlIIIIllIllIll = lllllllllllllIllllIlIIIlIIlIIlII + lllllllllllllIllllIlIIIIllIlllIl * lllllllllllllIllllIlIIIIllIIIIII + this.xCoord;
                int lllllllllllllIllllIlIIIIllIllIlI = (int)lllllllllllllIllllIlIIIIllIllIll;
                if (lllllllllllllIllllIlIIIIllIllIll < lllllllllllllIllllIlIIIIllIllIlI) {
                    --lllllllllllllIllllIlIIIIllIllIlI;
                }
                final int lllllllllllllIllllIlIIIIllIllIIl = lllllllllllllIllllIlIIIIllIllIlI & 0xFF;
                lllllllllllllIllllIlIIIIllIllIll -= lllllllllllllIllllIlIIIIllIllIlI;
                final double lllllllllllllIllllIlIIIIllIllIII = lllllllllllllIllllIlIIIIllIllIll * lllllllllllllIllllIlIIIIllIllIll * lllllllllllllIllllIlIIIIllIllIll * (lllllllllllllIllllIlIIIIllIllIll * (lllllllllllllIllllIlIIIIllIllIll * 6.0 - 15.0) + 10.0);
                for (int lllllllllllllIllllIlIIIIllIlIlll = 0; lllllllllllllIllllIlIIIIllIlIlll < lllllllllllllIllllIlIIIIllIIIIIl; ++lllllllllllllIllllIlIIIIllIlIlll) {
                    double lllllllllllllIllllIlIIIIllIlIllI = lllllllllllllIllllIlIIIIllIIIlII + lllllllllllllIllllIlIIIIllIlIlll * lllllllllllllIllllIlIIIIlIlllllI + this.zCoord;
                    int lllllllllllllIllllIlIIIIllIlIlIl = (int)lllllllllllllIllllIlIIIIllIlIllI;
                    if (lllllllllllllIllllIlIIIIllIlIllI < lllllllllllllIllllIlIIIIllIlIlIl) {
                        --lllllllllllllIllllIlIIIIllIlIlIl;
                    }
                    final int lllllllllllllIllllIlIIIIllIlIlII = lllllllllllllIllllIlIIIIllIlIlIl & 0xFF;
                    lllllllllllllIllllIlIIIIllIlIllI -= lllllllllllllIllllIlIIIIllIlIlIl;
                    final double lllllllllllllIllllIlIIIIllIlIIll = lllllllllllllIllllIlIIIIllIlIllI * lllllllllllllIllllIlIIIIllIlIllI * lllllllllllllIllllIlIIIIllIlIllI * (lllllllllllllIllllIlIIIIllIlIllI * (lllllllllllllIllllIlIIIIllIlIllI * 6.0 - 15.0) + 10.0);
                    for (int lllllllllllllIllllIlIIIIllIlIIlI = 0; lllllllllllllIllllIlIIIIllIlIIlI < lllllllllllllIllllIlIIIIllIIIIlI; ++lllllllllllllIllllIlIIIIllIlIIlI) {
                        double lllllllllllllIllllIlIIIIllIlIIIl = lllllllllllllIllllIlIIIIllIIIlIl + lllllllllllllIllllIlIIIIllIlIIlI * lllllllllllllIllllIlIIIIlIllllll + this.yCoord;
                        int lllllllllllllIllllIlIIIIllIlIIII = (int)lllllllllllllIllllIlIIIIllIlIIIl;
                        if (lllllllllllllIllllIlIIIIllIlIIIl < lllllllllllllIllllIlIIIIllIlIIII) {
                            --lllllllllllllIllllIlIIIIllIlIIII;
                        }
                        final int lllllllllllllIllllIlIIIIllIIllll = lllllllllllllIllllIlIIIIllIlIIII & 0xFF;
                        lllllllllllllIllllIlIIIIllIlIIIl -= lllllllllllllIllllIlIIIIllIlIIII;
                        final double lllllllllllllIllllIlIIIIllIIlllI = lllllllllllllIllllIlIIIIllIlIIIl * lllllllllllllIllllIlIIIIllIlIIIl * lllllllllllllIllllIlIIIIllIlIIIl * (lllllllllllllIllllIlIIIIllIlIIIl * (lllllllllllllIllllIlIIIIllIlIIIl * 6.0 - 15.0) + 10.0);
                        if (lllllllllllllIllllIlIIIIllIlIIlI == 0 || lllllllllllllIllllIlIIIIllIIllll != lllllllllllllIllllIlIIIIllllIIlI) {
                            lllllllllllllIllllIlIIIIllllIIlI = lllllllllllllIllllIlIIIIllIIllll;
                            lllllllllllllIllllIlIIIIllllIIII = this.permutations[lllllllllllllIllllIlIIIIllIllIIl] + lllllllllllllIllllIlIIIIllIIllll;
                            lllllllllllllIllllIlIIIIlllIlllI = this.permutations[lllllllllllllIllllIlIIIIllllIIII] + lllllllllllllIllllIlIIIIllIlIlII;
                            lllllllllllllIllllIlIIIIlllIllIl = this.permutations[lllllllllllllIllllIlIIIIllllIIII + 1] + lllllllllllllIllllIlIIIIllIlIlII;
                            lllllllllllllIllllIlIIIIlllIlIll = this.permutations[lllllllllllllIllllIlIIIIllIllIIl + 1] + lllllllllllllIllllIlIIIIllIIllll;
                            lllllllllllllIllllIlIIIIlllIlIIl = this.permutations[lllllllllllllIllllIlIIIIlllIlIll] + lllllllllllllIllllIlIIIIllIlIlII;
                            lllllllllllllIllllIlIIIIlllIIlll = this.permutations[lllllllllllllIllllIlIIIIlllIlIll + 1] + lllllllllllllIllllIlIIIIllIlIlII;
                            lllllllllllllIllllIlIIIIlllIIlIl = this.lerp(lllllllllllllIllllIlIIIIllIllIII, this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIlllI], lllllllllllllIllllIlIIIIllIllIll, lllllllllllllIllllIlIIIIllIlIIIl, lllllllllllllIllllIlIIIIllIlIllI), this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIlIIl], lllllllllllllIllllIlIIIIllIllIll - 1.0, lllllllllllllIllllIlIIIIllIlIIIl, lllllllllllllIllllIlIIIIllIlIllI));
                            lllllllllllllIllllIlIIIIlllIIIll = this.lerp(lllllllllllllIllllIlIIIIllIllIII, this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIllIl], lllllllllllllIllllIlIIIIllIllIll, lllllllllllllIllllIlIIIIllIlIIIl - 1.0, lllllllllllllIllllIlIIIIllIlIllI), this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIIlll], lllllllllllllIllllIlIIIIllIllIll - 1.0, lllllllllllllIllllIlIIIIllIlIIIl - 1.0, lllllllllllllIllllIlIIIIllIlIllI));
                            lllllllllllllIllllIlIIIIlllIIIIl = this.lerp(lllllllllllllIllllIlIIIIllIllIII, this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIlllI + 1], lllllllllllllIllllIlIIIIllIllIll, lllllllllllllIllllIlIIIIllIlIIIl, lllllllllllllIllllIlIIIIllIlIllI - 1.0), this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIlIIl + 1], lllllllllllllIllllIlIIIIllIllIll - 1.0, lllllllllllllIllllIlIIIIllIlIIIl, lllllllllllllIllllIlIIIIllIlIllI - 1.0));
                            lllllllllllllIllllIlIIIIllIlllll = this.lerp(lllllllllllllIllllIlIIIIllIllIII, this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIllIl + 1], lllllllllllllIllllIlIIIIllIllIll, lllllllllllllIllllIlIIIIllIlIIIl - 1.0, lllllllllllllIllllIlIIIIllIlIllI - 1.0), this.grad(this.permutations[lllllllllllllIllllIlIIIIlllIIlll + 1], lllllllllllllIllllIlIIIIllIllIll - 1.0, lllllllllllllIllllIlIIIIllIlIIIl - 1.0, lllllllllllllIllllIlIIIIllIlIllI - 1.0));
                        }
                        final double lllllllllllllIllllIlIIIIllIIllIl = this.lerp(lllllllllllllIllllIlIIIIllIIlllI, lllllllllllllIllllIlIIIIlllIIlIl, lllllllllllllIllllIlIIIIlllIIIll);
                        final double lllllllllllllIllllIlIIIIllIIllII = this.lerp(lllllllllllllIllllIlIIIIllIIlllI, lllllllllllllIllllIlIIIIlllIIIIl, lllllllllllllIllllIlIIIIllIlllll);
                        final double lllllllllllllIllllIlIIIIllIIlIll = this.lerp(lllllllllllllIllllIlIIIIllIlIIll, lllllllllllllIllllIlIIIIllIIllIl, lllllllllllllIllllIlIIIIllIIllII);
                        final int n2;
                        final int lllllllllllllIllllIlIIIIllIIlIlI = n2 = lllllllllllllIllllIlIIIIllllIllI++;
                        lllllllllllllIllllIlIIIlIIlIIllI[n2] += lllllllllllllIllllIlIIIIllIIlIll * lllllllllllllIllllIlIIIIllllIlII;
                    }
                }
            }
        }
    }
    
    public final double grad2(final int lllllllllllllIllllIlIIIllIIIIIIl, final double lllllllllllllIllllIlIIIlIlllllII, final double lllllllllllllIllllIlIIIlIlllllll) {
        final int lllllllllllllIllllIlIIIlIllllllI = lllllllllllllIllllIlIIIllIIIIIIl & 0xF;
        return NoiseGeneratorImproved.GRAD_2X[lllllllllllllIllllIlIIIlIllllllI] * lllllllllllllIllllIlIIIlIlllllII + NoiseGeneratorImproved.GRAD_2Z[lllllllllllllIllllIlIIIlIllllllI] * lllllllllllllIllllIlIIIlIlllllll;
    }
    
    public final double lerp(final double lllllllllllllIllllIlIIIllIIIllII, final double lllllllllllllIllllIlIIIllIIIlIII, final double lllllllllllllIllllIlIIIllIIIIlll) {
        return lllllllllllllIllllIlIIIllIIIlIII + lllllllllllllIllllIlIIIllIIIllII * (lllllllllllllIllllIlIIIllIIIIlll - lllllllllllllIllllIlIIIllIIIlIII);
    }
    
    public NoiseGeneratorImproved(final Random lllllllllllllIllllIlIIIllIIllIlI) {
        this.permutations = new int[512];
        this.xCoord = lllllllllllllIllllIlIIIllIIllIlI.nextDouble() * 256.0;
        this.yCoord = lllllllllllllIllllIlIIIllIIllIlI.nextDouble() * 256.0;
        this.zCoord = lllllllllllllIllllIlIIIllIIllIlI.nextDouble() * 256.0;
        for (int lllllllllllllIllllIlIIIllIIllIIl = 0; lllllllllllllIllllIlIIIllIIllIIl < 256; this.permutations[lllllllllllllIllllIlIIIllIIllIIl] = lllllllllllllIllllIlIIIllIIllIIl++) {}
        for (int lllllllllllllIllllIlIIIllIIllIII = 0; lllllllllllllIllllIlIIIllIIllIII < 256; ++lllllllllllllIllllIlIIIllIIllIII) {
            final int lllllllllllllIllllIlIIIllIIlIlll = lllllllllllllIllllIlIIIllIIllIlI.nextInt(256 - lllllllllllllIllllIlIIIllIIllIII) + lllllllllllllIllllIlIIIllIIllIII;
            final int lllllllllllllIllllIlIIIllIIlIllI = this.permutations[lllllllllllllIllllIlIIIllIIllIII];
            this.permutations[lllllllllllllIllllIlIIIllIIllIII] = this.permutations[lllllllllllllIllllIlIIIllIIlIlll];
            this.permutations[lllllllllllllIllllIlIIIllIIlIlll] = lllllllllllllIllllIlIIIllIIlIllI;
            this.permutations[lllllllllllllIllllIlIIIllIIllIII + 256] = this.permutations[lllllllllllllIllllIlIIIllIIllIII];
        }
    }
    
    public NoiseGeneratorImproved() {
        this(new Random());
    }
}
