package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.gson.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;

final class IndexedSerializer<E> extends TypeAdapter<E>
{
    private final /* synthetic */ String name;
    private final /* synthetic */ Index<String, E> map;
    
    @Override
    public E read(final JsonReader lllllllllllllllIIIIIlIlllllIlIll) throws IOException {
        final String lllllllllllllllIIIIIlIlllllIIlIl = lllllllllllllllIIIIIlIlllllIlIll.nextString();
        final E lllllllllllllllIIIIIlIlllllIIlII = this.map.value(lllllllllllllllIIIIIlIlllllIIlIl);
        if (lllllllllllllllIIIIIlIlllllIIlII != null) {
            return lllllllllllllllIIIIIlIlllllIIlII;
        }
        throw new JsonParseException(String.valueOf(new StringBuilder().append("invalid ").append(this.name).append(":  ").append(lllllllllllllllIIIIIlIlllllIIlIl)));
    }
    
    private IndexedSerializer(final String lllllllllllllllIIIIIllIIIIIIllII, final Index<String, E> lllllllllllllllIIIIIllIIIIIIlllI) {
        this.name = lllllllllllllllIIIIIllIIIIIIllII;
        this.map = lllllllllllllllIIIIIllIIIIIIlllI;
    }
    
    @Override
    public void write(final JsonWriter lllllllllllllllIIIIIlIllllllllll, final E lllllllllllllllIIIIIlIlllllllllI) throws IOException {
        lllllllllllllllIIIIIlIllllllllll.value(this.map.key(lllllllllllllllIIIIIlIlllllllllI));
    }
    
    public static <E> TypeAdapter<E> of(final String lllllllllllllllIIIIIllIIIIlIIIlI, final Index<String, E> lllllllllllllllIIIIIllIIIIIlllll) {
        return new IndexedSerializer<E>(lllllllllllllllIIIIIllIIIIlIIIlI, lllllllllllllllIIIIIllIIIIIlllll).nullSafe();
    }
}
