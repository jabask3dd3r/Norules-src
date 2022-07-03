package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;

final class KeySerializer extends TypeAdapter<Key>
{
    private KeySerializer() {
    }
    
    static {
        INSTANCE = new KeySerializer().nullSafe();
    }
    
    @Override
    public void write(final JsonWriter llllllllllllllIIlIIlIlllIllIlIIl, final Key llllllllllllllIIlIIlIlllIllIlIlI) throws IOException {
        llllllllllllllIIlIIlIlllIllIlIIl.value(llllllllllllllIIlIIlIlllIllIlIlI.asString());
    }
    
    @Override
    public Key read(final JsonReader llllllllllllllIIlIIlIlllIllIIIlI) throws IOException {
        return Key.key(llllllllllllllIIlIIlIlllIllIIIlI.nextString());
    }
}
