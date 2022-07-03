package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.*;

public class WrappedBlockData
{
    private final /* synthetic */ String minecraftKey;
    private final /* synthetic */ int savedBlockStateId;
    private final /* synthetic */ LinkedHashMap<String, String> blockData;
    
    public boolean hasData(final String lllllllllllllIIIlIIlIIlIIIIIlllI) {
        return this.blockData.containsKey(lllllllllllllIIIlIIlIIlIIIIIlllI);
    }
    
    public WrappedBlockData set(final String lllllllllllllIIIlIIlIIlIIIIlllII, final Object lllllllllllllIIIlIIlIIlIIIIllIII) {
        if (!this.hasData(lllllllllllllIIIlIIlIIlIIIIlllII)) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("No blockdata found for ").append(lllllllllllllIIIlIIlIIlIIIIlllII).append(" at ").append(this.minecraftKey)));
        }
        this.blockData.put(lllllllllllllIIIlIIlIIlIIIIlllII, lllllllllllllIIIlIIlIIlIIIIllIII.toString());
        return this;
    }
    
    public int getBlockStateId() {
        return ConnectionData.getId(this.toString());
    }
    
    public String getMinecraftKey() {
        return this.minecraftKey;
    }
    
    public static WrappedBlockData fromString(final String lllllllllllllIIIlIIlIIlIIlIlIIlI) {
        final String[] lllllllllllllIIIlIIlIIlIIlIlIIIl = lllllllllllllIIIlIIlIIlIIlIlIIlI.split("\\[");
        final String lllllllllllllIIIlIIlIIlIIlIlIIII = lllllllllllllIIIlIIlIIlIIlIlIIIl[0];
        final WrappedBlockData lllllllllllllIIIlIIlIIlIIlIIllll = new WrappedBlockData(lllllllllllllIIIlIIlIIlIIlIlIIII, ConnectionData.getId(lllllllllllllIIIlIIlIIlIIlIlIIlI));
        if (lllllllllllllIIIlIIlIIlIIlIlIIIl.length > 1) {
            String lllllllllllllIIIlIIlIIlIIlIlIlII = lllllllllllllIIIlIIlIIlIIlIlIIIl[1];
            lllllllllllllIIIlIIlIIlIIlIlIlII = lllllllllllllIIIlIIlIIlIIlIlIlII.replace("]", "");
            final Exception lllllllllllllIIIlIIlIIlIIlIIlIII;
            final String[] lllllllllllllIIIlIIlIIlIIlIlIIll = (Object)(lllllllllllllIIIlIIlIIlIIlIIlIII = (Exception)(Object)lllllllllllllIIIlIIlIIlIIlIlIlII.split(","));
            for (double lllllllllllllIIIlIIlIIlIIlIIIlll = lllllllllllllIIIlIIlIIlIIlIIlIII.length, lllllllllllllIIIlIIlIIlIIlIIIllI = 0; lllllllllllllIIIlIIlIIlIIlIIIllI < lllllllllllllIIIlIIlIIlIIlIIIlll; ++lllllllllllllIIIlIIlIIlIIlIIIllI) {
                final String lllllllllllllIIIlIIlIIlIIlIlIlIl = lllllllllllllIIIlIIlIIlIIlIIlIII[lllllllllllllIIIlIIlIIlIIlIIIllI];
                final String[] lllllllllllllIIIlIIlIIlIIlIlIllI = lllllllllllllIIIlIIlIIlIIlIlIlIl.split("=");
                lllllllllllllIIIlIIlIIlIIlIIllll.blockData.put(lllllllllllllIIIlIIlIIlIIlIlIllI[0], lllllllllllllIIIlIIlIIlIIlIlIllI[1]);
            }
        }
        return lllllllllllllIIIlIIlIIlIIlIIllll;
    }
    
    public int getSavedBlockStateId() {
        return this.savedBlockStateId;
    }
    
    public String getValue(final String lllllllllllllIIIlIIlIIlIIIIlIlII) {
        return this.blockData.get(lllllllllllllIIIlIIlIIlIIIIlIlII);
    }
    
    private WrappedBlockData(final String lllllllllllllIIIlIIlIIlIIIllIllI, final int lllllllllllllIIIlIIlIIlIIIllIlIl) {
        this.blockData = new LinkedHashMap<String, String>();
        this.minecraftKey = lllllllllllllIIIlIIlIIlIIIllIllI;
        this.savedBlockStateId = lllllllllllllIIIlIIlIIlIIIllIlIl;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIIlIIlIIlIIIlIlllI = new StringBuilder(String.valueOf(new StringBuilder().append(this.minecraftKey).append("[")));
        for (final Map.Entry<String, String> lllllllllllllIIIlIIlIIlIIIllIIII : this.blockData.entrySet()) {
            lllllllllllllIIIlIIlIIlIIIlIlllI.append(lllllllllllllIIIlIIlIIlIIIllIIII.getKey()).append('=').append(lllllllllllllIIIlIIlIIlIIIllIIII.getValue()).append(',');
        }
        return String.valueOf(new StringBuilder().append(lllllllllllllIIIlIIlIIlIIIlIlllI.substring(0, lllllllllllllIIIlIIlIIlIIIlIlllI.length() - 1)).append("]"));
    }
    
    public static WrappedBlockData fromStateId(final int lllllllllllllIIIlIIlIIlIIlIIIIIl) {
        final String lllllllllllllIIIlIIlIIlIIlIIIIII = ConnectionData.getKey(lllllllllllllIIIlIIlIIlIIlIIIIIl);
        if (lllllllllllllIIIlIIlIIlIIlIIIIII != null) {
            return fromString(lllllllllllllIIIlIIlIIlIIlIIIIII);
        }
        Via.getPlatform().getLogger().info(String.valueOf(new StringBuilder().append("Unable to get blockdata from ").append(lllllllllllllIIIlIIlIIlIIlIIIIIl)));
        return fromString("minecraft:air");
    }
}
