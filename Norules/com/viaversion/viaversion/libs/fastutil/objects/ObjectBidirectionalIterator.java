package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;

public interface ObjectBidirectionalIterator<K> extends ObjectIterator<K>, BidirectionalIterator<K>
{
    default int skip(final int llllllllllllllIlIllIIIlIIIllllll) {
        return super.skip(llllllllllllllIlIllIIIlIIIllllll);
    }
    
    default int back(final int llllllllllllllIlIllIIIlIIlIIIllI) {
        int llllllllllllllIlIllIIIlIIlIIlIlI = llllllllllllllIlIllIIIlIIlIIIllI;
        while (llllllllllllllIlIllIIIlIIlIIlIlI-- != 0 && this.hasPrevious()) {
            this.previous();
        }
        return llllllllllllllIlIllIIIlIIlIIIllI - llllllllllllllIlIllIIIlIIlIIlIlI - 1;
    }
}
