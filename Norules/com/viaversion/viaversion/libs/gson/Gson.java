package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.reflect.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.math.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.internal.bind.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;

public final class Gson
{
    final /* synthetic */ FieldNamingStrategy fieldNamingStrategy;
    final /* synthetic */ boolean generateNonExecutableJson;
    final /* synthetic */ boolean complexMapKeySerialization;
    final /* synthetic */ Excluder excluder;
    private final /* synthetic */ ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    final /* synthetic */ boolean lenient;
    final /* synthetic */ int timeStyle;
    final /* synthetic */ List<TypeAdapterFactory> builderHierarchyFactories;
    final /* synthetic */ int dateStyle;
    final /* synthetic */ boolean htmlSafe;
    private final /* synthetic */ Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final /* synthetic */ boolean serializeNulls;
    final /* synthetic */ boolean serializeSpecialFloatingPointValues;
    final /* synthetic */ Map<Type, InstanceCreator<?>> instanceCreators;
    private static final /* synthetic */ TypeToken<?> NULL_KEY_SURROGATE;
    final /* synthetic */ boolean prettyPrinting;
    private final /* synthetic */ ConstructorConstructor constructorConstructor;
    final /* synthetic */ List<TypeAdapterFactory> factories;
    final /* synthetic */ LongSerializationPolicy longSerializationPolicy;
    final /* synthetic */ String datePattern;
    final /* synthetic */ List<TypeAdapterFactory> builderFactories;
    private final /* synthetic */ JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    
    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }
    
    private static TypeAdapter<Number> longAdapter(final LongSerializationPolicy lllllllllllllIIlIllllIllIllIIllI) {
        if (lllllllllllllIIlIllllIllIllIIllI == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        return new TypeAdapter<Number>() {
            @Override
            public Number read(final JsonReader lllllllllllllIIlllIIIlIlIIIIllll) throws IOException {
                if (lllllllllllllIIlllIIIlIlIIIIllll.peek() == JsonToken.NULL) {
                    lllllllllllllIIlllIIIlIlIIIIllll.nextNull();
                    return null;
                }
                return lllllllllllllIIlllIIIlIlIIIIllll.nextLong();
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIlllIIIlIlIIIIlIII, final Number lllllllllllllIIlllIIIlIlIIIIIlll) throws IOException {
                if (lllllllllllllIIlllIIIlIlIIIIIlll == null) {
                    lllllllllllllIIlllIIIlIlIIIIlIII.nullValue();
                    return;
                }
                lllllllllllllIIlllIIIlIlIIIIlIII.value(lllllllllllllIIlllIIIlIlIIIIIlll.toString());
            }
        };
    }
    
    public void toJson(final JsonElement lllllllllllllIIlIllllIlIlIIlIIIl, final JsonWriter lllllllllllllIIlIllllIlIlIIlIIII) throws JsonIOException {
        final boolean lllllllllllllIIlIllllIlIlIIIllll = lllllllllllllIIlIllllIlIlIIlIIII.isLenient();
        lllllllllllllIIlIllllIlIlIIlIIII.setLenient(true);
        final boolean lllllllllllllIIlIllllIlIlIIIlllI = lllllllllllllIIlIllllIlIlIIlIIII.isHtmlSafe();
        lllllllllllllIIlIllllIlIlIIlIIII.setHtmlSafe(this.htmlSafe);
        final boolean lllllllllllllIIlIllllIlIlIIIllIl = lllllllllllllIIlIllllIlIlIIlIIII.getSerializeNulls();
        lllllllllllllIIlIllllIlIlIIlIIII.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(lllllllllllllIIlIllllIlIlIIlIIIl, lllllllllllllIIlIllllIlIlIIlIIII);
        }
        catch (IOException lllllllllllllIIlIllllIlIlIIlIlIl) {
            throw new JsonIOException(lllllllllllllIIlIllllIlIlIIlIlIl);
        }
        catch (AssertionError lllllllllllllIIlIllllIlIlIIlIIll) {
            final AssertionError lllllllllllllIIlIllllIlIlIIlIlII = new AssertionError((Object)String.valueOf(new StringBuilder().append("AssertionError (GSON 2.8.7): ").append(lllllllllllllIIlIllllIlIlIIlIIll.getMessage())));
            lllllllllllllIIlIllllIlIlIIlIlII.initCause(lllllllllllllIIlIllllIlIlIIlIIll);
            throw lllllllllllllIIlIllllIlIlIIlIlII;
        }
        finally {
            lllllllllllllIIlIllllIlIlIIlIIII.setLenient(lllllllllllllIIlIllllIlIlIIIllll);
            lllllllllllllIIlIllllIlIlIIlIIII.setHtmlSafe(lllllllllllllIIlIllllIlIlIIIlllI);
            lllllllllllllIIlIllllIlIlIIlIIII.setSerializeNulls(lllllllllllllIIlIllllIlIlIIIllIl);
        }
    }
    
    public Excluder excluder() {
        return this.excluder;
    }
    
    public <T> TypeAdapter<T> getAdapter(final Class<T> lllllllllllllIIlIllllIllIIlIIlIl) {
        return this.getAdapter((TypeToken<T>)TypeToken.get((Class<T>)lllllllllllllIIlIllllIllIIlIIlIl));
    }
    
    public <T> T fromJson(final JsonElement lllllllllllllIIlIllllIlIIIIIllll, final Type lllllllllllllIIlIllllIlIIIIIlllI) throws JsonSyntaxException {
        if (lllllllllllllIIlIllllIlIIIIIllll == null) {
            return null;
        }
        return this.fromJson(new JsonTreeReader(lllllllllllllIIlIllllIlIIIIIllll), lllllllllllllIIlIllllIlIIIIIlllI);
    }
    
    public String toJson(final Object lllllllllllllIIlIllllIllIIIIIlll, final Type lllllllllllllIIlIllllIllIIIIIIlI) {
        final StringWriter lllllllllllllIIlIllllIllIIIIIlIl = new StringWriter();
        this.toJson(lllllllllllllIIlIllllIllIIIIIlll, lllllllllllllIIlIllllIllIIIIIIlI, lllllllllllllIIlIllllIllIIIIIlIl);
        return lllllllllllllIIlIllllIllIIIIIlIl.toString();
    }
    
    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> lllllllllllllIIlIllllIllIllIIIll) {
        return new TypeAdapter<AtomicLong>() {
            @Override
            public void write(final JsonWriter llllllllllllllIlIIlllIlIllIllIII, final AtomicLong llllllllllllllIlIIlllIlIllIlIlll) throws IOException {
                lllllllllllllIIlIllllIllIllIIIll.write(llllllllllllllIlIIlllIlIllIllIII, llllllllllllllIlIIlllIlIllIlIlll.get());
            }
            
            @Override
            public AtomicLong read(final JsonReader llllllllllllllIlIIlllIlIllIIllII) throws IOException {
                final Number llllllllllllllIlIIlllIlIllIIlllI = lllllllllllllIIlIllllIllIllIIIll.read(llllllllllllllIlIIlllIlIllIIllII);
                return new AtomicLong(llllllllllllllIlIIlllIlIllIIlllI.longValue());
            }
        }.nullSafe();
    }
    
    Gson(final Excluder lllllllllllllIIlIllllIlllIIllIIl, final FieldNamingStrategy lllllllllllllIIlIllllIlllIIllIII, final Map<Type, InstanceCreator<?>> lllllllllllllIIlIllllIlllIlIlIll, final boolean lllllllllllllIIlIllllIlllIIlIllI, final boolean lllllllllllllIIlIllllIlllIlIlIIl, final boolean lllllllllllllIIlIllllIlllIIlIlII, final boolean lllllllllllllIIlIllllIlllIlIIlll, final boolean lllllllllllllIIlIllllIlllIIlIIlI, final boolean lllllllllllllIIlIllllIlllIlIIlIl, final boolean lllllllllllllIIlIllllIlllIlIIlII, final LongSerializationPolicy lllllllllllllIIlIllllIlllIIIllll, final String lllllllllllllIIlIllllIlllIIIlllI, final int lllllllllllllIIlIllllIlllIIIllIl, final int lllllllllllllIIlIllllIlllIIIllII, final List<TypeAdapterFactory> lllllllllllllIIlIllllIlllIIlllll, final List<TypeAdapterFactory> lllllllllllllIIlIllllIlllIIllllI, final List<TypeAdapterFactory> lllllllllllllIIlIllllIlllIIIlIIl) {
        this.calls = new ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>>();
        this.typeTokenCache = new ConcurrentHashMap<TypeToken<?>, TypeAdapter<?>>();
        this.excluder = lllllllllllllIIlIllllIlllIIllIIl;
        this.fieldNamingStrategy = lllllllllllllIIlIllllIlllIIllIII;
        this.instanceCreators = lllllllllllllIIlIllllIlllIlIlIll;
        this.constructorConstructor = new ConstructorConstructor(lllllllllllllIIlIllllIlllIlIlIll);
        this.serializeNulls = lllllllllllllIIlIllllIlllIIlIllI;
        this.complexMapKeySerialization = lllllllllllllIIlIllllIlllIlIlIIl;
        this.generateNonExecutableJson = lllllllllllllIIlIllllIlllIIlIlII;
        this.htmlSafe = lllllllllllllIIlIllllIlllIlIIlll;
        this.prettyPrinting = lllllllllllllIIlIllllIlllIIlIIlI;
        this.lenient = lllllllllllllIIlIllllIlllIlIIlIl;
        this.serializeSpecialFloatingPointValues = lllllllllllllIIlIllllIlllIlIIlII;
        this.longSerializationPolicy = lllllllllllllIIlIllllIlllIIIllll;
        this.datePattern = lllllllllllllIIlIllllIlllIIIlllI;
        this.dateStyle = lllllllllllllIIlIllllIlllIIIllIl;
        this.timeStyle = lllllllllllllIIlIllllIlllIIIllII;
        this.builderFactories = lllllllllllllIIlIllllIlllIIlllll;
        this.builderHierarchyFactories = lllllllllllllIIlIllllIlllIIllllI;
        final List<TypeAdapterFactory> lllllllllllllIIlIllllIlllIIlllII = new ArrayList<TypeAdapterFactory>();
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(ObjectTypeAdapter.FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(lllllllllllllIIlIllllIlllIIllIIl);
        lllllllllllllIIlIllllIlllIIlllII.addAll(lllllllllllllIIlIllllIlllIIIlIIl);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.STRING_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.INTEGER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.BOOLEAN_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.BYTE_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.SHORT_FACTORY);
        final TypeAdapter<Number> lllllllllllllIIlIllllIlllIIllIll = longAdapter(lllllllllllllIIlIllllIlllIIIllll);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(Long.TYPE, Long.class, lllllllllllllIIlIllllIlllIIllIll));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(lllllllllllllIIlIllllIlllIlIIlII)));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(lllllllllllllIIlIllllIlllIlIIlII)));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.NUMBER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(lllllllllllllIIlIllllIlllIIllIll)));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(lllllllllllllIIlIllllIlllIIllIll)));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.CHARACTER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.STRING_BUILDER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.STRING_BUFFER_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.URL_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.URI_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.UUID_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.CURRENCY_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.LOCALE_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.INET_ADDRESS_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.BIT_SET_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(DateTypeAdapter.FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.CALENDAR_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TimeTypeAdapter.FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(SqlDateTypeAdapter.FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.TIMESTAMP_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(ArrayTypeAdapter.FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.CLASS_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        lllllllllllllIIlIllllIlllIIlllII.add(new MapTypeAdapterFactory(this.constructorConstructor, lllllllllllllIIlIllllIlllIlIlIIl));
        this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        lllllllllllllIIlIllllIlllIIlllII.add(this.jsonAdapterFactory);
        lllllllllllllIIlIllllIlllIIlllII.add(TypeAdapters.ENUM_FACTORY);
        lllllllllllllIIlIllllIlllIIlllII.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, lllllllllllllIIlIllllIlllIIllIII, lllllllllllllIIlIllllIlllIIllIIl, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList((List<? extends TypeAdapterFactory>)lllllllllllllIIlIllllIlllIIlllII);
    }
    
    public void toJson(final Object lllllllllllllIIlIllllIlIlllIlIll, final Type lllllllllllllIIlIllllIlIlllIlllI, final Appendable lllllllllllllIIlIllllIlIlllIllIl) throws JsonIOException {
        try {
            final JsonWriter lllllllllllllIIlIllllIlIllllIIlI = this.newJsonWriter(Streams.writerForAppendable(lllllllllllllIIlIllllIlIlllIllIl));
            this.toJson(lllllllllllllIIlIllllIlIlllIlIll, lllllllllllllIIlIllllIlIlllIlllI, lllllllllllllIIlIllllIlIllllIIlI);
        }
        catch (IOException lllllllllllllIIlIllllIlIllllIIIl) {
            throw new JsonIOException(lllllllllllllIIlIllllIlIllllIIIl);
        }
    }
    
    public <T> T fromJson(final String lllllllllllllIIlIllllIlIIlllIIIl, final Type lllllllllllllIIlIllllIlIIllIlIll) throws JsonSyntaxException {
        if (lllllllllllllIIlIllllIlIIlllIIIl == null) {
            return null;
        }
        final StringReader lllllllllllllIIlIllllIlIIllIllll = new StringReader(lllllllllllllIIlIllllIlIIlllIIIl);
        final T lllllllllllllIIlIllllIlIIllIlllI = this.fromJson(lllllllllllllIIlIllllIlIIllIllll, lllllllllllllIIlIllllIlIIllIlIll);
        return lllllllllllllIIlIllllIlIIllIlllI;
    }
    
    public <T> TypeAdapter<T> getAdapter(final TypeToken<T> lllllllllllllIIlIllllIllIlIIlIIl) {
        final TypeAdapter<?> lllllllllllllIIlIllllIllIlIIlllI = this.typeTokenCache.get((lllllllllllllIIlIllllIllIlIIlIIl == null) ? Gson.NULL_KEY_SURROGATE : lllllllllllllIIlIllllIllIlIIlIIl);
        if (lllllllllllllIIlIllllIllIlIIlllI != null) {
            return (TypeAdapter<T>)lllllllllllllIIlIllllIllIlIIlllI;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> lllllllllllllIIlIllllIllIlIIllIl = this.calls.get();
        boolean lllllllllllllIIlIllllIllIlIIllII = false;
        if (lllllllllllllIIlIllllIllIlIIllIl == null) {
            lllllllllllllIIlIllllIllIlIIllIl = new HashMap<TypeToken<?>, FutureTypeAdapter<?>>();
            this.calls.set(lllllllllllllIIlIllllIllIlIIllIl);
            lllllllllllllIIlIllllIllIlIIllII = true;
        }
        final FutureTypeAdapter<T> lllllllllllllIIlIllllIllIlIIlIll = (FutureTypeAdapter<T>)lllllllllllllIIlIllllIllIlIIllIl.get(lllllllllllllIIlIllllIllIlIIlIIl);
        if (lllllllllllllIIlIllllIllIlIIlIll != null) {
            return lllllllllllllIIlIllllIllIlIIlIll;
        }
        try {
            final FutureTypeAdapter<T> lllllllllllllIIlIllllIllIlIlIIIl = new FutureTypeAdapter<T>();
            lllllllllllllIIlIllllIllIlIIllIl.put(lllllllllllllIIlIllllIllIlIIlIIl, lllllllllllllIIlIllllIllIlIlIIIl);
            for (final TypeAdapterFactory lllllllllllllIIlIllllIllIlIlIIlI : this.factories) {
                final TypeAdapter<T> lllllllllllllIIlIllllIllIlIlIIll = lllllllllllllIIlIllllIllIlIlIIlI.create(this, lllllllllllllIIlIllllIllIlIIlIIl);
                if (lllllllllllllIIlIllllIllIlIlIIll != null) {
                    lllllllllllllIIlIllllIllIlIlIIIl.setDelegate(lllllllllllllIIlIllllIllIlIlIIll);
                    this.typeTokenCache.put(lllllllllllllIIlIllllIllIlIIlIIl, lllllllllllllIIlIllllIllIlIlIIll);
                    final boolean lllllllllllllIIlIllllIllIlIIIIII = (boolean)lllllllllllllIIlIllllIllIlIlIIll;
                    return (TypeAdapter<T>)lllllllllllllIIlIllllIllIlIIIIII;
                }
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("GSON (2.8.7) cannot handle ").append(lllllllllllllIIlIllllIllIlIIlIIl)));
        }
        finally {
            lllllllllllllIIlIllllIllIlIIllIl.remove(lllllllllllllIIlIllllIllIlIIlIIl);
            if (lllllllllllllIIlIllllIllIlIIllII) {
                this.calls.remove();
            }
        }
    }
    
    public String toJson(final JsonElement lllllllllllllIIlIllllIlIlIllllll) {
        final StringWriter lllllllllllllIIlIllllIlIllIIIIIl = new StringWriter();
        this.toJson(lllllllllllllIIlIllllIlIlIllllll, lllllllllllllIIlIllllIlIllIIIIIl);
        return lllllllllllllIIlIllllIlIllIIIIIl.toString();
    }
    
    public boolean htmlSafe() {
        return this.htmlSafe;
    }
    
    public <T> T fromJson(final String lllllllllllllIIlIllllIlIIllllllI, final Class<T> lllllllllllllIIlIllllIlIIllllIIl) throws JsonSyntaxException {
        final Object lllllllllllllIIlIllllIlIIlllllII = this.fromJson(lllllllllllllIIlIllllIlIIllllllI, (Type)lllllllllllllIIlIllllIlIIllllIIl);
        return Primitives.wrap(lllllllllllllIIlIllllIlIIllllIIl).cast(lllllllllllllIIlIllllIlIIlllllII);
    }
    
    public JsonElement toJsonTree(final Object lllllllllllllIIlIllllIllIIIllIIl, final Type lllllllllllllIIlIllllIllIIIllIII) {
        final JsonTreeWriter lllllllllllllIIlIllllIllIIIlIlll = new JsonTreeWriter();
        this.toJson(lllllllllllllIIlIllllIllIIIllIIl, lllllllllllllIIlIllllIllIIIllIII, lllllllllllllIIlIllllIllIIIlIlll);
        return lllllllllllllIIlIllllIllIIIlIlll.get();
    }
    
    public JsonReader newJsonReader(final Reader lllllllllllllIIlIllllIlIlIlIIIll) {
        final JsonReader lllllllllllllIIlIllllIlIlIlIIIlI = new JsonReader(lllllllllllllIIlIllllIlIlIlIIIll);
        lllllllllllllIIlIllllIlIlIlIIIlI.setLenient(this.lenient);
        return lllllllllllllIIlIllllIlIlIlIIIlI;
    }
    
    public <T> T fromJson(final Reader lllllllllllllIIlIllllIlIIlIlllIl, final Class<T> lllllllllllllIIlIllllIlIIllIIIIl) throws JsonIOException, JsonSyntaxException {
        final JsonReader lllllllllllllIIlIllllIlIIllIIIII = this.newJsonReader(lllllllllllllIIlIllllIlIIlIlllIl);
        final Object lllllllllllllIIlIllllIlIIlIlllll = this.fromJson(lllllllllllllIIlIllllIlIIllIIIII, lllllllllllllIIlIllllIlIIllIIIIl);
        assertFullConsumption(lllllllllllllIIlIllllIlIIlIlllll, lllllllllllllIIlIllllIlIIllIIIII);
        return Primitives.wrap(lllllllllllllIIlIllllIlIIllIIIIl).cast(lllllllllllllIIlIllllIlIIlIlllll);
    }
    
    private TypeAdapter<Number> floatAdapter(final boolean lllllllllllllIIlIllllIllIllIlllI) {
        if (lllllllllllllIIlIllllIllIllIlllI) {
            return TypeAdapters.FLOAT;
        }
        return new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter lllllllllllllIIIllIllllIlIIIIIII, final Number lllllllllllllIIIllIllllIIlllllII) throws IOException {
                if (lllllllllllllIIIllIllllIIlllllII == null) {
                    lllllllllllllIIIllIllllIlIIIIIII.nullValue();
                    return;
                }
                final float lllllllllllllIIIllIllllIIllllllI = lllllllllllllIIIllIllllIIlllllII.floatValue();
                Gson.checkValidFloatingPoint(lllllllllllllIIIllIllllIIllllllI);
                lllllllllllllIIIllIllllIlIIIIIII.value(lllllllllllllIIIllIllllIIlllllII);
            }
            
            @Override
            public Float read(final JsonReader lllllllllllllIIIllIllllIlIIIIllI) throws IOException {
                if (lllllllllllllIIIllIllllIlIIIIllI.peek() == JsonToken.NULL) {
                    lllllllllllllIIIllIllllIlIIIIllI.nextNull();
                    return null;
                }
                return (float)lllllllllllllIIIllIllllIlIIIIllI.nextDouble();
            }
        };
    }
    
    public JsonElement toJsonTree(final Object lllllllllllllIIlIllllIllIIlIIIIl) {
        if (lllllllllllllIIlIllllIllIIlIIIIl == null) {
            return JsonNull.INSTANCE;
        }
        return this.toJsonTree(lllllllllllllIIlIllllIllIIlIIIIl, lllllllllllllIIlIllllIllIIlIIIIl.getClass());
    }
    
    public void toJson(final Object lllllllllllllIIlIllllIlIllIllIII, final Type lllllllllllllIIlIllllIlIllIIllll, final JsonWriter lllllllllllllIIlIllllIlIllIIlllI) throws JsonIOException {
        final TypeAdapter<?> lllllllllllllIIlIllllIlIllIlIlIl = this.getAdapter(TypeToken.get(lllllllllllllIIlIllllIlIllIIllll));
        final boolean lllllllllllllIIlIllllIlIllIlIlII = lllllllllllllIIlIllllIlIllIIlllI.isLenient();
        lllllllllllllIIlIllllIlIllIIlllI.setLenient(true);
        final boolean lllllllllllllIIlIllllIlIllIlIIll = lllllllllllllIIlIllllIlIllIIlllI.isHtmlSafe();
        lllllllllllllIIlIllllIlIllIIlllI.setHtmlSafe(this.htmlSafe);
        final boolean lllllllllllllIIlIllllIlIllIlIIlI = lllllllllllllIIlIllllIlIllIIlllI.getSerializeNulls();
        lllllllllllllIIlIllllIlIllIIlllI.setSerializeNulls(this.serializeNulls);
        try {
            lllllllllllllIIlIllllIlIllIlIlIl.write(lllllllllllllIIlIllllIlIllIIlllI, lllllllllllllIIlIllllIlIllIllIII);
        }
        catch (IOException lllllllllllllIIlIllllIlIllIlllII) {
            throw new JsonIOException(lllllllllllllIIlIllllIlIllIlllII);
        }
        catch (AssertionError lllllllllllllIIlIllllIlIllIllIlI) {
            final AssertionError lllllllllllllIIlIllllIlIllIllIll = new AssertionError((Object)String.valueOf(new StringBuilder().append("AssertionError (GSON 2.8.7): ").append(lllllllllllllIIlIllllIlIllIllIlI.getMessage())));
            lllllllllllllIIlIllllIlIllIllIll.initCause(lllllllllllllIIlIllllIlIllIllIlI);
            throw lllllllllllllIIlIllllIlIllIllIll;
        }
        finally {
            lllllllllllllIIlIllllIlIllIIlllI.setLenient(lllllllllllllIIlIllllIlIllIlIlII);
            lllllllllllllIIlIllllIlIllIIlllI.setHtmlSafe(lllllllllllllIIlIllllIlIllIlIIll);
            lllllllllllllIIlIllllIlIllIIlllI.setSerializeNulls(lllllllllllllIIlIllllIlIllIlIIlI);
        }
    }
    
    public void toJson(final JsonElement lllllllllllllIIlIllllIlIlIllIllI, final Appendable lllllllllllllIIlIllllIlIlIllIlIl) throws JsonIOException {
        try {
            final JsonWriter lllllllllllllIIlIllllIlIlIlllIIl = this.newJsonWriter(Streams.writerForAppendable(lllllllllllllIIlIllllIlIlIllIlIl));
            this.toJson(lllllllllllllIIlIllllIlIlIllIllI, lllllllllllllIIlIllllIlIlIlllIIl);
        }
        catch (IOException lllllllllllllIIlIllllIlIlIlllIII) {
            throw new JsonIOException(lllllllllllllIIlIllllIlIlIlllIII);
        }
    }
    
    public boolean serializeNulls() {
        return this.serializeNulls;
    }
    
    static void checkValidFloatingPoint(final double lllllllllllllIIlIllllIllIllIlIIl) {
        if (Double.isNaN(lllllllllllllIIlIllllIllIllIlIIl) || Double.isInfinite(lllllllllllllIIlIllllIllIllIlIIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllIIlIllllIllIllIlIIl).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.")));
        }
    }
    
    static {
        DEFAULT_LENIENT = false;
        DEFAULT_JSON_NON_EXECUTABLE = false;
        DEFAULT_SERIALIZE_NULLS = false;
        JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
        DEFAULT_PRETTY_PRINT = false;
        DEFAULT_ESCAPE_HTML = true;
        DEFAULT_COMPLEX_MAP_KEYS = false;
        DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
        NULL_KEY_SURROGATE = TypeToken.get((Class<?>)Object.class);
    }
    
    public String toJson(final Object lllllllllllllIIlIllllIllIIIIllll) {
        if (lllllllllllllIIlIllllIllIIIIllll == null) {
            return this.toJson(JsonNull.INSTANCE);
        }
        return this.toJson(lllllllllllllIIlIllllIllIIIIllll, lllllllllllllIIlIllllIllIIIIllll.getClass());
    }
    
    private static void assertFullConsumption(final Object lllllllllllllIIlIllllIlIIlIIIlIl, final JsonReader lllllllllllllIIlIllllIlIIlIIIlII) {
        try {
            if (lllllllllllllIIlIllllIlIIlIIIlIl != null && lllllllllllllIIlIllllIlIIlIIIlII.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
        }
        catch (MalformedJsonException lllllllllllllIIlIllllIlIIlIIIlll) {
            throw new JsonSyntaxException(lllllllllllllIIlIllllIlIIlIIIlll);
        }
        catch (IOException lllllllllllllIIlIllllIlIIlIIIllI) {
            throw new JsonIOException(lllllllllllllIIlIllllIlIIlIIIllI);
        }
    }
    
    private TypeAdapter<Number> doubleAdapter(final boolean lllllllllllllIIlIllllIllIlllIlII) {
        if (lllllllllllllIIlIllllIllIlllIlII) {
            return TypeAdapters.DOUBLE;
        }
        return new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter lllllllllllllIlIlllIIIllIllIIlIl, final Number lllllllllllllIlIlllIIIllIllIIlll) throws IOException {
                if (lllllllllllllIlIlllIIIllIllIIlll == null) {
                    lllllllllllllIlIlllIIIllIllIIlIl.nullValue();
                    return;
                }
                final double lllllllllllllIlIlllIIIllIllIIllI = lllllllllllllIlIlllIIIllIllIIlll.doubleValue();
                Gson.checkValidFloatingPoint(lllllllllllllIlIlllIIIllIllIIllI);
                lllllllllllllIlIlllIIIllIllIIlIl.value(lllllllllllllIlIlllIIIllIllIIlll);
            }
            
            @Override
            public Double read(final JsonReader lllllllllllllIlIlllIIIllIllIlllI) throws IOException {
                if (lllllllllllllIlIlllIIIllIllIlllI.peek() == JsonToken.NULL) {
                    lllllllllllllIlIlllIIIllIllIlllI.nextNull();
                    return null;
                }
                return lllllllllllllIlIlllIIIllIllIlllI.nextDouble();
            }
        };
    }
    
    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }
    
    public <T> T fromJson(final JsonReader lllllllllllllIIlIllllIlIIIlIlIII, final Type lllllllllllllIIlIllllIlIIIlIIlll) throws JsonIOException, JsonSyntaxException {
        boolean lllllllllllllIIlIllllIlIIIlIlIll = true;
        final boolean lllllllllllllIIlIllllIlIIIlIlIlI = lllllllllllllIIlIllllIlIIIlIlIII.isLenient();
        lllllllllllllIIlIllllIlIIIlIlIII.setLenient(true);
        try {
            lllllllllllllIIlIllllIlIIIlIlIII.peek();
            lllllllllllllIIlIllllIlIIIlIlIll = false;
            final TypeToken<T> lllllllllllllIIlIllllIlIIIllIllI = (TypeToken<T>)TypeToken.get(lllllllllllllIIlIllllIlIIIlIIlll);
            final TypeAdapter<T> lllllllllllllIIlIllllIlIIIllIlIl = this.getAdapter(lllllllllllllIIlIllllIlIIIllIllI);
            final double lllllllllllllIIlIllllIlIIIlIIIIl;
            final T lllllllllllllIIlIllllIlIIIllIlII = (T)(lllllllllllllIIlIllllIlIIIlIIIIl = (double)lllllllllllllIIlIllllIlIIIllIlIl.read(lllllllllllllIIlIllllIlIIIlIlIII));
            return (T)lllllllllllllIIlIllllIlIIIlIIIIl;
        }
        catch (EOFException lllllllllllllIIlIllllIlIIIllIIll) {
            if (lllllllllllllIIlIllllIlIIIlIlIll) {
                return null;
            }
            throw new JsonSyntaxException(lllllllllllllIIlIllllIlIIIllIIll);
        }
        catch (IllegalStateException lllllllllllllIIlIllllIlIIIllIIlI) {
            throw new JsonSyntaxException(lllllllllllllIIlIllllIlIIIllIIlI);
        }
        catch (IOException lllllllllllllIIlIllllIlIIIllIIIl) {
            throw new JsonSyntaxException(lllllllllllllIIlIllllIlIIIllIIIl);
        }
        catch (AssertionError lllllllllllllIIlIllllIlIIIlIllll) {
            final AssertionError lllllllllllllIIlIllllIlIIIllIIII = new AssertionError((Object)String.valueOf(new StringBuilder().append("AssertionError (GSON 2.8.7): ").append(lllllllllllllIIlIllllIlIIIlIllll.getMessage())));
            lllllllllllllIIlIllllIlIIIllIIII.initCause(lllllllllllllIIlIllllIlIIIlIllll);
            throw lllllllllllllIIlIllllIlIIIllIIII;
        }
        finally {
            lllllllllllllIIlIllllIlIIIlIlIII.setLenient(lllllllllllllIIlIllllIlIIIlIlIlI);
        }
    }
    
    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }
    
    public void toJson(final Object lllllllllllllIIlIllllIlIlllllIIl, final Appendable lllllllllllllIIlIllllIlIlllllIll) throws JsonIOException {
        if (lllllllllllllIIlIllllIlIlllllIIl != null) {
            this.toJson(lllllllllllllIIlIllllIlIlllllIIl, lllllllllllllIIlIllllIlIlllllIIl.getClass(), lllllllllllllIIlIllllIlIlllllIll);
        }
        else {
            this.toJson(JsonNull.INSTANCE, lllllllllllllIIlIllllIlIlllllIll);
        }
    }
    
    public <T> T fromJson(final Reader lllllllllllllIIlIllllIlIIlIIlllI, final Type lllllllllllllIIlIllllIlIIlIlIIlI) throws JsonIOException, JsonSyntaxException {
        final JsonReader lllllllllllllIIlIllllIlIIlIlIIIl = this.newJsonReader(lllllllllllllIIlIllllIlIIlIIlllI);
        final T lllllllllllllIIlIllllIlIIlIlIIII = this.fromJson(lllllllllllllIIlIllllIlIIlIlIIIl, lllllllllllllIIlIllllIlIIlIlIIlI);
        assertFullConsumption(lllllllllllllIIlIllllIlIIlIlIIII, lllllllllllllIIlIllllIlIIlIlIIIl);
        return lllllllllllllIIlIllllIlIIlIlIIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("{serializeNulls:").append(this.serializeNulls).append(",factories:").append(this.factories).append(",instanceCreators:").append(this.constructorConstructor).append("}"));
    }
    
    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> lllllllllllllIIlIllllIllIllIIIII) {
        return new TypeAdapter<AtomicLongArray>() {
            @Override
            public AtomicLongArray read(final JsonReader lllllllllllllllllllIIIlIIIIIIIlI) throws IOException {
                final List<Long> lllllllllllllllllllIIIlIIIIIIIIl = new ArrayList<Long>();
                lllllllllllllllllllIIIlIIIIIIIlI.beginArray();
                while (lllllllllllllllllllIIIlIIIIIIIlI.hasNext()) {
                    final long lllllllllllllllllllIIIlIIIIIIlIl = lllllllllllllIIlIllllIllIllIIIII.read(lllllllllllllllllllIIIlIIIIIIIlI).longValue();
                    lllllllllllllllllllIIIlIIIIIIIIl.add(lllllllllllllllllllIIIlIIIIIIlIl);
                }
                lllllllllllllllllllIIIlIIIIIIIlI.endArray();
                final int lllllllllllllllllllIIIlIIIIIIIII = lllllllllllllllllllIIIlIIIIIIIIl.size();
                final AtomicLongArray lllllllllllllllllllIIIIlllllllll = new AtomicLongArray(lllllllllllllllllllIIIlIIIIIIIII);
                for (int lllllllllllllllllllIIIlIIIIIIlII = 0; lllllllllllllllllllIIIlIIIIIIlII < lllllllllllllllllllIIIlIIIIIIIII; ++lllllllllllllllllllIIIlIIIIIIlII) {
                    lllllllllllllllllllIIIIlllllllll.set(lllllllllllllllllllIIIlIIIIIIlII, lllllllllllllllllllIIIlIIIIIIIIl.get(lllllllllllllllllllIIIlIIIIIIlII));
                }
                return lllllllllllllllllllIIIIlllllllll;
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllllllllIIIlIIIIlIIlI, final AtomicLongArray lllllllllllllllllllIIIlIIIIlIIIl) throws IOException {
                lllllllllllllllllllIIIlIIIIlIIlI.beginArray();
                for (int lllllllllllllllllllIIIlIIIIlIlIl = 0, lllllllllllllllllllIIIlIIIIlIlII = lllllllllllllllllllIIIlIIIIlIIIl.length(); lllllllllllllllllllIIIlIIIIlIlIl < lllllllllllllllllllIIIlIIIIlIlII; ++lllllllllllllllllllIIIlIIIIlIlIl) {
                    lllllllllllllIIlIllllIllIllIIIII.write(lllllllllllllllllllIIIlIIIIlIIlI, lllllllllllllllllllIIIlIIIIlIIIl.get(lllllllllllllllllllIIIlIIIIlIlIl));
                }
                lllllllllllllllllllIIIlIIIIlIIlI.endArray();
            }
        }.nullSafe();
    }
    
    public <T> T fromJson(final JsonElement lllllllllllllIIlIllllIlIIIIllIlI, final Class<T> lllllllllllllIIlIllllIlIIIIlIlIl) throws JsonSyntaxException {
        final Object lllllllllllllIIlIllllIlIIIIllIII = this.fromJson(lllllllllllllIIlIllllIlIIIIllIlI, (Type)lllllllllllllIIlIllllIlIIIIlIlIl);
        return Primitives.wrap(lllllllllllllIIlIllllIlIIIIlIlIl).cast(lllllllllllllIIlIllllIlIIIIllIII);
    }
    
    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory lllllllllllllIIlIllllIllIIllIIII, final TypeToken<T> lllllllllllllIIlIllllIllIIllIIll) {
        if (!this.factories.contains(lllllllllllllIIlIllllIllIIllIIII)) {
            lllllllllllllIIlIllllIllIIllIIII = this.jsonAdapterFactory;
        }
        boolean lllllllllllllIIlIllllIllIIllIIlI = false;
        for (final TypeAdapterFactory lllllllllllllIIlIllllIllIIllIllI : this.factories) {
            if (!lllllllllllllIIlIllllIllIIllIIlI) {
                if (lllllllllllllIIlIllllIllIIllIllI != lllllllllllllIIlIllllIllIIllIIII) {
                    continue;
                }
                lllllllllllllIIlIllllIllIIllIIlI = true;
            }
            else {
                final TypeAdapter<T> lllllllllllllIIlIllllIllIIllIlll = lllllllllllllIIlIllllIllIIllIllI.create(this, lllllllllllllIIlIllllIllIIllIIll);
                if (lllllllllllllIIlIllllIllIIllIlll != null) {
                    return lllllllllllllIIlIllllIllIIllIlll;
                }
                continue;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("GSON cannot serialize ").append(lllllllllllllIIlIllllIllIIllIIll)));
    }
    
    public JsonWriter newJsonWriter(final Writer lllllllllllllIIlIllllIlIlIlIllII) throws IOException {
        if (this.generateNonExecutableJson) {
            lllllllllllllIIlIllllIlIlIlIllII.write(")]}'\n");
        }
        final JsonWriter lllllllllllllIIlIllllIlIlIlIlIll = new JsonWriter(lllllllllllllIIlIllllIlIlIlIllII);
        if (this.prettyPrinting) {
            lllllllllllllIIlIllllIlIlIlIlIll.setIndent("  ");
        }
        lllllllllllllIIlIllllIlIlIlIlIll.setSerializeNulls(this.serializeNulls);
        return lllllllllllllIIlIllllIlIlIlIlIll;
    }
    
    static class FutureTypeAdapter<T> extends TypeAdapter<T>
    {
        private /* synthetic */ TypeAdapter<T> delegate;
        
        @Override
        public T read(final JsonReader llllllllllllllIIllIIlIIIIIIllllI) throws IOException {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            return this.delegate.read(llllllllllllllIIllIIlIIIIIIllllI);
        }
        
        public void setDelegate(final TypeAdapter<T> llllllllllllllIIllIIlIIIIIlIIlII) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = llllllllllllllIIllIIlIIIIIlIIlII;
        }
        
        @Override
        public void write(final JsonWriter llllllllllllllIIllIIlIIIIIIlIllI, final T llllllllllllllIIllIIlIIIIIIlIlIl) throws IOException {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            this.delegate.write(llllllllllllllIIllIIlIIIIIIlIllI, llllllllllllllIIllIIlIIIIIIlIlIl);
        }
    }
}
