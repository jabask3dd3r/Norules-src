package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public abstract class ModernMetaType extends MetaTypeTemplate
{
    protected abstract MetaType getType(final int p0);
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIlllIIIIIlIlIllll, final Metadata lllllllllllllIlIlllIIIIIlIllIIII) throws Exception {
        if (lllllllllllllIlIlllIIIIIlIllIIII == null) {
            lllllllllllllIlIlllIIIIIlIlIllll.writeByte(255);
        }
        else {
            lllllllllllllIlIlllIIIIIlIlIllll.writeByte(lllllllllllllIlIlllIIIIIlIllIIII.id());
            final MetaType lllllllllllllIlIlllIIIIIlIllIIll = lllllllllllllIlIlllIIIIIlIllIIII.metaType();
            lllllllllllllIlIlllIIIIIlIlIllll.writeByte(lllllllllllllIlIlllIIIIIlIllIIll.typeId());
            lllllllllllllIlIlllIIIIIlIllIIll.type().write(lllllllllllllIlIlllIIIIIlIlIllll, lllllllllllllIlIlllIIIIIlIllIIII.getValue());
        }
    }
    
    @Override
    public Metadata read(final ByteBuf lllllllllllllIlIlllIIIIIlIlllIIl) throws Exception {
        final short lllllllllllllIlIlllIIIIIlIllllII = lllllllllllllIlIlllIIIIIlIlllIIl.readUnsignedByte();
        if (lllllllllllllIlIlllIIIIIlIllllII == 255) {
            return null;
        }
        final MetaType lllllllllllllIlIlllIIIIIlIlllIll = this.getType(lllllllllllllIlIlllIIIIIlIlllIIl.readByte());
        return new Metadata(lllllllllllllIlIlllIIIIIlIllllII, lllllllllllllIlIlllIIIIIlIlllIll, lllllllllllllIlIlllIIIIIlIlllIll.type().read(lllllllllllllIlIlllIIIIIlIlllIIl));
    }
}
