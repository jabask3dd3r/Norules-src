package com.viaversion.viaversion.libs.gson;

import java.lang.reflect.*;
import java.util.*;

public enum FieldNamingPolicy implements FieldNamingStrategy
{
    UPPER_CAMEL_CASE(1) {
        @Override
        public String translateName(final Field lllllllllllllIlllllIIlIlIIlIllII) {
            return FieldNamingPolicy.upperCaseFirstLetter(lllllllllllllIlllllIIlIlIIlIllII.getName());
        }
    }, 
    IDENTITY(0) {
        @Override
        public String translateName(final Field lllllllllllllIlIIlllllIIIlllIIlI) {
            return lllllllllllllIlIIlllllIIIlllIIlI.getName();
        }
    }, 
    LOWER_CASE_WITH_DASHES(4) {
        @Override
        public String translateName(final Field lllllllllllllllIlIIllIlllIllIIIl) {
            return FieldNamingPolicy.separateCamelCase(lllllllllllllllIlIIllIlllIllIIIl.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_DOTS(5) {
        @Override
        public String translateName(final Field llllllllllllllIIlIlIlIIlllllIllI) {
            return FieldNamingPolicy.separateCamelCase(llllllllllllllIIlIlIlIIlllllIllI.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_UNDERSCORES(3) {
        @Override
        public String translateName(final Field lllllllllllllIIIIIllIIIIIIlIlIll) {
            return FieldNamingPolicy.separateCamelCase(lllllllllllllIIIIIllIIIIIIlIlIll.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }, 
    UPPER_CAMEL_CASE_WITH_SPACES(2) {
        @Override
        public String translateName(final Field lllllllllllllIlIIlllIIIlIlIlIlII) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(lllllllllllllIlIIlllIIIlIlIlIlII.getName(), " "));
        }
    };
    
    static String upperCaseFirstLetter(final String lllllllllllllIlIIIIIlIIIIIlIlIIl) {
        int lllllllllllllIlIIIIIlIIIIIlIlIII = 0;
        for (int lllllllllllllIlIIIIIlIIIIIlIIlll = lllllllllllllIlIIIIIlIIIIIlIlIIl.length() - 1; !Character.isLetter(lllllllllllllIlIIIIIlIIIIIlIlIIl.charAt(lllllllllllllIlIIIIIlIIIIIlIlIII)) && lllllllllllllIlIIIIIlIIIIIlIlIII < lllllllllllllIlIIIIIlIIIIIlIIlll; ++lllllllllllllIlIIIIIlIIIIIlIlIII) {}
        final char lllllllllllllIlIIIIIlIIIIIlIIllI = lllllllllllllIlIIIIIlIIIIIlIlIIl.charAt(lllllllllllllIlIIIIIlIIIIIlIlIII);
        if (Character.isUpperCase(lllllllllllllIlIIIIIlIIIIIlIIllI)) {
            return lllllllllllllIlIIIIIlIIIIIlIlIIl;
        }
        final char lllllllllllllIlIIIIIlIIIIIlIIlIl = Character.toUpperCase(lllllllllllllIlIIIIIlIIIIIlIIllI);
        if (lllllllllllllIlIIIIIlIIIIIlIlIII == 0) {
            return String.valueOf(new StringBuilder().append(lllllllllllllIlIIIIIlIIIIIlIIlIl).append(lllllllllllllIlIIIIIlIIIIIlIlIIl.substring(1)));
        }
        return String.valueOf(new StringBuilder().append(lllllllllllllIlIIIIIlIIIIIlIlIIl.substring(0, lllllllllllllIlIIIIIlIIIIIlIlIII)).append(lllllllllllllIlIIIIIlIIIIIlIIlIl).append(lllllllllllllIlIIIIIlIIIIIlIlIIl.substring(lllllllllllllIlIIIIIlIIIIIlIlIII + 1)));
    }
    
    static String separateCamelCase(final String lllllllllllllIlIIIIIlIIIIIllIlII, final String lllllllllllllIlIIIIIlIIIIIllIllI) {
        final StringBuilder lllllllllllllIlIIIIIlIIIIIllIlIl = new StringBuilder();
        for (int lllllllllllllIlIIIIIlIIIIIlllIIl = 0, lllllllllllllIlIIIIIlIIIIIlllIII = lllllllllllllIlIIIIIlIIIIIllIlII.length(); lllllllllllllIlIIIIIlIIIIIlllIIl < lllllllllllllIlIIIIIlIIIIIlllIII; ++lllllllllllllIlIIIIIlIIIIIlllIIl) {
            final char lllllllllllllIlIIIIIlIIIIIlllIlI = lllllllllllllIlIIIIIlIIIIIllIlII.charAt(lllllllllllllIlIIIIIlIIIIIlllIIl);
            if (Character.isUpperCase(lllllllllllllIlIIIIIlIIIIIlllIlI) && lllllllllllllIlIIIIIlIIIIIllIlIl.length() != 0) {
                lllllllllllllIlIIIIIlIIIIIllIlIl.append(lllllllllllllIlIIIIIlIIIIIllIllI);
            }
            lllllllllllllIlIIIIIlIIIIIllIlIl.append(lllllllllllllIlIIIIIlIIIIIlllIlI);
        }
        return String.valueOf(lllllllllllllIlIIIIIlIIIIIllIlIl);
    }
}
