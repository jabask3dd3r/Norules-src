package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

final class StyleImpl implements Style
{
    @Nullable
    private final /* synthetic */ ClickEvent clickEvent;
    @Nullable
    private final /* synthetic */ String insertion;
    private static final /* synthetic */ TextDecoration[] DECORATIONS;
    private final /* synthetic */ TextDecoration.State italic;
    private final /* synthetic */ TextDecoration.State obfuscated;
    private final /* synthetic */ TextDecoration.State strikethrough;
    private final /* synthetic */ TextDecoration.State bold;
    static final /* synthetic */ StyleImpl EMPTY;
    @Nullable
    private final /* synthetic */ HoverEvent<?> hoverEvent;
    @Nullable
    private final /* synthetic */ TextColor color;
    private final /* synthetic */ TextDecoration.State underlined;
    @Nullable
    private final /* synthetic */ Key font;
    
    StyleImpl(@Nullable final Key lllllllllllllIlIllllIllIlIllIIlI, @Nullable final TextColor lllllllllllllIlIllllIllIlIllIIIl, final TextDecoration.State lllllllllllllIlIllllIllIlIllIlIl, final TextDecoration.State lllllllllllllIlIllllIllIlIlIllII, final TextDecoration.State lllllllllllllIlIllllIllIlIlIllll, final TextDecoration.State lllllllllllllIlIllllIllIlIlIllIl, final TextDecoration.State lllllllllllllIlIllllIllIlIllIIII, @Nullable final ClickEvent lllllllllllllIlIllllIllIlIllIIll, @Nullable final HoverEvent<?> lllllllllllllIlIllllIllIlIlIlllI, @Nullable final String lllllllllllllIlIllllIllIlIllIlII) {
        this.font = lllllllllllllIlIllllIllIlIllIIlI;
        this.color = lllllllllllllIlIllllIllIlIllIIIl;
        this.obfuscated = lllllllllllllIlIllllIllIlIllIlIl;
        this.bold = lllllllllllllIlIllllIllIlIlIllII;
        this.strikethrough = lllllllllllllIlIllllIllIlIlIllll;
        this.underlined = lllllllllllllIlIllllIllIlIlIllIl;
        this.italic = lllllllllllllIlIllllIllIlIllIIII;
        this.clickEvent = lllllllllllllIlIllllIllIlIllIIll;
        this.hoverEvent = lllllllllllllIlIllllIllIlIlIlllI;
        this.insertion = lllllllllllllIlIllllIllIlIllIlII;
    }
    
    static {
        EMPTY = new StyleImpl(null, null, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, null, null, null);
        DECORATIONS = TextDecoration.values();
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlIllllIllIIIIIIIIl) {
        if (this == lllllllllllllIlIllllIllIIIIIIIIl) {
            return true;
        }
        if (!(lllllllllllllIlIllllIllIIIIIIIIl instanceof StyleImpl)) {
            return false;
        }
        final StyleImpl lllllllllllllIlIllllIlIllllllllI = (StyleImpl)lllllllllllllIlIllllIllIIIIIIIIl;
        return Objects.equals(this.color, lllllllllllllIlIllllIlIllllllllI.color) && this.obfuscated == lllllllllllllIlIllllIlIllllllllI.obfuscated && this.bold == lllllllllllllIlIllllIlIllllllllI.bold && this.strikethrough == lllllllllllllIlIllllIlIllllllllI.strikethrough && this.underlined == lllllllllllllIlIllllIlIllllllllI.underlined && this.italic == lllllllllllllIlIllllIlIllllllllI.italic && Objects.equals(this.clickEvent, lllllllllllllIlIllllIlIllllllllI.clickEvent) && Objects.equals(this.hoverEvent, lllllllllllllIlIllllIlIllllllllI.hoverEvent) && Objects.equals(this.insertion, lllllllllllllIlIllllIlIllllllllI.insertion) && Objects.equals(this.font, lllllllllllllIlIllllIlIllllllllI.font);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIllllIlIlllllIlll = Objects.hashCode(this.color);
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + this.obfuscated.hashCode();
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + this.bold.hashCode();
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + this.strikethrough.hashCode();
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + this.underlined.hashCode();
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + this.italic.hashCode();
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + Objects.hashCode(this.clickEvent);
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + Objects.hashCode(this.hoverEvent);
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + Objects.hashCode(this.insertion);
        lllllllllllllIlIllllIlIlllllIlll = 31 * lllllllllllllIlIllllIlIlllllIlll + Objects.hashCode(this.font);
        return lllllllllllllIlIllllIlIlllllIlll;
    }
    
    @Nullable
    @Override
    public ClickEvent clickEvent() {
        return this.clickEvent;
    }
    
    @NotNull
    @Override
    public Style colorIfAbsent(@Nullable final TextColor lllllllllllllIlIllllIllIIlllllll) {
        if (this.color == null) {
            return this.color(lllllllllllllIlIllllIllIIlllllll);
        }
        return this;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("color", this.color), ExaminableProperty.of("obfuscated", this.obfuscated), ExaminableProperty.of("bold", this.bold), ExaminableProperty.of("strikethrough", this.strikethrough), ExaminableProperty.of("underlined", this.underlined), ExaminableProperty.of("italic", this.italic), ExaminableProperty.of("clickEvent", this.clickEvent), ExaminableProperty.of("hoverEvent", this.hoverEvent), ExaminableProperty.of("insertion", this.insertion), ExaminableProperty.of("font", this.font) });
    }
    
    @NotNull
    @Override
    public Style clickEvent(@Nullable final ClickEvent lllllllllllllIlIllllIllIIIlllIll) {
        return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, lllllllllllllIlIllllIllIIIlllIll, this.hoverEvent, this.insertion);
    }
    
    @Nullable
    @Override
    public HoverEvent<?> hoverEvent() {
        return this.hoverEvent;
    }
    
    @NotNull
    @Override
    public Style decorations(@NotNull final Map<TextDecoration, TextDecoration.State> lllllllllllllIlIllllIllIIlIIllll) {
        final TextDecoration.State lllllllllllllIlIllllIllIIlIIllII = lllllllllllllIlIllllIllIIlIIllll.getOrDefault(TextDecoration.OBFUSCATED, this.obfuscated);
        final TextDecoration.State lllllllllllllIlIllllIllIIlIIlIll = lllllllllllllIlIllllIllIIlIIllll.getOrDefault(TextDecoration.BOLD, this.bold);
        final TextDecoration.State lllllllllllllIlIllllIllIIlIIlIlI = lllllllllllllIlIllllIllIIlIIllll.getOrDefault(TextDecoration.STRIKETHROUGH, this.strikethrough);
        final TextDecoration.State lllllllllllllIlIllllIllIIlIIlIIl = lllllllllllllIlIllllIllIIlIIllll.getOrDefault(TextDecoration.UNDERLINED, this.underlined);
        final TextDecoration.State lllllllllllllIlIllllIllIIlIIlIII = lllllllllllllIlIllllIllIIlIIllll.getOrDefault(TextDecoration.ITALIC, this.italic);
        return new StyleImpl(this.font, this.color, lllllllllllllIlIllllIllIIlIIllII, lllllllllllllIlIllllIllIIlIIlIll, lllllllllllllIlIllllIllIIlIIlIlI, lllllllllllllIlIllllIllIIlIIlIIl, lllllllllllllIlIllllIllIIlIIlIII, this.clickEvent, this.hoverEvent, this.insertion);
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public Style merge(@NotNull final Style lllllllllllllIlIllllIllIIIIllIll, final Merge.Strategy lllllllllllllIlIllllIllIIIIlllIl, @NotNull final Set<Merge> lllllllllllllIlIllllIllIIIIlllII) {
        if (lllllllllllllIlIllllIllIIIIllIll.isEmpty() || lllllllllllllIlIllllIllIIIIlllIl == Merge.Strategy.NEVER || lllllllllllllIlIllllIllIIIIlllII.isEmpty()) {
            return this;
        }
        if (this.isEmpty() && Merge.hasAll(lllllllllllllIlIllllIllIIIIlllII)) {
            return lllllllllllllIlIllllIllIIIIllIll;
        }
        final Builder lllllllllllllIlIllllIllIIIIlIllI = this.toBuilder();
        lllllllllllllIlIllllIllIIIIlIllI.merge(lllllllllllllIlIllllIllIIIIllIll, lllllllllllllIlIllllIllIIIIlllIl, lllllllllllllIlIllllIllIIIIlllII);
        return lllllllllllllIlIllllIllIIIIlIllI.build();
    }
    
    @Nullable
    @Override
    public String insertion() {
        return this.insertion;
    }
    
    @Nullable
    @Override
    public TextColor color() {
        return this.color;
    }
    
    @Override
    public boolean isEmpty() {
        return this == StyleImpl.EMPTY;
    }
    
    @NotNull
    @Override
    public Map<TextDecoration, TextDecoration.State> decorations() {
        final Map<TextDecoration, TextDecoration.State> lllllllllllllIlIllllIllIIlIlllIl = new EnumMap<TextDecoration, TextDecoration.State>(TextDecoration.class);
        for (int lllllllllllllIlIllllIllIIllIIIII = 0, lllllllllllllIlIllllIllIIlIlllll = StyleImpl.DECORATIONS.length; lllllllllllllIlIllllIllIIllIIIII < lllllllllllllIlIllllIllIIlIlllll; ++lllllllllllllIlIllllIllIIllIIIII) {
            final TextDecoration lllllllllllllIlIllllIllIIllIIIlI = StyleImpl.DECORATIONS[lllllllllllllIlIllllIllIIllIIIII];
            final TextDecoration.State lllllllllllllIlIllllIllIIllIIIIl = this.decoration(lllllllllllllIlIllllIllIIllIIIlI);
            lllllllllllllIlIllllIllIIlIlllIl.put(lllllllllllllIlIllllIllIIllIIIlI, lllllllllllllIlIllllIllIIllIIIIl);
        }
        return lllllllllllllIlIllllIllIIlIlllIl;
    }
    
    @Override
    public TextDecoration.State decoration(@NotNull final TextDecoration lllllllllllllIlIllllIllIIllllIII) {
        if (lllllllllllllIlIllllIllIIllllIII == TextDecoration.BOLD) {
            return this.bold;
        }
        if (lllllllllllllIlIllllIllIIllllIII == TextDecoration.ITALIC) {
            return this.italic;
        }
        if (lllllllllllllIlIllllIllIIllllIII == TextDecoration.UNDERLINED) {
            return this.underlined;
        }
        if (lllllllllllllIlIllllIllIIllllIII == TextDecoration.STRIKETHROUGH) {
            return this.strikethrough;
        }
        if (lllllllllllllIlIllllIllIIllllIII == TextDecoration.OBFUSCATED) {
            return this.obfuscated;
        }
        throw new IllegalArgumentException(String.format("unknown decoration '%s'", lllllllllllllIlIllllIllIIllllIII));
    }
    
    @Nullable
    @Override
    public Key font() {
        return this.font;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    @Override
    public Style insertion(@Nullable final String lllllllllllllIlIllllIllIIIlIIlll) {
        if (Objects.equals(this.insertion, lllllllllllllIlIllllIllIIIlIIlll)) {
            return this;
        }
        return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, lllllllllllllIlIllllIllIIIlIIlll);
    }
    
    static void decorate(final Builder lllllllllllllIlIllllIllIllIIlIll, final TextDecoration[] lllllllllllllIlIllllIllIllIIllII) {
        for (int lllllllllllllIlIllllIllIllIIlIIl = 0, lllllllllllllIlIllllIllIllIIlIII = lllllllllllllIlIllllIllIllIIllII.length; lllllllllllllIlIllllIllIllIIlIIl < lllllllllllllIlIllllIllIllIIlIII; ++lllllllllllllIlIllllIllIllIIlIIl) {
            final TextDecoration lllllllllllllIlIllllIllIllIIlIlI = lllllllllllllIlIllllIllIllIIllII[lllllllllllllIlIllllIllIllIIlIIl];
            lllllllllllllIlIllllIllIllIIlIll.decoration(lllllllllllllIlIllllIllIllIIlIlI, true);
        }
    }
    
    @NotNull
    @Override
    public Style font(@Nullable final Key lllllllllllllIlIllllIllIlIIlIIII) {
        if (Objects.equals(this.font, lllllllllllllIlIllllIllIlIIlIIII)) {
            return this;
        }
        return new StyleImpl(lllllllllllllIlIllllIllIlIIlIIII, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
    }
    
    @NotNull
    @Override
    public Style color(@Nullable final TextColor lllllllllllllIlIllllIllIlIIIIllI) {
        if (Objects.equals(this.color, lllllllllllllIlIllllIllIlIIIIllI)) {
            return this;
        }
        return new StyleImpl(this.font, lllllllllllllIlIllllIllIlIIIIllI, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
    }
    
    @NotNull
    @Override
    public Style hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIlIllllIllIIIllIIIl) {
        return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, HoverEventSource.unbox(lllllllllllllIlIllllIllIIIllIIIl), this.insertion);
    }
    
    @NotNull
    @Override
    public Style decoration(@NotNull final TextDecoration lllllllllllllIlIllllIllIIlllIIII, final TextDecoration.State lllllllllllllIlIllllIllIIllIllll) {
        Objects.requireNonNull(lllllllllllllIlIllllIllIIllIllll, "state");
        if (lllllllllllllIlIllllIllIIlllIIII == TextDecoration.BOLD) {
            return new StyleImpl(this.font, this.color, this.obfuscated, lllllllllllllIlIllllIllIIllIllll, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
        }
        if (lllllllllllllIlIllllIllIIlllIIII == TextDecoration.ITALIC) {
            return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, lllllllllllllIlIllllIllIIllIllll, this.clickEvent, this.hoverEvent, this.insertion);
        }
        if (lllllllllllllIlIllllIllIIlllIIII == TextDecoration.UNDERLINED) {
            return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, lllllllllllllIlIllllIllIIllIllll, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
        }
        if (lllllllllllllIlIllllIllIIlllIIII == TextDecoration.STRIKETHROUGH) {
            return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, lllllllllllllIlIllllIllIIllIllll, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
        }
        if (lllllllllllllIlIllllIllIIlllIIII == TextDecoration.OBFUSCATED) {
            return new StyleImpl(this.font, this.color, lllllllllllllIlIllllIllIIllIllll, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
        }
        throw new IllegalArgumentException(String.format("unknown decoration '%s'", lllllllllllllIlIllllIllIIlllIIII));
    }
    
    static final class BuilderImpl implements Builder
    {
        @Nullable
        /* synthetic */ String insertion;
        @Nullable
        /* synthetic */ TextColor color;
        /* synthetic */ TextDecoration.State obfuscated;
        @Nullable
        /* synthetic */ HoverEvent<?> hoverEvent;
        /* synthetic */ TextDecoration.State bold;
        /* synthetic */ TextDecoration.State italic;
        /* synthetic */ TextDecoration.State strikethrough;
        @Nullable
        /* synthetic */ ClickEvent clickEvent;
        /* synthetic */ TextDecoration.State underlined;
        @Nullable
        /* synthetic */ Key font;
        
        @NotNull
        @Override
        public StyleImpl build() {
            if (this.isEmpty()) {
                return StyleImpl.EMPTY;
            }
            return new StyleImpl(this.font, this.color, this.obfuscated, this.bold, this.strikethrough, this.underlined, this.italic, this.clickEvent, this.hoverEvent, this.insertion);
        }
        
        @NotNull
        @Override
        public Builder color(@Nullable final TextColor lllllllllllllIIIIIIIllllllIIIIlI) {
            this.color = lllllllllllllIIIIIIIllllllIIIIlI;
            return this;
        }
        
        @NotNull
        @Override
        public Builder decoration(@NotNull final TextDecoration lllllllllllllIIIIIIIlllllIIlllll, final TextDecoration.State lllllllllllllIIIIIIIlllllIIllllI) {
            Objects.requireNonNull(lllllllllllllIIIIIIIlllllIIllllI, "state");
            if (lllllllllllllIIIIIIIlllllIIlllll == TextDecoration.BOLD) {
                this.bold = lllllllllllllIIIIIIIlllllIIllllI;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlllll == TextDecoration.ITALIC) {
                this.italic = lllllllllllllIIIIIIIlllllIIllllI;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlllll == TextDecoration.UNDERLINED) {
                this.underlined = lllllllllllllIIIIIIIlllllIIllllI;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlllll == TextDecoration.STRIKETHROUGH) {
                this.strikethrough = lllllllllllllIIIIIIIlllllIIllllI;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlllll == TextDecoration.OBFUSCATED) {
                this.obfuscated = lllllllllllllIIIIIIIlllllIIllllI;
                return this;
            }
            throw new IllegalArgumentException(String.format("unknown decoration '%s'", lllllllllllllIIIIIIIlllllIIlllll));
        }
        
        @NotNull
        @Override
        public Builder clickEvent(@Nullable final ClickEvent lllllllllllllIIIIIIIlllllIIIlIlI) {
            this.clickEvent = lllllllllllllIIIIIIIlllllIIIlIlI;
            return this;
        }
        
        @NotNull
        @Override
        public Builder font(@Nullable final Key lllllllllllllIIIIIIIllllllIIlIIl) {
            this.font = lllllllllllllIIIIIIIllllllIIlIIl;
            return this;
        }
        
        BuilderImpl(@NotNull final StyleImpl lllllllllllllIIIIIIIllllllIlIIII) {
            this.obfuscated = TextDecoration.State.NOT_SET;
            this.bold = TextDecoration.State.NOT_SET;
            this.strikethrough = TextDecoration.State.NOT_SET;
            this.underlined = TextDecoration.State.NOT_SET;
            this.italic = TextDecoration.State.NOT_SET;
            this.color = lllllllllllllIIIIIIIllllllIlIIII.color;
            this.obfuscated = lllllllllllllIIIIIIIllllllIlIIII.obfuscated;
            this.bold = lllllllllllllIIIIIIIllllllIlIIII.bold;
            this.strikethrough = lllllllllllllIIIIIIIllllllIlIIII.strikethrough;
            this.underlined = lllllllllllllIIIIIIIllllllIlIIII.underlined;
            this.italic = lllllllllllllIIIIIIIllllllIlIIII.italic;
            this.clickEvent = lllllllllllllIIIIIIIllllllIlIIII.clickEvent;
            this.hoverEvent = lllllllllllllIIIIIIIllllllIlIIII.hoverEvent;
            this.insertion = lllllllllllllIIIIIIIllllllIlIIII.insertion;
            this.font = lllllllllllllIIIIIIIllllllIlIIII.font;
        }
        
        private static Merger merger(final Merge.Strategy lllllllllllllIIIIIIIllllIlIlIIll) {
            if (lllllllllllllIIIIIIIllllIlIlIIll == Merge.Strategy.ALWAYS) {
                return AlwaysMerger.INSTANCE;
            }
            if (lllllllllllllIIIIIIIllllIlIlIIll == Merge.Strategy.NEVER) {
                throw new UnsupportedOperationException();
            }
            if (lllllllllllllIIIIIIIllllIlIlIIll == Merge.Strategy.IF_ABSENT_ON_TARGET) {
                return IfAbsentOnTargetMerger.INSTANCE;
            }
            throw new IllegalArgumentException(lllllllllllllIIIIIIIllllIlIlIIll.name());
        }
        
        BuilderImpl() {
            this.obfuscated = TextDecoration.State.NOT_SET;
            this.bold = TextDecoration.State.NOT_SET;
            this.strikethrough = TextDecoration.State.NOT_SET;
            this.underlined = TextDecoration.State.NOT_SET;
            this.italic = TextDecoration.State.NOT_SET;
        }
        
        private boolean isEmpty() {
            return this.color == null && this.obfuscated == TextDecoration.State.NOT_SET && this.bold == TextDecoration.State.NOT_SET && this.strikethrough == TextDecoration.State.NOT_SET && this.underlined == TextDecoration.State.NOT_SET && this.italic == TextDecoration.State.NOT_SET && this.clickEvent == null && this.hoverEvent == null && this.insertion == null && this.font == null;
        }
        
        @NotNull
        @Override
        public Builder decorate(@NotNull final TextDecoration... lllllllllllllIIIIIIIlllllIlIlIll) {
            for (int lllllllllllllIIIIIIIlllllIlIlIlI = 0, lllllllllllllIIIIIIIlllllIlIlIIl = lllllllllllllIIIIIIIlllllIlIlIll.length; lllllllllllllIIIIIIIlllllIlIlIlI < lllllllllllllIIIIIIIlllllIlIlIIl; ++lllllllllllllIIIIIIIlllllIlIlIlI) {
                this.decorate(lllllllllllllIIIIIIIlllllIlIlIll[lllllllllllllIIIIIIIlllllIlIlIlI]);
            }
            return this;
        }
        
        @NotNull
        @Override
        public Builder colorIfAbsent(@Nullable final TextColor lllllllllllllIIIIIIIlllllIlllIll) {
            if (this.color == null) {
                this.color = lllllllllllllIIIIIIIlllllIlllIll;
            }
            return this;
        }
        
        @NotNull
        @Override
        public Builder merge(@NotNull final Style lllllllllllllIIIIIIIllllIllIlllI, final Merge.Strategy lllllllllllllIIIIIIIllllIllIllIl, @NotNull final Set<Merge> lllllllllllllIIIIIIIllllIllIllII) {
            if (lllllllllllllIIIIIIIllllIllIllIl == Merge.Strategy.NEVER || lllllllllllllIIIIIIIllllIllIlllI.isEmpty() || lllllllllllllIIIIIIIllllIllIllII.isEmpty()) {
                return this;
            }
            final Merger lllllllllllllIIIIIIIllllIlIllllI = merger(lllllllllllllIIIIIIIllllIllIllIl);
            if (lllllllllllllIIIIIIIllllIllIllII.contains(Merge.COLOR)) {
                final TextColor lllllllllllllIIIIIIIllllIllIlIll = lllllllllllllIIIIIIIllllIllIlllI.color();
                if (lllllllllllllIIIIIIIllllIllIlIll != null) {
                    lllllllllllllIIIIIIIllllIlIllllI.mergeColor(this, lllllllllllllIIIIIIIllllIllIlIll);
                }
            }
            if (lllllllllllllIIIIIIIllllIllIllII.contains(Merge.DECORATIONS)) {
                for (int lllllllllllllIIIIIIIllllIllIlIII = 0, lllllllllllllIIIIIIIllllIllIIlll = StyleImpl.DECORATIONS.length; lllllllllllllIIIIIIIllllIllIlIII < lllllllllllllIIIIIIIllllIllIIlll; ++lllllllllllllIIIIIIIllllIllIlIII) {
                    final TextDecoration lllllllllllllIIIIIIIllllIllIlIlI = StyleImpl.DECORATIONS[lllllllllllllIIIIIIIllllIllIlIII];
                    final TextDecoration.State lllllllllllllIIIIIIIllllIllIlIIl = lllllllllllllIIIIIIIllllIllIlllI.decoration(lllllllllllllIIIIIIIllllIllIlIlI);
                    if (lllllllllllllIIIIIIIllllIllIlIIl != TextDecoration.State.NOT_SET) {
                        lllllllllllllIIIIIIIllllIlIllllI.mergeDecoration(this, lllllllllllllIIIIIIIllllIllIlIlI, lllllllllllllIIIIIIIllllIllIlIIl);
                    }
                }
            }
            if (lllllllllllllIIIIIIIllllIllIllII.contains(Merge.EVENTS)) {
                final ClickEvent lllllllllllllIIIIIIIllllIllIIllI = lllllllllllllIIIIIIIllllIllIlllI.clickEvent();
                if (lllllllllllllIIIIIIIllllIllIIllI != null) {
                    lllllllllllllIIIIIIIllllIlIllllI.mergeClickEvent(this, lllllllllllllIIIIIIIllllIllIIllI);
                }
                final HoverEvent<?> lllllllllllllIIIIIIIllllIllIIlIl = lllllllllllllIIIIIIIllllIllIlllI.hoverEvent();
                if (lllllllllllllIIIIIIIllllIllIIlIl != null) {
                    lllllllllllllIIIIIIIllllIlIllllI.mergeHoverEvent(this, lllllllllllllIIIIIIIllllIllIIlIl);
                }
            }
            if (lllllllllllllIIIIIIIllllIllIllII.contains(Merge.INSERTION)) {
                final String lllllllllllllIIIIIIIllllIllIIlII = lllllllllllllIIIIIIIllllIllIlllI.insertion();
                if (lllllllllllllIIIIIIIllllIllIIlII != null) {
                    lllllllllllllIIIIIIIllllIlIllllI.mergeInsertion(this, lllllllllllllIIIIIIIllllIllIIlII);
                }
            }
            if (lllllllllllllIIIIIIIllllIllIllII.contains(Merge.FONT)) {
                final Key lllllllllllllIIIIIIIllllIllIIIll = lllllllllllllIIIIIIIllllIllIlllI.font();
                if (lllllllllllllIIIIIIIllllIllIIIll != null) {
                    lllllllllllllIIIIIIIllllIlIllllI.mergeFont(this, lllllllllllllIIIIIIIllllIllIIIll);
                }
            }
            return this;
        }
        
        @NotNull
        @Override
        public Builder decorate(@NotNull final TextDecoration lllllllllllllIIIIIIIlllllIllIlII) {
            return this.decoration(lllllllllllllIIIIIIIlllllIllIlII, TextDecoration.State.TRUE);
        }
        
        @NotNull
        @Override
        public Builder hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIIIIIIIlllllIIIIIll) {
            this.hoverEvent = HoverEventSource.unbox(lllllllllllllIIIIIIIlllllIIIIIll);
            return this;
        }
        
        @NotNull
        Builder decorationIfAbsent(@NotNull final TextDecoration lllllllllllllIIIIIIIlllllIIlIlII, final TextDecoration.State lllllllllllllIIIIIIIlllllIIlIIll) {
            Objects.requireNonNull(lllllllllllllIIIIIIIlllllIIlIIll, "state");
            if (lllllllllllllIIIIIIIlllllIIlIlII == TextDecoration.BOLD && this.bold == TextDecoration.State.NOT_SET) {
                this.bold = lllllllllllllIIIIIIIlllllIIlIIll;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlIlII == TextDecoration.ITALIC && this.italic == TextDecoration.State.NOT_SET) {
                this.italic = lllllllllllllIIIIIIIlllllIIlIIll;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlIlII == TextDecoration.UNDERLINED && this.underlined == TextDecoration.State.NOT_SET) {
                this.underlined = lllllllllllllIIIIIIIlllllIIlIIll;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlIlII == TextDecoration.STRIKETHROUGH && this.strikethrough == TextDecoration.State.NOT_SET) {
                this.strikethrough = lllllllllllllIIIIIIIlllllIIlIIll;
                return this;
            }
            if (lllllllllllllIIIIIIIlllllIIlIlII == TextDecoration.OBFUSCATED && this.obfuscated == TextDecoration.State.NOT_SET) {
                this.obfuscated = lllllllllllllIIIIIIIlllllIIlIIll;
                return this;
            }
            throw new IllegalArgumentException(String.format("unknown decoration '%s'", lllllllllllllIIIIIIIlllllIIlIlII));
        }
        
        @NotNull
        @Override
        public Builder insertion(@Nullable final String lllllllllllllIIIIIIIllllIlllllII) {
            this.insertion = lllllllllllllIIIIIIIllllIlllllII;
            return this;
        }
    }
}
