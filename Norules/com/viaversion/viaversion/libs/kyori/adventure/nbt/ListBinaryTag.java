package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import java.util.*;

public interface ListBinaryTag extends ListTagSetter<ListBinaryTag, BinaryTag>, BinaryTag, Iterable<BinaryTag>
{
    @NotNull
    BinaryTagType<? extends BinaryTag> elementType();
    
    default byte getByte(final int llllllllllllllIIIIlIllIllIIIllIl, final byte llllllllllllllIIIIlIllIllIIIlllI) {
        final BinaryTag llllllllllllllIIIIlIllIllIIIlIIl = this.get(llllllllllllllIIIIlIllIllIIIllIl);
        if (llllllllllllllIIIIlIllIllIIIlIIl.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIllIIIlIIl).byteValue();
        }
        return llllllllllllllIIIIlIllIllIIIlllI;
    }
    
    @NotNull
    BinaryTag get(final int llllllllllllllIIIIlIllIllIIlllll);
    
    default float getFloat(final int llllllllllllllIIIIlIllIlIlIIIIll) {
        return this.getFloat(llllllllllllllIIIIlIllIlIlIIIIll, 0.0f);
    }
    
    @NotNull
    default CompoundBinaryTag getCompound(final int llllllllllllllIIIIlIllIIlIllIIII, @NotNull final CompoundBinaryTag llllllllllllllIIIIlIllIIlIllIIIl) {
        final BinaryTag llllllllllllllIIIIlIllIIlIlIllII = this.get(llllllllllllllIIIIlIllIIlIllIIII);
        if (llllllllllllllIIIIlIllIIlIlIllII.type() == BinaryTagTypes.COMPOUND) {
            return (CompoundBinaryTag)llllllllllllllIIIIlIllIIlIlIllII;
        }
        return llllllllllllllIIIIlIllIIlIllIIIl;
    }
    
    @NotNull
    ListBinaryTag set(final int llllllllllllllIIIIlIllIllIIlllIl, @NotNull final BinaryTag llllllllllllllIIIIlIllIllIIlllII, @Nullable final Consumer<? super BinaryTag> llllllllllllllIIIIlIllIllIIllllI);
    
    @NotNull
    ListBinaryTag remove(final int llllllllllllllIIIIlIllIllIIllIll, @Nullable final Consumer<? super BinaryTag> llllllllllllllIIIIlIllIllIIllIlI);
    
    @NotNull
    default String getString(final int llllllllllllllIIIIlIllIlIIIIIIIl) {
        return this.getString(llllllllllllllIIIIlIllIlIIIIIIIl, "");
    }
    
    @NotNull
    default <T extends BinaryTag> Builder<T> builder(@NotNull final BinaryTagType<T> llllllllllllllIIIIlIllIllIlIlllI) {
        if (llllllllllllllIIIIlIllIllIlIlllI == BinaryTagTypes.END) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot create a list of ").append(BinaryTagTypes.END)));
        }
        return new ListTagBuilder<T>(llllllllllllllIIIIlIllIllIlIlllI);
    }
    
    default long[] getLongArray(final int llllllllllllllIIIIlIllIIlIIIIIII, final long[] llllllllllllllIIIIlIllIIlIIIIIIl) {
        final BinaryTag llllllllllllllIIIIlIllIIIlllllII = this.get(llllllllllllllIIIIlIllIIlIIIIIII);
        if (llllllllllllllIIIIlIllIIIlllllII.type() == BinaryTagTypes.LONG_ARRAY) {
            return ((LongArrayBinaryTag)llllllllllllllIIIIlIllIIIlllllII).value();
        }
        return llllllllllllllIIIIlIllIIlIIIIIIl;
    }
    
    @NotNull
    default ListBinaryTag getList(final int llllllllllllllIIIIlIllIIllIIlIll, @Nullable final BinaryTagType<?> llllllllllllllIIIIlIllIIllIIlIlI, @NotNull final ListBinaryTag llllllllllllllIIIIlIllIIllIIlIIl) {
        final BinaryTag llllllllllllllIIIIlIllIIllIIIIll = this.get(llllllllllllllIIIIlIllIIllIIlIll);
        if (llllllllllllllIIIIlIllIIllIIIIll.type() == BinaryTagTypes.LIST) {
            final ListBinaryTag llllllllllllllIIIIlIllIIllIIlIII = (ListBinaryTag)llllllllllllllIIIIlIllIIllIIIIll;
            if (llllllllllllllIIIIlIllIIllIIlIlI == null || llllllllllllllIIIIlIllIIllIIlIII.elementType() == llllllllllllllIIIIlIllIIllIIlIlI) {
                return llllllllllllllIIIIlIllIIllIIlIII;
            }
        }
        return llllllllllllllIIIIlIllIIllIIlIIl;
    }
    
    @NotNull
    default ListBinaryTag getList(final int llllllllllllllIIIIlIllIIllIllIIl, @NotNull final ListBinaryTag llllllllllllllIIIIlIllIIllIllIII) {
        return this.getList(llllllllllllllIIIIlIllIIllIllIIl, null, llllllllllllllIIIIlIllIIllIllIII);
    }
    
    @NotNull
    default CompoundBinaryTag getCompound(final int llllllllllllllIIIIlIllIIlIlllIlI) {
        return this.getCompound(llllllllllllllIIIIlIllIIlIlllIlI, CompoundBinaryTag.empty());
    }
    
    @NotNull
    default Builder<BinaryTag> builder() {
        return new ListTagBuilder<BinaryTag>();
    }
    
    default int[] getIntArray(final int llllllllllllllIIIIlIllIIlIlIIlII) {
        final BinaryTag llllllllllllllIIIIlIllIIlIlIIIIl = this.get(llllllllllllllIIIIlIllIIlIlIIlII);
        if (llllllllllllllIIIIlIllIIlIlIIIIl.type() == BinaryTagTypes.INT_ARRAY) {
            return ((IntArrayBinaryTag)llllllllllllllIIIIlIllIIlIlIIIIl).value();
        }
        return new int[0];
    }
    
    default long getLong(final int llllllllllllllIIIIlIllIlIlIIllll, final long llllllllllllllIIIIlIllIlIlIIlllI) {
        final BinaryTag llllllllllllllIIIIlIllIlIlIIlIlI = this.get(llllllllllllllIIIIlIllIlIlIIllll);
        if (llllllllllllllIIIIlIllIlIlIIlIlI.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIlIlIIlIlI).longValue();
        }
        return llllllllllllllIIIIlIllIlIlIIlllI;
    }
    
    default short getShort(final int llllllllllllllIIIIlIllIlIllllIII, final short llllllllllllllIIIIlIllIlIllllIIl) {
        final BinaryTag llllllllllllllIIIIlIllIlIlllIlII = this.get(llllllllllllllIIIIlIllIlIllllIII);
        if (llllllllllllllIIIIlIllIlIlllIlII.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIlIlllIlII).shortValue();
        }
        return llllllllllllllIIIIlIllIlIllllIIl;
    }
    
    default long getLong(final int llllllllllllllIIIIlIllIlIlIllIII) {
        return this.getLong(llllllllllllllIIIIlIllIlIlIllIII, 0L);
    }
    
    default byte getByte(final int llllllllllllllIIIIlIllIllIIlIlll) {
        return this.getByte(llllllllllllllIIIIlIllIllIIlIlll, (byte)0);
    }
    
    @NotNull
    default ListBinaryTag from(@NotNull final Iterable<? extends BinaryTag> llllllllllllllIIIIlIllIllIllIIlI) {
        return builder().add(llllllllllllllIIIIlIllIllIllIIlI).build();
    }
    
    default float getFloat(final int llllllllllllllIIIIlIllIlIIlllIIl, final float llllllllllllllIIIIlIllIlIIlllIlI) {
        final BinaryTag llllllllllllllIIIIlIllIlIIllIlIl = this.get(llllllllllllllIIIIlIllIlIIlllIIl);
        if (llllllllllllllIIIIlIllIlIIllIlIl.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIlIIllIlIl).floatValue();
        }
        return llllllllllllllIIIIlIllIlIIlllIlI;
    }
    
    @NotNull
    default String getString(final int llllllllllllllIIIIlIllIIlllllIII, @NotNull final String llllllllllllllIIIIlIllIIllllIlll) {
        final BinaryTag llllllllllllllIIIIlIllIIllllIIll = this.get(llllllllllllllIIIIlIllIIlllllIII);
        if (llllllllllllllIIIIlIllIIllllIIll.type() == BinaryTagTypes.STRING) {
            return ((StringBinaryTag)llllllllllllllIIIIlIllIIllllIIll).value();
        }
        return llllllllllllllIIIIlIllIIllllIlll;
    }
    
    @NotNull
    default ListBinaryTag empty() {
        return ListBinaryTagImpl.EMPTY;
    }
    
    @NotNull
    Stream<BinaryTag> stream();
    
    default int getInt(final int llllllllllllllIIIIlIllIlIllIIlII, final int llllllllllllllIIIIlIllIlIllIIIll) {
        final BinaryTag llllllllllllllIIIIlIllIlIlIlllll = this.get(llllllllllllllIIIIlIllIlIllIIlII);
        if (llllllllllllllIIIIlIllIlIlIlllll.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIlIlIlllll).intValue();
        }
        return llllllllllllllIIIIlIllIlIllIIIll;
    }
    
    @NotNull
    default ListBinaryTag getList(final int llllllllllllllIIIIlIllIIlllIllII) {
        return this.getList(llllllllllllllIIIIlIllIIlllIllII, null, empty());
    }
    
    @NotNull
    default ListBinaryTag of(@NotNull final BinaryTagType<? extends BinaryTag> llllllllllllllIIIIlIllIllIlIlIII, @NotNull final List<BinaryTag> llllllllllllllIIIIlIllIllIlIlIIl) {
        if (llllllllllllllIIIIlIllIllIlIlIIl.isEmpty()) {
            return empty();
        }
        if (llllllllllllllIIIIlIllIllIlIlIII == BinaryTagTypes.END) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot create a list of ").append(BinaryTagTypes.END)));
        }
        return new ListBinaryTagImpl(llllllllllllllIIIIlIllIllIlIlIII, llllllllllllllIIIIlIllIllIlIlIIl);
    }
    
    int size();
    
    default int[] getIntArray(final int llllllllllllllIIIIlIllIIlIIllIIl, final int[] llllllllllllllIIIIlIllIIlIIllIII) {
        final BinaryTag llllllllllllllIIIIlIllIIlIIlIlII = this.get(llllllllllllllIIIIlIllIIlIIllIIl);
        if (llllllllllllllIIIIlIllIIlIIlIlII.type() == BinaryTagTypes.INT_ARRAY) {
            return ((IntArrayBinaryTag)llllllllllllllIIIIlIllIIlIIlIlII).value();
        }
        return llllllllllllllIIIIlIllIIlIIllIII;
    }
    
    default double getDouble(final int llllllllllllllIIIIlIllIlIIlIlllI) {
        return this.getDouble(llllllllllllllIIIIlIllIlIIlIlllI, 0.0);
    }
    
    @Deprecated
    @NotNull
    default BinaryTagType<? extends BinaryTag> listType() {
        return this.elementType();
    }
    
    default long[] getLongArray(final int llllllllllllllIIIIlIllIIlIIIllII) {
        final BinaryTag llllllllllllllIIIIlIllIIlIIIlIIl = this.get(llllllllllllllIIIIlIllIIlIIIllII);
        if (llllllllllllllIIIIlIllIIlIIIlIIl.type() == BinaryTagTypes.LONG_ARRAY) {
            return ((LongArrayBinaryTag)llllllllllllllIIIIlIllIIlIIIlIIl).value();
        }
        return new long[0];
    }
    
    default short getShort(final int llllllllllllllIIIIlIllIllIIIIIlI) {
        return this.getShort(llllllllllllllIIIIlIllIllIIIIIlI, (short)0);
    }
    
    default byte[] getByteArray(final int llllllllllllllIIIIlIllIlIIIIllII, final byte[] llllllllllllllIIIIlIllIlIIIIllIl) {
        final BinaryTag llllllllllllllIIIIlIllIlIIIIlIII = this.get(llllllllllllllIIIIlIllIlIIIIllII);
        if (llllllllllllllIIIIlIllIlIIIIlIII.type() == BinaryTagTypes.BYTE_ARRAY) {
            return ((ByteArrayBinaryTag)llllllllllllllIIIIlIllIlIIIIlIII).value();
        }
        return llllllllllllllIIIIlIllIlIIIIllIl;
    }
    
    @NotNull
    default BinaryTagType<ListBinaryTag> type() {
        return BinaryTagTypes.LIST;
    }
    
    default double getDouble(final int llllllllllllllIIIIlIllIlIIlIIlIl, final double llllllllllllllIIIIlIllIlIIlIIlII) {
        final BinaryTag llllllllllllllIIIIlIllIlIIlIIIII = this.get(llllllllllllllIIIIlIllIlIIlIIlIl);
        if (llllllllllllllIIIIlIllIlIIlIIIII.type().numeric()) {
            return ((NumberBinaryTag)llllllllllllllIIIIlIllIlIIlIIIII).doubleValue();
        }
        return llllllllllllllIIIIlIllIlIIlIIlII;
    }
    
    default int getInt(final int llllllllllllllIIIIlIllIlIllIllIl) {
        return this.getInt(llllllllllllllIIIIlIllIlIllIllIl, 0);
    }
    
    @NotNull
    default ListBinaryTag getList(final int llllllllllllllIIIIlIllIIlllIIlII, @Nullable final BinaryTagType<?> llllllllllllllIIIIlIllIIlllIIIll) {
        return this.getList(llllllllllllllIIIIlIllIIlllIIlII, llllllllllllllIIIIlIllIIlllIIIll, empty());
    }
    
    default byte[] getByteArray(final int llllllllllllllIIIIlIllIlIIIllIII) {
        final BinaryTag llllllllllllllIIIIlIllIlIIIlIlIl = this.get(llllllllllllllIIIIlIllIlIIIllIII);
        if (llllllllllllllIIIIlIllIlIIIlIlIl.type() == BinaryTagTypes.BYTE_ARRAY) {
            return ((ByteArrayBinaryTag)llllllllllllllIIIIlIllIlIIIlIlIl).value();
        }
        return new byte[0];
    }
    
    public interface Builder<T extends BinaryTag> extends ListTagSetter<Builder<T>, T>
    {
        @NotNull
        ListBinaryTag build();
    }
}
