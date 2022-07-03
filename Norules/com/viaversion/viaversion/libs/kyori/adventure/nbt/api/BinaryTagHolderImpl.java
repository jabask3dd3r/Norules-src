package com.viaversion.viaversion.libs.kyori.adventure.nbt.api;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import java.util.*;

final class BinaryTagHolderImpl implements BinaryTagHolder
{
    private final /* synthetic */ String string;
    
    @Override
    public String toString() {
        return this.string;
    }
    
    @NotNull
    @Override
    public <T, DX extends Exception> T get(@NotNull final Codec<T, String, DX, ?> lllllllllllllIIIIllIIllIIIlIlllI) throws DX, Exception {
        return lllllllllllllIIIIllIIllIIIlIlllI.decode(this.string);
    }
    
    @Override
    public int hashCode() {
        return 31 * this.string.hashCode();
    }
    
    @NotNull
    @Override
    public String string() {
        return this.string;
    }
    
    BinaryTagHolderImpl(final String lllllllllllllIIIIllIIllIIIlllIII) {
        this.string = Objects.requireNonNull(lllllllllllllIIIIllIIllIIIlllIII, "string");
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIllIIllIIIlIIlII) {
        return lllllllllllllIIIIllIIllIIIlIIlII instanceof BinaryTagHolderImpl && this.string.equals(((BinaryTagHolderImpl)lllllllllllllIIIIllIIllIIIlIIlII).string);
    }
}
