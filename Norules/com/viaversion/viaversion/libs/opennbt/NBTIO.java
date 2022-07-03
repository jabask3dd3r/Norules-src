package com.viaversion.viaversion.libs.opennbt;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.zip.*;
import java.nio.charset.*;
import java.io.*;

public class NBTIO
{
    public static CompoundTag readTag(final InputStream lllllllllllllllllIlIIllllIIlIIlI) throws IOException {
        return readTag(lllllllllllllllllIlIIllllIIlIIlI, false);
    }
    
    public static void writeTag(final OutputStream lllllllllllllllllIlIIlllIlllIlIl, final CompoundTag lllllllllllllllllIlIIlllIlllIlll, final boolean lllllllllllllllllIlIIlllIlllIllI) throws IOException {
        writeTag(lllllllllllllllllIlIIlllIlllIllI ? new LittleEndianDataOutputStream(lllllllllllllllllIlIIlllIlllIlIl) : new DataOutputStream(lllllllllllllllllIlIIlllIlllIlIl), lllllllllllllllllIlIIlllIlllIlll);
    }
    
    public static CompoundTag readFile(final File lllllllllllllllllIlIIlllllIlIIll) throws IOException {
        return readFile(lllllllllllllllllIlIIlllllIlIIll, true, false);
    }
    
    public static CompoundTag readTag(final InputStream lllllllllllllllllIlIIllllIIIlllI, final boolean lllllllllllllllllIlIIllllIIIllIl) throws IOException {
        return readTag(lllllllllllllllllIlIIllllIIIllIl ? new LittleEndianDataInputStream(lllllllllllllllllIlIIllllIIIlllI) : new DataInputStream(lllllllllllllllllIlIIllllIIIlllI));
    }
    
    public static void writeFile(final CompoundTag lllllllllllllllllIlIIllllIllIllI, final String lllllllllllllllllIlIIllllIllIlIl) throws IOException {
        writeFile(lllllllllllllllllIlIIllllIllIllI, new File(lllllllllllllllllIlIIllllIllIlIl));
    }
    
    public static void writeTag(final DataOutput lllllllllllllllllIlIIlllIllIlllI, final CompoundTag lllllllllllllllllIlIIlllIllIllIl) throws IOException {
        lllllllllllllllllIlIIlllIllIlllI.writeByte(10);
        lllllllllllllllllIlIIlllIllIlllI.writeUTF("");
        lllllllllllllllllIlIIlllIllIllIl.write(lllllllllllllllllIlIIlllIllIlllI);
    }
    
    public static CompoundTag readTag(final DataInput lllllllllllllllllIlIIllllIIIIlII) throws IOException {
        final int lllllllllllllllllIlIIllllIIIIllI = lllllllllllllllllIlIIllllIIIIlII.readByte();
        if (lllllllllllllllllIlIIllllIIIIllI != 10) {
            throw new IOException(String.format("Expected root tag to be a CompoundTag, was %s", lllllllllllllllllIlIIllllIIIIllI));
        }
        lllllllllllllllllIlIIllllIIIIlII.skipBytes(lllllllllllllllllIlIIllllIIIIlII.readUnsignedShort());
        final CompoundTag lllllllllllllllllIlIIllllIIIIlIl = new CompoundTag();
        lllllllllllllllllIlIIllllIIIIlIl.read(lllllllllllllllllIlIIllllIIIIlII);
        return lllllllllllllllllIlIIllllIIIIlIl;
    }
    
    public static void writeTag(final OutputStream lllllllllllllllllIlIIlllIlllllIl, final CompoundTag lllllllllllllllllIlIIlllIllllllI) throws IOException {
        writeTag(lllllllllllllllllIlIIlllIlllllIl, lllllllllllllllllIlIIlllIllllllI, false);
    }
    
    public static void writeFile(final CompoundTag lllllllllllllllllIlIIllllIllIIlI, final File lllllllllllllllllIlIIllllIllIIIl) throws IOException {
        writeFile(lllllllllllllllllIlIIllllIllIIlI, lllllllllllllllllIlIIllllIllIIIl, true, false);
    }
    
    public static CompoundTag readFile(final File lllllllllllllllllIlIIllllIllllll, final boolean lllllllllllllllllIlIIllllIlllllI, final boolean lllllllllllllllllIlIIllllIllllIl) throws IOException {
        InputStream lllllllllllllllllIlIIlllllIIIIIl = new FileInputStream(lllllllllllllllllIlIIllllIllllll);
        if (lllllllllllllllllIlIIllllIlllllI) {
            lllllllllllllllllIlIIlllllIIIIIl = new GZIPInputStream(lllllllllllllllllIlIIlllllIIIIIl);
        }
        final Tag lllllllllllllllllIlIIlllllIIIIII = readTag(lllllllllllllllllIlIIlllllIIIIIl, lllllllllllllllllIlIIllllIllllIl);
        if (!(lllllllllllllllllIlIIlllllIIIIII instanceof CompoundTag)) {
            throw new IOException("Root tag is not a CompoundTag!");
        }
        return (CompoundTag)lllllllllllllllllIlIIlllllIIIIII;
    }
    
    public static CompoundTag readFile(final String lllllllllllllllllIlIIlllllIIllII, final boolean lllllllllllllllllIlIIlllllIIlllI, final boolean lllllllllllllllllIlIIlllllIIllIl) throws IOException {
        return readFile(new File(lllllllllllllllllIlIIlllllIIllII), lllllllllllllllllIlIIlllllIIlllI, lllllllllllllllllIlIIlllllIIllIl);
    }
    
    public static CompoundTag readFile(final String lllllllllllllllllIlIIlllllIlIlll) throws IOException {
        return readFile(new File(lllllllllllllllllIlIIlllllIlIlll));
    }
    
    public static void writeFile(final CompoundTag lllllllllllllllllIlIIllllIIllIII, final File lllllllllllllllllIlIIllllIIlllII, final boolean lllllllllllllllllIlIIllllIIllIll, final boolean lllllllllllllllllIlIIllllIIllIlI) throws IOException {
        if (!lllllllllllllllllIlIIllllIIlllII.exists()) {
            if (lllllllllllllllllIlIIllllIIlllII.getParentFile() != null && !lllllllllllllllllIlIIllllIIlllII.getParentFile().exists()) {
                lllllllllllllllllIlIIllllIIlllII.getParentFile().mkdirs();
            }
            lllllllllllllllllIlIIllllIIlllII.createNewFile();
        }
        OutputStream lllllllllllllllllIlIIllllIIllIIl = new FileOutputStream(lllllllllllllllllIlIIllllIIlllII);
        if (lllllllllllllllllIlIIllllIIllIll) {
            lllllllllllllllllIlIIllllIIllIIl = new GZIPOutputStream(lllllllllllllllllIlIIllllIIllIIl);
        }
        writeTag(lllllllllllllllllIlIIllllIIllIIl, lllllllllllllllllIlIIllllIIllIII, lllllllllllllllllIlIIllllIIllIlI);
        lllllllllllllllllIlIIllllIIllIIl.close();
    }
    
    public static void writeFile(final CompoundTag lllllllllllllllllIlIIllllIlIlIlI, final String lllllllllllllllllIlIIllllIlIIlIl, final boolean lllllllllllllllllIlIIllllIlIIlII, final boolean lllllllllllllllllIlIIllllIlIIlll) throws IOException {
        writeFile(lllllllllllllllllIlIIllllIlIlIlI, new File(lllllllllllllllllIlIIllllIlIIlIl), lllllllllllllllllIlIIllllIlIIlII, lllllllllllllllllIlIIllllIlIIlll);
    }
    
    private static final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput
    {
        @Override
        public synchronized void write(final byte[] lIllIIIIIllIlI, final int lIllIIIIIllIIl, final int lIllIIIIIlIlII) throws IOException {
            this.out.write(lIllIIIIIllIlI, lIllIIIIIllIIl, lIllIIIIIlIlII);
        }
        
        @Override
        public void writeChar(final int lIlIlllllllIIl) throws IOException {
            this.out.write(lIlIlllllllIIl & 0xFF);
            this.out.write(lIlIlllllllIIl >>> 8 & 0xFF);
        }
        
        @Override
        public synchronized void write(final int lIllIIIIlIIIII) throws IOException {
            this.out.write(lIllIIIIlIIIII);
        }
        
        @Override
        public void writeDouble(final double lIlIlllllIIIIl) throws IOException {
            this.writeLong(Double.doubleToLongBits(lIlIlllllIIIIl));
        }
        
        @Override
        public void writeBytes(final String lIlIllllIlIlII) throws IOException {
            for (int lIlIllllIlIllI = lIlIllllIlIlII.length(), lIlIllllIllIIl = 0; lIlIllllIllIIl < lIlIllllIlIllI; ++lIlIllllIllIIl) {
                this.out.write((byte)lIlIllllIlIlII.charAt(lIlIllllIllIIl));
            }
        }
        
        @Override
        public void writeBoolean(final boolean lIllIIIIIIlIll) throws IOException {
            this.out.write(lIllIIIIIIlIll ? 1 : 0);
        }
        
        @Override
        public void flush() throws IOException {
            this.out.flush();
        }
        
        @Override
        public void writeInt(final int lIlIllllllIlIl) throws IOException {
            this.out.write(lIlIllllllIlIl & 0xFF);
            this.out.write(lIlIllllllIlIl >>> 8 & 0xFF);
            this.out.write(lIlIllllllIlIl >>> 16 & 0xFF);
            this.out.write(lIlIllllllIlIl >>> 24 & 0xFF);
        }
        
        @Override
        public void writeUTF(final String lIlIlllIllIIll) throws IOException {
            final byte[] lIlIlllIllIlIl = lIlIlllIllIIll.getBytes(StandardCharsets.UTF_8);
            this.writeShort(lIlIlllIllIlIl.length);
            this.write(lIlIlllIllIlIl);
        }
        
        private LittleEndianDataOutputStream(final OutputStream lIllIIIIlIIllI) {
            super(lIllIIIIlIIllI);
        }
        
        @Override
        public void writeLong(final long lIlIlllllIllIl) throws IOException {
            this.out.write((int)(lIlIlllllIllIl & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 8 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 16 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 24 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 32 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 40 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 48 & 0xFFL));
            this.out.write((int)(lIlIlllllIllIl >>> 56 & 0xFFL));
        }
        
        @Override
        public void writeChars(final String lIlIllllIIIlIl) throws IOException {
            for (int lIlIllllIIIIll = lIlIllllIIIlIl.length(), lIlIllllIIlIIl = 0; lIlIllllIIlIIl < lIlIllllIIIIll; ++lIlIllllIIlIIl) {
                final char lIlIllllIIlIlI = lIlIllllIIIlIl.charAt(lIlIllllIIlIIl);
                this.out.write(lIlIllllIIlIlI & '\u00ff');
                this.out.write(lIlIllllIIlIlI >>> 8 & 0xFF);
            }
        }
        
        @Override
        public void writeFloat(final float lIlIlllllIlIIl) throws IOException {
            this.writeInt(Float.floatToIntBits(lIlIlllllIlIIl));
        }
        
        @Override
        public void writeByte(final int lIllIIIIIIIlll) throws IOException {
            this.out.write(lIllIIIIIIIlll);
        }
        
        @Override
        public void writeShort(final int lIllIIIIIIIIIl) throws IOException {
            this.out.write(lIllIIIIIIIIIl & 0xFF);
            this.out.write(lIllIIIIIIIIIl >>> 8 & 0xFF);
        }
    }
    
    private static final class LittleEndianDataInputStream extends FilterInputStream implements DataInput
    {
        private LittleEndianDataInputStream(final InputStream llllllllllllllIlIIIIIIllllIlIIll) {
            super(llllllllllllllIlIIIIIIllllIlIIll);
        }
        
        @Override
        public long readLong() throws IOException {
            final long llllllllllllllIlIIIIIIllIlIlIlII = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIlIIll = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIlIIlI = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIlIIIl = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIlIIII = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIIllll = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIIlllI = this.in.read();
            final long llllllllllllllIlIIIIIIllIlIIllIl = this.in.read();
            if ((llllllllllllllIlIIIIIIllIlIlIlII | llllllllllllllIlIIIIIIllIlIlIIll | llllllllllllllIlIIIIIIllIlIlIIlI | llllllllllllllIlIIIIIIllIlIlIIIl | llllllllllllllIlIIIIIIllIlIlIIII | llllllllllllllIlIIIIIIllIlIIllll | llllllllllllllIlIIIIIIllIlIIlllI | llllllllllllllIlIIIIIIllIlIIllIl) < 0L) {
                throw new EOFException();
            }
            return llllllllllllllIlIIIIIIllIlIlIlII | llllllllllllllIlIIIIIIllIlIlIIll << 8 | llllllllllllllIlIIIIIIllIlIlIIlI << 16 | llllllllllllllIlIIIIIIllIlIlIIIl << 24 | llllllllllllllIlIIIIIIllIlIlIIII << 32 | llllllllllllllIlIIIIIIllIlIIllll << 40 | llllllllllllllIlIIIIIIllIlIIlllI << 48 | llllllllllllllIlIIIIIIllIlIIllIl << 56;
        }
        
        @Override
        public short readShort() throws IOException {
            final int llllllllllllllIlIIIIIIlllIIIIlII = this.in.read();
            final int llllllllllllllIlIIIIIIlllIIIIIll = this.in.read();
            if ((llllllllllllllIlIIIIIIlllIIIIlII | llllllllllllllIlIIIIIIlllIIIIIll) < 0) {
                throw new EOFException();
            }
            return (short)(llllllllllllllIlIIIIIIlllIIIIlII | llllllllllllllIlIIIIIIlllIIIIIll << 8);
        }
        
        @Override
        public int readUnsignedByte() throws IOException {
            final int llllllllllllllIlIIIIIIlllIIIlIll = this.in.read();
            if (llllllllllllllIlIIIIIIlllIIIlIll < 0) {
                throw new EOFException();
            }
            return llllllllllllllIlIIIIIIlllIIIlIll;
        }
        
        @Override
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(this.readInt());
        }
        
        @Override
        public int read(final byte[] llllllllllllllIlIIIIIIllllIIIIIl, final int llllllllllllllIlIIIIIIllllIIIIII, final int llllllllllllllIlIIIIIIlllIllllll) throws IOException {
            return this.in.read(llllllllllllllIlIIIIIIllllIIIIIl, llllllllllllllIlIIIIIIllllIIIIII, llllllllllllllIlIIIIIIlllIllllll);
        }
        
        @Override
        public String readUTF() throws IOException {
            final byte[] llllllllllllllIlIIIIIIllIIlllIIl = new byte[this.readUnsignedShort()];
            this.readFully(llllllllllllllIlIIIIIIllIIlllIIl);
            return new String(llllllllllllllIlIIIIIIllIIlllIIl, StandardCharsets.UTF_8);
        }
        
        @Override
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(this.readLong());
        }
        
        @Override
        public int readUnsignedShort() throws IOException {
            final int llllllllllllllIlIIIIIIllIllllIll = this.in.read();
            final int llllllllllllllIlIIIIIIllIllllIlI = this.in.read();
            if ((llllllllllllllIlIIIIIIllIllllIll | llllllllllllllIlIIIIIIllIllllIlI) < 0) {
                throw new EOFException();
            }
            return llllllllllllllIlIIIIIIllIllllIll | llllllllllllllIlIIIIIIllIllllIlI << 8;
        }
        
        @Override
        public boolean readBoolean() throws IOException {
            final int llllllllllllllIlIIIIIIlllIIlIlll = this.in.read();
            if (llllllllllllllIlIIIIIIlllIIlIlll < 0) {
                throw new EOFException();
            }
            return llllllllllllllIlIIIIIIlllIIlIlll != 0;
        }
        
        @Override
        public void readFully(final byte[] llllllllllllllIlIIIIIIlllIlllIll) throws IOException {
            this.readFully(llllllllllllllIlIIIIIIlllIlllIll, 0, llllllllllllllIlIIIIIIlllIlllIll.length);
        }
        
        @Override
        public char readChar() throws IOException {
            final int llllllllllllllIlIIIIIIllIlllIIlI = this.in.read();
            final int llllllllllllllIlIIIIIIllIlllIIIl = this.in.read();
            if ((llllllllllllllIlIIIIIIllIlllIIlI | llllllllllllllIlIIIIIIllIlllIIIl) < 0) {
                throw new EOFException();
            }
            return (char)(llllllllllllllIlIIIIIIllIlllIIlI | llllllllllllllIlIIIIIIllIlllIIIl << 8);
        }
        
        @Override
        public void readFully(final byte[] llllllllllllllIlIIIIIIlllIlIllll, final int llllllllllllllIlIIIIIIlllIlIlllI, final int llllllllllllllIlIIIIIIlllIlIlIIl) throws IOException {
            if (llllllllllllllIlIIIIIIlllIlIlIIl < 0) {
                throw new IndexOutOfBoundsException();
            }
            int llllllllllllllIlIIIIIIlllIllIIlI;
            for (int llllllllllllllIlIIIIIIlllIllIIIl = 0; llllllllllllllIlIIIIIIlllIllIIIl < llllllllllllllIlIIIIIIlllIlIlIIl; llllllllllllllIlIIIIIIlllIllIIIl += llllllllllllllIlIIIIIIlllIllIIlI) {
                llllllllllllllIlIIIIIIlllIllIIlI = this.in.read(llllllllllllllIlIIIIIIlllIlIllll, llllllllllllllIlIIIIIIlllIlIlllI + llllllllllllllIlIIIIIIlllIllIIIl, llllllllllllllIlIIIIIIlllIlIlIIl - llllllllllllllIlIIIIIIlllIllIIIl);
                if (llllllllllllllIlIIIIIIlllIllIIlI < 0) {
                    throw new EOFException();
                }
            }
        }
        
        @Override
        public int readInt() throws IOException {
            final int llllllllllllllIlIIIIIIllIllIIlll = this.in.read();
            final int llllllllllllllIlIIIIIIllIllIIllI = this.in.read();
            final int llllllllllllllIlIIIIIIllIllIIlIl = this.in.read();
            final int llllllllllllllIlIIIIIIllIllIIlII = this.in.read();
            if ((llllllllllllllIlIIIIIIllIllIIlll | llllllllllllllIlIIIIIIllIllIIllI | llllllllllllllIlIIIIIIllIllIIlIl | llllllllllllllIlIIIIIIllIllIIlII) < 0) {
                throw new EOFException();
            }
            return llllllllllllllIlIIIIIIllIllIIlll | llllllllllllllIlIIIIIIllIllIIllI << 8 | llllllllllllllIlIIIIIIllIllIIlIl << 16 | llllllllllllllIlIIIIIIllIllIIlII << 24;
        }
        
        @Override
        public String readLine() throws IOException {
            throw new UnsupportedOperationException("Use readUTF.");
        }
        
        @Override
        public byte readByte() throws IOException {
            final int llllllllllllllIlIIIIIIlllIIlIIIl = this.in.read();
            if (llllllllllllllIlIIIIIIlllIIlIIIl < 0) {
                throw new EOFException();
            }
            return (byte)llllllllllllllIlIIIIIIlllIIlIIIl;
        }
        
        @Override
        public int skipBytes(final int llllllllllllllIlIIIIIIlllIIlllIl) throws IOException {
            int llllllllllllllIlIIIIIIlllIlIIIII = 0;
            for (int llllllllllllllIlIIIIIIlllIIlllll = 0; llllllllllllllIlIIIIIIlllIlIIIII < llllllllllllllIlIIIIIIlllIIlllIl && (llllllllllllllIlIIIIIIlllIIlllll = (int)this.in.skip(llllllllllllllIlIIIIIIlllIIlllIl - llllllllllllllIlIIIIIIlllIlIIIII)) > 0; llllllllllllllIlIIIIIIlllIlIIIII += llllllllllllllIlIIIIIIlllIIlllll) {}
            return llllllllllllllIlIIIIIIlllIlIIIII;
        }
        
        @Override
        public int read(final byte[] llllllllllllllIlIIIIIIllllIIllIl) throws IOException {
            return this.in.read(llllllllllllllIlIIIIIIllllIIllIl, 0, llllllllllllllIlIIIIIIllllIIllIl.length);
        }
    }
}
