package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;

final class TextColorWrapper
{
    final /* synthetic */ boolean reset;
    @Nullable
    final /* synthetic */ TextColor color;
    @Nullable
    final /* synthetic */ TextDecoration decoration;
    
    TextColorWrapper(@Nullable final TextColor lllllllllllllIIIIIllIllIlIlIIlIl, @Nullable final TextDecoration lllllllllllllIIIIIllIllIlIlIIIll, final boolean lllllllllllllIIIIIllIllIlIlIIlII) {
        this.color = lllllllllllllIIIIIllIllIlIlIIlIl;
        this.decoration = lllllllllllllIIIIIllIllIlIlIIIll;
        this.reset = lllllllllllllIIIIIllIllIlIlIIlII;
    }
    
    static class Serializer extends TypeAdapter<TextColorWrapper>
    {
        @Override
        public void write(final JsonWriter lllllllllllllIlIIIIlIlIlIlIIIIll, final TextColorWrapper lllllllllllllIlIIIIlIlIlIlIIIlII) {
            throw new JsonSyntaxException("Cannot write TextColorWrapper instances");
        }
        
        @Override
        public TextColorWrapper read(final JsonReader lllllllllllllIlIIIIlIlIlIIlllIlI) throws IOException {
            final String lllllllllllllIlIIIIlIlIlIIllIlll = lllllllllllllIlIIIIlIlIlIIlllIlI.nextString();
            final TextColor lllllllllllllIlIIIIlIlIlIIllIllI = TextColorSerializer.fromString(lllllllllllllIlIIIIlIlIlIIllIlll);
            final TextDecoration lllllllllllllIlIIIIlIlIlIIllIlIl = TextDecoration.NAMES.value(lllllllllllllIlIIIIlIlIlIIllIlll);
            final boolean lllllllllllllIlIIIIlIlIlIIllIlII = lllllllllllllIlIIIIlIlIlIIllIlIl == null && lllllllllllllIlIIIIlIlIlIIllIlll.equals("reset");
            if (lllllllllllllIlIIIIlIlIlIIllIllI == null && lllllllllllllIlIIIIlIlIlIIllIlIl == null && !lllllllllllllIlIIIIlIlIlIIllIlII) {
                throw new JsonParseException(String.valueOf(new StringBuilder().append("Don't know how to parse ").append(lllllllllllllIlIIIIlIlIlIIllIlll).append(" at ").append(lllllllllllllIlIIIIlIlIlIIlllIlI.getPath())));
            }
            return new TextColorWrapper(lllllllllllllIlIIIIlIlIlIIllIllI, lllllllllllllIlIIIIlIlIlIIllIlIl, lllllllllllllIlIIIIlIlIlIIllIlII);
        }
    }
}
