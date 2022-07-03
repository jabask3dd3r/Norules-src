package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import shadersmod.client.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.resources.*;
import optifine.*;

public class GuiVideoSettings extends GuiScreenOF
{
    private static /* synthetic */ GameSettings.Options[] videoOptions;
    private /* synthetic */ GuiScreen parentGuiScreen;
    private /* synthetic */ GameSettings guiGameSettings;
    private /* synthetic */ TooltipManager tooltipManager;
    protected /* synthetic */ String screenTitle;
    
    private void actionPerformed(final GuiButton lllllllllllllIIIlIllIIlIllllllII, final int lllllllllllllIIIlIllIIllIIIIlIII) {
        if (lllllllllllllIIIlIllIIlIllllllII.enabled) {
            final int lllllllllllllIIIlIllIIllIIIIIlll = this.guiGameSettings.guiScale;
            if (lllllllllllllIIIlIllIIlIllllllII.id < 200 && lllllllllllllIIIlIllIIlIllllllII instanceof GuiOptionButton) {
                this.guiGameSettings.setOptionValue(((GuiOptionButton)lllllllllllllIIIlIllIIlIllllllII).returnEnumOptions(), lllllllllllllIIIlIllIIllIIIIlIII);
                lllllllllllllIIIlIllIIlIllllllII.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllIIIlIllIIlIllllllII.id));
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }
            if (this.guiGameSettings.guiScale != lllllllllllllIIIlIllIIllIIIIIlll) {
                final ScaledResolution lllllllllllllIIIlIllIIllIIIIIllI = new ScaledResolution(this.mc);
                final int lllllllllllllIIIlIllIIllIIIIIlIl = lllllllllllllIIIlIllIIllIIIIIllI.getScaledWidth();
                final int lllllllllllllIIIlIllIIllIIIIIlII = lllllllllllllIIIlIllIIllIIIIIllI.getScaledHeight();
                this.setWorldAndResolution(this.mc, lllllllllllllIIIlIllIIllIIIIIlIl, lllllllllllllIIIlIllIIllIIIIIlII);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 201) {
                this.mc.gameSettings.saveOptions();
                final GuiDetailSettingsOF lllllllllllllIIIlIllIIllIIIIIIll = new GuiDetailSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIllIIIIIIll);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 202) {
                this.mc.gameSettings.saveOptions();
                final GuiQualitySettingsOF lllllllllllllIIIlIllIIllIIIIIIlI = new GuiQualitySettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIllIIIIIIlI);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 211) {
                this.mc.gameSettings.saveOptions();
                final GuiAnimationSettingsOF lllllllllllllIIIlIllIIllIIIIIIIl = new GuiAnimationSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIllIIIIIIIl);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 212) {
                this.mc.gameSettings.saveOptions();
                final GuiPerformanceSettingsOF lllllllllllllIIIlIllIIllIIIIIIII = new GuiPerformanceSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIllIIIIIIII);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 222) {
                this.mc.gameSettings.saveOptions();
                final GuiOtherSettingsOF lllllllllllllIIIlIllIIlIllllllll = new GuiOtherSettingsOF(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIlIllllllll);
            }
            if (lllllllllllllIIIlIllIIlIllllllII.id == 231) {
                if (Config.isAntialiasing() || Config.isAntialiasingConfigured()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.aa1"), Lang.get("of.message.shaders.aa2"));
                    return;
                }
                if (Config.isAnisotropicFiltering()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.af1"), Lang.get("of.message.shaders.af2"));
                    return;
                }
                if (Config.isFastRender()) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.fr1"), Lang.get("of.message.shaders.fr2"));
                    return;
                }
                if (Config.getGameSettings().anaglyph) {
                    Config.showGuiMessage(Lang.get("of.message.shaders.an1"), Lang.get("of.message.shaders.an2"));
                    return;
                }
                this.mc.gameSettings.saveOptions();
                final GuiShaders lllllllllllllIIIlIllIIlIlllllllI = new GuiShaders(this, this.guiGameSettings);
                this.mc.displayGuiScreen(lllllllllllllIIIlIllIIlIlllllllI);
            }
        }
    }
    
    public GuiVideoSettings(final GuiScreen lllllllllllllIIIlIllIIllIIllIIll, final GameSettings lllllllllllllIIIlIllIIllIIlIllll) {
        this.screenTitle = "Video Settings";
        this.tooltipManager = new TooltipManager(this);
        this.parentGuiScreen = lllllllllllllIIIlIllIIllIIllIIll;
        this.guiGameSettings = lllllllllllllIIIlIllIIllIIlIllll;
    }
    
    public static void drawGradientRect(final GuiScreen lllllllllllllIIIlIllIIlIllIlIIIl, final int lllllllllllllIIIlIllIIlIllIlIIII, final int lllllllllllllIIIlIllIIlIllIIllll, final int lllllllllllllIIIlIllIIlIllIIIlll, final int lllllllllllllIIIlIllIIlIllIIIllI, final int lllllllllllllIIIlIllIIlIllIIIlIl, final int lllllllllllllIIIlIllIIlIllIIlIll) {
        lllllllllllllIIIlIllIIlIllIlIIIl.drawGradientRect(lllllllllllllIIIlIllIIlIllIlIIII, lllllllllllllIIIlIllIIlIllIIllll, lllllllllllllIIIlIllIIlIllIIIlll, lllllllllllllIIIlIllIIlIllIIIllI, lllllllllllllIIIlIllIIlIllIIIlIl, lllllllllllllIIIlIllIIlIllIIlIll);
    }
    
    @Override
    protected void actionPerformedRightClick(final GuiButton lllllllllllllIIIlIllIIllIIIlIlII) {
        if (lllllllllllllIIIlIllIIllIIIlIlII.id == GameSettings.Options.GUI_SCALE.ordinal()) {
            this.actionPerformed(lllllllllllllIIIlIllIIllIIIlIlII, -1);
        }
    }
    
    public static int getButtonWidth(final GuiButton lllllllllllllIIIlIllIIlIllIlllIl) {
        return lllllllllllllIIIlIllIIlIllIlllIl.width;
    }
    
    static {
        __OBFID = "CL_00000718";
        GuiVideoSettings.videoOptions = new GameSettings.Options[] { GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.AO_LEVEL, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.USE_VBO, GameSettings.Options.GAMMA, GameSettings.Options.ATTACK_INDICATOR, GameSettings.Options.DYNAMIC_LIGHTS, GameSettings.Options.DYNAMIC_FOV };
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIlIllIIllIIIllIlI) throws IOException {
        this.actionPerformed(lllllllllllllIIIlIllIIllIIIllIlI, 1);
    }
    
    public static int getButtonHeight(final GuiButton lllllllllllllIIIlIllIIlIllIllIIl) {
        return lllllllllllllIIIlIllIIlIllIllIIl.height;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIlIllIIlIlllIllIl, final int lllllllllllllIIIlIllIIlIlllIllII, final float lllllllllllllIIIlIllIIlIlllIlIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 16777215);
        String lllllllllllllIIIlIllIIlIlllIlIlI = Config.getVersion();
        final String lllllllllllllIIIlIllIIlIlllIlIIl = "HD_U";
        if (lllllllllllllIIIlIllIIlIlllIlIIl.equals("HD")) {
            lllllllllllllIIIlIllIIlIlllIlIlI = "OptiFine HD C6";
        }
        if (lllllllllllllIIIlIllIIlIlllIlIIl.equals("HD_U")) {
            lllllllllllllIIIlIllIIlIlllIlIlI = "OptiFine HD C6 Ultra";
        }
        if (lllllllllllllIIIlIllIIlIlllIlIIl.equals("L")) {
            lllllllllllllIIIlIllIIlIlllIlIlI = "OptiFine C6 Light";
        }
        this.drawString(this.fontRendererObj, lllllllllllllIIIlIllIIlIlllIlIlI, 2, this.height - 10, 8421504);
        final String lllllllllllllIIIlIllIIlIlllIlIII = "Minecraft 1.12.2";
        final int lllllllllllllIIIlIllIIlIlllIIlll = this.fontRendererObj.getStringWidth(lllllllllllllIIIlIllIIlIlllIlIII);
        this.drawString(this.fontRendererObj, lllllllllllllIIIlIllIIlIlllIlIII, this.width - lllllllllllllIIIlIllIIlIlllIIlll - 2, this.height - 10, 8421504);
        super.drawScreen(lllllllllllllIIIlIllIIlIlllIllIl, lllllllllllllIIIlIllIIlIlllIllII, lllllllllllllIIIlIllIIlIlllIlIll);
        this.tooltipManager.drawTooltips(lllllllllllllIIIlIllIIlIlllIllIl, lllllllllllllIIIlIllIIlIlllIllII, this.buttonList);
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("options.videoTitle", new Object[0]);
        this.buttonList.clear();
        for (int lllllllllllllIIIlIllIIllIIlIlIII = 0; lllllllllllllIIIlIllIIllIIlIlIII < GuiVideoSettings.videoOptions.length; ++lllllllllllllIIIlIllIIllIIlIlIII) {
            final GameSettings.Options lllllllllllllIIIlIllIIllIIlIIlll = GuiVideoSettings.videoOptions[lllllllllllllIIIlIllIIllIIlIlIII];
            if (lllllllllllllIIIlIllIIllIIlIIlll != null) {
                final int lllllllllllllIIIlIllIIllIIlIIllI = this.width / 2 - 155 + lllllllllllllIIIlIllIIllIIlIlIII % 2 * 160;
                final int lllllllllllllIIIlIllIIllIIlIIlIl = this.height / 6 + 21 * (lllllllllllllIIIlIllIIllIIlIlIII / 2) - 12;
                if (lllllllllllllIIIlIllIIllIIlIIlll.getEnumFloat()) {
                    this.buttonList.add(new GuiOptionSliderOF(lllllllllllllIIIlIllIIllIIlIIlll.returnEnumOrdinal(), lllllllllllllIIIlIllIIllIIlIIllI, lllllllllllllIIIlIllIIllIIlIIlIl, lllllllllllllIIIlIllIIllIIlIIlll));
                }
                else {
                    this.buttonList.add(new GuiOptionButtonOF(lllllllllllllIIIlIllIIllIIlIIlll.returnEnumOrdinal(), lllllllllllllIIIlIllIIllIIlIIllI, lllllllllllllIIIlIllIIllIIlIIlIl, lllllllllllllIIIlIllIIllIIlIIlll, this.guiGameSettings.getKeyBinding(lllllllllllllIIIlIllIIllIIlIIlll)));
                }
            }
        }
        int lllllllllllllIIIlIllIIllIIlIIlII = this.height / 6 + 21 * (GuiVideoSettings.videoOptions.length / 2) - 12;
        int lllllllllllllIIIlIllIIllIIlIIIll = 0;
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(231, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.shaders")));
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(202, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.quality")));
        lllllllllllllIIIlIllIIllIIlIIlII += 21;
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(201, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.details")));
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(212, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.performance")));
        lllllllllllllIIIlIllIIllIIlIIlII += 21;
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 0;
        this.buttonList.add(new GuiOptionButton(211, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.animations")));
        lllllllllllllIIIlIllIIllIIlIIIll = this.width / 2 - 155 + 160;
        this.buttonList.add(new GuiOptionButton(222, lllllllllllllIIIlIllIIllIIlIIIll, lllllllllllllIIIlIllIIllIIlIIlII, Lang.get("of.options.other")));
        lllllllllllllIIIlIllIIllIIlIIlII += 21;
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
}
