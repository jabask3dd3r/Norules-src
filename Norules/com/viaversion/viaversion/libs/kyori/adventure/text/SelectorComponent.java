package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface SelectorComponent extends BuildableComponent<SelectorComponent, Builder>, ScopedComponent<SelectorComponent>
{
    @NotNull
    String pattern();
    
    @Contract(pure = true)
    @NotNull
    SelectorComponent pattern(@NotNull final String lllllllllllllllIIIllIlIllllllIll);
    
    @NotNull
    SelectorComponent separator(@Nullable final ComponentLike lllllllllllllllIIIllIlIllllllIlI);
    
    @Nullable
    Component separator();
    
    public interface Builder extends ComponentBuilder<SelectorComponent, Builder>
    {
        @Contract("_ -> this")
        @NotNull
        Builder separator(@Nullable final ComponentLike lllllllllllllIlIlIIlIIIllIllllll);
        
        @Contract("_ -> this")
        @NotNull
        Builder pattern(@NotNull final String lllllllllllllIlIlIIlIIIlllIIIIII);
    }
}
