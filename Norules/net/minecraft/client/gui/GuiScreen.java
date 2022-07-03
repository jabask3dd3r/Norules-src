package net.minecraft.client.gui;

import com.google.common.base.*;
import net.minecraft.client.*;
import org.apache.commons.lang3.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.nbt.*;
import java.awt.datatransfer.*;
import net.minecraft.util.text.event.*;
import java.net.*;
import java.io.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import org.lwjgl.input.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import java.awt.*;

public abstract class GuiScreen extends Gui implements GuiYesNoCallback
{
    private /* synthetic */ boolean field_193977_u;
    public /* synthetic */ int height;
    protected /* synthetic */ RenderItem itemRender;
    protected /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Set<String> PROTOCOLS;
    private /* synthetic */ URI clickedLinkURI;
    public /* synthetic */ int width;
    protected /* synthetic */ GuiButton selectedButton;
    private /* synthetic */ long lastMouseEvent;
    protected /* synthetic */ List<GuiLabel> labelList;
    private /* synthetic */ int eventButton;
    private /* synthetic */ int touchValue;
    protected /* synthetic */ FontRenderer fontRendererObj;
    protected /* synthetic */ List<GuiButton> buttonList;
    private static final /* synthetic */ Logger LOGGER;
    
    public void drawGrayBackground() {
        this.drawGrayWorldBackground(0);
    }
    
    protected <T extends GuiButton> T addButton(final T llllllllllllllllIlIIIlIlllIlIlII) {
        this.buttonList.add(llllllllllllllllIlIIIlIlllIlIlII);
        return llllllllllllllllIlIIIlIlllIlIlII;
    }
    
    public static void setClipboardString(final String llllllllllllllllIlIIIlIlllIIllII) {
        if (!StringUtils.isEmpty((CharSequence)llllllllllllllllIlIIIlIlllIIllII)) {
            try {
                final StringSelection llllllllllllllllIlIIIlIlllIIlIll = new StringSelection(llllllllllllllllIlIIIlIlllIIllII);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(llllllllllllllllIlIIIlIlllIIlIll, null);
            }
            catch (Exception ex) {}
        }
    }
    
    public void drawHoveringText(final List<String> llllllllllllllllIlIIIlIllIIIllIl, final int llllllllllllllllIlIIIlIllIIIllII, final int llllllllllllllllIlIIIlIlIlllllII) {
        if (!llllllllllllllllIlIIIlIllIIIllIl.isEmpty()) {
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int llllllllllllllllIlIIIlIllIIIlIlI = 0;
            for (final String llllllllllllllllIlIIIlIllIIIlIIl : llllllllllllllllIlIIIlIllIIIllIl) {
                final int llllllllllllllllIlIIIlIllIIIlIII = this.fontRendererObj.getStringWidth(llllllllllllllllIlIIIlIllIIIlIIl);
                if (llllllllllllllllIlIIIlIllIIIlIII > llllllllllllllllIlIIIlIllIIIlIlI) {
                    llllllllllllllllIlIIIlIllIIIlIlI = llllllllllllllllIlIIIlIllIIIlIII;
                }
            }
            int llllllllllllllllIlIIIlIllIIIIlll = llllllllllllllllIlIIIlIllIIIllII + 12;
            int llllllllllllllllIlIIIlIllIIIIllI = llllllllllllllllIlIIIlIlIlllllII - 12;
            int llllllllllllllllIlIIIlIllIIIIlIl = 8;
            if (llllllllllllllllIlIIIlIllIIIllIl.size() > 1) {
                llllllllllllllllIlIIIlIllIIIIlIl += 2 + (llllllllllllllllIlIIIlIllIIIllIl.size() - 1) * 10;
            }
            if (llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI > this.width) {
                llllllllllllllllIlIIIlIllIIIIlll -= 28 + llllllllllllllllIlIIIlIllIIIlIlI;
            }
            if (llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 6 > this.height) {
                llllllllllllllllIlIIIlIllIIIIllI = this.height - llllllllllllllllIlIIIlIllIIIIlIl - 6;
            }
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            final int llllllllllllllllIlIIIlIllIIIIlII = -267386864;
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI - 4, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI - 3, -267386864, -267386864);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 4, -267386864, -267386864);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI - 3, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3, -267386864, -267386864);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 4, llllllllllllllllIlIIIlIllIIIIllI - 3, llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3, -267386864, -267386864);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI - 3, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 4, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3, -267386864, -267386864);
            final int llllllllllllllllIlIIIlIllIIIIIll = 1347420415;
            final int llllllllllllllllIlIIIlIllIIIIIlI = 1344798847;
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI - 3 + 1, llllllllllllllllIlIIIlIllIIIIlll - 3 + 1, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3 - 1, 1347420415, 1344798847);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 2, llllllllllllllllIlIIIlIllIIIIllI - 3 + 1, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3 - 1, 1347420415, 1344798847);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI - 3, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI - 3 + 1, 1347420415, 1347420415);
            this.drawGradientRect(llllllllllllllllIlIIIlIllIIIIlll - 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 2, llllllllllllllllIlIIIlIllIIIIlll + llllllllllllllllIlIIIlIllIIIlIlI + 3, llllllllllllllllIlIIIlIllIIIIllI + llllllllllllllllIlIIIlIllIIIIlIl + 3, 1344798847, 1344798847);
            for (int llllllllllllllllIlIIIlIllIIIIIIl = 0; llllllllllllllllIlIIIlIllIIIIIIl < llllllllllllllllIlIIIlIllIIIllIl.size(); ++llllllllllllllllIlIIIlIllIIIIIIl) {
                final String llllllllllllllllIlIIIlIllIIIIIII = llllllllllllllllIlIIIlIllIIIllIl.get(llllllllllllllllIlIIIlIllIIIIIIl);
                this.fontRendererObj.drawStringWithShadow(llllllllllllllllIlIIIlIllIIIIIII, (float)llllllllllllllllIlIIIlIllIIIIlll, (float)llllllllllllllllIlIIIlIllIIIIllI, -1);
                if (llllllllllllllllIlIIIlIllIIIIIIl == 0) {
                    llllllllllllllllIlIIIlIllIIIIllI += 2;
                }
                llllllllllllllllIlIIIlIllIIIIllI += 10;
            }
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
        }
    }
    
    protected void renderToolTip(final ItemStack llllllllllllllllIlIIIlIlllIIIIll, final int llllllllllllllllIlIIIlIllIlllllI, final int llllllllllllllllIlIIIlIllIllllIl) {
        this.drawHoveringText(this.func_191927_a(llllllllllllllllIlIIIlIlllIIIIll), llllllllllllllllIlIIIlIllIlllllI, llllllllllllllllIlIIIlIllIllllIl);
    }
    
    public boolean func_193976_p() {
        return this.field_193977_u;
    }
    
    protected void handleComponentHover(final ITextComponent llllllllllllllllIlIIIlIlIllIlIIl, final int llllllllllllllllIlIIIlIlIlIlllIl, final int llllllllllllllllIlIIIlIlIllIIlll) {
        if (llllllllllllllllIlIIIlIlIllIlIIl != null && llllllllllllllllIlIIIlIlIllIlIIl.getStyle().getHoverEvent() != null) {
            final HoverEvent llllllllllllllllIlIIIlIlIllIIllI = llllllllllllllllIlIIIlIlIllIlIIl.getStyle().getHoverEvent();
            if (llllllllllllllllIlIIIlIlIllIIllI.getAction() == HoverEvent.Action.SHOW_ITEM) {
                ItemStack llllllllllllllllIlIIIlIlIllIIlIl = ItemStack.field_190927_a;
                try {
                    final NBTBase llllllllllllllllIlIIIlIlIllIIlII = JsonToNBT.getTagFromJson(llllllllllllllllIlIIIlIlIllIIllI.getValue().getUnformattedText());
                    if (llllllllllllllllIlIIIlIlIllIIlII instanceof NBTTagCompound) {
                        llllllllllllllllIlIIIlIlIllIIlIl = new ItemStack((NBTTagCompound)llllllllllllllllIlIIIlIlIllIIlII);
                    }
                }
                catch (NBTException ex) {}
                if (llllllllllllllllIlIIIlIlIllIIlIl.func_190926_b()) {
                    this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(TextFormatting.RED).append("Invalid Item!")), llllllllllllllllIlIIIlIlIlIlllIl, llllllllllllllllIlIIIlIlIllIIlll);
                }
                else {
                    this.renderToolTip(llllllllllllllllIlIIIlIlIllIIlIl, llllllllllllllllIlIIIlIlIlIlllIl, llllllllllllllllIlIIIlIlIllIIlll);
                }
            }
            else if (llllllllllllllllIlIIIlIlIllIIllI.getAction() == HoverEvent.Action.SHOW_ENTITY) {
                if (this.mc.gameSettings.advancedItemTooltips) {
                    try {
                        final NBTTagCompound llllllllllllllllIlIIIlIlIllIIIll = JsonToNBT.getTagFromJson(llllllllllllllllIlIIIlIlIllIIllI.getValue().getUnformattedText());
                        final List<String> llllllllllllllllIlIIIlIlIllIIIlI = (List<String>)Lists.newArrayList();
                        llllllllllllllllIlIIIlIlIllIIIlI.add(llllllllllllllllIlIIIlIlIllIIIll.getString("name"));
                        if (llllllllllllllllIlIIIlIlIllIIIll.hasKey("type", 8)) {
                            final String llllllllllllllllIlIIIlIlIllIIIIl = llllllllllllllllIlIIIlIlIllIIIll.getString("type");
                            llllllllllllllllIlIIIlIlIllIIIlI.add(String.valueOf(new StringBuilder("Type: ").append(llllllllllllllllIlIIIlIlIllIIIIl)));
                        }
                        llllllllllllllllIlIIIlIlIllIIIlI.add(llllllllllllllllIlIIIlIlIllIIIll.getString("id"));
                        this.drawHoveringText(llllllllllllllllIlIIIlIlIllIIIlI, llllllllllllllllIlIIIlIlIlIlllIl, llllllllllllllllIlIIIlIlIllIIlll);
                    }
                    catch (NBTException llllllllllllllllIlIIIlIlIllIIIII) {
                        this.drawCreativeTabHoveringText(String.valueOf(new StringBuilder().append(TextFormatting.RED).append("Invalid Entity!")), llllllllllllllllIlIIIlIlIlIlllIl, llllllllllllllllIlIIIlIlIllIIlll);
                    }
                }
            }
            else if (llllllllllllllllIlIIIlIlIllIIllI.getAction() == HoverEvent.Action.SHOW_TEXT) {
                this.drawHoveringText(this.mc.fontRendererObj.listFormattedStringToWidth(llllllllllllllllIlIIIlIlIllIIllI.getValue().getFormattedText(), Math.max(this.width / 2, 200)), llllllllllllllllIlIIIlIlIlIlllIl, llllllllllllllllIlIIIlIlIllIIlll);
            }
            GlStateManager.disableLighting();
        }
    }
    
    public static String getClipboardString() {
        try {
            final Transferable llllllllllllllllIlIIIlIlllIlIIII = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (llllllllllllllllIlIIIlIlllIlIIII != null && llllllllllllllllIlIIIlIlllIlIIII.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)llllllllllllllllIlIIIlIlllIlIIII.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception ex) {}
        return "";
    }
    
    public void setWorldAndResolution(final Minecraft llllllllllllllllIlIIIlIlIIIIIllI, final int llllllllllllllllIlIIIlIlIIIIIlIl, final int llllllllllllllllIlIIIlIlIIIIIlII) {
        this.mc = llllllllllllllllIlIIIlIlIIIIIllI;
        this.itemRender = llllllllllllllllIlIIIlIlIIIIIllI.getRenderItem();
        this.fontRendererObj = llllllllllllllllIlIIIlIlIIIIIllI.fontRendererObj;
        this.width = llllllllllllllllIlIIIlIlIIIIIlIl;
        this.height = llllllllllllllllIlIIIlIlIIIIIlII;
        this.buttonList.clear();
        this.initGui();
    }
    
    protected void keyTyped(final char llllllllllllllllIlIIIlIlllIllIll, final int llllllllllllllllIlIIIlIlllIllIlI) throws IOException {
        if (llllllllllllllllIlIIIlIlllIllIlI == 1) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null) {
                this.mc.setIngameFocus();
            }
        }
    }
    
    public void drawWorldBackground(final int llllllllllllllllIlIIIlIIllIIlllI) {
        if (this.mc.world != null) {
            this.drawGradientRect(0.0, 0.0, this.width, this.height, -1072689136, -804253680);
        }
        else {
            this.drawBackground(llllllllllllllllIlIIIlIIllIIlllI);
        }
    }
    
    public void handleKeyboardInput() throws IOException {
        final char llllllllllllllllIlIIIlIIlllIIlII = Keyboard.getEventCharacter();
        if ((Keyboard.getEventKey() == 0 && llllllllllllllllIlIIIlIIlllIIlII >= ' ') || Keyboard.getEventKeyState()) {
            this.keyTyped(llllllllllllllllIlIIIlIIlllIIlII, Keyboard.getEventKey());
        }
        this.mc.dispatchKeypresses();
    }
    
    protected void actionPerformed(final GuiButton llllllllllllllllIlIIIlIlIIIlIIII) throws IOException {
    }
    
    public void initGui() {
    }
    
    public boolean handleComponentClick(final ITextComponent llllllllllllllllIlIIIlIlIlIIIlll) {
        if (llllllllllllllllIlIIIlIlIlIIIlll == null) {
            return false;
        }
        final ClickEvent llllllllllllllllIlIIIlIlIlIIllIl = llllllllllllllllIlIIIlIlIlIIIlll.getStyle().getClickEvent();
        if (isShiftKeyDown()) {
            if (llllllllllllllllIlIIIlIlIlIIIlll.getStyle().getInsertion() != null) {
                this.setText(llllllllllllllllIlIIIlIlIlIIIlll.getStyle().getInsertion(), false);
            }
        }
        else if (llllllllllllllllIlIIIlIlIlIIllIl != null) {
            if (llllllllllllllllIlIIIlIlIlIIllIl.getAction() == ClickEvent.Action.OPEN_URL) {
                if (!this.mc.gameSettings.chatLinks) {
                    return false;
                }
                try {
                    final URI llllllllllllllllIlIIIlIlIlIIllII = new URI(llllllllllllllllIlIIIlIlIlIIllIl.getValue());
                    final String llllllllllllllllIlIIIlIlIlIIlIll = llllllllllllllllIlIIIlIlIlIIllII.getScheme();
                    if (llllllllllllllllIlIIIlIlIlIIlIll == null) {
                        throw new URISyntaxException(llllllllllllllllIlIIIlIlIlIIllIl.getValue(), "Missing protocol");
                    }
                    if (!GuiScreen.PROTOCOLS.contains(llllllllllllllllIlIIIlIlIlIIlIll.toLowerCase(Locale.ROOT))) {
                        throw new URISyntaxException(llllllllllllllllIlIIIlIlIlIIllIl.getValue(), String.valueOf(new StringBuilder("Unsupported protocol: ").append(llllllllllllllllIlIIIlIlIlIIlIll.toLowerCase(Locale.ROOT))));
                    }
                    if (this.mc.gameSettings.chatLinksPrompt) {
                        this.clickedLinkURI = llllllllllllllllIlIIIlIlIlIIllII;
                        this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, llllllllllllllllIlIIIlIlIlIIllIl.getValue(), 31102009, false));
                    }
                    else {
                        this.openWebLink(llllllllllllllllIlIIIlIlIlIIllII);
                    }
                }
                catch (URISyntaxException llllllllllllllllIlIIIlIlIlIIlIlI) {
                    GuiScreen.LOGGER.error("Can't open url for {}", (Object)llllllllllllllllIlIIIlIlIlIIllIl, (Object)llllllllllllllllIlIIIlIlIlIIlIlI);
                }
            }
            else if (llllllllllllllllIlIIIlIlIlIIllIl.getAction() == ClickEvent.Action.OPEN_FILE) {
                final URI llllllllllllllllIlIIIlIlIlIIlIIl = new File(llllllllllllllllIlIIIlIlIlIIllIl.getValue()).toURI();
                this.openWebLink(llllllllllllllllIlIIIlIlIlIIlIIl);
            }
            else if (llllllllllllllllIlIIIlIlIlIIllIl.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
                this.setText(llllllllllllllllIlIIIlIlIlIIllIl.getValue(), true);
            }
            else if (llllllllllllllllIlIIIlIlIlIIllIl.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.sendChatMessage(llllllllllllllllIlIIIlIlIlIIllIl.getValue(), false);
            }
            else {
                GuiScreen.LOGGER.error("Don't know how to handle {}", (Object)llllllllllllllllIlIIIlIlIlIIllIl);
            }
            return true;
        }
        return false;
    }
    
    public void func_193975_a(final boolean llllllllllllllllIlIIIlIllIlIIIIl) {
        this.field_193977_u = llllllllllllllllIlIIIlIllIlIIIIl;
    }
    
    public static boolean isCtrlKeyDown() {
        if (Minecraft.IS_RUNNING_ON_MAC) {
            return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
        }
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }
    
    private void openWebLink(final URI llllllllllllllllIlIIIlIIlIlIlIll) {
        try {
            final Class<?> llllllllllllllllIlIIIlIIlIlIllll = Class.forName("java.awt.Desktop");
            final Object llllllllllllllllIlIIIlIIlIlIlllI = llllllllllllllllIlIIIlIIlIlIllll.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            llllllllllllllllIlIIIlIIlIlIllll.getMethod("browse", URI.class).invoke(llllllllllllllllIlIIIlIIlIlIlllI, llllllllllllllllIlIIIlIIlIlIlIll);
        }
        catch (Throwable llllllllllllllllIlIIIlIIlIlIllIl) {
            final Throwable llllllllllllllllIlIIIlIIlIlIllII = llllllllllllllllIlIIIlIIlIlIllIl.getCause();
            GuiScreen.LOGGER.error("Couldn't open link: {}", (Object)((llllllllllllllllIlIIIlIIlIlIllII == null) ? "<UNKNOWN>" : llllllllllllllllIlIIIlIIlIlIllII.getMessage()));
        }
    }
    
    public static boolean isKeyComboCtrlC(final int llllllllllllllllIlIIIlIIlIlIIIII) {
        return llllllllllllllllIlIIIlIIlIlIIIII == 46 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    public List<String> func_191927_a(final ItemStack llllllllllllllllIlIIIlIllIllIIll) {
        final List<String> llllllllllllllllIlIIIlIllIllIllI = llllllllllllllllIlIIIlIllIllIIll.getTooltip(this.mc.player, this.mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
        for (int llllllllllllllllIlIIIlIllIllIlIl = 0; llllllllllllllllIlIIIlIllIllIlIl < llllllllllllllllIlIIIlIllIllIllI.size(); ++llllllllllllllllIlIIIlIllIllIlIl) {
            if (llllllllllllllllIlIIIlIllIllIlIl == 0) {
                llllllllllllllllIlIIIlIllIllIllI.set(llllllllllllllllIlIIIlIllIllIlIl, String.valueOf(new StringBuilder().append(llllllllllllllllIlIIIlIllIllIIll.getRarity().rarityColor).append(llllllllllllllllIlIIIlIllIllIllI.get(llllllllllllllllIlIIIlIllIllIlIl))));
            }
            else {
                llllllllllllllllIlIIIlIllIllIllI.set(llllllllllllllllIlIIIlIllIllIlIl, String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(llllllllllllllllIlIIIlIllIllIllI.get(llllllllllllllllIlIIIlIllIllIlIl))));
            }
        }
        return llllllllllllllllIlIIIlIllIllIllI;
    }
    
    public void setGuiSize(final int llllllllllllllllIlIIIlIIllllllll, final int llllllllllllllllIlIIIlIIlllllIll) {
        this.width = llllllllllllllllIlIIIlIIllllllll;
        this.height = llllllllllllllllIlIIIlIIlllllIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        PROTOCOLS = Sets.newHashSet((Object[])new String[] { "http", "https" });
        NEWLINE_SPLITTER = Splitter.on('\n');
    }
    
    public void updateScreen() {
    }
    
    public void handleInput() throws IOException {
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                this.handleMouseInput();
            }
        }
        if (Keyboard.isCreated()) {
            while (Keyboard.next()) {
                this.handleKeyboardInput();
            }
        }
    }
    
    public void drawBackground(final int llllllllllllllllIlIIIlIIllIIIlll) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        final Tessellator llllllllllllllllIlIIIlIIllIIIllI = Tessellator.getInstance();
        final BufferBuilder llllllllllllllllIlIIIlIIllIIIlIl = llllllllllllllllIlIIIlIIllIIIllI.getBuffer();
        this.mc.getTextureManager().bindTexture(GuiScreen.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllllllIlIIIlIIllIIIlII = 32.0f;
        llllllllllllllllIlIIIlIIllIIIlIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllllllIlIIIlIIllIIIlIl.pos(0.0, this.height, 0.0).tex(0.0, this.height / 32.0f + llllllllllllllllIlIIIlIIllIIIlll).color(64, 64, 64, 255).endVertex();
        llllllllllllllllIlIIIlIIllIIIlIl.pos(this.width, this.height, 0.0).tex(this.width / 32.0f, this.height / 32.0f + llllllllllllllllIlIIIlIIllIIIlll).color(64, 64, 64, 255).endVertex();
        llllllllllllllllIlIIIlIIllIIIlIl.pos(this.width, 0.0, 0.0).tex(this.width / 32.0f, llllllllllllllllIlIIIlIIllIIIlll).color(64, 64, 64, 255).endVertex();
        llllllllllllllllIlIIIlIIllIIIlIl.pos(0.0, 0.0, 0.0).tex(0.0, llllllllllllllllIlIIIlIIllIIIlll).color(64, 64, 64, 255).endVertex();
        llllllllllllllllIlIIIlIIllIIIllI.draw();
    }
    
    public GuiScreen() {
        this.buttonList = (List<GuiButton>)Lists.newArrayList();
        this.labelList = (List<GuiLabel>)Lists.newArrayList();
    }
    
    public void onGuiClosed() {
    }
    
    public void drawCreativeTabHoveringText(final String llllllllllllllllIlIIIlIllIlIIlll, final int llllllllllllllllIlIIIlIllIlIIllI, final int llllllllllllllllIlIIIlIllIlIlIIl) {
        this.drawHoveringText(Arrays.asList(llllllllllllllllIlIIIlIllIlIIlll), llllllllllllllllIlIIIlIllIlIIllI, llllllllllllllllIlIIIlIllIlIlIIl);
    }
    
    public void drawGrayWorldBackground(final int llllllllllllllllIlIIIlIIllIllIIl) {
        if (this.mc.world != null) {
            this.drawGradientRect(0.0, 0.0, this.width, this.height, new Color(0, 0, 0, 200).getRGB(), new Color(95, 94, 94, 195).getRGB());
        }
        else {
            this.drawBackground(llllllllllllllllIlIIIlIIllIllIIl);
        }
    }
    
    public void handleMouseInput() throws IOException {
        final int llllllllllllllllIlIIIlIIllllIIII = Mouse.getEventX() * this.width / this.mc.displayWidth;
        final int llllllllllllllllIlIIIlIIlllIllll = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
        final int llllllllllllllllIlIIIlIIlllIlllI = Mouse.getEventButton();
        if (Mouse.getEventButtonState()) {
            if (this.mc.gameSettings.touchscreen && this.touchValue++ > 0) {
                return;
            }
            this.eventButton = llllllllllllllllIlIIIlIIlllIlllI;
            this.lastMouseEvent = Minecraft.getSystemTime();
            this.mouseClicked(llllllllllllllllIlIIIlIIllllIIII, llllllllllllllllIlIIIlIIlllIllll, this.eventButton);
        }
        else if (llllllllllllllllIlIIIlIIlllIlllI != -1) {
            if (this.mc.gameSettings.touchscreen && --this.touchValue > 0) {
                return;
            }
            this.eventButton = -1;
            this.mouseReleased(llllllllllllllllIlIIIlIIllllIIII, llllllllllllllllIlIIIlIIlllIllll, llllllllllllllllIlIIIlIIlllIlllI);
        }
        else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
            final long llllllllllllllllIlIIIlIIlllIllIl = Minecraft.getSystemTime() - this.lastMouseEvent;
            this.mouseClickMove(llllllllllllllllIlIIIlIIllllIIII, llllllllllllllllIlIIIlIIlllIllll, this.eventButton, llllllllllllllllIlIIIlIIlllIllIl);
        }
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllllIlIIIlIIlIlllIIl, final int llllllllllllllllIlIIIlIIlIllIlIl) {
        if (llllllllllllllllIlIIIlIIlIllIlIl == 31102009) {
            if (llllllllllllllllIlIIIlIIlIlllIIl) {
                this.openWebLink(this.clickedLinkURI);
            }
            this.clickedLinkURI = null;
            this.mc.displayGuiScreen(this);
        }
    }
    
    public void sendChatMessage(final String llllllllllllllllIlIIIlIlIIlllllI) {
        this.sendChatMessage(llllllllllllllllIlIIIlIlIIlllllI, true);
    }
    
    public void sendChatMessage(final String llllllllllllllllIlIIIlIlIIllIllI, final boolean llllllllllllllllIlIIIlIlIIllIlIl) {
        if (llllllllllllllllIlIIIlIlIIllIlIl) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(llllllllllllllllIlIIIlIlIIllIllI);
        }
        this.mc.player.sendChatMessage(llllllllllllllllIlIIIlIlIIllIllI);
    }
    
    public static boolean isKeyComboCtrlA(final int llllllllllllllllIlIIIlIIlIIllIlI) {
        return llllllllllllllllIlIIIlIIlIIllIlI == 30 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    public static boolean isKeyComboCtrlX(final int llllllllllllllllIlIIIlIIlIlIIlll) {
        return llllllllllllllllIlIIIlIIlIlIIlll == 45 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    protected void mouseClicked(final int llllllllllllllllIlIIIlIlIIlIllIl, final int llllllllllllllllIlIIIlIlIIlIllII, final int llllllllllllllllIlIIIlIlIIlIIlIl) throws IOException {
        if (llllllllllllllllIlIIIlIlIIlIIlIl == 0) {
            for (int llllllllllllllllIlIIIlIlIIlIlIlI = 0; llllllllllllllllIlIIIlIlIIlIlIlI < this.buttonList.size(); ++llllllllllllllllIlIIIlIlIIlIlIlI) {
                final GuiButton llllllllllllllllIlIIIlIlIIlIlIIl = this.buttonList.get(llllllllllllllllIlIIIlIlIIlIlIlI);
                if (llllllllllllllllIlIIIlIlIIlIlIIl.mousePressed(this.mc, llllllllllllllllIlIIIlIlIIlIllIl, llllllllllllllllIlIIIlIlIIlIllII)) {
                    this.selectedButton = llllllllllllllllIlIIIlIlIIlIlIIl;
                    llllllllllllllllIlIIIlIlIIlIlIIl.playPressSound(this.mc.getSoundHandler());
                    this.actionPerformed(llllllllllllllllIlIIIlIlIIlIlIIl);
                }
            }
        }
    }
    
    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }
    
    protected void mouseClickMove(final int llllllllllllllllIlIIIlIlIIIlIlIl, final int llllllllllllllllIlIIIlIlIIIlIlII, final int llllllllllllllllIlIIIlIlIIIlIIll, final long llllllllllllllllIlIIIlIlIIIlIIlI) {
    }
    
    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    public static boolean isAltKeyDown() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }
    
    public void onResize(final Minecraft llllllllllllllllIlIIIlIIlIIlIIIl, final int llllllllllllllllIlIIIlIIlIIlIIII, final int llllllllllllllllIlIIIlIIlIIIlIlI) {
        this.setWorldAndResolution(llllllllllllllllIlIIIlIIlIIlIIIl, llllllllllllllllIlIIIlIIlIIlIIII, llllllllllllllllIlIIIlIIlIIIlIlI);
    }
    
    protected void setText(final String llllllllllllllllIlIIIlIlIlIlIllI, final boolean llllllllllllllllIlIIIlIlIlIlIlIl) {
    }
    
    public void drawScreen(final int llllllllllllllllIlIIIlIllllIIIIl, final int llllllllllllllllIlIIIlIllllIIllI, final float llllllllllllllllIlIIIlIllllIIlIl) {
        for (int llllllllllllllllIlIIIlIllllIIlII = 0; llllllllllllllllIlIIIlIllllIIlII < this.buttonList.size(); ++llllllllllllllllIlIIIlIllllIIlII) {
            this.buttonList.get(llllllllllllllllIlIIIlIllllIIlII).func_191745_a(this.mc, llllllllllllllllIlIIIlIllllIIIIl, llllllllllllllllIlIIIlIllllIIllI);
        }
        for (int llllllllllllllllIlIIIlIllllIIIll = 0; llllllllllllllllIlIIIlIllllIIIll < this.labelList.size(); ++llllllllllllllllIlIIIlIllllIIIll) {
            this.labelList.get(llllllllllllllllIlIIIlIllllIIIll).drawLabel(this.mc, llllllllllllllllIlIIIlIllllIIIIl, llllllllllllllllIlIIIlIllllIIllI);
        }
    }
    
    protected void mouseReleased(final int llllllllllllllllIlIIIlIlIIIlllIl, final int llllllllllllllllIlIIIlIlIIIllIII, final int llllllllllllllllIlIIIlIlIIIlIlll) {
        if (this.selectedButton != null && llllllllllllllllIlIIIlIlIIIlIlll == 0) {
            this.selectedButton.mouseReleased(llllllllllllllllIlIIIlIlIIIlllIl, llllllllllllllllIlIIIlIlIIIllIII);
            this.selectedButton = null;
        }
    }
    
    public static boolean isKeyComboCtrlV(final int llllllllllllllllIlIIIlIIlIlIIlII) {
        return llllllllllllllllIlIIIlIIlIlIIlII == 47 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
}
