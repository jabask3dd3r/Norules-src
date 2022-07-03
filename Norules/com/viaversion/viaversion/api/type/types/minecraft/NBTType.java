package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.*;
import com.google.common.base.*;
import io.netty.buffer.*;
import java.io.*;

public class NBTType extends Type<CompoundTag>
{
    @Override
    public void write(final ByteBuf lllllllllllllIlIIllIlllIIIIIlIlI, final CompoundTag lllllllllllllIlIIllIlllIIIIIlIIl) throws Exception {
        if (lllllllllllllIlIIllIlllIIIIIlIIl == null) {
            lllllllllllllIlIIllIlllIIIIIlIlI.writeByte(0);
        }
        else {
            final ByteBufOutputStream lllllllllllllIlIIllIlllIIIIIllII = new ByteBufOutputStream(lllllllllllllIlIIllIlllIIIIIlIlI);
            NBTIO.writeTag((DataOutput)lllllllllllllIlIIllIlllIIIIIllII, lllllllllllllIlIIllIlllIIIIIlIIl);
        }
    }
    
    @Override
    public CompoundTag read(final ByteBuf lllllllllllllIlIIllIlllIIIIlIlIl) throws Exception {
        Preconditions.checkArgument(lllllllllllllIlIIllIlllIIIIlIlIl.readableBytes() <= 2097152, "Cannot read NBT (got %s bytes)", new Object[] { lllllllllllllIlIIllIlllIIIIlIlIl.readableBytes() });
        final int lllllllllllllIlIIllIlllIIIIlIlII = lllllllllllllIlIIllIlllIIIIlIlIl.readerIndex();
        final byte lllllllllllllIlIIllIlllIIIIlIIll = lllllllllllllIlIIllIlllIIIIlIlIl.readByte();
        if (lllllllllllllIlIIllIlllIIIIlIIll == 0) {
            return null;
        }
        lllllllllllllIlIIllIlllIIIIlIlIl.readerIndex(lllllllllllllIlIIllIlllIIIIlIlII);
        return NBTIO.readTag((DataInput)new ByteBufInputStream(lllllllllllllIlIIllIlllIIIIlIlIl));
    }
    
    public NBTType() {
        super(CompoundTag.class);
    }
}
