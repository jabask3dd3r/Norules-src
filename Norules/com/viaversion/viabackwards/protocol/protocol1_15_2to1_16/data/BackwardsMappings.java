package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.data;

import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class BackwardsMappings extends com.viaversion.viabackwards.api.data.BackwardsMappings
{
    private final /* synthetic */ Map<String, String> attributeMappings;
    
    public Map<String, String> getAttributeMappings() {
        return this.attributeMappings;
    }
    
    public BackwardsMappings() {
        super("1.16", "1.15", Protocol1_16To1_15_2.class, true);
        this.attributeMappings = new HashMap<String, String>();
    }
    
    @Override
    protected void loadVBExtras(final JsonObject llllllllllllllIIllIllIIllIIIlIlI, final JsonObject llllllllllllllIIllIllIIllIIIlIIl) {
        for (final Map.Entry<String, String> llllllllllllllIIllIllIIllIIIllII : Protocol1_16To1_15_2.MAPPINGS.getAttributeMappings().entrySet()) {
            this.attributeMappings.put(llllllllllllllIIllIllIIllIIIllII.getValue(), llllllllllllllIIllIllIIllIIIllII.getKey());
        }
    }
}
