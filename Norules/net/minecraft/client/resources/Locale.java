package net.minecraft.client.resources;

import com.google.common.base.*;
import java.util.regex.*;
import net.minecraft.util.*;
import org.apache.commons.io.*;
import java.io.*;
import java.nio.charset.*;
import com.google.common.collect.*;
import java.util.*;

public class Locale
{
    private static final /* synthetic */ Splitter SPLITTER;
    private static final /* synthetic */ Pattern PATTERN;
    /* synthetic */ Map<String, String> properties;
    private /* synthetic */ boolean unicode;
    
    private void checkUnicode() {
        this.unicode = false;
        int lllllllllllllIlIlIlIIIlIIlIlllII = 0;
        int lllllllllllllIlIlIlIIIlIIlIllIll = 0;
        for (final String lllllllllllllIlIlIlIIIlIIlIllIlI : this.properties.values()) {
            final int lllllllllllllIlIlIlIIIlIIlIllIIl = lllllllllllllIlIlIlIIIlIIlIllIlI.length();
            lllllllllllllIlIlIlIIIlIIlIllIll += lllllllllllllIlIlIlIIIlIIlIllIIl;
            for (int lllllllllllllIlIlIlIIIlIIlIllIII = 0; lllllllllllllIlIlIlIIIlIIlIllIII < lllllllllllllIlIlIlIIIlIIlIllIIl; ++lllllllllllllIlIlIlIIIlIIlIllIII) {
                if (lllllllllllllIlIlIlIIIlIIlIllIlI.charAt(lllllllllllllIlIlIlIIIlIIlIllIII) >= '\u0100') {
                    ++lllllllllllllIlIlIlIIIlIIlIlllII;
                }
            }
        }
        final float lllllllllllllIlIlIlIIIlIIlIlIlll = lllllllllllllIlIlIlIIIlIIlIlllII / (float)lllllllllllllIlIlIlIIIlIIlIllIll;
        this.unicode = (lllllllllllllIlIlIlIIIlIIlIlIlll > 0.1);
    }
    
    private String translateKeyPrivate(final String lllllllllllllIlIlIlIIIlIIIlIIlII) {
        final String lllllllllllllIlIlIlIIIlIIIlIIllI = this.properties.get(lllllllllllllIlIlIlIIIlIIIlIIlII);
        return (lllllllllllllIlIlIlIIIlIIIlIIllI == null) ? lllllllllllllIlIlIlIIIlIIIlIIlII : lllllllllllllIlIlIlIIIlIIIlIIllI;
    }
    
    public synchronized void loadLocaleDataFiles(final IResourceManager lllllllllllllIlIlIlIIIlIIlllIlIl, final List<String> lllllllllllllIlIlIlIIIlIIlllIlII) {
        this.properties.clear();
        for (final String lllllllllllllIlIlIlIIIlIIlllIIll : lllllllllllllIlIlIlIIIlIIlllIlII) {
            final String lllllllllllllIlIlIlIIIlIIlllIIlI = String.format("lang/%s.lang", lllllllllllllIlIlIlIIIlIIlllIIll);
            for (final String lllllllllllllIlIlIlIIIlIIlllIIIl : lllllllllllllIlIlIlIIIlIIlllIlIl.getResourceDomains()) {
                try {
                    this.loadLocaleData(lllllllllllllIlIlIlIIIlIIlllIlIl.getAllResources(new ResourceLocation(lllllllllllllIlIlIlIIIlIIlllIIIl, lllllllllllllIlIlIlIIIlIIlllIIlI)));
                }
                catch (IOException ex) {}
            }
        }
        this.checkUnicode();
    }
    
    public Locale() {
        this.properties = (Map<String, String>)Maps.newHashMap();
    }
    
    public boolean isUnicode() {
        return this.unicode;
    }
    
    static {
        SPLITTER = Splitter.on('=').limit(2);
        PATTERN = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    }
    
    private void loadLocaleData(final List<IResource> lllllllllllllIlIlIlIIIlIIlIIlIII) throws IOException {
        for (final IResource lllllllllllllIlIlIlIIIlIIlIIIlll : lllllllllllllIlIlIlIIIlIIlIIlIII) {
            final InputStream lllllllllllllIlIlIlIIIlIIlIIIllI = lllllllllllllIlIlIlIIIlIIlIIIlll.getInputStream();
            try {
                this.loadLocaleData(lllllllllllllIlIlIlIIIlIIlIIIllI);
            }
            finally {
                IOUtils.closeQuietly(lllllllllllllIlIlIlIIIlIIlIIIllI);
            }
            IOUtils.closeQuietly(lllllllllllllIlIlIlIIIlIIlIIIllI);
        }
    }
    
    private void loadLocaleData(final InputStream lllllllllllllIlIlIlIIIlIIIllIIIl) throws IOException {
        for (final String lllllllllllllIlIlIlIIIlIIIllIllI : IOUtils.readLines(lllllllllllllIlIlIlIIIlIIIllIIIl, StandardCharsets.UTF_8)) {
            if (!lllllllllllllIlIlIlIIIlIIIllIllI.isEmpty() && lllllllllllllIlIlIlIIIlIIIllIllI.charAt(0) != '#') {
                final String[] lllllllllllllIlIlIlIIIlIIIllIlIl = (String[])Iterables.toArray(Locale.SPLITTER.split((CharSequence)lllllllllllllIlIlIlIIIlIIIllIllI), (Class)String.class);
                if (lllllllllllllIlIlIlIIIlIIIllIlIl == null || lllllllllllllIlIlIlIIIlIIIllIlIl.length != 2) {
                    continue;
                }
                final String lllllllllllllIlIlIlIIIlIIIllIlII = lllllllllllllIlIlIlIIIlIIIllIlIl[0];
                final String lllllllllllllIlIlIlIIIlIIIllIIll = Locale.PATTERN.matcher(lllllllllllllIlIlIlIIIlIIIllIlIl[1]).replaceAll("%$1s");
                this.properties.put(lllllllllllllIlIlIlIIIlIIIllIlII, lllllllllllllIlIlIlIIIlIIIllIIll);
            }
        }
    }
    
    public String formatMessage(final String lllllllllllllIlIlIlIIIlIIIIlllII, final Object[] lllllllllllllIlIlIlIIIlIIIIlIllI) {
        final String lllllllllllllIlIlIlIIIlIIIIllIlI = this.translateKeyPrivate(lllllllllllllIlIlIlIIIlIIIIlllII);
        try {
            return String.format(lllllllllllllIlIlIlIIIlIIIIllIlI, lllllllllllllIlIlIlIIIlIIIIlIllI);
        }
        catch (IllegalFormatException lllllllllllllIlIlIlIIIlIIIIllIIl) {
            return String.valueOf(new StringBuilder("Format error: ").append(lllllllllllllIlIlIlIIIlIIIIllIlI));
        }
    }
    
    public boolean hasKey(final String lllllllllllllIlIlIlIIIlIIIIIlllI) {
        return this.properties.containsKey(lllllllllllllIlIlIlIIIlIIIIIlllI);
    }
}
