package com.viaversion.viaversion.libs.kyori.adventure.text;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

final class KeybindComponentImpl extends AbstractComponent implements KeybindComponent
{
    private final /* synthetic */ String keybind;
    
    @NotNull
    @Override
    public KeybindComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllIIIIlIIlIlIlllIIlll) {
        return new KeybindComponentImpl(lllllllllllllIIIIlIIlIlIlllIIlll, this.style, this.keybind);
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("keybind", this.keybind)), super.examinablePropertiesWithoutChildren());
    }
    
    @NotNull
    @Override
    public KeybindComponent style(@NotNull final Style lllllllllllllIIIIlIIlIlIlllIIIII) {
        return new KeybindComponentImpl(this.children, lllllllllllllIIIIlIIlIlIlllIIIII, this.keybind);
    }
    
    @NotNull
    @Override
    public KeybindComponent keybind(@NotNull final String lllllllllllllIIIIlIIlIlIlllIlllI) {
        if (Objects.equals(this.keybind, lllllllllllllIIIIlIIlIlIlllIlllI)) {
            return this;
        }
        return new KeybindComponentImpl(this.children, this.style, Objects.requireNonNull(lllllllllllllIIIIlIIlIlIlllIlllI, "keybind"));
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIIlIIlIlIllIIlllI = super.hashCode();
        lllllllllllllIIIIlIIlIlIllIIlllI = 31 * lllllllllllllIIIIlIIlIlIllIIlllI + this.keybind.hashCode();
        return lllllllllllllIIIIlIIlIlIllIIlllI;
    }
    
    @NotNull
    @Override
    public String keybind() {
        return this.keybind;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIIIlIIlIlIllIllIII) {
        if (this == lllllllllllllIIIIlIIlIlIllIllIII) {
            return true;
        }
        if (!(lllllllllllllIIIIlIIlIlIllIllIII instanceof KeybindComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllIIIIlIIlIlIllIllIII)) {
            return false;
        }
        final KeybindComponent lllllllllllllIIIIlIIlIlIllIlIlIl = (KeybindComponent)lllllllllllllIIIIlIIlIlIllIllIII;
        return Objects.equals(this.keybind, lllllllllllllIIIIlIIlIlIllIlIlIl.keybind());
    }
    
    KeybindComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIIIIlIIlIlIlllllllI, @NotNull final Style lllllllllllllIIIIlIIlIlIllllllII, @NotNull final String lllllllllllllIIIIlIIlIlIllllllIl) {
        super(lllllllllllllIIIIlIIlIlIlllllllI, lllllllllllllIIIIlIIlIlIllllllII);
        this.keybind = Objects.requireNonNull(lllllllllllllIIIIlIIlIlIllllllIl, "keybind");
    }
    
    static final class BuilderImpl extends AbstractComponentBuilder<KeybindComponent, KeybindComponent.Builder> implements KeybindComponent.Builder
    {
        @Nullable
        private /* synthetic */ String keybind;
        
        @NotNull
        @Override
        public KeybindComponent build() {
            if (this.keybind == null) {
                throw new IllegalStateException("keybind must be set");
            }
            return new KeybindComponentImpl(this.children, this.buildStyle(), this.keybind);
        }
        
        BuilderImpl() {
        }
        
        @NotNull
        @Override
        public KeybindComponent.Builder keybind(@NotNull final String llllllllllllllIlIIllllIIIllllIII) {
            this.keybind = llllllllllllllIlIIllllIIIllllIII;
            return this;
        }
        
        BuilderImpl(@NotNull final KeybindComponent llllllllllllllIlIIllllIIIlllllll) {
            super(llllllllllllllIlIIllllIIIlllllll);
            this.keybind = llllllllllllllIlIIllllIIIlllllll.keybind();
        }
    }
}
