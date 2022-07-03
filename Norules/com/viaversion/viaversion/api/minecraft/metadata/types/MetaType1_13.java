package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;

public enum MetaType1_13 implements MetaType
{
    Position(9, (Type)Type.POSITION), 
    BlockID(13, (Type)Type.VAR_INT), 
    String(3, (Type)Type.STRING), 
    OptUUID(12, (Type)Type.OPTIONAL_UUID), 
    Boolean(7, (Type)Type.BOOLEAN), 
    VarInt(1, (Type)Type.VAR_INT), 
    Chat(4, (Type)Type.COMPONENT), 
    Slot(6, (Type)Type.FLAT_ITEM), 
    Direction(11, (Type)Type.VAR_INT), 
    OptPosition(10, (Type)Type.OPTIONAL_POSITION), 
    OptChat(5, (Type)Type.OPTIONAL_COMPONENT), 
    NBTTag(14, (Type)Type.NBT), 
    PARTICLE(15, (Type)Types1_13.PARTICLE), 
    Vector3F(8, (Type)Type.ROTATION), 
    Float(2, (Type)Type.FLOAT), 
    Byte(0, (Type)Type.BYTE);
    
    private final /* synthetic */ int typeID;
    private final /* synthetic */ Type type;
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    private MetaType1_13(final int lIIIlIlIIlIIlI, final Type lIIIlIlIIlIllI) {
        this.typeID = lIIIlIlIIlIIlI;
        this.type = lIIIlIlIIlIllI;
    }
    
    public static MetaType1_13 byId(final int lIIIlIlIIIlllI) {
        return values()[lIIIlIlIIIlllI];
    }
    
    @Override
    public Type type() {
        return this.type;
    }
}
