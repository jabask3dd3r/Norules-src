package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.translation.*;
import java.util.*;

public interface TranslatableComponent extends BuildableComponent<TranslatableComponent, Builder>, ScopedComponent<TranslatableComponent>
{
    @Contract(pure = true)
    @NotNull
    TranslatableComponent args(@NotNull final List<? extends ComponentLike> llllllllllllllIIlllIlIlIIllIllll);
    
    @NotNull
    String key();
    
    @NotNull
    @Contract(pure = true)
    default TranslatableComponent key(@NotNull final Translatable llllllllllllllIIlllIlIlIIlllIllI) {
        return this.key(Objects.requireNonNull(llllllllllllllIIlllIlIlIIlllIllI, "translatable").translationKey());
    }
    
    @NotNull
    @Contract(pure = true)
    TranslatableComponent args(@NotNull final ComponentLike... llllllllllllllIIlllIlIlIIlllIIII);
    
    @NotNull
    @Contract(pure = true)
    TranslatableComponent key(@NotNull final String llllllllllllllIIlllIlIlIIlllIIIl);
    
    @NotNull
    List<Component> args();
    
    public interface Builder extends ComponentBuilder<TranslatableComponent, Builder>
    {
        @NotNull
        @Contract("_ -> this")
        Builder args(@NotNull final ComponentBuilder<?, ?> lllllllllllllIlIIIlIIlIIIIlIlllI);
        
        @Contract("_ -> this")
        @NotNull
        Builder args(@NotNull final ComponentLike... lllllllllllllIlIIIlIIlIIIIlIlIll);
        
        @NotNull
        @Contract("_ -> this")
        Builder key(@NotNull final String lllllllllllllIlIIIlIIlIIIIlIllll);
        
        @NotNull
        @Contract("_ -> this")
        Builder args(@NotNull final List<? extends ComponentLike> lllllllllllllIlIIIlIIlIIIIlIlIlI);
        
        @Contract("_ -> this")
        @NotNull
        Builder args(@NotNull final ComponentBuilder<?, ?>... lllllllllllllIlIIIlIIlIIIIlIllIl);
        
        @NotNull
        @Contract("_ -> this")
        Builder args(@NotNull final Component lllllllllllllIlIIIlIIlIIIIlIllII);
        
        @Contract(pure = true)
        @NotNull
        default Builder key(@NotNull final Translatable lllllllllllllIlIIIlIIlIIIIllIlII) {
            return this.key(Objects.requireNonNull(lllllllllllllIlIIIlIIlIIIIllIlII, "translatable").translationKey());
        }
    }
}
