package net.minecraft.item;

import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.creativetab.*;

public class ItemSeeds extends Item
{
    private final /* synthetic */ Block soilBlockID;
    private final /* synthetic */ Block crops;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIlIlIIlllIIIlllIII, final World lllllllllllllIIlIlIIlllIIlIIIIIl, final BlockPos lllllllllllllIIlIlIIlllIIIllIllI, final EnumHand lllllllllllllIIlIlIIlllIIIllIlIl, final EnumFacing lllllllllllllIIlIlIIlllIIIllIlII, final float lllllllllllllIIlIlIIlllIIIllllIl, final float lllllllllllllIIlIlIIlllIIIllllII, final float lllllllllllllIIlIlIIlllIIIlllIll) {
        final ItemStack lllllllllllllIIlIlIIlllIIIlllIlI = lllllllllllllIIlIlIIlllIIIlllIII.getHeldItem(lllllllllllllIIlIlIIlllIIIllIlIl);
        if (lllllllllllllIIlIlIIlllIIIllIlII == EnumFacing.UP && lllllllllllllIIlIlIIlllIIIlllIII.canPlayerEdit(lllllllllllllIIlIlIIlllIIIllIllI.offset(lllllllllllllIIlIlIIlllIIIllIlII), lllllllllllllIIlIlIIlllIIIllIlII, lllllllllllllIIlIlIIlllIIIlllIlI) && lllllllllllllIIlIlIIlllIIlIIIIIl.getBlockState(lllllllllllllIIlIlIIlllIIIllIllI).getBlock() == this.soilBlockID && lllllllllllllIIlIlIIlllIIlIIIIIl.isAirBlock(lllllllllllllIIlIlIIlllIIIllIllI.up())) {
            lllllllllllllIIlIlIIlllIIlIIIIIl.setBlockState(lllllllllllllIIlIlIIlllIIIllIllI.up(), this.crops.getDefaultState());
            if (lllllllllllllIIlIlIIlllIIIlllIII instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIIlIlIIlllIIIlllIII, lllllllllllllIIlIlIIlllIIIllIllI.up(), lllllllllllllIIlIlIIlllIIIlllIlI);
            }
            lllllllllllllIIlIlIIlllIIIlllIlI.func_190918_g(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    public ItemSeeds(final Block lllllllllllllIIlIlIIlllIIlIIllll, final Block lllllllllllllIIlIlIIlllIIlIIlllI) {
        this.crops = lllllllllllllIIlIlIIlllIIlIIllll;
        this.soilBlockID = lllllllllllllIIlIlIIlllIIlIIlllI;
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
