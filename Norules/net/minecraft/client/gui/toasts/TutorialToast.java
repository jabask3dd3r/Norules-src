package net.minecraft.client.gui.toasts;

import net.minecraft.util.text.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.math.*;

public class TutorialToast implements IToast
{
    private /* synthetic */ float field_193677_i;
    private /* synthetic */ float field_193676_h;
    private final /* synthetic */ String field_193672_d;
    private final /* synthetic */ Icons field_193671_c;
    private /* synthetic */ long field_193675_g;
    private /* synthetic */ Visibility field_193674_f;
    private final /* synthetic */ String field_193673_e;
    private final /* synthetic */ boolean field_193678_j;
    
    public void func_193670_a() {
        this.field_193674_f = Visibility.HIDE;
    }
    
    public void func_193669_a(final float lllllllllllllllIllIlIIllIlllIlII) {
        this.field_193677_i = lllllllllllllllIllIlIIllIlllIlII;
    }
    
    public TutorialToast(final Icons lllllllllllllllIllIlIIlllIIlIIll, final ITextComponent lllllllllllllllIllIlIIlllIIIllIl, @Nullable final ITextComponent lllllllllllllllIllIlIIlllIIlIIIl, final boolean lllllllllllllllIllIlIIlllIIIlIll) {
        this.field_193674_f = Visibility.SHOW;
        this.field_193671_c = lllllllllllllllIllIlIIlllIIlIIll;
        this.field_193672_d = lllllllllllllllIllIlIIlllIIIllIl.getFormattedText();
        this.field_193673_e = ((lllllllllllllllIllIlIIlllIIlIIIl == null) ? null : lllllllllllllllIllIlIIlllIIlIIIl.getFormattedText());
        this.field_193678_j = lllllllllllllllIllIlIIlllIIIlIll;
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllllllIllIlIIlllIIIIlII, final long lllllllllllllllIllIlIIllIlllllIl) {
        lllllllllllllllIllIlIIlllIIIIlII.func_192989_b().getTextureManager().bindTexture(TutorialToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        lllllllllllllllIllIlIIlllIIIIlII.drawTexturedModalRect(0, 0, 0, 96, 160, 32);
        this.field_193671_c.func_193697_a(lllllllllllllllIllIlIIlllIIIIlII, 6, 6);
        if (this.field_193673_e == null) {
            lllllllllllllllIllIlIIlllIIIIlII.func_192989_b().fontRendererObj.drawString(this.field_193672_d, 30.0, 12.0, -11534256);
        }
        else {
            lllllllllllllllIllIlIIlllIIIIlII.func_192989_b().fontRendererObj.drawString(this.field_193672_d, 30.0, 7.0, -11534256);
            lllllllllllllllIllIlIIlllIIIIlII.func_192989_b().fontRendererObj.drawString(this.field_193673_e, 30.0, 18.0, -16777216);
        }
        if (this.field_193678_j) {
            Gui.drawRect(3.0, 28.0, 157.0, 29.0, -1);
            final float lllllllllllllllIllIlIIlllIIIIIlI = (float)MathHelper.clampedLerp(this.field_193676_h, this.field_193677_i, (lllllllllllllllIllIlIIllIlllllIl - this.field_193675_g) / 100.0f);
            int lllllllllllllllIllIlIIlllIIIIIII = 0;
            if (this.field_193677_i >= this.field_193676_h) {
                final int lllllllllllllllIllIlIIlllIIIIIIl = -16755456;
            }
            else {
                lllllllllllllllIllIlIIlllIIIIIII = -11206656;
            }
            Gui.drawRect(3.0, 28.0, (int)(3.0f + 154.0f * lllllllllllllllIllIlIIlllIIIIIlI), 29.0, lllllllllllllllIllIlIIlllIIIIIII);
            this.field_193676_h = lllllllllllllllIllIlIIlllIIIIIlI;
            this.field_193675_g = lllllllllllllllIllIlIIllIlllllIl;
        }
        return this.field_193674_f;
    }
    
    public enum Icons
    {
        MOVEMENT_KEYS("MOVEMENT_KEYS", 0, 0, 0);
        
        private final /* synthetic */ int field_193704_g;
        
        RECIPE_BOOK("RECIPE_BOOK", 3, 0, 1), 
        TREE("TREE", 2, 2, 0), 
        WOODEN_PLANKS("WOODEN_PLANKS", 4, 1, 1), 
        MOUSE("MOUSE", 1, 1, 0);
        
        private final /* synthetic */ int field_193703_f;
        
        private Icons(final String lIIlIlIlIIIlIl, final int lIIlIlIlIIIlII, final int lIIlIlIlIIlIII, final int lIIlIlIlIIIlll) {
            this.field_193703_f = lIIlIlIlIIlIII;
            this.field_193704_g = lIIlIlIlIIIlll;
        }
        
        public void func_193697_a(final Gui lIIlIlIIlllIII, final int lIIlIlIIllIlll, final int lIIlIlIIlllIlI) {
            GlStateManager.enableBlend();
            lIIlIlIIlllIII.drawTexturedModalRect(lIIlIlIIllIlll, lIIlIlIIlllIlI, 176 + this.field_193703_f * 20, this.field_193704_g * 20, 20, 20);
            GlStateManager.enableBlend();
        }
    }
}
