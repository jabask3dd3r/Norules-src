package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerRiverMix extends GenLayer
{
    private final /* synthetic */ GenLayer riverPatternGeneratorChain;
    private final /* synthetic */ GenLayer biomePatternGeneratorChain;
    
    public GenLayerRiverMix(final long lllllllllllllIlIllIlIlIIIIlIIIll, final GenLayer lllllllllllllIlIllIlIlIIIIlIIIlI, final GenLayer lllllllllllllIlIllIlIlIIIIlIIIIl) {
        super(lllllllllllllIlIllIlIlIIIIlIIIll);
        this.biomePatternGeneratorChain = lllllllllllllIlIllIlIlIIIIlIIIlI;
        this.riverPatternGeneratorChain = lllllllllllllIlIllIlIlIIIIlIIIIl;
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIlIllIlIlIIIIIIIIll, final int lllllllllllllIlIllIlIlIIIIIIlIll, final int lllllllllllllIlIllIlIlIIIIIIlIlI, final int lllllllllllllIlIllIlIlIIIIIIlIIl) {
        final int[] lllllllllllllIlIllIlIlIIIIIIlIII = this.biomePatternGeneratorChain.getInts(lllllllllllllIlIllIlIlIIIIIIIIll, lllllllllllllIlIllIlIlIIIIIIlIll, lllllllllllllIlIllIlIlIIIIIIlIlI, lllllllllllllIlIllIlIlIIIIIIlIIl);
        final int[] lllllllllllllIlIllIlIlIIIIIIIlll = this.riverPatternGeneratorChain.getInts(lllllllllllllIlIllIlIlIIIIIIIIll, lllllllllllllIlIllIlIlIIIIIIlIll, lllllllllllllIlIllIlIlIIIIIIlIlI, lllllllllllllIlIllIlIlIIIIIIlIIl);
        final int[] lllllllllllllIlIllIlIlIIIIIIIllI = IntCache.getIntCache(lllllllllllllIlIllIlIlIIIIIIlIlI * lllllllllllllIlIllIlIlIIIIIIlIIl);
        for (int lllllllllllllIlIllIlIlIIIIIIIlIl = 0; lllllllllllllIlIllIlIlIIIIIIIlIl < lllllllllllllIlIllIlIlIIIIIIlIlI * lllllllllllllIlIllIlIlIIIIIIlIIl; ++lllllllllllllIlIllIlIlIIIIIIIlIl) {
            if (lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl] != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl] != Biome.getIdForBiome(Biomes.DEEP_OCEAN)) {
                if (lllllllllllllIlIllIlIlIIIIIIIlll[lllllllllllllIlIllIlIlIIIIIIIlIl] == Biome.getIdForBiome(Biomes.RIVER)) {
                    if (lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl] == Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                        lllllllllllllIlIllIlIlIIIIIIIllI[lllllllllllllIlIllIlIlIIIIIIIlIl] = Biome.getIdForBiome(Biomes.FROZEN_RIVER);
                    }
                    else if (lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND) && lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE)) {
                        lllllllllllllIlIllIlIlIIIIIIIllI[lllllllllllllIlIllIlIlIIIIIIIlIl] = (lllllllllllllIlIllIlIlIIIIIIIlll[lllllllllllllIlIllIlIlIIIIIIIlIl] & 0xFF);
                    }
                    else {
                        lllllllllllllIlIllIlIlIIIIIIIllI[lllllllllllllIlIllIlIlIIIIIIIlIl] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE);
                    }
                }
                else {
                    lllllllllllllIlIllIlIlIIIIIIIllI[lllllllllllllIlIllIlIlIIIIIIIlIl] = lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl];
                }
            }
            else {
                lllllllllllllIlIllIlIlIIIIIIIllI[lllllllllllllIlIllIlIlIIIIIIIlIl] = lllllllllllllIlIllIlIlIIIIIIlIII[lllllllllllllIlIllIlIlIIIIIIIlIl];
            }
        }
        return lllllllllllllIlIllIlIlIIIIIIIllI;
    }
    
    @Override
    public void initWorldGenSeed(final long lllllllllllllIlIllIlIlIIIIIllIIl) {
        this.biomePatternGeneratorChain.initWorldGenSeed(lllllllllllllIlIllIlIlIIIIIllIIl);
        this.riverPatternGeneratorChain.initWorldGenSeed(lllllllllllllIlIllIlIlIIIIIllIIl);
        super.initWorldGenSeed(lllllllllllllIlIllIlIlIIIIIllIIl);
    }
}
