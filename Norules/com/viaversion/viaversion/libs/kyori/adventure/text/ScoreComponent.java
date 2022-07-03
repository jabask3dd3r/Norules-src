package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface ScoreComponent extends BuildableComponent<ScoreComponent, Builder>, ScopedComponent<ScoreComponent>
{
    @NotNull
    String name();
    
    @Deprecated
    @Contract(pure = true)
    @NotNull
    ScoreComponent value(@Nullable final String lllllllllllllIlIIIIllIlIlIlIlIlI);
    
    @Contract(pure = true)
    @NotNull
    ScoreComponent name(@NotNull final String lllllllllllllIlIIIIllIlIlIlIllII);
    
    @Deprecated
    @Nullable
    String value();
    
    @NotNull
    String objective();
    
    @NotNull
    @Contract(pure = true)
    ScoreComponent objective(@NotNull final String lllllllllllllIlIIIIllIlIlIlIlIll);
    
    public interface Builder extends ComponentBuilder<ScoreComponent, Builder>
    {
        @Contract("_ -> this")
        @NotNull
        Builder objective(@NotNull final String lllllllllllllllIlIllllIIIlIlIlIl);
        
        @Contract("_ -> this")
        @NotNull
        Builder name(@NotNull final String lllllllllllllllIlIllllIIIlIlIllI);
        
        @Deprecated
        @NotNull
        @Contract("_ -> this")
        Builder value(@Nullable final String lllllllllllllllIlIllllIIIlIlIlII);
    }
}
