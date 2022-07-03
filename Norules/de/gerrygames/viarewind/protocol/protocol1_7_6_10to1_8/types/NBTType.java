package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.*;
import io.netty.buffer.*;
import java.io.*;

public class NBTType extends Type<CompoundTag>
{
    @Override
    public CompoundTag read(final ByteBuf llllllllllllllIllIIIIIIlllIllIll) {
        final short llllllllllllllIllIIIIIIlllIllIlI = llllllllllllllIllIIIIIIlllIllIll.readShort();
        if (llllllllllllllIllIIIIIIlllIllIlI < 0) {
            return null;
        }
        final ByteBufInputStream llllllllllllllIllIIIIIIlllIllIIl = new ByteBufInputStream(llllllllllllllIllIIIIIIlllIllIll);
        final DataInputStream llllllllllllllIllIIIIIIlllIllIII = new DataInputStream((InputStream)llllllllllllllIllIIIIIIlllIllIIl);
        try {
            return NBTIO.readTag((DataInput)llllllllllllllIllIIIIIIlllIllIII);
        }
        catch (Throwable llllllllllllllIllIIIIIIlllIlllll) {
            llllllllllllllIllIIIIIIlllIlllll.printStackTrace();
            try {
                llllllllllllllIllIIIIIIlllIllIII.close();
            }
            catch (IOException llllllllllllllIllIIIIIIlllIllllI) {
                llllllllllllllIllIIIIIIlllIllllI.printStackTrace();
            }
        }
        finally {
            try {
                llllllllllllllIllIIIIIIlllIllIII.close();
            }
            catch (IOException llllllllllllllIllIIIIIIlllIlllIl) {
                llllllllllllllIllIIIIIIlllIlllIl.printStackTrace();
            }
        }
        return null;
    }
    
    public NBTType() {
        super(CompoundTag.class);
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIllIIIIIIlllIIIlII, final CompoundTag llllllllllllllIllIIIIIIlllIIIIll) throws Exception {
        if (llllllllllllllIllIIIIIIlllIIIIll == null) {
            llllllllllllllIllIIIIIIlllIIIlII.writeShort(-1);
        }
        else {
            final ByteBuf llllllllllllllIllIIIIIIlllIIlIlI = llllllllllllllIllIIIIIIlllIIIlII.alloc().buffer();
            final ByteBufOutputStream llllllllllllllIllIIIIIIlllIIlIIl = new ByteBufOutputStream(llllllllllllllIllIIIIIIlllIIlIlI);
            final DataOutputStream llllllllllllllIllIIIIIIlllIIlIII = new DataOutputStream((OutputStream)llllllllllllllIllIIIIIIlllIIlIIl);
            NBTIO.writeTag((DataOutput)llllllllllllllIllIIIIIIlllIIlIII, llllllllllllllIllIIIIIIlllIIIIll);
            llllllllllllllIllIIIIIIlllIIlIII.close();
            llllllllllllllIllIIIIIIlllIIIlII.writeShort(llllllllllllllIllIIIIIIlllIIlIlI.readableBytes());
            llllllllllllllIllIIIIIIlllIIIlII.writeBytes(llllllllllllllIllIIIIIIlllIIlIlI);
            llllllllllllllIllIIIIIIlllIIlIlI.release();
        }
    }
}
