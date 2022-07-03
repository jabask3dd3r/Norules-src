package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.google.common.base.*;

public final class MetaListType extends ModernMetaListType
{
    private final /* synthetic */ Type<Metadata> type;
    
    @Override
    protected Type<Metadata> getType() {
        return this.type;
    }
    
    public MetaListType(final Type<Metadata> llllllllllllllllIlIIIIIIlIlIIlII) {
        Preconditions.checkNotNull((Object)llllllllllllllllIlIIIIIIlIlIIlII);
        this.type = llllllllllllllllIlIIIIIIlIlIIlII;
    }
}
