package net.minecraft.world.gen.layer;

public class GenLayerZoom extends GenLayer
{
    public GenLayerZoom(final long llllllllllllllIlIllIlIIlllIllIII, final GenLayer llllllllllllllIlIllIlIIlllIllIlI) {
        super(llllllllllllllIlIllIlIIlllIllIII);
        super.parent = llllllllllllllIlIllIlIIlllIllIlI;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIlIllIlIIlllIIIIIl, final int llllllllllllllIlIllIlIIllIlIlIlI, final int llllllllllllllIlIllIlIIllIllllll, final int llllllllllllllIlIllIlIIllIlllllI) {
        final int llllllllllllllIlIllIlIIllIllllIl = llllllllllllllIlIllIlIIlllIIIIIl >> 1;
        final int llllllllllllllIlIllIlIIllIllllII = llllllllllllllIlIllIlIIllIlIlIlI >> 1;
        final int llllllllllllllIlIllIlIIllIlllIll = (llllllllllllllIlIllIlIIllIllllll >> 1) + 2;
        final int llllllllllllllIlIllIlIIllIlllIlI = (llllllllllllllIlIllIlIIllIlllllI >> 1) + 2;
        final int[] llllllllllllllIlIllIlIIllIlllIIl = this.parent.getInts(llllllllllllllIlIllIlIIllIllllIl, llllllllllllllIlIllIlIIllIllllII, llllllllllllllIlIllIlIIllIlllIll, llllllllllllllIlIllIlIIllIlllIlI);
        final int llllllllllllllIlIllIlIIllIlllIII = llllllllllllllIlIllIlIIllIlllIll - 1 << 1;
        final int llllllllllllllIlIllIlIIllIllIlll = llllllllllllllIlIllIlIIllIlllIlI - 1 << 1;
        final int[] llllllllllllllIlIllIlIIllIllIllI = IntCache.getIntCache(llllllllllllllIlIllIlIIllIlllIII * llllllllllllllIlIllIlIIllIllIlll);
        for (int llllllllllllllIlIllIlIIllIllIlIl = 0; llllllllllllllIlIllIlIIllIllIlIl < llllllllllllllIlIllIlIIllIlllIlI - 1; ++llllllllllllllIlIllIlIIllIllIlIl) {
            int llllllllllllllIlIllIlIIllIllIlII = (llllllllllllllIlIllIlIIllIllIlIl << 1) * llllllllllllllIlIllIlIIllIlllIII;
            int llllllllllllllIlIllIlIIllIllIIll = 0;
            int llllllllllllllIlIllIlIIllIllIIlI = llllllllllllllIlIllIlIIllIlllIIl[llllllllllllllIlIllIlIIllIllIIll + 0 + (llllllllllllllIlIllIlIIllIllIlIl + 0) * llllllllllllllIlIllIlIIllIlllIll];
            int llllllllllllllIlIllIlIIllIllIIIl = llllllllllllllIlIllIlIIllIlllIIl[llllllllllllllIlIllIlIIllIllIIll + 0 + (llllllllllllllIlIllIlIIllIllIlIl + 1) * llllllllllllllIlIllIlIIllIlllIll];
            while (llllllllllllllIlIllIlIIllIllIIll < llllllllllllllIlIllIlIIllIlllIll - 1) {
                this.initChunkSeed(llllllllllllllIlIllIlIIllIllIIll + llllllllllllllIlIllIlIIllIllllIl << 1, llllllllllllllIlIllIlIIllIllIlIl + llllllllllllllIlIllIlIIllIllllII << 1);
                final int llllllllllllllIlIllIlIIllIllIIII = llllllllllllllIlIllIlIIllIlllIIl[llllllllllllllIlIllIlIIllIllIIll + 1 + (llllllllllllllIlIllIlIIllIllIlIl + 0) * llllllllllllllIlIllIlIIllIlllIll];
                final int llllllllllllllIlIllIlIIllIlIllll = llllllllllllllIlIllIlIIllIlllIIl[llllllllllllllIlIllIlIIllIllIIll + 1 + (llllllllllllllIlIllIlIIllIllIlIl + 1) * llllllllllllllIlIllIlIIllIlllIll];
                llllllllllllllIlIllIlIIllIllIllI[llllllllllllllIlIllIlIIllIllIlII] = llllllllllllllIlIllIlIIllIllIIlI;
                llllllllllllllIlIllIlIIllIllIllI[llllllllllllllIlIllIlIIllIllIlII++ + llllllllllllllIlIllIlIIllIlllIII] = this.selectRandom(llllllllllllllIlIllIlIIllIllIIlI, llllllllllllllIlIllIlIIllIllIIIl);
                llllllllllllllIlIllIlIIllIllIllI[llllllllllllllIlIllIlIIllIllIlII] = this.selectRandom(llllllllllllllIlIllIlIIllIllIIlI, llllllllllllllIlIllIlIIllIllIIII);
                llllllllllllllIlIllIlIIllIllIllI[llllllllllllllIlIllIlIIllIllIlII++ + llllllllllllllIlIllIlIIllIlllIII] = this.selectModeOrRandom(llllllllllllllIlIllIlIIllIllIIlI, llllllllllllllIlIllIlIIllIllIIII, llllllllllllllIlIllIlIIllIllIIIl, llllllllllllllIlIllIlIIllIlIllll);
                llllllllllllllIlIllIlIIllIllIIlI = llllllllllllllIlIllIlIIllIllIIII;
                llllllllllllllIlIllIlIIllIllIIIl = llllllllllllllIlIllIlIIllIlIllll;
                ++llllllllllllllIlIllIlIIllIllIIll;
            }
        }
        final int[] llllllllllllllIlIllIlIIllIlIlllI = IntCache.getIntCache(llllllllllllllIlIllIlIIllIllllll * llllllllllllllIlIllIlIIllIlllllI);
        for (int llllllllllllllIlIllIlIIllIlIllIl = 0; llllllllllllllIlIllIlIIllIlIllIl < llllllllllllllIlIllIlIIllIlllllI; ++llllllllllllllIlIllIlIIllIlIllIl) {
            System.arraycopy(llllllllllllllIlIllIlIIllIllIllI, (llllllllllllllIlIllIlIIllIlIllIl + (llllllllllllllIlIllIlIIllIlIlIlI & 0x1)) * llllllllllllllIlIllIlIIllIlllIII + (llllllllllllllIlIllIlIIlllIIIIIl & 0x1), llllllllllllllIlIllIlIIllIlIlllI, llllllllllllllIlIllIlIIllIlIllIl * llllllllllllllIlIllIlIIllIllllll, llllllllllllllIlIllIlIIllIllllll);
        }
        return llllllllllllllIlIllIlIIllIlIlllI;
    }
    
    public static GenLayer magnify(final long llllllllllllllIlIllIlIIllIIlIIll, final GenLayer llllllllllllllIlIllIlIIllIIIllIl, final int llllllllllllllIlIllIlIIllIIlIIIl) {
        GenLayer llllllllllllllIlIllIlIIllIIlIIII = llllllllllllllIlIllIlIIllIIIllIl;
        for (int llllllllllllllIlIllIlIIllIIIllll = 0; llllllllllllllIlIllIlIIllIIIllll < llllllllllllllIlIllIlIIllIIlIIIl; ++llllllllllllllIlIllIlIIllIIIllll) {
            llllllllllllllIlIllIlIIllIIlIIII = new GenLayerZoom(llllllllllllllIlIllIlIIllIIlIIll + llllllllllllllIlIllIlIIllIIIllll, llllllllllllllIlIllIlIIllIIlIIII);
        }
        return llllllllllllllIlIllIlIIllIIlIIII;
    }
}
