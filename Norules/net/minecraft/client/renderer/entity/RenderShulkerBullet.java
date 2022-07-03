package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class RenderShulkerBullet extends Render<EntityShulkerBullet>
{
    private final /* synthetic */ ModelShulkerBullet model;
    private static final /* synthetic */ ResourceLocation SHULKER_SPARK_TEXTURE;
    
    @Override
    public void doRender(final EntityShulkerBullet lllllllllllllIIIlllIIIllIIlIllII, final double lllllllllllllIIIlllIIIllIIlIIIII, final double lllllllllllllIIIlllIIIllIIIlllll, final double lllllllllllllIIIlllIIIllIIlIlIIl, final float lllllllllllllIIIlllIIIllIIlIlIII, final float lllllllllllllIIIlllIIIllIIlIIlll) {
        GlStateManager.pushMatrix();
        final float lllllllllllllIIIlllIIIllIIlIIllI = this.rotLerp(lllllllllllllIIIlllIIIllIIlIllII.prevRotationYaw, lllllllllllllIIIlllIIIllIIlIllII.rotationYaw, lllllllllllllIIIlllIIIllIIlIIlll);
        final float lllllllllllllIIIlllIIIllIIlIIlIl = lllllllllllllIIIlllIIIllIIlIllII.prevRotationPitch + (lllllllllllllIIIlllIIIllIIlIllII.rotationPitch - lllllllllllllIIIlllIIIllIIlIllII.prevRotationPitch) * lllllllllllllIIIlllIIIllIIlIIlll;
        final float lllllllllllllIIIlllIIIllIIlIIlII = lllllllllllllIIIlllIIIllIIlIllII.ticksExisted + lllllllllllllIIIlllIIIllIIlIIlll;
        GlStateManager.translate((float)lllllllllllllIIIlllIIIllIIlIIIII, (float)lllllllllllllIIIlllIIIllIIIlllll + 0.15f, (float)lllllllllllllIIIlllIIIllIIlIlIIl);
        GlStateManager.rotate(MathHelper.sin(lllllllllllllIIIlllIIIllIIlIIlII * 0.1f) * 180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(MathHelper.cos(lllllllllllllIIIlllIIIllIIlIIlII * 0.1f) * 180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(MathHelper.sin(lllllllllllllIIIlllIIIllIIlIIlII * 0.15f) * 360.0f, 0.0f, 0.0f, 1.0f);
        final float lllllllllllllIIIlllIIIllIIlIIIll = 0.03125f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.bindEntityTexture(lllllllllllllIIIlllIIIllIIlIllII);
        this.model.render(lllllllllllllIIIlllIIIllIIlIllII, 0.0f, 0.0f, 0.0f, lllllllllllllIIIlllIIIllIIlIIllI, lllllllllllllIIIlllIIIllIIlIIlIl, 0.03125f);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        GlStateManager.scale(1.5f, 1.5f, 1.5f);
        this.model.render(lllllllllllllIIIlllIIIllIIlIllII, 0.0f, 0.0f, 0.0f, lllllllllllllIIIlllIIIllIIlIIllI, lllllllllllllIIIlllIIIllIIlIIlIl, 0.03125f);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIIlllIIIllIIlIllII, lllllllllllllIIIlllIIIllIIlIIIII, lllllllllllllIIIlllIIIllIIIlllll, lllllllllllllIIIlllIIIllIIlIlIIl, lllllllllllllIIIlllIIIllIIlIlIII, lllllllllllllIIIlllIIIllIIlIIlll);
    }
    
    static {
        SHULKER_SPARK_TEXTURE = new ResourceLocation("textures/entity/shulker/spark.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityShulkerBullet lllllllllllllIIIlllIIIllIIIlIllI) {
        return RenderShulkerBullet.SHULKER_SPARK_TEXTURE;
    }
    
    private float rotLerp(final float lllllllllllllIIIlllIIIllIIllllII, final float lllllllllllllIIIlllIIIllIIlllIll, final float lllllllllllllIIIlllIIIllIIlllllI) {
        float lllllllllllllIIIlllIIIllIIllllIl;
        for (lllllllllllllIIIlllIIIllIIllllIl = lllllllllllllIIIlllIIIllIIlllIll - lllllllllllllIIIlllIIIllIIllllII; lllllllllllllIIIlllIIIllIIllllIl < -180.0f; lllllllllllllIIIlllIIIllIIllllIl += 360.0f) {}
        while (lllllllllllllIIIlllIIIllIIllllIl >= 180.0f) {
            lllllllllllllIIIlllIIIllIIllllIl -= 360.0f;
        }
        return lllllllllllllIIIlllIIIllIIllllII + lllllllllllllIIIlllIIIllIIlllllI * lllllllllllllIIIlllIIIllIIllllIl;
    }
    
    public RenderShulkerBullet(final RenderManager lllllllllllllIIIlllIIIllIlIIIllI) {
        super(lllllllllllllIIIlllIIIllIlIIIllI);
        this.model = new ModelShulkerBullet();
    }
}
