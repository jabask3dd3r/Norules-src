package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;

final class EntityNBTComponentImpl extends NBTComponentImpl<EntityNBTComponent, EntityNBTComponent.Builder> implements EntityNBTComponent
{
    private final /* synthetic */ String selector;
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllIIIIIIIIllIIlIIll) {
        if (this == lllllllllllllllIIIIIIIIllIIlIIll) {
            return true;
        }
        if (!(lllllllllllllllIIIIIIIIllIIlIIll instanceof EntityNBTComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllllIIIIIIIIllIIlIIll)) {
            return false;
        }
        final EntityNBTComponentImpl lllllllllllllllIIIIIIIIllIIlIIII = (EntityNBTComponentImpl)lllllllllllllllIIIIIIIIllIIlIIll;
        return Objects.equals(this.selector, lllllllllllllllIIIIIIIIllIIlIIII.selector());
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("selector", this.selector)), super.examinablePropertiesWithoutChildren());
    }
    
    @NotNull
    @Override
    public EntityNBTComponent nbtPath(@NotNull final String lllllllllllllllIIIIIIIIlllIIIlII) {
        if (Objects.equals(this.nbtPath, lllllllllllllllIIIIIIIIlllIIIlII)) {
            return this;
        }
        return new EntityNBTComponentImpl(this.children, this.style, lllllllllllllllIIIIIIIIlllIIIlII, this.interpret, this.separator, this.selector);
    }
    
    @NotNull
    @Override
    public String selector() {
        return this.selector;
    }
    
    @NotNull
    @Override
    public EntityNBTComponent interpret(final boolean lllllllllllllllIIIIIIIIllIllllIl) {
        if (this.interpret == lllllllllllllllIIIIIIIIllIllllIl) {
            return this;
        }
        return new EntityNBTComponentImpl(this.children, this.style, this.nbtPath, lllllllllllllllIIIIIIIIllIllllIl, this.separator, this.selector);
    }
    
    @Override
    public EntityNBTComponent.Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    EntityNBTComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllllIIIIIIIIlllIllIII, @NotNull final Style lllllllllllllllIIIIIIIIlllIllIIl, final String lllllllllllllllIIIIIIIIlllIlIlIl, final boolean lllllllllllllllIIIIIIIIlllIlIllI, @Nullable final ComponentLike lllllllllllllllIIIIIIIIlllIllIlI, final String lllllllllllllllIIIIIIIIlllIlIlll) {
        super(lllllllllllllllIIIIIIIIlllIllIII, lllllllllllllllIIIIIIIIlllIllIIl, lllllllllllllllIIIIIIIIlllIlIlIl, lllllllllllllllIIIIIIIIlllIlIllI, lllllllllllllllIIIIIIIIlllIllIlI);
        this.selector = lllllllllllllllIIIIIIIIlllIlIlll;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIIIIIIIllIIIlIIl = super.hashCode();
        lllllllllllllllIIIIIIIIllIIIlIIl = 31 * lllllllllllllllIIIIIIIIllIIIlIIl + this.selector.hashCode();
        return lllllllllllllllIIIIIIIIllIIIlIIl;
    }
    
    @NotNull
    @Override
    public EntityNBTComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllllIIIIIIIIllIlIIIlI) {
        return new EntityNBTComponentImpl(lllllllllllllllIIIIIIIIllIlIIIlI, this.style, this.nbtPath, this.interpret, this.separator, this.selector);
    }
    
    @Nullable
    @Override
    public Component separator() {
        return this.separator;
    }
    
    @NotNull
    @Override
    public EntityNBTComponent separator(@Nullable final ComponentLike lllllllllllllllIIIIIIIIllIllIIll) {
        return new EntityNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, lllllllllllllllIIIIIIIIllIllIIll, this.selector);
    }
    
    @NotNull
    @Override
    public EntityNBTComponent selector(@NotNull final String lllllllllllllllIIIIIIIIllIlIlIIl) {
        if (Objects.equals(this.selector, lllllllllllllllIIIIIIIIllIlIlIIl)) {
            return this;
        }
        return new EntityNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, this.separator, lllllllllllllllIIIIIIIIllIlIlIIl);
    }
    
    @NotNull
    @Override
    public EntityNBTComponent style(@NotNull final Style lllllllllllllllIIIIIIIIllIIllIll) {
        return new EntityNBTComponentImpl(this.children, lllllllllllllllIIIIIIIIllIIllIll, this.nbtPath, this.interpret, this.separator, this.selector);
    }
    
    static final class BuilderImpl extends NBTComponentImpl.BuilderImpl<EntityNBTComponent, EntityNBTComponent.Builder> implements EntityNBTComponent.Builder
    {
        @Nullable
        private /* synthetic */ String selector;
        
        @Override
        public EntityNBTComponent.Builder selector(@NotNull final String llIlIlIlIIIlII) {
            this.selector = llIlIlIlIIIlII;
            return this;
        }
        
        BuilderImpl() {
        }
        
        BuilderImpl(@NotNull final EntityNBTComponent llIlIlIlIIlIll) {
            super(llIlIlIlIIlIll);
            this.selector = llIlIlIlIIlIll.selector();
        }
        
        @NotNull
        @Override
        public EntityNBTComponent build() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.selector == null) {
                throw new IllegalStateException("selector must be set");
            }
            return new EntityNBTComponentImpl(this.children, this.buildStyle(), this.nbtPath, this.interpret, this.separator, this.selector);
        }
    }
}
