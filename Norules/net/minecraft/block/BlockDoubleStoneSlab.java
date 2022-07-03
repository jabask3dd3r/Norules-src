package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockDoubleStoneSlab extends BlockStoneSlab
{
    @Override
    public boolean isDouble() {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIIlIlIlllllIIlIl, final IBlockState llllllllllllllIIIIlIlIlllllIIlII, final BlockPos llllllllllllllIIIIlIlIlllllIIIll, final EnumFacing llllllllllllllIIIIlIlIlllllIIIlI) {
        return BlockFaceShape.SOLID;
    }
}
