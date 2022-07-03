package net.minecraft.world.biome;

import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class BiomeColorHelper
{
    private static final /* synthetic */ ColorResolver WATER_COLOR;
    private static final /* synthetic */ ColorResolver GRASS_COLOR;
    private static final /* synthetic */ ColorResolver FOLIAGE_COLOR;
    
    public static int getWaterColorAtPos(final IBlockAccess lllllllllllllllIIIIIlIlIlIIllIll, final BlockPos lllllllllllllllIIIIIlIlIlIIllIII) {
        return getColorAtPos(lllllllllllllllIIIIIlIlIlIIllIll, lllllllllllllllIIIIIlIlIlIIllIII, BiomeColorHelper.WATER_COLOR);
    }
    
    static {
        GRASS_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome lllllllllllllIlllIIIIlIllIIIlIlI, final BlockPos lllllllllllllIlllIIIIlIllIIIlIll) {
                return lllllllllllllIlllIIIIlIllIIIlIlI.getGrassColorAtPos(lllllllllllllIlllIIIIlIllIIIlIll);
            }
        };
        FOLIAGE_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome llllllllllllllIIlllllIlIIIIllIll, final BlockPos llllllllllllllIIlllllIlIIIIlIlIl) {
                return llllllllllllllIIlllllIlIIIIllIll.getFoliageColorAtPos(llllllllllllllIIlllllIlIIIIlIlIl);
            }
        };
        WATER_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome llllllllllllllIllIllIllIlIIllIIl, final BlockPos llllllllllllllIllIllIllIlIIllIII) {
                return llllllllllllllIllIllIllIlIIllIIl.getWaterColor();
            }
        };
    }
    
    private static int getColorAtPos(final IBlockAccess lllllllllllllllIIIIIlIlIlIllIIlI, final BlockPos lllllllllllllllIIIIIlIlIlIlllIIl, final ColorResolver lllllllllllllllIIIIIlIlIlIlllIII) {
        int lllllllllllllllIIIIIlIlIlIllIlll = 0;
        int lllllllllllllllIIIIIlIlIlIllIllI = 0;
        int lllllllllllllllIIIIIlIlIlIllIlIl = 0;
        for (final BlockPos.MutableBlockPos lllllllllllllllIIIIIlIlIlIllIlII : BlockPos.getAllInBoxMutable(lllllllllllllllIIIIIlIlIlIlllIIl.add(-1, 0, -1), lllllllllllllllIIIIIlIlIlIlllIIl.add(1, 0, 1))) {
            final int lllllllllllllllIIIIIlIlIlIllIIll = lllllllllllllllIIIIIlIlIlIlllIII.getColorAtPos(lllllllllllllllIIIIIlIlIlIllIIlI.getBiome(lllllllllllllllIIIIIlIlIlIllIlII), lllllllllllllllIIIIIlIlIlIllIlII);
            lllllllllllllllIIIIIlIlIlIllIlll += (lllllllllllllllIIIIIlIlIlIllIIll & 0xFF0000) >> 16;
            lllllllllllllllIIIIIlIlIlIllIllI += (lllllllllllllllIIIIIlIlIlIllIIll & 0xFF00) >> 8;
            lllllllllllllllIIIIIlIlIlIllIlIl += (lllllllllllllllIIIIIlIlIlIllIIll & 0xFF);
        }
        return (lllllllllllllllIIIIIlIlIlIllIlll / 9 & 0xFF) << 16 | (lllllllllllllllIIIIIlIlIlIllIllI / 9 & 0xFF) << 8 | (lllllllllllllllIIIIIlIlIlIllIlIl / 9 & 0xFF);
    }
    
    public static int getFoliageColorAtPos(final IBlockAccess lllllllllllllllIIIIIlIlIlIlIIIIl, final BlockPos lllllllllllllllIIIIIlIlIlIlIIIII) {
        return getColorAtPos(lllllllllllllllIIIIIlIlIlIlIIIIl, lllllllllllllllIIIIIlIlIlIlIIIII, BiomeColorHelper.FOLIAGE_COLOR);
    }
    
    public static int getGrassColorAtPos(final IBlockAccess lllllllllllllllIIIIIlIlIlIlIIlll, final BlockPos lllllllllllllllIIIIIlIlIlIlIIllI) {
        return getColorAtPos(lllllllllllllllIIIIIlIlIlIlIIlll, lllllllllllllllIIIIIlIlIlIlIIllI, BiomeColorHelper.GRASS_COLOR);
    }
    
    interface ColorResolver
    {
        int getColorAtPos(final Biome p0, final BlockPos p1);
    }
}
