package com.viaversion.viaversion.libs.gson;

import java.math.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.io.*;

public abstract class JsonElement
{
    public short getAsShort() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public long getAsLong() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public String getAsString() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public JsonArray getAsJsonArray() {
        if (this.isJsonArray()) {
            return (JsonArray)this;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Not a JSON Array: ").append(this)));
    }
    
    public JsonNull getAsJsonNull() {
        if (this.isJsonNull()) {
            return (JsonNull)this;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Not a JSON Null: ").append(this)));
    }
    
    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }
    
    public double getAsDouble() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public JsonObject getAsJsonObject() {
        if (this.isJsonObject()) {
            return (JsonObject)this;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Not a JSON Object: ").append(this)));
    }
    
    public float getAsFloat() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public abstract JsonElement deepCopy();
    
    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }
    
    @Deprecated
    public char getAsCharacter() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }
    
    public int getAsInt() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    @Override
    public String toString() {
        try {
            final StringWriter lllllllllllllIIlIlIIlIIlIlIlllll = new StringWriter();
            final JsonWriter lllllllllllllIIlIlIIlIIlIlIllllI = new JsonWriter(lllllllllllllIIlIlIIlIIlIlIlllll);
            lllllllllllllIIlIlIIlIIlIlIllllI.setLenient(true);
            Streams.write(this, lllllllllllllIIlIlIIlIIlIlIllllI);
            return lllllllllllllIIlIlIIlIIlIlIlllll.toString();
        }
        catch (IOException lllllllllllllIIlIlIIlIIlIlIlllIl) {
            throw new AssertionError((Object)lllllllllllllIIlIlIIlIIlIlIlllIl);
        }
    }
    
    public byte getAsByte() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public Number getAsNumber() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public JsonPrimitive getAsJsonPrimitive() {
        if (this.isJsonPrimitive()) {
            return (JsonPrimitive)this;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Not a JSON Primitive: ").append(this)));
    }
    
    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }
    
    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }
}
