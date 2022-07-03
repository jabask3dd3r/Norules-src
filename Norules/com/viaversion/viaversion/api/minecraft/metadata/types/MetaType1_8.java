package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;

public enum MetaType1_8 implements MetaType
{
    Byte(0, (Type)Type.BYTE), 
    Float(3, (Type)Type.FLOAT);
    
    private final /* synthetic */ Type type;
    
    Position(6, (Type)Type.VECTOR), 
    Int(2, (Type)Type.INT), 
    @Deprecated
    NonExistent(-1, (Type)Type.NOTHING), 
    Short(1, (Type)Type.SHORT), 
    String(4, (Type)Type.STRING), 
    Slot(5, (Type)Type.ITEM), 
    Rotation(7, (Type)Type.ROTATION);
    
    private final /* synthetic */ int typeID;
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    @Override
    public Type type() {
        return this.type;
    }
    
    private MetaType1_8(final int lllllllllllllIlIlllllIIIIIllIIll, final Type lllllllllllllIlIlllllIIIIIllIIlI) {
        this.typeID = lllllllllllllIlIlllllIIIIIllIIll;
        this.type = lllllllllllllIlIlllllIIIIIllIIlI;
    }
    
    public static MetaType1_8 byId(final int lllllllllllllIlIlllllIIIIIllIIII) {
        return values()[lllllllllllllIlIlllllIIIIIllIIII];
    }
}
