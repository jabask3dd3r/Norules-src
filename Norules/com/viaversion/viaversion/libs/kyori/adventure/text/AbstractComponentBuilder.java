package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

abstract class AbstractComponentBuilder<C extends BuildableComponent<C, B>, B extends ComponentBuilder<C, B>> implements ComponentBuilder<C, B>
{
    protected /* synthetic */ List<Component> children;
    private /* synthetic */ Style.Builder styleBuilder;
    @Nullable
    private /* synthetic */ Style style;
    
    @NotNull
    @Override
    public B append(@NotNull final Component lllllllllllllIlIIIIIIlIlIllIIIll) {
        if (lllllllllllllIlIIIIIIlIlIllIIIll == Component.empty()) {
            return (B)this;
        }
        this.prepareChildren();
        this.children.add(lllllllllllllIlIIIIIIlIlIllIIIll);
        return (B)this;
    }
    
    @NotNull
    @Override
    public B append(@NotNull final ComponentLike... lllllllllllllIlIIIIIIlIlIlIIIlIl) {
        boolean lllllllllllllIlIIIIIIlIlIIllllll = false;
        for (int lllllllllllllIlIIIIIIlIlIlIIIIll = 0, lllllllllllllIlIIIIIIlIlIlIIIIlI = lllllllllllllIlIIIIIIlIlIlIIIlIl.length; lllllllllllllIlIIIIIIlIlIlIIIIll < lllllllllllllIlIIIIIIlIlIlIIIIlI; ++lllllllllllllIlIIIIIIlIlIlIIIIll) {
            final Component lllllllllllllIlIIIIIIlIlIlIIIlII = lllllllllllllIlIIIIIIlIlIlIIIlIl[lllllllllllllIlIIIIIIlIlIlIIIIll].asComponent();
            if (lllllllllllllIlIIIIIIlIlIlIIIlII != Component.empty()) {
                if (!lllllllllllllIlIIIIIIlIlIIllllll) {
                    this.prepareChildren();
                    lllllllllllllIlIIIIIIlIlIIllllll = true;
                }
                this.children.add(lllllllllllllIlIIIIIIlIlIlIIIlII);
            }
        }
        return (B)this;
    }
    
    @NotNull
    @Override
    public B mergeStyle(@NotNull final Component lllllllllllllIlIIIIIIlIIlIlIIllI, @NotNull final Set<Style.Merge> lllllllllllllIlIIIIIIlIIlIlIIlll) {
        this.styleBuilder().merge(lllllllllllllIlIIIIIIlIIlIlIIllI.style(), lllllllllllllIlIIIIIIlIIlIlIIlll);
        return (B)this;
    }
    
    @NotNull
    protected Style buildStyle() {
        if (this.styleBuilder != null) {
            return this.styleBuilder.build();
        }
        if (this.style != null) {
            return this.style;
        }
        return Style.empty();
    }
    
    @NotNull
    @Override
    public B hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIlIIIIIIlIIlIllIllI) {
        this.styleBuilder().hoverEvent(lllllllllllllIlIIIIIIlIIlIllIllI);
        return (B)this;
    }
    
    @NotNull
    @Override
    public B style(@NotNull final Style lllllllllllllIlIIIIIIlIIlllIlIll) {
        this.style = lllllllllllllIlIIIIIIlIIlllIlIll;
        this.styleBuilder = null;
        return (B)this;
    }
    
    @NotNull
    @Override
    public B resetStyle() {
        this.style = null;
        this.styleBuilder = null;
        return (B)this;
    }
    
    @NotNull
    @Override
    public B applyDeep(@NotNull final Consumer<? super ComponentBuilder<?, ?>> lllllllllllllIlIIIIIIlIlIIIllllI) {
        this.apply(lllllllllllllIlIIIIIIlIlIIIllllI);
        if (this.children == Collections.emptyList()) {
            return (B)this;
        }
        final ListIterator<Component> lllllllllllllIlIIIIIIlIlIIIllIIl = this.children.listIterator();
        while (lllllllllllllIlIIIIIIlIlIIIllIIl.hasNext()) {
            final Component lllllllllllllIlIIIIIIlIlIIIlllIl = lllllllllllllIlIIIIIIlIlIIIllIIl.next();
            if (!(lllllllllllllIlIIIIIIlIlIIIlllIl instanceof BuildableComponent)) {
                continue;
            }
            final ComponentBuilder<?, ?> lllllllllllllIlIIIIIIlIlIIIlllII = ((BuildableComponent)lllllllllllllIlIIIIIIlIlIIIlllIl).toBuilder();
            lllllllllllllIlIIIIIIlIlIIIlllII.applyDeep(lllllllllllllIlIIIIIIlIlIIIllllI);
            lllllllllllllIlIIIIIIlIlIIIllIIl.set((Component)lllllllllllllIlIIIIIIlIlIIIlllII.build());
        }
        return (B)this;
    }
    
    @NotNull
    @Override
    public B style(@NotNull final Consumer<Style.Builder> lllllllllllllIlIIIIIIlIIlllIIlII) {
        lllllllllllllIlIIIIIIlIIlllIIlII.accept(this.styleBuilder());
        return (B)this;
    }
    
    protected final boolean hasStyle() {
        return this.styleBuilder != null || this.style != null;
    }
    
    @NotNull
    @Override
    public B colorIfAbsent(@Nullable final TextColor lllllllllllllIlIIIIIIlIIllIIllll) {
        this.styleBuilder().colorIfAbsent(lllllllllllllIlIIIIIIlIIllIIllll);
        return (B)this;
    }
    
    private void prepareChildren() {
        if (this.children == Collections.emptyList()) {
            this.children = new ArrayList<Component>();
        }
    }
    
    @NotNull
    @Override
    public B color(@Nullable final TextColor lllllllllllllIlIIIIIIlIIllIlIllI) {
        this.styleBuilder().color(lllllllllllllIlIIIIIIlIIllIlIllI);
        return (B)this;
    }
    
    @NotNull
    @Override
    public B font(@Nullable final Key lllllllllllllIlIIIIIIlIIllIlllIl) {
        this.styleBuilder().font(lllllllllllllIlIIIIIIlIIllIlllIl);
        return (B)this;
    }
    
    private Style.Builder styleBuilder() {
        if (this.styleBuilder == null) {
            if (this.style != null) {
                this.styleBuilder = this.style.toBuilder();
                this.style = null;
            }
            else {
                this.styleBuilder = Style.style();
            }
        }
        return this.styleBuilder;
    }
    
    @NotNull
    @Override
    public B insertion(@Nullable final String lllllllllllllIlIIIIIIlIIlIlIllll) {
        this.styleBuilder().insertion(lllllllllllllIlIIIIIIlIIlIlIllll);
        return (B)this;
    }
    
    protected AbstractComponentBuilder(@NotNull final C lllllllllllllIlIIIIIIlIlIllIllII) {
        this.children = Collections.emptyList();
        final List<Component> lllllllllllllIlIIIIIIlIlIllIlIIl = lllllllllllllIlIIIIIIlIlIllIllII.children();
        if (!lllllllllllllIlIIIIIIlIlIllIlIIl.isEmpty()) {
            this.children = new ArrayList<Component>(lllllllllllllIlIIIIIIlIlIllIlIIl);
        }
        if (lllllllllllllIlIIIIIIlIlIllIllII.hasStyling()) {
            this.style = lllllllllllllIlIIIIIIlIlIllIllII.style();
        }
    }
    
    @NotNull
    @Override
    public B decoration(@NotNull final TextDecoration lllllllllllllIlIIIIIIlIIllIIIlll, final TextDecoration.State lllllllllllllIlIIIIIIlIIllIIIllI) {
        this.styleBuilder().decoration(lllllllllllllIlIIIIIIlIIllIIIlll, lllllllllllllIlIIIIIIlIIllIIIllI);
        return (B)this;
    }
    
    @NotNull
    @Override
    public B mapChildren(@NotNull final Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> lllllllllllllIlIIIIIIlIlIIIIlllI) {
        if (this.children == Collections.emptyList()) {
            return (B)this;
        }
        final ListIterator<Component> lllllllllllllIlIIIIIIlIlIIIIlIIl = this.children.listIterator();
        while (lllllllllllllIlIIIIIIlIlIIIIlIIl.hasNext()) {
            final Component lllllllllllllIlIIIIIIlIlIIIIllIl = lllllllllllllIlIIIIIIlIlIIIIlIIl.next();
            if (!(lllllllllllllIlIIIIIIlIlIIIIllIl instanceof BuildableComponent)) {
                continue;
            }
            final BuildableComponent<?, ?> lllllllllllllIlIIIIIIlIlIIIIllII = (BuildableComponent<?, ?>)lllllllllllllIlIIIIIIlIlIIIIlllI.apply((BuildableComponent<?, ?>)lllllllllllllIlIIIIIIlIlIIIIllIl);
            if (lllllllllllllIlIIIIIIlIlIIIIllIl == lllllllllllllIlIIIIIIlIlIIIIllII) {
                continue;
            }
            lllllllllllllIlIIIIIIlIlIIIIlIIl.set(lllllllllllllIlIIIIIIlIlIIIIllII);
        }
        return (B)this;
    }
    
    @NotNull
    @Override
    public B append(@NotNull final Component... lllllllllllllIlIIIIIIlIlIlIllIII) {
        boolean lllllllllllllIlIIIIIIlIlIlIlIIlI = false;
        for (int lllllllllllllIlIIIIIIlIlIlIlIllI = 0, lllllllllllllIlIIIIIIlIlIlIlIlIl = lllllllllllllIlIIIIIIlIlIlIllIII.length; lllllllllllllIlIIIIIIlIlIlIlIllI < lllllllllllllIlIIIIIIlIlIlIlIlIl; ++lllllllllllllIlIIIIIIlIlIlIlIllI) {
            final Component lllllllllllllIlIIIIIIlIlIlIlIlll = lllllllllllllIlIIIIIIlIlIlIllIII[lllllllllllllIlIIIIIIlIlIlIlIllI];
            if (lllllllllllllIlIIIIIIlIlIlIlIlll != Component.empty()) {
                if (!lllllllllllllIlIIIIIIlIlIlIlIIlI) {
                    this.prepareChildren();
                    lllllllllllllIlIIIIIIlIlIlIlIIlI = true;
                }
                this.children.add(lllllllllllllIlIIIIIIlIlIlIlIlll);
            }
        }
        return (B)this;
    }
    
    @NotNull
    @Override
    public B append(@NotNull final Iterable<? extends ComponentLike> lllllllllllllIlIIIIIIlIlIIllIIlI) {
        boolean lllllllllllllIlIIIIIIlIlIIlIllIl = false;
        for (final ComponentLike lllllllllllllIlIIIIIIlIlIIllIIII : lllllllllllllIlIIIIIIlIlIIllIIlI) {
            final Component lllllllllllllIlIIIIIIlIlIIllIIIl = lllllllllllllIlIIIIIIlIlIIllIIII.asComponent();
            if (lllllllllllllIlIIIIIIlIlIIllIIIl != Component.empty()) {
                if (!lllllllllllllIlIIIIIIlIlIIlIllIl) {
                    this.prepareChildren();
                    lllllllllllllIlIIIIIIlIlIIlIllIl = true;
                }
                this.children.add(lllllllllllllIlIIIIIIlIlIIllIIIl);
            }
        }
        return (B)this;
    }
    
    @NotNull
    @Override
    public B clickEvent(@Nullable final ClickEvent lllllllllllllIlIIIIIIlIIlIllllIl) {
        this.styleBuilder().clickEvent(lllllllllllllIlIIIIIIlIIlIllllIl);
        return (B)this;
    }
    
    protected AbstractComponentBuilder() {
        this.children = Collections.emptyList();
    }
    
    @NotNull
    @Override
    public List<Component> children() {
        return Collections.unmodifiableList((List<? extends Component>)this.children);
    }
    
    @NotNull
    @Override
    public B mapChildrenDeep(@NotNull final Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> lllllllllllllIlIIIIIIlIIllllllIl) {
        if (this.children == Collections.emptyList()) {
            return (B)this;
        }
        final ListIterator<Component> lllllllllllllIlIIIIIIlIIllllIlll = this.children.listIterator();
        while (lllllllllllllIlIIIIIIlIIllllIlll.hasNext()) {
            final Component lllllllllllllIlIIIIIIlIIlllllIll = lllllllllllllIlIIIIIIlIIllllIlll.next();
            if (!(lllllllllllllIlIIIIIIlIIlllllIll instanceof BuildableComponent)) {
                continue;
            }
            final BuildableComponent<?, ?> lllllllllllllIlIIIIIIlIIlllllIlI = (BuildableComponent<?, ?>)lllllllllllllIlIIIIIIlIIllllllIl.apply((BuildableComponent<?, ?>)lllllllllllllIlIIIIIIlIIlllllIll);
            if (lllllllllllllIlIIIIIIlIIlllllIlI.children().isEmpty()) {
                if (lllllllllllllIlIIIIIIlIIlllllIll == lllllllllllllIlIIIIIIlIIlllllIlI) {
                    continue;
                }
                lllllllllllllIlIIIIIIlIIllllIlll.set(lllllllllllllIlIIIIIIlIIlllllIlI);
            }
            else {
                final ComponentBuilder<?, ?> lllllllllllllIlIIIIIIlIIllllllII = (ComponentBuilder<?, ?>)lllllllllllllIlIIIIIIlIIlllllIlI.toBuilder();
                lllllllllllllIlIIIIIIlIIllllllII.mapChildrenDeep(lllllllllllllIlIIIIIIlIIllllllIl);
                lllllllllllllIlIIIIIIlIIllllIlll.set((Component)lllllllllllllIlIIIIIIlIIllllllII.build());
            }
        }
        return (B)this;
    }
}
