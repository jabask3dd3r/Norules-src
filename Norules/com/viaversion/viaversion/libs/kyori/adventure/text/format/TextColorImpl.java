package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import org.jetbrains.annotations.*;

@Debug.Renderer(text = "asHexString()")
final class TextColorImpl implements TextColor
{
    private final /* synthetic */ int value;
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllIIlIIlIIIlIllIIIl) {
        if (this == lllllllllllllllIIlIIlIIIlIllIIIl) {
            return true;
        }
        if (!(lllllllllllllllIIlIIlIIIlIllIIIl instanceof TextColorImpl)) {
            return false;
        }
        final TextColorImpl lllllllllllllllIIlIIlIIIlIlIlllI = (TextColorImpl)lllllllllllllllIIlIIlIIIlIllIIIl;
        return this.value == lllllllllllllllIIlIIlIIIlIlIlllI.value;
    }
    
    @Override
    public String toString() {
        return this.asHexString();
    }
    
    @Override
    public int value() {
        return this.value;
    }
    
    TextColorImpl(final int lllllllllllllllIIlIIlIIIlIllllII) {
        this.value = lllllllllllllllIIlIIlIIIlIllllII;
    }
}
