package com.viaversion.viaversion.rewriter.meta;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;

public class MetaHandlerEventImpl implements MetaHandlerEvent
{
    private final /* synthetic */ UserConnection connection;
    private final /* synthetic */ List<Metadata> metadataList;
    private final /* synthetic */ EntityType entityType;
    private final /* synthetic */ int entityId;
    private final /* synthetic */ Metadata meta;
    private /* synthetic */ List<Metadata> extraData;
    private /* synthetic */ boolean cancel;
    
    @Override
    public int entityId() {
        return this.entityId;
    }
    
    @Override
    public Metadata metaAtIndex(final int lllllllllllllIIllIlllllIlIllIlll) {
        for (final Metadata lllllllllllllIIllIlllllIlIlllIll : this.metadataList) {
            if (lllllllllllllIIllIlllllIlIllIlll == lllllllllllllIIllIlllllIlIlllIll.id()) {
                return lllllllllllllIIllIlllllIlIlllIll;
            }
        }
        return null;
    }
    
    @Override
    public List<Metadata> metadataList() {
        return Collections.unmodifiableList((List<? extends Metadata>)this.metadataList);
    }
    
    @Override
    public UserConnection user() {
        return this.connection;
    }
    
    @Override
    public void createExtraMeta(final Metadata lllllllllllllIIllIlllllIlIlIlIll) {
        ((this.extraData != null) ? this.extraData : (this.extraData = new ArrayList<Metadata>())).add(lllllllllllllIIllIlllllIlIlIlIll);
    }
    
    @Override
    public void cancel() {
        this.cancel = true;
    }
    
    @Override
    public EntityType entityType() {
        return this.entityType;
    }
    
    @Override
    public boolean cancelled() {
        return this.cancel;
    }
    
    public MetaHandlerEventImpl(final UserConnection lllllllllllllIIllIlllllIllIlIllI, final EntityType lllllllllllllIIllIlllllIllIlIlIl, final int lllllllllllllIIllIlllllIllIllIlI, final Metadata lllllllllllllIIllIlllllIllIllIIl, final List<Metadata> lllllllllllllIIllIlllllIllIlIIlI) {
        this.connection = lllllllllllllIIllIlllllIllIlIllI;
        this.entityType = lllllllllllllIIllIlllllIllIlIlIl;
        this.entityId = lllllllllllllIIllIlllllIllIllIlI;
        this.meta = lllllllllllllIIllIlllllIllIllIIl;
        this.metadataList = lllllllllllllIIllIlllllIllIlIIlI;
    }
    
    @Override
    public Metadata meta() {
        return this.meta;
    }
    
    @Override
    public List<Metadata> extraMeta() {
        return this.extraData;
    }
}
