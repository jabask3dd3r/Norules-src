package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class ItemType extends Type<Item>
{
    private final /* synthetic */ boolean compressed;
    
    @Override
    public Item read(final ByteBuf lllllllllllllIlIIlllIIllIIllIllI) throws Exception {
        final int lllllllllllllIlIIlllIIllIIllIlIl = lllllllllllllIlIIlllIIllIIllIllI.readerIndex();
        final short lllllllllllllIlIIlllIIllIIllIlII = lllllllllllllIlIIlllIIllIIllIllI.readShort();
        if (lllllllllllllIlIIlllIIllIIllIlII < 0) {
            return null;
        }
        final Item lllllllllllllIlIIlllIIllIIllIIll = new DataItem();
        lllllllllllllIlIIlllIIllIIllIIll.setIdentifier(lllllllllllllIlIIlllIIllIIllIlII);
        lllllllllllllIlIIlllIIllIIllIIll.setAmount(lllllllllllllIlIIlllIIllIIllIllI.readByte());
        lllllllllllllIlIIlllIIllIIllIIll.setData(lllllllllllllIlIIlllIIllIIllIllI.readShort());
        lllllllllllllIlIIlllIIllIIllIIll.setTag((this.compressed ? Types1_7_6_10.COMPRESSED_NBT : Types1_7_6_10.NBT).read(lllllllllllllIlIIlllIIllIIllIllI));
        return lllllllllllllIlIIlllIIllIIllIIll;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIIlllIIllIIlIIlII, final Item lllllllllllllIlIIlllIIllIIlIIIII) throws Exception {
        if (lllllllllllllIlIIlllIIllIIlIIIII == null) {
            lllllllllllllIlIIlllIIllIIlIIlII.writeShort(-1);
        }
        else {
            lllllllllllllIlIIlllIIllIIlIIlII.writeShort(lllllllllllllIlIIlllIIllIIlIIIII.identifier());
            lllllllllllllIlIIlllIIllIIlIIlII.writeByte(lllllllllllllIlIIlllIIllIIlIIIII.amount());
            lllllllllllllIlIIlllIIllIIlIIlII.writeShort((int)lllllllllllllIlIIlllIIllIIlIIIII.data());
            (this.compressed ? Types1_7_6_10.COMPRESSED_NBT : Types1_7_6_10.NBT).write(lllllllllllllIlIIlllIIllIIlIIlII, lllllllllllllIlIIlllIIllIIlIIIII.tag());
        }
    }
    
    public ItemType(final boolean lllllllllllllIlIIlllIIllIIllllIl) {
        super(Item.class);
        this.compressed = lllllllllllllIlIIlllIIllIIllllIl;
    }
}
