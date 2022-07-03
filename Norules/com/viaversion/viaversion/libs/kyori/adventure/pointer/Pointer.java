package com.viaversion.viaversion.libs.kyori.adventure.pointer;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

public interface Pointer<V> extends Examinable
{
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("type", this.type()), ExaminableProperty.of("key", this.key()) });
    }
    
    @NotNull
    default <V> Pointer<V> pointer(@NotNull final Class<V> llllllllllllllIIIllIlIlllIIIIIIl, @NotNull final Key llllllllllllllIIIllIlIlllIIIIIlI) {
        return new PointerImpl<V>(llllllllllllllIIIllIlIlllIIIIIIl, llllllllllllllIIIllIlIlllIIIIIlI);
    }
    
    @NotNull
    Key key();
    
    @NotNull
    Class<V> type();
}
