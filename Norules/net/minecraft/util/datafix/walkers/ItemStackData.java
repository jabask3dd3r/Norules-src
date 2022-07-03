package net.minecraft.util.datafix.walkers;

import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;

public class ItemStackData extends Filtered
{
    private final /* synthetic */ String[] matchingTags;
    
    @Override
    NBTTagCompound filteredProcess(final IDataFixer lllllllllllllIIIIIIlIIllIlllIlII, NBTTagCompound lllllllllllllIIIIIIlIIllIllIlllI, final int lllllllllllllIIIIIIlIIllIlllIIlI) {
        float lllllllllllllIIIIIIlIIllIllIlIIl;
        for (byte lllllllllllllIIIIIIlIIllIllIlIlI = (byte)((String[])(Object)(lllllllllllllIIIIIIlIIllIllIlIIl = (float)(Object)this.matchingTags)).length, lllllllllllllIIIIIIlIIllIllIlIll = 0; lllllllllllllIIIIIIlIIllIllIlIll < lllllllllllllIIIIIIlIIllIllIlIlI; ++lllllllllllllIIIIIIlIIllIllIlIll) {
            final String lllllllllllllIIIIIIlIIllIlllIIIl = lllllllllllllIIIIIIlIIllIllIlIIl[lllllllllllllIIIIIIlIIllIllIlIll];
            lllllllllllllIIIIIIlIIllIllIlllI = DataFixesManager.processItemStack(lllllllllllllIIIIIIlIIllIlllIlII, (NBTTagCompound)lllllllllllllIIIIIIlIIllIllIlllI, lllllllllllllIIIIIIlIIllIlllIIlI, lllllllllllllIIIIIIlIIllIlllIIIl);
        }
        return (NBTTagCompound)lllllllllllllIIIIIIlIIllIllIlllI;
    }
    
    public ItemStackData(final Class<?> lllllllllllllIIIIIIlIIllIlllllll, final String... lllllllllllllIIIIIIlIIlllIIIIIIl) {
        super(lllllllllllllIIIIIIlIIllIlllllll);
        this.matchingTags = lllllllllllllIIIIIIlIIlllIIIIIIl;
    }
}
