package net.minecraft.stats;

import net.minecraft.item.*;
import net.minecraft.util.text.*;

public class StatCrafting extends StatBase
{
    private final /* synthetic */ Item item;
    
    public Item getItem() {
        return this.item;
    }
    
    public StatCrafting(final String lllllllllllllllIlIlIIlllllIIIllI, final String lllllllllllllllIlIlIIlllllIIIIII, final ITextComponent lllllllllllllllIlIlIIlllllIIIlII, final Item lllllllllllllllIlIlIIlllllIIIIll) {
        super(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIlIIlllllIIIllI)).append(lllllllllllllllIlIlIIlllllIIIIII)), lllllllllllllllIlIlIIlllllIIIlII);
        this.item = lllllllllllllllIlIlIIlllllIIIIll;
    }
}
