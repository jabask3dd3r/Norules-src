package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiSlider extends GuiButton
{
    private final /* synthetic */ GuiPageButtonList.GuiResponder responder;
    private /* synthetic */ FormatHelper formatHelper;
    private /* synthetic */ float sliderPosition;
    private final /* synthetic */ float max;
    private final /* synthetic */ String name;
    public /* synthetic */ boolean isMouseDown;
    private final /* synthetic */ float min;
    
    private String getDisplayString() {
        return (this.formatHelper == null) ? String.valueOf(new StringBuilder(String.valueOf(I18n.format(this.name, new Object[0]))).append(": ").append(this.getSliderValue())) : this.formatHelper.getText(this.id, I18n.format(this.name, new Object[0]), this.getSliderValue());
    }
    
    public GuiSlider(final GuiPageButtonList.GuiResponder lllllllllllllIllllIIllIlIIlllIII, final int lllllllllllllIllllIIllIlIIllIlll, final int lllllllllllllIllllIIllIlIIllIllI, final int lllllllllllllIllllIIllIlIIlIlIll, final String lllllllllllllIllllIIllIlIIllIlII, final float lllllllllllllIllllIIllIlIIllIIll, final float lllllllllllllIllllIIllIlIIlIlIII, final float lllllllllllllIllllIIllIlIIllIIIl, final FormatHelper lllllllllllllIllllIIllIlIIlIIllI) {
        super(lllllllllllllIllllIIllIlIIllIlll, lllllllllllllIllllIIllIlIIllIllI, lllllllllllllIllllIIllIlIIlIlIll, 150, 20, "");
        this.sliderPosition = 1.0f;
        this.name = lllllllllllllIllllIIllIlIIllIlII;
        this.min = lllllllllllllIllllIIllIlIIllIIll;
        this.max = lllllllllllllIllllIIllIlIIlIlIII;
        this.sliderPosition = (lllllllllllllIllllIIllIlIIllIIIl - lllllllllllllIllllIIllIlIIllIIll) / (lllllllllllllIllllIIllIlIIlIlIII - lllllllllllllIllllIIllIlIIllIIll);
        this.formatHelper = lllllllllllllIllllIIllIlIIlIIllI;
        this.responder = lllllllllllllIllllIIllIlIIlllIII;
        this.displayString = this.getDisplayString();
    }
    
    public void setSliderValue(final float lllllllllllllIllllIIllIlIIIllllI, final boolean lllllllllllllIllllIIllIlIIIlllIl) {
        this.sliderPosition = (lllllllllllllIllllIIllIlIIIllllI - this.min) / (this.max - this.min);
        this.displayString = this.getDisplayString();
        if (lllllllllllllIllllIIllIlIIIlllIl) {
            this.responder.setEntryValue(this.id, this.getSliderValue());
        }
    }
    
    public float getSliderPosition() {
        return this.sliderPosition;
    }
    
    public void setSliderPosition(final float lllllllllllllIllllIIllIlIIIIIllI) {
        this.sliderPosition = lllllllllllllIllllIIllIlIIIIIllI;
        this.displayString = this.getDisplayString();
        this.responder.setEntryValue(this.id, this.getSliderValue());
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIllllIIllIIllllIlIl, final int lllllllllllllIllllIIllIIllllIlII) {
        this.isMouseDown = false;
    }
    
    public float getSliderValue() {
        return this.min + (this.max - this.min) * this.sliderPosition;
    }
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllIllllIIllIIlllllllI, final int lllllllllllllIllllIIllIIllllllIl, final int lllllllllllllIllllIIllIIlllllIII) {
        if (super.mousePressed(lllllllllllllIllllIIllIIlllllllI, lllllllllllllIllllIIllIIllllllIl, lllllllllllllIllllIIllIIlllllIII)) {
            this.sliderPosition = (lllllllllllllIllllIIllIIllllllIl - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderPosition < 0.0f) {
                this.sliderPosition = 0.0f;
            }
            if (this.sliderPosition > 1.0f) {
                this.sliderPosition = 1.0f;
            }
            this.displayString = this.getDisplayString();
            this.responder.setEntryValue(this.id, this.getSliderValue());
            this.isMouseDown = true;
            return true;
        }
        return false;
    }
    
    @Override
    protected int getHoverState(final boolean lllllllllllllIllllIIllIlIIIlIIlI) {
        return 0;
    }
    
    @Override
    protected void mouseDragged(final Minecraft lllllllllllllIllllIIllIlIIIIlllI, final int lllllllllllllIllllIIllIlIIIIlIlI, final int lllllllllllllIllllIIllIlIIIIllII) {
        if (this.visible) {
            if (this.isMouseDown) {
                this.sliderPosition = (lllllllllllllIllllIIllIlIIIIlIlI - (this.xPosition + 4)) / (float)(this.width - 8);
                if (this.sliderPosition < 0.0f) {
                    this.sliderPosition = 0.0f;
                }
                if (this.sliderPosition > 1.0f) {
                    this.sliderPosition = 1.0f;
                }
                this.displayString = this.getDisplayString();
                this.responder.setEntryValue(this.id, this.getSliderValue());
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderPosition * (this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderPosition * (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }
    
    public interface FormatHelper
    {
        String getText(final int p0, final String p1, final float p2);
    }
}
