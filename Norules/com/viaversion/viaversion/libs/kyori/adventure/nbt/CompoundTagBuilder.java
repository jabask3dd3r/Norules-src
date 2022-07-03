package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;

final class CompoundTagBuilder implements CompoundBinaryTag.Builder
{
    @Nullable
    private /* synthetic */ Map<String, BinaryTag> tags;
    
    @Override
    public CompoundBinaryTag.Builder put(@NotNull final String lllllllllllllIIlllIIIIIlIIllllll, @NotNull final BinaryTag lllllllllllllIIlllIIIIIlIlIIIIII) {
        this.tags().put(lllllllllllllIIlllIIIIIlIIllllll, lllllllllllllIIlllIIIIIlIlIIIIII);
        return this;
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag build() {
        if (this.tags == null) {
            return CompoundBinaryTag.empty();
        }
        return new CompoundBinaryTagImpl(new HashMap<String, BinaryTag>(this.tags));
    }
    
    private Map<String, BinaryTag> tags() {
        if (this.tags == null) {
            this.tags = new HashMap<String, BinaryTag>();
        }
        return this.tags;
    }
    
    @Override
    public CompoundBinaryTag.Builder put(@NotNull final Map<String, ? extends BinaryTag> lllllllllllllIIlllIIIIIlIIlIIlll) {
        this.tags().putAll(lllllllllllllIIlllIIIIIlIIlIIlll);
        return this;
    }
    
    @Override
    public CompoundBinaryTag.Builder put(@NotNull final CompoundBinaryTag lllllllllllllIIlllIIIIIlIIllIIll) {
        final Map<String, BinaryTag> lllllllllllllIIlllIIIIIlIIlIllll = this.tags();
        for (final String lllllllllllllIIlllIIIIIlIIllIIlI : lllllllllllllIIlllIIIIIlIIllIIll.keySet()) {
            lllllllllllllIIlllIIIIIlIIlIllll.put(lllllllllllllIIlllIIIIIlIIllIIlI, lllllllllllllIIlllIIIIIlIIllIIll.get(lllllllllllllIIlllIIIIIlIIllIIlI));
        }
        return this;
    }
    
    @Override
    public CompoundBinaryTag.Builder remove(@NotNull final String lllllllllllllIIlllIIIIIlIIIllllI, @Nullable final Consumer<? super BinaryTag> lllllllllllllIIlllIIIIIlIIIlllIl) {
        if (this.tags != null) {
            final BinaryTag lllllllllllllIIlllIIIIIlIIIlllII = this.tags.remove(lllllllllllllIIlllIIIIIlIIIllllI);
            if (lllllllllllllIIlllIIIIIlIIIlllIl != null) {
                lllllllllllllIIlllIIIIIlIIIlllIl.accept(lllllllllllllIIlllIIIIIlIIIlllII);
            }
        }
        return this;
    }
}
