package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.lang.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory
{
    private final /* synthetic */ ConstructorConstructor constructorConstructor;
    
    public CollectionTypeAdapterFactory(final ConstructorConstructor llllllllllllllIlIIllIllIllIlIIII) {
        this.constructorConstructor = llllllllllllllIlIIllIllIllIlIIII;
    }
    
    @Override
    public <T> TypeAdapter<T> create(final Gson llllllllllllllIlIIllIllIlIllllIl, final TypeToken<T> llllllllllllllIlIIllIllIlIlIllII) {
        final Type llllllllllllllIlIIllIllIlIlllIll = llllllllllllllIlIIllIllIlIlIllII.getType();
        final Class<? super T> llllllllllllllIlIIllIllIlIlllIIl = llllllllllllllIlIIllIllIlIlIllII.getRawType();
        if (!Collection.class.isAssignableFrom(llllllllllllllIlIIllIllIlIlllIIl)) {
            return null;
        }
        final Type llllllllllllllIlIIllIllIlIllIlll = $Gson$Types.getCollectionElementType(llllllllllllllIlIIllIllIlIlllIll, llllllllllllllIlIIllIllIlIlllIIl);
        final TypeAdapter<?> llllllllllllllIlIIllIllIlIllIlIl = llllllllllllllIlIIllIllIlIllllIl.getAdapter(TypeToken.get(llllllllllllllIlIIllIllIlIllIlll));
        final ObjectConstructor<T> llllllllllllllIlIIllIllIlIllIIll = this.constructorConstructor.get(llllllllllllllIlIIllIllIlIlIllII);
        final TypeAdapter<T> llllllllllllllIlIIllIllIlIllIIIl = (TypeAdapter<T>)new Adapter(llllllllllllllIlIIllIllIlIllllIl, llllllllllllllIlIIllIllIlIllIlll, (TypeAdapter<Object>)llllllllllllllIlIIllIllIlIllIlIl, (ObjectConstructor<? extends Collection<Object>>)llllllllllllllIlIIllIllIlIllIIll);
        return llllllllllllllIlIIllIllIlIllIIIl;
    }
    
    private static final class Adapter<E> extends TypeAdapter<Collection<E>>
    {
        private final /* synthetic */ TypeAdapter<E> elementTypeAdapter;
        private final /* synthetic */ ObjectConstructor<? extends Collection<E>> constructor;
        
        public Adapter(final Gson llllllllllllllIlllIIIIlllIIlIllI, final Type llllllllllllllIlllIIIIlllIIlIlIl, final TypeAdapter<E> llllllllllllllIlllIIIIlllIIllIIl, final ObjectConstructor<? extends Collection<E>> llllllllllllllIlllIIIIlllIIllIII) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(llllllllllllllIlllIIIIlllIIlIllI, llllllllllllllIlllIIIIlllIIllIIl, llllllllllllllIlllIIIIlllIIlIlIl);
            this.constructor = llllllllllllllIlllIIIIlllIIllIII;
        }
        
        @Override
        public void write(final JsonWriter llllllllllllllIlllIIIIllIlllllII, final Collection<E> llllllllllllllIlllIIIIllIllllllI) throws IOException {
            if (llllllllllllllIlllIIIIllIllllllI == null) {
                llllllllllllllIlllIIIIllIlllllII.nullValue();
                return;
            }
            llllllllllllllIlllIIIIllIlllllII.beginArray();
            for (final E llllllllllllllIlllIIIIlllIIIIIIl : llllllllllllllIlllIIIIllIllllllI) {
                this.elementTypeAdapter.write(llllllllllllllIlllIIIIllIlllllII, llllllllllllllIlllIIIIlllIIIIIIl);
            }
            llllllllllllllIlllIIIIllIlllllII.endArray();
        }
        
        @Override
        public Collection<E> read(final JsonReader llllllllllllllIlllIIIIlllIIIlIIl) throws IOException {
            if (llllllllllllllIlllIIIIlllIIIlIIl.peek() == JsonToken.NULL) {
                llllllllllllllIlllIIIIlllIIIlIIl.nextNull();
                return null;
            }
            final Collection<E> llllllllllllllIlllIIIIlllIIIlIll = (Collection<E>)this.constructor.construct();
            llllllllllllllIlllIIIIlllIIIlIIl.beginArray();
            while (llllllllllllllIlllIIIIlllIIIlIIl.hasNext()) {
                final E llllllllllllllIlllIIIIlllIIIlllI = this.elementTypeAdapter.read(llllllllllllllIlllIIIIlllIIIlIIl);
                llllllllllllllIlllIIIIlllIIIlIll.add(llllllllllllllIlllIIIIlllIIIlllI);
            }
            llllllllllllllIlllIIIIlllIIIlIIl.endArray();
            return llllllllllllllIlllIIIIlllIIIlIll;
        }
    }
}
