package com.viaversion.viaversion.libs.kyori.adventure.text;

import java.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class SelectorComponentImpl extends AbstractComponent implements SelectorComponent
{
    @Nullable
    private final /* synthetic */ Component separator;
    private final /* synthetic */ String pattern;
    
    @Nullable
    @Override
    public Component separator() {
        return this.separator;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlIlIIllIlIIIIIIIlI) {
        if (this == lllllllllllllIlIlIIllIlIIIIIIIlI) {
            return true;
        }
        if (!(lllllllllllllIlIlIIllIlIIIIIIIlI instanceof SelectorComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllIlIlIIllIlIIIIIIIlI)) {
            return false;
        }
        final SelectorComponent lllllllllllllIlIlIIllIIlllllllll = (SelectorComponent)lllllllllllllIlIlIIllIlIIIIIIIlI;
        return Objects.equals(this.pattern, lllllllllllllIlIlIIllIIlllllllll.pattern()) && Objects.equals(this.separator, lllllllllllllIlIlIIllIIlllllllll.separator());
    }
    
    @NotNull
    @Override
    public SelectorComponent separator(@Nullable final ComponentLike lllllllllllllIlIlIIllIlIIIIllIII) {
        return new SelectorComponentImpl(this.children, this.style, this.pattern, lllllllllllllIlIlIIllIlIIIIllIII);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIlIIllIIllllllIII = super.hashCode();
        lllllllllllllIlIlIIllIIllllllIII = 31 * lllllllllllllIlIlIIllIIllllllIII + this.pattern.hashCode();
        lllllllllllllIlIlIIllIIllllllIII = 31 * lllllllllllllIlIlIIllIIllllllIII + Objects.hashCode(this.separator);
        return lllllllllllllIlIlIIllIIllllllIII;
    }
    
    @NotNull
    @Override
    public String pattern() {
        return this.pattern;
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public SelectorComponent style(@NotNull final Style lllllllllllllIlIlIIllIlIIIIIlIlI) {
        return new SelectorComponentImpl(this.children, lllllllllllllIlIlIIllIlIIIIIlIlI, this.pattern, this.separator);
    }
    
    SelectorComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIlIlIIllIlIIIllIlIl, @NotNull final Style lllllllllllllIlIlIIllIlIIIllIIll, @NotNull final String lllllllllllllIlIlIIllIlIIIllIlII, @Nullable final ComponentLike lllllllllllllIlIlIIllIlIIIllIIlI) {
        super(lllllllllllllIlIlIIllIlIIIllIlIl, lllllllllllllIlIlIIllIlIIIllIIll);
        this.pattern = lllllllllllllIlIlIIllIlIIIllIlII;
        this.separator = ComponentLike.unbox(lllllllllllllIlIlIIllIlIIIllIIlI);
    }
    
    @NotNull
    @Override
    public SelectorComponent pattern(@NotNull final String lllllllllllllIlIlIIllIlIIIlIIIlI) {
        if (Objects.equals(this.pattern, lllllllllllllIlIlIIllIlIIIlIIIlI)) {
            return this;
        }
        return new SelectorComponentImpl(this.children, this.style, Objects.requireNonNull(lllllllllllllIlIlIIllIlIIIlIIIlI, "pattern"), this.separator);
    }
    
    @NotNull
    @Override
    public SelectorComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllIlIlIIllIlIIIIlIIIl) {
        return new SelectorComponentImpl(lllllllllllllIlIlIIllIlIIIIlIIIl, this.style, this.pattern, this.separator);
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T[])new ExaminableProperty[] { ExaminableProperty.of("pattern", this.pattern), ExaminableProperty.of("separator", this.separator) }), super.examinablePropertiesWithoutChildren());
    }
    
    static final class BuilderImpl extends AbstractComponentBuilder<SelectorComponent, SelectorComponent.Builder> implements SelectorComponent.Builder
    {
        @Nullable
        private /* synthetic */ Component separator;
        @Nullable
        private /* synthetic */ String pattern;
        
        @NotNull
        @Override
        public SelectorComponent.Builder separator(@Nullable final ComponentLike lllllllllllllIlIIlIlllIIllllIIll) {
            this.separator = ComponentLike.unbox(lllllllllllllIlIIlIlllIIllllIIll);
            return this;
        }
        
        BuilderImpl(@NotNull final SelectorComponent lllllllllllllIlIIlIlllIlIIIIIIIl) {
            super(lllllllllllllIlIIlIlllIlIIIIIIIl);
            this.pattern = lllllllllllllIlIIlIlllIlIIIIIIIl.pattern();
        }
        
        @NotNull
        @Override
        public SelectorComponent build() {
            if (this.pattern == null) {
                throw new IllegalStateException("pattern must be set");
            }
            return new SelectorComponentImpl(this.children, this.buildStyle(), this.pattern, this.separator);
        }
        
        @NotNull
        @Override
        public SelectorComponent.Builder pattern(@NotNull final String lllllllllllllIlIIlIlllIIlllllIlI) {
            this.pattern = lllllllllllllIlIIlIlllIIlllllIlI;
            return this;
        }
        
        BuilderImpl() {
        }
    }
}
