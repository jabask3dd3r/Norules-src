package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class CustomByteType extends PartialType<byte[], Integer>
{
    public CustomByteType(final Integer llllllllllllllIIlllIlIllllllIIIl) {
        super(llllllllllllllIIlllIlIllllllIIIl, byte[].class);
    }
    
    @Override
    public byte[] read(final ByteBuf llllllllllllllIIlllIlIlllllIllII, final Integer llllllllllllllIIlllIlIlllllIlIII) throws Exception {
        if (llllllllllllllIIlllIlIlllllIllII.readableBytes() < llllllllllllllIIlllIlIlllllIlIII) {
            throw new RuntimeException("Readable bytes does not match expected!");
        }
        final byte[] llllllllllllllIIlllIlIlllllIlIlI = new byte[(int)llllllllllllllIIlllIlIlllllIlIII];
        llllllllllllllIIlllIlIlllllIllII.readBytes(llllllllllllllIIlllIlIlllllIlIlI);
        return llllllllllllllIIlllIlIlllllIlIlI;
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIlllIlIlllllIIIII, final Integer llllllllllllllIIlllIlIlllllIIIlI, final byte[] llllllllllllllIIlllIlIllllIlllll) throws Exception {
        llllllllllllllIIlllIlIlllllIIIII.writeBytes(llllllllllllllIIlllIlIllllIlllll);
    }
}
