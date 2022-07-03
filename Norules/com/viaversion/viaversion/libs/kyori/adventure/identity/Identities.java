package com.viaversion.viaversion.libs.kyori.adventure.identity;

import java.util.*;
import org.jetbrains.annotations.*;

final class Identities
{
    private Identities() {
    }
    
    static {
        NIL = new Identity() {
            private final /* synthetic */ UUID uuid = new UUID(0L, 0L);
            
            @Override
            public int hashCode() {
                return 0;
            }
            
            @Override
            public boolean equals(final Object lllllllllllllIlIlIIIIllIIIIlIllI) {
                return this == lllllllllllllIlIlIIIIllIIIIlIllI;
            }
            
            @Override
            public String toString() {
                return "Identity.nil()";
            }
            
            @NotNull
            @Override
            public UUID uuid() {
                return this.uuid;
            }
        };
    }
}
