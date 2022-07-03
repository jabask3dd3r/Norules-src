package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

public interface ScopedComponent<C extends Component> extends Component
{
    @NotNull
    default C append(@NotNull final Component lllllllllllllllIllIlIlllllIllIll) {
        if (lllllllllllllllIllIlIlllllIllIll == Component.empty()) {
            return (C)this;
        }
        final List<Component> lllllllllllllllIllIlIlllllIllIII = this.children();
        return this.children(MonkeyBars.addOne((List<? extends ComponentLike>)lllllllllllllllIllIlIlllllIllIII, (ComponentLike)lllllllllllllllIllIlIlllllIllIll));
    }
    
    @NotNull
    C style(@NotNull final Style lllllllllllllllIllIllIIIIIIlIIlI);
    
    @NotNull
    default Component decorate(@NotNull final TextDecoration lllllllllllllllIllIlIllllIlIlIll) {
        return super.decorate(lllllllllllllllIllIlIllllIlIlIll);
    }
    
    @NotNull
    default C colorIfAbsent(@Nullable final TextColor lllllllllllllllIllIlIllllIllIIlI) {
        return (C)super.colorIfAbsent(lllllllllllllllIllIlIllllIllIIlI);
    }
    
    @NotNull
    default C hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllllIllIlIllllIIIIlll) {
        return (C)super.hoverEvent(lllllllllllllllIllIlIllllIIIIlll);
    }
    
    @NotNull
    default C mergeStyle(@NotNull final Component lllllllllllllllIllIlIllllllIllIl, final Style.Merge... lllllllllllllllIllIlIllllllIlIll) {
        return (C)super.mergeStyle(lllllllllllllllIllIlIllllllIllIl, lllllllllllllllIllIlIllllllIlIll);
    }
    
    @NotNull
    default C insertion(@Nullable final String lllllllllllllllIllIlIllllIIIIIII) {
        return (C)super.insertion(lllllllllllllllIllIlIllllIIIIIII);
    }
    
    @NotNull
    default C mergeStyle(@NotNull final Component lllllllllllllllIllIlIllllllllllI) {
        return (C)super.mergeStyle(lllllllllllllllIllIlIllllllllllI);
    }
    
    @NotNull
    default C decoration(@NotNull final TextDecoration lllllllllllllllIllIlIllllIlIIIll, final boolean lllllllllllllllIllIlIllllIlIIIlI) {
        return (C)super.decoration(lllllllllllllllIllIlIllllIlIIIll, lllllllllllllllIllIlIllllIlIIIlI);
    }
    
    @NotNull
    default C style(final Style.Builder lllllllllllllllIllIllIIIIIIIIlll) {
        return (C)super.style(lllllllllllllllIllIllIIIIIIIIlll);
    }
    
    @NotNull
    default C append(@NotNull final ComponentBuilder<?, ?> lllllllllllllllIllIlIlllllIIlIll) {
        return (C)super.append(lllllllllllllllIllIlIlllllIIlIll);
    }
    
    @NotNull
    default C style(@NotNull final Consumer<Style.Builder> lllllllllllllllIllIllIIIIIIIllll) {
        return (C)super.style(lllllllllllllllIllIllIIIIIIIllll);
    }
    
    @NotNull
    default C decoration(@NotNull final TextDecoration lllllllllllllllIllIlIllllIIllIII, final TextDecoration.State lllllllllllllllIllIlIllllIIlIlll) {
        return (C)super.decoration(lllllllllllllllIllIlIllllIIllIII, lllllllllllllllIllIlIllllIIlIlll);
    }
    
    @NotNull
    default C color(@Nullable final TextColor lllllllllllllllIllIlIllllIlllIIl) {
        return (C)super.color(lllllllllllllllIllIlIllllIlllIIl);
    }
    
    @NotNull
    default C append(@NotNull final ComponentLike lllllllllllllllIllIlIlllllIlIIlI) {
        return (C)super.append(lllllllllllllllIllIlIlllllIlIIlI);
    }
    
    @NotNull
    default C mergeStyle(@NotNull final Component lllllllllllllllIllIlIlllllIIIIll, @NotNull final Set<Style.Merge> lllllllllllllllIllIlIlllllIIIIlI) {
        return (C)super.mergeStyle(lllllllllllllllIllIlIlllllIIIIll, lllllllllllllllIllIlIlllllIIIIlI);
    }
    
    @NotNull
    C children(@NotNull final List<? extends ComponentLike> lllllllllllllllIllIllIIIIIIlIIll);
    
    @NotNull
    default C clickEvent(@Nullable final ClickEvent lllllllllllllllIllIlIllllIIIlllI) {
        return (C)super.clickEvent(lllllllllllllllIllIlIllllIIIlllI);
    }
}
