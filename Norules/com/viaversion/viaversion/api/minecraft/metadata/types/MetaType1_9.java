package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;

public enum MetaType1_9 implements MetaType
{
    private final /* synthetic */ Type type;
    
    BlockID(12, (Type)Type.VAR_INT), 
    Chat(4, (Type)Type.COMPONENT);
    
    private final /* synthetic */ int typeID;
    
    Slot(5, (Type)Type.ITEM), 
    Float(2, (Type)Type.FLOAT), 
    VarInt(1, (Type)Type.VAR_INT), 
    OptUUID(11, (Type)Type.OPTIONAL_UUID), 
    Direction(10, (Type)Type.VAR_INT), 
    Boolean(6, (Type)Type.BOOLEAN), 
    Byte(0, (Type)Type.BYTE), 
    String(3, (Type)Type.STRING), 
    Vector3F(7, (Type)Type.ROTATION), 
    OptPosition(9, (Type)Type.OPTIONAL_POSITION), 
    Position(8, (Type)Type.POSITION);
    
    @Override
    public Type type() {
        return this.type;
    }
    
    private MetaType1_9(final int lllllllllllllIlllllIIlIIlllllIlI, final Type lllllllllllllIlllllIIlIIlllllIIl) {
        this.typeID = lllllllllllllIlllllIIlIIlllllIlI;
        this.type = lllllllllllllIlllllIIlIIlllllIIl;
    }
    
    public static MetaType1_9 byId(final int lllllllllllllIlllllIIlIIllllIllI) {
        return values()[lllllllllllllIlllllIIlIIllllIllI];
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
}
