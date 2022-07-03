package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockSnowBlock extends Block
{
    protected BlockSnowBlock() {
        super(Material.CRAFTED_SNOW);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIIlIlIIIllIIlIlIII, final BlockPos lllllllllllllIIIlIlIIIllIIlIIlll, final IBlockState lllllllllllllIIIlIlIIIllIIlIlIll, final Random lllllllllllllIIIlIlIIIllIIlIlIlI) {
        if (lllllllllllllIIIlIlIIIllIIlIlIII.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllIIIlIlIIIllIIlIIlll) > 11) {
            this.dropBlockAsItem(lllllllllllllIIIlIlIIIllIIlIlIII, lllllllllllllIIIlIlIIIllIIlIIlll, lllllllllllllIIIlIlIIIllIIlIlIII.getBlockState(lllllllllllllIIIlIlIIIllIIlIIlll), 0);
            lllllllllllllIIIlIlIIIllIIlIlIII.setBlockToAir(lllllllllllllIIIlIlIIIllIIlIIlll);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIlIlIIIllIIllIllI, final Random lllllllllllllIIIlIlIIIllIIllIlIl, final int lllllllllllllIIIlIlIIIllIIllIlII) {
        return Items.SNOWBALL;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIIIlIlIIIllIIllIIlI) {
        return 4;
    }
}
