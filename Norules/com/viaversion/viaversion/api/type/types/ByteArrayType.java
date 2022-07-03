package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.google.common.base.*;

public class ByteArrayType extends Type<byte[]>
{
    public ByteArrayType() {
        super(byte[].class);
    }
    
    @Override
    public byte[] read(final ByteBuf lllllllllllllIIIIIlllIlIlIIIlllI) throws Exception {
        final int lllllllllllllIIIIIlllIlIlIIIllIl = Type.VAR_INT.readPrimitive(lllllllllllllIIIIIlllIlIlIIIlllI);
        Preconditions.checkArgument(lllllllllllllIIIIIlllIlIlIIIlllI.isReadable(lllllllllllllIIIIIlllIlIlIIIllIl), (Object)"Length is fewer than readable bytes");
        final byte[] lllllllllllllIIIIIlllIlIlIIIllII = new byte[lllllllllllllIIIIIlllIlIlIIIllIl];
        lllllllllllllIIIIIlllIlIlIIIlllI.readBytes(lllllllllllllIIIIIlllIlIlIIIllII);
        return lllllllllllllIIIIIlllIlIlIIIllII;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIIIlllIlIlIIlIlII, final byte[] lllllllllllllIIIIIlllIlIlIIlIlIl) throws Exception {
        Type.VAR_INT.writePrimitive(lllllllllllllIIIIIlllIlIlIIlIlII, lllllllllllllIIIIIlllIlIlIIlIlIl.length);
        lllllllllllllIIIIIlllIlIlIIlIlII.writeBytes(lllllllllllllIIIIIlllIlIlIIlIlIl);
    }
}
