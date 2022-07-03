package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class GuiPerformanceSettingsOF extends GuiScreen
{
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ GuiScreen prevScreen;
    private /* synthetic */ TooltipManager tooltipManager;
    protected /* synthetic */ String title;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.performanceTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllIlIIIIllIIlIlIllIlI = 0; lllllllllllllIlIIIIllIIlIlIllIlI < GuiPerformanceSettingsOF.enumOptions.length; ++lllllllllllllIlIIIIllIIlIlIllIlI) {
            final GameSettings.Options lllllllllllllIlIIIIllIIlIlIllIIl = GuiPerformanceSettingsOF.enumOptions[lllllllllllllIlIIIIllIIlIlIllIlI];
            final int lllllllllllllIlIIIIllIIlIlIllIII = this.width / 2 - 155 + lllllllllllllIlIIIIllIIlIlIllIlI % 2 * 160;
            final int lllllllllllllIlIIIIllIIlIlIlIlll = this.height / 6 + 21 * (lllllllllllllIlIIIIllIIlIlIllIlI / 2) - 12;
            if (!lllllllllllllIlIIIIllIIlIlIllIIl.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(lllllllllllllIlIIIIllIIlIlIllIIl.returnEnumOrdinal(), lllllllllllllIlIIIIllIIlIlIllIII, lllllllllllllIlIIIIllIIlIlIlIlll, lllllllllllllIlIIIIllIIlIlIllIIl, this.settings.getKeyBinding(lllllllllllllIlIIIIllIIlIlIllIIl)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(lllllllllllllIlIIIIllIIlIlIllIIl.returnEnumOrdinal(), lllllllllllllIlIIIIllIIlIlIllIII, lllllllllllllIlIIIIllIIlIlIlIlll, lllllllllllllIlIIIIllIIlIlIllIIl));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIlIIIIllIIlIlIIlllI) {
        if (lllllllllllllIlIIIIllIIlIlIIlllI.enabled) {
            if (lllllllllllllIlIIIIllIIlIlIIlllI.id < 200 && lllllllllllllIlIIIIllIIlIlIIlllI instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)lllllllllllllIlIIIIllIIlIlIIlllI).returnEnumOptions(), 1);
                lllllllllllllIlIIIIllIIlIlIIlllI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllIlIIIIllIIlIlIIlllI.id));
            }
            if (lllllllllllllIlIIIIllIIlIlIIlllI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
    
    static {
        GuiPerformanceSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.SMOOTH_FPS, GameSettings.Options.SMOOTH_WORLD, GameSettings.Options.FAST_RENDER, GameSettings.Options.FAST_MATH, GameSettings.Options.CHUNK_UPDATES, GameSettings.Options.CHUNK_UPDATES_DYNAMIC, GameSettings.Options.LAZY_CHUNK_LOADING };
    }
    
    public GuiPerformanceSettingsOF(final GuiScreen lllllllllllllIlIIIIllIIlIllIIIlI, final GameSettings lllllllllllllIlIIIIllIIlIllIIIIl) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = lllllllllllllIlIIIIllIIlIllIIIlI;
        this.settings = lllllllllllllIlIIIIllIIlIllIIIIl;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlIIIIllIIlIlIIIllI, final int lllllllllllllIlIIIIllIIlIlIIIIIl, final float lllllllllllllIlIIIIllIIlIlIIIIII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllIlIIIIllIIlIlIIIllI, lllllllllllllIlIIIIllIIlIlIIIIIl, lllllllllllllIlIIIIllIIlIlIIIIII);
        this.tooltipManager.drawTooltips(lllllllllllllIlIIIIllIIlIlIIIllI, lllllllllllllIlIIIIllIIlIlIIIIIl, this.buttonList);
    }
}
