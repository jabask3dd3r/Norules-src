package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

public interface ComponentBuilder<C extends BuildableComponent<C, B>, B extends ComponentBuilder<C, B>> extends Buildable.Builder<C>, ComponentBuilderApplicable, ComponentLike
{
    @NotNull
    @Contract("_ -> this")
    B append(@NotNull final Component lllllllllllllllllIllIlIlIIIllIIl);
    
    @NotNull
    @Contract("_ -> this")
    B mapChildrenDeep(@NotNull final Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> lllllllllllllllllIllIlIIlllllllI);
    
    @NotNull
    @Contract("_ -> this")
    B style(@NotNull final Consumer<Style.Builder> lllllllllllllllllIllIlIIllllllII);
    
    @NotNull
    @Contract("_ -> this")
    B append(@NotNull final Iterable<? extends ComponentLike> lllllllllllllllllIllIlIlIIIIlIII);
    
    @Contract("_ -> this")
    @NotNull
    B applyDeep(@NotNull final Consumer<? super ComponentBuilder<?, ?>> lllllllllllllllllIllIlIlIIIIIIII);
    
    @Contract("_ -> this")
    @NotNull
    default B append(@NotNull final ComponentLike lllllllllllllllllIllIlIlIIIlIllI) {
        return this.append(lllllllllllllllllIllIlIlIIIlIllI.asComponent());
    }
    
    @Contract("_ -> this")
    @NotNull
    B mapChildren(@NotNull final Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> lllllllllllllllllIllIlIIllllllll);
    
    @Contract("_ -> this")
    @NotNull
    B font(@Nullable final Key lllllllllllllllllIllIlIIlllllIll);
    
    @NotNull
    @Contract("_ -> this")
    default B decorate(@NotNull final TextDecoration lllllllllllllllllIllIlIIlllIlIII) {
        return this.decoration(lllllllllllllllllIllIlIIlllIlIII, TextDecoration.State.TRUE);
    }
    
    @NotNull
    @Contract("_ -> this")
    B insertion(@Nullable final String lllllllllllllllllIllIlIIllIIIlll);
    
    @NotNull
    default Component asComponent() {
        return this.build();
    }
    
    @Contract("_, _ -> this")
    @NotNull
    default B decorations(@NotNull final Set<TextDecoration> lllllllllllllllllIllIlIIllllIlII, final boolean lllllllllllllllllIllIlIIllllIIll) {
        final TextDecoration.State lllllllllllllllllIllIlIIlllIllll = TextDecoration.State.byBoolean(lllllllllllllllllIllIlIIllllIIll);
        lllllllllllllllllIllIlIIllllIlII.forEach(lllllllllllllllllIllIlIIlIIllIIl -> this.decoration(lllllllllllllllllIllIlIIlIIllIIl, lllllllllllllllllIllIlIIlllIllll));
        return (B)this;
    }
    
    @NotNull
    @Contract("_ -> this")
    B style(@NotNull final Style lllllllllllllllllIllIlIIllllllIl);
    
    @Contract("_ -> this")
    @NotNull
    default B append(@NotNull final ComponentBuilder<?, ?> lllllllllllllllllIllIlIlIIIIllll) {
        return this.append((Component)lllllllllllllllllIllIlIlIIIIllll.build());
    }
    
    @NotNull
    List<Component> children();
    
    @NotNull
    @Contract("_, _ -> this")
    default B mergeStyle(@NotNull final Component lllllllllllllllllIllIlIIlIllllII, final Style.Merge... lllllllllllllllllIllIlIIlIlllIll) {
        return this.mergeStyle(lllllllllllllllllIllIlIIlIllllII, Style.Merge.of(lllllllllllllllllIllIlIIlIlllIll));
    }
    
    @Contract("_ -> this")
    @NotNull
    B clickEvent(@Nullable final ClickEvent lllllllllllllllllIllIlIIllIIlIIl);
    
    @NotNull
    @Contract("_ -> this")
    B append(@NotNull final ComponentLike... lllllllllllllllllIllIlIlIIIIlIIl);
    
    @NotNull
    C build();
    
    @NotNull
    @Contract("_ -> this")
    default B applicableApply(@NotNull final ComponentBuilderApplicable lllllllllllllllllIllIlIIlIllIIII) {
        lllllllllllllllllIllIlIIlIllIIII.componentBuilderApply(this);
        return (B)this;
    }
    
    default void componentBuilderApply(@NotNull final ComponentBuilder<?, ?> lllllllllllllllllIllIlIIlIlIlIIl) {
        lllllllllllllllllIllIlIIlIlIlIIl.append(this);
    }
    
    @NotNull
    @Contract("_ -> this")
    default B decorate(@NotNull final TextDecoration... lllllllllllllllllIllIlIIllIlllll) {
        for (int lllllllllllllllllIllIlIIllIllllI = 0, lllllllllllllllllIllIlIIllIlllIl = lllllllllllllllllIllIlIIllIlllll.length; lllllllllllllllllIllIlIIllIllllI < lllllllllllllllllIllIlIIllIlllIl; ++lllllllllllllllllIllIlIIllIllllI) {
            this.decorate(lllllllllllllllllIllIlIIllIlllll[lllllllllllllllllIllIlIIllIllllI]);
        }
        return (B)this;
    }
    
    @NotNull
    @Contract("_ -> this")
    default B mergeStyle(@NotNull final Component lllllllllllllllllIllIlIIllIIIlII) {
        return this.mergeStyle(lllllllllllllllllIllIlIIllIIIlII, Style.Merge.all());
    }
    
    @NotNull
    @Contract("_, _ -> this")
    B mergeStyle(@NotNull final Component lllllllllllllllllIllIlIIlIllIIll, @NotNull final Set<Style.Merge> lllllllllllllllllIllIlIIlIllIlII);
    
    @Contract("_, _ -> this")
    @NotNull
    default B decoration(@NotNull final TextDecoration lllllllllllllllllIllIlIIllIlIIll, final boolean lllllllllllllllllIllIlIIllIlIIlI) {
        return this.decoration(lllllllllllllllllIllIlIIllIlIIll, TextDecoration.State.byBoolean(lllllllllllllllllIllIlIIllIlIIlI));
    }
    
    @Contract("_ -> this")
    @NotNull
    B append(@NotNull final Component... lllllllllllllllllIllIlIlIIIIlIlI);
    
    @NotNull
    @Contract("_ -> this")
    B color(@Nullable final TextColor lllllllllllllllllIllIlIIlllllIlI);
    
    @NotNull
    B resetStyle();
    
    @NotNull
    @Contract("_ -> this")
    B hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllllllIllIlIIllIIlIII);
    
    @NotNull
    @Contract("_, _ -> this")
    B decoration(@NotNull final TextDecoration lllllllllllllllllIllIlIIllIIlIlI, final TextDecoration.State lllllllllllllllllIllIlIIllIIlIll);
    
    @Contract("_ -> this")
    @NotNull
    default B apply(@NotNull final Consumer<? super ComponentBuilder<?, ?>> lllllllllllllllllIllIlIlIIIIIlIl) {
        lllllllllllllllllIllIlIlIIIIIlIl.accept(this);
        return (B)this;
    }
    
    @NotNull
    @Contract("_ -> this")
    B colorIfAbsent(@Nullable final TextColor lllllllllllllllllIllIlIIlllllIIl);
}
