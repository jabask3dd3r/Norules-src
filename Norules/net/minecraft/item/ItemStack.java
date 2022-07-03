package net.minecraft.item;

import net.minecraft.entity.item.*;
import java.text.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.datafix.walkers.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.advancements.*;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.*;

public final class ItemStack
{
    private /* synthetic */ EntityItemFrame itemFrame;
    private /* synthetic */ boolean field_190928_g;
    public static final /* synthetic */ DecimalFormat DECIMALFORMAT;
    private /* synthetic */ boolean canPlaceOnCacheResult;
    private /* synthetic */ int animationsToGo;
    private /* synthetic */ NBTTagCompound stackTagCompound;
    public /* synthetic */ int stackSize;
    private /* synthetic */ boolean canDestroyCacheResult;
    private /* synthetic */ Block canPlaceOnCacheBlock;
    private /* synthetic */ int itemDamage;
    private final /* synthetic */ Item item;
    public static final /* synthetic */ ItemStack field_190927_a;
    private /* synthetic */ Block canDestroyCacheBlock;
    
    public void func_190918_g(final int lllllllllllllllllIIlIlIIIIlIllII) {
        this.func_190917_f(-lllllllllllllllllIIlIlIIIIlIllII);
    }
    
    public ItemStack func_190924_f(final String lllllllllllllllllIIlIlIlIIlIlIll) {
        this.func_190925_c("display").setString("LocName", lllllllllllllllllIIlIlIlIIlIlIll);
        return this;
    }
    
    public float getStrVsBlock(final IBlockState lllllllllllllllllIIlIllIIlIIllIl) {
        return this.getItem().getStrVsBlock(this, lllllllllllllllllIIlIllIIlIIllIl);
    }
    
    public ItemStack(final Item lllllllllllllllllIIlIllIlIlIIlII) {
        this(lllllllllllllllllIIlIllIlIlIIlII, 1);
    }
    
    public ItemStack(final NBTTagCompound lllllllllllllllllIIlIllIlIIIIllI) {
        this.item = Item.getByNameOrId(lllllllllllllllllIIlIllIlIIIIllI.getString("id"));
        this.stackSize = lllllllllllllllllIIlIllIlIIIIllI.getByte("Count");
        this.itemDamage = Math.max(0, lllllllllllllllllIIlIllIlIIIIllI.getShort("Damage"));
        if (lllllllllllllllllIIlIllIlIIIIllI.hasKey("tag", 10)) {
            this.stackTagCompound = lllllllllllllllllIIlIllIlIIIIllI.getCompoundTag("tag");
            if (this.item != null) {
                this.item.updateItemStackNBT(lllllllllllllllllIIlIllIlIIIIllI);
            }
        }
        this.func_190923_F();
    }
    
    public boolean getHasSubtypes() {
        return this.getItem().getHasSubtypes();
    }
    
    public int getMaxItemUseDuration() {
        return this.getItem().getMaxItemUseDuration(this);
    }
    
    private void func_190923_F() {
        this.field_190928_g = this.func_190926_b();
    }
    
    public ItemStack(final Item lllllllllllllllllIIlIllIlIIllIlI, final int lllllllllllllllllIIlIllIlIIllIIl) {
        this(lllllllllllllllllIIlIllIlIIllIlI, lllllllllllllllllIIlIllIlIIllIIl, 0);
    }
    
    public void setTagInfo(final String lllllllllllllllllIIlIlIIlIlllIII, final NBTBase lllllllllllllllllIIlIlIIlIllIlll) {
        if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
        }
        this.stackTagCompound.setTag(lllllllllllllllllIIlIlIIlIlllIII, lllllllllllllllllIIlIlIIlIllIlll);
    }
    
    public boolean isItemDamaged() {
        return this.isItemStackDamageable() && this.itemDamage > 0;
    }
    
    @Nullable
    public EntityItemFrame getItemFrame() {
        return this.field_190928_g ? null : this.itemFrame;
    }
    
    public ItemStack(final Block lllllllllllllllllIIlIllIlIllllll) {
        this(lllllllllllllllllIIlIllIlIllllll, 1);
    }
    
    public boolean isItemEqualIgnoreDurability(final ItemStack lllllllllllllllllIIlIlIllIIlIIII) {
        if (!this.isItemStackDamageable()) {
            return this.isItemEqual(lllllllllllllllllIIlIlIllIIlIIII);
        }
        return !lllllllllllllllllIIlIlIllIIlIIII.func_190926_b() && this.item == lllllllllllllllllIIlIlIllIIlIIII.item;
    }
    
    public static boolean areItemStacksEqual(final ItemStack lllllllllllllllllIIlIlIllIlIllll, final ItemStack lllllllllllllllllIIlIlIllIlIlllI) {
        return (lllllllllllllllllIIlIlIllIlIllll.func_190926_b() && lllllllllllllllllIIlIlIllIlIlllI.func_190926_b()) || (!lllllllllllllllllIIlIlIllIlIllll.func_190926_b() && !lllllllllllllllllIIlIlIllIlIlllI.func_190926_b() && lllllllllllllllllIIlIlIllIlIllll.isItemStackEqual(lllllllllllllllllIIlIlIllIlIlllI));
    }
    
    public void setTagCompound(@Nullable final NBTTagCompound lllllllllllllllllIIlIlIlIIlllIIl) {
        this.stackTagCompound = lllllllllllllllllIIlIlIlIIlllIIl;
    }
    
    @Nullable
    public NBTTagCompound getTagCompound() {
        return this.stackTagCompound;
    }
    
    public boolean hasEffect() {
        return this.getItem().hasEffect(this);
    }
    
    public void setRepairCost(final int lllllllllllllllllIIlIlIIlIIllllI) {
        if (!this.hasTagCompound()) {
            this.stackTagCompound = new NBTTagCompound();
        }
        this.stackTagCompound.setInteger("RepairCost", lllllllllllllllllIIlIlIIlIIllllI);
    }
    
    public int getRepairCost() {
        return (this.hasTagCompound() && this.stackTagCompound.hasKey("RepairCost", 3)) ? this.stackTagCompound.getInteger("RepairCost") : 0;
    }
    
    public boolean hasDisplayName() {
        final NBTTagCompound lllllllllllllllllIIlIlIlIIIllIll = this.getSubCompound("display");
        return lllllllllllllllllIIlIlIlIIIllIll != null && lllllllllllllllllIIlIlIlIIIllIll.hasKey("Name", 8);
    }
    
    @Nullable
    public NBTTagCompound getSubCompound(final String lllllllllllllllllIIlIlIlIlIIIllI) {
        return (this.stackTagCompound != null && this.stackTagCompound.hasKey(lllllllllllllllllIIlIlIlIlIIIllI, 10)) ? this.stackTagCompound.getCompoundTag(lllllllllllllllllIIlIlIlIlIIIllI) : null;
    }
    
    public boolean canHarvestBlock(final IBlockState lllllllllllllllllIIlIlIlllIIllII) {
        return this.getItem().canHarvestBlock(lllllllllllllllllIIlIlIlllIIllII);
    }
    
    public boolean isItemStackDamageable() {
        return !this.field_190928_g && this.item.getMaxDamage() > 0 && (!this.hasTagCompound() || !this.getTagCompound().getBoolean("Unbreakable"));
    }
    
    public boolean isItemEqual(final ItemStack lllllllllllllllllIIlIlIllIIlIlII) {
        return !lllllllllllllllllIIlIlIllIIlIlII.func_190926_b() && this.item == lllllllllllllllllIIlIlIllIIlIlII.item && this.itemDamage == lllllllllllllllllIIlIlIllIIlIlII.itemDamage;
    }
    
    public boolean canPlaceOn(final Block lllllllllllllllllIIlIlIIIlIIllIl) {
        if (lllllllllllllllllIIlIlIIIlIIllIl == this.canPlaceOnCacheBlock) {
            return this.canPlaceOnCacheResult;
        }
        this.canPlaceOnCacheBlock = lllllllllllllllllIIlIlIIIlIIllIl;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanPlaceOn", 9)) {
            final NBTTagList lllllllllllllllllIIlIlIIIlIlIIIl = this.stackTagCompound.getTagList("CanPlaceOn", 8);
            for (int lllllllllllllllllIIlIlIIIlIlIIII = 0; lllllllllllllllllIIlIlIIIlIlIIII < lllllllllllllllllIIlIlIIIlIlIIIl.tagCount(); ++lllllllllllllllllIIlIlIIIlIlIIII) {
                final Block lllllllllllllllllIIlIlIIIlIIllll = Block.getBlockFromName(lllllllllllllllllIIlIlIIIlIlIIIl.getStringTagAt(lllllllllllllllllIIlIlIIIlIlIIII));
                if (lllllllllllllllllIIlIlIIIlIIllll == lllllllllllllllllIIlIlIIIlIIllIl) {
                    this.canPlaceOnCacheResult = true;
                    return true;
                }
            }
        }
        this.canPlaceOnCacheResult = false;
        return false;
    }
    
    public ItemStack copy() {
        final ItemStack lllllllllllllllllIIlIlIllIlllIlI = new ItemStack(this.item, this.stackSize, this.itemDamage);
        lllllllllllllllllIIlIlIllIlllIlI.func_190915_d(this.func_190921_D());
        if (this.stackTagCompound != null) {
            lllllllllllllllllIIlIlIllIlllIlI.stackTagCompound = this.stackTagCompound.copy();
        }
        return lllllllllllllllllIIlIlIllIlllIlI;
    }
    
    public Multimap<String, AttributeModifier> getAttributeModifiers(final EntityEquipmentSlot lllllllllllllllllIIlIlIIlIIlIIll) {
        Multimap<String, AttributeModifier> lllllllllllllllllIIlIlIIlIIlIIIl = null;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("AttributeModifiers", 9)) {
            final Multimap<String, AttributeModifier> lllllllllllllllllIIlIlIIlIIlIIlI = (Multimap<String, AttributeModifier>)HashMultimap.create();
            final NBTTagList lllllllllllllllllIIlIlIIlIIlIIII = this.stackTagCompound.getTagList("AttributeModifiers", 10);
            for (int lllllllllllllllllIIlIlIIlIIIllll = 0; lllllllllllllllllIIlIlIIlIIIllll < lllllllllllllllllIIlIlIIlIIlIIII.tagCount(); ++lllllllllllllllllIIlIlIIlIIIllll) {
                final NBTTagCompound lllllllllllllllllIIlIlIIlIIIlllI = lllllllllllllllllIIlIlIIlIIlIIII.getCompoundTagAt(lllllllllllllllllIIlIlIIlIIIllll);
                final AttributeModifier lllllllllllllllllIIlIlIIlIIIllIl = SharedMonsterAttributes.readAttributeModifierFromNBT(lllllllllllllllllIIlIlIIlIIIlllI);
                if (lllllllllllllllllIIlIlIIlIIIllIl != null && (!lllllllllllllllllIIlIlIIlIIIlllI.hasKey("Slot", 8) || lllllllllllllllllIIlIlIIlIIIlllI.getString("Slot").equals(lllllllllllllllllIIlIlIIlIIlIIll.getName())) && lllllllllllllllllIIlIlIIlIIIllIl.getID().getLeastSignificantBits() != 0L && lllllllllllllllllIIlIlIIlIIIllIl.getID().getMostSignificantBits() != 0L) {
                    lllllllllllllllllIIlIlIIlIIlIIlI.put((Object)lllllllllllllllllIIlIlIIlIIIlllI.getString("AttributeName"), (Object)lllllllllllllllllIIlIlIIlIIIllIl);
                }
            }
        }
        else {
            lllllllllllllllllIIlIlIIlIIlIIIl = this.getItem().getItemAttributeModifiers(lllllllllllllllllIIlIlIIlIIlIIll);
        }
        return lllllllllllllllllIIlIlIIlIIlIIIl;
    }
    
    public String getDisplayName() {
        final NBTTagCompound lllllllllllllllllIIlIlIlIIllIIll = this.getSubCompound("display");
        if (lllllllllllllllllIIlIlIlIIllIIll != null) {
            if (lllllllllllllllllIIlIlIlIIllIIll.hasKey("Name", 8)) {
                return lllllllllllllllllIIlIlIlIIllIIll.getString("Name");
            }
            if (lllllllllllllllllIIlIlIlIIllIIll.hasKey("LocName", 8)) {
                return I18n.translateToLocal(lllllllllllllllllIIlIlIlIIllIIll.getString("LocName"));
            }
        }
        return this.getItem().getItemStackDisplayName(this);
    }
    
    public Item getItem() {
        return this.field_190928_g ? Item.getItemFromBlock(Blocks.AIR) : this.item;
    }
    
    public int getMaxDamage() {
        return this.getItem().getMaxDamage();
    }
    
    public ItemStack setStackDisplayName(final String lllllllllllllllllIIlIlIlIIlIIlll) {
        this.func_190925_c("display").setString("Name", lllllllllllllllllIIlIlIlIIlIIlll);
        return this;
    }
    
    public void onCrafting(final World lllllllllllllllllIIlIlIlIlllIIll, final EntityPlayer lllllllllllllllllIIlIlIlIllIlllI, final int lllllllllllllllllIIlIlIlIlllIIIl) {
        lllllllllllllllllIIlIlIlIllIlllI.addStat(StatList.getCraftStats(this.item), lllllllllllllllllIIlIlIlIlllIIIl);
        this.getItem().onCreated(this, lllllllllllllllllIIlIlIlIlllIIll, lllllllllllllllllIIlIlIlIllIlllI);
    }
    
    public static boolean areItemsEqual(final ItemStack lllllllllllllllllIIlIlIllIlIIIll, final ItemStack lllllllllllllllllIIlIlIllIlIIIlI) {
        return lllllllllllllllllIIlIlIllIlIIIll == lllllllllllllllllIIlIlIllIlIIIlI || (!lllllllllllllllllIIlIlIllIlIIIll.func_190926_b() && !lllllllllllllllllIIlIlIllIlIIIlI.func_190926_b() && lllllllllllllllllIIlIlIllIlIIIll.isItemEqual(lllllllllllllllllIIlIlIllIlIIIlI));
    }
    
    public void func_190915_d(final int lllllllllllllllllIIlIlIIIlIIIIll) {
        this.animationsToGo = lllllllllllllllllIIlIlIIIlIIIIll;
    }
    
    public EnumRarity getRarity() {
        return this.getItem().getRarity(this);
    }
    
    public void clearCustomName() {
        final NBTTagCompound lllllllllllllllllIIlIlIlIIlIIIIl = this.getSubCompound("display");
        if (lllllllllllllllllIIlIlIlIIlIIIIl != null) {
            lllllllllllllllllIIlIlIlIIlIIIIl.removeTag("Name");
            if (lllllllllllllllllIIlIlIlIIlIIIIl.hasNoTags()) {
                this.func_190919_e("display");
            }
        }
        if (this.stackTagCompound != null && this.stackTagCompound.hasNoTags()) {
            this.stackTagCompound = null;
        }
    }
    
    public static boolean areItemsEqualIgnoreDurability(final ItemStack lllllllllllllllllIIlIlIllIIllIll, final ItemStack lllllllllllllllllIIlIlIllIIllIlI) {
        return lllllllllllllllllIIlIlIllIIllIll == lllllllllllllllllIIlIlIllIIllIlI || (!lllllllllllllllllIIlIlIllIIllIll.func_190926_b() && !lllllllllllllllllIIlIlIllIIllIlI.func_190926_b() && lllllllllllllllllIIlIlIllIIllIll.isItemEqualIgnoreDurability(lllllllllllllllllIIlIlIllIIllIlI));
    }
    
    public void addAttributeModifier(final String lllllllllllllllllIIlIlIIIllllIII, final AttributeModifier lllllllllllllllllIIlIlIIIlllllIl, @Nullable final EntityEquipmentSlot lllllllllllllllllIIlIlIIIlllIllI) {
        if (this.stackTagCompound == null) {
            this.stackTagCompound = new NBTTagCompound();
        }
        if (!this.stackTagCompound.hasKey("AttributeModifiers", 9)) {
            this.stackTagCompound.setTag("AttributeModifiers", new NBTTagList());
        }
        final NBTTagList lllllllllllllllllIIlIlIIIllllIll = this.stackTagCompound.getTagList("AttributeModifiers", 10);
        final NBTTagCompound lllllllllllllllllIIlIlIIIllllIlI = SharedMonsterAttributes.writeAttributeModifierToNBT(lllllllllllllllllIIlIlIIIlllllIl);
        lllllllllllllllllIIlIlIIIllllIlI.setString("AttributeName", lllllllllllllllllIIlIlIIIllllIII);
        if (lllllllllllllllllIIlIlIIIlllIllI != null) {
            lllllllllllllllllIIlIlIIIllllIlI.setString("Slot", lllllllllllllllllIIlIlIIIlllIllI.getName());
        }
        lllllllllllllllllIIlIlIIIllllIll.appendTag(lllllllllllllllllIIlIlIIIllllIlI);
    }
    
    public void func_190917_f(final int lllllllllllllllllIIlIlIIIIllIIlI) {
        this.func_190920_e(this.stackSize + lllllllllllllllllIIlIlIIIIllIIlI);
    }
    
    public void onBlockDestroyed(final World lllllllllllllllllIIlIlIlllIllIlI, final IBlockState lllllllllllllllllIIlIlIlllIlIIll, final BlockPos lllllllllllllllllIIlIlIlllIllIII, final EntityPlayer lllllllllllllllllIIlIlIlllIlIIIl) {
        final boolean lllllllllllllllllIIlIlIlllIlIllI = this.getItem().onBlockDestroyed(this, lllllllllllllllllIIlIlIlllIllIlI, lllllllllllllllllIIlIlIlllIlIIll, lllllllllllllllllIIlIlIlllIllIII, lllllllllllllllllIIlIlIlllIlIIIl);
        if (lllllllllllllllllIIlIlIlllIlIllI) {
            lllllllllllllllllIIlIlIlllIlIIIl.addStat(StatList.getObjectUseStats(this.item));
        }
    }
    
    public ItemStack(final Block lllllllllllllllllIIlIllIlIlllIII, final int lllllllllllllllllIIlIllIlIllIlII) {
        this(lllllllllllllllllIIlIllIlIlllIII, lllllllllllllllllIIlIllIlIllIlII, 0);
    }
    
    public void setItemDamage(final int lllllllllllllllllIIlIllIIIIlIIlI) {
        this.itemDamage = lllllllllllllllllIIlIllIIIIlIIlI;
        if (this.itemDamage < 0) {
            this.itemDamage = 0;
        }
    }
    
    public NBTTagList getEnchantmentTagList() {
        return (this.stackTagCompound != null) ? this.stackTagCompound.getTagList("ench", 10) : new NBTTagList();
    }
    
    public boolean canDestroy(final Block lllllllllllllllllIIlIlIIIllIIIIl) {
        if (lllllllllllllllllIIlIlIIIllIIIIl == this.canDestroyCacheBlock) {
            return this.canDestroyCacheResult;
        }
        this.canDestroyCacheBlock = lllllllllllllllllIIlIlIIIllIIIIl;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanDestroy", 9)) {
            final NBTTagList lllllllllllllllllIIlIlIIIllIIIII = this.stackTagCompound.getTagList("CanDestroy", 8);
            for (int lllllllllllllllllIIlIlIIIlIlllll = 0; lllllllllllllllllIIlIlIIIlIlllll < lllllllllllllllllIIlIlIIIllIIIII.tagCount(); ++lllllllllllllllllIIlIlIIIlIlllll) {
                final Block lllllllllllllllllIIlIlIIIlIllllI = Block.getBlockFromName(lllllllllllllllllIIlIlIIIllIIIII.getStringTagAt(lllllllllllllllllIIlIlIIIlIlllll));
                if (lllllllllllllllllIIlIlIIIlIllllI == lllllllllllllllllIIlIlIIIllIIIIl) {
                    this.canDestroyCacheResult = true;
                    return true;
                }
            }
        }
        this.canDestroyCacheResult = false;
        return false;
    }
    
    public void func_190920_e(final int lllllllllllllllllIIlIlIIIIlllIII) {
        this.stackSize = lllllllllllllllllIIlIlIIIIlllIII;
        this.func_190923_F();
    }
    
    public void damageItem(final int lllllllllllllllllIIlIlIlllllIlII, final EntityLivingBase lllllllllllllllllIIlIlIllllIllll) {
        if ((!(lllllllllllllllllIIlIlIllllIllll instanceof EntityPlayer) || !((EntityPlayer)lllllllllllllllllIIlIlIllllIllll).capabilities.isCreativeMode) && this.isItemStackDamageable() && this.attemptDamageItem(lllllllllllllllllIIlIlIlllllIlII, lllllllllllllllllIIlIlIllllIllll.getRNG(), (lllllllllllllllllIIlIlIllllIllll instanceof EntityPlayerMP) ? ((EntityPlayerMP)lllllllllllllllllIIlIlIllllIllll) : null)) {
            lllllllllllllllllIIlIlIllllIllll.renderBrokenItemStack(this);
            this.func_190918_g(1);
            if (lllllllllllllllllIIlIlIllllIllll instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllllllIIlIlIlllllIIlI = (EntityPlayer)lllllllllllllllllIIlIlIllllIllll;
                lllllllllllllllllIIlIlIlllllIIlI.addStat(StatList.getObjectBreakStats(this.item));
            }
            this.itemDamage = 0;
        }
    }
    
    public boolean canEditBlocks() {
        return this.getItem().canItemEditBlocks();
    }
    
    public int getMetadata() {
        return this.itemDamage;
    }
    
    public void func_190919_e(final String lllllllllllllllllIIlIlIlIlIIIIlI) {
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey(lllllllllllllllllIIlIlIlIlIIIIlI, 10)) {
            this.stackTagCompound.removeTag(lllllllllllllllllIIlIlIlIlIIIIlI);
        }
    }
    
    public int func_190916_E() {
        return this.field_190928_g ? 0 : this.stackSize;
    }
    
    public void updateAnimation(final World lllllllllllllllllIIlIlIlIlllllII, final Entity lllllllllllllllllIIlIlIllIIIIIII, final int lllllllllllllllllIIlIlIlIllllIlI, final boolean lllllllllllllllllIIlIlIlIllllllI) {
        if (this.animationsToGo > 0) {
            --this.animationsToGo;
        }
        if (this.item != null) {
            this.item.onUpdate(this, lllllllllllllllllIIlIlIlIlllllII, lllllllllllllllllIIlIlIllIIIIIII, lllllllllllllllllIIlIlIlIllllIlI, lllllllllllllllllIIlIlIlIllllllI);
        }
    }
    
    public void hitEntity(final EntityLivingBase lllllllllllllllllIIlIlIllllIIlII, final EntityPlayer lllllllllllllllllIIlIlIllllIIIll) {
        final boolean lllllllllllllllllIIlIlIllllIIllI = this.item.hitEntity(this, lllllllllllllllllIIlIlIllllIIlII, lllllllllllllllllIIlIlIllllIIIll);
        if (lllllllllllllllllIIlIlIllllIIllI) {
            lllllllllllllllllIIlIlIllllIIIll.addStat(StatList.getObjectUseStats(this.item));
        }
    }
    
    public boolean isOnItemFrame() {
        return this.itemFrame != null;
    }
    
    public static boolean areItemStackTagsEqual(final ItemStack lllllllllllllllllIIlIlIllIllIIll, final ItemStack lllllllllllllllllIIlIlIllIllIIlI) {
        return (lllllllllllllllllIIlIlIllIllIIll.func_190926_b() && lllllllllllllllllIIlIlIllIllIIlI.func_190926_b()) || (!lllllllllllllllllIIlIlIllIllIIll.func_190926_b() && !lllllllllllllllllIIlIlIllIllIIlI.func_190926_b() && (lllllllllllllllllIIlIlIllIllIIll.stackTagCompound != null || lllllllllllllllllIIlIlIllIllIIlI.stackTagCompound == null) && (lllllllllllllllllIIlIlIllIllIIll.stackTagCompound == null || lllllllllllllllllIIlIlIllIllIIll.stackTagCompound.equals(lllllllllllllllllIIlIlIllIllIIlI.stackTagCompound)));
    }
    
    public ItemStack onItemUseFinish(final World lllllllllllllllllIIlIllIIIllIlll, final EntityLivingBase lllllllllllllllllIIlIllIIIllIllI) {
        return this.getItem().onItemUseFinish(this, lllllllllllllllllIIlIllIIIllIlll, lllllllllllllllllIIlIllIIIllIllI);
    }
    
    public ItemStack splitStack(final int lllllllllllllllllIIlIllIIlllIlII) {
        final int lllllllllllllllllIIlIllIIlllIlll = Math.min(lllllllllllllllllIIlIllIIlllIlII, this.stackSize);
        final ItemStack lllllllllllllllllIIlIllIIlllIllI = this.copy();
        lllllllllllllllllIIlIllIIlllIllI.func_190920_e(lllllllllllllllllIIlIllIIlllIlll);
        this.func_190918_g(lllllllllllllllllIIlIllIIlllIlll);
        return lllllllllllllllllIIlIllIIlllIllI;
    }
    
    public boolean isItemEnchantable() {
        return this.getItem().isItemTool(this) && !this.isItemEnchanted();
    }
    
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllllllIIlIllIIllIIIll, final World lllllllllllllllllIIlIllIIllIIIlI, final BlockPos lllllllllllllllllIIlIllIIllIIIIl, final EnumHand lllllllllllllllllIIlIllIIllIIIII, final EnumFacing lllllllllllllllllIIlIllIIlIlIlIl, final float lllllllllllllllllIIlIllIIlIllllI, final float lllllllllllllllllIIlIllIIlIlllIl, final float lllllllllllllllllIIlIllIIlIlIIlI) {
        final EnumActionResult lllllllllllllllllIIlIllIIlIllIll = this.getItem().onItemUse(lllllllllllllllllIIlIllIIllIIIll, lllllllllllllllllIIlIllIIllIIIlI, lllllllllllllllllIIlIllIIllIIIIl, lllllllllllllllllIIlIllIIllIIIII, lllllllllllllllllIIlIllIIlIlIlIl, lllllllllllllllllIIlIllIIlIllllI, lllllllllllllllllIIlIllIIlIlllIl, lllllllllllllllllIIlIllIIlIlIIlI);
        if (lllllllllllllllllIIlIllIIlIllIll == EnumActionResult.SUCCESS) {
            lllllllllllllllllIIlIllIIllIIIll.addStat(StatList.getObjectUseStats(this.item));
        }
        return lllllllllllllllllIIlIllIIlIllIll;
    }
    
    public boolean hasTagCompound() {
        return !this.field_190928_g && this.stackTagCompound != null;
    }
    
    public int getMaxStackSize() {
        return this.getItem().getItemStackLimit();
    }
    
    public boolean interactWithEntity(final EntityPlayer lllllllllllllllllIIlIlIlllIIIIII, final EntityLivingBase lllllllllllllllllIIlIlIlllIIIIll, final EnumHand lllllllllllllllllIIlIlIlllIIIIlI) {
        return this.getItem().itemInteractionForEntity(this, lllllllllllllllllIIlIlIlllIIIIII, lllllllllllllllllIIlIlIlllIIIIll, lllllllllllllllllIIlIlIlllIIIIlI);
    }
    
    public boolean func_190926_b() {
        return this == ItemStack.field_190927_a || this.item == null || this.item == Item.getItemFromBlock(Blocks.AIR) || this.stackSize <= 0 || this.itemDamage < -32768 || this.itemDamage > 65535;
    }
    
    public int getItemDamage() {
        return this.itemDamage;
    }
    
    public ItemStack(final Item lllllllllllllllllIIlIllIlIIlIIll, final int lllllllllllllllllIIlIllIlIIlIIlI, final int lllllllllllllllllIIlIllIlIIIllIl) {
        this.item = lllllllllllllllllIIlIllIlIIlIIll;
        this.itemDamage = lllllllllllllllllIIlIllIlIIIllIl;
        this.stackSize = lllllllllllllllllIIlIllIlIIlIIlI;
        if (this.itemDamage < 0) {
            this.itemDamage = 0;
        }
        this.func_190923_F();
    }
    
    public void setItemFrame(final EntityItemFrame lllllllllllllllllIIlIlIIlIlIlIlI) {
        this.itemFrame = lllllllllllllllllIIlIlIIlIlIlIlI;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllllIIlIllIIIllIIIl) {
        final ResourceLocation lllllllllllllllllIIlIllIIIllIIII = Item.REGISTRY.getNameForObject(this.item);
        lllllllllllllllllIIlIllIIIllIIIl.setString("id", (lllllllllllllllllIIlIllIIIllIIII == null) ? "minecraft:air" : lllllllllllllllllIIlIllIIIllIIII.toString());
        lllllllllllllllllIIlIllIIIllIIIl.setByte("Count", (byte)this.stackSize);
        lllllllllllllllllIIlIllIIIllIIIl.setShort("Damage", (short)this.itemDamage);
        if (this.stackTagCompound != null) {
            lllllllllllllllllIIlIllIIIllIIIl.setTag("tag", this.stackTagCompound);
        }
        return lllllllllllllllllIIlIllIIIllIIIl;
    }
    
    public List<String> getTooltip(@Nullable final EntityPlayer lllllllllllllllllIIlIlIIlllIIlll, final ITooltipFlag lllllllllllllllllIIlIlIlIIIIIlIl) {
        final List<String> lllllllllllllllllIIlIlIlIIIIIlII = (List<String>)Lists.newArrayList();
        String lllllllllllllllllIIlIlIlIIIIIIll = this.getDisplayName();
        if (this.hasDisplayName()) {
            lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder().append(TextFormatting.ITALIC).append(lllllllllllllllllIIlIlIlIIIIIIll));
        }
        lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIlIlIIIIIIll)).append(TextFormatting.RESET));
        if (lllllllllllllllllIIlIlIlIIIIIlIl.func_194127_a()) {
            String lllllllllllllllllIIlIlIlIIIIIIlI = "";
            if (!lllllllllllllllllIIlIlIlIIIIIIll.isEmpty()) {
                lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIlIlIIIIIIll)).append(" ("));
                lllllllllllllllllIIlIlIlIIIIIIlI = ")";
            }
            final int lllllllllllllllllIIlIlIlIIIIIIIl = Item.getIdFromItem(this.item);
            if (this.getHasSubtypes()) {
                lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIlIlIIIIIIll)).append(String.format("#%04d/%d%s", lllllllllllllllllIIlIlIlIIIIIIIl, this.itemDamage, lllllllllllllllllIIlIlIlIIIIIIlI)));
            }
            else {
                lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIlIlIIIIIIll)).append(String.format("#%04d%s", lllllllllllllllllIIlIlIlIIIIIIIl, lllllllllllllllllIIlIlIlIIIIIIlI)));
            }
        }
        else if (!this.hasDisplayName() && this.item == Items.FILLED_MAP) {
            lllllllllllllllllIIlIlIlIIIIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIlIlIlIIIIIIll)).append(" #").append(this.itemDamage));
        }
        lllllllllllllllllIIlIlIlIIIIIlII.add(lllllllllllllllllIIlIlIlIIIIIIll);
        int lllllllllllllllllIIlIlIlIIIIIIII = 0;
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("HideFlags", 99)) {
            lllllllllllllllllIIlIlIlIIIIIIII = this.stackTagCompound.getInteger("HideFlags");
        }
        if ((lllllllllllllllllIIlIlIlIIIIIIII & 0x20) == 0x0) {
            this.getItem().addInformation(this, (lllllllllllllllllIIlIlIIlllIIlll == null) ? null : lllllllllllllllllIIlIlIIlllIIlll.world, lllllllllllllllllIIlIlIlIIIIIlII, lllllllllllllllllIIlIlIlIIIIIlIl);
        }
        if (this.hasTagCompound()) {
            if ((lllllllllllllllllIIlIlIlIIIIIIII & 0x1) == 0x0) {
                final NBTTagList lllllllllllllllllIIlIlIIllllllll = this.getEnchantmentTagList();
                for (int lllllllllllllllllIIlIlIIlllllllI = 0; lllllllllllllllllIIlIlIIlllllllI < lllllllllllllllllIIlIlIIllllllll.tagCount(); ++lllllllllllllllllIIlIlIIlllllllI) {
                    final NBTTagCompound lllllllllllllllllIIlIlIIllllllIl = lllllllllllllllllIIlIlIIllllllll.getCompoundTagAt(lllllllllllllllllIIlIlIIlllllllI);
                    final int lllllllllllllllllIIlIlIIllllllII = lllllllllllllllllIIlIlIIllllllIl.getShort("id");
                    final int lllllllllllllllllIIlIlIIlllllIll = lllllllllllllllllIIlIlIIllllllIl.getShort("lvl");
                    final Enchantment lllllllllllllllllIIlIlIIlllllIlI = Enchantment.getEnchantmentByID(lllllllllllllllllIIlIlIIllllllII);
                    if (lllllllllllllllllIIlIlIIlllllIlI != null) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(lllllllllllllllllIIlIlIIlllllIlI.getTranslatedName(lllllllllllllllllIIlIlIIlllllIll));
                    }
                }
            }
            if (this.stackTagCompound.hasKey("display", 10)) {
                final NBTTagCompound lllllllllllllllllIIlIlIIlllllIIl = this.stackTagCompound.getCompoundTag("display");
                if (lllllllllllllllllIIlIlIIlllllIIl.hasKey("color", 3)) {
                    if (lllllllllllllllllIIlIlIlIIIIIlIl.func_194127_a()) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(I18n.translateToLocalFormatted("item.color", String.format("#%06X", lllllllllllllllllIIlIlIIlllllIIl.getInteger("color"))));
                    }
                    else {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.ITALIC).append(I18n.translateToLocal("item.dyed"))));
                    }
                }
                if (lllllllllllllllllIIlIlIIlllllIIl.getTagId("Lore") == 9) {
                    final NBTTagList lllllllllllllllllIIlIlIIlllllIII = lllllllllllllllllIIlIlIIlllllIIl.getTagList("Lore", 8);
                    if (!lllllllllllllllllIIlIlIIlllllIII.hasNoTags()) {
                        for (int lllllllllllllllllIIlIlIIllllIlll = 0; lllllllllllllllllIIlIlIIllllIlll < lllllllllllllllllIIlIlIIlllllIII.tagCount(); ++lllllllllllllllllIIlIlIIllllIlll) {
                            lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_PURPLE).append(TextFormatting.ITALIC).append(lllllllllllllllllIIlIlIIlllllIII.getStringTagAt(lllllllllllllllllIIlIlIIllllIlll))));
                        }
                    }
                }
            }
        }
        final long lllllllllllllllllIIlIlIIllIlllll;
        final int length = (lllllllllllllllllIIlIlIIllIlllll = (long)(Object)EntityEquipmentSlot.values()).length;
        for (Exception lllllllllllllllllIIlIlIIlllIIIIl = (Exception)0; lllllllllllllllllIIlIlIIlllIIIIl < length; ++lllllllllllllllllIIlIlIIlllIIIIl) {
            final EntityEquipmentSlot lllllllllllllllllIIlIlIIllllIllI = lllllllllllllllllIIlIlIIllIlllll[lllllllllllllllllIIlIlIIlllIIIIl];
            final Multimap<String, AttributeModifier> lllllllllllllllllIIlIlIIllllIlIl = this.getAttributeModifiers(lllllllllllllllllIIlIlIIllllIllI);
            if (!lllllllllllllllllIIlIlIIllllIlIl.isEmpty() && (lllllllllllllllllIIlIlIlIIIIIIII & 0x2) == 0x0) {
                lllllllllllllllllIIlIlIlIIIIIlII.add("");
                lllllllllllllllllIIlIlIlIIIIIlII.add(I18n.translateToLocal(String.valueOf(new StringBuilder("item.modifiers.").append(lllllllllllllllllIIlIlIIllllIllI.getName()))));
                for (final Map.Entry<String, AttributeModifier> lllllllllllllllllIIlIlIIllllIlII : lllllllllllllllllIIlIlIIllllIlIl.entries()) {
                    final AttributeModifier lllllllllllllllllIIlIlIIllllIIll = lllllllllllllllllIIlIlIIllllIlII.getValue();
                    double lllllllllllllllllIIlIlIIllllIIlI = lllllllllllllllllIIlIlIIllllIIll.getAmount();
                    boolean lllllllllllllllllIIlIlIIllllIIIl = false;
                    if (lllllllllllllllllIIlIlIIlllIIlll != null) {
                        if (lllllllllllllllllIIlIlIIllllIIll.getID() == Item.ATTACK_DAMAGE_MODIFIER) {
                            lllllllllllllllllIIlIlIIllllIIlI += lllllllllllllllllIIlIlIIlllIIlll.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue();
                            lllllllllllllllllIIlIlIIllllIIlI += EnchantmentHelper.getModifierForCreature(this, EnumCreatureAttribute.UNDEFINED);
                            lllllllllllllllllIIlIlIIllllIIIl = true;
                        }
                        else if (lllllllllllllllllIIlIlIIllllIIll.getID() == Item.ATTACK_SPEED_MODIFIER) {
                            lllllllllllllllllIIlIlIIllllIIlI += lllllllllllllllllIIlIlIIlllIIlll.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getBaseValue();
                            lllllllllllllllllIIlIlIIllllIIIl = true;
                        }
                    }
                    double lllllllllllllllllIIlIlIIlllIllll = 0.0;
                    if (lllllllllllllllllIIlIlIIllllIIll.getOperation() != 1 && lllllllllllllllllIIlIlIIllllIIll.getOperation() != 2) {
                        final double lllllllllllllllllIIlIlIIllllIIII = lllllllllllllllllIIlIlIIllllIIlI;
                    }
                    else {
                        lllllllllllllllllIIlIlIIlllIllll = lllllllllllllllllIIlIlIIllllIIlI * 100.0;
                    }
                    if (lllllllllllllllllIIlIlIIllllIIIl) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder(" ").append(I18n.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.equals.").append(lllllllllllllllllIIlIlIIllllIIll.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllllllIIlIlIIlllIllll), I18n.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllllllIIlIlIIllllIlII.getKey())))))));
                    }
                    else if (lllllllllllllllllIIlIlIIllllIIlI > 0.0) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.BLUE).append(" ").append(I18n.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.plus.").append(lllllllllllllllllIIlIlIIllllIIll.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllllllIIlIlIIlllIllll), I18n.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllllllIIlIlIIllllIlII.getKey())))))));
                    }
                    else {
                        if (lllllllllllllllllIIlIlIIllllIIlI >= 0.0) {
                            continue;
                        }
                        lllllllllllllllllIIlIlIIlllIllll *= -1.0;
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.RED).append(" ").append(I18n.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.take.").append(lllllllllllllllllIIlIlIIllllIIll.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllllllIIlIlIIlllIllll), I18n.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllllllIIlIlIIllllIlII.getKey())))))));
                    }
                }
            }
        }
        if (this.hasTagCompound() && this.getTagCompound().getBoolean("Unbreakable") && (lllllllllllllllllIIlIlIlIIIIIIII & 0x4) == 0x0) {
            lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.BLUE).append(I18n.translateToLocal("item.unbreakable"))));
        }
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanDestroy", 9) && (lllllllllllllllllIIlIlIlIIIIIIII & 0x8) == 0x0) {
            final NBTTagList lllllllllllllllllIIlIlIIlllIlllI = this.stackTagCompound.getTagList("CanDestroy", 8);
            if (!lllllllllllllllllIIlIlIIlllIlllI.hasNoTags()) {
                lllllllllllllllllIIlIlIlIIIIIlII.add("");
                lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(I18n.translateToLocal("item.canBreak"))));
                for (int lllllllllllllllllIIlIlIIlllIllIl = 0; lllllllllllllllllIIlIlIIlllIllIl < lllllllllllllllllIIlIlIIlllIlllI.tagCount(); ++lllllllllllllllllIIlIlIIlllIllIl) {
                    final Block lllllllllllllllllIIlIlIIlllIllII = Block.getBlockFromName(lllllllllllllllllIIlIlIIlllIlllI.getStringTagAt(lllllllllllllllllIIlIlIIlllIllIl));
                    if (lllllllllllllllllIIlIlIIlllIllII != null) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(lllllllllllllllllIIlIlIIlllIllII.getLocalizedName())));
                    }
                    else {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append("missingno")));
                    }
                }
            }
        }
        if (this.hasTagCompound() && this.stackTagCompound.hasKey("CanPlaceOn", 9) && (lllllllllllllllllIIlIlIlIIIIIIII & 0x10) == 0x0) {
            final NBTTagList lllllllllllllllllIIlIlIIlllIlIll = this.stackTagCompound.getTagList("CanPlaceOn", 8);
            if (!lllllllllllllllllIIlIlIIlllIlIll.hasNoTags()) {
                lllllllllllllllllIIlIlIlIIIIIlII.add("");
                lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(I18n.translateToLocal("item.canPlace"))));
                for (int lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIll.tagCount(); ++lllllllllllllllllIIlIlIIlllIlIlI) {
                    final Block lllllllllllllllllIIlIlIIlllIlIIl = Block.getBlockFromName(lllllllllllllllllIIlIlIIlllIlIll.getStringTagAt(lllllllllllllllllIIlIlIIlllIlIlI));
                    if (lllllllllllllllllIIlIlIIlllIlIIl != null) {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(lllllllllllllllllIIlIlIIlllIlIIl.getLocalizedName())));
                    }
                    else {
                        lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append("missingno")));
                    }
                }
            }
        }
        if (lllllllllllllllllIIlIlIlIIIIIlIl.func_194127_a()) {
            if (this.isItemDamaged()) {
                lllllllllllllllllIIlIlIlIIIIIlII.add(I18n.translateToLocalFormatted("item.durability", this.getMaxDamage() - this.getItemDamage(), this.getMaxDamage()));
            }
            lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(Item.REGISTRY.getNameForObject(this.item).toString())));
            if (this.hasTagCompound()) {
                lllllllllllllllllIIlIlIlIIIIIlII.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(I18n.translateToLocalFormatted("item.nbt_tags", this.getTagCompound().getKeySet().size()))));
            }
        }
        return lllllllllllllllllIIlIlIlIIIIIlII;
    }
    
    public NBTTagCompound func_190925_c(final String lllllllllllllllllIIlIlIlIlIlIIII) {
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey(lllllllllllllllllIIlIlIlIlIlIIII, 10)) {
            return this.stackTagCompound.getCompoundTag(lllllllllllllllllIIlIlIlIlIlIIII);
        }
        final NBTTagCompound lllllllllllllllllIIlIlIlIlIIllll = new NBTTagCompound();
        this.setTagInfo(lllllllllllllllllIIlIlIlIlIlIIII, lllllllllllllllllIIlIlIlIlIIllll);
        return lllllllllllllllllIIlIlIlIlIIllll;
    }
    
    private boolean isItemStackEqual(final ItemStack lllllllllllllllllIIlIlIllIlIIllI) {
        return this.stackSize == lllllllllllllllllIIlIlIllIlIIllI.stackSize && this.getItem() == lllllllllllllllllIIlIlIllIlIIllI.getItem() && this.itemDamage == lllllllllllllllllIIlIlIllIlIIllI.itemDamage && (this.stackTagCompound != null || lllllllllllllllllIIlIlIllIlIIllI.stackTagCompound == null) && (this.stackTagCompound == null || this.stackTagCompound.equals(lllllllllllllllllIIlIlIllIlIIllI.stackTagCompound));
    }
    
    public boolean isItemEnchanted() {
        return this.stackTagCompound != null && this.stackTagCompound.hasKey("ench", 9) && !this.stackTagCompound.getTagList("ench", 10).hasNoTags();
    }
    
    public ActionResult<ItemStack> useItemRightClick(final World lllllllllllllllllIIlIllIIlIIIlIl, final EntityPlayer lllllllllllllllllIIlIllIIlIIIIII, final EnumHand lllllllllllllllllIIlIllIIlIIIIll) {
        return this.getItem().onItemRightClick(lllllllllllllllllIIlIllIIlIIIlIl, lllllllllllllllllIIlIllIIlIIIIII, lllllllllllllllllIIlIllIIlIIIIll);
    }
    
    public String getUnlocalizedName() {
        return this.getItem().getUnlocalizedName(this);
    }
    
    public static void registerFixes(final DataFixer lllllllllllllllllIIlIllIIllllllI) {
        lllllllllllllllllIIlIllIIllllllI.registerWalker(FixTypes.ITEM_INSTANCE, new BlockEntityTag());
        lllllllllllllllllIIlIllIIllllllI.registerWalker(FixTypes.ITEM_INSTANCE, new EntityTag());
    }
    
    public ItemStack(final Block lllllllllllllllllIIlIllIlIlIlIlI, final int lllllllllllllllllIIlIllIlIlIllIl, final int lllllllllllllllllIIlIllIlIlIlIII) {
        this(Item.getItemFromBlock(lllllllllllllllllIIlIllIlIlIlIlI), lllllllllllllllllIIlIllIlIlIllIl, lllllllllllllllllIIlIllIlIlIlIII);
    }
    
    public boolean isStackable() {
        return this.getMaxStackSize() > 1 && (!this.isItemStackDamageable() || !this.isItemDamaged());
    }
    
    public boolean attemptDamageItem(int lllllllllllllllllIIlIlIlllllllll, final Random lllllllllllllllllIIlIllIIIIIIlIl, @Nullable final EntityPlayerMP lllllllllllllllllIIlIllIIIIIIlII) {
        if (!this.isItemStackDamageable()) {
            return false;
        }
        if (lllllllllllllllllIIlIlIlllllllll > 0) {
            final int lllllllllllllllllIIlIllIIIIIIIll = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, this);
            int lllllllllllllllllIIlIllIIIIIIIlI = 0;
            for (int lllllllllllllllllIIlIllIIIIIIIIl = 0; lllllllllllllllllIIlIllIIIIIIIll > 0 && lllllllllllllllllIIlIllIIIIIIIIl < lllllllllllllllllIIlIlIlllllllll; ++lllllllllllllllllIIlIllIIIIIIIIl) {
                if (EnchantmentDurability.negateDamage(this, lllllllllllllllllIIlIllIIIIIIIll, lllllllllllllllllIIlIllIIIIIIlIl)) {
                    ++lllllllllllllllllIIlIllIIIIIIIlI;
                }
            }
            lllllllllllllllllIIlIlIlllllllll -= lllllllllllllllllIIlIllIIIIIIIlI;
            if (lllllllllllllllllIIlIlIlllllllll <= 0) {
                return false;
            }
        }
        if (lllllllllllllllllIIlIllIIIIIIlII != null && lllllllllllllllllIIlIlIlllllllll != 0) {
            CriteriaTriggers.field_193132_s.func_193158_a(lllllllllllllllllIIlIllIIIIIIlII, this, this.itemDamage + lllllllllllllllllIIlIlIlllllllll);
        }
        this.itemDamage += lllllllllllllllllIIlIlIlllllllll;
        return this.itemDamage > this.getMaxDamage();
    }
    
    public EnumAction getItemUseAction() {
        return this.getItem().getItemUseAction(this);
    }
    
    public ITextComponent getTextComponent() {
        final TextComponentString lllllllllllllllllIIlIlIIIllIlllI = new TextComponentString(this.getDisplayName());
        if (this.hasDisplayName()) {
            lllllllllllllllllIIlIlIIIllIlllI.getStyle().setItalic(true);
        }
        final ITextComponent lllllllllllllllllIIlIlIIIllIllIl = new TextComponentString("[").appendSibling(lllllllllllllllllIIlIlIIIllIlllI).appendText("]");
        if (!this.field_190928_g) {
            final NBTTagCompound lllllllllllllllllIIlIlIIIllIllII = this.writeToNBT(new NBTTagCompound());
            lllllllllllllllllIIlIlIIIllIllIl.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new TextComponentString(lllllllllllllllllIIlIlIIIllIllII.toString())));
            lllllllllllllllllIIlIlIIIllIllIl.getStyle().setColor(this.getRarity().rarityColor);
        }
        return lllllllllllllllllIIlIlIIIllIllIl;
    }
    
    static {
        field_190927_a = new ItemStack((Item)null);
        DECIMALFORMAT = new DecimalFormat("#.##");
    }
    
    public void addEnchantment(final Enchantment lllllllllllllllllIIlIlIIllIIIIll, final int lllllllllllllllllIIlIlIIllIIIIlI) {
        if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
        }
        if (!this.stackTagCompound.hasKey("ench", 9)) {
            this.stackTagCompound.setTag("ench", new NBTTagList());
        }
        final NBTTagList lllllllllllllllllIIlIlIIllIIIllI = this.stackTagCompound.getTagList("ench", 10);
        final NBTTagCompound lllllllllllllllllIIlIlIIllIIIlIl = new NBTTagCompound();
        lllllllllllllllllIIlIlIIllIIIlIl.setShort("id", (short)Enchantment.getEnchantmentID(lllllllllllllllllIIlIlIIllIIIIll));
        lllllllllllllllllIIlIlIIllIIIlIl.setShort("lvl", (byte)lllllllllllllllllIIlIlIIllIIIIlI);
        lllllllllllllllllIIlIlIIllIIIllI.appendTag(lllllllllllllllllIIlIlIIllIIIlIl);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.stackSize)).append("x").append(this.getItem().getUnlocalizedName()).append("@").append(this.itemDamage));
    }
    
    public int func_190921_D() {
        return this.animationsToGo;
    }
    
    public void onPlayerStoppedUsing(final World lllllllllllllllllIIlIlIlIllIIIIl, final EntityLivingBase lllllllllllllllllIIlIlIlIllIIIII, final int lllllllllllllllllIIlIlIlIlIlllll) {
        this.getItem().onPlayerStoppedUsing(this, lllllllllllllllllIIlIlIlIllIIIIl, lllllllllllllllllIIlIlIlIllIIIII, lllllllllllllllllIIlIlIlIlIlllll);
    }
}
