package net.minecraft.client.renderer.entity;

import net.minecraft.entity.effect.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class RenderLightningBolt extends Render<EntityLightningBolt>
{
    public RenderLightningBolt(final RenderManager lIIlllIllIIIIlI) {
        super(lIIlllIllIIIIlI);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final EntityLightningBolt lIIlllIIlIllIlI) {
        return null;
    }
    
    @Override
    public void doRender(final EntityLightningBolt lIIlllIlIIllllI, final double lIIlllIIllllIlI, final double lIIlllIlIIlllII, final double lIIlllIIllllIII, final float lIIlllIlIIllIlI, final float lIIlllIlIIllIIl) {
        final Tessellator lIIlllIlIIllIII = Tessellator.getInstance();
        final BufferBuilder lIIlllIlIIlIlll = lIIlllIlIIllIII.getBuffer();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
        final double[] lIIlllIlIIlIllI = new double[8];
        final double[] lIIlllIlIIlIlIl = new double[8];
        double lIIlllIlIIlIlII = 0.0;
        double lIIlllIlIIlIIll = 0.0;
        final Random lIIlllIlIIlIIlI = new Random(lIIlllIlIIllllI.boltVertex);
        for (int lIIlllIlIIlIIIl = 7; lIIlllIlIIlIIIl >= 0; --lIIlllIlIIlIIIl) {
            lIIlllIlIIlIllI[lIIlllIlIIlIIIl] = lIIlllIlIIlIlII;
            lIIlllIlIIlIlIl[lIIlllIlIIlIIIl] = lIIlllIlIIlIIll;
            lIIlllIlIIlIlII += lIIlllIlIIlIIlI.nextInt(11) - 5;
            lIIlllIlIIlIIll += lIIlllIlIIlIIlI.nextInt(11) - 5;
        }
        for (int lIIlllIlIIlIIII = 0; lIIlllIlIIlIIII < 4; ++lIIlllIlIIlIIII) {
            final Random lIIlllIlIIIllll = new Random(lIIlllIlIIllllI.boltVertex);
            for (int lIIlllIlIIIlllI = 0; lIIlllIlIIIlllI < 3; ++lIIlllIlIIIlllI) {
                int lIIlllIlIIIllIl = 7;
                int lIIlllIlIIIllII = 0;
                if (lIIlllIlIIIlllI > 0) {
                    lIIlllIlIIIllIl = 7 - lIIlllIlIIIlllI;
                }
                if (lIIlllIlIIIlllI > 0) {
                    lIIlllIlIIIllII = lIIlllIlIIIllIl - 2;
                }
                double lIIlllIlIIIlIll = lIIlllIlIIlIllI[lIIlllIlIIIllIl] - lIIlllIlIIlIlII;
                double lIIlllIlIIIlIlI = lIIlllIlIIlIlIl[lIIlllIlIIIllIl] - lIIlllIlIIlIIll;
                for (int lIIlllIlIIIlIIl = lIIlllIlIIIllIl; lIIlllIlIIIlIIl >= lIIlllIlIIIllII; --lIIlllIlIIIlIIl) {
                    final double lIIlllIlIIIlIII = lIIlllIlIIIlIll;
                    final double lIIlllIlIIIIlll = lIIlllIlIIIlIlI;
                    if (lIIlllIlIIIlllI == 0) {
                        lIIlllIlIIIlIll += lIIlllIlIIIllll.nextInt(11) - 5;
                        lIIlllIlIIIlIlI += lIIlllIlIIIllll.nextInt(11) - 5;
                    }
                    else {
                        lIIlllIlIIIlIll += lIIlllIlIIIllll.nextInt(31) - 15;
                        lIIlllIlIIIlIlI += lIIlllIlIIIllll.nextInt(31) - 15;
                    }
                    lIIlllIlIIlIlll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    final float lIIlllIlIIIIllI = 0.5f;
                    final float lIIlllIlIIIIlIl = 0.45f;
                    final float lIIlllIlIIIIlII = 0.45f;
                    final float lIIlllIlIIIIIll = 0.5f;
                    double lIIlllIlIIIIIlI = 0.1 + lIIlllIlIIlIIII * 0.2;
                    if (lIIlllIlIIIlllI == 0) {
                        lIIlllIlIIIIIlI *= lIIlllIlIIIlIIl * 0.1 + 1.0;
                    }
                    double lIIlllIlIIIIIIl = 0.1 + lIIlllIlIIlIIII * 0.2;
                    if (lIIlllIlIIIlllI == 0) {
                        lIIlllIlIIIIIIl *= (lIIlllIlIIIlIIl - 1) * 0.1 + 1.0;
                    }
                    for (int lIIlllIlIIIIIII = 0; lIIlllIlIIIIIII < 5; ++lIIlllIlIIIIIII) {
                        double lIIlllIIlllllll = lIIlllIIllllIlI + 0.5 - lIIlllIlIIIIIlI;
                        double lIIlllIIllllllI = lIIlllIIllllIII + 0.5 - lIIlllIlIIIIIlI;
                        if (lIIlllIlIIIIIII == 1 || lIIlllIlIIIIIII == 2) {
                            lIIlllIIlllllll += lIIlllIlIIIIIlI * 2.0;
                        }
                        if (lIIlllIlIIIIIII == 2 || lIIlllIlIIIIIII == 3) {
                            lIIlllIIllllllI += lIIlllIlIIIIIlI * 2.0;
                        }
                        double lIIlllIIlllllIl = lIIlllIIllllIlI + 0.5 - lIIlllIlIIIIIIl;
                        double lIIlllIIlllllII = lIIlllIIllllIII + 0.5 - lIIlllIlIIIIIIl;
                        if (lIIlllIlIIIIIII == 1 || lIIlllIlIIIIIII == 2) {
                            lIIlllIIlllllIl += lIIlllIlIIIIIIl * 2.0;
                        }
                        if (lIIlllIlIIIIIII == 2 || lIIlllIlIIIIIII == 3) {
                            lIIlllIIlllllII += lIIlllIlIIIIIIl * 2.0;
                        }
                        lIIlllIlIIlIlll.pos(lIIlllIIlllllIl + lIIlllIlIIIlIll, lIIlllIlIIlllII + lIIlllIlIIIlIIl * 16, lIIlllIIlllllII + lIIlllIlIIIlIlI).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                        lIIlllIlIIlIlll.pos(lIIlllIIlllllll + lIIlllIlIIIlIII, lIIlllIlIIlllII + (lIIlllIlIIIlIIl + 1) * 16, lIIlllIIllllllI + lIIlllIlIIIIlll).color(0.45f, 0.45f, 0.5f, 0.3f).endVertex();
                    }
                    lIIlllIlIIllIII.draw();
                }
            }
        }
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
    }
}
