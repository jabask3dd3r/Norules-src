package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.creativetab.*;
import javax.annotation.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;

public class ItemBow extends Item
{
    @Override
    public int getItemEnchantability() {
        return 1;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack lIlIllIIIl) {
        return 72000;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lIlIlIlIII, final EntityPlayer lIlIlIIIlI, final EnumHand lIlIlIIIIl) {
        final ItemStack lIlIlIIlIl = lIlIlIIIlI.getHeldItem(lIlIlIIIIl);
        final boolean lIlIlIIlII = !this.findAmmo(lIlIlIIIlI).func_190926_b();
        if (!lIlIlIIIlI.capabilities.isCreativeMode && !lIlIlIIlII) {
            return lIlIlIIlII ? new ActionResult<ItemStack>(EnumActionResult.PASS, lIlIlIIlIl) : new ActionResult<ItemStack>(EnumActionResult.FAIL, lIlIlIIlIl);
        }
        lIlIlIIIlI.setActiveHand(lIlIlIIIIl);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lIlIlIIlIl);
    }
    
    public ItemBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack llllllllllllllIIllIllIllllIlIIll, @Nullable final World llllllllllllllIIllIllIllllIlIIlI, @Nullable final EntityLivingBase llllllllllllllIIllIllIllllIIllll) {
                if (llllllllllllllIIllIllIllllIIllll == null) {
                    return 0.0f;
                }
                return (llllllllllllllIIllIllIllllIIllll.getActiveItemStack().getItem() != Items.BOW) ? 0.0f : ((llllllllllllllIIllIllIllllIlIIll.getMaxItemUseDuration() - llllllllllllllIIllIllIllllIIllll.getItemInUseCount()) / 20.0f);
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllllIIlllllIIIllIIIlI, @Nullable final World lllllllllllllllIIlllllIIIllIIIIl, @Nullable final EntityLivingBase lllllllllllllllIIlllllIIIlIllllI) {
                return (lllllllllllllllIIlllllIIIlIllllI != null && lllllllllllllllIIlllllIIIlIllllI.isHandActive() && lllllllllllllllIIlllllIIIlIllllI.getActiveItemStack() == lllllllllllllllIIlllllIIIllIIIlI) ? 1.0f : 0.0f;
            }
        });
    }
    
    @Override
    public void onPlayerStoppedUsing(final ItemStack lIllIlIlIl, final World lIllIIIlIl, final EntityLivingBase lIllIlIIll, final int lIllIIIIll) {
        if (lIllIlIIll instanceof EntityPlayer) {
            final EntityPlayer lIllIlIIIl = (EntityPlayer)lIllIlIIll;
            final boolean lIllIlIIII = lIllIlIIIl.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, lIllIlIlIl) > 0;
            ItemStack lIllIIllll = this.findAmmo(lIllIlIIIl);
            if (!lIllIIllll.func_190926_b() || lIllIlIIII) {
                if (lIllIIllll.func_190926_b()) {
                    lIllIIllll = new ItemStack(Items.ARROW);
                }
                final int lIllIIlllI = this.getMaxItemUseDuration(lIllIlIlIl) - lIllIIIIll;
                final float lIllIIllIl = getArrowVelocity(lIllIIlllI);
                if (lIllIIllIl >= 0.1) {
                    final boolean lIllIIllII = lIllIlIIII && lIllIIllll.getItem() == Items.ARROW;
                    if (!lIllIIIlIl.isRemote) {
                        final ItemArrow lIllIIlIll = (ItemArrow)((lIllIIllll.getItem() instanceof ItemArrow) ? lIllIIllll.getItem() : Items.ARROW);
                        final EntityArrow lIllIIlIlI = lIllIIlIll.createArrow(lIllIIIlIl, lIllIIllll, lIllIlIIIl);
                        lIllIIlIlI.setAim(lIllIlIIIl, lIllIlIIIl.rotationPitch, lIllIlIIIl.rotationYaw, 0.0f, lIllIIllIl * 3.0f, 1.0f);
                        if (lIllIIllIl == 1.0f) {
                            lIllIIlIlI.setIsCritical(true);
                        }
                        final int lIllIIlIIl = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, lIllIlIlIl);
                        if (lIllIIlIIl > 0) {
                            lIllIIlIlI.setDamage(lIllIIlIlI.getDamage() + lIllIIlIIl * 0.5 + 0.5);
                        }
                        final int lIllIIlIII = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, lIllIlIlIl);
                        if (lIllIIlIII > 0) {
                            lIllIIlIlI.setKnockbackStrength(lIllIIlIII);
                        }
                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, lIllIlIlIl) > 0) {
                            lIllIIlIlI.setFire(100);
                        }
                        lIllIlIlIl.damageItem(1, lIllIlIIIl);
                        if (lIllIIllII || (lIllIlIIIl.capabilities.isCreativeMode && (lIllIIllll.getItem() == Items.SPECTRAL_ARROW || lIllIIllll.getItem() == Items.TIPPED_ARROW))) {
                            lIllIIlIlI.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        }
                        lIllIIIlIl.spawnEntityInWorld(lIllIIlIlI);
                    }
                    lIllIIIlIl.playSound(null, lIllIlIIIl.posX, lIllIlIIIl.posY, lIllIlIIIl.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (ItemBow.itemRand.nextFloat() * 0.4f + 1.2f) + lIllIIllIl * 0.5f);
                    if (!lIllIIllII && !lIllIlIIIl.capabilities.isCreativeMode) {
                        lIllIIllll.func_190918_g(1);
                        if (lIllIIllll.func_190926_b()) {
                            lIllIlIIIl.inventory.deleteStack(lIllIIllll);
                        }
                    }
                    lIllIlIIIl.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack lIlIlIllll) {
        return EnumAction.BOW;
    }
    
    protected boolean isArrow(final ItemStack lIlllIIlll) {
        return lIlllIIlll.getItem() instanceof ItemArrow;
    }
    
    private ItemStack findAmmo(final EntityPlayer lIlllIllII) {
        if (this.isArrow(lIlllIllII.getHeldItem(EnumHand.OFF_HAND))) {
            return lIlllIllII.getHeldItem(EnumHand.OFF_HAND);
        }
        if (this.isArrow(lIlllIllII.getHeldItem(EnumHand.MAIN_HAND))) {
            return lIlllIllII.getHeldItem(EnumHand.MAIN_HAND);
        }
        for (int lIlllIllll = 0; lIlllIllll < lIlllIllII.inventory.getSizeInventory(); ++lIlllIllll) {
            final ItemStack lIlllIlllI = lIlllIllII.inventory.getStackInSlot(lIlllIllll);
            if (this.isArrow(lIlllIlllI)) {
                return lIlllIlllI;
            }
        }
        return ItemStack.field_190927_a;
    }
    
    public static float getArrowVelocity(final int lIlIllIlII) {
        float lIlIllIlIl = lIlIllIlII / 20.0f;
        lIlIllIlIl = (lIlIllIlIl * lIlIllIlIl + lIlIllIlIl * 2.0f) / 3.0f;
        if (lIlIllIlIl > 1.0f) {
            lIlIllIlIl = 1.0f;
        }
        return lIlIllIlIl;
    }
}
