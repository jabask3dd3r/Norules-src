package net.minecraft.util.text.translation;

import java.util.regex.*;
import com.google.common.base.*;
import java.util.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import com.google.common.collect.*;
import java.io.*;

public class LanguageMap
{
    private static final /* synthetic */ Pattern NUMERIC_VARIABLE_PATTERN;
    private static final /* synthetic */ Splitter EQUAL_SIGN_SPLITTER;
    private /* synthetic */ long lastUpdateTimeInMilliseconds;
    private static final /* synthetic */ LanguageMap instance;
    private final /* synthetic */ Map<String, String> languageList;
    
    static {
        NUMERIC_VARIABLE_PATTERN = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
        EQUAL_SIGN_SPLITTER = Splitter.on('=').limit(2);
        instance = new LanguageMap();
    }
    
    public synchronized String translateKeyFormat(final String lllllllllllllIlllIIIIIIlIIllIlII, final Object... lllllllllllllIlllIIIIIIlIIlIlllI) {
        final String lllllllllllllIlllIIIIIIlIIllIIlI = this.tryTranslateKey(lllllllllllllIlllIIIIIIlIIllIlII);
        try {
            return String.format(lllllllllllllIlllIIIIIIlIIllIIlI, lllllllllllllIlllIIIIIIlIIlIlllI);
        }
        catch (IllegalFormatException lllllllllllllIlllIIIIIIlIIllIIIl) {
            return String.valueOf(new StringBuilder("Format error: ").append(lllllllllllllIlllIIIIIIlIIllIIlI));
        }
    }
    
    public LanguageMap() {
        this.languageList = (Map<String, String>)Maps.newHashMap();
        try {
            final InputStream lllllllllllllIlllIIIIIIlIlIIllll = LanguageMap.class.getResourceAsStream("/assets/minecraft/lang/en_us.lang");
            for (final String lllllllllllllIlllIIIIIIlIlIIlllI : IOUtils.readLines(lllllllllllllIlllIIIIIIlIlIIllll, StandardCharsets.UTF_8)) {
                if (!lllllllllllllIlllIIIIIIlIlIIlllI.isEmpty() && lllllllllllllIlllIIIIIIlIlIIlllI.charAt(0) != '#') {
                    final String[] lllllllllllllIlllIIIIIIlIlIIllIl = (String[])Iterables.toArray(LanguageMap.EQUAL_SIGN_SPLITTER.split((CharSequence)lllllllllllllIlllIIIIIIlIlIIlllI), (Class)String.class);
                    if (lllllllllllllIlllIIIIIIlIlIIllIl == null || lllllllllllllIlllIIIIIIlIlIIllIl.length != 2) {
                        continue;
                    }
                    final String lllllllllllllIlllIIIIIIlIlIIllII = lllllllllllllIlllIIIIIIlIlIIllIl[0];
                    final String lllllllllllllIlllIIIIIIlIlIIlIll = LanguageMap.NUMERIC_VARIABLE_PATTERN.matcher(lllllllllllllIlllIIIIIIlIlIIllIl[1]).replaceAll("%$1s");
                    this.languageList.put(lllllllllllllIlllIIIIIIlIlIIllII, lllllllllllllIlllIIIIIIlIlIIlIll);
                }
            }
            this.lastUpdateTimeInMilliseconds = System.currentTimeMillis();
        }
        catch (IOException ex) {}
    }
    
    public synchronized boolean isKeyTranslated(final String lllllllllllllIlllIIIIIIlIIIlllIl) {
        return this.languageList.containsKey(lllllllllllllIlllIIIIIIlIIIlllIl);
    }
    
    private String tryTranslateKey(final String lllllllllllllIlllIIIIIIlIIlIIlII) {
        final String lllllllllllllIlllIIIIIIlIIlIIllI = this.languageList.get(lllllllllllllIlllIIIIIIlIIlIIlII);
        return (lllllllllllllIlllIIIIIIlIIlIIllI == null) ? lllllllllllllIlllIIIIIIlIIlIIlII : lllllllllllllIlllIIIIIIlIIlIIllI;
    }
    
    public synchronized String translateKey(final String lllllllllllllIlllIIIIIIlIIlllIll) {
        return this.tryTranslateKey(lllllllllllllIlllIIIIIIlIIlllIll);
    }
    
    public long getLastUpdateTimeInMilliseconds() {
        return this.lastUpdateTimeInMilliseconds;
    }
    
    public static synchronized void replaceWith(final Map<String, String> lllllllllllllIlllIIIIIIlIlIIIIlI) {
        LanguageMap.instance.languageList.clear();
        LanguageMap.instance.languageList.putAll(lllllllllllllIlllIIIIIIlIlIIIIlI);
        LanguageMap.instance.lastUpdateTimeInMilliseconds = System.currentTimeMillis();
    }
    
    static LanguageMap getInstance() {
        return LanguageMap.instance;
    }
}
