package net.minecraft.world.biome;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;

public class BiomeSavanna extends Biome
{
    private static final /* synthetic */ WorldGenSavannaTree SAVANNA_TREE;
    
    protected BiomeSavanna(final BiomeProperties lllllllllllllIIllIIIlIIlIlIIIlII) {
        super(lllllllllllllIIllIIIlIIlIlIIIlII);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 1, 2, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDonkey.class, 1, 1, 1));
        if (this.getBaseHeight() > 1.1f) {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 8, 4, 4));
        }
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 20;
    }
    
    @Override
    public void decorate(final World lllllllllllllIIllIIIlIIlIIlIllII, final Random lllllllllllllIIllIIIlIIlIIlIlIll, final BlockPos lllllllllllllIIllIIIlIIlIIlIlIlI) {
        BiomeSavanna.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);
        for (int lllllllllllllIIllIIIlIIlIIllIIIl = 0; lllllllllllllIIllIIIlIIlIIllIIIl < 7; ++lllllllllllllIIllIIIlIIlIIllIIIl) {
            final int lllllllllllllIIllIIIlIIlIIllIIII = lllllllllllllIIllIIIlIIlIIlIlIll.nextInt(16) + 8;
            final int lllllllllllllIIllIIIlIIlIIlIllll = lllllllllllllIIllIIIlIIlIIlIlIll.nextInt(16) + 8;
            final int lllllllllllllIIllIIIlIIlIIlIlllI = lllllllllllllIIllIIIlIIlIIlIlIll.nextInt(lllllllllllllIIllIIIlIIlIIlIllII.getHeight(lllllllllllllIIllIIIlIIlIIlIlIlI.add(lllllllllllllIIllIIIlIIlIIllIIII, 0, lllllllllllllIIllIIIlIIlIIlIllll)).getY() + 32);
            BiomeSavanna.DOUBLE_PLANT_GENERATOR.generate(lllllllllllllIIllIIIlIIlIIlIllII, lllllllllllllIIllIIIlIIlIIlIlIll, lllllllllllllIIllIIIlIIlIIlIlIlI.add(lllllllllllllIIllIIIlIIlIIllIIII, lllllllllllllIIllIIIlIIlIIlIlllI, lllllllllllllIIllIIIlIIlIIlIllll));
        }
        super.decorate(lllllllllllllIIllIIIlIIlIIlIllII, lllllllllllllIIllIIIlIIlIIlIlIll, lllllllllllllIIllIIIlIIlIIlIlIlI);
    }
    
    static {
        SAVANNA_TREE = new WorldGenSavannaTree(false);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIIllIIIlIIlIIllllll) {
        return (lllllllllllllIIllIIIlIIlIIllllll.nextInt(5) > 0) ? BiomeSavanna.SAVANNA_TREE : BiomeSavanna.TREE_FEATURE;
    }
    
    @Override
    public Class<? extends Biome> getBiomeClass() {
        return BiomeSavanna.class;
    }
}
