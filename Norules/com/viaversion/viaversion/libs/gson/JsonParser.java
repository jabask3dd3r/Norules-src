package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.internal.*;

public final class JsonParser
{
    @Deprecated
    public JsonParser() {
    }
    
    public static JsonElement parseString(final String lllllllllllllIlIlllIIIlIIlIlIIII) throws JsonSyntaxException {
        return parseReader(new StringReader(lllllllllllllIlIlllIIIlIIlIlIIII));
    }
    
    @Deprecated
    public JsonElement parse(final String lllllllllllllIlIlllIIIlIIIllIlII) throws JsonSyntaxException {
        return parseString(lllllllllllllIlIlllIIIlIIIllIlII);
    }
    
    @Deprecated
    public JsonElement parse(final JsonReader lllllllllllllIlIlllIIIlIIIlIllIl) throws JsonIOException, JsonSyntaxException {
        return parseReader(lllllllllllllIlIlllIIIlIIIlIllIl);
    }
    
    public static JsonElement parseReader(final Reader lllllllllllllIlIlllIIIlIIlIIIlll) throws JsonSyntaxException, JsonIOException {
        try {
            final JsonReader lllllllllllllIlIlllIIIlIIlIIllII = new JsonReader(lllllllllllllIlIlllIIIlIIlIIIlll);
            final JsonElement lllllllllllllIlIlllIIIlIIlIIlIll = parseReader(lllllllllllllIlIlllIIIlIIlIIllII);
            if (!lllllllllllllIlIlllIIIlIIlIIlIll.isJsonNull() && lllllllllllllIlIlllIIIlIIlIIllII.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return lllllllllllllIlIlllIIIlIIlIIlIll;
        }
        catch (MalformedJsonException lllllllllllllIlIlllIIIlIIlIIlIlI) {
            throw new JsonSyntaxException(lllllllllllllIlIlllIIIlIIlIIlIlI);
        }
        catch (IOException lllllllllllllIlIlllIIIlIIlIIlIIl) {
            throw new JsonIOException(lllllllllllllIlIlllIIIlIIlIIlIIl);
        }
        catch (NumberFormatException lllllllllllllIlIlllIIIlIIlIIlIII) {
            throw new JsonSyntaxException(lllllllllllllIlIlllIIIlIIlIIlIII);
        }
    }
    
    public static JsonElement parseReader(final JsonReader lllllllllllllIlIlllIIIlIIIlllIll) throws JsonSyntaxException, JsonIOException {
        final boolean lllllllllllllIlIlllIIIlIIIllllII = lllllllllllllIlIlllIIIlIIIlllIll.isLenient();
        lllllllllllllIlIlllIIIlIIIlllIll.setLenient(true);
        try {
            return Streams.parse(lllllllllllllIlIlllIIIlIIIlllIll);
        }
        catch (StackOverflowError lllllllllllllIlIlllIIIlIIIllllll) {
            throw new JsonParseException(String.valueOf(new StringBuilder().append("Failed parsing JSON source: ").append(lllllllllllllIlIlllIIIlIIIlllIll).append(" to Json")), lllllllllllllIlIlllIIIlIIIllllll);
        }
        catch (OutOfMemoryError lllllllllllllIlIlllIIIlIIIlllllI) {
            throw new JsonParseException(String.valueOf(new StringBuilder().append("Failed parsing JSON source: ").append(lllllllllllllIlIlllIIIlIIIlllIll).append(" to Json")), lllllllllllllIlIlllIIIlIIIlllllI);
        }
        finally {
            lllllllllllllIlIlllIIIlIIIlllIll.setLenient(lllllllllllllIlIlllIIIlIIIllllII);
        }
    }
    
    @Deprecated
    public JsonElement parse(final Reader lllllllllllllIlIlllIIIlIIIllIIIl) throws JsonIOException, JsonSyntaxException {
        return parseReader(lllllllllllllIlIlllIIIlIIIllIIIl);
    }
}
