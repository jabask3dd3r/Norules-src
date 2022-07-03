package optifine;

import java.util.*;
import net.minecraft.client.gui.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;
import java.io.*;

public class GuiMessage extends GuiScreen
{
    private final /* synthetic */ List listLines2;
    private /* synthetic */ int ticksUntilEnable;
    protected /* synthetic */ String confirmButtonText;
    private /* synthetic */ String messageLine1;
    private /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ String messageLine2;
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 74, this.height / 6 + 96, this.confirmButtonText));
        this.listLines2.clear();
        this.listLines2.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }
    
    @Override
    public void drawScreen(final int llllllllllllIllllllllIIllllIIllI, final int llllllllllllIllllllllIIllllIIlIl, final float llllllllllllIllllllllIIllllIIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 16777215);
        int llllllllllllIllllllllIIllllIlIIl = 90;
        for (final Object llllllllllllIllllllllIIllllIlIII : this.listLines2) {
            this.drawCenteredString(this.fontRendererObj, (String)llllllllllllIllllllllIIllllIlIII, this.width / 2, llllllllllllIllllllllIIllllIlIIl, 16777215);
            llllllllllllIllllllllIIllllIlIIl += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(llllllllllllIllllllllIIllllIIllI, llllllllllllIllllllllIIllllIIlIl, llllllllllllIllllllllIIllllIIlII);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final GuiButton llllllllllllIllllllllIIlllIlIIIl : this.buttonList) {
                llllllllllllIllllllllIIlllIlIIIl.enabled = true;
            }
        }
    }
    
    public void setButtonDelay(final int llllllllllllIllllllllIIlllIllIII) {
        this.ticksUntilEnable = llllllllllllIllllllllIIlllIllIII;
        for (final GuiButton llllllllllllIllllllllIIlllIllIlI : this.buttonList) {
            llllllllllllIllllllllIIlllIllIlI.enabled = false;
        }
    }
    
    public GuiMessage(final GuiScreen llllllllllllIllllllllIlIIIIIIIlI, final String llllllllllllIllllllllIlIIIIIIIIl, final String llllllllllllIllllllllIIlllllllII) {
        this.listLines2 = Lists.newArrayList();
        this.parentScreen = llllllllllllIllllllllIlIIIIIIIlI;
        this.messageLine1 = llllllllllllIllllllllIlIIIIIIIIl;
        this.messageLine2 = llllllllllllIllllllllIIlllllllII;
        this.confirmButtonText = I18n.format("gui.done", new Object[0]);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIllllllllIIlllllIllI) throws IOException {
        Config.getMinecraft().displayGuiScreen(this.parentScreen);
    }
}
