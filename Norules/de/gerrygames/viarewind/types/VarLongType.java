package de.gerrygames.viarewind.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class VarLongType extends Type<Long>
{
    @Override
    public Long read(final ByteBuf llllllllllllllIIIlIlIlIllllIIIII) throws Exception {
        long llllllllllllllIIIlIlIlIlllIlllll = 0L;
        int llllllllllllllIIIlIlIlIlllIllllI = 0;
        byte llllllllllllllIIIlIlIlIlllIlllIl;
        do {
            llllllllllllllIIIlIlIlIlllIlllIl = llllllllllllllIIIlIlIlIllllIIIII.readByte();
            llllllllllllllIIIlIlIlIlllIlllll |= (llllllllllllllIIIlIlIlIlllIlllIl & 0x7F) << llllllllllllllIIIlIlIlIlllIllllI++ * 7;
            if (llllllllllllllIIIlIlIlIlllIllllI > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((llllllllllllllIIIlIlIlIlllIlllIl & 0x80) == 0x80);
        return llllllllllllllIIIlIlIlIlllIlllll;
    }
    
    static {
        VAR_LONG = new VarLongType();
    }
    
    public VarLongType() {
        super("VarLong", Long.class);
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIIlIlIlIlllIlIlIl, Long llllllllllllllIIIlIlIlIlllIlIIlI) throws Exception {
        while (((long)llllllllllllllIIIlIlIlIlllIlIIlI & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            llllllllllllllIIIlIlIlIlllIlIlIl.writeByte((int)((long)llllllllllllllIIIlIlIlIlllIlIIlI & 0x7FL) | 0x80);
            llllllllllllllIIIlIlIlIlllIlIIlI = (long)llllllllllllllIIIlIlIlIlllIlIIlI >>> 7;
        }
        llllllllllllllIIIlIlIlIlllIlIlIl.writeByte(llllllllllllllIIIlIlIlIlllIlIIlI.intValue());
    }
}
