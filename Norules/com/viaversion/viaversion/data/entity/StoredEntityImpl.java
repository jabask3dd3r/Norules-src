package com.viaversion.viaversion.data.entity;

import com.viaversion.viaversion.api.data.entity.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.concurrent.*;

public final class StoredEntityImpl implements StoredEntityData
{
    private final /* synthetic */ Map<Class<?>, Object> storedObjects;
    private final /* synthetic */ EntityType type;
    
    @Override
    public boolean has(final Class<?> lllllllllllllIllllIIlllllIllIIIl) {
        return this.storedObjects.containsKey(lllllllllllllIllllIIlllllIllIIIl);
    }
    
    @Override
    public EntityType type() {
        return this.type;
    }
    
    @Override
    public <T> T get(final Class<T> lllllllllllllIllllIIlllllIllIlIl) {
        return (T)this.storedObjects.get(lllllllllllllIllllIIlllllIllIlIl);
    }
    
    public StoredEntityImpl(final EntityType lllllllllllllIllllIIlllllIlllllI) {
        this.storedObjects = new ConcurrentHashMap<Class<?>, Object>();
        this.type = lllllllllllllIllllIIlllllIlllllI;
    }
    
    @Override
    public void put(final Object lllllllllllllIllllIIlllllIlIlIll) {
        this.storedObjects.put(lllllllllllllIllllIIlllllIlIlIll.getClass(), lllllllllllllIllllIIlllllIlIlIll);
    }
}
