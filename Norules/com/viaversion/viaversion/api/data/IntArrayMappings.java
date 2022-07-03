package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public class IntArrayMappings implements Mappings
{
    protected final /* synthetic */ int[] oldToNew;
    
    public IntArrayMappings(final JsonArray lllllllllllllIIlIlllIIllIIIIIIlI, final JsonArray lllllllllllllIIlIlllIIllIIIIIlIl, final boolean lllllllllllllIIlIlllIIllIIIIIlII) {
        this(lllllllllllllIIlIlllIIllIIIIIIlI.size(), lllllllllllllIIlIlllIIllIIIIIIlI, lllllllllllllIIlIlllIIllIIIIIlIl, lllllllllllllIIlIlllIIllIIIIIlII);
    }
    
    public IntArrayMappings(final int lllllllllllllIIlIlllIIlIlllllIlI, final JsonArray lllllllllllllIIlIlllIIlIlllllIIl, final JsonArray lllllllllllllIIlIlllIIlIlllllIII) {
        this(lllllllllllllIIlIlllIIlIlllllIlI, lllllllllllllIIlIlllIIlIlllllIIl, lllllllllllllIIlIlllIIlIlllllIII, true);
    }
    
    @Override
    public void setNewId(final int lllllllllllllIIlIlllIIlIllIlIIIl, final int lllllllllllllIIlIlllIIlIllIlIIll) {
        this.oldToNew[lllllllllllllIIlIlllIIlIllIlIIIl] = lllllllllllllIIlIlllIIlIllIlIIll;
    }
    
    @Override
    public int getNewId(final int lllllllllllllIIlIlllIIlIllIllIIl) {
        return (lllllllllllllIIlIlllIIlIllIllIIl >= 0 && lllllllllllllIIlIlllIIlIllIllIIl < this.oldToNew.length) ? this.oldToNew[lllllllllllllIIlIlllIIlIllIllIIl] : -1;
    }
    
    public IntArrayMappings(final JsonArray lllllllllllllIIlIlllIIlIlllIlllI, final JsonArray lllllllllllllIIlIlllIIlIlllIllIl, final JsonObject lllllllllllllIIlIlllIIlIlllIllII) {
        this(lllllllllllllIIlIlllIIlIlllIlllI.size(), lllllllllllllIIlIlllIIlIlllIlllI, lllllllllllllIIlIlllIIlIlllIllIl, lllllllllllllIIlIlllIIlIlllIllII, true);
    }
    
    public IntArrayMappings(final int lllllllllllllIIlIlllIIllIIlIIlIl, final JsonArray lllllllllllllIIlIlllIIllIIlIIlII, final JsonArray lllllllllllllIIlIlllIIllIIIlllIl, final JsonObject lllllllllllllIIlIlllIIllIIIlllII, final boolean lllllllllllllIIlIlllIIllIIlIIIIl) {
        this.oldToNew = new int[lllllllllllllIIlIlllIIllIIlIIlIl];
        Arrays.fill(this.oldToNew, -1);
        MappingDataLoader.mapIdentifiers(this.oldToNew, lllllllllllllIIlIlllIIllIIlIIlII, lllllllllllllIIlIlllIIllIIIlllIl, lllllllllllllIIlIlllIIllIIIlllII, lllllllllllllIIlIlllIIllIIlIIIIl);
    }
    
    public int[] getOldToNew() {
        return this.oldToNew;
    }
    
    public IntArrayMappings(final int lllllllllllllIIlIlllIIllIIllllII, final JsonObject lllllllllllllIIlIlllIIllIIllIlll, final JsonObject lllllllllllllIIlIlllIIllIIllIllI) {
        this.oldToNew = new int[lllllllllllllIIlIlllIIllIIllllII];
        Arrays.fill(this.oldToNew, -1);
        MappingDataLoader.mapIdentifiers(this.oldToNew, lllllllllllllIIlIlllIIllIIllIlll, lllllllllllllIIlIlllIIllIIllIllI);
    }
    
    public IntArrayMappings(final int[] lllllllllllllIIlIlllIIllIlIlllll) {
        this.oldToNew = lllllllllllllIIlIlllIIllIlIlllll;
    }
    
    public IntArrayMappings(final JsonArray lllllllllllllIIlIlllIIlIlllIIIll, final JsonArray lllllllllllllIIlIlllIIlIllIlllll) {
        this(lllllllllllllIIlIlllIIlIlllIIIll.size(), lllllllllllllIIlIlllIIlIlllIIIll, lllllllllllllIIlIlllIIlIllIlllll, true);
    }
    
    public IntArrayMappings(final JsonObject lllllllllllllIIlIlllIIllIIlIlllI, final JsonObject lllllllllllllIIlIlllIIllIIlIllIl) {
        this(lllllllllllllIIlIlllIIllIIlIlllI.entrySet().size(), lllllllllllllIIlIlllIIllIIlIlllI, lllllllllllllIIlIlllIIllIIlIllIl);
    }
    
    public IntArrayMappings(final JsonObject lllllllllllllIIlIlllIIllIlIIlIII, final JsonObject lllllllllllllIIlIlllIIllIlIIIIll, final JsonObject lllllllllllllIIlIlllIIllIlIIIllI) {
        this(lllllllllllllIIlIlllIIllIlIIlIII.entrySet().size(), lllllllllllllIIlIlllIIllIlIIlIII, lllllllllllllIIlIlllIIllIlIIIIll, lllllllllllllIIlIlllIIllIlIIIllI);
    }
    
    public IntArrayMappings(final int lllllllllllllIIlIlllIIllIIIlIlII, final JsonArray lllllllllllllIIlIlllIIllIIIIlllI, final JsonArray lllllllllllllIIlIlllIIllIIIIllIl, final boolean lllllllllllllIIlIlllIIllIIIIllII) {
        this(lllllllllllllIIlIlllIIllIIIlIlII, lllllllllllllIIlIlllIIllIIIIlllI, lllllllllllllIIlIlllIIllIIIIllIl, null, lllllllllllllIIlIlllIIllIIIIllII);
    }
    
    public IntArrayMappings(final int lllllllllllllIIlIlllIIllIlIlIllI, final JsonObject lllllllllllllIIlIlllIIllIlIlIlIl, final JsonObject lllllllllllllIIlIlllIIllIlIlIlII, final JsonObject lllllllllllllIIlIlllIIllIlIlIIll) {
        this.oldToNew = new int[lllllllllllllIIlIlllIIllIlIlIllI];
        Arrays.fill(this.oldToNew, -1);
        MappingDataLoader.mapIdentifiers(this.oldToNew, lllllllllllllIIlIlllIIllIlIlIlIl, lllllllllllllIIlIlllIIllIlIlIlII, lllllllllllllIIlIlllIIllIlIlIIll);
    }
}
