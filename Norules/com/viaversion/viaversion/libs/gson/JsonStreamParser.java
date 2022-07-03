package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.stream.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.io.*;

public final class JsonStreamParser implements Iterator<JsonElement>
{
    private final /* synthetic */ Object lock;
    private final /* synthetic */ JsonReader parser;
    
    @Override
    public boolean hasNext() {
        synchronized (this.lock) {
            try {
                return this.parser.peek() != JsonToken.END_DOCUMENT;
            }
            catch (MalformedJsonException lllllllllllllIlIIIlllIlIIllIIlll) {
                throw new JsonSyntaxException(lllllllllllllIlIIIlllIlIIllIIlll);
            }
            catch (IOException lllllllllllllIlIIIlllIlIIllIIllI) {
                throw new JsonIOException(lllllllllllllIlIIIlllIlIIllIIllI);
            }
        }
    }
    
    public JsonStreamParser(final Reader lllllllllllllIlIIIlllIlIIlllIllI) {
        this.parser = new JsonReader(lllllllllllllIlIIIlllIlIIlllIllI);
        this.parser.setLenient(true);
        this.lock = new Object();
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public JsonElement next() throws JsonParseException {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        }
        catch (StackOverflowError lllllllllllllIlIIIlllIlIIlllIIIl) {
            throw new JsonParseException("Failed parsing JSON source to Json", lllllllllllllIlIIIlllIlIIlllIIIl);
        }
        catch (OutOfMemoryError lllllllllllllIlIIIlllIlIIlllIIII) {
            throw new JsonParseException("Failed parsing JSON source to Json", lllllllllllllIlIIIlllIlIIlllIIII);
        }
        catch (JsonParseException lllllllllllllIlIIIlllIlIIllIllll) {
            throw (lllllllllllllIlIIIlllIlIIllIllll.getCause() instanceof EOFException) ? new NoSuchElementException() : lllllllllllllIlIIIlllIlIIllIllll;
        }
    }
    
    public JsonStreamParser(final String lllllllllllllIlIIIlllIlIIllllIlI) {
        this(new StringReader(lllllllllllllIlIIIlllIlIIllllIlI));
    }
}
