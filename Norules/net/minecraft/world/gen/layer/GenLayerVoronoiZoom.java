package net.minecraft.world.gen.layer;

public class GenLayerVoronoiZoom extends GenLayer
{
    @Override
    public int[] getInts(int lllllllllllllIlIIlllllIlIlIIllII, int lllllllllllllIlIIlllllIlIlIIlIll, final int lllllllllllllIlIIlllllIlIlIIlIlI, final int lllllllllllllIlIIlllllIlIIlIIlII) {
        lllllllllllllIlIIlllllIlIlIIllII -= 2;
        lllllllllllllIlIIlllllIlIlIIlIll -= 2;
        final int lllllllllllllIlIIlllllIlIlIIlIII = lllllllllllllIlIIlllllIlIlIIllII >> 2;
        final int lllllllllllllIlIIlllllIlIlIIIlll = lllllllllllllIlIIlllllIlIlIIlIll >> 2;
        final int lllllllllllllIlIIlllllIlIlIIIllI = (lllllllllllllIlIIlllllIlIlIIlIlI >> 2) + 2;
        final int lllllllllllllIlIIlllllIlIlIIIlIl = (lllllllllllllIlIIlllllIlIIlIIlII >> 2) + 2;
        final int[] lllllllllllllIlIIlllllIlIlIIIlII = this.parent.getInts(lllllllllllllIlIIlllllIlIlIIlIII, lllllllllllllIlIIlllllIlIlIIIlll, lllllllllllllIlIIlllllIlIlIIIllI, lllllllllllllIlIIlllllIlIlIIIlIl);
        final int lllllllllllllIlIIlllllIlIlIIIIll = lllllllllllllIlIIlllllIlIlIIIllI - 1 << 2;
        final int lllllllllllllIlIIlllllIlIlIIIIlI = lllllllllllllIlIIlllllIlIlIIIlIl - 1 << 2;
        final int[] lllllllllllllIlIIlllllIlIlIIIIIl = IntCache.getIntCache(lllllllllllllIlIIlllllIlIlIIIIll * lllllllllllllIlIIlllllIlIlIIIIlI);
        for (int lllllllllllllIlIIlllllIlIlIIIIII = 0; lllllllllllllIlIIlllllIlIlIIIIII < lllllllllllllIlIIlllllIlIlIIIlIl - 1; ++lllllllllllllIlIIlllllIlIlIIIIII) {
            int lllllllllllllIlIIlllllIlIIllllll = 0;
            int lllllllllllllIlIIlllllIlIIlllllI = lllllllllllllIlIIlllllIlIlIIIlII[lllllllllllllIlIIlllllIlIIllllll + 0 + (lllllllllllllIlIIlllllIlIlIIIIII + 0) * lllllllllllllIlIIlllllIlIlIIIllI];
            int lllllllllllllIlIIlllllIlIIllllIl = lllllllllllllIlIIlllllIlIlIIIlII[lllllllllllllIlIIlllllIlIIllllll + 0 + (lllllllllllllIlIIlllllIlIlIIIIII + 1) * lllllllllllllIlIIlllllIlIlIIIllI];
            while (lllllllllllllIlIIlllllIlIIllllll < lllllllllllllIlIIlllllIlIlIIIllI - 1) {
                final double lllllllllllllIlIIlllllIlIIllllII = 3.6;
                this.initChunkSeed(lllllllllllllIlIIlllllIlIIllllll + lllllllllllllIlIIlllllIlIlIIlIII << 2, lllllllllllllIlIIlllllIlIlIIIIII + lllllllllllllIlIIlllllIlIlIIIlll << 2);
                final double lllllllllllllIlIIlllllIlIIlllIll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double lllllllllllllIlIIlllllIlIIlllIlI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(lllllllllllllIlIIlllllIlIIllllll + lllllllllllllIlIIlllllIlIlIIlIII + 1 << 2, lllllllllllllIlIIlllllIlIlIIIIII + lllllllllllllIlIIlllllIlIlIIIlll << 2);
                final double lllllllllllllIlIIlllllIlIIlllIIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double lllllllllllllIlIIlllllIlIIlllIII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                this.initChunkSeed(lllllllllllllIlIIlllllIlIIllllll + lllllllllllllIlIIlllllIlIlIIlIII << 2, lllllllllllllIlIIlllllIlIlIIIIII + lllllllllllllIlIIlllllIlIlIIIlll + 1 << 2);
                final double lllllllllllllIlIIlllllIlIIllIlll = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6;
                final double lllllllllllllIlIIlllllIlIIllIllI = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                this.initChunkSeed(lllllllllllllIlIIlllllIlIIllllll + lllllllllllllIlIIlllllIlIlIIlIII + 1 << 2, lllllllllllllIlIIlllllIlIlIIIIII + lllllllllllllIlIIlllllIlIlIIIlll + 1 << 2);
                final double lllllllllllllIlIIlllllIlIIllIlIl = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final double lllllllllllllIlIIlllllIlIIllIlII = (this.nextInt(1024) / 1024.0 - 0.5) * 3.6 + 4.0;
                final int lllllllllllllIlIIlllllIlIIllIIll = lllllllllllllIlIIlllllIlIlIIIlII[lllllllllllllIlIIlllllIlIIllllll + 1 + (lllllllllllllIlIIlllllIlIlIIIIII + 0) * lllllllllllllIlIIlllllIlIlIIIllI] & 0xFF;
                final int lllllllllllllIlIIlllllIlIIllIIlI = lllllllllllllIlIIlllllIlIlIIIlII[lllllllllllllIlIIlllllIlIIllllll + 1 + (lllllllllllllIlIIlllllIlIlIIIIII + 1) * lllllllllllllIlIIlllllIlIlIIIllI] & 0xFF;
                for (int lllllllllllllIlIIlllllIlIIllIIIl = 0; lllllllllllllIlIIlllllIlIIllIIIl < 4; ++lllllllllllllIlIIlllllIlIIllIIIl) {
                    int lllllllllllllIlIIlllllIlIIllIIII = ((lllllllllllllIlIIlllllIlIlIIIIII << 2) + lllllllllllllIlIIlllllIlIIllIIIl) * lllllllllllllIlIIlllllIlIlIIIIll + (lllllllllllllIlIIlllllIlIIllllll << 2);
                    for (int lllllllllllllIlIIlllllIlIIlIllll = 0; lllllllllllllIlIIlllllIlIIlIllll < 4; ++lllllllllllllIlIIlllllIlIIlIllll) {
                        final double lllllllllllllIlIIlllllIlIIlIlllI = (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIlllIlI) * (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIlllIlI) + (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIlllIll) * (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIlllIll);
                        final double lllllllllllllIlIIlllllIlIIlIllIl = (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIlllIII) * (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIlllIII) + (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIlllIIl) * (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIlllIIl);
                        final double lllllllllllllIlIIlllllIlIIlIllII = (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIllIllI) * (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIllIllI) + (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIllIlll) * (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIllIlll);
                        final double lllllllllllllIlIIlllllIlIIlIlIll = (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIllIlII) * (lllllllllllllIlIIlllllIlIIllIIIl - lllllllllllllIlIIlllllIlIIllIlII) + (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIllIlIl) * (lllllllllllllIlIIlllllIlIIlIllll - lllllllllllllIlIIlllllIlIIllIlIl);
                        if (lllllllllllllIlIIlllllIlIIlIlllI < lllllllllllllIlIIlllllIlIIlIllIl && lllllllllllllIlIIlllllIlIIlIlllI < lllllllllllllIlIIlllllIlIIlIllII && lllllllllllllIlIIlllllIlIIlIlllI < lllllllllllllIlIIlllllIlIIlIlIll) {
                            lllllllllllllIlIIlllllIlIlIIIIIl[lllllllllllllIlIIlllllIlIIllIIII++] = lllllllllllllIlIIlllllIlIIlllllI;
                        }
                        else if (lllllllllllllIlIIlllllIlIIlIllIl < lllllllllllllIlIIlllllIlIIlIlllI && lllllllllllllIlIIlllllIlIIlIllIl < lllllllllllllIlIIlllllIlIIlIllII && lllllllllllllIlIIlllllIlIIlIllIl < lllllllllllllIlIIlllllIlIIlIlIll) {
                            lllllllllllllIlIIlllllIlIlIIIIIl[lllllllllllllIlIIlllllIlIIllIIII++] = lllllllllllllIlIIlllllIlIIllIIll;
                        }
                        else if (lllllllllllllIlIIlllllIlIIlIllII < lllllllllllllIlIIlllllIlIIlIlllI && lllllllllllllIlIIlllllIlIIlIllII < lllllllllllllIlIIlllllIlIIlIllIl && lllllllllllllIlIIlllllIlIIlIllII < lllllllllllllIlIIlllllIlIIlIlIll) {
                            lllllllllllllIlIIlllllIlIlIIIIIl[lllllllllllllIlIIlllllIlIIllIIII++] = lllllllllllllIlIIlllllIlIIllllIl;
                        }
                        else {
                            lllllllllllllIlIIlllllIlIlIIIIIl[lllllllllllllIlIIlllllIlIIllIIII++] = lllllllllllllIlIIlllllIlIIllIIlI;
                        }
                    }
                }
                lllllllllllllIlIIlllllIlIIlllllI = lllllllllllllIlIIlllllIlIIllIIll;
                lllllllllllllIlIIlllllIlIIllllIl = lllllllllllllIlIIlllllIlIIllIIlI;
                ++lllllllllllllIlIIlllllIlIIllllll;
            }
        }
        final int[] lllllllllllllIlIIlllllIlIIlIlIlI = IntCache.getIntCache(lllllllllllllIlIIlllllIlIlIIlIlI * lllllllllllllIlIIlllllIlIIlIIlII);
        for (int lllllllllllllIlIIlllllIlIIlIlIIl = 0; lllllllllllllIlIIlllllIlIIlIlIIl < lllllllllllllIlIIlllllIlIIlIIlII; ++lllllllllllllIlIIlllllIlIIlIlIIl) {
            System.arraycopy(lllllllllllllIlIIlllllIlIlIIIIIl, (lllllllllllllIlIIlllllIlIIlIlIIl + (lllllllllllllIlIIlllllIlIlIIlIll & 0x3)) * lllllllllllllIlIIlllllIlIlIIIIll + (lllllllllllllIlIIlllllIlIlIIllII & 0x3), lllllllllllllIlIIlllllIlIIlIlIlI, lllllllllllllIlIIlllllIlIIlIlIIl * lllllllllllllIlIIlllllIlIlIIlIlI, lllllllllllllIlIIlllllIlIlIIlIlI);
        }
        return lllllllllllllIlIIlllllIlIIlIlIlI;
    }
    
    public GenLayerVoronoiZoom(final long lllllllllllllIlIIlllllIlIlllIIlI, final GenLayer lllllllllllllIlIIlllllIlIlllIIIl) {
        super(lllllllllllllIlIIlllllIlIlllIIlI);
        super.parent = lllllllllllllIlIIlllllIlIlllIIIl;
    }
}
