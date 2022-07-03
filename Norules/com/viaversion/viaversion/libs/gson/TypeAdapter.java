package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.internal.bind.*;

public abstract class TypeAdapter<T>
{
    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() {
            @Override
            public T read(final JsonReader llllllllllllllllIIIIIlIlllllIIlI) throws IOException {
                if (llllllllllllllllIIIIIlIlllllIIlI.peek() == JsonToken.NULL) {
                    llllllllllllllllIIIIIlIlllllIIlI.nextNull();
                    return null;
                }
                return TypeAdapter.this.read(llllllllllllllllIIIIIlIlllllIIlI);
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllllIIIIIlIllllllIIl, final T llllllllllllllllIIIIIlIllllllIII) throws IOException {
                if (llllllllllllllllIIIIIlIllllllIII == null) {
                    llllllllllllllllIIIIIlIllllllIIl.nullValue();
                }
                else {
                    TypeAdapter.this.write(llllllllllllllllIIIIIlIllllllIIl, llllllllllllllllIIIIIlIllllllIII);
                }
            }
        };
    }
    
    public abstract void write(final JsonWriter p0, final T p1) throws IOException;
    
    public final void toJson(final Writer lllllllllllllIIllIIlIlIllllIIIll, final T lllllllllllllIIllIIlIlIllllIIIlI) throws IOException {
        final JsonWriter lllllllllllllIIllIIlIlIllllIIlIl = new JsonWriter(lllllllllllllIIllIIlIlIllllIIIll);
        this.write(lllllllllllllIIllIIlIlIllllIIlIl, lllllllllllllIIllIIlIlIllllIIIlI);
    }
    
    public final JsonElement toJsonTree(final T lllllllllllllIIllIIlIlIlllIIlIIl) {
        try {
            final JsonTreeWriter lllllllllllllIIllIIlIlIlllIIlllI = new JsonTreeWriter();
            this.write(lllllllllllllIIllIIlIlIlllIIlllI, lllllllllllllIIllIIlIlIlllIIlIIl);
            return lllllllllllllIIllIIlIlIlllIIlllI.get();
        }
        catch (IOException lllllllllllllIIllIIlIlIlllIIllIl) {
            throw new JsonIOException(lllllllllllllIIllIIlIlIlllIIllIl);
        }
    }
    
    public abstract T read(final JsonReader p0) throws IOException;
    
    public final String toJson(final T lllllllllllllIIllIIlIlIlllIlIlll) {
        final StringWriter lllllllllllllIIllIIlIlIlllIlIllI = new StringWriter();
        try {
            this.toJson(lllllllllllllIIllIIlIlIlllIlIllI, lllllllllllllIIllIIlIlIlllIlIlll);
        }
        catch (IOException lllllllllllllIIllIIlIlIlllIllIIl) {
            throw new AssertionError((Object)lllllllllllllIIllIIlIlIlllIllIIl);
        }
        return lllllllllllllIIllIIlIlIlllIlIllI.toString();
    }
    
    public final T fromJson(final String lllllllllllllIIllIIlIlIllIlllIIl) throws IOException {
        return this.fromJson(new StringReader(lllllllllllllIIllIIlIlIllIlllIIl));
    }
    
    public final T fromJsonTree(final JsonElement lllllllllllllIIllIIlIlIllIllIIII) {
        try {
            final JsonReader lllllllllllllIIllIIlIlIllIllIlIl = new JsonTreeReader(lllllllllllllIIllIIlIlIllIllIIII);
            return this.read(lllllllllllllIIllIIlIlIllIllIlIl);
        }
        catch (IOException lllllllllllllIIllIIlIlIllIllIlII) {
            throw new JsonIOException(lllllllllllllIIllIIlIlIllIllIlII);
        }
    }
    
    public final T fromJson(final Reader lllllllllllllIIllIIlIlIlllIIIIII) throws IOException {
        final JsonReader lllllllllllllIIllIIlIlIlllIIIIlI = new JsonReader(lllllllllllllIIllIIlIlIlllIIIIII);
        return this.read(lllllllllllllIIllIIlIlIlllIIIIlI);
    }
}
