package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.*;

public final class TreeTypeAdapter<T> extends TypeAdapter<T>
{
    private final /* synthetic */ JsonSerializer<T> serializer;
    private /* synthetic */ TypeAdapter<T> delegate;
    private final /* synthetic */ TypeToken<T> typeToken;
    final /* synthetic */ Gson gson;
    private final /* synthetic */ GsonContextImpl context;
    private final /* synthetic */ TypeAdapterFactory skipPast;
    private final /* synthetic */ JsonDeserializer<T> deserializer;
    
    public TreeTypeAdapter(final JsonSerializer<T> lllllllllllllIIllIlllIIIlllIlIIl, final JsonDeserializer<T> lllllllllllllIIllIlllIIIlllIlIII, final Gson lllllllllllllIIllIlllIIIlllIIlll, final TypeToken<T> lllllllllllllIIllIlllIIIlllIIllI, final TypeAdapterFactory lllllllllllllIIllIlllIIIllIlllll) {
        this.context = new GsonContextImpl();
        this.serializer = lllllllllllllIIllIlllIIIlllIlIIl;
        this.deserializer = lllllllllllllIIllIlllIIIlllIlIII;
        this.gson = lllllllllllllIIllIlllIIIlllIIlll;
        this.typeToken = lllllllllllllIIllIlllIIIlllIIllI;
        this.skipPast = lllllllllllllIIllIlllIIIllIlllll;
    }
    
    @Override
    public void write(final JsonWriter lllllllllllllIIllIlllIIIllIIllII, final T lllllllllllllIIllIlllIIIllIIllll) throws IOException {
        if (this.serializer == null) {
            this.delegate().write(lllllllllllllIIllIlllIIIllIIllII, lllllllllllllIIllIlllIIIllIIllll);
            return;
        }
        if (lllllllllllllIIllIlllIIIllIIllll == null) {
            lllllllllllllIIllIlllIIIllIIllII.nullValue();
            return;
        }
        final JsonElement lllllllllllllIIllIlllIIIllIIlllI = this.serializer.serialize(lllllllllllllIIllIlllIIIllIIllll, this.typeToken.getType(), this.context);
        Streams.write(lllllllllllllIIllIlllIIIllIIlllI, lllllllllllllIIllIlllIIIllIIllII);
    }
    
    private TypeAdapter<T> delegate() {
        final TypeAdapter<T> lllllllllllllIIllIlllIIIllIIIllI = this.delegate;
        return (lllllllllllllIIllIlllIIIllIIIllI != null) ? lllllllllllllIIllIlllIIIllIIIllI : (this.delegate = this.gson.getDelegateAdapter(this.skipPast, this.typeToken));
    }
    
    public static TypeAdapterFactory newTypeHierarchyFactory(final Class<?> lllllllllllllIIllIlllIIIlIllIIlI, final Object lllllllllllllIIllIlllIIIlIlIllll) {
        return new SingleTypeFactory(lllllllllllllIIllIlllIIIlIlIllll, null, false, lllllllllllllIIllIlllIIIlIllIIlI);
    }
    
    @Override
    public T read(final JsonReader lllllllllllllIIllIlllIIIllIllIlI) throws IOException {
        if (this.deserializer == null) {
            return this.delegate().read(lllllllllllllIIllIlllIIIllIllIlI);
        }
        final JsonElement lllllllllllllIIllIlllIIIllIllIIl = Streams.parse(lllllllllllllIIllIlllIIIllIllIlI);
        if (lllllllllllllIIllIlllIIIllIllIIl.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(lllllllllllllIIllIlllIIIllIllIIl, this.typeToken.getType(), this.context);
    }
    
    public static TypeAdapterFactory newFactory(final TypeToken<?> lllllllllllllIIllIlllIIIllIIIIIl, final Object lllllllllllllIIllIlllIIIlIlllllI) {
        return new SingleTypeFactory(lllllllllllllIIllIlllIIIlIlllllI, lllllllllllllIIllIlllIIIllIIIIIl, false, null);
    }
    
    public static TypeAdapterFactory newFactoryWithMatchRawType(final TypeToken<?> lllllllllllllIIllIlllIIIlIllIlll, final Object lllllllllllllIIllIlllIIIlIlllIIl) {
        final boolean lllllllllllllIIllIlllIIIlIlllIII = lllllllllllllIIllIlllIIIlIllIlll.getType() == lllllllllllllIIllIlllIIIlIllIlll.getRawType();
        return new SingleTypeFactory(lllllllllllllIIllIlllIIIlIlllIIl, lllllllllllllIIllIlllIIIlIllIlll, lllllllllllllIIllIlllIIIlIlllIII, null);
    }
    
    private static final class SingleTypeFactory implements TypeAdapterFactory
    {
        private final /* synthetic */ Class<?> hierarchyType;
        private final /* synthetic */ JsonDeserializer<?> deserializer;
        private final /* synthetic */ JsonSerializer<?> serializer;
        private final /* synthetic */ TypeToken<?> exactType;
        private final /* synthetic */ boolean matchRawType;
        
        @Override
        public <T> TypeAdapter<T> create(final Gson lllllllllllllIlllIIIIIIIIlllIIll, final TypeToken<T> lllllllllllllIlllIIIIIIIIlllIIlI) {
            final boolean lllllllllllllIlllIIIIIIIIlllIlIl = (this.exactType != null) ? (this.exactType.equals(lllllllllllllIlllIIIIIIIIlllIIlI) || (this.matchRawType && this.exactType.getType() == lllllllllllllIlllIIIIIIIIlllIIlI.getRawType())) : this.hierarchyType.isAssignableFrom(lllllllllllllIlllIIIIIIIIlllIIlI.getRawType());
            return lllllllllllllIlllIIIIIIIIlllIlIl ? new TreeTypeAdapter<T>((JsonSerializer<T>)this.serializer, (JsonDeserializer<T>)this.deserializer, lllllllllllllIlllIIIIIIIIlllIIll, lllllllllllllIlllIIIIIIIIlllIIlI, this) : null;
        }
        
        SingleTypeFactory(final Object lllllllllllllIlllIIIIIIIlIIIIlIl, final TypeToken<?> lllllllllllllIlllIIIIIIIlIIIIlII, final boolean lllllllllllllIlllIIIIIIIIllllllI, final Class<?> lllllllllllllIlllIIIIIIIIlllllIl) {
            this.serializer = (JsonSerializer<?>)((lllllllllllllIlllIIIIIIIlIIIIlIl instanceof JsonSerializer) ? ((JsonSerializer)lllllllllllllIlllIIIIIIIlIIIIlIl) : null);
            this.deserializer = (JsonDeserializer<?>)((lllllllllllllIlllIIIIIIIlIIIIlIl instanceof JsonDeserializer) ? ((JsonDeserializer)lllllllllllllIlllIIIIIIIlIIIIlIl) : null);
            $Gson$Preconditions.checkArgument(this.serializer != null || this.deserializer != null);
            this.exactType = lllllllllllllIlllIIIIIIIlIIIIlII;
            this.matchRawType = lllllllllllllIlllIIIIIIIIllllllI;
            this.hierarchyType = lllllllllllllIlllIIIIIIIIlllllIl;
        }
    }
    
    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext
    {
        @Override
        public JsonElement serialize(final Object lllllllllllllIlIllllIlllIlllIllI) {
            return TreeTypeAdapter.this.gson.toJsonTree(lllllllllllllIlIllllIlllIlllIllI);
        }
        
        @Override
        public <R> R deserialize(final JsonElement lllllllllllllIlIllllIlllIllIIlIl, final Type lllllllllllllIlIllllIlllIllIIlll) throws JsonParseException {
            return TreeTypeAdapter.this.gson.fromJson(lllllllllllllIlIllllIlllIllIIlIl, lllllllllllllIlIllllIlllIllIIlll);
        }
        
        @Override
        public JsonElement serialize(final Object lllllllllllllIlIllllIlllIlllIIIl, final Type lllllllllllllIlIllllIlllIllIllIl) {
            return TreeTypeAdapter.this.gson.toJsonTree(lllllllllllllIlIllllIlllIlllIIIl, lllllllllllllIlIllllIlllIllIllIl);
        }
    }
}
