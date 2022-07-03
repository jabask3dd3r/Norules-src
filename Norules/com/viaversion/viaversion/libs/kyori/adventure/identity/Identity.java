package com.viaversion.viaversion.libs.kyori.adventure.identity;

import com.viaversion.viaversion.libs.kyori.adventure.pointer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

public interface Identity extends Examinable
{
    @NotNull
    default Identity nil() {
        return Identities.NIL;
    }
    
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("uuid", this.uuid()));
    }
    
    @NotNull
    default Identity identity(@NotNull final UUID llllllllllllllllllIIIIIIlIIIllIl) {
        if (llllllllllllllllllIIIIIIlIIIllIl.equals(Identities.NIL.uuid())) {
            return Identities.NIL;
        }
        return new IdentityImpl(llllllllllllllllllIIIIIIlIIIllIl);
    }
    
    @NotNull
    UUID uuid();
}
