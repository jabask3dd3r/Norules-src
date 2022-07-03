package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public class ParticleMappings
{
    private final /* synthetic */ int fallingDustId;
    private final /* synthetic */ Mappings mappings;
    private final /* synthetic */ int itemId;
    private final /* synthetic */ int blockId;
    
    public int getFallingDustId() {
        return this.fallingDustId;
    }
    
    public int getItemId() {
        return this.itemId;
    }
    
    public int getBlockId() {
        return this.blockId;
    }
    
    public ParticleMappings(final JsonArray llllllllllllIllllllIIlllllIlllII, final Mappings llllllllllllIllllllIIlllllIlIlll) {
        this.mappings = llllllllllllIllllllIIlllllIlIlll;
        final Object2IntMap<String> llllllllllllIllllllIIlllllIllIlI = MappingDataLoader.arrayToMap(llllllllllllIllllllIIlllllIlllII);
        this.blockId = llllllllllllIllllllIIlllllIllIlI.getInt("block");
        this.fallingDustId = llllllllllllIllllllIIlllllIllIlI.getInt("falling_dust");
        this.itemId = llllllllllllIllllllIIlllllIllIlI.getInt("item");
    }
    
    public Mappings getMappings() {
        return this.mappings;
    }
}
