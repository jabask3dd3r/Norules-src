package net.minecraft.world.biome;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;

public class BiomeEnd extends Biome
{
    public BiomeEnd(final BiomeProperties lllllllllllllIlIlIllIlIllllIllIl) {
        super(lllllllllllllIlIlIllIlIllllIllIl);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = Blocks.DIRT.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.theBiomeDecorator = new BiomeEndDecorator();
    }
    
    @Override
    public int getSkyColorByTemp(final float lllllllllllllIlIlIllIlIllllIlIIl) {
        return 0;
    }
}
