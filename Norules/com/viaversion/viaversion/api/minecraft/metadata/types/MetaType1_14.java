package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;

public enum MetaType1_14 implements MetaType
{
    Slot(6, (Type)Type.FLAT_VAR_INT_ITEM), 
    Pose(18, (Type)Type.VAR_INT), 
    OptUUID(12, (Type)Type.OPTIONAL_UUID), 
    Vector3F(8, (Type)Type.ROTATION), 
    Position(9, (Type)Type.POSITION1_14), 
    OptPosition(10, (Type)Type.OPTIONAL_POSITION_1_14), 
    PARTICLE(15, (Type)Types1_14.PARTICLE), 
    Chat(4, (Type)Type.COMPONENT), 
    Boolean(7, (Type)Type.BOOLEAN);
    
    private final /* synthetic */ int typeID;
    
    Byte(0, (Type)Type.BYTE), 
    Float(2, (Type)Type.FLOAT), 
    NBTTag(14, (Type)Type.NBT);
    
    private final /* synthetic */ Type type;
    
    BlockID(13, (Type)Type.VAR_INT), 
    String(3, (Type)Type.STRING), 
    OptChat(5, (Type)Type.OPTIONAL_COMPONENT), 
    VarInt(1, (Type)Type.VAR_INT), 
    Direction(11, (Type)Type.VAR_INT), 
    OptVarInt(17, (Type)Type.OPTIONAL_VAR_INT), 
    VillagerData(16, (Type)Type.VILLAGER_DATA);
    
    public static MetaType1_14 byId(final int lllllllllllllIIIlIlIlIlIIIllllIl) {
        return values()[lllllllllllllIIIlIlIlIlIIIllllIl];
    }
    
    private MetaType1_14(final int lllllllllllllIIIlIlIlIlIIlIIIlll, final Type lllllllllllllIIIlIlIlIlIIlIIIlIl) {
        this.typeID = lllllllllllllIIIlIlIlIlIIlIIIlll;
        this.type = lllllllllllllIIIlIlIlIlIIlIIIlIl;
    }
    
    @Override
    public Type type() {
        return this.type;
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
}
