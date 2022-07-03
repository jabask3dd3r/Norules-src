package com.viaversion.viaversion.libs.gson;

public enum LongSerializationPolicy
{
    DEFAULT(0) {
        @Override
        public JsonElement serialize(final Long llllllllllllllIlIllIIIIlIlIlllIl) {
            return new JsonPrimitive(llllllllllllllIlIllIIIIlIlIlllIl);
        }
    }, 
    STRING(1) {
        @Override
        public JsonElement serialize(final Long lllllllllllllIIlIIIlllllllIIIIll) {
            return new JsonPrimitive(String.valueOf(lllllllllllllIIlIIIlllllllIIIIll));
        }
    };
    
    public abstract JsonElement serialize(final Long p0);
}
