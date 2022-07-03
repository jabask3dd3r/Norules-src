package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class GuiOptionSlider extends GuiButton
{
    private final /* synthetic */ float maxValue;
    private /* synthetic */ float sliderValue;
    private final /* synthetic */ GameSettings.Options options;
    private final /* synthetic */ float minValue;
    public /* synthetic */ boolean dragging;
    
    public GuiOptionSlider(final int lllllllllllllllIllIIlllIIIIIlIlI, final int lllllllllllllllIllIIlllIIIIIlllI, final int lllllllllllllllIllIIlllIIIIIllIl, final GameSettings.Options lllllllllllllllIllIIlllIIIIIIlll) {
        this(lllllllllllllllIllIIlllIIIIIlIlI, lllllllllllllllIllIIlllIIIIIlllI, lllllllllllllllIllIIlllIIIIIllIl, lllllllllllllllIllIIlllIIIIIIlll, 0.0f, 1.0f);
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllllIllIIllIlllIlIIIl, final int lllllllllllllllIllIIllIlllIlIIII) {
        this.dragging = false;
    }
    
    @Override
    protected int getHoverState(final boolean lllllllllllllllIllIIllIllllIllIl) {
        return 0;
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllllIllIIllIlllIlIllI, final int lllllllllllllllIllIIllIlllIlIlIl, final int lllllllllllllllIllIIllIlllIllIII) {
        if (super.mousePressed(lllllllllllllllIllIIllIlllIlIllI, lllllllllllllllIllIIllIlllIlIlIl, lllllllllllllllIllIIllIlllIllIII)) {
            this.sliderValue = (lllllllllllllllIllIIllIlllIlIlIl - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
            lllllllllllllllIllIIllIlllIlIllI.gameSettings.setOptionFloatValue(this.options, this.options.denormalizeValue(this.sliderValue));
            this.displayString = lllllllllllllllIllIIllIlllIlIllI.gameSettings.getKeyBinding(this.options);
            this.dragging = true;
            return true;
        }
        return false;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lllllllllllllllIllIIllIllllIIlll, final int lllllllllllllllIllIIllIllllIIllI, final int lllllllllllllllIllIIllIllllIIlIl) {
        if (this.visible) {
            if (this.dragging) {
                this.sliderValue = (lllllllllllllllIllIIllIllllIIllI - (this.xPosition + 4)) / (float)(this.width - 8);
                this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
                final float lllllllllllllllIllIIllIllllIIlII = this.options.denormalizeValue(this.sliderValue);
                lllllllllllllllIllIIllIllllIIlll.gameSettings.setOptionFloatValue(this.options, lllllllllllllllIllIIllIllllIIlII);
                this.sliderValue = this.options.normalizeValue(lllllllllllllllIllIIllIllllIIlII);
                this.displayString = lllllllllllllllIllIIllIllllIIlll.gameSettings.getKeyBinding(this.options);
            }
            lllllllllllllllIllIIllIllllIIlll.getTextureManager().bindTexture(GuiOptionSlider.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
    
    public GuiOptionSlider(final int lllllllllllllllIllIIllIlllllIlIl, final int lllllllllllllllIllIIllIlllllllII, final int lllllllllllllllIllIIllIlllllIIll, final GameSettings.Options lllllllllllllllIllIIllIllllllIlI, final float lllllllllllllllIllIIllIllllllIIl, final float lllllllllllllllIllIIllIlllllIIII) {
        super(lllllllllllllllIllIIllIlllllIlIl, lllllllllllllllIllIIllIlllllllII, lllllllllllllllIllIIllIlllllIIll, 150, 20, "");
        this.sliderValue = 1.0f;
        this.options = lllllllllllllllIllIIllIllllllIlI;
        this.minValue = lllllllllllllllIllIIllIllllllIIl;
        this.maxValue = lllllllllllllllIllIIllIlllllIIII;
        final Minecraft lllllllllllllllIllIIllIlllllIlll = Minecraft.getMinecraft();
        this.sliderValue = lllllllllllllllIllIIllIllllllIlI.normalizeValue(lllllllllllllllIllIIllIlllllIlll.gameSettings.getOptionFloatValue(lllllllllllllllIllIIllIllllllIlI));
        this.displayString = lllllllllllllllIllIIllIlllllIlll.gameSettings.getKeyBinding(lllllllllllllllIllIIllIllllllIlI);
    }
}
