package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;

public class GuiAnimationSettingsOF extends GuiScreen
{
    private /* synthetic */ GameSettings settings;
    protected /* synthetic */ String title;
    private static /* synthetic */ GameSettings.Options[] enumOptions;
    private /* synthetic */ GuiScreen prevScreen;
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.animationsTitle", new Object[0]);
        this.buttonList.clear();
        for (int llllllllllllllIIlIlIIlIllIllIlIl = 0; llllllllllllllIIlIlIIlIllIllIlIl < GuiAnimationSettingsOF.enumOptions.length; ++llllllllllllllIIlIlIIlIllIllIlIl) {
            final GameSettings.Options llllllllllllllIIlIlIIlIllIllIlII = GuiAnimationSettingsOF.enumOptions[llllllllllllllIIlIlIIlIllIllIlIl];
            final int llllllllllllllIIlIlIIlIllIllIIll = this.width / 2 - 155 + llllllllllllllIIlIlIIlIllIllIlIl % 2 * 160;
            final int llllllllllllllIIlIlIIlIllIllIIlI = this.height / 6 + 21 * (llllllllllllllIIlIlIIlIllIllIlIl / 2) - 12;
            if (!llllllllllllllIIlIlIIlIllIllIlII.getEnumFloat()) {
                this.buttonList.add(new GuiOptionButtonOF(llllllllllllllIIlIlIIlIllIllIlII.returnEnumOrdinal(), llllllllllllllIIlIlIIlIllIllIIll, llllllllllllllIIlIlIIlIllIllIIlI, llllllllllllllIIlIlIIlIllIllIlII, this.settings.getKeyBinding(llllllllllllllIIlIlIIlIllIllIlII)));
            }
            else {
                this.buttonList.add(new GuiOptionSliderOF(llllllllllllllIIlIlIIlIllIllIlII.returnEnumOrdinal(), llllllllllllllIIlIlIIlIllIllIIll, llllllllllllllIIlIlIIlIllIllIIlI, llllllllllllllIIlIlIIlIllIllIlII));
            }
        }
        this.buttonList.add(new GuiButton(210, this.width / 2 - 155, this.height / 6 + 168 + 11, 70, 20, Lang.get("of.options.animation.allOn")));
        this.buttonList.add(new GuiButton(211, this.width / 2 - 155 + 80, this.height / 6 + 168 + 11, 70, 20, Lang.get("of.options.animation.allOff")));
        this.buttonList.add(new GuiOptionButton(200, this.width / 2 + 5, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }
    
    static {
        GuiAnimationSettingsOF.enumOptions = new GameSettings.Options[] { GameSettings.Options.ANIMATED_WATER, GameSettings.Options.ANIMATED_LAVA, GameSettings.Options.ANIMATED_FIRE, GameSettings.Options.ANIMATED_PORTAL, GameSettings.Options.ANIMATED_REDSTONE, GameSettings.Options.ANIMATED_EXPLOSION, GameSettings.Options.ANIMATED_FLAME, GameSettings.Options.ANIMATED_SMOKE, GameSettings.Options.VOID_PARTICLES, GameSettings.Options.WATER_PARTICLES, GameSettings.Options.RAIN_SPLASH, GameSettings.Options.PORTAL_PARTICLES, GameSettings.Options.POTION_PARTICLES, GameSettings.Options.DRIPPING_WATER_LAVA, GameSettings.Options.ANIMATED_TERRAIN, GameSettings.Options.ANIMATED_TEXTURES, GameSettings.Options.FIREWORK_PARTICLES, GameSettings.Options.PARTICLES };
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIlIIlIllIlIlIII) {
        if (llllllllllllllIIlIlIIlIllIlIlIII.enabled) {
            if (llllllllllllllIIlIlIIlIllIlIlIII.id < 200 && llllllllllllllIIlIlIIlIllIlIlIII instanceof GuiOptionButton) {
                this.settings.setOptionValue(((GuiOptionButton)llllllllllllllIIlIlIIlIllIlIlIII).returnEnumOptions(), 1);
                llllllllllllllIIlIlIIlIllIlIlIII.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(llllllllllllllIIlIlIIlIllIlIlIII.id));
            }
            if (llllllllllllllIIlIlIIlIllIlIlIII.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.prevScreen);
            }
            if (llllllllllllllIIlIlIIlIllIlIlIII.id == 210) {
                this.mc.gameSettings.setAllAnimations(true);
            }
            if (llllllllllllllIIlIlIIlIllIlIlIII.id == 211) {
                this.mc.gameSettings.setAllAnimations(false);
            }
            final ScaledResolution llllllllllllllIIlIlIIlIllIlIIlll = new ScaledResolution(this.mc);
            this.setWorldAndResolution(this.mc, llllllllllllllIIlIlIIlIllIlIIlll.getScaledWidth(), llllllllllllllIIlIlIIlIllIlIIlll.getScaledHeight());
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIlIIlIllIIllIlI, final int llllllllllllllIIlIlIIlIllIIlllIl, final float llllllllllllllIIlIlIIlIllIIlllII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(llllllllllllllIIlIlIIlIllIIllIlI, llllllllllllllIIlIlIIlIllIIlllIl, llllllllllllllIIlIlIIlIllIIlllII);
    }
    
    public GuiAnimationSettingsOF(final GuiScreen llllllllllllllIIlIlIIlIllIllllIl, final GameSettings llllllllllllllIIlIlIIlIllIllllII) {
        this.prevScreen = llllllllllllllIIlIlIIlIllIllllIl;
        this.settings = llllllllllllllIIlIlIIlIllIllllII;
    }
}
