package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import io.netty.buffer.*;

public class UUIDType extends Type<UUID>
{
    @Override
    public void write(final ByteBuf lllllllllllllIlllllIlllllIllllll, final UUID lllllllllllllIlllllIlllllIlllllI) {
        lllllllllllllIlllllIlllllIllllll.writeLong(lllllllllllllIlllllIlllllIlllllI.getMostSignificantBits());
        lllllllllllllIlllllIlllllIllllll.writeLong(lllllllllllllIlllllIlllllIlllllI.getLeastSignificantBits());
    }
    
    @Override
    public UUID read(final ByteBuf lllllllllllllIlllllIllllllIIIIll) {
        return new UUID(lllllllllllllIlllllIllllllIIIIll.readLong(), lllllllllllllIlllllIllllllIIIIll.readLong());
    }
    
    public UUIDType() {
        super(UUID.class);
    }
}
