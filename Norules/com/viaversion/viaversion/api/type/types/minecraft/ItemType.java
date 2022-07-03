package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class ItemType extends BaseItemType
{
    @Override
    public Item read(final ByteBuf llIIIIlllIlllll) throws Exception {
        final short llIIIIlllIllllI = llIIIIlllIlllll.readShort();
        if (llIIIIlllIllllI < 0) {
            return null;
        }
        final Item llIIIIllllIIIIl = new DataItem();
        llIIIIllllIIIIl.setIdentifier(llIIIIlllIllllI);
        llIIIIllllIIIIl.setAmount(llIIIIlllIlllll.readByte());
        llIIIIllllIIIIl.setData(llIIIIlllIlllll.readShort());
        llIIIIllllIIIIl.setTag(ItemType.NBT.read(llIIIIlllIlllll));
        return llIIIIllllIIIIl;
    }
    
    @Override
    public void write(final ByteBuf llIIIIlllIlIlIl, final Item llIIIIlllIlIllI) throws Exception {
        if (llIIIIlllIlIllI == null) {
            llIIIIlllIlIlIl.writeShort(-1);
        }
        else {
            llIIIIlllIlIlIl.writeShort(llIIIIlllIlIllI.identifier());
            llIIIIlllIlIlIl.writeByte(llIIIIlllIlIllI.amount());
            llIIIIlllIlIlIl.writeShort((int)llIIIIlllIlIllI.data());
            ItemType.NBT.write(llIIIIlllIlIlIl, llIIIIlllIlIllI.tag());
        }
    }
    
    public ItemType() {
        super("Item");
    }
}
