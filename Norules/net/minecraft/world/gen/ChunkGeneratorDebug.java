package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import java.util.*;

public class ChunkGeneratorDebug implements IChunkGenerator
{
    private static final /* synthetic */ int GRID_WIDTH;
    private static final /* synthetic */ List<IBlockState> ALL_VALID_STATES;
    private static final /* synthetic */ int GRID_HEIGHT;
    protected static final /* synthetic */ IBlockState BARRIER;
    private final /* synthetic */ World world;
    protected static final /* synthetic */ IBlockState AIR;
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllllllIIllIllIlIllIll, final String lllllllllllllllllIIllIllIlIllIlI, final BlockPos lllllllllllllllllIIllIllIlIllIIl, final boolean lllllllllllllllllIIllIllIlIllIII) {
        return null;
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllllllIIllIllIllIlIll, final int lllllllllllllllllIIllIllIllIlIlI, final int lllllllllllllllllIIllIllIllIlIIl) {
        return false;
    }
    
    public static IBlockState getBlockStateFor(int lllllllllllllllllIIllIllIlllIlll, int lllllllllllllllllIIllIllIlllIIlI) {
        IBlockState lllllllllllllllllIIllIllIlllIlIl = ChunkGeneratorDebug.AIR;
        if (lllllllllllllllllIIllIllIlllIlll > 0 && lllllllllllllllllIIllIllIlllIIlI > 0 && lllllllllllllllllIIllIllIlllIlll % 2 != 0 && lllllllllllllllllIIllIllIlllIIlI % 2 != 0) {
            lllllllllllllllllIIllIllIlllIlll /= 2;
            lllllllllllllllllIIllIllIlllIIlI /= 2;
            if (lllllllllllllllllIIllIllIlllIlll <= ChunkGeneratorDebug.GRID_WIDTH && lllllllllllllllllIIllIllIlllIIlI <= ChunkGeneratorDebug.GRID_HEIGHT) {
                final int lllllllllllllllllIIllIllIlllIlII = MathHelper.abs(lllllllllllllllllIIllIllIlllIlll * ChunkGeneratorDebug.GRID_WIDTH + lllllllllllllllllIIllIllIlllIIlI);
                if (lllllllllllllllllIIllIllIlllIlII < ChunkGeneratorDebug.ALL_VALID_STATES.size()) {
                    lllllllllllllllllIIllIllIlllIlIl = ChunkGeneratorDebug.ALL_VALID_STATES.get(lllllllllllllllllIIllIllIlllIlII);
                }
            }
        }
        return lllllllllllllllllIIllIllIlllIlIl;
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllllllIIllIllIlIlllll, final BlockPos lllllllllllllllllIIllIllIllIIIlI) {
        final Biome lllllllllllllllllIIllIllIllIIIIl = this.world.getBiome(lllllllllllllllllIIllIllIllIIIlI);
        return lllllllllllllllllIIllIllIllIIIIl.getSpawnableList(lllllllllllllllllIIllIllIlIlllll);
    }
    
    @Override
    public void populate(final int lllllllllllllllllIIllIllIllIlllI, final int lllllllllllllllllIIllIllIllIllIl) {
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllllllIIllIllIlIlIIlI, final int lllllllllllllllllIIllIllIlIlIIIl, final int lllllllllllllllllIIllIllIlIlIIII) {
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllllIIllIlllIIlIIII, final int lllllllllllllllllIIllIlllIIIllll) {
        final ChunkPrimer lllllllllllllllllIIllIlllIIIlllI = new ChunkPrimer();
        for (int lllllllllllllllllIIllIlllIIIllIl = 0; lllllllllllllllllIIllIlllIIIllIl < 16; ++lllllllllllllllllIIllIlllIIIllIl) {
            for (int lllllllllllllllllIIllIlllIIIllII = 0; lllllllllllllllllIIllIlllIIIllII < 16; ++lllllllllllllllllIIllIlllIIIllII) {
                final int lllllllllllllllllIIllIlllIIIlIll = lllllllllllllllllIIllIlllIIlIIII * 16 + lllllllllllllllllIIllIlllIIIllIl;
                final int lllllllllllllllllIIllIlllIIIlIlI = lllllllllllllllllIIllIlllIIIllll * 16 + lllllllllllllllllIIllIlllIIIllII;
                lllllllllllllllllIIllIlllIIIlllI.setBlockState(lllllllllllllllllIIllIlllIIIllIl, 60, lllllllllllllllllIIllIlllIIIllII, ChunkGeneratorDebug.BARRIER);
                final IBlockState lllllllllllllllllIIllIlllIIIlIIl = getBlockStateFor(lllllllllllllllllIIllIlllIIIlIll, lllllllllllllllllIIllIlllIIIlIlI);
                if (lllllllllllllllllIIllIlllIIIlIIl != null) {
                    lllllllllllllllllIIllIlllIIIlllI.setBlockState(lllllllllllllllllIIllIlllIIIllIl, 70, lllllllllllllllllIIllIlllIIIllII, lllllllllllllllllIIllIlllIIIlIIl);
                }
            }
        }
        final Chunk lllllllllllllllllIIllIlllIIIlIII = new Chunk(this.world, lllllllllllllllllIIllIlllIIIlllI, lllllllllllllllllIIllIlllIIlIIII, lllllllllllllllllIIllIlllIIIllll);
        lllllllllllllllllIIllIlllIIIlIII.generateSkylightMap();
        final Biome[] lllllllllllllllllIIllIlllIIIIlll = this.world.getBiomeProvider().getBiomes(null, lllllllllllllllllIIllIlllIIlIIII * 16, lllllllllllllllllIIllIlllIIIllll * 16, 16, 16);
        final byte[] lllllllllllllllllIIllIlllIIIIllI = lllllllllllllllllIIllIlllIIIlIII.getBiomeArray();
        for (int lllllllllllllllllIIllIlllIIIIlIl = 0; lllllllllllllllllIIllIlllIIIIlIl < lllllllllllllllllIIllIlllIIIIllI.length; ++lllllllllllllllllIIllIlllIIIIlIl) {
            lllllllllllllllllIIllIlllIIIIllI[lllllllllllllllllIIllIlllIIIIlIl] = (byte)Biome.getIdForBiome(lllllllllllllllllIIllIlllIIIIlll[lllllllllllllllllIIllIlllIIIIlIl]);
        }
        lllllllllllllllllIIllIlllIIIlIII.generateSkylightMap();
        return lllllllllllllllllIIllIlllIIIlIII;
    }
    
    public ChunkGeneratorDebug(final World lllllllllllllllllIIllIlllIIllIll) {
        this.world = lllllllllllllllllIIllIlllIIllIll;
    }
    
    @Override
    public boolean func_193414_a(final World lllllllllllllllllIIllIllIlIlIllI, final String lllllllllllllllllIIllIllIlIlIlIl, final BlockPos lllllllllllllllllIIllIllIlIlIlII) {
        return false;
    }
    
    static {
        ALL_VALID_STATES = Lists.newArrayList();
        AIR = Blocks.AIR.getDefaultState();
        BARRIER = Blocks.BARRIER.getDefaultState();
        for (final Block lllllllllllllllllIIllIlllIlIIIll : Block.REGISTRY) {
            ChunkGeneratorDebug.ALL_VALID_STATES.addAll((Collection<? extends IBlockState>)lllllllllllllllllIIllIlllIlIIIll.getBlockState().getValidStates());
        }
        GRID_WIDTH = MathHelper.ceil(MathHelper.sqrt((float)ChunkGeneratorDebug.ALL_VALID_STATES.size()));
        GRID_HEIGHT = MathHelper.ceil(ChunkGeneratorDebug.ALL_VALID_STATES.size() / (float)ChunkGeneratorDebug.GRID_WIDTH);
    }
}
