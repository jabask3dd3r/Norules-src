package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface KeybindComponent extends BuildableComponent<KeybindComponent, Builder>, ScopedComponent<KeybindComponent>
{
    @NotNull
    @Contract(pure = true)
    KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIlIlIlIIllIlII);
    
    @NotNull
    String keybind();
    
    public interface Builder extends ComponentBuilder<KeybindComponent, Builder>
    {
        @Contract("_ -> this")
        @NotNull
        Builder keybind(@NotNull final String lllllllllllllIllllllIIlIIIIIlIll);
    }
}
