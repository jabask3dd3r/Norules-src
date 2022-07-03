package net.minecraft.client.renderer.entity;

import net.minecraft.entity.boss.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderDragon extends RenderLiving<EntityDragon>
{
    private static final /* synthetic */ ResourceLocation DRAGON_EXPLODING_TEXTURES;
    public static final /* synthetic */ ResourceLocation ENDERCRYSTAL_BEAM_TEXTURES;
    private static final /* synthetic */ ResourceLocation DRAGON_TEXTURES;
    
    static {
        ENDERCRYSTAL_BEAM_TEXTURES = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
        DRAGON_EXPLODING_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
        DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    }
    
    @Override
    protected void rotateCorpse(final EntityDragon lllllllllllllIlIlIIIIIIlllIlIIII, final float lllllllllllllIlIlIIIIIIlllIlIlll, final float lllllllllllllIlIlIIIIIIlllIlIllI, final float lllllllllllllIlIlIIIIIIlllIlIlIl) {
        final float lllllllllllllIlIlIIIIIIlllIlIlII = (float)lllllllllllllIlIlIIIIIIlllIlIIII.getMovementOffsets(7, lllllllllllllIlIlIIIIIIlllIlIlIl)[0];
        final float lllllllllllllIlIlIIIIIIlllIlIIll = (float)(lllllllllllllIlIlIIIIIIlllIlIIII.getMovementOffsets(5, lllllllllllllIlIlIIIIIIlllIlIlIl)[1] - lllllllllllllIlIlIIIIIIlllIlIIII.getMovementOffsets(10, lllllllllllllIlIlIIIIIIlllIlIlIl)[1]);
        GlStateManager.rotate(-lllllllllllllIlIlIIIIIIlllIlIlII, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIlIlIIIIIIlllIlIIll * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (lllllllllllllIlIlIIIIIIlllIlIIII.deathTime > 0) {
            float lllllllllllllIlIlIIIIIIlllIlIIlI = (lllllllllllllIlIlIIIIIIlllIlIIII.deathTime + lllllllllllllIlIlIIIIIIlllIlIlIl - 1.0f) / 20.0f * 1.6f;
            lllllllllllllIlIlIIIIIIlllIlIIlI = MathHelper.sqrt(lllllllllllllIlIlIIIIIIlllIlIIlI);
            if (lllllllllllllIlIlIIIIIIlllIlIIlI > 1.0f) {
                lllllllllllllIlIlIIIIIIlllIlIIlI = 1.0f;
            }
            GlStateManager.rotate(lllllllllllllIlIlIIIIIIlllIlIIlI * this.getDeathMaxRotation(lllllllllllllIlIlIIIIIIlllIlIIII), 0.0f, 0.0f, 1.0f);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityDragon lllllllllllllIlIlIIIIIIlIlIIllII) {
        return RenderDragon.DRAGON_TEXTURES;
    }
    
    @Override
    protected void renderModel(final EntityDragon lllllllllllllIlIlIIIIIIlllIIIIIl, final float lllllllllllllIlIlIIIIIIlllIIIIII, final float lllllllllllllIlIlIIIIIIllIllllll, final float lllllllllllllIlIlIIIIIIllIllIlIl, final float lllllllllllllIlIlIIIIIIllIllIlII, final float lllllllllllllIlIlIIIIIIllIllllII, final float lllllllllllllIlIlIIIIIIllIlllIll) {
        if (lllllllllllllIlIlIIIIIIlllIIIIIl.deathTicks > 0) {
            final float lllllllllllllIlIlIIIIIIllIlllIlI = lllllllllllllIlIlIIIIIIlllIIIIIl.deathTicks / 200.0f;
            GlStateManager.depthFunc(515);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, lllllllllllllIlIlIIIIIIllIlllIlI);
            this.bindTexture(RenderDragon.DRAGON_EXPLODING_TEXTURES);
            this.mainModel.render(lllllllllllllIlIlIIIIIIlllIIIIIl, lllllllllllllIlIlIIIIIIlllIIIIII, lllllllllllllIlIlIIIIIIllIllllll, lllllllllllllIlIlIIIIIIllIllIlIl, lllllllllllllIlIlIIIIIIllIllIlII, lllllllllllllIlIlIIIIIIllIllllII, lllllllllllllIlIlIIIIIIllIlllIll);
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.depthFunc(514);
        }
        this.bindEntityTexture(lllllllllllllIlIlIIIIIIlllIIIIIl);
        this.mainModel.render(lllllllllllllIlIlIIIIIIlllIIIIIl, lllllllllllllIlIlIIIIIIlllIIIIII, lllllllllllllIlIlIIIIIIllIllllll, lllllllllllllIlIlIIIIIIllIllIlIl, lllllllllllllIlIlIIIIIIllIllIlII, lllllllllllllIlIlIIIIIIllIllllII, lllllllllllllIlIlIIIIIIllIlllIll);
        if (lllllllllllllIlIlIIIIIIlllIIIIIl.hurtTime > 0) {
            GlStateManager.depthFunc(514);
            GlStateManager.disableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0f, 0.0f, 0.0f, 0.5f);
            this.mainModel.render(lllllllllllllIlIlIIIIIIlllIIIIIl, lllllllllllllIlIlIIIIIIlllIIIIII, lllllllllllllIlIlIIIIIIllIllllll, lllllllllllllIlIlIIIIIIllIllIlIl, lllllllllllllIlIlIIIIIIllIllIlII, lllllllllllllIlIlIIIIIIllIllllII, lllllllllllllIlIlIIIIIIllIlllIll);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.depthFunc(515);
        }
    }
    
    public static void renderCrystalBeams(final double lllllllllllllIlIlIIIIIIlIllIIllI, final double lllllllllllllIlIlIIIIIIlIllIIlIl, final double lllllllllllllIlIlIIIIIIlIllIIlII, final float lllllllllllllIlIlIIIIIIlIllIIIll, final double lllllllllllllIlIlIIIIIIlIllIIIlI, final double lllllllllllllIlIlIIIIIIlIllIIIIl, final double lllllllllllllIlIlIIIIIIlIllllIIl, final int lllllllllllllIlIlIIIIIIlIllllIII, final double lllllllllllllIlIlIIIIIIlIlllIlll, final double lllllllllllllIlIlIIIIIIlIlllIllI, final double lllllllllllllIlIlIIIIIIlIlIlllII) {
        final float lllllllllllllIlIlIIIIIIlIlllIlII = (float)(lllllllllllllIlIlIIIIIIlIlllIlll - lllllllllllllIlIlIIIIIIlIllIIIlI);
        final float lllllllllllllIlIlIIIIIIlIlllIIll = (float)(lllllllllllllIlIlIIIIIIlIlllIllI - 1.0 - lllllllllllllIlIlIIIIIIlIllIIIIl);
        final float lllllllllllllIlIlIIIIIIlIlllIIlI = (float)(lllllllllllllIlIlIIIIIIlIlIlllII - lllllllllllllIlIlIIIIIIlIllllIIl);
        final float lllllllllllllIlIlIIIIIIlIlllIIIl = MathHelper.sqrt(lllllllllllllIlIlIIIIIIlIlllIlII * lllllllllllllIlIlIIIIIIlIlllIlII + lllllllllllllIlIlIIIIIIlIlllIIlI * lllllllllllllIlIlIIIIIIlIlllIIlI);
        final float lllllllllllllIlIlIIIIIIlIlllIIII = MathHelper.sqrt(lllllllllllllIlIlIIIIIIlIlllIlII * lllllllllllllIlIlIIIIIIlIlllIlII + lllllllllllllIlIlIIIIIIlIlllIIll * lllllllllllllIlIlIIIIIIlIlllIIll + lllllllllllllIlIlIIIIIIlIlllIIlI * lllllllllllllIlIlIIIIIIlIlllIIlI);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllIlIlIIIIIIlIllIIllI, (float)lllllllllllllIlIlIIIIIIlIllIIlIl + 2.0f, (float)lllllllllllllIlIlIIIIIIlIllIIlII);
        GlStateManager.rotate((float)(-Math.atan2(lllllllllllllIlIlIIIIIIlIlllIIlI, lllllllllllllIlIlIIIIIIlIlllIlII)) * 57.295776f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((float)(-Math.atan2(lllllllllllllIlIlIIIIIIlIlllIIIl, lllllllllllllIlIlIIIIIIlIlllIIll)) * 57.295776f - 90.0f, 1.0f, 0.0f, 0.0f);
        final Tessellator lllllllllllllIlIlIIIIIIlIllIllll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIlIlIIIIIIlIllIlllI = lllllllllllllIlIlIIIIIIlIllIllll.getBuffer();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableCull();
        GlStateManager.shadeModel(7425);
        final float lllllllllllllIlIlIIIIIIlIllIllIl = 0.0f - (lllllllllllllIlIlIIIIIIlIllllIII + lllllllllllllIlIlIIIIIIlIllIIIll) * 0.01f;
        final float lllllllllllllIlIlIIIIIIlIllIllII = MathHelper.sqrt(lllllllllllllIlIlIIIIIIlIlllIlII * lllllllllllllIlIlIIIIIIlIlllIlII + lllllllllllllIlIlIIIIIIlIlllIIll * lllllllllllllIlIlIIIIIIlIlllIIll + lllllllllllllIlIlIIIIIIlIlllIIlI * lllllllllllllIlIlIIIIIIlIlllIIlI) / 32.0f - (lllllllllllllIlIlIIIIIIlIllllIII + lllllllllllllIlIlIIIIIIlIllIIIll) * 0.01f;
        lllllllllllllIlIlIIIIIIlIllIlllI.begin(5, DefaultVertexFormats.POSITION_TEX_COLOR);
        final int lllllllllllllIlIlIIIIIIlIllIlIll = 8;
        for (int lllllllllllllIlIlIIIIIIlIllIlIlI = 0; lllllllllllllIlIlIIIIIIlIllIlIlI <= 8; ++lllllllllllllIlIlIIIIIIlIllIlIlI) {
            final float lllllllllllllIlIlIIIIIIlIllIlIIl = MathHelper.sin(lllllllllllllIlIlIIIIIIlIllIlIlI % 8 * 6.2831855f / 8.0f) * 0.75f;
            final float lllllllllllllIlIlIIIIIIlIllIlIII = MathHelper.cos(lllllllllllllIlIlIIIIIIlIllIlIlI % 8 * 6.2831855f / 8.0f) * 0.75f;
            final float lllllllllllllIlIlIIIIIIlIllIIlll = lllllllllllllIlIlIIIIIIlIllIlIlI % 8 / 8.0f;
            lllllllllllllIlIlIIIIIIlIllIlllI.pos(lllllllllllllIlIlIIIIIIlIllIlIIl * 0.2f, lllllllllllllIlIlIIIIIIlIllIlIII * 0.2f, 0.0).tex(lllllllllllllIlIlIIIIIIlIllIIlll, lllllllllllllIlIlIIIIIIlIllIllIl).color(0, 0, 0, 255).endVertex();
            lllllllllllllIlIlIIIIIIlIllIlllI.pos(lllllllllllllIlIlIIIIIIlIllIlIIl, lllllllllllllIlIlIIIIIIlIllIlIII, lllllllllllllIlIlIIIIIIlIlllIIII).tex(lllllllllllllIlIlIIIIIIlIllIIlll, lllllllllllllIlIlIIIIIIlIllIllII).color(255, 255, 255, 255).endVertex();
        }
        lllllllllllllIlIlIIIIIIlIllIllll.draw();
        GlStateManager.enableCull();
        GlStateManager.shadeModel(7424);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    @Override
    public void doRender(final EntityDragon lllllllllllllIlIlIIIIIIllIIlllll, final double lllllllllllllIlIlIIIIIIllIlIIllI, final double lllllllllllllIlIlIIIIIIllIIlllIl, final double lllllllllllllIlIlIIIIIIllIIlllII, final float lllllllllllllIlIlIIIIIIllIlIIIll, final float lllllllllllllIlIlIIIIIIllIlIIIlI) {
        super.doRender(lllllllllllllIlIlIIIIIIllIIlllll, lllllllllllllIlIlIIIIIIllIlIIllI, lllllllllllllIlIlIIIIIIllIIlllIl, lllllllllllllIlIlIIIIIIllIIlllII, lllllllllllllIlIlIIIIIIllIlIIIll, lllllllllllllIlIlIIIIIIllIlIIIlI);
        if (lllllllllllllIlIlIIIIIIllIIlllll.healingEnderCrystal != null) {
            this.bindTexture(RenderDragon.ENDERCRYSTAL_BEAM_TEXTURES);
            float lllllllllllllIlIlIIIIIIllIlIIIIl = MathHelper.sin((lllllllllllllIlIlIIIIIIllIIlllll.healingEnderCrystal.ticksExisted + lllllllllllllIlIlIIIIIIllIlIIIlI) * 0.2f) / 2.0f + 0.5f;
            lllllllllllllIlIlIIIIIIllIlIIIIl = (lllllllllllllIlIlIIIIIIllIlIIIIl * lllllllllllllIlIlIIIIIIllIlIIIIl + lllllllllllllIlIlIIIIIIllIlIIIIl) * 0.2f;
            renderCrystalBeams(lllllllllllllIlIlIIIIIIllIlIIllI, lllllllllllllIlIlIIIIIIllIIlllIl, lllllllllllllIlIlIIIIIIllIIlllII, lllllllllllllIlIlIIIIIIllIlIIIlI, lllllllllllllIlIlIIIIIIllIIlllll.posX + (lllllllllllllIlIlIIIIIIllIIlllll.prevPosX - lllllllllllllIlIlIIIIIIllIIlllll.posX) * (1.0f - lllllllllllllIlIlIIIIIIllIlIIIlI), lllllllllllllIlIlIIIIIIllIIlllll.posY + (lllllllllllllIlIlIIIIIIllIIlllll.prevPosY - lllllllllllllIlIlIIIIIIllIIlllll.posY) * (1.0f - lllllllllllllIlIlIIIIIIllIlIIIlI), lllllllllllllIlIlIIIIIIllIIlllll.posZ + (lllllllllllllIlIlIIIIIIllIIlllll.prevPosZ - lllllllllllllIlIlIIIIIIllIIlllll.posZ) * (1.0f - lllllllllllllIlIlIIIIIIllIlIIIlI), lllllllllllllIlIlIIIIIIllIIlllll.ticksExisted, lllllllllllllIlIlIIIIIIllIIlllll.healingEnderCrystal.posX, lllllllllllllIlIlIIIIIIllIlIIIIl + lllllllllllllIlIlIIIIIIllIIlllll.healingEnderCrystal.posY, lllllllllllllIlIlIIIIIIllIIlllll.healingEnderCrystal.posZ);
        }
    }
    
    public RenderDragon(final RenderManager lllllllllllllIlIlIIIIIIllllIIIII) {
        super(lllllllllllllIlIlIIIIIIllllIIIII, new ModelDragon(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEnderDragonEyes(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEnderDragonDeath());
    }
}
