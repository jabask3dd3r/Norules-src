package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;

final class ScoreComponentImpl extends AbstractComponent implements ScoreComponent
{
    private final /* synthetic */ String name;
    @Deprecated
    @Nullable
    private final /* synthetic */ String value;
    private final /* synthetic */ String objective;
    
    @NotNull
    @Override
    public String name() {
        return this.name;
    }
    
    @NotNull
    @Override
    public ScoreComponent style(@NotNull final Style llllllllllllllIIlIIIIlIIlIlIlIII) {
        return new ScoreComponentImpl(this.children, llllllllllllllIIlIIIIlIIlIlIlIII, this.name, this.objective, this.value);
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T[])new ExaminableProperty[] { ExaminableProperty.of("name", this.name), ExaminableProperty.of("objective", this.objective), ExaminableProperty.of("value", this.value) }), super.examinablePropertiesWithoutChildren());
    }
    
    @NotNull
    @Override
    public ScoreComponent objective(@NotNull final String llllllllllllllIIlIIIIlIIllIIIIII) {
        if (Objects.equals(this.objective, llllllllllllllIIlIIIIlIIllIIIIII)) {
            return this;
        }
        return new ScoreComponentImpl(this.children, this.style, this.name, Objects.requireNonNull(llllllllllllllIIlIIIIlIIllIIIIII, "objective"), this.value);
    }
    
    @NotNull
    @Override
    public ScoreComponent name(@NotNull final String llllllllllllllIIlIIIIlIIllIIlIlI) {
        if (Objects.equals(this.name, llllllllllllllIIlIIIIlIIllIIlIlI)) {
            return this;
        }
        return new ScoreComponentImpl(this.children, this.style, Objects.requireNonNull(llllllllllllllIIlIIIIlIIllIIlIlI, "name"), this.objective, this.value);
    }
    
    ScoreComponentImpl(@NotNull final List<? extends ComponentLike> llllllllllllllIIlIIIIlIIllIlllIl, @NotNull final Style llllllllllllllIIlIIIIlIIllIlllII, @NotNull final String llllllllllllllIIlIIIIlIIllIllllI, @NotNull final String llllllllllllllIIlIIIIlIIllIlllll, @Nullable final String llllllllllllllIIlIIIIlIIlllIIIII) {
        super(llllllllllllllIIlIIIIlIIllIlllIl, llllllllllllllIIlIIIIlIIllIlllII);
        this.name = llllllllllllllIIlIIIIlIIllIllllI;
        this.objective = llllllllllllllIIlIIIIlIIllIlllll;
        this.value = llllllllllllllIIlIIIIlIIlllIIIII;
    }
    
    @Deprecated
    @NotNull
    @Override
    public ScoreComponent value(@Nullable final String llllllllllllllIIlIIIIlIIlIllIllI) {
        if (Objects.equals(this.value, llllllllllllllIIlIIIIlIIlIllIllI)) {
            return this;
        }
        return new ScoreComponentImpl(this.children, this.style, this.name, this.objective, llllllllllllllIIlIIIIlIIlIllIllI);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIIlIIIIlIIlIIlIllI = super.hashCode();
        llllllllllllllIIlIIIIlIIlIIlIllI = 31 * llllllllllllllIIlIIIIlIIlIIlIllI + this.name.hashCode();
        llllllllllllllIIlIIIIlIIlIIlIllI = 31 * llllllllllllllIIlIIIIlIIlIIlIllI + this.objective.hashCode();
        llllllllllllllIIlIIIIlIIlIIlIllI = 31 * llllllllllllllIIlIIIIlIIlIIlIllI + Objects.hashCode(this.value);
        return llllllllllllllIIlIIIIlIIlIIlIllI;
    }
    
    @Deprecated
    @Nullable
    @Override
    public String value() {
        return this.value;
    }
    
    @NotNull
    @Override
    public ScoreComponent children(@NotNull final List<? extends ComponentLike> llllllllllllllIIlIIIIlIIlIlIllll) {
        return new ScoreComponentImpl(llllllllllllllIIlIIIIlIIlIlIllll, this.style, this.name, this.objective, this.value);
    }
    
    @Override
    public boolean equals(@Nullable final Object llllllllllllllIIlIIIIlIIlIlIIIII) {
        if (this == llllllllllllllIIlIIIIlIIlIlIIIII) {
            return true;
        }
        if (!(llllllllllllllIIlIIIIlIIlIlIIIII instanceof ScoreComponent)) {
            return false;
        }
        if (!super.equals(llllllllllllllIIlIIIIlIIlIlIIIII)) {
            return false;
        }
        final ScoreComponent llllllllllllllIIlIIIIlIIlIIlllIl = (ScoreComponent)llllllllllllllIIlIIIIlIIlIlIIIII;
        return Objects.equals(this.name, llllllllllllllIIlIIIIlIIlIIlllIl.name()) && Objects.equals(this.objective, llllllllllllllIIlIIIIlIIlIIlllIl.objective()) && Objects.equals(this.value, llllllllllllllIIlIIIIlIIlIIlllIl.value());
    }
    
    @NotNull
    @Override
    public String objective() {
        return this.objective;
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    static final class BuilderImpl extends AbstractComponentBuilder<ScoreComponent, ScoreComponent.Builder> implements ScoreComponent.Builder
    {
        @Nullable
        private /* synthetic */ String objective;
        @Nullable
        private /* synthetic */ String value;
        @Nullable
        private /* synthetic */ String name;
        
        BuilderImpl() {
        }
        
        @Deprecated
        @NotNull
        @Override
        public ScoreComponent.Builder value(@Nullable final String lllllllllllllIlIIllIllllIllIllII) {
            this.value = lllllllllllllIlIIllIllllIllIllII;
            return this;
        }
        
        @NotNull
        @Override
        public ScoreComponent.Builder objective(@NotNull final String lllllllllllllIlIIllIllllIlllIIll) {
            this.objective = lllllllllllllIlIIllIllllIlllIIll;
            return this;
        }
        
        @NotNull
        @Override
        public ScoreComponent.Builder name(@NotNull final String lllllllllllllIlIIllIllllIllllIlI) {
            this.name = lllllllllllllIlIIllIllllIllllIlI;
            return this;
        }
        
        BuilderImpl(@NotNull final ScoreComponent lllllllllllllIlIIllIlllllIIIIIIl) {
            super(lllllllllllllIlIIllIlllllIIIIIIl);
            this.name = lllllllllllllIlIIllIlllllIIIIIIl.name();
            this.objective = lllllllllllllIlIIllIlllllIIIIIIl.objective();
            this.value = lllllllllllllIlIIllIlllllIIIIIIl.value();
        }
        
        @NotNull
        @Override
        public ScoreComponent build() {
            if (this.name == null) {
                throw new IllegalStateException("name must be set");
            }
            if (this.objective == null) {
                throw new IllegalStateException("objective must be set");
            }
            return new ScoreComponentImpl(this.children, this.buildStyle(), this.name, this.objective, this.value);
        }
    }
}
