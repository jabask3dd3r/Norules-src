package net.minecraft.enchantment;

import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import java.util.*;

public class EnchantmentHelper
{
    private static final /* synthetic */ HurtIterator ENCHANTMENT_ITERATOR_HURT;
    private static final /* synthetic */ ModifierLiving ENCHANTMENT_MODIFIER_LIVING;
    private static final /* synthetic */ ModifierDamage ENCHANTMENT_MODIFIER_DAMAGE;
    private static final /* synthetic */ DamageIterator ENCHANTMENT_ITERATOR_DAMAGE;
    
    public static void applyArthropodEnchantments(final EntityLivingBase lllllllllllllIllIllIIlIlIIlIIlIl, final Entity lllllllllllllIllIllIIlIlIIlIIlII) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.user = lllllllllllllIllIllIIlIlIIlIIlIl;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.target = lllllllllllllIllIllIIlIlIIlIIlII;
        if (lllllllllllllIllIllIIlIlIIlIIlIl != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE, lllllllllllllIllIllIIlIlIIlIIlIl.getEquipmentAndArmor());
        }
        if (lllllllllllllIllIllIIlIlIIlIIlIl instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE, lllllllllllllIllIllIIlIlIIlIIlIl.getHeldItemMainhand());
        }
    }
    
    public static List<EnchantmentData> buildEnchantmentList(final Random lllllllllllllIllIllIIlIIlIlIIIll, final ItemStack lllllllllllllIllIllIIlIIlIlIIIlI, int lllllllllllllIllIllIIlIIlIIllIII, final boolean lllllllllllllIllIllIIlIIlIIlIlll) {
        final List<EnchantmentData> lllllllllllllIllIllIIlIIlIIlllll = (List<EnchantmentData>)Lists.newArrayList();
        final Item lllllllllllllIllIllIIlIIlIIllllI = lllllllllllllIllIllIIlIIlIlIIIlI.getItem();
        final int lllllllllllllIllIllIIlIIlIIlllIl = lllllllllllllIllIllIIlIIlIIllllI.getItemEnchantability();
        if (lllllllllllllIllIllIIlIIlIIlllIl <= 0) {
            return lllllllllllllIllIllIIlIIlIIlllll;
        }
        lllllllllllllIllIllIIlIIlIIllIII = lllllllllllllIllIllIIlIIlIIllIII + 1 + lllllllllllllIllIllIIlIIlIlIIIll.nextInt(lllllllllllllIllIllIIlIIlIIlllIl / 4 + 1) + lllllllllllllIllIllIIlIIlIlIIIll.nextInt(lllllllllllllIllIllIIlIIlIIlllIl / 4 + 1);
        final float lllllllllllllIllIllIIlIIlIIlllII = (lllllllllllllIllIllIIlIIlIlIIIll.nextFloat() + lllllllllllllIllIllIIlIIlIlIIIll.nextFloat() - 1.0f) * 0.15f;
        lllllllllllllIllIllIIlIIlIIllIII = MathHelper.clamp(Math.round(lllllllllllllIllIllIIlIIlIIllIII + lllllllllllllIllIllIIlIIlIIllIII * lllllllllllllIllIllIIlIIlIIlllII), 1, Integer.MAX_VALUE);
        final List<EnchantmentData> lllllllllllllIllIllIIlIIlIIllIll = getEnchantmentDatas(lllllllllllllIllIllIIlIIlIIllIII, lllllllllllllIllIllIIlIIlIlIIIlI, lllllllllllllIllIllIIlIIlIIlIlll);
        if (!lllllllllllllIllIllIIlIIlIIllIll.isEmpty()) {
            lllllllllllllIllIllIIlIIlIIlllll.add(WeightedRandom.getRandomItem(lllllllllllllIllIllIIlIIlIlIIIll, lllllllllllllIllIllIIlIIlIIllIll));
            while (lllllllllllllIllIllIIlIIlIlIIIll.nextInt(50) <= lllllllllllllIllIllIIlIIlIIllIII) {
                removeIncompatible(lllllllllllllIllIllIIlIIlIIllIll, Util.getLastElement(lllllllllllllIllIllIIlIIlIIlllll));
                if (lllllllllllllIllIllIIlIIlIIllIll.isEmpty()) {
                    break;
                }
                lllllllllllllIllIllIIlIIlIIlllll.add(WeightedRandom.getRandomItem(lllllllllllllIllIllIIlIIlIlIIIll, lllllllllllllIllIllIIlIIlIIllIll));
                lllllllllllllIllIllIIlIIlIIllIII /= 2;
            }
        }
        return lllllllllllllIllIllIIlIIlIIlllll;
    }
    
    public static void setEnchantments(final Map<Enchantment, Integer> lllllllllllllIllIllIIlIlIllIIlII, final ItemStack lllllllllllllIllIllIIlIlIllIIIll) {
        final NBTTagList lllllllllllllIllIllIIlIlIllIlIIl = new NBTTagList();
        for (final Map.Entry<Enchantment, Integer> lllllllllllllIllIllIIlIlIllIlIII : lllllllllllllIllIllIIlIlIllIIlII.entrySet()) {
            final Enchantment lllllllllllllIllIllIIlIlIllIIlll = lllllllllllllIllIllIIlIlIllIlIII.getKey();
            if (lllllllllllllIllIllIIlIlIllIIlll != null) {
                final int lllllllllllllIllIllIIlIlIllIIllI = lllllllllllllIllIllIIlIlIllIlIII.getValue();
                final NBTTagCompound lllllllllllllIllIllIIlIlIllIIlIl = new NBTTagCompound();
                lllllllllllllIllIllIIlIlIllIIlIl.setShort("id", (short)Enchantment.getEnchantmentID(lllllllllllllIllIllIIlIlIllIIlll));
                lllllllllllllIllIllIIlIlIllIIlIl.setShort("lvl", (short)lllllllllllllIllIllIIlIlIllIIllI);
                lllllllllllllIllIllIIlIlIllIlIIl.appendTag(lllllllllllllIllIllIIlIlIllIIlIl);
                if (lllllllllllllIllIllIIlIlIllIIIll.getItem() != Items.ENCHANTED_BOOK) {
                    continue;
                }
                ItemEnchantedBook.addEnchantment(lllllllllllllIllIllIIlIlIllIIIll, new EnchantmentData(lllllllllllllIllIllIIlIlIllIIlll, lllllllllllllIllIllIIlIlIllIIllI));
            }
        }
        if (lllllllllllllIllIllIIlIlIllIlIIl.hasNoTags()) {
            if (lllllllllllllIllIllIIlIlIllIIIll.hasTagCompound()) {
                lllllllllllllIllIllIIlIlIllIIIll.getTagCompound().removeTag("ench");
            }
        }
        else if (lllllllllllllIllIllIIlIlIllIIIll.getItem() != Items.ENCHANTED_BOOK) {
            lllllllllllllIllIllIIlIlIllIIIll.setTagInfo("ench", lllllllllllllIllIllIIlIlIllIlIIl);
        }
    }
    
    public static boolean getAquaAffinityModifier(final EntityLivingBase lllllllllllllIllIllIIlIIllllIlII) {
        return getMaxEnchantmentLevel(Enchantments.AQUA_AFFINITY, lllllllllllllIllIllIIlIIllllIlII) > 0;
    }
    
    private static void applyEnchantmentModifierArray(final IModifier lllllllllllllIllIllIIlIlIlIIIllI, final Iterable<ItemStack> lllllllllllllIllIllIIlIlIlIIIlIl) {
        for (final ItemStack lllllllllllllIllIllIIlIlIlIIIlII : lllllllllllllIllIllIIlIlIlIIIlIl) {
            applyEnchantmentModifier(lllllllllllllIllIllIIlIlIlIIIllI, lllllllllllllIllIllIIlIlIlIIIlII);
        }
    }
    
    public static int calcItemStackEnchantability(final Random lllllllllllllIllIllIIlIIllIlIIIl, final int lllllllllllllIllIllIIlIIllIIlIIl, int lllllllllllllIllIllIIlIIllIIlIII, final ItemStack lllllllllllllIllIllIIlIIllIIIlll) {
        final Item lllllllllllllIllIllIIlIIllIIllIl = lllllllllllllIllIllIIlIIllIIIlll.getItem();
        final int lllllllllllllIllIllIIlIIllIIllII = lllllllllllllIllIllIIlIIllIIllIl.getItemEnchantability();
        if (lllllllllllllIllIllIIlIIllIIllII <= 0) {
            return 0;
        }
        if (lllllllllllllIllIllIIlIIllIIlIII > 15) {
            lllllllllllllIllIllIIlIIllIIlIII = 15;
        }
        final int lllllllllllllIllIllIIlIIllIIlIll = lllllllllllllIllIllIIlIIllIlIIIl.nextInt(8) + 1 + (lllllllllllllIllIllIIlIIllIIlIII >> 1) + lllllllllllllIllIllIIlIIllIlIIIl.nextInt(lllllllllllllIllIllIIlIIllIIlIII + 1);
        if (lllllllllllllIllIllIIlIIllIIlIIl == 0) {
            return Math.max(lllllllllllllIllIllIIlIIllIIlIll / 3, 1);
        }
        return (lllllllllllllIllIllIIlIIllIIlIIl == 1) ? (lllllllllllllIllIllIIlIIllIIlIll * 2 / 3 + 1) : Math.max(lllllllllllllIllIllIIlIIllIIlIll, lllllllllllllIllIllIIlIIllIIlIII * 2);
    }
    
    public static int getEfficiencyModifier(final EntityLivingBase lllllllllllllIllIllIIlIIllllllll) {
        return getMaxEnchantmentLevel(Enchantments.EFFICIENCY, lllllllllllllIllIllIIlIIllllllll);
    }
    
    public static ItemStack getEnchantedItem(final Enchantment lllllllllllllIllIllIIlIIllIllllI, final EntityLivingBase lllllllllllllIllIllIIlIIllIlllIl) {
        final List<ItemStack> lllllllllllllIllIllIIlIIlllIIIIl = lllllllllllllIllIllIIlIIllIllllI.getEntityEquipment(lllllllllllllIllIllIIlIIllIlllIl);
        if (lllllllllllllIllIllIIlIIlllIIIIl.isEmpty()) {
            return ItemStack.field_190927_a;
        }
        final List<ItemStack> lllllllllllllIllIllIIlIIlllIIIII = (List<ItemStack>)Lists.newArrayList();
        for (final ItemStack lllllllllllllIllIllIIlIIllIlllll : lllllllllllllIllIllIIlIIlllIIIIl) {
            if (!lllllllllllllIllIllIIlIIllIlllll.func_190926_b() && getEnchantmentLevel(lllllllllllllIllIllIIlIIllIllllI, lllllllllllllIllIllIIlIIllIlllll) > 0) {
                lllllllllllllIllIllIIlIIlllIIIII.add(lllllllllllllIllIllIIlIIllIlllll);
            }
        }
        return lllllllllllllIllIllIIlIIlllIIIII.isEmpty() ? ItemStack.field_190927_a : lllllllllllllIllIllIIlIIlllIIIII.get(lllllllllllllIllIllIIlIIllIlllIl.getRNG().nextInt(lllllllllllllIllIllIIlIIlllIIIII.size()));
    }
    
    public static List<EnchantmentData> getEnchantmentDatas(final int lllllllllllllIllIllIIlIIIlllllll, final ItemStack lllllllllllllIllIllIIlIIIllllllI, final boolean lllllllllllllIllIllIIlIIIlllIlIl) {
        final List<EnchantmentData> lllllllllllllIllIllIIlIIIlllllII = (List<EnchantmentData>)Lists.newArrayList();
        final Item lllllllllllllIllIllIIlIIIllllIll = lllllllllllllIllIllIIlIIIllllllI.getItem();
        final boolean lllllllllllllIllIllIIlIIIllllIlI = lllllllllllllIllIllIIlIIIllllllI.getItem() == Items.BOOK;
        for (final Enchantment lllllllllllllIllIllIIlIIIllllIIl : Enchantment.REGISTRY) {
            if ((!lllllllllllllIllIllIIlIIIllllIIl.isTreasureEnchantment() || lllllllllllllIllIllIIlIIIlllIlIl) && (lllllllllllllIllIllIIlIIIllllIIl.type.canEnchantItem(lllllllllllllIllIllIIlIIIllllIll) || lllllllllllllIllIllIIlIIIllllIlI)) {
                for (int lllllllllllllIllIllIIlIIIllllIII = lllllllllllllIllIllIIlIIIllllIIl.getMaxLevel(); lllllllllllllIllIllIIlIIIllllIII > lllllllllllllIllIllIIlIIIllllIIl.getMinLevel() - 1; --lllllllllllllIllIllIIlIIIllllIII) {
                    if (lllllllllllllIllIllIIlIIIlllllll >= lllllllllllllIllIllIIlIIIllllIIl.getMinEnchantability(lllllllllllllIllIllIIlIIIllllIII) && lllllllllllllIllIllIIlIIIlllllll <= lllllllllllllIllIllIIlIIIllllIIl.getMaxEnchantability(lllllllllllllIllIllIIlIIIllllIII)) {
                        lllllllllllllIllIllIIlIIIlllllII.add(new EnchantmentData(lllllllllllllIllIllIIlIIIllllIIl, lllllllllllllIllIllIIlIIIllllIII));
                        break;
                    }
                }
            }
        }
        return lllllllllllllIllIllIIlIIIlllllII;
    }
    
    public static void applyThornEnchantments(final EntityLivingBase lllllllllllllIllIllIIlIlIIlIlIll, final Entity lllllllllllllIllIllIIlIlIIlIlIII) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.attacker = lllllllllllllIllIllIIlIlIIlIlIII;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.user = lllllllllllllIllIllIIlIlIIlIlIll;
        if (lllllllllllllIllIllIIlIlIIlIlIll != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT, lllllllllllllIllIllIIlIlIIlIlIll.getEquipmentAndArmor());
        }
        if (lllllllllllllIllIllIIlIlIIlIlIII instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT, lllllllllllllIllIllIIlIlIIlIlIll.getHeldItemMainhand());
        }
    }
    
    public static int func_191529_b(final ItemStack lllllllllllllIllIllIIlIIllllllII) {
        return getEnchantmentLevel(Enchantments.LUCK_OF_THE_SEA, lllllllllllllIllIllIIlIIllllllII);
    }
    
    public static ItemStack addRandomEnchantment(final Random lllllllllllllIllIllIIlIIlIlllIll, ItemStack lllllllllllllIllIllIIlIIlIllIIll, final int lllllllllllllIllIllIIlIIlIlllIIl, final boolean lllllllllllllIllIllIIlIIlIlllIII) {
        final List<EnchantmentData> lllllllllllllIllIllIIlIIlIllIlll = buildEnchantmentList(lllllllllllllIllIllIIlIIlIlllIll, lllllllllllllIllIllIIlIIlIllIIll, lllllllllllllIllIllIIlIIlIlllIIl, lllllllllllllIllIllIIlIIlIlllIII);
        final boolean lllllllllllllIllIllIIlIIlIllIllI = lllllllllllllIllIllIIlIIlIllIIll.getItem() == Items.BOOK;
        if (lllllllllllllIllIllIIlIIlIllIllI) {
            lllllllllllllIllIllIIlIIlIllIIll = new ItemStack(Items.ENCHANTED_BOOK);
        }
        for (final EnchantmentData lllllllllllllIllIllIIlIIlIllIlIl : lllllllllllllIllIllIIlIIlIllIlll) {
            if (lllllllllllllIllIllIIlIIlIllIllI) {
                ItemEnchantedBook.addEnchantment(lllllllllllllIllIllIIlIIlIllIIll, lllllllllllllIllIllIIlIIlIllIlIl);
            }
            else {
                lllllllllllllIllIllIIlIIlIllIIll.addEnchantment(lllllllllllllIllIllIIlIIlIllIlIl.enchantmentobj, lllllllllllllIllIllIIlIIlIllIlIl.enchantmentLevel);
            }
        }
        return lllllllllllllIllIllIIlIIlIllIIll;
    }
    
    public static int func_191528_c(final ItemStack lllllllllllllIllIllIIlIIlllllIlI) {
        return getEnchantmentLevel(Enchantments.LURE, lllllllllllllIllIllIIlIIlllllIlI);
    }
    
    public static int getEnchantmentModifierDamage(final Iterable<ItemStack> lllllllllllllIllIllIIlIlIIllllIl, final DamageSource lllllllllllllIllIllIIlIlIIllllII) {
        EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.damageModifier = 0;
        EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.source = lllllllllllllIllIllIIlIlIIllllII;
        applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE, lllllllllllllIllIllIIlIlIIllllIl);
        return EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.damageModifier;
    }
    
    public static Map<Enchantment, Integer> getEnchantments(final ItemStack lllllllllllllIllIllIIlIllIIIIIIl) {
        final Map<Enchantment, Integer> lllllllllllllIllIllIIlIllIIIIIII = (Map<Enchantment, Integer>)Maps.newLinkedHashMap();
        final NBTTagList lllllllllllllIllIllIIlIlIlllllll = (lllllllllllllIllIllIIlIllIIIIIIl.getItem() == Items.ENCHANTED_BOOK) ? ItemEnchantedBook.getEnchantments(lllllllllllllIllIllIIlIllIIIIIIl) : lllllllllllllIllIllIIlIllIIIIIIl.getEnchantmentTagList();
        for (int lllllllllllllIllIllIIlIlIllllllI = 0; lllllllllllllIllIllIIlIlIllllllI < lllllllllllllIllIllIIlIlIlllllll.tagCount(); ++lllllllllllllIllIllIIlIlIllllllI) {
            final NBTTagCompound lllllllllllllIllIllIIlIlIlllllIl = lllllllllllllIllIllIIlIlIlllllll.getCompoundTagAt(lllllllllllllIllIllIIlIlIllllllI);
            final Enchantment lllllllllllllIllIllIIlIlIlllllII = Enchantment.getEnchantmentByID(lllllllllllllIllIllIIlIlIlllllIl.getShort("id"));
            final int lllllllllllllIllIllIIlIlIllllIll = lllllllllllllIllIllIIlIlIlllllIl.getShort("lvl");
            lllllllllllllIllIllIIlIllIIIIIII.put(lllllllllllllIllIllIIlIlIlllllII, lllllllllllllIllIllIIlIlIllllIll);
        }
        return lllllllllllllIllIllIIlIllIIIIIII;
    }
    
    public static boolean func_190938_b(final ItemStack lllllllllllllIllIllIIlIIlllIlllI) {
        return getEnchantmentLevel(Enchantments.field_190941_k, lllllllllllllIllIllIIlIIlllIlllI) > 0;
    }
    
    static {
        ENCHANTMENT_MODIFIER_DAMAGE = new ModifierDamage(null);
        ENCHANTMENT_MODIFIER_LIVING = new ModifierLiving(null);
        ENCHANTMENT_ITERATOR_HURT = new HurtIterator(null);
        ENCHANTMENT_ITERATOR_DAMAGE = new DamageIterator(null);
    }
    
    public static int getLootingModifier(final EntityLivingBase lllllllllllllIllIllIIlIIllllIlll) {
        return getMaxEnchantmentLevel(Enchantments.LOOTING, lllllllllllllIllIllIIlIIllllIlll);
    }
    
    private static void applyEnchantmentModifier(final IModifier lllllllllllllIllIllIIlIlIlIlIIII, final ItemStack lllllllllllllIllIllIIlIlIlIlIlIl) {
        if (!lllllllllllllIllIllIIlIlIlIlIlIl.func_190926_b()) {
            final NBTTagList lllllllllllllIllIllIIlIlIlIlIlII = lllllllllllllIllIllIIlIlIlIlIlIl.getEnchantmentTagList();
            for (int lllllllllllllIllIllIIlIlIlIlIIll = 0; lllllllllllllIllIllIIlIlIlIlIIll < lllllllllllllIllIllIIlIlIlIlIlII.tagCount(); ++lllllllllllllIllIllIIlIlIlIlIIll) {
                final int lllllllllllllIllIllIIlIlIlIlIIlI = lllllllllllllIllIllIIlIlIlIlIlII.getCompoundTagAt(lllllllllllllIllIllIIlIlIlIlIIll).getShort("id");
                final int lllllllllllllIllIllIIlIlIlIlIIIl = lllllllllllllIllIllIIlIlIlIlIlII.getCompoundTagAt(lllllllllllllIllIllIIlIlIlIlIIll).getShort("lvl");
                if (Enchantment.getEnchantmentByID(lllllllllllllIllIllIIlIlIlIlIIlI) != null) {
                    lllllllllllllIllIllIIlIlIlIlIIII.calculateModifier(Enchantment.getEnchantmentByID(lllllllllllllIllIllIIlIlIlIlIIlI), lllllllllllllIllIllIIlIlIlIlIIIl);
                }
            }
        }
    }
    
    public static int getDepthStriderModifier(final EntityLivingBase lllllllllllllIllIllIIlIlIIIIIIll) {
        return getMaxEnchantmentLevel(Enchantments.DEPTH_STRIDER, lllllllllllllIllIllIIlIlIIIIIIll);
    }
    
    public static float getModifierForCreature(final ItemStack lllllllllllllIllIllIIlIlIIllIlll, final EnumCreatureAttribute lllllllllllllIllIllIIlIlIIllIllI) {
        EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.livingModifier = 0.0f;
        EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.entityLiving = lllllllllllllIllIllIIlIlIIllIllI;
        applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING, lllllllllllllIllIllIIlIlIIllIlll);
        return EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.livingModifier;
    }
    
    public static int getMaxEnchantmentLevel(final Enchantment lllllllllllllIllIllIIlIlIIIllIlI, final EntityLivingBase lllllllllllllIllIllIIlIlIIIlIIll) {
        final Iterable<ItemStack> lllllllllllllIllIllIIlIlIIIllIII = lllllllllllllIllIllIIlIlIIIllIlI.getEntityEquipment(lllllllllllllIllIllIIlIlIIIlIIll);
        if (lllllllllllllIllIllIIlIlIIIllIII == null) {
            return 0;
        }
        int lllllllllllllIllIllIIlIlIIIlIlll = 0;
        for (final ItemStack lllllllllllllIllIllIIlIlIIIlIllI : lllllllllllllIllIllIIlIlIIIllIII) {
            final int lllllllllllllIllIllIIlIlIIIlIlIl = getEnchantmentLevel(lllllllllllllIllIllIIlIlIIIllIlI, lllllllllllllIllIllIIlIlIIIlIllI);
            if (lllllllllllllIllIllIIlIlIIIlIlIl > lllllllllllllIllIllIIlIlIIIlIlll) {
                lllllllllllllIllIllIIlIlIIIlIlll = lllllllllllllIllIllIIlIlIIIlIlIl;
            }
        }
        return lllllllllllllIllIllIIlIlIIIlIlll;
    }
    
    public static int getRespirationModifier(final EntityLivingBase lllllllllllllIllIllIIlIlIIIIIlIl) {
        return getMaxEnchantmentLevel(Enchantments.RESPIRATION, lllllllllllllIllIllIIlIlIIIIIlIl);
    }
    
    public static int getKnockbackModifier(final EntityLivingBase lllllllllllllIllIllIIlIlIIIIlIll) {
        return getMaxEnchantmentLevel(Enchantments.KNOCKBACK, lllllllllllllIllIllIIlIlIIIIlIll);
    }
    
    public static int getFireAspectModifier(final EntityLivingBase lllllllllllllIllIllIIlIlIIIIlIIl) {
        return getMaxEnchantmentLevel(Enchantments.FIRE_ASPECT, lllllllllllllIllIllIIlIlIIIIlIIl);
    }
    
    public static void removeIncompatible(final List<EnchantmentData> lllllllllllllIllIllIIlIIlIIIlllI, final EnchantmentData lllllllllllllIllIllIIlIIlIIIlIlI) {
        final Iterator<EnchantmentData> lllllllllllllIllIllIIlIIlIIIllII = lllllllllllllIllIllIIlIIlIIIlllI.iterator();
        while (lllllllllllllIllIllIIlIIlIIIllII.hasNext()) {
            if (!lllllllllllllIllIllIIlIIlIIIlIlI.enchantmentobj.func_191560_c(lllllllllllllIllIllIIlIIlIIIllII.next().enchantmentobj)) {
                lllllllllllllIllIllIIlIIlIIIllII.remove();
            }
        }
    }
    
    public static boolean hasFrostWalkerEnchantment(final EntityLivingBase lllllllllllllIllIllIIlIIllllIIII) {
        return getMaxEnchantmentLevel(Enchantments.FROST_WALKER, lllllllllllllIllIllIIlIIllllIIII) > 0;
    }
    
    public static boolean func_190939_c(final ItemStack lllllllllllllIllIllIIlIIlllIlIlI) {
        return getEnchantmentLevel(Enchantments.field_190940_C, lllllllllllllIllIllIIlIIlllIlIlI) > 0;
    }
    
    public static int getEnchantmentLevel(final Enchantment lllllllllllllIllIllIIlIllIIlIllI, final ItemStack lllllllllllllIllIllIIlIllIIlIlIl) {
        if (lllllllllllllIllIllIIlIllIIlIlIl.func_190926_b()) {
            return 0;
        }
        final NBTTagList lllllllllllllIllIllIIlIllIIlIlII = lllllllllllllIllIllIIlIllIIlIlIl.getEnchantmentTagList();
        for (int lllllllllllllIllIllIIlIllIIlIIll = 0; lllllllllllllIllIllIIlIllIIlIIll < lllllllllllllIllIllIIlIllIIlIlII.tagCount(); ++lllllllllllllIllIllIIlIllIIlIIll) {
            final NBTTagCompound lllllllllllllIllIllIIlIllIIlIIlI = lllllllllllllIllIllIIlIllIIlIlII.getCompoundTagAt(lllllllllllllIllIllIIlIllIIlIIll);
            final Enchantment lllllllllllllIllIllIIlIllIIlIIIl = Enchantment.getEnchantmentByID(lllllllllllllIllIllIIlIllIIlIIlI.getShort("id"));
            final int lllllllllllllIllIllIIlIllIIlIIII = lllllllllllllIllIllIIlIllIIlIIlI.getShort("lvl");
            if (lllllllllllllIllIllIIlIllIIlIIIl == lllllllllllllIllIllIIlIllIIlIllI) {
                return lllllllllllllIllIllIIlIllIIlIIII;
            }
        }
        return 0;
    }
    
    public static float func_191527_a(final EntityLivingBase lllllllllllllIllIllIIlIlIIllIIIl) {
        final int lllllllllllllIllIllIIlIlIIllIIII = getMaxEnchantmentLevel(Enchantments.field_191530_r, lllllllllllllIllIllIIlIlIIllIIIl);
        return (lllllllllllllIllIllIIlIlIIllIIII > 0) ? EnchantmentSweepingEdge.func_191526_e(lllllllllllllIllIllIIlIlIIllIIII) : 0.0f;
    }
    
    static final class ModifierDamage implements IModifier
    {
        public /* synthetic */ DamageSource source;
        public /* synthetic */ int damageModifier;
        
        @Override
        public void calculateModifier(final Enchantment lIIllIlllIIlIlI, final int lIIllIlllIIlIIl) {
            this.damageModifier += lIIllIlllIIlIlI.calcModifierDamage(lIIllIlllIIlIIl, this.source);
        }
        
        private ModifierDamage() {
        }
    }
    
    interface IModifier
    {
        void calculateModifier(final Enchantment p0, final int p1);
    }
    
    static final class DamageIterator implements IModifier
    {
        public /* synthetic */ Entity target;
        public /* synthetic */ EntityLivingBase user;
        
        private DamageIterator() {
        }
        
        @Override
        public void calculateModifier(final Enchantment lllllllllllllIIlllllIIlIIIIlIlII, final int lllllllllllllIIlllllIIlIIIIlIIII) {
            lllllllllllllIIlllllIIlIIIIlIlII.onEntityDamaged(this.user, this.target, lllllllllllllIIlllllIIlIIIIlIIII);
        }
    }
    
    static final class HurtIterator implements IModifier
    {
        public /* synthetic */ Entity attacker;
        public /* synthetic */ EntityLivingBase user;
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllllIIIllIIIlIlllllIll, final int llllllllllllllIIIllIIIlIllllIlll) {
            llllllllllllllIIIllIIIlIlllllIll.onUserHurt(this.user, this.attacker, llllllllllllllIIIllIIIlIllllIlll);
        }
        
        private HurtIterator() {
        }
    }
    
    static final class ModifierLiving implements IModifier
    {
        public /* synthetic */ float livingModifier;
        public /* synthetic */ EnumCreatureAttribute entityLiving;
        
        private ModifierLiving() {
        }
        
        @Override
        public void calculateModifier(final Enchantment lllllllllllllllIlllllIIIlllIIIlI, final int lllllllllllllllIlllllIIIlllIIlII) {
            this.livingModifier += lllllllllllllllIlllllIIIlllIIIlI.calcDamageByCreature(lllllllllllllllIlllllIIIlllIIlII, this.entityLiving);
        }
    }
}
