package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.init.*;

public class SlotFurnaceFuel extends Slot
{
    @Override
    public int getItemStackLimit(final ItemStack lllllllllllllIIllIllIlIIIllIllll) {
        return isBucket(lllllllllllllIIllIllIlIIIllIllll) ? 1 : super.getItemStackLimit(lllllllllllllIIllIllIlIIIllIllll);
    }
    
    public SlotFurnaceFuel(final IInventory lllllllllllllIIllIllIlIIIlllllII, final int lllllllllllllIIllIllIlIIlIIIIIII, final int lllllllllllllIIllIllIlIIIlllllll, final int lllllllllllllIIllIllIlIIIllllllI) {
        super(lllllllllllllIIllIllIlIIIlllllII, lllllllllllllIIllIllIlIIlIIIIIII, lllllllllllllIIllIllIlIIIlllllll, lllllllllllllIIllIllIlIIIllllllI);
    }
    
    @Override
    public boolean isItemValid(final ItemStack lllllllllllllIIllIllIlIIIlllIlIl) {
        return TileEntityFurnace.isItemFuel(lllllllllllllIIllIllIlIIIlllIlIl) || isBucket(lllllllllllllIIllIllIlIIIlllIlIl);
    }
    
    public static boolean isBucket(final ItemStack lllllllllllllIIllIllIlIIIllIllIl) {
        return lllllllllllllIIllIllIlIIIllIllIl.getItem() == Items.BUCKET;
    }
}
