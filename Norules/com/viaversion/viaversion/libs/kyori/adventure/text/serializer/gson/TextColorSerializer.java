package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import org.jetbrains.annotations.*;

final class TextColorSerializer extends TypeAdapter<TextColor>
{
    private final /* synthetic */ boolean downsampleColor;
    
    @Override
    public void write(final JsonWriter llllllllllllllllIlIIlIlIIIlIllll, final TextColor llllllllllllllllIlIIlIlIIIllIIIl) throws IOException {
        if (llllllllllllllllIlIIlIlIIIllIIIl instanceof NamedTextColor) {
            llllllllllllllllIlIIlIlIIIlIllll.value(NamedTextColor.NAMES.key((NamedTextColor)llllllllllllllllIlIIlIlIIIllIIIl));
        }
        else if (this.downsampleColor) {
            llllllllllllllllIlIIlIlIIIlIllll.value(NamedTextColor.NAMES.key(NamedTextColor.nearestTo(llllllllllllllllIlIIlIlIIIllIIIl)));
        }
        else {
            llllllllllllllllIlIIlIlIIIlIllll.value(llllllllllllllllIlIIlIlIIIllIIIl.asHexString());
        }
    }
    
    @Nullable
    @Override
    public TextColor read(final JsonReader llllllllllllllllIlIIlIlIIIIllIlI) throws IOException {
        final TextColor llllllllllllllllIlIIlIlIIIIlIlll = fromString(llllllllllllllllIlIIlIlIIIIllIlI.nextString());
        if (llllllllllllllllIlIIlIlIIIIlIlll == null) {
            return null;
        }
        return this.downsampleColor ? NamedTextColor.nearestTo(llllllllllllllllIlIIlIlIIIIlIlll) : llllllllllllllllIlIIlIlIIIIlIlll;
    }
    
    @Nullable
    static TextColor fromString(@NotNull final String llllllllllllllllIlIIlIlIIIIIlllI) {
        if (llllllllllllllllIlIIlIlIIIIIlllI.startsWith("#")) {
            return TextColor.fromHexString(llllllllllllllllIlIIlIlIIIIIlllI);
        }
        return NamedTextColor.NAMES.value(llllllllllllllllIlIIlIlIIIIIlllI);
    }
    
    private TextColorSerializer(final boolean llllllllllllllllIlIIlIlIIlIIIIII) {
        this.downsampleColor = llllllllllllllllIlIIlIlIIlIIIIII;
    }
    
    static {
        INSTANCE = new TextColorSerializer(false).nullSafe();
        DOWNSAMPLE_COLOR = new TextColorSerializer(true).nullSafe();
    }
}
