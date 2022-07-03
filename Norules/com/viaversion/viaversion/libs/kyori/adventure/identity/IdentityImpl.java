package com.viaversion.viaversion.libs.kyori.adventure.identity;

import java.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class IdentityImpl implements Examinable, Identity
{
    private final /* synthetic */ UUID uuid;
    
    IdentityImpl(final UUID lllllllllllllIIlIllIIIlIllllllIl) {
        this.uuid = lllllllllllllIIlIllIIIlIllllllIl;
    }
    
    @NotNull
    @Override
    public UUID uuid() {
        return this.uuid;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIlIllIIIlIlllIllll) {
        if (this == lllllllllllllIIlIllIIIlIlllIllll) {
            return true;
        }
        if (!(lllllllllllllIIlIllIIIlIlllIllll instanceof Identity)) {
            return false;
        }
        final Identity lllllllllllllIIlIllIIIlIlllIllII = (Identity)lllllllllllllIIlIllIIIlIlllIllll;
        return this.uuid.equals(lllllllllllllIIlIllIIIlIlllIllII.uuid());
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @Override
    public int hashCode() {
        return this.uuid.hashCode();
    }
}
