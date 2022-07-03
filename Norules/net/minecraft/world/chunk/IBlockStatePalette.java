package net.minecraft.world.chunk;

import net.minecraft.network.*;
import net.minecraft.block.state.*;
import javax.annotation.*;

public interface IBlockStatePalette
{
    void write(final PacketBuffer p0);
    
    int idFor(final IBlockState p0);
    
    int getSerializedState();
    
    void read(final PacketBuffer p0);
    
    @Nullable
    IBlockState getBlockState(final int p0);
}
