package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public abstract class AbstractObjectSet<K> extends AbstractObjectCollection<K> implements Cloneable, ObjectSet<K>
{
    @Override
    public abstract ObjectIterator<K> iterator();
    
    @Override
    public boolean equals(final Object lllllllllllllllllllllIlIIlIIIllI) {
        if (lllllllllllllllllllllIlIIlIIIllI == this) {
            return true;
        }
        if (!(lllllllllllllllllllllIlIIlIIIllI instanceof Set)) {
            return false;
        }
        final Set<?> lllllllllllllllllllllIlIIlIIIlIl = (Set<?>)lllllllllllllllllllllIlIIlIIIllI;
        return lllllllllllllllllllllIlIIlIIIlIl.size() == this.size() && this.containsAll(lllllllllllllllllllllIlIIlIIIlIl);
    }
    
    protected AbstractObjectSet() {
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllllllllIlIIIlllIlI = 0;
        int lllllllllllllllllllllIlIIIlllIIl = this.size();
        final ObjectIterator<K> lllllllllllllllllllllIlIIIlllIII = this.iterator();
        while (lllllllllllllllllllllIlIIIlllIIl-- != 0) {
            final K lllllllllllllllllllllIlIIIllllII = lllllllllllllllllllllIlIIIlllIII.next();
            lllllllllllllllllllllIlIIIlllIlI += ((lllllllllllllllllllllIlIIIllllII == null) ? 0 : lllllllllllllllllllllIlIIIllllII.hashCode());
        }
        return lllllllllllllllllllllIlIIIlllIlI;
    }
}
