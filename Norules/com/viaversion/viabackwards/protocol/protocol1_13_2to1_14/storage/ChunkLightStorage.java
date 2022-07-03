package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage;

import com.viaversion.viaversion.api.connection.*;
import java.lang.reflect.*;
import java.util.*;

public class ChunkLightStorage extends StoredObject
{
    public static final /* synthetic */ byte[] FULL_LIGHT;
    private static /* synthetic */ Constructor<?> fastUtilLongObjectHashMap;
    public static final /* synthetic */ byte[] EMPTY_LIGHT;
    private final /* synthetic */ Map<Long, ChunkLight> storedLight;
    
    public void setStoredLight(final byte[][] llllllllllllllIIIllllIllllIIllII, final byte[][] llllllllllllllIIIllllIllllIIIllI, final int llllllllllllllIIIllllIllllIIIlIl, final int llllllllllllllIIIllllIllllIIIlII) {
        this.storedLight.put(this.getChunkSectionIndex(llllllllllllllIIIllllIllllIIIlIl, llllllllllllllIIIllllIllllIIIlII), new ChunkLight(llllllllllllllIIIllllIllllIIllII, llllllllllllllIIIllllIllllIIIllI));
    }
    
    public ChunkLight getStoredLight(final int llllllllllllllIIIllllIlllIllllll, final int llllllllllllllIIIllllIlllIlllIll) {
        return this.storedLight.get(this.getChunkSectionIndex(llllllllllllllIIIllllIlllIllllll, llllllllllllllIIIllllIlllIlllIll));
    }
    
    private long getChunkSectionIndex(final int llllllllllllllIIIllllIlllIlIlIll, final int llllllllllllllIIIllllIlllIlIlIlI) {
        return ((long)llllllllllllllIIIllllIlllIlIlIll & 0x3FFFFFFL) << 38 | ((long)llllllllllllllIIIllllIlllIlIlIlI & 0x3FFFFFFL);
    }
    
    public ChunkLightStorage(final UserConnection llllllllllllllIIIllllIllllIlIlIl) {
        super(llllllllllllllIIIllllIllllIlIlIl);
        this.storedLight = this.createLongObjectMap();
    }
    
    private Map<Long, ChunkLight> createLongObjectMap() {
        if (ChunkLightStorage.fastUtilLongObjectHashMap != null) {
            try {
                return (Map<Long, ChunkLight>)ChunkLightStorage.fastUtilLongObjectHashMap.newInstance(new Object[0]);
            }
            catch (IllegalAccessException | InstantiationException | InvocationTargetException ex2) {
                final ReflectiveOperationException ex;
                final ReflectiveOperationException llllllllllllllIIIllllIlllIlIIllI = ex;
                llllllllllllllIIIllllIlllIlIIllI.printStackTrace();
            }
        }
        return new HashMap<Long, ChunkLight>();
    }
    
    public void clear() {
        this.storedLight.clear();
    }
    
    public void unloadChunk(final int llllllllllllllIIIllllIlllIllIIll, final int llllllllllllllIIIllllIlllIllIIlI) {
        this.storedLight.remove(this.getChunkSectionIndex(llllllllllllllIIIllllIlllIllIIll, llllllllllllllIIIllllIlllIllIIlI));
    }
    
    static {
        FULL_LIGHT = new byte[2048];
        EMPTY_LIGHT = new byte[2048];
        Arrays.fill(ChunkLightStorage.FULL_LIGHT, (byte)(-1));
        Arrays.fill(ChunkLightStorage.EMPTY_LIGHT, (byte)0);
        try {
            ChunkLightStorage.fastUtilLongObjectHashMap = Class.forName("com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap").getConstructor((Class<?>[])new Class[0]);
        }
        catch (ClassNotFoundException ex) {}
        catch (NoSuchMethodException ex2) {}
    }
    
    public static class ChunkLight
    {
        private final /* synthetic */ byte[][] skyLight;
        private final /* synthetic */ byte[][] blockLight;
        
        public byte[][] getBlockLight() {
            return this.blockLight;
        }
        
        public byte[][] getSkyLight() {
            return this.skyLight;
        }
        
        public ChunkLight(final byte[][] lllllllllllllllllllIlIlllllIlIll, final byte[][] lllllllllllllllllllIlIlllllIlIlI) {
            this.skyLight = lllllllllllllllllllIlIlllllIlIll;
            this.blockLight = lllllllllllllllllllIlIlllllIlIlI;
        }
    }
}
