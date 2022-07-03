package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.*;

public class BlockChangeRecordType extends Type<BlockChangeRecord>
{
    @Override
    public void write(final ByteBuf llllllllllllllIlIIlIIlIIllIllIll, final BlockChangeRecord llllllllllllllIlIIlIIlIIllIllIII) throws Exception {
        Type.SHORT.writePrimitive(llllllllllllllIlIIlIIlIIllIllIll, (short)(llllllllllllllIlIIlIIlIIllIllIII.getSectionX() << 12 | llllllllllllllIlIIlIIlIIllIllIII.getSectionZ() << 8 | llllllllllllllIlIIlIIlIIllIllIII.getY()));
        Type.VAR_INT.writePrimitive(llllllllllllllIlIIlIIlIIllIllIll, llllllllllllllIlIIlIIlIIllIllIII.getBlockId());
    }
    
    public BlockChangeRecordType() {
        super(BlockChangeRecord.class);
    }
    
    @Override
    public BlockChangeRecord read(final ByteBuf llllllllllllllIlIIlIIlIIlllIIIIl) throws Exception {
        final short llllllllllllllIlIIlIIlIIlllIIIll = Type.SHORT.readPrimitive(llllllllllllllIlIIlIIlIIlllIIIIl);
        final int llllllllllllllIlIIlIIlIIlllIIIlI = Type.VAR_INT.readPrimitive(llllllllllllllIlIIlIIlIIlllIIIIl);
        return new BlockChangeRecord1_8(llllllllllllllIlIIlIIlIIlllIIIll >> 12 & 0xF, llllllllllllllIlIIlIIlIIlllIIIll & 0xFF, llllllllllllllIlIIlIIlIIlllIIIll >> 8 & 0xF, llllllllllllllIlIIlIIlIIlllIIIlI);
    }
}
