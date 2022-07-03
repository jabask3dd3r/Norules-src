package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;

public class ItemArrow extends Item
{
    public ItemArrow() {
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
    
    public EntityArrow createArrow(final World lIllIlIIIII, final ItemStack lIllIIlllll, final EntityLivingBase lIllIIllllI) {
        final EntityTippedArrow lIllIlIIIIl = new EntityTippedArrow(lIllIlIIIII, lIllIIllllI);
        lIllIlIIIIl.setPotionEffect(lIllIIlllll);
        return lIllIlIIIIl;
    }
}
