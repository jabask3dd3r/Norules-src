package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.util.*;

public interface CompoundBinaryTag extends BinaryTag, CompoundTagSetter<CompoundBinaryTag>, Iterable<Map.Entry<String, ? extends BinaryTag>>
{
    int[] getIntArray(@NotNull final String lllllllllllllIlIllIlIIlIlIllIllI);
    
    long[] getLongArray(@NotNull final String lllllllllllllIlIllIlIIlIlIllIIlI, final long[] lllllllllllllIlIllIlIIlIlIllIIIl);
    
    @NotNull
    default ListBinaryTag getList(@NotNull final String lllllllllllllIlIllIlIIlIllIlIlII) {
        return this.getList(lllllllllllllIlIllIlIIlIllIlIlII, ListBinaryTag.empty());
    }
    
    default boolean getBoolean(@NotNull final String lllllllllllllIlIllIlIIllIIlIlIII) {
        return this.getBoolean(lllllllllllllIlIllIlIIllIIlIlIII, false);
    }
    
    int getInt(@NotNull final String lllllllllllllIlIllIlIIlIllllllll, final int lllllllllllllIlIllIlIIlIlllllllI);
    
    @NotNull
    CompoundBinaryTag getCompound(@NotNull final String lllllllllllllIlIllIlIIlIlIllIlll, @NotNull final CompoundBinaryTag lllllllllllllIlIllIlIIlIlIlllIII);
    
    @NotNull
    String getString(@NotNull final String lllllllllllllIlIllIlIIlIllIlIlll, @NotNull final String lllllllllllllIlIllIlIIlIllIllIII);
    
    @NotNull
    Set<String> keySet();
    
    short getShort(@NotNull final String lllllllllllllIlIllIlIIllIIIIIlll, final short lllllllllllllIlIllIlIIllIIIIlIII);
    
    default long getLong(@NotNull final String lllllllllllllIlIllIlIIlIlllllIll) {
        return this.getLong(lllllllllllllIlIllIlIIlIlllllIll, 0L);
    }
    
    default byte getByte(@NotNull final String lllllllllllllIlIllIlIIllIIIlIllI) {
        return this.getByte(lllllllllllllIlIllIlIIllIIIlIllI, (byte)0);
    }
    
    byte[] getByteArray(@NotNull final String lllllllllllllIlIllIlIIlIlllIIIlI);
    
    @NotNull
    default CompoundBinaryTag getCompound(@NotNull final String lllllllllllllIlIllIlIIlIlIllllIl) {
        return this.getCompound(lllllllllllllIlIllIlIIlIlIllllIl, empty());
    }
    
    default double getDouble(@NotNull final String lllllllllllllIlIllIlIIlIlllIlIIl) {
        return this.getDouble(lllllllllllllIlIllIlIIlIlllIlIIl, 0.0);
    }
    
    @NotNull
    ListBinaryTag getList(@NotNull final String lllllllllllllIlIllIlIIlIllIIIIII, @NotNull final BinaryTagType<? extends BinaryTag> lllllllllllllIlIllIlIIlIllIIIIlI, @NotNull final ListBinaryTag lllllllllllllIlIllIlIIlIllIIIIIl);
    
    default int getInt(@NotNull final String lllllllllllllIlIllIlIIllIIIIIlII) {
        return this.getInt(lllllllllllllIlIllIlIIllIIIIIlII, 0);
    }
    
    @NotNull
    ListBinaryTag getList(@NotNull final String lllllllllllllIlIllIlIIlIllIIllll, @NotNull final ListBinaryTag lllllllllllllIlIllIlIIlIllIIlllI);
    
    long[] getLongArray(@NotNull final String lllllllllllllIlIllIlIIlIlIllIIll);
    
    byte[] getByteArray(@NotNull final String lllllllllllllIlIllIlIIlIlllIIIII, final byte[] lllllllllllllIlIllIlIIlIlllIIIIl);
    
    float getFloat(@NotNull final String lllllllllllllIlIllIlIIlIlllIllIl, final float lllllllllllllIlIllIlIIlIlllIllII);
    
    double getDouble(@NotNull final String lllllllllllllIlIllIlIIlIlllIIIll, final double lllllllllllllIlIllIlIIlIlllIIlII);
    
    default float getFloat(@NotNull final String lllllllllllllIlIllIlIIlIllllIIlI) {
        return this.getFloat(lllllllllllllIlIllIlIIlIllllIIlI, 0.0f);
    }
    
    int[] getIntArray(@NotNull final String lllllllllllllIlIllIlIIlIlIllIlII, final int[] lllllllllllllIlIllIlIIlIlIllIlIl);
    
    @NotNull
    default BinaryTagType<CompoundBinaryTag> type() {
        return BinaryTagTypes.COMPOUND;
    }
    
    default short getShort(@NotNull final String lllllllllllllIlIllIlIIllIIIIllIl) {
        return this.getShort(lllllllllllllIlIllIlIIllIIIIllIl, (short)0);
    }
    
    @Nullable
    BinaryTag get(final String lllllllllllllIlIllIlIIllIIlIllII);
    
    @NotNull
    default Builder builder() {
        return new CompoundTagBuilder();
    }
    
    @NotNull
    default ListBinaryTag getList(@NotNull final String lllllllllllllIlIllIlIIlIllIIlIlI, @NotNull final BinaryTagType<? extends BinaryTag> lllllllllllllIlIllIlIIlIllIIlIIl) {
        return this.getList(lllllllllllllIlIllIlIIlIllIIlIlI, lllllllllllllIlIllIlIIlIllIIlIIl, ListBinaryTag.empty());
    }
    
    byte getByte(@NotNull final String lllllllllllllIlIllIlIIllIIIlIIIl, final byte lllllllllllllIlIllIlIIllIIIlIIII);
    
    @NotNull
    default CompoundBinaryTag empty() {
        return CompoundBinaryTagImpl.EMPTY;
    }
    
    long getLong(@NotNull final String lllllllllllllIlIllIlIIlIllllIlIl, final long lllllllllllllIlIllIlIIlIllllIllI);
    
    @NotNull
    default CompoundBinaryTag from(@NotNull final Map<String, ? extends BinaryTag> lllllllllllllIlIllIlIIllIIllIllI) {
        if (lllllllllllllIlIllIlIIllIIllIllI.isEmpty()) {
            return empty();
        }
        return new CompoundBinaryTagImpl(new HashMap<String, BinaryTag>(lllllllllllllIlIllIlIIllIIllIllI));
    }
    
    default boolean getBoolean(@NotNull final String lllllllllllllIlIllIlIIllIIlIIIII, final boolean lllllllllllllIlIllIlIIllIIIlllll) {
        return this.getByte(lllllllllllllIlIllIlIIllIIlIIIII) != 0 || lllllllllllllIlIllIlIIllIIIlllll;
    }
    
    @NotNull
    default String getString(@NotNull final String lllllllllllllIlIllIlIIlIllIlllIl) {
        return this.getString(lllllllllllllIlIllIlIIlIllIlllIl, "");
    }
    
    public interface Builder extends CompoundTagSetter<Builder>
    {
        @NotNull
        CompoundBinaryTag build();
    }
}
