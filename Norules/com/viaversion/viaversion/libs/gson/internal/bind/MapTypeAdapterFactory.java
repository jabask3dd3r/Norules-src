package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.reflect.*;
import java.lang.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.util.*;

public final class MapTypeAdapterFactory implements TypeAdapterFactory
{
    private final /* synthetic */ ConstructorConstructor constructorConstructor;
    final /* synthetic */ boolean complexMapKeySerialization;
    
    public MapTypeAdapterFactory(final ConstructorConstructor lllllllllllllIlIIIIllIlIlllIIIll, final boolean lllllllllllllIlIIIIllIlIllIlllll) {
        this.constructorConstructor = lllllllllllllIlIIIIllIlIlllIIIll;
        this.complexMapKeySerialization = lllllllllllllIlIIIIllIlIllIlllll;
    }
    
    @Override
    public <T> TypeAdapter<T> create(final Gson lllllllllllllIlIIIIllIlIllIIIlll, final TypeToken<T> lllllllllllllIlIIIIllIlIllIIIllI) {
        final Type lllllllllllllIlIIIIllIlIllIlIIII = lllllllllllllIlIIIIllIlIllIIIllI.getType();
        final Class<? super T> lllllllllllllIlIIIIllIlIllIIllll = lllllllllllllIlIIIIllIlIllIIIllI.getRawType();
        if (!Map.class.isAssignableFrom(lllllllllllllIlIIIIllIlIllIIllll)) {
            return null;
        }
        final Class<?> lllllllllllllIlIIIIllIlIllIIlllI = $Gson$Types.getRawType(lllllllllllllIlIIIIllIlIllIlIIII);
        final Type[] lllllllllllllIlIIIIllIlIllIIllIl = $Gson$Types.getMapKeyAndValueTypes(lllllllllllllIlIIIIllIlIllIlIIII, lllllllllllllIlIIIIllIlIllIIlllI);
        final TypeAdapter<?> lllllllllllllIlIIIIllIlIllIIllII = this.getKeyAdapter(lllllllllllllIlIIIIllIlIllIIIlll, lllllllllllllIlIIIIllIlIllIIllIl[0]);
        final TypeAdapter<?> lllllllllllllIlIIIIllIlIllIIlIll = lllllllllllllIlIIIIllIlIllIIIlll.getAdapter(TypeToken.get(lllllllllllllIlIIIIllIlIllIIllIl[1]));
        final ObjectConstructor<T> lllllllllllllIlIIIIllIlIllIIlIlI = this.constructorConstructor.get(lllllllllllllIlIIIIllIlIllIIIllI);
        final TypeAdapter<T> lllllllllllllIlIIIIllIlIllIIlIIl = (TypeAdapter<T>)new Adapter(lllllllllllllIlIIIIllIlIllIIIlll, lllllllllllllIlIIIIllIlIllIIllIl[0], (TypeAdapter<Object>)lllllllllllllIlIIIIllIlIllIIllII, lllllllllllllIlIIIIllIlIllIIllIl[1], (TypeAdapter<Object>)lllllllllllllIlIIIIllIlIllIIlIll, (ObjectConstructor<? extends Map<Object, Object>>)lllllllllllllIlIIIIllIlIllIIlIlI);
        return lllllllllllllIlIIIIllIlIllIIlIIl;
    }
    
    private TypeAdapter<?> getKeyAdapter(final Gson lllllllllllllIlIIIIllIlIlIlllIII, final Type lllllllllllllIlIIIIllIlIlIllIlll) {
        return (lllllllllllllIlIIIIllIlIlIllIlll == Boolean.TYPE || lllllllllllllIlIIIIllIlIlIllIlll == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : lllllllllllllIlIIIIllIlIlIlllIII.getAdapter(TypeToken.get(lllllllllllllIlIIIIllIlIlIllIlll));
    }
    
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>>
    {
        private final /* synthetic */ TypeAdapter<V> valueTypeAdapter;
        private final /* synthetic */ ObjectConstructor<? extends Map<K, V>> constructor;
        private final /* synthetic */ TypeAdapter<K> keyTypeAdapter;
        
        public Adapter(final Gson lllllllllllllIllIIlIlllIlIIIIlll, final Type lllllllllllllIllIIlIlllIlIIIIllI, final TypeAdapter<K> lllllllllllllIllIIlIlllIlIIIIlIl, final Type lllllllllllllIllIIlIlllIlIIIllII, final TypeAdapter<V> lllllllllllllIllIIlIlllIlIIIlIll, final ObjectConstructor<? extends Map<K, V>> lllllllllllllIllIIlIlllIlIIIIIlI) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(lllllllllllllIllIIlIlllIlIIIIlll, lllllllllllllIllIIlIlllIlIIIIlIl, lllllllllllllIllIIlIlllIlIIIIllI);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(lllllllllllllIllIIlIlllIlIIIIlll, lllllllllllllIllIIlIlllIlIIIlIll, lllllllllllllIllIIlIlllIlIIIllII);
            this.constructor = lllllllllllllIllIIlIlllIlIIIIIlI;
        }
        
        private String keyToString(final JsonElement lllllllllllllIllIIlIlllIIlIIIlII) {
            if (lllllllllllllIllIIlIlllIIlIIIlII.isJsonPrimitive()) {
                final JsonPrimitive lllllllllllllIllIIlIlllIIlIIIlll = lllllllllllllIllIIlIlllIIlIIIlII.getAsJsonPrimitive();
                if (lllllllllllllIllIIlIlllIIlIIIlll.isNumber()) {
                    return String.valueOf(lllllllllllllIllIIlIlllIIlIIIlll.getAsNumber());
                }
                if (lllllllllllllIllIIlIlllIIlIIIlll.isBoolean()) {
                    return Boolean.toString(lllllllllllllIllIIlIlllIIlIIIlll.getAsBoolean());
                }
                if (lllllllllllllIllIIlIlllIIlIIIlll.isString()) {
                    return lllllllllllllIllIIlIlllIIlIIIlll.getAsString();
                }
                throw new AssertionError();
            }
            else {
                if (lllllllllllllIllIIlIlllIIlIIIlII.isJsonNull()) {
                    return "null";
                }
                throw new AssertionError();
            }
        }
        
        @Override
        public Map<K, V> read(final JsonReader lllllllllllllIllIIlIlllIIlllIIll) throws IOException {
            final JsonToken lllllllllllllIllIIlIlllIIlllIIlI = lllllllllllllIllIIlIlllIIlllIIll.peek();
            if (lllllllllllllIllIIlIlllIIlllIIlI == JsonToken.NULL) {
                lllllllllllllIllIIlIlllIIlllIIll.nextNull();
                return null;
            }
            final Map<K, V> lllllllllllllIllIIlIlllIIlllIIIl = (Map<K, V>)this.constructor.construct();
            if (lllllllllllllIllIIlIlllIIlllIIlI == JsonToken.BEGIN_ARRAY) {
                lllllllllllllIllIIlIlllIIlllIIll.beginArray();
                while (lllllllllllllIllIIlIlllIIlllIIll.hasNext()) {
                    lllllllllllllIllIIlIlllIIlllIIll.beginArray();
                    final K lllllllllllllIllIIlIlllIIllllIlI = this.keyTypeAdapter.read(lllllllllllllIllIIlIlllIIlllIIll);
                    final V lllllllllllllIllIIlIlllIIllllIIl = this.valueTypeAdapter.read(lllllllllllllIllIIlIlllIIlllIIll);
                    final V lllllllllllllIllIIlIlllIIllllIII = lllllllllllllIllIIlIlllIIlllIIIl.put(lllllllllllllIllIIlIlllIIllllIlI, lllllllllllllIllIIlIlllIIllllIIl);
                    if (lllllllllllllIllIIlIlllIIllllIII != null) {
                        throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("duplicate key: ").append(lllllllllllllIllIIlIlllIIllllIlI)));
                    }
                    lllllllllllllIllIIlIlllIIlllIIll.endArray();
                }
                lllllllllllllIllIIlIlllIIlllIIll.endArray();
            }
            else {
                lllllllllllllIllIIlIlllIIlllIIll.beginObject();
                while (lllllllllllllIllIIlIlllIIlllIIll.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(lllllllllllllIllIIlIlllIIlllIIll);
                    final K lllllllllllllIllIIlIlllIIlllIlll = this.keyTypeAdapter.read(lllllllllllllIllIIlIlllIIlllIIll);
                    final V lllllllllllllIllIIlIlllIIlllIllI = this.valueTypeAdapter.read(lllllllllllllIllIIlIlllIIlllIIll);
                    final V lllllllllllllIllIIlIlllIIlllIlIl = lllllllllllllIllIIlIlllIIlllIIIl.put(lllllllllllllIllIIlIlllIIlllIlll, lllllllllllllIllIIlIlllIIlllIllI);
                    if (lllllllllllllIllIIlIlllIIlllIlIl != null) {
                        throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("duplicate key: ").append(lllllllllllllIllIIlIlllIIlllIlll)));
                    }
                }
                lllllllllllllIllIIlIlllIIlllIIll.endObject();
            }
            return lllllllllllllIllIIlIlllIIlllIIIl;
        }
        
        @Override
        public void write(final JsonWriter lllllllllllllIllIIlIlllIIlIlIlll, final Map<K, V> lllllllllllllIllIIlIlllIIlIlIllI) throws IOException {
            if (lllllllllllllIllIIlIlllIIlIlIllI == null) {
                lllllllllllllIllIIlIlllIIlIlIlll.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                lllllllllllllIllIIlIlllIIlIlIlll.beginObject();
                for (final Map.Entry<K, V> lllllllllllllIllIIlIlllIIllIIIII : lllllllllllllIllIIlIlllIIlIlIllI.entrySet()) {
                    lllllllllllllIllIIlIlllIIlIlIlll.name(String.valueOf(lllllllllllllIllIIlIlllIIllIIIII.getKey()));
                    this.valueTypeAdapter.write(lllllllllllllIllIIlIlllIIlIlIlll, lllllllllllllIllIIlIlllIIllIIIII.getValue());
                }
                lllllllllllllIllIIlIlllIIlIlIlll.endObject();
                return;
            }
            boolean lllllllllllllIllIIlIlllIIlIlIlIl = false;
            final List<JsonElement> lllllllllllllIllIIlIlllIIlIlIlII = new ArrayList<JsonElement>(lllllllllllllIllIIlIlllIIlIlIllI.size());
            final List<V> lllllllllllllIllIIlIlllIIlIlIIll = new ArrayList<V>(lllllllllllllIllIIlIlllIIlIlIllI.size());
            for (final Map.Entry<K, V> lllllllllllllIllIIlIlllIIlIllllI : lllllllllllllIllIIlIlllIIlIlIllI.entrySet()) {
                final JsonElement lllllllllllllIllIIlIlllIIlIlllll = this.keyTypeAdapter.toJsonTree(lllllllllllllIllIIlIlllIIlIllllI.getKey());
                lllllllllllllIllIIlIlllIIlIlIlII.add(lllllllllllllIllIIlIlllIIlIlllll);
                lllllllllllllIllIIlIlllIIlIlIIll.add(lllllllllllllIllIIlIlllIIlIllllI.getValue());
                lllllllllllllIllIIlIlllIIlIlIlIl |= (lllllllllllllIllIIlIlllIIlIlllll.isJsonArray() || lllllllllllllIllIIlIlllIIlIlllll.isJsonObject());
            }
            if (lllllllllllllIllIIlIlllIIlIlIlIl) {
                lllllllllllllIllIIlIlllIIlIlIlll.beginArray();
                for (int lllllllllllllIllIIlIlllIIlIlllIl = 0, lllllllllllllIllIIlIlllIIlIlllII = lllllllllllllIllIIlIlllIIlIlIlII.size(); lllllllllllllIllIIlIlllIIlIlllIl < lllllllllllllIllIIlIlllIIlIlllII; ++lllllllllllllIllIIlIlllIIlIlllIl) {
                    lllllllllllllIllIIlIlllIIlIlIlll.beginArray();
                    Streams.write(lllllllllllllIllIIlIlllIIlIlIlII.get(lllllllllllllIllIIlIlllIIlIlllIl), lllllllllllllIllIIlIlllIIlIlIlll);
                    this.valueTypeAdapter.write(lllllllllllllIllIIlIlllIIlIlIlll, lllllllllllllIllIIlIlllIIlIlIIll.get(lllllllllllllIllIIlIlllIIlIlllIl));
                    lllllllllllllIllIIlIlllIIlIlIlll.endArray();
                }
                lllllllllllllIllIIlIlllIIlIlIlll.endArray();
            }
            else {
                lllllllllllllIllIIlIlllIIlIlIlll.beginObject();
                for (int lllllllllllllIllIIlIlllIIlIllIlI = 0, lllllllllllllIllIIlIlllIIlIllIIl = lllllllllllllIllIIlIlllIIlIlIlII.size(); lllllllllllllIllIIlIlllIIlIllIlI < lllllllllllllIllIIlIlllIIlIllIIl; ++lllllllllllllIllIIlIlllIIlIllIlI) {
                    final JsonElement lllllllllllllIllIIlIlllIIlIllIll = lllllllllllllIllIIlIlllIIlIlIlII.get(lllllllllllllIllIIlIlllIIlIllIlI);
                    lllllllllllllIllIIlIlllIIlIlIlll.name(this.keyToString(lllllllllllllIllIIlIlllIIlIllIll));
                    this.valueTypeAdapter.write(lllllllllllllIllIIlIlllIIlIlIlll, lllllllllllllIllIIlIlllIIlIlIIll.get(lllllllllllllIllIIlIlllIIlIllIlI));
                }
                lllllllllllllIllIIlIlllIIlIlIlll.endObject();
            }
        }
    }
}
