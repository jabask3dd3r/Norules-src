package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class ItemArrayType extends BaseItemArrayType
{
    @Override
    public void write(final ByteBuf llllllllllllllIlIlllIllllIlIlIIl, final Item[] llllllllllllllIlIlllIllllIlIlIII) throws Exception {
        ItemArrayType.SHORT.writePrimitive(llllllllllllllIlIlllIllllIlIlIIl, (short)llllllllllllllIlIlllIllllIlIlIII.length);
        final boolean llllllllllllllIlIlllIllllIlIIlll = (Object)llllllllllllllIlIlllIllllIlIlIII;
        final float llllllllllllllIlIlllIllllIlIIllI = llllllllllllllIlIlllIllllIlIIlll.length;
        for (char llllllllllllllIlIlllIllllIlIIlIl = '\0'; llllllllllllllIlIlllIllllIlIIlIl < llllllllllllllIlIlllIllllIlIIllI; ++llllllllllllllIlIlllIllllIlIIlIl) {
            final Item llllllllllllllIlIlllIllllIlIlllI = llllllllllllllIlIlllIllllIlIIlll[llllllllllllllIlIlllIllllIlIIlIl];
            ItemArrayType.ITEM.write(llllllllllllllIlIlllIllllIlIlIIl, llllllllllllllIlIlllIllllIlIlllI);
        }
    }
    
    @Override
    public Item[] read(final ByteBuf llllllllllllllIlIlllIllllIllllII) throws Exception {
        final int llllllllllllllIlIlllIllllIlllIlI = ItemArrayType.SHORT.readPrimitive(llllllllllllllIlIlllIllllIllllII);
        final Item[] llllllllllllllIlIlllIllllIlllIIl = new Item[llllllllllllllIlIlllIllllIlllIlI];
        for (int llllllllllllllIlIlllIlllllIIIIIl = 0; llllllllllllllIlIlllIlllllIIIIIl < llllllllllllllIlIlllIllllIlllIlI; ++llllllllllllllIlIlllIlllllIIIIIl) {
            llllllllllllllIlIlllIllllIlllIIl[llllllllllllllIlIlllIlllllIIIIIl] = ItemArrayType.ITEM.read(llllllllllllllIlIlllIllllIllllII);
        }
        return llllllllllllllIlIlllIllllIlllIIl;
    }
    
    public ItemArrayType() {
        super("Item Array");
    }
}
