package net.minecraft.world.gen.layer;

public class GenLayerSmooth extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllllllllIIlIIIIIlIIllI, final int llllllllllllllllllIIlIIIIIllIlll, final int llllllllllllllllllIIlIIIIIllIllI, final int llllllllllllllllllIIlIIIIIllIlIl) {
        final int llllllllllllllllllIIlIIIIIllIlII = llllllllllllllllllIIlIIIIIlIIllI - 1;
        final int llllllllllllllllllIIlIIIIIllIIll = llllllllllllllllllIIlIIIIIllIlll - 1;
        final int llllllllllllllllllIIlIIIIIllIIlI = llllllllllllllllllIIlIIIIIllIllI + 2;
        final int llllllllllllllllllIIlIIIIIllIIIl = llllllllllllllllllIIlIIIIIllIlIl + 2;
        final int[] llllllllllllllllllIIlIIIIIllIIII = this.parent.getInts(llllllllllllllllllIIlIIIIIllIlII, llllllllllllllllllIIlIIIIIllIIll, llllllllllllllllllIIlIIIIIllIIlI, llllllllllllllllllIIlIIIIIllIIIl);
        final int[] llllllllllllllllllIIlIIIIIlIllll = IntCache.getIntCache(llllllllllllllllllIIlIIIIIllIllI * llllllllllllllllllIIlIIIIIllIlIl);
        for (int llllllllllllllllllIIlIIIIIlIlllI = 0; llllllllllllllllllIIlIIIIIlIlllI < llllllllllllllllllIIlIIIIIllIlIl; ++llllllllllllllllllIIlIIIIIlIlllI) {
            for (int llllllllllllllllllIIlIIIIIlIllIl = 0; llllllllllllllllllIIlIIIIIlIllIl < llllllllllllllllllIIlIIIIIllIllI; ++llllllllllllllllllIIlIIIIIlIllIl) {
                final int llllllllllllllllllIIlIIIIIlIllII = llllllllllllllllllIIlIIIIIllIIII[llllllllllllllllllIIlIIIIIlIllIl + 0 + (llllllllllllllllllIIlIIIIIlIlllI + 1) * llllllllllllllllllIIlIIIIIllIIlI];
                final int llllllllllllllllllIIlIIIIIlIlIll = llllllllllllllllllIIlIIIIIllIIII[llllllllllllllllllIIlIIIIIlIllIl + 2 + (llllllllllllllllllIIlIIIIIlIlllI + 1) * llllllllllllllllllIIlIIIIIllIIlI];
                final int llllllllllllllllllIIlIIIIIlIlIlI = llllllllllllllllllIIlIIIIIllIIII[llllllllllllllllllIIlIIIIIlIllIl + 1 + (llllllllllllllllllIIlIIIIIlIlllI + 0) * llllllllllllllllllIIlIIIIIllIIlI];
                final int llllllllllllllllllIIlIIIIIlIlIIl = llllllllllllllllllIIlIIIIIllIIII[llllllllllllllllllIIlIIIIIlIllIl + 1 + (llllllllllllllllllIIlIIIIIlIlllI + 2) * llllllllllllllllllIIlIIIIIllIIlI];
                int llllllllllllllllllIIlIIIIIlIlIII = llllllllllllllllllIIlIIIIIllIIII[llllllllllllllllllIIlIIIIIlIllIl + 1 + (llllllllllllllllllIIlIIIIIlIlllI + 1) * llllllllllllllllllIIlIIIIIllIIlI];
                if (llllllllllllllllllIIlIIIIIlIllII == llllllllllllllllllIIlIIIIIlIlIll && llllllllllllllllllIIlIIIIIlIlIlI == llllllllllllllllllIIlIIIIIlIlIIl) {
                    this.initChunkSeed(llllllllllllllllllIIlIIIIIlIllIl + llllllllllllllllllIIlIIIIIlIIllI, llllllllllllllllllIIlIIIIIlIlllI + llllllllllllllllllIIlIIIIIllIlll);
                    if (this.nextInt(2) == 0) {
                        llllllllllllllllllIIlIIIIIlIlIII = llllllllllllllllllIIlIIIIIlIllII;
                    }
                    else {
                        llllllllllllllllllIIlIIIIIlIlIII = llllllllllllllllllIIlIIIIIlIlIlI;
                    }
                }
                else {
                    if (llllllllllllllllllIIlIIIIIlIllII == llllllllllllllllllIIlIIIIIlIlIll) {
                        llllllllllllllllllIIlIIIIIlIlIII = llllllllllllllllllIIlIIIIIlIllII;
                    }
                    if (llllllllllllllllllIIlIIIIIlIlIlI == llllllllllllllllllIIlIIIIIlIlIIl) {
                        llllllllllllllllllIIlIIIIIlIlIII = llllllllllllllllllIIlIIIIIlIlIlI;
                    }
                }
                llllllllllllllllllIIlIIIIIlIllll[llllllllllllllllllIIlIIIIIlIllIl + llllllllllllllllllIIlIIIIIlIlllI * llllllllllllllllllIIlIIIIIllIllI] = llllllllllllllllllIIlIIIIIlIlIII;
            }
        }
        return llllllllllllllllllIIlIIIIIlIllll;
    }
    
    public GenLayerSmooth(final long llllllllllllllllllIIlIIIIlIIllIl, final GenLayer llllllllllllllllllIIlIIIIlIIllll) {
        super(llllllllllllllllllIIlIIIIlIIllIl);
        super.parent = llllllllllllllllllIIlIIIIlIIllll;
    }
}
