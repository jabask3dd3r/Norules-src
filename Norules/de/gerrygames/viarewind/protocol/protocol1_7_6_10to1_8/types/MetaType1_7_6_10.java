package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;

public enum MetaType1_7_6_10 implements MetaType
{
    String(4, (Type)Type.STRING), 
    Int(2, (Type)Type.INT), 
    Position(6, (Type)Type.VECTOR), 
    Float(3, (Type)Type.FLOAT), 
    NonExistent(-1, (Type)Type.NOTHING), 
    Byte(0, (Type)Type.BYTE), 
    Slot(5, (Type)Types1_7_6_10.COMPRESSED_NBT_ITEM);
    
    private final /* synthetic */ Type type;
    private final /* synthetic */ int typeID;
    
    Short(1, (Type)Type.SHORT);
    
    @Override
    public Type type() {
        return this.type;
    }
    
    @Override
    public int typeId() {
        return this.typeID;
    }
    
    public static MetaType1_7_6_10 byId(final int lllllllllllllllIllIIlllllIlllIlI) {
        return values()[lllllllllllllllIllIIlllllIlllIlI];
    }
    
    private MetaType1_7_6_10(final int lllllllllllllllIllIIlllllIllIIlI, final Type lllllllllllllllIllIIlllllIllIIIl) {
        this.typeID = lllllllllllllllIllIIlllllIllIIlI;
        this.type = lllllllllllllllIllIIlllllIllIIIl;
    }
}
