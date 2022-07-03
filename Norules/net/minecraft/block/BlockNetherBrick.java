package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockNetherBrick extends Block
{
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIIIlIlllIIIlllII, final IBlockAccess llllllllllllllIlIIIlIlllIIIllIll, final BlockPos llllllllllllllIlIIIlIlllIIIllIlI) {
        return MapColor.NETHERRACK;
    }
    
    public BlockNetherBrick() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
