package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

final class TranslatableComponentImpl extends AbstractComponent implements TranslatableComponent
{
    private final /* synthetic */ List<Component> args;
    private final /* synthetic */ String key;
    
    @NotNull
    @Override
    public TranslatableComponent args(@NotNull final ComponentLike... llIIllllllIlII) {
        return new TranslatableComponentImpl(this.children, this.style, this.key, llIIllllllIlII);
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T[])new ExaminableProperty[] { ExaminableProperty.of("key", this.key), ExaminableProperty.of("args", this.args) }), super.examinablePropertiesWithoutChildren());
    }
    
    @NotNull
    @Override
    public String key() {
        return this.key;
    }
    
    @NotNull
    @Override
    public TranslatableComponent children(@NotNull final List<? extends ComponentLike> llIIlllllIIllI) {
        return new TranslatableComponentImpl(llIIlllllIIllI, this.style, this.key, this.args);
    }
    
    @NotNull
    @Override
    public List<Component> args() {
        return this.args;
    }
    
    @NotNull
    @Override
    public TranslatableComponent args(@NotNull final List<? extends ComponentLike> llIIlllllIllIl) {
        return new TranslatableComponentImpl(this.children, this.style, this.key, llIIlllllIllIl);
    }
    
    TranslatableComponentImpl(@NotNull final List<Component> llIlIIIIlIIIll, @NotNull final Style llIlIIIIlIIIIl, @NotNull final String llIlIIIIlIIlII, @NotNull final ComponentLike[] llIlIIIIlIIIlI) {
        this(llIlIIIIlIIIll, llIlIIIIlIIIIl, llIlIIIIlIIlII, Arrays.asList(llIlIIIIlIIIlI));
    }
    
    @Override
    public int hashCode() {
        int llIIllllIIllIl = super.hashCode();
        llIIllllIIllIl = 31 * llIIllllIIllIl + this.key.hashCode();
        llIIllllIIllIl = 31 * llIIllllIIllIl + this.args.hashCode();
        return llIIllllIIllIl;
    }
    
    @NotNull
    @Override
    public TranslatableComponent style(@NotNull final Style llIIllllIlllll) {
        return new TranslatableComponentImpl(this.children, llIIllllIlllll, this.key, this.args);
    }
    
    @Override
    public boolean equals(@Nullable final Object llIIllllIlIlll) {
        if (this == llIIllllIlIlll) {
            return true;
        }
        if (!(llIIllllIlIlll instanceof TranslatableComponent)) {
            return false;
        }
        if (!super.equals(llIIllllIlIlll)) {
            return false;
        }
        final TranslatableComponent llIIllllIlIlII = (TranslatableComponent)llIIllllIlIlll;
        return Objects.equals(this.key, llIIllllIlIlII.key()) && Objects.equals(this.args, llIIllllIlIlII.args());
    }
    
    TranslatableComponentImpl(@NotNull final List<? extends ComponentLike> llIlIIIIIIllll, @NotNull final Style llIlIIIIIlIIII, @NotNull final String llIlIIIIIlIIIl, @NotNull final List<? extends ComponentLike> llIlIIIIIIlllI) {
        super(llIlIIIIIIllll, llIlIIIIIlIIII);
        this.key = Objects.requireNonNull(llIlIIIIIlIIIl, "key");
        this.args = ComponentLike.asComponents(llIlIIIIIIlllI);
    }
    
    @NotNull
    @Override
    public TranslatableComponent key(@NotNull final String llIIlllllllllI) {
        if (Objects.equals(this.key, llIIlllllllllI)) {
            return this;
        }
        return new TranslatableComponentImpl(this.children, this.style, Objects.requireNonNull(llIIlllllllllI, "key"), this.args);
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    static final class BuilderImpl extends AbstractComponentBuilder<TranslatableComponent, TranslatableComponent.Builder> implements TranslatableComponent.Builder
    {
        private /* synthetic */ List<? extends Component> args;
        @Nullable
        private /* synthetic */ String key;
        
        @NotNull
        @Override
        public TranslatableComponent.Builder args(@NotNull final List<? extends ComponentLike> lllllllllllllIlIlIIlllllIIIlllIl) {
            this.args = ComponentLike.asComponents(lllllllllllllIlIlIIlllllIIIlllIl);
            return this;
        }
        
        @NotNull
        @Override
        public TranslatableComponentImpl build() {
            if (this.key == null) {
                throw new IllegalStateException("key must be set");
            }
            return new TranslatableComponentImpl(this.children, this.buildStyle(), this.key, this.args);
        }
        
        @NotNull
        @Override
        public TranslatableComponent.Builder args(@NotNull final ComponentBuilder<?, ?> lllllllllllllIlIlIIlllllIIlllIIl) {
            return this.args((List<? extends ComponentLike>)Collections.singletonList(lllllllllllllIlIlIIlllllIIlllIIl.build()));
        }
        
        @NotNull
        @Override
        public TranslatableComponent.Builder args(@NotNull final ComponentLike... lllllllllllllIlIlIIlllllIIlIIlII) {
            if (lllllllllllllIlIlIIlllllIIlIIlII.length == 0) {
                return this.args(Collections.emptyList());
            }
            return this.args(Arrays.asList(lllllllllllllIlIlIIlllllIIlIIlII));
        }
        
        @NotNull
        @Override
        public TranslatableComponent.Builder args(@NotNull final ComponentBuilder<?, ?>... lllllllllllllIlIlIIlllllIIllIIlI) {
            if (lllllllllllllIlIlIIlllllIIllIIlI.length == 0) {
                return this.args(Collections.emptyList());
            }
            return this.args((List<? extends ComponentLike>)Stream.of(lllllllllllllIlIlIIlllllIIllIIlI).map((Function<? super ComponentBuilder<?, ?>, ?>)ComponentBuilder::build).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
        }
        
        @NotNull
        @Override
        public TranslatableComponent.Builder key(@NotNull final String lllllllllllllIlIlIIlllllIlIIIIII) {
            this.key = lllllllllllllIlIlIIlllllIlIIIIII;
            return this;
        }
        
        @NotNull
        @Override
        public TranslatableComponent.Builder args(@NotNull final Component lllllllllllllIlIlIIlllllIIlIlIll) {
            return this.args(Collections.singletonList(lllllllllllllIlIlIIlllllIIlIlIll));
        }
        
        BuilderImpl() {
            this.args = Collections.emptyList();
        }
        
        BuilderImpl(@NotNull final TranslatableComponent lllllllllllllIlIlIIlllllIlIIIlll) {
            super(lllllllllllllIlIlIIlllllIlIIIlll);
            this.args = Collections.emptyList();
            this.key = lllllllllllllIlIlIIlllllIlIIIlll.key();
            this.args = lllllllllllllIlIlIIlllllIlIIIlll.args();
        }
    }
}
