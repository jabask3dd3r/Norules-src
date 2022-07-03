package com.viaversion.viaversion.api.minecraft.chunks;

import io.netty.buffer.*;

public class ChunkSectionLightImpl implements ChunkSectionLight
{
    private /* synthetic */ NibbleArray skyLight;
    private /* synthetic */ NibbleArray blockLight;
    
    @Override
    public byte[] getBlockLight() {
        return (byte[])((this.blockLight == null) ? null : this.blockLight.getHandle());
    }
    
    @Override
    public NibbleArray getBlockLightNibbleArray() {
        return this.blockLight;
    }
    
    @Override
    public void setSkyLight(final byte[] llllllllllllllIllIlllIIIlIllIIll) {
        if (llllllllllllllIllIlllIIIlIllIIll.length != 2048) {
            throw new IllegalArgumentException("Data length != 2048");
        }
        if (this.skyLight == null) {
            this.skyLight = new NibbleArray(llllllllllllllIllIlllIIIlIllIIll);
        }
        else {
            this.skyLight.setHandle(llllllllllllllIllIlllIIIlIllIIll);
        }
    }
    
    @Override
    public boolean hasBlockLight() {
        return this.blockLight != null;
    }
    
    @Override
    public byte[] getSkyLight() {
        return (byte[])((this.skyLight == null) ? null : this.skyLight.getHandle());
    }
    
    @Override
    public void setBlockLight(final byte[] llllllllllllllIllIlllIIIlIlllIIl) {
        if (llllllllllllllIllIlllIIIlIlllIIl.length != 2048) {
            throw new IllegalArgumentException("Data length != 2048");
        }
        if (this.blockLight == null) {
            this.blockLight = new NibbleArray(llllllllllllllIllIlllIIIlIlllIIl);
        }
        else {
            this.blockLight.setHandle(llllllllllllllIllIlllIIIlIlllIIl);
        }
    }
    
    @Override
    public boolean hasSkyLight() {
        return this.skyLight != null;
    }
    
    public ChunkSectionLightImpl() {
        this.blockLight = new NibbleArray(4096);
    }
    
    @Override
    public void readSkyLight(final ByteBuf llllllllllllllIllIlllIIIlIIlllIl) {
        if (this.skyLight == null) {
            this.skyLight = new NibbleArray(4096);
        }
        llllllllllllllIllIlllIIIlIIlllIl.readBytes(this.skyLight.getHandle());
    }
    
    @Override
    public void readBlockLight(final ByteBuf llllllllllllllIllIlllIIIlIlIIIIl) {
        if (this.blockLight == null) {
            this.blockLight = new NibbleArray(4096);
        }
        llllllllllllllIllIlllIIIlIlIIIIl.readBytes(this.blockLight.getHandle());
    }
    
    @Override
    public NibbleArray getSkyLightNibbleArray() {
        return this.skyLight;
    }
    
    @Override
    public void writeSkyLight(final ByteBuf llllllllllllllIllIlllIIIlIIlIIIl) {
        llllllllllllllIllIlllIIIlIIlIIIl.writeBytes(this.skyLight.getHandle());
    }
    
    @Override
    public void writeBlockLight(final ByteBuf llllllllllllllIllIlllIIIlIIlIlIl) {
        llllllllllllllIllIlllIIIlIIlIlIl.writeBytes(this.blockLight.getHandle());
    }
}
