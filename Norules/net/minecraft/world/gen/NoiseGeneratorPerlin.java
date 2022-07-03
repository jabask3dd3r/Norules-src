package net.minecraft.world.gen;

import java.util.*;

public class NoiseGeneratorPerlin extends NoiseGenerator
{
    private final /* synthetic */ int levels;
    private final /* synthetic */ NoiseGeneratorSimplex[] noiseLevels;
    
    public NoiseGeneratorPerlin(final Random llllllllllllllIIllIlllIIllllllll, final int llllllllllllllIIllIlllIlIIIIIIlI) {
        this.levels = llllllllllllllIIllIlllIlIIIIIIlI;
        this.noiseLevels = new NoiseGeneratorSimplex[llllllllllllllIIllIlllIlIIIIIIlI];
        for (int llllllllllllllIIllIlllIlIIIIIIIl = 0; llllllllllllllIIllIlllIlIIIIIIIl < llllllllllllllIIllIlllIlIIIIIIlI; ++llllllllllllllIIllIlllIlIIIIIIIl) {
            this.noiseLevels[llllllllllllllIIllIlllIlIIIIIIIl] = new NoiseGeneratorSimplex(llllllllllllllIIllIlllIIllllllll);
        }
    }
    
    public double getValue(final double llllllllllllllIIllIlllIIllllIlIl, final double llllllllllllllIIllIlllIIllllIlII) {
        double llllllllllllllIIllIlllIIllllIIll = 0.0;
        double llllllllllllllIIllIlllIIllllIIlI = 1.0;
        for (int llllllllllllllIIllIlllIIllllIIIl = 0; llllllllllllllIIllIlllIIllllIIIl < this.levels; ++llllllllllllllIIllIlllIIllllIIIl) {
            llllllllllllllIIllIlllIIllllIIll += this.noiseLevels[llllllllllllllIIllIlllIIllllIIIl].getValue(llllllllllllllIIllIlllIIllllIlIl * llllllllllllllIIllIlllIIllllIIlI, llllllllllllllIIllIlllIIllllIlII * llllllllllllllIIllIlllIIllllIIlI) / llllllllllllllIIllIlllIIllllIIlI;
            llllllllllllllIIllIlllIIllllIIlI /= 2.0;
        }
        return llllllllllllllIIllIlllIIllllIIll;
    }
    
    public double[] getRegion(double[] llllllllllllllIIllIlllIIlIlIllIl, final double llllllllllllllIIllIlllIIlIlllIlI, final double llllllllllllllIIllIlllIIlIlllIIl, final int llllllllllllllIIllIlllIIlIlIlIlI, final int llllllllllllllIIllIlllIIlIllIlll, final double llllllllllllllIIllIlllIIlIllIllI, final double llllllllllllllIIllIlllIIlIllIlIl, final double llllllllllllllIIllIlllIIlIllIlII, final double llllllllllllllIIllIlllIIlIlIIlIl) {
        if (llllllllllllllIIllIlllIIlIlIllIl != null && llllllllllllllIIllIlllIIlIlIllIl.length >= llllllllllllllIIllIlllIIlIlIlIlI * llllllllllllllIIllIlllIIlIllIlll) {
            for (int llllllllllllllIIllIlllIIlIllIIlI = 0; llllllllllllllIIllIlllIIlIllIIlI < llllllllllllllIIllIlllIIlIlIllIl.length; ++llllllllllllllIIllIlllIIlIllIIlI) {
                llllllllllllllIIllIlllIIlIlIllIl[llllllllllllllIIllIlllIIlIllIIlI] = 0.0;
            }
        }
        else {
            llllllllllllllIIllIlllIIlIlIllIl = new double[llllllllllllllIIllIlllIIlIlIlIlI * llllllllllllllIIllIlllIIlIllIlll];
        }
        double llllllllllllllIIllIlllIIlIllIIIl = 1.0;
        double llllllllllllllIIllIlllIIlIllIIII = 1.0;
        for (int llllllllllllllIIllIlllIIlIlIllll = 0; llllllllllllllIIllIlllIIlIlIllll < this.levels; ++llllllllllllllIIllIlllIIlIlIllll) {
            this.noiseLevels[llllllllllllllIIllIlllIIlIlIllll].add(llllllllllllllIIllIlllIIlIlIllIl, llllllllllllllIIllIlllIIlIlllIlI, llllllllllllllIIllIlllIIlIlllIIl, llllllllllllllIIllIlllIIlIlIlIlI, llllllllllllllIIllIlllIIlIllIlll, llllllllllllllIIllIlllIIlIllIllI * llllllllllllllIIllIlllIIlIllIIII * llllllllllllllIIllIlllIIlIllIIIl, llllllllllllllIIllIlllIIlIllIlIl * llllllllllllllIIllIlllIIlIllIIII * llllllllllllllIIllIlllIIlIllIIIl, 0.55 / llllllllllllllIIllIlllIIlIllIIIl);
            llllllllllllllIIllIlllIIlIllIIII *= llllllllllllllIIllIlllIIlIllIlII;
            llllllllllllllIIllIlllIIlIllIIIl *= llllllllllllllIIllIlllIIlIlIIlIl;
        }
        return llllllllllllllIIllIlllIIlIlIllIl;
    }
    
    public double[] getRegion(final double[] llllllllllllllIIllIlllIIllIlIlll, final double llllllllllllllIIllIlllIIllIlIllI, final double llllllllllllllIIllIlllIIllIlIlIl, final int llllllllllllllIIllIlllIIllIlllIl, final int llllllllllllllIIllIlllIIllIlIIll, final double llllllllllllllIIllIlllIIllIllIll, final double llllllllllllllIIllIlllIIllIlIIIl, final double llllllllllllllIIllIlllIIllIlIIII) {
        return this.getRegion(llllllllllllllIIllIlllIIllIlIlll, llllllllllllllIIllIlllIIllIlIllI, llllllllllllllIIllIlllIIllIlIlIl, llllllllllllllIIllIlllIIllIlllIl, llllllllllllllIIllIlllIIllIlIIll, llllllllllllllIIllIlllIIllIllIll, llllllllllllllIIllIlllIIllIlIIIl, llllllllllllllIIllIlllIIllIlIIII, 0.5);
    }
}
