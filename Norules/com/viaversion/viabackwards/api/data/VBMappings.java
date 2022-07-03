package com.viaversion.viabackwards.api.data;

import com.viaversion.viaversion.api.data.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class VBMappings extends IntArrayMappings
{
    public VBMappings(final JsonObject lllllllllllllIIIIIIlIIIlIIIIIlll, final JsonObject lllllllllllllIIIIIIlIIIlIIIIlIll, final JsonObject lllllllllllllIIIIIIlIIIlIIIIIlIl, final boolean lllllllllllllIIIIIIlIIIlIIIIlIIl) {
        super(create(lllllllllllllIIIIIIlIIIlIIIIIlll.entrySet().size(), lllllllllllllIIIIIIlIIIlIIIIIlll, lllllllllllllIIIIIIlIIIlIIIIlIll, lllllllllllllIIIIIIlIIIlIIIIIlIl, lllllllllllllIIIIIIlIIIlIIIIlIIl));
    }
    
    public VBMappings(final JsonObject lllllllllllllIIIIIIlIIIIlllllIlI, final JsonObject lllllllllllllIIIIIIlIIIIlllllIIl, final boolean lllllllllllllIIIIIIlIIIIlllllIII) {
        this(lllllllllllllIIIIIIlIIIIlllllIlI, lllllllllllllIIIIIIlIIIIlllllIIl, null, lllllllllllllIIIIIIlIIIIlllllIII);
    }
    
    public VBMappings(final int lllllllllllllIIIIIIlIIIlIIIllIll, final JsonObject lllllllllllllIIIIIIlIIIlIIlIIIll, final JsonObject lllllllllllllIIIIIIlIIIlIIlIIIIl, final JsonObject lllllllllllllIIIIIIlIIIlIIIlIlII, final boolean lllllllllllllIIIIIIlIIIlIIIlIIll) {
        super(create(lllllllllllllIIIIIIlIIIlIIIllIll, lllllllllllllIIIIIIlIIIlIIlIIIll, lllllllllllllIIIIIIlIIIlIIlIIIIl, lllllllllllllIIIIIIlIIIlIIIlIlII, lllllllllllllIIIIIIlIIIlIIIlIIll));
    }
    
    private static int[] create(final int lllllllllllllIIIIIIlIIIIllIlllII, final JsonObject lllllllllllllIIIIIIlIIIIllIllIll, final JsonObject lllllllllllllIIIIIIlIIIIllIllIlI, final JsonObject lllllllllllllIIIIIIlIIIIllIlllll, final boolean lllllllllllllIIIIIIlIIIIllIllllI) {
        final int[] lllllllllllllIIIIIIlIIIIllIlllIl = new int[lllllllllllllIIIIIIlIIIIllIlllII];
        Arrays.fill(lllllllllllllIIIIIIlIIIIllIlllIl, -1);
        VBMappingDataLoader.mapIdentifiers(lllllllllllllIIIIIIlIIIIllIlllIl, lllllllllllllIIIIIIlIIIIllIllIll, lllllllllllllIIIIIIlIIIIllIllIlI, lllllllllllllIIIIIIlIIIIllIlllll, lllllllllllllIIIIIIlIIIIllIllllI);
        return lllllllllllllIIIIIIlIIIIllIlllIl;
    }
    
    public VBMappings(final JsonArray lllllllllllllIIIIIIlIIIIlllIllII, final JsonArray lllllllllllllIIIIIIlIIIIlllIlIll, final JsonObject lllllllllllllIIIIIIlIIIIlllIlIlI, final boolean lllllllllllllIIIIIIlIIIIlllIlllI) {
        super(lllllllllllllIIIIIIlIIIIlllIllII.size(), lllllllllllllIIIIIIlIIIIlllIllII, lllllllllllllIIIIIIlIIIIlllIlIll, lllllllllllllIIIIIIlIIIIlllIlIlI, lllllllllllllIIIIIIlIIIIlllIlllI);
    }
}
