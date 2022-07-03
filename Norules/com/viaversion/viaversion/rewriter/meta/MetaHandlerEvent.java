package com.viaversion.viaversion.rewriter.meta;

import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;

public interface MetaHandlerEvent
{
    EntityType entityType();
    
    Metadata meta();
    
    default void setIndex(final int llllllllllllllIIIIIIlIlIIlIIlIII) {
        this.meta().setId(llllllllllllllIIIIIIlIlIIlIIlIII);
    }
    
    boolean cancelled();
    
    default int index() {
        return this.meta().id();
    }
    
    Metadata metaAtIndex(final int p0);
    
    List<Metadata> extraMeta();
    
    void cancel();
    
    List<Metadata> metadataList();
    
    void createExtraMeta(final Metadata p0);
    
    int entityId();
    
    UserConnection user();
}
