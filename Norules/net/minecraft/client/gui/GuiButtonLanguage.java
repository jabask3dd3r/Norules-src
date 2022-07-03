package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiButtonLanguage extends GuiButton
{
    public void func_191745_a(final Minecraft llllllllllllllIlIIllIllIIlIIlIII, final int llllllllllllllIlIIllIllIIlIIIlll, final int llllllllllllllIlIIllIllIIIllllll, final float llllllllllllllIlIIllIllIIlIIIlIl) {
        if (this.visible) {
            llllllllllllllIlIIllIllIIlIIlIII.getTextureManager().bindTexture(GuiButton.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean llllllllllllllIlIIllIllIIlIIIlII = llllllllllllllIlIIllIllIIlIIIlll >= this.xPosition && llllllllllllllIlIIllIllIIIllllll >= this.yPosition && llllllllllllllIlIIllIllIIlIIIlll < this.xPosition + this.width && llllllllllllllIlIIllIllIIIllllll < this.yPosition + this.height;
            int llllllllllllllIlIIllIllIIlIIIIll = 106;
            if (llllllllllllllIlIIllIllIIlIIIlII) {
                llllllllllllllIlIIllIllIIlIIIIll += this.height;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, llllllllllllllIlIIllIllIIlIIIIll, this.width, this.height);
        }
    }
    
    public GuiButtonLanguage(final int llllllllllllllIlIIllIllIIlIlIllI, final int llllllllllllllIlIIllIllIIlIlIlIl, final int llllllllllllllIlIIllIllIIlIlIIII) {
        super(llllllllllllllIlIIllIllIIlIlIllI, llllllllllllllIlIIllIllIIlIlIlIl, llllllllllllllIlIIllIllIIlIlIIII, 98, 20, "Alt Manager");
    }
}
