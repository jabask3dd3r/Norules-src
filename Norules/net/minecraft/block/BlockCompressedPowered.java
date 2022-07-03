package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockCompressedPowered extends Block
{
    @Override
    public boolean canProvidePower(final IBlockState llllllllllllIlllllIllllIIIIlIlll) {
        return true;
    }
    
    @Override
    public int getWeakPower(final IBlockState llllllllllllIlllllIllllIIIIlIlIl, final IBlockAccess llllllllllllIlllllIllllIIIIlIlII, final BlockPos llllllllllllIlllllIllllIIIIlIIll, final EnumFacing llllllllllllIlllllIllllIIIIlIIlI) {
        return 15;
    }
    
    public BlockCompressedPowered(final Material llllllllllllIlllllIllllIIIIllIlI, final MapColor llllllllllllIlllllIllllIIIIlllII) {
        super(llllllllllllIlllllIllllIIIIllIlI, llllllllllllIlllllIllllIIIIlllII);
    }
}
