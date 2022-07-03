package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.io.*;
import org.jetbrains.annotations.*;

final class TrackingDataInput implements BinaryTagScope, DataInput
{
    private /* synthetic */ long counter;
    private /* synthetic */ int depth;
    private final /* synthetic */ DataInput input;
    private final /* synthetic */ long maxLength;
    
    @Override
    public short readShort() throws IOException {
        this.counter += 2L;
        return this.input.readShort();
    }
    
    TrackingDataInput(final DataInput lllllllllllllIIIlllIllIlIIIIIIIl, final long lllllllllllllIIIlllIllIlIIIIIIII) {
        this.input = lllllllllllllIIIlllIllIlIIIIIIIl;
        this.maxLength = lllllllllllllIIIlllIllIlIIIIIIII;
    }
    
    static {
        MAX_DEPTH = 512;
    }
    
    @NotNull
    @Override
    public String readUTF() throws IOException {
        final String lllllllllllllIIIlllIllIIlIIlIIlI = this.input.readUTF();
        this.counter += lllllllllllllIIIlllIllIIlIIlIIlI.length() * 2L + 2L;
        return lllllllllllllIIIlllIllIIlIIlIIlI;
    }
    
    public void exit() throws IOException {
        --this.depth;
        this.ensureMaxLength(0L);
    }
    
    @Override
    public int readInt() throws IOException {
        this.counter += 4L;
        return this.input.readInt();
    }
    
    @Nullable
    @Override
    public String readLine() throws IOException {
        final String lllllllllllllIIIlllIllIIlIIllIII = this.input.readLine();
        if (lllllllllllllIIIlllIllIIlIIllIII != null) {
            this.counter += lllllllllllllIIIlllIllIIlIIllIII.length() + 1;
        }
        return lllllllllllllIIIlllIllIIlIIllIII;
    }
    
    @Override
    public char readChar() throws IOException {
        this.counter += 2L;
        return this.input.readChar();
    }
    
    @Override
    public int skipBytes(final int lllllllllllllIIIlllIllIIlIlllllI) throws IOException {
        return this.input.skipBytes(lllllllllllllIIIlllIllIIlIlllllI);
    }
    
    @Override
    public int readUnsignedShort() throws IOException {
        this.counter += 2L;
        return this.input.readUnsignedShort();
    }
    
    @Override
    public double readDouble() throws IOException {
        this.counter += 8L;
        return this.input.readDouble();
    }
    
    public DataInput input() {
        return this.input;
    }
    
    @Override
    public float readFloat() throws IOException {
        this.counter += 4L;
        return this.input.readFloat();
    }
    
    public TrackingDataInput enter() throws IOException {
        if (this.depth++ > 512) {
            throw new IOException("NBT read exceeded maximum depth of 512");
        }
        this.ensureMaxLength(0L);
        return this;
    }
    
    public static BinaryTagScope enter(final DataInput lllllllllllllIIIlllIllIIlllllIII) throws IOException {
        if (lllllllllllllIIIlllIllIIlllllIII instanceof TrackingDataInput) {
            return ((TrackingDataInput)lllllllllllllIIIlllIllIIlllllIII).enter();
        }
        return NoOp.INSTANCE;
    }
    
    @Override
    public void readFully(final byte[] lllllllllllllIIIlllIllIIllIIlIIl, final int lllllllllllllIIIlllIllIIllIIlIll, final int lllllllllllllIIIlllIllIIllIIlIlI) throws IOException {
        this.counter += lllllllllllllIIIlllIllIIllIIlIlI;
        this.input.readFully(lllllllllllllIIIlllIllIIllIIlIIl, lllllllllllllIIIlllIllIIllIIlIll, lllllllllllllIIIlllIllIIllIIlIlI);
    }
    
    @Override
    public void close() throws IOException {
        this.exit();
    }
    
    @Override
    public long readLong() throws IOException {
        this.counter += 8L;
        return this.input.readLong();
    }
    
    private void ensureMaxLength(final long lllllllllllllIIIlllIllIIllIllIll) throws IOException {
        if (this.maxLength > 0L && this.counter + lllllllllllllIIIlllIllIIllIllIll > this.maxLength) {
            throw new IOException(String.valueOf(new StringBuilder().append("The read NBT was longer than the maximum allowed size of ").append(this.maxLength).append(" bytes!")));
        }
    }
    
    @Override
    public int readUnsignedByte() throws IOException {
        ++this.counter;
        return this.input.readUnsignedByte();
    }
    
    @Override
    public void readFully(final byte[] lllllllllllllIIIlllIllIIllIlIlII) throws IOException {
        this.counter += lllllllllllllIIIlllIllIIllIlIlII.length;
        this.input.readFully(lllllllllllllIIIlllIllIIllIlIlII);
    }
    
    public TrackingDataInput enter(final long lllllllllllllIIIlllIllIIlllIlIII) throws IOException {
        if (this.depth++ > 512) {
            throw new IOException("NBT read exceeded maximum depth of 512");
        }
        this.ensureMaxLength(lllllllllllllIIIlllIllIIlllIlIII);
        return this;
    }
    
    public static BinaryTagScope enter(final DataInput lllllllllllllIIIlllIllIIllllIIll, final long lllllllllllllIIIlllIllIIllllIIlI) throws IOException {
        if (lllllllllllllIIIlllIllIIllllIIll instanceof TrackingDataInput) {
            return ((TrackingDataInput)lllllllllllllIIIlllIllIIllllIIll).enter(lllllllllllllIIIlllIllIIllllIIlI);
        }
        return NoOp.INSTANCE;
    }
    
    @Override
    public boolean readBoolean() throws IOException {
        ++this.counter;
        return this.input.readBoolean();
    }
    
    @Override
    public byte readByte() throws IOException {
        ++this.counter;
        return this.input.readByte();
    }
}
