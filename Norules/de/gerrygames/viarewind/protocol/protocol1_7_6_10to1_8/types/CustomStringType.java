package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;

public class CustomStringType extends PartialType<String[], Integer>
{
    @Override
    public String[] read(final ByteBuf llllllllllllllllIIlIIlIlIlIIIllI, final Integer llllllllllllllllIIlIIlIlIlIIIlll) throws Exception {
        if (llllllllllllllllIIlIIlIlIlIIIllI.readableBytes() < llllllllllllllllIIlIIlIlIlIIIlll / 4) {
            throw new RuntimeException("Readable bytes does not match expected!");
        }
        final String[] llllllllllllllllIIlIIlIlIlIIlIlI = new String[(int)llllllllllllllllIIlIIlIlIlIIIlll];
        for (int llllllllllllllllIIlIIlIlIlIIlIll = 0; llllllllllllllllIIlIIlIlIlIIlIll < llllllllllllllllIIlIIlIlIlIIIlll; ++llllllllllllllllIIlIIlIlIlIIlIll) {
            llllllllllllllllIIlIIlIlIlIIlIlI[llllllllllllllllIIlIIlIlIlIIlIll] = Type.STRING.read(llllllllllllllllIIlIIlIlIlIIIllI);
        }
        return llllllllllllllllIIlIIlIlIlIIlIlI;
    }
    
    public CustomStringType(final Integer llllllllllllllllIIlIIlIlIlIlIIII) {
        super(llllllllllllllllIIlIIlIlIlIlIIII, String[].class);
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllllIIlIIlIlIIllIlll, final Integer llllllllllllllllIIlIIlIlIIlllIIl, final String[] llllllllllllllllIIlIIlIlIIllIllI) throws Exception {
        final int llllllllllllllllIIlIIlIlIIllIlIl = (Object)llllllllllllllllIIlIIlIlIIllIllI;
        for (Exception llllllllllllllllIIlIIlIlIIllIlII = (Exception)llllllllllllllllIIlIIlIlIIllIlIl.length, llllllllllllllllIIlIIlIlIIllIIll = (Exception)0; llllllllllllllllIIlIIlIlIIllIIll < llllllllllllllllIIlIIlIlIIllIlII; ++llllllllllllllllIIlIIlIlIIllIIll) {
            final String llllllllllllllllIIlIIlIlIIllllII = llllllllllllllllIIlIIlIlIIllIlIl[llllllllllllllllIIlIIlIlIIllIIll];
            Type.STRING.write(llllllllllllllllIIlIIlIlIIllIlll, llllllllllllllllIIlIIlIlIIllllII);
        }
    }
}
