package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;

public class ItemEmptyMap extends ItemMapBase
{
    protected ItemEmptyMap() {
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllllllIIlllIIIIllIlIl, final EntityPlayer lllllllllllllllllIIlllIIIIlIlllI, final EnumHand lllllllllllllllllIIlllIIIIllIIll) {
        final ItemStack lllllllllllllllllIIlllIIIIllIIlI = ItemMap.func_190906_a(lllllllllllllllllIIlllIIIIllIlIl, lllllllllllllllllIIlllIIIIlIlllI.posX, lllllllllllllllllIIlllIIIIlIlllI.posZ, (byte)0, true, false);
        final ItemStack lllllllllllllllllIIlllIIIIllIIIl = lllllllllllllllllIIlllIIIIlIlllI.getHeldItem(lllllllllllllllllIIlllIIIIllIIll);
        lllllllllllllllllIIlllIIIIllIIIl.func_190918_g(1);
        if (lllllllllllllllllIIlllIIIIllIIIl.func_190926_b()) {
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllllllIIlllIIIIllIIlI);
        }
        if (!lllllllllllllllllIIlllIIIIlIlllI.inventory.addItemStackToInventory(lllllllllllllllllIIlllIIIIllIIlI.copy())) {
            lllllllllllllllllIIlllIIIIlIlllI.dropItem(lllllllllllllllllIIlllIIIIllIIlI, false);
        }
        lllllllllllllllllIIlllIIIIlIlllI.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllllllIIlllIIIIllIIIl);
    }
}
