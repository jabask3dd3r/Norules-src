package com.viaversion.viaversion.api.minecraft.metadata;

import com.google.common.base.*;
import java.util.*;

public final class Metadata
{
    private /* synthetic */ Object value;
    private /* synthetic */ int id;
    private /* synthetic */ MetaType metaType;
    
    private Object checkValue(final MetaType llllllllllllllIlIIlIlIllIIllIIlI, final Object llllllllllllllIlIIlIlIllIIllIIll) {
        Preconditions.checkNotNull((Object)llllllllllllllIlIIlIlIllIIllIIlI);
        if (llllllllllllllIlIIlIlIllIIllIIll != null && !llllllllllllllIlIIlIlIllIIllIIlI.type().getOutputClass().isAssignableFrom(llllllllllllllIlIIlIlIllIIllIIll.getClass())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Metadata value and metaType are incompatible. Type=").append(llllllllllllllIlIIlIlIllIIllIIlI).append(", value=").append((llllllllllllllIlIIlIlIllIIllIIll != null) ? String.valueOf(new StringBuilder().append(llllllllllllllIlIIlIlIllIIllIIll).append(" (").append(llllllllllllllIlIIlIlIllIIllIIll.getClass().getSimpleName()).append(")")) : "null")));
        }
        return llllllllllllllIlIIlIlIllIIllIIll;
    }
    
    @Deprecated
    public void setMetaTypeUnsafe(final MetaType llllllllllllllIlIIlIlIllIIlIllIl) {
        this.metaType = llllllllllllllIlIIlIlIllIIlIllIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIlIlIllIIlIIllI) {
        if (this == llllllllllllllIlIIlIlIllIIlIIllI) {
            return true;
        }
        if (llllllllllllllIlIIlIlIllIIlIIllI == null || this.getClass() != llllllllllllllIlIIlIlIllIIlIIllI.getClass()) {
            return false;
        }
        final Metadata llllllllllllllIlIIlIlIllIIlIIlIl = (Metadata)llllllllllllllIlIIlIlIllIIlIIllI;
        return this.id == llllllllllllllIlIIlIlIllIIlIIlIl.id && this.metaType == this.metaType && Objects.equals(this.value, llllllllllllllIlIIlIlIllIIlIIlIl.value);
    }
    
    public void setMetaType(final MetaType llllllllllllllIlIIlIlIllIlIIllll) {
        this.checkValue(llllllllllllllIlIIlIlIllIlIIllll, this.value);
        this.metaType = llllllllllllllIlIIlIlIllIlIIllll;
    }
    
    public void setValue(final Object llllllllllllllIlIIlIlIllIlIIIIIl) {
        this.value = this.checkValue(this.metaType, llllllllllllllIlIIlIlIllIlIIIIIl);
    }
    
    public Metadata(final int llllllllllllllIlIIlIlIllIllIIlIl, final MetaType llllllllllllllIlIIlIlIllIllIIlII, final Object llllllllllllllIlIIlIlIllIllIIIll) {
        this.id = llllllllllllllIlIIlIlIllIllIIlIl;
        this.metaType = llllllllllllllIlIIlIlIllIllIIlII;
        this.value = this.checkValue(llllllllllllllIlIIlIlIllIllIIlII, llllllllllllllIlIIlIlIllIllIIIll);
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public <T> T value() {
        return (T)this.value;
    }
    
    public void setId(final int llllllllllllllIlIIlIlIllIlIllIII) {
        this.id = llllllllllllllIlIIlIlIllIlIllIII;
    }
    
    public int id() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Metadata{id=").append(this.id).append(", metaType=").append(this.metaType).append(", value=").append(this.value).append('}'));
    }
    
    public void setTypeAndValue(final MetaType llllllllllllllIlIIlIlIllIIlllIIl, final Object llllllllllllllIlIIlIlIllIIlllIII) {
        this.value = this.checkValue(llllllllllllllIlIIlIlIllIIlllIIl, llllllllllllllIlIIlIlIllIIlllIII);
        this.metaType = llllllllllllllIlIIlIlIllIIlllIIl;
    }
    
    public MetaType metaType() {
        return this.metaType;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIIlIlIllIIIllllI = this.id;
        llllllllllllllIlIIlIlIllIIIllllI = 31 * llllllllllllllIlIIlIlIllIIIllllI + this.metaType.hashCode();
        llllllllllllllIlIIlIlIllIIIllllI = 31 * llllllllllllllIlIIlIlIllIIIllllI + ((this.value != null) ? this.value.hashCode() : 0);
        return llllllllllllllIlIIlIlIllIIIllllI;
    }
}
