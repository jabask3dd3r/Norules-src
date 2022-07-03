package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class IntArrayType extends Type<int[]>
{
    public IntArrayType() {
        super(int[].class);
    }
    
    @Override
    public int[] read(final ByteBuf lllllllllllllIIlllIlIIlIIllIlIll) throws Exception {
        final byte lllllllllllllIIlllIlIIlIIllIlIlI = lllllllllllllIIlllIlIIlIIllIlIll.readByte();
        final int[] lllllllllllllIIlllIlIIlIIllIlIIl = new int[lllllllllllllIIlllIlIIlIIllIlIlI];
        for (byte lllllllllllllIIlllIlIIlIIllIllIl = 0; lllllllllllllIIlllIlIIlIIllIllIl < lllllllllllllIIlllIlIIlIIllIlIlI; ++lllllllllllllIIlllIlIIlIIllIllIl) {
            lllllllllllllIIlllIlIIlIIllIlIIl[lllllllllllllIIlllIlIIlIIllIllIl] = lllllllllllllIIlllIlIIlIIllIlIll.readInt();
        }
        return lllllllllllllIIlllIlIIlIIllIlIIl;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIIlllIlIIlIIlIllIlI, final int[] lllllllllllllIIlllIlIIlIIlIllIIl) throws Exception {
        lllllllllllllIIlllIlIIlIIlIllIlI.writeByte(lllllllllllllIIlllIlIIlIIlIllIIl.length);
        final long lllllllllllllIIlllIlIIlIIlIllIII = (Object)lllllllllllllIIlllIlIIlIIlIllIIl;
        final double lllllllllllllIIlllIlIIlIIlIlIlll = lllllllllllllIIlllIlIIlIIlIllIII.length;
        for (Exception lllllllllllllIIlllIlIIlIIlIlIllI = (Exception)0; lllllllllllllIIlllIlIIlIIlIlIllI < lllllllllllllIIlllIlIIlIIlIlIlll; ++lllllllllllllIIlllIlIIlIIlIlIllI) {
            final int lllllllllllllIIlllIlIIlIIlIllllI = lllllllllllllIIlllIlIIlIIlIllIII[lllllllllllllIIlllIlIIlIIlIlIllI];
            lllllllllllllIIlllIlIIlIIlIllIlI.writeInt(lllllllllllllIIlllIlIIlIIlIllllI);
        }
    }
}
