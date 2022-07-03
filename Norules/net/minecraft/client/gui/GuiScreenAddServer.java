package net.minecraft.client.gui;

import com.google.common.base.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.resources.*;
import java.io.*;
import org.lwjgl.input.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.net.*;

public class GuiScreenAddServer extends GuiScreen
{
    private /* synthetic */ GuiButton serverResourcePacks;
    private /* synthetic */ GuiTextField serverIPField;
    private final /* synthetic */ Predicate<String> addressFilter;
    private final /* synthetic */ ServerData serverData;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ GuiTextField serverNameField;
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllllIlIIllllIIlIIl) throws IOException {
        if (lllllllllllllIllllIlIIllllIIlIIl.enabled) {
            if (lllllllllllllIllllIlIIllllIIlIIl.id == 2) {
                this.serverData.setResourceMode(ServerData.ServerResourceMode.values()[(this.serverData.getResourceMode().ordinal() + 1) % ServerData.ServerResourceMode.values().length]);
                this.serverResourcePacks.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("addServer.resourcePack", new Object[0]))).append(": ").append(this.serverData.getResourceMode().getMotd().getFormattedText()));
            }
            else if (lllllllllllllIllllIlIIllllIIlIIl.id == 1) {
                this.parentScreen.confirmClicked(false, 0);
            }
            else if (lllllllllllllIllllIlIIllllIIlIIl.id == 0) {
                this.serverData.serverName = this.serverNameField.getText();
                this.serverData.serverIP = this.serverIPField.getText();
                this.parentScreen.confirmClicked(true, 0);
            }
        }
    }
    
    @Override
    public void updateScreen() {
        this.serverNameField.updateCursorCounter();
        this.serverIPField.updateCursorCounter();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIllllIlIIlllIllllll, final int lllllllllllllIllllIlIIlllIlllllI) throws IOException {
        this.serverNameField.textboxKeyTyped(lllllllllllllIllllIlIIlllIllllll, lllllllllllllIllllIlIIlllIlllllI);
        this.serverIPField.textboxKeyTyped(lllllllllllllIllllIlIIlllIllllll, lllllllllllllIllllIlIIlllIlllllI);
        if (lllllllllllllIllllIlIIlllIlllllI == 15) {
            this.serverNameField.setFocused(!this.serverNameField.isFocused());
            this.serverIPField.setFocused(!this.serverIPField.isFocused());
        }
        if (lllllllllllllIllllIlIIlllIlllllI == 28 || lllllllllllllIllllIlIIlllIlllllI == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.buttonList.get(0).enabled = (!this.serverIPField.getText().isEmpty() && this.serverIPField.getText().split(":").length > 0 && !this.serverNameField.getText().isEmpty());
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 18, I18n.format("addServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 18, I18n.format("gui.cancel", new Object[0])));
        this.serverResourcePacks = this.addButton(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 72, String.valueOf(new StringBuilder(String.valueOf(I18n.format("addServer.resourcePack", new Object[0]))).append(": ").append(this.serverData.getResourceMode().getMotd().getFormattedText()))));
        this.serverNameField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 66, 200, 20);
        this.serverNameField.setFocused(true);
        this.serverNameField.setText(this.serverData.serverName);
        this.serverIPField = new GuiTextField(1, this.fontRendererObj, this.width / 2 - 100, 106, 200, 20);
        this.serverIPField.setMaxStringLength(128);
        this.serverIPField.setText(this.serverData.serverIP);
        this.serverIPField.setValidator(this.addressFilter);
        this.buttonList.get(0).enabled = (!this.serverIPField.getText().isEmpty() && this.serverIPField.getText().split(":").length > 0 && !this.serverNameField.getText().isEmpty());
    }
    
    public GuiScreenAddServer(final GuiScreen lllllllllllllIllllIlIIllllIllIII, final ServerData lllllllllllllIllllIlIIllllIlIlII) {
        this.addressFilter = (Predicate<String>)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllllIlIlIIllllIIlllllII) {
                if (StringUtils.isNullOrEmpty(lllllllllllllIlIlIIllllIIlllllII)) {
                    return true;
                }
                final String[] lllllllllllllIlIlIIllllIIlllllll = lllllllllllllIlIlIIllllIIlllllII.split(":");
                if (lllllllllllllIlIlIIllllIIlllllll.length == 0) {
                    return true;
                }
                try {
                    final String lllllllllllllIlIlIIllllIIllllllI = IDN.toASCII(lllllllllllllIlIlIIllllIIlllllll[0]);
                    return true;
                }
                catch (IllegalArgumentException lllllllllllllIlIlIIllllIIlllllIl) {
                    return false;
                }
            }
        };
        this.parentScreen = lllllllllllllIllllIlIIllllIllIII;
        this.serverData = lllllllllllllIllllIlIIllllIlIlII;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllllIlIIlllIlIlIII, final int lllllllllllllIllllIlIIlllIlIIlll, final float lllllllllllllIllllIlIIlllIlIIllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("addServer.title", new Object[0]), this.width / 2, 17, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterName", new Object[0]), this.width / 2 - 100, 53, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 94, 10526880);
        this.serverNameField.drawTextBox();
        this.serverIPField.drawTextBox();
        super.drawScreen(lllllllllllllIllllIlIIlllIlIlIII, lllllllllllllIllllIlIIlllIlIIlll, lllllllllllllIllllIlIIlllIlIIllI);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIllllIlIIlllIlllIII, final int lllllllllllllIllllIlIIlllIllIIll, final int lllllllllllllIllllIlIIlllIllIIlI) throws IOException {
        super.mouseClicked(lllllllllllllIllllIlIIlllIlllIII, lllllllllllllIllllIlIIlllIllIIll, lllllllllllllIllllIlIIlllIllIIlI);
        this.serverIPField.mouseClicked(lllllllllllllIllllIlIIlllIlllIII, lllllllllllllIllllIlIIlllIllIIll, lllllllllllllIllllIlIIlllIllIIlI);
        this.serverNameField.mouseClicked(lllllllllllllIllllIlIIlllIlllIII, lllllllllllllIllllIlIIlllIllIIll, lllllllllllllIllllIlIIlllIllIIlI);
    }
}
