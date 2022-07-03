package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;

public interface NBTComponent<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends BuildableComponent<C, B>
{
    @Nullable
    Component separator();
    
    boolean interpret();
    
    @NotNull
    @Contract(pure = true)
    C interpret(final boolean llllllllllllllllllIIIlIlIllIIlII);
    
    @NotNull
    String nbtPath();
    
    @Contract(pure = true)
    @NotNull
    C nbtPath(@NotNull final String llllllllllllllllllIIIlIlIllIIlIl);
    
    @NotNull
    C separator(@Nullable final ComponentLike llllllllllllllllllIIIlIlIllIIIll);
}
