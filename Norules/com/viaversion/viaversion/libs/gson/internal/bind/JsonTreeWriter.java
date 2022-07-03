package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public final class JsonTreeWriter extends JsonWriter
{
    private static final /* synthetic */ JsonPrimitive SENTINEL_CLOSED;
    private final /* synthetic */ List<JsonElement> stack;
    private static final /* synthetic */ Writer UNWRITABLE_WRITER;
    private /* synthetic */ JsonElement product;
    private /* synthetic */ String pendingName;
    
    @Override
    public void flush() throws IOException {
    }
    
    @Override
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        final JsonElement lllllllllllllIIlIIlllIllIIllllII = this.peek();
        if (lllllllllllllIIlIIlllIllIIllllII instanceof JsonObject) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }
    
    @Override
    public JsonWriter nullValue() throws IOException {
        this.put(JsonNull.INSTANCE);
        return this;
    }
    
    @Override
    public JsonWriter value(final boolean lllllllllllllIIlIIlllIllIIlIIIlI) throws IOException {
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIlIIIlI));
        return this;
    }
    
    private void put(final JsonElement lllllllllllllIIlIIlllIllIlIlIlIl) {
        if (this.pendingName != null) {
            if (!lllllllllllllIIlIIlllIllIlIlIlIl.isJsonNull() || this.getSerializeNulls()) {
                final JsonObject lllllllllllllIIlIIlllIllIlIllIII = (JsonObject)this.peek();
                lllllllllllllIIlIIlllIllIlIllIII.add(this.pendingName, lllllllllllllIIlIIlllIllIlIlIlIl);
            }
            this.pendingName = null;
        }
        else if (this.stack.isEmpty()) {
            this.product = lllllllllllllIIlIIlllIllIlIlIlIl;
        }
        else {
            final JsonElement lllllllllllllIIlIIlllIllIlIlIlll = this.peek();
            if (!(lllllllllllllIIlIIlllIllIlIlIlll instanceof JsonArray)) {
                throw new IllegalStateException();
            }
            ((JsonArray)lllllllllllllIIlIIlllIllIlIlIlll).add(lllllllllllllIIlIIlllIllIlIlIlIl);
        }
    }
    
    @Override
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        final JsonElement lllllllllllllIIlIIlllIllIlIIlIII = this.peek();
        if (lllllllllllllIIlIIlllIllIlIIlIII instanceof JsonArray) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }
    
    @Override
    public JsonWriter beginArray() throws IOException {
        final JsonArray lllllllllllllIIlIIlllIllIlIIlllI = new JsonArray();
        this.put(lllllllllllllIIlIIlllIllIlIIlllI);
        this.stack.add(lllllllllllllIIlIIlllIllIlIIlllI);
        return this;
    }
    
    @Override
    public JsonWriter value(final Number lllllllllllllIIlIIlllIllIIIIlIlI) throws IOException {
        if (lllllllllllllIIlIIlllIllIIIIlIlI == null) {
            return this.nullValue();
        }
        if (!this.isLenient()) {
            final double lllllllllllllIIlIIlllIllIIIIllII = lllllllllllllIIlIIlllIllIIIIlIlI.doubleValue();
            if (Double.isNaN(lllllllllllllIIlIIlllIllIIIIllII) || Double.isInfinite(lllllllllllllIIlIIlllIllIIIIllII)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("JSON forbids NaN and infinities: ").append(lllllllllllllIIlIIlllIllIIIIlIlI)));
            }
        }
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIIIlIlI));
        return this;
    }
    
    public JsonElement get() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected one JSON element but was ").append(this.stack)));
        }
        return this.product;
    }
    
    public JsonTreeWriter() {
        super(JsonTreeWriter.UNWRITABLE_WRITER);
        this.stack = new ArrayList<JsonElement>();
        this.product = JsonNull.INSTANCE;
    }
    
    @Override
    public JsonWriter value(final double lllllllllllllIIlIIlllIllIIIlIllI) throws IOException {
        if (!this.isLenient() && (Double.isNaN(lllllllllllllIIlIIlllIllIIIlIllI) || Double.isInfinite(lllllllllllllIIlIIlllIllIIIlIllI))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("JSON forbids NaN and infinities: ").append(lllllllllllllIIlIIlllIllIIIlIllI)));
        }
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIIlIllI));
        return this;
    }
    
    @Override
    public JsonWriter value(final String lllllllllllllIIlIIlllIllIIlIlIll) throws IOException {
        if (lllllllllllllIIlIIlllIllIIlIlIll == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIlIlIll));
        return this;
    }
    
    private JsonElement peek() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    @Override
    public JsonWriter name(final String lllllllllllllIIlIIlllIllIIllIlIl) throws IOException {
        if (lllllllllllllIIlIIlllIllIIllIlIl == null) {
            throw new NullPointerException("name == null");
        }
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        final JsonElement lllllllllllllIIlIIlllIllIIllIlII = this.peek();
        if (lllllllllllllIIlIIlllIllIIllIlII instanceof JsonObject) {
            this.pendingName = lllllllllllllIIlIIlllIllIIllIlIl;
            return this;
        }
        throw new IllegalStateException();
    }
    
    @Override
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(JsonTreeWriter.SENTINEL_CLOSED);
    }
    
    @Override
    public JsonWriter value(final long lllllllllllllIIlIIlllIllIIIlIIlI) throws IOException {
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIIlIIlI));
        return this;
    }
    
    @Override
    public JsonWriter beginObject() throws IOException {
        final JsonObject lllllllllllllIIlIIlllIllIlIIIIlI = new JsonObject();
        this.put(lllllllllllllIIlIIlllIllIlIIIIlI);
        this.stack.add(lllllllllllllIIlIIlllIllIlIIIIlI);
        return this;
    }
    
    static {
        UNWRITABLE_WRITER = new Writer() {
            @Override
            public void close() throws IOException {
                throw new AssertionError();
            }
            
            @Override
            public void write(final char[] lllllllllllllIIIlIllIlIlllIIllII, final int lllllllllllllIIIlIllIlIlllIIlIll, final int lllllllllllllIIIlIllIlIlllIIlIlI) {
                throw new AssertionError();
            }
            
            @Override
            public void flush() throws IOException {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }
    
    @Override
    public JsonWriter value(final Boolean lllllllllllllIIlIIlllIllIIIlllII) throws IOException {
        if (lllllllllllllIIlIIlllIllIIIlllII == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(lllllllllllllIIlIIlllIllIIIlllII));
        return this;
    }
}
