package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.internal.reflect.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.annotations.*;
import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory
{
    private final /* synthetic */ Excluder excluder;
    private final /* synthetic */ ReflectionAccessor accessor;
    private final /* synthetic */ FieldNamingStrategy fieldNamingPolicy;
    private final /* synthetic */ ConstructorConstructor constructorConstructor;
    private final /* synthetic */ JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    
    private List<String> getFieldNames(final Field llllllllllllllllIIlIlllIIIlIIllI) {
        final SerializedName llllllllllllllllIIlIlllIIIlIIlIl = llllllllllllllllIIlIlllIIIlIIllI.getAnnotation(SerializedName.class);
        if (llllllllllllllllIIlIlllIIIlIIlIl == null) {
            final String llllllllllllllllIIlIlllIIIlIlIIl = this.fieldNamingPolicy.translateName(llllllllllllllllIIlIlllIIIlIIllI);
            return Collections.singletonList(llllllllllllllllIIlIlllIIIlIlIIl);
        }
        final String llllllllllllllllIIlIlllIIIlIIlII = llllllllllllllllIIlIlllIIIlIIlIl.value();
        final String[] llllllllllllllllIIlIlllIIIlIIIll = llllllllllllllllIIlIlllIIIlIIlIl.alternate();
        if (llllllllllllllllIIlIlllIIIlIIIll.length == 0) {
            return Collections.singletonList(llllllllllllllllIIlIlllIIIlIIlII);
        }
        final List<String> llllllllllllllllIIlIlllIIIlIIIlI = new ArrayList<String>(llllllllllllllllIIlIlllIIIlIIIll.length + 1);
        llllllllllllllllIIlIlllIIIlIIIlI.add(llllllllllllllllIIlIlllIIIlIIlII);
        final char llllllllllllllllIIlIlllIIIIllIll = (Object)llllllllllllllllIIlIlllIIIlIIIll;
        final short llllllllllllllllIIlIlllIIIIllIlI = (short)llllllllllllllllIIlIlllIIIIllIll.length;
        for (float llllllllllllllllIIlIlllIIIIllIIl = 0; llllllllllllllllIIlIlllIIIIllIIl < llllllllllllllllIIlIlllIIIIllIlI; ++llllllllllllllllIIlIlllIIIIllIIl) {
            final String llllllllllllllllIIlIlllIIIlIlIII = llllllllllllllllIIlIlllIIIIllIll[llllllllllllllllIIlIlllIIIIllIIl];
            llllllllllllllllIIlIlllIIIlIIIlI.add(llllllllllllllllIIlIlllIIIlIlIII);
        }
        return llllllllllllllllIIlIlllIIIlIIIlI;
    }
    
    public boolean excludeField(final Field llllllllllllllllIIlIlllIIIlllllI, final boolean llllllllllllllllIIlIlllIIlIIIIII) {
        return excludeField(llllllllllllllllIIlIlllIIIlllllI, llllllllllllllllIIlIlllIIlIIIIII, this.excluder);
    }
    
    private Map<String, BoundField> getBoundFields(final Gson llllllllllllllllIIlIllIlllIIIIlI, TypeToken<?> llllllllllllllllIIlIllIllIlllIll, Class<?> llllllllllllllllIIlIllIlllIIIIII) {
        final Map<String, BoundField> llllllllllllllllIIlIllIllIllllll = new LinkedHashMap<String, BoundField>();
        if (llllllllllllllllIIlIllIlllIIIIII.isInterface()) {
            return llllllllllllllllIIlIllIllIllllll;
        }
        final Type llllllllllllllllIIlIllIllIlllllI = llllllllllllllllIIlIllIllIlllIll.getType();
        while (llllllllllllllllIIlIllIlllIIIIII != Object.class) {
            final String llllllllllllllllIIlIllIllIllIllI;
            final Field[] llllllllllllllllIIlIllIlllIIIlII = (Object)(llllllllllllllllIIlIllIllIllIllI = (String)(Object)llllllllllllllllIIlIllIlllIIIIII.getDeclaredFields());
            final Exception llllllllllllllllIIlIllIllIllIlIl = (Exception)llllllllllllllllIIlIllIllIllIllI.length;
            for (long llllllllllllllllIIlIllIllIllIlII = 0; llllllllllllllllIIlIllIllIllIlII < llllllllllllllllIIlIllIllIllIlIl; ++llllllllllllllllIIlIllIllIllIlII) {
                final Field llllllllllllllllIIlIllIlllIIIlIl = llllllllllllllllIIlIllIllIllIllI[llllllllllllllllIIlIllIllIllIlII];
                boolean llllllllllllllllIIlIllIlllIIlIlI = this.excludeField(llllllllllllllllIIlIllIlllIIIlIl, true);
                final boolean llllllllllllllllIIlIllIlllIIlIIl = this.excludeField(llllllllllllllllIIlIllIlllIIIlIl, false);
                if (llllllllllllllllIIlIllIlllIIlIlI || llllllllllllllllIIlIllIlllIIlIIl) {
                    this.accessor.makeAccessible(llllllllllllllllIIlIllIlllIIIlIl);
                    final Type llllllllllllllllIIlIllIlllIIlIII = $Gson$Types.resolve(llllllllllllllllIIlIllIllIlllIll.getType(), llllllllllllllllIIlIllIlllIIIIII, llllllllllllllllIIlIllIlllIIIlIl.getGenericType());
                    final List<String> llllllllllllllllIIlIllIlllIIIlll = this.getFieldNames(llllllllllllllllIIlIllIlllIIIlIl);
                    BoundField llllllllllllllllIIlIllIlllIIIllI = null;
                    for (int llllllllllllllllIIlIllIlllIIllII = 0, llllllllllllllllIIlIllIlllIIlIll = llllllllllllllllIIlIllIlllIIIlll.size(); llllllllllllllllIIlIllIlllIIllII < llllllllllllllllIIlIllIlllIIlIll; ++llllllllllllllllIIlIllIlllIIllII) {
                        final String llllllllllllllllIIlIllIlllIIllll = llllllllllllllllIIlIllIlllIIIlll.get(llllllllllllllllIIlIllIlllIIllII);
                        if (llllllllllllllllIIlIllIlllIIllII != 0) {
                            llllllllllllllllIIlIllIlllIIlIlI = false;
                        }
                        final BoundField llllllllllllllllIIlIllIlllIIlllI = this.createBoundField(llllllllllllllllIIlIllIlllIIIIlI, llllllllllllllllIIlIllIlllIIIlIl, llllllllllllllllIIlIllIlllIIllll, TypeToken.get(llllllllllllllllIIlIllIlllIIlIII), llllllllllllllllIIlIllIlllIIlIlI, llllllllllllllllIIlIllIlllIIlIIl);
                        final BoundField llllllllllllllllIIlIllIlllIIllIl = llllllllllllllllIIlIllIllIllllll.put(llllllllllllllllIIlIllIlllIIllll, llllllllllllllllIIlIllIlllIIlllI);
                        if (llllllllllllllllIIlIllIlllIIIllI == null) {
                            llllllllllllllllIIlIllIlllIIIllI = llllllllllllllllIIlIllIlllIIllIl;
                        }
                    }
                    if (llllllllllllllllIIlIllIlllIIIllI != null) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIllIllIlllllI).append(" declares multiple JSON fields named ").append(llllllllllllllllIIlIllIlllIIIllI.name)));
                    }
                }
            }
            llllllllllllllllIIlIllIllIlllIll = TypeToken.get($Gson$Types.resolve(llllllllllllllllIIlIllIllIlllIll.getType(), llllllllllllllllIIlIllIlllIIIIII, llllllllllllllllIIlIllIlllIIIIII.getGenericSuperclass()));
            llllllllllllllllIIlIllIlllIIIIII = llllllllllllllllIIlIllIllIlllIll.getRawType();
        }
        return llllllllllllllllIIlIllIllIllllll;
    }
    
    static boolean excludeField(final Field llllllllllllllllIIlIlllIIIlllIIl, final boolean llllllllllllllllIIlIlllIIIllIlIl, final Excluder llllllllllllllllIIlIlllIIIllIlII) {
        return !llllllllllllllllIIlIlllIIIllIlII.excludeClass(llllllllllllllllIIlIlllIIIlllIIl.getType(), llllllllllllllllIIlIlllIIIllIlIl) && !llllllllllllllllIIlIlllIIIllIlII.excludeField(llllllllllllllllIIlIlllIIIlllIIl, llllllllllllllllIIlIlllIIIllIlIl);
    }
    
    public ReflectiveTypeAdapterFactory(final ConstructorConstructor llllllllllllllllIIlIlllIIlIIlIIl, final FieldNamingStrategy llllllllllllllllIIlIlllIIlIIllIl, final Excluder llllllllllllllllIIlIlllIIlIIllII, final JsonAdapterAnnotationTypeAdapterFactory llllllllllllllllIIlIlllIIlIIIllI) {
        this.accessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = llllllllllllllllIIlIlllIIlIIlIIl;
        this.fieldNamingPolicy = llllllllllllllllIIlIlllIIlIIllIl;
        this.excluder = llllllllllllllllIIlIlllIIlIIllII;
        this.jsonAdapterFactory = llllllllllllllllIIlIlllIIlIIIllI;
    }
    
    @Override
    public <T> TypeAdapter<T> create(final Gson llllllllllllllllIIlIlllIIIIIllII, final TypeToken<T> llllllllllllllllIIlIlllIIIIlIIII) {
        final Class<? super T> llllllllllllllllIIlIlllIIIIIllll = llllllllllllllllIIlIlllIIIIlIIII.getRawType();
        if (!Object.class.isAssignableFrom(llllllllllllllllIIlIlllIIIIIllll)) {
            return null;
        }
        final ObjectConstructor<T> llllllllllllllllIIlIlllIIIIIlllI = this.constructorConstructor.get(llllllllllllllllIIlIlllIIIIlIIII);
        return new Adapter<T>(llllllllllllllllIIlIlllIIIIIlllI, this.getBoundFields(llllllllllllllllIIlIlllIIIIIllII, llllllllllllllllIIlIlllIIIIlIIII, llllllllllllllllIIlIlllIIIIIllll));
    }
    
    private BoundField createBoundField(final Gson llllllllllllllllIIlIllIllllIllll, final Field llllllllllllllllIIlIllIllllllIlI, final String llllllllllllllllIIlIllIllllIllIl, final TypeToken<?> llllllllllllllllIIlIllIllllllIII, final boolean llllllllllllllllIIlIllIlllllIlll, final boolean llllllllllllllllIIlIllIlllllIllI) {
        final boolean llllllllllllllllIIlIllIlllllIlIl = Primitives.isPrimitive(llllllllllllllllIIlIllIllllllIII.getRawType());
        final JsonAdapter llllllllllllllllIIlIllIlllllIlII = llllllllllllllllIIlIllIllllllIlI.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> llllllllllllllllIIlIllIlllllIIll = null;
        if (llllllllllllllllIIlIllIlllllIlII != null) {
            llllllllllllllllIIlIllIlllllIIll = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, llllllllllllllllIIlIllIllllIllll, llllllllllllllllIIlIllIllllllIII, llllllllllllllllIIlIllIlllllIlII);
        }
        final boolean llllllllllllllllIIlIllIlllllIIlI = llllllllllllllllIIlIllIlllllIIll != null;
        if (llllllllllllllllIIlIllIlllllIIll == null) {
            llllllllllllllllIIlIllIlllllIIll = llllllllllllllllIIlIllIllllIllll.getAdapter(llllllllllllllllIIlIllIllllllIII);
        }
        final TypeAdapter<?> llllllllllllllllIIlIllIlllllIIIl = llllllllllllllllIIlIllIlllllIIll;
        return new BoundField(llllllllllllllllIIlIllIllllIllIl, llllllllllllllllIIlIllIlllllIlll, llllllllllllllllIIlIllIlllllIllI) {
            @Override
            void write(final JsonWriter lllllllllllllIllllIllIIIlIIllllI, final Object lllllllllllllIllllIllIIIlIlIIIlI) throws IllegalAccessException, IOException {
                final Object lllllllllllllIllllIllIIIlIlIIIIl = llllllllllllllllIIlIllIllllllIlI.get(lllllllllllllIllllIllIIIlIlIIIlI);
                final TypeAdapter lllllllllllllIllllIllIIIlIlIIIII = llllllllllllllllIIlIllIlllllIIlI ? llllllllllllllllIIlIllIlllllIIIl : new TypeAdapterRuntimeTypeWrapper(llllllllllllllllIIlIllIllllIllll, llllllllllllllllIIlIllIlllllIIIl, llllllllllllllllIIlIllIllllllIII.getType());
                lllllllllllllIllllIllIIIlIlIIIII.write(lllllllllllllIllllIllIIIlIIllllI, lllllllllllllIllllIllIIIlIlIIIIl);
            }
            
            public boolean writeField(final Object lllllllllllllIllllIllIIIlIIIIlll) throws IOException, IllegalAccessException {
                if (!this.serialized) {
                    return false;
                }
                final Object lllllllllllllIllllIllIIIlIIIlIIl = llllllllllllllllIIlIllIllllllIlI.get(lllllllllllllIllllIllIIIlIIIIlll);
                return lllllllllllllIllllIllIIIlIIIlIIl != lllllllllllllIllllIllIIIlIIIIlll;
            }
            
            @Override
            void read(final JsonReader lllllllllllllIllllIllIIIlIIlIlIl, final Object lllllllllllllIllllIllIIIlIIlIIII) throws IllegalAccessException, IOException {
                final Object lllllllllllllIllllIllIIIlIIlIIll = llllllllllllllllIIlIllIlllllIIIl.read(lllllllllllllIllllIllIIIlIIlIlIl);
                if (lllllllllllllIllllIllIIIlIIlIIll != null || !llllllllllllllllIIlIllIlllllIlIl) {
                    llllllllllllllllIIlIllIllllllIlI.set(lllllllllllllIllllIllIIIlIIlIIII, lllllllllllllIllllIllIIIlIIlIIll);
                }
            }
        };
    }
    
    public static final class Adapter<T> extends TypeAdapter<T>
    {
        private final /* synthetic */ Map<String, BoundField> boundFields;
        private final /* synthetic */ ObjectConstructor<T> constructor;
        
        @Override
        public void write(final JsonWriter lllllllllllllllIllIlIlllIlIIIIII, final T lllllllllllllllIllIlIlllIIllllll) throws IOException {
            if (lllllllllllllllIllIlIlllIIllllll == null) {
                lllllllllllllllIllIlIlllIlIIIIII.nullValue();
                return;
            }
            lllllllllllllllIllIlIlllIlIIIIII.beginObject();
            try {
                for (final BoundField lllllllllllllllIllIlIlllIlIIIIll : this.boundFields.values()) {
                    if (lllllllllllllllIllIlIlllIlIIIIll.writeField(lllllllllllllllIllIlIlllIIllllll)) {
                        lllllllllllllllIllIlIlllIlIIIIII.name(lllllllllllllllIllIlIlllIlIIIIll.name);
                        lllllllllllllllIllIlIlllIlIIIIll.write(lllllllllllllllIllIlIlllIlIIIIII, lllllllllllllllIllIlIlllIIllllll);
                    }
                }
            }
            catch (IllegalAccessException lllllllllllllllIllIlIlllIlIIIIlI) {
                throw new AssertionError((Object)lllllllllllllllIllIlIlllIlIIIIlI);
            }
            lllllllllllllllIllIlIlllIlIIIIII.endObject();
        }
        
        @Override
        public T read(final JsonReader lllllllllllllllIllIlIlllIlIIllll) throws IOException {
            if (lllllllllllllllIllIlIlllIlIIllll.peek() == JsonToken.NULL) {
                lllllllllllllllIllIlIlllIlIIllll.nextNull();
                return null;
            }
            final T lllllllllllllllIllIlIlllIlIIlllI = this.constructor.construct();
            try {
                lllllllllllllllIllIlIlllIlIIllll.beginObject();
                while (lllllllllllllllIllIlIlllIlIIllll.hasNext()) {
                    final String lllllllllllllllIllIlIlllIlIlIlII = lllllllllllllllIllIlIlllIlIIllll.nextName();
                    final BoundField lllllllllllllllIllIlIlllIlIlIIll = this.boundFields.get(lllllllllllllllIllIlIlllIlIlIlII);
                    if (lllllllllllllllIllIlIlllIlIlIIll == null || !lllllllllllllllIllIlIlllIlIlIIll.deserialized) {
                        lllllllllllllllIllIlIlllIlIIllll.skipValue();
                    }
                    else {
                        lllllllllllllllIllIlIlllIlIlIIll.read(lllllllllllllllIllIlIlllIlIIllll, lllllllllllllllIllIlIlllIlIIlllI);
                    }
                }
            }
            catch (IllegalStateException lllllllllllllllIllIlIlllIlIlIIlI) {
                throw new JsonSyntaxException(lllllllllllllllIllIlIlllIlIlIIlI);
            }
            catch (IllegalAccessException lllllllllllllllIllIlIlllIlIlIIIl) {
                throw new AssertionError((Object)lllllllllllllllIllIlIlllIlIlIIIl);
            }
            lllllllllllllllIllIlIlllIlIIllll.endObject();
            return lllllllllllllllIllIlIlllIlIIlllI;
        }
        
        Adapter(final ObjectConstructor<T> lllllllllllllllIllIlIlllIlIllllI, final Map<String, BoundField> lllllllllllllllIllIlIlllIlIlllIl) {
            this.constructor = lllllllllllllllIllIlIlllIlIllllI;
            this.boundFields = lllllllllllllllIllIlIlllIlIlllIl;
        }
    }
    
    abstract static class BoundField
    {
        final /* synthetic */ String name;
        final /* synthetic */ boolean serialized;
        final /* synthetic */ boolean deserialized;
        
        abstract void read(final JsonReader p0, final Object p1) throws IllegalAccessException, IOException;
        
        abstract boolean writeField(final Object p0) throws IllegalAccessException, IOException;
        
        abstract void write(final JsonWriter p0, final Object p1) throws IllegalAccessException, IOException;
        
        protected BoundField(final String lllllllllllllIllIlIlIlIIllIIIlIl, final boolean lllllllllllllIllIlIlIlIIllIIIIII, final boolean lllllllllllllIllIlIlIlIIllIIIIll) {
            this.name = lllllllllllllIllIlIlIlIIllIIIlIl;
            this.serialized = lllllllllllllIllIlIlIlIIllIIIIII;
            this.deserialized = lllllllllllllIllIlIlIlIIllIIIIll;
        }
    }
}
