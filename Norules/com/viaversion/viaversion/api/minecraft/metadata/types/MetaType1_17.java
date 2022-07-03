package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;

public enum MetaType1_17 implements MetaType
{
    OPT_COMPONENT(5, (Type)Type.OPTIONAL_COMPONENT), 
    BOOLEAN(7, (Type)Type.BOOLEAN);
    
    private static final /* synthetic */ MetaType1_17[] VALUES;
    
    DIRECTION(11, (Type)Type.VAR_INT), 
    FLOAT(2, (Type)Type.FLOAT), 
    ROTATION(8, (Type)Type.ROTATION), 
    ITEM(6, (Type)Type.FLAT_VAR_INT_ITEM), 
    OPT_VAR_INT(17, (Type)Type.OPTIONAL_VAR_INT), 
    BYTE(0, (Type)Type.BYTE), 
    COMPONENT(4, (Type)Type.COMPONENT), 
    NBT(14, (Type)Type.NBT), 
    OPT_POSITION(10, (Type)Type.OPTIONAL_POSITION_1_14), 
    OPT_UUID(12, (Type)Type.OPTIONAL_UUID), 
    POSE(18, (Type)Type.VAR_INT), 
    PARTICLE(15, (Type)Types1_17.PARTICLE);
    
    private final /* synthetic */ int typeId;
    
    POSITION(9, (Type)Type.POSITION1_14), 
    VAR_INT(1, (Type)Type.VAR_INT), 
    VILLAGER_DATA(16, (Type)Type.VILLAGER_DATA), 
    STRING(3, (Type)Type.STRING);
    
    private final /* synthetic */ Type type;
    
    BLOCK_STATE(13, (Type)Type.VAR_INT);
    
    static {
        VALUES = values();
    }
    
    @Override
    public int typeId() {
        return this.typeId;
    }
    
    private MetaType1_17(final int lllllllllllllIlIIllIIIlllIIlIIll, final Type lllllllllllllIlIIllIIIlllIIIllIl) {
        this.typeId = lllllllllllllIlIIllIIIlllIIlIIll;
        this.type = lllllllllllllIlIIllIIIlllIIIllIl;
    }
    
    public static MetaType1_17 byId(final int lllllllllllllIlIIllIIIlllIIIlIll) {
        return MetaType1_17.VALUES[lllllllllllllIlIIllIIIlllIIIlIll];
    }
    
    @Override
    public Type type() {
        return this.type;
    }
}
