package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class BlockGlowstone extends Block
{
    @Override
    public Item getItemDropped(final IBlockState lIIlIIIIIIIIIlI, final Random lIIlIIIIIIIIIIl, final int lIIlIIIIIIIIIII) {
        return Items.GLOWSTONE_DUST;
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lIIlIIIIIIIlIIl, final Random lIIlIIIIIIIlIII) {
        return MathHelper.clamp(this.quantityDropped(lIIlIIIIIIIlIII) + lIIlIIIIIIIlIII.nextInt(lIIlIIIIIIIlIIl + 1), 1, 4);
    }
    
    public BlockGlowstone(final Material lIIlIIIIIIlIIll) {
        super(lIIlIIIIIIlIIll);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int quantityDropped(final Random lIIlIIIIIIIIlIl) {
        return 2 + lIIlIIIIIIIIlIl.nextInt(3);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lIIIllllllllllI, final IBlockAccess lIIIlllllllllIl, final BlockPos lIIIlllllllllII) {
        return MapColor.SAND;
    }
}
