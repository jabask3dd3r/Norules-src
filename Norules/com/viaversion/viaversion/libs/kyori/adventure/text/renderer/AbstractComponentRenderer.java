package com.viaversion.viaversion.libs.kyori.adventure.text.renderer;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;

public abstract class AbstractComponentRenderer<C> implements ComponentRenderer<C>
{
    @NotNull
    protected abstract Component renderText(@NotNull final TextComponent lllllllllllllIlIIlIlllIlIIIIllII, @NotNull final C lllllllllllllIlIIlIlllIlIIIIlIll);
    
    @NotNull
    protected abstract Component renderStorageNbt(@NotNull final StorageNBTComponent lllllllllllllIlIIlIlllIlIIIlIIll, @NotNull final C lllllllllllllIlIIlIlllIlIIIlIlII);
    
    @NotNull
    protected abstract Component renderSelector(@NotNull final SelectorComponent lllllllllllllIlIIlIlllIlIIIIlllI, @NotNull final C lllllllllllllIlIIlIlllIlIIIIllIl);
    
    @NotNull
    @Override
    public Component render(@NotNull final Component lllllllllllllIlIIlIlllIlIIlIIIII, @NotNull final C lllllllllllllIlIIlIlllIlIIIlllll) {
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof TextComponent) {
            return this.renderText((TextComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
        }
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof TranslatableComponent) {
            return this.renderTranslatable((TranslatableComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
        }
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof KeybindComponent) {
            return this.renderKeybind((KeybindComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
        }
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof ScoreComponent) {
            return this.renderScore((ScoreComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
        }
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof SelectorComponent) {
            return this.renderSelector((SelectorComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
        }
        if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof NBTComponent) {
            if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof BlockNBTComponent) {
                return this.renderBlockNbt((BlockNBTComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
            }
            if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof EntityNBTComponent) {
                return this.renderEntityNbt((EntityNBTComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
            }
            if (lllllllllllllIlIIlIlllIlIIlIIIII instanceof StorageNBTComponent) {
                return this.renderStorageNbt((StorageNBTComponent)lllllllllllllIlIIlIlllIlIIlIIIII, lllllllllllllIlIIlIlllIlIIIlllll);
            }
        }
        return lllllllllllllIlIIlIlllIlIIlIIIII;
    }
    
    @NotNull
    protected abstract Component renderKeybind(@NotNull final KeybindComponent lllllllllllllIlIIlIlllIlIIIlIIIl, @NotNull final C lllllllllllllIlIIlIlllIlIIIlIIlI);
    
    @NotNull
    protected abstract Component renderBlockNbt(@NotNull final BlockNBTComponent lllllllllllllIlIIlIlllIlIIIlIlll, @NotNull final C lllllllllllllIlIIlIlllIlIIIllIII);
    
    @NotNull
    protected abstract Component renderScore(@NotNull final ScoreComponent lllllllllllllIlIIlIlllIlIIIlIIII, @NotNull final C lllllllllllllIlIIlIlllIlIIIIllll);
    
    @NotNull
    protected abstract Component renderEntityNbt(@NotNull final EntityNBTComponent lllllllllllllIlIIlIlllIlIIIlIlIl, @NotNull final C lllllllllllllIlIIlIlllIlIIIlIllI);
    
    @NotNull
    protected abstract Component renderTranslatable(@NotNull final TranslatableComponent lllllllllllllIlIIlIlllIlIIIIlIIl, @NotNull final C lllllllllllllIlIIlIlllIlIIIIlIlI);
}
