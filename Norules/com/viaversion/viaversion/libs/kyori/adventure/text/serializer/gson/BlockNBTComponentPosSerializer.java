package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;

final class BlockNBTComponentPosSerializer extends TypeAdapter<BlockNBTComponent.Pos>
{
    private BlockNBTComponentPosSerializer() {
    }
    
    static {
        INSTANCE = new BlockNBTComponentPosSerializer().nullSafe();
    }
    
    @Override
    public BlockNBTComponent.Pos read(final JsonReader lIIllIIIIllIlI) throws IOException {
        final String lIIllIIIIlIllI = lIIllIIIIllIlI.nextString();
        try {
            return BlockNBTComponent.Pos.fromString(lIIllIIIIlIllI);
        }
        catch (IllegalArgumentException lIIllIIIIllIIl) {
            throw new JsonParseException(String.valueOf(new StringBuilder().append("Don't know how to turn ").append(lIIllIIIIlIllI).append(" into a Position")));
        }
    }
    
    @Override
    public void write(final JsonWriter lIIllIIIIIllll, final BlockNBTComponent.Pos lIIllIIIIlIIII) throws IOException {
        lIIllIIIIIllll.value(lIIllIIIIlIIII.asString());
    }
}
