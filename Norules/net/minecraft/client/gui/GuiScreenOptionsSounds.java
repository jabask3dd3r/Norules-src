package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;

public class GuiScreenOptionsSounds extends GuiScreen
{
    protected /* synthetic */ String title;
    private /* synthetic */ String offDisplayString;
    private final /* synthetic */ GameSettings game_settings_4;
    private final /* synthetic */ GuiScreen parent;
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.sounds.title", new Object[0]);
        this.offDisplayString = I18n.format("options.off", new Object[0]);
        int lllllllllllllIIIlIllIIIIIlIIlIll = 0;
        this.buttonList.add(new Button(SoundCategory.MASTER.ordinal(), this.width / 2 - 155 + lllllllllllllIIIlIllIIIIIlIIlIll % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllllIIIlIllIIIIIlIIlIll >> 1), SoundCategory.MASTER, true));
        lllllllllllllIIIlIllIIIIIlIIlIll += 2;
        Exception lllllllllllllIIIlIllIIIIIlIIIIlI;
        for (byte lllllllllllllIIIlIllIIIIIlIIIIll = (byte)((SoundCategory[])(Object)(lllllllllllllIIIlIllIIIIIlIIIIlI = (Exception)(Object)SoundCategory.values())).length, b = 0; b < lllllllllllllIIIlIllIIIIIlIIIIll; ++b) {
            final SoundCategory lllllllllllllIIIlIllIIIIIlIIlIlI = lllllllllllllIIIlIllIIIIIlIIIIlI[b];
            if (lllllllllllllIIIlIllIIIIIlIIlIlI != SoundCategory.MASTER) {
                this.buttonList.add(new Button(lllllllllllllIIIlIllIIIIIlIIlIlI.ordinal(), this.width / 2 - 155 + lllllllllllllIIIlIllIIIIIlIIlIll % 2 * 160, this.height / 6 - 12 + 24 * (lllllllllllllIIIlIllIIIIIlIIlIll >> 1), lllllllllllllIIIlIllIIIIIlIIlIlI, false));
                ++lllllllllllllIIIlIllIIIIIlIIlIll;
            }
        }
        final int lllllllllllllIIIlIllIIIIIlIIlIIl = this.width / 2 - 75;
        final int lllllllllllllIIIlIllIIIIIlIIlIII = this.height / 6 - 12;
        ++lllllllllllllIIIlIllIIIIIlIIlIll;
        this.buttonList.add(new GuiOptionButton(201, lllllllllllllIIIlIllIIIIIlIIlIIl, lllllllllllllIIIlIllIIIIIlIIlIII + 24 * (lllllllllllllIIIlIllIIIIIlIIlIll >> 1), GameSettings.Options.SHOW_SUBTITLES, this.game_settings_4.getKeyBinding(GameSettings.Options.SHOW_SUBTITLES)));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIlIllIIIIIIllIlIl) throws IOException {
        if (lllllllllllllIIIlIllIIIIIIllIlIl.enabled) {
            if (lllllllllllllIIIlIllIIIIIIllIlIl.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parent);
            }
            else if (lllllllllllllIIIlIllIIIIIIllIlIl.id == 201) {
                this.mc.gameSettings.setOptionValue(GameSettings.Options.SHOW_SUBTITLES, 1);
                lllllllllllllIIIlIllIIIIIIllIlIl.displayString = this.mc.gameSettings.getKeyBinding(GameSettings.Options.SHOW_SUBTITLES);
                this.mc.gameSettings.saveOptions();
            }
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIIlIllIIIIIIllllIl, final int lllllllllllllIIIlIllIIIIIIlllIIl) throws IOException {
        if (lllllllllllllIIIlIllIIIIIIlllIIl == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllllIIIlIllIIIIIIllllIl, lllllllllllllIIIlIllIIIIIIlllIIl);
    }
    
    protected String getDisplayString(final SoundCategory lllllllllllllIIIlIllIIIIIIlIIIlI) {
        final float lllllllllllllIIIlIllIIIIIIlIIIIl = this.game_settings_4.getSoundLevel(lllllllllllllIIIlIllIIIIIIlIIIlI);
        return (lllllllllllllIIIlIllIIIIIIlIIIIl == 0.0f) ? this.offDisplayString : String.valueOf(new StringBuilder(String.valueOf((int)(lllllllllllllIIIlIllIIIIIIlIIIIl * 100.0f))).append("%"));
    }
    
    public GuiScreenOptionsSounds(final GuiScreen lllllllllllllIIIlIllIIIIIlIlIlll, final GameSettings lllllllllllllIIIlIllIIIIIlIlIllI) {
        this.title = "Options";
        this.parent = lllllllllllllIIIlIllIIIIIlIlIlll;
        this.game_settings_4 = lllllllllllllIIIlIllIIIIIlIlIllI;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIlIllIIIIIIlIlIIl, final int lllllllllllllIIIlIllIIIIIIlIlIII, final float lllllllllllllIIIlIllIIIIIIlIlIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        super.drawScreen(lllllllllllllIIIlIllIIIIIIlIlIIl, lllllllllllllIIIlIllIIIIIIlIlIII, lllllllllllllIIIlIllIIIIIIlIlIll);
    }
    
    class Button extends GuiButton
    {
        private final /* synthetic */ SoundCategory category;
        private final /* synthetic */ String categoryName;
        public /* synthetic */ float volume;
        public /* synthetic */ boolean pressed;
        
        @Override
        public void playPressSound(final SoundHandler lllllllllllllIlIllIIIllIllIIlllI) {
        }
        
        @Override
        protected int getHoverState(final boolean lllllllllllllIlIllIIIllIlllIIllI) {
            return 0;
        }
        
        @Override
        protected void mouseDragged(final Minecraft lllllllllllllIlIllIIIllIlllIIIIl, final int lllllllllllllIlIllIIIllIlllIIIII, final int lllllllllllllIlIllIIIllIllIlllll) {
            if (this.visible) {
                if (this.pressed) {
                    this.volume = (lllllllllllllIlIllIIIllIlllIIIII - (this.xPosition + 4)) / (float)(this.width - 8);
                    this.volume = MathHelper.clamp(this.volume, 0.0f, 1.0f);
                    lllllllllllllIlIllIIIllIlllIIIIl.gameSettings.setSoundLevel(this.category, this.volume);
                    lllllllllllllIlIllIIIllIlllIIIIl.gameSettings.saveOptions();
                    this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.categoryName)).append(": ").append(GuiScreenOptionsSounds.this.getDisplayString(this.category)));
                }
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.drawTexturedModalRect(this.xPosition + (int)(this.volume * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
                this.drawTexturedModalRect(this.xPosition + (int)(this.volume * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
            }
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllIlIllIIIllIllIIlIll, final int lllllllllllllIlIllIIIllIllIIlIlI) {
            if (this.pressed) {
                GuiScreenOptionsSounds.this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            }
            this.pressed = false;
        }
        
        public Button(final int lllllllllllllIlIllIIIllIlllIllII, final int lllllllllllllIlIllIIIllIlllIlIll, final int lllllllllllllIlIllIIIllIlllIlIlI, final SoundCategory lllllllllllllIlIllIIIllIllllIIII, final boolean lllllllllllllIlIllIIIllIlllIllll) {
            super(lllllllllllllIlIllIIIllIlllIllII, lllllllllllllIlIllIIIllIlllIlIll, lllllllllllllIlIllIIIllIlllIlIlI, lllllllllllllIlIllIIIllIlllIllll ? 310 : 150, 20, "");
            this.volume = 1.0f;
            this.category = lllllllllllllIlIllIIIllIllllIIII;
            this.categoryName = I18n.format(String.valueOf(new StringBuilder("soundCategory.").append(lllllllllllllIlIllIIIllIllllIIII.getName())), new Object[0]);
            this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.categoryName)).append(": ").append(GuiScreenOptionsSounds.this.getDisplayString(lllllllllllllIlIllIIIllIllllIIII)));
            this.volume = GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(lllllllllllllIlIllIIIllIllllIIII);
        }
        
        @Override
        public boolean mousePressed(final Minecraft lllllllllllllIlIllIIIllIllIlIllI, final int lllllllllllllIlIllIIIllIllIlIIIl, final int lllllllllllllIlIllIIIllIllIlIIII) {
            if (super.mousePressed(lllllllllllllIlIllIIIllIllIlIllI, lllllllllllllIlIllIIIllIllIlIIIl, lllllllllllllIlIllIIIllIllIlIIII)) {
                this.volume = (lllllllllllllIlIllIIIllIllIlIIIl - (this.xPosition + 4)) / (float)(this.width - 8);
                this.volume = MathHelper.clamp(this.volume, 0.0f, 1.0f);
                lllllllllllllIlIllIIIllIllIlIllI.gameSettings.setSoundLevel(this.category, this.volume);
                lllllllllllllIlIllIIIllIllIlIllI.gameSettings.saveOptions();
                this.displayString = String.valueOf(new StringBuilder(String.valueOf(this.categoryName)).append(": ").append(GuiScreenOptionsSounds.this.getDisplayString(this.category)));
                this.pressed = true;
                return true;
            }
            return false;
        }
    }
}
