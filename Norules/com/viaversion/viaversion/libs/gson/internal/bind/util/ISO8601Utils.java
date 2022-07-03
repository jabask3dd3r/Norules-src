package com.viaversion.viaversion.libs.gson.internal.bind.util;

import java.util.*;
import java.text.*;

public class ISO8601Utils
{
    private static final /* synthetic */ TimeZone TIMEZONE_UTC;
    
    public static String format(final Date llllllllllllllIllllllIIIlIIIIllI, final boolean llllllllllllllIllllllIIIlIIIIIll) {
        return format(llllllllllllllIllllllIIIlIIIIllI, llllllllllllllIllllllIIIlIIIIIll, ISO8601Utils.TIMEZONE_UTC);
    }
    
    private static int parseInt(final String llllllllllllllIllllllIIIIIIIllll, final int llllllllllllllIllllllIIIIIIIlllI, final int llllllllllllllIllllllIIIIIIlIIlI) throws NumberFormatException {
        if (llllllllllllllIllllllIIIIIIIlllI < 0 || llllllllllllllIllllllIIIIIIlIIlI > llllllllllllllIllllllIIIIIIIllll.length() || llllllllllllllIllllllIIIIIIIlllI > llllllllllllllIllllllIIIIIIlIIlI) {
            throw new NumberFormatException(llllllllllllllIllllllIIIIIIIllll);
        }
        int llllllllllllllIllllllIIIIIIlIIIl = llllllllllllllIllllllIIIIIIIlllI;
        int llllllllllllllIllllllIIIIIIlIIII = 0;
        if (llllllllllllllIllllllIIIIIIlIIIl < llllllllllllllIllllllIIIIIIlIIlI) {
            final int llllllllllllllIllllllIIIIIIlIllI = Character.digit(llllllllllllllIllllllIIIIIIIllll.charAt(llllllllllllllIllllllIIIIIIlIIIl++), 10);
            if (llllllllllllllIllllllIIIIIIlIllI < 0) {
                throw new NumberFormatException(String.valueOf(new StringBuilder().append("Invalid number: ").append(llllllllllllllIllllllIIIIIIIllll.substring(llllllllllllllIllllllIIIIIIIlllI, llllllllllllllIllllllIIIIIIlIIlI))));
            }
            llllllllllllllIllllllIIIIIIlIIII = -llllllllllllllIllllllIIIIIIlIllI;
        }
        while (llllllllllllllIllllllIIIIIIlIIIl < llllllllllllllIllllllIIIIIIlIIlI) {
            final int llllllllllllllIllllllIIIIIIlIlIl = Character.digit(llllllllllllllIllllllIIIIIIIllll.charAt(llllllllllllllIllllllIIIIIIlIIIl++), 10);
            if (llllllllllllllIllllllIIIIIIlIlIl < 0) {
                throw new NumberFormatException(String.valueOf(new StringBuilder().append("Invalid number: ").append(llllllllllllllIllllllIIIIIIIllll.substring(llllllllllllllIllllllIIIIIIIlllI, llllllllllllllIllllllIIIIIIlIIlI))));
            }
            llllllllllllllIllllllIIIIIIlIIII *= 10;
            llllllllllllllIllllllIIIIIIlIIII -= llllllllllllllIllllllIIIIIIlIlIl;
        }
        return -llllllllllllllIllllllIIIIIIlIIII;
    }
    
    public static String format(final Date llllllllllllllIllllllIIIlIIIlIlI) {
        return format(llllllllllllllIllllllIIIlIIIlIlI, false, ISO8601Utils.TIMEZONE_UTC);
    }
    
    private static void padInt(final StringBuilder llllllllllllllIlllllIlllllllllll, final int llllllllllllllIllllllIIIIIIIIIlI, final int llllllllllllllIllllllIIIIIIIIIIl) {
        final String llllllllllllllIllllllIIIIIIIIIII = Integer.toString(llllllllllllllIllllllIIIIIIIIIlI);
        for (int llllllllllllllIllllllIIIIIIIIlII = llllllllllllllIllllllIIIIIIIIIIl - llllllllllllllIllllllIIIIIIIIIII.length(); llllllllllllllIllllllIIIIIIIIlII > 0; --llllllllllllllIllllllIIIIIIIIlII) {
            llllllllllllllIlllllIlllllllllll.append('0');
        }
        llllllllllllllIlllllIlllllllllll.append(llllllllllllllIllllllIIIIIIIIIII);
    }
    
    private static int indexOfNonDigit(final String llllllllllllllIlllllIlllllllIIlI, final int llllllllllllllIlllllIlllllllIIIl) {
        for (int llllllllllllllIlllllIlllllllIlIl = llllllllllllllIlllllIlllllllIIIl; llllllllllllllIlllllIlllllllIlIl < llllllllllllllIlllllIlllllllIIlI.length(); ++llllllllllllllIlllllIlllllllIlIl) {
            final char llllllllllllllIlllllIlllllllIllI = llllllllllllllIlllllIlllllllIIlI.charAt(llllllllllllllIlllllIlllllllIlIl);
            if (llllllllllllllIlllllIlllllllIllI < '0' || llllllllllllllIlllllIlllllllIllI > '9') {
                return llllllllllllllIlllllIlllllllIlIl;
            }
        }
        return llllllllllllllIlllllIlllllllIIlI.length();
    }
    
    public static String format(final Date llllllllllllllIllllllIIIIlllIIII, final boolean llllllllllllllIllllllIIIIllIllll, final TimeZone llllllllllllllIllllllIIIIllIlllI) {
        final Calendar llllllllllllllIllllllIIIIlllIlII = new GregorianCalendar(llllllllllllllIllllllIIIIllIlllI, Locale.US);
        llllllllllllllIllllllIIIIlllIlII.setTime(llllllllllllllIllllllIIIIlllIIII);
        int llllllllllllllIllllllIIIIlllIIll = "yyyy-MM-ddThh:mm:ss".length();
        llllllllllllllIllllllIIIIlllIIll += (llllllllllllllIllllllIIIIllIllll ? ".sss".length() : 0);
        llllllllllllllIllllllIIIIlllIIll += ((llllllllllllllIllllllIIIIllIlllI.getRawOffset() == 0) ? "Z".length() : "+hh:mm".length());
        final StringBuilder llllllllllllllIllllllIIIIlllIIlI = new StringBuilder(llllllllllllllIllllllIIIIlllIIll);
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(1), "yyyy".length());
        llllllllllllllIllllllIIIIlllIIlI.append('-');
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(2) + 1, "MM".length());
        llllllllllllllIllllllIIIIlllIIlI.append('-');
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(5), "dd".length());
        llllllllllllllIllllllIIIIlllIIlI.append('T');
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(11), "hh".length());
        llllllllllllllIllllllIIIIlllIIlI.append(':');
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(12), "mm".length());
        llllllllllllllIllllllIIIIlllIIlI.append(':');
        padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(13), "ss".length());
        if (llllllllllllllIllllllIIIIllIllll) {
            llllllllllllllIllllllIIIIlllIIlI.append('.');
            padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIlllIlII.get(14), "sss".length());
        }
        final int llllllllllllllIllllllIIIIlllIIIl = llllllllllllllIllllllIIIIllIlllI.getOffset(llllllllllllllIllllllIIIIlllIlII.getTimeInMillis());
        if (llllllllllllllIllllllIIIIlllIIIl != 0) {
            final int llllllllllllllIllllllIIIIllllIIl = Math.abs(llllllllllllllIllllllIIIIlllIIIl / 60000 / 60);
            final int llllllllllllllIllllllIIIIllllIII = Math.abs(llllllllllllllIllllllIIIIlllIIIl / 60000 % 60);
            llllllllllllllIllllllIIIIlllIIlI.append((llllllllllllllIllllllIIIIlllIIIl < 0) ? '-' : '+');
            padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIllllIIl, "hh".length());
            llllllllllllllIllllllIIIIlllIIlI.append(':');
            padInt(llllllllllllllIllllllIIIIlllIIlI, llllllllllllllIllllllIIIIllllIII, "mm".length());
        }
        else {
            llllllllllllllIllllllIIIIlllIIlI.append('Z');
        }
        return String.valueOf(llllllllllllllIllllllIIIIlllIIlI);
    }
    
    static {
        UTC_ID = "UTC";
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    }
    
    public static Date parse(final String llllllllllllllIllllllIIIIIllllIl, final ParsePosition llllllllllllllIllllllIIIIIllllII) throws ParseException {
        Exception llllllllllllllIllllllIIIIIlllIll = null;
        try {
            final int index;
            int llllllllllllllIllllllIIIIlIIllII = index = llllllllllllllIllllllIIIIIllllII.getIndex();
            llllllllllllllIllllllIIIIlIIllII += 4;
            final int llllllllllllllIllllllIIIIlIIlIll = parseInt(llllllllllllllIllllllIIIIIllllIl, index, llllllllllllllIllllllIIIIlIIllII);
            if (checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, '-')) {
                ++llllllllllllllIllllllIIIIlIIllII;
            }
            final int llllllllllllllIllllllIIIIIIIlllI = llllllllllllllIllllllIIIIlIIllII;
            llllllllllllllIllllllIIIIlIIllII += 2;
            final int llllllllllllllIllllllIIIIlIIlIlI = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIIIIlllI, llllllllllllllIllllllIIIIlIIllII);
            if (checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, '-')) {
                ++llllllllllllllIllllllIIIIlIIllII;
            }
            final int llllllllllllllIllllllIIIIIIIlllI2 = llllllllllllllIllllllIIIIlIIllII;
            llllllllllllllIllllllIIIIlIIllII += 2;
            final int llllllllllllllIllllllIIIIlIIlIIl = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIIIIlllI2, llllllllllllllIllllllIIIIlIIllII);
            int llllllllllllllIllllllIIIIlIIlIII = 0;
            int llllllllllllllIllllllIIIIlIIIlll = 0;
            int llllllllllllllIllllllIIIIlIIIllI = 0;
            int llllllllllllllIllllllIIIIlIIIlIl = 0;
            final boolean llllllllllllllIllllllIIIIlIIIlII = checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, 'T');
            if (!llllllllllllllIllllllIIIIlIIIlII && llllllllllllllIllllllIIIIIllllIl.length() <= llllllllllllllIllllllIIIIlIIllII) {
                final Calendar llllllllllllllIllllllIIIIlIlIlIl = new GregorianCalendar(llllllllllllllIllllllIIIIlIIlIll, llllllllllllllIllllllIIIIlIIlIlI - 1, llllllllllllllIllllllIIIIlIIlIIl);
                llllllllllllllIllllllIIIIIllllII.setIndex(llllllllllllllIllllllIIIIlIIllII);
                return llllllllllllllIllllllIIIIlIlIlIl.getTime();
            }
            if (llllllllllllllIllllllIIIIlIIIlII) {
                final int llllllllllllllIllllllIIIIIIIlllI3 = ++llllllllllllllIllllllIIIIlIIllII;
                llllllllllllllIllllllIIIIlIIllII += 2;
                llllllllllllllIllllllIIIIlIIlIII = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIIIIlllI3, llllllllllllllIllllllIIIIlIIllII);
                if (checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, ':')) {
                    ++llllllllllllllIllllllIIIIlIIllII;
                }
                final int llllllllllllllIllllllIIIIIIIlllI4 = llllllllllllllIllllllIIIIlIIllII;
                llllllllllllllIllllllIIIIlIIllII += 2;
                llllllllllllllIllllllIIIIlIIIlll = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIIIIlllI4, llllllllllllllIllllllIIIIlIIllII);
                if (checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, ':')) {
                    ++llllllllllllllIllllllIIIIlIIllII;
                }
                if (llllllllllllllIllllllIIIIIllllIl.length() > llllllllllllllIllllllIIIIlIIllII) {
                    final char llllllllllllllIllllllIIIIlIlIIIl = llllllllllllllIllllllIIIIIllllIl.charAt(llllllllllllllIllllllIIIIlIIllII);
                    if (llllllllllllllIllllllIIIIlIlIIIl != 'Z' && llllllllllllllIllllllIIIIlIlIIIl != '+' && llllllllllllllIllllllIIIIlIlIIIl != '-') {
                        final int llllllllllllllIllllllIIIIIIIlllI5 = llllllllllllllIllllllIIIIlIIllII;
                        llllllllllllllIllllllIIIIlIIllII += 2;
                        llllllllllllllIllllllIIIIlIIIllI = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIIIIlllI5, llllllllllllllIllllllIIIIlIIllII);
                        if (llllllllllllllIllllllIIIIlIIIllI > 59 && llllllllllllllIllllllIIIIlIIIllI < 63) {
                            llllllllllllllIllllllIIIIlIIIllI = 59;
                        }
                        if (checkOffset(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, '.')) {
                            ++llllllllllllllIllllllIIIIlIIllII;
                            final int llllllllllllllIllllllIIIIlIlIlII = indexOfNonDigit(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII + 1);
                            final int llllllllllllllIllllllIIIIlIlIIll = Math.min(llllllllllllllIllllllIIIIlIlIlII, llllllllllllllIllllllIIIIlIIllII + 3);
                            final int llllllllllllllIllllllIIIIlIlIIlI = parseInt(llllllllllllllIllllllIIIIIllllIl, llllllllllllllIllllllIIIIlIIllII, llllllllllllllIllllllIIIIlIlIIll);
                            switch (llllllllllllllIllllllIIIIlIlIIll - llllllllllllllIllllllIIIIlIIllII) {
                                case 2: {
                                    llllllllllllllIllllllIIIIlIIIlIl = llllllllllllllIllllllIIIIlIlIIlI * 10;
                                    break;
                                }
                                case 1: {
                                    llllllllllllllIllllllIIIIlIIIlIl = llllllllllllllIllllllIIIIlIlIIlI * 100;
                                    break;
                                }
                                default: {
                                    llllllllllllllIllllllIIIIlIIIlIl = llllllllllllllIllllllIIIIlIlIIlI;
                                    break;
                                }
                            }
                            llllllllllllllIllllllIIIIlIIllII = llllllllllllllIllllllIIIIlIlIlII;
                        }
                    }
                }
            }
            if (llllllllllllllIllllllIIIIIllllIl.length() <= llllllllllllllIllllllIIIIlIIllII) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            TimeZone llllllllllllllIllllllIIIIlIIIIll = null;
            final char llllllllllllllIllllllIIIIlIIIIlI = llllllllllllllIllllllIIIIIllllIl.charAt(llllllllllllllIllllllIIIIlIIllII);
            if (llllllllllllllIllllllIIIIlIIIIlI == 'Z') {
                llllllllllllllIllllllIIIIlIIIIll = ISO8601Utils.TIMEZONE_UTC;
                ++llllllllllllllIllllllIIIIlIIllII;
            }
            else {
                if (llllllllllllllIllllllIIIIlIIIIlI != '+' && llllllllllllllIllllllIIIIlIIIIlI != '-') {
                    throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Invalid time zone indicator '").append(llllllllllllllIllllllIIIIlIIIIlI).append("'")));
                }
                String llllllllllllllIllllllIIIIlIIllIl = llllllllllllllIllllllIIIIIllllIl.substring(llllllllllllllIllllllIIIIlIIllII);
                llllllllllllllIllllllIIIIlIIllIl = ((llllllllllllllIllllllIIIIlIIllIl.length() >= 5) ? llllllllllllllIllllllIIIIlIIllIl : String.valueOf(new StringBuilder().append(llllllllllllllIllllllIIIIlIIllIl).append("00")));
                llllllllllllllIllllllIIIIlIIllII += llllllllllllllIllllllIIIIlIIllIl.length();
                if ("+0000".equals(llllllllllllllIllllllIIIIlIIllIl) || "+00:00".equals(llllllllllllllIllllllIIIIlIIllIl)) {
                    llllllllllllllIllllllIIIIlIIIIll = ISO8601Utils.TIMEZONE_UTC;
                }
                else {
                    final String llllllllllllllIllllllIIIIlIIllll = String.valueOf(new StringBuilder().append("GMT").append(llllllllllllllIllllllIIIIlIIllIl));
                    llllllllllllllIllllllIIIIlIIIIll = TimeZone.getTimeZone(llllllllllllllIllllllIIIIlIIllll);
                    final String llllllllllllllIllllllIIIIlIIlllI = llllllllllllllIllllllIIIIlIIIIll.getID();
                    if (!llllllllllllllIllllllIIIIlIIlllI.equals(llllllllllllllIllllllIIIIlIIllll)) {
                        final String llllllllllllllIllllllIIIIlIlIIII = llllllllllllllIllllllIIIIlIIlllI.replace(":", "");
                        if (!llllllllllllllIllllllIIIIlIlIIII.equals(llllllllllllllIllllllIIIIlIIllll)) {
                            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Mismatching time zone indicator: ").append(llllllllllllllIllllllIIIIlIIllll).append(" given, resolves to ").append(llllllllllllllIllllllIIIIlIIIIll.getID())));
                        }
                    }
                }
            }
            final Calendar llllllllllllllIllllllIIIIlIIIIIl = new GregorianCalendar(llllllllllllllIllllllIIIIlIIIIll);
            llllllllllllllIllllllIIIIlIIIIIl.setLenient(false);
            llllllllllllllIllllllIIIIlIIIIIl.set(1, llllllllllllllIllllllIIIIlIIlIll);
            llllllllllllllIllllllIIIIlIIIIIl.set(2, llllllllllllllIllllllIIIIlIIlIlI - 1);
            llllllllllllllIllllllIIIIlIIIIIl.set(5, llllllllllllllIllllllIIIIlIIlIIl);
            llllllllllllllIllllllIIIIlIIIIIl.set(11, llllllllllllllIllllllIIIIlIIlIII);
            llllllllllllllIllllllIIIIlIIIIIl.set(12, llllllllllllllIllllllIIIIlIIIlll);
            llllllllllllllIllllllIIIIlIIIIIl.set(13, llllllllllllllIllllllIIIIlIIIllI);
            llllllllllllllIllllllIIIIlIIIIIl.set(14, llllllllllllllIllllllIIIIlIIIlIl);
            llllllllllllllIllllllIIIIIllllII.setIndex(llllllllllllllIllllllIIIIlIIllII);
            return llllllllllllllIllllllIIIIlIIIIIl.getTime();
        }
        catch (IndexOutOfBoundsException llllllllllllllIllllllIIIIlIIIIII) {
            llllllllllllllIllllllIIIIIlllIll = llllllllllllllIllllllIIIIlIIIIII;
        }
        catch (NumberFormatException llllllllllllllIllllllIIIIIllllll) {
            llllllllllllllIllllllIIIIIlllIll = llllllllllllllIllllllIIIIIllllll;
        }
        catch (IllegalArgumentException llllllllllllllIllllllIIIIIlllllI) {
            llllllllllllllIllllllIIIIIlllIll = llllllllllllllIllllllIIIIIlllllI;
        }
        final String llllllllllllllIllllllIIIIIlllIlI = (llllllllllllllIllllllIIIIIllllIl == null) ? null : String.valueOf(new StringBuilder().append('\"').append(llllllllllllllIllllllIIIIIllllIl).append('\"'));
        String llllllllllllllIllllllIIIIIlllIIl = llllllllllllllIllllllIIIIIlllIll.getMessage();
        if (llllllllllllllIllllllIIIIIlllIIl == null || llllllllllllllIllllllIIIIIlllIIl.isEmpty()) {
            llllllllllllllIllllllIIIIIlllIIl = String.valueOf(new StringBuilder().append("(").append(llllllllllllllIllllllIIIIIlllIll.getClass().getName()).append(")"));
        }
        final ParseException llllllllllllllIllllllIIIIIlllIII = new ParseException(String.valueOf(new StringBuilder().append("Failed to parse date [").append(llllllllllllllIllllllIIIIIlllIlI).append("]: ").append(llllllllllllllIllllllIIIIIlllIIl)), llllllllllllllIllllllIIIIIllllII.getIndex());
        llllllllllllllIllllllIIIIIlllIII.initCause(llllllllllllllIllllllIIIIIlllIll);
        throw llllllllllllllIllllllIIIIIlllIII;
    }
    
    private static boolean checkOffset(final String llllllllllllllIllllllIIIIIIlllll, final int llllllllllllllIllllllIIIIIlIIIIl, final char llllllllllllllIllllllIIIIIIlllIl) {
        return llllllllllllllIllllllIIIIIlIIIIl < llllllllllllllIllllllIIIIIIlllll.length() && llllllllllllllIllllllIIIIIIlllll.charAt(llllllllllllllIllllllIIIIIlIIIIl) == llllllllllllllIllllllIIIIIIlllIl;
    }
}
