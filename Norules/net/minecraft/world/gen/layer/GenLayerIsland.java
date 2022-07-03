package net.minecraft.world.gen.layer;

public class GenLayerIsland extends GenLayer
{
    public GenLayerIsland(final long lllllllllllllIlIIllIIlIIllllllll) {
        super(lllllllllllllIlIIllIIlIIllllllll);
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIlIIllIIlIIllllIlIl, final int lllllllllllllIlIIllIIlIIlllIllII, final int lllllllllllllIlIIllIIlIIllllIIll, final int lllllllllllllIlIIllIIlIIlllIlIlI) {
        final int[] lllllllllllllIlIIllIIlIIllllIIIl = IntCache.getIntCache(lllllllllllllIlIIllIIlIIllllIIll * lllllllllllllIlIIllIIlIIlllIlIlI);
        for (int lllllllllllllIlIIllIIlIIllllIIII = 0; lllllllllllllIlIIllIIlIIllllIIII < lllllllllllllIlIIllIIlIIlllIlIlI; ++lllllllllllllIlIIllIIlIIllllIIII) {
            for (int lllllllllllllIlIIllIIlIIlllIllll = 0; lllllllllllllIlIIllIIlIIlllIllll < lllllllllllllIlIIllIIlIIllllIIll; ++lllllllllllllIlIIllIIlIIlllIllll) {
                this.initChunkSeed(lllllllllllllIlIIllIIlIIllllIlIl + lllllllllllllIlIIllIIlIIlllIllll, lllllllllllllIlIIllIIlIIlllIllII + lllllllllllllIlIIllIIlIIllllIIII);
                lllllllllllllIlIIllIIlIIllllIIIl[lllllllllllllIlIIllIIlIIlllIllll + lllllllllllllIlIIllIIlIIllllIIII * lllllllllllllIlIIllIIlIIllllIIll] = ((this.nextInt(10) == 0) ? 1 : 0);
            }
        }
        if (lllllllllllllIlIIllIIlIIllllIlIl > -lllllllllllllIlIIllIIlIIllllIIll && lllllllllllllIlIIllIIlIIllllIlIl <= 0 && lllllllllllllIlIIllIIlIIlllIllII > -lllllllllllllIlIIllIIlIIlllIlIlI && lllllllllllllIlIIllIIlIIlllIllII <= 0) {
            lllllllllllllIlIIllIIlIIllllIIIl[-lllllllllllllIlIIllIIlIIllllIlIl + -lllllllllllllIlIIllIIlIIlllIllII * lllllllllllllIlIIllIIlIIllllIIll] = 1;
        }
        return lllllllllllllIlIIllIIlIIllllIIIl;
    }
}
