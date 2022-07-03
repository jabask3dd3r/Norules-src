package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.objects.*;

public interface IntBidirectionalIterator extends IntIterator, ObjectBidirectionalIterator<Integer>
{
    default int back(final int lllllllllllllllIIIIIlIllIIIllIlI) {
        int lllllllllllllllIIIIIlIllIIIlllII = lllllllllllllllIIIIIlIllIIIllIlI;
        while (lllllllllllllllIIIIIlIllIIIlllII-- != 0 && this.hasPrevious()) {
            this.previousInt();
        }
        return lllllllllllllllIIIIIlIllIIIllIlI - lllllllllllllllIIIIIlIllIIIlllII - 1;
    }
    
    @Deprecated
    default Integer previous() {
        return this.previousInt();
    }
    
    int previousInt();
    
    default int skip(final int lllllllllllllllIIIIIlIllIIIlIlIl) {
        return super.skip(lllllllllllllllIIIIIlIllIIIlIlIl);
    }
}
