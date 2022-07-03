package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class BlockNetherrack extends Block
{
    public BlockNetherrack() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIllllllIllIllllI, final IBlockAccess lllllllllllllIlIIllllllIllIlllIl, final BlockPos lllllllllllllIlIIllllllIllIlllII) {
        return MapColor.NETHERRACK;
    }
}
