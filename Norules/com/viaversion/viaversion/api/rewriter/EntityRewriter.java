package com.viaversion.viaversion.api.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.data.entity.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public interface EntityRewriter<T extends Protocol> extends Rewriter<T>
{
    default <E extends EntityTracker> E tracker(final UserConnection lllllllllllllllIllIIIIIIIlIllIII) {
        return lllllllllllllllIllIIIIIIIlIllIII.getEntityTracker((Class<? extends Protocol>)this.protocol().getClass());
    }
    
    void handleMetadata(final int p0, final List<Metadata> p1, final UserConnection p2);
    
    default EntityType objectTypeFromId(final int lllllllllllllllIllIIIIIIIlIllllI) {
        return this.typeFromId(lllllllllllllllIllIIIIIIIlIllllI);
    }
    
    int newEntityId(final int p0);
    
    EntityType typeFromId(final int p0);
}
