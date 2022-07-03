package com.viaversion.viaversion.libs.kyori.adventure.permission;

import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.pointer.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

public interface PermissionChecker extends Predicate<String>
{
    default boolean test(final String llllllllllllllllIIlIllIllIIIIlII) {
        return this.value(llllllllllllllllIIlIllIllIIIIlII) == TriState.TRUE;
    }
    
    @NotNull
    default PermissionChecker always(final TriState llllllllllllllllIIlIllIllIIIlIlI) {
        if (llllllllllllllllIIlIllIllIIIlIlI == TriState.TRUE) {
            return PermissionCheckers.TRUE;
        }
        if (llllllllllllllllIIlIllIllIIIlIlI == TriState.FALSE) {
            return PermissionCheckers.FALSE;
        }
        return PermissionCheckers.NOT_SET;
    }
    
    @NotNull
    TriState value(final String llllllllllllllllIIlIllIllIIIIlll);
}
