package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.lang.reflect.*;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T>
{
    private final /* synthetic */ Gson context;
    private final /* synthetic */ Type type;
    private final /* synthetic */ TypeAdapter<T> delegate;
    
    @Override
    public T read(final JsonReader llllllllllllIlllllIIlIIllIIIlllI) throws IOException {
        return this.delegate.read(llllllllllllIlllllIIlIIllIIIlllI);
    }
    
    TypeAdapterRuntimeTypeWrapper(final Gson llllllllllllIlllllIIlIIllIIlIllI, final TypeAdapter<T> llllllllllllIlllllIIlIIllIIlIlIl, final Type llllllllllllIlllllIIlIIllIIllIII) {
        this.context = llllllllllllIlllllIIlIIllIIlIllI;
        this.delegate = llllllllllllIlllllIIlIIllIIlIlIl;
        this.type = llllllllllllIlllllIIlIIllIIllIII;
    }
    
    @Override
    public void write(final JsonWriter llllllllllllIlllllIIlIIllIIIIlIl, final T llllllllllllIlllllIIlIIllIIIIlII) throws IOException {
        TypeAdapter llllllllllllIlllllIIlIIllIIIIIll = this.delegate;
        final Type llllllllllllIlllllIIlIIllIIIIIlI = this.getRuntimeTypeIfMoreSpecific(this.type, llllllllllllIlllllIIlIIllIIIIlII);
        if (llllllllllllIlllllIIlIIllIIIIIlI != this.type) {
            final TypeAdapter llllllllllllIlllllIIlIIllIIIIlll = this.context.getAdapter(TypeToken.get(llllllllllllIlllllIIlIIllIIIIIlI));
            if (!(llllllllllllIlllllIIlIIllIIIIlll instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                llllllllllllIlllllIIlIIllIIIIIll = llllllllllllIlllllIIlIIllIIIIlll;
            }
            else if (!(this.delegate instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                llllllllllllIlllllIIlIIllIIIIIll = this.delegate;
            }
            else {
                llllllllllllIlllllIIlIIllIIIIIll = llllllllllllIlllllIIlIIllIIIIlll;
            }
        }
        llllllllllllIlllllIIlIIllIIIIIll.write(llllllllllllIlllllIIlIIllIIIIlIl, llllllllllllIlllllIIlIIllIIIIlII);
    }
    
    private Type getRuntimeTypeIfMoreSpecific(Type llllllllllllIlllllIIlIIlIlllIllI, final Object llllllllllllIlllllIIlIIlIlllIlIl) {
        if (llllllllllllIlllllIIlIIlIlllIlIl != null && (llllllllllllIlllllIIlIIlIlllIllI == Object.class || llllllllllllIlllllIIlIIlIlllIllI instanceof TypeVariable || llllllllllllIlllllIIlIIlIlllIllI instanceof Class)) {
            llllllllllllIlllllIIlIIlIlllIllI = llllllllllllIlllllIIlIIlIlllIlIl.getClass();
        }
        return llllllllllllIlllllIIlIIlIlllIllI;
    }
}
