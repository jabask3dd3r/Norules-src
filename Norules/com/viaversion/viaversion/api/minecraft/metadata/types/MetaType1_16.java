package com.viaversion.viaversion.api.minecraft.metadata.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;

public enum MetaType1_16 implements MetaType
{
    VILLAGER_DATA(16, (Type)Type.VILLAGER_DATA), 
    ROTATION(8, (Type)Type.ROTATION);
    
    private final /* synthetic */ Type type;
    
    OPT_POSITION(10, (Type)Type.OPTIONAL_POSITION_1_14), 
    DIRECTION(11, (Type)Type.VAR_INT), 
    COMPONENT(4, (Type)Type.COMPONENT), 
    POSE(18, (Type)Type.VAR_INT), 
    OPT_UUID(12, (Type)Type.OPTIONAL_UUID), 
    FLOAT(2, (Type)Type.FLOAT), 
    POSITION(9, (Type)Type.POSITION1_14), 
    BYTE(0, (Type)Type.BYTE), 
    OPT_VAR_INT(17, (Type)Type.OPTIONAL_VAR_INT);
    
    private static final /* synthetic */ MetaType1_16[] VALUES;
    
    ITEM(6, (Type)Type.FLAT_VAR_INT_ITEM), 
    OPT_COMPONENT(5, (Type)Type.OPTIONAL_COMPONENT);
    
    private final /* synthetic */ int typeId;
    
    BLOCK_STATE(13, (Type)Type.VAR_INT), 
    BOOLEAN(7, (Type)Type.BOOLEAN), 
    STRING(3, (Type)Type.STRING), 
    PARTICLE(15, (Type)Types1_16.PARTICLE), 
    VAR_INT(1, (Type)Type.VAR_INT), 
    NBT(14, (Type)Type.NBT);
    
    private MetaType1_16(final int llllllllllllllIlIlllIllllIIIllII, final Type llllllllllllllIlIlllIllllIIIlIll) {
        this.typeId = llllllllllllllIlIlllIllllIIIllII;
        this.type = llllllllllllllIlIlllIllllIIIlIll;
    }
    
    public static MetaType1_16 byId(final int llllllllllllllIlIlllIllllIIIlIIl) {
        return MetaType1_16.VALUES[llllllllllllllIlIlllIllllIIIlIIl];
    }
    
    @Override
    public int typeId() {
        return this.typeId;
    }
    
    static {
        VALUES = values();
    }
    
    @Override
    public Type type() {
        return this.type;
    }
}
