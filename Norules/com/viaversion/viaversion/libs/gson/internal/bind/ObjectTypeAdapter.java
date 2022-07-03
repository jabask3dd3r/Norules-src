package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.util.*;

public final class ObjectTypeAdapter extends TypeAdapter<Object>
{
    private final /* synthetic */ Gson gson;
    
    @Override
    public void write(final JsonWriter lllllllllllllIlIIIIIllIllIIIIIll, final Object lllllllllllllIlIIIIIllIllIIIIllI) throws IOException {
        if (lllllllllllllIlIIIIIllIllIIIIllI == null) {
            lllllllllllllIlIIIIIllIllIIIIIll.nullValue();
            return;
        }
        final TypeAdapter<Object> lllllllllllllIlIIIIIllIllIIIIlIl = this.gson.getAdapter(lllllllllllllIlIIIIIllIllIIIIllI.getClass());
        if (lllllllllllllIlIIIIIllIllIIIIlIl instanceof ObjectTypeAdapter) {
            lllllllllllllIlIIIIIllIllIIIIIll.beginObject();
            lllllllllllllIlIIIIIllIllIIIIIll.endObject();
            return;
        }
        lllllllllllllIlIIIIIllIllIIIIlIl.write(lllllllllllllIlIIIIIllIllIIIIIll, lllllllllllllIlIIIIIllIllIIIIllI);
    }
    
    static {
        FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllllIIllIlIIllIlllllI, final TypeToken<T> lllllllllllllllIIllIlIIllIlllIll) {
                if (lllllllllllllllIIllIlIIllIlllIll.getRawType() == Object.class) {
                    return (TypeAdapter<T>)new ObjectTypeAdapter(lllllllllllllllIIllIlIIllIlllllI);
                }
                return null;
            }
        };
    }
    
    ObjectTypeAdapter(final Gson lllllllllllllIlIIIIIllIllIIlllII) {
        this.gson = lllllllllllllIlIIIIIllIllIIlllII;
    }
    
    @Override
    public Object read(final JsonReader lllllllllllllIlIIIIIllIllIIlIIII) throws IOException {
        final JsonToken lllllllllllllIlIIIIIllIllIIlIIlI = lllllllllllllIlIIIIIllIllIIlIIII.peek();
        switch (lllllllllllllIlIIIIIllIllIIlIIlI) {
            case BEGIN_ARRAY: {
                final List<Object> lllllllllllllIlIIIIIllIllIIlIllI = new ArrayList<Object>();
                lllllllllllllIlIIIIIllIllIIlIIII.beginArray();
                while (lllllllllllllIlIIIIIllIllIIlIIII.hasNext()) {
                    lllllllllllllIlIIIIIllIllIIlIllI.add(this.read(lllllllllllllIlIIIIIllIllIIlIIII));
                }
                lllllllllllllIlIIIIIllIllIIlIIII.endArray();
                return lllllllllllllIlIIIIIllIllIIlIllI;
            }
            case BEGIN_OBJECT: {
                final Map<String, Object> lllllllllllllIlIIIIIllIllIIlIlIl = new LinkedTreeMap<String, Object>();
                lllllllllllllIlIIIIIllIllIIlIIII.beginObject();
                while (lllllllllllllIlIIIIIllIllIIlIIII.hasNext()) {
                    lllllllllllllIlIIIIIllIllIIlIlIl.put(lllllllllllllIlIIIIIllIllIIlIIII.nextName(), this.read(lllllllllllllIlIIIIIllIllIIlIIII));
                }
                lllllllllllllIlIIIIIllIllIIlIIII.endObject();
                return lllllllllllllIlIIIIIllIllIIlIlIl;
            }
            case STRING: {
                return lllllllllllllIlIIIIIllIllIIlIIII.nextString();
            }
            case NUMBER: {
                return lllllllllllllIlIIIIIllIllIIlIIII.nextDouble();
            }
            case BOOLEAN: {
                return lllllllllllllIlIIIIIllIllIIlIIII.nextBoolean();
            }
            case NULL: {
                lllllllllllllIlIIIIIllIllIIlIIII.nextNull();
                return null;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}
