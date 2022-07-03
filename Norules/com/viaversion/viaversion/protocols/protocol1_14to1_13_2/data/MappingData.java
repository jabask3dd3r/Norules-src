package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data;

import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class MappingData extends MappingDataBase
{
    private /* synthetic */ IntSet nonFullBlocks;
    private /* synthetic */ IntSet motionBlocking;
    
    public MappingData() {
        super("1.13.2", "1.14");
    }
    
    public void loadExtras(final JsonObject lllllllllllllIllIlIlIIIllIlIlllI, final JsonObject lllllllllllllIllIlIlIIIllIllIlIl, final JsonObject lllllllllllllIllIlIlIIIllIllIlII) {
        final JsonObject lllllllllllllIllIlIlIIIllIllIIll = lllllllllllllIllIlIlIIIllIllIlIl.getAsJsonObject("blockstates");
        final Map<String, Integer> lllllllllllllIllIlIlIIIllIllIIlI = new HashMap<String, Integer>(lllllllllllllIllIlIlIIIllIllIIll.entrySet().size());
        for (final Map.Entry<String, JsonElement> lllllllllllllIllIlIlIIIllIlllllI : lllllllllllllIllIlIlIIIllIllIIll.entrySet()) {
            lllllllllllllIllIlIlIIIllIllIIlI.put(lllllllllllllIllIlIlIIIllIlllllI.getValue().getAsString(), Integer.parseInt(lllllllllllllIllIlIlIIIllIlllllI.getKey()));
        }
        final JsonObject lllllllllllllIllIlIlIIIllIllIIIl = MappingDataLoader.loadData("heightMapData-1.14.json");
        final JsonArray lllllllllllllIllIlIlIIIllIllIIII = lllllllllllllIllIlIlIIIllIllIIIl.getAsJsonArray("MOTION_BLOCKING");
        this.motionBlocking = new IntOpenHashSet(lllllllllllllIllIlIlIIIllIllIIII.size(), 1.0f);
        for (final JsonElement lllllllllllllIllIlIlIIIllIlllIll : lllllllllllllIllIlIlIIIllIllIIII) {
            final String lllllllllllllIllIlIlIIIllIllllIl = lllllllllllllIllIlIlIIIllIlllIll.getAsString();
            final Integer lllllllllllllIllIlIlIIIllIllllII = lllllllllllllIllIlIlIIIllIllIIlI.get(lllllllllllllIllIlIlIIIllIllllIl);
            if (lllllllllllllIllIlIlIIIllIllllII == null) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unknown blockstate ").append(lllllllllllllIllIlIlIIIllIllllIl).append(" :(")));
            }
            else {
                this.motionBlocking.add((int)lllllllllllllIllIlIlIIIllIllllII);
            }
        }
        if (Via.getConfig().isNonFullBlockLightFix()) {
            this.nonFullBlocks = new IntOpenHashSet(1611, 1.0f);
            for (final Map.Entry<String, JsonElement> lllllllllllllIllIlIlIIIllIlllIIl : lllllllllllllIllIlIlIIIllIlIlllI.getAsJsonObject("blockstates").entrySet()) {
                final String lllllllllllllIllIlIlIIIllIlllIlI = lllllllllllllIllIlIlIIIllIlllIIl.getValue().getAsString();
                if (lllllllllllllIllIlIlIIIllIlllIlI.contains("_slab") || lllllllllllllIllIlIlIIIllIlllIlI.contains("_stairs") || lllllllllllllIllIlIlIIIllIlllIlI.contains("_wall[")) {
                    this.nonFullBlocks.add(this.blockStateMappings.getNewId(Integer.parseInt(lllllllllllllIllIlIlIIIllIlllIIl.getKey())));
                }
            }
            this.nonFullBlocks.add(this.blockStateMappings.getNewId(8163));
            for (int lllllllllllllIllIlIlIIIllIlllIII = 3060; lllllllllllllIllIlIlIIIllIlllIII <= 3067; ++lllllllllllllIllIlIlIIIllIlllIII) {
                this.nonFullBlocks.add(this.blockStateMappings.getNewId(lllllllllllllIllIlIlIIIllIlllIII));
            }
        }
    }
    
    public IntSet getNonFullBlocks() {
        return this.nonFullBlocks;
    }
    
    public IntSet getMotionBlocking() {
        return this.motionBlocking;
    }
}
