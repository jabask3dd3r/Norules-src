package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.*;
import io.netty.buffer.*;
import java.util.zip.*;
import java.io.*;

public class CompressedNBTType extends Type<CompoundTag>
{
    public CompressedNBTType() {
        super(CompoundTag.class);
    }
    
    @Override
    public CompoundTag read(final ByteBuf llllllllllllllIIlIIlllllllIlIIIl) throws IOException {
        final short llllllllllllllIIlIIlllllllIlIIII = llllllllllllllIIlIIlllllllIlIIIl.readShort();
        if (llllllllllllllIIlIIlllllllIlIIII <= 0) {
            return null;
        }
        final ByteBuf llllllllllllllIIlIIlllllllIIllll = llllllllllllllIIlIIlllllllIlIIIl.readSlice((int)llllllllllllllIIlIIlllllllIlIIII);
        final GZIPInputStream llllllllllllllIIlIIlllllllIlIIll = new GZIPInputStream((InputStream)new ByteBufInputStream(llllllllllllllIIlIIlllllllIIllll));
        try {
            final int llllllllllllllIIlIIlllllllIIlIlI = (int)NBTIO.readTag(llllllllllllllIIlIIlllllllIlIIll);
            llllllllllllllIIlIIlllllllIlIIll.close();
            return (CompoundTag)llllllllllllllIIlIIlllllllIIlIlI;
        }
        catch (Throwable llllllllllllllIIlIIlllllllIIlIlI) {
            try {
                llllllllllllllIIlIIlllllllIlIIll.close();
            }
            catch (Throwable llllllllllllllIIlIIlllllllIIlIIl) {
                ((Throwable)llllllllllllllIIlIIlllllllIIlIlI).addSuppressed((Throwable)llllllllllllllIIlIIlllllllIIlIIl);
            }
            throw llllllllllllllIIlIIlllllllIIlIlI;
        }
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIlIIllllllIllllII, final CompoundTag llllllllllllllIIlIIllllllIlllIll) throws Exception {
        if (llllllllllllllIIlIIllllllIlllIll == null) {
            llllllllllllllIIlIIllllllIllllII.writeShort(-1);
            return;
        }
        final ByteBuf llllllllllllllIIlIIllllllIllllIl = llllllllllllllIIlIIllllllIllllII.alloc().buffer();
        try {
            final GZIPOutputStream llllllllllllllIIlIIlllllllIIIIIl = new GZIPOutputStream((OutputStream)new ByteBufOutputStream(llllllllllllllIIlIIllllllIllllIl));
            try {
                NBTIO.writeTag(llllllllllllllIIlIIlllllllIIIIIl, llllllllllllllIIlIIllllllIlllIll);
                llllllllllllllIIlIIlllllllIIIIIl.close();
            }
            catch (Throwable llllllllllllllIIlIIllllllIlllIII) {
                try {
                    llllllllllllllIIlIIlllllllIIIIIl.close();
                }
                catch (Throwable llllllllllllllIIlIIllllllIllIlll) {
                    ((Throwable)llllllllllllllIIlIIllllllIlllIII).addSuppressed((Throwable)llllllllllllllIIlIIllllllIllIlll);
                }
                throw llllllllllllllIIlIIllllllIlllIII;
            }
            llllllllllllllIIlIIllllllIllllII.writeShort(llllllllllllllIIlIIllllllIllllIl.readableBytes());
            llllllllllllllIIlIIllllllIllllII.writeBytes(llllllllllllllIIlIIllllllIllllIl);
        }
        finally {
            llllllllllllllIIlIIllllllIllllIl.release();
        }
    }
}
