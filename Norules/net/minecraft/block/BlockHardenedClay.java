package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class BlockHardenedClay extends Block
{
    public BlockHardenedClay() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIIllIIIlIlllIlIIll, final IBlockAccess llllllllllllllIIllIIIlIlllIlIIlI, final BlockPos llllllllllllllIIllIIIlIlllIlIIIl) {
        return MapColor.ADOBE;
    }
}
