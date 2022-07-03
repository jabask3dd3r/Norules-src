package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class Position1_14Type extends Type<Position>
{
    @Override
    public void write(final ByteBuf llllllllllllllllllllIllIllIIlIll, final Position llllllllllllllllllllIllIllIIlIlI) {
        llllllllllllllllllllIllIllIIlIll.writeLong(((long)llllllllllllllllllllIllIllIIlIlI.getX() & 0x3FFFFFFL) << 38 | (long)(llllllllllllllllllllIllIllIIlIlI.getY() & 0xFFF) | ((long)llllllllllllllllllllIllIllIIlIlI.getZ() & 0x3FFFFFFL) << 12);
    }
    
    public Position1_14Type() {
        super(Position.class);
    }
    
    @Override
    public Position read(final ByteBuf llllllllllllllllllllIllIllIlIlIl) {
        final long llllllllllllllllllllIllIllIllIIl = llllllllllllllllllllIllIllIlIlIl.readLong();
        final long llllllllllllllllllllIllIllIllIII = llllllllllllllllllllIllIllIllIIl >> 38;
        final long llllllllllllllllllllIllIllIlIlll = llllllllllllllllllllIllIllIllIIl << 52 >> 52;
        final long llllllllllllllllllllIllIllIlIllI = llllllllllllllllllllIllIllIllIIl << 26 >> 38;
        return new Position((int)llllllllllllllllllllIllIllIllIII, (int)llllllllllllllllllllIllIllIlIlll, (int)llllllllllllllllllllIllIllIlIllI);
    }
}
