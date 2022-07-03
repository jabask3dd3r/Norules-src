package com.viaversion.viaversion.libs.gson.internal.bind;

import java.math.*;
import java.util.concurrent.atomic.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.net.*;
import java.sql.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.annotations.*;

public final class TypeAdapters
{
    public static final /* synthetic */ TypeAdapter<BitSet> BIT_SET;
    public static final /* synthetic */ TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final /* synthetic */ TypeAdapter<Number> SHORT;
    public static final /* synthetic */ TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final /* synthetic */ TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final /* synthetic */ TypeAdapter<Boolean> BOOLEAN;
    public static final /* synthetic */ TypeAdapter<Calendar> CALENDAR;
    public static final /* synthetic */ TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final /* synthetic */ TypeAdapter<Currency> CURRENCY;
    public static final /* synthetic */ TypeAdapter<String> STRING;
    public static final /* synthetic */ TypeAdapter<Character> CHARACTER;
    public static final /* synthetic */ TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final /* synthetic */ TypeAdapter<Number> BYTE;
    public static final /* synthetic */ TypeAdapter<UUID> UUID;
    public static final /* synthetic */ TypeAdapter<URI> URI;
    public static final /* synthetic */ TypeAdapter<Locale> LOCALE;
    public static final /* synthetic */ TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final /* synthetic */ TypeAdapter<Class> CLASS;
    public static final /* synthetic */ TypeAdapter<InetAddress> INET_ADDRESS;
    public static final /* synthetic */ TypeAdapter<Number> NUMBER;
    public static final /* synthetic */ TypeAdapter<Number> INTEGER;
    public static final /* synthetic */ TypeAdapter<URL> URL;
    
    public static <TT> TypeAdapterFactory newFactory(final Class<TT> lllllllllllllIlIllllIlllIIIIIIlI, final Class<TT> lllllllllllllIlIllllIlllIIIIIlII, final TypeAdapter<? super TT> lllllllllllllIlIllllIlllIIIIIIll) {
        return new TypeAdapterFactory() {
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append("Factory[type=").append(lllllllllllllIlIllllIlllIIIIIlII.getName()).append("+").append(lllllllllllllIlIllllIlllIIIIIIlI.getName()).append(",adapter=").append(lllllllllllllIlIllllIlllIIIIIIll).append("]"));
            }
            
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllllIllIIlIllllIIllIl, final TypeToken<T> lllllllllllllllIllIIlIllllIIlIIl) {
                final Class<? super T> lllllllllllllllIllIIlIllllIIlIll = lllllllllllllllIllIIlIllllIIlIIl.getRawType();
                return (TypeAdapter<T>)((lllllllllllllllIllIIlIllllIIlIll == lllllllllllllIlIllllIlllIIIIIIlI || lllllllllllllllIllIIlIllllIIlIll == lllllllllllllIlIllllIlllIIIIIlII) ? lllllllllllllIlIllllIlllIIIIIIll : null);
            }
        };
    }
    
    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> lllllllllllllIlIllllIlllIIIlIIII, final TypeAdapter<TT> lllllllllllllIlIllllIlllIIIlIIIl) {
        return new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllIlIIlllllllIIIlIllI, final TypeToken<T> lllllllllllllIlIIlllllllIIIlIIll) {
                return (TypeAdapter<T>)(lllllllllllllIlIIlllllllIIIlIIll.equals(lllllllllllllIlIllllIlllIIIlIIII) ? lllllllllllllIlIllllIlllIIIlIIIl : null);
            }
        };
    }
    
    public static <TT> TypeAdapterFactory newFactory(final Class<TT> lllllllllllllIlIllllIlllIIIIllII, final TypeAdapter<TT> lllllllllllllIlIllllIlllIIIIlIIl) {
        return new TypeAdapterFactory() {
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append("Factory[type=").append(lllllllllllllIlIllllIlllIIIIllII.getName()).append(",adapter=").append(lllllllllllllIlIllllIlllIIIIlIIl).append("]"));
            }
            
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllIIlllIIlIIIIIllllll, final TypeToken<T> lllllllllllllIIlllIIlIIIIIlllIll) {
                return (TypeAdapter<T>)((lllllllllllllIIlllIIlIIIIIlllIll.getRawType() == lllllllllllllIlIllllIlllIIIIllII) ? lllllllllllllIlIllllIlllIIIIlIIl : null);
            }
        };
    }
    
    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }
    
    static {
        CLASS = new TypeAdapter<Class>() {
            @Override
            public Class read(final JsonReader lllllllllllllIlIIllIlllIlIIIIIlI) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIlIIllIlllIlIIIIllI, final Class lllllllllllllIlIIllIlllIlIIIIlIl) throws IOException {
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Attempted to serialize java.lang.Class: ").append(lllllllllllllIlIIllIlllIlIIIIlIl.getName()).append(". Forgot to register a type adapter?")));
            }
        }.nullSafe();
        CLASS_FACTORY = newFactory(Class.class, TypeAdapters.CLASS);
        BIT_SET = new TypeAdapter<BitSet>() {
            @Override
            public BitSet read(final JsonReader llllllllllllllIlIllIllIlIlllllll) throws IOException {
                final BitSet llllllllllllllIlIllIllIllIIIIIlI = new BitSet();
                llllllllllllllIlIllIllIlIlllllll.beginArray();
                int llllllllllllllIlIllIllIllIIIIIIl = 0;
                for (JsonToken llllllllllllllIlIllIllIllIIIIIII = llllllllllllllIlIllIllIlIlllllll.peek(); llllllllllllllIlIllIllIllIIIIIII != JsonToken.END_ARRAY; llllllllllllllIlIllIllIllIIIIIII = llllllllllllllIlIllIllIlIlllllll.peek()) {
                    switch (llllllllllllllIlIllIllIllIIIIIII) {
                        case NUMBER: {
                            final boolean llllllllllllllIlIllIllIllIIIlIlI = llllllllllllllIlIllIllIlIlllllll.nextInt() != 0;
                            break;
                        }
                        case BOOLEAN: {
                            final boolean llllllllllllllIlIllIllIllIIIlIIl = llllllllllllllIlIllIllIlIlllllll.nextBoolean();
                            break;
                        }
                        case STRING: {
                            final String llllllllllllllIlIllIllIllIIIIllI = llllllllllllllIlIllIllIlIlllllll.nextString();
                            try {
                                final boolean llllllllllllllIlIllIllIllIIIlIII = Integer.parseInt(llllllllllllllIlIllIllIllIIIIllI) != 0;
                                break;
                            }
                            catch (NumberFormatException llllllllllllllIlIllIllIllIIIIlll) {
                                throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("Error: Expecting: bitset number value (1, 0), Found: ").append(llllllllllllllIlIllIllIllIIIIllI)));
                            }
                            throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("Invalid bitset value type: ").append(llllllllllllllIlIllIllIllIIIIIII)));
                        }
                    }
                    final boolean llllllllllllllIlIllIllIllIIIIlIl;
                    if (llllllllllllllIlIllIllIllIIIIlIl) {
                        llllllllllllllIlIllIllIllIIIIIlI.set(llllllllllllllIlIllIllIllIIIIIIl);
                    }
                    ++llllllllllllllIlIllIllIllIIIIIIl;
                }
                llllllllllllllIlIllIllIlIlllllll.endArray();
                return llllllllllllllIlIllIllIllIIIIIlI;
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllIlIllIllIlIllIllll, final BitSet llllllllllllllIlIllIllIlIllIlllI) throws IOException {
                llllllllllllllIlIllIllIlIllIllll.beginArray();
                for (int llllllllllllllIlIllIllIlIlllIIlI = 0, llllllllllllllIlIllIllIlIlllIIIl = llllllllllllllIlIllIllIlIllIlllI.length(); llllllllllllllIlIllIllIlIlllIIlI < llllllllllllllIlIllIllIlIlllIIIl; ++llllllllllllllIlIllIllIlIlllIIlI) {
                    final int llllllllllllllIlIllIllIlIlllIIll = llllllllllllllIlIllIllIlIllIlllI.get(llllllllllllllIlIllIllIlIlllIIlI) ? 1 : 0;
                    llllllllllllllIlIllIllIlIllIllll.value(llllllllllllllIlIllIllIlIlllIIll);
                }
                llllllllllllllIlIllIllIlIllIllll.endArray();
            }
        }.nullSafe();
        BIT_SET_FACTORY = newFactory(BitSet.class, TypeAdapters.BIT_SET);
        BOOLEAN = new TypeAdapter<Boolean>() {
            @Override
            public Boolean read(final JsonReader llllllllllllllIlIllIIIllllIIlIll) throws IOException {
                final JsonToken llllllllllllllIlIllIIIllllIIlIlI = llllllllllllllIlIllIIIllllIIlIll.peek();
                if (llllllllllllllIlIllIIIllllIIlIlI == JsonToken.NULL) {
                    llllllllllllllIlIllIIIllllIIlIll.nextNull();
                    return null;
                }
                if (llllllllllllllIlIllIIIllllIIlIlI == JsonToken.STRING) {
                    return Boolean.parseBoolean(llllllllllllllIlIllIIIllllIIlIll.nextString());
                }
                return llllllllllllllIlIllIIIllllIIlIll.nextBoolean();
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllIlIllIIIllllIIIlII, final Boolean llllllllllllllIlIllIIIllllIIIIll) throws IOException {
                llllllllllllllIlIllIIIllllIIIlII.value(llllllllllllllIlIllIIIllllIIIIll);
            }
        };
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() {
            @Override
            public Boolean read(final JsonReader lllllllllllllIIIIlllIIIIIlIIllII) throws IOException {
                if (lllllllllllllIIIIlllIIIIIlIIllII.peek() == JsonToken.NULL) {
                    lllllllllllllIIIIlllIIIIIlIIllII.nextNull();
                    return null;
                }
                return Boolean.valueOf(lllllllllllllIIIIlllIIIIIlIIllII.nextString());
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIIIlllIIIIIlIIlIII, final Boolean lllllllllllllIIIIlllIIIIIlIIIlIl) throws IOException {
                lllllllllllllIIIIlllIIIIIlIIlIII.value((lllllllllllllIIIIlllIIIIIlIIIlIl == null) ? "null" : lllllllllllllIIIIlllIIIIIlIIIlIl.toString());
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, TypeAdapters.BOOLEAN);
        BYTE = new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter lllIlIllIllIIlI, final Number lllIlIllIlIllll) throws IOException {
                lllIlIllIllIIlI.value(lllIlIllIlIllll);
            }
            
            @Override
            public Number read(final JsonReader lllIlIllIllIlll) throws IOException {
                if (lllIlIllIllIlll.peek() == JsonToken.NULL) {
                    lllIlIllIllIlll.nextNull();
                    return null;
                }
                try {
                    final int lllIlIllIlllIll = lllIlIllIllIlll.nextInt();
                    return (byte)lllIlIllIlllIll;
                }
                catch (NumberFormatException lllIlIllIlllIlI) {
                    throw new JsonSyntaxException(lllIlIllIlllIlI);
                }
            }
        };
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, TypeAdapters.BYTE);
        SHORT = new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter llllllllllllllIIllIIIIIlIlllIIII, final Number llllllllllllllIIllIIIIIlIllIllIl) throws IOException {
                llllllllllllllIIllIIIIIlIlllIIII.value(llllllllllllllIIllIIIIIlIllIllIl);
            }
            
            @Override
            public Number read(final JsonReader llllllllllllllIIllIIIIIlIlllIllI) throws IOException {
                if (llllllllllllllIIllIIIIIlIlllIllI.peek() == JsonToken.NULL) {
                    llllllllllllllIIllIIIIIlIlllIllI.nextNull();
                    return null;
                }
                try {
                    return (short)llllllllllllllIIllIIIIIlIlllIllI.nextInt();
                }
                catch (NumberFormatException llllllllllllllIIllIIIIIlIllllIII) {
                    throw new JsonSyntaxException(llllllllllllllIIllIIIIIlIllllIII);
                }
            }
        };
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, TypeAdapters.SHORT);
        INTEGER = new TypeAdapter<Number>() {
            @Override
            public Number read(final JsonReader llllllllllllllIlIlIlIllIIllIIIIl) throws IOException {
                if (llllllllllllllIlIlIlIllIIllIIIIl.peek() == JsonToken.NULL) {
                    llllllllllllllIlIlIlIllIIllIIIIl.nextNull();
                    return null;
                }
                try {
                    return llllllllllllllIlIlIlIllIIllIIIIl.nextInt();
                }
                catch (NumberFormatException llllllllllllllIlIlIlIllIIllIIIll) {
                    throw new JsonSyntaxException(llllllllllllllIlIlIlIllIIllIIIll);
                }
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllIlIlIlIllIIlIllIIl, final Number llllllllllllllIlIlIlIllIIlIllIII) throws IOException {
                llllllllllllllIlIlIlIllIIlIllIIl.value(llllllllllllllIlIlIlIllIIlIllIII);
            }
        };
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, TypeAdapters.INTEGER);
        ATOMIC_INTEGER = new TypeAdapter<AtomicInteger>() {
            @Override
            public AtomicInteger read(final JsonReader lllllllllllllIIlIIIIlllllllIIlll) throws IOException {
                try {
                    return new AtomicInteger(lllllllllllllIIlIIIIlllllllIIlll.nextInt());
                }
                catch (NumberFormatException lllllllllllllIIlIIIIlllllllIlIIl) {
                    throw new JsonSyntaxException(lllllllllllllIIlIIIIlllllllIlIIl);
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIlIIIIllllllIlllll, final AtomicInteger lllllllllllllIIlIIIIllllllIllllI) throws IOException {
                lllllllllllllIIlIIIIllllllIlllll.value(lllllllllllllIIlIIIIllllllIllllI.get());
            }
        }.nullSafe();
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, TypeAdapters.ATOMIC_INTEGER);
        ATOMIC_BOOLEAN = new TypeAdapter<AtomicBoolean>() {
            @Override
            public void write(final JsonWriter lllllllllllllIlIlIIIIlIlllllIlIl, final AtomicBoolean lllllllllllllIlIlIIIIlIlllllIlII) throws IOException {
                lllllllllllllIlIlIIIIlIlllllIlIl.value(lllllllllllllIlIlIIIIlIlllllIlII.get());
            }
            
            @Override
            public AtomicBoolean read(final JsonReader lllllllllllllIlIlIIIIlIllllllIIl) throws IOException {
                return new AtomicBoolean(lllllllllllllIlIlIIIIlIllllllIIl.nextBoolean());
            }
        }.nullSafe();
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, TypeAdapters.ATOMIC_BOOLEAN);
        ATOMIC_INTEGER_ARRAY = new TypeAdapter<AtomicIntegerArray>() {
            @Override
            public void write(final JsonWriter lllllllllllllIIIlIIIIIIlllIlllll, final AtomicIntegerArray lllllllllllllIIIlIIIIIIllllIIIII) throws IOException {
                lllllllllllllIIIlIIIIIIlllIlllll.beginArray();
                for (int lllllllllllllIIIlIIIIIIllllIIlII = 0, lllllllllllllIIIlIIIIIIllllIIIll = lllllllllllllIIIlIIIIIIllllIIIII.length(); lllllllllllllIIIlIIIIIIllllIIlII < lllllllllllllIIIlIIIIIIllllIIIll; ++lllllllllllllIIIlIIIIIIllllIIlII) {
                    lllllllllllllIIIlIIIIIIlllIlllll.value(lllllllllllllIIIlIIIIIIllllIIIII.get(lllllllllllllIIIlIIIIIIllllIIlII));
                }
                lllllllllllllIIIlIIIIIIlllIlllll.endArray();
            }
            
            @Override
            public AtomicIntegerArray read(final JsonReader lllllllllllllIIIlIIIIIIllllIllIl) throws IOException {
                final List<Integer> lllllllllllllIIIlIIIIIIlllllIIII = new ArrayList<Integer>();
                lllllllllllllIIIlIIIIIIllllIllIl.beginArray();
                while (lllllllllllllIIIlIIIIIIllllIllIl.hasNext()) {
                    try {
                        final int lllllllllllllIIIlIIIIIIlllllIlIl = lllllllllllllIIIlIIIIIIllllIllIl.nextInt();
                        lllllllllllllIIIlIIIIIIlllllIIII.add(lllllllllllllIIIlIIIIIIlllllIlIl);
                        continue;
                    }
                    catch (NumberFormatException lllllllllllllIIIlIIIIIIlllllIlII) {
                        throw new JsonSyntaxException(lllllllllllllIIIlIIIIIIlllllIlII);
                    }
                    break;
                }
                lllllllllllllIIIlIIIIIIllllIllIl.endArray();
                final int lllllllllllllIIIlIIIIIIllllIllll = lllllllllllllIIIlIIIIIIlllllIIII.size();
                final AtomicIntegerArray lllllllllllllIIIlIIIIIIllllIlllI = new AtomicIntegerArray(lllllllllllllIIIlIIIIIIllllIllll);
                for (int lllllllllllllIIIlIIIIIIlllllIIll = 0; lllllllllllllIIIlIIIIIIlllllIIll < lllllllllllllIIIlIIIIIIllllIllll; ++lllllllllllllIIIlIIIIIIlllllIIll) {
                    lllllllllllllIIIlIIIIIIllllIlllI.set(lllllllllllllIIIlIIIIIIlllllIIll, lllllllllllllIIIlIIIIIIlllllIIII.get(lllllllllllllIIIlIIIIIIlllllIIll));
                }
                return lllllllllllllIIIlIIIIIIllllIlllI;
            }
        }.nullSafe();
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, TypeAdapters.ATOMIC_INTEGER_ARRAY);
        LONG = new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter lllllllllllllIlllllIIlIIIllIllII, final Number lllllllllllllIlllllIIlIIIllIlIll) throws IOException {
                lllllllllllllIlllllIIlIIIllIllII.value(lllllllllllllIlllllIIlIIIllIlIll);
            }
            
            @Override
            public Number read(final JsonReader lllllllllllllIlllllIIlIIIlllIIIl) throws IOException {
                if (lllllllllllllIlllllIIlIIIlllIIIl.peek() == JsonToken.NULL) {
                    lllllllllllllIlllllIIlIIIlllIIIl.nextNull();
                    return null;
                }
                try {
                    return lllllllllllllIlllllIIlIIIlllIIIl.nextLong();
                }
                catch (NumberFormatException lllllllllllllIlllllIIlIIIlllIlII) {
                    throw new JsonSyntaxException(lllllllllllllIlllllIIlIIIlllIlII);
                }
            }
        };
        FLOAT = new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter llllllllllllllIIlIlIlIlIIllIlIII, final Number llllllllllllllIIlIlIlIlIIllIIlll) throws IOException {
                llllllllllllllIIlIlIlIlIIllIlIII.value(llllllllllllllIIlIlIlIlIIllIIlll);
            }
            
            @Override
            public Number read(final JsonReader llllllllllllllIIlIlIlIlIIllIllIl) throws IOException {
                if (llllllllllllllIIlIlIlIlIIllIllIl.peek() == JsonToken.NULL) {
                    llllllllllllllIIlIlIlIlIIllIllIl.nextNull();
                    return null;
                }
                return (float)llllllllllllllIIlIlIlIlIIllIllIl.nextDouble();
            }
        };
        DOUBLE = new TypeAdapter<Number>() {
            @Override
            public void write(final JsonWriter lllllllllllllIIlIllIllIllIIllIll, final Number lllllllllllllIIlIllIllIllIIllIlI) throws IOException {
                lllllllllllllIIlIllIllIllIIllIll.value(lllllllllllllIIlIllIllIllIIllIlI);
            }
            
            @Override
            public Number read(final JsonReader lllllllllllllIIlIllIllIllIlIIIlI) throws IOException {
                if (lllllllllllllIIlIllIllIllIlIIIlI.peek() == JsonToken.NULL) {
                    lllllllllllllIIlIllIllIllIlIIIlI.nextNull();
                    return null;
                }
                return lllllllllllllIIlIllIllIllIlIIIlI.nextDouble();
            }
        };
        NUMBER = new TypeAdapter<Number>() {
            @Override
            public Number read(final JsonReader lllllllllllllIIlIllIIllIIlIlIIll) throws IOException {
                final JsonToken lllllllllllllIIlIllIIllIIlIlIlII = lllllllllllllIIlIllIIllIIlIlIIll.peek();
                switch (lllllllllllllIIlIllIIllIIlIlIlII) {
                    case NULL: {
                        lllllllllllllIIlIllIIllIIlIlIIll.nextNull();
                        return null;
                    }
                    case NUMBER:
                    case STRING: {
                        return new LazilyParsedNumber(lllllllllllllIIlIllIIllIIlIlIIll.nextString());
                    }
                    default: {
                        throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("Expecting number, got: ").append(lllllllllllllIIlIllIIllIIlIlIlII)));
                    }
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIlIllIIllIIlIIlllI, final Number lllllllllllllIIlIllIIllIIlIIllIl) throws IOException {
                lllllllllllllIIlIllIIllIIlIIlllI.value(lllllllllllllIIlIllIIllIIlIIllIl);
            }
        };
        NUMBER_FACTORY = newFactory(Number.class, TypeAdapters.NUMBER);
        CHARACTER = new TypeAdapter<Character>() {
            @Override
            public Character read(final JsonReader lllllllllllllllIlllIlIIllIIIllll) throws IOException {
                if (lllllllllllllllIlllIlIIllIIIllll.peek() == JsonToken.NULL) {
                    lllllllllllllllIlllIlIIllIIIllll.nextNull();
                    return null;
                }
                final String lllllllllllllllIlllIlIIllIIIllII = lllllllllllllllIlllIlIIllIIIllll.nextString();
                if (lllllllllllllllIlllIlIIllIIIllII.length() != 1) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("Expecting character, got: ").append(lllllllllllllllIlllIlIIllIIIllII)));
                }
                return lllllllllllllllIlllIlIIllIIIllII.charAt(0);
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllllIlllIlIIlIllllIIl, final Character lllllllllllllllIlllIlIIlIllllIll) throws IOException {
                lllllllllllllllIlllIlIIlIllllIIl.value((lllllllllllllllIlllIlIIlIllllIll == null) ? null : String.valueOf(lllllllllllllllIlllIlIIlIllllIll));
            }
        };
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, TypeAdapters.CHARACTER);
        STRING = new TypeAdapter<String>() {
            @Override
            public String read(final JsonReader lllllIIIllIllll) throws IOException {
                final JsonToken lllllIIIllIlllI = lllllIIIllIllll.peek();
                if (lllllIIIllIlllI == JsonToken.NULL) {
                    lllllIIIllIllll.nextNull();
                    return null;
                }
                if (lllllIIIllIlllI == JsonToken.BOOLEAN) {
                    return Boolean.toString(lllllIIIllIllll.nextBoolean());
                }
                return lllllIIIllIllll.nextString();
            }
            
            @Override
            public void write(final JsonWriter lllllIIIllIIllI, final String lllllIIIllIIlIl) throws IOException {
                lllllIIIllIIllI.value(lllllIIIllIIlIl);
            }
        };
        BIG_DECIMAL = new TypeAdapter<BigDecimal>() {
            @Override
            public BigDecimal read(final JsonReader lllllllllllllllIlIlllllIIlIlIIII) throws IOException {
                if (lllllllllllllllIlIlllllIIlIlIIII.peek() == JsonToken.NULL) {
                    lllllllllllllllIlIlllllIIlIlIIII.nextNull();
                    return null;
                }
                try {
                    return new BigDecimal(lllllllllllllllIlIlllllIIlIlIIII.nextString());
                }
                catch (NumberFormatException lllllllllllllllIlIlllllIIlIlIIlI) {
                    throw new JsonSyntaxException(lllllllllllllllIlIlllllIIlIlIIlI);
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllllIlIlllllIIlIIlIlI, final BigDecimal lllllllllllllllIlIlllllIIlIIIlll) throws IOException {
                lllllllllllllllIlIlllllIIlIIlIlI.value(lllllllllllllllIlIlllllIIlIIIlll);
            }
        };
        BIG_INTEGER = new TypeAdapter<BigInteger>() {
            @Override
            public BigInteger read(final JsonReader lllllllllllllIIlIlIlIIlllllIIlII) throws IOException {
                if (lllllllllllllIIlIlIlIIlllllIIlII.peek() == JsonToken.NULL) {
                    lllllllllllllIIlIlIlIIlllllIIlII.nextNull();
                    return null;
                }
                try {
                    return new BigInteger(lllllllllllllIIlIlIlIIlllllIIlII.nextString());
                }
                catch (NumberFormatException lllllllllllllIIlIlIlIIlllllIIlll) {
                    throw new JsonSyntaxException(lllllllllllllIIlIlIlIIlllllIIlll);
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIlIlIlIIllllIlllll, final BigInteger lllllllllllllIIlIlIlIIllllIlllII) throws IOException {
                lllllllllllllIIlIlIlIIllllIlllll.value(lllllllllllllIIlIlIlIIllllIlllII);
            }
        };
        STRING_FACTORY = newFactory(String.class, TypeAdapters.STRING);
        STRING_BUILDER = new TypeAdapter<StringBuilder>() {
            @Override
            public StringBuilder read(final JsonReader llllllllllllllIllIlllIIlIllIIlII) throws IOException {
                if (llllllllllllllIllIlllIIlIllIIlII.peek() == JsonToken.NULL) {
                    llllllllllllllIllIlllIIlIllIIlII.nextNull();
                    return null;
                }
                return new StringBuilder(llllllllllllllIllIlllIIlIllIIlII.nextString());
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllIllIlllIIlIlIllllI, final StringBuilder llllllllllllllIllIlllIIlIlIlllll) throws IOException {
                llllllllllllllIllIlllIIlIlIllllI.value((llllllllllllllIllIlllIIlIlIlllll == null) ? null : String.valueOf(llllllllllllllIllIlllIIlIlIlllll));
            }
        };
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, TypeAdapters.STRING_BUILDER);
        STRING_BUFFER = new TypeAdapter<StringBuffer>() {
            @Override
            public StringBuffer read(final JsonReader lllllllllllllIIllllIlIlIlllIIllI) throws IOException {
                if (lllllllllllllIIllllIlIlIlllIIllI.peek() == JsonToken.NULL) {
                    lllllllllllllIIllllIlIlIlllIIllI.nextNull();
                    return null;
                }
                return new StringBuffer(lllllllllllllIIllllIlIlIlllIIllI.nextString());
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIllllIlIlIlllIIIII, final StringBuffer lllllllllllllIIllllIlIlIllIlllll) throws IOException {
                lllllllllllllIIllllIlIlIlllIIIII.value((lllllllllllllIIllllIlIlIllIlllll == null) ? null : lllllllllllllIIllllIlIlIllIlllll.toString());
            }
        };
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, TypeAdapters.STRING_BUFFER);
        URL = new TypeAdapter<URL>() {
            @Override
            public URL read(final JsonReader llllllllllllIlllllIlIIIIIlIIllll) throws IOException {
                if (llllllllllllIlllllIlIIIIIlIIllll.peek() == JsonToken.NULL) {
                    llllllllllllIlllllIlIIIIIlIIllll.nextNull();
                    return null;
                }
                final String llllllllllllIlllllIlIIIIIlIIlllI = llllllllllllIlllllIlIIIIIlIIllll.nextString();
                return "null".equals(llllllllllllIlllllIlIIIIIlIIlllI) ? null : new URL(llllllllllllIlllllIlIIIIIlIIlllI);
            }
            
            @Override
            public void write(final JsonWriter llllllllllllIlllllIlIIIIIlIIIllI, final URL llllllllllllIlllllIlIIIIIlIIIlIl) throws IOException {
                llllllllllllIlllllIlIIIIIlIIIllI.value((llllllllllllIlllllIlIIIIIlIIIlIl == null) ? null : llllllllllllIlllllIlIIIIIlIIIlIl.toExternalForm());
            }
        };
        URL_FACTORY = newFactory(URL.class, TypeAdapters.URL);
        URI = new TypeAdapter<URI>() {
            @Override
            public URI read(final JsonReader lllllllllllllIIlllIllllllIIIIllI) throws IOException {
                if (lllllllllllllIIlllIllllllIIIIllI.peek() == JsonToken.NULL) {
                    lllllllllllllIIlllIllllllIIIIllI.nextNull();
                    return null;
                }
                try {
                    final String lllllllllllllIIlllIllllllIIIlIIl = lllllllllllllIIlllIllllllIIIIllI.nextString();
                    return "null".equals(lllllllllllllIIlllIllllllIIIlIIl) ? null : new URI(lllllllllllllIIlllIllllllIIIlIIl);
                }
                catch (URISyntaxException lllllllllllllIIlllIllllllIIIlIII) {
                    throw new JsonIOException(lllllllllllllIIlllIllllllIIIlIII);
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIlllIllllllIIIIIII, final URI lllllllllllllIIlllIlllllIlllllIl) throws IOException {
                lllllllllllllIIlllIllllllIIIIIII.value((lllllllllllllIIlllIlllllIlllllIl == null) ? null : lllllllllllllIIlllIlllllIlllllIl.toASCIIString());
            }
        };
        URI_FACTORY = newFactory(URI.class, TypeAdapters.URI);
        INET_ADDRESS = new TypeAdapter<InetAddress>() {
            @Override
            public InetAddress read(final JsonReader lllllllllllllIllllllIIIIIIIlIlll) throws IOException {
                if (lllllllllllllIllllllIIIIIIIlIlll.peek() == JsonToken.NULL) {
                    lllllllllllllIllllllIIIIIIIlIlll.nextNull();
                    return null;
                }
                return InetAddress.getByName(lllllllllllllIllllllIIIIIIIlIlll.nextString());
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIllllllIIIIIIIlIIll, final InetAddress lllllllllllllIllllllIIIIIIIlIIlI) throws IOException {
                lllllllllllllIllllllIIIIIIIlIIll.value((lllllllllllllIllllllIIIIIIIlIIlI == null) ? null : lllllllllllllIllllllIIIIIIIlIIlI.getHostAddress());
            }
        };
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, TypeAdapters.INET_ADDRESS);
        UUID = new TypeAdapter<UUID>() {
            @Override
            public UUID read(final JsonReader lllllllllllllllIIIlIlllIIIllIlIl) throws IOException {
                if (lllllllllllllllIIIlIlllIIIllIlIl.peek() == JsonToken.NULL) {
                    lllllllllllllllIIIlIlllIIIllIlIl.nextNull();
                    return null;
                }
                return java.util.UUID.fromString(lllllllllllllllIIIlIlllIIIllIlIl.nextString());
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllllIIIlIlllIIIllIIII, final UUID lllllllllllllllIIIlIlllIIIlIllIl) throws IOException {
                lllllllllllllllIIIlIlllIIIllIIII.value((lllllllllllllllIIIlIlllIIIlIllIl == null) ? null : lllllllllllllllIIIlIlllIIIlIllIl.toString());
            }
        };
        UUID_FACTORY = newFactory(UUID.class, TypeAdapters.UUID);
        CURRENCY = new TypeAdapter<Currency>() {
            @Override
            public void write(final JsonWriter llllllllllllIlllllIIIllllIlllllI, final Currency llllllllllllIlllllIIIllllIllllll) throws IOException {
                llllllllllllIlllllIIIllllIlllllI.value(llllllllllllIlllllIIIllllIllllll.getCurrencyCode());
            }
            
            @Override
            public Currency read(final JsonReader llllllllllllIlllllIIIlllllIIIlII) throws IOException {
                return Currency.getInstance(llllllllllllIlllllIIIlllllIIIlII.nextString());
            }
        }.nullSafe();
        CURRENCY_FACTORY = newFactory(Currency.class, TypeAdapters.CURRENCY);
        TIMESTAMP_FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllllIIlIIlIIllllIlIlI, final TypeToken<T> lllllllllllllllIIlIIlIIllllIllIl) {
                if (lllllllllllllllIIlIIlIIllllIllIl.getRawType() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter<Date> lllllllllllllllIIlIIlIIllllIllII = lllllllllllllllIIlIIlIIllllIlIlI.getAdapter(Date.class);
                return (TypeAdapter<T>)new TypeAdapter<Timestamp>() {
                    @Override
                    public void write(final JsonWriter lllllllllllllIIIlIIIIIIIIIIlIlll, final Timestamp lllllllllllllIIIlIIIIIIIIIIllIIl) throws IOException {
                        lllllllllllllllIIlIIlIIllllIllII.write(lllllllllllllIIIlIIIIIIIIIIlIlll, lllllllllllllIIIlIIIIIIIIIIllIIl);
                    }
                    
                    @Override
                    public Timestamp read(final JsonReader lllllllllllllIIIlIIIIIIIIIlIIIll) throws IOException {
                        final Date lllllllllllllIIIlIIIIIIIIIlIIIlI = lllllllllllllllIIlIIlIIllllIllII.read(lllllllllllllIIIlIIIIIIIIIlIIIll);
                        return (lllllllllllllIIIlIIIIIIIIIlIIIlI != null) ? new Timestamp(lllllllllllllIIIlIIIIIIIIIlIIIlI.getTime()) : null;
                    }
                };
            }
        };
        CALENDAR = new TypeAdapter<Calendar>() {
            static {
                HOUR_OF_DAY = "hourOfDay";
                SECOND = "second";
                DAY_OF_MONTH = "dayOfMonth";
                MINUTE = "minute";
                MONTH = "month";
                YEAR = "year";
            }
            
            @Override
            public Calendar read(final JsonReader llllllllllllllIIIIIIIlIlIIIIlIlI) throws IOException {
                if (llllllllllllllIIIIIIIlIlIIIIlIlI.peek() == JsonToken.NULL) {
                    llllllllllllllIIIIIIIlIlIIIIlIlI.nextNull();
                    return null;
                }
                llllllllllllllIIIIIIIlIlIIIIlIlI.beginObject();
                int llllllllllllllIIIIIIIlIlIIIIlIIl = 0;
                int llllllllllllllIIIIIIIlIlIIIIlIII = 0;
                int llllllllllllllIIIIIIIlIlIIIIIlll = 0;
                int llllllllllllllIIIIIIIlIlIIIIIllI = 0;
                int llllllllllllllIIIIIIIlIlIIIIIlIl = 0;
                int llllllllllllllIIIIIIIlIlIIIIIlII = 0;
                while (llllllllllllllIIIIIIIlIlIIIIlIlI.peek() != JsonToken.END_OBJECT) {
                    final String llllllllllllllIIIIIIIlIlIIIIllIl = llllllllllllllIIIIIIIlIlIIIIlIlI.nextName();
                    final int llllllllllllllIIIIIIIlIlIIIIllII = llllllllllllllIIIIIIIlIlIIIIlIlI.nextInt();
                    if ("year".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                        llllllllllllllIIIIIIIlIlIIIIlIIl = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                    else if ("month".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                        llllllllllllllIIIIIIIlIlIIIIlIII = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                    else if ("dayOfMonth".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                        llllllllllllllIIIIIIIlIlIIIIIlll = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                    else if ("hourOfDay".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                        llllllllllllllIIIIIIIlIlIIIIIllI = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                    else if ("minute".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                        llllllllllllllIIIIIIIlIlIIIIIlIl = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                    else {
                        if (!"second".equals(llllllllllllllIIIIIIIlIlIIIIllIl)) {
                            continue;
                        }
                        llllllllllllllIIIIIIIlIlIIIIIlII = llllllllllllllIIIIIIIlIlIIIIllII;
                    }
                }
                llllllllllllllIIIIIIIlIlIIIIlIlI.endObject();
                return new GregorianCalendar(llllllllllllllIIIIIIIlIlIIIIlIIl, llllllllllllllIIIIIIIlIlIIIIlIII, llllllllllllllIIIIIIIlIlIIIIIlll, llllllllllllllIIIIIIIlIlIIIIIllI, llllllllllllllIIIIIIIlIlIIIIIlIl, llllllllllllllIIIIIIIlIlIIIIIlII);
            }
            
            @Override
            public void write(final JsonWriter llllllllllllllIIIIIIIlIIllllIlll, final Calendar llllllllllllllIIIIIIIlIIllllIllI) throws IOException {
                if (llllllllllllllIIIIIIIlIIllllIllI == null) {
                    llllllllllllllIIIIIIIlIIllllIlll.nullValue();
                    return;
                }
                llllllllllllllIIIIIIIlIIllllIlll.beginObject();
                llllllllllllllIIIIIIIlIIllllIlll.name("year");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(1));
                llllllllllllllIIIIIIIlIIllllIlll.name("month");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(2));
                llllllllllllllIIIIIIIlIIllllIlll.name("dayOfMonth");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(5));
                llllllllllllllIIIIIIIlIIllllIlll.name("hourOfDay");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(11));
                llllllllllllllIIIIIIIlIIllllIlll.name("minute");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(12));
                llllllllllllllIIIIIIIlIIllllIlll.name("second");
                llllllllllllllIIIIIIIlIIllllIlll.value(llllllllllllllIIIIIIIlIIllllIllI.get(13));
                llllllllllllllIIIIIIIlIIllllIlll.endObject();
            }
        };
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, TypeAdapters.CALENDAR);
        LOCALE = new TypeAdapter<Locale>() {
            @Override
            public Locale read(final JsonReader lllllllllllllIlIIIIIIIIIIIIIlllI) throws IOException {
                if (lllllllllllllIlIIIIIIIIIIIIIlllI.peek() == JsonToken.NULL) {
                    lllllllllllllIlIIIIIIIIIIIIIlllI.nextNull();
                    return null;
                }
                final String lllllllllllllIlIIIIIIIIIIIIlIIll = lllllllllllllIlIIIIIIIIIIIIIlllI.nextString();
                final StringTokenizer lllllllllllllIlIIIIIIIIIIIIlIIlI = new StringTokenizer(lllllllllllllIlIIIIIIIIIIIIlIIll, "_");
                String lllllllllllllIlIIIIIIIIIIIIlIIIl = null;
                String lllllllllllllIlIIIIIIIIIIIIlIIII = null;
                String lllllllllllllIlIIIIIIIIIIIIIllll = null;
                if (lllllllllllllIlIIIIIIIIIIIIlIIlI.hasMoreElements()) {
                    lllllllllllllIlIIIIIIIIIIIIlIIIl = lllllllllllllIlIIIIIIIIIIIIlIIlI.nextToken();
                }
                if (lllllllllllllIlIIIIIIIIIIIIlIIlI.hasMoreElements()) {
                    lllllllllllllIlIIIIIIIIIIIIlIIII = lllllllllllllIlIIIIIIIIIIIIlIIlI.nextToken();
                }
                if (lllllllllllllIlIIIIIIIIIIIIlIIlI.hasMoreElements()) {
                    lllllllllllllIlIIIIIIIIIIIIIllll = lllllllllllllIlIIIIIIIIIIIIlIIlI.nextToken();
                }
                if (lllllllllllllIlIIIIIIIIIIIIlIIII == null && lllllllllllllIlIIIIIIIIIIIIIllll == null) {
                    return new Locale(lllllllllllllIlIIIIIIIIIIIIlIIIl);
                }
                if (lllllllllllllIlIIIIIIIIIIIIIllll == null) {
                    return new Locale(lllllllllllllIlIIIIIIIIIIIIlIIIl, lllllllllllllIlIIIIIIIIIIIIlIIII);
                }
                return new Locale(lllllllllllllIlIIIIIIIIIIIIlIIIl, lllllllllllllIlIIIIIIIIIIIIlIIII, lllllllllllllIlIIIIIIIIIIIIIllll);
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIlIIIIIIIIIIIIIIlIl, final Locale lllllllllllllIlIIIIIIIIIIIIIIIlI) throws IOException {
                lllllllllllllIlIIIIIIIIIIIIIIlIl.value((lllllllllllllIlIIIIIIIIIIIIIIIlI == null) ? null : lllllllllllllIlIIIIIIIIIIIIIIIlI.toString());
            }
        };
        LOCALE_FACTORY = newFactory(Locale.class, TypeAdapters.LOCALE);
        JSON_ELEMENT = new TypeAdapter<JsonElement>() {
            @Override
            public JsonElement read(final JsonReader lllllllllllllIIIllIIlIllIllllIlI) throws IOException {
                switch (lllllllllllllIIIllIIlIllIllllIlI.peek()) {
                    case STRING: {
                        return new JsonPrimitive(lllllllllllllIIIllIIlIllIllllIlI.nextString());
                    }
                    case NUMBER: {
                        final String lllllllllllllIIIllIIlIllIllllllI = lllllllllllllIIIllIIlIllIllllIlI.nextString();
                        return new JsonPrimitive(new LazilyParsedNumber(lllllllllllllIIIllIIlIllIllllllI));
                    }
                    case BOOLEAN: {
                        return new JsonPrimitive(lllllllllllllIIIllIIlIllIllllIlI.nextBoolean());
                    }
                    case NULL: {
                        lllllllllllllIIIllIIlIllIllllIlI.nextNull();
                        return JsonNull.INSTANCE;
                    }
                    case BEGIN_ARRAY: {
                        final JsonArray lllllllllllllIIIllIIlIllIlllllIl = new JsonArray();
                        lllllllllllllIIIllIIlIllIllllIlI.beginArray();
                        while (lllllllllllllIIIllIIlIllIllllIlI.hasNext()) {
                            lllllllllllllIIIllIIlIllIlllllIl.add(this.read(lllllllllllllIIIllIIlIllIllllIlI));
                        }
                        lllllllllllllIIIllIIlIllIllllIlI.endArray();
                        return lllllllllllllIIIllIIlIllIlllllIl;
                    }
                    case BEGIN_OBJECT: {
                        final JsonObject lllllllllllllIIIllIIlIllIlllllII = new JsonObject();
                        lllllllllllllIIIllIIlIllIllllIlI.beginObject();
                        while (lllllllllllllIIIllIIlIllIllllIlI.hasNext()) {
                            lllllllllllllIIIllIIlIllIlllllII.add(lllllllllllllIIIllIIlIllIllllIlI.nextName(), this.read(lllllllllllllIIIllIIlIllIllllIlI));
                        }
                        lllllllllllllIIIllIIlIllIllllIlI.endObject();
                        return lllllllllllllIIIllIIlIllIlllllII;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIIIllIIlIllIllIlIll, final JsonElement lllllllllllllIIIllIIlIllIllIIlll) throws IOException {
                if (lllllllllllllIIIllIIlIllIllIIlll == null || lllllllllllllIIIllIIlIllIllIIlll.isJsonNull()) {
                    lllllllllllllIIIllIIlIllIllIlIll.nullValue();
                }
                else if (lllllllllllllIIIllIIlIllIllIIlll.isJsonPrimitive()) {
                    final JsonPrimitive lllllllllllllIIIllIIlIllIllIllll = lllllllllllllIIIllIIlIllIllIIlll.getAsJsonPrimitive();
                    if (lllllllllllllIIIllIIlIllIllIllll.isNumber()) {
                        lllllllllllllIIIllIIlIllIllIlIll.value(lllllllllllllIIIllIIlIllIllIllll.getAsNumber());
                    }
                    else if (lllllllllllllIIIllIIlIllIllIllll.isBoolean()) {
                        lllllllllllllIIIllIIlIllIllIlIll.value(lllllllllllllIIIllIIlIllIllIllll.getAsBoolean());
                    }
                    else {
                        lllllllllllllIIIllIIlIllIllIlIll.value(lllllllllllllIIIllIIlIllIllIllll.getAsString());
                    }
                }
                else if (lllllllllllllIIIllIIlIllIllIIlll.isJsonArray()) {
                    lllllllllllllIIIllIIlIllIllIlIll.beginArray();
                    for (final JsonElement lllllllllllllIIIllIIlIllIllIlllI : lllllllllllllIIIllIIlIllIllIIlll.getAsJsonArray()) {
                        this.write(lllllllllllllIIIllIIlIllIllIlIll, lllllllllllllIIIllIIlIllIllIlllI);
                    }
                    lllllllllllllIIIllIIlIllIllIlIll.endArray();
                }
                else {
                    if (!lllllllllllllIIIllIIlIllIllIIlll.isJsonObject()) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Couldn't write ").append(lllllllllllllIIIllIIlIllIllIIlll.getClass())));
                    }
                    lllllllllllllIIIllIIlIllIllIlIll.beginObject();
                    for (final Map.Entry<String, JsonElement> lllllllllllllIIIllIIlIllIllIllIl : lllllllllllllIIIllIIlIllIllIIlll.getAsJsonObject().entrySet()) {
                        lllllllllllllIIIllIIlIllIllIlIll.name(lllllllllllllIIIllIIlIllIllIllIl.getKey());
                        this.write(lllllllllllllIIIllIIlIllIllIlIll, lllllllllllllIIIllIIlIllIllIllIl.getValue());
                    }
                    lllllllllllllIIIllIIlIllIllIlIll.endObject();
                }
            }
        };
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, TypeAdapters.JSON_ELEMENT);
        ENUM_FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllIllIllIIIlIIlllIlIl, final TypeToken<T> lllllllllllllIllIllIIIlIIlllIlII) {
                Class<? super T> lllllllllllllIllIllIIIlIIlllIIll = lllllllllllllIllIllIIIlIIlllIlII.getRawType();
                if (!Enum.class.isAssignableFrom(lllllllllllllIllIllIIIlIIlllIIll) || lllllllllllllIllIllIIIlIIlllIIll == Enum.class) {
                    return null;
                }
                if (!lllllllllllllIllIllIIIlIIlllIIll.isEnum()) {
                    lllllllllllllIllIllIIIlIIlllIIll = lllllllllllllIllIllIIIlIIlllIIll.getSuperclass();
                }
                return new EnumTypeAdapter<T>((Class<T>)lllllllllllllIllIllIIIlIIlllIIll);
            }
        };
    }
    
    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> lllllllllllllIlIllllIllIllllIIlI, final TypeAdapter<T1> lllllllllllllIlIllllIllIllllIIIl) {
        return new TypeAdapterFactory() {
            @Override
            public <T2> TypeAdapter<T2> create(final Gson llllllllllllllllllIIIlIlllIIIIll, final TypeToken<T2> llllllllllllllllllIIIlIllIllllll) {
                final Class<? super T2> llllllllllllllllllIIIlIlllIIIIIl = llllllllllllllllllIIIlIllIllllll.getRawType();
                if (!lllllllllllllIlIllllIllIllllIIlI.isAssignableFrom(llllllllllllllllllIIIlIlllIIIIIl)) {
                    return null;
                }
                return (TypeAdapter<T2>)new TypeAdapter<T1>() {
                    @Override
                    public void write(final JsonWriter lllllllllllllIllIlIIIllIIlIIIIlI, final T1 lllllllllllllIllIlIIIllIIlIIIIIl) throws IOException {
                        lllllllllllllIlIllllIllIllllIIIl.write(lllllllllllllIllIlIIIllIIlIIIIlI, lllllllllllllIllIlIIIllIIlIIIIIl);
                    }
                    
                    @Override
                    public T1 read(final JsonReader lllllllllllllIllIlIIIllIIIllllII) throws IOException {
                        final T1 lllllllllllllIllIlIIIllIIIlllIll = lllllllllllllIlIllllIllIllllIIIl.read(lllllllllllllIllIlIIIllIIIllllII);
                        if (lllllllllllllIllIlIIIllIIIlllIll != null && !llllllllllllllllllIIIlIlllIIIIIl.isInstance(lllllllllllllIllIlIIIllIIIlllIll)) {
                            throw new JsonSyntaxException(String.valueOf(new StringBuilder().append("Expected a ").append(llllllllllllllllllIIIlIlllIIIIIl.getName()).append(" but was ").append(lllllllllllllIllIlIIIllIIIlllIll.getClass().getName())));
                        }
                        return lllllllllllllIllIlIIIllIIIlllIll;
                    }
                };
            }
            
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append("Factory[typeHierarchy=").append(lllllllllllllIlIllllIllIllllIIlI.getName()).append(",adapter=").append(lllllllllllllIlIllllIllIllllIIIl).append("]"));
            }
        };
    }
    
    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> lllllllllllllIlIllllIllIlllllIIl, final Class<? extends TT> lllllllllllllIlIllllIllIlllllIII, final TypeAdapter<? super TT> lllllllllllllIlIllllIllIlllllIlI) {
        return new TypeAdapterFactory() {
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append("Factory[type=").append(lllllllllllllIlIllllIllIlllllIIl.getName()).append("+").append(lllllllllllllIlIllllIllIlllllIII.getName()).append(",adapter=").append(lllllllllllllIlIllllIllIlllllIlI).append("]"));
            }
            
            @Override
            public <T> TypeAdapter<T> create(final Gson lIIlIIllIllll, final TypeToken<T> lIIlIIllIlIll) {
                final Class<? super T> lIIlIIllIllIl = lIIlIIllIlIll.getRawType();
                return (TypeAdapter<T>)((lIIlIIllIllIl == lllllllllllllIlIllllIllIlllllIIl || lIIlIIllIllIl == lllllllllllllIlIllllIllIlllllIII) ? lllllllllllllIlIllllIllIlllllIlI : null);
            }
        };
    }
    
    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T>
    {
        private final /* synthetic */ Map<String, T> nameToConstant;
        private final /* synthetic */ Map<T, String> constantToName;
        
        @Override
        public T read(final JsonReader lllllllllllllIlIllIIlIIlIllllIlI) throws IOException {
            if (lllllllllllllIlIllIIlIIlIllllIlI.peek() == JsonToken.NULL) {
                lllllllllllllIlIllIIlIIlIllllIlI.nextNull();
                return null;
            }
            return this.nameToConstant.get(lllllllllllllIlIllIIlIIlIllllIlI.nextString());
        }
        
        public EnumTypeAdapter(final Class<T> lllllllllllllIlIllIIlIIllIIIlIII) {
            this.nameToConstant = new HashMap<String, T>();
            this.constantToName = new HashMap<T, String>();
            try {
                final T[] array = lllllllllllllIlIllIIlIIllIIIlIII.getEnumConstants();
                final String lllllllllllllIlIllIIlIIllIIIIllI = (String)array.length;
                for (float lllllllllllllIlIllIIlIIllIIIIlIl = 0; lllllllllllllIlIllIIlIIllIIIIlIl < lllllllllllllIlIllIIlIIllIIIIllI; ++lllllllllllllIlIllIIlIIllIIIIlIl) {
                    final T lllllllllllllIlIllIIlIIllIIIllIl = array[lllllllllllllIlIllIIlIIllIIIIlIl];
                    String lllllllllllllIlIllIIlIIllIIIllll = lllllllllllllIlIllIIlIIllIIIllIl.name();
                    final SerializedName lllllllllllllIlIllIIlIIllIIIlllI = lllllllllllllIlIllIIlIIllIIIlIII.getField(lllllllllllllIlIllIIlIIllIIIllll).getAnnotation(SerializedName.class);
                    if (lllllllllllllIlIllIIlIIllIIIlllI != null) {
                        lllllllllllllIlIllIIlIIllIIIllll = lllllllllllllIlIllIIlIIllIIIlllI.value();
                        final Exception lllllllllllllIlIllIIlIIllIIIIIIl = (Object)lllllllllllllIlIllIIlIIllIIIlllI.alternate();
                        final Exception lllllllllllllIlIllIIlIIllIIIIIII = (Exception)lllllllllllllIlIllIIlIIllIIIIIIl.length;
                        for (float lllllllllllllIlIllIIlIIlIlllllll = 0; lllllllllllllIlIllIIlIIlIlllllll < lllllllllllllIlIllIIlIIllIIIIIII; ++lllllllllllllIlIllIIlIIlIlllllll) {
                            final String lllllllllllllIlIllIIlIIllIIlIIII = lllllllllllllIlIllIIlIIllIIIIIIl[lllllllllllllIlIllIIlIIlIlllllll];
                            this.nameToConstant.put(lllllllllllllIlIllIIlIIllIIlIIII, lllllllllllllIlIllIIlIIllIIIllIl);
                        }
                    }
                    this.nameToConstant.put(lllllllllllllIlIllIIlIIllIIIllll, lllllllllllllIlIllIIlIIllIIIllIl);
                    this.constantToName.put(lllllllllllllIlIllIIlIIllIIIllIl, lllllllllllllIlIllIIlIIllIIIllll);
                }
            }
            catch (NoSuchFieldException lllllllllllllIlIllIIlIIllIIIllII) {
                throw new AssertionError((Object)lllllllllllllIlIllIIlIIllIIIllII);
            }
        }
        
        @Override
        public void write(final JsonWriter lllllllllllllIlIllIIlIIlIlllIIII, final T lllllllllllllIlIllIIlIIlIllIllll) throws IOException {
            lllllllllllllIlIllIIlIIlIlllIIII.value((lllllllllllllIlIllIIlIIlIllIllll == null) ? null : this.constantToName.get(lllllllllllllIlIllIIlIIlIllIllll));
        }
    }
}
