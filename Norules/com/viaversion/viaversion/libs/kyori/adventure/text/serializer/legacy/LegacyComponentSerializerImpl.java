package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy;

import java.util.regex.*;
import org.jetbrains.annotations.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.flattener.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;

final class LegacyComponentSerializerImpl implements LegacyComponentSerializer
{
    private static final /* synthetic */ TextDecoration[] DECORATIONS;
    private final /* synthetic */ char character;
    @Nullable
    private final /* synthetic */ TextReplacementConfig urlReplacementConfig;
    private static final /* synthetic */ Optional<Provider> SERVICE;
    static final /* synthetic */ Consumer<Builder> BUILDER;
    private final /* synthetic */ boolean hexColours;
    private final /* synthetic */ ComponentFlattener flattener;
    private static final /* synthetic */ List<TextFormat> FORMATS;
    private static final /* synthetic */ String LEGACY_CHARS;
    static final /* synthetic */ Pattern URL_SCHEME_PATTERN;
    static final /* synthetic */ Pattern DEFAULT_URL_PATTERN;
    private final /* synthetic */ char hexCharacter;
    private final /* synthetic */ boolean useTerriblyStupidHexFormat;
    
    @Nullable
    private DecodedFormat decodeTextFormat(final char lllllllllllllIlIllIllIlIIIIIIIIl, final String lllllllllllllIlIllIllIlIIIIIIIlI, final int lllllllllllllIlIllIllIlIIIIIIIII) {
        final FormatCodeType lllllllllllllIlIllIllIIlllllIlll = this.determineFormatType(lllllllllllllIlIllIllIlIIIIIIIIl, lllllllllllllIlIllIllIlIIIIIIIlI, lllllllllllllIlIllIllIlIIIIIIIII);
        if (lllllllllllllIlIllIllIIlllllIlll == null) {
            return null;
        }
        if (lllllllllllllIlIllIllIIlllllIlll == FormatCodeType.KYORI_HEX) {
            final TextColor lllllllllllllIlIllIllIIlllllllll = tryParseHexColor(lllllllllllllIlIllIllIlIIIIIIIlI.substring(lllllllllllllIlIllIllIlIIIIIIIII, lllllllllllllIlIllIllIlIIIIIIIII + 6));
            if (lllllllllllllIlIllIllIIlllllllll != null) {
                return new DecodedFormat(lllllllllllllIlIllIllIIlllllIlll, (TextFormat)lllllllllllllIlIllIllIIlllllllll);
            }
        }
        else {
            if (lllllllllllllIlIllIllIIlllllIlll == FormatCodeType.MOJANG_LEGACY) {
                return new DecodedFormat(lllllllllllllIlIllIllIIlllllIlll, (TextFormat)LegacyComponentSerializerImpl.FORMATS.get(LegacyComponentSerializerImpl.LEGACY_CHARS.indexOf(lllllllllllllIlIllIllIlIIIIIIIIl)));
            }
            if (lllllllllllllIlIllIllIIlllllIlll == FormatCodeType.BUNGEECORD_UNUSUAL_HEX) {
                final StringBuilder lllllllllllllIlIllIllIIlllllllIl = new StringBuilder(6);
                for (int lllllllllllllIlIllIllIIllllllllI = lllllllllllllIlIllIllIlIIIIIIIII - 1; lllllllllllllIlIllIllIIllllllllI >= lllllllllllllIlIllIllIlIIIIIIIII - 11; lllllllllllllIlIllIllIIllllllllI -= 2) {
                    lllllllllllllIlIllIllIIlllllllIl.append(lllllllllllllIlIllIllIlIIIIIIIlI.charAt(lllllllllllllIlIllIllIIllllllllI));
                }
                final TextColor lllllllllllllIlIllIllIIlllllllII = tryParseHexColor(String.valueOf(lllllllllllllIlIllIllIIlllllllIl.reverse()));
                if (lllllllllllllIlIllIllIIlllllllII != null) {
                    return new DecodedFormat(lllllllllllllIlIllIllIIlllllIlll, (TextFormat)lllllllllllllIlIllIllIIlllllllII);
                }
            }
        }
        return null;
    }
    
    @NotNull
    @Override
    public TextComponent deserialize(@NotNull final String lllllllllllllIlIllIllIIllIllIllI) {
        int lllllllllllllIlIllIllIIllIllIIIl = lllllllllllllIlIllIllIIllIllIllI.lastIndexOf(this.character, lllllllllllllIlIllIllIIllIllIllI.length() - 2);
        if (lllllllllllllIlIllIllIIllIllIIIl == -1) {
            return this.extractUrl(Component.text(lllllllllllllIlIllIllIIllIllIllI));
        }
        final List<TextComponent> lllllllllllllIlIllIllIIllIllIIII = new ArrayList<TextComponent>();
        TextComponent.Builder lllllllllllllIlIllIllIIllIlIllll = null;
        boolean lllllllllllllIlIllIllIIllIlIlllI = false;
        int lllllllllllllIlIllIllIIllIlIllIl = lllllllllllllIlIllIllIIllIllIllI.length();
        do {
            final DecodedFormat lllllllllllllIlIllIllIIllIllIlII = this.decodeTextFormat(lllllllllllllIlIllIllIIllIllIllI.charAt(lllllllllllllIlIllIllIIllIllIIIl + 1), lllllllllllllIlIllIllIIllIllIllI, lllllllllllllIlIllIllIIllIllIIIl + 2);
            if (lllllllllllllIlIllIllIIllIllIlII != null) {
                final int lllllllllllllIlIllIllIIllIllIlIl = lllllllllllllIlIllIllIIllIllIIIl + ((lllllllllllllIlIllIllIIllIllIlII.encodedFormat == FormatCodeType.KYORI_HEX) ? 8 : 2);
                if (lllllllllllllIlIllIllIIllIllIlIl != lllllllllllllIlIllIllIIllIlIllIl) {
                    if (lllllllllllllIlIllIllIIllIlIllll != null) {
                        if (lllllllllllllIlIllIllIIllIlIlllI) {
                            lllllllllllllIlIllIllIIllIllIIII.add(((ComponentBuilder<TextComponent, B>)lllllllllllllIlIllIllIIllIlIllll).build());
                            lllllllllllllIlIllIllIIllIlIlllI = false;
                            lllllllllllllIlIllIllIIllIlIllll = Component.text();
                        }
                        else {
                            lllllllllllllIlIllIllIIllIlIllll = ((ComponentBuilder<C, TextComponent.Builder>)Component.text()).append(((ComponentBuilder<Component, B>)lllllllllllllIlIllIllIIllIlIllll).build());
                        }
                    }
                    else {
                        lllllllllllllIlIllIllIIllIlIllll = Component.text();
                    }
                    lllllllllllllIlIllIllIIllIlIllll.content(lllllllllllllIlIllIllIIllIllIllI.substring(lllllllllllllIlIllIllIIllIllIlIl, lllllllllllllIlIllIllIIllIlIllIl));
                }
                else if (lllllllllllllIlIllIllIIllIlIllll == null) {
                    lllllllllllllIlIllIllIIllIlIllll = Component.text();
                }
                if (!lllllllllllllIlIllIllIIllIlIlllI) {
                    lllllllllllllIlIllIllIIllIlIlllI = applyFormat(lllllllllllllIlIllIllIIllIlIllll, lllllllllllllIlIllIllIIllIllIlII.format);
                }
                if (lllllllllllllIlIllIllIIllIllIlII.encodedFormat == FormatCodeType.BUNGEECORD_UNUSUAL_HEX) {
                    lllllllllllllIlIllIllIIllIllIIIl -= 12;
                }
                lllllllllllllIlIllIllIIllIlIllIl = lllllllllllllIlIllIllIIllIllIIIl;
            }
            lllllllllllllIlIllIllIIllIllIIIl = lllllllllllllIlIllIllIIllIllIllI.lastIndexOf(this.character, lllllllllllllIlIllIllIIllIllIIIl - 1);
        } while (lllllllllllllIlIllIllIIllIllIIIl != -1);
        if (lllllllllllllIlIllIllIIllIlIllll != null) {
            lllllllllllllIlIllIllIIllIllIIII.add(((ComponentBuilder<TextComponent, B>)lllllllllllllIlIllIllIIllIlIllll).build());
        }
        final String lllllllllllllIlIllIllIIllIlIllII = (lllllllllllllIlIllIllIIllIlIllIl > 0) ? lllllllllllllIlIllIllIIllIllIllI.substring(0, lllllllllllllIlIllIllIIllIlIllIl) : "";
        if (lllllllllllllIlIllIllIIllIllIIII.size() == 1 && lllllllllllllIlIllIllIIllIlIllII.isEmpty()) {
            return this.extractUrl(lllllllllllllIlIllIllIIllIllIIII.get(0));
        }
        Collections.reverse(lllllllllllllIlIllIllIIllIllIIII);
        return this.extractUrl(((ComponentBuilder<TextComponent, B>)((ComponentBuilder<C, TextComponent.Builder>)Component.text().content(lllllllllllllIlIllIllIIllIlIllII)).append(lllllllllllllIlIllIllIIllIllIIII)).build());
    }
    
    @Nullable
    static LegacyFormat legacyFormat(final char lllllllllllllIlIllIllIlIIIIlIIII) {
        final int lllllllllllllIlIllIllIlIIIIIllIl = LegacyComponentSerializerImpl.LEGACY_CHARS.indexOf(lllllllllllllIlIllIllIlIIIIlIIII);
        if (lllllllllllllIlIllIllIlIIIIIllIl != -1) {
            final TextFormat lllllllllllllIlIllIllIlIIIIIllll = LegacyComponentSerializerImpl.FORMATS.get(lllllllllllllIlIllIllIlIIIIIllIl);
            if (lllllllllllllIlIllIllIlIIIIIllll instanceof NamedTextColor) {
                return new LegacyFormat((NamedTextColor)lllllllllllllIlIllIllIlIIIIIllll);
            }
            if (lllllllllllllIlIllIllIlIIIIIllll instanceof TextDecoration) {
                return new LegacyFormat((TextDecoration)lllllllllllllIlIllIllIlIIIIIllll);
            }
            if (lllllllllllllIlIllIllIlIIIIIllll instanceof Reset) {
                return LegacyFormat.RESET;
            }
        }
        return null;
    }
    
    static {
        LEGACY_BUNGEE_HEX_CHAR = 'x';
        DEFAULT_URL_PATTERN = Pattern.compile("(?:(https?)://)?([-\\w_.]+\\.\\w{2,})(/\\S*)?");
        URL_SCHEME_PATTERN = Pattern.compile("^[a-z][a-z0-9+\\-.]*:");
        DECORATIONS = TextDecoration.values();
        final Map<TextFormat, String> lllllllllllllIlIllIllIIlIllIIlll = new LinkedHashMap<TextFormat, String>(22);
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.BLACK, "0");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_BLUE, "1");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_GREEN, "2");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_AQUA, "3");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_RED, "4");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_PURPLE, "5");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.GOLD, "6");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.GRAY, "7");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.DARK_GRAY, "8");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.BLUE, "9");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.GREEN, "a");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.AQUA, "b");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.RED, "c");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.LIGHT_PURPLE, "d");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.YELLOW, "e");
        lllllllllllllIlIllIllIIlIllIIlll.put(NamedTextColor.WHITE, "f");
        lllllllllllllIlIllIllIIlIllIIlll.put(TextDecoration.OBFUSCATED, "k");
        lllllllllllllIlIllIllIIlIllIIlll.put(TextDecoration.BOLD, "l");
        lllllllllllllIlIllIllIIlIllIIlll.put(TextDecoration.STRIKETHROUGH, "m");
        lllllllllllllIlIllIllIIlIllIIlll.put(TextDecoration.UNDERLINED, "n");
        lllllllllllllIlIllIllIIlIllIIlll.put(TextDecoration.ITALIC, "o");
        lllllllllllllIlIllIllIIlIllIIlll.put(Reset.INSTANCE, "r");
        FORMATS = Collections.unmodifiableList((List<? extends TextFormat>)new ArrayList<TextFormat>(lllllllllllllIlIllIllIIlIllIIlll.keySet()));
        LEGACY_CHARS = String.join("", lllllllllllllIlIllIllIIlIllIIlll.values());
        if (LegacyComponentSerializerImpl.FORMATS.size() != LegacyComponentSerializerImpl.LEGACY_CHARS.length()) {
            throw new IllegalStateException("FORMATS length differs from LEGACY_CHARS length");
        }
        SERVICE = Services.service(Provider.class);
        BUILDER = LegacyComponentSerializerImpl.SERVICE.map((Function<? super Provider, ? extends Consumer<Builder>>)Provider::legacy).orElseGet(() -> lllllllllllllIlIllIllIIlIllllllI -> {});
    }
    
    private static boolean isHexTextColor(final TextFormat lllllllllllllIlIllIllIIllllIIllI) {
        return lllllllllllllIlIllIllIIllllIIllI instanceof TextColor && !(lllllllllllllIlIllIllIIllllIIllI instanceof NamedTextColor);
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @Nullable
    private FormatCodeType determineFormatType(final char lllllllllllllIlIllIllIlIIIlIIIlI, final String lllllllllllllIlIllIllIlIIIlIIIII, final int lllllllllllllIlIllIllIlIIIlIIIIl) {
        if (lllllllllllllIlIllIllIlIIIlIIIIl >= 14) {
            final int lllllllllllllIlIllIllIlIIIIlllll = lllllllllllllIlIllIllIlIIIlIIIIl - 14;
            final int lllllllllllllIlIllIllIlIIIIllllI = lllllllllllllIlIllIllIlIIIlIIIIl - 13;
            if (lllllllllllllIlIllIllIlIIIlIIIII.charAt(lllllllllllllIlIllIllIlIIIIlllll) == this.character && lllllllllllllIlIllIllIlIIIlIIIII.charAt(lllllllllllllIlIllIllIlIIIIllllI) == 'x') {
                return FormatCodeType.BUNGEECORD_UNUSUAL_HEX;
            }
        }
        if (lllllllllllllIlIllIllIlIIIlIIIlI == this.hexCharacter && lllllllllllllIlIllIllIlIIIlIIIII.length() - lllllllllllllIlIllIllIlIIIlIIIIl >= 6) {
            return FormatCodeType.KYORI_HEX;
        }
        if (LegacyComponentSerializerImpl.LEGACY_CHARS.indexOf(lllllllllllllIlIllIllIlIIIlIIIlI) != -1) {
            return FormatCodeType.MOJANG_LEGACY;
        }
        return null;
    }
    
    LegacyComponentSerializerImpl(final char lllllllllllllIlIllIllIlIIIlllIII, final char lllllllllllllIlIllIllIlIIIlllIlI, @Nullable final TextReplacementConfig lllllllllllllIlIllIllIlIIIllIlll, final boolean lllllllllllllIlIllIllIlIIIllllII, final boolean lllllllllllllIlIllIllIlIIIlllIll, final ComponentFlattener lllllllllllllIlIllIllIlIIIlllIIl) {
        this.character = lllllllllllllIlIllIllIlIIIlllIII;
        this.hexCharacter = lllllllllllllIlIllIllIlIIIlllIlI;
        this.urlReplacementConfig = lllllllllllllIlIllIllIlIIIllIlll;
        this.hexColours = lllllllllllllIlIllIllIlIIIllllII;
        this.useTerriblyStupidHexFormat = lllllllllllllIlIllIllIlIIIlllIll;
        this.flattener = lllllllllllllIlIllIllIlIIIlllIIl;
    }
    
    private static boolean applyFormat(final TextComponent.Builder lllllllllllllIlIllIllIIllIIlIlIl, @NotNull final TextFormat lllllllllllllIlIllIllIIllIIlIllI) {
        if (lllllllllllllIlIllIllIIllIIlIllI instanceof TextColor) {
            lllllllllllllIlIllIllIIllIIlIlIl.colorIfAbsent((TextColor)lllllllllllllIlIllIllIIllIIlIllI);
            return true;
        }
        if (lllllllllllllIlIllIllIIllIIlIllI instanceof TextDecoration) {
            lllllllllllllIlIllIllIIllIIlIlIl.decoration((TextDecoration)lllllllllllllIlIllIllIIllIIlIllI, TextDecoration.State.TRUE);
            return false;
        }
        if (lllllllllllllIlIllIllIIllIIlIllI instanceof Reset) {
            return true;
        }
        throw new IllegalArgumentException(String.format("unknown format '%s'", lllllllllllllIlIllIllIIllIIlIllI.getClass()));
    }
    
    @Nullable
    private static TextColor tryParseHexColor(final String lllllllllllllIlIllIllIIllllIllIl) {
        try {
            final int lllllllllllllIlIllIllIIllllIllII = Integer.parseInt(lllllllllllllIlIllIllIIllllIllIl, 16);
            return TextColor.color(lllllllllllllIlIllIllIIllllIllII);
        }
        catch (NumberFormatException lllllllllllllIlIllIllIIllllIlIll) {
            return null;
        }
    }
    
    private TextComponent extractUrl(final TextComponent lllllllllllllIlIllIllIIlllIIIllI) {
        if (this.urlReplacementConfig == null) {
            return lllllllllllllIlIllIllIIlllIIIllI;
        }
        final Component lllllllllllllIlIllIllIIlllIIIIll = lllllllllllllIlIllIllIIlllIIIllI.replaceText(this.urlReplacementConfig);
        if (lllllllllllllIlIllIllIIlllIIIIll instanceof TextComponent) {
            return (TextComponent)lllllllllllllIlIllIllIIlllIIIIll;
        }
        return TextComponent.ofChildren(lllllllllllllIlIllIllIIlllIIIIll);
    }
    
    private String toLegacyCode(TextFormat lllllllllllllIlIllIllIIlllIllIlI) {
        if (isHexTextColor(lllllllllllllIlIllIllIIlllIllIlI)) {
            final TextColor lllllllllllllIlIllIllIIlllIlIllI = (TextColor)lllllllllllllIlIllIllIIlllIllIlI;
            if (this.hexColours) {
                final String lllllllllllllIlIllIllIIlllIlIlll = String.format("%06x", lllllllllllllIlIllIllIIlllIlIllI.value());
                if (this.useTerriblyStupidHexFormat) {
                    final StringBuilder lllllllllllllIlIllIllIIlllIllIII = new StringBuilder(String.valueOf('x'));
                    final double lllllllllllllIlIllIllIIlllIIllIl = (Object)lllllllllllllIlIllIllIIlllIlIlll.toCharArray();
                    final byte lllllllllllllIlIllIllIIlllIIllII = (byte)lllllllllllllIlIllIllIIlllIIllIl.length;
                    for (final char lllllllllllllIlIllIllIIlllIllIIl : lllllllllllllIlIllIllIIlllIIllIl) {
                        lllllllllllllIlIllIllIIlllIllIII.append(this.character).append(lllllllllllllIlIllIllIIlllIllIIl);
                    }
                    return String.valueOf(lllllllllllllIlIllIllIIlllIllIII);
                }
                return String.valueOf(new StringBuilder().append(this.hexCharacter).append(lllllllllllllIlIllIllIIlllIlIlll));
            }
            else {
                lllllllllllllIlIllIllIIlllIllIlI = NamedTextColor.nearestTo(lllllllllllllIlIllIllIIlllIlIllI);
            }
        }
        final int lllllllllllllIlIllIllIIlllIlIIll = LegacyComponentSerializerImpl.FORMATS.indexOf(lllllllllllllIlIllIllIIlllIllIlI);
        return Character.toString(LegacyComponentSerializerImpl.LEGACY_CHARS.charAt(lllllllllllllIlIllIllIIlllIlIIll));
    }
    
    @NotNull
    @Override
    public String serialize(@NotNull final Component lllllllllllllIlIllIllIIllIIlllll) {
        final Cereal lllllllllllllIlIllIllIIllIIlllII = new Cereal();
        this.flattener.flatten(lllllllllllllIlIllIllIIllIIlllll, lllllllllllllIlIllIllIIllIIlllII);
        return lllllllllllllIlIllIllIIllIIlllII.toString();
    }
    
    static final class DecodedFormat
    {
        final /* synthetic */ TextFormat format;
        final /* synthetic */ FormatCodeType encodedFormat;
        
        private DecodedFormat(final FormatCodeType lllllllllllllllIlIIIIIlIIllIlIlI, final TextFormat lllllllllllllllIlIIIIIlIIllIlIll) {
            if (lllllllllllllllIlIIIIIlIIllIlIll == null) {
                throw new IllegalStateException("No format found");
            }
            this.encodedFormat = lllllllllllllllIlIIIIIlIIllIlIlI;
            this.format = lllllllllllllllIlIIIIIlIIllIlIll;
        }
    }
    
    enum FormatCodeType
    {
        MOJANG_LEGACY, 
        KYORI_HEX, 
        BUNGEECORD_UNUSUAL_HEX;
        
        private static /* synthetic */ FormatCodeType[] $values() {
            return new FormatCodeType[] { FormatCodeType.MOJANG_LEGACY, FormatCodeType.KYORI_HEX, FormatCodeType.BUNGEECORD_UNUSUAL_HEX };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    static final class BuilderImpl implements Builder
    {
        private /* synthetic */ TextReplacementConfig urlReplacementConfig;
        private /* synthetic */ ComponentFlattener flattener;
        private /* synthetic */ boolean useTerriblyStupidHexFormat;
        private /* synthetic */ boolean hexColours;
        private /* synthetic */ char hexCharacter;
        private /* synthetic */ char character;
        
        @NotNull
        @Override
        public Builder flattener(@NotNull final ComponentFlattener llllllllllllllIlllIIlIIlIIllIIll) {
            this.flattener = Objects.requireNonNull(llllllllllllllIlllIIlIIlIIllIIll, "flattener");
            return this;
        }
        
        @NotNull
        @Override
        public Builder useUnusualXRepeatedCharacterHexFormat() {
            this.useTerriblyStupidHexFormat = true;
            return this;
        }
        
        @NotNull
        @Override
        public Builder extractUrls(@Nullable final Style llllllllllllllIlllIIlIIlIlIIlIll) {
            return this.extractUrls(LegacyComponentSerializerImpl.DEFAULT_URL_PATTERN, llllllllllllllIlllIIlIIlIlIIlIll);
        }
        
        @NotNull
        @Override
        public Builder extractUrls() {
            return this.extractUrls(LegacyComponentSerializerImpl.DEFAULT_URL_PATTERN, null);
        }
        
        @NotNull
        @Override
        public Builder extractUrls(@NotNull final Pattern llllllllllllllIlllIIlIIlIlIIIIll, @Nullable final Style llllllllllllllIlllIIlIIlIlIIIIlI) {
            Objects.requireNonNull(llllllllllllllIlllIIlIIlIlIIIIll, "pattern");
            String llllllllllllllIlllIIlIIlIIlIIIll;
            this.urlReplacementConfig = TextReplacementConfig.builder().match(llllllllllllllIlllIIlIIlIlIIIIll).replacement(llllllllllllllIlllIIlIIlIIlIIIIl -> {
                llllllllllllllIlllIIlIIlIIlIIIll = llllllllllllllIlllIIlIIlIIlIIIIl.content();
                if (!LegacyComponentSerializerImpl.URL_SCHEME_PATTERN.matcher(llllllllllllllIlllIIlIIlIIlIIIll).find()) {
                    llllllllllllllIlllIIlIIlIIlIIIll = String.valueOf(new StringBuilder().append("http://").append(llllllllllllllIlllIIlIIlIIlIIIll));
                }
                return ((llllllllllllllIlllIIlIIlIlIIIIlI == null) ? llllllllllllllIlllIIlIIlIIlIIIIl : ((ComponentBuilder<C, TextComponent.Builder>)llllllllllllllIlllIIlIIlIIlIIIIl).style(llllllllllllllIlllIIlIIlIlIIIIlI)).clickEvent(ClickEvent.openUrl(llllllllllllllIlllIIlIIlIIlIIIll));
            }).build();
            return this;
        }
        
        @NotNull
        @Override
        public Builder character(final char llllllllllllllIlllIIlIIlIllIIIll) {
            this.character = llllllllllllllIlllIIlIIlIllIIIll;
            return this;
        }
        
        @NotNull
        @Override
        public Builder hexCharacter(final char llllllllllllllIlllIIlIIlIlIlllII) {
            this.hexCharacter = llllllllllllllIlllIIlIIlIlIlllII;
            return this;
        }
        
        BuilderImpl(@NotNull final LegacyComponentSerializerImpl llllllllllllllIlllIIlIIlIllIlIlI) {
            this();
            this.character = llllllllllllllIlllIIlIIlIllIlIlI.character;
            this.hexCharacter = llllllllllllllIlllIIlIIlIllIlIlI.hexCharacter;
            this.urlReplacementConfig = llllllllllllllIlllIIlIIlIllIlIlI.urlReplacementConfig;
            this.hexColours = llllllllllllllIlllIIlIIlIllIlIlI.hexColours;
            this.useTerriblyStupidHexFormat = llllllllllllllIlllIIlIIlIllIlIlI.useTerriblyStupidHexFormat;
        }
        
        BuilderImpl() {
            this.character = '§';
            this.hexCharacter = '#';
            this.urlReplacementConfig = null;
            this.hexColours = false;
            this.useTerriblyStupidHexFormat = false;
            this.flattener = ComponentFlattener.basic();
            LegacyComponentSerializerImpl.BUILDER.accept(this);
        }
        
        @NotNull
        @Override
        public Builder extractUrls(@NotNull final Pattern llllllllllllllIlllIIlIIlIlIlIIlI) {
            return this.extractUrls(llllllllllllllIlllIIlIIlIlIlIIlI, null);
        }
        
        @NotNull
        @Override
        public LegacyComponentSerializer build() {
            return new LegacyComponentSerializerImpl(this.character, this.hexCharacter, this.urlReplacementConfig, this.hexColours, this.useTerriblyStupidHexFormat, this.flattener);
        }
        
        @NotNull
        @Override
        public Builder hexColors() {
            this.hexColours = true;
            return this;
        }
    }
    
    private final class Cereal implements FlattenerListener
    {
        private final /* synthetic */ StringBuilder sb;
        private /* synthetic */ StyleState[] styles;
        private final /* synthetic */ StyleState style;
        private /* synthetic */ int head;
        @Nullable
        private /* synthetic */ TextFormat lastWritten;
        
        void append(@NotNull final TextFormat lIlIlIllIlIIlI) {
            if (this.lastWritten != lIlIlIllIlIIlI) {
                this.sb.append(LegacyComponentSerializerImpl.this.character).append(LegacyComponentSerializerImpl.this.toLegacyCode(lIlIlIllIlIIlI));
            }
            this.lastWritten = lIlIlIllIlIIlI;
        }
        
        @Override
        public void pushStyle(@NotNull final Style lIlIlIlllIlIIl) {
            final int lIlIlIlllIIllI = ++this.head;
            if (lIlIlIlllIIllI >= this.styles.length) {
                this.styles = Arrays.copyOf(this.styles, this.styles.length * 2);
            }
            StyleState lIlIlIlllIIlIl = this.styles[lIlIlIlllIIllI];
            if (lIlIlIlllIIlIl == null) {
                lIlIlIlllIIlIl = (this.styles[lIlIlIlllIIllI] = new StyleState());
            }
            if (lIlIlIlllIIllI > 0) {
                lIlIlIlllIIlIl.set(this.styles[lIlIlIlllIIllI - 1]);
            }
            else {
                lIlIlIlllIIlIl.clear();
            }
            lIlIlIlllIIlIl.apply(lIlIlIlllIlIIl);
        }
        
        @Override
        public void popStyle(@NotNull final Style lIlIlIllIllIII) {
            if (this.head-- < 0) {
                throw new IllegalStateException("Tried to pop beyond what was pushed!");
            }
        }
        
        @Override
        public void component(@NotNull final String lIlIlIllIllllI) {
            if (!lIlIlIllIllllI.isEmpty()) {
                if (this.head < 0) {
                    throw new IllegalStateException("No style has been pushed!");
                }
                this.styles[this.head].applyFormat();
                this.sb.append(lIlIlIllIllllI);
            }
        }
        
        private Cereal() {
            this.sb = new StringBuilder();
            this.style = new StyleState();
            this.styles = new StyleState[8];
            this.head = -1;
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.sb);
        }
        
        private final class StyleState
        {
            private final /* synthetic */ Set<TextDecoration> decorations;
            @Nullable
            private /* synthetic */ TextColor color;
            private /* synthetic */ boolean needsReset;
            
            private void applyFullFormat() {
                if (this.color != null) {
                    Cereal.this.append(this.color);
                }
                else {
                    Cereal.this.append(Reset.INSTANCE);
                }
                Cereal.this.style.color = this.color;
                for (final TextDecoration llllllllllllllIllllIIlllIlIIIIIl : this.decorations) {
                    Cereal.this.append(llllllllllllllIllllIIlllIlIIIIIl);
                }
                Cereal.this.style.decorations.clear();
                Cereal.this.style.decorations.addAll(this.decorations);
            }
            
            void set(@NotNull final StyleState llllllllllllllIllllIIlllIllIlIlI) {
                this.color = llllllllllllllIllllIIlllIllIlIlI.color;
                this.decorations.clear();
                this.decorations.addAll(llllllllllllllIllllIIlllIllIlIlI.decorations);
            }
            
            void apply(@NotNull final Style llllllllllllllIllllIIlllIlIlllII) {
                final TextColor llllllllllllllIllllIIlllIlIlIllI = llllllllllllllIllllIIlllIlIlllII.color();
                if (llllllllllllllIllllIIlllIlIlIllI != null) {
                    this.color = llllllllllllllIllllIIlllIlIlIllI;
                }
                for (int llllllllllllllIllllIIlllIlIllIlI = 0, llllllllllllllIllllIIlllIlIllIIl = LegacyComponentSerializerImpl.DECORATIONS.length; llllllllllllllIllllIIlllIlIllIlI < llllllllllllllIllllIIlllIlIllIIl; ++llllllllllllllIllllIIlllIlIllIlI) {
                    final TextDecoration llllllllllllllIllllIIlllIlIllIll = LegacyComponentSerializerImpl.DECORATIONS[llllllllllllllIllllIIlllIlIllIlI];
                    switch (llllllllllllllIllllIIlllIlIlllII.decoration(llllllllllllllIllllIIlllIlIllIll)) {
                        case TRUE: {
                            this.decorations.add(llllllllllllllIllllIIlllIlIllIll);
                            break;
                        }
                        case FALSE: {
                            if (this.decorations.remove(llllllllllllllIllllIIlllIlIllIll)) {
                                this.needsReset = true;
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            
            StyleState() {
                this.decorations = EnumSet.noneOf(TextDecoration.class);
            }
            
            void applyFormat() {
                final boolean llllllllllllllIllllIIlllIlIIlIIl = this.color != Cereal.this.style.color;
                if (this.needsReset) {
                    if (!llllllllllllllIllllIIlllIlIIlIIl) {
                        Cereal.this.append(Reset.INSTANCE);
                    }
                    this.needsReset = false;
                }
                if (llllllllllllllIllllIIlllIlIIlIIl || Cereal.this.lastWritten == Reset.INSTANCE) {
                    this.applyFullFormat();
                    return;
                }
                if (!this.decorations.containsAll(Cereal.this.style.decorations)) {
                    this.applyFullFormat();
                    return;
                }
                for (final TextDecoration llllllllllllllIllllIIlllIlIIlIll : this.decorations) {
                    if (Cereal.this.style.decorations.add(llllllllllllllIllllIIlllIlIIlIll)) {
                        Cereal.this.append(llllllllllllllIllllIIlllIlIIlIll);
                    }
                }
            }
            
            public void clear() {
                this.color = null;
                this.decorations.clear();
            }
        }
    }
    
    private enum Reset implements TextFormat
    {
        INSTANCE;
        
        private static /* synthetic */ Reset[] $values() {
            return new Reset[] { Reset.INSTANCE };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    static final class Instances
    {
        static {
            SECTION = LegacyComponentSerializerImpl.SERVICE.map(Provider::legacySection).orElseGet(() -> new LegacyComponentSerializerImpl('§', '#', null, false, false, ComponentFlattener.basic()));
            AMPERSAND = LegacyComponentSerializerImpl.SERVICE.map(Provider::legacyAmpersand).orElseGet(() -> new LegacyComponentSerializerImpl('&', '#', null, false, false, ComponentFlattener.basic()));
        }
    }
}
