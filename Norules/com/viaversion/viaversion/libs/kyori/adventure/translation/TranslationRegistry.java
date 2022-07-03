package com.viaversion.viaversion.libs.kyori.adventure.translation;

import java.util.regex.*;
import java.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import java.util.function.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;

public interface TranslationRegistry extends Translator
{
    public static final /* synthetic */ Pattern SINGLE_QUOTE_PATTERN = Pattern.compile("'");
    
    boolean contains(@NotNull final String lllllllllllllIllllIIIllIIllIlllI);
    
    void register(@NotNull final String lllllllllllllIllllIIIllIIllIlIlI, @NotNull final Locale lllllllllllllIllllIIIllIIllIlIIl, @NotNull final MessageFormat lllllllllllllIllllIIIllIIllIlIII);
    
    @NotNull
    default TranslationRegistry create(final Key lllllllllllllIllllIIIllIIlllIIIl) {
        return new TranslationRegistryImpl(Objects.requireNonNull(lllllllllllllIllllIIIllIIlllIIIl, "name"));
    }
    
    @Nullable
    MessageFormat translate(@NotNull final String lllllllllllllIllllIIIllIIllIllIl, @NotNull final Locale lllllllllllllIllllIIIllIIllIllII);
    
    void defaultLocale(@NotNull final Locale lllllllllllllIllllIIIllIIllIlIll);
    
    default void registerAll(@NotNull final Locale lllllllllllllIllllIIIllIIIlIllll, @NotNull final Set<String> lllllllllllllIllllIIIllIIIlIlllI, final Function<String, MessageFormat> lllllllllllllIllllIIIllIIIlIllIl) {
        List<IllegalArgumentException> lllllllllllllIllllIIIllIIIlIIlIl = null;
        for (final String lllllllllllllIllllIIIllIIIlIlIll : lllllllllllllIllllIIIllIIIlIlllI) {
            try {
                this.register(lllllllllllllIllllIIIllIIIlIlIll, lllllllllllllIllllIIIllIIIlIllll, lllllllllllllIllllIIIllIIIlIllIl.apply(lllllllllllllIllllIIIllIIIlIlIll));
            }
            catch (IllegalArgumentException lllllllllllllIllllIIIllIIIlIllII) {
                if (lllllllllllllIllllIIIllIIIlIIlIl == null) {
                    lllllllllllllIllllIIIllIIIlIIlIl = new LinkedList<IllegalArgumentException>();
                }
                lllllllllllllIllllIIIllIIIlIIlIl.add(lllllllllllllIllllIIIllIIIlIllII);
            }
        }
        if (lllllllllllllIllllIIIllIIIlIIlIl != null) {
            final int lllllllllllllIllllIIIllIIIlIlIlI = lllllllllllllIllllIIIllIIIlIIlIl.size();
            if (lllllllllllllIllllIIIllIIIlIlIlI == 1) {
                throw lllllllllllllIllllIIIllIIIlIIlIl.get(0);
            }
            if (lllllllllllllIllllIIIllIIIlIlIlI > 1) {
                throw new IllegalArgumentException(String.format("Invalid key (and %d more)", lllllllllllllIllllIIIllIIIlIlIlI - 1), lllllllllllllIllllIIIllIIIlIIlIl.get(0));
            }
        }
    }
    
    void unregister(@NotNull final String lllllllllllllIllllIIIllIIIIlllII);
    
    default void registerAll(@NotNull final Locale lllllllllllllIllllIIIllIIllIIIll, @NotNull final Map<String, MessageFormat> lllllllllllllIllllIIIllIIllIIlII) {
        final Set<String> keySet = lllllllllllllIllllIIIllIIllIIlII.keySet();
        Objects.requireNonNull(lllllllllllllIllllIIIllIIllIIlII);
        this.registerAll(lllllllllllllIllllIIIllIIllIIIll, keySet, lllllllllllllIllllIIIllIIllIIlII::get);
    }
    
    default void registerAll(@NotNull final Locale lllllllllllllIllllIIIllIIlIIIIII, @NotNull final ResourceBundle lllllllllllllIllllIIIllIIlIIIIIl, final boolean lllllllllllllIllllIIIllIIlIIIIlI) {
        final String lllllllllllllIllllIIIllIIIIlIIlI;
        final MessageFormat messageFormat;
        this.registerAll(lllllllllllllIllllIIIllIIlIIIIII, lllllllllllllIllllIIIllIIlIIIIIl.keySet(), lllllllllllllIllllIIIllIIIIIlllI -> {
            lllllllllllllIllllIIIllIIIIlIIlI = lllllllllllllIllllIIIllIIlIIIIIl.getString(lllllllllllllIllllIIIllIIIIIlllI);
            new MessageFormat(lllllllllllllIllllIIIllIIlIIIIlI ? TranslationRegistry.SINGLE_QUOTE_PATTERN.matcher(lllllllllllllIllllIIIllIIIIlIIlI).replaceAll("''") : lllllllllllllIllllIIIllIIIIlIIlI, lllllllllllllIllllIIIllIIlIIIIII);
            return messageFormat;
        });
    }
    
    default void registerAll(@NotNull final Locale lllllllllllllIllllIIIllIIlIlIlII, @NotNull final Path lllllllllllllIllllIIIllIIlIlIIll, final boolean lllllllllllllIllllIIIllIIlIlIlIl) {
        try {
            final BufferedReader lllllllllllllIllllIIIllIIlIlIIlI = Files.newBufferedReader(lllllllllllllIllllIIIllIIlIlIIll, StandardCharsets.UTF_8);
            try {
                this.registerAll(lllllllllllllIllllIIIllIIlIlIlII, new PropertyResourceBundle(lllllllllllllIllllIIIllIIlIlIIlI), lllllllllllllIllllIIIllIIlIlIlIl);
                if (lllllllllllllIllllIIIllIIlIlIIlI != null) {
                    lllllllllllllIllllIIIllIIlIlIIlI.close();
                }
            }
            catch (Throwable lllllllllllllIllllIIIllIIlIIlIII) {
                if (lllllllllllllIllllIIIllIIlIlIIlI != null) {
                    try {
                        lllllllllllllIllllIIIllIIlIlIIlI.close();
                    }
                    catch (Throwable lllllllllllllIllllIIIllIIlIIIlll) {
                        ((Throwable)lllllllllllllIllllIIIllIIlIIlIII).addSuppressed((Throwable)lllllllllllllIllllIIIllIIlIIIlll);
                    }
                }
                throw lllllllllllllIllllIIIllIIlIIlIII;
            }
        }
        catch (IOException ex) {}
    }
}
