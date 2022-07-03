package net.minecraft.item;

import net.minecraft.inventory.*;
import net.minecraft.dispenser.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class ItemArmor extends Item
{
    public static final /* synthetic */ IBehaviorDispenseItem DISPENSER_BEHAVIOR;
    public final /* synthetic */ int renderIndex;
    public final /* synthetic */ int damageReduceAmount;
    public final /* synthetic */ float toughness;
    private static final /* synthetic */ int[] MAX_DAMAGE_ARRAY;
    private final /* synthetic */ ArmorMaterial material;
    private static final /* synthetic */ UUID[] ARMOR_MODIFIERS;
    public final /* synthetic */ EntityEquipmentSlot armorType;
    
    @Override
    public boolean getIsRepairable(final ItemStack lllllllllllllIlIlIlllIlIIIlIIIll, final ItemStack lllllllllllllIlIlIlllIlIIIlIIIlI) {
        return this.material.getRepairItem() == lllllllllllllIlIlIlllIlIIIlIIIlI.getItem() || super.getIsRepairable(lllllllllllllIlIlIlllIlIIIlIIIll, lllllllllllllIlIlIlllIlIIIlIIIlI);
    }
    
    public boolean hasColor(final ItemStack lllllllllllllIlIlIlllIlIIlIlIllI) {
        if (this.material != ArmorMaterial.LEATHER) {
            return false;
        }
        final NBTTagCompound lllllllllllllIlIlIlllIlIIlIlIlIl = lllllllllllllIlIlIlllIlIIlIlIllI.getTagCompound();
        return lllllllllllllIlIlIlllIlIIlIlIlIl != null && lllllllllllllIlIlIlllIlIIlIlIlIl.hasKey("display", 10) && lllllllllllllIlIlIlllIlIIlIlIlIl.getCompoundTag("display").hasKey("color", 3);
    }
    
    public int getColor(final ItemStack lllllllllllllIlIlIlllIlIIlIIlIII) {
        if (this.material != ArmorMaterial.LEATHER) {
            return 16777215;
        }
        final NBTTagCompound lllllllllllllIlIlIlllIlIIlIIlIll = lllllllllllllIlIlIlllIlIIlIIlIII.getTagCompound();
        if (lllllllllllllIlIlIlllIlIIlIIlIll != null) {
            final NBTTagCompound lllllllllllllIlIlIlllIlIIlIIlIlI = lllllllllllllIlIlIlllIlIIlIIlIll.getCompoundTag("display");
            if (lllllllllllllIlIlIlllIlIIlIIlIlI != null && lllllllllllllIlIlIlllIlIIlIIlIlI.hasKey("color", 3)) {
                return lllllllllllllIlIlIlllIlIIlIIlIlI.getInteger("color");
            }
        }
        return 10511680;
    }
    
    static {
        MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
        ARMOR_MODIFIERS = new UUID[] { UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150") };
        EMPTY_SLOT_NAMES = new String[] { "minecraft:items/empty_armor_slot_boots", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_helmet" };
        DISPENSER_BEHAVIOR = new BehaviorDefaultDispenseItem() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllIllIIIlIlllIlIlllll, final ItemStack lllllllllllllIllIIIlIlllIlIllIlI) {
                final ItemStack lllllllllllllIllIIIlIlllIlIlllIl = ItemArmor.dispenseArmor(lllllllllllllIllIIIlIlllIlIlllll, lllllllllllllIllIIIlIlllIlIllIlI);
                return lllllllllllllIllIIIlIlllIlIlllIl.func_190926_b() ? super.dispenseStack(lllllllllllllIllIIIlIlllIlIlllll, lllllllllllllIllIIIlIlllIlIllIlI) : lllllllllllllIllIIIlIlllIlIlllIl;
            }
        };
    }
    
    public void removeColor(final ItemStack lllllllllllllIlIlIlllIlIIIllllII) {
        if (this.material == ArmorMaterial.LEATHER) {
            final NBTTagCompound lllllllllllllIlIlIlllIlIIIllllll = lllllllllllllIlIlIlllIlIIIllllII.getTagCompound();
            if (lllllllllllllIlIlIlllIlIIIllllll != null) {
                final NBTTagCompound lllllllllllllIlIlIlllIlIIIlllllI = lllllllllllllIlIlIlllIlIIIllllll.getCompoundTag("display");
                if (lllllllllllllIlIlIlllIlIIIlllllI.hasKey("color")) {
                    lllllllllllllIlIlIlllIlIIIlllllI.removeTag("color");
                }
            }
        }
    }
    
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot lllllllllllllIlIlIlllIlIIIIIlIIl) {
        final Multimap<String, AttributeModifier> lllllllllllllIlIlIlllIlIIIIIlIll = super.getItemAttributeModifiers(lllllllllllllIlIlIlllIlIIIIIlIIl);
        if (lllllllllllllIlIlIlllIlIIIIIlIIl == this.armorType) {
            lllllllllllllIlIlIlllIlIIIIIlIll.put((Object)SharedMonsterAttributes.ARMOR.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemArmor.ARMOR_MODIFIERS[lllllllllllllIlIlIlllIlIIIIIlIIl.getIndex()], "Armor modifier", this.damageReduceAmount, 0));
            lllllllllllllIlIlIlllIlIIIIIlIll.put((Object)SharedMonsterAttributes.ARMOR_TOUGHNESS.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemArmor.ARMOR_MODIFIERS[lllllllllllllIlIlIlllIlIIIIIlIIl.getIndex()], "Armor toughness", this.toughness, 0));
        }
        return lllllllllllllIlIlIlllIlIIIIIlIll;
    }
    
    public ArmorMaterial getArmorMaterial() {
        return this.material;
    }
    
    public EntityEquipmentSlot getEquipmentSlot() {
        return this.armorType;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIlIlIlllIlIIIIllIll, final EntityPlayer lllllllllllllIlIlIlllIlIIIIlIlIl, final EnumHand lllllllllllllIlIlIlllIlIIIIllIIl) {
        final ItemStack lllllllllllllIlIlIlllIlIIIIllIII = lllllllllllllIlIlIlllIlIIIIlIlIl.getHeldItem(lllllllllllllIlIlIlllIlIIIIllIIl);
        final EntityEquipmentSlot lllllllllllllIlIlIlllIlIIIIlIlll = EntityLiving.getSlotForItemStack(lllllllllllllIlIlIlllIlIIIIllIII);
        final ItemStack lllllllllllllIlIlIlllIlIIIIlIllI = lllllllllllllIlIlIlllIlIIIIlIlIl.getItemStackFromSlot(lllllllllllllIlIlIlllIlIIIIlIlll);
        if (lllllllllllllIlIlIlllIlIIIIlIllI.func_190926_b()) {
            lllllllllllllIlIlIlllIlIIIIlIlIl.setItemStackToSlot(lllllllllllllIlIlIlllIlIIIIlIlll, lllllllllllllIlIlIlllIlIIIIllIII.copy());
            lllllllllllllIlIlIlllIlIIIIllIII.func_190920_e(0);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIlIlIlllIlIIIIllIII);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllIlIlIlllIlIIIIllIII);
    }
    
    public void setColor(final ItemStack lllllllllllllIlIlIlllIlIIIllIIll, final int lllllllllllllIlIlIlllIlIIIlIllIl) {
        if (this.material != ArmorMaterial.LEATHER) {
            throw new UnsupportedOperationException("Can't dye non-leather!");
        }
        NBTTagCompound lllllllllllllIlIlIlllIlIIIllIIIl = lllllllllllllIlIlIlllIlIIIllIIll.getTagCompound();
        if (lllllllllllllIlIlIlllIlIIIllIIIl == null) {
            lllllllllllllIlIlIlllIlIIIllIIIl = new NBTTagCompound();
            lllllllllllllIlIlIlllIlIIIllIIll.setTagCompound(lllllllllllllIlIlIlllIlIIIllIIIl);
        }
        final NBTTagCompound lllllllllllllIlIlIlllIlIIIllIIII = lllllllllllllIlIlIlllIlIIIllIIIl.getCompoundTag("display");
        if (!lllllllllllllIlIlIlllIlIIIllIIIl.hasKey("display", 10)) {
            lllllllllllllIlIlIlllIlIIIllIIIl.setTag("display", lllllllllllllIlIlIlllIlIIIllIIII);
        }
        lllllllllllllIlIlIlllIlIIIllIIII.setInteger("color", lllllllllllllIlIlIlllIlIIIlIllIl);
    }
    
    public static ItemStack dispenseArmor(final IBlockSource lllllllllllllIlIlIlllIlIIlllllIl, final ItemStack lllllllllllllIlIlIlllIlIIlllllII) {
        final BlockPos lllllllllllllIlIlIlllIlIIllllIll = lllllllllllllIlIlIlllIlIIlllllIl.getBlockPos().offset(lllllllllllllIlIlIlllIlIIlllllIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
        final List<EntityLivingBase> lllllllllllllIlIlIlllIlIIllllIlI = lllllllllllllIlIlIlllIlIIlllllIl.getWorld().getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, new AxisAlignedBB(lllllllllllllIlIlIlllIlIIllllIll), (com.google.common.base.Predicate<? super EntityLivingBase>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new EntitySelectors.ArmoredMob(lllllllllllllIlIlIlllIlIIlllllII)));
        if (lllllllllllllIlIlIlllIlIIllllIlI.isEmpty()) {
            return ItemStack.field_190927_a;
        }
        final EntityLivingBase lllllllllllllIlIlIlllIlIIllllIIl = lllllllllllllIlIlIlllIlIIllllIlI.get(0);
        final EntityEquipmentSlot lllllllllllllIlIlIlllIlIIllllIII = EntityLiving.getSlotForItemStack(lllllllllllllIlIlIlllIlIIlllllII);
        final ItemStack lllllllllllllIlIlIlllIlIIlllIlll = lllllllllllllIlIlIlllIlIIlllllII.splitStack(1);
        lllllllllllllIlIlIlllIlIIllllIIl.setItemStackToSlot(lllllllllllllIlIlIlllIlIIllllIII, lllllllllllllIlIlIlllIlIIlllIlll);
        if (lllllllllllllIlIlIlllIlIIllllIIl instanceof EntityLiving) {
            ((EntityLiving)lllllllllllllIlIlIlllIlIIllllIIl).setDropChance(lllllllllllllIlIlIlllIlIIllllIII, 2.0f);
        }
        return lllllllllllllIlIlIlllIlIIlllllII;
    }
    
    public ItemArmor(final ArmorMaterial lllllllllllllIlIlIlllIlIIllIIllI, final int lllllllllllllIlIlIlllIlIIllIIlIl, final EntityEquipmentSlot lllllllllllllIlIlIlllIlIIllIIlII) {
        this.material = lllllllllllllIlIlIlllIlIIllIIllI;
        this.armorType = lllllllllllllIlIlIlllIlIIllIIlII;
        this.renderIndex = lllllllllllllIlIlIlllIlIIllIIlIl;
        this.damageReduceAmount = lllllllllllllIlIlIlllIlIIllIIllI.getDamageReductionAmount(lllllllllllllIlIlIlllIlIIllIIlII);
        this.setMaxDamage(lllllllllllllIlIlIlllIlIIllIIllI.getDurability(lllllllllllllIlIlIlllIlIIllIIlII));
        this.toughness = lllllllllllllIlIlIlllIlIIllIIllI.getToughness();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.COMBAT);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
    }
    
    @Override
    public int getItemEnchantability() {
        return this.material.getEnchantability();
    }
    
    public enum ArmorMaterial
    {
        private final /* synthetic */ SoundEvent soundEvent;
        
        DIAMOND("DIAMOND", 4, "diamond", 33, new int[] { 3, 6, 8, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f);
        
        private final /* synthetic */ String name;
        private final /* synthetic */ int maxDamageFactor;
        
        IRON("IRON", 2, "iron", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);
        
        private final /* synthetic */ int enchantability;
        private final /* synthetic */ float toughness;
        
        GOLD("GOLD", 3, "gold", 7, new int[] { 1, 3, 5, 2 }, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f);
        
        private final /* synthetic */ int[] damageReductionAmountArray;
        
        CHAIN("CHAIN", 1, "chainmail", 15, new int[] { 1, 4, 5, 2 }, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f), 
        LEATHER("LEATHER", 0, "leather", 5, new int[] { 1, 2, 3, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);
        
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }
        
        public float getToughness() {
            return this.toughness;
        }
        
        public String getName() {
            return this.name;
        }
        
        private ArmorMaterial(final String llllllllllllllIIllIIlllIIlIllIlI, final int llllllllllllllIIllIIlllIIlIllIIl, final String llllllllllllllIIllIIlllIIlIllIII, final int llllllllllllllIIllIIlllIIllIIIII, final int[] llllllllllllllIIllIIlllIIlIlllll, final int llllllllllllllIIllIIlllIIlIllllI, final SoundEvent llllllllllllllIIllIIlllIIlIlIlII, final float llllllllllllllIIllIIlllIIlIlIIll) {
            this.name = llllllllllllllIIllIIlllIIlIllIII;
            this.maxDamageFactor = llllllllllllllIIllIIlllIIllIIIII;
            this.damageReductionAmountArray = llllllllllllllIIllIIlllIIlIlllll;
            this.enchantability = llllllllllllllIIllIIlllIIlIllllI;
            this.soundEvent = llllllllllllllIIllIIlllIIlIlIlII;
            this.toughness = llllllllllllllIIllIIlllIIlIlIIll;
        }
        
        public int getDamageReductionAmount(final EntityEquipmentSlot llllllllllllllIIllIIlllIIlIIlIIl) {
            return this.damageReductionAmountArray[llllllllllllllIIllIIlllIIlIIlIIl.getIndex()];
        }
        
        public int getEnchantability() {
            return this.enchantability;
        }
        
        public int getDurability(final EntityEquipmentSlot llllllllllllllIIllIIlllIIlIIllIl) {
            return ItemArmor.MAX_DAMAGE_ARRAY[llllllllllllllIIllIIlllIIlIIllIl.getIndex()] * this.maxDamageFactor;
        }
        
        public Item getRepairItem() {
            if (this == ArmorMaterial.LEATHER) {
                return Items.LEATHER;
            }
            if (this == ArmorMaterial.CHAIN) {
                return Items.IRON_INGOT;
            }
            if (this == ArmorMaterial.GOLD) {
                return Items.GOLD_INGOT;
            }
            if (this == ArmorMaterial.IRON) {
                return Items.IRON_INGOT;
            }
            return (this == ArmorMaterial.DIAMOND) ? Items.DIAMOND : null;
        }
    }
}
