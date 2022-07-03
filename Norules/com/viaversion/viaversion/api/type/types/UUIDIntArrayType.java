package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import io.netty.buffer.*;

public class UUIDIntArrayType extends Type<UUID>
{
    @Override
    public void write(final ByteBuf llllllllllllllIIIIlIIlIIlIIIIIII, final UUID llllllllllllllIIIIlIIlIIIlllllll) {
        final int[] llllllllllllllIIIIlIIlIIIllllllI = uuidToIntArray(llllllllllllllIIIIlIIlIIIlllllll);
        llllllllllllllIIIIlIIlIIlIIIIIII.writeInt(llllllllllllllIIIIlIIlIIIllllllI[0]);
        llllllllllllllIIIIlIIlIIlIIIIIII.writeInt(llllllllllllllIIIIlIIlIIIllllllI[1]);
        llllllllllllllIIIIlIIlIIlIIIIIII.writeInt(llllllllllllllIIIIlIIlIIIllllllI[2]);
        llllllllllllllIIIIlIIlIIlIIIIIII.writeInt(llllllllllllllIIIIlIIlIIIllllllI[3]);
    }
    
    public UUIDIntArrayType() {
        super(UUID.class);
    }
    
    @Override
    public UUID read(final ByteBuf llllllllllllllIIIIlIIlIIlIIIIllI) {
        final int[] llllllllllllllIIIIlIIlIIlIIIIlll = { llllllllllllllIIIIlIIlIIlIIIIllI.readInt(), llllllllllllllIIIIlIIlIIlIIIIllI.readInt(), llllllllllllllIIIIlIIlIIlIIIIllI.readInt(), llllllllllllllIIIIlIIlIIlIIIIllI.readInt() };
        return uuidFromIntArray(llllllllllllllIIIIlIIlIIlIIIIlll);
    }
    
    public static int[] uuidToIntArray(final UUID llllllllllllllIIIIlIIlIIIlllIlIl) {
        return bitsToIntArray(llllllllllllllIIIIlIIlIIIlllIlIl.getMostSignificantBits(), llllllllllllllIIIIlIIlIIIlllIlIl.getLeastSignificantBits());
    }
    
    public static UUID uuidFromIntArray(final int[] llllllllllllllIIIIlIIlIIIllllIII) {
        return new UUID((long)llllllllllllllIIIIlIIlIIIllllIII[0] << 32 | ((long)llllllllllllllIIIIlIIlIIIllllIII[1] & 0xFFFFFFFFL), (long)llllllllllllllIIIIlIIlIIIllllIII[2] << 32 | ((long)llllllllllllllIIIIlIIlIIIllllIII[3] & 0xFFFFFFFFL));
    }
    
    public static int[] bitsToIntArray(final long llllllllllllllIIIIlIIlIIIlllIIlI, final long llllllllllllllIIIIlIIlIIIllIllll) {
        return new int[] { (int)(llllllllllllllIIIIlIIlIIIlllIIlI >> 32), (int)llllllllllllllIIIIlIIlIIIlllIIlI, (int)(llllllllllllllIIIIlIIlIIIllIllll >> 32), (int)llllllllllllllIIIIlIIlIIIllIllll };
    }
}
