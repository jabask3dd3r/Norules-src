package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import java.util.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

@Debug.Renderer(text = "\"CompoundBinaryTag[length=\" + this.tags.size() + \"]\"", childrenArray = "this.tags.entrySet().toArray()", hasChildren = "!this.tags.isEmpty()")
final class CompoundBinaryTagImpl extends AbstractBinaryTag implements CompoundBinaryTag
{
    private final /* synthetic */ Map<String, BinaryTag> tags;
    private final /* synthetic */ int hashCode;
    
    @NotNull
    @Override
    public CompoundBinaryTag getCompound(@NotNull final String lllllllllllllIlllIllIIIIIIIlIllI, @NotNull final CompoundBinaryTag lllllllllllllIlllIllIIIIIIIllIII) {
        if (this.contains(lllllllllllllIlllIllIIIIIIIlIllI, BinaryTagTypes.COMPOUND)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIIIlIllI);
        }
        return lllllllllllllIlllIllIIIIIIIllIII;
    }
    
    @NotNull
    @Override
    public Iterator<Map.Entry<String, ? extends BinaryTag>> iterator() {
        return (Iterator<Map.Entry<String, ? extends BinaryTag>>)this.tags.entrySet().iterator();
    }
    
    @NotNull
    @Override
    public ListBinaryTag getList(@NotNull final String lllllllllllllIlllIllIIIIIIllIlII, @NotNull final ListBinaryTag lllllllllllllIlllIllIIIIIIllIlIl) {
        if (this.contains(lllllllllllllIlllIllIIIIIIllIlII, BinaryTagTypes.LIST)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIIllIlII);
        }
        return lllllllllllllIlllIllIIIIIIllIlIl;
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag put(@NotNull final Map<String, ? extends BinaryTag> lllllllllllllIlllIllIIIIlIlIIlll) {
        return this.edit(lllllllllllllIlllIlIllllIIllIIll -> lllllllllllllIlllIlIllllIIllIIll.putAll(lllllllllllllIlllIllIIIIlIlIIlll));
    }
    
    @NotNull
    @Override
    public Set<String> keySet() {
        return Collections.unmodifiableSet((Set<? extends String>)this.tags.keySet());
    }
    
    @Override
    public void forEach(@NotNull final Consumer<? super Map.Entry<String, ? extends BinaryTag>> lllllllllllllIlllIlIlllllIIIllII) {
        this.tags.entrySet().forEach(Objects.requireNonNull(lllllllllllllIlllIlIlllllIIIllII, "action"));
    }
    
    @Override
    public long getLong(@NotNull final String lllllllllllllIlllIllIIIIIlllIIll, final long lllllllllllllIlllIllIIIIIlllIIlI) {
        if (this.contains(lllllllllllllIlllIllIIIIIlllIIll, BinaryTagTypes.LONG)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIlllIIll).longValue();
        }
        return lllllllllllllIlllIllIIIIIlllIIlI;
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag put(@NotNull final CompoundBinaryTag lllllllllllllIlllIllIIIIlIlIlllI) {
        final long lllllllllllllIlllIlIllllIIIllIlI;
        String lllllllllllllIlllIlIllllIIlIIIlI;
        return this.edit(lllllllllllllIlllIlIllllIIIlllll -> {
            lllllllllllllIlllIlIllllIIIllIlI = (long)lllllllllllllIlllIllIIIIlIlIlllI.keySet().iterator();
            while (((Iterator)lllllllllllllIlllIlIllllIIIllIlI).hasNext()) {
                lllllllllllllIlllIlIllllIIlIIIlI = ((Iterator<String>)lllllllllllllIlllIlIllllIIIllIlI).next();
                lllllllllllllIlllIlIllllIIIlllll.put(lllllllllllllIlllIlIllllIIlIIIlI, lllllllllllllIlllIllIIIIlIlIlllI.get(lllllllllllllIlllIlIllllIIlIIIlI));
            }
        });
    }
    
    public boolean contains(@NotNull final String lllllllllllllIlllIllIIIIllIIllll, @NotNull final BinaryTagType<?> lllllllllllllIlllIllIIIIllIIlllI) {
        final BinaryTag lllllllllllllIlllIllIIIIllIIlIlI = this.tags.get(lllllllllllllIlllIllIIIIllIIllll);
        return lllllllllllllIlllIllIIIIllIIlIlI != null && lllllllllllllIlllIllIIIIllIIlllI.test(lllllllllllllIlllIllIIIIllIIlIlI.type());
    }
    
    @Override
    public double getDouble(@NotNull final String lllllllllllllIlllIllIIIIIlIlllII, final double lllllllllllllIlllIllIIIIIlIlllIl) {
        if (this.contains(lllllllllllllIlllIllIIIIIlIlllII, BinaryTagTypes.DOUBLE)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIlIlllII).doubleValue();
        }
        return lllllllllllllIlllIllIIIIIlIlllIl;
    }
    
    private CompoundBinaryTag edit(final Consumer<Map<String, BinaryTag>> lllllllllllllIlllIlIlllllIlllllI) {
        final Map<String, BinaryTag> lllllllllllllIlllIlIlllllIlllIII = new HashMap<String, BinaryTag>(this.tags);
        lllllllllllllIlllIlIlllllIlllllI.accept(lllllllllllllIlllIlIlllllIlllIII);
        return new CompoundBinaryTagImpl(lllllllllllllIlllIlIlllllIlllIII);
    }
    
    @Override
    public byte[] getByteArray(@NotNull final String lllllllllllllIlllIllIIIIIlIIlIll, final byte[] lllllllllllllIlllIllIIIIIlIIlIlI) {
        if (this.contains(lllllllllllllIlllIllIIIIIlIIlIll, BinaryTagTypes.BYTE_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIlIIlIll).value();
        }
        return lllllllllllllIlllIllIIIIIlIIlIlI;
    }
    
    @Override
    public short getShort(@NotNull final String lllllllllllllIlllIllIIIIlIIIlIII, final short lllllllllllllIlllIllIIIIlIIIlIIl) {
        if (this.contains(lllllllllllllIlllIllIIIIlIIIlIII, BinaryTagTypes.SHORT)) {
            return this.tags.get(lllllllllllllIlllIllIIIIlIIIlIII).shortValue();
        }
        return lllllllllllllIlllIllIIIIlIIIlIIl;
    }
    
    static {
        EMPTY = new CompoundBinaryTagImpl(Collections.emptyMap());
    }
    
    @Override
    public long[] getLongArray(@NotNull final String lllllllllllllIlllIlIlllllllIIIIl) {
        if (this.contains(lllllllllllllIlllIlIlllllllIIIIl, BinaryTagTypes.LONG_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIlIlllllllIIIIl).value();
        }
        return new long[0];
    }
    
    @Override
    public long[] getLongArray(@NotNull final String lllllllllllllIlllIlIllllllIlIlll, final long[] lllllllllllllIlllIlIllllllIlIlIl) {
        if (this.contains(lllllllllllllIlllIlIllllllIlIlll, BinaryTagTypes.LONG_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIlIllllllIlIlll).value();
        }
        return lllllllllllllIlllIlIllllllIlIlIl;
    }
    
    @Override
    public byte getByte(@NotNull final String lllllllllllllIlllIllIIIIlIIlIIll, final byte lllllllllllllIlllIllIIIIlIIlIlII) {
        if (this.contains(lllllllllllllIlllIllIIIIlIIlIIll, BinaryTagTypes.BYTE)) {
            return this.tags.get(lllllllllllllIlllIllIIIIlIIlIIll).byteValue();
        }
        return lllllllllllllIlllIllIIIIlIIlIlII;
    }
    
    @Override
    public byte[] getByteArray(@NotNull final String lllllllllllllIlllIllIIIIIlIlIIll) {
        if (this.contains(lllllllllllllIlllIllIIIIIlIlIIll, BinaryTagTypes.BYTE_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIlIlIIll).value();
        }
        return new byte[0];
    }
    
    CompoundBinaryTagImpl(final Map<String, BinaryTag> lllllllllllllIlllIllIIIIllIllIII) {
        this.tags = Collections.unmodifiableMap((Map<? extends String, ? extends BinaryTag>)lllllllllllllIlllIllIIIIllIllIII);
        this.hashCode = lllllllllllllIlllIllIIIIllIllIII.hashCode();
    }
    
    @Override
    public int getInt(@NotNull final String lllllllllllllIlllIllIIIIIllllllI, final int lllllllllllllIlllIllIIIIIlllllIl) {
        if (this.contains(lllllllllllllIlllIllIIIIIllllllI, BinaryTagTypes.INT)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIllllllI).intValue();
        }
        return lllllllllllllIlllIllIIIIIlllllIl;
    }
    
    @Override
    public int[] getIntArray(@NotNull final String lllllllllllllIlllIllIIIIIIIIIlII) {
        if (this.contains(lllllllllllllIlllIllIIIIIIIIIlII, BinaryTagTypes.INT_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIIIIIlII).value();
        }
        return new int[0];
    }
    
    @Override
    public int[] getIntArray(@NotNull final String lllllllllllllIlllIlIllllllllIIII, final int[] lllllllllllllIlllIlIllllllllIIIl) {
        if (this.contains(lllllllllllllIlllIlIllllllllIIII, BinaryTagTypes.INT_ARRAY)) {
            return this.tags.get(lllllllllllllIlllIlIllllllllIIII).value();
        }
        return lllllllllllllIlllIlIllllllllIIIl;
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag put(@NotNull final String lllllllllllllIlllIllIIIIlIllIlll, @NotNull final BinaryTag lllllllllllllIlllIllIIIIlIlllIII) {
        return this.edit(lllllllllllllIlllIlIllllIIIIIlll -> lllllllllllllIlllIlIllllIIIIIlll.put(lllllllllllllIlllIllIIIIlIllIlll, lllllllllllllIlllIllIIIIlIlllIII));
    }
    
    @NotNull
    @Override
    public ListBinaryTag getList(@NotNull final String lllllllllllllIlllIllIIIIIIlIIllI, @NotNull final BinaryTagType<? extends BinaryTag> lllllllllllllIlllIllIIIIIIlIlIII, @NotNull final ListBinaryTag lllllllllllllIlllIllIIIIIIlIIlll) {
        if (this.contains(lllllllllllllIlllIllIIIIIIlIIllI, BinaryTagTypes.LIST)) {
            final ListBinaryTag lllllllllllllIlllIllIIIIIIlIIlIl = this.tags.get(lllllllllllllIlllIllIIIIIIlIIllI);
            if (lllllllllllllIlllIllIIIIIIlIlIII.test(lllllllllllllIlllIllIIIIIIlIIlIl.elementType())) {
                return lllllllllllllIlllIllIIIIIIlIIlIl;
            }
        }
        return lllllllllllllIlllIllIIIIIIlIIlll;
    }
    
    @Nullable
    @Override
    public BinaryTag get(final String lllllllllllllIlllIllIIIIllIIIIII) {
        return this.tags.get(lllllllllllllIlllIllIIIIllIIIIII);
    }
    
    @NotNull
    @Override
    public String getString(@NotNull final String lllllllllllllIlllIllIIIIIlIIIIII, @NotNull final String lllllllllllllIlllIllIIIIIIllllll) {
        if (this.contains(lllllllllllllIlllIllIIIIIlIIIIII, BinaryTagTypes.STRING)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIlIIIIII).value();
        }
        return lllllllllllllIlllIllIIIIIIllllll;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("tags", this.tags));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIlIlllllIlIllll) {
        return this == lllllllllllllIlllIlIlllllIlIllll || (lllllllllllllIlllIlIlllllIlIllll instanceof CompoundBinaryTagImpl && this.tags.equals(((CompoundBinaryTagImpl)lllllllllllllIlllIlIlllllIlIllll).tags));
    }
    
    @NotNull
    @Override
    public CompoundBinaryTag remove(@NotNull final String lllllllllllllIlllIllIIIIlIIlllll, @Nullable final Consumer<? super BinaryTag> lllllllllllllIlllIllIIIIlIIllllI) {
        if (!this.tags.containsKey(lllllllllllllIlllIllIIIIlIIlllll)) {
            return this;
        }
        final BinaryTag lllllllllllllIlllIlIllllIlIIIlII;
        return this.edit(lllllllllllllIlllIlIllllIIllllll -> {
            lllllllllllllIlllIlIllllIlIIIlII = lllllllllllllIlllIlIllllIIllllll.remove(lllllllllllllIlllIllIIIIlIIlllll);
            if (lllllllllllllIlllIllIIIIlIIllllI != null) {
                lllllllllllllIlllIllIIIIlIIllllI.accept(lllllllllllllIlllIlIllllIlIIIlII);
            }
        });
    }
    
    @Override
    public float getFloat(@NotNull final String lllllllllllllIlllIllIIIIIllIlIII, final float lllllllllllllIlllIllIIIIIllIIlll) {
        if (this.contains(lllllllllllllIlllIllIIIIIllIlIII, BinaryTagTypes.FLOAT)) {
            return this.tags.get(lllllllllllllIlllIllIIIIIllIlIII).floatValue();
        }
        return lllllllllllllIlllIllIIIIIllIIlll;
    }
}
