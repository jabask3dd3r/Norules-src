package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import org.jetbrains.annotations.*;
import java.util.*;

public interface CompoundTagSetter<R>
{
    @NotNull
    R put(@NotNull final String lllllllllllllllllllIlIlllllIIIll, @NotNull final BinaryTag lllllllllllllllllllIlIlllllIIIlI);
    
    @NotNull
    R remove(@NotNull final String lllllllllllllllllllIlIllllIlIlll, @Nullable final Consumer<? super BinaryTag> lllllllllllllllllllIlIllllIllIII);
    
    @NotNull
    default R putBoolean(@NotNull final String lllllllllllllllllllIlIllllIlIIll, final boolean lllllllllllllllllllIlIllllIlIIlI) {
        return this.put(lllllllllllllllllllIlIllllIlIIll, lllllllllllllllllllIlIllllIlIIlI ? ByteBinaryTag.ONE : ByteBinaryTag.ZERO);
    }
    
    @NotNull
    default R putByte(@NotNull final String lllllllllllllllllllIlIllllIIIlll, final byte lllllllllllllllllllIlIllllIIlIII) {
        return this.put(lllllllllllllllllllIlIllllIIIlll, ByteBinaryTag.of(lllllllllllllllllllIlIllllIIlIII));
    }
    
    @NotNull
    default R putString(@NotNull final String lllllllllllllllllllIlIllIllllIll, @NotNull final String lllllllllllllllllllIlIllIllllIlI) {
        return this.put(lllllllllllllllllllIlIllIllllIll, StringBinaryTag.of(lllllllllllllllllllIlIllIllllIlI));
    }
    
    @NotNull
    default R putFloat(@NotNull final String lllllllllllllllllllIlIlllIIllIll, final float lllllllllllllllllllIlIlllIIlllII) {
        return this.put(lllllllllllllllllllIlIlllIIllIll, FloatBinaryTag.of(lllllllllllllllllllIlIlllIIlllII));
    }
    
    @NotNull
    default R putLong(@NotNull final String lllllllllllllllllllIlIlllIlIIllI, final long lllllllllllllllllllIlIlllIlIIlll) {
        return this.put(lllllllllllllllllllIlIlllIlIIllI, LongBinaryTag.of(lllllllllllllllllllIlIlllIlIIlll));
    }
    
    @NotNull
    default R putLongArray(@NotNull final String lllllllllllllllllllIlIllIllIIlIl, final long[] lllllllllllllllllllIlIllIllIIlII) {
        return this.put(lllllllllllllllllllIlIllIllIIlIl, LongArrayBinaryTag.of(lllllllllllllllllllIlIllIllIIlII));
    }
    
    @NotNull
    default R putIntArray(@NotNull final String lllllllllllllllllllIlIllIlllIIII, final int[] lllllllllllllllllllIlIllIllIllll) {
        return this.put(lllllllllllllllllllIlIllIlllIIII, IntArrayBinaryTag.of(lllllllllllllllllllIlIllIllIllll));
    }
    
    @NotNull
    default R putInt(@NotNull final String lllllllllllllllllllIlIlllIllIIIl, final int lllllllllllllllllllIlIlllIllIIlI) {
        return this.put(lllllllllllllllllllIlIlllIllIIIl, IntBinaryTag.of(lllllllllllllllllllIlIlllIllIIlI));
    }
    
    @NotNull
    R put(@NotNull final CompoundBinaryTag lllllllllllllllllllIlIlllllIIIIl);
    
    @NotNull
    default R putShort(@NotNull final String lllllllllllllllllllIlIlllIllllII, final short lllllllllllllllllllIlIlllIllllIl) {
        return this.put(lllllllllllllllllllIlIlllIllllII, ShortBinaryTag.of(lllllllllllllllllllIlIlllIllllIl));
    }
    
    @NotNull
    R put(@NotNull final Map<String, ? extends BinaryTag> lllllllllllllllllllIlIlllllIIIII);
    
    @NotNull
    default R putByteArray(@NotNull final String lllllllllllllllllllIlIlllIIIIllI, final byte[] lllllllllllllllllllIlIlllIIIIlIl) {
        return this.put(lllllllllllllllllllIlIlllIIIIllI, ByteArrayBinaryTag.of(lllllllllllllllllllIlIlllIIIIlIl));
    }
    
    @NotNull
    default R remove(@NotNull final String lllllllllllllllllllIlIllllIlllIl) {
        return this.remove(lllllllllllllllllllIlIllllIlllIl, null);
    }
    
    @NotNull
    default R putDouble(@NotNull final String lllllllllllllllllllIlIlllIIlIIIl, final double lllllllllllllllllllIlIlllIIlIIII) {
        return this.put(lllllllllllllllllllIlIlllIIlIIIl, DoubleBinaryTag.of(lllllllllllllllllllIlIlllIIlIIII));
    }
}
