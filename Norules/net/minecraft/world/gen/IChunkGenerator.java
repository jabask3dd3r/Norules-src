package net.minecraft.world.gen;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.biome.*;

public interface IChunkGenerator
{
    @Nullable
    BlockPos getStrongholdGen(final World p0, final String p1, final BlockPos p2, final boolean p3);
    
    Chunk provideChunk(final int p0, final int p1);
    
    boolean generateStructures(final Chunk p0, final int p1, final int p2);
    
    void populate(final int p0, final int p1);
    
    void recreateStructures(final Chunk p0, final int p1, final int p2);
    
    List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType p0, final BlockPos p1);
    
    boolean func_193414_a(final World p0, final String p1, final BlockPos p2);
}
