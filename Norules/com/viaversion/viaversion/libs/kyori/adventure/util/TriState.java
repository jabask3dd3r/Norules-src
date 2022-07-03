package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;

public enum TriState
{
    TRUE, 
    NOT_SET, 
    FALSE;
    
    private static /* synthetic */ TriState[] $values() {
        return new TriState[] { TriState.NOT_SET, TriState.FALSE, TriState.TRUE };
    }
    
    @NotNull
    public static TriState byBoolean(final boolean lllllllllllllIlIlIlllIlIllIIIlIl) {
        return lllllllllllllIlIlIlllIlIllIIIlIl ? TriState.TRUE : TriState.FALSE;
    }
    
    static {
        $VALUES = $values();
    }
    
    @NotNull
    public static TriState byBoolean(@Nullable final Boolean lllllllllllllIlIlIlllIlIllIIIIIl) {
        return (lllllllllllllIlIlIlllIlIllIIIIIl == null) ? TriState.NOT_SET : byBoolean((boolean)lllllllllllllIlIlIlllIlIllIIIIIl);
    }
}
