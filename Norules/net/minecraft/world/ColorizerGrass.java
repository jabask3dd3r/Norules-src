package net.minecraft.world;

public class ColorizerGrass
{
    private static /* synthetic */ int[] grassBuffer;
    
    public static void setGrassBiomeColorizer(final int[] llllllllllllllIIlIIIIIIlIlIllIIl) {
        ColorizerGrass.grassBuffer = llllllllllllllIIlIIIIIIlIlIllIIl;
    }
    
    static {
        ColorizerGrass.grassBuffer = new int[65536];
    }
    
    public static int getGrassColor(final double llllllllllllllIIlIIIIIIlIlIlIIlI, double llllllllllllllIIlIIIIIIlIlIIllII) {
        llllllllllllllIIlIIIIIIlIlIIllII *= llllllllllllllIIlIIIIIIlIlIlIIlI;
        final int llllllllllllllIIlIIIIIIlIlIlIIII = (int)((1.0 - llllllllllllllIIlIIIIIIlIlIlIIlI) * 255.0);
        final int llllllllllllllIIlIIIIIIlIlIIllll = (int)((1.0 - llllllllllllllIIlIIIIIIlIlIIllII) * 255.0);
        final int llllllllllllllIIlIIIIIIlIlIIlllI = llllllllllllllIIlIIIIIIlIlIIllll << 8 | llllllllllllllIIlIIIIIIlIlIlIIII;
        return (llllllllllllllIIlIIIIIIlIlIIlllI > ColorizerGrass.grassBuffer.length) ? -65281 : ColorizerGrass.grassBuffer[llllllllllllllIIlIIIIIIlIlIIlllI];
    }
}
