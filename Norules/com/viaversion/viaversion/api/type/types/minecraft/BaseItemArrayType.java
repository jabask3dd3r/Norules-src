package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public abstract class BaseItemArrayType extends Type<Item[]>
{
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseItemArrayType.class;
    }
    
    protected BaseItemArrayType(final String lllllllllllllIlIIlIIlIIlllIIlIII) {
        super(lllllllllllllIlIIlIIlIIlllIIlIII, Item[].class);
    }
    
    protected BaseItemArrayType() {
        super(Item[].class);
    }
}
