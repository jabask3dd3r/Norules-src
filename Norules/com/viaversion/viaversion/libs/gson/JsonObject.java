package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.internal.*;
import java.util.*;

public final class JsonObject extends JsonElement
{
    private final /* synthetic */ LinkedTreeMap<String, JsonElement> members;
    
    public JsonArray getAsJsonArray(final String lllllllllllllllIlIlIlIIllllIllIl) {
        return this.members.get(lllllllllllllllIlIlIlIIllllIllIl);
    }
    
    public int size() {
        return this.members.size();
    }
    
    public JsonObject getAsJsonObject(final String lllllllllllllllIlIlIlIIllllIlIIl) {
        return this.members.get(lllllllllllllllIlIlIlIIllllIlIIl);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlIlIlIIllllIIIll) {
        return lllllllllllllllIlIlIlIIllllIIIll == this || (lllllllllllllllIlIlIlIIllllIIIll instanceof JsonObject && ((JsonObject)lllllllllllllllIlIlIlIIllllIIIll).members.equals(this.members));
    }
    
    @Override
    public int hashCode() {
        return this.members.hashCode();
    }
    
    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }
    
    public JsonElement get(final String lllllllllllllllIlIlIlIIllllllIIl) {
        return this.members.get(lllllllllllllllIlIlIlIIllllllIIl);
    }
    
    public void addProperty(final String lllllllllllllllIlIlIlIlIIIIlIIlI, final Character lllllllllllllllIlIlIlIlIIIIlIIIl) {
        this.add(lllllllllllllllIlIlIlIlIIIIlIIlI, (lllllllllllllllIlIlIlIlIIIIlIIIl == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllllIlIlIlIlIIIIlIIIl));
    }
    
    public void addProperty(final String lllllllllllllllIlIlIlIlIIIlIIIIl, final Number lllllllllllllllIlIlIlIlIIIlIIIII) {
        this.add(lllllllllllllllIlIlIlIlIIIlIIIIl, (lllllllllllllllIlIlIlIlIIIlIIIII == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllllIlIlIlIlIIIlIIIII));
    }
    
    public JsonObject() {
        this.members = new LinkedTreeMap<String, JsonElement>();
    }
    
    public boolean has(final String lllllllllllllllIlIlIlIlIIIIIIIIl) {
        return this.members.containsKey(lllllllllllllllIlIlIlIlIIIIIIIIl);
    }
    
    @Override
    public JsonObject deepCopy() {
        final JsonObject lllllllllllllllIlIlIlIlIIlIIIlIl = new JsonObject();
        for (final Map.Entry<String, JsonElement> lllllllllllllllIlIlIlIlIIlIIIlll : this.members.entrySet()) {
            lllllllllllllllIlIlIlIlIIlIIIlIl.add(lllllllllllllllIlIlIlIlIIlIIIlll.getKey(), lllllllllllllllIlIlIlIlIIlIIIlll.getValue().deepCopy());
        }
        return lllllllllllllllIlIlIlIlIIlIIIlIl;
    }
    
    public JsonElement remove(final String lllllllllllllllIlIlIlIlIIIllIlII) {
        return this.members.remove(lllllllllllllllIlIlIlIlIIIllIlII);
    }
    
    public void addProperty(final String lllllllllllllllIlIlIlIlIIIlIlIlI, final String lllllllllllllllIlIlIlIlIIIlIllII) {
        this.add(lllllllllllllllIlIlIlIlIIIlIlIlI, (lllllllllllllllIlIlIlIlIIIlIllII == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllllIlIlIlIlIIIlIllII));
    }
    
    public void addProperty(final String lllllllllllllllIlIlIlIlIIIIllIII, final Boolean lllllllllllllllIlIlIlIlIIIIlIlll) {
        this.add(lllllllllllllllIlIlIlIlIIIIllIII, (lllllllllllllllIlIlIlIlIIIIlIlll == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllllIlIlIlIlIIIIlIlll));
    }
    
    public void add(final String lllllllllllllllIlIlIlIlIIIllllII, final JsonElement lllllllllllllllIlIlIlIlIIIlllIll) {
        this.members.put(lllllllllllllllIlIlIlIlIIIllllII, (lllllllllllllllIlIlIlIlIIIlllIll == null) ? JsonNull.INSTANCE : lllllllllllllllIlIlIlIlIIIlllIll);
    }
    
    public Set<String> keySet() {
        return this.members.keySet();
    }
    
    public JsonPrimitive getAsJsonPrimitive(final String lllllllllllllllIlIlIlIIlllllIIll) {
        return this.members.get(lllllllllllllllIlIlIlIIlllllIIll);
    }
}
