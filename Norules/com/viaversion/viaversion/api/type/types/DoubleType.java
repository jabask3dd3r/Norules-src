package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class DoubleType extends Type<Double> implements TypeConverter<Double>
{
    public double readPrimitive(final ByteBuf lllllllllllllIIIIIllIIIIllIIlllI) {
        return lllllllllllllIIIIIllIIIIllIIlllI.readDouble();
    }
    
    public DoubleType() {
        super(Double.class);
    }
    
    @Deprecated
    @Override
    public Double read(final ByteBuf lllllllllllllIIIIIllIIIIllIlIIll) {
        return lllllllllllllIIIIIllIIIIllIlIIll.readDouble();
    }
    
    public void writePrimitive(final ByteBuf lllllllllllllIIIIIllIIIIllIIIIll, final double lllllllllllllIIIIIllIIIIllIIIIlI) {
        lllllllllllllIIIIIllIIIIllIIIIll.writeDouble(lllllllllllllIIIIIllIIIIllIIIIlI);
    }
    
    @Override
    public Double from(final Object lllllllllllllIIIIIllIIIIlIllllIl) {
        if (lllllllllllllIIIIIllIIIIlIllllIl instanceof Number) {
            return ((Number)lllllllllllllIIIIIllIIIIlIllllIl).doubleValue();
        }
        if (lllllllllllllIIIIIllIIIIlIllllIl instanceof Boolean) {
            return lllllllllllllIIIIIllIIIIlIllllIl ? 1.0 : 0.0;
        }
        return (Double)lllllllllllllIIIIIllIIIIlIllllIl;
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf lllllllllllllIIIIIllIIIIllIIlIII, final Double lllllllllllllIIIIIllIIIIllIIIlll) {
        lllllllllllllIIIIIllIIIIllIIlIII.writeDouble((double)lllllllllllllIIIIIllIIIIllIIIlll);
    }
}
