package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.internal.*;
import java.math.*;

public final class JsonPrimitive extends JsonElement
{
    private final /* synthetic */ Object value;
    
    @Override
    public BigInteger getAsBigInteger() {
        return (BigInteger)((this.value instanceof BigInteger) ? this.value : new BigInteger(this.value.toString()));
    }
    
    public JsonPrimitive(final Number llllllllllllllIlllIllIllIlllIllI) {
        this.value = $Gson$Preconditions.checkNotNull(llllllllllllllIlllIllIllIlllIllI);
    }
    
    @Override
    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            final long llllllllllllllIlllIllIllIIllIlll = this.getAsNumber().longValue();
            return (int)(llllllllllllllIlllIllIllIIllIlll ^ llllllllllllllIlllIllIllIIllIlll >>> 32);
        }
        if (this.value instanceof Number) {
            final long llllllllllllllIlllIllIllIIllIllI = Double.doubleToLongBits(this.getAsNumber().doubleValue());
            return (int)(llllllllllllllIlllIllIllIIllIllI ^ llllllllllllllIlllIllIllIIllIllI >>> 32);
        }
        return this.value.hashCode();
    }
    
    @Override
    public char getAsCharacter() {
        return this.getAsString().charAt(0);
    }
    
    @Override
    public Number getAsNumber() {
        return (this.value instanceof String) ? new LazilyParsedNumber((String)this.value) : this.value;
    }
    
    public JsonPrimitive(final Boolean llllllllllllllIlllIllIllIlllllII) {
        this.value = $Gson$Preconditions.checkNotNull(llllllllllllllIlllIllIllIlllllII);
    }
    
    public boolean isNumber() {
        return this.value instanceof Number;
    }
    
    @Override
    public String getAsString() {
        if (this.isNumber()) {
            return this.getAsNumber().toString();
        }
        if (this.isBoolean()) {
            return ((Boolean)this.value).toString();
        }
        return (String)this.value;
    }
    
    @Override
    public boolean getAsBoolean() {
        if (this.isBoolean()) {
            return (boolean)this.value;
        }
        return Boolean.parseBoolean(this.getAsString());
    }
    
    public JsonPrimitive(final Character llllllllllllllIlllIllIllIllIlIlI) {
        this.value = $Gson$Preconditions.checkNotNull(llllllllllllllIlllIllIllIllIlIlI).toString();
    }
    
    @Override
    public JsonPrimitive deepCopy() {
        return this;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlllIllIllIIlIIlll) {
        if (this == llllllllllllllIlllIllIllIIlIIlll) {
            return true;
        }
        if (llllllllllllllIlllIllIllIIlIIlll == null || this.getClass() != llllllllllllllIlllIllIllIIlIIlll.getClass()) {
            return false;
        }
        final JsonPrimitive llllllllllllllIlllIllIllIIlIlIIl = (JsonPrimitive)llllllllllllllIlllIllIllIIlIIlll;
        if (this.value == null) {
            return llllllllllllllIlllIllIllIIlIlIIl.value == null;
        }
        if (isIntegral(this) && isIntegral(llllllllllllllIlllIllIllIIlIlIIl)) {
            return this.getAsNumber().longValue() == llllllllllllllIlllIllIllIIlIlIIl.getAsNumber().longValue();
        }
        if (this.value instanceof Number && llllllllllllllIlllIllIllIIlIlIIl.value instanceof Number) {
            final double llllllllllllllIlllIllIllIIlIllIl = this.getAsNumber().doubleValue();
            final double llllllllllllllIlllIllIllIIlIllII = llllllllllllllIlllIllIllIIlIlIIl.getAsNumber().doubleValue();
            return llllllllllllllIlllIllIllIIlIllIl == llllllllllllllIlllIllIllIIlIllII || (Double.isNaN(llllllllllllllIlllIllIllIIlIllIl) && Double.isNaN(llllllllllllllIlllIllIllIIlIllII));
        }
        return this.value.equals(llllllllllllllIlllIllIllIIlIlIIl.value);
    }
    
    @Override
    public BigDecimal getAsBigDecimal() {
        return (BigDecimal)((this.value instanceof BigDecimal) ? this.value : new BigDecimal(this.value.toString()));
    }
    
    @Override
    public float getAsFloat() {
        return this.isNumber() ? this.getAsNumber().floatValue() : Float.parseFloat(this.getAsString());
    }
    
    public JsonPrimitive(final String llllllllllllllIlllIllIllIlllIIII) {
        this.value = $Gson$Preconditions.checkNotNull(llllllllllllllIlllIllIllIlllIIII);
    }
    
    private static boolean isIntegral(final JsonPrimitive llllllllllllllIlllIllIllIIlIIIII) {
        if (llllllllllllllIlllIllIllIIlIIIII.value instanceof Number) {
            final Number llllllllllllllIlllIllIllIIlIIIIl = (Number)llllllllllllllIlllIllIllIIlIIIII.value;
            return llllllllllllllIlllIllIllIIlIIIIl instanceof BigInteger || llllllllllllllIlllIllIllIIlIIIIl instanceof Long || llllllllllllllIlllIllIllIIlIIIIl instanceof Integer || llllllllllllllIlllIllIllIIlIIIIl instanceof Short || llllllllllllllIlllIllIllIIlIIIIl instanceof Byte;
        }
        return false;
    }
    
    public boolean isString() {
        return this.value instanceof String;
    }
    
    @Override
    public int getAsInt() {
        return this.isNumber() ? this.getAsNumber().intValue() : Integer.parseInt(this.getAsString());
    }
    
    @Override
    public long getAsLong() {
        return this.isNumber() ? this.getAsNumber().longValue() : Long.parseLong(this.getAsString());
    }
    
    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }
    
    @Override
    public byte getAsByte() {
        return this.isNumber() ? this.getAsNumber().byteValue() : Byte.parseByte(this.getAsString());
    }
    
    @Override
    public short getAsShort() {
        return this.isNumber() ? this.getAsNumber().shortValue() : Short.parseShort(this.getAsString());
    }
    
    @Override
    public double getAsDouble() {
        return this.isNumber() ? this.getAsNumber().doubleValue() : Double.parseDouble(this.getAsString());
    }
}
