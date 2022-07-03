package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.util.function.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;

@ApiStatus.NonExtendable
public interface Style extends Buildable<Style, Builder>, Examinable
{
    @NotNull
    default Style decorate(@NotNull final TextDecoration lllllllllllllIllIIlIlIIIlIllIlII) {
        return this.decoration(lllllllllllllIllIIlIlIIIlIllIlII, TextDecoration.State.TRUE);
    }
    
    TextDecoration.State decoration(@NotNull final TextDecoration lllllllllllllIllIIlIlIIIlIllIlll);
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIIlIlIlII, @NotNull final Set<Merge> lllllllllllllIllIIlIlIIIIlIlIlIl) {
        return this.merge(lllllllllllllIllIIlIlIIIIlIlIlII, Merge.Strategy.ALWAYS, lllllllllllllIllIIlIlIIIIlIlIlIl);
    }
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIIllIIIlI, final Merge.Strategy lllllllllllllIllIIlIlIIIIllIIIIl, @NotNull final Merge... lllllllllllllIllIIlIlIIIIllIIIll) {
        return this.merge(lllllllllllllIllIIlIlIIIIllIIIlI, lllllllllllllIllIIlIlIIIIllIIIIl, Merge.of(lllllllllllllIllIIlIlIIIIllIIIll));
    }
    
    @NotNull
    default Style empty() {
        return StyleImpl.EMPTY;
    }
    
    @NotNull
    Style decoration(@NotNull final TextDecoration lllllllllllllIllIIlIlIIIlIlIIlII, final TextDecoration.State lllllllllllllIllIIlIlIIIlIlIIIll);
    
    @Nullable
    String insertion();
    
    @NotNull
    Style font(@Nullable final Key lllllllllllllIllIIlIlIIIllIIIIIl);
    
    @NotNull
    Map<TextDecoration, TextDecoration.State> decorations();
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIlIIlllII) {
        return this.merge(lllllllllllllIllIIlIlIIIlIIlllII, Merge.all());
    }
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIlIIlIIll, final Merge.Strategy lllllllllllllIllIIlIlIIIlIIlIlII) {
        return this.merge(lllllllllllllIllIIlIlIIIlIIlIIll, lllllllllllllIllIIlIlIIIlIIlIlII, Merge.all());
    }
    
    @NotNull
    default Style style(@Nullable final TextColor lllllllllllllIllIIlIlIIIllllIlll, final Set<TextDecoration> lllllllllllllIllIIlIlIIIllllIllI) {
        final Builder lllllllllllllIllIIlIlIIIllllIIlI = style();
        lllllllllllllIllIIlIlIIIllllIIlI.color(lllllllllllllIllIIlIlIIIllllIlll);
        if (!lllllllllllllIllIIlIlIIIllllIllI.isEmpty()) {
            for (final TextDecoration lllllllllllllIllIIlIlIIIllllIlIl : lllllllllllllIllIIlIlIIIllllIllI) {
                lllllllllllllIllIIlIlIIIllllIIlI.decoration(lllllllllllllIllIIlIlIIIllllIlIl, true);
            }
        }
        return lllllllllllllIllIIlIlIIIllllIIlI.build();
    }
    
    @NotNull
    Style clickEvent(@Nullable final ClickEvent lllllllllllllIllIIlIlIIIlIlIIIIl);
    
    boolean isEmpty();
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIIllIlllI, @NotNull final Merge... lllllllllllllIllIIlIlIIIIllIllll) {
        return this.merge(lllllllllllllIllIIlIlIIIIllIlllI, Merge.of(lllllllllllllIllIIlIlIIIIllIllll));
    }
    
    @NotNull
    Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIIlIIlIll, final Merge.Strategy lllllllllllllIllIIlIlIIIIlIIllII, @NotNull final Set<Merge> lllllllllllllIllIIlIlIIIIlIIllIl);
    
    @NotNull
    default Style style(@NotNull final Consumer<Builder> lllllllllllllIllIIlIlIIlIIIlIIlI) {
        return Buildable.configureAndBuild(style(), lllllllllllllIllIIlIlIIlIIIlIIlI);
    }
    
    @NotNull
    Style hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIllIIlIlIIIlIlIIIII);
    
    @NotNull
    default Style edit(@NotNull final Consumer<Builder> lllllllllllllIllIIlIlIIIllIlIIIl) {
        return this.edit(lllllllllllllIllIIlIlIIIllIlIIIl, Merge.Strategy.ALWAYS);
    }
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIIlllllIl, final Merge.Strategy lllllllllllllIllIIlIlIIIIlllllII, @NotNull final Merge lllllllllllllIllIIlIlIIIIllllIll) {
        return this.merge(lllllllllllllIllIIlIlIIIIlllllIl, lllllllllllllIllIIlIlIIIIlllllII, Collections.singleton(lllllllllllllIllIIlIlIIIIllllIll));
    }
    
    @NotNull
    default Style merge(@NotNull final Style lllllllllllllIllIIlIlIIIlIIIlIIl, @NotNull final Merge lllllllllllllIllIIlIlIIIlIIIlIII) {
        return this.merge(lllllllllllllIllIIlIlIIIlIIIlIIl, Collections.singleton(lllllllllllllIllIIlIlIIIlIIIlIII));
    }
    
    @NotNull
    default Builder style() {
        return new StyleImpl.BuilderImpl();
    }
    
    @NotNull
    default Style style(final StyleBuilderApplicable... lllllllllllllIllIIlIlIIIlllIlIII) {
        if (lllllllllllllIllIIlIlIIIlllIlIII.length == 0) {
            return empty();
        }
        final Builder lllllllllllllIllIIlIlIIIlllIIlII = style();
        for (int lllllllllllllIllIIlIlIIIlllIIlll = 0, lllllllllllllIllIIlIlIIIlllIIllI = lllllllllllllIllIIlIlIIIlllIlIII.length; lllllllllllllIllIIlIlIIIlllIIlll < lllllllllllllIllIIlIlIIIlllIIllI; ++lllllllllllllIllIIlIlIIIlllIIlll) {
            lllllllllllllIllIIlIlIIIlllIlIII[lllllllllllllIllIIlIlIIIlllIIlll].styleApply(lllllllllllllIllIIlIlIIIlllIIlII);
        }
        return lllllllllllllIllIIlIlIIIlllIIlII.build();
    }
    
    @NotNull
    Style decorations(@NotNull final Map<TextDecoration, TextDecoration.State> lllllllllllllIllIIlIlIIIlIlIIIlI);
    
    @NotNull
    Style insertion(@Nullable final String lllllllllllllIllIIlIlIIIlIIlllll);
    
    @NotNull
    default Style style(@Nullable final TextColor lllllllllllllIllIIlIlIIlIIIIlllI) {
        if (lllllllllllllIllIIlIlIIlIIIIlllI == null) {
            return empty();
        }
        return new StyleImpl(null, lllllllllllllIllIIlIlIIlIIIIlllI, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, TextDecoration.State.NOT_SET, null, null, null);
    }
    
    @NotNull
    Style colorIfAbsent(@Nullable final TextColor lllllllllllllIllIIlIlIIIlIllllll);
    
    @NotNull
    default Style edit(@NotNull final Consumer<Builder> lllllllllllllIllIIlIlIIIllIIlIIl, final Merge.Strategy lllllllllllllIllIIlIlIIIllIIlIII) {
        return style(lllllllllllllIllIIlIlIIIIlIIIIII -> {
            if (lllllllllllllIllIIlIlIIIllIIlIII == Merge.Strategy.ALWAYS) {
                lllllllllllllIllIIlIlIIIIlIIIIII.merge(this, lllllllllllllIllIIlIlIIIllIIlIII);
            }
            lllllllllllllIllIIlIlIIIllIIlIIl.accept(lllllllllllllIllIIlIlIIIIlIIIIII);
            if (lllllllllllllIllIIlIlIIIllIIlIII == Merge.Strategy.IF_ABSENT_ON_TARGET) {
                lllllllllllllIllIIlIlIIIIlIIIIII.merge(this, lllllllllllllIllIIlIlIIIllIIlIII);
            }
        });
    }
    
    @NotNull
    default Style style(@NotNull final TextDecoration lllllllllllllIllIIlIlIIlIIIIlIlI) {
        return style().decoration(lllllllllllllIllIIlIlIIlIIIIlIlI, true).build();
    }
    
    default boolean hasDecoration(@NotNull final TextDecoration lllllllllllllIllIIlIlIIIlIllllII) {
        return this.decoration(lllllllllllllIllIIlIlIIIlIllllII) == TextDecoration.State.TRUE;
    }
    
    @Nullable
    ClickEvent clickEvent();
    
    @Nullable
    TextColor color();
    
    @NotNull
    default Style style(@NotNull final Iterable<? extends StyleBuilderApplicable> lllllllllllllIllIIlIlIIIllIllIll) {
        final Builder lllllllllllllIllIIlIlIIIllIllIII = style();
        for (final StyleBuilderApplicable lllllllllllllIllIIlIlIIIllIllIlI : lllllllllllllIllIIlIlIIIllIllIll) {
            lllllllllllllIllIIlIlIIIllIllIlI.styleApply(lllllllllllllIllIIlIlIIIllIllIII);
        }
        return lllllllllllllIllIIlIlIIIllIllIII.build();
    }
    
    @NotNull
    default Style style(@Nullable final TextColor lllllllllllllIllIIlIlIIlIIIIIlII, final TextDecoration... lllllllllllllIllIIlIlIIlIIIIIIll) {
        final Builder lllllllllllllIllIIlIlIIlIIIIIIII = style();
        lllllllllllllIllIIlIlIIlIIIIIIII.color(lllllllllllllIllIIlIlIIlIIIIIlII);
        StyleImpl.decorate(lllllllllllllIllIIlIlIIlIIIIIIII, lllllllllllllIllIIlIlIIlIIIIIIll);
        return lllllllllllllIllIIlIlIIlIIIIIIII.build();
    }
    
    @Nullable
    HoverEvent<?> hoverEvent();
    
    @NotNull
    Style color(@Nullable final TextColor lllllllllllllIllIIlIlIIIllIIIIII);
    
    @NotNull
    default Style decoration(@NotNull final TextDecoration lllllllllllllIllIIlIlIIIlIlIllII, final boolean lllllllllllllIllIIlIlIIIlIlIlIll) {
        return this.decoration(lllllllllllllIllIIlIlIIIlIlIllII, TextDecoration.State.byBoolean(lllllllllllllIllIIlIlIIIlIlIlIll));
    }
    
    @NotNull
    Builder toBuilder();
    
    @Nullable
    Key font();
    
    public enum Merge
    {
        static final /* synthetic */ Set<Merge> ALL;
        
        DECORATIONS, 
        EVENTS, 
        FONT, 
        INSERTION, 
        COLOR;
        
        static final /* synthetic */ Set<Merge> COLOR_AND_DECORATIONS;
        
        static boolean hasAll(@NotNull final Set<Merge> lllllllllllllllllIlIlIlllIIIlIII) {
            return lllllllllllllllllIlIlIlllIIIlIII.size() == Merge.ALL.size();
        }
        
        @NotNull
        public static Set<Merge> colorAndDecorations() {
            return Merge.COLOR_AND_DECORATIONS;
        }
        
        @NotNull
        public static Set<Merge> all() {
            return Merge.ALL;
        }
        
        private static /* synthetic */ Merge[] $values() {
            return new Merge[] { Merge.COLOR, Merge.DECORATIONS, Merge.EVENTS, Merge.INSERTION, Merge.FONT };
        }
        
        @NotNull
        public static Set<Merge> of(final Merge... lllllllllllllllllIlIlIlllIIIllII) {
            return MonkeyBars.enumSet(Merge.class, lllllllllllllllllIlIlIlllIIIllII);
        }
        
        static {
            $VALUES = $values();
            ALL = of(values());
            COLOR_AND_DECORATIONS = of(Merge.COLOR, Merge.DECORATIONS);
        }
        
        public enum Strategy
        {
            NEVER, 
            ALWAYS, 
            IF_ABSENT_ON_TARGET;
            
            private static /* synthetic */ Strategy[] $values() {
                return new Strategy[] { Strategy.ALWAYS, Strategy.NEVER, Strategy.IF_ABSENT_ON_TARGET };
            }
            
            static {
                $VALUES = $values();
            }
        }
    }
    
    public interface Builder extends Buildable.Builder<Style>
    {
        @NotNull
        @Contract("_, _ -> this")
        default Builder decoration(@NotNull final TextDecoration lllllllllllllIllllIlIIIIIlIIIIII, final boolean lllllllllllllIllllIlIIIIIlIIIIIl) {
            return this.decoration(lllllllllllllIllllIlIIIIIlIIIIII, TextDecoration.State.byBoolean(lllllllllllllIllllIlIIIIIlIIIIIl));
        }
        
        @NotNull
        @Contract("_ -> this")
        Builder colorIfAbsent(@Nullable final TextColor lllllllllllllIllllIlIIIIIlIllIIl);
        
        @NotNull
        @Contract("_, _ -> this")
        default Builder merge(@NotNull final Style lllllllllllllIllllIlIIIIIIIIIlII, @NotNull final Set<Merge> lllllllllllllIllllIlIIIIIIIIIlIl) {
            return this.merge(lllllllllllllIllllIlIIIIIIIIIlII, Merge.Strategy.ALWAYS, lllllllllllllIllllIlIIIIIIIIIlIl);
        }
        
        @NotNull
        @Contract("_ -> this")
        Builder font(@Nullable final Key lllllllllllllIllllIlIIIIIlIllIll);
        
        @Contract("_ -> this")
        @NotNull
        default Builder decorate(@NotNull final TextDecoration... lllllllllllllIllllIlIIIIIlIIllIl) {
            for (int lllllllllllllIllllIlIIIIIlIIllII = 0, lllllllllllllIllllIlIIIIIlIIlIll = lllllllllllllIllllIlIIIIIlIIllIl.length; lllllllllllllIllllIlIIIIIlIIllII < lllllllllllllIllllIlIIIIIlIIlIll; ++lllllllllllllIllllIlIIIIIlIIllII) {
                this.decorate(lllllllllllllIllllIlIIIIIlIIllIl[lllllllllllllIllllIlIIIIIlIIllII]);
            }
            return this;
        }
        
        @NotNull
        @Contract("_, _, _ -> this")
        Builder merge(@NotNull final Style lllllllllllllIllllIIlllllllllIll, final Merge.Strategy lllllllllllllIllllIIllllllllllIl, @NotNull final Set<Merge> lllllllllllllIllllIIllllllllllII);
        
        @NotNull
        @Contract("_, _ -> this")
        default Builder merge(@NotNull final Style lllllllllllllIllllIlIIIIIIIlllll, @NotNull final Merge... lllllllllllllIllllIlIIIIIIIllllI) {
            if (lllllllllllllIllllIlIIIIIIIllllI.length == 0) {
                return this;
            }
            return this.merge(lllllllllllllIllllIlIIIIIIIlllll, Merge.of(lllllllllllllIllllIlIIIIIIIllllI));
        }
        
        @Contract("_ -> this")
        @NotNull
        Builder color(@Nullable final TextColor lllllllllllllIllllIlIIIIIlIllIlI);
        
        @NotNull
        @Contract("_, _ -> this")
        default Builder merge(@NotNull final Style lllllllllllllIllllIlIIIIIIlIlIlI, final Merge.Strategy lllllllllllllIllllIlIIIIIIlIlIIl) {
            return this.merge(lllllllllllllIllllIlIIIIIIlIlIlI, lllllllllllllIllllIlIIIIIIlIlIIl, Merge.all());
        }
        
        @NotNull
        Style build();
        
        @Contract("_ -> this")
        @NotNull
        Builder clickEvent(@Nullable final ClickEvent lllllllllllllIllllIlIIIIIIllIlll);
        
        @NotNull
        @Contract("_, _ -> this")
        Builder decoration(@NotNull final TextDecoration lllllllllllllIllllIlIIIIIIlllIII, final TextDecoration.State lllllllllllllIllllIlIIIIIIlllIIl);
        
        @Contract("_ -> this")
        @NotNull
        Builder hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIllllIlIIIIIIllIllI);
        
        @NotNull
        @Contract("_, _, _ -> this")
        default Builder merge(@NotNull final Style lllllllllllllIllllIlIIIIIIIlIIlI, final Merge.Strategy lllllllllllllIllllIlIIIIIIIlIIll, @NotNull final Merge... lllllllllllllIllllIlIIIIIIIlIIIl) {
            if (lllllllllllllIllllIlIIIIIIIlIIIl.length == 0) {
                return this;
            }
            return this.merge(lllllllllllllIllllIlIIIIIIIlIIlI, lllllllllllllIllllIlIIIIIIIlIIll, Merge.of(lllllllllllllIllllIlIIIIIIIlIIIl));
        }
        
        @Contract("_ -> this")
        @NotNull
        default Builder decorate(@NotNull final TextDecoration lllllllllllllIllllIlIIIIIlIlIllI) {
            return this.decoration(lllllllllllllIllllIlIIIIIlIlIllI, TextDecoration.State.TRUE);
        }
        
        @Contract("_ -> this")
        @NotNull
        default Builder apply(@NotNull final StyleBuilderApplicable lllllllllllllIllllIIlllllllllIII) {
            lllllllllllllIllllIIlllllllllIII.styleApply(this);
            return this;
        }
        
        @NotNull
        @Contract("_ -> this")
        default Builder merge(@NotNull final Style lllllllllllllIllllIlIIIIIIllIIlI) {
            return this.merge(lllllllllllllIllllIlIIIIIIllIIlI, Merge.all());
        }
        
        @Contract("_ -> this")
        @NotNull
        Builder insertion(@Nullable final String lllllllllllllIllllIlIIIIIIllIlIl);
    }
}
