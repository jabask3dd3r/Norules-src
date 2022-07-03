package net.minecraft.client.renderer.color;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public interface IBlockColor
{
    int colorMultiplier(final IBlockState p0, final IBlockAccess p1, final BlockPos p2, final int p3);
}
