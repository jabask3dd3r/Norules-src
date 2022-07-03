package net.minecraft.item;

import net.minecraft.block.*;

public class ItemLeaves extends ItemBlock
{
    private final /* synthetic */ BlockLeaves leaves;
    
    @Override
    public int getMetadata(final int lllllllllllllIIIlIIIIlIIllIIIIII) {
        return lllllllllllllIIIlIIIIlIIllIIIIII | 0x4;
    }
    
    public ItemLeaves(final BlockLeaves lllllllllllllIIIlIIIIlIIllIIIlII) {
        super(lllllllllllllIIIlIIIIlIIllIIIlII);
        this.leaves = lllllllllllllIIIlIIIIlIIllIIIlII;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIIIlIIIIlIIlIlllIlI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(this.leaves.getWoodType(lllllllllllllIIIlIIIIlIIlIlllIlI.getMetadata()).getUnlocalizedName()));
    }
}
