package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;

public class ItemSeedFood extends ItemFood
{
    private final /* synthetic */ Block crops;
    private final /* synthetic */ Block soilId;
    
    public ItemSeedFood(final int lllllllllllllIIIIlIlIIIllIIllllI, final float lllllllllllllIIIIlIlIIIllIIlllIl, final Block lllllllllllllIIIIlIlIIIllIIlllII, final Block lllllllllllllIIIIlIlIIIllIIllIll) {
        super(lllllllllllllIIIIlIlIIIllIIllllI, lllllllllllllIIIIlIlIIIllIIlllIl, false);
        this.crops = lllllllllllllIIIIlIlIIIllIIlllII;
        this.soilId = lllllllllllllIIIIlIlIIIllIIllIll;
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIIIlIlIIIllIIIIIll, final World lllllllllllllIIIIlIlIIIllIIIIIlI, final BlockPos lllllllllllllIIIIlIlIIIllIIIIIIl, final EnumHand lllllllllllllIIIIlIlIIIllIIIlIlI, final EnumFacing lllllllllllllIIIIlIlIIIllIIIlIIl, final float lllllllllllllIIIIlIlIIIllIIIlIII, final float lllllllllllllIIIIlIlIIIllIIIIlll, final float lllllllllllllIIIIlIlIIIllIIIIllI) {
        final ItemStack lllllllllllllIIIIlIlIIIllIIIIlIl = lllllllllllllIIIIlIlIIIllIIIIIll.getHeldItem(lllllllllllllIIIIlIlIIIllIIIlIlI);
        if (lllllllllllllIIIIlIlIIIllIIIlIIl == EnumFacing.UP && lllllllllllllIIIIlIlIIIllIIIIIll.canPlayerEdit(lllllllllllllIIIIlIlIIIllIIIIIIl.offset(lllllllllllllIIIIlIlIIIllIIIlIIl), lllllllllllllIIIIlIlIIIllIIIlIIl, lllllllllllllIIIIlIlIIIllIIIIlIl) && lllllllllllllIIIIlIlIIIllIIIIIlI.getBlockState(lllllllllllllIIIIlIlIIIllIIIIIIl).getBlock() == this.soilId && lllllllllllllIIIIlIlIIIllIIIIIlI.isAirBlock(lllllllllllllIIIIlIlIIIllIIIIIIl.up())) {
            lllllllllllllIIIIlIlIIIllIIIIIlI.setBlockState(lllllllllllllIIIIlIlIIIllIIIIIIl.up(), this.crops.getDefaultState(), 11);
            lllllllllllllIIIIlIlIIIllIIIIlIl.func_190918_g(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}
