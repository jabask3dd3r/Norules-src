package com.viaversion.viaversion.libs.gson.internal;

import java.math.*;
import java.io.*;

public final class LazilyParsedNumber extends Number
{
    private final /* synthetic */ String value;
    
    @Override
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIllIIIIlllIlllI) {
        if (this == lllllllllllllllllIllIIIIlllIlllI) {
            return true;
        }
        if (lllllllllllllllllIllIIIIlllIlllI instanceof LazilyParsedNumber) {
            final LazilyParsedNumber lllllllllllllllllIllIIIIllllIIlI = (LazilyParsedNumber)lllllllllllllllllIllIIIIlllIlllI;
            return this.value == lllllllllllllllllIllIIIIllllIIlI.value || this.value.equals(lllllllllllllllllIllIIIIllllIIlI.value);
        }
        return false;
    }
    
    @Override
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        }
        catch (NumberFormatException lllllllllllllllllIllIIIlIIlIIIlI) {
            return new BigDecimal(this.value).longValue();
        }
    }
    
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    
    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.value);
    }
    
    @Override
    public float floatValue() {
        return Float.parseFloat(this.value);
    }
    
    @Override
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException lllllllllllllllllIllIIIlIIllIIll) {
            try {
                return (int)Long.parseLong(this.value);
            }
            catch (NumberFormatException lllllllllllllllllIllIIIlIIllIlII) {
                return new BigDecimal(this.value).intValue();
            }
        }
    }
    
    @Override
    public String toString() {
        return this.value;
    }
    
    public LazilyParsedNumber(final String lllllllllllllllllIllIIIlIlIIIIll) {
        this.value = lllllllllllllllllIllIIIlIlIIIIll;
    }
}
