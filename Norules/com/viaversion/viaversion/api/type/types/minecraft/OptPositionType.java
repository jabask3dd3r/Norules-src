package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class OptPositionType extends Type<Position>
{
    @Override
    public Position read(final ByteBuf lllllllllllllIIIIlIllIlIllIIIlII) throws Exception {
        final boolean lllllllllllllIIIIlIllIlIllIIIlIl = lllllllllllllIIIIlIllIlIllIIIlII.readBoolean();
        if (!lllllllllllllIIIIlIllIlIllIIIlIl) {
            return null;
        }
        return Type.POSITION.read(lllllllllllllIIIIlIllIlIllIIIlII);
    }
    
    public OptPositionType() {
        super(Position.class);
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIIlIllIlIlIllllll, final Position lllllllllllllIIIIlIllIlIlIlllllI) throws Exception {
        lllllllllllllIIIIlIllIlIlIllllll.writeBoolean(lllllllllllllIIIIlIllIlIlIlllllI != null);
        if (lllllllllllllIIIIlIllIlIlIlllllI != null) {
            Type.POSITION.write(lllllllllllllIIIIlIllIlIlIllllll, lllllllllllllIIIIlIllIlIlIlllllI);
        }
    }
}
