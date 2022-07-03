package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiButtonImage extends GuiButton
{
    private final /* synthetic */ ResourceLocation field_191750_o;
    private final /* synthetic */ int field_191748_q;
    private final /* synthetic */ int field_191747_p;
    private final /* synthetic */ int field_191749_r;
    
    public void func_191745_a(final Minecraft lllllllllllllIllIlIIlIllIIllIIll, final int lllllllllllllIllIlIIlIllIIllIIlI, final int lllllllllllllIllIlIIlIllIIlllIII, final float lllllllllllllIllIlIIlIllIIllIlll) {
        if (this.visible) {
            this.hovered = (lllllllllllllIllIlIIlIllIIllIIlI >= this.xPosition && lllllllllllllIllIlIIlIllIIlllIII >= this.yPosition && lllllllllllllIllIlIIlIllIIllIIlI < this.xPosition + this.width && lllllllllllllIllIlIIlIllIIlllIII < this.yPosition + this.height);
            lllllllllllllIllIlIIlIllIIllIIll.getTextureManager().bindTexture(this.field_191750_o);
            GlStateManager.disableDepth();
            final int lllllllllllllIllIlIIlIllIIllIllI = this.field_191747_p;
            int lllllllllllllIllIlIIlIllIIllIlIl = this.field_191748_q;
            if (this.hovered) {
                lllllllllllllIllIlIIlIllIIllIlIl += this.field_191749_r;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllIllIlIIlIllIIllIllI, lllllllllllllIllIlIIlIllIIllIlIl, this.width, this.height);
            GlStateManager.enableDepth();
        }
    }
    
    public void func_191746_c(final int lllllllllllllIllIlIIlIllIlIIIllI, final int lllllllllllllIllIlIIlIllIlIIIIlI) {
        this.xPosition = lllllllllllllIllIlIIlIllIlIIIllI;
        this.yPosition = lllllllllllllIllIlIIlIllIlIIIIlI;
    }
    
    public GuiButtonImage(final int lllllllllllllIllIlIIlIllIlIlIIll, final int lllllllllllllIllIlIIlIllIlIlIIlI, final int lllllllllllllIllIlIIlIllIlIlIIIl, final int lllllllllllllIllIlIIlIllIlIllIlI, final int lllllllllllllIllIlIIlIllIlIIllll, final int lllllllllllllIllIlIIlIllIlIIlllI, final int lllllllllllllIllIlIIlIllIlIlIlll, final int lllllllllllllIllIlIIlIllIlIlIllI, final ResourceLocation lllllllllllllIllIlIIlIllIlIlIlIl) {
        super(lllllllllllllIllIlIIlIllIlIlIIll, lllllllllllllIllIlIIlIllIlIlIIlI, lllllllllllllIllIlIIlIllIlIlIIIl, lllllllllllllIllIlIIlIllIlIllIlI, lllllllllllllIllIlIIlIllIlIIllll, "");
        this.field_191747_p = lllllllllllllIllIlIIlIllIlIIlllI;
        this.field_191748_q = lllllllllllllIllIlIIlIllIlIlIlll;
        this.field_191749_r = lllllllllllllIllIlIIlIllIlIlIllI;
        this.field_191750_o = lllllllllllllIllIlIIlIllIlIlIlIl;
    }
}
