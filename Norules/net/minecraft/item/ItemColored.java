package net.minecraft.item;

import net.minecraft.block.*;

public class ItemColored extends ItemBlock
{
    private /* synthetic */ String[] subtypeNames;
    
    @Override
    public int getMetadata(final int lllllllllllllIlllIllIIlllIIIlIII) {
        return lllllllllllllIlllIllIIlllIIIlIII;
    }
    
    public ItemColored setSubtypeNames(final String[] lllllllllllllIlllIllIIlllIIIIIIl) {
        this.subtypeNames = lllllllllllllIlllIllIIlllIIIIIIl;
        return this;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIlllIllIIllIllllIIl) {
        if (this.subtypeNames == null) {
            return super.getUnlocalizedName(lllllllllllllIlllIllIIllIllllIIl);
        }
        final int lllllllllllllIlllIllIIllIllllIll = lllllllllllllIlllIllIIllIllllIIl.getMetadata();
        return (lllllllllllllIlllIllIIllIllllIll >= 0 && lllllllllllllIlllIllIIllIllllIll < this.subtypeNames.length) ? String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName(lllllllllllllIlllIllIIllIllllIIl))).append(".").append(this.subtypeNames[lllllllllllllIlllIllIIllIllllIll])) : super.getUnlocalizedName(lllllllllllllIlllIllIIllIllllIIl);
    }
    
    public ItemColored(final Block lllllllllllllIlllIllIIlllIIIllll, final boolean lllllllllllllIlllIllIIlllIIIlllI) {
        super(lllllllllllllIlllIllIIlllIIIllll);
        if (lllllllllllllIlllIllIIlllIIIlllI) {
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
        }
    }
}
