package net.minecraft.world.gen.layer;

public class GenLayerFuzzyZoom extends GenLayerZoom
{
    @Override
    protected int selectModeOrRandom(final int lllllllllllllIIIIllIllllllIIllII, final int lllllllllllllIIIIllIllllllIlIIII, final int lllllllllllllIIIIllIllllllIIlIlI, final int lllllllllllllIIIIllIllllllIIlllI) {
        return this.selectRandom(lllllllllllllIIIIllIllllllIIllII, lllllllllllllIIIIllIllllllIlIIII, lllllllllllllIIIIllIllllllIIlIlI, lllllllllllllIIIIllIllllllIIlllI);
    }
    
    public GenLayerFuzzyZoom(final long lllllllllllllIIIIllIllllllIllIIl, final GenLayer lllllllllllllIIIIllIllllllIllIll) {
        super(lllllllllllllIIIIllIllllllIllIIl, lllllllllllllIIIIllIllllllIllIll);
    }
}
