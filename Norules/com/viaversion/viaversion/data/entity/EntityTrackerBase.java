package com.viaversion.viaversion.data.entity;

import java.util.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.connection.*;
import com.google.common.base.*;
import java.util.concurrent.*;

public class EntityTrackerBase implements EntityTracker, ClientEntityIdChangeListener
{
    private /* synthetic */ int currentMinY;
    private final /* synthetic */ Map<Integer, StoredEntityData> entityData;
    private final /* synthetic */ Map<Integer, EntityType> entityTypes;
    private /* synthetic */ int currentWorldSectionHeight;
    private final /* synthetic */ EntityType playerType;
    private /* synthetic */ int clientEntityId;
    private final /* synthetic */ UserConnection connection;
    
    @Override
    public void setCurrentMinY(final int lllllllllllllIIIlllllIlIllIIIlIl) {
        this.currentMinY = lllllllllllllIIIlllllIlIllIIIlIl;
    }
    
    @Override
    public UserConnection user() {
        return this.connection;
    }
    
    @Override
    public int clientEntityId() {
        return this.clientEntityId;
    }
    
    @Override
    public StoredEntityData entityDataIfPresent(final int lllllllllllllIIIlllllIlIlllIlIIl) {
        return this.entityData.get(lllllllllllllIIIlllllIlIlllIlIIl);
    }
    
    @Override
    public boolean hasEntity(final int lllllllllllllIIIlllllIlIlllllllI) {
        return this.entityTypes.containsKey(lllllllllllllIIIlllllIlIlllllllI);
    }
    
    @Override
    public StoredEntityData entityData(final int lllllllllllllIIIlllllIlIllllIIII) {
        final EntityType lllllllllllllIIIlllllIlIllllIIlI = this.entityType(lllllllllllllIIIlllllIlIllllIIII);
        return (lllllllllllllIIIlllllIlIllllIIlI != null) ? this.entityData.computeIfAbsent(lllllllllllllIIIlllllIlIllllIIII, lllllllllllllIIIlllllIlIllIIIIlI -> new StoredEntityImpl(lllllllllllllIIIlllllIlIllllIIlI)) : null;
    }
    
    @Override
    public void setClientEntityId(final int lllllllllllllIIIlllllIlIllIllIII) {
        Preconditions.checkNotNull((Object)this.playerType);
        this.entityTypes.put(lllllllllllllIIIlllllIlIllIllIII, this.playerType);
        if (this.clientEntityId != -1 && this.entityData != null) {
            final StoredEntityData lllllllllllllIIIlllllIlIllIlllII = this.entityData.remove(this.clientEntityId);
            if (lllllllllllllIIIlllllIlIllIlllII != null) {
                this.entityData.put(lllllllllllllIIIlllllIlIllIllIII, lllllllllllllIIIlllllIlIllIlllII);
            }
        }
        this.clientEntityId = lllllllllllllIIIlllllIlIllIllIII;
    }
    
    public EntityTrackerBase(final UserConnection lllllllllllllIIIlllllIllIIIlIllI, final EntityType lllllllllllllIIIlllllIllIIIlIIIl, final boolean lllllllllllllIIIlllllIllIIIlIlII) {
        this.entityTypes = new ConcurrentHashMap<Integer, EntityType>();
        this.clientEntityId = -1;
        this.currentWorldSectionHeight = 16;
        this.connection = lllllllllllllIIIlllllIllIIIlIllI;
        this.playerType = lllllllllllllIIIlllllIllIIIlIIIl;
        this.entityData = (lllllllllllllIIIlllllIllIIIlIlII ? new ConcurrentHashMap<Integer, StoredEntityData>() : null);
    }
    
    @Override
    public void setCurrentWorldSectionHeight(final int lllllllllllllIIIlllllIlIllIlIIII) {
        this.currentWorldSectionHeight = lllllllllllllIIIlllllIlIllIlIIII;
    }
    
    @Override
    public EntityType entityType(final int lllllllllllllIIIlllllIlIlllllIlI) {
        return this.entityTypes.get(lllllllllllllIIIlllllIlIlllllIlI);
    }
    
    @Override
    public void removeEntity(final int lllllllllllllIIIlllllIlIlllIIlIl) {
        this.entityTypes.remove(lllllllllllllIIIlllllIlIlllIIlIl);
        if (this.entityData != null) {
            this.entityData.remove(lllllllllllllIIIlllllIlIlllIIlIl);
        }
    }
    
    @Override
    public int currentWorldSectionHeight() {
        return this.currentWorldSectionHeight;
    }
    
    public EntityTrackerBase(final UserConnection lllllllllllllIIIlllllIllIIIlllIl, final EntityType lllllllllllllIIIlllllIllIIIlllll) {
        this(lllllllllllllIIIlllllIllIIIlllIl, lllllllllllllIIIlllllIllIIIlllll, false);
    }
    
    @Override
    public void addEntity(final int lllllllllllllIIIlllllIllIIIIIlIl, final EntityType lllllllllllllIIIlllllIllIIIIIlll) {
        this.entityTypes.put(lllllllllllllIIIlllllIllIIIIIlIl, lllllllllllllIIIlllllIllIIIIIlll);
    }
    
    @Override
    public int currentMinY() {
        return this.currentMinY;
    }
}
