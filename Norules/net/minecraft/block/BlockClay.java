package net.minecraft.block;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockClay extends Block
{
    @Override
    public int quantityDropped(final Random lllllllllllllllIllIllIIlIIIIllII) {
        return 4;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIllIllIIlIIIlIIII, final Random lllllllllllllllIllIllIIlIIIIllll, final int lllllllllllllllIllIllIIlIIIIlllI) {
        return Items.CLAY_BALL;
    }
    
    public BlockClay() {
        super(Material.CLAY);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
