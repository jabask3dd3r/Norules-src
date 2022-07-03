package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

final class BinaryTagReaderImpl implements BinaryTagIO.Reader
{
    private final /* synthetic */ long maxBytes;
    
    static {
        UNLIMITED = new BinaryTagReaderImpl(-1L);
        DEFAULT_LIMIT = new BinaryTagReaderImpl(131082L);
    }
    
    @Override
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final DataInput llllllllllllllIIIIllllllIIlllIII) throws IOException {
        final BinaryTagType<? extends BinaryTag> llllllllllllllIIIIllllllIIllIlIl = BinaryTagType.of(llllllllllllllIIIIllllllIIlllIII.readByte());
        requireCompound(llllllllllllllIIIIllllllIIllIlIl);
        final String llllllllllllllIIIIllllllIIllIlII = llllllllllllllIIIIllllllIIlllIII.readUTF();
        return new AbstractMap.SimpleImmutableEntry<String, CompoundBinaryTag>(llllllllllllllIIIIllllllIIllIlII, BinaryTagTypes.COMPOUND.read(llllllllllllllIIIIllllllIIlllIII));
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag read(@NotNull DataInput llllllllllllllIIIIllllllIllIIIIl) throws IOException {
        if (!(llllllllllllllIIIIllllllIllIIIIl instanceof TrackingDataInput)) {
            llllllllllllllIIIIllllllIllIIIIl = new TrackingDataInput((DataInput)llllllllllllllIIIIllllllIllIIIIl, this.maxBytes);
        }
        final BinaryTagType<? extends BinaryTag> llllllllllllllIIIIllllllIllIIIll = BinaryTagType.of(((DataInput)llllllllllllllIIIIllllllIllIIIIl).readByte());
        requireCompound(llllllllllllllIIIIllllllIllIIIll);
        ((DataInput)llllllllllllllIIIIllllllIllIIIIl).skipBytes(((DataInput)llllllllllllllIIIIllllllIllIIIIl).readUnsignedShort());
        return BinaryTagTypes.COMPOUND.read((DataInput)llllllllllllllIIIIllllllIllIIIIl);
    }
    
    private static void requireCompound(final BinaryTagType<? extends BinaryTag> llllllllllllllIIIIllllllIIlIllll) throws IOException {
        if (llllllllllllllIIIIllllllIIlIllll != BinaryTagTypes.COMPOUND) {
            throw new IOException(String.format("Expected root tag to be a %s, was %s", BinaryTagTypes.COMPOUND, llllllllllllllIIIIllllllIIlIllll));
        }
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag read(@NotNull final InputStream llllllllllllllIIIIllllllIlllIlII, final BinaryTagIO.Compression llllllllllllllIIIIllllllIlllIlIl) throws IOException {
        final DataInputStream llllllllllllllIIIIllllllIlllIIll = new DataInputStream(new BufferedInputStream(llllllllllllllIIIIllllllIlllIlIl.decompress(IOStreamUtil.closeShield(llllllllllllllIIIIllllllIlllIlII))));
        try {
            final String llllllllllllllIIIIllllllIllIlIll = (String)this.read((DataInput)llllllllllllllIIIIllllllIlllIIll);
            llllllllllllllIIIIllllllIlllIIll.close();
            return (CompoundBinaryTag)llllllllllllllIIIIllllllIllIlIll;
        }
        catch (Throwable llllllllllllllIIIIllllllIllIlIll) {
            try {
                llllllllllllllIIIIllllllIlllIIll.close();
            }
            catch (Throwable llllllllllllllIIIIllllllIllIlIlI) {
                ((Throwable)llllllllllllllIIIIllllllIllIlIll).addSuppressed(llllllllllllllIIIIllllllIllIlIlI);
            }
            throw llllllllllllllIIIIllllllIllIlIll;
        }
    }
    
    @Override
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final Path llllllllllllllIIIIllllllIlIllIIl, final BinaryTagIO.Compression llllllllllllllIIIIllllllIlIllIII) throws IOException {
        final InputStream llllllllllllllIIIIllllllIlIlIlll = Files.newInputStream(llllllllllllllIIIIllllllIlIllIIl, new OpenOption[0]);
        try {
            final short llllllllllllllIIIIllllllIlIIllll = (short)this.readNamed(llllllllllllllIIIIllllllIlIlIlll, llllllllllllllIIIIllllllIlIllIII);
            if (llllllllllllllIIIIllllllIlIlIlll != null) {
                llllllllllllllIIIIllllllIlIlIlll.close();
            }
            return (Map.Entry<String, CompoundBinaryTag>)llllllllllllllIIIIllllllIlIIllll;
        }
        catch (Throwable llllllllllllllIIIIllllllIlIIllll) {
            if (llllllllllllllIIIIllllllIlIlIlll != null) {
                try {
                    llllllllllllllIIIIllllllIlIlIlll.close();
                }
                catch (Throwable llllllllllllllIIIIllllllIlIIlllI) {
                    ((Throwable)llllllllllllllIIIIllllllIlIIllll).addSuppressed((Throwable)llllllllllllllIIIIllllllIlIIlllI);
                }
            }
            throw llllllllllllllIIIIllllllIlIIllll;
        }
    }
    
    BinaryTagReaderImpl(final long llllllllllllllIIIIlllllllIIlIIlI) {
        this.maxBytes = llllllllllllllIIIIlllllllIIlIIlI;
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag read(@NotNull final Path llllllllllllllIIIIlllllllIIIIllI, final BinaryTagIO.Compression llllllllllllllIIIIlllllllIIIIlll) throws IOException {
        final InputStream llllllllllllllIIIIlllllllIIIIlIl = Files.newInputStream(llllllllllllllIIIIlllllllIIIIllI, new OpenOption[0]);
        try {
            final boolean llllllllllllllIIIIllllllIlllllIl = (boolean)this.read(llllllllllllllIIIIlllllllIIIIlIl, llllllllllllllIIIIlllllllIIIIlll);
            if (llllllllllllllIIIIlllllllIIIIlIl != null) {
                llllllllllllllIIIIlllllllIIIIlIl.close();
            }
            return (CompoundBinaryTag)llllllllllllllIIIIllllllIlllllIl;
        }
        catch (Throwable llllllllllllllIIIIllllllIlllllIl) {
            if (llllllllllllllIIIIlllllllIIIIlIl != null) {
                try {
                    llllllllllllllIIIIlllllllIIIIlIl.close();
                }
                catch (Throwable llllllllllllllIIIIllllllIlllllII) {
                    ((Throwable)llllllllllllllIIIIllllllIlllllIl).addSuppressed((Throwable)llllllllllllllIIIIllllllIlllllII);
                }
            }
            throw llllllllllllllIIIIllllllIlllllIl;
        }
    }
    
    @Override
    public Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final InputStream llllllllllllllIIIIllllllIlIIIlll, final BinaryTagIO.Compression llllllllllllllIIIIllllllIlIIIllI) throws IOException {
        final DataInputStream llllllllllllllIIIIllllllIlIIIlIl = new DataInputStream(new BufferedInputStream(llllllllllllllIIIIllllllIlIIIllI.decompress(IOStreamUtil.closeShield(llllllllllllllIIIIllllllIlIIIlll))));
        try {
            final byte llllllllllllllIIIIllllllIIllllIl = (byte)this.readNamed((DataInput)llllllllllllllIIIIllllllIlIIIlIl);
            llllllllllllllIIIIllllllIlIIIlIl.close();
            return (Map.Entry<String, CompoundBinaryTag>)llllllllllllllIIIIllllllIIllllIl;
        }
        catch (Throwable llllllllllllllIIIIllllllIIllllIl) {
            try {
                llllllllllllllIIIIllllllIlIIIlIl.close();
            }
            catch (Throwable llllllllllllllIIIIllllllIIllllII) {
                ((Throwable)llllllllllllllIIIIllllllIIllllIl).addSuppressed((Throwable)llllllllllllllIIIIllllllIIllllII);
            }
            throw llllllllllllllIIIIllllllIIllllIl;
        }
    }
}
