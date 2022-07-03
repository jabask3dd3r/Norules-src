package net.minecraft.world.gen;

import java.util.*;
import net.minecraft.util.math.*;

public class NoiseGeneratorOctaves extends NoiseGenerator
{
    private final /* synthetic */ int octaves;
    private final /* synthetic */ NoiseGeneratorImproved[] generatorCollection;
    
    public double[] generateNoiseOctaves(final double[] llllllllllllllIlIIIIIlIllIllllIl, final int llllllllllllllIlIIIIIlIllIllllII, final int llllllllllllllIlIIIIIlIllIlllIll, final int llllllllllllllIlIIIIIlIllIllIIIl, final int llllllllllllllIlIIIIIlIllIlllIIl, final double llllllllllllllIlIIIIIlIllIlllIII, final double llllllllllllllIlIIIIIlIllIlIlllI, final double llllllllllllllIlIIIIIlIllIllIllI) {
        return this.generateNoiseOctaves(llllllllllllllIlIIIIIlIllIllllIl, llllllllllllllIlIIIIIlIllIllllII, 10, llllllllllllllIlIIIIIlIllIlllIll, llllllllllllllIlIIIIIlIllIllIIIl, 1, llllllllllllllIlIIIIIlIllIlllIIl, llllllllllllllIlIIIIIlIllIlllIII, 1.0, llllllllllllllIlIIIIIlIllIlIlllI);
    }
    
    public NoiseGeneratorOctaves(final Random llllllllllllllIlIIIIIllIIIIIIIII, final int llllllllllllllIlIIIIIlIlllllllll) {
        this.octaves = llllllllllllllIlIIIIIlIlllllllll;
        this.generatorCollection = new NoiseGeneratorImproved[llllllllllllllIlIIIIIlIlllllllll];
        for (int llllllllllllllIlIIIIIllIIIIIIIlI = 0; llllllllllllllIlIIIIIllIIIIIIIlI < llllllllllllllIlIIIIIlIlllllllll; ++llllllllllllllIlIIIIIllIIIIIIIlI) {
            this.generatorCollection[llllllllllllllIlIIIIIllIIIIIIIlI] = new NoiseGeneratorImproved(llllllllllllllIlIIIIIllIIIIIIIII);
        }
    }
    
    public double[] generateNoiseOctaves(double[] llllllllllllllIlIIIIIlIlllIlIlll, final int llllllllllllllIlIIIIIlIllllIlIIl, final int llllllllllllllIlIIIIIlIlllIlIlIl, final int llllllllllllllIlIIIIIlIlllIlIlII, final int llllllllllllllIlIIIIIlIlllIlIIll, final int llllllllllllllIlIIIIIlIllllIIlIl, final int llllllllllllllIlIIIIIlIllllIIlII, final double llllllllllllllIlIIIIIlIlllIlIIII, final double llllllllllllllIlIIIIIlIlllIIllll, final double llllllllllllllIlIIIIIlIllllIIIIl) {
        if (llllllllllllllIlIIIIIlIlllIlIlll == null) {
            llllllllllllllIlIIIIIlIlllIlIlll = new double[llllllllllllllIlIIIIIlIlllIlIIll * llllllllllllllIlIIIIIlIllllIIlIl * llllllllllllllIlIIIIIlIllllIIlII];
        }
        else {
            for (int llllllllllllllIlIIIIIlIllllIIIII = 0; llllllllllllllIlIIIIIlIllllIIIII < llllllllllllllIlIIIIIlIlllIlIlll.length; ++llllllllllllllIlIIIIIlIllllIIIII) {
                llllllllllllllIlIIIIIlIlllIlIlll[llllllllllllllIlIIIIIlIllllIIIII] = 0.0;
            }
        }
        double llllllllllllllIlIIIIIlIlllIlllll = 1.0;
        for (int llllllllllllllIlIIIIIlIlllIllllI = 0; llllllllllllllIlIIIIIlIlllIllllI < this.octaves; ++llllllllllllllIlIIIIIlIlllIllllI) {
            double llllllllllllllIlIIIIIlIlllIlllIl = llllllllllllllIlIIIIIlIllllIlIIl * llllllllllllllIlIIIIIlIlllIlllll * llllllllllllllIlIIIIIlIlllIlIIII;
            final double llllllllllllllIlIIIIIlIlllIlllII = llllllllllllllIlIIIIIlIlllIlIlIl * llllllllllllllIlIIIIIlIlllIlllll * llllllllllllllIlIIIIIlIlllIIllll;
            double llllllllllllllIlIIIIIlIlllIllIll = llllllllllllllIlIIIIIlIlllIlIlII * llllllllllllllIlIIIIIlIlllIlllll * llllllllllllllIlIIIIIlIllllIIIIl;
            long llllllllllllllIlIIIIIlIlllIllIlI = MathHelper.lFloor(llllllllllllllIlIIIIIlIlllIlllIl);
            long llllllllllllllIlIIIIIlIlllIllIIl = MathHelper.lFloor(llllllllllllllIlIIIIIlIlllIllIll);
            llllllllllllllIlIIIIIlIlllIlllIl -= llllllllllllllIlIIIIIlIlllIllIlI;
            llllllllllllllIlIIIIIlIlllIllIll -= llllllllllllllIlIIIIIlIlllIllIIl;
            llllllllllllllIlIIIIIlIlllIllIlI %= 16777216L;
            llllllllllllllIlIIIIIlIlllIllIIl %= 16777216L;
            llllllllllllllIlIIIIIlIlllIlllIl += llllllllllllllIlIIIIIlIlllIllIlI;
            llllllllllllllIlIIIIIlIlllIllIll += llllllllllllllIlIIIIIlIlllIllIIl;
            this.generatorCollection[llllllllllllllIlIIIIIlIlllIllllI].populateNoiseArray(llllllllllllllIlIIIIIlIlllIlIlll, llllllllllllllIlIIIIIlIlllIlllIl, llllllllllllllIlIIIIIlIlllIlllII, llllllllllllllIlIIIIIlIlllIllIll, llllllllllllllIlIIIIIlIlllIlIIll, llllllllllllllIlIIIIIlIllllIIlIl, llllllllllllllIlIIIIIlIllllIIlII, llllllllllllllIlIIIIIlIlllIlIIII * llllllllllllllIlIIIIIlIlllIlllll, llllllllllllllIlIIIIIlIlllIIllll * llllllllllllllIlIIIIIlIlllIlllll, llllllllllllllIlIIIIIlIllllIIIIl * llllllllllllllIlIIIIIlIlllIlllll, llllllllllllllIlIIIIIlIlllIlllll);
            llllllllllllllIlIIIIIlIlllIlllll /= 2.0;
        }
        return llllllllllllllIlIIIIIlIlllIlIlll;
    }
}
