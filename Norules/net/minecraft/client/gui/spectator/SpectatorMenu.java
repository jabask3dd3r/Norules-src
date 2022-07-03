package net.minecraft.client.gui.spectator;

import java.util.*;
import net.minecraft.client.gui.spectator.categories.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.text.*;

public class SpectatorMenu
{
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_RIGHT_ENABLED;
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_LEFT;
    private final /* synthetic */ ISpectatorMenuRecipient listener;
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_RIGHT_DISABLED;
    private static final /* synthetic */ ISpectatorMenuObject CLOSE_ITEM;
    private final /* synthetic */ List<SpectatorDetails> previousCategories;
    private /* synthetic */ int selectedSlot;
    private /* synthetic */ ISpectatorMenuView category;
    public static final /* synthetic */ ISpectatorMenuObject EMPTY_SLOT;
    private /* synthetic */ int page;
    
    public ISpectatorMenuObject getSelectedItem() {
        return this.getItem(this.selectedSlot);
    }
    
    public int getSelectedSlot() {
        return this.selectedSlot;
    }
    
    static /* synthetic */ void access$1(final SpectatorMenu llllllllllllllllllIIllIIlllIIIlI, final int llllllllllllllllllIIllIIlllIIIIl) {
        llllllllllllllllllIIllIIlllIIIlI.page = llllllllllllllllllIIllIIlllIIIIl;
    }
    
    public List<ISpectatorMenuObject> getItems() {
        final List<ISpectatorMenuObject> llllllllllllllllllIIllIlIIIIlIIl = (List<ISpectatorMenuObject>)Lists.newArrayList();
        for (int llllllllllllllllllIIllIlIIIIlIII = 0; llllllllllllllllllIIllIlIIIIlIII <= 8; ++llllllllllllllllllIIllIlIIIIlIII) {
            llllllllllllllllllIIllIlIIIIlIIl.add(this.getItem(llllllllllllllllllIIllIlIIIIlIII));
        }
        return llllllllllllllllllIIllIlIIIIlIIl;
    }
    
    public ISpectatorMenuObject getItem(final int llllllllllllllllllIIllIlIIIlIIlI) {
        final int llllllllllllllllllIIllIlIIIlIIIl = llllllllllllllllllIIllIlIIIlIIlI + this.page * 6;
        if (this.page > 0 && llllllllllllllllllIIllIlIIIlIIlI == 0) {
            return SpectatorMenu.SCROLL_LEFT;
        }
        if (llllllllllllllllllIIllIlIIIlIIlI == 7) {
            return (llllllllllllllllllIIllIlIIIlIIIl < this.category.getItems().size()) ? SpectatorMenu.SCROLL_RIGHT_ENABLED : SpectatorMenu.SCROLL_RIGHT_DISABLED;
        }
        if (llllllllllllllllllIIllIlIIIlIIlI == 8) {
            return SpectatorMenu.CLOSE_ITEM;
        }
        return (ISpectatorMenuObject)((llllllllllllllllllIIllIlIIIlIIIl >= 0 && llllllllllllllllllIIllIlIIIlIIIl < this.category.getItems().size()) ? MoreObjects.firstNonNull((Object)this.category.getItems().get(llllllllllllllllllIIllIlIIIlIIIl), (Object)SpectatorMenu.EMPTY_SLOT) : SpectatorMenu.EMPTY_SLOT);
    }
    
    public SpectatorMenu(final ISpectatorMenuRecipient llllllllllllllllllIIllIlIIIllIIl) {
        this.previousCategories = (List<SpectatorDetails>)Lists.newArrayList();
        this.category = new BaseSpectatorGroup();
        this.selectedSlot = -1;
        this.listener = llllllllllllllllllIIllIlIIIllIIl;
    }
    
    public void exit() {
        this.listener.onSpectatorMenuClosed(this);
    }
    
    public void selectSlot(final int llllllllllllllllllIIllIIlllllIlI) {
        final ISpectatorMenuObject llllllllllllllllllIIllIIlllllIIl = this.getItem(llllllllllllllllllIIllIIlllllIlI);
        if (llllllllllllllllllIIllIIlllllIIl != SpectatorMenu.EMPTY_SLOT) {
            if (this.selectedSlot == llllllllllllllllllIIllIIlllllIlI && llllllllllllllllllIIllIIlllllIIl.isEnabled()) {
                llllllllllllllllllIIllIIlllllIIl.selectItem(this);
            }
            else {
                this.selectedSlot = llllllllllllllllllIIllIIlllllIlI;
            }
        }
    }
    
    static {
        CLOSE_ITEM = new EndSpectatorObject(null);
        SCROLL_LEFT = new MoveMenuObject(-1, true);
        SCROLL_RIGHT_ENABLED = new MoveMenuObject(1, true);
        SCROLL_RIGHT_DISABLED = new MoveMenuObject(1, false);
        EMPTY_SLOT = new ISpectatorMenuObject() {
            @Override
            public ITextComponent getSpectatorName() {
                return new TextComponentString("");
            }
            
            @Override
            public void renderIcon(final float llllllllllllllllllIIIIIIllIIlIII, final int llllllllllllllllllIIIIIIllIIIlll) {
            }
            
            @Override
            public void selectItem(final SpectatorMenu llllllllllllllllllIIIIIIllIIlIll) {
            }
            
            @Override
            public boolean isEnabled() {
                return false;
            }
        };
    }
    
    public SpectatorDetails getCurrentPage() {
        return new SpectatorDetails(this.category, this.getItems(), this.selectedSlot);
    }
    
    public void selectCategory(final ISpectatorMenuView llllllllllllllllllIIllIIlllIlIlI) {
        this.previousCategories.add(this.getCurrentPage());
        this.category = llllllllllllllllllIIllIIlllIlIlI;
        this.selectedSlot = -1;
        this.page = 0;
    }
    
    public ISpectatorMenuView getSelectedCategory() {
        return this.category;
    }
    
    static class EndSpectatorObject implements ISpectatorMenuObject
    {
        @Override
        public boolean isEnabled() {
            return true;
        }
        
        @Override
        public void renderIcon(final float llIllIIIIlllll, final int llIllIIIIllllI) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
            Gui.drawModalRectWithCustomSizedTexture(0.0, 0.0, 128.0f, 0.0f, 16, 16, 256.0f, 256.0f);
        }
        
        @Override
        public void selectItem(final SpectatorMenu llIllIIIlIIIlI) {
            llIllIIIlIIIlI.exit();
        }
        
        @Override
        public ITextComponent getSpectatorName() {
            return new TextComponentTranslation("spectatorMenu.close", new Object[0]);
        }
        
        private EndSpectatorObject() {
        }
    }
    
    static class MoveMenuObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ boolean enabled;
        private final /* synthetic */ int direction;
        
        @Override
        public void selectItem(final SpectatorMenu lllllllllllllIIlIllIlllIllllIlII) {
            SpectatorMenu.access$1(lllllllllllllIIlIllIlllIllllIlII, lllllllllllllIIlIllIlllIllllIlII.page + this.direction);
        }
        
        @Override
        public ITextComponent getSpectatorName() {
            return (this.direction < 0) ? new TextComponentTranslation("spectatorMenu.previous_page", new Object[0]) : new TextComponentTranslation("spectatorMenu.next_page", new Object[0]);
        }
        
        @Override
        public boolean isEnabled() {
            return this.enabled;
        }
        
        @Override
        public void renderIcon(final float lllllllllllllIIlIllIlllIlllIlllI, final int lllllllllllllIIlIllIlllIlllIllIl) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
            if (this.direction < 0) {
                Gui.drawModalRectWithCustomSizedTexture(0.0, 0.0, 144.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            }
            else {
                Gui.drawModalRectWithCustomSizedTexture(0.0, 0.0, 160.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            }
        }
        
        public MoveMenuObject(final int lllllllllllllIIlIllIlllIlllllllI, final boolean lllllllllllllIIlIllIlllIllllllIl) {
            this.direction = lllllllllllllIIlIllIlllIlllllllI;
            this.enabled = lllllllllllllIIlIllIlllIllllllIl;
        }
    }
}
