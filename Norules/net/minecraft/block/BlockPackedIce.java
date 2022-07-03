package net.minecraft.block;

import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockPackedIce extends Block
{
    @Override
    public int quantityDropped(final Random lllllllllllllllIIllllllIlIIIlIII) {
        return 0;
    }
    
    public BlockPackedIce() {
        super(Material.PACKED_ICE);
        this.slipperiness = 0.98f;
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
