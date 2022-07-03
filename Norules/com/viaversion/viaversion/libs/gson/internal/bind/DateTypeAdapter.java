package com.viaversion.viaversion.libs.gson.internal.bind;

import java.io.*;
import java.text.*;
import com.viaversion.viaversion.libs.gson.internal.bind.util.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.reflect.*;

public final class DateTypeAdapter extends TypeAdapter<Date>
{
    private final /* synthetic */ List<DateFormat> dateFormats;
    
    @Override
    public Date read(final JsonReader lllllllllllllIIIlllIIIIlIIlIllIl) throws IOException {
        if (lllllllllllllIIIlllIIIIlIIlIllIl.peek() == JsonToken.NULL) {
            lllllllllllllIIIlllIIIIlIIlIllIl.nextNull();
            return null;
        }
        return this.deserializeToDate(lllllllllllllIIIlllIIIIlIIlIllIl.nextString());
    }
    
    private synchronized Date deserializeToDate(final String lllllllllllllIIIlllIIIIlIIlIIlII) {
        for (final DateFormat lllllllllllllIIIlllIIIIlIIlIIlll : this.dateFormats) {
            try {
                return lllllllllllllIIIlllIIIIlIIlIIlll.parse(lllllllllllllIIIlllIIIIlIIlIIlII);
            }
            catch (ParseException lllllllllllllIIIlllIIIIlIIIlllll) {
                continue;
            }
            break;
        }
        try {
            return ISO8601Utils.parse(lllllllllllllIIIlllIIIIlIIlIIlII, new ParsePosition(0));
        }
        catch (ParseException lllllllllllllIIIlllIIIIlIIlIIllI) {
            throw new JsonSyntaxException(lllllllllllllIIIlllIIIIlIIlIIlII, lllllllllllllIIIlllIIIIlIIlIIllI);
        }
    }
    
    public DateTypeAdapter() {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }
    
    @Override
    public synchronized void write(final JsonWriter lllllllllllllIIIlllIIIIlIIIllIIl, final Date lllllllllllllIIIlllIIIIlIIIlIlII) throws IOException {
        if (lllllllllllllIIIlllIIIIlIIIlIlII == null) {
            lllllllllllllIIIlllIIIIlIIIllIIl.nullValue();
            return;
        }
        final String lllllllllllllIIIlllIIIIlIIIlIlll = this.dateFormats.get(0).format(lllllllllllllIIIlllIIIIlIIIlIlII);
        lllllllllllllIIIlllIIIIlIIIllIIl.value(lllllllllllllIIIlllIIIIlIIIlIlll);
    }
    
    static {
        FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson llllIIlIlllllll, final TypeToken<T> llllIIlIlllllIl) {
                return (TypeAdapter<T>)((llllIIlIlllllIl.getRawType() == Date.class) ? new DateTypeAdapter() : null);
            }
        };
    }
}
