package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class ItemCoal extends Item
{
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIllIllIIlIlllIIlIlI) {
        return (lllllllllllllIllIllIIlIlllIIlIlI.getMetadata() == 1) ? "item.charcoal" : "item.coal";
    }
    
    public ItemCoal() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
    
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllIllIllIIlIlllIIIlIl, final NonNullList<ItemStack> lllllllllllllIllIllIIlIlllIIIIIl) {
        if (this.func_194125_a(lllllllllllllIllIllIIlIlllIIIlIl)) {
            lllllllllllllIllIllIIlIlllIIIIIl.add(new ItemStack(this, 1, 0));
            lllllllllllllIllIllIIlIlllIIIIIl.add(new ItemStack(this, 1, 1));
        }
    }
}
