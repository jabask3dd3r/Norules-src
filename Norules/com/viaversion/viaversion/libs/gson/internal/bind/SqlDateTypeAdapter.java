package com.viaversion.viaversion.libs.gson.internal.bind;

import java.sql.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;
import java.text.*;

public final class SqlDateTypeAdapter extends TypeAdapter<Date>
{
    private final /* synthetic */ DateFormat format;
    
    @Override
    public synchronized void write(final JsonWriter lllllllllllllllIlIIllIlIlIIIIlll, final Date lllllllllllllllIlIIllIlIlIIIIIll) throws IOException {
        lllllllllllllllIlIIllIlIlIIIIlll.value((lllllllllllllllIlIIllIlIlIIIIIll == null) ? null : this.format.format(lllllllllllllllIlIIllIlIlIIIIIll));
    }
    
    static {
        FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson llllllllllllllIIIllIlIllIlIlIlll, final TypeToken<T> llllllllllllllIIIllIlIllIlIlIlIl) {
                return (TypeAdapter<T>)((llllllllllllllIIIllIlIllIlIlIlIl.getRawType() == Date.class) ? new SqlDateTypeAdapter() : null);
            }
        };
    }
    
    @Override
    public synchronized Date read(final JsonReader lllllllllllllllIlIIllIlIlIIIllll) throws IOException {
        if (lllllllllllllllIlIIllIlIlIIIllll.peek() == JsonToken.NULL) {
            lllllllllllllllIlIIllIlIlIIIllll.nextNull();
            return null;
        }
        try {
            final long lllllllllllllllIlIIllIlIlIIlIIlI = this.format.parse(lllllllllllllllIlIIllIlIlIIIllll.nextString()).getTime();
            return new Date(lllllllllllllllIlIIllIlIlIIlIIlI);
        }
        catch (ParseException lllllllllllllllIlIIllIlIlIIlIIIl) {
            throw new JsonSyntaxException(lllllllllllllllIlIIllIlIlIIlIIIl);
        }
    }
    
    public SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }
}
