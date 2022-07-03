package com.viaversion.viaversion.libs.kyori.adventure.key;

import org.jetbrains.annotations.*;

public final class InvalidKeyException extends RuntimeException
{
    private final /* synthetic */ String keyNamespace;
    private final /* synthetic */ String keyValue;
    
    InvalidKeyException(@NotNull final String lllllllllllllIllIIlIllIllllIllll, @NotNull final String lllllllllllllIllIIlIllIllllIlllI, @Nullable final String lllllllllllllIllIIlIllIlllllIIII) {
        super(lllllllllllllIllIIlIllIlllllIIII);
        this.keyNamespace = lllllllllllllIllIIlIllIllllIllll;
        this.keyValue = lllllllllllllIllIIlIllIllllIlllI;
    }
    
    @NotNull
    public final String keyValue() {
        return this.keyValue;
    }
    
    @NotNull
    public final String keyNamespace() {
        return this.keyNamespace;
    }
}
