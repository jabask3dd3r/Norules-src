package com.viaversion.viaversion.api.data.entity;

import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.connection.*;

public interface EntityTracker
{
    int clientEntityId();
    
    int currentMinY();
    
    boolean hasEntity(final int p0);
    
    StoredEntityData entityData(final int p0);
    
    void addEntity(final int p0, final EntityType p1);
    
    StoredEntityData entityDataIfPresent(final int p0);
    
    void removeEntity(final int p0);
    
    EntityType entityType(final int p0);
    
    int currentWorldSectionHeight();
    
    UserConnection user();
    
    void setCurrentWorldSectionHeight(final int p0);
    
    void setClientEntityId(final int p0);
    
    void setCurrentMinY(final int p0);
}
