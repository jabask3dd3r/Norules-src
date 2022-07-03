package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

interface Merger
{
    void mergeClickEvent(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIlIIIIIIlI, @Nullable final ClickEvent lllllllllllllllIIlllIlIlIIIIIIll);
    
    void mergeFont(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIIllllllII, @Nullable final Key lllllllllllllllIIlllIlIIllllllIl);
    
    void mergeColor(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIlIIIIlIII, @Nullable final TextColor lllllllllllllllIIlllIlIlIIIIIlll);
    
    void mergeInsertion(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIIllllllll, @Nullable final String lllllllllllllllIIlllIlIIlllllllI);
    
    void mergeDecoration(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIlIIIIIlII, @NotNull final TextDecoration lllllllllllllllIIlllIlIlIIIIIlIl, final TextDecoration.State lllllllllllllllIIlllIlIlIIIIIllI);
    
    void mergeHoverEvent(final StyleImpl.BuilderImpl lllllllllllllllIIlllIlIlIIIIIIIl, @Nullable final HoverEvent<?> lllllllllllllllIIlllIlIlIIIIIIII);
}
