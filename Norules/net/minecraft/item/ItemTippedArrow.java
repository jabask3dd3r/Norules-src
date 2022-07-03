package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.init.*;

public class ItemTippedArrow extends ItemArrow
{
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllllIllIllllllIIIIlII, final NonNullList<ItemStack> lllllllllllllllIllIllllllIIIIIll) {
        if (this.func_194125_a(lllllllllllllllIllIllllllIIIIlII)) {
            for (final PotionType lllllllllllllllIllIllllllIIIIllI : PotionType.REGISTRY) {
                if (!lllllllllllllllIllIllllllIIIIllI.getEffects().isEmpty()) {
                    lllllllllllllllIllIllllllIIIIIll.add(PotionUtils.addPotionToItemStack(new ItemStack(this), lllllllllllllllIllIllllllIIIIllI));
                }
            }
        }
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllllIllIlllllIlllllIl, @Nullable final World lllllllllllllllIllIlllllIlllllII, final List<String> lllllllllllllllIllIlllllIllllIll, final ITooltipFlag lllllllllllllllIllIlllllIllllIlI) {
        PotionUtils.addPotionTooltip(lllllllllllllllIllIlllllIlllllIl, lllllllllllllllIllIlllllIllllIll, 0.125f);
    }
    
    @Override
    public EntityArrow createArrow(final World lllllllllllllllIllIllllllIIlIIlI, final ItemStack lllllllllllllllIllIllllllIIlIIIl, final EntityLivingBase lllllllllllllllIllIllllllIIlIIII) {
        final EntityTippedArrow lllllllllllllllIllIllllllIIlIIll = new EntityTippedArrow(lllllllllllllllIllIllllllIIlIIlI, lllllllllllllllIllIllllllIIlIIII);
        lllllllllllllllIllIllllllIIlIIll.setPotionEffect(lllllllllllllllIllIllllllIIlIIIl);
        return lllllllllllllllIllIllllllIIlIIll;
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllllIllIlllllIlllIlII) {
        return I18n.translateToLocal(PotionUtils.getPotionFromItem(lllllllllllllllIllIlllllIlllIlII).getNamePrefixed("tipped_arrow.effect."));
    }
    
    @Override
    public ItemStack func_190903_i() {
        return PotionUtils.addPotionToItemStack(super.func_190903_i(), PotionTypes.POISON);
    }
}
