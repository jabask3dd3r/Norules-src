package net.minecraft.enchantment;

import net.minecraft.inventory.*;
import net.minecraft.util.registry.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.text.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class Enchantment
{
    private final /* synthetic */ EntityEquipmentSlot[] applicableEquipmentTypes;
    protected /* synthetic */ String name;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Enchantment> REGISTRY;
    @Nullable
    public /* synthetic */ EnumEnchantmentType type;
    private final /* synthetic */ Rarity rarity;
    
    public int getMinLevel() {
        return 1;
    }
    
    public int calcModifierDamage(final int lIllIllllIII, final DamageSource lIllIlllIlll) {
        return 0;
    }
    
    public final boolean func_191560_c(final Enchantment lIllIlllIIII) {
        return this.canApplyTogether(lIllIlllIIII) && lIllIlllIIII.canApplyTogether(this);
    }
    
    public int getMinEnchantability(final int lIlllIIIIIIl) {
        return 1 + lIlllIIIIIIl * 10;
    }
    
    public int getMaxLevel() {
        return 1;
    }
    
    public static int getEnchantmentID(final Enchantment lIlllIlIlllI) {
        return Enchantment.REGISTRY.getIDForObject(lIlllIlIlllI);
    }
    
    @Nullable
    public static Enchantment getEnchantmentByID(final int lIlllIllIIII) {
        return Enchantment.REGISTRY.getObjectById(lIlllIllIIII);
    }
    
    public void onUserHurt(final EntityLivingBase lIllIlIIlIlI, final Entity lIllIlIIlIIl, final int lIllIlIIlIII) {
    }
    
    public Enchantment setName(final String lIllIllIIlII) {
        this.name = lIllIllIIlII;
        return this;
    }
    
    public float calcDamageByCreature(final int lIllIlllIlIl, final EnumCreatureAttribute lIllIlllIlII) {
        return 0.0f;
    }
    
    public boolean canApply(final ItemStack lIllIlIlIIlI) {
        return this.type.canEnchantItem(lIllIlIlIIlI.getItem());
    }
    
    public String getTranslatedName(final int lIllIlIllIlI) {
        String lIllIlIllIIl = I18n.translateToLocal(this.getName());
        if (this.func_190936_d()) {
            lIllIlIllIIl = String.valueOf(new StringBuilder().append(TextFormatting.RED).append(lIllIlIllIIl));
        }
        return (lIllIlIllIlI == 1 && this.getMaxLevel() == 1) ? lIllIlIllIIl : String.valueOf(new StringBuilder(String.valueOf(lIllIlIllIIl)).append(" ").append(I18n.translateToLocal(String.valueOf(new StringBuilder("enchantment.level.").append(lIllIlIllIlI)))));
    }
    
    public Rarity getRarity() {
        return this.rarity;
    }
    
    protected boolean canApplyTogether(final Enchantment lIllIllIlIlI) {
        return this != lIllIllIlIlI;
    }
    
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.").append(this.name));
    }
    
    public boolean isTreasureEnchantment() {
        return false;
    }
    
    public boolean func_190936_d() {
        return false;
    }
    
    protected Enchantment(final Rarity lIlllIlIIIII, final EnumEnchantmentType lIlllIlIIIll, final EntityEquipmentSlot[] lIlllIlIIIlI) {
        this.rarity = lIlllIlIIIII;
        this.type = lIlllIlIIIll;
        this.applicableEquipmentTypes = lIlllIlIIIlI;
    }
    
    public void onEntityDamaged(final EntityLivingBase lIllIlIIlllI, final Entity lIllIlIIllIl, final int lIllIlIIllII) {
    }
    
    static {
        REGISTRY = new RegistryNamespaced<ResourceLocation, Enchantment>();
    }
    
    public static void registerEnchantments() {
        final EntityEquipmentSlot[] lIllIlIIIlII = { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };
        Enchantment.REGISTRY.register(0, new ResourceLocation("protection"), new EnchantmentProtection(Rarity.COMMON, EnchantmentProtection.Type.ALL, lIllIlIIIlII));
        Enchantment.REGISTRY.register(1, new ResourceLocation("fire_protection"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.FIRE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(2, new ResourceLocation("feather_falling"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.FALL, lIllIlIIIlII));
        Enchantment.REGISTRY.register(3, new ResourceLocation("blast_protection"), new EnchantmentProtection(Rarity.RARE, EnchantmentProtection.Type.EXPLOSION, lIllIlIIIlII));
        Enchantment.REGISTRY.register(4, new ResourceLocation("projectile_protection"), new EnchantmentProtection(Rarity.UNCOMMON, EnchantmentProtection.Type.PROJECTILE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(5, new ResourceLocation("respiration"), new EnchantmentOxygen(Rarity.RARE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(6, new ResourceLocation("aqua_affinity"), new EnchantmentWaterWorker(Rarity.RARE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(7, new ResourceLocation("thorns"), new EnchantmentThorns(Rarity.VERY_RARE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(8, new ResourceLocation("depth_strider"), new EnchantmentWaterWalker(Rarity.RARE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(9, new ResourceLocation("frost_walker"), new EnchantmentFrostWalker(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.FEET }));
        Enchantment.REGISTRY.register(10, new ResourceLocation("binding_curse"), new EnchantmentBindingCurse(Rarity.VERY_RARE, lIllIlIIIlII));
        Enchantment.REGISTRY.register(16, new ResourceLocation("sharpness"), new EnchantmentDamage(Rarity.COMMON, 0, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(17, new ResourceLocation("smite"), new EnchantmentDamage(Rarity.UNCOMMON, 1, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(18, new ResourceLocation("bane_of_arthropods"), new EnchantmentDamage(Rarity.UNCOMMON, 2, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(19, new ResourceLocation("knockback"), new EnchantmentKnockback(Rarity.UNCOMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(20, new ResourceLocation("fire_aspect"), new EnchantmentFireAspect(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(21, new ResourceLocation("looting"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(22, new ResourceLocation("sweeping"), new EnchantmentSweepingEdge(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(32, new ResourceLocation("efficiency"), new EnchantmentDigging(Rarity.COMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(33, new ResourceLocation("silk_touch"), new EnchantmentUntouching(Rarity.VERY_RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(34, new ResourceLocation("unbreaking"), new EnchantmentDurability(Rarity.UNCOMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(35, new ResourceLocation("fortune"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(48, new ResourceLocation("power"), new EnchantmentArrowDamage(Rarity.COMMON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(49, new ResourceLocation("punch"), new EnchantmentArrowKnockback(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(50, new ResourceLocation("flame"), new EnchantmentArrowFire(Rarity.RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(51, new ResourceLocation("infinity"), new EnchantmentArrowInfinite(Rarity.VERY_RARE, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(61, new ResourceLocation("luck_of_the_sea"), new EnchantmentLootBonus(Rarity.RARE, EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(62, new ResourceLocation("lure"), new EnchantmentFishingSpeed(Rarity.RARE, EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND }));
        Enchantment.REGISTRY.register(70, new ResourceLocation("mending"), new EnchantmentMending(Rarity.RARE, EntityEquipmentSlot.values()));
        Enchantment.REGISTRY.register(71, new ResourceLocation("vanishing_curse"), new EnchantmentVanishingCurse(Rarity.VERY_RARE, EntityEquipmentSlot.values()));
    }
    
    public List<ItemStack> getEntityEquipment(final EntityLivingBase lIlllIIlIlII) {
        final List<ItemStack> lIlllIIlIIll = (List<ItemStack>)Lists.newArrayList();
        final int lIlllIIIlIlI;
        final double lIlllIIIlIll = ((EntityEquipmentSlot[])(Object)(lIlllIIIlIlI = (int)(Object)this.applicableEquipmentTypes)).length;
        for (long lIlllIIIllII = 0; lIlllIIIllII < lIlllIIIlIll; ++lIlllIIIllII) {
            final EntityEquipmentSlot lIlllIIlIIlI = lIlllIIIlIlI[lIlllIIIllII];
            final ItemStack lIlllIIlIIIl = lIlllIIlIlII.getItemStackFromSlot(lIlllIIlIIlI);
            if (!lIlllIIlIIIl.func_190926_b()) {
                lIlllIIlIIll.add(lIlllIIlIIIl);
            }
        }
        return lIlllIIlIIll;
    }
    
    public int getMaxEnchantability(final int lIllIllllIlI) {
        return this.getMinEnchantability(lIllIllllIlI) + 5;
    }
    
    @Nullable
    public static Enchantment getEnchantmentByLocation(final String lIlllIlIlIll) {
        return Enchantment.REGISTRY.getObject(new ResourceLocation(lIlllIlIlIll));
    }
    
    public enum Rarity
    {
        COMMON("COMMON", 0, 10), 
        RARE("RARE", 2, 2);
        
        private final /* synthetic */ int weight;
        
        UNCOMMON("UNCOMMON", 1, 5), 
        VERY_RARE("VERY_RARE", 3, 1);
        
        private Rarity(final String llllllllllllllIlIlIllIlllIIlllll, final int llllllllllllllIlIlIllIlllIIllllI, final int llllllllllllllIlIlIllIlllIlIIIIl) {
            this.weight = llllllllllllllIlIlIllIlllIlIIIIl;
        }
        
        public int getWeight() {
            return this.weight;
        }
    }
}
