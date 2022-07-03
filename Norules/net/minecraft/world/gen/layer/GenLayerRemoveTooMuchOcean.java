package net.minecraft.world.gen.layer;

public class GenLayerRemoveTooMuchOcean extends GenLayer
{
    public GenLayerRemoveTooMuchOcean(final long llllllllllllllllIIlllIlIIIllIIlI, final GenLayer llllllllllllllllIIlllIlIIIlIlllI) {
        super(llllllllllllllllIIlllIlIIIllIIlI);
        this.parent = llllllllllllllllIIlllIlIIIlIlllI;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIIlllIlIIIIIlIII, final int llllllllllllllllIIlllIlIIIIllIIl, final int llllllllllllllllIIlllIlIIIIIIllI, final int llllllllllllllllIIlllIlIIIIIIlIl) {
        final int llllllllllllllllIIlllIlIIIIlIllI = llllllllllllllllIIlllIlIIIIIlIII - 1;
        final int llllllllllllllllIIlllIlIIIIlIlIl = llllllllllllllllIIlllIlIIIIllIIl - 1;
        final int llllllllllllllllIIlllIlIIIIlIlII = llllllllllllllllIIlllIlIIIIIIllI + 2;
        final int llllllllllllllllIIlllIlIIIIlIIll = llllllllllllllllIIlllIlIIIIIIlIl + 2;
        final int[] llllllllllllllllIIlllIlIIIIlIIlI = this.parent.getInts(llllllllllllllllIIlllIlIIIIlIllI, llllllllllllllllIIlllIlIIIIlIlIl, llllllllllllllllIIlllIlIIIIlIlII, llllllllllllllllIIlllIlIIIIlIIll);
        final int[] llllllllllllllllIIlllIlIIIIlIIIl = IntCache.getIntCache(llllllllllllllllIIlllIlIIIIIIllI * llllllllllllllllIIlllIlIIIIIIlIl);
        for (int llllllllllllllllIIlllIlIIIIlIIII = 0; llllllllllllllllIIlllIlIIIIlIIII < llllllllllllllllIIlllIlIIIIIIlIl; ++llllllllllllllllIIlllIlIIIIlIIII) {
            for (int llllllllllllllllIIlllIlIIIIIllll = 0; llllllllllllllllIIlllIlIIIIIllll < llllllllllllllllIIlllIlIIIIIIllI; ++llllllllllllllllIIlllIlIIIIIllll) {
                final int llllllllllllllllIIlllIlIIIIIlllI = llllllllllllllllIIlllIlIIIIlIIlI[llllllllllllllllIIlllIlIIIIIllll + 1 + (llllllllllllllllIIlllIlIIIIlIIII + 1 - 1) * (llllllllllllllllIIlllIlIIIIIIllI + 2)];
                final int llllllllllllllllIIlllIlIIIIIllIl = llllllllllllllllIIlllIlIIIIlIIlI[llllllllllllllllIIlllIlIIIIIllll + 1 + 1 + (llllllllllllllllIIlllIlIIIIlIIII + 1) * (llllllllllllllllIIlllIlIIIIIIllI + 2)];
                final int llllllllllllllllIIlllIlIIIIIllII = llllllllllllllllIIlllIlIIIIlIIlI[llllllllllllllllIIlllIlIIIIIllll + 1 - 1 + (llllllllllllllllIIlllIlIIIIlIIII + 1) * (llllllllllllllllIIlllIlIIIIIIllI + 2)];
                final int llllllllllllllllIIlllIlIIIIIlIll = llllllllllllllllIIlllIlIIIIlIIlI[llllllllllllllllIIlllIlIIIIIllll + 1 + (llllllllllllllllIIlllIlIIIIlIIII + 1 + 1) * (llllllllllllllllIIlllIlIIIIIIllI + 2)];
                final int llllllllllllllllIIlllIlIIIIIlIlI = llllllllllllllllIIlllIlIIIIlIIlI[llllllllllllllllIIlllIlIIIIIllll + 1 + (llllllllllllllllIIlllIlIIIIlIIII + 1) * llllllllllllllllIIlllIlIIIIlIlII];
                llllllllllllllllIIlllIlIIIIlIIIl[llllllllllllllllIIlllIlIIIIIllll + llllllllllllllllIIlllIlIIIIlIIII * llllllllllllllllIIlllIlIIIIIIllI] = llllllllllllllllIIlllIlIIIIIlIlI;
                this.initChunkSeed(llllllllllllllllIIlllIlIIIIIllll + llllllllllllllllIIlllIlIIIIIlIII, llllllllllllllllIIlllIlIIIIlIIII + llllllllllllllllIIlllIlIIIIllIIl);
                if (llllllllllllllllIIlllIlIIIIIlIlI == 0 && llllllllllllllllIIlllIlIIIIIlllI == 0 && llllllllllllllllIIlllIlIIIIIllIl == 0 && llllllllllllllllIIlllIlIIIIIllII == 0 && llllllllllllllllIIlllIlIIIIIlIll == 0 && this.nextInt(2) == 0) {
                    llllllllllllllllIIlllIlIIIIlIIIl[llllllllllllllllIIlllIlIIIIIllll + llllllllllllllllIIlllIlIIIIlIIII * llllllllllllllllIIlllIlIIIIIIllI] = 1;
                }
            }
        }
        return llllllllllllllllIIlllIlIIIIlIIIl;
    }
}
