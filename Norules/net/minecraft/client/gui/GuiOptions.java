package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.client.resources.*;

public class GuiOptions extends GuiScreen
{
    private /* synthetic */ GuiLockIconButton lockButton;
    private static final /* synthetic */ GameSettings.Options[] SCREEN_OPTIONS;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiButton difficultyButton;
    private final /* synthetic */ GuiScreen lastScreen;
    private final /* synthetic */ GameSettings settings;
    
    @Override
    public void drawScreen(final int llllllllllllllIlllllIIIlIlIIIIII, final int llllllllllllllIlllllIIIlIIlllIll, final float llllllllllllllIlllllIIIlIIlllIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllIlllllIIIlIlIIIIII, llllllllllllllIlllllIIIlIIlllIll, llllllllllllllIlllllIIIlIIlllIlI);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlllllIIIlIlIlIIll, final int llllllllllllllIlllllIIIlIlIIllll) throws IOException {
        if (llllllllllllllIlllllIIIlIlIIllll == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(llllllllllllllIlllllIIIlIlIlIIll, llllllllllllllIlllllIIIlIlIIllll);
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIlllllIIIlIlIllIIl, final int llllllllllllllIlllllIIIlIlIllIll) {
        this.mc.displayGuiScreen(this);
        if (llllllllllllllIlllllIIIlIlIllIll == 109 && llllllllllllllIlllllIIIlIlIllIIl && this.mc.world != null) {
            this.mc.world.getWorldInfo().setDifficultyLocked(true);
            this.lockButton.setLocked(true);
            this.lockButton.enabled = false;
            this.difficultyButton.enabled = false;
        }
    }
    
    static {
        SCREEN_OPTIONS = new GameSettings.Options[] { GameSettings.Options.FOV };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlllllIIIlIlIIlIlI) throws IOException {
        if (llllllllllllllIlllllIIIlIlIIlIlI.enabled) {
            if (llllllllllllllIlllllIIIlIlIIlIlI.id < 100 && llllllllllllllIlllllIIIlIlIIlIlI instanceof GuiOptionButton) {
                final GameSettings.Options llllllllllllllIlllllIIIlIlIIlIIl = ((GuiOptionButton)llllllllllllllIlllllIIIlIlIIlIlI).returnEnumOptions();
                this.settings.setOptionValue(llllllllllllllIlllllIIIlIlIIlIIl, 1);
                llllllllllllllIlllllIIIlIlIIlIlI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllIlllllIIIlIlIIlIlI.id));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 108) {
                this.mc.world.getWorldInfo().setDifficulty(EnumDifficulty.getDifficultyEnum(this.mc.world.getDifficulty().getDifficultyId() + 1));
                this.difficultyButton.displayString = this.getDifficultyText(this.mc.world.getDifficulty());
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 109) {
                this.mc.displayGuiScreen(new GuiYesNo(this, new TextComponentTranslation("difficulty.lock.title", new Object[0]).getFormattedText(), new TextComponentTranslation("difficulty.lock.question", new Object[] { new TextComponentTranslation(this.mc.world.getWorldInfo().getDifficulty().getDifficultyResourceKey(), new Object[0]) }).getFormattedText(), 109));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 110) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiCustomizeSkin(this));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 101) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiVideoSettings(this, this.settings));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 100) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiControls(this, this.settings));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 102) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiLanguage(this, this.settings, this.mc.getLanguageManager()));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 103) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new ScreenChatOptions(this, this.settings));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 104) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiSnooper(this, this.settings));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.lastScreen);
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 105) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenResourcePacks(this));
            }
            if (llllllllllllllIlllllIIIlIlIIlIlI.id == 106) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenOptionsSounds(this, this.settings));
            }
        }
    }
    
    public String getDifficultyText(final EnumDifficulty llllllllllllllIlllllIIIlIllIIlII) {
        final ITextComponent llllllllllllllIlllllIIIlIllIIIll = new TextComponentString("");
        llllllllllllllIlllllIIIlIllIIIll.appendSibling(new TextComponentTranslation("options.difficulty", new Object[0]));
        llllllllllllllIlllllIIIlIllIIIll.appendText(": ");
        llllllllllllllIlllllIIIlIllIIIll.appendSibling(new TextComponentTranslation(llllllllllllllIlllllIIIlIllIIlII.getDifficultyResourceKey(), new Object[0]));
        return llllllllllllllIlllllIIIlIllIIIll.getFormattedText();
    }
    
    public GuiOptions(final GuiScreen llllllllllllllIlllllIIIlIlllllll, final GameSettings llllllllllllllIlllllIIIlIllllIll) {
        this.title = "Options";
        this.lastScreen = llllllllllllllIlllllIIIlIlllllll;
        this.settings = llllllllllllllIlllllIIIlIllllIll;
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.title", new Object[0]);
        int llllllllllllllIlllllIIIlIlllIIlI = 0;
        final int llllllllllllllIlllllIIIlIllIlIIl;
        final Exception llllllllllllllIlllllIIIlIllIlIlI = (Exception)((GameSettings.Options[])(Object)(llllllllllllllIlllllIIIlIllIlIIl = (int)(Object)GuiOptions.SCREEN_OPTIONS)).length;
        for (short llllllllllllllIlllllIIIlIllIlIll = 0; llllllllllllllIlllllIIIlIllIlIll < llllllllllllllIlllllIIIlIllIlIlI; ++llllllllllllllIlllllIIIlIllIlIll) {
            final GameSettings.Options llllllllllllllIlllllIIIlIlllIIIl = llllllllllllllIlllllIIIlIllIlIIl[llllllllllllllIlllllIIIlIllIlIll];
            if (llllllllllllllIlllllIIIlIlllIIIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(llllllllllllllIlllllIIIlIlllIIIl.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllIlllllIIIlIlllIIlI % 2 * 160, this.height / 6 - 12 + 24 * (llllllllllllllIlllllIIIlIlllIIlI >> 1), llllllllllllllIlllllIIIlIlllIIIl));
            }
            else {
                final GuiOptionButton llllllllllllllIlllllIIIlIlllIIII = new GuiOptionButton(llllllllllllllIlllllIIIlIlllIIIl.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllIlllllIIIlIlllIIlI % 2 * 160, this.height / 6 - 12 + 24 * (llllllllllllllIlllllIIIlIlllIIlI >> 1), llllllllllllllIlllllIIIlIlllIIIl, this.settings.getKeyBinding(llllllllllllllIlllllIIIlIlllIIIl));
                this.buttonList.add(llllllllllllllIlllllIIIlIlllIIII);
            }
            ++llllllllllllllIlllllIIIlIlllIIlI;
        }
        if (this.mc.world != null) {
            final EnumDifficulty llllllllllllllIlllllIIIlIllIllll = this.mc.world.getDifficulty();
            this.difficultyButton = new GuiButton(108, this.width / 2 - 155 + llllllllllllllIlllllIIIlIlllIIlI % 2 * 160, this.height / 6 - 12 + 24 * (llllllllllllllIlllllIIIlIlllIIlI >> 1), 150, 20, this.getDifficultyText(llllllllllllllIlllllIIIlIllIllll));
            this.buttonList.add(this.difficultyButton);
            if (this.mc.isSingleplayer() && !this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
                this.difficultyButton.setWidth(this.difficultyButton.getButtonWidth() - 20);
                this.lockButton = new GuiLockIconButton(109, this.difficultyButton.xPosition + this.difficultyButton.getButtonWidth(), this.difficultyButton.yPosition);
                this.buttonList.add(this.lockButton);
                this.lockButton.setLocked(this.mc.world.getWorldInfo().isDifficultyLocked());
                this.lockButton.enabled = !this.lockButton.isLocked();
                this.difficultyButton.enabled = !this.lockButton.isLocked();
            }
            else {
                this.difficultyButton.enabled = false;
            }
        }
        else {
            this.buttonList.add(new GuiOptionButton(GameSettings.Options.REALMS_NOTIFICATIONS.returnEnumOrdinal(), this.width / 2 - 155 + llllllllllllllIlllllIIIlIlllIIlI % 2 * 160, this.height / 6 - 12 + 24 * (llllllllllllllIlllllIIIlIlllIIlI >> 1), GameSettings.Options.REALMS_NOTIFICATIONS, this.settings.getKeyBinding(GameSettings.Options.REALMS_NOTIFICATIONS)));
        }
        this.buttonList.add(new GuiButton(110, this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, I18n.format("options.skinCustomisation", new Object[0])));
        this.buttonList.add(new GuiButton(106, this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, I18n.format("options.sounds", new Object[0])));
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.video", new Object[0])));
        this.buttonList.add(new GuiButton(100, this.width / 2 + 5, this.height / 6 + 72 - 6, 150, 20, I18n.format("options.controls", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 - 155, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.language", new Object[0])));
        this.buttonList.add(new GuiButton(103, this.width / 2 + 5, this.height / 6 + 96 - 6, 150, 20, I18n.format("options.chat.title", new Object[0])));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 155, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.resourcepack", new Object[0])));
        this.buttonList.add(new GuiButton(104, this.width / 2 + 5, this.height / 6 + 120 - 6, 150, 20, I18n.format("options.snooper.view", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
}
