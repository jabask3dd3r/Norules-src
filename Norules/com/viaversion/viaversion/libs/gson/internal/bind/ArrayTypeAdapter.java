package com.viaversion.viaversion.libs.gson.internal.bind;

import java.io.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.*;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object>
{
    private final /* synthetic */ TypeAdapter<E> componentTypeAdapter;
    private final /* synthetic */ Class<E> componentType;
    
    @Override
    public void write(final JsonWriter lllIIIIIl, final Object lllIIIIII) throws IOException {
        if (lllIIIIII == null) {
            lllIIIIIl.nullValue();
            return;
        }
        lllIIIIIl.beginArray();
        for (int lllIIIlll = 0, lllIIIllI = Array.getLength(lllIIIIII); lllIIIlll < lllIIIllI; ++lllIIIlll) {
            final E lllIIlIII = (E)Array.get(lllIIIIII, lllIIIlll);
            this.componentTypeAdapter.write(lllIIIIIl, lllIIlIII);
        }
        lllIIIIIl.endArray();
    }
    
    public ArrayTypeAdapter(final Gson llllIIlII, final TypeAdapter<E> llllIIIll, final Class<E> llllIIIlI) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(llllIIlII, llllIIIll, llllIIIlI);
        this.componentType = llllIIIlI;
    }
    
    @Override
    public Object read(final JsonReader lllIlIIll) throws IOException {
        if (lllIlIIll.peek() == JsonToken.NULL) {
            lllIlIIll.nextNull();
            return null;
        }
        final List<E> lllIlIlll = new ArrayList<E>();
        lllIlIIll.beginArray();
        while (lllIlIIll.hasNext()) {
            final E lllIllIll = this.componentTypeAdapter.read(lllIlIIll);
            lllIlIlll.add(lllIllIll);
        }
        lllIlIIll.endArray();
        final int lllIlIllI = lllIlIlll.size();
        final Object lllIlIlIl = Array.newInstance(this.componentType, lllIlIllI);
        for (int lllIllIlI = 0; lllIllIlI < lllIlIllI; ++lllIllIlI) {
            Array.set(lllIlIlIl, lllIllIlI, lllIlIlll.get(lllIllIlI));
        }
        return lllIlIlIl;
    }
    
    static {
        FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllIIlIlllllIllIIIIIlI, final TypeToken<T> lllllllllllllIIlIlllllIlIlllllII) {
                final Type lllllllllllllIIlIlllllIllIIIIIII = lllllllllllllIIlIlllllIlIlllllII.getType();
                if (!(lllllllllllllIIlIlllllIllIIIIIII instanceof GenericArrayType) && (!(lllllllllllllIIlIlllllIllIIIIIII instanceof Class) || !((Class)lllllllllllllIIlIlllllIllIIIIIII).isArray())) {
                    return null;
                }
                final Type lllllllllllllIIlIlllllIlIlllllll = $Gson$Types.getArrayComponentType(lllllllllllllIIlIlllllIllIIIIIII);
                final TypeAdapter<?> lllllllllllllIIlIlllllIlIllllllI = lllllllllllllIIlIlllllIllIIIIIlI.getAdapter(TypeToken.get(lllllllllllllIIlIlllllIlIlllllll));
                return (TypeAdapter<T>)new ArrayTypeAdapter(lllllllllllllIIlIlllllIllIIIIIlI, (TypeAdapter<Object>)lllllllllllllIIlIlllllIlIllllllI, (Class<Object>)$Gson$Types.getRawType(lllllllllllllIIlIlllllIlIlllllll));
            }
        };
    }
}
