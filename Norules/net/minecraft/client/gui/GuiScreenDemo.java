package net.minecraft.client.gui;

import net.minecraft.util.*;
import java.net.*;
import java.io.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.renderer.*;

public class GuiScreenDemo extends GuiScreen
{
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ ResourceLocation DEMO_BACKGROUND_LOCATION;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIlllllIIllllIIIllIlI) throws IOException {
        switch (llllllllllllIlllllIIllllIIIllIlI.id) {
            case 1: {
                llllllllllllIlllllIIllllIIIllIlI.enabled = false;
                try {
                    final Class<?> llllllllllllIlllllIIllllIIIllIIl = Class.forName("java.awt.Desktop");
                    final Object llllllllllllIlllllIIllllIIIllIII = llllllllllllIlllllIIllllIIIllIIl.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
                    llllllllllllIlllllIIllllIIIllIIl.getMethod("browse", URI.class).invoke(llllllllllllIlllllIIllllIIIllIII, new URI("http://www.minecraft.net/store?source=demo"));
                }
                catch (Throwable llllllllllllIlllllIIllllIIIlIlll) {
                    GuiScreenDemo.LOGGER.error("Couldn't open link", llllllllllllIlllllIIllllIIIlIlll);
                }
                break;
            }
            case 2: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DEMO_BACKGROUND_LOCATION = new ResourceLocation("textures/gui/demo_background.png");
    }
    
    @Override
    public void drawScreen(final int llllllllllllIlllllIIlllIlllllIlI, final int llllllllllllIlllllIIlllIlllllIIl, final float llllllllllllIlllllIIlllIlllllIII) {
        this.drawDefaultBackground();
        final int llllllllllllIlllllIIlllIlllllllI = (this.width - 248) / 2 + 10;
        int llllllllllllIlllllIIlllIllllllIl = (this.height - 166) / 2 + 8;
        this.fontRendererObj.drawString(I18n.format("demo.help.title", new Object[0]), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl, 2039583);
        llllllllllllIlllllIIlllIllllllIl += 12;
        final GameSettings llllllllllllIlllllIIlllIllllllII = this.mc.gameSettings;
        this.fontRendererObj.drawString(I18n.format("demo.help.movementShort", GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindRight.getKeyCode())), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.movementMouse", new Object[0]), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl + 12, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.jump", GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindJump.getKeyCode())), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl + 24, 5197647);
        this.fontRendererObj.drawString(I18n.format("demo.help.inventory", GameSettings.getKeyDisplayString(llllllllllllIlllllIIlllIllllllII.keyBindInventory.getKeyCode())), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl + 36, 5197647);
        this.fontRendererObj.drawSplitString(I18n.format("demo.help.fullWrapped", new Object[0]), llllllllllllIlllllIIlllIlllllllI, llllllllllllIlllllIIlllIllllllIl + 68, 218, 2039583);
        super.drawScreen(llllllllllllIlllllIIlllIlllllIlI, llllllllllllIlllllIIlllIlllllIIl, llllllllllllIlllllIIlllIlllllIII);
    }
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenDemo.DEMO_BACKGROUND_LOCATION);
        final int llllllllllllIlllllIIllllIIIIlllI = (this.width - 248) / 2;
        final int llllllllllllIlllllIIllllIIIIllIl = (this.height - 166) / 2;
        this.drawTexturedModalRect(llllllllllllIlllllIIllllIIIIlllI, llllllllllllIlllllIIllllIIIIllIl, 0, 0, 248, 166);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        final int llllllllllllIlllllIIllllIIlIIIlI = -16;
        this.buttonList.add(new GuiButton(1, this.width / 2 - 116, this.height / 2 + 62 - 16, 114, 20, I18n.format("demo.help.buy", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height / 2 + 62 - 16, 114, 20, I18n.format("demo.help.later", new Object[0])));
    }
}
