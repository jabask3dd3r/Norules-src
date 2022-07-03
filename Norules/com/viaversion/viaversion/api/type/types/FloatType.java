package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;

public class FloatType extends Type<Float> implements TypeConverter<Float>
{
    public void writePrimitive(final ByteBuf llllllllllllllIIIIIlIlIIlIllllII, final float llllllllllllllIIIIIlIlIIlIlllIll) {
        llllllllllllllIIIIIlIlIIlIllllII.writeFloat(llllllllllllllIIIIIlIlIIlIlllIll);
    }
    
    public float readPrimitive(final ByteBuf llllllllllllllIIIIIlIlIIllIIIIIl) {
        return llllllllllllllIIIIIlIlIIllIIIIIl.readFloat();
    }
    
    public FloatType() {
        super(Float.class);
    }
    
    @Deprecated
    @Override
    public Float read(final ByteBuf llllllllllllllIIIIIlIlIIlIllIllI) {
        return llllllllllllllIIIIIlIlIIlIllIllI.readFloat();
    }
    
    @Override
    public Float from(final Object llllllllllllllIIIIIlIlIIlIlIlIll) {
        if (llllllllllllllIIIIIlIlIIlIlIlIll instanceof Number) {
            return ((Number)llllllllllllllIIIIIlIlIIlIlIlIll).floatValue();
        }
        if (llllllllllllllIIIIIlIlIIlIlIlIll instanceof Boolean) {
            return llllllllllllllIIIIIlIlIIlIlIlIll ? 1.0f : 0.0f;
        }
        return (Float)llllllllllllllIIIIIlIlIIlIlIlIll;
    }
    
    @Deprecated
    @Override
    public void write(final ByteBuf llllllllllllllIIIIIlIlIIlIlIllll, final Float llllllllllllllIIIIIlIlIIlIllIIII) {
        llllllllllllllIIIIIlIlIIlIlIllll.writeFloat((float)llllllllllllllIIIIIlIlIIlIllIIII);
    }
}
