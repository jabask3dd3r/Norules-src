package net.minecraft.realms;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class RealmsButton
{
    private final /* synthetic */ GuiButtonRealmsProxy proxy;
    
    public int y() {
        return this.proxy.getPositionY();
    }
    
    public int id() {
        return this.proxy.getId();
    }
    
    public void released(final int llllllllllllllIIlllIlIllIIIIIIII, final int llllllllllllllIIlllIlIlIllllllll) {
    }
    
    public int getYImage(final boolean llllllllllllllIIlllIlIlIlllIIIIl) {
        return this.proxy.getYImage(llllllllllllllIIlllIlIlIlllIIIIl);
    }
    
    public RealmsButton(final int llllllllllllllIIlllIlIllIIlllIIl, final int llllllllllllllIIlllIlIllIIlllIII, final int llllllllllllllIIlllIlIllIIllIlll, final int llllllllllllllIIlllIlIllIIlIllll, final int llllllllllllllIIlllIlIllIIlIlllI, final String llllllllllllllIIlllIlIllIIllIlII) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIIlllIlIllIIlllIIl, llllllllllllllIIlllIlIllIIlllIII, llllllllllllllIIlllIlIllIIllIlll, llllllllllllllIIlllIlIllIIllIlII, llllllllllllllIIlllIlIllIIlIllll, llllllllllllllIIlllIlIllIIlIlllI);
    }
    
    public void blit(final int llllllllllllllIIlllIlIlIlllIllll, final int llllllllllllllIIlllIlIlIllllIlIl, final int llllllllllllllIIlllIlIlIllllIlII, final int llllllllllllllIIlllIlIlIlllIllII, final int llllllllllllllIIlllIlIlIlllIlIll, final int llllllllllllllIIlllIlIlIlllIlIlI) {
        this.proxy.drawTexturedModalRect(llllllllllllllIIlllIlIlIlllIllll, llllllllllllllIIlllIlIlIllllIlIl, llllllllllllllIIlllIlIlIllllIlII, llllllllllllllIIlllIlIlIlllIllII, llllllllllllllIIlllIlIlIlllIlIll, llllllllllllllIIlllIlIlIlllIlIlI);
    }
    
    static {
        WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
    }
    
    public void render(final int llllllllllllllIIlllIlIllIIIIIllI, final int llllllllllllllIIlllIlIllIIIIlIIl, final float llllllllllllllIIlllIlIllIIIIlIII) {
        this.proxy.func_191745_a(Minecraft.getMinecraft(), llllllllllllllIIlllIlIllIIIIIllI, llllllllllllllIIlllIlIllIIIIlIIl);
    }
    
    public boolean active() {
        return this.proxy.getEnabled();
    }
    
    public void msg(final String llllllllllllllIIlllIlIllIIIllIlI) {
        this.proxy.setText(llllllllllllllIIlllIlIllIIIllIlI);
    }
    
    public RealmsButton(final int llllllllllllllIIlllIlIllIlIIlIlI, final int llllllllllllllIIlllIlIllIlIIIlII, final int llllllllllllllIIlllIlIllIlIIlIII, final String llllllllllllllIIlllIlIllIlIIIlll) {
        this.proxy = new GuiButtonRealmsProxy(this, llllllllllllllIIlllIlIllIlIIlIlI, llllllllllllllIIlllIlIllIlIIIlII, llllllllllllllIIlllIlIllIlIIlIII, llllllllllllllIIlllIlIllIlIIIlll);
    }
    
    public void active(final boolean llllllllllllllIIlllIlIllIIlIIIII) {
        this.proxy.setEnabled(llllllllllllllIIlllIlIllIIlIIIII);
    }
    
    public void renderBg(final int llllllllllllllIIlllIlIlIlllIlIII, final int llllllllllllllIIlllIlIlIlllIIlll) {
    }
    
    public int getWidth() {
        return this.proxy.getButtonWidth();
    }
    
    public int getHeight() {
        return this.proxy.getHeight();
    }
    
    public GuiButton getProxy() {
        return this.proxy;
    }
    
    public void clicked(final int llllllllllllllIIlllIlIllIIIIIIll, final int llllllllllllllIIlllIlIllIIIIIIlI) {
    }
}
