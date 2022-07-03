package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class VarIntType extends Type<Integer> implements TypeConverter<Integer>
{
    @Override
    public Integer from(final Object lllIllIIIIIIlll) {
        if (lllIllIIIIIIlll instanceof Number) {
            return ((Number)lllIllIIIIIIlll).intValue();
        }
        if (lllIllIIIIIIlll instanceof Boolean) {
            return ((boolean)lllIllIIIIIIlll) ? 1 : 0;
        }
        return (Integer)lllIllIIIIIIlll;
    }
    
    @Deprecated
    @Override
    public Integer read(final ByteBuf lllIllIIIIlIllI) {
        return this.readPrimitive(lllIllIIIIlIllI);
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf lllIllIIIIIllll, final Integer lllIllIIIIIlIll) {
        this.writePrimitive(lllIllIIIIIllll, lllIllIIIIIlIll);
    }
    
    public VarIntType() {
        super("VarInt", Integer.class);
    }
    
    public int readPrimitive(final ByteBuf lllIllIIIlIIlll) {
        int lllIllIIIlIlIlI = 0;
        int lllIllIIIlIlIIl = 0;
        byte lllIllIIIlIlIII;
        do {
            lllIllIIIlIlIII = lllIllIIIlIIlll.readByte();
            lllIllIIIlIlIlI |= (lllIllIIIlIlIII & 0x7F) << lllIllIIIlIlIIl++ * 7;
            if (lllIllIIIlIlIIl > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((lllIllIIIlIlIII & 0x80) == 0x80);
        return lllIllIIIlIlIlI;
    }
    
    public void writePrimitive(final ByteBuf lllIllIIIIlllll, int lllIllIIIIllIll) {
        do {
            int lllIllIIIIlllIl = (int)(lllIllIIIIllIll & 0x7F);
            lllIllIIIIllIll >>>= 7;
            if (lllIllIIIIllIll != 0) {
                lllIllIIIIlllIl |= 0x80;
            }
            lllIllIIIIlllll.writeByte(lllIllIIIIlllIl);
        } while (lllIllIIIIllIll != 0);
    }
}
