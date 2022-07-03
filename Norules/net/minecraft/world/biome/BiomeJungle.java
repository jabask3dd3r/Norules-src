package net.minecraft.world.biome;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;

public class BiomeJungle extends Biome
{
    private final /* synthetic */ boolean isEdge;
    private static final /* synthetic */ IBlockState JUNGLE_LOG;
    private static final /* synthetic */ IBlockState JUNGLE_LEAF;
    private static final /* synthetic */ IBlockState OAK_LEAF;
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllllllIIlIIlIlIllIIlllII) {
        return (llllllllllllllIIlIIlIlIllIIlllII.nextInt(4) == 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIIlIIlIlIllIlIIIIl) {
        if (llllllllllllllIIlIIlIlIllIlIIIIl.nextInt(10) == 0) {
            return BiomeJungle.BIG_TREE_FEATURE;
        }
        if (llllllllllllllIIlIIlIlIllIlIIIIl.nextInt(2) == 0) {
            return new WorldGenShrub(BiomeJungle.JUNGLE_LOG, BiomeJungle.OAK_LEAF);
        }
        return (!this.isEdge && llllllllllllllIIlIIlIlIllIlIIIIl.nextInt(3) == 0) ? new WorldGenMegaJungle(false, 10, 20, BiomeJungle.JUNGLE_LOG, BiomeJungle.JUNGLE_LEAF) : new WorldGenTrees(false, 4 + llllllllllllllIIlIIlIlIllIlIIIIl.nextInt(7), BiomeJungle.JUNGLE_LOG, BiomeJungle.JUNGLE_LEAF, true);
    }
    
    static {
        JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
        JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
        OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    public BiomeJungle(final boolean llllllllllllllIIlIIlIlIllIlIIllI, final BiomeProperties llllllllllllllIIlIIlIlIllIlIlIII) {
        super(llllllllllllllIIlIIlIlIllIlIlIII);
        this.isEdge = llllllllllllllIIlIIlIlIllIlIIllI;
        if (llllllllllllllIIlIIlIlIllIlIIllI) {
            this.theBiomeDecorator.treesPerChunk = 2;
        }
        else {
            this.theBiomeDecorator.treesPerChunk = 50;
        }
        this.theBiomeDecorator.grassPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 4;
        if (!llllllllllllllIIlIIlIlIllIlIIllI) {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }
        this.spawnableCreatureList.add(new SpawnListEntry(EntityParrot.class, 40, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
    }
    
    @Override
    public void decorate(final World llllllllllllllIIlIIlIlIllIIIlllI, final Random llllllllllllllIIlIIlIlIllIIIllIl, final BlockPos llllllllllllllIIlIIlIlIllIIIllII) {
        super.decorate(llllllllllllllIIlIIlIlIllIIIlllI, llllllllllllllIIlIIlIlIllIIIllIl, llllllllllllllIIlIIlIlIllIIIllII);
        final int llllllllllllllIIlIIlIlIllIIIlIll = llllllllllllllIIlIIlIlIllIIIllIl.nextInt(16) + 8;
        final int llllllllllllllIIlIIlIlIllIIIlIlI = llllllllllllllIIlIIlIlIllIIIllIl.nextInt(16) + 8;
        int llllllllllllllIIlIIlIlIllIIIlIIl = llllllllllllllIIlIIlIlIllIIIllIl.nextInt(llllllllllllllIIlIIlIlIllIIIlllI.getHeight(llllllllllllllIIlIIlIlIllIIIllII.add(llllllllllllllIIlIIlIlIllIIIlIll, 0, llllllllllllllIIlIIlIlIllIIIlIlI)).getY() * 2);
        new WorldGenMelon().generate(llllllllllllllIIlIIlIlIllIIIlllI, llllllllllllllIIlIIlIlIllIIIllIl, llllllllllllllIIlIIlIlIllIIIllII.add(llllllllllllllIIlIIlIlIllIIIlIll, llllllllllllllIIlIIlIlIllIIIlIIl, llllllllllllllIIlIIlIlIllIIIlIlI));
        final WorldGenVines llllllllllllllIIlIIlIlIllIIIlIII = new WorldGenVines();
        for (int llllllllllllllIIlIIlIlIllIIIIlll = 0; llllllllllllllIIlIIlIlIllIIIIlll < 50; ++llllllllllllllIIlIIlIlIllIIIIlll) {
            llllllllllllllIIlIIlIlIllIIIlIIl = llllllllllllllIIlIIlIlIllIIIllIl.nextInt(16) + 8;
            final int llllllllllllllIIlIIlIlIllIIIIllI = 128;
            final int llllllllllllllIIlIIlIlIllIIIIlIl = llllllllllllllIIlIIlIlIllIIIllIl.nextInt(16) + 8;
            llllllllllllllIIlIIlIlIllIIIlIII.generate(llllllllllllllIIlIIlIlIllIIIlllI, llllllllllllllIIlIIlIlIllIIIllIl, llllllllllllllIIlIIlIlIllIIIllII.add(llllllllllllllIIlIIlIlIllIIIlIIl, 128, llllllllllllllIIlIIlIlIllIIIIlIl));
        }
    }
}
