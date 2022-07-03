package net.minecraft.world.gen.layer;

public class GenLayerEdge extends GenLayer
{
    private final /* synthetic */ Mode mode;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode() {
        final int[] $switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode = GenLayerEdge.$SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode;
        if ($switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode != null) {
            return $switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode;
        }
        final Exception lllllllllllllIlIIlIIllIIlIIlIlIl = (Object)new int[Mode.values().length];
        try {
            lllllllllllllIlIIlIIllIIlIIlIlIl[Mode.COOL_WARM.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIlIIllIIlIIlIlIl[Mode.HEAT_ICE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIlIIllIIlIIlIlIl[Mode.SPECIAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GenLayerEdge.$SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode = (int[])(Object)lllllllllllllIlIIlIIllIIlIIlIlIl;
    }
    
    private int[] getIntsCoolWarm(final int lllllllllllllIlIIlIIllIlIIIlIlll, final int lllllllllllllIlIIlIIllIlIIIlIllI, final int lllllllllllllIlIIlIIllIlIIIIIIIl, final int lllllllllllllIlIIlIIllIlIIIIIIII) {
        final int lllllllllllllIlIIlIIllIlIIIlIIll = lllllllllllllIlIIlIIllIlIIIlIlll - 1;
        final int lllllllllllllIlIIlIIllIlIIIlIIlI = lllllllllllllIlIIlIIllIlIIIlIllI - 1;
        final int lllllllllllllIlIIlIIllIlIIIlIIIl = 1 + lllllllllllllIlIIlIIllIlIIIIIIIl + 1;
        final int lllllllllllllIlIIlIIllIlIIIlIIII = 1 + lllllllllllllIlIIlIIllIlIIIIIIII + 1;
        final int[] lllllllllllllIlIIlIIllIlIIIIllll = this.parent.getInts(lllllllllllllIlIIlIIllIlIIIlIIll, lllllllllllllIlIIlIIllIlIIIlIIlI, lllllllllllllIlIIlIIllIlIIIlIIIl, lllllllllllllIlIIlIIllIlIIIlIIII);
        final int[] lllllllllllllIlIIlIIllIlIIIIlllI = IntCache.getIntCache(lllllllllllllIlIIlIIllIlIIIIIIIl * lllllllllllllIlIIlIIllIlIIIIIIII);
        for (int lllllllllllllIlIIlIIllIlIIIIllIl = 0; lllllllllllllIlIIlIIllIlIIIIllIl < lllllllllllllIlIIlIIllIlIIIIIIII; ++lllllllllllllIlIIlIIllIlIIIIllIl) {
            for (int lllllllllllllIlIIlIIllIlIIIIllII = 0; lllllllllllllIlIIlIIllIlIIIIllII < lllllllllllllIlIIlIIllIlIIIIIIIl; ++lllllllllllllIlIIlIIllIlIIIIllII) {
                this.initChunkSeed(lllllllllllllIlIIlIIllIlIIIIllII + lllllllllllllIlIIlIIllIlIIIlIlll, lllllllllllllIlIIlIIllIlIIIIllIl + lllllllllllllIlIIlIIllIlIIIlIllI);
                int lllllllllllllIlIIlIIllIlIIIIlIll = lllllllllllllIlIIlIIllIlIIIIllll[lllllllllllllIlIIlIIllIlIIIIllII + 1 + (lllllllllllllIlIIlIIllIlIIIIllIl + 1) * lllllllllllllIlIIlIIllIlIIIlIIIl];
                if (lllllllllllllIlIIlIIllIlIIIIlIll == 1) {
                    final int lllllllllllllIlIIlIIllIlIIIIlIlI = lllllllllllllIlIIlIIllIlIIIIllll[lllllllllllllIlIIlIIllIlIIIIllII + 1 + (lllllllllllllIlIIlIIllIlIIIIllIl + 1 - 1) * lllllllllllllIlIIlIIllIlIIIlIIIl];
                    final int lllllllllllllIlIIlIIllIlIIIIlIIl = lllllllllllllIlIIlIIllIlIIIIllll[lllllllllllllIlIIlIIllIlIIIIllII + 1 + 1 + (lllllllllllllIlIIlIIllIlIIIIllIl + 1) * lllllllllllllIlIIlIIllIlIIIlIIIl];
                    final int lllllllllllllIlIIlIIllIlIIIIlIII = lllllllllllllIlIIlIIllIlIIIIllll[lllllllllllllIlIIlIIllIlIIIIllII + 1 - 1 + (lllllllllllllIlIIlIIllIlIIIIllIl + 1) * lllllllllllllIlIIlIIllIlIIIlIIIl];
                    final int lllllllllllllIlIIlIIllIlIIIIIlll = lllllllllllllIlIIlIIllIlIIIIllll[lllllllllllllIlIIlIIllIlIIIIllII + 1 + (lllllllllllllIlIIlIIllIlIIIIllIl + 1 + 1) * lllllllllllllIlIIlIIllIlIIIlIIIl];
                    final boolean lllllllllllllIlIIlIIllIlIIIIIllI = lllllllllllllIlIIlIIllIlIIIIlIlI == 3 || lllllllllllllIlIIlIIllIlIIIIlIIl == 3 || lllllllllllllIlIIlIIllIlIIIIlIII == 3 || lllllllllllllIlIIlIIllIlIIIIIlll == 3;
                    final boolean lllllllllllllIlIIlIIllIlIIIIIlIl = lllllllllllllIlIIlIIllIlIIIIlIlI == 4 || lllllllllllllIlIIlIIllIlIIIIlIIl == 4 || lllllllllllllIlIIlIIllIlIIIIlIII == 4 || lllllllllllllIlIIlIIllIlIIIIIlll == 4;
                    if (lllllllllllllIlIIlIIllIlIIIIIllI || lllllllllllllIlIIlIIllIlIIIIIlIl) {
                        lllllllllllllIlIIlIIllIlIIIIlIll = 2;
                    }
                }
                lllllllllllllIlIIlIIllIlIIIIlllI[lllllllllllllIlIIlIIllIlIIIIllII + lllllllllllllIlIIlIIllIlIIIIllIl * lllllllllllllIlIIlIIllIlIIIIIIIl] = lllllllllllllIlIIlIIllIlIIIIlIll;
            }
        }
        return lllllllllllllIlIIlIIllIlIIIIlllI;
    }
    
    public GenLayerEdge(final long lllllllllllllIlIIlIIllIlIlIIIIlI, final GenLayer lllllllllllllIlIIlIIllIlIIllllIl, final Mode lllllllllllllIlIIlIIllIlIIllllII) {
        super(lllllllllllllIlIIlIIllIlIlIIIIlI);
        this.parent = lllllllllllllIlIIlIIllIlIIllllIl;
        this.mode = lllllllllllllIlIIlIIllIlIIllllII;
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIlIIlIIllIlIIllIIII, final int lllllllllllllIlIIlIIllIlIIlIllll, final int lllllllllllllIlIIlIIllIlIIlIlllI, final int lllllllllllllIlIIlIIllIlIIllIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode()[this.mode.ordinal()]) {
            default: {
                return this.getIntsCoolWarm(lllllllllllllIlIIlIIllIlIIllIIII, lllllllllllllIlIIlIIllIlIIlIllll, lllllllllllllIlIIlIIllIlIIlIlllI, lllllllllllllIlIIlIIllIlIIllIIlI);
            }
            case 2: {
                return this.getIntsHeatIce(lllllllllllllIlIIlIIllIlIIllIIII, lllllllllllllIlIIlIIllIlIIlIllll, lllllllllllllIlIIlIIllIlIIlIlllI, lllllllllllllIlIIlIIllIlIIllIIlI);
            }
            case 3: {
                return this.getIntsSpecial(lllllllllllllIlIIlIIllIlIIllIIII, lllllllllllllIlIIlIIllIlIIlIllll, lllllllllllllIlIIlIIllIlIIlIlllI, lllllllllllllIlIIlIIllIlIIllIIlI);
            }
        }
    }
    
    private int[] getIntsSpecial(final int lllllllllllllIlIIlIIllIIlIlIlIIl, final int lllllllllllllIlIIlIIllIIlIlIlIII, final int lllllllllllllIlIIlIIllIIlIlIIlll, final int lllllllllllllIlIIlIIllIIlIIlllII) {
        final int[] lllllllllllllIlIIlIIllIIlIlIIlIl = this.parent.getInts(lllllllllllllIlIIlIIllIIlIlIlIIl, lllllllllllllIlIIlIIllIIlIlIlIII, lllllllllllllIlIIlIIllIIlIlIIlll, lllllllllllllIlIIlIIllIIlIIlllII);
        final int[] lllllllllllllIlIIlIIllIIlIlIIlII = IntCache.getIntCache(lllllllllllllIlIIlIIllIIlIlIIlll * lllllllllllllIlIIlIIllIIlIIlllII);
        for (int lllllllllllllIlIIlIIllIIlIlIIIll = 0; lllllllllllllIlIIlIIllIIlIlIIIll < lllllllllllllIlIIlIIllIIlIIlllII; ++lllllllllllllIlIIlIIllIIlIlIIIll) {
            for (int lllllllllllllIlIIlIIllIIlIlIIIlI = 0; lllllllllllllIlIIlIIllIIlIlIIIlI < lllllllllllllIlIIlIIllIIlIlIIlll; ++lllllllllllllIlIIlIIllIIlIlIIIlI) {
                this.initChunkSeed(lllllllllllllIlIIlIIllIIlIlIIIlI + lllllllllllllIlIIlIIllIIlIlIlIIl, lllllllllllllIlIIlIIllIIlIlIIIll + lllllllllllllIlIIlIIllIIlIlIlIII);
                int lllllllllllllIlIIlIIllIIlIlIIIIl = lllllllllllllIlIIlIIllIIlIlIIlIl[lllllllllllllIlIIlIIllIIlIlIIIlI + lllllllllllllIlIIlIIllIIlIlIIIll * lllllllllllllIlIIlIIllIIlIlIIlll];
                if (lllllllllllllIlIIlIIllIIlIlIIIIl != 0 && this.nextInt(13) == 0) {
                    lllllllllllllIlIIlIIllIIlIlIIIIl |= (1 + this.nextInt(15) << 8 & 0xF00);
                }
                lllllllllllllIlIIlIIllIIlIlIIlII[lllllllllllllIlIIlIIllIIlIlIIIlI + lllllllllllllIlIIlIIllIIlIlIIIll * lllllllllllllIlIIlIIllIIlIlIIlll] = lllllllllllllIlIIlIIllIIlIlIIIIl;
            }
        }
        return lllllllllllllIlIIlIIllIIlIlIIlII;
    }
    
    private int[] getIntsHeatIce(final int lllllllllllllIlIIlIIllIIllIllIll, final int lllllllllllllIlIIlIIllIIllIIIllI, final int lllllllllllllIlIIlIIllIIllIllIIl, final int lllllllllllllIlIIlIIllIIllIllIII) {
        final int lllllllllllllIlIIlIIllIIllIlIlll = lllllllllllllIlIIlIIllIIllIllIll - 1;
        final int lllllllllllllIlIIlIIllIIllIlIllI = lllllllllllllIlIIlIIllIIllIIIllI - 1;
        final int lllllllllllllIlIIlIIllIIllIlIlIl = 1 + lllllllllllllIlIIlIIllIIllIllIIl + 1;
        final int lllllllllllllIlIIlIIllIIllIlIlII = 1 + lllllllllllllIlIIlIIllIIllIllIII + 1;
        final int[] lllllllllllllIlIIlIIllIIllIlIIll = this.parent.getInts(lllllllllllllIlIIlIIllIIllIlIlll, lllllllllllllIlIIlIIllIIllIlIllI, lllllllllllllIlIIlIIllIIllIlIlIl, lllllllllllllIlIIlIIllIIllIlIlII);
        final int[] lllllllllllllIlIIlIIllIIllIlIIlI = IntCache.getIntCache(lllllllllllllIlIIlIIllIIllIllIIl * lllllllllllllIlIIlIIllIIllIllIII);
        for (int lllllllllllllIlIIlIIllIIllIlIIIl = 0; lllllllllllllIlIIlIIllIIllIlIIIl < lllllllllllllIlIIlIIllIIllIllIII; ++lllllllllllllIlIIlIIllIIllIlIIIl) {
            for (int lllllllllllllIlIIlIIllIIllIlIIII = 0; lllllllllllllIlIIlIIllIIllIlIIII < lllllllllllllIlIIlIIllIIllIllIIl; ++lllllllllllllIlIIlIIllIIllIlIIII) {
                int lllllllllllllIlIIlIIllIIllIIllll = lllllllllllllIlIIlIIllIIllIlIIll[lllllllllllllIlIIlIIllIIllIlIIII + 1 + (lllllllllllllIlIIlIIllIIllIlIIIl + 1) * lllllllllllllIlIIlIIllIIllIlIlIl];
                if (lllllllllllllIlIIlIIllIIllIIllll == 4) {
                    final int lllllllllllllIlIIlIIllIIllIIlllI = lllllllllllllIlIIlIIllIIllIlIIll[lllllllllllllIlIIlIIllIIllIlIIII + 1 + (lllllllllllllIlIIlIIllIIllIlIIIl + 1 - 1) * lllllllllllllIlIIlIIllIIllIlIlIl];
                    final int lllllllllllllIlIIlIIllIIllIIllIl = lllllllllllllIlIIlIIllIIllIlIIll[lllllllllllllIlIIlIIllIIllIlIIII + 1 + 1 + (lllllllllllllIlIIlIIllIIllIlIIIl + 1) * lllllllllllllIlIIlIIllIIllIlIlIl];
                    final int lllllllllllllIlIIlIIllIIllIIllII = lllllllllllllIlIIlIIllIIllIlIIll[lllllllllllllIlIIlIIllIIllIlIIII + 1 - 1 + (lllllllllllllIlIIlIIllIIllIlIIIl + 1) * lllllllllllllIlIIlIIllIIllIlIlIl];
                    final int lllllllllllllIlIIlIIllIIllIIlIll = lllllllllllllIlIIlIIllIIllIlIIll[lllllllllllllIlIIlIIllIIllIlIIII + 1 + (lllllllllllllIlIIlIIllIIllIlIIIl + 1 + 1) * lllllllllllllIlIIlIIllIIllIlIlIl];
                    final boolean lllllllllllllIlIIlIIllIIllIIlIlI = lllllllllllllIlIIlIIllIIllIIlllI == 2 || lllllllllllllIlIIlIIllIIllIIllIl == 2 || lllllllllllllIlIIlIIllIIllIIllII == 2 || lllllllllllllIlIIlIIllIIllIIlIll == 2;
                    final boolean lllllllllllllIlIIlIIllIIllIIlIIl = lllllllllllllIlIIlIIllIIllIIlllI == 1 || lllllllllllllIlIIlIIllIIllIIllIl == 1 || lllllllllllllIlIIlIIllIIllIIllII == 1 || lllllllllllllIlIIlIIllIIllIIlIll == 1;
                    if (lllllllllllllIlIIlIIllIIllIIlIIl || lllllllllllllIlIIlIIllIIllIIlIlI) {
                        lllllllllllllIlIIlIIllIIllIIllll = 3;
                    }
                }
                lllllllllllllIlIIlIIllIIllIlIIlI[lllllllllllllIlIIlIIllIIllIlIIII + lllllllllllllIlIIlIIllIIllIlIIIl * lllllllllllllIlIIlIIllIIllIllIIl] = lllllllllllllIlIIlIIllIIllIIllll;
            }
        }
        return lllllllllllllIlIIlIIllIIllIlIIlI;
    }
    
    public enum Mode
    {
        COOL_WARM("COOL_WARM", 0), 
        SPECIAL("SPECIAL", 2), 
        HEAT_ICE("HEAT_ICE", 1);
        
        private Mode(final String lIIllIlIIll, final int lIIllIlIIlI) {
        }
    }
}
