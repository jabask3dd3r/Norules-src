package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class VillagerDataType extends Type<VillagerData>
{
    @Override
    public VillagerData read(final ByteBuf lIIlIllIIllIlI) throws Exception {
        return new VillagerData(Type.VAR_INT.readPrimitive(lIIlIllIIllIlI), Type.VAR_INT.readPrimitive(lIIlIllIIllIlI), Type.VAR_INT.readPrimitive(lIIlIllIIllIlI));
    }
    
    @Override
    public void write(final ByteBuf lIIlIllIIlIlII, final VillagerData lIIlIllIIIllll) throws Exception {
        Type.VAR_INT.writePrimitive(lIIlIllIIlIlII, lIIlIllIIIllll.getType());
        Type.VAR_INT.writePrimitive(lIIlIllIIlIlII, lIIlIllIIIllll.getProfession());
        Type.VAR_INT.writePrimitive(lIIlIllIIlIlII, lIIlIllIIIllll.getLevel());
    }
    
    public VillagerDataType() {
        super(VillagerData.class);
    }
}
