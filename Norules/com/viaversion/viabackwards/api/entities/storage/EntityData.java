package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;

public class EntityData
{
    private final /* synthetic */ int id;
    private /* synthetic */ MetaCreator defaultMeta;
    private /* synthetic */ Object mobName;
    private final /* synthetic */ int replacementId;
    
    public EntityData spawnMetadata(final MetaCreator llllllllllllllIIIllIllIlIllIIIlI) {
        this.defaultMeta = llllllllllllllIIIllIllIlIllIIIlI;
        return this;
    }
    
    public EntityData jsonName(final String llllllllllllllIIIllIllIlIlllIIII) {
        this.mobName = ChatRewriter.legacyTextToJson(llllllllllllllIIIllIllIlIlllIIII);
        return this;
    }
    
    public MetaCreator defaultMeta() {
        return this.defaultMeta;
    }
    
    public int replacementId() {
        return this.replacementId;
    }
    
    public Object mobName() {
        return this.mobName;
    }
    
    public int typeId() {
        return this.id;
    }
    
    public boolean hasBaseMeta() {
        return this.defaultMeta != null;
    }
    
    public EntityData mobName(final String llllllllllllllIIIllIllIlIllIlIlI) {
        this.mobName = llllllllllllllIIIllIllIlIllIlIlI;
        return this;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("EntityData{id=").append(this.id).append(", mobName='").append(this.mobName).append('\'').append(", replacementId=").append(this.replacementId).append(", defaultMeta=").append(this.defaultMeta).append('}'));
    }
    
    public EntityData(final int llllllllllllllIIIllIllIlIlllIlIl, final int llllllllllllllIIIllIllIlIlllIlll) {
        this.id = llllllllllllllIIIllIllIlIlllIlIl;
        this.replacementId = llllllllllllllIIIllIllIlIlllIlll;
    }
    
    public boolean isObjectType() {
        return false;
    }
    
    public int objectData() {
        return -1;
    }
    
    @FunctionalInterface
    public interface MetaCreator
    {
        void createMeta(final WrappedMetadata p0);
    }
}
