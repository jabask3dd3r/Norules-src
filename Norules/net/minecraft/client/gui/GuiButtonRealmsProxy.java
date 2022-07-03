package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.client.*;

public class GuiButtonRealmsProxy extends GuiButton
{
    private final /* synthetic */ RealmsButton realmsButton;
    
    @Override
    public boolean mousePressed(final Minecraft lllllllllllllIIIIlIllIlllIlIIllI, final int lllllllllllllIIIIlIllIlllIlIIIIl, final int lllllllllllllIIIIlIllIlllIlIIIII) {
        if (super.mousePressed(lllllllllllllIIIIlIllIlllIlIIllI, lllllllllllllIIIIlIllIlllIlIIIIl, lllllllllllllIIIIlIllIlllIlIIIII)) {
            this.realmsButton.clicked(lllllllllllllIIIIlIllIlllIlIIIIl, lllllllllllllIIIIlIllIlllIlIIIII);
        }
        return super.mousePressed(lllllllllllllIIIIlIllIlllIlIIllI, lllllllllllllIIIIlIllIlllIlIIIIl, lllllllllllllIIIIlIllIlllIlIIIII);
    }
    
    public GuiButtonRealmsProxy(final RealmsButton lllllllllllllIIIIlIllIllllIIlIlI, final int lllllllllllllIIIIlIllIllllIIlIIl, final int lllllllllllllIIIIlIllIllllIlIIII, final int lllllllllllllIIIIlIllIllllIIIlll, final String lllllllllllllIIIIlIllIllllIIIllI, final int lllllllllllllIIIIlIllIllllIIllIl, final int lllllllllllllIIIIlIllIllllIIIlII) {
        super(lllllllllllllIIIIlIllIllllIIlIIl, lllllllllllllIIIIlIllIllllIlIIII, lllllllllllllIIIIlIllIllllIIIlll, lllllllllllllIIIIlIllIllllIIllIl, lllllllllllllIIIIlIllIllllIIIlII, lllllllllllllIIIIlIllIllllIIIllI);
        this.realmsButton = lllllllllllllIIIIlIllIllllIIlIlI;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void mouseDragged(final Minecraft lllllllllllllIIIIlIllIlllIIlIIlI, final int lllllllllllllIIIIlIllIlllIIlIIIl, final int lllllllllllllIIIIlIllIlllIIlIIII) {
        this.realmsButton.renderBg(lllllllllllllIIIIlIllIlllIIlIIIl, lllllllllllllIIIIlIllIlllIIlIIII);
    }
    
    public int getHoverState(final boolean lllllllllllllIIIIlIllIlllIIIIllI) {
        return this.realmsButton.getYImage(lllllllllllllIIIIlIllIlllIIIIllI);
    }
    
    public int getYImage(final boolean lllllllllllllIIIIlIllIllIllllllI) {
        return super.getHoverState(lllllllllllllIIIIlIllIllIllllllI);
    }
    
    public GuiButtonRealmsProxy(final RealmsButton lllllllllllllIIIIlIllIlllllIIIII, final int lllllllllllllIIIIlIllIllllIlllll, final int lllllllllllllIIIIlIllIlllllIIlII, final int lllllllllllllIIIIlIllIllllIlllIl, final String lllllllllllllIIIIlIllIllllIlllII) {
        super(lllllllllllllIIIIlIllIllllIlllll, lllllllllllllIIIIlIllIlllllIIlII, lllllllllllllIIIIlIllIllllIlllIl, lllllllllllllIIIIlIllIllllIlllII);
        this.realmsButton = lllllllllllllIIIIlIllIlllllIIIII;
    }
    
    @Override
    public int getButtonWidth() {
        return super.getButtonWidth();
    }
    
    public void setText(final String lllllllllllllIIIIlIllIlllIllIIlI) {
        super.displayString = lllllllllllllIIIIlIllIlllIllIIlI;
    }
    
    public int getPositionY() {
        return this.yPosition;
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIIIlIllIlllIIllIll, final int lllllllllllllIIIIlIllIlllIIlIlll) {
        this.realmsButton.released(lllllllllllllIIIIlIllIlllIIllIll, lllllllllllllIIIIlIllIlllIIlIlll);
    }
    
    public void setEnabled(final boolean lllllllllllllIIIIlIllIlllIlllIII) {
        this.enabled = lllllllllllllIIIIlIllIlllIlllIII;
    }
    
    public RealmsButton getRealmsButton() {
        return this.realmsButton;
    }
    
    public boolean getEnabled() {
        return this.enabled;
    }
    
    public int getHeight() {
        return this.height;
    }
}
