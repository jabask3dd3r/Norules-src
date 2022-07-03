package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.*;

public class FlatItemArrayType extends BaseItemArrayType
{
    @Override
    public void write(final ByteBuf lIlllIIllllIlII, final Item[] lIlllIIllllIIll) throws Exception {
        Type.SHORT.writePrimitive(lIlllIIllllIlII, (short)lIlllIIllllIIll.length);
        final boolean lIlllIIllllIIlI = (Object)lIlllIIllllIIll;
        final long lIlllIIllllIIIl = lIlllIIllllIIlI.length;
        for (char lIlllIIllllIIII = '\0'; lIlllIIllllIIII < lIlllIIllllIIIl; ++lIlllIIllllIIII) {
            final Item lIlllIIlllllIII = lIlllIIllllIIlI[lIlllIIllllIIII];
            Type.FLAT_ITEM.write(lIlllIIllllIlII, lIlllIIlllllIII);
        }
    }
    
    @Override
    public Item[] read(final ByteBuf lIlllIlIIIIIlIl) throws Exception {
        final int lIlllIlIIIIIlII = Type.SHORT.readPrimitive(lIlllIlIIIIIlIl);
        final Item[] lIlllIlIIIIIIll = new Item[lIlllIlIIIIIlII];
        for (int lIlllIlIIIIIlll = 0; lIlllIlIIIIIlll < lIlllIlIIIIIlII; ++lIlllIlIIIIIlll) {
            lIlllIlIIIIIIll[lIlllIlIIIIIlll] = Type.FLAT_ITEM.read(lIlllIlIIIIIlIl);
        }
        return lIlllIlIIIIIIll;
    }
    
    public FlatItemArrayType() {
        super("Flat Item Array");
    }
}
