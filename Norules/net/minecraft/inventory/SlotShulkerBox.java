package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.block.*;

public class SlotShulkerBox extends Slot
{
    @Override
    public boolean isItemValid(final ItemStack lllllllllllllIlIllllIIIIIllIIIlI) {
        return !(Block.getBlockFromItem(lllllllllllllIlIllllIIIIIllIIIlI.getItem()) instanceof BlockShulkerBox);
    }
    
    public SlotShulkerBox(final IInventory lllllllllllllIlIllllIIIIIllIlIII, final int lllllllllllllIlIllllIIIIIllIIlll, final int lllllllllllllIlIllllIIIIIllIIllI, final int lllllllllllllIlIllllIIIIIllIlIlI) {
        super(lllllllllllllIlIllllIIIIIllIlIII, lllllllllllllIlIllllIIIIIllIIlll, lllllllllllllIlIllllIIIIIllIIllI, lllllllllllllIlIllllIIIIIllIlIlI);
    }
}
