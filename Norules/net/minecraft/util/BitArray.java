package net.minecraft.util;

import org.apache.commons.lang3.*;
import net.minecraft.util.math.*;

public class BitArray
{
    private final /* synthetic */ int arraySize;
    private final /* synthetic */ long[] longArray;
    private final /* synthetic */ long maxEntryValue;
    private final /* synthetic */ int bitsPerEntry;
    
    public void setAt(final int lllllllllllllIIllIIlIllIlIlIlllI, final int lllllllllllllIIllIIlIllIlIlIllIl) {
        Validate.inclusiveBetween(0L, (long)(this.arraySize - 1), (long)lllllllllllllIIllIIlIllIlIlIlllI);
        Validate.inclusiveBetween(0L, this.maxEntryValue, (long)lllllllllllllIIllIIlIllIlIlIllIl);
        final int lllllllllllllIIllIIlIllIlIllIlIl = lllllllllllllIIllIIlIllIlIlIlllI * this.bitsPerEntry;
        final int lllllllllllllIIllIIlIllIlIllIlII = lllllllllllllIIllIIlIllIlIllIlIl / 64;
        final int lllllllllllllIIllIIlIllIlIllIIll = ((lllllllllllllIIllIIlIllIlIlIlllI + 1) * this.bitsPerEntry - 1) / 64;
        final int lllllllllllllIIllIIlIllIlIllIIlI = lllllllllllllIIllIIlIllIlIllIlIl % 64;
        this.longArray[lllllllllllllIIllIIlIllIlIllIlII] = ((this.longArray[lllllllllllllIIllIIlIllIlIllIlII] & ~(this.maxEntryValue << lllllllllllllIIllIIlIllIlIllIIlI)) | ((long)lllllllllllllIIllIIlIllIlIlIllIl & this.maxEntryValue) << lllllllllllllIIllIIlIllIlIllIIlI);
        if (lllllllllllllIIllIIlIllIlIllIlII != lllllllllllllIIllIIlIllIlIllIIll) {
            final int lllllllllllllIIllIIlIllIlIllIIIl = 64 - lllllllllllllIIllIIlIllIlIllIIlI;
            final int lllllllllllllIIllIIlIllIlIllIIII = this.bitsPerEntry - lllllllllllllIIllIIlIllIlIllIIIl;
            this.longArray[lllllllllllllIIllIIlIllIlIllIIll] = (this.longArray[lllllllllllllIIllIIlIllIlIllIIll] >>> lllllllllllllIIllIIlIllIlIllIIII << lllllllllllllIIllIIlIllIlIllIIII | ((long)lllllllllllllIIllIIlIllIlIlIllIl & this.maxEntryValue) >> lllllllllllllIIllIIlIllIlIllIIIl);
        }
    }
    
    public int size() {
        return this.arraySize;
    }
    
    public BitArray(final int lllllllllllllIIllIIlIllIllIIIllI, final int lllllllllllllIIllIIlIllIllIIIIlI) {
        Validate.inclusiveBetween(1L, 32L, (long)lllllllllllllIIllIIlIllIllIIIllI);
        this.arraySize = lllllllllllllIIllIIlIllIllIIIIlI;
        this.bitsPerEntry = lllllllllllllIIllIIlIllIllIIIllI;
        this.maxEntryValue = (1L << lllllllllllllIIllIIlIllIllIIIllI) - 1L;
        this.longArray = new long[MathHelper.roundUp(lllllllllllllIIllIIlIllIllIIIIlI * lllllllllllllIIllIIlIllIllIIIllI, 64) / 64];
    }
    
    public int getAt(final int lllllllllllllIIllIIlIllIlIIlIlll) {
        Validate.inclusiveBetween(0L, (long)(this.arraySize - 1), (long)lllllllllllllIIllIIlIllIlIIlIlll);
        final int lllllllllllllIIllIIlIllIlIIlllIl = lllllllllllllIIllIIlIllIlIIlIlll * this.bitsPerEntry;
        final int lllllllllllllIIllIIlIllIlIIlllII = lllllllllllllIIllIIlIllIlIIlllIl / 64;
        final int lllllllllllllIIllIIlIllIlIIllIll = ((lllllllllllllIIllIIlIllIlIIlIlll + 1) * this.bitsPerEntry - 1) / 64;
        final int lllllllllllllIIllIIlIllIlIIllIlI = lllllllllllllIIllIIlIllIlIIlllIl % 64;
        if (lllllllllllllIIllIIlIllIlIIlllII == lllllllllllllIIllIIlIllIlIIllIll) {
            return (int)(this.longArray[lllllllllllllIIllIIlIllIlIIlllII] >>> lllllllllllllIIllIIlIllIlIIllIlI & this.maxEntryValue);
        }
        final int lllllllllllllIIllIIlIllIlIIllIIl = 64 - lllllllllllllIIllIIlIllIlIIllIlI;
        return (int)((this.longArray[lllllllllllllIIllIIlIllIlIIlllII] >>> lllllllllllllIIllIIlIllIlIIllIlI | this.longArray[lllllllllllllIIllIIlIllIlIIllIll] << lllllllllllllIIllIIlIllIlIIllIIl) & this.maxEntryValue);
    }
    
    public long[] getBackingLongArray() {
        return this.longArray;
    }
}
