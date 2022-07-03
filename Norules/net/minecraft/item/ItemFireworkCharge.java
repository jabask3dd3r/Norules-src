package net.minecraft.item;

import java.util.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.client.util.*;

public class ItemFireworkCharge extends Item
{
    public static void addExplosionInfo(final NBTTagCompound llllllllllllllIIllIIlIlllIllllll, final List<String> llllllllllllllIIllIIlIlllIlllllI) {
        final byte llllllllllllllIIllIIlIlllIllllIl = llllllllllllllIIllIIlIlllIllllll.getByte("Type");
        if (llllllllllllllIIllIIlIlllIllllIl >= 0 && llllllllllllllIIllIIlIlllIllllIl <= 4) {
            llllllllllllllIIllIIlIlllIlllllI.add(I18n.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.type.").append(llllllllllllllIIllIIlIlllIllllIl))).trim());
        }
        else {
            llllllllllllllIIllIIlIlllIlllllI.add(I18n.translateToLocal("item.fireworksCharge.type").trim());
        }
        final int[] llllllllllllllIIllIIlIlllIllllII = llllllllllllllIIllIIlIlllIllllll.getIntArray("Colors");
        if (llllllllllllllIIllIIlIlllIllllII.length > 0) {
            boolean llllllllllllllIIllIIlIlllIlllIll = true;
            String llllllllllllllIIllIIlIlllIlllIlI = "";
            final float llllllllllllllIIllIIlIlllIlIIlIl;
            final String llllllllllllllIIllIIlIlllIlIIllI = (String)((int[])(Object)(llllllllllllllIIllIIlIlllIlIIlIl = (float)(Object)llllllllllllllIIllIIlIlllIllllII)).length;
            for (final int llllllllllllllIIllIIlIlllIlllIIl : llllllllllllllIIllIIlIlllIlIIlIl) {
                if (!llllllllllllllIIllIIlIlllIlllIll) {
                    llllllllllllllIIllIIlIlllIlllIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIlllIlI)).append(", "));
                }
                llllllllllllllIIllIIlIlllIlllIll = false;
                boolean llllllllllllllIIllIIlIlllIlllIII = false;
                for (int llllllllllllllIIllIIlIlllIllIlll = 0; llllllllllllllIIllIIlIlllIllIlll < ItemDye.DYE_COLORS.length; ++llllllllllllllIIllIIlIlllIllIlll) {
                    if (llllllllllllllIIllIIlIlllIlllIIl == ItemDye.DYE_COLORS[llllllllllllllIIllIIlIlllIllIlll]) {
                        llllllllllllllIIllIIlIlllIlllIII = true;
                        llllllllllllllIIllIIlIlllIlllIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIlllIlI)).append(I18n.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.").append(EnumDyeColor.byDyeDamage(llllllllllllllIIllIIlIlllIllIlll).getUnlocalizedName())))));
                        break;
                    }
                }
                if (!llllllllllllllIIllIIlIlllIlllIII) {
                    llllllllllllllIIllIIlIlllIlllIlI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIlllIlI)).append(I18n.translateToLocal("item.fireworksCharge.customColor")));
                }
            }
            llllllllllllllIIllIIlIlllIlllllI.add(llllllllllllllIIllIIlIlllIlllIlI);
        }
        final int[] llllllllllllllIIllIIlIlllIllIllI = llllllllllllllIIllIIlIlllIllllll.getIntArray("FadeColors");
        if (llllllllllllllIIllIIlIlllIllIllI.length > 0) {
            boolean llllllllllllllIIllIIlIlllIllIlIl = true;
            String llllllllllllllIIllIIlIlllIllIlII = String.valueOf(new StringBuilder(String.valueOf(I18n.translateToLocal("item.fireworksCharge.fadeTo"))).append(" "));
            final int[] array;
            final float llllllllllllllIIllIIlIlllIlIIlIl = (array = llllllllllllllIIllIIlIlllIllIllI).length;
            for (String llllllllllllllIIllIIlIlllIlIIllI = (String)0; llllllllllllllIIllIIlIlllIlIIllI < llllllllllllllIIllIIlIlllIlIIlIl; ++llllllllllllllIIllIIlIlllIlIIllI) {
                final int llllllllllllllIIllIIlIlllIllIIll = array[llllllllllllllIIllIIlIlllIlIIllI];
                if (!llllllllllllllIIllIIlIlllIllIlIl) {
                    llllllllllllllIIllIIlIlllIllIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIllIlII)).append(", "));
                }
                llllllllllllllIIllIIlIlllIllIlIl = false;
                boolean llllllllllllllIIllIIlIlllIllIIlI = false;
                for (int llllllllllllllIIllIIlIlllIllIIIl = 0; llllllllllllllIIllIIlIlllIllIIIl < 16; ++llllllllllllllIIllIIlIlllIllIIIl) {
                    if (llllllllllllllIIllIIlIlllIllIIll == ItemDye.DYE_COLORS[llllllllllllllIIllIIlIlllIllIIIl]) {
                        llllllllllllllIIllIIlIlllIllIIlI = true;
                        llllllllllllllIIllIIlIlllIllIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIllIlII)).append(I18n.translateToLocal(String.valueOf(new StringBuilder("item.fireworksCharge.").append(EnumDyeColor.byDyeDamage(llllllllllllllIIllIIlIlllIllIIIl).getUnlocalizedName())))));
                        break;
                    }
                }
                if (!llllllllllllllIIllIIlIlllIllIIlI) {
                    llllllllllllllIIllIIlIlllIllIlII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlllIllIlII)).append(I18n.translateToLocal("item.fireworksCharge.customColor")));
                }
            }
            llllllllllllllIIllIIlIlllIlllllI.add(llllllllllllllIIllIIlIlllIllIlII);
        }
        final boolean llllllllllllllIIllIIlIlllIllIIII = llllllllllllllIIllIIlIlllIllllll.getBoolean("Trail");
        if (llllllllllllllIIllIIlIlllIllIIII) {
            llllllllllllllIIllIIlIlllIlllllI.add(I18n.translateToLocal("item.fireworksCharge.trail"));
        }
        final boolean llllllllllllllIIllIIlIlllIlIllll = llllllllllllllIIllIIlIlllIllllll.getBoolean("Flicker");
        if (llllllllllllllIIllIIlIlllIlIllll) {
            llllllllllllllIIllIIlIlllIlllllI.add(I18n.translateToLocal("item.fireworksCharge.flicker"));
        }
    }
    
    public static NBTBase getExplosionTag(final ItemStack llllllllllllllIIllIIlIllllIllIll, final String llllllllllllllIIllIIlIllllIlllIl) {
        if (llllllllllllllIIllIIlIllllIllIll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIIllIIlIllllIlllII = llllllllllllllIIllIIlIllllIllIll.getTagCompound().getCompoundTag("Explosion");
            if (llllllllllllllIIllIIlIllllIlllII != null) {
                return llllllllllllllIIllIIlIllllIlllII.getTag(llllllllllllllIIllIIlIllllIlllIl);
            }
        }
        return null;
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIIllIIlIllllIIllll, @Nullable final World llllllllllllllIIllIIlIllllIlIIll, final List<String> llllllllllllllIIllIIlIllllIlIIlI, final ITooltipFlag llllllllllllllIIllIIlIllllIlIIIl) {
        if (llllllllllllllIIllIIlIllllIIllll.hasTagCompound()) {
            final NBTTagCompound llllllllllllllIIllIIlIllllIlIIII = llllllllllllllIIllIIlIllllIIllll.getTagCompound().getCompoundTag("Explosion");
            if (llllllllllllllIIllIIlIllllIlIIII != null) {
                addExplosionInfo(llllllllllllllIIllIIlIllllIlIIII, llllllllllllllIIllIIlIllllIlIIlI);
            }
        }
    }
}
