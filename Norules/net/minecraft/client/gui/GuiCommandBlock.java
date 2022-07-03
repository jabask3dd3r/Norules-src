package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import java.io.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.text.*;
import net.minecraft.tileentity.*;
import org.lwjgl.input.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class GuiCommandBlock extends GuiScreen implements ITabCompleter
{
    private /* synthetic */ boolean automatic;
    private /* synthetic */ GuiButton conditionalBtn;
    private /* synthetic */ TabCompleter tabCompleter;
    private /* synthetic */ GuiButton cancelBtn;
    private final /* synthetic */ TileEntityCommandBlock commandBlock;
    private /* synthetic */ boolean conditional;
    private /* synthetic */ GuiButton outputBtn;
    private /* synthetic */ GuiButton doneBtn;
    private /* synthetic */ boolean trackOutput;
    private /* synthetic */ TileEntityCommandBlock.Mode commandBlockMode;
    private /* synthetic */ GuiTextField previousOutputTextField;
    private /* synthetic */ GuiButton modeBtn;
    private /* synthetic */ GuiButton autoExecBtn;
    private /* synthetic */ GuiTextField commandTextField;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
    
    private void updateMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[this.commandBlockMode.ordinal()]) {
            case 1: {
                this.modeBtn.displayString = I18n.format("advMode.mode.sequence", new Object[0]);
                break;
            }
            case 2: {
                this.modeBtn.displayString = I18n.format("advMode.mode.auto", new Object[0]);
                break;
            }
            case 3: {
                this.modeBtn.displayString = I18n.format("advMode.mode.redstone", new Object[0]);
                break;
            }
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIllIllllllIllIll, final int llllllllllllllIlIllIllllllIllIlI) throws IOException {
        this.tabCompleter.resetRequested();
        if (llllllllllllllIlIllIllllllIllIlI == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        this.commandTextField.textboxKeyTyped(llllllllllllllIlIllIllllllIllIll, llllllllllllllIlIllIllllllIllIlI);
        this.previousOutputTextField.textboxKeyTyped(llllllllllllllIlIllIllllllIllIll, llllllllllllllIlIllIllllllIllIlI);
        if (llllllllllllllIlIllIllllllIllIlI != 28 && llllllllllllllIlIllIllllllIllIlI != 156) {
            if (llllllllllllllIlIllIllllllIllIlI == 1) {
                this.actionPerformed(this.cancelBtn);
            }
        }
        else {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    private void updateConditional() {
        if (this.conditional) {
            this.conditionalBtn.displayString = I18n.format("advMode.mode.conditional", new Object[0]);
        }
        else {
            this.conditionalBtn.displayString = I18n.format("advMode.mode.unconditional", new Object[0]);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIlIllIllllllIlIIII, final int llllllllllllllIlIllIllllllIlIIll, final int llllllllllllllIlIllIllllllIlIIlI) throws IOException {
        super.mouseClicked(llllllllllllllIlIllIllllllIlIIII, llllllllllllllIlIllIllllllIlIIll, llllllllllllllIlIllIllllllIlIIlI);
        this.commandTextField.mouseClicked(llllllllllllllIlIllIllllllIlIIII, llllllllllllllIlIllIllllllIlIIll, llllllllllllllIlIllIllllllIlIIlI);
        this.previousOutputTextField.mouseClicked(llllllllllllllIlIllIllllllIlIIII, llllllllllllllIlIllIllllllIlIIll, llllllllllllllIlIllIllllllIlIIlI);
    }
    
    private void nextMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[this.commandBlockMode.ordinal()]) {
            case 1: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.AUTO;
                break;
            }
            case 2: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.REDSTONE;
                break;
            }
            case 3: {
                this.commandBlockMode = TileEntityCommandBlock.Mode.SEQUENCE;
                break;
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIllIlllllllIIlIl) throws IOException {
        if (llllllllllllllIlIllIlllllllIIlIl.enabled) {
            final CommandBlockBaseLogic llllllllllllllIlIllIlllllllIlIII = this.commandBlock.getCommandBlockLogic();
            if (llllllllllllllIlIllIlllllllIIlIl.id == 1) {
                llllllllllllllIlIllIlllllllIlIII.setTrackOutput(this.trackOutput);
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllllIlIllIlllllllIIlIl.id == 0) {
                final PacketBuffer llllllllllllllIlIllIlllllllIIlll = new PacketBuffer(Unpooled.buffer());
                llllllllllllllIlIllIlllllllIlIII.fillInInfo(llllllllllllllIlIllIlllllllIIlll);
                llllllllllllllIlIllIlllllllIIlll.writeString(this.commandTextField.getText());
                llllllllllllllIlIllIlllllllIIlll.writeBoolean(llllllllllllllIlIllIlllllllIlIII.shouldTrackOutput());
                llllllllllllllIlIllIlllllllIIlll.writeString(this.commandBlockMode.name());
                llllllllllllllIlIllIlllllllIIlll.writeBoolean(this.conditional);
                llllllllllllllIlIllIlllllllIIlll.writeBoolean(this.automatic);
                this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|AutoCmd", llllllllllllllIlIllIlllllllIIlll));
                if (!llllllllllllllIlIllIlllllllIlIII.shouldTrackOutput()) {
                    llllllllllllllIlIllIlllllllIlIII.setLastOutput(null);
                }
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllllIlIllIlllllllIIlIl.id == 4) {
                llllllllllllllIlIllIlllllllIlIII.setTrackOutput(!llllllllllllllIlIllIlllllllIlIII.shouldTrackOutput());
                this.updateCmdOutput();
            }
            else if (llllllllllllllIlIllIlllllllIIlIl.id == 5) {
                this.nextMode();
                this.updateMode();
            }
            else if (llllllllllllllIlIllIlllllllIIlIl.id == 6) {
                this.conditional = !this.conditional;
                this.updateConditional();
            }
            else if (llllllllllllllIlIllIlllllllIIlIl.id == 7) {
                this.automatic = !this.automatic;
                this.updateAutoExec();
            }
        }
    }
    
    @Override
    public void updateScreen() {
        this.commandTextField.updateCursorCounter();
    }
    
    public void updateGui() {
        final CommandBlockBaseLogic llllllllllllllIlIllIllllllllIIlI = this.commandBlock.getCommandBlockLogic();
        this.commandTextField.setText(llllllllllllllIlIllIllllllllIIlI.getCommand());
        this.trackOutput = llllllllllllllIlIllIllllllllIIlI.shouldTrackOutput();
        this.commandBlockMode = this.commandBlock.getMode();
        this.conditional = this.commandBlock.isConditional();
        this.automatic = this.commandBlock.isAuto();
        this.updateCmdOutput();
        this.updateMode();
        this.updateConditional();
        this.updateAutoExec();
        this.doneBtn.enabled = true;
        this.outputBtn.enabled = true;
        this.modeBtn.enabled = true;
        this.conditionalBtn.enabled = true;
        this.autoExecBtn.enabled = true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = GuiCommandBlock.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        }
        final int llllllllllllllIlIllIlllllIlIIIlI = (Object)new int[TileEntityCommandBlock.Mode.values().length];
        try {
            llllllllllllllIlIllIlllllIlIIIlI[TileEntityCommandBlock.Mode.AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIllIlllllIlIIIlI[TileEntityCommandBlock.Mode.REDSTONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIllIlllllIlIIIlI[TileEntityCommandBlock.Mode.SEQUENCE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GuiCommandBlock.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = (int[])(Object)llllllllllllllIlIllIlllllIlIIIlI;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIllIllllllIIIIII, final int llllllllllllllIlIllIlllllIllllll, final float llllllllllllllIlIllIlllllIlllllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("advMode.setCommand", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("advMode.command", new Object[0]), this.width / 2 - 150, 40, 10526880);
        this.commandTextField.drawTextBox();
        int llllllllllllllIlIllIllllllIIIIll = 75;
        int llllllllllllllIlIllIllllllIIIIlI = 0;
        this.drawString(this.fontRendererObj, I18n.format("advMode.nearestPlayer", new Object[0]), this.width / 2 - 140, llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.randomPlayer", new Object[0]), this.width / 2 - 140, llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allPlayers", new Object[0]), this.width / 2 - 140, llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.allEntities", new Object[0]), this.width / 2 - 140, llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        this.drawString(this.fontRendererObj, I18n.format("advMode.self", new Object[0]), this.width / 2 - 140, llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI++ * this.fontRendererObj.FONT_HEIGHT, 10526880);
        if (!this.previousOutputTextField.getText().isEmpty()) {
            llllllllllllllIlIllIllllllIIIIll = llllllllllllllIlIllIllllllIIIIll + llllllllllllllIlIllIllllllIIIIlI * this.fontRendererObj.FONT_HEIGHT + 1;
            this.drawString(this.fontRendererObj, I18n.format("advMode.previousOutput", new Object[0]), this.width / 2 - 150, llllllllllllllIlIllIllllllIIIIll + 4, 10526880);
            this.previousOutputTextField.drawTextBox();
        }
        super.drawScreen(llllllllllllllIlIllIllllllIIIIII, llllllllllllllIlIllIlllllIllllll, llllllllllllllIlIllIlllllIlllllI);
    }
    
    public GuiCommandBlock(final TileEntityCommandBlock llllllllllllllIlIllIllllllllllll) {
        this.commandBlockMode = TileEntityCommandBlock.Mode.REDSTONE;
        this.commandBlock = llllllllllllllIlIllIllllllllllll;
    }
    
    @Override
    public void setCompletions(final String... llllllllllllllIlIllIlllllIlIIllI) {
        this.tabCompleter.setCompletions(llllllllllllllIlIllIlllllIlIIllI);
    }
    
    private void updateCmdOutput() {
        final CommandBlockBaseLogic llllllllllllllIlIllIlllllIlllIII = this.commandBlock.getCommandBlockLogic();
        if (llllllllllllllIlIllIlllllIlllIII.shouldTrackOutput()) {
            this.outputBtn.displayString = "O";
            if (llllllllllllllIlIllIlllllIlllIII.getLastOutput() != null) {
                this.previousOutputTextField.setText(llllllllllllllIlIllIlllllIlllIII.getLastOutput().getUnformattedText());
            }
        }
        else {
            this.outputBtn.displayString = "X";
            this.previousOutputTextField.setText("-");
        }
    }
    
    @Override
    public void initGui() {
        final CommandBlockBaseLogic llllllllllllllIlIllIlllllllllIII = this.commandBlock.getCommandBlockLogic();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneBtn = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelBtn = this.addButton(new GuiButton(1, this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.outputBtn = this.addButton(new GuiButton(4, this.width / 2 + 150 - 20, 135, 20, 20, "O"));
        this.modeBtn = this.addButton(new GuiButton(5, this.width / 2 - 50 - 100 - 4, 165, 100, 20, I18n.format("advMode.mode.sequence", new Object[0])));
        this.conditionalBtn = this.addButton(new GuiButton(6, this.width / 2 - 50, 165, 100, 20, I18n.format("advMode.mode.unconditional", new Object[0])));
        this.autoExecBtn = this.addButton(new GuiButton(7, this.width / 2 + 50 + 4, 165, 100, 20, I18n.format("advMode.mode.redstoneTriggered", new Object[0])));
        this.commandTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.commandTextField.setMaxStringLength(32500);
        this.commandTextField.setFocused(true);
        this.previousOutputTextField = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 150, 135, 276, 20);
        this.previousOutputTextField.setMaxStringLength(32500);
        this.previousOutputTextField.setEnabled(false);
        this.previousOutputTextField.setText("-");
        this.doneBtn.enabled = false;
        this.outputBtn.enabled = false;
        this.modeBtn.enabled = false;
        this.conditionalBtn.enabled = false;
        this.autoExecBtn.enabled = false;
        this.tabCompleter = new TabCompleter(this.commandTextField, true) {
            @Nullable
            @Override
            public BlockPos getTargetBlockPos() {
                return llllllllllllllIlIllIlllllllllIII.getPosition();
            }
        };
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private void updateAutoExec() {
        if (this.automatic) {
            this.autoExecBtn.displayString = I18n.format("advMode.mode.autoexec.bat", new Object[0]);
        }
        else {
            this.autoExecBtn.displayString = I18n.format("advMode.mode.redstoneTriggered", new Object[0]);
        }
    }
}
