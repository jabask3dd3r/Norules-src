package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.*;

public class FlatItemType extends BaseItemType
{
    @Override
    public Item read(final ByteBuf lllllllllllllIlIIIlIlIIlllIlIllI) throws Exception {
        final short lllllllllllllIlIIIlIlIIlllIlIlll = lllllllllllllIlIIIlIlIIlllIlIllI.readShort();
        if (lllllllllllllIlIIIlIlIIlllIlIlll < 0) {
            return null;
        }
        final Item lllllllllllllIlIIIlIlIIlllIllIlI = new DataItem();
        lllllllllllllIlIIIlIlIIlllIllIlI.setIdentifier(lllllllllllllIlIIIlIlIIlllIlIlll);
        lllllllllllllIlIIIlIlIIlllIllIlI.setAmount(lllllllllllllIlIIIlIlIIlllIlIllI.readByte());
        lllllllllllllIlIIIlIlIIlllIllIlI.setTag(Type.NBT.read(lllllllllllllIlIIIlIlIIlllIlIllI));
        return lllllllllllllIlIIIlIlIIlllIllIlI;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIIIlIlIIlllIIlllI, final Item lllllllllllllIlIIIlIlIIlllIIllll) throws Exception {
        if (lllllllllllllIlIIIlIlIIlllIIllll == null) {
            lllllllllllllIlIIIlIlIIlllIIlllI.writeShort(-1);
        }
        else {
            lllllllllllllIlIIIlIlIIlllIIlllI.writeShort(lllllllllllllIlIIIlIlIIlllIIllll.identifier());
            lllllllllllllIlIIIlIlIIlllIIlllI.writeByte(lllllllllllllIlIIIlIlIIlllIIllll.amount());
            Type.NBT.write(lllllllllllllIlIIIlIlIIlllIIlllI, lllllllllllllIlIIIlIlIIlllIIllll.tag());
        }
    }
    
    public FlatItemType() {
        super("FlatItem");
    }
}
