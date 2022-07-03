package com.viaversion.viaversion.libs.gson;

import java.util.*;
import java.math.*;

public final class JsonArray extends JsonElement implements Iterable<JsonElement>
{
    private final /* synthetic */ List<JsonElement> elements;
    
    public void add(final Number lllllllllllllIlIIIlIIIlllIIllIII) {
        this.elements.add((lllllllllllllIlIIIlIIIlllIIllIII == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllIlIIIlIIIlllIIllIII));
    }
    
    public boolean remove(final JsonElement lllllllllllllIlIIIlIIIllIlllIlll) {
        return this.elements.remove(lllllllllllllIlIIIlIIIllIlllIlll);
    }
    
    @Override
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIIlIIIllIIllIIlI) {
        return lllllllllllllIlIIIlIIIllIIllIIlI == this || (lllllllllllllIlIIIlIIIllIIllIIlI instanceof JsonArray && ((JsonArray)lllllllllllllIlIIIlIIIllIIllIIlI).elements.equals(this.elements));
    }
    
    @Override
    public int getAsInt() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }
    
    public JsonElement remove(final int lllllllllllllIlIIIlIIIllIlllIIll) {
        return this.elements.remove(lllllllllllllIlIIIlIIIllIlllIIll);
    }
    
    public int size() {
        return this.elements.size();
    }
    
    @Override
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }
    
    public void add(final Boolean lllllllllllllIlIIIlIIIlllIlIIlII) {
        this.elements.add((lllllllllllllIlIIIlIIIlllIlIIlII == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllIlIIIlIIIlllIlIIlII));
    }
    
    public void addAll(final JsonArray lllllllllllllIlIIIlIIIlllIIIIllI) {
        this.elements.addAll(lllllllllllllIlIIIlIIIlllIIIIllI.elements);
    }
    
    @Override
    public String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new IllegalStateException();
    }
    
    public JsonArray(final int lllllllllllllIlIIIlIIIlllIllIlIl) {
        this.elements = new ArrayList<JsonElement>(lllllllllllllIlIIIlIIIlllIllIlIl);
    }
    
    public void add(final String lllllllllllllIlIIIlIIIlllIIlIIlI) {
        this.elements.add((lllllllllllllIlIIIlIIIlllIIlIIlI == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllIlIIIlIIIlllIIlIIlI));
    }
    
    @Override
    public long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }
    
    public void add(final Character lllllllllllllIlIIIlIIIlllIlIIIII) {
        this.elements.add((lllllllllllllIlIIIlIIIlllIlIIIII == null) ? JsonNull.INSTANCE : new JsonPrimitive(lllllllllllllIlIIIlIIIlllIlIIIII));
    }
    
    @Override
    public double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }
    
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }
    
    public JsonArray() {
        this.elements = new ArrayList<JsonElement>();
    }
    
    @Override
    public byte getAsByte() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }
    
    public JsonElement get(final int lllllllllllllIlIIIlIIIllIlIllllI) {
        return this.elements.get(lllllllllllllIlIIIlIIIllIlIllllI);
    }
    
    @Override
    public float getAsFloat() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }
    
    @Override
    public int hashCode() {
        return this.elements.hashCode();
    }
    
    public JsonElement set(final int lllllllllllllIlIIIlIIIlllIIIIIIl, final JsonElement lllllllllllllIlIIIlIIIllIlllllIl) {
        return this.elements.set(lllllllllllllIlIIIlIIIlllIIIIIIl, lllllllllllllIlIIIlIIIllIlllllIl);
    }
    
    public void add(JsonElement lllllllllllllIlIIIlIIIlllIIIllII) {
        if (lllllllllllllIlIIIlIIIlllIIIllII == null) {
            lllllllllllllIlIIIlIIIlllIIIllII = JsonNull.INSTANCE;
        }
        this.elements.add(lllllllllllllIlIIIlIIIlllIIIllII);
    }
    
    @Override
    public BigInteger getAsBigInteger() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }
    
    @Override
    public short getAsShort() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }
    
    @Override
    public JsonArray deepCopy() {
        if (!this.elements.isEmpty()) {
            final JsonArray lllllllllllllIlIIIlIIIlllIlIllll = new JsonArray(this.elements.size());
            for (final JsonElement lllllllllllllIlIIIlIIIlllIllIIII : this.elements) {
                lllllllllllllIlIIIlIIIlllIlIllll.add(lllllllllllllIlIIIlIIIlllIllIIII.deepCopy());
            }
            return lllllllllllllIlIIIlIIIlllIlIllll;
        }
        return new JsonArray();
    }
    
    @Override
    public Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }
    
    @Override
    public boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }
    
    @Override
    public char getAsCharacter() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }
    
    public boolean contains(final JsonElement lllllllllllllIlIIIlIIIllIllIllIl) {
        return this.elements.contains(lllllllllllllIlIIIlIIIllIllIllIl);
    }
}
