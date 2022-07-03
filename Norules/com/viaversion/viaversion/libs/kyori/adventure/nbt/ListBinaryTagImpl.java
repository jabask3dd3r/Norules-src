package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;

@Debug.Renderer(text = "\"ListBinaryTag[type=\" + this.type.toString() + \"]\"", childrenArray = "this.tags.toArray()", hasChildren = "!this.tags.isEmpty()")
final class ListBinaryTagImpl extends AbstractBinaryTag implements ListBinaryTag
{
    private final /* synthetic */ BinaryTagType<? extends BinaryTag> elementType;
    private final /* synthetic */ int hashCode;
    private final /* synthetic */ List<BinaryTag> tags;
    
    static void mustBeSameType(final BinaryTag lllllllllllllIIIIIlIlIlIIIllIllI, final BinaryTagType<? extends BinaryTag> lllllllllllllIIIIIlIlIlIIIllIlll) {
        if (lllllllllllllIIIIIlIlIlIIIllIllI.type() != lllllllllllllIIIIIlIlIlIIIllIlll) {
            throw new IllegalArgumentException(String.format("Trying to add tag of type %s to list of %s", lllllllllllllIIIIIlIlIlIIIllIllI.type(), lllllllllllllIIIIIlIlIlIIIllIlll));
        }
    }
    
    @Override
    public int size() {
        return this.tags.size();
    }
    
    @NotNull
    @Override
    public BinaryTagType<? extends BinaryTag> elementType() {
        return this.elementType;
    }
    
    static {
        EMPTY = new ListBinaryTagImpl(BinaryTagTypes.END, Collections.emptyList());
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIlIlIlIIIIIlIll) {
        return this == lllllllllllllIIIIIlIlIlIIIIIlIll || (lllllllllllllIIIIIlIlIlIIIIIlIll instanceof ListBinaryTagImpl && this.tags.equals(((ListBinaryTagImpl)lllllllllllllIIIIIlIlIlIIIIIlIll).tags));
    }
    
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("tags", this.tags), ExaminableProperty.of("type", this.elementType) });
    }
    
    @NotNull
    @Override
    public ListBinaryTag add(final Iterable<? extends BinaryTag> lllllllllllllIIIIIlIlIlIIlIlIIII) {
        if (lllllllllllllIIIIIlIlIlIIlIlIIII instanceof Collection && ((Collection)lllllllllllllIIIIIlIlIlIIlIlIIII).isEmpty()) {
            return this;
        }
        final BinaryTagType<?> lllllllllllllIIIIIlIlIlIIlIIllIl = mustBeSameType(lllllllllllllIIIIIlIlIlIIlIlIIII);
        final double lllllllllllllIIIIIlIlIIllllIlIll;
        BinaryTag lllllllllllllIIIIIlIlIIlllllIIII;
        return this.edit(lllllllllllllIIIIIlIlIIllllIlllI -> {
            lllllllllllllIIIIIlIlIIllllIlIll = (double)lllllllllllllIIIIIlIlIlIIlIlIIII.iterator();
            while (((Iterator)lllllllllllllIIIIIlIlIIllllIlIll).hasNext()) {
                lllllllllllllIIIIIlIlIIlllllIIII = ((Iterator<BinaryTag>)lllllllllllllIIIIIlIlIIllllIlIll).next();
                lllllllllllllIIIIIlIlIIllllIlllI.add(lllllllllllllIIIIIlIlIIlllllIIII);
            }
        }, (BinaryTagType<? extends BinaryTag>)lllllllllllllIIIIIlIlIlIIlIIllIl);
    }
    
    @NotNull
    @Override
    public BinaryTag get(final int lllllllllllllIIIIIlIlIlIIllllIIl) {
        return this.tags.get(lllllllllllllIIIIIlIlIlIIllllIIl);
    }
    
    @NotNull
    @Override
    public ListBinaryTag set(final int lllllllllllllIIIIIlIlIlIIllIlllI, @NotNull final BinaryTag lllllllllllllIIIIIlIlIlIIlllIIII, @Nullable final Consumer<? super BinaryTag> lllllllllllllIIIIIlIlIlIIllIllll) {
        final BinaryTag lllllllllllllIIIIIlIlIIlllIIlllI;
        return this.edit(lllllllllllllIIIIIlIlIIlllIIllll -> {
            lllllllllllllIIIIIlIlIIlllIIlllI = lllllllllllllIIIIIlIlIIlllIIllll.set(lllllllllllllIIIIIlIlIlIIllIlllI, lllllllllllllIIIIIlIlIlIIlllIIII);
            if (lllllllllllllIIIIIlIlIlIIllIllll != null) {
                lllllllllllllIIIIIlIlIlIIllIllll.accept(lllllllllllllIIIIIlIlIIlllIIlllI);
            }
        }, lllllllllllllIIIIIlIlIlIIlllIIII.type());
    }
    
    static void noAddEnd(final BinaryTag lllllllllllllIIIIIlIlIlIIlIIlIII) {
        if (lllllllllllllIIIIIlIlIlIIlIIlIII.type() == BinaryTagTypes.END) {
            throw new IllegalArgumentException(String.format("Cannot add a %s to a %s", BinaryTagTypes.END, BinaryTagTypes.LIST));
        }
    }
    
    private ListBinaryTag edit(final Consumer<List<BinaryTag>> lllllllllllllIIIIIlIlIlIIIlIlIll, @Nullable final BinaryTagType<? extends BinaryTag> lllllllllllllIIIIIlIlIlIIIlIllII) {
        final List<BinaryTag> lllllllllllllIIIIIlIlIlIIIlIIlll = new ArrayList<BinaryTag>(this.tags);
        lllllllllllllIIIIIlIlIlIIIlIlIll.accept(lllllllllllllIIIIIlIlIlIIIlIIlll);
        BinaryTagType<? extends BinaryTag> lllllllllllllIIIIIlIlIlIIIlIIllI = this.elementType;
        if (lllllllllllllIIIIIlIlIlIIIlIllII != null && lllllllllllllIIIIIlIlIlIIIlIIllI == BinaryTagTypes.END) {
            lllllllllllllIIIIIlIlIlIIIlIIllI = lllllllllllllIIIIIlIlIlIIIlIllII;
        }
        return new ListBinaryTagImpl(lllllllllllllIIIIIlIlIlIIIlIIllI, lllllllllllllIIIIIlIlIlIIIlIIlll);
    }
    
    @NotNull
    @Override
    public ListBinaryTag remove(final int lllllllllllllIIIIIlIlIlIIllIIIIl, @Nullable final Consumer<? super BinaryTag> lllllllllllllIIIIIlIlIlIIllIIIlI) {
        final BinaryTag lllllllllllllIIIIIlIlIIlllIlllII;
        return this.edit(lllllllllllllIIIIIlIlIIlllIlllIl -> {
            lllllllllllllIIIIIlIlIIlllIlllII = lllllllllllllIIIIIlIlIIlllIlllIl.remove(lllllllllllllIIIIIlIlIlIIllIIIIl);
            if (lllllllllllllIIIIIlIlIlIIllIIIlI != null) {
                lllllllllllllIIIIIlIlIlIIllIIIlI.accept(lllllllllllllIIIIIlIlIIlllIlllII);
            }
        }, null);
    }
    
    @Override
    public Iterator<BinaryTag> iterator() {
        final Iterator<BinaryTag> lllllllllllllIIIIIlIlIlIIIIllIlI = this.tags.iterator();
        return new Iterator<BinaryTag>() {
            @Override
            public BinaryTag next() {
                return lllllllllllllIIIIIlIlIlIIIIllIlI.next();
            }
            
            @Override
            public boolean hasNext() {
                return lllllllllllllIIIIIlIlIlIIIIllIlI.hasNext();
            }
            
            @Override
            public void forEachRemaining(final Consumer<? super BinaryTag> lllllllllllllIllIllIlllIIlIIllIl) {
                lllllllllllllIIIIIlIlIlIIIIllIlI.forEachRemaining(lllllllllllllIllIllIlllIIlIIllIl);
            }
        };
    }
    
    static BinaryTagType<?> mustBeSameType(final Iterable<? extends BinaryTag> lllllllllllllIIIIIlIlIlIIlIIIIIl) {
        BinaryTagType<?> lllllllllllllIIIIIlIlIlIIIlllllI = null;
        for (final BinaryTag lllllllllllllIIIIIlIlIlIIlIIIIII : lllllllllllllIIIIIlIlIlIIlIIIIIl) {
            if (lllllllllllllIIIIIlIlIlIIIlllllI == null) {
                lllllllllllllIIIIIlIlIlIIIlllllI = lllllllllllllIIIIIlIlIlIIlIIIIII.type();
            }
            else {
                mustBeSameType(lllllllllllllIIIIIlIlIlIIlIIIIII, (BinaryTagType<? extends BinaryTag>)lllllllllllllIIIIIlIlIlIIIlllllI);
            }
        }
        return lllllllllllllIIIIIlIlIlIIIlllllI;
    }
    
    @Override
    public void forEach(final Consumer<? super BinaryTag> lllllllllllllIIIIIlIlIlIIIIlIlIl) {
        this.tags.forEach(lllllllllllllIIIIIlIlIlIIIIlIlIl);
    }
    
    @NotNull
    @Override
    public Stream<BinaryTag> stream() {
        return this.tags.stream();
    }
    
    ListBinaryTagImpl(final BinaryTagType<? extends BinaryTag> lllllllllllllIIIIIlIlIlIlIIIlIIl, final List<BinaryTag> lllllllllllllIIIIIlIlIlIlIIIlIII) {
        this.tags = Collections.unmodifiableList((List<? extends BinaryTag>)lllllllllllllIIIIIlIlIlIlIIIlIII);
        this.elementType = lllllllllllllIIIIIlIlIlIlIIIlIIl;
        this.hashCode = lllllllllllllIIIIIlIlIlIlIIIlIII.hashCode();
    }
    
    @Override
    public Spliterator<BinaryTag> spliterator() {
        return Spliterators.spliterator((Collection<? extends BinaryTag>)this.tags, 1040);
    }
    
    @NotNull
    @Override
    public ListBinaryTag add(final BinaryTag lllllllllllllIIIIIlIlIlIIlIllIII) {
        noAddEnd(lllllllllllllIIIIIlIlIlIIlIllIII);
        if (this.elementType != BinaryTagTypes.END) {
            mustBeSameType(lllllllllllllIIIIIlIlIlIIlIllIII, this.elementType);
        }
        return this.edit(lllllllllllllIIIIIlIlIIllllIIllI -> lllllllllllllIIIIIlIlIIllllIIllI.add(lllllllllllllIIIIIlIlIlIIlIllIII), lllllllllllllIIIIIlIlIlIIlIllIII.type());
    }
}
