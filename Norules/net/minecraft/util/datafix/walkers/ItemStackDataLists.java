package net.minecraft.util.datafix.walkers;

import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;

public class ItemStackDataLists extends Filtered
{
    private final /* synthetic */ String[] matchingTags;
    
    public ItemStackDataLists(final Class<?> lIIIIlIlllI, final String... lIIIIlIllIl) {
        super(lIIIIlIlllI);
        this.matchingTags = lIIIIlIllIl;
    }
    
    @Override
    NBTTagCompound filteredProcess(final IDataFixer lIIIIlIIIll, NBTTagCompound lIIIIIlllIl, final int lIIIIlIIIIl) {
        final long lIIIIIllIII;
        final float lIIIIIllIIl = ((String[])(Object)(lIIIIIllIII = (long)(Object)this.matchingTags)).length;
        for (boolean lIIIIIllIlI = false; (lIIIIIllIlI ? 1 : 0) < lIIIIIllIIl; ++lIIIIIllIlI) {
            final String lIIIIlIIIII = lIIIIIllIII[lIIIIIllIlI];
            lIIIIIlllIl = DataFixesManager.processInventory(lIIIIlIIIll, lIIIIIlllIl, lIIIIlIIIIl, lIIIIlIIIII);
        }
        return lIIIIIlllIl;
    }
}
