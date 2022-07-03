package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class ShortByteArrayType extends Type<byte[]>
{
    public ShortByteArrayType() {
        super(byte[].class);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIllIllIIIIllIIIlIll, final byte[] lllllllllllllIllIllIIIIllIIIlIlI) throws Exception {
        lllllllllllllIllIllIIIIllIIIlIll.writeShort(lllllllllllllIllIllIIIIllIIIlIlI.length);
        lllllllllllllIllIllIIIIllIIIlIll.writeBytes(lllllllllllllIllIllIIIIllIIIlIlI);
    }
    
    @Override
    public byte[] read(final ByteBuf lllllllllllllIllIllIIIIllIIIIIlI) throws Exception {
        final byte[] lllllllllllllIllIllIIIIllIIIIIll = new byte[lllllllllllllIllIllIIIIllIIIIIlI.readShort()];
        lllllllllllllIllIllIIIIllIIIIIlI.readBytes(lllllllllllllIllIllIIIIllIIIIIll);
        return lllllllllllllIllIllIIIIllIIIIIll;
    }
}
