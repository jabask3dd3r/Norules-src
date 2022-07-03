package com.viaversion.viaversion.protocols.protocol1_15to1_14_4.data;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.data.*;

public class MappingData extends MappingDataBase
{
    public MappingData() {
        super("1.14", "1.15", true);
    }
    
    @Override
    protected Mappings loadFromArray(final JsonObject llllllllllllllIllIlIlIlIllIIlIll, final JsonObject llllllllllllllIllIlIlIlIllIIllll, final JsonObject llllllllllllllIllIlIlIlIllIIlllI, final String llllllllllllllIllIlIlIlIllIIIllI) {
        if (!llllllllllllllIllIlIlIlIllIIIllI.equals("sounds")) {
            return super.loadFromArray(llllllllllllllIllIlIlIlIllIIlIll, llllllllllllllIllIlIlIlIllIIllll, llllllllllllllIllIlIlIlIllIIlllI, llllllllllllllIllIlIlIlIllIIIllI);
        }
        return new IntArrayMappings(llllllllllllllIllIlIlIlIllIIlIll.getAsJsonArray(llllllllllllllIllIlIlIlIllIIIllI), llllllllllllllIllIlIlIlIllIIllll.getAsJsonArray(llllllllllllllIllIlIlIlIllIIIllI), false);
    }
}
