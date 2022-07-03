package net.minecraft.util;

import org.apache.commons.lang3.*;
import java.util.*;
import javax.annotation.*;

public class NonNullList<E> extends AbstractList<E>
{
    private final /* synthetic */ List<E> field_191198_a;
    private final /* synthetic */ E field_191199_b;
    
    public static <E> NonNullList<E> func_191197_a(final int lllllllllllllllIIIIIIlllllIlIllI, final E lllllllllllllllIIIIIIlllllIlIIlI) {
        Validate.notNull((Object)lllllllllllllllIIIIIIlllllIlIIlI);
        final Object[] lllllllllllllllIIIIIIlllllIlIlII = new Object[lllllllllllllllIIIIIIlllllIlIllI];
        Arrays.fill(lllllllllllllllIIIIIIlllllIlIlII, lllllllllllllllIIIIIIlllllIlIIlI);
        return new NonNullList<E>(Arrays.asList((E[])lllllllllllllllIIIIIIlllllIlIlII), lllllllllllllllIIIIIIlllllIlIIlI);
    }
    
    @Override
    public E remove(final int lllllllllllllllIIIIIIllllIlIIIIl) {
        return this.field_191198_a.remove(lllllllllllllllIIIIIIllllIlIIIIl);
    }
    
    protected NonNullList(final List<E> lllllllllllllllIIIIIIlllllIIIIII, @Nullable final E lllllllllllllllIIIIIIlllllIIIIlI) {
        this.field_191198_a = lllllllllllllllIIIIIIlllllIIIIII;
        this.field_191199_b = lllllllllllllllIIIIIIlllllIIIIlI;
    }
    
    @Override
    public void clear() {
        if (this.field_191199_b == null) {
            super.clear();
        }
        else {
            for (int lllllllllllllllIIIIIIllllIIllIlI = 0; lllllllllllllllIIIIIIllllIIllIlI < this.size(); ++lllllllllllllllIIIIIIllllIIllIlI) {
                this.set(lllllllllllllllIIIIIIllllIIllIlI, this.field_191199_b);
            }
        }
    }
    
    protected NonNullList() {
        this(new ArrayList<Object>(), null);
    }
    
    @Nonnull
    @Override
    public E get(final int lllllllllllllllIIIIIIllllIlllIIl) {
        return this.field_191198_a.get(lllllllllllllllIIIIIIllllIlllIIl);
    }
    
    public static <E> NonNullList<E> func_193580_a(final E lllllllllllllllIIIIIIlllllIIllII, final E... lllllllllllllllIIIIIIlllllIIllIl) {
        return new NonNullList<E>(Arrays.asList(lllllllllllllllIIIIIIlllllIIllIl), lllllllllllllllIIIIIIlllllIIllII);
    }
    
    @Override
    public void add(final int lllllllllllllllIIIIIIllllIlIlIll, final E lllllllllllllllIIIIIIllllIlIlIlI) {
        Validate.notNull((Object)lllllllllllllllIIIIIIllllIlIlIlI);
        this.field_191198_a.add(lllllllllllllllIIIIIIllllIlIlIll, lllllllllllllllIIIIIIllllIlIlIlI);
    }
    
    public static <E> NonNullList<E> func_191196_a() {
        return new NonNullList<E>();
    }
    
    @Override
    public E set(final int lllllllllllllllIIIIIIllllIllIIIl, final E lllllllllllllllIIIIIIllllIllIIll) {
        Validate.notNull((Object)lllllllllllllllIIIIIIllllIllIIll);
        return this.field_191198_a.set(lllllllllllllllIIIIIIllllIllIIIl, lllllllllllllllIIIIIIllllIllIIll);
    }
    
    @Override
    public int size() {
        return this.field_191198_a.size();
    }
}
