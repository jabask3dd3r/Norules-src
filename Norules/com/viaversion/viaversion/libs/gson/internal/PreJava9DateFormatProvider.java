package com.viaversion.viaversion.libs.gson.internal;

import java.util.*;
import java.text.*;

public class PreJava9DateFormatProvider
{
    private static String getDatePartOfDateTimePattern(final int lllllllllllllIIllIIIlllIlllllIlI) {
        switch (lllllllllllllIIllIIIlllIlllllIlI) {
            case 3: {
                return "M/d/yy";
            }
            case 2: {
                return "MMM d, yyyy";
            }
            case 1: {
                return "MMMM d, yyyy";
            }
            case 0: {
                return "EEEE, MMMM d, yyyy";
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unknown DateFormat style: ").append(lllllllllllllIIllIIIlllIlllllIlI)));
            }
        }
    }
    
    public static DateFormat getUSDateFormat(final int lllllllllllllIIllIIIllllIIIIlIII) {
        return new SimpleDateFormat(getDateFormatPattern(lllllllllllllIIllIIIllllIIIIlIII), Locale.US);
    }
    
    private static String getDateFormatPattern(final int lllllllllllllIIllIIIlllIllllllIl) {
        switch (lllllllllllllIIllIIIlllIllllllIl) {
            case 3: {
                return "M/d/yy";
            }
            case 2: {
                return "MMM d, y";
            }
            case 1: {
                return "MMMM d, y";
            }
            case 0: {
                return "EEEE, MMMM d, y";
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unknown DateFormat style: ").append(lllllllllllllIIllIIIlllIllllllIl)));
            }
        }
    }
    
    private static String getTimePartOfDateTimePattern(final int lllllllllllllIIllIIIlllIllllIlll) {
        switch (lllllllllllllIIllIIIlllIllllIlll) {
            case 3: {
                return "h:mm a";
            }
            case 2: {
                return "h:mm:ss a";
            }
            case 0:
            case 1: {
                return "h:mm:ss a z";
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unknown DateFormat style: ").append(lllllllllllllIIllIIIlllIllllIlll)));
            }
        }
    }
    
    public static DateFormat getUSDateTimeFormat(final int lllllllllllllIIllIIIllllIIIIIlII, final int lllllllllllllIIllIIIllllIIIIIIll) {
        final String lllllllllllllIIllIIIllllIIIIIIlI = String.valueOf(new StringBuilder().append(getDatePartOfDateTimePattern(lllllllllllllIIllIIIllllIIIIIlII)).append(" ").append(getTimePartOfDateTimePattern(lllllllllllllIIllIIIllllIIIIIIll)));
        return new SimpleDateFormat(lllllllllllllIIllIIIllllIIIIIIlI, Locale.US);
    }
}
