package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import org.lwjgl.input.*;
import java.io.*;
import net.minecraft.world.storage.*;
import org.apache.commons.io.*;
import net.minecraft.client.renderer.*;

public class GuiWorldEdit extends GuiScreen
{
    private /* synthetic */ GuiTextField nameEdit;
    private final /* synthetic */ GuiScreen lastScreen;
    private final /* synthetic */ String worldId;
    
    @Override
    public void updateScreen() {
        this.nameEdit.updateCursorCounter();
    }
    
    @Override
    public void drawScreen(final int llllIllIIIlIlI, final int llllIllIIIIIll, final float llllIllIIIIIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.edit.title", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName", new Object[0]), this.width / 2 - 100, 47, 10526880);
        this.nameEdit.drawTextBox();
        super.drawScreen(llllIllIIIlIlI, llllIllIIIIIll, llllIllIIIIIlI);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    public GuiWorldEdit(final GuiScreen lllllIIIlIllIl, final String lllllIIIlIlIll) {
        this.lastScreen = lllllIIIlIllIl;
        this.worldId = lllllIIIlIlIll;
    }
    
    @Override
    protected void keyTyped(final char llllIllIlllIIl, final int llllIllIllIlll) throws IOException {
        this.nameEdit.textboxKeyTyped(llllIllIlllIIl, llllIllIllIlll);
        this.buttonList.get(2).enabled = !this.nameEdit.getText().trim().isEmpty();
        if (llllIllIllIlll == 28 || llllIllIllIlll == 156) {
            this.actionPerformed(this.buttonList.get(2));
        }
    }
    
    @Override
    protected void mouseClicked(final int llllIllIIlllIl, final int llllIllIlIIIlI, final int llllIllIlIIIII) throws IOException {
        super.mouseClicked(llllIllIIlllIl, llllIllIlIIIlI, llllIllIlIIIII);
        this.nameEdit.mouseClicked(llllIllIIlllIl, llllIllIlIIIlI, llllIllIlIIIII);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        final GuiButton llllIlllllIlIl = this.addButton(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 24 + 12, I18n.format("selectWorld.edit.resetIcon", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 48 + 12, I18n.format("selectWorld.edit.openFolder", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectWorld.edit.save", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        llllIlllllIlIl.enabled = this.mc.getSaveLoader().getFile(this.worldId, "icon.png").isFile();
        final ISaveFormat llllIlllllIlII = this.mc.getSaveLoader();
        final WorldInfo llllIlllllIIll = llllIlllllIlII.getWorldInfo(this.worldId);
        final String llllIlllllIIlI = (llllIlllllIIll == null) ? "" : llllIlllllIIll.getWorldName();
        this.nameEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.nameEdit.setFocused(true);
        this.nameEdit.setText(llllIlllllIIlI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllIlllIIlIlI) throws IOException {
        if (llllIlllIIlIlI.enabled) {
            if (llllIlllIIlIlI.id == 1) {
                this.mc.displayGuiScreen(this.lastScreen);
            }
            else if (llllIlllIIlIlI.id == 0) {
                final ISaveFormat llllIlllIIllll = this.mc.getSaveLoader();
                llllIlllIIllll.renameWorld(this.worldId, this.nameEdit.getText().trim());
                this.mc.displayGuiScreen(this.lastScreen);
            }
            else if (llllIlllIIlIlI.id == 3) {
                final ISaveFormat llllIlllIIlllI = this.mc.getSaveLoader();
                FileUtils.deleteQuietly(llllIlllIIlllI.getFile(this.worldId, "icon.png"));
                llllIlllIIlIlI.enabled = false;
            }
            else if (llllIlllIIlIlI.id == 4) {
                final ISaveFormat llllIlllIIllIl = this.mc.getSaveLoader();
                OpenGlHelper.openFile(llllIlllIIllIl.getFile(this.worldId, "icon.png").getParentFile());
            }
        }
    }
}
