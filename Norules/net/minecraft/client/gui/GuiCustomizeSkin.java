package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.settings.*;

public class GuiCustomizeSkin extends GuiScreen
{
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ String title;
    
    @Override
    protected void keyTyped(final char lllllllllllllIlIllllIIIIllllllll, final int lllllllllllllIlIllllIIIIlllllllI) throws IOException {
        if (lllllllllllllIlIllllIIIIlllllllI == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllllIlIllllIIIIllllllll, lllllllllllllIlIllllIIIIlllllllI);
    }
    
    private String getMessage(final EnumPlayerModelParts lllllllllllllIlIllllIIIIllIlllIl) {
        String lllllllllllllIlIllllIIIIllIlllll = null;
        if (this.mc.gameSettings.getModelParts().contains(lllllllllllllIlIllllIIIIllIlllIl)) {
            final String lllllllllllllIlIllllIIIIlllIIIII = I18n.format("options.on", new Object[0]);
        }
        else {
            lllllllllllllIlIllllIIIIllIlllll = I18n.format("options.off", new Object[0]);
        }
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllllIIIIllIlllIl.getName().getFormattedText())).append(": ").append(lllllllllllllIlIllllIIIIllIlllll));
    }
    
    public GuiCustomizeSkin(final GuiScreen lllllllllllllIlIllllIIIlIIIlIlIl) {
        this.parentScreen = lllllllllllllIlIllllIIIlIIIlIlIl;
    }
    
    @Override
    public void initGui() {
        int lllllllllllllIlIllllIIIlIIIIlIll = 0;
        this.title = I18n.format("options.skinCustomisation.title", new Object[0]);
        final Exception lllllllllllllIlIllllIIIlIIIIIlII;
        final double lllllllllllllIlIllllIIIlIIIIIlIl = ((EnumPlayerModelParts[])(Object)(lllllllllllllIlIllllIIIlIIIIIlII = (Exception)(Object)EnumPlayerModelParts.values())).length;
        for (long lllllllllllllIlIllllIIIlIIIIIllI = 0; lllllllllllllIlIllllIIIlIIIIIllI < lllllllllllllIlIllllIIIlIIIIIlIl; ++lllllllllllllIlIllllIIIlIIIIIllI) {
            final EnumPlayerModelParts lllllllllllllIlIllllIIIlIIIIlIlI = lllllllllllllIlIllllIIIlIIIIIlII[lllllllllllllIlIllllIIIlIIIIIllI];
            this.buttonList.add(new ButtonPart(lllllllllllllIlIllllIIIlIIIIlIlI.getPartId(), this.width / 2 - 155 + lllllllllllllIlIllllIIIlIIIIlIll % 2 * 160, this.height / 6 + 24 * (lllllllllllllIlIllllIIIlIIIIlIll >> 1), 150, 20, lllllllllllllIlIllllIIIlIIIIlIlI, (ButtonPart)null));
            ++lllllllllllllIlIllllIIIlIIIIlIll;
        }
        this.buttonList.add(new GuiOptionButton(199, this.width / 2 - 155 + lllllllllllllIlIllllIIIlIIIIlIll % 2 * 160, this.height / 6 + 24 * (lllllllllllllIlIllllIIIlIIIIlIll >> 1), GameSettings.Options.MAIN_HAND, this.mc.gameSettings.getKeyBinding(GameSettings.Options.MAIN_HAND)));
        if (++lllllllllllllIlIllllIIIlIIIIlIll % 2 == 1) {
            ++lllllllllllllIlIllllIIIlIIIIlIll;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 24 * (lllllllllllllIlIllllIIIlIIIIlIll >> 1), I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIlIllllIIIIllllIIll) throws IOException {
        if (lllllllllllllIlIllllIIIIllllIIll.enabled) {
            if (lllllllllllllIlIllllIIIIllllIIll.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (lllllllllllllIlIllllIIIIllllIIll.id == 199) {
                this.mc.gameSettings.setOptionValue(GameSettings.Options.MAIN_HAND, 1);
                lllllllllllllIlIllllIIIIllllIIll.displayString = this.mc.gameSettings.getKeyBinding(GameSettings.Options.MAIN_HAND);
                this.mc.gameSettings.sendSettingsToServer();
            }
            else if (lllllllllllllIlIllllIIIIllllIIll instanceof ButtonPart) {
                final EnumPlayerModelParts lllllllllllllIlIllllIIIIllllIlIl = ((ButtonPart)lllllllllllllIlIllllIIIIllllIIll).playerModelParts;
                this.mc.gameSettings.switchModelPartEnabled(lllllllllllllIlIllllIIIIllllIlIl);
                lllllllllllllIlIllllIIIIllllIIll.displayString = this.getMessage(lllllllllllllIlIllllIIIIllllIlIl);
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlIllllIIIIlllIlIII, final int lllllllllllllIlIllllIIIIlllIlIll, final float lllllllllllllIlIllllIIIIlllIlIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllllIlIllllIIIIlllIlIII, lllllllllllllIlIllllIIIIlllIlIll, lllllllllllllIlIllllIIIIlllIlIlI);
    }
    
    class ButtonPart extends GuiButton
    {
        private final /* synthetic */ EnumPlayerModelParts playerModelParts;
        
        private ButtonPart(final int lllllllllllllllIIIlllIIllIlIIlIl, final int lllllllllllllllIIIlllIIllIlIIlII, final int lllllllllllllllIIIlllIIllIIllIll, final int lllllllllllllllIIIlllIIllIlIIIlI, final int lllllllllllllllIIIlllIIllIlIIIIl, final EnumPlayerModelParts lllllllllllllllIIIlllIIllIlIIIII) {
            super(lllllllllllllllIIIlllIIllIlIIlIl, lllllllllllllllIIIlllIIllIlIIlII, lllllllllllllllIIIlllIIllIIllIll, lllllllllllllllIIIlllIIllIlIIIlI, lllllllllllllllIIIlllIIllIlIIIIl, GuiCustomizeSkin.this.getMessage(lllllllllllllllIIIlllIIllIlIIIII));
            this.playerModelParts = lllllllllllllllIIIlllIIllIlIIIII;
        }
    }
}
