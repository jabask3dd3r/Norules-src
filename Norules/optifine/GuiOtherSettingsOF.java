package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.gui.*;

public class GuiOtherSettingsOF extends GuiScreen implements GuiYesNoCallback
{
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ TooltipManager tooltipManager;
    private /* synthetic */ GuiScreen prevScreen;
    protected /* synthetic */ String title;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.otherTitle", new Object[0]);
        this.buttonList.clear();
        for (int lIIlllIIlllllI = 0; lIIlllIIlllllI < GuiOtherSettingsOF.enumOptions.length; ++lIIlllIIlllllI) {
            final GameSettings.Options lIIlllIIllllIl = GuiOtherSettingsOF.enumOptions[lIIlllIIlllllI];
            final int lIIlllIIllllII = this.width / 2 - 155 + lIIlllIIlllllI % 2 * 160;
            final int lIIlllIIlllIll = this.height / 6 + 21 * (lIIlllIIlllllI / 2) - 12;
            if (!lIIlllIIllllIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(lIIlllIIllllIl.returnEnumOrdinal(), lIIlllIIllllII, lIIlllIIlllIll, lIIlllIIllllIl, this.settings.getKeyBinding(lIIlllIIllllIl)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(lIIlllIIllllIl.returnEnumOrdinal(), lIIlllIIllllII, lIIlllIIlllIll, lIIlllIIllllIl));
            }
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 100, this.height / 6 + 168 + 11 - 44, I18n.format("of.options.other.reset", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    public GuiOtherSettingsOF(final GuiScreen lIIlllIlIIlIIl, final GameSettings lIIlllIlIIlIII) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = lIIlllIlIIlIIl;
        this.settings = lIIlllIlIIlIII;
    }
    
    @Override
    public void confirmClicked(final boolean lIIlllIIlIIllI, final int lIIlllIIlIlIII) {
        if (lIIlllIIlIIllI) {
            this.mc.gameSettings.resetSettings();
        }
        this.mc.displayGuiScreen(this);
    }
    
    static {
        GuiOtherSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.LAGOMETER, GameSettings.Options.PROFILER, GameSettings.Options.SHOW_FPS, GameSettings.Options.ADVANCED_TOOLTIPS, GameSettings.Options.WEATHER, GameSettings.Options.TIME, GameSettings.Options.USE_FULLSCREEN, GameSettings.Options.FULLSCREEN_MODE, GameSettings.Options.ANAGLYPH, GameSettings.Options.AUTOSAVE_TICKS, GameSettings.Options.SCREENSHOT_SIZE };
    }
    
    @Override
    public void drawScreen(final int lIIlllIIIlllII, final int lIIlllIIIlllll, final float lIIlllIIIllIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lIIlllIIIlllII, lIIlllIIIlllll, lIIlllIIIllIlI);
        this.tooltipManager.drawTooltips(lIIlllIIIlllII, lIIlllIIIlllll, this.buttonList);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lIIlllIIlIlllI) {
        if (lIIlllIIlIlllI.enabled) {
            if (lIIlllIIlIlllI.id < 200 && lIIlllIIlIlllI instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)lIIlllIIlIlllI).returnEnumOptions(), 1);
                lIIlllIIlIlllI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lIIlllIIlIlllI.id));
            }
            if (lIIlllIIlIlllI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (lIIlllIIlIlllI.id == 210) {
                this.mc.gameSettings.saveOptions();
                final GuiYesNo lIIlllIIllIIII = new GuiYesNo(this, I18n.format("of.message.other.reset", new Object[0]), "", 9999);
                this.mc.displayGuiScreen(lIIlllIIllIIII);
            }
        }
    }
}
