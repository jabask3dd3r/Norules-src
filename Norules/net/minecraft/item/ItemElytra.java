package net.minecraft.item;

import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;

public class ItemElytra extends Item
{
    @Override
    public boolean getIsRepairable(final ItemStack llllllllllllllIIIlIlIllllllIlIll, final ItemStack llllllllllllllIIIlIlIllllllIlIlI) {
        return llllllllllllllIIIlIlIllllllIlIlI.getItem() == Items.LEATHER;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllIIIlIlIllllllIIIlI, final EntityPlayer llllllllllllllIIIlIlIlllllIlllII, final EnumHand llllllllllllllIIIlIlIlllllIllIll) {
        final ItemStack llllllllllllllIIIlIlIlllllIlllll = llllllllllllllIIIlIlIlllllIlllII.getHeldItem(llllllllllllllIIIlIlIlllllIllIll);
        final EntityEquipmentSlot llllllllllllllIIIlIlIlllllIllllI = EntityLiving.getSlotForItemStack(llllllllllllllIIIlIlIlllllIlllll);
        final ItemStack llllllllllllllIIIlIlIlllllIlllIl = llllllllllllllIIIlIlIlllllIlllII.getItemStackFromSlot(llllllllllllllIIIlIlIlllllIllllI);
        if (llllllllllllllIIIlIlIlllllIlllIl.func_190926_b()) {
            llllllllllllllIIIlIlIlllllIlllII.setItemStackToSlot(llllllllllllllIIIlIlIlllllIllllI, llllllllllllllIIIlIlIlllllIlllll.copy());
            llllllllllllllIIIlIlIlllllIlllll.func_190920_e(0);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllIIIlIlIlllllIlllll);
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, llllllllllllllIIIlIlIlllllIlllll);
    }
    
    public ItemElytra() {
        this.maxStackSize = 1;
        this.setMaxDamage(432);
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        this.addPropertyOverride(new ResourceLocation("broken"), new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack lllllllllllllIllIIlIllIllllllIlI, @Nullable final World lllllllllllllIllIIlIllIllllllIIl, @Nullable final EntityLivingBase lllllllllllllIllIIlIllIllllllIII) {
                return ItemElytra.isBroken(lllllllllllllIllIIlIllIllllllIlI) ? 0.0f : 1.0f;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
    }
    
    public static boolean isBroken(final ItemStack llllllllllllllIIIlIlIllllllIlllI) {
        return llllllllllllllIIIlIlIllllllIlllI.getItemDamage() < llllllllllllllIIIlIlIllllllIlllI.getMaxDamage() - 1;
    }
}
