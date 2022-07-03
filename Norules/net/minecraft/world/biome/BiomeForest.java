package net.minecraft.world.biome;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class BiomeForest extends Biome
{
    private final /* synthetic */ Type type;
    protected static final /* synthetic */ WorldGenBirchTree BIRCH_TREE;
    protected static final /* synthetic */ WorldGenCanopyTree ROOF_TREE;
    
    static {
        SUPER_BIRCH_TREE = new WorldGenBirchTree(false, true);
        BIRCH_TREE = new WorldGenBirchTree(false, false);
        ROOF_TREE = new WorldGenCanopyTree(false);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIllIllIIIllIIIIIIIl) {
        if (this.type == Type.ROOFED && lllllllllllllIllIllIIIllIIIIIIIl.nextInt(3) > 0) {
            return BiomeForest.ROOF_TREE;
        }
        if (this.type != Type.BIRCH && lllllllllllllIllIllIIIllIIIIIIIl.nextInt(5) != 0) {
            return (lllllllllllllIllIllIIIllIIIIIIIl.nextInt(10) == 0) ? BiomeForest.BIG_TREE_FEATURE : BiomeForest.TREE_FEATURE;
        }
        return BiomeForest.BIRCH_TREE;
    }
    
    protected void addDoublePlants(final World lllllllllllllIllIllIIIlIlIllIIlI, final Random lllllllllllllIllIllIIIlIlIlIIlll, final BlockPos lllllllllllllIllIllIIIlIlIllIIII, final int lllllllllllllIllIllIIIlIlIlIIlIl) {
        for (int lllllllllllllIllIllIIIlIlIlIlllI = 0; lllllllllllllIllIllIIIlIlIlIlllI < lllllllllllllIllIllIIIlIlIlIIlIl; ++lllllllllllllIllIllIIIlIlIlIlllI) {
            final int lllllllllllllIllIllIIIlIlIlIllIl = lllllllllllllIllIllIIIlIlIlIIlll.nextInt(3);
            if (lllllllllllllIllIllIIIlIlIlIllIl == 0) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
            }
            else if (lllllllllllllIllIllIIIlIlIlIllIl == 1) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
            }
            else if (lllllllllllllIllIllIIIlIlIlIllIl == 2) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
            }
            for (int lllllllllllllIllIllIIIlIlIlIllII = 0; lllllllllllllIllIllIIIlIlIlIllII < 5; ++lllllllllllllIllIllIIIlIlIlIllII) {
                final int lllllllllllllIllIllIIIlIlIlIlIll = lllllllllllllIllIllIIIlIlIlIIlll.nextInt(16) + 8;
                final int lllllllllllllIllIllIIIlIlIlIlIlI = lllllllllllllIllIllIIIlIlIlIIlll.nextInt(16) + 8;
                final int lllllllllllllIllIllIIIlIlIlIlIIl = lllllllllllllIllIllIIIlIlIlIIlll.nextInt(lllllllllllllIllIllIIIlIlIllIIlI.getHeight(lllllllllllllIllIllIIIlIlIllIIII.add(lllllllllllllIllIllIIIlIlIlIlIll, 0, lllllllllllllIllIllIIIlIlIlIlIlI)).getY() + 32);
                if (BiomeForest.DOUBLE_PLANT_GENERATOR.generate(lllllllllllllIllIllIIIlIlIllIIlI, lllllllllllllIllIllIIIlIlIlIIlll, new BlockPos(lllllllllllllIllIllIIIlIlIllIIII.getX() + lllllllllllllIllIllIIIlIlIlIlIll, lllllllllllllIllIllIIIlIlIlIlIIl, lllllllllllllIllIllIIIlIlIllIIII.getZ() + lllllllllllllIllIllIIIlIlIlIlIlI))) {
                    break;
                }
            }
        }
    }
    
    public BiomeForest(final Type lllllllllllllIllIllIIIllIIIIlIll, final BiomeProperties lllllllllllllIllIllIIIllIIIIlIlI) {
        super(lllllllllllllIllIllIIIllIIIIlIlI);
        this.type = lllllllllllllIllIllIIIllIIIIlIll;
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 2;
        if (this.type == Type.FLOWER) {
            this.theBiomeDecorator.treesPerChunk = 6;
            this.theBiomeDecorator.flowersPerChunk = 100;
            this.theBiomeDecorator.grassPerChunk = 1;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        }
        if (this.type == Type.NORMAL) {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        }
        if (this.type == Type.ROOFED) {
            this.theBiomeDecorator.treesPerChunk = -999;
        }
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos lllllllllllllIllIllIIIlIlIIllIIl) {
        final int lllllllllllllIllIllIIIlIlIIllIII = super.getGrassColorAtPos(lllllllllllllIllIllIIIlIlIIllIIl);
        return (this.type == Type.ROOFED) ? ((lllllllllllllIllIllIIIlIlIIllIII & 0xFEFEFE) + 2634762 >> 1) : lllllllllllllIllIllIIIlIlIIllIII;
    }
    
    protected void addMushrooms(final World lllllllllllllIllIllIIIlIllIlIIIl, final Random lllllllllllllIllIllIIIlIllIIIlIl, final BlockPos lllllllllllllIllIllIIIlIllIIllll) {
        for (int lllllllllllllIllIllIIIlIllIIlllI = 0; lllllllllllllIllIllIIIlIllIIlllI < 4; ++lllllllllllllIllIllIIIlIllIIlllI) {
            for (int lllllllllllllIllIllIIIlIllIIllIl = 0; lllllllllllllIllIllIIIlIllIIllIl < 4; ++lllllllllllllIllIllIIIlIllIIllIl) {
                final int lllllllllllllIllIllIIIlIllIIllII = lllllllllllllIllIllIIIlIllIIlllI * 4 + 1 + 8 + lllllllllllllIllIllIIIlIllIIIlIl.nextInt(3);
                final int lllllllllllllIllIllIIIlIllIIlIll = lllllllllllllIllIllIIIlIllIIllIl * 4 + 1 + 8 + lllllllllllllIllIllIIIlIllIIIlIl.nextInt(3);
                final BlockPos lllllllllllllIllIllIIIlIllIIlIlI = lllllllllllllIllIllIIIlIllIlIIIl.getHeight(lllllllllllllIllIllIIIlIllIIllll.add(lllllllllllllIllIllIIIlIllIIllII, 0, lllllllllllllIllIllIIIlIllIIlIll));
                if (lllllllllllllIllIllIIIlIllIIIlIl.nextInt(20) == 0) {
                    final WorldGenBigMushroom lllllllllllllIllIllIIIlIllIIlIIl = new WorldGenBigMushroom();
                    lllllllllllllIllIllIIIlIllIIlIIl.generate(lllllllllllllIllIllIIIlIllIlIIIl, lllllllllllllIllIllIIIlIllIIIlIl, lllllllllllllIllIllIIIlIllIIlIlI);
                }
                else {
                    final WorldGenAbstractTree lllllllllllllIllIllIIIlIllIIlIII = this.genBigTreeChance(lllllllllllllIllIllIIIlIllIIIlIl);
                    lllllllllllllIllIllIIIlIllIIlIII.setDecorationDefaults();
                    if (lllllllllllllIllIllIIIlIllIIlIII.generate(lllllllllllllIllIllIIIlIllIlIIIl, lllllllllllllIllIllIIIlIllIIIlIl, lllllllllllllIllIllIIIlIllIIlIlI)) {
                        lllllllllllllIllIllIIIlIllIIlIII.generateSaplings(lllllllllllllIllIllIIIlIllIlIIIl, lllllllllllllIllIllIIIlIllIIIlIl, lllllllllllllIllIllIIIlIllIIlIlI);
                    }
                }
            }
        }
    }
    
    @Override
    public Class<? extends Biome> getBiomeClass() {
        return BiomeForest.class;
    }
    
    @Override
    public void decorate(final World lllllllllllllIllIllIIIlIlllIIIII, final Random lllllllllllllIllIllIIIlIllIlllll, final BlockPos lllllllllllllIllIllIIIlIllIllllI) {
        if (this.type == Type.ROOFED) {
            this.addMushrooms(lllllllllllllIllIllIIIlIlllIIIII, lllllllllllllIllIllIIIlIllIlllll, lllllllllllllIllIllIIIlIllIllllI);
        }
        int lllllllllllllIllIllIIIlIlllIIIlI = lllllllllllllIllIllIIIlIllIlllll.nextInt(5) - 3;
        if (this.type == Type.FLOWER) {
            lllllllllllllIllIllIIIlIlllIIIlI += 2;
        }
        this.addDoublePlants(lllllllllllllIllIllIIIlIlllIIIII, lllllllllllllIllIllIIIlIllIlllll, lllllllllllllIllIllIIIlIllIllllI, lllllllllllllIllIllIIIlIlllIIIlI);
        super.decorate(lllllllllllllIllIllIIIlIlllIIIII, lllllllllllllIllIllIIIlIllIlllll, lllllllllllllIllIllIIIlIllIllllI);
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random lllllllllllllIllIllIIIlIlllllIlI, final BlockPos lllllllllllllIllIllIIIlIllllIlII) {
        if (this.type == Type.FLOWER) {
            final double lllllllllllllIllIllIIIlIlllllIII = MathHelper.clamp((1.0 + BiomeForest.GRASS_COLOR_NOISE.getValue(lllllllllllllIllIllIIIlIllllIlII.getX() / 48.0, lllllllllllllIllIllIIIlIllllIlII.getZ() / 48.0)) / 2.0, 0.0, 0.9999);
            final BlockFlower.EnumFlowerType lllllllllllllIllIllIIIlIllllIlll = BlockFlower.EnumFlowerType.values()[(int)(lllllllllllllIllIllIIIlIlllllIII * BlockFlower.EnumFlowerType.values().length)];
            return (lllllllllllllIllIllIIIlIllllIlll == BlockFlower.EnumFlowerType.BLUE_ORCHID) ? BlockFlower.EnumFlowerType.POPPY : lllllllllllllIllIllIIIlIllllIlll;
        }
        return super.pickRandomFlower(lllllllllllllIllIllIIIlIlllllIlI, lllllllllllllIllIllIIIlIllllIlII);
    }
    
    public enum Type
    {
        NORMAL("NORMAL", 0), 
        FLOWER("FLOWER", 1), 
        BIRCH("BIRCH", 2), 
        ROOFED("ROOFED", 3);
        
        private Type(final String llllllllllllllIIlIIllllIIIllIlII, final int llllllllllllllIIlIIllllIIIllIIll) {
        }
    }
}
