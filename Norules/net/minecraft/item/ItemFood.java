package net.minecraft.item;

import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.creativetab.*;

public class ItemFood extends Item
{
    private final /* synthetic */ float saturationModifier;
    private /* synthetic */ PotionEffect potionId;
    private /* synthetic */ boolean alwaysEdible;
    public final /* synthetic */ int itemUseDuration;
    private final /* synthetic */ boolean isWolfsFavoriteMeat;
    private /* synthetic */ float potionEffectProbability;
    private final /* synthetic */ int healAmount;
    
    protected void onFoodEaten(final ItemStack llllllllllllllIIllIIIIlIlIlllIlI, final World llllllllllllllIIllIIIIlIlIlllIIl, final EntityPlayer llllllllllllllIIllIIIIlIlIlllIII) {
        if (!llllllllllllllIIllIIIIlIlIlllIIl.isRemote && this.potionId != null && llllllllllllllIIllIIIIlIlIlllIIl.rand.nextFloat() < this.potionEffectProbability) {
            llllllllllllllIIllIIIIlIlIlllIII.addPotionEffect(new PotionEffect(this.potionId));
        }
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllIIllIIIIlIlIlIlIll, final EntityPlayer llllllllllllllIIllIIIIlIlIlIIllI, final EnumHand llllllllllllllIIllIIIIlIlIlIlIIl) {
        final ItemStack llllllllllllllIIllIIIIlIlIlIlIII = llllllllllllllIIllIIIIlIlIlIIllI.getHeldItem(llllllllllllllIIllIIIIlIlIlIlIIl);
        if (llllllllllllllIIllIIIIlIlIlIIllI.canEat(this.alwaysEdible)) {
            llllllllllllllIIllIIIIlIlIlIIllI.setActiveHand(llllllllllllllIIllIIIIlIlIlIlIIl);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllIIllIIIIlIlIlIlIII);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, llllllllllllllIIllIIIIlIlIlIlIII);
    }
    
    public float getSaturationModifier(final ItemStack llllllllllllllIIllIIIIlIlIIlllIl) {
        return this.saturationModifier;
    }
    
    public ItemFood(final int llllllllllllllIIllIIIIlIllIlIIlI, final boolean llllllllllllllIIllIIIIlIllIIlllI) {
        this(llllllllllllllIIllIIIIlIllIlIIlI, 0.6f, llllllllllllllIIllIIIIlIllIIlllI);
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllIIllIIIIlIlIllIIll) {
        return 32;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllIIllIIIIlIlIllIIIl) {
        return EnumAction.EAT;
    }
    
    public ItemFood setPotionEffect(final PotionEffect llllllllllllllIIllIIIIlIlIIlIlII, final float llllllllllllllIIllIIIIlIlIIlIIII) {
        this.potionId = llllllllllllllIIllIIIIlIlIIlIlII;
        this.potionEffectProbability = llllllllllllllIIllIIIIlIlIIlIIII;
        return this;
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack llllllllllllllIIllIIIIlIllIIIlll, final World llllllllllllllIIllIIIIlIllIIIIIl, final EntityLivingBase llllllllllllllIIllIIIIlIllIIIlIl) {
        if (llllllllllllllIIllIIIIlIllIIIlIl instanceof EntityPlayer) {
            final EntityPlayer llllllllllllllIIllIIIIlIllIIIlII = (EntityPlayer)llllllllllllllIIllIIIIlIllIIIlIl;
            llllllllllllllIIllIIIIlIllIIIlII.getFoodStats().addStats(this, llllllllllllllIIllIIIIlIllIIIlll);
            llllllllllllllIIllIIIIlIllIIIIIl.playSound(null, llllllllllllllIIllIIIIlIllIIIlII.posX, llllllllllllllIIllIIIIlIllIIIlII.posY, llllllllllllllIIllIIIIlIllIIIlII.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5f, llllllllllllllIIllIIIIlIllIIIIIl.rand.nextFloat() * 0.1f + 0.9f);
            this.onFoodEaten(llllllllllllllIIllIIIIlIllIIIlll, llllllllllllllIIllIIIIlIllIIIIIl, llllllllllllllIIllIIIIlIllIIIlII);
            llllllllllllllIIllIIIIlIllIIIlII.addStat(StatList.getObjectUseStats(this));
            if (llllllllllllllIIllIIIIlIllIIIlII instanceof EntityPlayerMP) {
                CriteriaTriggers.field_193138_y.func_193148_a((EntityPlayerMP)llllllllllllllIIllIIIIlIllIIIlII, llllllllllllllIIllIIIIlIllIIIlll);
            }
        }
        llllllllllllllIIllIIIIlIllIIIlll.func_190918_g(1);
        return llllllllllllllIIllIIIIlIllIIIlll;
    }
    
    public ItemFood setAlwaysEdible() {
        this.alwaysEdible = true;
        return this;
    }
    
    public boolean isWolfsFavoriteMeat() {
        return this.isWolfsFavoriteMeat;
    }
    
    public ItemFood(final int llllllllllllllIIllIIIIlIllIlllIl, final float llllllllllllllIIllIIIIlIllIllIII, final boolean llllllllllllllIIllIIIIlIllIllIll) {
        this.itemUseDuration = 32;
        this.healAmount = llllllllllllllIIllIIIIlIllIlllIl;
        this.isWolfsFavoriteMeat = llllllllllllllIIllIIIIlIllIllIll;
        this.saturationModifier = llllllllllllllIIllIIIIlIllIllIII;
        this.setCreativeTab(CreativeTabs.FOOD);
    }
    
    public int getHealAmount(final ItemStack llllllllllllllIIllIIIIlIlIlIIIIl) {
        return this.healAmount;
    }
}
