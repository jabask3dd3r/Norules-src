package com.viaversion.viaversion.libs.gson;

import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.internal.bind.util.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.sql.*;
import java.text.*;

final class DefaultDateTypeAdapter extends TypeAdapter<Date>
{
    private final /* synthetic */ Class<? extends Date> dateType;
    private final /* synthetic */ List<DateFormat> dateFormats;
    
    DefaultDateTypeAdapter(final Class<? extends Date> llllllllllllllIIIlIIllIlllIlIIlI) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = verifyDateType(llllllllllllllIIIlIIllIlllIlIIlI);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }
    
    private Date deserializeToDate(final String llllllllllllllIIIlIIllIllIIIIIlI) {
        synchronized (this.dateFormats) {
            for (final DateFormat llllllllllllllIIIlIIllIllIIIIlll : this.dateFormats) {
                try {
                    return llllllllllllllIIIlIIllIllIIIIlll.parse(llllllllllllllIIIlIIllIllIIIIIlI);
                }
                catch (ParseException llllllllllllllIIIlIIllIlIllllllI) {
                    continue;
                }
                break;
            }
            try {
                return ISO8601Utils.parse(llllllllllllllIIIlIIllIllIIIIIlI, new ParsePosition(0));
            }
            catch (ParseException llllllllllllllIIIlIIllIllIIIIllI) {
                throw new JsonSyntaxException(llllllllllllllIIIlIIllIllIIIIIlI, llllllllllllllIIIlIIllIllIIIIllI);
            }
        }
    }
    
    @Override
    public Date read(final JsonReader llllllllllllllIIIlIIllIllIIlIIll) throws IOException {
        if (llllllllllllllIIIlIIllIllIIlIIll.peek() == JsonToken.NULL) {
            llllllllllllllIIIlIIllIllIIlIIll.nextNull();
            return null;
        }
        final Date llllllllllllllIIIlIIllIllIIlIIlI = this.deserializeToDate(llllllllllllllIIIlIIllIllIIlIIll.nextString());
        if (this.dateType == Date.class) {
            return llllllllllllllIIIlIIllIllIIlIIlI;
        }
        if (this.dateType == Timestamp.class) {
            return new Timestamp(llllllllllllllIIIlIIllIllIIlIIlI.getTime());
        }
        if (this.dateType == java.sql.Date.class) {
            return new java.sql.Date(llllllllllllllIIIlIIllIllIIlIIlI.getTime());
        }
        throw new AssertionError();
    }
    
    public DefaultDateTypeAdapter(final int llllllllllllllIIIlIIllIllIlllIII, final int llllllllllllllIIIlIIllIllIlllIlI) {
        this(Date.class, llllllllllllllIIIlIIllIllIlllIII, llllllllllllllIIIlIIllIllIlllIlI);
    }
    
    private static Class<? extends Date> verifyDateType(final Class<? extends Date> llllllllllllllIIIlIIllIllIlIlIII) {
        if (llllllllllllllIIIlIIllIllIlIlIII != Date.class && llllllllllllllIIIlIIllIllIlIlIII != java.sql.Date.class && llllllllllllllIIIlIIllIllIlIlIII != Timestamp.class) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Date type must be one of ").append(Date.class).append(", ").append(Timestamp.class).append(", or ").append(java.sql.Date.class).append(" but was ").append(llllllllllllllIIIlIIllIllIlIlIII)));
        }
        return llllllllllllllIIIlIIllIllIlIlIII;
    }
    
    @Override
    public String toString() {
        final DateFormat llllllllllllllIIIlIIllIlIllllIIl = this.dateFormats.get(0);
        if (llllllllllllllIIIlIIllIlIllllIIl instanceof SimpleDateFormat) {
            return String.valueOf(new StringBuilder().append("DefaultDateTypeAdapter(").append(((SimpleDateFormat)llllllllllllllIIIlIIllIlIllllIIl).toPattern()).append(')'));
        }
        return String.valueOf(new StringBuilder().append("DefaultDateTypeAdapter(").append(llllllllllllllIIIlIIllIlIllllIIl.getClass().getSimpleName()).append(')'));
    }
    
    static {
        SIMPLE_NAME = "DefaultDateTypeAdapter";
    }
    
    @Override
    public void write(final JsonWriter llllllllllllllIIIlIIllIllIIlllll, final Date llllllllllllllIIIlIIllIllIIllllI) throws IOException {
        if (llllllllllllllIIIlIIllIllIIllllI == null) {
            llllllllllllllIIIlIIllIllIIlllll.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            final String llllllllllllllIIIlIIllIllIlIIIIl = this.dateFormats.get(0).format(llllllllllllllIIIlIIllIllIIllllI);
            llllllllllllllIIIlIIllIllIIlllll.value(llllllllllllllIIIlIIllIllIlIIIIl);
        }
    }
    
    public DefaultDateTypeAdapter(final Class<? extends Date> llllllllllllllIIIlIIllIllIlIllIl, final int llllllllllllllIIIlIIllIllIlIllII, final int llllllllllllllIIIlIIllIllIlIlIll) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = verifyDateType(llllllllllllllIIIlIIllIllIlIllIl);
        this.dateFormats.add(DateFormat.getDateTimeInstance(llllllllllllllIIIlIIllIllIlIllII, llllllllllllllIIIlIIllIllIlIlIll, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(llllllllllllllIIIlIIllIllIlIllII, llllllllllllllIIIlIIllIllIlIlIll));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(llllllllllllllIIIlIIllIllIlIllII, llllllllllllllIIIlIIllIllIlIlIll));
        }
    }
    
    DefaultDateTypeAdapter(final Class<? extends Date> llllllllllllllIIIlIIllIlllIIIIIl, final int llllllllllllllIIIlIIllIlllIIIIII) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = verifyDateType(llllllllllllllIIIlIIllIlllIIIIIl);
        this.dateFormats.add(DateFormat.getDateInstance(llllllllllllllIIIlIIllIlllIIIIII, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(llllllllllllllIIIlIIllIlllIIIIII));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(llllllllllllllIIIlIIllIlllIIIIII));
        }
    }
    
    DefaultDateTypeAdapter(final Class<? extends Date> llllllllllllllIIIlIIllIlllIIlIlI, final String llllllllllllllIIIlIIllIlllIIlIIl) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = verifyDateType(llllllllllllllIIIlIIllIlllIIlIlI);
        this.dateFormats.add(new SimpleDateFormat(llllllllllllllIIIlIIllIlllIIlIIl, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(llllllllllllllIIIlIIllIlllIIlIIl));
        }
    }
}
