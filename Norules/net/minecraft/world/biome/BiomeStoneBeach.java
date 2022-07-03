package net.minecraft.world.biome;

import net.minecraft.init.*;

public class BiomeStoneBeach extends Biome
{
    public BiomeStoneBeach(final BiomeProperties lllllllllllllIIlIllIIlIIIIllllIl) {
        super(lllllllllllllIIlIllIIlIIIIllllIl);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.STONE.getDefaultState();
        this.fillerBlock = Blocks.STONE.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.cactiPerChunk = 0;
    }
}
