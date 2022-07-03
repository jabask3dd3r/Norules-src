package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;

public class OptPosition1_14Type extends Type<Position>
{
    @Override
    public void write(final ByteBuf llllllllllllllIlIIIIIlllIIlIIllI, final Position llllllllllllllIlIIIIIlllIIlIIlIl) throws Exception {
        llllllllllllllIlIIIIIlllIIlIIllI.writeBoolean(llllllllllllllIlIIIIIlllIIlIIlIl != null);
        if (llllllllllllllIlIIIIIlllIIlIIlIl != null) {
            Type.POSITION1_14.write(llllllllllllllIlIIIIIlllIIlIIllI, llllllllllllllIlIIIIIlllIIlIIlIl);
        }
    }
    
    @Override
    public Position read(final ByteBuf llllllllllllllIlIIIIIlllIIlIllIl) throws Exception {
        final boolean llllllllllllllIlIIIIIlllIIlIllII = llllllllllllllIlIIIIIlllIIlIllIl.readBoolean();
        if (!llllllllllllllIlIIIIIlllIIlIllII) {
            return null;
        }
        return Type.POSITION1_14.read(llllllllllllllIlIIIIIlllIIlIllIl);
    }
    
    public OptPosition1_14Type() {
        super(Position.class);
    }
}
