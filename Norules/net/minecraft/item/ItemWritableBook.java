package net.minecraft.item;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;

public class ItemWritableBook extends Item
{
    public ItemWritableBook() {
        this.setMaxStackSize(1);
    }
    
    public static boolean isNBTValid(final NBTTagCompound lllllllllllllIIIlllIIlIllIIIIIIl) {
        if (lllllllllllllIIIlllIIlIllIIIIIIl == null) {
            return false;
        }
        if (!lllllllllllllIIIlllIIlIllIIIIIIl.hasKey("pages", 9)) {
            return false;
        }
        final NBTTagList lllllllllllllIIIlllIIlIllIIIIlII = lllllllllllllIIIlllIIlIllIIIIIIl.getTagList("pages", 8);
        for (int lllllllllllllIIIlllIIlIllIIIIIll = 0; lllllllllllllIIIlllIIlIllIIIIIll < lllllllllllllIIIlllIIlIllIIIIlII.tagCount(); ++lllllllllllllIIIlllIIlIllIIIIIll) {
            final String lllllllllllllIIIlllIIlIllIIIIIlI = lllllllllllllIIIlllIIlIllIIIIlII.getStringTagAt(lllllllllllllIIIlllIIlIllIIIIIll);
            if (lllllllllllllIIIlllIIlIllIIIIIlI.length() > 32767) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIlllIIlIllIIlIIIl, final EntityPlayer lllllllllllllIIIlllIIlIllIIIllII, final EnumHand lllllllllllllIIIlllIIlIllIIIllll) {
        final ItemStack lllllllllllllIIIlllIIlIllIIIlllI = lllllllllllllIIIlllIIlIllIIIllII.getHeldItem(lllllllllllllIIIlllIIlIllIIIllll);
        lllllllllllllIIIlllIIlIllIIIllII.openBook(lllllllllllllIIIlllIIlIllIIIlllI, lllllllllllllIIIlllIIlIllIIIllll);
        lllllllllllllIIIlllIIlIllIIIllII.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIlllIIlIllIIIlllI);
    }
}
