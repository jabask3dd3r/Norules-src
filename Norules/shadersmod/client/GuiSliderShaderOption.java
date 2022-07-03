package shadersmod.client;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class GuiSliderShaderOption extends GuiButtonShaderOption
{
    private /* synthetic */ float sliderValue;
    private /* synthetic */ ShaderOption shaderOption;
    public /* synthetic */ boolean dragging;
    
    @Override
    protected int getHoverState(final boolean lllllllllllllllIIIlIlllIIlIllIll) {
        return 0;
    }
    
    @Override
    public void valueChanged() {
        this.sliderValue = this.shaderOption.getIndexNormalized();
    }
    
    public GuiSliderShaderOption(final int lllllllllllllllIIIlIlllIIllIlIll, final int lllllllllllllllIIIlIlllIIllIlIlI, final int lllllllllllllllIIIlIlllIIllIlIIl, final int lllllllllllllllIIIlIlllIIllIIIII, final int lllllllllllllllIIIlIlllIIlIlllll, final ShaderOption lllllllllllllllIIIlIlllIIlIllllI, final String lllllllllllllllIIIlIlllIIlIlllIl) {
        super(lllllllllllllllIIIlIlllIIllIlIll, lllllllllllllllIIIlIlllIIllIlIlI, lllllllllllllllIIIlIlllIIllIlIIl, lllllllllllllllIIIlIlllIIllIIIII, lllllllllllllllIIIlIlllIIlIlllll, lllllllllllllllIIIlIlllIIlIllllI, lllllllllllllllIIIlIlllIIlIlllIl);
        this.sliderValue = 1.0f;
        this.shaderOption = null;
        this.shaderOption = lllllllllllllllIIIlIlllIIlIllllI;
        this.sliderValue = lllllllllllllllIIIlIlllIIlIllllI.getIndexNormalized();
        this.displayString = GuiShaderOptions.getButtonText(lllllllllllllllIIIlIlllIIlIllllI, this.width);
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllllIIIlIlllIIlIIIIlI, final int lllllllllllllllIIIlIlllIIlIIIIIl) {
        this.dragging = false;
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllllIIIlIlllIIlIIlIll, final int lllllllllllllllIIIlIlllIIlIIlIlI, final int lllllllllllllllIIIlIlllIIlIIIlIl) {
        if (super.mousePressed(lllllllllllllllIIIlIlllIIlIIlIll, lllllllllllllllIIIlIlllIIlIIlIlI, lllllllllllllllIIIlIlllIIlIIIlIl)) {
            this.sliderValue = (lllllllllllllllIIIlIlllIIlIIlIlI - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
            this.shaderOption.setIndexNormalized(this.sliderValue);
            this.displayString = GuiShaderOptions.getButtonText(this.shaderOption, this.width);
            this.dragging = true;
            return true;
        }
        return false;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lllllllllllllllIIIlIlllIIlIlIllI, final int lllllllllllllllIIIlIlllIIlIlIIIl, final int lllllllllllllllIIIlIlllIIlIlIlII) {
        if (this.visible) {
            if (this.dragging) {
                this.sliderValue = (lllllllllllllllIIIlIlllIIlIlIIIl - (this.xPosition + 4)) / (float)(this.width - 8);
                this.sliderValue = MathHelper.clamp(this.sliderValue, 0.0f, 1.0f);
                this.shaderOption.setIndexNormalized(this.sliderValue);
                this.sliderValue = this.shaderOption.getIndexNormalized();
                this.displayString = GuiShaderOptions.getButtonText(this.shaderOption, this.width);
            }
            lllllllllllllllIIIlIlllIIlIlIllI.getTextureManager().bindTexture(GuiSliderShaderOption.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
}
