package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;

public class ItemNameTag extends Item
{
    @Override
    public boolean itemInteractionForEntity(final ItemStack llllllllllllIllllllIIIIIlIlllllI, final EntityPlayer llllllllllllIllllllIIIIIllIIIIIl, final EntityLivingBase llllllllllllIllllllIIIIIlIllllIl, final EnumHand llllllllllllIllllllIIIIIlIllllll) {
        if (llllllllllllIllllllIIIIIlIlllllI.hasDisplayName() && !(llllllllllllIllllllIIIIIlIllllIl instanceof EntityPlayer)) {
            llllllllllllIllllllIIIIIlIllllIl.setCustomNameTag(llllllllllllIllllllIIIIIlIlllllI.getDisplayName());
            if (llllllllllllIllllllIIIIIlIllllIl instanceof EntityLiving) {
                ((EntityLiving)llllllllllllIllllllIIIIIlIllllIl).enablePersistence();
            }
            llllllllllllIllllllIIIIIlIlllllI.func_190918_g(1);
            return true;
        }
        return false;
    }
    
    public ItemNameTag() {
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
