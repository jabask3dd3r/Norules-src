package net.minecraft.client.gui.toasts;

import net.minecraft.client.renderer.*;
import net.minecraft.util.text.*;
import javax.annotation.*;

public class SystemToast implements IToast
{
    private /* synthetic */ boolean field_193663_g;
    private /* synthetic */ long field_193662_f;
    private final /* synthetic */ Type field_193659_c;
    private /* synthetic */ String field_193661_e;
    private /* synthetic */ String field_193660_d;
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllllIIIllIIIIllIllllIlI, final long lllllllllllllIIIllIIIIllIlllIIll) {
        if (this.field_193663_g) {
            this.field_193662_f = lllllllllllllIIIllIIIIllIlllIIll;
            this.field_193663_g = false;
        }
        lllllllllllllIIIllIIIIllIllllIlI.func_192989_b().getTextureManager().bindTexture(SystemToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        lllllllllllllIIIllIIIIllIllllIlI.drawTexturedModalRect(0, 0, 0, 64, 160, 32);
        if (this.field_193661_e == null) {
            lllllllllllllIIIllIIIIllIllllIlI.func_192989_b().fontRendererObj.drawString(this.field_193660_d, 18.0, 12.0, -256);
        }
        else {
            lllllllllllllIIIllIIIIllIllllIlI.func_192989_b().fontRendererObj.drawString(this.field_193660_d, 18.0, 7.0, -256);
            lllllllllllllIIIllIIIIllIllllIlI.func_192989_b().fontRendererObj.drawString(this.field_193661_e, 18.0, 18.0, -1);
        }
        return (lllllllllllllIIIllIIIIllIlllIIll - this.field_193662_f < 5000L) ? Visibility.SHOW : Visibility.HIDE;
    }
    
    public void func_193656_a(final ITextComponent lllllllllllllIIIllIIIIllIllIIlll, @Nullable final ITextComponent lllllllllllllIIIllIIIIllIlIlllll) {
        this.field_193660_d = lllllllllllllIIIllIIIIllIllIIlll.getUnformattedText();
        this.field_193661_e = ((lllllllllllllIIIllIIIIllIlIlllll == null) ? null : lllllllllllllIIIllIIIIllIlIlllll.getUnformattedText());
        this.field_193663_g = true;
    }
    
    @Override
    public Type func_193652_b() {
        return this.field_193659_c;
    }
    
    public static void func_193657_a(final GuiToast lllllllllllllIIIllIIIIllIlIlIIIl, final Type lllllllllllllIIIllIIIIllIlIIllll, final ITextComponent lllllllllllllIIIllIIIIllIlIIIIll, @Nullable final ITextComponent lllllllllllllIIIllIIIIllIlIIlIll) {
        final SystemToast lllllllllllllIIIllIIIIllIlIIlIIl = lllllllllllllIIIllIIIIllIlIlIIIl.func_192990_a((Class<? extends SystemToast>)SystemToast.class, (Object)lllllllllllllIIIllIIIIllIlIIllll);
        if (lllllllllllllIIIllIIIIllIlIIlIIl == null) {
            lllllllllllllIIIllIIIIllIlIlIIIl.func_192988_a(new SystemToast(lllllllllllllIIIllIIIIllIlIIllll, lllllllllllllIIIllIIIIllIlIIIIll, lllllllllllllIIIllIIIIllIlIIlIll));
        }
        else {
            lllllllllllllIIIllIIIIllIlIIlIIl.func_193656_a(lllllllllllllIIIllIIIIllIlIIIIll, lllllllllllllIIIllIIIIllIlIIlIll);
        }
    }
    
    public SystemToast(final Type lllllllllllllIIIllIIIIlllIIIllll, final ITextComponent lllllllllllllIIIllIIIIlllIIIllIl, @Nullable final ITextComponent lllllllllllllIIIllIIIIlllIIIIllI) {
        this.field_193659_c = lllllllllllllIIIllIIIIlllIIIllll;
        this.field_193660_d = lllllllllllllIIIllIIIIlllIIIllIl.getUnformattedText();
        this.field_193661_e = ((lllllllllllllIIIllIIIIlllIIIIllI == null) ? null : lllllllllllllIIIllIIIIlllIIIIllI.getUnformattedText());
    }
    
    public enum Type
    {
        NARRATOR_TOGGLE("NARRATOR_TOGGLE", 1), 
        TUTORIAL_HINT("TUTORIAL_HINT", 0);
        
        private Type(final String lllllllllllllIlIIIlIllIIllIIlIIl, final int lllllllllllllIlIIIlIllIIllIIlIII) {
        }
    }
}
