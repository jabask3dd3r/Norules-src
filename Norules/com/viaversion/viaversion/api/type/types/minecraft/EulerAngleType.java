package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class EulerAngleType extends Type<EulerAngle>
{
    @Override
    public void write(final ByteBuf llllllllllllllIIlIIllIIIIIIlllIl, final EulerAngle llllllllllllllIIlIIllIIIIIIlllII) throws Exception {
        Type.FLOAT.writePrimitive(llllllllllllllIIlIIllIIIIIIlllIl, llllllllllllllIIlIIllIIIIIIlllII.getX());
        Type.FLOAT.writePrimitive(llllllllllllllIIlIIllIIIIIIlllIl, llllllllllllllIIlIIllIIIIIIlllII.getY());
        Type.FLOAT.writePrimitive(llllllllllllllIIlIIllIIIIIIlllIl, llllllllllllllIIlIIllIIIIIIlllII.getZ());
    }
    
    @Override
    public EulerAngle read(final ByteBuf llllllllllllllIIlIIllIIIIIlIlIII) throws Exception {
        final float llllllllllllllIIlIIllIIIIIlIIlll = Type.FLOAT.readPrimitive(llllllllllllllIIlIIllIIIIIlIlIII);
        final float llllllllllllllIIlIIllIIIIIlIIllI = Type.FLOAT.readPrimitive(llllllllllllllIIlIIllIIIIIlIlIII);
        final float llllllllllllllIIlIIllIIIIIlIIlIl = Type.FLOAT.readPrimitive(llllllllllllllIIlIIllIIIIIlIlIII);
        return new EulerAngle(llllllllllllllIIlIIllIIIIIlIIlll, llllllllllllllIIlIIllIIIIIlIIllI, llllllllllllllIIlIIllIIIIIlIIlIl);
    }
    
    public EulerAngleType() {
        super(EulerAngle.class);
    }
}
