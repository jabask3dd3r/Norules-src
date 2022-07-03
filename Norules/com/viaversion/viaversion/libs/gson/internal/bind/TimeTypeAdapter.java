package com.viaversion.viaversion.libs.gson.internal.bind;

import java.sql.*;
import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.text.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.reflect.*;

public final class TimeTypeAdapter extends TypeAdapter<Time>
{
    private final /* synthetic */ DateFormat format;
    
    @Override
    public synchronized void write(final JsonWriter lllllllllllllllIlIIlIIIIlIlIllII, final Time lllllllllllllllIlIIlIIIIlIlIlllI) throws IOException {
        lllllllllllllllIlIIlIIIIlIlIllII.value((lllllllllllllllIlIIlIIIIlIlIlllI == null) ? null : this.format.format(lllllllllllllllIlIIlIIIIlIlIlllI));
    }
    
    public TimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }
    
    @Override
    public synchronized Time read(final JsonReader lllllllllllllllIlIIlIIIIlIllIlll) throws IOException {
        if (lllllllllllllllIlIIlIIIIlIllIlll.peek() == JsonToken.NULL) {
            lllllllllllllllIlIIlIIIIlIllIlll.nextNull();
            return null;
        }
        try {
            final Date lllllllllllllllIlIIlIIIIlIlllIlI = this.format.parse(lllllllllllllllIlIIlIIIIlIllIlll.nextString());
            return new Time(lllllllllllllllIlIIlIIIIlIlllIlI.getTime());
        }
        catch (ParseException lllllllllllllllIlIIlIIIIlIlllIIl) {
            throw new JsonSyntaxException(lllllllllllllllIlIIlIIIIlIlllIIl);
        }
    }
    
    static {
        FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson lllllllllllllllIIlllIlIIlllIIlIl, final TypeToken<T> lllllllllllllllIIlllIlIIlllIIlII) {
                return (TypeAdapter<T>)((lllllllllllllllIIlllIlIIlllIIlII.getRawType() == Time.class) ? new TimeTypeAdapter() : null);
            }
        };
    }
}
