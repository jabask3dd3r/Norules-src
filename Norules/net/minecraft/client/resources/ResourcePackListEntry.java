package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;

public abstract class ResourcePackListEntry implements GuiListExtended.IGuiListEntry
{
    private static final /* synthetic */ ITextComponent INCOMPATIBLE_OLD;
    protected final /* synthetic */ GuiScreenResourcePacks resourcePacksGUI;
    private static final /* synthetic */ ResourceLocation RESOURCE_PACKS_TEXTURE;
    private static final /* synthetic */ ITextComponent INCOMPATIBLE;
    protected final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ITextComponent INCOMPATIBLE_NEW;
    
    @Override
    public void func_192633_a(final int lllllllllllllIlIIlllIIIIlIIIIllI, final int lllllllllllllIlIIlllIIIIlIIIIlIl, final int lllllllllllllIlIIlllIIIIlIIIIlII, final float lllllllllllllIlIIlllIIIIlIIIIIll) {
    }
    
    public ResourcePackListEntry(final GuiScreenResourcePacks lllllllllllllIlIIlllIIIIlllIlllI) {
        this.resourcePacksGUI = lllllllllllllIlIIlllIIIIlllIlllI;
        this.mc = Minecraft.getMinecraft();
    }
    
    protected boolean showHoverOverlay() {
        return true;
    }
    
    protected boolean canMoveLeft() {
        return this.resourcePacksGUI.hasResourcePackEntry(this);
    }
    
    protected boolean canMoveDown() {
        final List<ResourcePackListEntry> lllllllllllllIlIIlllIIIIlIlIlIIl = this.resourcePacksGUI.getListContaining(this);
        final int lllllllllllllIlIIlllIIIIlIlIlIII = lllllllllllllIlIIlllIIIIlIlIlIIl.indexOf(this);
        return lllllllllllllIlIIlllIIIIlIlIlIII >= 0 && lllllllllllllIlIIlllIIIIlIlIlIII < lllllllllllllIlIIlllIIIIlIlIlIIl.size() - 1 && lllllllllllllIlIIlllIIIIlIlIlIIl.get(lllllllllllllIlIIlllIIIIlIlIlIII + 1).showHoverOverlay();
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllllIlIIlllIIIIlIIlllII, final int lllllllllllllIlIIlllIIIIlIIllIll, final int lllllllllllllIlIIlllIIIIlIIllIlI, final int lllllllllllllIlIIlllIIIIlIIllIIl, final int lllllllllllllIlIIlllIIIIlIIIllIl, final int lllllllllllllIlIIlllIIIIlIIIllII) {
        if (this.showHoverOverlay() && lllllllllllllIlIIlllIIIIlIIIllIl <= 32) {
            if (this.canMoveRight()) {
                this.resourcePacksGUI.markChanged();
                final int lllllllllllllIlIIlllIIIIlIIlIllI = this.resourcePacksGUI.getSelectedResourcePacks().get(0).isServerPack() ? 1 : 0;
                final int lllllllllllllIlIIlllIIIIlIIlIlIl = this.getResourcePackFormat();
                if (lllllllllllllIlIIlllIIIIlIIlIlIl == 3) {
                    this.resourcePacksGUI.getListContaining(this).remove(this);
                    this.resourcePacksGUI.getSelectedResourcePacks().add(lllllllllllllIlIIlllIIIIlIIlIllI, this);
                }
                else {
                    final String lllllllllllllIlIIlllIIIIlIIlIlII = I18n.format("resourcePack.incompatible.confirm.title", new Object[0]);
                    final String lllllllllllllIlIIlllIIIIlIIlIIll = I18n.format(String.valueOf(new StringBuilder("resourcePack.incompatible.confirm.").append((lllllllllllllIlIIlllIIIIlIIlIlIl > 3) ? "new" : "old")), new Object[0]);
                    this.mc.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                        @Override
                        public void confirmClicked(final boolean llllllllllllllIlIllIlIIlIllllIlI, final int llllllllllllllIlIllIlIIlIllllIIl) {
                            final List<ResourcePackListEntry> llllllllllllllIlIllIlIIlIllllIII = ResourcePackListEntry.this.resourcePacksGUI.getListContaining(ResourcePackListEntry.this);
                            ResourcePackListEntry.this.mc.displayGuiScreen(ResourcePackListEntry.this.resourcePacksGUI);
                            if (llllllllllllllIlIllIlIIlIllllIlI) {
                                llllllllllllllIlIllIlIIlIllllIII.remove(ResourcePackListEntry.this);
                                ResourcePackListEntry.this.resourcePacksGUI.getSelectedResourcePacks().add(lllllllllllllIlIIlllIIIIlIIlIllI, ResourcePackListEntry.this);
                            }
                        }
                    }, lllllllllllllIlIIlllIIIIlIIlIlII, lllllllllllllIlIIlllIIIIlIIlIIll, 0));
                }
                return true;
            }
            if (lllllllllllllIlIIlllIIIIlIIIllIl < 16 && this.canMoveLeft()) {
                this.resourcePacksGUI.getListContaining(this).remove(this);
                this.resourcePacksGUI.getAvailableResourcePacks().add(0, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
            if (lllllllllllllIlIIlllIIIIlIIIllIl > 16 && lllllllllllllIlIIlllIIIIlIIIllII < 16 && this.canMoveUp()) {
                final List<ResourcePackListEntry> lllllllllllllIlIIlllIIIIlIIlIIlI = this.resourcePacksGUI.getListContaining(this);
                final int lllllllllllllIlIIlllIIIIlIIlIIIl = lllllllllllllIlIIlllIIIIlIIlIIlI.indexOf(this);
                lllllllllllllIlIIlllIIIIlIIlIIlI.remove(this);
                lllllllllllllIlIIlllIIIIlIIlIIlI.add(lllllllllllllIlIIlllIIIIlIIlIIIl - 1, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
            if (lllllllllllllIlIIlllIIIIlIIIllIl > 16 && lllllllllllllIlIIlllIIIIlIIIllII > 16 && this.canMoveDown()) {
                final List<ResourcePackListEntry> lllllllllllllIlIIlllIIIIlIIlIIII = this.resourcePacksGUI.getListContaining(this);
                final int lllllllllllllIlIIlllIIIIlIIIllll = lllllllllllllIlIIlllIIIIlIIlIIII.indexOf(this);
                lllllllllllllIlIIlllIIIIlIIlIIII.remove(this);
                lllllllllllllIlIIlllIIIIlIIlIIII.add(lllllllllllllIlIIlllIIIIlIIIllll + 1, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
        }
        return false;
    }
    
    protected abstract String getResourcePackName();
    
    protected abstract void bindResourcePackIcon();
    
    protected abstract String getResourcePackDescription();
    
    protected boolean canMoveRight() {
        return !this.resourcePacksGUI.hasResourcePackEntry(this);
    }
    
    protected boolean canMoveUp() {
        final List<ResourcePackListEntry> lllllllllllllIlIIlllIIIIlIllIIlI = this.resourcePacksGUI.getListContaining(this);
        final int lllllllllllllIlIIlllIIIIlIllIIIl = lllllllllllllIlIIlllIIIIlIllIIlI.indexOf(this);
        return lllllllllllllIlIIlllIIIIlIllIIIl > 0 && lllllllllllllIlIIlllIIIIlIllIIlI.get(lllllllllllllIlIIlllIIIIlIllIIIl - 1).showHoverOverlay();
    }
    
    public boolean isServerPack() {
        return false;
    }
    
    static {
        RESOURCE_PACKS_TEXTURE = new ResourceLocation("textures/gui/resource_packs.png");
        INCOMPATIBLE = new TextComponentTranslation("resourcePack.incompatible", new Object[0]);
        INCOMPATIBLE_OLD = new TextComponentTranslation("resourcePack.incompatible.old", new Object[0]);
        INCOMPATIBLE_NEW = new TextComponentTranslation("resourcePack.incompatible.new", new Object[0]);
    }
    
    protected abstract int getResourcePackFormat();
    
    @Override
    public void func_192634_a(final int lllllllllllllIlIIlllIIIIllIlllII, final int lllllllllllllIlIIlllIIIIllIllIll, final int lllllllllllllIlIIlllIIIIllIIlIIl, final int lllllllllllllIlIIlllIIIIllIIlIII, final int lllllllllllllIlIIlllIIIIllIllIII, final int lllllllllllllIlIIlllIIIIllIIIllI, final int lllllllllllllIlIIlllIIIIllIIIlIl, final boolean lllllllllllllIlIIlllIIIIllIlIlIl, final float lllllllllllllIlIIlllIIIIllIlIlII) {
        final int lllllllllllllIlIIlllIIIIllIlIIll = this.getResourcePackFormat();
        if (lllllllllllllIlIIlllIIIIllIlIIll != 3) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Gui.drawRect(lllllllllllllIlIIlllIIIIllIllIll - 1, lllllllllllllIlIIlllIIIIllIIlIIl - 1, lllllllllllllIlIIlllIIIIllIllIll + lllllllllllllIlIIlllIIIIllIIlIII - 9, lllllllllllllIlIIlllIIIIllIIlIIl + lllllllllllllIlIIlllIIIIllIllIII + 1, -8978432);
        }
        this.bindResourcePackIcon();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        String lllllllllllllIlIIlllIIIIllIlIIlI = this.getResourcePackName();
        String lllllllllllllIlIIlllIIIIllIlIIIl = this.getResourcePackDescription();
        if (this.showHoverOverlay() && (this.mc.gameSettings.touchscreen || lllllllllllllIlIIlllIIIIllIlIlIl)) {
            this.mc.getTextureManager().bindTexture(ResourcePackListEntry.RESOURCE_PACKS_TEXTURE);
            Gui.drawRect(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, lllllllllllllIlIIlllIIIIllIllIll + 32, lllllllllllllIlIIlllIIIIllIIlIIl + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int lllllllllllllIlIIlllIIIIllIlIIII = lllllllllllllIlIIlllIIIIllIIIllI - lllllllllllllIlIIlllIIIIllIllIll;
            final int lllllllllllllIlIIlllIIIIllIIllll = lllllllllllllIlIIlllIIIIllIIIlIl - lllllllllllllIlIIlllIIIIllIIlIIl;
            if (lllllllllllllIlIIlllIIIIllIlIIll < 3) {
                lllllllllllllIlIIlllIIIIllIlIIlI = ResourcePackListEntry.INCOMPATIBLE.getFormattedText();
                lllllllllllllIlIIlllIIIIllIlIIIl = ResourcePackListEntry.INCOMPATIBLE_OLD.getFormattedText();
            }
            else if (lllllllllllllIlIIlllIIIIllIlIIll > 3) {
                lllllllllllllIlIIlllIIIIllIlIIlI = ResourcePackListEntry.INCOMPATIBLE.getFormattedText();
                lllllllllllllIlIIlllIIIIllIlIIIl = ResourcePackListEntry.INCOMPATIBLE_NEW.getFormattedText();
            }
            if (this.canMoveRight()) {
                if (lllllllllllllIlIIlllIIIIllIlIIII < 32) {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 0.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 0.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            else {
                if (this.canMoveLeft()) {
                    if (lllllllllllllIlIIlllIIIIllIlIIII < 16) {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 32.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 32.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
                if (this.canMoveUp()) {
                    if (lllllllllllllIlIIlllIIIIllIlIIII < 32 && lllllllllllllIlIIlllIIIIllIlIIII > 16 && lllllllllllllIlIIlllIIIIllIIllll < 16) {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 96.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 96.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
                if (this.canMoveDown()) {
                    if (lllllllllllllIlIIlllIIIIllIlIIII < 32 && lllllllllllllIlIIlllIIIIllIlIIII > 16 && lllllllllllllIlIIlllIIIIllIIllll > 16) {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 64.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIlIIlllIIIIllIllIll, lllllllllllllIlIIlllIIIIllIIlIIl, 64.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                    }
                }
            }
        }
        final int lllllllllllllIlIIlllIIIIllIIlllI = this.mc.fontRendererObj.getStringWidth(lllllllllllllIlIIlllIIIIllIlIIlI);
        if (lllllllllllllIlIIlllIIIIllIIlllI > 157) {
            lllllllllllllIlIIlllIIIIllIlIIlI = String.valueOf(new StringBuilder(String.valueOf(this.mc.fontRendererObj.trimStringToWidth(lllllllllllllIlIIlllIIIIllIlIIlI, 157 - this.mc.fontRendererObj.getStringWidth("...")))).append("..."));
        }
        this.mc.fontRendererObj.drawStringWithShadow(lllllllllllllIlIIlllIIIIllIlIIlI, (float)(lllllllllllllIlIIlllIIIIllIllIll + 32 + 2), (float)(lllllllllllllIlIIlllIIIIllIIlIIl + 1), 16777215);
        final List<String> lllllllllllllIlIIlllIIIIllIIllIl = this.mc.fontRendererObj.listFormattedStringToWidth(lllllllllllllIlIIlllIIIIllIlIIIl, 157);
        for (int lllllllllllllIlIIlllIIIIllIIllII = 0; lllllllllllllIlIIlllIIIIllIIllII < 2 && lllllllllllllIlIIlllIIIIllIIllII < lllllllllllllIlIIlllIIIIllIIllIl.size(); ++lllllllllllllIlIIlllIIIIllIIllII) {
            this.mc.fontRendererObj.drawStringWithShadow(lllllllllllllIlIIlllIIIIllIIllIl.get(lllllllllllllIlIIlllIIIIllIIllII), (float)(lllllllllllllIlIIlllIIIIllIllIll + 32 + 2), (float)(lllllllllllllIlIIlllIIIIllIIlIIl + 12 + 10 * lllllllllllllIlIIlllIIIIllIIllII), 8421504);
        }
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIlIIlllIIIIlIIIIIIl, final int lllllllllllllIlIIlllIIIIlIIIIIII, final int lllllllllllllIlIIlllIIIIIlllllll, final int lllllllllllllIlIIlllIIIIIllllllI, final int lllllllllllllIlIIlllIIIIIlllllIl, final int lllllllllllllIlIIlllIIIIIlllllII) {
    }
}
