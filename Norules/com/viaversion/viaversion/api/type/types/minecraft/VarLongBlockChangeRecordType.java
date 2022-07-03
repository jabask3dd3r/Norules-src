package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.*;

public class VarLongBlockChangeRecordType extends Type<BlockChangeRecord>
{
    @Override
    public void write(final ByteBuf lllllllllllllIllllIIIIlllIIIIIIl, final BlockChangeRecord lllllllllllllIllllIIIIlllIIIIIII) throws Exception {
        final short lllllllllllllIllllIIIIlllIIIIIlI = (short)(lllllllllllllIllllIIIIlllIIIIIII.getSectionX() << 8 | lllllllllllllIllllIIIIlllIIIIIII.getSectionZ() << 4 | lllllllllllllIllllIIIIlllIIIIIII.getSectionY());
        Type.VAR_LONG.writePrimitive(lllllllllllllIllllIIIIlllIIIIIIl, (long)lllllllllllllIllllIIIIlllIIIIIII.getBlockId() << 12 | (long)lllllllllllllIllllIIIIlllIIIIIlI);
    }
    
    @Override
    public BlockChangeRecord read(final ByteBuf lllllllllllllIllllIIIIlllIIIlIll) throws Exception {
        final long lllllllllllllIllllIIIIlllIIIllIl = Type.VAR_LONG.readPrimitive(lllllllllllllIllllIIIIlllIIIlIll);
        final short lllllllllllllIllllIIIIlllIIIllII = (short)(lllllllllllllIllllIIIIlllIIIllIl & 0xFFFL);
        return new BlockChangeRecord1_16_2(lllllllllllllIllllIIIIlllIIIllII >>> 8 & 0xF, lllllllllllllIllllIIIIlllIIIllII & 0xF, lllllllllllllIllllIIIIlllIIIllII >>> 4 & 0xF, (int)(lllllllllllllIllllIIIIlllIIIllIl >>> 12));
    }
    
    public VarLongBlockChangeRecordType() {
        super(BlockChangeRecord.class);
    }
}
