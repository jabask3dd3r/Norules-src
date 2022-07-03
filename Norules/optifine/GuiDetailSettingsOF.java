package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.*;
import java.util.*;

public class GuiDetailSettingsOF extends GuiScreen
{
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    protected /* synthetic */ String title;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ TooltipManager tooltipManager;
    private /* synthetic */ GuiScreen prevScreen;
    
    public GuiDetailSettingsOF(final GuiScreen lllllllllllllIIIllIlIlIllIllllII, final GameSettings lllllllllllllIIIllIlIlIllIlllIll) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = lllllllllllllIIIllIlIlIllIllllII;
        this.settings = lllllllllllllIIIllIlIlIllIlllIll;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIllIlIlIllIlIIIll) {
        if (lllllllllllllIIIllIlIlIllIlIIIll.enabled) {
            if (lllllllllllllIIIllIlIlIllIlIIIll.id < 200 && lllllllllllllIIIllIlIlIllIlIIIll instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)lllllllllllllIIIllIlIlIllIlIIIll).returnEnumOptions(), 1);
                lllllllllllllIIIllIlIlIllIlIIIll.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllIIIllIlIlIllIlIIIll.id));
            }
            if (lllllllllllllIIIllIlIlIllIlIIIll.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.detailsTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllIIIllIlIlIllIllIIIl = 0; lllllllllllllIIIllIlIlIllIllIIIl < GuiDetailSettingsOF.enumOptions.length; ++lllllllllllllIIIllIlIlIllIllIIIl) {
            final GameSettings.Options lllllllllllllIIIllIlIlIllIllIIII = GuiDetailSettingsOF.enumOptions[lllllllllllllIIIllIlIlIllIllIIIl];
            final int lllllllllllllIIIllIlIlIllIlIllll = this.width / 2 - 155 + lllllllllllllIIIllIlIlIllIllIIIl % 2 * 160;
            final int lllllllllllllIIIllIlIlIllIlIlllI = this.height / 6 + 21 * (lllllllllllllIIIllIlIlIllIllIIIl / 2) - 12;
            if (!lllllllllllllIIIllIlIlIllIllIIII.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(lllllllllllllIIIllIlIlIllIllIIII.returnEnumOrdinal(), lllllllllllllIIIllIlIlIllIlIllll, lllllllllllllIIIllIlIlIllIlIlllI, lllllllllllllIIIllIlIlIllIllIIII, this.settings.getKeyBinding(lllllllllllllIIIllIlIlIllIllIIII)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(lllllllllllllIIIllIlIlIllIllIIII.returnEnumOrdinal(), lllllllllllllIIIllIlIlIllIlIllll, lllllllllllllIIIllIlIlIllIlIlllI, lllllllllllllIIIllIlIlIllIllIIII));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIllIlIlIllIIlllIl, final int lllllllllllllIIIllIlIlIllIIlllII, final float lllllllllllllIIIllIlIlIllIIllIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllIIIllIlIlIllIIlllIl, lllllllllllllIIIllIlIlIllIIlllII, lllllllllllllIIIllIlIlIllIIllIll);
        this.tooltipManager.drawTooltips(lllllllllllllIIIllIlIlIllIIlllIl, lllllllllllllIIIllIlIlIllIIlllII, this.buttonList);
    }
    
    static {
        GuiDetailSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.CLOUDS, GameSettings.Options.CLOUD_HEIGHT, GameSettings.Options.TREES, GameSettings.Options.RAIN, GameSettings.Options.SKY, GameSettings.Options.STARS, GameSettings.Options.SUN_MOON, GameSettings.Options.SHOW_CAPES, GameSettings.Options.FOG_FANCY, GameSettings.Options.FOG_START, GameSettings.Options.TRANSLUCENT_BLOCKS, GameSettings.Options.HELD_ITEM_TOOLTIPS, GameSettings.Options.DROPPED_ITEMS, GameSettings.Options.ENTITY_SHADOWS, GameSettings.Options.VIGNETTE, GameSettings.Options.ALTERNATE_BLOCKS };
    }
}
