package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class BlockHay extends BlockRotatedPillar
{
    public BlockHay() {
        super(Material.GRASS, MapColor.YELLOW);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHay.AXIS, EnumFacing.Axis.Y));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void onFallenUpon(final World lllIlIIlIlllIII, final BlockPos lllIlIIlIllIlll, final Entity lllIlIIlIllIlII, final float lllIlIIlIllIIll) {
        lllIlIIlIllIlII.fall(lllIlIIlIllIIll, 0.2f);
    }
}
