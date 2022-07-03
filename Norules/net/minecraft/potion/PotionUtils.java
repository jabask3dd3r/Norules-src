package net.minecraft.potion;

import net.minecraft.init.*;
import net.minecraft.item.*;
import javax.annotation.*;
import com.google.common.base.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.text.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;
import optifine.*;

public class PotionUtils
{
    public static int getPotionColor(final PotionType lllllllllllllIIlIlIlIIIIlIlIIlll) {
        return (lllllllllllllIIlIlIlIIIIlIlIIlll == PotionTypes.EMPTY) ? 16253176 : getPotionColorFromEffectList(lllllllllllllIIlIlIlIIIIlIlIIlll.getEffects());
    }
    
    public static int func_190932_c(final ItemStack lllllllllllllIIlIlIlIIIIlIlIllIl) {
        final NBTTagCompound lllllllllllllIIlIlIlIIIIlIlIllII = lllllllllllllIIlIlIlIIIIlIlIllIl.getTagCompound();
        if (lllllllllllllIIlIlIlIIIIlIlIllII != null && lllllllllllllIIlIlIlIIIIlIlIllII.hasKey("CustomPotionColor", 99)) {
            return lllllllllllllIIlIlIlIIIIlIlIllII.getInteger("CustomPotionColor");
        }
        return (getPotionFromItem(lllllllllllllIIlIlIlIIIIlIlIllIl) == PotionTypes.EMPTY) ? 16253176 : getPotionColorFromEffectList(getEffectsFromStack(lllllllllllllIIlIlIlIIIIlIlIllIl));
    }
    
    public static List<PotionEffect> getEffectsFromStack(final ItemStack lllllllllllllIIlIlIlIIIIllIllIlI) {
        return getEffectsFromTag(lllllllllllllIIlIlIlIIIIllIllIlI.getTagCompound());
    }
    
    public static PotionType getPotionTypeFromNBT(@Nullable final NBTTagCompound lllllllllllllIIlIlIlIIIIlIIIIlII) {
        return (lllllllllllllIIlIlIlIIIIlIIIIlII == null) ? PotionTypes.EMPTY : PotionType.getPotionTypeForName(lllllllllllllIIlIlIlIIIIlIIIIlII.getString("Potion"));
    }
    
    public static ItemStack appendEffects(final ItemStack lllllllllllllIIlIlIlIIIIIllIlIll, final Collection<PotionEffect> lllllllllllllIIlIlIlIIIIIllIllll) {
        if (lllllllllllllIIlIlIlIIIIIllIllll.isEmpty()) {
            return lllllllllllllIIlIlIlIIIIIllIlIll;
        }
        final NBTTagCompound lllllllllllllIIlIlIlIIIIIllIlllI = (NBTTagCompound)MoreObjects.firstNonNull((Object)lllllllllllllIIlIlIlIIIIIllIlIll.getTagCompound(), (Object)new NBTTagCompound());
        final NBTTagList lllllllllllllIIlIlIlIIIIIllIllIl = lllllllllllllIIlIlIlIIIIIllIlllI.getTagList("CustomPotionEffects", 9);
        for (final PotionEffect lllllllllllllIIlIlIlIIIIIllIllII : lllllllllllllIIlIlIlIIIIIllIllll) {
            lllllllllllllIIlIlIlIIIIIllIllIl.appendTag(lllllllllllllIIlIlIlIIIIIllIllII.writeCustomPotionEffectToNBT(new NBTTagCompound()));
        }
        lllllllllllllIIlIlIlIIIIIllIlllI.setTag("CustomPotionEffects", lllllllllllllIIlIlIlIIIIIllIllIl);
        lllllllllllllIIlIlIlIIIIIllIlIll.setTagCompound(lllllllllllllIIlIlIlIIIIIllIlllI);
        return lllllllllllllIIlIlIlIIIIIllIlIll;
    }
    
    public static List<PotionEffect> getFullEffectsFromItem(final ItemStack lllllllllllllIIlIlIlIIIIllIIlIII) {
        return getFullEffectsFromTag(lllllllllllllIIlIlIlIIIIllIIlIII.getTagCompound());
    }
    
    public static ItemStack addPotionToItemStack(final ItemStack lllllllllllllIIlIlIlIIIIIllllIlI, final PotionType lllllllllllllIIlIlIlIIIIIllllllI) {
        final ResourceLocation lllllllllllllIIlIlIlIIIIIlllllIl = PotionType.REGISTRY.getNameForObject(lllllllllllllIIlIlIlIIIIIllllllI);
        if (lllllllllllllIIlIlIlIIIIIllllllI == PotionTypes.EMPTY) {
            if (lllllllllllllIIlIlIlIIIIIllllIlI.hasTagCompound()) {
                final NBTTagCompound lllllllllllllIIlIlIlIIIIIlllllII = lllllllllllllIIlIlIlIIIIIllllIlI.getTagCompound();
                lllllllllllllIIlIlIlIIIIIlllllII.removeTag("Potion");
                if (lllllllllllllIIlIlIlIIIIIlllllII.hasNoTags()) {
                    lllllllllllllIIlIlIlIIIIIllllIlI.setTagCompound(null);
                }
            }
        }
        else {
            final NBTTagCompound lllllllllllllIIlIlIlIIIIIllllIll = lllllllllllllIIlIlIlIIIIIllllIlI.hasTagCompound() ? lllllllllllllIIlIlIlIIIIIllllIlI.getTagCompound() : new NBTTagCompound();
            lllllllllllllIIlIlIlIIIIIllllIll.setString("Potion", lllllllllllllIIlIlIlIIIIIlllllIl.toString());
            lllllllllllllIIlIlIlIIIIIllllIlI.setTagCompound(lllllllllllllIIlIlIlIIIIIllllIll);
        }
        return lllllllllllllIIlIlIlIIIIIllllIlI;
    }
    
    public static List<PotionEffect> getFullEffectsFromTag(@Nullable final NBTTagCompound lllllllllllllIIlIlIlIIIIllIIIIll) {
        final List<PotionEffect> lllllllllllllIIlIlIlIIIIllIIIlII = (List<PotionEffect>)Lists.newArrayList();
        addCustomPotionEffectToList(lllllllllllllIIlIlIlIIIIllIIIIll, lllllllllllllIIlIlIlIIIIllIIIlII);
        return lllllllllllllIIlIlIlIIIIllIIIlII;
    }
    
    public static List<PotionEffect> mergeEffects(final PotionType lllllllllllllIIlIlIlIIIIllIlIllI, final Collection<PotionEffect> lllllllllllllIIlIlIlIIIIllIlIIlI) {
        final List<PotionEffect> lllllllllllllIIlIlIlIIIIllIlIlII = (List<PotionEffect>)Lists.newArrayList();
        lllllllllllllIIlIlIlIIIIllIlIlII.addAll(lllllllllllllIIlIlIlIIIIllIlIllI.getEffects());
        lllllllllllllIIlIlIlIIIIllIlIlII.addAll(lllllllllllllIIlIlIlIIIIllIlIIlI);
        return lllllllllllllIIlIlIlIIIIllIlIlII;
    }
    
    public static List<PotionEffect> getEffectsFromTag(@Nullable final NBTTagCompound lllllllllllllIIlIlIlIIIIllIIllII) {
        final List<PotionEffect> lllllllllllllIIlIlIlIIIIllIIllIl = (List<PotionEffect>)Lists.newArrayList();
        lllllllllllllIIlIlIlIIIIllIIllIl.addAll(getPotionTypeFromNBT(lllllllllllllIIlIlIlIIIIllIIllII).getEffects());
        addCustomPotionEffectToList(lllllllllllllIIlIlIlIIIIllIIllII, lllllllllllllIIlIlIlIIIIllIIllIl);
        return lllllllllllllIIlIlIlIIIIllIIllIl;
    }
    
    public static void addCustomPotionEffectToList(@Nullable final NBTTagCompound lllllllllllllIIlIlIlIIIIlIlllIll, final List<PotionEffect> lllllllllllllIIlIlIlIIIIlIlllIlI) {
        if (lllllllllllllIIlIlIlIIIIlIlllIll != null && lllllllllllllIIlIlIlIIIIlIlllIll.hasKey("CustomPotionEffects", 9)) {
            final NBTTagList lllllllllllllIIlIlIlIIIIlIlllIIl = lllllllllllllIIlIlIlIIIIlIlllIll.getTagList("CustomPotionEffects", 10);
            for (int lllllllllllllIIlIlIlIIIIlIlllIII = 0; lllllllllllllIIlIlIlIIIIlIlllIII < lllllllllllllIIlIlIlIIIIlIlllIIl.tagCount(); ++lllllllllllllIIlIlIlIIIIlIlllIII) {
                final NBTTagCompound lllllllllllllIIlIlIlIIIIlIllIlll = lllllllllllllIIlIlIlIIIIlIlllIIl.getCompoundTagAt(lllllllllllllIIlIlIlIIIIlIlllIII);
                final PotionEffect lllllllllllllIIlIlIlIIIIlIllIllI = PotionEffect.readCustomPotionEffectFromNBT(lllllllllllllIIlIlIlIIIIlIllIlll);
                if (lllllllllllllIIlIlIlIIIIlIllIllI != null) {
                    lllllllllllllIIlIlIlIIIIlIlllIlI.add(lllllllllllllIIlIlIlIIIIlIllIllI);
                }
            }
        }
    }
    
    public static void addPotionTooltip(final ItemStack lllllllllllllIIlIlIlIIIIIlIlIlll, final List<String> lllllllllllllIIlIlIlIIIIIlIlIllI, final float lllllllllllllIIlIlIlIIIIIlIIIIll) {
        final List<PotionEffect> lllllllllllllIIlIlIlIIIIIlIlIlII = getEffectsFromStack(lllllllllllllIIlIlIlIIIIIlIlIlll);
        final List<Tuple<String, AttributeModifier>> lllllllllllllIIlIlIlIIIIIlIlIIll = (List<Tuple<String, AttributeModifier>>)Lists.newArrayList();
        if (lllllllllllllIIlIlIlIIIIIlIlIlII.isEmpty()) {
            final String lllllllllllllIIlIlIlIIIIIlIlIIlI = I18n.translateToLocal("effect.none").trim();
            lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(lllllllllllllIIlIlIlIIIIIlIlIIlI)));
        }
        else {
            for (final PotionEffect lllllllllllllIIlIlIlIIIIIlIlIIIl : lllllllllllllIIlIlIlIIIIIlIlIlII) {
                String lllllllllllllIIlIlIlIIIIIlIlIIII = I18n.translateToLocal(lllllllllllllIIlIlIlIIIIIlIlIIIl.getEffectName()).trim();
                final Potion lllllllllllllIIlIlIlIIIIIlIIllll = lllllllllllllIIlIlIlIIIIIlIlIIIl.getPotion();
                final Map<IAttribute, AttributeModifier> lllllllllllllIIlIlIlIIIIIlIIlllI = lllllllllllllIIlIlIlIIIIIlIIllll.getAttributeModifierMap();
                if (!lllllllllllllIIlIlIlIIIIIlIIlllI.isEmpty()) {
                    for (final Map.Entry<IAttribute, AttributeModifier> lllllllllllllIIlIlIlIIIIIlIIllIl : lllllllllllllIIlIlIlIIIIIlIIlllI.entrySet()) {
                        final AttributeModifier lllllllllllllIIlIlIlIIIIIlIIllII = lllllllllllllIIlIlIlIIIIIlIIllIl.getValue();
                        final AttributeModifier lllllllllllllIIlIlIlIIIIIlIIlIll = new AttributeModifier(lllllllllllllIIlIlIlIIIIIlIIllII.getName(), lllllllllllllIIlIlIlIIIIIlIIllll.getAttributeModifierAmount(lllllllllllllIIlIlIlIIIIIlIlIIIl.getAmplifier(), lllllllllllllIIlIlIlIIIIIlIIllII), lllllllllllllIIlIlIlIIIIIlIIllII.getOperation());
                        lllllllllllllIIlIlIlIIIIIlIlIIll.add(new Tuple<String, AttributeModifier>(lllllllllllllIIlIlIlIIIIIlIIllIl.getKey().getAttributeUnlocalizedName(), lllllllllllllIIlIlIlIIIIIlIIlIll));
                    }
                }
                if (lllllllllllllIIlIlIlIIIIIlIlIIIl.getAmplifier() > 0) {
                    lllllllllllllIIlIlIlIIIIIlIlIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIlIlIIIIIlIlIIII)).append(" ").append(I18n.translateToLocal(String.valueOf(new StringBuilder("potion.potency.").append(lllllllllllllIIlIlIlIIIIIlIlIIIl.getAmplifier()))).trim()));
                }
                if (lllllllllllllIIlIlIlIIIIIlIlIIIl.getDuration() > 20) {
                    lllllllllllllIIlIlIlIIIIIlIlIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIlIlIIIIIlIlIIII)).append(" (").append(Potion.getPotionDurationString(lllllllllllllIIlIlIlIIIIIlIlIIIl, lllllllllllllIIlIlIlIIIIIlIIIIll)).append(")"));
                }
                if (lllllllllllllIIlIlIlIIIIIlIIllll.isBadEffect()) {
                    lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.RED).append(lllllllllllllIIlIlIlIIIIIlIlIIII)));
                }
                else {
                    lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.BLUE).append(lllllllllllllIIlIlIlIIIIIlIlIIII)));
                }
            }
        }
        if (!lllllllllllllIIlIlIlIIIIIlIlIIll.isEmpty()) {
            lllllllllllllIIlIlIlIIIIIlIlIllI.add("");
            lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.DARK_PURPLE).append(I18n.translateToLocal("potion.whenDrank"))));
            for (final Tuple<String, AttributeModifier> lllllllllllllIIlIlIlIIIIIlIIlIlI : lllllllllllllIIlIlIlIIIIIlIlIIll) {
                final AttributeModifier lllllllllllllIIlIlIlIIIIIlIIlIIl = lllllllllllllIIlIlIlIIIIIlIIlIlI.getSecond();
                final double lllllllllllllIIlIlIlIIIIIlIIlIII = lllllllllllllIIlIlIlIIIIIlIIlIIl.getAmount();
                double lllllllllllllIIlIlIlIIIIIlIIIllI = 0.0;
                if (lllllllllllllIIlIlIlIIIIIlIIlIIl.getOperation() != 1 && lllllllllllllIIlIlIlIIIIIlIIlIIl.getOperation() != 2) {
                    final double lllllllllllllIIlIlIlIIIIIlIIIlll = lllllllllllllIIlIlIlIIIIIlIIlIIl.getAmount();
                }
                else {
                    lllllllllllllIIlIlIlIIIIIlIIIllI = lllllllllllllIIlIlIlIIIIIlIIlIIl.getAmount() * 100.0;
                }
                if (lllllllllllllIIlIlIlIIIIIlIIlIII > 0.0) {
                    lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.BLUE).append(I18n.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.plus.").append(lllllllllllllIIlIlIlIIIIIlIIlIIl.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllIIlIlIlIIIIIlIIIllI), I18n.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllIIlIlIlIIIIIlIIlIlI.getFirst())))))));
                }
                else {
                    if (lllllllllllllIIlIlIlIIIIIlIIlIII >= 0.0) {
                        continue;
                    }
                    lllllllllllllIIlIlIlIIIIIlIIIllI *= -1.0;
                    lllllllllllllIIlIlIlIIIIIlIlIllI.add(String.valueOf(new StringBuilder().append(TextFormatting.RED).append(I18n.translateToLocalFormatted(String.valueOf(new StringBuilder("attribute.modifier.take.").append(lllllllllllllIIlIlIlIIIIIlIIlIIl.getOperation())), ItemStack.DECIMALFORMAT.format(lllllllllllllIIlIlIlIIIIIlIIIllI), I18n.translateToLocal(String.valueOf(new StringBuilder("attribute.name.").append(lllllllllllllIIlIlIlIIIIIlIIlIlI.getFirst())))))));
                }
            }
        }
    }
    
    public static int getPotionColorFromEffectList(final Collection<PotionEffect> lllllllllllllIIlIlIlIIIIlIIlIIll) {
        final int lllllllllllllIIlIlIlIIIIlIIllIll = 3694022;
        if (lllllllllllllIIlIlIlIIIIlIIlIIll.isEmpty()) {
            return Config.isCustomColors() ? CustomColors.getPotionColor(null, lllllllllllllIIlIlIlIIIIlIIllIll) : 3694022;
        }
        float lllllllllllllIIlIlIlIIIIlIIllIlI = 0.0f;
        float lllllllllllllIIlIlIlIIIIlIIllIIl = 0.0f;
        float lllllllllllllIIlIlIlIIIIlIIllIII = 0.0f;
        int lllllllllllllIIlIlIlIIIIlIIlIlll = 0;
        for (final PotionEffect lllllllllllllIIlIlIlIIIIlIIlIllI : lllllllllllllIIlIlIlIIIIlIIlIIll) {
            if (lllllllllllllIIlIlIlIIIIlIIlIllI.doesShowParticles()) {
                int lllllllllllllIIlIlIlIIIIlIIlIlIl = lllllllllllllIIlIlIlIIIIlIIlIllI.getPotion().getLiquidColor();
                if (Config.isCustomColors()) {
                    lllllllllllllIIlIlIlIIIIlIIlIlIl = CustomColors.getPotionColor(lllllllllllllIIlIlIlIIIIlIIlIllI.getPotion(), lllllllllllllIIlIlIlIIIIlIIlIlIl);
                }
                final int lllllllllllllIIlIlIlIIIIlIIlIlII = lllllllllllllIIlIlIlIIIIlIIlIllI.getAmplifier() + 1;
                lllllllllllllIIlIlIlIIIIlIIllIlI += lllllllllllllIIlIlIlIIIIlIIlIlII * (lllllllllllllIIlIlIlIIIIlIIlIlIl >> 16 & 0xFF) / 255.0f;
                lllllllllllllIIlIlIlIIIIlIIllIIl += lllllllllllllIIlIlIlIIIIlIIlIlII * (lllllllllllllIIlIlIlIIIIlIIlIlIl >> 8 & 0xFF) / 255.0f;
                lllllllllllllIIlIlIlIIIIlIIllIII += lllllllllllllIIlIlIlIIIIlIIlIlII * (lllllllllllllIIlIlIlIIIIlIIlIlIl >> 0 & 0xFF) / 255.0f;
                lllllllllllllIIlIlIlIIIIlIIlIlll += lllllllllllllIIlIlIlIIIIlIIlIlII;
            }
        }
        if (lllllllllllllIIlIlIlIIIIlIIlIlll == 0) {
            return 0;
        }
        lllllllllllllIIlIlIlIIIIlIIllIlI = lllllllllllllIIlIlIlIIIIlIIllIlI / lllllllllllllIIlIlIlIIIIlIIlIlll * 255.0f;
        lllllllllllllIIlIlIlIIIIlIIllIIl = lllllllllllllIIlIlIlIIIIlIIllIIl / lllllllllllllIIlIlIlIIIIlIIlIlll * 255.0f;
        lllllllllllllIIlIlIlIIIIlIIllIII = lllllllllllllIIlIlIlIIIIlIIllIII / lllllllllllllIIlIlIlIIIIlIIlIlll * 255.0f;
        return (int)lllllllllllllIIlIlIlIIIIlIIllIlI << 16 | (int)lllllllllllllIIlIlIlIIIIlIIllIIl << 8 | (int)lllllllllllllIIlIlIlIIIIlIIllIII;
    }
    
    public static PotionType getPotionFromItem(final ItemStack lllllllllllllIIlIlIlIIIIlIIIIlll) {
        return getPotionTypeFromNBT(lllllllllllllIIlIlIlIIIIlIIIIlll.getTagCompound());
    }
}
