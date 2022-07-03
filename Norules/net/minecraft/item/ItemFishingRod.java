package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;

public class ItemFishingRod extends Item
{
    public ItemFishingRod() {
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.addPropertyOverride(new ResourceLocation("cast"), new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack llllllllllllllllIIllIllIlllllllI, @Nullable final World llllllllllllllllIIllIllIllllllIl, @Nullable final EntityLivingBase llllllllllllllllIIllIllIllllllII) {
                if (llllllllllllllllIIllIllIllllllII == null) {
                    return 0.0f;
                }
                final boolean llllllllllllllllIIllIllIlllllIll = llllllllllllllllIIllIllIllllllII.getHeldItemMainhand() == llllllllllllllllIIllIllIlllllllI;
                boolean llllllllllllllllIIllIllIlllllIlI = llllllllllllllllIIllIllIllllllII.getHeldItemOffhand() == llllllllllllllllIIllIllIlllllllI;
                if (llllllllllllllllIIllIllIllllllII.getHeldItemMainhand().getItem() instanceof ItemFishingRod) {
                    llllllllllllllllIIllIllIlllllIlI = false;
                }
                return ((llllllllllllllllIIllIllIlllllIll || llllllllllllllllIIllIllIlllllIlI) && llllllllllllllllIIllIllIllllllII instanceof EntityPlayer && ((EntityPlayer)llllllllllllllllIIllIllIllllllII).fishEntity != null) ? 1.0f : 0.0f;
            }
        });
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIlIllIlIlllIIIllIlI, final EntityPlayer lllllllllllllIlIllIlIlllIIIlIIII, final EnumHand lllllllllllllIlIllIlIlllIIIIllll) {
        final ItemStack lllllllllllllIlIllIlIlllIIIlIlll = lllllllllllllIlIllIlIlllIIIlIIII.getHeldItem(lllllllllllllIlIllIlIlllIIIIllll);
        if (lllllllllllllIlIllIlIlllIIIlIIII.fishEntity != null) {
            final int lllllllllllllIlIllIlIlllIIIlIllI = lllllllllllllIlIllIlIlllIIIlIIII.fishEntity.handleHookRetraction();
            lllllllllllllIlIllIlIlllIIIlIlll.damageItem(lllllllllllllIlIllIlIlllIIIlIllI, lllllllllllllIlIllIlIlllIIIlIIII);
            lllllllllllllIlIllIlIlllIIIlIIII.swingArm(lllllllllllllIlIllIlIlllIIIIllll);
            lllllllllllllIlIllIlIlllIIIllIlI.playSound(null, lllllllllllllIlIllIlIlllIIIlIIII.posX, lllllllllllllIlIllIlIlllIIIlIIII.posY, lllllllllllllIlIllIlIlllIIIlIIII.posZ, SoundEvents.field_193780_J, SoundCategory.NEUTRAL, 1.0f, 0.4f / (ItemFishingRod.itemRand.nextFloat() * 0.4f + 0.8f));
        }
        else {
            lllllllllllllIlIllIlIlllIIIllIlI.playSound(null, lllllllllllllIlIllIlIlllIIIlIIII.posX, lllllllllllllIlIllIlIlllIIIlIIII.posY, lllllllllllllIlIllIlIlllIIIlIIII.posZ, SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemFishingRod.itemRand.nextFloat() * 0.4f + 0.8f));
            if (!lllllllllllllIlIllIlIlllIIIllIlI.isRemote) {
                final EntityFishHook lllllllllllllIlIllIlIlllIIIlIlIl = new EntityFishHook(lllllllllllllIlIllIlIlllIIIllIlI, lllllllllllllIlIllIlIlllIIIlIIII);
                final int lllllllllllllIlIllIlIlllIIIlIlII = EnchantmentHelper.func_191528_c(lllllllllllllIlIllIlIlllIIIlIlll);
                if (lllllllllllllIlIllIlIlllIIIlIlII > 0) {
                    lllllllllllllIlIllIlIlllIIIlIlIl.func_191516_a(lllllllllllllIlIllIlIlllIIIlIlII);
                }
                final int lllllllllllllIlIllIlIlllIIIlIIll = EnchantmentHelper.func_191529_b(lllllllllllllIlIllIlIlllIIIlIlll);
                if (lllllllllllllIlIllIlIlllIIIlIIll > 0) {
                    lllllllllllllIlIllIlIlllIIIlIlIl.func_191517_b(lllllllllllllIlIllIlIlllIIIlIIll);
                }
                lllllllllllllIlIllIlIlllIIIllIlI.spawnEntityInWorld(lllllllllllllIlIllIlIlllIIIlIlIl);
            }
            lllllllllllllIlIllIlIlllIIIlIIII.swingArm(lllllllllllllIlIllIlIlllIIIIllll);
            lllllllllllllIlIllIlIlllIIIlIIII.addStat(StatList.getObjectUseStats(this));
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIlIllIlIlllIIIlIlll);
    }
    
    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
    
    @Override
    public int getItemEnchantability() {
        return 1;
    }
}
