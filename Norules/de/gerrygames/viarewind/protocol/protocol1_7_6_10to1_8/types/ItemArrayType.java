package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import io.netty.buffer.*;

public class ItemArrayType extends Type<Item[]>
{
    private final /* synthetic */ boolean compressed;
    
    @Override
    public Item[] read(final ByteBuf lllllllllllllIIllIlIlIIIllllllll) throws Exception {
        final int lllllllllllllIIllIlIlIIlIIIIIIlI = Type.SHORT.read(lllllllllllllIIllIlIlIIIllllllll);
        final Item[] lllllllllllllIIllIlIlIIlIIIIIIIl = new Item[lllllllllllllIIllIlIlIIlIIIIIIlI];
        for (int lllllllllllllIIllIlIlIIlIIIIIlIl = 0; lllllllllllllIIllIlIlIIlIIIIIlIl < lllllllllllllIIllIlIlIIlIIIIIIlI; ++lllllllllllllIIllIlIlIIlIIIIIlIl) {
            lllllllllllllIIllIlIlIIlIIIIIIIl[lllllllllllllIIllIlIlIIlIIIIIlIl] = (this.compressed ? Types1_7_6_10.COMPRESSED_NBT_ITEM : Types1_7_6_10.ITEM).read(lllllllllllllIIllIlIlIIIllllllll);
        }
        return lllllllllllllIIllIlIlIIlIIIIIIIl;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIllIlIlIIIlllIIIII, final Item[] lllllllllllllIIllIlIlIIIlllIIIlI) throws Exception {
        Type.SHORT.write(lllllllllllllIIllIlIlIIIlllIIIII, (short)lllllllllllllIIllIlIlIIIlllIIIlI.length);
        final long lllllllllllllIIllIlIlIIIllIllllI = (Object)lllllllllllllIIllIlIlIIIlllIIIlI;
        final String lllllllllllllIIllIlIlIIIllIlllIl = (String)lllllllllllllIIllIlIlIIIllIllllI.length;
        for (float lllllllllllllIIllIlIlIIIllIlllII = 0; lllllllllllllIIllIlIlIIIllIlllII < lllllllllllllIIllIlIlIIIllIlllIl; ++lllllllllllllIIllIlIlIIIllIlllII) {
            final Item lllllllllllllIIllIlIlIIIlllIIlIl = lllllllllllllIIllIlIlIIIllIllllI[lllllllllllllIIllIlIlIIIllIlllII];
            (this.compressed ? Types1_7_6_10.COMPRESSED_NBT_ITEM : Types1_7_6_10.ITEM).write(lllllllllllllIIllIlIlIIIlllIIIII, lllllllllllllIIllIlIlIIIlllIIlIl);
        }
    }
    
    public ItemArrayType(final boolean lllllllllllllIIllIlIlIIlIIIlIIlI) {
        super(Item[].class);
        this.compressed = lllllllllllllIIllIlIlIIlIIIlIIlI;
    }
}
