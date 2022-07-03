package com.viaversion.viaversion.libs.gson.internal;

public final class $Gson$Preconditions
{
    private $Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }
    
    public static <T> T checkNotNull(final T llllllllllllllllIIIllIIIIlIIlIII) {
        if (llllllllllllllllIIIllIIIIlIIlIII == null) {
            throw new NullPointerException();
        }
        return llllllllllllllllIIIllIIIIlIIlIII;
    }
    
    public static void checkArgument(final boolean llllllllllllllllIIIllIIIIlIIIlII) {
        if (!llllllllllllllllIIIllIIIIlIIIlII) {
            throw new IllegalArgumentException();
        }
    }
}
