package com.viaversion.viaversion.libs.kyori.adventure.permission;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;

final class PermissionCheckers
{
    static {
        NOT_SET = new Always(TriState.NOT_SET);
        FALSE = new Always(TriState.FALSE);
        TRUE = new Always(TriState.TRUE);
    }
    
    private PermissionCheckers() {
    }
    
    private static final class Always implements PermissionChecker
    {
        private final /* synthetic */ TriState value;
        
        @Override
        public int hashCode() {
            return this.value.hashCode();
        }
        
        private Always(final TriState lllllllllllllIIllllllIllIlIIIlII) {
            this.value = lllllllllllllIIllllllIllIlIIIlII;
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIIllllllIllIIllIlII) {
            if (this == lllllllllllllIIllllllIllIIllIlII) {
                return true;
            }
            if (lllllllllllllIIllllllIllIIllIlII == null || this.getClass() != lllllllllllllIIllllllIllIIllIlII.getClass()) {
                return false;
            }
            final Always lllllllllllllIIllllllIllIIllIIIl = (Always)lllllllllllllIIllllllIllIIllIlII;
            return this.value == lllllllllllllIIllllllIllIIllIIIl.value;
        }
        
        @NotNull
        @Override
        public TriState value(final String lllllllllllllIIllllllIllIIlllllI) {
            return this.value;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(PermissionChecker.class.getSimpleName()).append(".always(").append(this.value).append(")"));
        }
    }
}
