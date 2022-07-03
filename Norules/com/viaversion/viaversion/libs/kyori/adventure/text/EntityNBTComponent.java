package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface EntityNBTComponent extends NBTComponent<EntityNBTComponent, Builder>, ScopedComponent<EntityNBTComponent>
{
    @NotNull
    String selector();
    
    @Contract(pure = true)
    @NotNull
    EntityNBTComponent selector(@NotNull final String lllllllllllllIlIIlIIllllIllIIIlI);
    
    public interface Builder extends NBTComponentBuilder<EntityNBTComponent, Builder>
    {
        @NotNull
        @Contract("_ -> this")
        Builder selector(@NotNull final String lllllllllllllIllIllllIlIIllllIlI);
    }
}
