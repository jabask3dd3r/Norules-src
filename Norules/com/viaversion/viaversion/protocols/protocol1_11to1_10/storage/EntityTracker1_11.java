package com.viaversion.viaversion.protocols.protocol1_11to1_10.storage;

import com.viaversion.viaversion.data.entity.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.google.common.collect.*;

public class EntityTracker1_11 extends EntityTrackerBase
{
    private final /* synthetic */ Set<Integer> holograms;
    
    public boolean isHologram(final int llllllllllllllllllllllllllIIIlll) {
        return this.holograms.contains(llllllllllllllllllllllllllIIIlll);
    }
    
    public void removeHologram(final int llllllllllllllllllllllllllIIIIll) {
        this.holograms.remove(llllllllllllllllllllllllllIIIIll);
    }
    
    public void addHologram(final int llllllllllllllllllllllllllIIllIl) {
        this.holograms.add(llllllllllllllllllllllllllIIllIl);
    }
    
    public EntityTracker1_11(final UserConnection llllllllllllllllllllllllllIllIIl) {
        super(llllllllllllllllllllllllllIllIIl, Entity1_11Types.EntityType.PLAYER);
        this.holograms = (Set<Integer>)Sets.newConcurrentHashSet();
    }
    
    @Override
    public void removeEntity(final int llllllllllllllllllllllllllIlIIll) {
        super.removeEntity(llllllllllllllllllllllllllIlIIll);
        if (this.isHologram(llllllllllllllllllllllllllIlIIll)) {
            this.removeHologram(llllllllllllllllllllllllllIlIIll);
        }
    }
}
