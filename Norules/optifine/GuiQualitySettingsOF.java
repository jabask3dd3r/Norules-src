package optifine;

import net.minecraft.client.settings.*;
import java.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.resources.*;

public class GuiQualitySettingsOF extends GuiScreen
{
    protected /* synthetic */ String title;
    private /* synthetic */ GuiScreen prevScreen;
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ TooltipManager tooltipManager;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIlllllIllllllIl, final int llllllllllllllIlIIlllllIllllIlIl, final float llllllllllllllIlIIlllllIllllIlII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllIlIIlllllIllllllIl, llllllllllllllIlIIlllllIllllIlIl, llllllllllllllIlIIlllllIllllIlII);
        this.tooltipManager.drawTooltips(llllllllllllllIlIIlllllIllllllIl, llllllllllllllIlIIlllllIllllIlIl, this.buttonList);
    }
    
    public GuiQualitySettingsOF(final GuiScreen llllllllllllllIlIIllllllIllIlIII, final GameSettings llllllllllllllIlIIllllllIllIIllI) {
        this.tooltipManager = new TooltipManager(this);
        this.prevScreen = llllllllllllllIlIIllllllIllIlIII;
        this.settings = llllllllllllllIlIIllllllIllIIllI;
    }
    
    static {
        GuiQualitySettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.MIPMAP_LEVELS, GameSettings.Options.MIPMAP_TYPE, GameSettings.Options.AF_LEVEL, GameSettings.Options.AA_LEVEL, GameSettings.Options.CLEAR_WATER, GameSettings.Options.RANDOM_MOBS, GameSettings.Options.BETTER_GRASS, GameSettings.Options.BETTER_SNOW, GameSettings.Options.CUSTOM_FONTS, GameSettings.Options.CUSTOM_COLORS, GameSettings.Options.SWAMP_COLORS, GameSettings.Options.SMOOTH_BIOMES, GameSettings.Options.CONNECTED_TEXTURES, GameSettings.Options.NATURAL_TEXTURES, GameSettings.Options.CUSTOM_SKY, GameSettings.Options.CUSTOM_ITEMS, GameSettings.Options.CUSTOM_ENTITY_MODELS, GameSettings.Options.CUSTOM_GUIS };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIIllllllIIIllIlI) {
        if (llllllllllllllIlIIllllllIIIllIlI.enabled) {
            if (llllllllllllllIlIIllllllIIIllIlI.id < 200 && llllllllllllllIlIIllllllIIIllIlI instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)llllllllllllllIlIIllllllIIIllIlI).returnEnumOptions(), 1);
                llllllllllllllIlIIllllllIIIllIlI.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllIlIIllllllIIIllIlI.id));
            }
            if (llllllllllllllIlIIllllllIIIllIlI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (llllllllllllllIlIIllllllIIIllIlI.id != GameSettings.Options.AA_LEVEL.ordinal()) {
                final ScaledResolution llllllllllllllIlIIllllllIIIllIII = new ScaledResolution(this.mc);
                this.setWorldAndResolution(this.mc, llllllllllllllIlIIllllllIIIllIII.getScaledWidth(), llllllllllllllIlIIllllllIIIllIII.getScaledHeight());
            }
        }
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.qualityTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllllllIlIIllllllIlIIIIII = 0; llllllllllllllIlIIllllllIlIIIIII < GuiQualitySettingsOF.enumOptions.length; ++llllllllllllllIlIIllllllIlIIIIII) {
            final GameSettings.Options llllllllllllllIlIIllllllIIlllllI = GuiQualitySettingsOF.enumOptions[llllllllllllllIlIIllllllIlIIIIII];
            final int llllllllllllllIlIIllllllIIllllII = this.width / 2 - 155 + llllllllllllllIlIIllllllIlIIIIII % 2 * 160;
            final int llllllllllllllIlIIllllllIIlllIlI = this.height / 6 + 21 * (llllllllllllllIlIIllllllIlIIIIII / 2) - 12;
            if (!llllllllllllllIlIIllllllIIlllllI.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(llllllllllllllIlIIllllllIIlllllI.returnEnumOrdinal(), llllllllllllllIlIIllllllIIllllII, llllllllllllllIlIIllllllIIlllIlI, llllllllllllllIlIIllllllIIlllllI, this.settings.getKeyBinding(llllllllllllllIlIIllllllIIlllllI)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(llllllllllllllIlIIllllllIIlllllI.returnEnumOrdinal(), llllllllllllllIlIIllllllIIllllII, llllllllllllllIlIIllllllIIlllIlI, llllllllllllllIlIIllllllIIlllllI));
            }
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
}
