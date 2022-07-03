package com.viaversion.viaversion.libs.kyori.adventure.nbt.api;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

public interface BinaryTagHolder
{
    @NotNull
    default <T, EX extends Exception> BinaryTagHolder encode(@NotNull final T lllllllllllllllIIlIlIllllllIllII, @NotNull final Codec<? super T, String, ?, EX> lllllllllllllllIIlIlIllllllIllIl) throws EX, Exception {
        return new BinaryTagHolderImpl(lllllllllllllllIIlIlIllllllIllIl.encode((Object)lllllllllllllllIIlIlIllllllIllII));
    }
    
    @NotNull
     <T, DX extends Exception> T get(@NotNull final Codec<T, String, DX, ?> lllllllllllllllIIlIlIlllllIllIll) throws DX, Exception;
    
    @NotNull
    default BinaryTagHolder of(@NotNull final String lllllllllllllllIIlIlIllllllIIIIl) {
        return new BinaryTagHolderImpl(lllllllllllllllIIlIlIllllllIIIIl);
    }
    
    @NotNull
    String string();
}
