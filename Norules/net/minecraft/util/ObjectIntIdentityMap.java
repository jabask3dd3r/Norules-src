package net.minecraft.util;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class ObjectIntIdentityMap<T> implements IObjectIntIterable<T>
{
    private final /* synthetic */ IdentityHashMap<T, Integer> identityMap;
    private final /* synthetic */ List<T> objectList;
    
    @Nullable
    public final T getByValue(final int lllllllllllllIllIIIIlllIlllIlIIl) {
        return (lllllllllllllIllIIIIlllIlllIlIIl >= 0 && lllllllllllllIllIIIIlllIlllIlIIl < this.objectList.size()) ? this.objectList.get(lllllllllllllIllIIIIlllIlllIlIIl) : null;
    }
    
    public ObjectIntIdentityMap(final int lllllllllllllIllIIIIllllIIIIIIIl) {
        this.objectList = (List<T>)Lists.newArrayListWithExpectedSize(lllllllllllllIllIIIIllllIIIIIIIl);
        this.identityMap = new IdentityHashMap<T, Integer>(lllllllllllllIllIIIIllllIIIIIIIl);
    }
    
    public int size() {
        return this.identityMap.size();
    }
    
    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)Iterators.filter((Iterator)this.objectList.iterator(), Predicates.notNull());
    }
    
    public void put(final T lllllllllllllIllIIIIlllIlllllIlI, final int lllllllllllllIllIIIIlllIllllIllI) {
        this.identityMap.put(lllllllllllllIllIIIIlllIlllllIlI, lllllllllllllIllIIIIlllIllllIllI);
        while (this.objectList.size() <= lllllllllllllIllIIIIlllIllllIllI) {
            this.objectList.add(null);
        }
        this.objectList.set(lllllllllllllIllIIIIlllIllllIllI, lllllllllllllIllIIIIlllIlllllIlI);
    }
    
    public int get(final T lllllllllllllIllIIIIlllIllllIIIl) {
        final Integer lllllllllllllIllIIIIlllIllllIIII = this.identityMap.get(lllllllllllllIllIIIIlllIllllIIIl);
        return (lllllllllllllIllIIIIlllIllllIIII == null) ? -1 : lllllllllllllIllIIIIlllIllllIIII;
    }
    
    public ObjectIntIdentityMap() {
        this(512);
    }
}
