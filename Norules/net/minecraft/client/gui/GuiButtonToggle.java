package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiButtonToggle extends GuiButton
{
    protected /* synthetic */ int field_191759_t;
    protected /* synthetic */ int field_191756_q;
    protected /* synthetic */ int field_191757_r;
    protected /* synthetic */ boolean field_191755_p;
    protected /* synthetic */ ResourceLocation field_191760_o;
    protected /* synthetic */ int field_191758_s;
    
    public void func_191745_a(final Minecraft lllllllllllllllIllllIIIlIIlIIIIl, final int lllllllllllllllIllllIIIlIIlIIIII, final int lllllllllllllllIllllIIIlIIIlllll, final float lllllllllllllllIllllIIIlIIIllllI) {
        if (this.visible) {
            this.hovered = (lllllllllllllllIllllIIIlIIlIIIII >= this.xPosition && lllllllllllllllIllllIIIlIIIlllll >= this.yPosition && lllllllllllllllIllllIIIlIIlIIIII < this.xPosition + this.width && lllllllllllllllIllllIIIlIIIlllll < this.yPosition + this.height);
            lllllllllllllllIllllIIIlIIlIIIIl.getTextureManager().bindTexture(this.field_191760_o);
            GlStateManager.disableDepth();
            int lllllllllllllllIllllIIIlIIIlllIl = this.field_191756_q;
            int lllllllllllllllIllllIIIlIIIlllII = this.field_191757_r;
            if (this.field_191755_p) {
                lllllllllllllllIllllIIIlIIIlllIl += this.field_191758_s;
            }
            if (this.hovered) {
                lllllllllllllllIllllIIIlIIIlllII += this.field_191759_t;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllllIllllIIIlIIIlllIl, lllllllllllllllIllllIIIlIIIlllII, this.width, this.height);
            GlStateManager.enableDepth();
        }
    }
    
    public GuiButtonToggle(final int lllllllllllllllIllllIIIlIlIllIIl, final int lllllllllllllllIllllIIIlIlIlIIIl, final int lllllllllllllllIllllIIIlIlIlIlll, final int lllllllllllllllIllllIIIlIlIIllll, final int lllllllllllllllIllllIIIlIlIIlllI, final boolean lllllllllllllllIllllIIIlIlIlIlII) {
        super(lllllllllllllllIllllIIIlIlIllIIl, lllllllllllllllIllllIIIlIlIlIIIl, lllllllllllllllIllllIIIlIlIlIlll, lllllllllllllllIllllIIIlIlIIllll, lllllllllllllllIllllIIIlIlIIlllI, "");
        this.field_191755_p = lllllllllllllllIllllIIIlIlIlIlII;
    }
    
    public void func_191753_b(final boolean lllllllllllllllIllllIIIlIIllIlIl) {
        this.field_191755_p = lllllllllllllllIllllIIIlIIllIlIl;
    }
    
    public void func_191751_a(final int lllllllllllllllIllllIIIlIIllllll, final int lllllllllllllllIllllIIIlIlIIIlII, final int lllllllllllllllIllllIIIlIlIIIIll, final int lllllllllllllllIllllIIIlIIllllII, final ResourceLocation lllllllllllllllIllllIIIlIIlllIll) {
        this.field_191756_q = lllllllllllllllIllllIIIlIIllllll;
        this.field_191757_r = lllllllllllllllIllllIIIlIlIIIlII;
        this.field_191758_s = lllllllllllllllIllllIIIlIlIIIIll;
        this.field_191759_t = lllllllllllllllIllllIIIlIIllllII;
        this.field_191760_o = lllllllllllllllIllllIIIlIIlllIll;
    }
    
    public void func_191752_c(final int lllllllllllllllIllllIIIlIIlIlIlI, final int lllllllllllllllIllllIIIlIIlIllII) {
        this.xPosition = lllllllllllllllIllllIIIlIIlIlIlI;
        this.yPosition = lllllllllllllllIllllIIIlIIlIllII;
    }
    
    public boolean func_191754_c() {
        return this.field_191755_p;
    }
}
