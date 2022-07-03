package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class BiomeHills extends Biome
{
    private final /* synthetic */ Type type;
    private final /* synthetic */ WorldGenTaiga2 spruceGenerator;
    private final /* synthetic */ WorldGenerator theWorldGenerator;
    
    @Override
    public void decorate(final World llllllllllllllllIIllIIIIIllllllI, final Random llllllllllllllllIIllIIIIIlllllIl, final BlockPos llllllllllllllllIIllIIIIIlllllII) {
        super.decorate(llllllllllllllllIIllIIIIIllllllI, llllllllllllllllIIllIIIIIlllllIl, llllllllllllllllIIllIIIIIlllllII);
        for (int llllllllllllllllIIllIIIIlIIIlIIl = 3 + llllllllllllllllIIllIIIIIlllllIl.nextInt(6), llllllllllllllllIIllIIIIlIIIlIII = 0; llllllllllllllllIIllIIIIlIIIlIII < llllllllllllllllIIllIIIIlIIIlIIl; ++llllllllllllllllIIllIIIIlIIIlIII) {
            final int llllllllllllllllIIllIIIIlIIIIlll = llllllllllllllllIIllIIIIIlllllIl.nextInt(16);
            final int llllllllllllllllIIllIIIIlIIIIllI = llllllllllllllllIIllIIIIIlllllIl.nextInt(28) + 4;
            final int llllllllllllllllIIllIIIIlIIIIlIl = llllllllllllllllIIllIIIIIlllllIl.nextInt(16);
            final BlockPos llllllllllllllllIIllIIIIlIIIIlII = llllllllllllllllIIllIIIIIlllllII.add(llllllllllllllllIIllIIIIlIIIIlll, llllllllllllllllIIllIIIIlIIIIllI, llllllllllllllllIIllIIIIlIIIIlIl);
            if (llllllllllllllllIIllIIIIIllllllI.getBlockState(llllllllllllllllIIllIIIIlIIIIlII).getBlock() == Blocks.STONE) {
                llllllllllllllllIIllIIIIIllllllI.setBlockState(llllllllllllllllIIllIIIIlIIIIlII, Blocks.EMERALD_ORE.getDefaultState(), 2);
            }
        }
        for (int llllllllllllllllIIllIIIIlIIIIIll = 0; llllllllllllllllIIllIIIIlIIIIIll < 7; ++llllllllllllllllIIllIIIIlIIIIIll) {
            final int llllllllllllllllIIllIIIIlIIIIIlI = llllllllllllllllIIllIIIIIlllllIl.nextInt(16);
            final int llllllllllllllllIIllIIIIlIIIIIIl = llllllllllllllllIIllIIIIIlllllIl.nextInt(64);
            final int llllllllllllllllIIllIIIIlIIIIIII = llllllllllllllllIIllIIIIIlllllIl.nextInt(16);
            this.theWorldGenerator.generate(llllllllllllllllIIllIIIIIllllllI, llllllllllllllllIIllIIIIIlllllIl, llllllllllllllllIIllIIIIIlllllII.add(llllllllllllllllIIllIIIIlIIIIIlI, llllllllllllllllIIllIIIIlIIIIIIl, llllllllllllllllIIllIIIIlIIIIIII));
        }
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllllIIllIIIIlIIllIlI) {
        return (llllllllllllllllIIllIIIIlIIllIlI.nextInt(3) > 0) ? this.spruceGenerator : super.genBigTreeChance(llllllllllllllllIIllIIIIlIIllIlI);
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllllIIllIIIIIllIllIl, final Random llllllllllllllllIIllIIIIIllIIlIl, final ChunkPrimer llllllllllllllllIIllIIIIIllIIlII, final int llllllllllllllllIIllIIIIIllIIIll, final int llllllllllllllllIIllIIIIIllIIIlI, final double llllllllllllllllIIllIIIIIllIlIII) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        if ((llllllllllllllllIIllIIIIIllIlIII < -1.0 || llllllllllllllllIIllIIIIIllIlIII > 2.0) && this.type == Type.MUTATED) {
            this.topBlock = Blocks.GRAVEL.getDefaultState();
            this.fillerBlock = Blocks.GRAVEL.getDefaultState();
        }
        else if (llllllllllllllllIIllIIIIIllIlIII > 1.0 && this.type != Type.EXTRA_TREES) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }
        this.generateBiomeTerrain(llllllllllllllllIIllIIIIIllIllIl, llllllllllllllllIIllIIIIIllIIlIl, llllllllllllllllIIllIIIIIllIIlII, llllllllllllllllIIllIIIIIllIIIll, llllllllllllllllIIllIIIIIllIIIlI, llllllllllllllllIIllIIIIIllIlIII);
    }
    
    protected BiomeHills(final Type llllllllllllllllIIllIIIIlIIlllll, final BiomeProperties llllllllllllllllIIllIIIIlIIllllI) {
        super(llllllllllllllllIIllIIIIlIIllllI);
        this.theWorldGenerator = new WorldGenMinable(Blocks.MONSTER_EGG.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.STONE), 9);
        this.spruceGenerator = new WorldGenTaiga2(false);
        if (llllllllllllllllIIllIIIIlIIlllll == Type.EXTRA_TREES) {
            this.theBiomeDecorator.treesPerChunk = 3;
        }
        this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 5, 4, 6));
        this.type = llllllllllllllllIIllIIIIlIIlllll;
    }
    
    public enum Type
    {
        MUTATED("MUTATED", 2), 
        NORMAL("NORMAL", 0), 
        EXTRA_TREES("EXTRA_TREES", 1);
        
        private Type(final String lllllllllllllIlllIlllllllIllIIIl, final int lllllllllllllIlllIlllllllIllIIII) {
        }
    }
}
