package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import java.lang.reflect.*;
import java.util.*;

public class BlockConnectionStorage implements StorableObject
{
    private static /* synthetic */ Constructor<?> fastUtilLongObjectHashMap;
    private static final /* synthetic */ short[] REVERSE_BLOCK_MAPPINGS;
    private final /* synthetic */ Map<Long, Pair<byte[], NibbleArray>> blockStorage;
    
    private short encodeBlockPos(final Position llllllllllllllllllIlIllIlIllIllI) {
        return this.encodeBlockPos(llllllllllllllllllIlIllIlIllIllI.getX(), llllllllllllllllllIlIllIlIllIllI.getY(), llllllllllllllllllIlIllIlIllIllI.getZ());
    }
    
    private short encodeBlockPos(final int llllllllllllllllllIlIllIlIllllII, final int llllllllllllllllllIlIllIlIlllIll, final int llllllllllllllllllIlIllIlIlllIlI) {
        return (short)((llllllllllllllllllIlIllIlIlllIll & 0xF) << 8 | (llllllllllllllllllIlIllIlIllllII & 0xF) << 4 | (llllllllllllllllllIlIllIlIlllIlI & 0xF));
    }
    
    public BlockConnectionStorage() {
        this.blockStorage = this.createLongObjectMap();
    }
    
    public void remove(final int llllllllllllllllllIlIlllIIIIIIIl, final int llllllllllllllllllIlIlllIIIIIIII, final int llllllllllllllllllIlIllIllllllll) {
        final long llllllllllllllllllIlIllIlllllllI = this.getChunkSectionIndex(llllllllllllllllllIlIlllIIIIIIIl, llllllllllllllllllIlIlllIIIIIIII, llllllllllllllllllIlIllIllllllll);
        final Pair<byte[], NibbleArray> llllllllllllllllllIlIllIllllllIl = this.blockStorage.get(llllllllllllllllllIlIllIlllllllI);
        if (llllllllllllllllllIlIllIllllllIl == null) {
            return;
        }
        final int llllllllllllllllllIlIllIllllllII = this.encodeBlockPos(llllllllllllllllllIlIlllIIIIIIIl, llllllllllllllllllIlIlllIIIIIIII, llllllllllllllllllIlIllIllllllll);
        final NibbleArray llllllllllllllllllIlIllIlllllIll = llllllllllllllllllIlIllIllllllIl.getValue();
        if (llllllllllllllllllIlIllIlllllIll != null) {
            llllllllllllllllllIlIllIlllllIll.set(llllllllllllllllllIlIllIllllllII, 0);
            boolean llllllllllllllllllIlIlllIIIIIlII = true;
            for (int llllllllllllllllllIlIlllIIIIIlIl = 0; llllllllllllllllllIlIlllIIIIIlIl < 4096; ++llllllllllllllllllIlIlllIIIIIlIl) {
                if (llllllllllllllllllIlIllIlllllIll.get(llllllllllllllllllIlIlllIIIIIlIl) != 0) {
                    llllllllllllllllllIlIlllIIIIIlII = false;
                    break;
                }
            }
            if (llllllllllllllllllIlIlllIIIIIlII) {
                llllllllllllllllllIlIllIllllllIl.setValue(null);
            }
        }
        llllllllllllllllllIlIllIllllllIl.getKey()[llllllllllllllllllIlIllIllllllII] = 0;
        for (final short llllllllllllllllllIlIlllIIIIIIll : llllllllllllllllllIlIllIllllllIl.getKey()) {
            if (llllllllllllllllllIlIlllIIIIIIll != 0) {
                return;
            }
        }
        this.blockStorage.remove(llllllllllllllllllIlIllIlllllllI);
    }
    
    private long getChunkSectionIndex(final int llllllllllllllllllIlIllIllIIllll, final int llllllllllllllllllIlIllIllIIlIll, final int llllllllllllllllllIlIllIllIIllIl) {
        return ((long)(llllllllllllllllllIlIllIllIIllll >> 4) & 0x3FFFFFFL) << 38 | ((long)(llllllllllllllllllIlIllIllIIlIll >> 4) & 0xFFFL) << 26 | ((long)(llllllllllllllllllIlIllIllIIllIl >> 4) & 0x3FFFFFFL);
    }
    
    static {
        REVERSE_BLOCK_MAPPINGS = new short[8582];
        try {
            final String llllllllllllllllllIlIllIlIlIllIl = String.valueOf(new StringBuilder("it").append(".unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap"));
            BlockConnectionStorage.fastUtilLongObjectHashMap = Class.forName(llllllllllllllllllIlIllIlIlIllIl).getConstructor((Class<?>[])new Class[0]);
            Via.getPlatform().getLogger().info("Using FastUtil Long2ObjectOpenHashMap for block connections");
        }
        catch (ClassNotFoundException ex) {}
        catch (NoSuchMethodException ex2) {}
        Arrays.fill(BlockConnectionStorage.REVERSE_BLOCK_MAPPINGS, (short)(-1));
        for (int llllllllllllllllllIlIllIlIlIlIll = 0; llllllllllllllllllIlIllIlIlIlIll < 4096; ++llllllllllllllllllIlIllIlIlIlIll) {
            final int llllllllllllllllllIlIllIlIlIllII = Protocol1_13To1_12_2.MAPPINGS.getBlockMappings().getNewId(llllllllllllllllllIlIllIlIlIlIll);
            if (llllllllllllllllllIlIllIlIlIllII != -1) {
                BlockConnectionStorage.REVERSE_BLOCK_MAPPINGS[llllllllllllllllllIlIllIlIlIllII] = (short)llllllllllllllllllIlIllIlIlIlIll;
            }
        }
    }
    
    public int get(final int llllllllllllllllllIlIlllIIlIIIII, final int llllllllllllllllllIlIlllIIIlIlll, final int llllllllllllllllllIlIlllIIIlIllI) {
        final long llllllllllllllllllIlIlllIIIlllIl = this.getChunkSectionIndex(llllllllllllllllllIlIlllIIlIIIII, llllllllllllllllllIlIlllIIIlIlll, llllllllllllllllllIlIlllIIIlIllI);
        final Pair<byte[], NibbleArray> llllllllllllllllllIlIlllIIIlllII = this.blockStorage.get(llllllllllllllllllIlIlllIIIlllIl);
        if (llllllllllllllllllIlIlllIIIlllII == null) {
            return 0;
        }
        final short llllllllllllllllllIlIlllIIIllIll = this.encodeBlockPos(llllllllllllllllllIlIlllIIlIIIII, llllllllllllllllllIlIlllIIIlIlll, llllllllllllllllllIlIlllIIIlIllI);
        final NibbleArray llllllllllllllllllIlIlllIIIllIlI = llllllllllllllllllIlIlllIIIlllII.getValue();
        return WorldPackets.toNewId((llllllllllllllllllIlIlllIIIlllII.getKey()[llllllllllllllllllIlIlllIIIllIll] & 0xFF) << 4 | ((llllllllllllllllllIlIlllIIIllIlI == null) ? 0 : llllllllllllllllllIlIlllIIIllIlI.get(llllllllllllllllllIlIlllIIIllIll)));
    }
    
    private long getChunkSectionIndex(final Position llllllllllllllllllIlIllIllIIIlII) {
        return this.getChunkSectionIndex(llllllllllllllllllIlIllIllIIIlII.getX(), llllllllllllllllllIlIllIllIIIlII.getY(), llllllllllllllllllIlIllIllIIIlII.getZ());
    }
    
    public void unloadChunk(final int llllllllllllllllllIlIllIlllIIIlI, final int llllllllllllllllllIlIllIlllIIIIl) {
        for (int llllllllllllllllllIlIllIlllIIlll = 0; llllllllllllllllllIlIllIlllIIlll < 256; llllllllllllllllllIlIllIlllIIlll += 16) {
            this.blockStorage.remove(this.getChunkSectionIndex(llllllllllllllllllIlIllIlllIIIlI << 4, llllllllllllllllllIlIllIlllIIlll, llllllllllllllllllIlIllIlllIIIIl << 4));
        }
    }
    
    public void store(final int llllllllllllllllllIlIlllIIllIIlI, final int llllllllllllllllllIlIlllIIllIIIl, final int llllllllllllllllllIlIlllIIlllIlI, int llllllllllllllllllIlIlllIIlIllll) {
        final short llllllllllllllllllIlIlllIIlllIII = BlockConnectionStorage.REVERSE_BLOCK_MAPPINGS[llllllllllllllllllIlIlllIIlIllll];
        if (llllllllllllllllllIlIlllIIlllIII == -1) {
            return;
        }
        llllllllllllllllllIlIlllIIlIllll = llllllllllllllllllIlIlllIIlllIII;
        final long llllllllllllllllllIlIlllIIllIlll = this.getChunkSectionIndex(llllllllllllllllllIlIlllIIllIIlI, llllllllllllllllllIlIlllIIllIIIl, llllllllllllllllllIlIlllIIlllIlI);
        final Pair<byte[], NibbleArray> llllllllllllllllllIlIlllIIllIllI = this.getChunkSection(llllllllllllllllllIlIlllIIllIlll, (llllllllllllllllllIlIlllIIlIllll & 0xF) != 0x0);
        final int llllllllllllllllllIlIlllIIllIlIl = this.encodeBlockPos(llllllllllllllllllIlIlllIIllIIlI, llllllllllllllllllIlIlllIIllIIIl, llllllllllllllllllIlIlllIIlllIlI);
        llllllllllllllllllIlIlllIIllIllI.getKey()[llllllllllllllllllIlIlllIIllIlIl] = (byte)(llllllllllllllllllIlIlllIIlIllll >> 4);
        final NibbleArray llllllllllllllllllIlIlllIIllIlII = llllllllllllllllllIlIlllIIllIllI.getValue();
        if (llllllllllllllllllIlIlllIIllIlII != null) {
            llllllllllllllllllIlIlllIIllIlII.set(llllllllllllllllllIlIlllIIllIlIl, llllllllllllllllllIlIlllIIlIllll);
        }
    }
    
    private <T> Map<Long, T> createLongObjectMap() {
        if (BlockConnectionStorage.fastUtilLongObjectHashMap != null) {
            try {
                return (Map<Long, T>)BlockConnectionStorage.fastUtilLongObjectHashMap.newInstance(new Object[0]);
            }
            catch (IllegalAccessException | InstantiationException | InvocationTargetException ex2) {
                final ReflectiveOperationException ex;
                final ReflectiveOperationException llllllllllllllllllIlIllIlIllIIlI = ex;
                llllllllllllllllllIlIllIlIllIIlI.printStackTrace();
            }
        }
        return new HashMap<Long, T>();
    }
    
    public void clear() {
        this.blockStorage.clear();
    }
    
    private Pair<byte[], NibbleArray> getChunkSection(final long llllllllllllllllllIlIllIllIlIllI, final boolean llllllllllllllllllIlIllIllIlIlIl) {
        Pair<byte[], NibbleArray> llllllllllllllllllIlIllIllIllIII = this.blockStorage.get(llllllllllllllllllIlIllIllIlIllI);
        if (llllllllllllllllllIlIllIllIllIII == null) {
            llllllllllllllllllIlIllIllIllIII = new Pair<byte[], NibbleArray>(new byte[4096], null);
            this.blockStorage.put(llllllllllllllllllIlIllIllIlIllI, llllllllllllllllllIlIllIllIllIII);
        }
        if (llllllllllllllllllIlIllIllIllIII.getValue() == null && llllllllllllllllllIlIllIllIlIlIl) {
            llllllllllllllllllIlIllIllIllIII.setValue(new NibbleArray(4096));
        }
        return llllllllllllllllllIlIllIllIllIII;
    }
}
