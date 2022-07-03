package net.minecraft.realms;

import net.minecraft.util.math.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class RealmsSliderButton extends RealmsButton
{
    private final /* synthetic */ float maxValue;
    public /* synthetic */ boolean sliding;
    public /* synthetic */ float value;
    private /* synthetic */ int steps;
    private final /* synthetic */ float minValue;
    
    @Override
    public void released(final int lllllllllllllllllIlIIIllIIllIlIl, final int lllllllllllllllllIlIIIllIIllIlII) {
        this.sliding = false;
    }
    
    public float toPct(final float lllllllllllllllllIlIIIllIllIIIIl) {
        return MathHelper.clamp((this.clamp(lllllllllllllllllIlIIIllIllIIIIl) - this.minValue) / (this.maxValue - this.minValue), 0.0f, 1.0f);
    }
    
    public void clicked(final float lllllllllllllllllIlIIIllIIlllIII) {
    }
    
    public float clamp(float lllllllllllllllllIlIIIllIlIlIIll) {
        lllllllllllllllllIlIIIllIlIlIIll = this.clampSteps(lllllllllllllllllIlIIIllIlIlIIll);
        return MathHelper.clamp(lllllllllllllllllIlIIIllIlIlIIll, this.minValue, this.maxValue);
    }
    
    @Override
    public void clicked(final int lllllllllllllllllIlIIIllIIlllIlI, final int lllllllllllllllllIlIIIllIIllllII) {
        this.value = (lllllllllllllllllIlIIIllIIlllIlI - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
        this.value = MathHelper.clamp(this.value, 0.0f, 1.0f);
        this.clicked(this.toValue(this.value));
        this.getProxy().displayString = this.getMessage();
        this.sliding = true;
    }
    
    public RealmsSliderButton(final int lllllllllllllllllIlIIIllIllIllII, final int lllllllllllllllllIlIIIllIllIlIll, final int lllllllllllllllllIlIIIllIllIlIlI, final int lllllllllllllllllIlIIIllIlllIIlI, final int lllllllllllllllllIlIIIllIlllIIIl, final int lllllllllllllllllIlIIIllIlllIIII, final float lllllllllllllllllIlIIIllIllIllll, final float lllllllllllllllllIlIIIllIllIIllI) {
        super(lllllllllllllllllIlIIIllIllIllII, lllllllllllllllllIlIIIllIllIlIll, lllllllllllllllllIlIIIllIllIlIlI, lllllllllllllllllIlIIIllIlllIIlI, 20, "");
        this.value = 1.0f;
        this.minValue = lllllllllllllllllIlIIIllIllIllll;
        this.maxValue = lllllllllllllllllIlIIIllIllIIllI;
        this.value = this.toPct((float)lllllllllllllllllIlIIIllIlllIIII);
        this.getProxy().displayString = this.getMessage();
    }
    
    @Override
    public void renderBg(final int lllllllllllllllllIlIIIllIlIIIllI, final int lllllllllllllllllIlIIIllIlIIIlIl) {
        if (this.getProxy().visible) {
            if (this.sliding) {
                this.value = (lllllllllllllllllIlIIIllIlIIIllI - (this.getProxy().xPosition + 4)) / (float)(this.getProxy().getButtonWidth() - 8);
                this.value = MathHelper.clamp(this.value, 0.0f, 1.0f);
                final float lllllllllllllllllIlIIIllIlIIIlII = this.toValue(this.value);
                this.clicked(lllllllllllllllllIlIIIllIlIIIlII);
                this.value = this.toPct(lllllllllllllllllIlIIIllIlIIIlII);
                this.getProxy().displayString = this.getMessage();
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(RealmsSliderButton.WIDGETS_LOCATION);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)), this.getProxy().yPosition, 0, 66, 4, 20);
            this.blit(this.getProxy().xPosition + (int)(this.value * (this.getProxy().getButtonWidth() - 8)) + 4, this.getProxy().yPosition, 196, 66, 4, 20);
        }
    }
    
    public String getMessage() {
        return "";
    }
    
    protected float clampSteps(float lllllllllllllllllIlIIIllIlIIllIl) {
        if (this.steps > 0) {
            lllllllllllllllllIlIIIllIlIIllIl = (float)(this.steps * Math.round(lllllllllllllllllIlIIIllIlIIllIl / this.steps));
        }
        return lllllllllllllllllIlIIIllIlIIllIl;
    }
    
    public float toValue(final float lllllllllllllllllIlIIIllIlIllIIl) {
        return this.clamp(this.minValue + (this.maxValue - this.minValue) * MathHelper.clamp(lllllllllllllllllIlIIIllIlIllIIl, 0.0f, 1.0f));
    }
    
    @Override
    public int getYImage(final boolean lllllllllllllllllIlIIIllIlIIlIll) {
        return 0;
    }
    
    public RealmsSliderButton(final int lllllllllllllllllIlIIIlllIIIIlII, final int lllllllllllllllllIlIIIlllIIIlIlI, final int lllllllllllllllllIlIIIlllIIIIIlI, final int lllllllllllllllllIlIIIlllIIIIIIl, final int lllllllllllllllllIlIIIlllIIIIlll, final int lllllllllllllllllIlIIIllIlllllll) {
        this(lllllllllllllllllIlIIIlllIIIIlII, lllllllllllllllllIlIIIlllIIIlIlI, lllllllllllllllllIlIIIlllIIIIIlI, lllllllllllllllllIlIIIlllIIIIIIl, lllllllllllllllllIlIIIllIlllllll, 0, 1.0f, (float)lllllllllllllllllIlIIIlllIIIIlll);
    }
}
