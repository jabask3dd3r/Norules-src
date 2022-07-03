package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;

public class GuiControls extends GuiScreen
{
    private /* synthetic */ GuiButton buttonReset;
    private /* synthetic */ GuiKeyBindingList keyBindingList;
    protected /* synthetic */ String screenTitle;
    public /* synthetic */ KeyBinding buttonId;
    private static final /* synthetic */ GameSettings.Options[] OPTIONS_ARR;
    private final /* synthetic */ GameSettings options;
    public /* synthetic */ long time;
    private final /* synthetic */ GuiScreen parentScreen;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllllIlIlIlIlIIlIIIIl) throws IOException {
        if (llllllllllllllllIlIlIlIlIIlIIIIl.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (llllllllllllllllIlIlIlIlIIlIIIIl.id == 201) {
            final String llllllllllllllllIlIlIlIlIIIllIlI;
            final int llllllllllllllllIlIlIlIlIIIllIll = ((KeyBinding[])(Object)(llllllllllllllllIlIlIlIlIIIllIlI = (String)(Object)this.mc.gameSettings.keyBindings)).length;
            for (byte llllllllllllllllIlIlIlIlIIIlllII = 0; llllllllllllllllIlIlIlIlIIIlllII < llllllllllllllllIlIlIlIlIIIllIll; ++llllllllllllllllIlIlIlIlIIIlllII) {
                final KeyBinding llllllllllllllllIlIlIlIlIIlIIIII = llllllllllllllllIlIlIlIlIIIllIlI[llllllllllllllllIlIlIlIlIIIlllII];
                llllllllllllllllIlIlIlIlIIlIIIII.setKeyCode(llllllllllllllllIlIlIlIlIIlIIIII.getKeyCodeDefault());
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (llllllllllllllllIlIlIlIlIIlIIIIl.id < 100 && llllllllllllllllIlIlIlIlIIlIIIIl instanceof GuiOptionButton) {
            this.options.setOptionValue(((GuiOptionButton)llllllllllllllllIlIlIlIlIIlIIIIl).returnEnumOptions(), 1);
            llllllllllllllllIlIlIlIlIIlIIIIl.displayString = this.options.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllllIlIlIlIlIIlIIIIl.id));
        }
    }
    
    @Override
    public void initGui() {
        this.keyBindingList = new GuiKeyBindingList(this, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155 + 160, this.height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonReset = this.addButton(new GuiButton(201, this.width / 2 - 155, this.height - 29, 150, 20, I18n.format("controls.resetAll", new Object[0])));
        this.screenTitle = I18n.format("controls.title", new Object[0]);
        int llllllllllllllllIlIlIlIlIIllIIll = 0;
        final boolean llllllllllllllllIlIlIlIlIIlIllII;
        final Exception llllllllllllllllIlIlIlIlIIlIllIl = (Exception)((GameSettings.Options[])(Object)(llllllllllllllllIlIlIlIlIIlIllII = (boolean)(Object)GuiControls.OPTIONS_ARR)).length;
        for (final GameSettings.Options llllllllllllllllIlIlIlIlIIllIIlI : llllllllllllllllIlIlIlIlIIlIllII) {
            if (llllllllllllllllIlIlIlIlIIllIIlI.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(llllllllllllllllIlIlIlIlIIllIIlI.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIlIlIlIlIIllIIll % 2 * 160, 18 + 24 * (llllllllllllllllIlIlIlIlIIllIIll >> 1), llllllllllllllllIlIlIlIlIIllIIlI));
            }
            else {
                this.buttonList.add(new GuiOptionButton(llllllllllllllllIlIlIlIlIIllIIlI.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllllIlIlIlIlIIllIIll % 2 * 160, 18 + 24 * (llllllllllllllllIlIlIlIlIIllIIll >> 1), llllllllllllllllIlIlIlIlIIllIIlI, this.options.getKeyBinding(llllllllllllllllIlIlIlIlIIllIIlI)));
            }
            ++llllllllllllllllIlIlIlIlIIllIIll;
        }
    }
    
    public GuiControls(final GuiScreen llllllllllllllllIlIlIlIlIIllllII, final GameSettings llllllllllllllllIlIlIlIlIIlllllI) {
        this.screenTitle = "Controls";
        this.parentScreen = llllllllllllllllIlIlIlIlIIllllII;
        this.options = llllllllllllllllIlIlIlIlIIlllllI;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.keyBindingList.handleMouseInput();
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllllllIlIlIlIlIIIIIlII, final int llllllllllllllllIlIlIlIlIIIIIIll, final int llllllllllllllllIlIlIlIlIIIIIIlI) {
        if (llllllllllllllllIlIlIlIlIIIIIIlI != 0 || !this.keyBindingList.mouseReleased(llllllllllllllllIlIlIlIlIIIIIlII, llllllllllllllllIlIlIlIlIIIIIIll, llllllllllllllllIlIlIlIlIIIIIIlI)) {
            super.mouseReleased(llllllllllllllllIlIlIlIlIIIIIlII, llllllllllllllllIlIlIlIlIIIIIIll, llllllllllllllllIlIlIlIlIIIIIIlI);
        }
    }
    
    static {
        OPTIONS_ARR = new GameSettings.Options[] { GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN, GameSettings.Options.AUTO_JUMP };
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIlIlIlIIlllIlIII, final int llllllllllllllllIlIlIlIIlllIIlll, final float llllllllllllllllIlIlIlIIlllIllII) {
        this.drawDefaultBackground();
        this.keyBindingList.drawScreen(llllllllllllllllIlIlIlIIlllIlIII, llllllllllllllllIlIlIlIIlllIIlll, llllllllllllllllIlIlIlIIlllIllII);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 8, 16777215);
        boolean llllllllllllllllIlIlIlIIlllIlIll = false;
        final int llllllllllllllllIlIlIlIIlllIIIIl;
        final byte llllllllllllllllIlIlIlIIlllIIIlI = (byte)((KeyBinding[])(Object)(llllllllllllllllIlIlIlIIlllIIIIl = (int)(Object)this.options.keyBindings)).length;
        for (Exception llllllllllllllllIlIlIlIIlllIIIll = (Exception)0; llllllllllllllllIlIlIlIIlllIIIll < llllllllllllllllIlIlIlIIlllIIIlI; ++llllllllllllllllIlIlIlIIlllIIIll) {
            final KeyBinding llllllllllllllllIlIlIlIIlllIlIlI = llllllllllllllllIlIlIlIIlllIIIIl[llllllllllllllllIlIlIlIIlllIIIll];
            if (llllllllllllllllIlIlIlIIlllIlIlI.getKeyCode() != llllllllllllllllIlIlIlIIlllIlIlI.getKeyCodeDefault()) {
                llllllllllllllllIlIlIlIIlllIlIll = true;
                break;
            }
        }
        this.buttonReset.enabled = llllllllllllllllIlIlIlIIlllIlIll;
        super.drawScreen(llllllllllllllllIlIlIlIIlllIlIII, llllllllllllllllIlIlIlIIlllIIlll, llllllllllllllllIlIlIlIIlllIllII);
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllllIlIlIlIlIIIlIIII, final int llllllllllllllllIlIlIlIlIIIlIIll, final int llllllllllllllllIlIlIlIlIIIlIIlI) throws IOException {
        if (this.buttonId != null) {
            this.options.setOptionKeyBinding(this.buttonId, -100 + llllllllllllllllIlIlIlIlIIIlIIlI);
            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (llllllllllllllllIlIlIlIlIIIlIIlI != 0 || !this.keyBindingList.mouseClicked(llllllllllllllllIlIlIlIlIIIlIIII, llllllllllllllllIlIlIlIlIIIlIIll, llllllllllllllllIlIlIlIlIIIlIIlI)) {
            super.mouseClicked(llllllllllllllllIlIlIlIlIIIlIIII, llllllllllllllllIlIlIlIlIIIlIIll, llllllllllllllllIlIlIlIlIIIlIIlI);
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllllIlIlIlIIllllllIl, final int llllllllllllllllIlIlIlIIlllllIIl) throws IOException {
        if (this.buttonId != null) {
            if (llllllllllllllllIlIlIlIIlllllIIl == 1) {
                this.options.setOptionKeyBinding(this.buttonId, 0);
            }
            else if (llllllllllllllllIlIlIlIIlllllIIl != 0) {
                this.options.setOptionKeyBinding(this.buttonId, llllllllllllllllIlIlIlIIlllllIIl);
            }
            else if (llllllllllllllllIlIlIlIIllllllIl > '\0') {
                this.options.setOptionKeyBinding(this.buttonId, llllllllllllllllIlIlIlIIllllllIl + '\u0100');
            }
            this.buttonId = null;
            this.time = Minecraft.getSystemTime();
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else {
            super.keyTyped(llllllllllllllllIlIlIlIIllllllIl, llllllllllllllllIlIlIlIIlllllIIl);
        }
    }
}
