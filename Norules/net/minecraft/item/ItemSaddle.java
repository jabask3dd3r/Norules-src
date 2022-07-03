package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class ItemSaddle extends Item
{
    public ItemSaddle() {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
    }
    
    @Override
    public boolean itemInteractionForEntity(final ItemStack lllllllllllllIlllIIIIllIlIllIIIl, final EntityPlayer lllllllllllllIlllIIIIllIlIllIIII, final EntityLivingBase lllllllllllllIlllIIIIllIlIlIlIlI, final EnumHand lllllllllllllIlllIIIIllIlIlIlllI) {
        if (lllllllllllllIlllIIIIllIlIlIlIlI instanceof EntityPig) {
            final EntityPig lllllllllllllIlllIIIIllIlIlIllIl = (EntityPig)lllllllllllllIlllIIIIllIlIlIlIlI;
            if (!lllllllllllllIlllIIIIllIlIlIllIl.getSaddled() && !lllllllllllllIlllIIIIllIlIlIllIl.isChild()) {
                lllllllllllllIlllIIIIllIlIlIllIl.setSaddled(true);
                lllllllllllllIlllIIIIllIlIlIllIl.world.playSound(lllllllllllllIlllIIIIllIlIllIIII, lllllllllllllIlllIIIIllIlIlIllIl.posX, lllllllllllllIlllIIIIllIlIlIllIl.posY, lllllllllllllIlllIIIIllIlIlIllIl.posZ, SoundEvents.ENTITY_PIG_SADDLE, SoundCategory.NEUTRAL, 0.5f, 1.0f);
                lllllllllllllIlllIIIIllIlIllIIIl.func_190918_g(1);
            }
            return true;
        }
        return false;
    }
}
