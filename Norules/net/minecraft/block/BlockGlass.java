package net.minecraft.block;

import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.block.state.*;

public class BlockGlass extends BlockBreakable
{
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public BlockGlass(final Material lllllllllllllIlllIIIIIIIlIlIIIlI, final boolean lllllllllllllIlllIIIIIIIlIlIIIIl) {
        super(lllllllllllllIlllIIIIIIIlIlIIIlI, lllllllllllllIlllIIIIIIIlIlIIIIl);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIlllIIIIIIIlIIlllII) {
        return 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlllIIIIIIIlIIllIIl) {
        return false;
    }
}
