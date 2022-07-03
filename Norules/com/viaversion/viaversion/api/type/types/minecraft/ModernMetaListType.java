package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import io.netty.buffer.*;

public abstract class ModernMetaListType extends AbstractMetaListType
{
    @Override
    protected void writeEnd(final Type<Metadata> llllllllllllllIIIllIlIllIllIIIII, final ByteBuf llllllllllllllIIIllIlIllIlIlllll) throws Exception {
        llllllllllllllIIIllIlIllIllIIIII.write(llllllllllllllIIIllIlIllIlIlllll, null);
    }
}
