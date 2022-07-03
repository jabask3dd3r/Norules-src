package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;

public final class BinaryTagIO
{
    private BinaryTagIO() {
    }
    
    @NotNull
    public static Reader unlimitedReader() {
        return BinaryTagReaderImpl.UNLIMITED;
    }
    
    @Deprecated
    @NotNull
    public static CompoundBinaryTag readCompressedInputStream(@NotNull final InputStream lllllllllllllIlIIIlIIIlllllllIll) throws IOException {
        return reader().read(lllllllllllllIlIIIlIIIlllllllIll, Compression.GZIP);
    }
    
    @Deprecated
    public static void writeCompressedPath(@NotNull final CompoundBinaryTag lllllllllllllIlIIIlIIIlllllIIIlI, @NotNull final Path lllllllllllllIlIIIlIIIlllllIIIIl) throws IOException {
        writer().write(lllllllllllllIlIIIlIIIlllllIIIlI, lllllllllllllIlIIIlIIIlllllIIIIl, Compression.GZIP);
    }
    
    @Deprecated
    public static void writeCompressedOutputStream(@NotNull final CompoundBinaryTag lllllllllllllIlIIIlIIIllllIllIlI, @NotNull final OutputStream lllllllllllllIlIIIlIIIllllIllIIl) throws IOException {
        writer().write(lllllllllllllIlIIIlIIIllllIllIlI, lllllllllllllIlIIIlIIIllllIllIIl, Compression.GZIP);
    }
    
    static {
        BinaryTagTypes.COMPOUND.id();
    }
    
    @Deprecated
    public static void writeDataOutput(@NotNull final CompoundBinaryTag lllllllllllllIlIIIlIIIllllIlIIIl, @NotNull final DataOutput lllllllllllllIlIIIlIIIllllIlIIlI) throws IOException {
        writer().write(lllllllllllllIlIIIlIIIllllIlIIIl, lllllllllllllIlIIIlIIIllllIlIIlI);
    }
    
    @Deprecated
    @NotNull
    public static CompoundBinaryTag readDataInput(@NotNull final DataInput lllllllllllllIlIIIlIIIllllllIlll) throws IOException {
        return reader().read(lllllllllllllIlIIIlIIIllllllIlll);
    }
    
    @Deprecated
    @NotNull
    public static CompoundBinaryTag readCompressedPath(@NotNull final Path lllllllllllllIlIIIlIIIllllllllll) throws IOException {
        return reader().read(lllllllllllllIlIIIlIIIllllllllll, Compression.GZIP);
    }
    
    @Deprecated
    public static void writeOutputStream(@NotNull final CompoundBinaryTag lllllllllllllIlIIIlIIIlllllIlIIl, @NotNull final OutputStream lllllllllllllIlIIIlIIIlllllIlIlI) throws IOException {
        writer().write(lllllllllllllIlIIIlIIIlllllIlIIl, lllllllllllllIlIIIlIIIlllllIlIlI);
    }
    
    @Deprecated
    @NotNull
    public static CompoundBinaryTag readInputStream(@NotNull final InputStream lllllllllllllIlIIIlIIlIIIIIIIIll) throws IOException {
        return reader().read(lllllllllllllIlIIIlIIlIIIIIIIIll);
    }
    
    @NotNull
    public static Reader reader(final long lllllllllllllIlIIIlIIlIIIIIIlIll) {
        if (lllllllllllllIlIIIlIIlIIIIIIlIll <= 0L) {
            throw new IllegalArgumentException("The size limit must be greater than zero");
        }
        return new BinaryTagReaderImpl(lllllllllllllIlIIIlIIlIIIIIIlIll);
    }
    
    @NotNull
    public static Writer writer() {
        return BinaryTagWriterImpl.INSTANCE;
    }
    
    @Deprecated
    public static void writePath(@NotNull final CompoundBinaryTag lllllllllllllIlIIIlIIIllllllIIlI, @NotNull final Path lllllllllllllIlIIIlIIIllllllIIIl) throws IOException {
        writer().write(lllllllllllllIlIIIlIIIllllllIIlI, lllllllllllllIlIIIlIIIllllllIIIl);
    }
    
    @Deprecated
    @NotNull
    public static CompoundBinaryTag readPath(@NotNull final Path lllllllllllllIlIIIlIIlIIIIIIIlll) throws IOException {
        return reader().read(lllllllllllllIlIIIlIIlIIIIIIIlll);
    }
    
    @NotNull
    public static Reader reader() {
        return BinaryTagReaderImpl.DEFAULT_LIMIT;
    }
    
    public interface Reader
    {
        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final Path llllllllllllllIlIIIIIllIllIIllll, @NotNull final Compression llllllllllllllIlIIIIIllIllIlIIII) throws IOException;
        
        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final DataInput llllllllllllllIlIIIIIllIllIIIlIl) throws IOException;
        
        @NotNull
        CompoundBinaryTag read(@NotNull final DataInput llllllllllllllIlIIIIIllIllIllIII) throws IOException;
        
        @NotNull
        CompoundBinaryTag read(@NotNull final Path llllllllllllllIlIIIIIllIlllIIIlI, @NotNull final Compression llllllllllllllIlIIIIIllIlllIIIll) throws IOException;
        
        @NotNull
        CompoundBinaryTag read(@NotNull final InputStream llllllllllllllIlIIIIIllIllIllIIl, @NotNull final Compression llllllllllllllIlIIIIIllIllIllIlI) throws IOException;
        
        default Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final Path llllllllllllllIlIIIIIllIllIlIlIl) throws IOException {
            return this.readNamed(llllllllllllllIlIIIIIllIllIlIlIl, Compression.NONE);
        }
        
        Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final InputStream llllllllllllllIlIIIIIllIllIIIllI, @NotNull final Compression llllllllllllllIlIIIIIllIllIIIlll) throws IOException;
        
        default Map.Entry<String, CompoundBinaryTag> readNamed(@NotNull final InputStream llllllllllllllIlIIIIIllIllIIllII) throws IOException {
            return this.readNamed(llllllllllllllIlIIIIIllIllIIllII, Compression.NONE);
        }
        
        @NotNull
        default CompoundBinaryTag read(@NotNull final Path llllllllllllllIlIIIIIllIlllIlIII) throws IOException {
            return this.read(llllllllllllllIlIIIIIllIlllIlIII, Compression.NONE);
        }
        
        @NotNull
        default CompoundBinaryTag read(@NotNull final InputStream llllllllllllllIlIIIIIllIllIlllll) throws IOException {
            return this.read(llllllllllllllIlIIIIIllIllIlllll, Compression.NONE);
        }
    }
    
    public abstract static class Compression
    {
        public static final /* synthetic */ Compression GZIP;
        public static final /* synthetic */ Compression NONE;
        
        static {
            NONE = new Compression() {
                @NotNull
                @Override
                OutputStream compress(@NotNull final OutputStream lllllllllllllIIIIIllIIlIIlIllIIl) {
                    return lllllllllllllIIIIIllIIlIIlIllIIl;
                }
                
                @NotNull
                @Override
                InputStream decompress(@NotNull final InputStream lllllllllllllIIIIIllIIlIIlIllllI) {
                    return lllllllllllllIIIIIllIIlIIlIllllI;
                }
                
                @Override
                public String toString() {
                    return "Compression.NONE";
                }
            };
            GZIP = new Compression() {
                @Override
                public String toString() {
                    return "Compression.GZIP";
                }
                
                @NotNull
                @Override
                InputStream decompress(@NotNull final InputStream lllllllllllllIlIIllllIIIlllIlIIl) throws IOException {
                    return new GZIPInputStream(lllllllllllllIlIIllllIIIlllIlIIl);
                }
                
                @NotNull
                @Override
                OutputStream compress(@NotNull final OutputStream lllllllllllllIlIIllllIIIlllIIlII) throws IOException {
                    return new GZIPOutputStream(lllllllllllllIlIIllllIIIlllIIlII);
                }
            };
            ZLIB = new Compression() {
                @Override
                public String toString() {
                    return "Compression.ZLIB";
                }
                
                @NotNull
                @Override
                InputStream decompress(@NotNull final InputStream lllllllllllllIlllllIIIIIlIIIIIll) {
                    return new InflaterInputStream(lllllllllllllIlllllIIIIIlIIIIIll);
                }
                
                @NotNull
                @Override
                OutputStream compress(@NotNull final OutputStream lllllllllllllIlllllIIIIIIllllllI) {
                    return new DeflaterOutputStream(lllllllllllllIlllllIIIIIIllllllI);
                }
            };
        }
        
        @NotNull
        abstract InputStream decompress(@NotNull final InputStream lllllllllllllIlIIIIllIlIIllIllIl) throws IOException;
        
        @NotNull
        abstract OutputStream compress(@NotNull final OutputStream lllllllllllllIlIIIIllIlIIllIllII) throws IOException;
    }
    
    public interface Writer
    {
        default void write(@NotNull final CompoundBinaryTag lllllllllllllIIlIIIIllllIIlIIIlI, @NotNull final OutputStream lllllllllllllIIlIIIIllllIIlIIIIl) throws IOException {
            this.write(lllllllllllllIIlIIIIllllIIlIIIlI, lllllllllllllIIlIIIIllllIIlIIIIl, Compression.NONE);
        }
        
        void write(@NotNull final CompoundBinaryTag lllllllllllllIIlIIIIllllIIlIIlll, @NotNull final Path lllllllllllllIIlIIIIllllIIlIlIII, @NotNull final Compression lllllllllllllIIlIIIIllllIIlIIllI) throws IOException;
        
        void write(@NotNull final CompoundBinaryTag lllllllllllllIIlIIIIllllIIIllIlI, @NotNull final OutputStream lllllllllllllIIlIIIIllllIIIllIIl, @NotNull final Compression lllllllllllllIIlIIIIllllIIIllIII) throws IOException;
        
        void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIlIIIIlllIllllllII, @NotNull final OutputStream lllllllllllllIIlIIIIlllIlllllIlI, @NotNull final Compression lllllllllllllIIlIIIIlllIlllllIll) throws IOException;
        
        default void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIlIIIIllllIIIlIIlI, @NotNull final Path lllllllllllllIIlIIIIllllIIIlIIIl) throws IOException {
            this.writeNamed(lllllllllllllIIlIIIIllllIIIlIIlI, lllllllllllllIIlIIIIllllIIIlIIIl, Compression.NONE);
        }
        
        void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIlIIIIlllIlllllIIl, @NotNull final DataOutput lllllllllllllIIlIIIIlllIlllllIII) throws IOException;
        
        default void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIlIIIIllllIIIIIIll, @NotNull final OutputStream lllllllllllllIIlIIIIllllIIIIIlII) throws IOException {
            this.writeNamed(lllllllllllllIIlIIIIllllIIIIIIll, lllllllllllllIIlIIIIllllIIIIIlII, Compression.NONE);
        }
        
        void write(@NotNull final CompoundBinaryTag lllllllllllllIIlIIIIllllIIIlIlll, @NotNull final DataOutput lllllllllllllIIlIIIIllllIIIlIllI) throws IOException;
        
        default void write(@NotNull final CompoundBinaryTag lllllllllllllIIlIIIIllllIIlIllll, @NotNull final Path lllllllllllllIIlIIIIllllIIllIIII) throws IOException {
            this.write(lllllllllllllIIlIIIIllllIIlIllll, lllllllllllllIIlIIIIllllIIllIIII, Compression.NONE);
        }
        
        void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIlIIIIllllIIIIlIlI, @NotNull final Path lllllllllllllIIlIIIIllllIIIIlIII, @NotNull final Compression lllllllllllllIIlIIIIllllIIIIlIIl) throws IOException;
    }
}
