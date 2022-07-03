package net.minecraft.world;

public class ColorizerFoliage
{
    private static /* synthetic */ int[] foliageBuffer;
    
    public static int getFoliageColor(final double lllllllllllllllIIlIIlIlIIIIIlIIl, double lllllllllllllllIIlIIlIlIIIIIlIII) {
        lllllllllllllllIIlIIlIlIIIIIlIII *= lllllllllllllllIIlIIlIlIIIIIlIIl;
        final int lllllllllllllllIIlIIlIlIIIIIlIll = (int)((1.0 - lllllllllllllllIIlIIlIlIIIIIlIIl) * 255.0);
        final int lllllllllllllllIIlIIlIlIIIIIlIlI = (int)((1.0 - lllllllllllllllIIlIIlIlIIIIIlIII) * 255.0);
        return ColorizerFoliage.foliageBuffer[lllllllllllllllIIlIIlIlIIIIIlIlI << 8 | lllllllllllllllIIlIIlIlIIIIIlIll];
    }
    
    public static void setFoliageBiomeColorizer(final int[] lllllllllllllllIIlIIlIlIIIIlIIll) {
        ColorizerFoliage.foliageBuffer = lllllllllllllllIIlIIlIlIIIIlIIll;
    }
    
    public static int getFoliageColorBirch() {
        return 8431445;
    }
    
    static {
        ColorizerFoliage.foliageBuffer = new int[65536];
    }
    
    public static int getFoliageColorPine() {
        return 6396257;
    }
    
    public static int getFoliageColorBasic() {
        return 4764952;
    }
}
