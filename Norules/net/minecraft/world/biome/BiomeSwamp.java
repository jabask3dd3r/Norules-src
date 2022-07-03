package net.minecraft.world.biome;

import net.minecraft.block.state.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;

public class BiomeSwamp extends Biome
{
    protected static final /* synthetic */ IBlockState WATER_LILY;
    
    protected BiomeSwamp(final BiomeProperties lllllllllllllIllllIllllIllIIllII) {
        super(lllllllllllllIllllIllllIllIIllII);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 4;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
    }
    
    @Override
    public int getFoliageColorAtPos(final BlockPos lllllllllllllIllllIllllIlIllllll) {
        return 6975545;
    }
    
    @Override
    public void decorate(final World lllllllllllllIllllIllllIlIIlIlIl, final Random lllllllllllllIllllIllllIlIIlIlII, final BlockPos lllllllllllllIllllIllllIlIIlIIll) {
        super.decorate(lllllllllllllIllllIllllIlIIlIlIl, lllllllllllllIllllIllllIlIIlIlII, lllllllllllllIllllIllllIlIIlIIll);
        if (lllllllllllllIllllIllllIlIIlIlII.nextInt(64) == 0) {
            new WorldGenFossils().generate(lllllllllllllIllllIllllIlIIlIlIl, lllllllllllllIllllIllllIlIIlIlII, lllllllllllllIllllIllllIlIIlIIll);
        }
    }
    
    @Override
    public void genTerrainBlocks(final World lllllllllllllIllllIllllIlIlIIlII, final Random lllllllllllllIllllIllllIlIlIIIll, final ChunkPrimer lllllllllllllIllllIllllIlIlIIIlI, final int lllllllllllllIllllIllllIlIlIllII, final int lllllllllllllIllllIllllIlIlIIIII, final double lllllllllllllIllllIllllIlIlIlIlI) {
        final double lllllllllllllIllllIllllIlIlIlIIl = BiomeSwamp.GRASS_COLOR_NOISE.getValue(lllllllllllllIllllIllllIlIlIllII * 0.25, lllllllllllllIllllIllllIlIlIIIII * 0.25);
        if (lllllllllllllIllllIllllIlIlIlIIl > 0.0) {
            final int lllllllllllllIllllIllllIlIlIlIII = lllllllllllllIllllIllllIlIlIllII & 0xF;
            final int lllllllllllllIllllIllllIlIlIIlll = lllllllllllllIllllIllllIlIlIIIII & 0xF;
            int lllllllllllllIllllIllllIlIlIIllI = 255;
            while (lllllllllllllIllllIllllIlIlIIllI >= 0) {
                if (lllllllllllllIllllIllllIlIlIIIlI.getBlockState(lllllllllllllIllllIllllIlIlIIlll, lllllllllllllIllllIllllIlIlIIllI, lllllllllllllIllllIllllIlIlIlIII).getMaterial() != Material.AIR) {
                    if (lllllllllllllIllllIllllIlIlIIllI != 62 || lllllllllllllIllllIllllIlIlIIIlI.getBlockState(lllllllllllllIllllIllllIlIlIIlll, lllllllllllllIllllIllllIlIlIIllI, lllllllllllllIllllIllllIlIlIlIII).getBlock() == Blocks.WATER) {
                        break;
                    }
                    lllllllllllllIllllIllllIlIlIIIlI.setBlockState(lllllllllllllIllllIllllIlIlIIlll, lllllllllllllIllllIllllIlIlIIllI, lllllllllllllIllllIllllIlIlIlIII, BiomeSwamp.WATER);
                    if (lllllllllllllIllllIllllIlIlIlIIl < 0.12) {
                        lllllllllllllIllllIllllIlIlIIIlI.setBlockState(lllllllllllllIllllIllllIlIlIIlll, lllllllllllllIllllIllllIlIlIIllI + 1, lllllllllllllIllllIllllIlIlIlIII, BiomeSwamp.WATER_LILY);
                        break;
                    }
                    break;
                }
                else {
                    --lllllllllllllIllllIllllIlIlIIllI;
                }
            }
        }
        this.generateBiomeTerrain(lllllllllllllIllllIllllIlIlIIlII, lllllllllllllIllllIllllIlIlIIIll, lllllllllllllIllllIllllIlIlIIIlI, lllllllllllllIllllIllllIlIlIllII, lllllllllllllIllllIllllIlIlIIIII, lllllllllllllIllllIllllIlIlIlIlI);
    }
    
    static {
        WATER_LILY = Blocks.WATERLILY.getDefaultState();
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos lllllllllllllIllllIllllIllIIIIlI) {
        final double lllllllllllllIllllIllllIllIIIIll = BiomeSwamp.GRASS_COLOR_NOISE.getValue(lllllllllllllIllllIllllIllIIIIlI.getX() * 0.0225, lllllllllllllIllllIllllIllIIIIlI.getZ() * 0.0225);
        return (lllllllllllllIllllIllllIllIIIIll < -0.1) ? 5011004 : 6975545;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIllllIllllIllIIlIII) {
        return BiomeSwamp.SWAMP_FEATURE;
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random lllllllllllllIllllIllllIlIllllIl, final BlockPos lllllllllllllIllllIllllIlIllllII) {
        return BlockFlower.EnumFlowerType.BLUE_ORCHID;
    }
}
