package net.minecraft.world.biome;

import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;

public class BiomeTaiga extends Biome
{
    private static final /* synthetic */ WorldGenTaiga1 PINE_GENERATOR;
    private final /* synthetic */ Type type;
    private static final /* synthetic */ WorldGenBlockBlob FOREST_ROCK_GENERATOR;
    private static final /* synthetic */ WorldGenMegaPineTree MEGA_PINE_GENERATOR;
    private static final /* synthetic */ WorldGenMegaPineTree MEGA_SPRUCE_GENERATOR;
    private static final /* synthetic */ WorldGenTaiga2 SPRUCE_GENERATOR;
    
    static {
        PINE_GENERATOR = new WorldGenTaiga1();
        SPRUCE_GENERATOR = new WorldGenTaiga2(false);
        MEGA_PINE_GENERATOR = new WorldGenMegaPineTree(false, false);
        MEGA_SPRUCE_GENERATOR = new WorldGenMegaPineTree(false, true);
        FOREST_ROCK_GENERATOR = new WorldGenBlockBlob(Blocks.MOSSY_COBBLESTONE, 0);
    }
    
    @Override
    public void genTerrainBlocks(final World lllllllllllllIlIIIllIllIlIlllIII, final Random lllllllllllllIlIIIllIllIlIllIlll, final ChunkPrimer lllllllllllllIlIIIllIllIlIllIllI, final int lllllllllllllIlIIIllIllIlIllIlIl, final int lllllllllllllIlIIIllIllIlIlllIll, final double lllllllllllllIlIIIllIllIlIllIIll) {
        if (this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();
            if (lllllllllllllIlIIIllIllIlIllIIll > 1.75) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            }
            else if (lllllllllllllIlIIIllIllIlIllIIll > -0.95) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }
        }
        this.generateBiomeTerrain(lllllllllllllIlIIIllIllIlIlllIII, lllllllllllllIlIIIllIllIlIllIlll, lllllllllllllIlIIIllIllIlIllIllI, lllllllllllllIlIIIllIllIlIllIlIl, lllllllllllllIlIIIllIllIlIlllIll, lllllllllllllIlIIIllIllIlIllIIll);
    }
    
    public BiomeTaiga(final Type lllllllllllllIlIIIllIllIllllIlIl, final BiomeProperties lllllllllllllIlIIIllIllIllllIlII) {
        super(lllllllllllllIlIIIllIllIllllIlII);
        this.type = lllllllllllllIlIIIllIllIllllIlIl;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.theBiomeDecorator.treesPerChunk = 10;
        if (lllllllllllllIlIIIllIllIllllIlIl != Type.MEGA && lllllllllllllIlIIIllIllIllllIlIl != Type.MEGA_SPRUCE) {
            this.theBiomeDecorator.grassPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 1;
        }
        else {
            this.theBiomeDecorator.grassPerChunk = 7;
            this.theBiomeDecorator.deadBushPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 3;
        }
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIlIIIllIllIlllIllIl) {
        if ((this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) && lllllllllllllIlIIIllIllIlllIllIl.nextInt(3) == 0) {
            return (this.type != Type.MEGA_SPRUCE && lllllllllllllIlIIIllIllIlllIllIl.nextInt(13) != 0) ? BiomeTaiga.MEGA_PINE_GENERATOR : BiomeTaiga.MEGA_SPRUCE_GENERATOR;
        }
        return (lllllllllllllIlIIIllIllIlllIllIl.nextInt(3) == 0) ? BiomeTaiga.PINE_GENERATOR : BiomeTaiga.SPRUCE_GENERATOR;
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random lllllllllllllIlIIIllIllIlllIlIII) {
        return (lllllllllllllIlIIIllIllIlllIlIII.nextInt(5) > 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @Override
    public void decorate(final World lllllllllllllIlIIIllIllIllIIllll, final Random lllllllllllllIlIIIllIllIllIllIll, final BlockPos lllllllllllllIlIIIllIllIllIIllIl) {
        if (this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) {
            for (int lllllllllllllIlIIIllIllIllIllIIl = lllllllllllllIlIIIllIllIllIllIll.nextInt(3), lllllllllllllIlIIIllIllIllIllIII = 0; lllllllllllllIlIIIllIllIllIllIII < lllllllllllllIlIIIllIllIllIllIIl; ++lllllllllllllIlIIIllIllIllIllIII) {
                final int lllllllllllllIlIIIllIllIllIlIlll = lllllllllllllIlIIIllIllIllIllIll.nextInt(16) + 8;
                final int lllllllllllllIlIIIllIllIllIlIllI = lllllllllllllIlIIIllIllIllIllIll.nextInt(16) + 8;
                final BlockPos lllllllllllllIlIIIllIllIllIlIlIl = lllllllllllllIlIIIllIllIllIIllll.getHeight(lllllllllllllIlIIIllIllIllIIllIl.add(lllllllllllllIlIIIllIllIllIlIlll, 0, lllllllllllllIlIIIllIllIllIlIllI));
                BiomeTaiga.FOREST_ROCK_GENERATOR.generate(lllllllllllllIlIIIllIllIllIIllll, lllllllllllllIlIIIllIllIllIllIll, lllllllllllllIlIIIllIllIllIlIlIl);
            }
        }
        BiomeTaiga.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);
        for (int lllllllllllllIlIIIllIllIllIlIlII = 0; lllllllllllllIlIIIllIllIllIlIlII < 7; ++lllllllllllllIlIIIllIllIllIlIlII) {
            final int lllllllllllllIlIIIllIllIllIlIIll = lllllllllllllIlIIIllIllIllIllIll.nextInt(16) + 8;
            final int lllllllllllllIlIIIllIllIllIlIIlI = lllllllllllllIlIIIllIllIllIllIll.nextInt(16) + 8;
            final int lllllllllllllIlIIIllIllIllIlIIIl = lllllllllllllIlIIIllIllIllIllIll.nextInt(lllllllllllllIlIIIllIllIllIIllll.getHeight(lllllllllllllIlIIIllIllIllIIllIl.add(lllllllllllllIlIIIllIllIllIlIIll, 0, lllllllllllllIlIIIllIllIllIlIIlI)).getY() + 32);
            BiomeTaiga.DOUBLE_PLANT_GENERATOR.generate(lllllllllllllIlIIIllIllIllIIllll, lllllllllllllIlIIIllIllIllIllIll, lllllllllllllIlIIIllIllIllIIllIl.add(lllllllllllllIlIIIllIllIllIlIIll, lllllllllllllIlIIIllIllIllIlIIIl, lllllllllllllIlIIIllIllIllIlIIlI));
        }
        super.decorate(lllllllllllllIlIIIllIllIllIIllll, lllllllllllllIlIIIllIllIllIllIll, lllllllllllllIlIIIllIllIllIIllIl);
    }
    
    public enum Type
    {
        MEGA("MEGA", 1), 
        NORMAL("NORMAL", 0), 
        MEGA_SPRUCE("MEGA_SPRUCE", 2);
        
        private Type(final String llllllllllllllIIIllIllIllIlIllll, final int llllllllllllllIIIllIllIllIlIlllI) {
        }
    }
}
