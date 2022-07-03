package net.minecraft.world.gen.layer;

public class GenLayerRiverInit extends GenLayer
{
    @Override
    public int[] getInts(final int lllllllllllllIIIIlIIlIIIllIIlIlI, final int lllllllllllllIIIIlIIlIIIllIIlIIl, final int lllllllllllllIIIIlIIlIIIlIllllll, final int lllllllllllllIIIIlIIlIIIlIlllllI) {
        final int[] lllllllllllllIIIIlIIlIIIllIIIllI = this.parent.getInts(lllllllllllllIIIIlIIlIIIllIIlIlI, lllllllllllllIIIIlIIlIIIllIIlIIl, lllllllllllllIIIIlIIlIIIlIllllll, lllllllllllllIIIIlIIlIIIlIlllllI);
        final int[] lllllllllllllIIIIlIIlIIIllIIIlIl = IntCache.getIntCache(lllllllllllllIIIIlIIlIIIlIllllll * lllllllllllllIIIIlIIlIIIlIlllllI);
        for (int lllllllllllllIIIIlIIlIIIllIIIlII = 0; lllllllllllllIIIIlIIlIIIllIIIlII < lllllllllllllIIIIlIIlIIIlIlllllI; ++lllllllllllllIIIIlIIlIIIllIIIlII) {
            for (int lllllllllllllIIIIlIIlIIIllIIIIll = 0; lllllllllllllIIIIlIIlIIIllIIIIll < lllllllllllllIIIIlIIlIIIlIllllll; ++lllllllllllllIIIIlIIlIIIllIIIIll) {
                this.initChunkSeed(lllllllllllllIIIIlIIlIIIllIIIIll + lllllllllllllIIIIlIIlIIIllIIlIlI, lllllllllllllIIIIlIIlIIIllIIIlII + lllllllllllllIIIIlIIlIIIllIIlIIl);
                lllllllllllllIIIIlIIlIIIllIIIlIl[lllllllllllllIIIIlIIlIIIllIIIIll + lllllllllllllIIIIlIIlIIIllIIIlII * lllllllllllllIIIIlIIlIIIlIllllll] = ((lllllllllllllIIIIlIIlIIIllIIIllI[lllllllllllllIIIIlIIlIIIllIIIIll + lllllllllllllIIIIlIIlIIIllIIIlII * lllllllllllllIIIIlIIlIIIlIllllll] > 0) ? (this.nextInt(299999) + 2) : 0);
            }
        }
        return lllllllllllllIIIIlIIlIIIllIIIlIl;
    }
    
    public GenLayerRiverInit(final long lllllllllllllIIIIlIIlIIIllIlIllI, final GenLayer lllllllllllllIIIIlIIlIIIllIlIlIl) {
        super(lllllllllllllIIIIlIIlIIIllIlIllI);
        this.parent = lllllllllllllIIIIlIIlIIIllIlIlIl;
    }
}
