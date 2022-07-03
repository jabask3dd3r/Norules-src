package net.minecraft.world.chunk;

import net.minecraft.block.state.*;

interface IBlockStatePaletteResizer
{
    int onResize(final int p0, final IBlockState p1);
}
