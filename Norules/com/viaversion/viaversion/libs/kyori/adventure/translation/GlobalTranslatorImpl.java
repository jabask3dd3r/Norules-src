package com.viaversion.viaversion.libs.kyori.adventure.translation;

import com.viaversion.viaversion.libs.kyori.adventure.text.renderer.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.text.*;
import org.jetbrains.annotations.*;
import java.util.concurrent.*;
import java.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class GlobalTranslatorImpl implements GlobalTranslator
{
    final /* synthetic */ TranslatableComponentRenderer<Locale> renderer;
    private static final /* synthetic */ Key NAME;
    private final /* synthetic */ Set<Translator> sources;
    
    static {
        NAME = Key.key("adventure", "global");
        INSTANCE = new GlobalTranslatorImpl();
    }
    
    @NotNull
    @Override
    public Iterable<? extends Translator> sources() {
        return (Iterable<? extends Translator>)Collections.unmodifiableSet((Set<?>)this.sources);
    }
    
    @Override
    public boolean removeSource(@NotNull final Translator lllllllllllllIllIlllIIIIIlIIIIll) {
        Objects.requireNonNull(lllllllllllllIllIlllIIIIIlIIIIll, "source");
        return this.sources.remove(lllllllllllllIllIlllIIIIIlIIIIll);
    }
    
    @Nullable
    @Override
    public MessageFormat translate(@NotNull final String lllllllllllllIllIlllIIIIIIllIlll, @NotNull final Locale lllllllllllllIllIlllIIIIIIlllIII) {
        Objects.requireNonNull(lllllllllllllIllIlllIIIIIIllIlll, "key");
        Objects.requireNonNull(lllllllllllllIllIlllIIIIIIlllIII, "locale");
        for (final Translator lllllllllllllIllIlllIIIIIIllIlIl : this.sources) {
            final MessageFormat lllllllllllllIllIlllIIIIIIllIllI = lllllllllllllIllIlllIIIIIIllIlIl.translate(lllllllllllllIllIlllIIIIIIllIlll, lllllllllllllIllIlllIIIIIIlllIII);
            if (lllllllllllllIllIlllIIIIIIllIllI != null) {
                return lllllllllllllIllIlllIIIIIIllIllI;
            }
        }
        return null;
    }
    
    @Override
    public boolean addSource(@NotNull final Translator lllllllllllllIllIlllIIIIIlIIlIlI) {
        Objects.requireNonNull(lllllllllllllIllIlllIIIIIlIIlIlI, "source");
        if (lllllllllllllIllIlllIIIIIlIIlIlI == this) {
            throw new IllegalArgumentException("GlobalTranslationSource");
        }
        return this.sources.add(lllllllllllllIllIlllIIIIIlIIlIlI);
    }
    
    private GlobalTranslatorImpl() {
        this.renderer = TranslatableComponentRenderer.usingTranslationSource(this);
        this.sources = Collections.newSetFromMap(new ConcurrentHashMap<Translator, Boolean>());
    }
    
    @NotNull
    @Override
    public Key name() {
        return GlobalTranslatorImpl.NAME;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("sources", this.sources));
    }
}
