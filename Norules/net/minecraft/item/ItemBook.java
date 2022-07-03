package net.minecraft.item;

public class ItemBook extends Item
{
    @Override
    public boolean isItemTool(final ItemStack lllllllllllllIlIlllIIIIlIlllIIlI) {
        return lllllllllllllIlIlllIIIIlIlllIIlI.func_190916_E() == 1;
    }
    
    @Override
    public int getItemEnchantability() {
        return 1;
    }
}
