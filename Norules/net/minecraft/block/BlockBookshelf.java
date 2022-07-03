package net.minecraft.block;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockBookshelf extends Block
{
    @Override
    public int quantityDropped(final Random lllllllllllllIlIllllIlllIIIlllII) {
        return 3;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIllllIlllIIIllIlI, final Random lllllllllllllIlIllllIlllIIIllIIl, final int lllllllllllllIlIllllIlllIIIllIII) {
        return Items.BOOK;
    }
    
    public BlockBookshelf() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
