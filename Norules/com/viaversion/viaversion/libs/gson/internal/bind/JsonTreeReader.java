package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public final class JsonTreeReader extends JsonReader
{
    private /* synthetic */ int[] pathIndices;
    private static final /* synthetic */ Reader UNREADABLE_READER;
    private /* synthetic */ Object[] stack;
    private /* synthetic */ int stackSize;
    private /* synthetic */ String[] pathNames;
    private static final /* synthetic */ Object SENTINEL_CLOSED;
    
    public JsonTreeReader(final JsonElement llIlllIlllllIIl) {
        super(JsonTreeReader.UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        this.push(llIlllIlllllIIl);
    }
    
    @Override
    public long nextLong() throws IOException {
        final JsonToken llIlllIlIIllIIl = this.peek();
        if (llIlllIlIIllIIl != JsonToken.NUMBER && llIlllIlIIllIIl != JsonToken.STRING) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(llIlllIlIIllIIl).append(this.locationString())));
        }
        final long llIlllIlIIllIII = ((JsonPrimitive)this.peekStack()).getAsLong();
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
        return llIlllIlIIllIII;
    }
    
    @Override
    public void beginObject() throws IOException {
        this.expect(JsonToken.BEGIN_OBJECT);
        final JsonObject llIlllIlllIllII = (JsonObject)this.peekStack();
        this.push(llIlllIlllIllII.entrySet().iterator());
    }
    
    @Override
    public String nextName() throws IOException {
        this.expect(JsonToken.NAME);
        final Iterator<?> llIlllIlIllllll = (Iterator<?>)this.peekStack();
        final Map.Entry<?, ?> llIlllIlIlllllI = (Map.Entry<?, ?>)llIlllIlIllllll.next();
        final String llIlllIlIllllIl = (String)llIlllIlIlllllI.getKey();
        this.pathNames[this.stackSize - 1] = llIlllIlIllllIl;
        this.push(llIlllIlIlllllI.getValue());
        return llIlllIlIllllIl;
    }
    
    private void expect(final JsonToken llIlllIllIIIlIl) throws IOException {
        if (this.peek() != llIlllIllIIIlIl) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected ").append(llIlllIllIIIlIl).append(" but was ").append(this.peek()).append(this.locationString())));
        }
    }
    
    @Override
    public double nextDouble() throws IOException {
        final JsonToken llIlllIlIlIIIlI = this.peek();
        if (llIlllIlIlIIIlI != JsonToken.NUMBER && llIlllIlIlIIIlI != JsonToken.STRING) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(llIlllIlIlIIIlI).append(this.locationString())));
        }
        final double llIlllIlIlIIIIl = ((JsonPrimitive)this.peekStack()).getAsDouble();
        if (!this.isLenient() && (Double.isNaN(llIlllIlIlIIIIl) || Double.isInfinite(llIlllIlIlIIIIl))) {
            throw new NumberFormatException(String.valueOf(new StringBuilder().append("JSON forbids NaN and infinities: ").append(llIlllIlIlIIIIl)));
        }
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
        return llIlllIlIlIIIIl;
    }
    
    static {
        UNREADABLE_READER = new Reader() {
            @Override
            public int read(final char[] llllllllllllllIlIIllIIIlIIlIllII, final int llllllllllllllIlIIllIIIlIIlIlIlI, final int llllllllllllllIlIIllIIIlIIlIlIII) throws IOException {
                throw new AssertionError();
            }
            
            @Override
            public void close() throws IOException {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new Object();
    }
    
    @Override
    public void skipValue() throws IOException {
        if (this.peek() == JsonToken.NAME) {
            this.nextName();
            this.pathNames[this.stackSize - 2] = "null";
        }
        else {
            this.popStack();
            if (this.stackSize > 0) {
                this.pathNames[this.stackSize - 1] = "null";
            }
        }
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    private String locationString() {
        return String.valueOf(new StringBuilder().append(" at path ").append(this.getPath()));
    }
    
    @Override
    public void beginArray() throws IOException {
        this.expect(JsonToken.BEGIN_ARRAY);
        final JsonArray llIlllIllllIlIl = (JsonArray)this.peekStack();
        this.push(llIlllIllllIlIl.iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }
    
    @Override
    public String nextString() throws IOException {
        final JsonToken llIlllIlIllIlII = this.peek();
        if (llIlllIlIllIlII != JsonToken.STRING && llIlllIlIllIlII != JsonToken.NUMBER) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected ").append(JsonToken.STRING).append(" but was ").append(llIlllIlIllIlII).append(this.locationString())));
        }
        final String llIlllIlIllIIll = ((JsonPrimitive)this.popStack()).getAsString();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
        return llIlllIlIllIIll;
    }
    
    @Override
    public void nextNull() throws IOException {
        this.expect(JsonToken.NULL);
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    @Override
    public String getPath() {
        final StringBuilder llIlllIIllIlIll = new StringBuilder().append('$');
        for (int llIlllIIllIllIl = 0; llIlllIIllIllIl < this.stackSize; ++llIlllIIllIllIl) {
            if (this.stack[llIlllIIllIllIl] instanceof JsonArray) {
                if (this.stack[++llIlllIIllIllIl] instanceof Iterator) {
                    llIlllIIllIlIll.append('[').append(this.pathIndices[llIlllIIllIllIl]).append(']');
                }
            }
            else if (this.stack[llIlllIIllIllIl] instanceof JsonObject && this.stack[++llIlllIIllIllIl] instanceof Iterator) {
                llIlllIIllIlIll.append('.');
                if (this.pathNames[llIlllIIllIllIl] != null) {
                    llIlllIIllIlIll.append(this.pathNames[llIlllIIllIllIl]);
                }
            }
        }
        return String.valueOf(llIlllIIllIlIll);
    }
    
    @Override
    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        final Object llIlllIllIllIII = this.peekStack();
        if (llIlllIllIllIII instanceof Iterator) {
            final boolean llIlllIllIlllII = this.stack[this.stackSize - 2] instanceof JsonObject;
            final Iterator<?> llIlllIllIllIll = (Iterator<?>)llIlllIllIllIII;
            if (!llIlllIllIllIll.hasNext()) {
                return llIlllIllIlllII ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (llIlllIllIlllII) {
                return JsonToken.NAME;
            }
            this.push(llIlllIllIllIll.next());
            return this.peek();
        }
        else {
            if (llIlllIllIllIII instanceof JsonObject) {
                return JsonToken.BEGIN_OBJECT;
            }
            if (llIlllIllIllIII instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (llIlllIllIllIII instanceof JsonPrimitive) {
                final JsonPrimitive llIlllIllIllIlI = (JsonPrimitive)llIlllIllIllIII;
                if (llIlllIllIllIlI.isString()) {
                    return JsonToken.STRING;
                }
                if (llIlllIllIllIlI.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (llIlllIllIllIlI.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            }
            else {
                if (llIlllIllIllIII instanceof JsonNull) {
                    return JsonToken.NULL;
                }
                if (llIlllIllIllIII == JsonTreeReader.SENTINEL_CLOSED) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }
    
    @Override
    public int nextInt() throws IOException {
        final JsonToken llIlllIlIIlIIII = this.peek();
        if (llIlllIlIIlIIII != JsonToken.NUMBER && llIlllIlIIlIIII != JsonToken.STRING) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(llIlllIlIIlIIII).append(this.locationString())));
        }
        final int llIlllIlIIIllll = ((JsonPrimitive)this.peekStack()).getAsInt();
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
        return llIlllIlIIIllll;
    }
    
    private void push(final Object llIlllIIlllIlII) {
        if (this.stackSize == this.stack.length) {
            final int llIlllIIlllIllI = this.stackSize * 2;
            this.stack = Arrays.copyOf(this.stack, llIlllIIlllIllI);
            this.pathIndices = Arrays.copyOf(this.pathIndices, llIlllIIlllIllI);
            this.pathNames = Arrays.copyOf(this.pathNames, llIlllIIlllIllI);
        }
        this.stack[this.stackSize++] = llIlllIIlllIlII;
    }
    
    @Override
    public boolean hasNext() throws IOException {
        final JsonToken llIlllIlllIIIll = this.peek();
        return llIlllIlllIIIll != JsonToken.END_OBJECT && llIlllIlllIIIll != JsonToken.END_ARRAY;
    }
    
    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public void endArray() throws IOException {
        this.expect(JsonToken.END_ARRAY);
        this.popStack();
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    @Override
    public boolean nextBoolean() throws IOException {
        this.expect(JsonToken.BOOLEAN);
        final boolean llIlllIlIlIllII = ((JsonPrimitive)this.popStack()).getAsBoolean();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
        return llIlllIlIlIllII;
    }
    
    public void promoteNameToValue() throws IOException {
        this.expect(JsonToken.NAME);
        final Iterator<?> llIlllIIllllllI = (Iterator<?>)this.peekStack();
        final Map.Entry<?, ?> llIlllIIlllllIl = (Map.Entry<?, ?>)llIlllIIllllllI.next();
        this.push(llIlllIIlllllIl.getValue());
        this.push(new JsonPrimitive((String)llIlllIIlllllIl.getKey()));
    }
    
    @Override
    public void endObject() throws IOException {
        this.expect(JsonToken.END_OBJECT);
        this.popStack();
        this.popStack();
        if (this.stackSize > 0) {
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
        }
    }
    
    @Override
    public void close() throws IOException {
        this.stack = new Object[] { JsonTreeReader.SENTINEL_CLOSED };
        this.stackSize = 1;
    }
    
    private Object popStack() {
        final Object[] stack = this.stack;
        final int stackSize = this.stackSize - 1;
        this.stackSize = stackSize;
        final Object llIlllIllIIllIl = stack[stackSize];
        this.stack[this.stackSize] = null;
        return llIlllIllIIllIl;
    }
}
