package net.minecraft.util;

public enum BlockRenderLayer
{
    TRANSLUCENT("TRANSLUCENT", 3, "Translucent"), 
    SOLID("SOLID", 0, "Solid");
    
    private final /* synthetic */ String layerName;
    
    CUTOUT_MIPPED("CUTOUT_MIPPED", 1, "Mipped Cutout"), 
    CUTOUT("CUTOUT", 2, "Cutout");
    
    @Override
    public String toString() {
        return this.layerName;
    }
    
    private BlockRenderLayer(final String lllllllllllllIllIIllllIIlIIlIlIl, final int lllllllllllllIllIIllllIIlIIlIlII, final String lllllllllllllIllIIllllIIlIIlIlll) {
        this.layerName = lllllllllllllIllIIllllIIlIIlIlll;
    }
}
