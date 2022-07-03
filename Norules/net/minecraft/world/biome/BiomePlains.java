package net.minecraft.world.biome;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import java.util.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class BiomePlains extends Biome
{
    protected /* synthetic */ boolean sunflowers;
    
    protected BiomePlains(final boolean llllllllllllllIlIlIIIlIlIlIIlIlI, final BiomeProperties llllllllllllllIlIlIIIlIlIlIIIllI) {
        super(llllllllllllllIlIlIIIlIlIlIIIllI);
        this.sunflowers = llllllllllllllIlIlIIIlIlIlIIlIlI;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDonkey.class, 1, 1, 3));
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.extraTreeChance = 0.05f;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIlIlIIIlIlIIIlIlIl) {
        return (llllllllllllllIlIlIIIlIlIIIlIlIl.nextInt(3) == 0) ? BiomePlains.BIG_TREE_FEATURE : BiomePlains.TREE_FEATURE;
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllllIlIlIIIlIlIIlllIll, final BlockPos llllllllllllllIlIlIIIlIlIIllllll) {
        final double llllllllllllllIlIlIIIlIlIIlllllI = BiomePlains.GRASS_COLOR_NOISE.getValue(llllllllllllllIlIlIIIlIlIIllllll.getX() / 200.0, llllllllllllllIlIlIIIlIlIIllllll.getZ() / 200.0);
        if (llllllllllllllIlIlIIIlIlIIlllllI < -0.8) {
            final int llllllllllllllIlIlIIIlIlIIllllIl = llllllllllllllIlIlIIIlIlIIlllIll.nextInt(4);
            switch (llllllllllllllIlIlIIIlIlIIllllIl) {
                case 0: {
                    return BlockFlower.EnumFlowerType.ORANGE_TULIP;
                }
                case 1: {
                    return BlockFlower.EnumFlowerType.RED_TULIP;
                }
                case 2: {
                    return BlockFlower.EnumFlowerType.PINK_TULIP;
                }
                default: {
                    return BlockFlower.EnumFlowerType.WHITE_TULIP;
                }
            }
        }
        else {
            if (llllllllllllllIlIlIIIlIlIIlllIll.nextInt(3) <= 0) {
                return BlockFlower.EnumFlowerType.DANDELION;
            }
            final int llllllllllllllIlIlIIIlIlIIllllII = llllllllllllllIlIlIIIlIlIIlllIll.nextInt(3);
            if (llllllllllllllIlIlIIIlIlIIllllII == 0) {
                return BlockFlower.EnumFlowerType.POPPY;
            }
            return (llllllllllllllIlIlIIIlIlIIllllII == 1) ? BlockFlower.EnumFlowerType.HOUSTONIA : BlockFlower.EnumFlowerType.OXEYE_DAISY;
        }
    }
    
    @Override
    public void decorate(final World llllllllllllllIlIlIIIlIlIIlIIIII, final Random llllllllllllllIlIlIIIlIlIIlIllII, final BlockPos llllllllllllllIlIlIIIlIlIIlIlIll) {
        final double llllllllllllllIlIlIIIlIlIIlIlIlI = BiomePlains.GRASS_COLOR_NOISE.getValue((llllllllllllllIlIlIIIlIlIIlIlIll.getX() + 8) / 200.0, (llllllllllllllIlIlIIIlIlIIlIlIll.getZ() + 8) / 200.0);
        if (llllllllllllllIlIlIIIlIlIIlIlIlI < -0.8) {
            this.theBiomeDecorator.flowersPerChunk = 15;
            this.theBiomeDecorator.grassPerChunk = 5;
        }
        else {
            this.theBiomeDecorator.flowersPerChunk = 4;
            this.theBiomeDecorator.grassPerChunk = 10;
            BiomePlains.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);
            for (int llllllllllllllIlIlIIIlIlIIlIlIIl = 0; llllllllllllllIlIlIIIlIlIIlIlIIl < 7; ++llllllllllllllIlIlIIIlIlIIlIlIIl) {
                final int llllllllllllllIlIlIIIlIlIIlIlIII = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(16) + 8;
                final int llllllllllllllIlIlIIIlIlIIlIIlll = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(16) + 8;
                final int llllllllllllllIlIlIIIlIlIIlIIllI = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(llllllllllllllIlIlIIIlIlIIlIIIII.getHeight(llllllllllllllIlIlIIIlIlIIlIlIll.add(llllllllllllllIlIlIIIlIlIIlIlIII, 0, llllllllllllllIlIlIIIlIlIIlIIlll)).getY() + 32);
                BiomePlains.DOUBLE_PLANT_GENERATOR.generate(llllllllllllllIlIlIIIlIlIIlIIIII, llllllllllllllIlIlIIIlIlIIlIllII, llllllllllllllIlIlIIIlIlIIlIlIll.add(llllllllllllllIlIlIIIlIlIIlIlIII, llllllllllllllIlIlIIIlIlIIlIIllI, llllllllllllllIlIlIIIlIlIIlIIlll));
            }
        }
        if (this.sunflowers) {
            BiomePlains.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SUNFLOWER);
            for (int llllllllllllllIlIlIIIlIlIIlIIlIl = 0; llllllllllllllIlIlIIIlIlIIlIIlIl < 10; ++llllllllllllllIlIlIIIlIlIIlIIlIl) {
                final int llllllllllllllIlIlIIIlIlIIlIIlII = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(16) + 8;
                final int llllllllllllllIlIlIIIlIlIIlIIIll = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(16) + 8;
                final int llllllllllllllIlIlIIIlIlIIlIIIlI = llllllllllllllIlIlIIIlIlIIlIllII.nextInt(llllllllllllllIlIlIIIlIlIIlIIIII.getHeight(llllllllllllllIlIlIIIlIlIIlIlIll.add(llllllllllllllIlIlIIIlIlIIlIIlII, 0, llllllllllllllIlIlIIIlIlIIlIIIll)).getY() + 32);
                BiomePlains.DOUBLE_PLANT_GENERATOR.generate(llllllllllllllIlIlIIIlIlIIlIIIII, llllllllllllllIlIlIIIlIlIIlIllII, llllllllllllllIlIlIIIlIlIIlIlIll.add(llllllllllllllIlIlIIIlIlIIlIIlII, llllllllllllllIlIlIIIlIlIIlIIIlI, llllllllllllllIlIlIIIlIlIIlIIIll));
            }
        }
        super.decorate(llllllllllllllIlIlIIIlIlIIlIIIII, llllllllllllllIlIlIIIlIlIIlIllII, llllllllllllllIlIlIIIlIlIIlIlIll);
    }
}
