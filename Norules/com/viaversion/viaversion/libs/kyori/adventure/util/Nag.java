package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;

public abstract class Nag extends RuntimeException
{
    protected Nag(final String lllllllllllllIllIllIIIllIIlIlIII) {
        super(lllllllllllllIllIllIIIllIIlIlIII);
    }
    
    public static void print(@NotNull final Nag lllllllllllllIllIllIIIllIIlIllIl) {
        lllllllllllllIllIllIIIllIIlIllIl.printStackTrace();
    }
}
