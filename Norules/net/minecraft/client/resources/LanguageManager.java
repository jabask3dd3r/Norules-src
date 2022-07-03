package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import java.io.*;
import net.minecraft.util.text.translation.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.google.common.collect.*;

public class LanguageManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ MetadataSerializer theMetadataSerializer;
    private final /* synthetic */ Map<String, Language> languageMap;
    protected static final /* synthetic */ Locale CURRENT_LOCALE;
    private /* synthetic */ String currentLanguage;
    private static final /* synthetic */ Logger LOGGER;
    
    public boolean isCurrentLocaleUnicode() {
        return LanguageManager.CURRENT_LOCALE.isUnicode();
    }
    
    public void parseLanguageMetadata(final List<IResourcePack> lllllllllllllIIlIllIllIlIllIIllI) {
        this.languageMap.clear();
        for (final IResourcePack lllllllllllllIIlIllIllIlIllIIlIl : lllllllllllllIIlIllIllIlIllIIllI) {
            try {
                final LanguageMetadataSection lllllllllllllIIlIllIllIlIllIIlII = lllllllllllllIIlIllIllIlIllIIlIl.getPackMetadata(this.theMetadataSerializer, "language");
                if (lllllllllllllIIlIllIllIlIllIIlII == null) {
                    continue;
                }
                for (final Language lllllllllllllIIlIllIllIlIllIIIll : lllllllllllllIIlIllIllIlIllIIlII.getLanguages()) {
                    if (!this.languageMap.containsKey(lllllllllllllIIlIllIllIlIllIIIll.getLanguageCode())) {
                        this.languageMap.put(lllllllllllllIIlIllIllIlIllIIIll.getLanguageCode(), lllllllllllllIIlIllIllIlIllIIIll);
                    }
                }
            }
            catch (RuntimeException lllllllllllllIIlIllIllIlIllIIIlI) {
                LanguageManager.LOGGER.warn("Unable to parse language metadata section of resourcepack: {}", (Object)lllllllllllllIIlIllIllIlIllIIlIl.getPackName(), (Object)lllllllllllllIIlIllIllIlIllIIIlI);
            }
            catch (IOException lllllllllllllIIlIllIllIlIllIIIIl) {
                LanguageManager.LOGGER.warn("Unable to parse language metadata section of resourcepack: {}", (Object)lllllllllllllIIlIllIllIlIllIIlIl.getPackName(), (Object)lllllllllllllIIlIllIllIlIllIIIIl);
            }
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIIlIllIllIlIlIlIIlI) {
        final List<String> lllllllllllllIIlIllIllIlIlIlIlII = (List<String>)Lists.newArrayList((Object[])new String[] { "en_us" });
        if (!"en_us".equals(this.currentLanguage)) {
            lllllllllllllIIlIllIllIlIlIlIlII.add(this.currentLanguage);
        }
        LanguageManager.CURRENT_LOCALE.loadLocaleDataFiles(lllllllllllllIIlIllIllIlIlIlIIlI, lllllllllllllIIlIllIllIlIlIlIlII);
        LanguageMap.replaceWith(LanguageManager.CURRENT_LOCALE.properties);
    }
    
    public boolean isCurrentLanguageBidirectional() {
        return this.getCurrentLanguage() != null && this.getCurrentLanguage().isBidirectional();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        CURRENT_LOCALE = new Locale();
    }
    
    public Language getCurrentLanguage() {
        final String lllllllllllllIIlIllIllIlIlIIIIll = this.languageMap.containsKey(this.currentLanguage) ? this.currentLanguage : "en_us";
        return this.languageMap.get(lllllllllllllIIlIllIllIlIlIIIIll);
    }
    
    public LanguageManager(final MetadataSerializer lllllllllllllIIlIllIllIlIlllIIII, final String lllllllllllllIIlIllIllIlIlllIIlI) {
        this.languageMap = (Map<String, Language>)Maps.newHashMap();
        this.theMetadataSerializer = lllllllllllllIIlIllIllIlIlllIIII;
        this.currentLanguage = lllllllllllllIIlIllIllIlIlllIIlI;
        I18n.setLocale(LanguageManager.CURRENT_LOCALE);
    }
    
    public Language func_191960_a(final String lllllllllllllIIlIllIllIlIIlllIlI) {
        return this.languageMap.get(lllllllllllllIIlIllIllIlIIlllIlI);
    }
    
    public SortedSet<Language> getLanguages() {
        return (SortedSet<Language>)Sets.newTreeSet((Iterable)this.languageMap.values());
    }
    
    public void setCurrentLanguage(final Language lllllllllllllIIlIllIllIlIlIIIlll) {
        this.currentLanguage = lllllllllllllIIlIllIllIlIlIIIlll.getLanguageCode();
    }
}
