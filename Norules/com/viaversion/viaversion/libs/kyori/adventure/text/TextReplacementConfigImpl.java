package com.viaversion.viaversion.libs.kyori.adventure.text;

import java.util.function.*;
import java.util.regex.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;

final class TextReplacementConfigImpl implements TextReplacementConfig
{
    private final /* synthetic */ Condition continuer;
    private final /* synthetic */ Pattern matchPattern;
    private final /* synthetic */ BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    TextReplacementRenderer.State createState() {
        return new TextReplacementRenderer.State(this.matchPattern, this.replacement, this.continuer);
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("matchPattern", this.matchPattern), ExaminableProperty.of("replacement", this.replacement), ExaminableProperty.of("continuer", this.continuer) });
    }
    
    @Override
    public TextReplacementConfig.Builder toBuilder() {
        return new Builder(this);
    }
    
    @NotNull
    @Override
    public Pattern matchPattern() {
        return this.matchPattern;
    }
    
    TextReplacementConfigImpl(final Builder llllllllllllllIllIIIlIIlIIllIIll) {
        this.matchPattern = llllllllllllllIllIIIlIIlIIllIIll.matchPattern;
        this.replacement = llllllllllllllIllIIIlIIlIIllIIll.replacement;
        this.continuer = llllllllllllllIllIIIlIIlIIllIIll.continuer;
    }
    
    static final class Builder implements TextReplacementConfig.Builder
    {
        @Nullable
        /* synthetic */ Pattern matchPattern;
        /* synthetic */ Condition continuer;
        @Nullable
        /* synthetic */ BiFunction<MatchResult, TextComponent.Builder, ComponentLike> replacement;
        
        Builder(final TextReplacementConfigImpl lllIIIIIIIIllII) {
            this.continuer = ((llIllllllIllIlI, llIllllllIllIIl, llIllllllIllIII) -> PatternReplacementResult.REPLACE);
            this.matchPattern = lllIIIIIIIIllII.matchPattern;
            this.replacement = lllIIIIIIIIllII.replacement;
            this.continuer = lllIIIIIIIIllII.continuer;
        }
        
        @NotNull
        @Override
        public Builder replacement(@NotNull final BiFunction<MatchResult, TextComponent.Builder, ComponentLike> llIllllllllIlll) {
            this.replacement = Objects.requireNonNull(llIllllllllIlll, "replacement");
            return this;
        }
        
        @NotNull
        @Override
        public Builder match(@NotNull final Pattern lllIIIIIIIIIlIl) {
            this.matchPattern = Objects.requireNonNull(lllIIIIIIIIIlIl, "pattern");
            return this;
        }
        
        @NotNull
        @Override
        public Builder condition(final Condition llIlllllllllllI) {
            this.continuer = Objects.requireNonNull(llIlllllllllllI, "continuation");
            return this;
        }
        
        Builder() {
            this.continuer = ((llIllllllIllIlI, llIllllllIllIIl, llIllllllIllIII) -> PatternReplacementResult.REPLACE);
        }
        
        @NotNull
        @Override
        public TextReplacementConfig build() {
            if (this.matchPattern == null) {
                throw new IllegalStateException("A pattern must be provided to match against");
            }
            if (this.replacement == null) {
                throw new IllegalStateException("A replacement action must be provided");
            }
            return new TextReplacementConfigImpl(this);
        }
    }
}
