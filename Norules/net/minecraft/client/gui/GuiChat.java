package net.minecraft.client.gui;

import net.minecraft.util.*;
import org.lwjgl.input.*;
import java.io.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class GuiChat extends GuiScreen implements ITabCompleter
{
    private /* synthetic */ String defaultInputFieldText;
    private /* synthetic */ TabCompleter tabCompleter;
    private /* synthetic */ int sentHistoryCursor;
    private /* synthetic */ String historyBuffer;
    protected /* synthetic */ GuiTextField inputField;
    
    @Override
    public void drawScreen(final int lllllllllllllIlllllllIlIlIlIIlII, final int lllllllllllllIlllllllIlIlIlIlIII, final float lllllllllllllIlllllllIlIlIlIIlll) {
        Gui.drawRect(2.0, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        this.inputField.drawTextBox();
        final ITextComponent lllllllllllllIlllllllIlIlIlIIllI = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
        if (lllllllllllllIlllllllIlIlIlIIllI != null && lllllllllllllIlllllllIlIlIlIIllI.getStyle().getHoverEvent() != null) {
            this.handleComponentHover(lllllllllllllIlllllllIlIlIlIIllI, lllllllllllllIlllllllIlIlIlIIlII, lllllllllllllIlllllllIlIlIlIlIII);
        }
        super.drawScreen(lllllllllllllIlllllllIlIlIlIIlII, lllllllllllllIlllllllIlIlIlIlIII, lllllllllllllIlllllllIlIlIlIIlll);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.ingameGUI.getChatGUI().resetScroll();
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        this.inputField = new GuiTextField(0, this.fontRendererObj, 4, this.height - 12, this.width - 4, 12);
        this.inputField.setMaxStringLength(256);
        this.inputField.setEnableBackgroundDrawing(false);
        this.inputField.setFocused(true);
        this.inputField.setText(this.defaultInputFieldText);
        this.inputField.setCanLoseFocus(false);
        this.tabCompleter = new ChatTabCompleter(this.inputField);
    }
    
    public void getSentHistory(final int lllllllllllllIlllllllIlIlIllIIlI) {
        int lllllllllllllIlllllllIlIlIllIlIl = this.sentHistoryCursor + lllllllllllllIlllllllIlIlIllIIlI;
        final int lllllllllllllIlllllllIlIlIllIlII = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        lllllllllllllIlllllllIlIlIllIlIl = MathHelper.clamp(lllllllllllllIlllllllIlIlIllIlIl, 0, lllllllllllllIlllllllIlIlIllIlII);
        if (lllllllllllllIlllllllIlIlIllIlIl != this.sentHistoryCursor) {
            if (lllllllllllllIlllllllIlIlIllIlIl == lllllllllllllIlllllllIlIlIllIlII) {
                this.sentHistoryCursor = lllllllllllllIlllllllIlIlIllIlII;
                this.inputField.setText(this.historyBuffer);
            }
            else {
                if (this.sentHistoryCursor == lllllllllllllIlllllllIlIlIllIlII) {
                    this.historyBuffer = this.inputField.getText();
                }
                this.inputField.setText(this.mc.ingameGUI.getChatGUI().getSentMessages().get(lllllllllllllIlllllllIlIlIllIlIl));
                this.sentHistoryCursor = lllllllllllllIlllllllIlIlIllIlIl;
            }
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIlllllllIlIllIIllIl, final int lllllllllllllIlllllllIlIllIIIlll, final int lllllllllllllIlllllllIlIllIIlIll) throws IOException {
        if (lllllllllllllIlllllllIlIllIIlIll == 0) {
            final ITextComponent lllllllllllllIlllllllIlIllIIlIlI = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
            if (lllllllllllllIlllllllIlIllIIlIlI != null && this.handleComponentClick(lllllllllllllIlllllllIlIllIIlIlI)) {
                return;
            }
        }
        this.inputField.mouseClicked(lllllllllllllIlllllllIlIllIIllIl, lllllllllllllIlllllllIlIllIIIlll, lllllllllllllIlllllllIlIllIIlIll);
        super.mouseClicked(lllllllllllllIlllllllIlIllIIllIl, lllllllllllllIlllllllIlIllIIIlll, lllllllllllllIlllllllIlIllIIlIll);
    }
    
    @Override
    protected void setText(final String lllllllllllllIlllllllIlIlIllllIl, final boolean lllllllllllllIlllllllIlIlIllllll) {
        if (lllllllllllllIlllllllIlIlIllllll) {
            this.inputField.setText(lllllllllllllIlllllllIlIlIllllIl);
        }
        else {
            this.inputField.writeText(lllllllllllllIlllllllIlIlIllllIl);
        }
    }
    
    @Override
    public void setCompletions(final String... lllllllllllllIlllllllIlIlIIllIlI) {
        this.tabCompleter.setCompletions(lllllllllllllIlllllllIlIlIIllIlI);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int lllllllllllllIlllllllIlIllIlIllI = Mouse.getEventDWheel();
        if (lllllllllllllIlllllllIlIllIlIllI != 0) {
            if (lllllllllllllIlllllllIlIllIlIllI > 1) {
                lllllllllllllIlllllllIlIllIlIllI = 1;
            }
            if (lllllllllllllIlllllllIlIllIlIllI < -1) {
                lllllllllllllIlllllllIlIllIlIllI = -1;
            }
            if (!GuiScreen.isShiftKeyDown()) {
                lllllllllllllIlllllllIlIllIlIllI *= 7;
            }
            this.mc.ingameGUI.getChatGUI().scroll(lllllllllllllIlllllllIlIllIlIllI);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public GuiChat(final String lllllllllllllIlllllllIlIlllIllll) {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.defaultInputFieldText = "";
        this.defaultInputFieldText = lllllllllllllIlllllllIlIlllIllll;
    }
    
    @Override
    public void updateScreen() {
        this.inputField.updateCursorCounter();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIlllllllIlIllIlllII, final int lllllllllllllIlllllllIlIllIlllll) throws IOException {
        this.tabCompleter.resetRequested();
        if (lllllllllllllIlllllllIlIllIlllll == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        if (lllllllllllllIlllllllIlIllIlllll == 1) {
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllllIlllllllIlIllIlllll != 28 && lllllllllllllIlllllllIlIllIlllll != 156) {
            if (lllllllllllllIlllllllIlIllIlllll == 200) {
                this.getSentHistory(-1);
            }
            else if (lllllllllllllIlllllllIlIllIlllll == 208) {
                this.getSentHistory(1);
            }
            else if (lllllllllllllIlllllllIlIllIlllll == 201) {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            }
            else if (lllllllllllllIlllllllIlIllIlllll == 209) {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            }
            else {
                this.inputField.textboxKeyTyped(lllllllllllllIlllllllIlIllIlllII, lllllllllllllIlllllllIlIllIlllll);
            }
        }
        else {
            final String lllllllllllllIlllllllIlIllIllllI = this.inputField.getText().trim();
            if (!lllllllllllllIlllllllIlIllIllllI.isEmpty()) {
                this.sendChatMessage(lllllllllllllIlllllllIlIllIllllI);
            }
            this.mc.displayGuiScreen(null);
        }
    }
    
    public GuiChat() {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.defaultInputFieldText = "";
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    public static class ChatTabCompleter extends TabCompleter
    {
        private final /* synthetic */ Minecraft clientInstance;
        
        @Override
        public void complete() {
            super.complete();
            if (this.completions.size() > 1) {
                final StringBuilder lllllllllllllIIlllIlllllIlIIIIIl = new StringBuilder();
                for (final String lllllllllllllIIlllIlllllIlIIIIII : this.completions) {
                    if (lllllllllllllIIlllIlllllIlIIIIIl.length() > 0) {
                        lllllllllllllIIlllIlllllIlIIIIIl.append(", ");
                    }
                    lllllllllllllIIlllIlllllIlIIIIIl.append(lllllllllllllIIlllIlllllIlIIIIII);
                }
                this.clientInstance.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString(String.valueOf(lllllllllllllIIlllIlllllIlIIIIIl)), 1);
            }
        }
        
        public ChatTabCompleter(final GuiTextField lllllllllllllIIlllIlllllIlIIlIIl) {
            super(lllllllllllllIIlllIlllllIlIIlIIl, false);
            this.clientInstance = Minecraft.getMinecraft();
        }
        
        @Nullable
        @Override
        public BlockPos getTargetBlockPos() {
            BlockPos lllllllllllllIIlllIlllllIIlllIII = null;
            if (this.clientInstance.objectMouseOver != null && this.clientInstance.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                lllllllllllllIIlllIlllllIIlllIII = this.clientInstance.objectMouseOver.getBlockPos();
            }
            return lllllllllllllIIlllIlllllIIlllIII;
        }
    }
}
