package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import optifine.*;
import net.minecraft.util.text.*;
import net.minecraft.block.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer<TileEntitySign>
{
    private static final /* synthetic */ ResourceLocation SIGN_TEXTURE;
    private final /* synthetic */ ModelSign model;
    
    @Override
    public void func_192841_a(final TileEntitySign lllllllllllllIIllIllIIllIlIlllll, final double lllllllllllllIIllIllIIllIlllIIlI, final double lllllllllllllIIllIllIIllIlIlllIl, final double lllllllllllllIIllIllIIllIlllIIII, final float lllllllllllllIIllIllIIllIllIllll, final int lllllllllllllIIllIllIIllIlIllIll, final float lllllllllllllIIllIllIIllIllIllIl) {
        final Block lllllllllllllIIllIllIIllIllIllII = lllllllllllllIIllIllIIllIlIlllll.getBlockType();
        GlStateManager.pushMatrix();
        final float lllllllllllllIIllIllIIllIllIlIll = 0.6666667f;
        if (lllllllllllllIIllIllIIllIllIllII == Blocks.STANDING_SIGN) {
            GlStateManager.translate((float)lllllllllllllIIllIllIIllIlllIIlI + 0.5f, (float)lllllllllllllIIllIllIIllIlIlllIl + 0.5f, (float)lllllllllllllIIllIllIIllIlllIIII + 0.5f);
            final float lllllllllllllIIllIllIIllIllIlIlI = lllllllllllllIIllIllIIllIlIlllll.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(-lllllllllllllIIllIllIIllIllIlIlI, 0.0f, 1.0f, 0.0f);
            this.model.signStick.showModel = true;
        }
        else {
            final int lllllllllllllIIllIllIIllIllIlIIl = lllllllllllllIIllIllIIllIlIlllll.getBlockMetadata();
            float lllllllllllllIIllIllIIllIllIlIII = 0.0f;
            if (lllllllllllllIIllIllIIllIllIlIIl == 2) {
                lllllllllllllIIllIllIIllIllIlIII = 180.0f;
            }
            if (lllllllllllllIIllIllIIllIllIlIIl == 4) {
                lllllllllllllIIllIllIIllIllIlIII = 90.0f;
            }
            if (lllllllllllllIIllIllIIllIllIlIIl == 5) {
                lllllllllllllIIllIllIIllIllIlIII = -90.0f;
            }
            GlStateManager.translate((float)lllllllllllllIIllIllIIllIlllIIlI + 0.5f, (float)lllllllllllllIIllIllIIllIlIlllIl + 0.5f, (float)lllllllllllllIIllIllIIllIlllIIII + 0.5f);
            GlStateManager.rotate(-lllllllllllllIIllIllIIllIllIlIII, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.model.signStick.showModel = false;
        }
        if (lllllllllllllIIllIllIIllIlIllIll >= 0) {
            this.bindTexture(TileEntitySignRenderer.DESTROY_STAGES[lllllllllllllIIllIllIIllIlIllIll]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(TileEntitySignRenderer.SIGN_TEXTURE);
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.6666667f, -0.6666667f, -0.6666667f);
        this.model.renderSign();
        GlStateManager.popMatrix();
        final FontRenderer lllllllllllllIIllIllIIllIllIIlll = this.getFontRenderer();
        final float lllllllllllllIIllIllIIllIllIIllI = 0.010416667f;
        GlStateManager.translate(0.0f, 0.33333334f, 0.046666667f);
        GlStateManager.scale(0.010416667f, -0.010416667f, 0.010416667f);
        GlStateManager.glNormal3f(0.0f, 0.0f, -0.010416667f);
        GlStateManager.depthMask(false);
        int lllllllllllllIIllIllIIllIllIIlIl = 0;
        if (Config.isCustomColors()) {
            lllllllllllllIIllIllIIllIllIIlIl = CustomColors.getSignTextColor(lllllllllllllIIllIllIIllIllIIlIl);
        }
        if (lllllllllllllIIllIllIIllIlIllIll < 0) {
            for (int lllllllllllllIIllIllIIllIllIIlII = 0; lllllllllllllIIllIllIIllIllIIlII < lllllllllllllIIllIllIIllIlIlllll.signText.length; ++lllllllllllllIIllIllIIllIllIIlII) {
                if (lllllllllllllIIllIllIIllIlIlllll.signText[lllllllllllllIIllIllIIllIllIIlII] != null) {
                    final ITextComponent lllllllllllllIIllIllIIllIllIIIll = lllllllllllllIIllIllIIllIlIlllll.signText[lllllllllllllIIllIllIIllIllIIlII];
                    final List<ITextComponent> lllllllllllllIIllIllIIllIllIIIlI = GuiUtilRenderComponents.splitText(lllllllllllllIIllIllIIllIllIIIll, 90, lllllllllllllIIllIllIIllIllIIlll, false, true);
                    String lllllllllllllIIllIllIIllIllIIIIl = (lllllllllllllIIllIllIIllIllIIIlI != null && !lllllllllllllIIllIllIIllIllIIIlI.isEmpty()) ? lllllllllllllIIllIllIIllIllIIIlI.get(0).getFormattedText() : "";
                    if (lllllllllllllIIllIllIIllIllIIlII == lllllllllllllIIllIllIIllIlIlllll.lineBeingEdited) {
                        lllllllllllllIIllIllIIllIllIIIIl = String.valueOf(new StringBuilder("> ").append(lllllllllllllIIllIllIIllIllIIIIl).append(" <"));
                        lllllllllllllIIllIllIIllIllIIlll.drawString(lllllllllllllIIllIllIIllIllIIIIl, -lllllllllllllIIllIllIIllIllIIlll.getStringWidth(lllllllllllllIIllIllIIllIllIIIIl) / 2, lllllllllllllIIllIllIIllIllIIlII * 10 - lllllllllllllIIllIllIIllIlIlllll.signText.length * 5, lllllllllllllIIllIllIIllIllIIlIl);
                    }
                    else {
                        lllllllllllllIIllIllIIllIllIIlll.drawString(lllllllllllllIIllIllIIllIllIIIIl, -lllllllllllllIIllIllIIllIllIIlll.getStringWidth(lllllllllllllIIllIllIIllIllIIIIl) / 2, lllllllllllllIIllIllIIllIllIIlII * 10 - lllllllllllllIIllIllIIllIlIlllll.signText.length * 5, lllllllllllllIIllIllIIllIllIIlIl);
                    }
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
        if (lllllllllllllIIllIllIIllIlIllIll >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static {
        SIGN_TEXTURE = new ResourceLocation("textures/entity/sign.png");
    }
    
    public TileEntitySignRenderer() {
        this.model = new ModelSign();
    }
}
