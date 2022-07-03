package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class RemainingBytesType extends Type<byte[]>
{
    @Override
    public void write(final ByteBuf lllllllllllllIllIIIlllIIIlIllIIl, final byte[] lllllllllllllIllIIIlllIIIlIllIII) {
        lllllllllllllIllIIIlllIIIlIllIIl.writeBytes(lllllllllllllIllIIIlllIIIlIllIII);
    }
    
    public RemainingBytesType() {
        super(byte[].class);
    }
    
    @Override
    public byte[] read(final ByteBuf lllllllllllllIllIIIlllIIIllIIIII) {
        final byte[] lllllllllllllIllIIIlllIIIllIIIIl = new byte[lllllllllllllIllIIIlllIIIllIIIII.readableBytes()];
        lllllllllllllIllIIIlllIIIllIIIII.readBytes(lllllllllllllIllIIIlllIIIllIIIIl);
        return lllllllllllllIllIIIlllIIIllIIIIl;
    }
}
