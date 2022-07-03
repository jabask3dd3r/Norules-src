package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public abstract class BaseItemType extends Type<Item>
{
    protected BaseItemType(final String lllllllllllllIlIIIIlllIIIlIIIlll) {
        super(lllllllllllllIlIIIIlllIIIlIIIlll, Item.class);
    }
    
    protected BaseItemType() {
        super(Item.class);
    }
    
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseItemType.class;
    }
}
