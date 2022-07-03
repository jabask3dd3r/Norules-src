package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;

public class ItemChorusFruit extends ItemFood
{
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIIlIIlIllIllllIIIl, final World llllllllllllllIIlIIlIllIlllIIIll, final EntityLivingBase llllllllllllllIIlIIlIllIlllIIIlI) {
        final ItemStack llllllllllllllIIlIIlIllIlllIlllI = super.onItemUseFinish(llllllllllllllIIlIIlIllIllllIIIl, llllllllllllllIIlIIlIllIlllIIIll, llllllllllllllIIlIIlIllIlllIIIlI);
        if (!llllllllllllllIIlIIlIllIlllIIIll.isRemote) {
            final double llllllllllllllIIlIIlIllIlllIllIl = llllllllllllllIIlIIlIllIlllIIIlI.posX;
            final double llllllllllllllIIlIIlIllIlllIllII = llllllllllllllIIlIIlIllIlllIIIlI.posY;
            final double llllllllllllllIIlIIlIllIlllIlIll = llllllllllllllIIlIIlIllIlllIIIlI.posZ;
            for (int llllllllllllllIIlIIlIllIlllIlIlI = 0; llllllllllllllIIlIIlIllIlllIlIlI < 16; ++llllllllllllllIIlIIlIllIlllIlIlI) {
                final double llllllllllllllIIlIIlIllIlllIlIIl = llllllllllllllIIlIIlIllIlllIIIlI.posX + (llllllllllllllIIlIIlIllIlllIIIlI.getRNG().nextDouble() - 0.5) * 16.0;
                final double llllllllllllllIIlIIlIllIlllIlIII = MathHelper.clamp(llllllllllllllIIlIIlIllIlllIIIlI.posY + (llllllllllllllIIlIIlIllIlllIIIlI.getRNG().nextInt(16) - 8), 0.0, llllllllllllllIIlIIlIllIlllIIIll.getActualHeight() - 1);
                final double llllllllllllllIIlIIlIllIlllIIlll = llllllllllllllIIlIIlIllIlllIIIlI.posZ + (llllllllllllllIIlIIlIllIlllIIIlI.getRNG().nextDouble() - 0.5) * 16.0;
                if (llllllllllllllIIlIIlIllIlllIIIlI.isRiding()) {
                    llllllllllllllIIlIIlIllIlllIIIlI.dismountRidingEntity();
                }
                if (llllllllllllllIIlIIlIllIlllIIIlI.attemptTeleport(llllllllllllllIIlIIlIllIlllIlIIl, llllllllllllllIIlIIlIllIlllIlIII, llllllllllllllIIlIIlIllIlllIIlll)) {
                    llllllllllllllIIlIIlIllIlllIIIll.playSound(null, llllllllllllllIIlIIlIllIlllIllIl, llllllllllllllIIlIIlIllIlllIllII, llllllllllllllIIlIIlIllIlllIlIll, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
                    llllllllllllllIIlIIlIllIlllIIIlI.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0f, 1.0f);
                    break;
                }
            }
            if (llllllllllllllIIlIIlIllIlllIIIlI instanceof EntityPlayer) {
                ((EntityPlayer)llllllllllllllIIlIIlIllIlllIIIlI).getCooldownTracker().setCooldown(this, 20);
            }
        }
        return llllllllllllllIIlIIlIllIlllIlllI;
    }
    
    public ItemChorusFruit(final int llllllllllllllIIlIIlIlllIIIIIIll, final float llllllllllllllIIlIIlIllIllllllll) {
        super(llllllllllllllIIlIIlIlllIIIIIIll, llllllllllllllIIlIIlIllIllllllll, false);
    }
}
