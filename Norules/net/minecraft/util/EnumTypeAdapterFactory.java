package net.minecraft.util;

import com.google.gson.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.io.*;
import javax.annotation.*;
import com.google.gson.stream.*;
import java.util.*;

public class EnumTypeAdapterFactory implements TypeAdapterFactory
{
    @Nullable
    public <T> TypeAdapter<T> create(final Gson llllllllllllllIlIlIIIllIIIIllIll, final TypeToken<T> llllllllllllllIlIlIIIllIIIIllIIl) {
        final Class<T> llllllllllllllIlIlIIIllIIIIlIlll = (Class<T>)llllllllllllllIlIlIIIllIIIIllIIl.getRawType();
        if (!llllllllllllllIlIlIIIllIIIIlIlll.isEnum()) {
            return null;
        }
        final Map<String, T> llllllllllllllIlIlIIIllIIIIlIlIl = (Map<String, T>)Maps.newHashMap();
        final char llllllllllllllIlIlIIIllIIIIIIlll;
        final long llllllllllllllIlIlIIIllIIIIIlIII = ((T[])(Object)(llllllllllllllIlIlIIIllIIIIIIlll = (char)(Object)llllllllllllllIlIlIIIllIIIIlIlll.getEnumConstants())).length;
        for (float llllllllllllllIlIlIIIllIIIIIlIlI = 0; llllllllllllllIlIlIIIllIIIIIlIlI < llllllllllllllIlIlIIIllIIIIIlIII; ++llllllllllllllIlIlIIIllIIIIIlIlI) {
            final T llllllllllllllIlIlIIIllIIIIlIIll = llllllllllllllIlIlIIIllIIIIIIlll[llllllllllllllIlIlIIIllIIIIIlIlI];
            llllllllllllllIlIlIIIllIIIIlIlIl.put(this.getName(llllllllllllllIlIlIIIllIIIIlIIll), llllllllllllllIlIlIIIllIIIIlIIll);
        }
        return new TypeAdapter<T>() {
            @Nullable
            public T read(final JsonReader llllllllllllIlllllllIllllIlIlIlI) throws IOException {
                if (llllllllllllIlllllllIllllIlIlIlI.peek() == JsonToken.NULL) {
                    llllllllllllIlllllllIllllIlIlIlI.nextNull();
                    return null;
                }
                return llllllllllllllIlIlIIIllIIIIlIlIl.get(llllllllllllIlllllllIllllIlIlIlI.nextString());
            }
            
            public void write(final JsonWriter llllllllllllIlllllllIllllIllIlII, final T llllllllllllIlllllllIllllIllIIll) throws IOException {
                if (llllllllllllIlllllllIllllIllIIll == null) {
                    llllllllllllIlllllllIllllIllIlII.nullValue();
                }
                else {
                    llllllllllllIlllllllIllllIllIlII.value(EnumTypeAdapterFactory.this.getName(llllllllllllIlllllllIllllIllIIll));
                }
            }
        };
    }
    
    private String getName(final Object llllllllllllllIlIlIIIllIIIIIIIII) {
        return (llllllllllllllIlIlIIIllIIIIIIIII instanceof Enum) ? ((Enum)llllllllllllllIlIlIIIllIIIIIIIII).name().toLowerCase(Locale.ROOT) : llllllllllllllIlIlIIIllIIIIIIIII.toString().toLowerCase(Locale.ROOT);
    }
}
