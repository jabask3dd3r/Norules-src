package com.viaversion.viaversion.api.data.entity;

import com.viaversion.viaversion.api.minecraft.entities.*;

public interface StoredEntityData
{
    boolean has(final Class<?> p0);
    
    void put(final Object p0);
    
    EntityType type();
    
     <T> T get(final Class<T> p0);
}
