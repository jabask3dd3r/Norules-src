package net.minecraft.world.gen.layer;

public class GenLayerAddIsland extends GenLayer
{
    @Override
    public int[] getInts(final int llIllIIIlI, final int llIlllIlIl, final int llIlllIlII, final int llIlIlllll) {
        final int llIlllIIlI = llIllIIIlI - 1;
        final int llIlllIIIl = llIlllIlIl - 1;
        final int llIlllIIII = llIlllIlII + 2;
        final int llIllIllll = llIlIlllll + 2;
        final int[] llIllIlllI = this.parent.getInts(llIlllIIlI, llIlllIIIl, llIlllIIII, llIllIllll);
        final int[] llIllIllIl = IntCache.getIntCache(llIlllIlII * llIlIlllll);
        for (int llIllIllII = 0; llIllIllII < llIlIlllll; ++llIllIllII) {
            for (int llIllIlIll = 0; llIllIlIll < llIlllIlII; ++llIllIlIll) {
                final int llIllIlIlI = llIllIlllI[llIllIlIll + 0 + (llIllIllII + 0) * llIlllIIII];
                final int llIllIlIIl = llIllIlllI[llIllIlIll + 2 + (llIllIllII + 0) * llIlllIIII];
                final int llIllIlIII = llIllIlllI[llIllIlIll + 0 + (llIllIllII + 2) * llIlllIIII];
                final int llIllIIlll = llIllIlllI[llIllIlIll + 2 + (llIllIllII + 2) * llIlllIIII];
                final int llIllIIllI = llIllIlllI[llIllIlIll + 1 + (llIllIllII + 1) * llIlllIIII];
                this.initChunkSeed(llIllIlIll + llIllIIIlI, llIllIllII + llIlllIlIl);
                if (llIllIIllI != 0 || (llIllIlIlI == 0 && llIllIlIIl == 0 && llIllIlIII == 0 && llIllIIlll == 0)) {
                    if (llIllIIllI > 0 && (llIllIlIlI == 0 || llIllIlIIl == 0 || llIllIlIII == 0 || llIllIIlll == 0)) {
                        if (this.nextInt(5) == 0) {
                            if (llIllIIllI == 4) {
                                llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = 4;
                            }
                            else {
                                llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = 0;
                            }
                        }
                        else {
                            llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = llIllIIllI;
                        }
                    }
                    else {
                        llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = llIllIIllI;
                    }
                }
                else {
                    int llIllIIlIl = 1;
                    int llIllIIlII = 1;
                    if (llIllIlIlI != 0 && this.nextInt(llIllIIlIl++) == 0) {
                        llIllIIlII = llIllIlIlI;
                    }
                    if (llIllIlIIl != 0 && this.nextInt(llIllIIlIl++) == 0) {
                        llIllIIlII = llIllIlIIl;
                    }
                    if (llIllIlIII != 0 && this.nextInt(llIllIIlIl++) == 0) {
                        llIllIIlII = llIllIlIII;
                    }
                    if (llIllIIlll != 0 && this.nextInt(llIllIIlIl++) == 0) {
                        llIllIIlII = llIllIIlll;
                    }
                    if (this.nextInt(3) == 0) {
                        llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = llIllIIlII;
                    }
                    else if (llIllIIlII == 4) {
                        llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = 4;
                    }
                    else {
                        llIllIllIl[llIllIlIll + llIllIllII * llIlllIlII] = 0;
                    }
                }
            }
        }
        return llIllIllIl;
    }
    
    public GenLayerAddIsland(final long lllIIlIIII, final GenLayer lllIIIllll) {
        super(lllIIlIIII);
        this.parent = lllIIIllll;
    }
}
