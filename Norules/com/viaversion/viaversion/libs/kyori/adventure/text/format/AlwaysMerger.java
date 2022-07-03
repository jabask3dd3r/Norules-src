package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

final class AlwaysMerger implements Merger
{
    @Override
    public void mergeClickEvent(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIlllIlIIlI, @Nullable final ClickEvent lllllllllllllIIlIllIllIlllIlIIll) {
        lllllllllllllIIlIllIllIlllIlIIlI.clickEvent(lllllllllllllIIlIllIllIlllIlIIll);
    }
    
    @Override
    public void mergeFont(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIllIllIlll, @Nullable final Key lllllllllllllIIlIllIllIllIlllIII) {
        lllllllllllllIIlIllIllIllIllIlll.font(lllllllllllllIIlIllIllIllIlllIII);
    }
    
    private AlwaysMerger() {
    }
    
    static {
        INSTANCE = new AlwaysMerger();
    }
    
    @Override
    public void mergeDecoration(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIlllIlllll, @NotNull final TextDecoration lllllllllllllIIlIllIllIlllIlllIl, final TextDecoration.State lllllllllllllIIlIllIllIlllIllllI) {
        lllllllllllllIIlIllIllIlllIlllll.decoration(lllllllllllllIIlIllIllIlllIlllIl, lllllllllllllIIlIllIllIlllIllllI);
    }
    
    @Override
    public void mergeInsertion(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIlllIIIIIl, @Nullable final String lllllllllllllIIlIllIllIlllIIIIII) {
        lllllllllllllIIlIllIllIlllIIIIIl.insertion(lllllllllllllIIlIllIllIlllIIIIII);
    }
    
    @Override
    public void mergeHoverEvent(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIlllIIlIlI, @Nullable final HoverEvent<?> lllllllllllllIIlIllIllIlllIIlIIl) {
        lllllllllllllIIlIllIllIlllIIlIlI.hoverEvent(lllllllllllllIIlIllIllIlllIIlIIl);
    }
    
    @Override
    public void mergeColor(final StyleImpl.BuilderImpl lllllllllllllIIlIllIllIllllIlIII, @Nullable final TextColor lllllllllllllIIlIllIllIllllIlIIl) {
        lllllllllllllIIlIllIllIllllIlIII.color(lllllllllllllIIlIllIllIllllIlIIl);
    }
}
