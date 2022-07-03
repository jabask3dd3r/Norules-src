package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;

public class ItemSoup extends ItemFood
{
    public ItemSoup(final int lllllllllllllIIIlIlIIlIlIllIllll) {
        super(lllllllllllllIIIlIlIIlIlIllIllll, false);
        this.setMaxStackSize(1);
    }
    
    @Override
    public ItemStack onItemUseFinish(final ItemStack lllllllllllllIIIlIlIIlIlIllIIlIl, final World lllllllllllllIIIlIlIIlIlIllIlIII, final EntityLivingBase lllllllllllllIIIlIlIIlIlIllIIIll) {
        super.onItemUseFinish(lllllllllllllIIIlIlIIlIlIllIIlIl, lllllllllllllIIIlIlIIlIlIllIlIII, lllllllllllllIIIlIlIIlIlIllIIIll);
        return new ItemStack(Items.BOWL);
    }
}
