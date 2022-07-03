package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class VectorType extends Type<Vector>
{
    public VectorType() {
        super(Vector.class);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIlIIIllllIlIllIlI, final Vector lllllllllllllIIIlIIIllllIlIllIIl) throws Exception {
        Type.INT.write(lllllllllllllIIIlIIIllllIlIllIlI, lllllllllllllIIIlIIIllllIlIllIIl.getBlockX());
        Type.INT.write(lllllllllllllIIIlIIIllllIlIllIlI, lllllllllllllIIIlIIIllllIlIllIIl.getBlockY());
        Type.INT.write(lllllllllllllIIIlIIIllllIlIllIlI, lllllllllllllIIIlIIIllllIlIllIIl.getBlockZ());
    }
    
    @Override
    public Vector read(final ByteBuf lllllllllllllIIIlIIIllllIllIIlll) throws Exception {
        final int lllllllllllllIIIlIIIllllIllIIllI = Type.INT.read(lllllllllllllIIIlIIIllllIllIIlll);
        final int lllllllllllllIIIlIIIllllIllIIlIl = Type.INT.read(lllllllllllllIIIlIIIllllIllIIlll);
        final int lllllllllllllIIIlIIIllllIllIIlII = Type.INT.read(lllllllllllllIIIlIIIllllIllIIlll);
        return new Vector(lllllllllllllIIIlIIIllllIllIIllI, lllllllllllllIIIlIIIllllIllIIlIl, lllllllllllllIIIlIIIllllIllIIlII);
    }
}
