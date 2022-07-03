package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import org.jetbrains.annotations.*;

final class IfAbsentOnTargetMerger implements Merger
{
    private IfAbsentOnTargetMerger() {
    }
    
    static {
        INSTANCE = new IfAbsentOnTargetMerger();
    }
    
    @Override
    public void mergeInsertion(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIIIlIlI, @Nullable final String lllllllllllllIlIlIIllIlIlIIIlIIl) {
        if (lllllllllllllIlIlIIllIlIlIIIlIlI.insertion == null) {
            lllllllllllllIlIlIIllIlIlIIIlIlI.insertion(lllllllllllllIlIlIIllIlIlIIIlIIl);
        }
    }
    
    @Override
    public void mergeHoverEvent(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIIlIIll, @Nullable final HoverEvent<?> lllllllllllllIlIlIIllIlIlIIlIIlI) {
        if (lllllllllllllIlIlIIllIlIlIIlIIll.hoverEvent == null) {
            lllllllllllllIlIlIIllIlIlIIlIIll.hoverEvent(lllllllllllllIlIlIIllIlIlIIlIIlI);
        }
    }
    
    @Override
    public void mergeFont(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIIIIIII, @Nullable final Key lllllllllllllIlIlIIllIlIlIIIIIIl) {
        if (lllllllllllllIlIlIIllIlIlIIIIIII.font == null) {
            lllllllllllllIlIlIIllIlIlIIIIIII.font(lllllllllllllIlIlIIllIlIlIIIIIIl);
        }
    }
    
    @Override
    public void mergeClickEvent(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIIlllII, @Nullable final ClickEvent lllllllllllllIlIlIIllIlIlIIllIll) {
        if (lllllllllllllIlIlIIllIlIlIIlllII.clickEvent == null) {
            lllllllllllllIlIlIIllIlIlIIlllII.clickEvent(lllllllllllllIlIlIIllIlIlIIllIll);
        }
    }
    
    @Override
    public void mergeColor(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIllIIIl, @Nullable final TextColor lllllllllllllIlIlIIllIlIlIllIIlI) {
        if (lllllllllllllIlIlIIllIlIlIllIIIl.color == null) {
            lllllllllllllIlIlIIllIlIlIllIIIl.color(lllllllllllllIlIlIIllIlIlIllIIlI);
        }
    }
    
    @Override
    public void mergeDecoration(final StyleImpl.BuilderImpl lllllllllllllIlIlIIllIlIlIlIlIII, @NotNull final TextDecoration lllllllllllllIlIlIIllIlIlIlIIlll, final TextDecoration.State lllllllllllllIlIlIIllIlIlIlIIllI) {
        lllllllllllllIlIlIIllIlIlIlIlIII.decorationIfAbsent(lllllllllllllIlIlIIllIlIlIlIIlll, lllllllllllllIlIlIIllIlIlIlIIllI);
    }
}
