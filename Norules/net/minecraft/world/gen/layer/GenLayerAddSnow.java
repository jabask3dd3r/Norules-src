package net.minecraft.world.gen.layer;

public class GenLayerAddSnow extends GenLayer
{
    public GenLayerAddSnow(final long lllllllllllllIlIlIlIllIllIllllIl, final GenLayer lllllllllllllIlIlIlIllIllIlllIIl) {
        super(lllllllllllllIlIlIlIllIllIllllIl);
        this.parent = lllllllllllllIlIlIlIllIllIlllIIl;
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIlIlIlIllIllIlIlIII, final int lllllllllllllIlIlIlIllIllIIllIII, final int lllllllllllllIlIlIlIllIllIlIIllI, final int lllllllllllllIlIlIlIllIllIlIIlIl) {
        final int lllllllllllllIlIlIlIllIllIlIIlII = lllllllllllllIlIlIlIllIllIlIlIII - 1;
        final int lllllllllllllIlIlIlIllIllIlIIIll = lllllllllllllIlIlIlIllIllIIllIII - 1;
        final int lllllllllllllIlIlIlIllIllIlIIIlI = lllllllllllllIlIlIlIllIllIlIIllI + 2;
        final int lllllllllllllIlIlIlIllIllIlIIIIl = lllllllllllllIlIlIlIllIllIlIIlIl + 2;
        final int[] lllllllllllllIlIlIlIllIllIlIIIII = this.parent.getInts(lllllllllllllIlIlIlIllIllIlIIlII, lllllllllllllIlIlIlIllIllIlIIIll, lllllllllllllIlIlIlIllIllIlIIIlI, lllllllllllllIlIlIlIllIllIlIIIIl);
        final int[] lllllllllllllIlIlIlIllIllIIlllll = IntCache.getIntCache(lllllllllllllIlIlIlIllIllIlIIllI * lllllllllllllIlIlIlIllIllIlIIlIl);
        for (int lllllllllllllIlIlIlIllIllIIllllI = 0; lllllllllllllIlIlIlIllIllIIllllI < lllllllllllllIlIlIlIllIllIlIIlIl; ++lllllllllllllIlIlIlIllIllIIllllI) {
            for (int lllllllllllllIlIlIlIllIllIIlllIl = 0; lllllllllllllIlIlIlIllIllIIlllIl < lllllllllllllIlIlIlIllIllIlIIllI; ++lllllllllllllIlIlIlIllIllIIlllIl) {
                final int lllllllllllllIlIlIlIllIllIIlllII = lllllllllllllIlIlIlIllIllIlIIIII[lllllllllllllIlIlIlIllIllIIlllIl + 1 + (lllllllllllllIlIlIlIllIllIIllllI + 1) * lllllllllllllIlIlIlIllIllIlIIIlI];
                this.initChunkSeed(lllllllllllllIlIlIlIllIllIIlllIl + lllllllllllllIlIlIlIllIllIlIlIII, lllllllllllllIlIlIlIllIllIIllllI + lllllllllllllIlIlIlIllIllIIllIII);
                if (lllllllllllllIlIlIlIllIllIIlllII == 0) {
                    lllllllllllllIlIlIlIllIllIIlllll[lllllllllllllIlIlIlIllIllIIlllIl + lllllllllllllIlIlIlIllIllIIllllI * lllllllllllllIlIlIlIllIllIlIIllI] = 0;
                }
                else {
                    int lllllllllllllIlIlIlIllIllIIllIll = this.nextInt(6);
                    if (lllllllllllllIlIlIlIllIllIIllIll == 0) {
                        lllllllllllllIlIlIlIllIllIIllIll = 4;
                    }
                    else if (lllllllllllllIlIlIlIllIllIIllIll <= 1) {
                        lllllllllllllIlIlIlIllIllIIllIll = 3;
                    }
                    else {
                        lllllllllllllIlIlIlIllIllIIllIll = 1;
                    }
                    lllllllllllllIlIlIlIllIllIIlllll[lllllllllllllIlIlIlIllIllIIlllIl + lllllllllllllIlIlIlIllIllIIllllI * lllllllllllllIlIlIlIllIllIlIIllI] = lllllllllllllIlIlIlIllIllIIllIll;
                }
            }
        }
        return lllllllllllllIlIlIlIllIllIIlllll;
    }
}
