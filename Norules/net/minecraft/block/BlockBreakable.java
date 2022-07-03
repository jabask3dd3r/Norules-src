package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;

public class BlockBreakable extends Block
{
    private final /* synthetic */ boolean ignoreSimilarity;
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllllIIlIIlllIlIIIIII, final IBlockAccess llllllllllllllllIIlIIlllIIlllllI, final BlockPos llllllllllllllllIIlIIlllIIllllII, final EnumFacing llllllllllllllllIIlIIlllIIlIllIl) {
        final IBlockState llllllllllllllllIIlIIlllIIlllIIl = llllllllllllllllIIlIIlllIIlllllI.getBlockState(llllllllllllllllIIlIIlllIIllllII.offset(llllllllllllllllIIlIIlllIIlIllIl));
        final Block llllllllllllllllIIlIIlllIIllIlll = llllllllllllllllIIlIIlllIIlllIIl.getBlock();
        if (this == Blocks.GLASS || this == Blocks.STAINED_GLASS) {
            if (llllllllllllllllIIlIIlllIlIIIIII != llllllllllllllllIIlIIlllIIlllIIl) {
                return true;
            }
            if (llllllllllllllllIIlIIlllIIllIlll == this) {
                return false;
            }
        }
        return (this.ignoreSimilarity || llllllllllllllllIIlIIlllIIllIlll != this) && super.shouldSideBeRendered(llllllllllllllllIIlIIlllIlIIIIII, llllllllllllllllIIlIIlllIIlllllI, llllllllllllllllIIlIIlllIIllllII, llllllllllllllllIIlIIlllIIlIllIl);
    }
    
    protected BlockBreakable(final Material llllllllllllllllIIlIIlllIllIIIIl, final boolean llllllllllllllllIIlIIlllIllIIllI, final MapColor llllllllllllllllIIlIIlllIllIIlIl) {
        super(llllllllllllllllIIlIIlllIllIIIIl, llllllllllllllllIIlIIlllIllIIlIl);
        this.ignoreSimilarity = llllllllllllllllIIlIIlllIllIIllI;
    }
    
    protected BlockBreakable(final Material llllllllllllllllIIlIIlllIllllIIl, final boolean llllllllllllllllIIlIIlllIlllllII) {
        this(llllllllllllllllIIlIIlllIllllIIl, llllllllllllllllIIlIIlllIlllllII, llllllllllllllllIIlIIlllIllllIIl.getMaterialMapColor());
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllllIIlIIlllIlIllIII) {
        return false;
    }
}
