package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface NBTComponentBuilder<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends ComponentBuilder<C, B>
{
    @Contract("_ -> this")
    @NotNull
    B nbtPath(@NotNull final String llllllllllllllIIIlllllllIlIIIIII);
    
    @Contract("_ -> this")
    @NotNull
    B interpret(final boolean llllllllllllllIIIlllllllIIllllll);
    
    @NotNull
    @Contract("_ -> this")
    B separator(@Nullable final ComponentLike llllllllllllllIIIlllllllIIlllllI);
}
