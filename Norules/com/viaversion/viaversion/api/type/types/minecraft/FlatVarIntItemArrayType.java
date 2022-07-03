package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class FlatVarIntItemArrayType extends BaseItemArrayType
{
    @Override
    public Item[] read(final ByteBuf lllllllllllllIIIIlIlIIllllllIlIl) throws Exception {
        final int lllllllllllllIIIIlIlIIllllllIlll = FlatVarIntItemArrayType.SHORT.readPrimitive(lllllllllllllIIIIlIlIIllllllIlIl);
        final Item[] lllllllllllllIIIIlIlIIllllllIllI = new Item[lllllllllllllIIIIlIlIIllllllIlll];
        for (int lllllllllllllIIIIlIlIIlllllllIlI = 0; lllllllllllllIIIIlIlIIlllllllIlI < lllllllllllllIIIIlIlIIllllllIlll; ++lllllllllllllIIIIlIlIIlllllllIlI) {
            lllllllllllllIIIIlIlIIllllllIllI[lllllllllllllIIIIlIlIIlllllllIlI] = FlatVarIntItemArrayType.FLAT_VAR_INT_ITEM.read(lllllllllllllIIIIlIlIIllllllIlIl);
        }
        return lllllllllllllIIIIlIlIIllllllIllI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIIIlIlIIlllllIIlll, final Item[] lllllllllllllIIIIlIlIIlllllIIllI) throws Exception {
        FlatVarIntItemArrayType.SHORT.writePrimitive(lllllllllllllIIIIlIlIIlllllIIlll, (short)lllllllllllllIIIIlIlIIlllllIIllI.length);
        final short lllllllllllllIIIIlIlIIlllllIIlIl = (Object)lllllllllllllIIIIlIlIIlllllIIllI;
        final long lllllllllllllIIIIlIlIIlllllIIlII = lllllllllllllIIIIlIlIIlllllIIlIl.length;
        for (byte lllllllllllllIIIIlIlIIlllllIIIll = 0; lllllllllllllIIIIlIlIIlllllIIIll < lllllllllllllIIIIlIlIIlllllIIlII; ++lllllllllllllIIIIlIlIIlllllIIIll) {
            final Item lllllllllllllIIIIlIlIIlllllIlIll = lllllllllllllIIIIlIlIIlllllIIlIl[lllllllllllllIIIIlIlIIlllllIIIll];
            FlatVarIntItemArrayType.FLAT_VAR_INT_ITEM.write(lllllllllllllIIIIlIlIIlllllIIlll, lllllllllllllIIIIlIlIIlllllIlIll);
        }
    }
    
    public FlatVarIntItemArrayType() {
        super("Flat Item Array");
    }
}
