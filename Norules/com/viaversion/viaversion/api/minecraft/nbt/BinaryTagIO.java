package com.viaversion.viaversion.api.minecraft.nbt;

import java.nio.file.*;
import java.util.zip.*;
import java.io.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public final class BinaryTagIO
{
    public static void writeCompressedOutputStream(final CompoundTag llllllllllllllIIIllIlllllIllllll, final OutputStream llllllllllllllIIIllIlllllIlllllI) throws IOException {
        final DataOutputStream llllllllllllllIIIllIllllllIIIIlI = new DataOutputStream(new GZIPOutputStream(llllllllllllllIIIllIlllllIlllllI));
        try {
            writeDataOutput(llllllllllllllIIIllIlllllIllllll, llllllllllllllIIIllIllllllIIIIlI);
            llllllllllllllIIIllIllllllIIIIlI.close();
        }
        catch (Throwable llllllllllllllIIIllIlllllIllllII) {
            try {
                llllllllllllllIIIllIllllllIIIIlI.close();
            }
            catch (Throwable llllllllllllllIIIllIlllllIlllIll) {
                ((Throwable)llllllllllllllIIIllIlllllIllllII).addSuppressed((Throwable)llllllllllllllIIIllIlllllIlllIll);
            }
            throw llllllllllllllIIIllIlllllIllllII;
        }
    }
    
    public static CompoundTag readString(final String llllllllllllllIIIllIlllllIlIlIll) throws IOException {
        try {
            final CharBuffer llllllllllllllIIIllIlllllIllIIII = new CharBuffer(llllllllllllllIIIllIlllllIlIlIll);
            final TagStringReader llllllllllllllIIIllIlllllIlIllll = new TagStringReader(llllllllllllllIIIllIlllllIllIIII);
            final CompoundTag llllllllllllllIIIllIlllllIlIlllI = llllllllllllllIIIllIlllllIlIllll.compound();
            if (llllllllllllllIIIllIlllllIllIIII.skipWhitespace().hasMore()) {
                throw new IOException("Document had trailing content after first CompoundTag");
            }
            return llllllllllllllIIIllIlllllIlIlllI;
        }
        catch (StringTagParseException llllllllllllllIIIllIlllllIlIllIl) {
            throw new IOException(llllllllllllllIIIllIlllllIlIllIl);
        }
    }
    
    private BinaryTagIO() {
    }
    
    public static void writeOutputStream(final CompoundTag llllllllllllllIIIllIllllllIlIlII, final OutputStream llllllllllllllIIIllIllllllIlIIIl) throws IOException {
        final DataOutputStream llllllllllllllIIIllIllllllIlIlIl = new DataOutputStream(llllllllllllllIIIllIllllllIlIIIl);
        try {
            writeDataOutput(llllllllllllllIIIllIllllllIlIlII, llllllllllllllIIIllIllllllIlIlIl);
            llllllllllllllIIIllIllllllIlIlIl.close();
        }
        catch (Throwable llllllllllllllIIIllIllllllIIllll) {
            try {
                llllllllllllllIIIllIllllllIlIlIl.close();
            }
            catch (Throwable llllllllllllllIIIllIllllllIIlllI) {
                ((Throwable)llllllllllllllIIIllIllllllIIllll).addSuppressed((Throwable)llllllllllllllIIIllIllllllIIlllI);
            }
            throw llllllllllllllIIIllIllllllIIllll;
        }
    }
    
    public static void writePath(final CompoundTag llllllllllllllIIIllIllllllIllllI, final Path llllllllllllllIIIllIllllllIlllIl) throws IOException {
        writeOutputStream(llllllllllllllIIIllIllllllIllllI, Files.newOutputStream(llllllllllllllIIIllIllllllIlllIl, new OpenOption[0]));
    }
    
    public static CompoundTag readDataInput(final DataInput llllllllllllllIIIllIlllllllIIIll) throws IOException {
        final byte llllllllllllllIIIllIlllllllIIlIl = llllllllllllllIIIllIlllllllIIIll.readByte();
        if (llllllllllllllIIIllIlllllllIIlIl != 10) {
            throw new IOException(String.format("Expected root tag to be a CompoundTag, was %s", llllllllllllllIIIllIlllllllIIlIl));
        }
        llllllllllllllIIIllIlllllllIIIll.skipBytes(llllllllllllllIIIllIlllllllIIIll.readUnsignedShort());
        final CompoundTag llllllllllllllIIIllIlllllllIIlII = new CompoundTag();
        llllllllllllllIIIllIlllllllIIlII.read(llllllllllllllIIIllIlllllllIIIll);
        return llllllllllllllIIIllIlllllllIIlII;
    }
    
    public static CompoundTag readInputStream(final InputStream llllllllllllllIIIllIlllllllllIll) throws IOException {
        final DataInputStream llllllllllllllIIIllIllllllllllII = new DataInputStream(llllllllllllllIIIllIlllllllllIll);
        try {
            final double llllllllllllllIIIllIlllllllllIII = (double)readDataInput(llllllllllllllIIIllIllllllllllII);
            llllllllllllllIIIllIllllllllllII.close();
            return (CompoundTag)llllllllllllllIIIllIlllllllllIII;
        }
        catch (Throwable llllllllllllllIIIllIlllllllllIII) {
            try {
                llllllllllllllIIIllIllllllllllII.close();
            }
            catch (Throwable llllllllllllllIIIllIllllllllIlll) {
                ((Throwable)llllllllllllllIIIllIlllllllllIII).addSuppressed((Throwable)llllllllllllllIIIllIllllllllIlll);
            }
            throw llllllllllllllIIIllIlllllllllIII;
        }
    }
    
    public static void writeDataOutput(final CompoundTag llllllllllllllIIIllIlllllIlllIII, final DataOutput llllllllllllllIIIllIlllllIllIlIl) throws IOException {
        llllllllllllllIIIllIlllllIllIlIl.writeByte(10);
        llllllllllllllIIIllIlllllIllIlIl.writeUTF("");
        llllllllllllllIIIllIlllllIlllIII.write(llllllllllllllIIIllIlllllIllIlIl);
    }
    
    public static void writeCompressedPath(final CompoundTag llllllllllllllIIIllIllllllIIlIIl, final Path llllllllllllllIIIllIllllllIIlIII) throws IOException {
        writeCompressedOutputStream(llllllllllllllIIIllIllllllIIlIIl, Files.newOutputStream(llllllllllllllIIIllIllllllIIlIII, new OpenOption[0]));
    }
    
    public static CompoundTag readCompressedInputStream(final InputStream llllllllllllllIIIllIlllllllIllIl) throws IOException {
        final DataInputStream llllllllllllllIIIllIlllllllIllll = new DataInputStream(new BufferedInputStream(new GZIPInputStream(llllllllllllllIIIllIlllllllIllIl)));
        try {
            final Exception llllllllllllllIIIllIlllllllIlIll = (Exception)readDataInput(llllllllllllllIIIllIlllllllIllll);
            llllllllllllllIIIllIlllllllIllll.close();
            return (CompoundTag)llllllllllllllIIIllIlllllllIlIll;
        }
        catch (Throwable llllllllllllllIIIllIlllllllIlIll) {
            try {
                llllllllllllllIIIllIlllllllIllll.close();
            }
            catch (Throwable llllllllllllllIIIllIlllllllIlIlI) {
                llllllllllllllIIIllIlllllllIlIll.addSuppressed((Throwable)llllllllllllllIIIllIlllllllIlIlI);
            }
            throw llllllllllllllIIIllIlllllllIlIll;
        }
    }
    
    public static String writeString(final CompoundTag llllllllllllllIIIllIlllllIlIIIIl) throws IOException {
        final StringBuilder llllllllllllllIIIllIlllllIlIIIII = new StringBuilder();
        final TagStringWriter llllllllllllllIIIllIlllllIlIIIlI = new TagStringWriter(llllllllllllllIIIllIlllllIlIIIII);
        try {
            llllllllllllllIIIllIlllllIlIIIlI.writeTag(llllllllllllllIIIllIlllllIlIIIIl);
            llllllllllllllIIIllIlllllIlIIIlI.close();
        }
        catch (Throwable llllllllllllllIIIllIlllllIIlllII) {
            try {
                llllllllllllllIIIllIlllllIlIIIlI.close();
            }
            catch (Throwable llllllllllllllIIIllIlllllIIllIll) {
                ((Throwable)llllllllllllllIIIllIlllllIIlllII).addSuppressed((Throwable)llllllllllllllIIIllIlllllIIllIll);
            }
            throw llllllllllllllIIIllIlllllIIlllII;
        }
        return String.valueOf(llllllllllllllIIIllIlllllIlIIIII);
    }
    
    public static CompoundTag readPath(final Path llllllllllllllIIIlllIIIIIIIIIIIl) throws IOException {
        return readInputStream(Files.newInputStream(llllllllllllllIIIlllIIIIIIIIIIIl, new OpenOption[0]));
    }
    
    public static CompoundTag readCompressedPath(final Path llllllllllllllIIIllIllllllllIlIl) throws IOException {
        return readCompressedInputStream(Files.newInputStream(llllllllllllllIIIllIllllllllIlIl, new OpenOption[0]));
    }
}
