package com.viaversion.viaversion.libs.kyori.adventure.pointer;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

final class PointerImpl<T> implements Pointer<T>
{
    private final /* synthetic */ Key key;
    private final /* synthetic */ Class<T> type;
    
    PointerImpl(final Class<T> llllllllllllllIllIIlIIllIlllllII, final Key llllllllllllllIllIIlIIllIllllIll) {
        this.type = llllllllllllllIllIIlIIllIlllllII;
        this.key = llllllllllllllIllIIlIIllIllllIll;
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    @Override
    public Key key() {
        return this.key;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllIIlIIllIlIllllI = this.type.hashCode();
        llllllllllllllIllIIlIIllIlIllllI = 31 * llllllllllllllIllIIlIIllIlIllllI + this.key.hashCode();
        return llllllllllllllIllIIlIIllIlIllllI;
    }
    
    @NotNull
    @Override
    public Class<T> type() {
        return this.type;
    }
    
    @Override
    public boolean equals(@Nullable final Object llllllllllllllIllIIlIIllIllIlIII) {
        if (this == llllllllllllllIllIIlIIllIllIlIII) {
            return true;
        }
        if (llllllllllllllIllIIlIIllIllIlIII == null || this.getClass() != llllllllllllllIllIIlIIllIllIlIII.getClass()) {
            return false;
        }
        final PointerImpl<?> llllllllllllllIllIIlIIllIllIIlIl = (PointerImpl<?>)llllllllllllllIllIIlIIllIllIlIII;
        return this.type.equals(llllllllllllllIllIIlIIllIllIIlIl.type) && this.key.equals(llllllllllllllIllIIlIIllIllIIlIl.key);
    }
}
