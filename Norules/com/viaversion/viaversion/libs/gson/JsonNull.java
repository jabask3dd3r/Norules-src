package com.viaversion.viaversion.libs.gson;

public final class JsonNull extends JsonElement
{
    public static final /* synthetic */ JsonNull INSTANCE;
    
    @Override
    public JsonNull deepCopy() {
        return JsonNull.INSTANCE;
    }
    
    @Override
    public boolean equals(final Object llIllllIIlIlII) {
        return this == llIllllIIlIlII || llIllllIIlIlII instanceof JsonNull;
    }
    
    static {
        INSTANCE = new JsonNull();
    }
    
    @Deprecated
    public JsonNull() {
    }
    
    @Override
    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}
