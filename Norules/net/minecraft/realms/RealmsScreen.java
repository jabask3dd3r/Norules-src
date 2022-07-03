package net.minecraft.realms;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;
import com.mojang.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;

public class RealmsScreen
{
    private final /* synthetic */ GuiScreenRealmsProxy proxy;
    
    public boolean isPauseScreen() {
        return this.proxy.doesGuiPauseGame();
    }
    
    public List<String> fontSplit(final String lllllllllllllIIlIIIlIlIIlllIIllI, final int lllllllllllllIIlIIIlIlIIlllIIlIl) {
        return this.proxy.fontSplit(lllllllllllllIIlIIIlIlIIlllIIllI, lllllllllllllIIlIIIlIlIIlllIIlIl);
    }
    
    public void drawString(final String lllllllllllllIIlIIIlIllIIIIIlIIl, final int lllllllllllllIIlIIIlIllIIIIlIlII, final int lllllllllllllIIlIIIlIllIIIIlIIlI, final int lllllllllllllIIlIIIlIllIIIIlIIII) {
        this.drawString(lllllllllllllIIlIIIlIllIIIIIlIIl, lllllllllllllIIlIIIlIllIIIIlIlII, lllllllllllllIIlIIIlIllIIIIlIIlI, lllllllllllllIIlIIIlIllIIIIlIIII, true);
    }
    
    public void buttonClicked(final RealmsButton lllllllllllllIIlIIIlIlIIlllIIIll) {
    }
    
    public void drawCenteredString(final String lllllllllllllIIlIIIlIllIIIlIllIl, final int lllllllllllllIIlIIIlIllIIIlIIIlI, final int lllllllllllllIIlIIIlIllIIIlIIIII, final int lllllllllllllIIlIIIlIllIIIIllllI) {
        this.proxy.drawCenteredString(lllllllllllllIIlIIIlIllIIIlIllIl, lllllllllllllIIlIIIlIllIIIlIIIlI, lllllllllllllIIlIIIlIllIIIlIIIII, lllllllllllllIIlIIIlIllIIIIllllI);
    }
    
    public static RealmsButton newButton(final int lllllllllllllIIlIIIlIlIIllIlIIII, final int lllllllllllllIIlIIIlIlIIllIIllll, final int lllllllllllllIIlIIIlIlIIllIIlllI, final int lllllllllllllIIlIIIlIlIIllIIIlll, final int lllllllllllllIIlIIIlIlIIllIIllII, final String lllllllllllllIIlIIIlIlIIllIIIlIl) {
        return new RealmsButton(lllllllllllllIIlIIIlIlIIllIlIIII, lllllllllllllIIlIIIlIlIIllIIllll, lllllllllllllIIlIIIlIlIIllIIlllI, lllllllllllllIIlIIIlIlIIllIIIlll, lllllllllllllIIlIIIlIlIIllIIllII, lllllllllllllIIlIIIlIlIIllIIIlIl);
    }
    
    public void init(final Minecraft lllllllllllllIIlIIIlIllIIIllllll, final int lllllllllllllIIlIIIlIllIIIlllllI, final int lllllllllllllIIlIIIlIllIIIllllIl) {
    }
    
    public void renderTooltip(final String lllllllllllllIIlIIIlIlIlIIlIlIlI, final int lllllllllllllIIlIIIlIlIlIIlIlIIl, final int lllllllllllllIIlIIIlIlIlIIlIlIII) {
        this.proxy.drawCreativeTabHoveringText(lllllllllllllIIlIIIlIlIlIIlIlIlI, lllllllllllllIIlIIIlIlIlIIlIlIIl, lllllllllllllIIlIIIlIlIlIIlIlIII);
    }
    
    public void removed() {
    }
    
    public int width() {
        return this.proxy.width;
    }
    
    public RealmsAnvilLevelStorageSource getLevelStorageSource() {
        return new RealmsAnvilLevelStorageSource(Minecraft.getMinecraft().getSaveLoader());
    }
    
    public void keyboardEvent() {
    }
    
    public void render(final int lllllllllllllIIlIIIlIlIlIlIIIIll, final int lllllllllllllIIlIIIlIlIlIlIIIlll, final float lllllllllllllIIlIIIlIlIlIlIIIIIl) {
        for (int lllllllllllllIIlIIIlIlIlIlIIIlIl = 0; lllllllllllllIIlIIIlIlIlIlIIIlIl < this.proxy.buttons().size(); ++lllllllllllllIIlIIIlIlIlIlIIIlIl) {
            this.proxy.buttons().get(lllllllllllllIIlIIIlIlIlIlIIIlIl).render(lllllllllllllIIlIIIlIlIlIlIIIIll, lllllllllllllIIlIIIlIlIlIlIIIlll, lllllllllllllIIlIIIlIlIlIlIIIIIl);
        }
    }
    
    public void mouseClicked(final int lllllllllllllIIlIIIlIlIIlIlIIIIl, final int lllllllllllllIIlIIIlIlIIlIlIIIII, final int lllllllllllllIIlIIIlIlIIlIIlllll) {
    }
    
    public void tick() {
    }
    
    public static String getLocalizedString(final String lllllllllllllIIlIIIlIlIIlIIIlIII, final Object... lllllllllllllIIlIIIlIlIIlIIIIlll) {
        return I18n.format(lllllllllllllIIlIIIlIlIIlIIIlIII, lllllllllllllIIlIIIlIlIIlIIIIlll);
    }
    
    public void fillGradient(final int lllllllllllllIIlIIIlIlIlIllIIIII, final int lllllllllllllIIlIIIlIlIlIlIlllll, final int lllllllllllllIIlIIIlIlIlIlIllllI, final int lllllllllllllIIlIIIlIlIlIlIlllIl, final int lllllllllllllIIlIIIlIlIlIllIIIll, final int lllllllllllllIIlIIIlIlIlIlIllIll) {
        this.proxy.drawGradientRect(lllllllllllllIIlIIIlIlIlIllIIIII, lllllllllllllIIlIIIlIlIlIlIlllll, lllllllllllllIIlIIIlIlIlIlIllllI, lllllllllllllIIlIIIlIlIlIlIlllIl, lllllllllllllIIlIIIlIlIlIllIIIll, lllllllllllllIIlIIIlIlIlIlIllIll);
    }
    
    public static String getLocalizedString(final String lllllllllllllIIlIIIlIlIIlIIIllII) {
        return I18n.format(lllllllllllllIIlIIIlIlIIlIIIllII, new Object[0]);
    }
    
    public void mouseEvent() {
    }
    
    public static void blit(final int lllllllllllllIIlIIIlIlIllIIIIIll, final int lllllllllllllIIlIIIlIlIlIlllIllI, final float lllllllllllllIIlIIIlIlIlIlllIlIl, final float lllllllllllllIIlIIIlIlIlIllllllI, final int lllllllllllllIIlIIIlIlIlIlllllII, final int lllllllllllllIIlIIIlIlIlIlllIIlI, final float lllllllllllllIIlIIIlIlIlIlllIIIl, final float lllllllllllllIIlIIIlIlIlIllllIII) {
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIlIIIlIlIllIIIIIll, lllllllllllllIIlIIIlIlIlIlllIllI, lllllllllllllIIlIIIlIlIlIlllIlIl, lllllllllllllIIlIIIlIlIlIllllllI, lllllllllllllIIlIIIlIlIlIlllllII, lllllllllllllIIlIIIlIlIlIlllIIlI, lllllllllllllIIlIIIlIlIlIlllIIIl, lllllllllllllIIlIIIlIlIlIllllIII);
    }
    
    public void renderTooltip(final ItemStack lllllllllllllIIlIIIlIlIlIIllIllI, final int lllllllllllllIIlIIIlIlIlIIlllIIl, final int lllllllllllllIIlIIIlIlIlIIlllIII) {
        this.proxy.renderToolTip(lllllllllllllIIlIIIlIlIlIIllIllI, lllllllllllllIIlIIIlIlIlIIlllIIl, lllllllllllllIIlIIIlIlIlIIlllIII);
    }
    
    public void renderTooltip(final List<String> lllllllllllllIIlIIIlIlIlIIlIIIlI, final int lllllllllllllIIlIIIlIlIlIIIlllIl, final int lllllllllllllIIlIIIlIlIlIIIlllII) {
        this.proxy.drawHoveringText(lllllllllllllIIlIIIlIlIlIIlIIIlI, lllllllllllllIIlIIIlIlIlIIIlllIl, lllllllllllllIIlIIIlIlIlIIIlllII);
    }
    
    public static void bindFace(final String lllllllllllllIIlIIIlIlIlIIIlIlIl, final String lllllllllllllIIlIIIlIlIlIIIlIlll) {
        ResourceLocation lllllllllllllIIlIIIlIlIlIIIlIllI = AbstractClientPlayer.getLocationSkin(lllllllllllllIIlIIIlIlIlIIIlIlll);
        if (lllllllllllllIIlIIIlIlIlIIIlIllI == null) {
            lllllllllllllIIlIIIlIlIlIIIlIllI = DefaultPlayerSkin.getDefaultSkin(UUIDTypeAdapter.fromString(lllllllllllllIIlIIIlIlIlIIIlIlIl));
        }
        AbstractClientPlayer.getDownloadImageSkin(lllllllllllllIIlIIIlIlIlIIIlIllI, lllllllllllllIIlIIIlIlIlIIIlIlll);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIIlIIIlIlIlIIIlIllI);
    }
    
    public void renderBackground() {
        this.proxy.drawDefaultBackground();
    }
    
    public int height() {
        return this.proxy.height;
    }
    
    public RealmsScreen() {
        this.proxy = new GuiScreenRealmsProxy(this);
    }
    
    public RealmsEditBox newEditBox(final int lllllllllllllIIlIIIlIlIIlIlIIlll, final int lllllllllllllIIlIIIlIlIIlIlIlIll, final int lllllllllllllIIlIIIlIlIIlIlIIlIl, final int lllllllllllllIIlIIIlIlIIlIlIlIIl, final int lllllllllllllIIlIIIlIlIIlIlIIIll) {
        return new RealmsEditBox(lllllllllllllIIlIIIlIlIIlIlIIlll, lllllllllllllIIlIIIlIlIIlIlIlIll, lllllllllllllIIlIIIlIlIIlIlIIlIl, lllllllllllllIIlIIIlIlIIlIlIlIIl, lllllllllllllIIlIIIlIlIIlIlIIIll);
    }
    
    public void mouseDragged(final int lllllllllllllIIlIIIlIlIIlIIlIlll, final int lllllllllllllIIlIIIlIlIIlIIlIllI, final int lllllllllllllIIlIIIlIlIIlIIlIlIl, final long lllllllllllllIIlIIIlIlIIlIIlIlII) {
    }
    
    public void buttonsAdd(final RealmsButton lllllllllllllIIlIIIlIlIIlIlllllI) {
        this.proxy.buttonsAdd(lllllllllllllIIlIIIlIlIIlIlllllI);
    }
    
    public List<RealmsButton> buttons() {
        return this.proxy.buttons();
    }
    
    public int fontLineHeight() {
        return this.proxy.getFontHeight();
    }
    
    public void keyPressed(final char lllllllllllllIIlIIIlIlIIlIIlIIlI, final int lllllllllllllIIlIIIlIlIIlIIlIIIl) {
    }
    
    public int fontWidth(final String lllllllllllllIIlIIIlIlIIllllllIl) {
        return this.proxy.getStringWidth(lllllllllllllIIlIIIlIlIIllllllIl);
    }
    
    public void buttonsClear() {
        this.proxy.buttonsClear();
    }
    
    public void buttonsRemove(final RealmsButton lllllllllllllIIlIIIlIlIIlIllIlIl) {
        this.proxy.buttonsRemove(lllllllllllllIIlIIIlIlIIlIllIlIl);
    }
    
    public void confirmResult(final boolean lllllllllllllIIlIIIlIlIIlIIIllll, final int lllllllllllllIIlIIIlIlIIlIIIlllI) {
    }
    
    public GuiScreenRealmsProxy getProxy() {
        return this.proxy;
    }
    
    static {
        SKIN_TEX_HEIGHT = 64;
        SKIN_HEAD_V = 8;
        SKIN_HEAD_U = 8;
        SKIN_HEAD_WIDTH = 8;
        SKIN_TEX_WIDTH = 64;
        SKIN_HAT_V = 8;
        SKIN_HAT_U = 40;
        SKIN_HAT_HEIGHT = 8;
        SKIN_HEAD_HEIGHT = 8;
        SKIN_HAT_WIDTH = 8;
    }
    
    public void mouseReleased(final int lllllllllllllIIlIIIlIlIIlIIllIll, final int lllllllllllllIIlIIIlIlIIlIIllIlI, final int lllllllllllllIIlIIIlIlIIlIIllIIl) {
    }
    
    public void blit(final int lllllllllllllIIlIIIlIlIllllIIIll, final int lllllllllllllIIlIIIlIlIllllIIIIl, final int lllllllllllllIIlIIIlIlIlllIlIlII, final int lllllllllllllIIlIIIlIlIlllIlIIlI, final int lllllllllllllIIlIIIlIlIlllIlIIII, final int lllllllllllllIIlIIIlIlIlllIllIII) {
        this.proxy.drawTexturedModalRect(lllllllllllllIIlIIIlIlIllllIIIll, lllllllllllllIIlIIIlIlIllllIIIIl, lllllllllllllIIlIIIlIlIlllIlIlII, lllllllllllllIIlIIIlIlIlllIlIIlI, lllllllllllllIIlIIIlIlIlllIlIIII, lllllllllllllIIlIIIlIlIlllIllIII);
    }
    
    public void drawString(final String lllllllllllllIIlIIIlIlIllllllIll, final int lllllllllllllIIlIIIlIlIlllllIIlI, final int lllllllllllllIIlIIIlIlIlllllIIIl, final int lllllllllllllIIlIIIlIlIlllllIIII, final boolean lllllllllllllIIlIIIlIlIlllllIlIl) {
        this.proxy.drawString(lllllllllllllIIlIIIlIlIllllllIll, lllllllllllllIIlIIIlIlIlllllIIlI, lllllllllllllIIlIIIlIlIlllllIIIl, lllllllllllllIIlIIIlIlIlllllIIII, false);
    }
    
    public static RealmsButton newButton(final int lllllllllllllIIlIIIlIlIIllIllllI, final int lllllllllllllIIlIIIlIlIIllIllIIl, final int lllllllllllllIIlIIIlIlIIllIllIII, final String lllllllllllllIIlIIIlIlIIllIllIll) {
        return new RealmsButton(lllllllllllllIIlIIIlIlIIllIllllI, lllllllllllllIIlIIIlIlIIllIllIIl, lllllllllllllIIlIIIlIlIIllIllIII, lllllllllllllIIlIIIlIlIIllIllIll);
    }
    
    public void renderBackground(final int lllllllllllllIIlIIIlIlIlIlIIllll) {
        this.proxy.drawWorldBackground(lllllllllllllIIlIIIlIlIlIlIIllll);
    }
    
    public static void blit(final int lllllllllllllIIlIIIlIlIllIllIlII, final int lllllllllllllIIlIIIlIlIllIlIIIlI, final float lllllllllllllIIlIIIlIlIllIlIIIII, final float lllllllllllllIIlIIIlIlIllIllIIII, final int lllllllllllllIIlIIIlIlIllIIlllIl, final int lllllllllllllIIlIIIlIlIllIIllIll, final int lllllllllllllIIlIIIlIlIllIIllIlI, final int lllllllllllllIIlIIIlIlIllIlIlIII, final float lllllllllllllIIlIIIlIlIllIIlIlll, final float lllllllllllllIIlIIIlIlIllIlIIlII) {
        Gui.drawScaledCustomSizeModalRect(lllllllllllllIIlIIIlIlIllIllIlII, lllllllllllllIIlIIIlIlIllIlIIIlI, lllllllllllllIIlIIIlIlIllIlIIIII, lllllllllllllIIlIIIlIlIllIllIIII, lllllllllllllIIlIIIlIlIllIIlllIl, lllllllllllllIIlIIIlIlIllIIllIll, lllllllllllllIIlIIIlIlIllIIllIlI, lllllllllllllIIlIIIlIlIllIlIlIII, lllllllllllllIIlIIIlIlIllIIlIlll, lllllllllllllIIlIIIlIlIllIlIIlII);
    }
    
    public void fontDrawShadow(final String lllllllllllllIIlIIIlIlIIllllIllI, final int lllllllllllllIIlIIIlIlIIllllIIII, final int lllllllllllllIIlIIIlIlIIlllIllll, final int lllllllllllllIIlIIIlIlIIlllIlllI) {
        this.proxy.fontDrawShadow(lllllllllllllIIlIIIlIlIIllllIllI, lllllllllllllIIlIIIlIlIIllllIIII, lllllllllllllIIlIIIlIlIIlllIllll, lllllllllllllIIlIIIlIlIIlllIlllI);
    }
    
    public void init() {
    }
    
    public static void bind(final String lllllllllllllIIlIIIlIlIlIIIlIIII) {
        final ResourceLocation lllllllllllllIIlIIIlIlIlIIIIllll = new ResourceLocation(lllllllllllllIIlIIIlIlIlIIIlIIII);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIIlIIIlIlIlIIIIllll);
    }
}
