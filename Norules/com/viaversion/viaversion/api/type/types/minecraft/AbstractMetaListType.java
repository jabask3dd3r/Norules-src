package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.type.*;

public abstract class AbstractMetaListType extends MetaListTypeTemplate
{
    @Override
    public List<Metadata> read(final ByteBuf lllllllllllllIlIllIIlIIlIlIIlIII) throws Exception {
        final Type<Metadata> lllllllllllllIlIllIIlIIlIlIIllII = this.getType();
        final List<Metadata> lllllllllllllIlIllIIlIIlIlIIlIll = new ArrayList<Metadata>();
        Metadata lllllllllllllIlIllIIlIIlIlIIlIlI;
        do {
            lllllllllllllIlIllIIlIIlIlIIlIlI = lllllllllllllIlIllIIlIIlIlIIllII.read(lllllllllllllIlIllIIlIIlIlIIlIII);
            if (lllllllllllllIlIllIIlIIlIlIIlIlI != null) {
                lllllllllllllIlIllIIlIIlIlIIlIll.add(lllllllllllllIlIllIIlIIlIlIIlIlI);
            }
        } while (lllllllllllllIlIllIIlIIlIlIIlIlI != null);
        return lllllllllllllIlIllIIlIIlIlIIlIll;
    }
    
    protected abstract Type<Metadata> getType();
    
    protected abstract void writeEnd(final Type<Metadata> p0, final ByteBuf p1) throws Exception;
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIllIIlIIlIIlllIII, final List<Metadata> lllllllllllllIlIllIIlIIlIIllIlll) throws Exception {
        final Type<Metadata> lllllllllllllIlIllIIlIIlIIlllIlI = this.getType();
        for (final Metadata lllllllllllllIlIllIIlIIlIIlllllI : lllllllllllllIlIllIIlIIlIIllIlll) {
            lllllllllllllIlIllIIlIIlIIlllIlI.write(lllllllllllllIlIllIIlIIlIIlllIII, lllllllllllllIlIllIIlIIlIIlllllI);
        }
        this.writeEnd(lllllllllllllIlIllIIlIIlIIlllIlI, lllllllllllllIlIllIIlIIlIIlllIII);
    }
}
