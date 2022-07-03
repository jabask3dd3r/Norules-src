package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;

public enum MetaType1_12 implements MetaType
{
    Slot(5, (Type)Type.ITEM), 
    Byte(0, (Type)Type.BYTE), 
    Direction(10, (Type)Type.VAR_INT), 
    OptUUID(11, (Type)Type.OPTIONAL_UUID), 
    Vector3F(7, (Type)Type.ROTATION), 
    Chat(4, (Type)Type.COMPONENT), 
    OptPosition(9, (Type)Type.OPTIONAL_POSITION), 
    Boolean(6, (Type)Type.BOOLEAN), 
    String(3, (Type)Type.STRING);
    
    private final /* synthetic */ int typeID;
    
    NBTTag(13, (Type)Type.NBT), 
    Float(2, (Type)Type.FLOAT), 
    BlockID(12, (Type)Type.VAR_INT), 
    Position(8, (Type)Type.POSITION), 
    VarInt(1, (Type)Type.VAR_INT);
    
    private final /* synthetic */ Type type;
    
    private MetaType1_12(final int lllllllllllllllllIlllllIlIIIlllI, final Type lllllllllllllllllIlllllIlIIlIIlI) {
        this.typeID = lllllllllllllllllIlllllIlIIIlllI;
        this.type = lllllllllllllllllIlllllIlIIlIIlI;
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    @Override
    public Type type() {
        return this.type;
    }
    
    public static MetaType1_12 byId(final int lllllllllllllllllIlllllIlIIIlIll) {
        return values()[lllllllllllllllllIlllllIlIIIlIll];
    }
}
