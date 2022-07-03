package com.viaversion.viaversion.libs.kyori.adventure.text.serializer;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;

public interface ComponentSerializer<I extends Component, O extends Component, R>
{
    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    @Nullable
    default R serializeOr(@Nullable final I llllllllllllllIlllIIllllIIIlIllI, @Nullable final R llllllllllllllIlllIIllllIIIlIlIl) {
        if (llllllllllllllIlllIIllllIIIlIllI == null) {
            return llllllllllllllIlllIIllllIIIlIlIl;
        }
        return this.serialize(llllllllllllllIlllIIllllIIIlIllI);
    }
    
    @NotNull
    O deserialize(@NotNull final R llllllllllllllIlllIIllllIIlllIll);
    
    @Nullable
    @Contract(value = "!null -> !null; null -> null", pure = true)
    default O deserializeOrNull(@Nullable final R llllllllllllllIlllIIllllIIllIIIl) {
        return this.deserializeOr(llllllllllllllIlllIIllllIIllIIIl, null);
    }
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default O deseializeOrNull(@Nullable final R llllllllllllllIlllIIllllIIlllIII) {
        return this.deserializeOrNull(llllllllllllllIlllIIllllIIlllIII);
    }
    
    @Nullable
    @Contract(value = "!null, _ -> !null; null, _ -> param2", pure = true)
    default O deserializeOr(@Nullable final R llllllllllllllIlllIIllllIIlIlIIl, @Nullable final O llllllllllllllIlllIIllllIIlIlIII) {
        if (llllllllllllllIlllIIllllIIlIlIIl == null) {
            return llllllllllllllIlllIIllllIIlIlIII;
        }
        return this.deserialize(llllllllllllllIlllIIllllIIlIlIIl);
    }
    
    @NotNull
    R serialize(@NotNull final I llllllllllllllIlllIIllllIIlIIIIl);
    
    @Contract(value = "!null -> !null; null -> null", pure = true)
    @Nullable
    default R serializeOrNull(@Nullable final I llllllllllllllIlllIIllllIIIllllI) {
        return this.serializeOr(llllllllllllllIlllIIllllIIIllllI, null);
    }
}
