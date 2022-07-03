package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;

public enum MetaType1_13_2 implements MetaType
{
    String(3, (Type)Type.STRING), 
    PARTICLE(15, (Type)Types1_13_2.PARTICLE), 
    Float(2, (Type)Type.FLOAT), 
    Slot(6, (Type)Type.FLAT_VAR_INT_ITEM);
    
    private final /* synthetic */ int typeID;
    
    BlockID(13, (Type)Type.VAR_INT), 
    OptPosition(10, (Type)Type.OPTIONAL_POSITION), 
    OptChat(5, (Type)Type.OPTIONAL_COMPONENT), 
    VarInt(1, (Type)Type.VAR_INT), 
    Position(9, (Type)Type.POSITION), 
    Vector3F(8, (Type)Type.ROTATION), 
    OptUUID(12, (Type)Type.OPTIONAL_UUID), 
    Direction(11, (Type)Type.VAR_INT), 
    Boolean(7, (Type)Type.BOOLEAN), 
    Chat(4, (Type)Type.COMPONENT), 
    NBTTag(14, (Type)Type.NBT);
    
    private final /* synthetic */ Type type;
    
    Byte(0, (Type)Type.BYTE);
    
    public static MetaType1_13_2 byId(final int lllllllllllllIIIIIlllIlIIlIlIlIl) {
        return values()[lllllllllllllIIIIIlllIlIIlIlIlIl];
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    private MetaType1_13_2(final int lllllllllllllIIIIIlllIlIIlIlllIl, final Type lllllllllllllIIIIIlllIlIIlIlIlll) {
        this.typeID = lllllllllllllIIIIIlllIlIIlIlllIl;
        this.type = lllllllllllllIIIIIlllIlIIlIlIlll;
    }
    
    @Override
    public Type type() {
        return this.type;
    }
}
