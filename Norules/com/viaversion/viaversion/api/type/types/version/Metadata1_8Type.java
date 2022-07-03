package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.types.minecraft.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public class Metadata1_8Type extends MetaTypeTemplate
{
    @Override
    public Metadata read(final ByteBuf lllllllllllllIIlIlIIllllIllllIlI) throws Exception {
        final byte lllllllllllllIIlIlIIllllIllllllI = lllllllllllllIIlIlIIllllIllllIlI.readByte();
        if (lllllllllllllIIlIlIIllllIllllllI == 127) {
            return null;
        }
        final int lllllllllllllIIlIlIIllllIlllllIl = (lllllllllllllIIlIlIIllllIllllllI & 0xE0) >> 5;
        final MetaType1_8 lllllllllllllIIlIlIIllllIlllllII = MetaType1_8.byId(lllllllllllllIIlIlIIllllIlllllIl);
        final int lllllllllllllIIlIlIIllllIllllIll = lllllllllllllIIlIlIIllllIllllllI & 0x1F;
        return new Metadata(lllllllllllllIIlIlIIllllIllllIll, lllllllllllllIIlIlIIllllIlllllII, lllllllllllllIIlIlIIllllIlllllII.type().read(lllllllllllllIIlIlIIllllIllllIlI));
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIlIlIIllllIlllIIIl, final Metadata lllllllllllllIIlIlIIllllIllIllIl) throws Exception {
        final byte lllllllllllllIIlIlIIllllIllIllll = (byte)(lllllllllllllIIlIlIIllllIllIllIl.metaType().typeId() << 5 | (lllllllllllllIIlIlIIllllIllIllIl.id() & 0x1F));
        lllllllllllllIIlIlIIllllIlllIIIl.writeByte((int)lllllllllllllIIlIlIIllllIllIllll);
        lllllllllllllIIlIlIIllllIllIllIl.metaType().type().write(lllllllllllllIIlIlIIllllIlllIIIl, lllllllllllllIIlIlIIllllIllIllIl.getValue());
    }
}
