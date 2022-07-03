package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.types.minecraft.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public class MetadataType extends MetaTypeTemplate
{
    @Override
    public void write(final ByteBuf llllllllllllllllllllIlllIllllIII, final Metadata llllllllllllllllllllIlllIlllIlll) throws Exception {
        final int llllllllllllllllllllIlllIllllIIl = (llllllllllllllllllllIlllIlllIlll.metaType().typeId() << 5 | (llllllllllllllllllllIlllIlllIlll.id() & 0x1F)) & 0xFF;
        llllllllllllllllllllIlllIllllIII.writeByte(llllllllllllllllllllIlllIllllIIl);
        llllllllllllllllllllIlllIlllIlll.metaType().type().write(llllllllllllllllllllIlllIllllIII, llllllllllllllllllllIlllIlllIlll.getValue());
    }
    
    @Override
    public Metadata read(final ByteBuf llllllllllllllllllllIllllIIIIlII) throws Exception {
        final byte llllllllllllllllllllIllllIIIIlIl = llllllllllllllllllllIllllIIIIlII.readByte();
        if (llllllllllllllllllllIllllIIIIlIl == 127) {
            return null;
        }
        final int llllllllllllllllllllIllllIIIlIlI = (llllllllllllllllllllIllllIIIIlIl & 0xE0) >> 5;
        final MetaType1_7_6_10 llllllllllllllllllllIllllIIIlIIl = MetaType1_7_6_10.byId(llllllllllllllllllllIllllIIIlIlI);
        final int llllllllllllllllllllIllllIIIlIII = llllllllllllllllllllIllllIIIIlIl & 0x1F;
        return new Metadata(llllllllllllllllllllIllllIIIlIII, llllllllllllllllllllIllllIIIlIIl, llllllllllllllllllllIllllIIIlIIl.type().read(llllllllllllllllllllIllllIIIIlII));
    }
}
