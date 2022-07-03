package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.types.minecraft.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import io.netty.buffer.*;

public class MetadataList1_8Type extends AbstractMetaListType
{
    @Override
    protected Type<Metadata> getType() {
        return Types1_8.METADATA;
    }
    
    @Override
    protected void writeEnd(final Type<Metadata> llllllllllllllllllIIIIlllIllIIIl, final ByteBuf llllllllllllllllllIIIIlllIllIIII) throws Exception {
        llllllllllllllllllIIIIlllIllIIII.writeByte(127);
    }
}
