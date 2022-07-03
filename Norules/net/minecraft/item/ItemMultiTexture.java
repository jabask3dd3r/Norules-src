package net.minecraft.item;

import net.minecraft.block.*;

public class ItemMultiTexture extends ItemBlock
{
    protected final /* synthetic */ Mapper nameFunction;
    protected final /* synthetic */ Block theBlock;
    
    public ItemMultiTexture(final Block lllllllllllllIlllIlllIlllIIIIIll, final Block lllllllllllllIlllIlllIlllIIIIIlI, final Mapper lllllllllllllIlllIlllIlllIIIIIIl) {
        super(lllllllllllllIlllIlllIlllIIIIIll);
        this.theBlock = lllllllllllllIlllIlllIlllIIIIIlI;
        this.nameFunction = lllllllllllllIlllIlllIlllIIIIIIl;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(final int lllllllllllllIlllIlllIllIlllIIIl) {
        return lllllllllllllIlllIlllIllIlllIIIl;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIlllIlllIllIllIllIl) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(this.nameFunction.apply(lllllllllllllIlllIlllIllIllIllIl)));
    }
    
    public ItemMultiTexture(final Block lllllllllllllIlllIlllIllIllllIll, final Block lllllllllllllIlllIlllIllIllllIlI, final String[] lllllllllllllIlllIlllIllIllllIIl) {
        this(lllllllllllllIlllIlllIllIllllIll, lllllllllllllIlllIlllIllIllllIlI, new Mapper() {
            @Override
            public String apply(final ItemStack llllllllllllllIllIIlIIlIIIIIllll) {
                int llllllllllllllIllIIlIIlIIIIlIIIl = llllllllllllllIllIIlIIlIIIIIllll.getMetadata();
                if (llllllllllllllIllIIlIIlIIIIlIIIl < 0 || llllllllllllllIllIIlIIlIIIIlIIIl >= lllllllllllllIlllIlllIllIllllIIl.length) {
                    llllllllllllllIllIIlIIlIIIIlIIIl = 0;
                }
                return lllllllllllllIlllIlllIllIllllIIl[llllllllllllllIllIIlIIlIIIIlIIIl];
            }
        });
    }
    
    public interface Mapper
    {
        String apply(final ItemStack p0);
    }
}
