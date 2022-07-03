package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.internal.bind.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;
import java.io.*;

public final class Streams
{
    public static void write(final JsonElement llllllllllllllIIIllIlIIlIllIIllI, final JsonWriter llllllllllllllIIIllIlIIlIllIIIll) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(llllllllllllllIIIllIlIIlIllIIIll, llllllllllllllIIIllIlIIlIllIIllI);
    }
    
    private Streams() {
        throw new UnsupportedOperationException();
    }
    
    public static JsonElement parse(final JsonReader llllllllllllllIIIllIlIIlIllIllIl) throws JsonParseException {
        boolean llllllllllllllIIIllIlIIlIllIllII = true;
        try {
            llllllllllllllIIIllIlIIlIllIllIl.peek();
            llllllllllllllIIIllIlIIlIllIllII = false;
            return TypeAdapters.JSON_ELEMENT.read(llllllllllllllIIIllIlIIlIllIllIl);
        }
        catch (EOFException llllllllllllllIIIllIlIIlIlllIIIl) {
            if (llllllllllllllIIIllIlIIlIllIllII) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(llllllllllllllIIIllIlIIlIlllIIIl);
        }
        catch (MalformedJsonException llllllllllllllIIIllIlIIlIlllIIII) {
            throw new JsonSyntaxException(llllllllllllllIIIllIlIIlIlllIIII);
        }
        catch (IOException llllllllllllllIIIllIlIIlIllIllll) {
            throw new JsonIOException(llllllllllllllIIIllIlIIlIllIllll);
        }
        catch (NumberFormatException llllllllllllllIIIllIlIIlIllIlllI) {
            throw new JsonSyntaxException(llllllllllllllIIIllIlIIlIllIlllI);
        }
    }
    
    public static Writer writerForAppendable(final Appendable llllllllllllllIIIllIlIIlIllIIIII) {
        return (llllllllllllllIIIllIlIIlIllIIIII instanceof Writer) ? ((Writer)llllllllllllllIIIllIlIIlIllIIIII) : new AppendableWriter(llllllllllllllIIIllIlIIlIllIIIII);
    }
    
    private static final class AppendableWriter extends Writer
    {
        private final /* synthetic */ CurrentWrite currentWrite;
        private final /* synthetic */ Appendable appendable;
        
        @Override
        public void write(final int lllllllllllllIllIllIIIllIIllIIll) throws IOException {
            this.appendable.append((char)lllllllllllllIllIllIIIllIIllIIll);
        }
        
        @Override
        public void write(final char[] lllllllllllllIllIllIIIllIIlllIIl, final int lllllllllllllIllIllIIIllIIlllIII, final int lllllllllllllIllIllIIIllIIllIlll) throws IOException {
            this.currentWrite.chars = lllllllllllllIllIllIIIllIIlllIIl;
            this.appendable.append(this.currentWrite, lllllllllllllIllIllIIIllIIlllIII, lllllllllllllIllIllIIIllIIlllIII + lllllllllllllIllIllIIIllIIllIlll);
        }
        
        @Override
        public void flush() {
        }
        
        AppendableWriter(final Appendable lllllllllllllIllIllIIIllIlIIIlIl) {
            this.currentWrite = new CurrentWrite();
            this.appendable = lllllllllllllIllIllIIIllIlIIIlIl;
        }
        
        @Override
        public void close() {
        }
        
        static class CurrentWrite implements CharSequence
        {
            /* synthetic */ char[] chars;
            
            @Override
            public char charAt(final int lllllllllllllIIlllIlIlIlIllIlllI) {
                return this.chars[lllllllllllllIIlllIlIlIlIllIlllI];
            }
            
            @Override
            public CharSequence subSequence(final int lllllllllllllIIlllIlIlIlIllIIllI, final int lllllllllllllIIlllIlIlIlIllIIlIl) {
                return new String(this.chars, lllllllllllllIIlllIlIlIlIllIIllI, lllllllllllllIIlllIlIlIlIllIIlIl - lllllllllllllIIlllIlIlIlIllIIllI);
            }
            
            @Override
            public int length() {
                return this.chars.length;
            }
        }
    }
}
