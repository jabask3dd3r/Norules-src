package com.viaversion.viaversion.api.type.types.minecraft;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class FlatVarIntItemType extends BaseItemType
{
    public FlatVarIntItemType() {
        super("FlatVarIntItem");
    }
    
    @Override
    public Item read(final ByteBuf lllllIIIlIIlIlI) throws Exception {
        final boolean lllllIIIlIIlIll = lllllIIIlIIlIlI.readBoolean();
        if (!lllllIIIlIIlIll) {
            return null;
        }
        final Item lllllIIIlIIlllI = new DataItem();
        lllllIIIlIIlllI.setIdentifier(FlatVarIntItemType.VAR_INT.readPrimitive(lllllIIIlIIlIlI));
        lllllIIIlIIlllI.setAmount(lllllIIIlIIlIlI.readByte());
        lllllIIIlIIlllI.setTag(FlatVarIntItemType.NBT.read(lllllIIIlIIlIlI));
        return lllllIIIlIIlllI;
    }
    
    @Override
    public void write(final ByteBuf lllllIIIlIIIlII, final Item lllllIIIlIIIIll) throws Exception {
        if (lllllIIIlIIIIll == null) {
            lllllIIIlIIIlII.writeBoolean(false);
        }
        else {
            lllllIIIlIIIlII.writeBoolean(true);
            FlatVarIntItemType.VAR_INT.writePrimitive(lllllIIIlIIIlII, lllllIIIlIIIIll.identifier());
            lllllIIIlIIIlII.writeByte(lllllIIIlIIIIll.amount());
            FlatVarIntItemType.NBT.write(lllllIIIlIIIlII, lllllIIIlIIIIll.tag());
        }
    }
}
