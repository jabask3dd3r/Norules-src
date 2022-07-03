package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import io.netty.buffer.*;

public class OptUUIDType extends Type<UUID>
{
    @Override
    public void write(final ByteBuf lllllllllllllIIIlIIllIIllIlllIll, final UUID lllllllllllllIIIlIIllIIllIlllIII) {
        if (lllllllllllllIIIlIIllIIllIlllIII == null) {
            lllllllllllllIIIlIIllIIllIlllIll.writeBoolean(false);
        }
        else {
            lllllllllllllIIIlIIllIIllIlllIll.writeBoolean(true);
            lllllllllllllIIIlIIllIIllIlllIll.writeLong(lllllllllllllIIIlIIllIIllIlllIII.getMostSignificantBits());
            lllllllllllllIIIlIIllIIllIlllIll.writeLong(lllllllllllllIIIlIIllIIllIlllIII.getLeastSignificantBits());
        }
    }
    
    @Override
    public UUID read(final ByteBuf lllllllllllllIIIlIIllIIlllIIIIlI) {
        final boolean lllllllllllllIIIlIIllIIlllIIIIIl = lllllllllllllIIIlIIllIIlllIIIIlI.readBoolean();
        if (!lllllllllllllIIIlIIllIIlllIIIIIl) {
            return null;
        }
        return new UUID(lllllllllllllIIIlIIllIIlllIIIIlI.readLong(), lllllllllllllIIIlIIllIIlllIIIIlI.readLong());
    }
    
    public OptUUIDType() {
        super(UUID.class);
    }
}
