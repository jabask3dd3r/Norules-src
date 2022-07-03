package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.boss.*;
import java.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerEnderDragonDeath implements LayerRenderer<EntityDragon>
{
    @Override
    public void doRenderLayer(final EntityDragon llllllllllllllllIIllIIIllIlIlIIl, final float llllllllllllllllIIllIIIllIlllIIl, final float llllllllllllllllIIllIIIllIlllIII, final float llllllllllllllllIIllIIIllIlIlIII, final float llllllllllllllllIIllIIIllIllIllI, final float llllllllllllllllIIllIIIllIllIlIl, final float llllllllllllllllIIllIIIllIllIlII, final float llllllllllllllllIIllIIIllIllIIll) {
        if (llllllllllllllllIIllIIIllIlIlIIl.deathTicks > 0) {
            final Tessellator llllllllllllllllIIllIIIllIllIIlI = Tessellator.getInstance();
            final BufferBuilder llllllllllllllllIIllIIIllIllIIIl = llllllllllllllllIIllIIIllIllIIlI.getBuffer();
            RenderHelper.disableStandardItemLighting();
            final float llllllllllllllllIIllIIIllIllIIII = (llllllllllllllllIIllIIIllIlIlIIl.deathTicks + llllllllllllllllIIllIIIllIlIlIII) / 200.0f;
            float llllllllllllllllIIllIIIllIlIllll = 0.0f;
            if (llllllllllllllllIIllIIIllIllIIII > 0.8f) {
                llllllllllllllllIIllIIIllIlIllll = (llllllllllllllllIIllIIIllIllIIII - 0.8f) / 0.2f;
            }
            final Random llllllllllllllllIIllIIIllIlIlllI = new Random(432L);
            GlStateManager.disableTexture2D();
            GlStateManager.shadeModel(7425);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.enableCull();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -1.0f, -2.0f);
            for (int llllllllllllllllIIllIIIllIlIllIl = 0; llllllllllllllllIIllIIIllIlIllIl < (llllllllllllllllIIllIIIllIllIIII + llllllllllllllllIIllIIIllIllIIII * llllllllllllllllIIllIIIllIllIIII) / 2.0f * 60.0f; ++llllllllllllllllIIllIIIllIlIllIl) {
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 360.0f + llllllllllllllllIIllIIIllIllIIII * 90.0f, 0.0f, 0.0f, 1.0f);
                final float llllllllllllllllIIllIIIllIlIllII = llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 20.0f + 5.0f + llllllllllllllllIIllIIIllIlIllll * 10.0f;
                final float llllllllllllllllIIllIIIllIlIlIll = llllllllllllllllIIllIIIllIlIlllI.nextFloat() * 2.0f + 1.0f + llllllllllllllllIIllIIIllIlIllll * 2.0f;
                llllllllllllllllIIllIIIllIllIIIl.begin(6, DefaultVertexFormats.POSITION_COLOR);
                llllllllllllllllIIllIIIllIllIIIl.pos(0.0, 0.0, 0.0).color(255, 255, 255, (int)(255.0f * (1.0f - llllllllllllllllIIllIIIllIlIllll))).endVertex();
                llllllllllllllllIIllIIIllIllIIIl.pos(-0.866 * llllllllllllllllIIllIIIllIlIlIll, llllllllllllllllIIllIIIllIlIllII, -0.5f * llllllllllllllllIIllIIIllIlIlIll).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIllIIIllIllIIIl.pos(0.866 * llllllllllllllllIIllIIIllIlIlIll, llllllllllllllllIIllIIIllIlIllII, -0.5f * llllllllllllllllIIllIIIllIlIlIll).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIllIIIllIllIIIl.pos(0.0, llllllllllllllllIIllIIIllIlIllII, 1.0f * llllllllllllllllIIllIIIllIlIlIll).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIllIIIllIllIIIl.pos(-0.866 * llllllllllllllllIIllIIIllIlIlIll, llllllllllllllllIIllIIIllIlIllII, -0.5f * llllllllllllllllIIllIIIllIlIlIll).color(255, 0, 255, 0).endVertex();
                llllllllllllllllIIllIIIllIllIIlI.draw();
            }
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.shadeModel(7424);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
