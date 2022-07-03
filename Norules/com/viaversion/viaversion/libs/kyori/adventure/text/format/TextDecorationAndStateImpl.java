package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class TextDecorationAndStateImpl implements TextDecorationAndState
{
    private final /* synthetic */ TextDecoration.State state;
    private final /* synthetic */ TextDecoration decoration;
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    TextDecorationAndStateImpl(final TextDecoration llllllllllllllllIIlIIlIIllllllll, final TextDecoration.State llllllllllllllllIIlIIlIIlllllllI) {
        this.decoration = llllllllllllllllIIlIIlIIllllllll;
        this.state = llllllllllllllllIIlIIlIIlllllllI;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllllIIlIIlIIlllIIIIl = this.decoration.hashCode();
        llllllllllllllllIIlIIlIIlllIIIIl = 31 * llllllllllllllllIIlIIlIIlllIIIIl + this.state.hashCode();
        return llllllllllllllllIIlIIlIIlllIIIIl;
    }
    
    @Override
    public TextDecoration decoration() {
        return this.decoration;
    }
    
    @Override
    public TextDecoration.State state() {
        return this.state;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIlIIlIIlllIlIll) {
        if (this == llllllllllllllllIIlIIlIIlllIlIll) {
            return true;
        }
        if (llllllllllllllllIIlIIlIIlllIlIll == null || this.getClass() != llllllllllllllllIIlIIlIIlllIlIll.getClass()) {
            return false;
        }
        final TextDecorationAndStateImpl llllllllllllllllIIlIIlIIlllIlIII = (TextDecorationAndStateImpl)llllllllllllllllIIlIIlIIlllIlIll;
        return this.decoration == llllllllllllllllIIlIIlIIlllIlIII.decoration && this.state == llllllllllllllllIIlIIlIIlllIlIII.state;
    }
}
