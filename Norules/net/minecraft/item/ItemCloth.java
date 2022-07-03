package net.minecraft.item;

import net.minecraft.block.*;

public class ItemCloth extends ItemBlock
{
    public ItemCloth(final Block lllllllllllllllIIlIlIlllIllllllI) {
        super(lllllllllllllllIIlIlIlllIllllllI);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(final int lllllllllllllllIIlIlIlllIllllIll) {
        return lllllllllllllllIIlIlIlllIllllIll;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllllIIlIlIlllIlllIlII) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumDyeColor.byMetadata(lllllllllllllllIIlIlIlllIlllIlII.getMetadata()).getUnlocalizedName()));
    }
}
