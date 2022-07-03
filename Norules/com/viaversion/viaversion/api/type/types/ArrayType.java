package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import java.lang.reflect.*;

public class ArrayType<T> extends Type<T[]>
{
    private final /* synthetic */ Type<T> elementType;
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIIlIIllIlllIlllll, final T[] lllllllllllllIlIIlIIllIlllIllIll) throws Exception {
        Type.VAR_INT.writePrimitive(lllllllllllllIlIIlIIllIlllIlllll, lllllllllllllIlIIlIIllIlllIllIll.length);
        final boolean lllllllllllllIlIIlIIllIlllIllIlI = (Object)lllllllllllllIlIIlIIllIlllIllIll;
        final float lllllllllllllIlIIlIIllIlllIllIIl = lllllllllllllIlIIlIIllIlllIllIlI.length;
        for (short lllllllllllllIlIIlIIllIlllIllIII = 0; lllllllllllllIlIIlIIllIlllIllIII < lllllllllllllIlIIlIIllIlllIllIIl; ++lllllllllllllIlIIlIIllIlllIllIII) {
            final T lllllllllllllIlIIlIIllIllllIIIIl = lllllllllllllIlIIlIIllIlllIllIlI[lllllllllllllIlIIlIIllIlllIllIII];
            this.elementType.write(lllllllllllllIlIIlIIllIlllIlllll, lllllllllllllIlIIlIIllIllllIIIIl);
        }
    }
    
    public ArrayType(final Type<T> lllllllllllllIlIIlIIllIllllllIll) {
        super(String.valueOf(new StringBuilder().append(lllllllllllllIlIIlIIllIllllllIll.getTypeName()).append(" Array")), getArrayClass(lllllllllllllIlIIlIIllIllllllIll.getOutputClass()));
        this.elementType = lllllllllllllIlIIlIIllIllllllIll;
    }
    
    @Override
    public T[] read(final ByteBuf lllllllllllllIlIIlIIllIlllllIIII) throws Exception {
        final int lllllllllllllIlIIlIIllIllllIllll = Type.VAR_INT.readPrimitive(lllllllllllllIlIIlIIllIlllllIIII);
        final T[] lllllllllllllIlIIlIIllIllllIlllI = (T[])Array.newInstance(this.elementType.getOutputClass(), lllllllllllllIlIIlIIllIllllIllll);
        for (int lllllllllllllIlIIlIIllIlllllIIlI = 0; lllllllllllllIlIIlIIllIlllllIIlI < lllllllllllllIlIIlIIllIllllIllll; ++lllllllllllllIlIIlIIllIlllllIIlI) {
            lllllllllllllIlIIlIIllIllllIlllI[lllllllllllllIlIIlIIllIlllllIIlI] = this.elementType.read(lllllllllllllIlIIlIIllIlllllIIII);
        }
        return lllllllllllllIlIIlIIllIllllIlllI;
    }
    
    public static Class<?> getArrayClass(final Class<?> lllllllllllllIlIIlIIllIllllllIII) {
        return Array.newInstance(lllllllllllllIlIIlIIllIllllllIII, 0).getClass();
    }
}
