package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class StorageNBTComponentImpl extends NBTComponentImpl<StorageNBTComponent, StorageNBTComponent.Builder> implements StorageNBTComponent
{
    private final /* synthetic */ Key storage;
    
    @NotNull
    @Override
    public StorageNBTComponent style(@NotNull final Style lllllllllllllIlllIllIIlIIllllIll) {
        return new StorageNBTComponentImpl(this.children, lllllllllllllIlllIllIIlIIllllIll, this.nbtPath, this.interpret, this.separator, this.storage);
    }
    
    @NotNull
    @Override
    public StorageNBTComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllIlllIllIIlIlIIIIIlI) {
        return new StorageNBTComponentImpl(lllllllllllllIlllIllIIlIlIIIIIlI, this.style, this.nbtPath, this.interpret, this.separator, this.storage);
    }
    
    @Override
    public StorageNBTComponent.Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public StorageNBTComponent nbtPath(@NotNull final String lllllllllllllIlllIllIIlIlIllIIIl) {
        if (Objects.equals(this.nbtPath, lllllllllllllIlllIllIIlIlIllIIIl)) {
            return this;
        }
        return new StorageNBTComponentImpl(this.children, this.style, lllllllllllllIlllIllIIlIlIllIIIl, this.interpret, this.separator, this.storage);
    }
    
    @NotNull
    @Override
    public StorageNBTComponent storage(@NotNull final Key lllllllllllllIlllIllIIlIlIIIlIIl) {
        if (Objects.equals(this.storage, lllllllllllllIlllIllIIlIlIIIlIIl)) {
            return this;
        }
        return new StorageNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, this.separator, lllllllllllllIlllIllIIlIlIIIlIIl);
    }
    
    @NotNull
    @Override
    public StorageNBTComponent separator(@Nullable final ComponentLike lllllllllllllIlllIllIIlIlIIlIIll) {
        return new StorageNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, lllllllllllllIlllIllIIlIlIIlIIll, this.storage);
    }
    
    @Nullable
    @Override
    public Component separator() {
        return this.separator;
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("storage", this.storage)), super.examinablePropertiesWithoutChildren());
    }
    
    StorageNBTComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIlllIllIIlIllIlIllI, @NotNull final Style lllllllllllllIlllIllIIlIllIIlllI, final String lllllllllllllIlllIllIIlIllIlIIII, final boolean lllllllllllllIlllIllIIlIllIlIlII, @Nullable final ComponentLike lllllllllllllIlllIllIIlIllIllIII, final Key lllllllllllllIlllIllIIlIllIlIIlI) {
        super(lllllllllllllIlllIllIIlIllIlIllI, lllllllllllllIlllIllIIlIllIIlllI, lllllllllllllIlllIllIIlIllIlIIII, lllllllllllllIlllIllIIlIllIlIlII, lllllllllllllIlllIllIIlIllIllIII);
        this.storage = lllllllllllllIlllIllIIlIllIlIIlI;
    }
    
    @NotNull
    @Override
    public Key storage() {
        return this.storage;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlllIllIIlIIllIlIIl = super.hashCode();
        lllllllllllllIlllIllIIlIIllIlIIl = 31 * lllllllllllllIlllIllIIlIIllIlIIl + this.storage.hashCode();
        return lllllllllllllIlllIllIIlIIllIlIIl;
    }
    
    @NotNull
    @Override
    public StorageNBTComponent interpret(final boolean lllllllllllllIlllIllIIlIlIlIIlII) {
        if (this.interpret == lllllllllllllIlllIllIIlIlIlIIlII) {
            return this;
        }
        return new StorageNBTComponentImpl(this.children, this.style, this.nbtPath, lllllllllllllIlllIllIIlIlIlIIlII, this.separator, this.storage);
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlllIllIIlIIlllIIll) {
        if (this == lllllllllllllIlllIllIIlIIlllIIll) {
            return true;
        }
        if (!(lllllllllllllIlllIllIIlIIlllIIll instanceof StorageNBTComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllIlllIllIIlIIlllIIll)) {
            return false;
        }
        final StorageNBTComponentImpl lllllllllllllIlllIllIIlIIlllIIII = (StorageNBTComponentImpl)lllllllllllllIlllIllIIlIIlllIIll;
        return Objects.equals(this.storage, lllllllllllllIlllIllIIlIIlllIIII.storage());
    }
    
    static class BuilderImpl extends NBTComponentImpl.BuilderImpl<StorageNBTComponent, StorageNBTComponent.Builder> implements StorageNBTComponent.Builder
    {
        @Nullable
        private /* synthetic */ Key storage;
        
        @Override
        public StorageNBTComponent.Builder storage(@NotNull final Key lllllllllllllIllIIlIIIIIllIllIll) {
            this.storage = lllllllllllllIllIIlIIIIIllIllIll;
            return this;
        }
        
        BuilderImpl(@NotNull final StorageNBTComponent lllllllllllllIllIIlIIIIIlllIIIlI) {
            super(lllllllllllllIllIIlIIIIIlllIIIlI);
            this.storage = lllllllllllllIllIIlIIIIIlllIIIlI.storage();
        }
        
        BuilderImpl() {
        }
        
        @NotNull
        @Override
        public StorageNBTComponent build() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.storage == null) {
                throw new IllegalStateException("storage must be set");
            }
            return new StorageNBTComponentImpl(this.children, this.buildStyle(), this.nbtPath, this.interpret, this.separator, this.storage);
        }
    }
}
