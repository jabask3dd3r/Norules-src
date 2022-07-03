package net.minecraft.client.gui.inventory;

import net.minecraft.tileentity.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import org.lwjgl.input.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.io.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.text.*;

public class GuiEditCommandBlockMinecart extends GuiScreen implements ITabCompleter
{
    private final /* synthetic */ CommandBlockBaseLogic commandBlockLogic;
    private /* synthetic */ GuiButton doneButton;
    private /* synthetic */ GuiButton cancelButton;
    private /* synthetic */ GuiButton outputButton;
    private /* synthetic */ GuiTextField commandField;
    private /* synthetic */ GuiTextField previousEdit;
    private /* synthetic */ boolean trackOutput;
    private /* synthetic */ TabCompleter tabCompleter;
    
    @Override
    public void setCompletions(final String... llllllllllllIlllllIlllIlIIlIlllI) {
        this.tabCompleter.setCompletions(llllllllllllIlllllIlllIlIIlIlllI);
    }
    
    @Override
    public void drawScreen(final int llllllllllllIlllllIlllIlIIlllIIl, final int llllllllllllIlllllIlllIlIIlllllI, final float llllllllllllIlllllIlllIlIIllllIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("advMode.setCommand", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("advMode.command", new Object[0]), this.width / 2 - 150, 40, 10526880);
        this.commandField.drawTextBox();
        int llllllllllllIlllllIlllIlIIllllII = 75;
        int llllllllllllIlllllIlllIlIIlllIll = 0;
        this.drawString(this.fontRendererObj, I18n.format("advMode.nearestPlayer", new Object[0]), this.width / 2 - 140, llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.randomPlayer", new Object[0]), this.width / 2 - 140, llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allPlayers", new Object[0]), this.width / 2 - 140, llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allEntities", new Object[0]), this.width / 2 - 140, llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.self", new Object[0]), this.width / 2 - 140, llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        if (!this.previousEdit.getText().isEmpty()) {
            llllllllllllIlllllIlllIlIIllllII = llllllllllllIlllllIlllIlIIllllII + llllllllllllIlllllIlllIlIIlllIll * this.fontRendererObj.FONT_HEIGHT + 20;
            this.drawString(this.fontRendererObj, I18n.format("advMode.previousOutput", new Object[0]), this.width / 2 - 150, llllllllllllIlllllIlllIlIIllllII, 10526880);
            this.previousEdit.drawTextBox();
        }
        super.drawScreen(llllllllllllIlllllIlllIlIIlllIIl, llllllllllllIlllllIlllIlIIlllllI, llllllllllllIlllllIlllIlIIllllIl);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelButton = this.addButton(new GuiButton(1, this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.outputButton = this.addButton(new GuiButton(4, this.width / 2 + 150 - 20, 150, 20, 20, "O"));
        this.commandField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.commandField.setMaxStringLength(32500);
        this.commandField.setFocused(true);
        this.commandField.setText(this.commandBlockLogic.getCommand());
        this.previousEdit = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 150, 150, 276, 20);
        this.previousEdit.setMaxStringLength(32500);
        this.previousEdit.setEnabled(false);
        this.previousEdit.setText("-");
        this.trackOutput = this.commandBlockLogic.shouldTrackOutput();
        this.updateCommandOutput();
        this.doneButton.enabled = !this.commandField.getText().trim().isEmpty();
        this.tabCompleter = new TabCompleter(this.commandField, true) {
            @Nullable
            @Override
            public BlockPos getTargetBlockPos() {
                return GuiEditCommandBlockMinecart.this.commandBlockLogic.getPosition();
            }
        };
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIlllllIlllIlIlIlIlll, final int llllllllllllIlllllIlllIlIlIlIllI) throws IOException {
        this.tabCompleter.resetRequested();
        if (llllllllllllIlllllIlllIlIlIlIllI == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        this.commandField.textboxKeyTyped(llllllllllllIlllllIlllIlIlIlIlll, llllllllllllIlllllIlllIlIlIlIllI);
        this.previousEdit.textboxKeyTyped(llllllllllllIlllllIlllIlIlIlIlll, llllllllllllIlllllIlllIlIlIlIllI);
        this.doneButton.enabled = !this.commandField.getText().trim().isEmpty();
        if (llllllllllllIlllllIlllIlIlIlIllI != 28 && llllllllllllIlllllIlllIlIlIlIllI != 156) {
            if (llllllllllllIlllllIlllIlIlIlIllI == 1) {
                this.actionPerformed(this.cancelButton);
            }
        }
        else {
            this.actionPerformed(this.doneButton);
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIlllllIlllIlIllIIIII) throws IOException {
        if (llllllllllllIlllllIlllIlIllIIIII.enabled) {
            if (llllllllllllIlllllIlllIlIllIIIII.id == 1) {
                this.commandBlockLogic.setTrackOutput(this.trackOutput);
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllIlllllIlllIlIllIIIII.id == 0) {
                final PacketBuffer llllllllllllIlllllIlllIlIlIlllll = new PacketBuffer(Unpooled.buffer());
                llllllllllllIlllllIlllIlIlIlllll.writeByte(this.commandBlockLogic.getCommandBlockType());
                this.commandBlockLogic.fillInInfo(llllllllllllIlllllIlllIlIlIlllll);
                llllllllllllIlllllIlllIlIlIlllll.writeString(this.commandField.getText());
                llllllllllllIlllllIlllIlIlIlllll.writeBoolean(this.commandBlockLogic.shouldTrackOutput());
                this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|AdvCmd", llllllllllllIlllllIlllIlIlIlllll));
                if (!this.commandBlockLogic.shouldTrackOutput()) {
                    this.commandBlockLogic.setLastOutput(null);
                }
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllIlllllIlllIlIllIIIII.id == 4) {
                this.commandBlockLogic.setTrackOutput(!this.commandBlockLogic.shouldTrackOutput());
                this.updateCommandOutput();
            }
        }
    }
    
    private void updateCommandOutput() {
        if (this.commandBlockLogic.shouldTrackOutput()) {
            this.outputButton.displayString = "O";
            if (this.commandBlockLogic.getLastOutput() != null) {
                this.previousEdit.setText(this.commandBlockLogic.getLastOutput().getUnformattedText());
            }
        }
        else {
            this.outputButton.displayString = "X";
            this.previousEdit.setText("-");
        }
    }
    
    @Override
    public void updateScreen() {
        this.commandField.updateCursorCounter();
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIlllllIlllIlIlIIlIIl, final int llllllllllllIlllllIlllIlIlIIllII, final int llllllllllllIlllllIlllIlIlIIIlll) throws IOException {
        super.mouseClicked(llllllllllllIlllllIlllIlIlIIlIIl, llllllllllllIlllllIlllIlIlIIllII, llllllllllllIlllllIlllIlIlIIIlll);
        this.commandField.mouseClicked(llllllllllllIlllllIlllIlIlIIlIIl, llllllllllllIlllllIlllIlIlIIllII, llllllllllllIlllllIlllIlIlIIIlll);
        this.previousEdit.mouseClicked(llllllllllllIlllllIlllIlIlIIlIIl, llllllllllllIlllllIlllIlIlIIllII, llllllllllllIlllllIlllIlIlIIIlll);
    }
    
    public GuiEditCommandBlockMinecart(final CommandBlockBaseLogic llllllllllllIlllllIlllIlIllIllII) {
        this.commandBlockLogic = llllllllllllIlllllIlllIlIllIllII;
    }
}
