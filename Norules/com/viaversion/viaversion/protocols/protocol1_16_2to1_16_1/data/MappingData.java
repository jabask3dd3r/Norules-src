package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.data;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.minecraft.nbt.*;
import com.viaversion.viaversion.api.*;
import java.io.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public class MappingData extends MappingDataBase
{
    private final /* synthetic */ Map<String, CompoundTag> dimensionDataMap;
    private /* synthetic */ CompoundTag dimensionRegistry;
    
    public void loadExtras(final JsonObject lllllllllllllIIllIIIllIIlIlIllII, final JsonObject lllllllllllllIIllIIIllIIlIlIlIll, final JsonObject lllllllllllllIIllIIIllIIlIlIlIlI) {
        try {
            this.dimensionRegistry = BinaryTagIO.readCompressedInputStream(MappingDataLoader.getResource("dimension-registry-1.16.2.nbt"));
        }
        catch (IOException lllllllllllllIIllIIIllIIlIllIIIl) {
            Via.getPlatform().getLogger().severe("Error loading dimension registry:");
            lllllllllllllIIllIIIllIIlIllIIIl.printStackTrace();
        }
        final ListTag lllllllllllllIIllIIIllIIlIlIlIIl = this.dimensionRegistry.get("minecraft:dimension_type").get("value");
        for (final Tag lllllllllllllIIllIIIllIIlIlIlllI : lllllllllllllIIllIIIllIIlIlIlIIl) {
            final CompoundTag lllllllllllllIIllIIIllIIlIllIIII = (CompoundTag)lllllllllllllIIllIIIllIIlIlIlllI;
            final CompoundTag lllllllllllllIIllIIIllIIlIlIllll = new CompoundTag(lllllllllllllIIllIIIllIIlIllIIII.get("element").getValue());
            this.dimensionDataMap.put(lllllllllllllIIllIIIllIIlIllIIII.get("name").getValue(), lllllllllllllIIllIIIllIIlIlIllll);
        }
    }
    
    public Map<String, CompoundTag> getDimensionDataMap() {
        return this.dimensionDataMap;
    }
    
    public CompoundTag getDimensionRegistry() {
        return this.dimensionRegistry;
    }
    
    public MappingData() {
        super("1.16", "1.16.2", true);
        this.dimensionDataMap = new HashMap<String, CompoundTag>();
    }
}
