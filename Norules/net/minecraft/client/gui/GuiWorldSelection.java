package net.minecraft.client.gui;

import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;
import font.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.*;
import javax.annotation.*;

public class GuiWorldSelection extends GuiScreen
{
    private /* synthetic */ GuiButton copyButton;
    private /* synthetic */ String worldVersTooltip;
    protected /* synthetic */ GuiScreen prevScreen;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiButton renameButton;
    /* synthetic */ MinecraftFontRenderer font;
    private /* synthetic */ GuiListWorldSelection selectionList;
    private /* synthetic */ GuiButton deleteButton;
    private /* synthetic */ GuiButton selectButton;
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIllIIlllIIlIIlII, final int lllllllllllllIIIIllIIlllIIIlllll, final float lllllllllllllIIIIllIIlllIIlIIIlI) {
        this.worldVersTooltip = null;
        this.selectionList.drawScreen(lllllllllllllIIIIllIIlllIIlIIlII, lllllllllllllIIIIllIIlllIIIlllll, lllllllllllllIIIIllIIlllIIlIIIlI);
        this.font.drawCenteredString(this.title, this.width / 2, 17, 16777215);
        super.drawScreen(lllllllllllllIIIIllIIlllIIlIIlII, lllllllllllllIIIIllIIlllIIIlllll, lllllllllllllIIIIllIIlllIIlIIIlI);
        if (this.worldVersTooltip != null) {
            this.drawHoveringText(Lists.newArrayList(Splitter.on("\n").split((CharSequence)this.worldVersTooltip)), lllllllllllllIIIIllIIlllIIlIIlII, lllllllllllllIIIIllIIlllIIIlllll);
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.selectionList.handleMouseInput();
    }
    
    public GuiWorldSelection(final GuiScreen lllllllllllllIIIIllIIlllIIlllllI) {
        this.title = "Select world";
        this.font = FontLoader.INSTANCE.comfortaa_bold_20;
        this.prevScreen = lllllllllllllIIIIllIIlllIIlllllI;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIIIIllIIlllIIIlIlII, final int lllllllllllllIIIIllIIlllIIIlIIll, final int lllllllllllllIIIIllIIlllIIIlIIlI) throws IOException {
        super.mouseClicked(lllllllllllllIIIIllIIlllIIIlIlII, lllllllllllllIIIIllIIlllIIIlIIll, lllllllllllllIIIIllIIlllIIIlIIlI);
        this.selectionList.mouseClicked(lllllllllllllIIIIllIIlllIIIlIlII, lllllllllllllIIIIllIIlllIIIlIIll, lllllllllllllIIIIllIIlllIIIlIIlI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIIllIIlllIIlIlIll) throws IOException {
        if (lllllllllllllIIIIllIIlllIIlIlIll.enabled) {
            final GuiListWorldSelectionEntry lllllllllllllIIIIllIIlllIIlIllIl = this.selectionList.getSelectedWorld();
            if (lllllllllllllIIIIllIIlllIIlIlIll.id == 2) {
                if (lllllllllllllIIIIllIIlllIIlIllIl != null) {
                    lllllllllllllIIIIllIIlllIIlIllIl.deleteWorld();
                }
            }
            else if (lllllllllllllIIIIllIIlllIIlIlIll.id == 1) {
                if (lllllllllllllIIIIllIIlllIIlIllIl != null) {
                    lllllllllllllIIIIllIIlllIIlIllIl.joinWorld();
                }
            }
            else if (lllllllllllllIIIIllIIlllIIlIlIll.id == 3) {
                this.mc.displayGuiScreen(new GuiCreateWorld(this));
            }
            else if (lllllllllllllIIIIllIIlllIIlIlIll.id == 4) {
                if (lllllllllllllIIIIllIIlllIIlIllIl != null) {
                    lllllllllllllIIIIllIIlllIIlIllIl.editWorld();
                }
            }
            else if (lllllllllllllIIIIllIIlllIIlIlIll.id == 0) {
                this.mc.displayGuiScreen(this.prevScreen);
            }
            else if (lllllllllllllIIIIllIIlllIIlIlIll.id == 5 && lllllllllllllIIIIllIIlllIIlIllIl != null) {
                lllllllllllllIIIIllIIlllIIlIllIl.recreateWorld();
            }
        }
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllIIIIllIIlllIIIIlIII, final int lllllllllllllIIIIllIIlllIIIIlIll, final int lllllllllllllIIIIllIIlllIIIIIllI) {
        super.mouseReleased(lllllllllllllIIIIllIIlllIIIIlIII, lllllllllllllIIIIllIIlllIIIIlIll, lllllllllllllIIIIllIIlllIIIIIllI);
        this.selectionList.mouseReleased(lllllllllllllIIIIllIIlllIIIIlIII, lllllllllllllIIIIllIIlllIIIIlIll, lllllllllllllIIIIllIIlllIIIIIllI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void postInit() {
        this.selectButton = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format("selectWorld.select", new Object[0])));
        this.addButton(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        this.renameButton = this.addButton(new GuiButton(4, this.width / 2 - 154, this.height - 28, 72, 20, I18n.format("selectWorld.edit", new Object[0])));
        this.deleteButton = this.addButton(new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, I18n.format("selectWorld.delete", new Object[0])));
        this.copyButton = this.addButton(new GuiButton(5, this.width / 2 + 4, this.height - 28, 72, 20, I18n.format("selectWorld.recreate", new Object[0])));
        this.addButton(new GuiButton(0, this.width / 2 + 82, this.height - 28, 72, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectButton.enabled = false;
        this.deleteButton.enabled = false;
        this.renameButton.enabled = false;
        this.copyButton.enabled = false;
    }
    
    public void setVersionTooltip(final String lllllllllllllIIIIllIIlllIIIIIIII) {
        this.worldVersTooltip = lllllllllllllIIIIllIIlllIIIIIIII;
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("selectWorld.title", new Object[0]);
        this.selectionList = new GuiListWorldSelection(this, this.mc, this.width, this.height, 32, this.height - 64, 36);
        this.postInit();
    }
    
    public void selectWorld(@Nullable final GuiListWorldSelectionEntry lllllllllllllIIIIllIIllIlllllIll) {
        final boolean lllllllllllllIIIIllIIllIlllllIlI = lllllllllllllIIIIllIIllIlllllIll != null;
        this.selectButton.enabled = lllllllllllllIIIIllIIllIlllllIlI;
        this.deleteButton.enabled = lllllllllllllIIIIllIIllIlllllIlI;
        this.renameButton.enabled = lllllllllllllIIIIllIIllIlllllIlI;
        this.copyButton.enabled = lllllllllllllIIIIllIIllIlllllIlI;
    }
}
