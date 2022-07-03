package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;

public interface Codec<D, E, DX extends Throwable, EX extends Throwable>
{
    @NotNull
    D decode(@NotNull final E lllllllllllllIIIIIlIIIIIlllIIIlI) throws DX, Throwable;
    
    @NotNull
    default <D, E, DX extends Throwable, EX extends Throwable> Codec<D, E, DX, EX> of(@NotNull final Decoder<D, E, DX> lllllllllllllIIIIIlIIIIIlllIlIII, @NotNull final Encoder<D, E, EX> lllllllllllllIIIIIlIIIIIlllIIlll) {
        return new Codec<D, E, DX, EX>() {
            @NotNull
            @Override
            public D decode(@NotNull final E llIllllIIIlIlll) throws DX, Throwable {
                return lllllllllllllIIIIIlIIIIIlllIlIII.decode(llIllllIIIlIlll);
            }
            
            @NotNull
            @Override
            public E encode(@NotNull final D llIllllIIIlIIII) throws EX, Throwable {
                return lllllllllllllIIIIIlIIIIIlllIIlll.encode(llIllllIIIlIIII);
            }
        };
    }
    
    @NotNull
    E encode(@NotNull final D lllllllllllllIIIIIlIIIIIlllIIIIl) throws EX, Throwable;
    
    public interface Decoder<D, E, X extends Throwable>
    {
        @NotNull
        D decode(@NotNull final E llllllllllllllllllIlIlllIlIIlIll) throws X, Throwable;
    }
    
    public interface Encoder<D, E, X extends Throwable>
    {
        @NotNull
        E encode(@NotNull final D lllllllllllllIIllllIIlIlIlIlIlII) throws X, Throwable;
    }
}
