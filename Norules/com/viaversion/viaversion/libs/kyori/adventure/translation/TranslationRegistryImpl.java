package com.viaversion.viaversion.libs.kyori.adventure.translation;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.text.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;

final class TranslationRegistryImpl implements TranslationRegistry, Examinable
{
    private /* synthetic */ Locale defaultLocale;
    private final /* synthetic */ Map<String, Translation> translations;
    private final /* synthetic */ Key name;
    
    @Override
    public void defaultLocale(@NotNull final Locale lllllllllllllIIlIllIllllIlIIIlll) {
        this.defaultLocale = Objects.requireNonNull(lllllllllllllIIlIllIllllIlIIIlll, "defaultLocale");
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.translations, this.defaultLocale);
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @Override
    public boolean contains(@NotNull final String lllllllllllllIIlIllIllllIlIlllII) {
        return this.translations.containsKey(lllllllllllllIIlIllIllllIlIlllII);
    }
    
    @NotNull
    @Override
    public Key name() {
        return this.name;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("translations", this.translations));
    }
    
    @Override
    public void unregister(@NotNull final String lllllllllllllIIlIllIllllIllIIllI) {
        this.translations.remove(lllllllllllllIIlIllIllllIllIIllI);
    }
    
    @Nullable
    @Override
    public MessageFormat translate(@NotNull final String lllllllllllllIIlIllIllllIlIlIIlI, @NotNull final Locale lllllllllllllIIlIllIllllIlIlIIll) {
        final Translation lllllllllllllIIlIllIllllIlIIlllI = this.translations.get(lllllllllllllIIlIllIllllIlIlIIlI);
        if (lllllllllllllIIlIllIllllIlIIlllI == null) {
            return null;
        }
        return lllllllllllllIIlIllIllllIlIIlllI.translate(lllllllllllllIIlIllIllllIlIlIIll);
    }
    
    @Override
    public void register(@NotNull final String lllllllllllllIIlIllIllllIlllIIlI, @NotNull final Locale lllllllllllllIIlIllIllllIlllIIll, @NotNull final MessageFormat lllllllllllllIIlIllIllllIlllIIIl) {
        this.translations.computeIfAbsent(lllllllllllllIIlIllIllllIlllIIlI, lllllllllllllIIlIllIllllIIlIllII -> new Translation(lllllllllllllIIlIllIllllIIlIllII)).register(lllllllllllllIIlIllIllllIlllIIll, lllllllllllllIIlIllIllllIlllIIIl);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIllIllllIIllllII) {
        if (this == lllllllllllllIIlIllIllllIIllllII) {
            return true;
        }
        if (!(lllllllllllllIIlIllIllllIIllllII instanceof TranslationRegistryImpl)) {
            return false;
        }
        final TranslationRegistryImpl lllllllllllllIIlIllIllllIIlllIIl = (TranslationRegistryImpl)lllllllllllllIIlIllIllllIIllllII;
        return this.name.equals(lllllllllllllIIlIllIllllIIlllIIl.name) && this.translations.equals(lllllllllllllIIlIllIllllIIlllIIl.translations) && this.defaultLocale.equals(lllllllllllllIIlIllIllllIIlllIIl.defaultLocale);
    }
    
    TranslationRegistryImpl(final Key lllllllllllllIIlIllIllllIlllllII) {
        this.translations = new ConcurrentHashMap<String, Translation>();
        this.defaultLocale = Locale.US;
        this.name = lllllllllllllIIlIllIllllIlllllII;
    }
    
    final class Translation implements Examinable
    {
        private final /* synthetic */ Map<Locale, MessageFormat> formats;
        private final /* synthetic */ String key;
        
        @Nullable
        MessageFormat translate(@NotNull final Locale llllllllllllIlllllIIIIllIIllIlII) {
            MessageFormat llllllllllllIlllllIIIIllIIllIIIl = this.formats.get(Objects.requireNonNull(llllllllllllIlllllIIIIllIIllIlII, "locale"));
            if (llllllllllllIlllllIIIIllIIllIIIl == null) {
                llllllllllllIlllllIIIIllIIllIIIl = this.formats.get(new Locale(llllllllllllIlllllIIIIllIIllIlII.getLanguage()));
                if (llllllllllllIlllllIIIIllIIllIIIl == null) {
                    llllllllllllIlllllIIIIllIIllIIIl = this.formats.get(TranslationRegistryImpl.this.defaultLocale);
                    if (llllllllllllIlllllIIIIllIIllIIIl == null) {
                        llllllllllllIlllllIIIIllIIllIIIl = this.formats.get(TranslationLocales.global());
                    }
                }
            }
            return llllllllllllIlllllIIIIllIIllIIIl;
        }
        
        @Override
        public boolean equals(final Object llllllllllllIlllllIIIIllIIlIIlll) {
            if (this == llllllllllllIlllllIIIIllIIlIIlll) {
                return true;
            }
            if (!(llllllllllllIlllllIIIIllIIlIIlll instanceof Translation)) {
                return false;
            }
            final Translation llllllllllllIlllllIIIIllIIlIIlII = (Translation)llllllllllllIlllllIIIIllIIlIIlll;
            return this.key.equals(llllllllllllIlllllIIIIllIIlIIlII.key) && this.formats.equals(llllllllllllIlllllIIIIllIIlIIlII.formats);
        }
        
        @Override
        public String toString() {
            return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
        }
        
        Translation(final String llllllllllllIlllllIIIIllIlIIlIlI) {
            this.key = Objects.requireNonNull(llllllllllllIlllllIIIIllIlIIlIlI, "translation key");
            this.formats = new ConcurrentHashMap<Locale, MessageFormat>();
        }
        
        void register(@NotNull final Locale llllllllllllIlllllIIIIllIIlllllI, @NotNull final MessageFormat llllllllllllIlllllIIIIllIIllllll) {
            if (this.formats.putIfAbsent(Objects.requireNonNull(llllllllllllIlllllIIIIllIIlllllI, "locale"), Objects.requireNonNull(llllllllllllIlllllIIIIllIIllllll, "message format")) != null) {
                throw new IllegalArgumentException(String.format("Translation already exists: %s for %s", this.key, llllllllllllIlllllIIIIllIIlllllI));
            }
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.key, this.formats);
        }
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("key", this.key), ExaminableProperty.of("formats", this.formats) });
        }
    }
}
