package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class BiomeSavannaMutated extends BiomeSavanna
{
    public BiomeSavannaMutated(final BiomeProperties llllllllllllllIIlIIIlIlIIlIlllII) {
        super(llllllllllllllIIlIIIlIlIIlIlllII);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 2;
        this.theBiomeDecorator.grassPerChunk = 5;
    }
    
    @Override
    public void decorate(final World llllllllllllllIIlIIIlIlIIIlllIll, final Random llllllllllllllIIlIIIlIlIIIlllIlI, final BlockPos llllllllllllllIIlIIIlIlIIIlllIIl) {
        this.theBiomeDecorator.decorate(llllllllllllllIIlIIIlIlIIIlllIll, llllllllllllllIIlIIIlIlIIIlllIlI, this, llllllllllllllIIlIIIlIlIIIlllIIl);
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIIlIIIlIlIIlIIlIlI, final Random llllllllllllllIIlIIIlIlIIlIlIIII, final ChunkPrimer llllllllllllllIIlIIIlIlIIlIIllll, final int llllllllllllllIIlIIIlIlIIlIIIlll, final int llllllllllllllIIlIIIlIlIIlIIllIl, final double llllllllllllllIIlIIIlIlIIlIIIlIl) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        if (llllllllllllllIIlIIIlIlIIlIIIlIl > 1.75) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }
        else if (llllllllllllllIIlIIIlIlIIlIIIlIl > -0.5) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        }
        this.generateBiomeTerrain(llllllllllllllIIlIIIlIlIIlIIlIlI, llllllllllllllIIlIIIlIlIIlIlIIII, llllllllllllllIIlIIIlIlIIlIIllll, llllllllllllllIIlIIIlIlIIlIIIlll, llllllllllllllIIlIIIlIlIIlIIllIl, llllllllllllllIIlIIIlIlIIlIIIlIl);
    }
}
