package net.minecraft.client.gui.toasts;

import net.minecraft.client.resources.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.advancements.*;
import java.util.*;

public class AdvancementToast implements IToast
{
    private /* synthetic */ boolean field_194168_d;
    private final /* synthetic */ Advancement field_193679_c;
    
    public AdvancementToast(final Advancement lllllllllllllIIIllIlIllllIllIlIl) {
        this.field_194168_d = false;
        this.field_193679_c = lllllllllllllIIIllIlIllllIllIlIl;
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllllIIIllIlIllllIIllIIl, final long lllllllllllllIIIllIlIllllIlIIlII) {
        lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().getTextureManager().bindTexture(AdvancementToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final DisplayInfo lllllllllllllIIIllIlIllllIlIIIll = this.field_193679_c.func_192068_c();
        lllllllllllllIIIllIlIllllIIllIIl.drawTexturedModalRect(0, 0, 0, 0, 160, 32);
        if (lllllllllllllIIIllIlIllllIlIIIll != null) {
            final List<String> lllllllllllllIIIllIlIllllIlIIIlI = lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.listFormattedStringToWidth(lllllllllllllIIIllIlIllllIlIIIll.func_192297_a().getFormattedText(), 125);
            final int lllllllllllllIIIllIlIllllIlIIIIl = (lllllllllllllIIIllIlIllllIlIIIll.func_192291_d() == FrameType.CHALLENGE) ? 16746751 : 16776960;
            if (lllllllllllllIIIllIlIllllIlIIIlI.size() == 1) {
                lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.drawString(I18n.format(String.valueOf(new StringBuilder("advancements.toast.").append(lllllllllllllIIIllIlIllllIlIIIll.func_192291_d().func_192307_a())), new Object[0]), 30.0, 7.0, lllllllllllllIIIllIlIllllIlIIIIl | 0xFF000000);
                lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.drawString(lllllllllllllIIIllIlIllllIlIIIll.func_192297_a().getFormattedText(), 30.0, 18.0, -1);
            }
            else {
                final int lllllllllllllIIIllIlIllllIlIIIII = 1500;
                final float lllllllllllllIIIllIlIllllIIlllll = 300.0f;
                if (lllllllllllllIIIllIlIllllIlIIlII < 1500L) {
                    final int lllllllllllllIIIllIlIllllIIllllI = MathHelper.floor(MathHelper.clamp((1500L - lllllllllllllIIIllIlIllllIlIIlII) / 300.0f, 0.0f, 1.0f) * 255.0f) << 24 | 0x4000000;
                    lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.drawString(I18n.format(String.valueOf(new StringBuilder("advancements.toast.").append(lllllllllllllIIIllIlIllllIlIIIll.func_192291_d().func_192307_a())), new Object[0]), 30.0, 11.0, lllllllllllllIIIllIlIllllIlIIIIl | lllllllllllllIIIllIlIllllIIllllI);
                }
                else {
                    final int lllllllllllllIIIllIlIllllIIlllIl = MathHelper.floor(MathHelper.clamp((lllllllllllllIIIllIlIllllIlIIlII - 1500L) / 300.0f, 0.0f, 1.0f) * 252.0f) << 24 | 0x4000000;
                    int lllllllllllllIIIllIlIllllIIlllII = 16 - lllllllllllllIIIllIlIllllIlIIIlI.size() * lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.FONT_HEIGHT / 2;
                    for (final String lllllllllllllIIIllIlIllllIIllIll : lllllllllllllIIIllIlIllllIlIIIlI) {
                        lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.drawString(lllllllllllllIIIllIlIllllIIllIll, 30.0, lllllllllllllIIIllIlIllllIIlllII, 0xFFFFFF | lllllllllllllIIIllIlIllllIIlllIl);
                        lllllllllllllIIIllIlIllllIIlllII += lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().fontRendererObj.FONT_HEIGHT;
                    }
                }
            }
            if (!this.field_194168_d && lllllllllllllIIIllIlIllllIlIIlII > 0L) {
                this.field_194168_d = true;
                if (lllllllllllllIIIllIlIllllIlIIIll.func_192291_d() == FrameType.CHALLENGE) {
                    lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().getSoundHandler().playSound(PositionedSoundRecord.func_194007_a(SoundEvents.field_194228_if, 1.0f, 1.0f));
                }
            }
            RenderHelper.enableGUIStandardItemLighting();
            lllllllllllllIIIllIlIllllIIllIIl.func_192989_b().getRenderItem().renderItemAndEffectIntoGUI(null, lllllllllllllIIIllIlIllllIlIIIll.func_192298_b(), 8, 8);
            return (lllllllllllllIIIllIlIllllIlIIlII >= 5000L) ? Visibility.HIDE : Visibility.SHOW;
        }
        return Visibility.HIDE;
    }
}
