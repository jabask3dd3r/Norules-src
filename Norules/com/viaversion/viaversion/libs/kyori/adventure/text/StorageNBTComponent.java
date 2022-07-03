package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;

public interface StorageNBTComponent extends NBTComponent<StorageNBTComponent, Builder>, ScopedComponent<StorageNBTComponent>
{
    @NotNull
    @Contract(pure = true)
    StorageNBTComponent storage(@NotNull final Key lllllllllllllIIIlIIIIIlIIIIIllIl);
    
    @NotNull
    Key storage();
    
    public interface Builder extends NBTComponentBuilder<StorageNBTComponent, Builder>
    {
        @NotNull
        @Contract("_ -> this")
        Builder storage(@NotNull final Key llllllllllllllIIllIIIlllllllIllI);
    }
}
