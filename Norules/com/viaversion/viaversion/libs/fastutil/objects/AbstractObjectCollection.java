package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public abstract class AbstractObjectCollection<K> extends AbstractCollection<K> implements ObjectCollection<K>
{
    @Override
    public abstract ObjectIterator<K> iterator();
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIlIIlIIIIIIlIIIlll = new StringBuilder();
        final ObjectIterator<K> lllllllllllllIIlIIlIIIIIIlIIIllI = this.iterator();
        int lllllllllllllIIlIIlIIIIIIlIIIlIl = this.size();
        boolean lllllllllllllIIlIIlIIIIIIlIIIlII = true;
        lllllllllllllIIlIIlIIIIIIlIIIlll.append("{");
        while (lllllllllllllIIlIIlIIIIIIlIIIlIl-- != 0) {
            if (lllllllllllllIIlIIlIIIIIIlIIIlII) {
                lllllllllllllIIlIIlIIIIIIlIIIlII = false;
            }
            else {
                lllllllllllllIIlIIlIIIIIIlIIIlll.append(", ");
            }
            final Object lllllllllllllIIlIIlIIIIIIlIIlIIl = lllllllllllllIIlIIlIIIIIIlIIIllI.next();
            if (this == lllllllllllllIIlIIlIIIIIIlIIlIIl) {
                lllllllllllllIIlIIlIIIIIIlIIIlll.append("(this collection)");
            }
            else {
                lllllllllllllIIlIIlIIIIIIlIIIlll.append(String.valueOf(lllllllllllllIIlIIlIIIIIIlIIlIIl));
            }
        }
        lllllllllllllIIlIIlIIIIIIlIIIlll.append("}");
        return String.valueOf(lllllllllllllIIlIIlIIIIIIlIIIlll);
    }
    
    protected AbstractObjectCollection() {
    }
}
