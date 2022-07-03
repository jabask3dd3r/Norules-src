package net.minecraft.block.state;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;

public interface IBlockBehaviors
{
    boolean onBlockEventReceived(final World p0, final BlockPos p1, final int p2, final int p3);
    
    void neighborChanged(final World p0, final BlockPos p1, final Block p2, final BlockPos p3);
}
