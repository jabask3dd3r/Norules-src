package com.viaversion.viaversion.libs.gson;

import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.bind.*;
import java.sql.*;
import java.util.*;

public final class GsonBuilder
{
    private /* synthetic */ String datePattern;
    private final /* synthetic */ List<TypeAdapterFactory> factories;
    private /* synthetic */ boolean serializeSpecialFloatingPointValues;
    private /* synthetic */ boolean complexMapKeySerialization;
    private /* synthetic */ boolean escapeHtmlChars;
    private /* synthetic */ int dateStyle;
    private final /* synthetic */ List<TypeAdapterFactory> hierarchyFactories;
    private /* synthetic */ boolean lenient;
    private /* synthetic */ boolean prettyPrinting;
    private /* synthetic */ boolean generateNonExecutableJson;
    private /* synthetic */ LongSerializationPolicy longSerializationPolicy;
    private final /* synthetic */ Map<Type, InstanceCreator<?>> instanceCreators;
    private /* synthetic */ boolean serializeNulls;
    private /* synthetic */ FieldNamingStrategy fieldNamingPolicy;
    private /* synthetic */ int timeStyle;
    private /* synthetic */ Excluder excluder;
    
    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }
    
    public GsonBuilder excludeFieldsWithModifiers(final int... llllllllllllIlllllIlllIIIIllllIl) {
        this.excluder = this.excluder.withModifiers(llllllllllllIlllllIlllIIIIllllIl);
        return this;
    }
    
    public GsonBuilder setDateFormat(final int llllllllllllIlllllIllIlllllIllII) {
        this.dateStyle = llllllllllllIlllllIllIlllllIllII;
        this.datePattern = null;
        return this;
    }
    
    GsonBuilder(final Gson llllllllllllIlllllIlllIIIlIIlIll) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap<Type, InstanceCreator<?>>();
        this.factories = new ArrayList<TypeAdapterFactory>();
        this.hierarchyFactories = new ArrayList<TypeAdapterFactory>();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.excluder = llllllllllllIlllllIlllIIIlIIlIll.excluder;
        this.fieldNamingPolicy = llllllllllllIlllllIlllIIIlIIlIll.fieldNamingStrategy;
        this.instanceCreators.putAll(llllllllllllIlllllIlllIIIlIIlIll.instanceCreators);
        this.serializeNulls = llllllllllllIlllllIlllIIIlIIlIll.serializeNulls;
        this.complexMapKeySerialization = llllllllllllIlllllIlllIIIlIIlIll.complexMapKeySerialization;
        this.generateNonExecutableJson = llllllllllllIlllllIlllIIIlIIlIll.generateNonExecutableJson;
        this.escapeHtmlChars = llllllllllllIlllllIlllIIIlIIlIll.htmlSafe;
        this.prettyPrinting = llllllllllllIlllllIlllIIIlIIlIll.prettyPrinting;
        this.lenient = llllllllllllIlllllIlllIIIlIIlIll.lenient;
        this.serializeSpecialFloatingPointValues = llllllllllllIlllllIlllIIIlIIlIll.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = llllllllllllIlllllIlllIIIlIIlIll.longSerializationPolicy;
        this.datePattern = llllllllllllIlllllIlllIIIlIIlIll.datePattern;
        this.dateStyle = llllllllllllIlllllIlllIIIlIIlIll.dateStyle;
        this.timeStyle = llllllllllllIlllllIlllIIIlIIlIll.timeStyle;
        this.factories.addAll(llllllllllllIlllllIlllIIIlIIlIll.builderFactories);
        this.hierarchyFactories.addAll(llllllllllllIlllllIlllIIIlIIlIll.builderHierarchyFactories);
    }
    
    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap<Type, InstanceCreator<?>>();
        this.factories = new ArrayList<TypeAdapterFactory>();
        this.hierarchyFactories = new ArrayList<TypeAdapterFactory>();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
    }
    
    public GsonBuilder registerTypeAdapter(final Type llllllllllllIlllllIllIllllIlllII, final Object llllllllllllIlllllIllIllllIllIll) {
        $Gson$Preconditions.checkArgument(llllllllllllIlllllIllIllllIllIll instanceof JsonSerializer || llllllllllllIlllllIllIllllIllIll instanceof JsonDeserializer || llllllllllllIlllllIllIllllIllIll instanceof InstanceCreator || llllllllllllIlllllIllIllllIllIll instanceof TypeAdapter);
        if (llllllllllllIlllllIllIllllIllIll instanceof InstanceCreator) {
            this.instanceCreators.put(llllllllllllIlllllIllIllllIlllII, (InstanceCreator<?>)llllllllllllIlllllIllIllllIllIll);
        }
        if (llllllllllllIlllllIllIllllIllIll instanceof JsonSerializer || llllllllllllIlllllIllIllllIllIll instanceof JsonDeserializer) {
            final TypeToken<?> llllllllllllIlllllIllIllllIllllI = TypeToken.get(llllllllllllIlllllIllIllllIlllII);
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(llllllllllllIlllllIllIllllIllllI, llllllllllllIlllllIllIllllIllIll));
        }
        if (llllllllllllIlllllIllIllllIllIll instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(llllllllllllIlllllIllIllllIlllII), (TypeAdapter<?>)llllllllllllIlllllIllIllllIllIll));
        }
        return this;
    }
    
    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }
    
    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }
    
    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }
    
    public GsonBuilder setDateFormat(final String llllllllllllIlllllIllIllllllIIlI) {
        this.datePattern = llllllllllllIlllllIllIllllllIIlI;
        return this;
    }
    
    public GsonBuilder setVersion(final double llllllllllllIlllllIlllIIIlIIIlIl) {
        this.excluder = this.excluder.withVersion(llllllllllllIlllllIlllIIIlIIIlIl);
        return this;
    }
    
    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }
    
    public GsonBuilder setLongSerializationPolicy(final LongSerializationPolicy llllllllllllIlllllIlllIIIIlIlIII) {
        this.longSerializationPolicy = llllllllllllIlllllIlllIIIIlIlIII;
        return this;
    }
    
    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }
    
    private void addTypeAdaptersForDate(final String llllllllllllIlllllIllIlllIlIIllI, final int llllllllllllIlllllIllIlllIlIllII, final int llllllllllllIlllllIllIlllIlIIlII, final List<TypeAdapterFactory> llllllllllllIlllllIllIlllIlIIIll) {
        if (llllllllllllIlllllIllIlllIlIIllI != null && !"".equals(llllllllllllIlllllIllIlllIlIIllI.trim())) {
            final DefaultDateTypeAdapter llllllllllllIlllllIllIlllIllIlII = new DefaultDateTypeAdapter(Date.class, llllllllllllIlllllIllIlllIlIIllI);
            final TypeAdapter<Timestamp> llllllllllllIlllllIllIlllIllIIll = (TypeAdapter<Timestamp>)new DefaultDateTypeAdapter(Timestamp.class, llllllllllllIlllllIllIlllIlIIllI);
            final TypeAdapter<java.sql.Date> llllllllllllIlllllIllIlllIllIIlI = (TypeAdapter<java.sql.Date>)new DefaultDateTypeAdapter(java.sql.Date.class, llllllllllllIlllllIllIlllIlIIllI);
        }
        else {
            if (llllllllllllIlllllIllIlllIlIllII == 2 || llllllllllllIlllllIllIlllIlIIlII == 2) {
                return;
            }
            final DefaultDateTypeAdapter llllllllllllIlllllIllIlllIllIIIl = new DefaultDateTypeAdapter(Date.class, llllllllllllIlllllIllIlllIlIllII, llllllllllllIlllllIllIlllIlIIlII);
            final TypeAdapter<Timestamp> llllllllllllIlllllIllIlllIllIIII = (TypeAdapter<Timestamp>)new DefaultDateTypeAdapter(Timestamp.class, llllllllllllIlllllIllIlllIlIllII, llllllllllllIlllllIllIlllIlIIlII);
            final TypeAdapter<java.sql.Date> llllllllllllIlllllIllIlllIlIllll = (TypeAdapter<java.sql.Date>)new DefaultDateTypeAdapter(java.sql.Date.class, llllllllllllIlllllIllIlllIlIllII, llllllllllllIlllllIllIlllIlIIlII);
        }
        final DefaultDateTypeAdapter llllllllllllIlllllIllIlllIlIlIIl;
        llllllllllllIlllllIllIlllIlIIIll.add(TypeAdapters.newFactory(Date.class, llllllllllllIlllllIllIlllIlIlIIl));
        final TypeAdapter<Timestamp> llllllllllllIlllllIllIlllIlIlIII;
        llllllllllllIlllllIllIlllIlIIIll.add(TypeAdapters.newFactory(Timestamp.class, llllllllllllIlllllIllIlllIlIlIII));
        final TypeAdapter<java.sql.Date> llllllllllllIlllllIllIlllIlIIlll;
        llllllllllllIlllllIllIlllIlIIIll.add(TypeAdapters.newFactory(java.sql.Date.class, llllllllllllIlllllIllIlllIlIIlll));
    }
    
    public Gson create() {
        final List<TypeAdapterFactory> llllllllllllIlllllIllIllllIIIIII = new ArrayList<TypeAdapterFactory>(this.factories.size() + this.hierarchyFactories.size() + 3);
        llllllllllllIlllllIllIllllIIIIII.addAll(this.factories);
        Collections.reverse(llllllllllllIlllllIllIllllIIIIII);
        final List<TypeAdapterFactory> llllllllllllIlllllIllIlllIllllll = new ArrayList<TypeAdapterFactory>(this.hierarchyFactories);
        Collections.reverse(llllllllllllIlllllIllIlllIllllll);
        llllllllllllIlllllIllIllllIIIIII.addAll(llllllllllllIlllllIllIlllIllllll);
        this.addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, llllllllllllIlllllIllIllllIIIIII);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, llllllllllllIlllllIllIllllIIIIII);
    }
    
    public GsonBuilder setFieldNamingPolicy(final FieldNamingPolicy llllllllllllIlllllIlllIIIIlIIIlI) {
        this.fieldNamingPolicy = llllllllllllIlllllIlllIIIIlIIIlI;
        return this;
    }
    
    public GsonBuilder setDateFormat(final int llllllllllllIlllllIllIlllllIIlII, final int llllllllllllIlllllIllIlllllIIIll) {
        this.dateStyle = llllllllllllIlllllIllIlllllIIlII;
        this.timeStyle = llllllllllllIlllllIllIlllllIIIll;
        this.datePattern = null;
        return this;
    }
    
    public GsonBuilder setFieldNamingStrategy(final FieldNamingStrategy llllllllllllIlllllIlllIIIIIllllI) {
        this.fieldNamingPolicy = llllllllllllIlllllIlllIIIIIllllI;
        return this;
    }
    
    public GsonBuilder addDeserializationExclusionStrategy(final ExclusionStrategy llllllllllllIlllllIlllIIIIIIIIIl) {
        this.excluder = this.excluder.withExclusionStrategy(llllllllllllIlllllIlllIIIIIIIIIl, false, true);
        return this;
    }
    
    public GsonBuilder registerTypeAdapterFactory(final TypeAdapterFactory llllllllllllIlllllIllIllllIlIIll) {
        this.factories.add(llllllllllllIlllllIllIllllIlIIll);
        return this;
    }
    
    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }
    
    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }
    
    public GsonBuilder registerTypeHierarchyAdapter(final Class<?> llllllllllllIlllllIllIllllIIlIIl, final Object llllllllllllIlllllIllIllllIIlIII) {
        $Gson$Preconditions.checkArgument(llllllllllllIlllllIllIllllIIlIII instanceof JsonSerializer || llllllllllllIlllllIllIllllIIlIII instanceof JsonDeserializer || llllllllllllIlllllIllIllllIIlIII instanceof TypeAdapter);
        if (llllllllllllIlllllIllIllllIIlIII instanceof JsonDeserializer || llllllllllllIlllllIllIllllIIlIII instanceof JsonSerializer) {
            this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(llllllllllllIlllllIllIllllIIlIIl, llllllllllllIlllllIllIllllIIlIII));
        }
        if (llllllllllllIlllllIllIllllIIlIII instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(llllllllllllIlllllIllIllllIIlIIl, (TypeAdapter<?>)llllllllllllIlllllIllIllllIIlIII));
        }
        return this;
    }
    
    public GsonBuilder addSerializationExclusionStrategy(final ExclusionStrategy llllllllllllIlllllIlllIIIIIIlIIl) {
        this.excluder = this.excluder.withExclusionStrategy(llllllllllllIlllllIlllIIIIIIlIIl, true, false);
        return this;
    }
    
    public GsonBuilder setExclusionStrategies(final ExclusionStrategy... llllllllllllIlllllIlllIIIIIlIIIl) {
        final byte llllllllllllIlllllIlllIIIIIlIIII = (Object)llllllllllllIlllllIlllIIIIIlIIIl;
        final byte llllllllllllIlllllIlllIIIIIIllll = (byte)llllllllllllIlllllIlllIIIIIlIIII.length;
        for (Exception llllllllllllIlllllIlllIIIIIIlllI = (Exception)0; llllllllllllIlllllIlllIIIIIIlllI < llllllllllllIlllllIlllIIIIIIllll; ++llllllllllllIlllllIlllIIIIIIlllI) {
            final ExclusionStrategy llllllllllllIlllllIlllIIIIIlIlIl = llllllllllllIlllllIlllIIIIIlIIII[llllllllllllIlllllIlllIIIIIIlllI];
            this.excluder = this.excluder.withExclusionStrategy(llllllllllllIlllllIlllIIIIIlIlIl, true, true);
        }
        return this;
    }
    
    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }
}
