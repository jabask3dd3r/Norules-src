package net.minecraft.item;

import net.minecraft.block.*;

public class ItemAnvilBlock extends ItemMultiTexture
{
    public ItemAnvilBlock(final Block lllllllllllllllIlIlIIllllllllIlI) {
        super(lllllllllllllllIlIlIIllllllllIlI, lllllllllllllllIlIlIIllllllllIlI, new String[] { "intact", "slightlyDamaged", "veryDamaged" });
    }
    
    @Override
    public int getMetadata(final int lllllllllllllllIlIlIIlllllllIllI) {
        return lllllllllllllllIlIlIIlllllllIllI << 2;
    }
}
