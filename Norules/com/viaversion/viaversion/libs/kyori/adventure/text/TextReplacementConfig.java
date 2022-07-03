package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.regex.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import org.intellij.lang.annotations.*;
import java.util.function.*;

public interface TextReplacementConfig extends Buildable<TextReplacementConfig, Builder>, Examinable
{
    @NotNull
    default Builder builder() {
        return new TextReplacementConfigImpl.Builder();
    }
    
    @NotNull
    Pattern matchPattern();
    
    @FunctionalInterface
    public interface Condition
    {
        @NotNull
        PatternReplacementResult shouldReplace(@NotNull final MatchResult lllllllllllllllIlIllllIlllllIlII, final int lllllllllllllllIlIllllIlllllIIll, final int lllllllllllllllIlIllllIlllllIlIl);
    }
    
    public interface Builder extends Buildable.Builder<TextReplacementConfig>
    {
        @NotNull
        @Contract("_ -> this")
        default Builder replacement(@NotNull final String lIIIlllllIllIII) {
            Objects.requireNonNull(lIIIlllllIllIII, "replacement");
            return this.replacement(lIIIllllIllIIII -> lIIIllllIllIIII.content(lIIIlllllIllIII));
        }
        
        @NotNull
        @Contract("_ -> this")
        default Builder replacement(@Nullable final ComponentLike lIIIlllllIlIIII) {
            final Component lIIIlllllIIllIl = (lIIIlllllIlIIII == null) ? null : lIIIlllllIlIIII.asComponent();
            return this.replacement((lIIIllllIlllIII, lIIIllllIllIlll) -> lIIIlllllIIllIl);
        }
        
        @NotNull
        @Contract("_ -> this")
        default Builder match(@NotNull @RegExp final String lIIIlllllllIIlI) {
            return this.match(Pattern.compile(lIIIlllllllIIlI));
        }
        
        @NotNull
        @Contract("_ -> this")
        default Builder condition(@NotNull final IntFunction2<PatternReplacementResult> lIIIllllllIIIII) {
            return this.condition((lIIIllllIlIlIll, lIIIllllIlIlIlI, lIIIllllIlIlIIl) -> lIIIllllllIIIII.apply(lIIIllllIlIlIlI, lIIIllllIlIlIIl));
        }
        
        @NotNull
        default Builder once() {
            return this.times(1);
        }
        
        @Contract("_ -> this")
        default Builder matchLiteral(final String lIIIllllllllIIl) {
            return this.match(Pattern.compile(lIIIllllllllIIl, 16));
        }
        
        @NotNull
        @Contract("_ -> this")
        default Builder times(final int lIIIllllllIIlll) {
            return this.condition((lIIIllllIlIIIlI, lIIIllllIIlllll) -> (lIIIllllIIlllll < lIIIllllllIIlll) ? PatternReplacementResult.REPLACE : PatternReplacementResult.STOP);
        }
        
        @Contract("_ -> this")
        @NotNull
        Builder match(@NotNull final Pattern lIIIllllllIllIl);
        
        @NotNull
        @Contract("_ -> this")
        Builder condition(@NotNull final Condition lIIIlllllIllIll);
        
        @NotNull
        @Contract("_ -> this")
        Builder replacement(@NotNull final BiFunction<MatchResult, TextComponent.Builder, ComponentLike> lIIIlllllIIIIlI);
        
        @Contract("_ -> this")
        @NotNull
        default Builder replacement(@NotNull final Function<TextComponent.Builder, ComponentLike> lIIIlllllIIIlll) {
            Objects.requireNonNull(lIIIlllllIIIlll, "replacement");
            return this.replacement((lIIIllllIlllllI, lIIIllllIlllIll) -> lIIIlllllIIIlll.apply(lIIIllllIlllIll));
        }
    }
}
