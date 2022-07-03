package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.*;
import org.jetbrains.annotations.*;

final class ListTagBuilder<T extends BinaryTag> implements ListBinaryTag.Builder<T>
{
    @Nullable
    private /* synthetic */ List<BinaryTag> tags;
    private /* synthetic */ BinaryTagType<? extends BinaryTag> elementType;
    
    ListTagBuilder(final BinaryTagType<? extends BinaryTag> lllllllllllllIIIlIIIIIlllllllllI) {
        this.elementType = lllllllllllllIIIlIIIIIlllllllllI;
    }
    
    ListTagBuilder() {
        this(BinaryTagTypes.END);
    }
    
    @Override
    public ListBinaryTag.Builder<T> add(final Iterable<? extends T> lllllllllllllIIIlIIIIIlllllIlllI) {
        for (final T lllllllllllllIIIlIIIIIlllllIllIl : lllllllllllllIIIlIIIIIlllllIlllI) {
            this.add((BinaryTag)lllllllllllllIIIlIIIIIlllllIllIl);
        }
        return this;
    }
    
    @NotNull
    @Override
    public ListBinaryTag build() {
        if (this.tags == null) {
            return ListBinaryTag.empty();
        }
        return new ListBinaryTagImpl(this.elementType, new ArrayList<BinaryTag>(this.tags));
    }
    
    @Override
    public ListBinaryTag.Builder<T> add(final BinaryTag lllllllllllllIIIlIIIIIllllllIlll) {
        ListBinaryTagImpl.noAddEnd(lllllllllllllIIIlIIIIIllllllIlll);
        if (this.elementType == BinaryTagTypes.END) {
            this.elementType = lllllllllllllIIIlIIIIIllllllIlll.type();
        }
        ListBinaryTagImpl.mustBeSameType(lllllllllllllIIIlIIIIIllllllIlll, this.elementType);
        if (this.tags == null) {
            this.tags = new ArrayList<BinaryTag>();
        }
        this.tags.add(lllllllllllllIIIlIIIIIllllllIlll);
        return this;
    }
}
