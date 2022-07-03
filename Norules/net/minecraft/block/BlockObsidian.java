package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class BlockObsidian extends Block
{
    public BlockObsidian() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIIIIlIIlIIIllI, final Random lllllllllllllllIlIIIIIlIIlIIIlIl, final int lllllllllllllllIlIIIIIlIIlIIIlII) {
        return Item.getItemFromBlock(Blocks.OBSIDIAN);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIlIIIIIlIIlIIIIlI, final IBlockAccess lllllllllllllllIlIIIIIlIIlIIIIIl, final BlockPos lllllllllllllllIlIIIIIlIIlIIIIII) {
        return MapColor.BLACK;
    }
}
