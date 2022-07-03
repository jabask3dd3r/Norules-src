package net.minecraft.network;

import net.minecraft.util.text.*;
import io.netty.util.*;
import net.minecraft.util.math.*;
import java.nio.*;
import javax.annotation.*;
import java.nio.channels.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import io.netty.handler.codec.*;
import java.util.*;
import net.minecraft.util.*;
import io.netty.buffer.*;
import java.io.*;
import java.nio.charset.*;

public class PacketBuffer extends ByteBuf
{
    private final /* synthetic */ ByteBuf buf;
    
    public ByteBuf readBytes(final int llllllllllllIlllllllIIIIIIIIlllI) {
        return this.buf.readBytes(llllllllllllIlllllllIIIIIIIIlllI);
    }
    
    public ByteBuf writeZero(final int llllllllllllIllllllIlllIllllllll) {
        return this.buf.writeZero(llllllllllllIllllllIlllIllllllll);
    }
    
    public PacketBuffer writeByteArray(final byte[] llllllllllllIlllllllIIlllIlIlIIl) {
        this.writeVarIntToBuffer(llllllllllllIlllllllIIlllIlIlIIl.length);
        this.writeBytes(llllllllllllIlllllllIIlllIlIlIIl);
        return this;
    }
    
    public byte[] array() {
        return this.buf.array();
    }
    
    public static int getVarIntSize(final int llllllllllllIlllllllIIlllIllIIII) {
        for (int llllllllllllIlllllllIIlllIlIllll = 1; llllllllllllIlllllllIIlllIlIllll < 5; ++llllllllllllIlllllllIIlllIlIllll) {
            if ((llllllllllllIlllllllIIlllIllIIII & -1 << llllllllllllIlllllllIIlllIlIllll * 7) == 0x0) {
                return llllllllllllIlllllllIIlllIlIllll;
            }
        }
        return 5;
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllIllllllIlllllllIIIIl) {
        return this.buf.readBytes(llllllllllllIllllllIlllllllIIIIl);
    }
    
    public ByteBuf writeBytes(final ByteBuffer llllllllllllIllllllIllllIIlIIIIl) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIlIIIIl);
    }
    
    public ByteBuf ensureWritable(final int llllllllllllIlllllllIIlIIlIIIIIl) {
        return this.buf.ensureWritable(llllllllllllIlllllllIIlIIlIIIIIl);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllllIlllllllIlIIl, final int llllllllllllIllllllIlllllllIllII, final int llllllllllllIllllllIlllllllIlIll) {
        return this.buf.readBytes(llllllllllllIllllllIlllllllIlIIl, llllllllllllIllllllIlllllllIllII, llllllllllllIllllllIlllllllIlIll);
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIlIIllIII, final byte[] llllllllllllIlllllllIIIIlIIlllII, final int llllllllllllIlllllllIIIIlIIlIllI, final int llllllllllllIlllllllIIIIlIIllIlI) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIIllIII, llllllllllllIlllllllIIIIlIIlllII, llllllllllllIlllllllIIIIlIIlIllI, llllllllllllIlllllllIIIIlIIllIlI);
    }
    
    public ByteBuf setLongLE(final int llllllllllllIlllllllIIIIllllIIII, final long llllllllllllIlllllllIIIIlllIllII) {
        return this.buf.setLongLE(llllllllllllIlllllllIIIIllllIIII, llllllllllllIlllllllIIIIlllIllII);
    }
    
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }
    
    public ByteBuf touch() {
        return this.buf.touch();
    }
    
    public ByteBuf writeDouble(final double llllllllllllIllllllIllllIlIlIlII) {
        return this.buf.writeDouble(llllllllllllIllllllIllllIlIlIlII);
    }
    
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }
    
    public int getBytes(final int llllllllllllIlllllllIIIlIllIIlll, final GatheringByteChannel llllllllllllIlllllllIIIlIllIIllI, final int llllllllllllIlllllllIIIlIllIIIIl) throws IOException {
        return this.buf.getBytes(llllllllllllIlllllllIIIlIllIIlll, llllllllllllIlllllllIIIlIllIIllI, llllllllllllIlllllllIIIlIllIIIIl);
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllIllllllIllllIIllIIll) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIllIIll);
    }
    
    public ByteBuf setMediumLE(final int llllllllllllIlllllllIIIlIIIlIIIl, final int llllllllllllIlllllllIIIlIIIlIIII) {
        return this.buf.setMediumLE(llllllllllllIlllllllIIIlIIIlIIIl, llllllllllllIlllllllIIIlIIIlIIII);
    }
    
    public int bytesBefore(final int llllllllllllIllllllIlllIllIllIlI, final byte llllllllllllIllllllIlllIllIllIIl) {
        return this.buf.bytesBefore(llllllllllllIllllllIlllIllIllIlI, llllllllllllIllllllIlllIllIllIIl);
    }
    
    public PacketBuffer writeTextComponent(final ITextComponent llllllllllllIlllllllIIllIlIIIIIl) {
        return this.writeString(ITextComponent.Serializer.componentToJson(llllllllllllIlllllllIIllIlIIIIIl));
    }
    
    public ByteBuf writeInt(final int llllllllllllIllllllIllllIllllIII) {
        return this.buf.writeInt(llllllllllllIllllllIllllIllllIII);
    }
    
    public String toString(final int llllllllllllIllllllIlllIIlIIIIII, final int llllllllllllIllllllIlllIIIlllIll, final Charset llllllllllllIllllllIlllIIIlllIlI) {
        return this.buf.toString(llllllllllllIllllllIlllIIlIIIIII, llllllllllllIllllllIlllIIIlllIll, llllllllllllIllllllIlllIIIlllIlI);
    }
    
    public int getUnsignedMediumLE(final int llllllllllllIlllllllIIIlllllIlII) {
        return this.buf.getUnsignedMediumLE(llllllllllllIlllllllIIIlllllIlII);
    }
    
    public int getUnsignedShort(final int llllllllllllIlllllllIIlIIIIlIIlI) {
        return this.buf.getUnsignedShort(llllllllllllIlllllllIIlIIIIlIIlI);
    }
    
    public PacketBuffer writeUuid(final UUID llllllllllllIlllllllIIllIIIllIIl) {
        this.writeLong(llllllllllllIlllllllIIllIIIllIIl.getMostSignificantBits());
        this.writeLong(llllllllllllIlllllllIIllIIIllIIl.getLeastSignificantBits());
        return this;
    }
    
    public short getShortLE(final int llllllllllllIlllllllIIlIIIIllIII) {
        return this.buf.getShortLE(llllllllllllIlllllllIIlIIIIllIII);
    }
    
    public ByteBuf readRetainedSlice(final int llllllllllllIlllllllIIIIIIIIIIlI) {
        return this.buf.readRetainedSlice(llllllllllllIlllllllIIIIIIIIIIlI);
    }
    
    public int readUnsignedShortLE() {
        return this.buf.readUnsignedShortLE();
    }
    
    public boolean isWritable() {
        return this.buf.isWritable();
    }
    
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }
    
    public int setBytes(final int llllllllllllIlllllllIIIIlIIIIllI, final InputStream llllllllllllIlllllllIIIIlIIIIIIl, final int llllllllllllIlllllllIIIIlIIIIIII) throws IOException {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIIIIllI, llllllllllllIlllllllIIIIlIIIIIIl, llllllllllllIlllllllIIIIlIIIIIII);
    }
    
    public int[] readVarIntArray(final int llllllllllllIlllllllIIllIllllIlI) {
        final int llllllllllllIlllllllIIllIllllllI = this.readVarIntFromBuffer();
        if (llllllllllllIlllllllIIllIllllllI > llllllllllllIlllllllIIllIllllIlI) {
            throw new DecoderException(String.valueOf(new StringBuilder("VarIntArray with size ").append(llllllllllllIlllllllIIllIllllllI).append(" is bigger than allowed ").append(llllllllllllIlllllllIIllIllllIlI)));
        }
        final int[] llllllllllllIlllllllIIllIlllllIl = new int[llllllllllllIlllllllIIllIllllllI];
        for (int llllllllllllIlllllllIIllIlllllII = 0; llllllllllllIlllllllIIllIlllllII < llllllllllllIlllllllIIllIlllllIl.length; ++llllllllllllIlllllllIIllIlllllII) {
            llllllllllllIlllllllIIllIlllllIl[llllllllllllIlllllllIIllIlllllII] = this.readVarIntFromBuffer();
        }
        return llllllllllllIlllllllIIllIlllllIl;
    }
    
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }
    
    public int readBytes(final GatheringByteChannel llllllllllllIllllllIlllllIlllllI, final int llllllllllllIllllllIllllllIIIIII) throws IOException {
        return this.buf.readBytes(llllllllllllIllllllIlllllIlllllI, llllllllllllIllllllIllllllIIIIII);
    }
    
    public int readBytes(final FileChannel llllllllllllIllllllIlllllIlIlllI, final long llllllllllllIllllllIlllllIlIlIIl, final int llllllllllllIllllllIlllllIlIllII) throws IOException {
        return this.buf.readBytes(llllllllllllIllllllIlllllIlIlllI, llllllllllllIllllllIlllllIlIlIIl, llllllllllllIllllllIlllllIlIllII);
    }
    
    public ByteBuf unwrap() {
        return this.buf.unwrap();
    }
    
    public int bytesBefore(final byte llllllllllllIllllllIlllIlllIIIlI) {
        return this.buf.bytesBefore(llllllllllllIllllllIlllIlllIIIlI);
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIllIIIlIlI, final byte[] llllllllllllIlllllllIIIllIIIlIIl, final int llllllllllllIlllllllIIIllIIIlIII, final int llllllllllllIlllllllIIIllIIIIIlI) {
        return this.buf.getBytes(llllllllllllIlllllllIIIllIIIlIlI, llllllllllllIlllllllIIIllIIIlIIl, llllllllllllIlllllllIIIllIIIlIII, llllllllllllIlllllllIIIllIIIIIlI);
    }
    
    public ByteBuf discardSomeReadBytes() {
        return this.buf.discardSomeReadBytes();
    }
    
    public int[] readVarIntArray() {
        return this.readVarIntArray(this.readableBytes());
    }
    
    public ByteBuf slice(final int llllllllllllIllllllIlllIlIIlIIlI, final int llllllllllllIllllllIlllIlIIlIIIl) {
        return this.buf.slice(llllllllllllIllllllIlllIlIIlIIlI, llllllllllllIllllllIlllIlIIlIIIl);
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIllIlllIIl, final ByteBuf llllllllllllIlllllllIIIllIllIlIl) {
        return this.buf.getBytes(llllllllllllIlllllllIIIllIlllIIl, llllllllllllIlllllllIIIllIllIlIl);
    }
    
    public double readDouble() {
        return this.buf.readDouble();
    }
    
    public int writeCharSequence(final CharSequence llllllllllllIllllllIlllIllllIlIl, final Charset llllllllllllIllllllIlllIllllIlll) {
        return this.buf.writeCharSequence(llllllllllllIllllllIlllIllllIlIl, llllllllllllIllllllIlllIllllIlll);
    }
    
    public int writeBytes(final FileChannel llllllllllllIllllllIllllIIIIIlIl, final long llllllllllllIllllllIllllIIIIlIII, final int llllllllllllIllllllIllllIIIIIlll) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIIIIlIl, llllllllllllIllllllIllllIIIIlIII, llllllllllllIllllllIllllIIIIIlll);
    }
    
    public int forEachByte(final ByteProcessor llllllllllllIllllllIlllIllIIIlll) {
        return this.buf.forEachByte(llllllllllllIllllllIlllIllIIIlll);
    }
    
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }
    
    public ByteBuf writeLongLE(final long llllllllllllIllllllIllllIllIIllI) {
        return this.buf.writeLongLE(llllllllllllIllllllIllllIllIIllI);
    }
    
    public boolean equals(final Object llllllllllllIllllllIlllIIIllIIIl) {
        return this.buf.equals(llllllllllllIllllllIlllIIIllIIIl);
    }
    
    public int setCharSequence(final int llllllllllllIlllllllIIIIIlIlIllI, final CharSequence llllllllllllIlllllllIIIIIlIlIIIl, final Charset llllllllllllIlllllllIIIIIlIlIIII) {
        return this.buf.setCharSequence(llllllllllllIlllllllIIIIIlIlIllI, llllllllllllIlllllllIIIIIlIlIIIl, llllllllllllIlllllllIIIIIlIlIIII);
    }
    
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }
    
    public ByteBuf capacity(final int llllllllllllIlllllllIIlIlIlIlIll) {
        return this.buf.capacity(llllllllllllIlllllllIIlIlIlIlIll);
    }
    
    public int readVarIntFromBuffer() {
        int llllllllllllIlllllllIIllIIlIllll = 0;
        int llllllllllllIlllllllIIllIIlIlllI = 0;
        byte llllllllllllIlllllllIIllIIlIllIl;
        do {
            llllllllllllIlllllllIIllIIlIllIl = this.readByte();
            llllllllllllIlllllllIIllIIlIllll |= (llllllllllllIlllllllIIllIIlIllIl & 0x7F) << llllllllllllIlllllllIIllIIlIlllI++ * 7;
            if (llllllllllllIlllllllIIllIIlIlllI > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((llllllllllllIlllllllIIllIIlIllIl & 0x80) == 0x80);
        return llllllllllllIlllllllIIllIIlIllll;
    }
    
    public boolean release() {
        return this.buf.release();
    }
    
    public PacketBuffer(final ByteBuf llllllllllllIlllllllIIlllIllIIll) {
        this.buf = llllllllllllIlllllllIIlllIllIIll;
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIlIllIllll, final OutputStream llllllllllllIlllllllIIIlIllIlllI, final int llllllllllllIlllllllIIIlIlllIIIl) throws IOException {
        return this.buf.getBytes(llllllllllllIlllllllIIIlIllIllll, llllllllllllIlllllllIIIlIllIlllI, llllllllllllIlllllllIIIlIlllIIIl);
    }
    
    public ByteBuf writeMediumLE(final int llllllllllllIllllllIllllIllllllI) {
        return this.buf.writeMediumLE(llllllllllllIllllllIllllIllllllI);
    }
    
    public long readVarLong() {
        long llllllllllllIlllllllIIllIIlIIIll = 0L;
        int llllllllllllIlllllllIIllIIlIIIlI = 0;
        byte llllllllllllIlllllllIIllIIlIIIIl;
        do {
            llllllllllllIlllllllIIllIIlIIIIl = this.readByte();
            llllllllllllIlllllllIIllIIlIIIll |= (long)(llllllllllllIlllllllIIllIIlIIIIl & 0x7F) << llllllllllllIlllllllIIllIIlIIIlI++ * 7;
            if (llllllllllllIlllllllIIllIIlIIIlI > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((llllllllllllIlllllllIIllIIlIIIIl & 0x80) == 0x80);
        return llllllllllllIlllllllIIllIIlIIIll;
    }
    
    public UUID readUuid() {
        return new UUID(this.readLong(), this.readLong());
    }
    
    public ByteBuf writeLong(final long llllllllllllIllllllIllllIllIllII) {
        return this.buf.writeLong(llllllllllllIllllllIllllIllIllII);
    }
    
    public PacketBuffer writeBlockPos(final BlockPos llllllllllllIlllllllIIllIlIIllII) {
        this.writeLong(llllllllllllIlllllllIIllIlIIllII.toLong());
        return this;
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIlIlllllI, final ByteBuf llllllllllllIlllllllIIIIllIIIIIl, final int llllllllllllIlllllllIIIIlIllllII) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIlllllI, llllllllllllIlllllllIIIIllIIIIIl, llllllllllllIlllllllIIIIlIllllII);
    }
    
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }
    
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }
    
    public ByteBuf order(final ByteOrder llllllllllllIlllllllIIlIlIIllllI) {
        return this.buf.order(llllllllllllIlllllllIIlIlIIllllI);
    }
    
    public long[] readLongArray(@Nullable long[] llllllllllllIlllllllIIllIlIlIllI, final int llllllllllllIlllllllIIllIlIlIlIl) {
        final int llllllllllllIlllllllIIllIlIllIIl = this.readVarIntFromBuffer();
        if (llllllllllllIlllllllIIllIlIlIllI == null || llllllllllllIlllllllIIllIlIlIllI.length != llllllllllllIlllllllIIllIlIllIIl) {
            if (llllllllllllIlllllllIIllIlIllIIl > llllllllllllIlllllllIIllIlIlIlIl) {
                throw new DecoderException(String.valueOf(new StringBuilder("LongArray with size ").append(llllllllllllIlllllllIIllIlIllIIl).append(" is bigger than allowed ").append(llllllllllllIlllllllIIllIlIlIlIl)));
            }
            llllllllllllIlllllllIIllIlIlIllI = new long[llllllllllllIlllllllIIllIlIllIIl];
        }
        for (int llllllllllllIlllllllIIllIlIllIII = 0; llllllllllllIlllllllIIllIlIllIII < llllllllllllIlllllllIIllIlIlIllI.length; ++llllllllllllIlllllllIIllIlIllIII) {
            llllllllllllIlllllllIIllIlIlIllI[llllllllllllIlllllllIIllIlIllIII] = this.readLong();
        }
        return (long[])llllllllllllIlllllllIIllIlIlIllI;
    }
    
    public ByteBuf writeFloat(final float llllllllllllIllllllIllllIlIllIlI) {
        return this.buf.writeFloat(llllllllllllIllllllIllllIlIllIlI);
    }
    
    public float getFloat(final int llllllllllllIlllllllIIIlllIIIllI) {
        return this.buf.getFloat(llllllllllllIlllllllIIIlllIIIllI);
    }
    
    public int readIntLE() {
        return this.buf.readIntLE();
    }
    
    public long readUnsignedIntLE() {
        return this.buf.readUnsignedIntLE();
    }
    
    public CharSequence readCharSequence(final int llllllllllllIllllllIlllllIllIlIl, final Charset llllllllllllIllllllIlllllIllIlll) {
        return this.buf.readCharSequence(llllllllllllIllllllIlllllIllIlIl, llllllllllllIllllllIlllllIllIlll);
    }
    
    public ByteBuffer[] nioBuffers(final int llllllllllllIllllllIlllIIlIlllll, final int llllllllllllIllllllIlllIIlIllllI) {
        return this.buf.nioBuffers(llllllllllllIllllllIlllIIlIlllll, llllllllllllIllllllIlllIIlIllllI);
    }
    
    public PacketBuffer writeEnumValue(final Enum<?> llllllllllllIlllllllIIllIIllIlIl) {
        return this.writeVarIntToBuffer(llllllllllllIlllllllIIllIIllIlIl.ordinal());
    }
    
    public boolean isWritable(final int llllllllllllIlllllllIIlIIlIlllII) {
        return this.buf.isWritable(llllllllllllIlllllllIIlIIlIlllII);
    }
    
    public ByteBuf setLong(final int llllllllllllIlllllllIIIIllllIllI, final long llllllllllllIlllllllIIIIllllIlIl) {
        return this.buf.setLong(llllllllllllIlllllllIIIIllllIllI, llllllllllllIlllllllIIIIllllIlIl);
    }
    
    public int getInt(final int llllllllllllIlllllllIIIllllIlllI) {
        return this.buf.getInt(llllllllllllIlllllllIIIllllIlllI);
    }
    
    public int forEachByte(final int llllllllllllIllllllIlllIllIIIIIl, final int llllllllllllIllllllIlllIllIIIIII, final ByteProcessor llllllllllllIllllllIlllIlIllllll) {
        return this.buf.forEachByte(llllllllllllIllllllIlllIllIIIIIl, llllllllllllIllllllIlllIllIIIIII, llllllllllllIllllllIlllIlIllllll);
    }
    
    public ByteBuf readSlice(final int llllllllllllIlllllllIIIIIIIIlIlI) {
        return this.buf.readSlice(llllllllllllIlllllllIIIIIIIIlIlI);
    }
    
    public byte[] readByteArray(final int llllllllllllIlllllllIIlllIIllllI) {
        final int llllllllllllIlllllllIIlllIIlllIl = this.readVarIntFromBuffer();
        if (llllllllllllIlllllllIIlllIIlllIl > llllllllllllIlllllllIIlllIIllllI) {
            throw new DecoderException(String.valueOf(new StringBuilder("ByteArray with size ").append(llllllllllllIlllllllIIlllIIlllIl).append(" is bigger than allowed ").append(llllllllllllIlllllllIIlllIIllllI)));
        }
        final byte[] llllllllllllIlllllllIIlllIIlllII = new byte[llllllllllllIlllllllIIlllIIlllIl];
        this.readBytes(llllllllllllIlllllllIIlllIIlllII);
        return llllllllllllIlllllllIIlllIIlllII;
    }
    
    public int hashCode() {
        return this.buf.hashCode();
    }
    
    public int bytesBefore(final int llllllllllllIllllllIlllIllIIllll, final int llllllllllllIllllllIlllIllIlIIlI, final byte llllllllllllIllllllIlllIllIIllIl) {
        return this.buf.bytesBefore(llllllllllllIllllllIlllIllIIllll, llllllllllllIllllllIlllIllIlIIlI, llllllllllllIllllllIlllIllIIllIl);
    }
    
    public long getUnsignedInt(final int llllllllllllIlllllllIIIllllIIIlI) {
        return this.buf.getUnsignedInt(llllllllllllIlllllllIIIllllIIIlI);
    }
    
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }
    
    public boolean hasArray() {
        return this.buf.hasArray();
    }
    
    public ByteBuf copy(final int llllllllllllIllllllIlllIlIlIIIIl, final int llllllllllllIllllllIlllIlIIlllIl) {
        return this.buf.copy(llllllllllllIllllllIlllIlIlIIIIl, llllllllllllIllllllIlllIlIIlllIl);
    }
    
    public int readUnsignedMediumLE() {
        return this.buf.readUnsignedMediumLE();
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllllIllllIIllllll, final int llllllllllllIllllllIllllIIlllIlI, final int llllllllllllIllllllIllllIIllllIl) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIllllll, llllllllllllIllllllIllllIIlllIlI, llllllllllllIllllllIllllIIllllIl);
    }
    
    public int indexOf(final int llllllllllllIllllllIlllIlllIlllI, final int llllllllllllIllllllIlllIlllIlIIl, final byte llllllllllllIllllllIlllIlllIlIII) {
        return this.buf.indexOf(llllllllllllIllllllIlllIlllIlllI, llllllllllllIllllllIlllIlllIlIIl, llllllllllllIllllllIlllIlllIlIII);
    }
    
    public ByteBuf discardReadBytes() {
        return this.buf.discardReadBytes();
    }
    
    public String toString(final Charset llllllllllllIllllllIlllIIlIIIllI) {
        return this.buf.toString(llllllllllllIllllllIlllIIlIIIllI);
    }
    
    public ByteBuffer nioBuffer(final int llllllllllllIllllllIlllIIlllIIIl, final int llllllllllllIllllllIlllIIlllIIII) {
        return this.buf.nioBuffer(llllllllllllIllllllIlllIIlllIIIl, llllllllllllIllllllIlllIIlllIIII);
    }
    
    public short readShortLE() {
        return this.buf.readShortLE();
    }
    
    public ByteBuf setDouble(final int llllllllllllIlllllllIIIIllIlIlIl, final double llllllllllllIlllllllIIIIllIlIIIl) {
        return this.buf.setDouble(llllllllllllIlllllllIIIIllIlIlIl, llllllllllllIlllllllIIIIllIlIIIl);
    }
    
    public CharSequence getCharSequence(final int llllllllllllIlllllllIIIlIlIIllII, final int llllllllllllIlllllllIIIlIlIIlIll, final Charset llllllllllllIlllllllIIIlIlIIlIlI) {
        return this.buf.getCharSequence(llllllllllllIlllllllIIIlIlIIllII, llllllllllllIlllllllIIIlIlIIlIll, llllllllllllIlllllllIIIlIlIIlIlI);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllllIllllIlIIlIIl, final int llllllllllllIllllllIllllIlIIIlIl) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIlIIlIIl, llllllllllllIllllllIllllIlIIIlIl);
    }
    
    public ByteBuf markReaderIndex() {
        return this.buf.markReaderIndex();
    }
    
    public ByteBuffer internalNioBuffer(final int llllllllllllIllllllIlllIIllIlIll, final int llllllllllllIllllllIlllIIllIIlll) {
        return this.buf.internalNioBuffer(llllllllllllIllllllIlllIIllIlIll, llllllllllllIllllllIlllIIllIIlll);
    }
    
    public ByteBuf writeShort(final int llllllllllllIllllllIlllllIIlIIlI) {
        return this.buf.writeShort(llllllllllllIllllllIlllllIIlIIlI);
    }
    
    public int readInt() {
        return this.buf.readInt();
    }
    
    public ByteBuf writeByte(final int llllllllllllIllllllIlllllIIlIllI) {
        return this.buf.writeByte(llllllllllllIllllllIlllllIIlIllI);
    }
    
    public ByteBuf setIndex(final int llllllllllllIlllllllIIlIIllllIIl, final int llllllllllllIlllllllIIlIIllllIII) {
        return this.buf.setIndex(llllllllllllIlllllllIIlIIllllIIl, llllllllllllIlllllllIIlIIllllIII);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllllIllllllllIlll, final int llllllllllllIllllllIllllllllIIll) {
        return this.buf.readBytes(llllllllllllIllllllIllllllllIlll, llllllllllllIllllllIllllllllIIll);
    }
    
    public int writeBytes(final ScatteringByteChannel llllllllllllIllllllIllllIIIlIIII, final int llllllllllllIllllllIllllIIIlIIlI) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIIlIIII, llllllllllllIllllllIllllIIIlIIlI);
    }
    
    public ByteBuf asReadOnly() {
        return this.buf.asReadOnly();
    }
    
    public double getDouble(final int llllllllllllIlllllllIIIllIlllllI) {
        return this.buf.getDouble(llllllllllllIlllllllIIIllIlllllI);
    }
    
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }
    
    public ByteBuf setShortLE(final int llllllllllllIlllllllIIIlIIlIIIll, final int llllllllllllIlllllllIIIlIIlIIIlI) {
        return this.buf.setShortLE(llllllllllllIlllllllIIIlIIlIIIll, llllllllllllIlllllllIIIlIIlIIIlI);
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIllIIlllIl, final ByteBuf llllllllllllIlllllllIIIllIlIIIIl, final int llllllllllllIlllllllIIIllIIllIll, final int llllllllllllIlllllllIIIllIIlllll) {
        return this.buf.getBytes(llllllllllllIlllllllIIIllIIlllIl, llllllllllllIlllllllIIIllIlIIIIl, llllllllllllIlllllllIIIllIIllIll, llllllllllllIlllllllIIIllIIlllll);
    }
    
    public ByteBuf setZero(final int llllllllllllIlllllllIIIIIllIIIII, final int llllllllllllIlllllllIIIIIlIlllII) {
        return this.buf.setZero(llllllllllllIlllllllIIIIIllIIIII, llllllllllllIlllllllIIIIIlIlllII);
    }
    
    public ByteBuf readerIndex(final int llllllllllllIlllllllIIlIlIIIIlll) {
        return this.buf.readerIndex(llllllllllllIlllllllIIlIlIIIIlll);
    }
    
    public char readChar() {
        return this.buf.readChar();
    }
    
    public byte readByte() {
        return this.buf.readByte();
    }
    
    public PacketBuffer writeItemStackToBuffer(final ItemStack llllllllllllIlllllllIIlIlllIlllI) {
        if (llllllllllllIlllllllIIlIlllIlllI.func_190926_b()) {
            this.writeShort(-1);
        }
        else {
            this.writeShort(Item.getIdFromItem(llllllllllllIlllllllIIlIlllIlllI.getItem()));
            this.writeByte(llllllllllllIlllllllIIlIlllIlllI.func_190916_E());
            this.writeShort(llllllllllllIlllllllIIlIlllIlllI.getMetadata());
            NBTTagCompound llllllllllllIlllllllIIlIlllIllIl = null;
            if (llllllllllllIlllllllIIlIlllIlllI.getItem().isDamageable() || llllllllllllIlllllllIIlIlllIlllI.getItem().getShareTag()) {
                llllllllllllIlllllllIIlIlllIllIl = llllllllllllIlllllllIIlIlllIlllI.getTagCompound();
            }
            this.writeNBTTagCompoundToBuffer(llllllllllllIlllllllIIlIlllIllIl);
        }
        return this;
    }
    
    public ByteBuf writeShortLE(final int llllllllllllIllllllIlllllIIIlIlI) {
        return this.buf.writeShortLE(llllllllllllIllllllIlllllIIIlIlI);
    }
    
    @Nullable
    public NBTTagCompound readNBTTagCompoundFromBuffer() throws IOException {
        final int llllllllllllIlllllllIIlIlllllIIl = this.readerIndex();
        final byte llllllllllllIlllllllIIlIlllllIII = this.readByte();
        if (llllllllllllIlllllllIIlIlllllIII == 0) {
            return null;
        }
        this.readerIndex(llllllllllllIlllllllIIlIlllllIIl);
        try {
            return CompressedStreamTools.read((DataInput)new ByteBufInputStream((ByteBuf)this), new NBTSizeTracker(2097152L));
        }
        catch (IOException llllllllllllIlllllllIIlIllllIlll) {
            throw new EncoderException((Throwable)llllllllllllIlllllllIIlIllllIlll);
        }
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIlIlIIlIl, final byte[] llllllllllllIlllllllIIIIlIlIIlII) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIlIIlIl, llllllllllllIlllllllIIIIlIlIIlII);
    }
    
    public int writerIndex() {
        return this.buf.writerIndex();
    }
    
    public ByteBuf writeMedium(final int llllllllllllIllllllIlllllIIIIllI) {
        return this.buf.writeMedium(llllllllllllIllllllIlllllIIIIllI);
    }
    
    public String toString() {
        return this.buf.toString();
    }
    
    public int readerIndex() {
        return this.buf.readerIndex();
    }
    
    public ByteBuf setInt(final int llllllllllllIlllllllIIIlIIIIlIII, final int llllllllllllIlllllllIIIlIIIIlIlI) {
        return this.buf.setInt(llllllllllllIlllllllIIIlIIIIlIII, llllllllllllIlllllllIIIlIIIIlIlI);
    }
    
    public ByteBuf copy() {
        return this.buf.copy();
    }
    
    public int getBytes(final int llllllllllllIlllllllIIIlIlIlIlIl, final FileChannel llllllllllllIlllllllIIIlIlIlIlII, final long llllllllllllIlllllllIIIlIlIllIII, final int llllllllllllIlllllllIIIlIlIlIlll) throws IOException {
        return this.buf.getBytes(llllllllllllIlllllllIIIlIlIlIlIl, llllllllllllIlllllllIIIlIlIlIlII, llllllllllllIlllllllIIIlIlIllIII, llllllllllllIlllllllIIIlIlIlIlll);
    }
    
    public short getShort(final int llllllllllllIlllllllIIlIIIlIIIII) {
        return this.buf.getShort(llllllllllllIlllllllIIlIIIlIIIII);
    }
    
    public short getUnsignedByte(final int llllllllllllIlllllllIIlIIIlIIlII) {
        return this.buf.getUnsignedByte(llllllllllllIlllllllIIlIIIlIIlII);
    }
    
    public PacketBuffer func_192574_a(final Date llllllllllllIlllllllIIlIlIllIllI) {
        this.writeLong(llllllllllllIlllllllIIlIlIllIllI.getTime());
        return this;
    }
    
    public ByteBuf markWriterIndex() {
        return this.buf.markWriterIndex();
    }
    
    public ByteBuf slice() {
        return this.buf.slice();
    }
    
    public int setBytes(final int llllllllllllIlllllllIIIIIllIllIl, final FileChannel llllllllllllIlllllllIIIIIllIllII, final long llllllllllllIlllllllIIIIIllIlIll, final int llllllllllllIlllllllIIIIIllIIlIl) throws IOException {
        return this.buf.setBytes(llllllllllllIlllllllIIIIIllIllIl, llllllllllllIlllllllIIIIIllIllII, llllllllllllIlllllllIIIIIllIlIll, llllllllllllIlllllllIIIIIllIIlIl);
    }
    
    public byte[] readByteArray() {
        return this.readByteArray(this.readableBytes());
    }
    
    public int readableBytes() {
        return this.buf.readableBytes();
    }
    
    public <T extends Enum<T>> T readEnumValue(final Class<T> llllllllllllIlllllllIIllIIlllIll) {
        return llllllllllllIlllllllIIllIIlllIll.getEnumConstants()[this.readVarIntFromBuffer()];
    }
    
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }
    
    public PacketBuffer writeLongArray(final long[] llllllllllllIlllllllIIllIllIllII) {
        this.writeVarIntToBuffer(llllllllllllIlllllllIIllIllIllII.length);
        final short llllllllllllIlllllllIIllIllIlIII = (Object)llllllllllllIlllllllIIllIllIllII;
        final Exception llllllllllllIlllllllIIllIllIlIIl = (Exception)llllllllllllIlllllllIIllIllIllII.length;
        for (long llllllllllllIlllllllIIllIllIlIlI = 0; llllllllllllIlllllllIIllIllIlIlI < llllllllllllIlllllllIIllIllIlIIl; ++llllllllllllIlllllllIIllIllIlIlI) {
            final long llllllllllllIlllllllIIllIllIlllI = llllllllllllIlllllllIIllIllIlIII[llllllllllllIlllllllIIllIllIlIlI];
            this.writeLong(llllllllllllIlllllllIIllIllIlllI);
        }
        return this;
    }
    
    public ByteBuf setIntLE(final int llllllllllllIlllllllIIIlIIIIIIlI, final int llllllllllllIlllllllIIIlIIIIIIIl) {
        return this.buf.setIntLE(llllllllllllIlllllllIIIlIIIIIIlI, llllllllllllIlllllllIIIlIIIIIIIl);
    }
    
    public int getIntLE(final int llllllllllllIlllllllIIIllllIlIlI) {
        return this.buf.getIntLE(llllllllllllIlllllllIIIllllIlIlI);
    }
    
    public long getLongLE(final int llllllllllllIlllllllIIIlllIlIIII) {
        return this.buf.getLongLE(llllllllllllIlllllllIIIlllIlIIII);
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllIllllllIllllllIllIll, final int llllllllllllIllllllIllllllIllIlI, final int llllllllllllIllllllIllllllIllIIl) {
        return this.buf.readBytes(llllllllllllIllllllIllllllIllIll, llllllllllllIllllllIllllllIllIlI, llllllllllllIllllllIllllllIllIIl);
    }
    
    public boolean release(final int llllllllllllIllllllIlllIIIIIlIlI) {
        return this.buf.release(llllllllllllIllllllIlllIIIIIlIlI);
    }
    
    public ByteBuf setByte(final int llllllllllllIlllllllIIIlIIllIlIl, final int llllllllllllIlllllllIIIlIIllIlll) {
        return this.buf.setByte(llllllllllllIlllllllIIIlIIllIlIl, llllllllllllIlllllllIIIlIIllIlll);
    }
    
    public ByteBuf writeChar(final int llllllllllllIllllllIllllIllIIIlI) {
        return this.buf.writeChar(llllllllllllIllllllIllllIllIIIlI);
    }
    
    public int compareTo(final ByteBuf llllllllllllIllllllIlllIIIlIlIll) {
        return this.buf.compareTo(llllllllllllIllllllIlllIIIlIlIll);
    }
    
    public int getUnsignedShortLE(final int llllllllllllIlllllllIIlIIIIIllII) {
        return this.buf.getUnsignedShortLE(llllllllllllIlllllllIIlIIIIIllII);
    }
    
    public short readShort() {
        return this.buf.readShort();
    }
    
    public int capacity() {
        return this.buf.capacity();
    }
    
    public ByteBuf readBytes(final OutputStream llllllllllllIllllllIllllllIIIlll, final int llllllllllllIllllllIllllllIIlIIl) throws IOException {
        return this.buf.readBytes(llllllllllllIllllllIllllllIIIlll, llllllllllllIllllllIllllllIIlIIl);
    }
    
    public long getUnsignedIntLE(final int llllllllllllIlllllllIIIlllIllllI) {
        return this.buf.getUnsignedIntLE(llllllllllllIlllllllIIIlllIllllI);
    }
    
    public ByteBuf setFloat(final int llllllllllllIlllllllIIIIllIllIll, final float llllllllllllIlllllllIIIIllIlllIl) {
        return this.buf.setFloat(llllllllllllIlllllllIIIIllIllIll, llllllllllllIlllllllIIIIllIlllIl);
    }
    
    public long getLong(final int llllllllllllIlllllllIIIlllIllIII) {
        return this.buf.getLong(llllllllllllIlllllllIIIlllIllIII);
    }
    
    public int writableBytes() {
        return this.buf.writableBytes();
    }
    
    public int setBytes(final int llllllllllllIlllllllIIIIIllllIlI, final ScatteringByteChannel llllllllllllIlllllllIIIIIlllIlIl, final int llllllllllllIlllllllIIIIIlllIlII) throws IOException {
        return this.buf.setBytes(llllllllllllIlllllllIIIIIllllIlI, llllllllllllIlllllllIIIIIlllIlIl, llllllllllllIlllllllIIIIIlllIlII);
    }
    
    public PacketBuffer writeVarIntArray(final int[] llllllllllllIlllllllIIlllIIlIIII) {
        this.writeVarIntToBuffer(llllllllllllIlllllllIIlllIIlIIII.length);
        final short llllllllllllIlllllllIIlllIIIlIIl = (Object)llllllllllllIlllllllIIlllIIlIIII;
        final short llllllllllllIlllllllIIlllIIIlIlI = (short)llllllllllllIlllllllIIlllIIlIIII.length;
        for (byte llllllllllllIlllllllIIlllIIIlIll = 0; llllllllllllIlllllllIIlllIIIlIll < llllllllllllIlllllllIIlllIIIlIlI; ++llllllllllllIlllllllIIlllIIIlIll) {
            final int llllllllllllIlllllllIIlllIIIllll = llllllllllllIlllllllIIlllIIIlIIl[llllllllllllIlllllllIIlllIIIlIll];
            this.writeVarIntToBuffer(llllllllllllIlllllllIIlllIIIllll);
        }
        return this;
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllllIllllllllllII) {
        return this.buf.readBytes(llllllllllllIllllllIllllllllllII);
    }
    
    public int refCnt() {
        return this.buf.refCnt();
    }
    
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }
    
    public PacketBuffer func_192572_a(final ResourceLocation llllllllllllIlllllllIIlIlIllllIl) {
        this.writeString(llllllllllllIlllllllIIlIlIllllIl.toString());
        return this;
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIllIIllII, final ByteBuf llllllllllllIlllllllIIIIllIIlIII) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIllIIllII, llllllllllllIlllllllIIIIllIIlIII);
    }
    
    public ByteBuf setChar(final int llllllllllllIlllllllIIIIlllIIlII, final int llllllllllllIlllllllIIIIlllIIllI) {
        return this.buf.setChar(llllllllllllIlllllllIIIIlllIIlII, llllllllllllIlllllllIIIIlllIIllI);
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIlIIlIIII, final ByteBuffer llllllllllllIlllllllIIIIlIIIllll) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIIlIIII, llllllllllllIlllllllIIIIlIIIllll);
    }
    
    public ByteBuf clear() {
        return this.buf.clear();
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllIllllllIllllIIlIllIl, final int llllllllllllIllllllIllllIIlIllII, final int llllllllllllIllllllIllllIIlIlIll) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIlIllIl, llllllllllllIllllllIllllIIlIllII, llllllllllllIllllllIllllIIlIlIll);
    }
    
    public BlockPos readBlockPos() {
        return BlockPos.fromLong(this.readLong());
    }
    
    public char getChar(final int llllllllllllIlllllllIIIlllIIlIlI) {
        return this.buf.getChar(llllllllllllIlllllllIIIlllIIlIlI);
    }
    
    public byte getByte(final int llllllllllllIlllllllIIlIIIlIllII) {
        return this.buf.getByte(llllllllllllIlllllllIIlIIIlIllII);
    }
    
    public ByteBuf setBytes(final int llllllllllllIlllllllIIIIlIllIIII, final ByteBuf llllllllllllIlllllllIIIIlIlIllll, final int llllllllllllIlllllllIIIIlIllIIll, final int llllllllllllIlllllllIIIIlIllIIlI) {
        return this.buf.setBytes(llllllllllllIlllllllIIIIlIllIIII, llllllllllllIlllllllIIIIlIlIllll, llllllllllllIlllllllIIIIlIllIIll, llllllllllllIlllllllIIIIlIllIIlI);
    }
    
    public ByteBuf resetReaderIndex() {
        return this.buf.resetReaderIndex();
    }
    
    public ByteBuf resetWriterIndex() {
        return this.buf.resetWriterIndex();
    }
    
    public ByteBuf writerIndex(final int llllllllllllIlllllllIIlIlIIIIIII) {
        return this.buf.writerIndex(llllllllllllIlllllllIIlIlIIIIIII);
    }
    
    public int readMedium() {
        return this.buf.readMedium();
    }
    
    public ByteBuf skipBytes(final int llllllllllllIllllllIlllllIlIIIlI) {
        return this.buf.skipBytes(llllllllllllIllllllIlllllIlIIIlI);
    }
    
    public ByteOrder order() {
        return this.buf.order();
    }
    
    public PacketBuffer writeNBTTagCompoundToBuffer(@Nullable final NBTTagCompound llllllllllllIlllllllIIllIIIIIIII) {
        if (llllllllllllIlllllllIIllIIIIIIII == null) {
            this.writeByte(0);
        }
        else {
            try {
                CompressedStreamTools.write(llllllllllllIlllllllIIllIIIIIIII, (DataOutput)new ByteBufOutputStream((ByteBuf)this));
            }
            catch (IOException llllllllllllIlllllllIIllIIIIIIlI) {
                throw new EncoderException((Throwable)llllllllllllIlllllllIIllIIIIIIlI);
            }
        }
        return this;
    }
    
    public ITextComponent readTextComponent() throws IOException {
        return ITextComponent.Serializer.jsonToComponent(this.readStringFromBuffer(32767));
    }
    
    public int forEachByteDesc(final int llllllllllllIllllllIlllIlIlIllll, final int llllllllllllIllllllIlllIlIlIlllI, final ByteProcessor llllllllllllIllllllIlllIlIlIlIIl) {
        return this.buf.forEachByteDesc(llllllllllllIllllllIlllIlIlIllll, llllllllllllIllllllIlllIlIlIlllI, llllllllllllIllllllIlllIlIlIlIIl);
    }
    
    public boolean isReadable() {
        return this.buf.isReadable();
    }
    
    public long readLong() {
        return this.buf.readLong();
    }
    
    public ByteBuf writeIntLE(final int llllllllllllIllllllIllllIlllIIlI) {
        return this.buf.writeIntLE(llllllllllllIllllllIllllIlllIIlI);
    }
    
    public ResourceLocation func_192575_l() {
        return new ResourceLocation(this.readStringFromBuffer(32767));
    }
    
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }
    
    public long readLongLE() {
        return this.buf.readLongLE();
    }
    
    public int readMediumLE() {
        return this.buf.readMediumLE();
    }
    
    public int getUnsignedMedium(final int llllllllllllIlllllllIIIlllllllII) {
        return this.buf.getUnsignedMedium(llllllllllllIlllllllIIIlllllllII);
    }
    
    public ByteBuf retain() {
        return this.buf.retain();
    }
    
    public float readFloat() {
        return this.buf.readFloat();
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIllIIlIlIl, final byte[] llllllllllllIlllllllIIIllIIlIIIl) {
        return this.buf.getBytes(llllllllllllIlllllllIIIllIIlIlIl, llllllllllllIlllllllIIIllIIlIIIl);
    }
    
    public PacketBuffer writeString(final String llllllllllllIlllllllIIlIllIIIlll) {
        final byte[] llllllllllllIlllllllIIlIllIIlIIl = llllllllllllIlllllllIIlIllIIIlll.getBytes(StandardCharsets.UTF_8);
        if (llllllllllllIlllllllIIlIllIIlIIl.length > 32767) {
            throw new EncoderException(String.valueOf(new StringBuilder("String too big (was ").append(llllllllllllIlllllllIIlIllIIlIIl.length).append(" bytes encoded, max ").append(32767).append(")")));
        }
        this.writeVarIntToBuffer(llllllllllllIlllllllIIlIllIIlIIl.length);
        this.writeBytes(llllllllllllIlllllllIIlIllIIlIIl);
        return this;
    }
    
    public ByteBuf readBytes(final ByteBuffer llllllllllllIllllllIllllllIlIIIl) {
        return this.buf.readBytes(llllllllllllIllllllIllllllIlIIIl);
    }
    
    public String readStringFromBuffer(final int llllllllllllIlllllllIIlIllIlIlIl) {
        final int llllllllllllIlllllllIIlIllIlIlII = this.readVarIntFromBuffer();
        if (llllllllllllIlllllllIIlIllIlIlII > llllllllllllIlllllllIIlIllIlIlIl * 4) {
            throw new DecoderException(String.valueOf(new StringBuilder("The received encoded string buffer length is longer than maximum allowed (").append(llllllllllllIlllllllIIlIllIlIlII).append(" > ").append(llllllllllllIlllllllIIlIllIlIlIl * 4).append(")")));
        }
        if (llllllllllllIlllllllIIlIllIlIlII < 0) {
            throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        }
        final String llllllllllllIlllllllIIlIllIlIIll = this.toString(this.readerIndex(), llllllllllllIlllllllIIlIllIlIlII, StandardCharsets.UTF_8);
        this.readerIndex(this.readerIndex() + llllllllllllIlllllllIIlIllIlIlII);
        if (llllllllllllIlllllllIIlIllIlIIll.length() > llllllllllllIlllllllIIlIllIlIlIl) {
            throw new DecoderException(String.valueOf(new StringBuilder("The received string length is longer than maximum allowed (").append(llllllllllllIlllllllIIlIllIlIlII).append(" > ").append(llllllllllllIlllllllIIlIllIlIlIl).append(")")));
        }
        return llllllllllllIlllllllIIlIllIlIIll;
    }
    
    public ByteBuf writeBoolean(final boolean llllllllllllIllllllIlllllIIlllII) {
        return this.buf.writeBoolean(llllllllllllIllllllIlllllIIlllII);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllllIllllIlIIlllI) {
        return this.buf.writeBytes(llllllllllllIllllllIllllIlIIlllI);
    }
    
    public int writeBytes(final InputStream llllllllllllIllllllIllllIIIlllII, final int llllllllllllIllllllIllllIIIllIII) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllllIllllIIIlllII, llllllllllllIllllllIllllIIIllIII);
    }
    
    public int getMediumLE(final int llllllllllllIlllllllIIlIIIIIIIlI) {
        return this.buf.getMediumLE(llllllllllllIlllllllIIlIIIIIIIlI);
    }
    
    public PacketBuffer writeVarLong(long llllllllllllIlllllllIIllIIIIlIII) {
        while ((llllllllllllIlllllllIIllIIIIlIII & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            this.writeByte((int)(llllllllllllIlllllllIIllIIIIlIII & 0x7FL) | 0x80);
            llllllllllllIlllllllIIllIIIIlIII >>>= 7;
        }
        this.writeByte((int)llllllllllllIlllllllIIllIIIIlIII);
        return this;
    }
    
    public boolean isReadable(final int llllllllllllIlllllllIIlIIllIIIll) {
        return this.buf.isReadable(llllllllllllIlllllllIIlIIllIIIll);
    }
    
    public ByteBuf setMedium(final int llllllllllllIlllllllIIIlIIIllIlI, final int llllllllllllIlllllllIIIlIIIllIIl) {
        return this.buf.setMedium(llllllllllllIlllllllIIIlIIIllIlI, llllllllllllIlllllllIIIlIIIllIIl);
    }
    
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }
    
    public int ensureWritable(final int llllllllllllIlllllllIIlIIIllIlll, final boolean llllllllllllIlllllllIIlIIIllIllI) {
        return this.buf.ensureWritable(llllllllllllIlllllllIIlIIIllIlll, llllllllllllIlllllllIIlIIIllIllI);
    }
    
    public ByteBuf setBoolean(final int llllllllllllIlllllllIIIlIIlllllI, final boolean llllllllllllIlllllllIIIlIIllllIl) {
        return this.buf.setBoolean(llllllllllllIlllllllIIIlIIlllllI, llllllllllllIlllllllIIIlIIllllIl);
    }
    
    public ItemStack readItemStackFromBuffer() throws IOException {
        final int llllllllllllIlllllllIIlIlllIIIll = this.readShort();
        if (llllllllllllIlllllllIIlIlllIIIll < 0) {
            return ItemStack.field_190927_a;
        }
        final int llllllllllllIlllllllIIlIlllIIIlI = this.readByte();
        final int llllllllllllIlllllllIIlIlllIIIIl = this.readShort();
        final ItemStack llllllllllllIlllllllIIlIlllIIIII = new ItemStack(Item.getItemById(llllllllllllIlllllllIIlIlllIIIll), llllllllllllIlllllllIIlIlllIIIlI, llllllllllllIlllllllIIlIlllIIIIl);
        llllllllllllIlllllllIIlIlllIIIII.setTagCompound(this.readNBTTagCompoundFromBuffer());
        return llllllllllllIlllllllIIlIlllIIIII;
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIlIllllIlI, final ByteBuffer llllllllllllIlllllllIIIlIlllllII) {
        return this.buf.getBytes(llllllllllllIlllllllIIIlIllllIlI, llllllllllllIlllllllIIIlIlllllII);
    }
    
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate();
    }
    
    public int getMedium(final int llllllllllllIlllllllIIlIIIIIlIII) {
        return this.buf.getMedium(llllllllllllIlllllllIIlIIIIIlIII);
    }
    
    public long[] readLongArray(@Nullable final long[] llllllllllllIlllllllIIllIllIIIlI) {
        return this.readLongArray(llllllllllllIlllllllIIllIllIIIlI, this.readableBytes() / 8);
    }
    
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }
    
    public ByteBuf getBytes(final int llllllllllllIlllllllIIIllIlIllll, final ByteBuf llllllllllllIlllllllIIIllIlIlllI, final int llllllllllllIlllllllIIIllIlIllIl) {
        return this.buf.getBytes(llllllllllllIlllllllIIIllIlIllll, llllllllllllIlllllllIIIllIlIlllI, llllllllllllIlllllllIIIllIlIllIl);
    }
    
    public ByteBuf retainedSlice(final int llllllllllllIllllllIlllIlIIIlIIl, final int llllllllllllIllllllIlllIlIIIlIII) {
        return this.buf.retainedSlice(llllllllllllIllllllIlllIlIIIlIIl, llllllllllllIllllllIlllIlIIIlIII);
    }
    
    public boolean getBoolean(final int llllllllllllIlllllllIIlIIIllIIII) {
        return this.buf.getBoolean(llllllllllllIlllllllIIlIIIllIIII);
    }
    
    public Date func_192573_m() {
        return new Date(this.readLong());
    }
    
    public ByteBuf touch(final Object llllllllllllIllllllIlllIIIIlIllI) {
        return this.buf.touch(llllllllllllIllllllIlllIIIIlIllI);
    }
    
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }
    
    public int forEachByteDesc(final ByteProcessor llllllllllllIllllllIlllIlIllIlIl) {
        return this.buf.forEachByteDesc(llllllllllllIllllllIlllIlIllIlIl);
    }
    
    public boolean isDirect() {
        return this.buf.isDirect();
    }
    
    public PacketBuffer writeVarIntToBuffer(int llllllllllllIlllllllIIllIIIIlllI) {
        while ((llllllllllllIlllllllIIllIIIIlllI & 0xFFFFFF80) != 0x0) {
            this.writeByte((int)((llllllllllllIlllllllIIllIIIIlllI & 0x7F) | 0x80));
            llllllllllllIlllllllIIllIIIIlllI >>>= 7;
        }
        this.writeByte((int)llllllllllllIlllllllIIllIIIIlllI);
        return this;
    }
    
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice();
    }
    
    public ByteBuf setShort(final int llllllllllllIlllllllIIIlIIlIllII, final int llllllllllllIlllllllIIIlIIlIlllI) {
        return this.buf.setShort(llllllllllllIlllllllIIIlIIlIllII, llllllllllllIlllllllIIIlIIlIlllI);
    }
    
    public ByteBuf retain(final int llllllllllllIllllllIlllIIIlIIIlI) {
        return this.buf.retain(llllllllllllIllllllIlllIIIlIIIlI);
    }
}
