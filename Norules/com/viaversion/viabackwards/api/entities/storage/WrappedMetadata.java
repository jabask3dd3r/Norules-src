package com.viaversion.viabackwards.api.entities.storage;

import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public final class WrappedMetadata
{
    private final /* synthetic */ List<Metadata> metadataList;
    
    public void remove(final Metadata llllllllllllllllIIlIIllIIIIlIlIl) {
        this.metadataList.remove(llllllllllllllllIIlIIllIIIIlIlIl);
    }
    
    public boolean has(final Metadata llllllllllllllllIIlIIllIIIIlllIl) {
        return this.metadataList.contains(llllllllllllllllIIlIIllIIIIlllIl);
    }
    
    public void remove(final int llllllllllllllllIIlIIllIIIIlIIIl) {
        this.metadataList.removeIf(llllllllllllllllIIlIIlIlllllIIlI -> llllllllllllllllIIlIIlIlllllIIlI.id() == llllllllllllllllIIlIIllIIIIlIIIl);
    }
    
    public WrappedMetadata(final List<Metadata> llllllllllllllllIIlIIllIIIlIIIll) {
        this.metadataList = llllllllllllllllIIlIIllIIIlIIIll;
    }
    
    public void add(final Metadata llllllllllllllllIIlIIllIIIIIlIIl) {
        this.metadataList.add(llllllllllllllllIIlIIllIIIIIlIIl);
    }
    
    public Metadata get(final int llllllllllllllllIIlIIllIIIIIIIlI) {
        for (final Metadata llllllllllllllllIIlIIllIIIIIIlII : this.metadataList) {
            if (llllllllllllllllIIlIIllIIIIIIIlI == llllllllllllllllIIlIIllIIIIIIlII.id()) {
                return llllllllllllllllIIlIIllIIIIIIlII;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("MetaStorage{metaDataList=").append(this.metadataList).append('}'));
    }
    
    public List<Metadata> metadataList() {
        return this.metadataList;
    }
}
