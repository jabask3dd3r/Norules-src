package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class VarLongType extends Type<Long> implements TypeConverter<Long>
{
    @Override
    public Long from(final Object llllllllllllllIlIlIlIllIllIlIIII) {
        if (llllllllllllllIlIlIlIllIllIlIIII instanceof Number) {
            return ((Number)llllllllllllllIlIlIlIllIllIlIIII).longValue();
        }
        if (llllllllllllllIlIlIlIllIllIlIIII instanceof Boolean) {
            return (long)(((boolean)llllllllllllllIlIlIlIllIllIlIIII) ? 1 : 0);
        }
        return (Long)llllllllllllllIlIlIlIllIllIlIIII;
    }
    
    public void writePrimitive(final ByteBuf llllllllllllllIlIlIlIllIlllIIlIl, long llllllllllllllIlIlIlIllIlllIIlII) {
        do {
            int llllllllllllllIlIlIlIllIlllIIllI = (int)(llllllllllllllIlIlIlIllIlllIIlII & 0x7FL);
            llllllllllllllIlIlIlIllIlllIIlII >>>= 7;
            if (llllllllllllllIlIlIlIllIlllIIlII != 0L) {
                llllllllllllllIlIlIlIllIlllIIllI |= 0x80;
            }
            llllllllllllllIlIlIlIllIlllIIlIl.writeByte(llllllllllllllIlIlIlIllIlllIIllI);
        } while (llllllllllllllIlIlIlIllIlllIIlII != 0L);
    }
    
    @Deprecated
    @Override
    public Long read(final ByteBuf llllllllllllllIlIlIlIllIllIlllIl) {
        return this.readPrimitive(llllllllllllllIlIlIlIllIllIlllIl);
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf llllllllllllllIlIlIlIllIllIllIII, final Long llllllllllllllIlIlIlIllIllIlIlll) {
        this.writePrimitive(llllllllllllllIlIlIlIllIllIllIII, llllllllllllllIlIlIlIllIllIlIlll);
    }
    
    public long readPrimitive(final ByteBuf llllllllllllllIlIlIlIllIllllIlII) {
        long llllllllllllllIlIlIlIllIllllIIll = 0L;
        int llllllllllllllIlIlIlIllIllllIIlI = 0;
        byte llllllllllllllIlIlIlIllIllllIIIl;
        do {
            llllllllllllllIlIlIlIllIllllIIIl = llllllllllllllIlIlIlIllIllllIlII.readByte();
            llllllllllllllIlIlIlIllIllllIIll |= (long)(llllllllllllllIlIlIlIllIllllIIIl & 0x7F) << llllllllllllllIlIlIlIllIllllIIlI++ * 7;
            if (llllllllllllllIlIlIlIllIllllIIlI > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((llllllllllllllIlIlIlIllIllllIIIl & 0x80) == 0x80);
        return llllllllllllllIlIlIlIllIllllIIll;
    }
    
    public VarLongType() {
        super("VarLong", Long.class);
    }
}
