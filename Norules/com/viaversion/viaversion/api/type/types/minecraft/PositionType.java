package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class PositionType extends Type<Position>
{
    @Override
    public Position read(final ByteBuf llllllllllllllIIlllIIllIIIllllll) {
        final long llllllllllllllIIlllIIllIIlIIIIll = llllllllllllllIIlllIIllIIIllllll.readLong();
        final long llllllllllllllIIlllIIllIIlIIIIlI = llllllllllllllIIlllIIllIIlIIIIll >> 38;
        final long llllllllllllllIIlllIIllIIlIIIIIl = llllllllllllllIIlllIIllIIlIIIIll >> 26 & 0xFFFL;
        final long llllllllllllllIIlllIIllIIlIIIIII = llllllllllllllIIlllIIllIIlIIIIll << 38 >> 38;
        return new Position((int)llllllllllllllIIlllIIllIIlIIIIlI, (short)llllllllllllllIIlllIIllIIlIIIIIl, (int)llllllllllllllIIlllIIllIIlIIIIII);
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIlllIIllIIIllIlIl, final Position llllllllllllllIIlllIIllIIIllIlII) {
        llllllllllllllIIlllIIllIIIllIlIl.writeLong(((long)llllllllllllllIIlllIIllIIIllIlII.getX() & 0x3FFFFFFL) << 38 | ((long)llllllllllllllIIlllIIllIIIllIlII.getY() & 0xFFFL) << 26 | (long)(llllllllllllllIIlllIIllIIIllIlII.getZ() & 0x3FFFFFF));
    }
    
    public PositionType() {
        super(Position.class);
    }
}
