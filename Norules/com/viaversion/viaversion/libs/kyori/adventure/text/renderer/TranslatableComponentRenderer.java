package com.viaversion.viaversion.libs.kyori.adventure.text.renderer;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.translation.*;
import java.util.*;
import java.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;

public abstract class TranslatableComponentRenderer<C> extends AbstractComponentRenderer<C>
{
    private static final /* synthetic */ Set<Style.Merge> MERGES;
    
    @NotNull
    @Override
    protected Component renderSelector(@NotNull final SelectorComponent llllllllllllllIlllIIlIIIIlIlIllI, @NotNull final C llllllllllllllIlllIIlIIIIlIllIII) {
        final SelectorComponent.Builder llllllllllllllIlllIIlIIIIlIlIIII = Component.selector().pattern(llllllllllllllIlllIIlIIIIlIlIllI.pattern());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIIlIlIllI, llllllllllllllIlllIIlIIIIlIlIIII, llllllllllllllIlllIIlIIIIlIllIII);
    }
    
    static {
        MERGES = Style.Merge.of(Style.Merge.COLOR, Style.Merge.DECORATIONS, Style.Merge.INSERTION, Style.Merge.FONT);
    }
    
    @NotNull
    @Override
    protected Component renderKeybind(@NotNull final KeybindComponent llllllllllllllIlllIIlIIIlIIIIIIl, @NotNull final C llllllllllllllIlllIIlIIIlIIIIIlI) {
        final KeybindComponent.Builder llllllllllllllIlllIIlIIIIlllllIl = Component.keybind().keybind(llllllllllllllIlllIIlIIIlIIIIIIl.keybind());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIlIIIIIIl, llllllllllllllIlllIIlIIIIlllllIl, llllllllllllllIlllIIlIIIlIIIIIlI);
    }
    
    @Nullable
    protected abstract MessageFormat translate(@NotNull final String llllllllllllllIlllIIlIIIlIlllIlI, @NotNull final C llllllllllllllIlllIIlIIIlIlllIIl);
    
    @NotNull
    public static TranslatableComponentRenderer<Locale> usingTranslationSource(@NotNull final Translator llllllllllllllIlllIIlIIIlIllllIl) {
        Objects.requireNonNull(llllllllllllllIlllIIlIIIlIllllIl, "source");
        return new TranslatableComponentRenderer<Locale>() {
            @Nullable
            @Override
            protected MessageFormat translate(@NotNull final String lllllllllllllIllIllIllIlllllIlIl, @NotNull final Locale lllllllllllllIllIllIllIlllllIlII) {
                return llllllllllllllIlllIIlIIIlIllllIl.translate(lllllllllllllIllIllIllIlllllIlIl, lllllllllllllIllIllIllIlllllIlII);
            }
        };
    }
    
    @NotNull
    @Override
    protected Component renderStorageNbt(@NotNull final StorageNBTComponent llllllllllllllIlllIIlIIIlIIllIII, @NotNull final C llllllllllllllIlllIIlIIIlIIlIlll) {
        final StorageNBTComponent.Builder llllllllllllllIlllIIlIIIlIIlIIll = nbt(Component.storageNBT(), llllllllllllllIlllIIlIIIlIIllIII).storage(llllllllllllllIlllIIlIIIlIIllIII.storage());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIlIIllIII, llllllllllllllIlllIIlIIIlIIlIIll, llllllllllllllIlllIIlIIIlIIlIlll);
    }
    
    protected <O extends BuildableComponent<O, B>, B extends ComponentBuilder<O, B>> O optionallyRenderChildrenAppendAndBuild(final List<Component> llllllllllllllIlllIIIllllllllIIl, final B llllllllllllllIlllIIIllllllllIll, final C llllllllllllllIlllIIIllllllllIlI) {
        if (!llllllllllllllIlllIIIllllllllIIl.isEmpty()) {
            llllllllllllllIlllIIIllllllllIIl.forEach(llllllllllllllIlllIIIlllllIlIIll -> llllllllllllllIlllIIIllllllllIll.append(this.render(llllllllllllllIlllIIIlllllIlIIll, llllllllllllllIlllIIIllllllllIlI)));
        }
        return ((ComponentBuilder<O, B>)llllllllllllllIlllIIIllllllllIll).build();
    }
    
    @NotNull
    @Override
    protected Component renderScore(@NotNull final ScoreComponent llllllllllllllIlllIIlIIIIllIlllI, @NotNull final C llllllllllllllIlllIIlIIIIllIllIl) {
        final ScoreComponent.Builder llllllllllllllIlllIIlIIIIllIlIII = Component.score().name(llllllllllllllIlllIIlIIIIllIlllI.name()).objective(llllllllllllllIlllIIlIIIIllIlllI.objective()).value(llllllllllllllIlllIIlIIIIllIlllI.value());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIIllIlllI, llllllllllllllIlllIIlIIIIllIlIII, llllllllllllllIlllIIlIIIIllIllIl);
    }
    
    protected <O extends BuildableComponent<O, B>, B extends ComponentBuilder<O, B>> O mergeStyleAndOptionallyDeepRender(final Component llllllllllllllIlllIIlIIIIIIIlIIl, final B llllllllllllllIlllIIlIIIIIIIlIII, final C llllllllllllllIlllIIlIIIIIIIlIlI) {
        this.mergeStyle(llllllllllllllIlllIIlIIIIIIIlIIl, llllllllllllllIlllIIlIIIIIIIlIII, llllllllllllllIlllIIlIIIIIIIlIlI);
        return this.optionallyRenderChildrenAppendAndBuild(llllllllllllllIlllIIlIIIIIIIlIIl.children(), llllllllllllllIlllIIlIIIIIIIlIII, llllllllllllllIlllIIlIIIIIIIlIlI);
    }
    
    protected static <C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> B nbt(final B llllllllllllllIlllIIlIIIlIIIllII, final C llllllllllllllIlllIIlIIIlIIIlIll) {
        return ((NBTComponentBuilder<C, NBTComponentBuilder<NBTComponent, B>>)llllllllllllllIlllIIlIIIlIIIllII).nbtPath(llllllllllllllIlllIIlIIIlIIIlIll.nbtPath()).interpret(llllllllllllllIlllIIlIIIlIIIlIll.interpret());
    }
    
    @NotNull
    @Override
    protected Component renderText(@NotNull final TextComponent llllllllllllllIlllIIlIIIIlIIIIII, @NotNull final C llllllllllllllIlllIIlIIIIlIIIIIl) {
        final TextComponent.Builder llllllllllllllIlllIIlIIIIIllllII = Component.text().content(llllllllllllllIlllIIlIIIIlIIIIII.content());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIIlIIIIII, llllllllllllllIlllIIlIIIIIllllII, llllllllllllllIlllIIlIIIIlIIIIIl);
    }
    
    @NotNull
    @Override
    protected Component renderTranslatable(@NotNull final TranslatableComponent llllllllllllllIlllIIlIIIIIlIlIIl, @NotNull final C llllllllllllllIlllIIlIIIIIlIlIlI) {
        final MessageFormat llllllllllllllIlllIIlIIIIIIlllll = this.translate(llllllllllllllIlllIIlIIIIIlIlIIl.key(), llllllllllllllIlllIIlIIIIIlIlIlI);
        if (llllllllllllllIlllIIlIIIIIIlllll == null) {
            final TranslatableComponent.Builder llllllllllllllIlllIIlIIIIIlIIlIl = Component.translatable().key(llllllllllllllIlllIIlIIIIIlIlIIl.key());
            if (!llllllllllllllIlllIIlIIIIIlIlIIl.args().isEmpty()) {
                final List<Component> llllllllllllllIlllIIlIIIIIlIIllI = new ArrayList<Component>(llllllllllllllIlllIIlIIIIIlIlIIl.args());
                for (int llllllllllllllIlllIIlIIIIIlIlIII = 0, llllllllllllllIlllIIlIIIIIlIIlll = llllllllllllllIlllIIlIIIIIlIIllI.size(); llllllllllllllIlllIIlIIIIIlIlIII < llllllllllllllIlllIIlIIIIIlIIlll; ++llllllllllllllIlllIIlIIIIIlIlIII) {
                    llllllllllllllIlllIIlIIIIIlIIllI.set(llllllllllllllIlllIIlIIIIIlIlIII, this.render(llllllllllllllIlllIIlIIIIIlIIllI.get(llllllllllllllIlllIIlIIIIIlIlIII), llllllllllllllIlllIIlIIIIIlIlIlI));
                }
                llllllllllllllIlllIIlIIIIIlIIlIl.args(llllllllllllllIlllIIlIIIIIlIIllI);
            }
            return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIIIlIlIIl, llllllllllllllIlllIIlIIIIIlIIlIl, llllllllllllllIlllIIlIIIIIlIlIlI);
        }
        final List<Component> llllllllllllllIlllIIlIIIIIIllllI = llllllllllllllIlllIIlIIIIIlIlIIl.args();
        final TextComponent.Builder llllllllllllllIlllIIlIIIIIIlllIl = Component.text();
        this.mergeStyle(llllllllllllllIlllIIlIIIIIlIlIIl, llllllllllllllIlllIIlIIIIIIlllIl, llllllllllllllIlllIIlIIIIIlIlIlI);
        if (llllllllllllllIlllIIlIIIIIIllllI.isEmpty()) {
            llllllllllllllIlllIIlIIIIIIlllIl.content(llllllllllllllIlllIIlIIIIIIlllll.format(null, new StringBuffer(), null).toString());
            return this.optionallyRenderChildrenAppendAndBuild(llllllllllllllIlllIIlIIIIIlIlIIl.children(), llllllllllllllIlllIIlIIIIIIlllIl, llllllllllllllIlllIIlIIIIIlIlIlI);
        }
        final Object[] llllllllllllllIlllIIlIIIIIIlllII = new Object[llllllllllllllIlllIIlIIIIIIllllI.size()];
        final StringBuffer llllllllllllllIlllIIlIIIIIIllIll = llllllllllllllIlllIIlIIIIIIlllll.format(llllllllllllllIlllIIlIIIIIIlllII, new StringBuffer(), null);
        final AttributedCharacterIterator llllllllllllllIlllIIlIIIIIIllIlI = llllllllllllllIlllIIlIIIIIIlllll.formatToCharacterIterator(llllllllllllllIlllIIlIIIIIIlllII);
        while (llllllllllllllIlllIIlIIIIIIllIlI.getIndex() < llllllllllllllIlllIIlIIIIIIllIlI.getEndIndex()) {
            final int llllllllllllllIlllIIlIIIIIlIIlII = llllllllllllllIlllIIlIIIIIIllIlI.getRunLimit();
            final Integer llllllllllllllIlllIIlIIIIIlIIIll = (Integer)llllllllllllllIlllIIlIIIIIIllIlI.getAttribute(MessageFormat.Field.ARGUMENT);
            if (llllllllllllllIlllIIlIIIIIlIIIll != null) {
                llllllllllllllIlllIIlIIIIIIlllIl.append(this.render(llllllllllllllIlllIIlIIIIIIllllI.get(llllllllllllllIlllIIlIIIIIlIIIll), llllllllllllllIlllIIlIIIIIlIlIlI));
            }
            else {
                llllllllllllllIlllIIlIIIIIIlllIl.append(Component.text(llllllllllllllIlllIIlIIIIIIllIll.substring(llllllllllllllIlllIIlIIIIIIllIlI.getIndex(), llllllllllllllIlllIIlIIIIIlIIlII)));
            }
            llllllllllllllIlllIIlIIIIIIllIlI.setIndex(llllllllllllllIlllIIlIIIIIlIIlII);
        }
        return this.optionallyRenderChildrenAppendAndBuild(llllllllllllllIlllIIlIIIIIlIlIIl.children(), llllllllllllllIlllIIlIIIIIIlllIl, llllllllllllllIlllIIlIIIIIlIlIlI);
    }
    
    @NotNull
    @Override
    protected Component renderBlockNbt(@NotNull final BlockNBTComponent llllllllllllllIlllIIlIIIlIllIIll, @NotNull final C llllllllllllllIlllIIlIIIlIllIlII) {
        final BlockNBTComponent.Builder llllllllllllllIlllIIlIIIlIlIllll = nbt(Component.blockNBT(), llllllllllllllIlllIIlIIIlIllIIll).pos(llllllllllllllIlllIIlIIIlIllIIll.pos());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIlIllIIll, llllllllllllllIlllIIlIIIlIlIllll, llllllllllllllIlllIIlIIIlIllIlII);
    }
    
    @NotNull
    @Override
    protected Component renderEntityNbt(@NotNull final EntityNBTComponent llllllllllllllIlllIIlIIIlIlIIlIl, @NotNull final C llllllllllllllIlllIIlIIIlIlIIllI) {
        final EntityNBTComponent.Builder llllllllllllllIlllIIlIIIlIlIIIIl = nbt(Component.entityNBT(), llllllllllllllIlllIIlIIIlIlIIlIl).selector(llllllllllllllIlllIIlIIIlIlIIlIl.selector());
        return this.mergeStyleAndOptionallyDeepRender(llllllllllllllIlllIIlIIIlIlIIlIl, llllllllllllllIlllIIlIIIlIlIIIIl, llllllllllllllIlllIIlIIIlIlIIllI);
    }
    
    protected <B extends ComponentBuilder<?, ?>> void mergeStyle(final Component llllllllllllllIlllIIIllllllIlIlI, final B llllllllllllllIlllIIIllllllIlIll, final C llllllllllllllIlllIIIllllllIlIIl) {
        llllllllllllllIlllIIIllllllIlIll.mergeStyle(llllllllllllllIlllIIIllllllIlIlI, TranslatableComponentRenderer.MERGES);
        llllllllllllllIlllIIIllllllIlIll.clickEvent(llllllllllllllIlllIIIllllllIlIlI.clickEvent());
        final HoverEvent<?> llllllllllllllIlllIIIllllllIIlII = llllllllllllllIlllIIIllllllIlIlI.hoverEvent();
        if (llllllllllllllIlllIIIllllllIIlII != null) {
            llllllllllllllIlllIIIllllllIlIll.hoverEvent(llllllllllllllIlllIIIllllllIIlII.withRenderedValue(this, llllllllllllllIlllIIIllllllIlIIl));
        }
    }
}
