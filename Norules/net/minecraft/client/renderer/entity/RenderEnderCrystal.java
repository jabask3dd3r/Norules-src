package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;

public class RenderEnderCrystal extends Render<EntityEnderCrystal>
{
    private static final /* synthetic */ ResourceLocation ENDER_CRYSTAL_TEXTURES;
    private final /* synthetic */ ModelBase modelEnderCrystal;
    private final /* synthetic */ ModelBase modelEnderCrystalNoBase;
    
    @Override
    public boolean shouldRender(final EntityEnderCrystal lllllllllllllIIIlllIlllllIIIlllI, final ICamera lllllllllllllIIIlllIlllllIIIIlll, final double lllllllllllllIIIlllIlllllIIIllII, final double lllllllllllllIIIlllIlllllIIIlIll, final double lllllllllllllIIIlllIlllllIIIIlII) {
        return super.shouldRender(lllllllllllllIIIlllIlllllIIIlllI, lllllllllllllIIIlllIlllllIIIIlll, lllllllllllllIIIlllIlllllIIIllII, lllllllllllllIIIlllIlllllIIIlIll, lllllllllllllIIIlllIlllllIIIIlII) || lllllllllllllIIIlllIlllllIIIlllI.getBeamTarget() != null;
    }
    
    static {
        ENDER_CRYSTAL_TEXTURES = new ResourceLocation("textures/entity/endercrystal/endercrystal.png");
    }
    
    @Override
    public void doRender(final EntityEnderCrystal lllllllllllllIIIlllIlllllIllIllI, final double lllllllllllllIIIlllIlllllIllIlIl, final double lllllllllllllIIIlllIlllllIlIIlII, final double lllllllllllllIIIlllIlllllIlIIIll, final float lllllllllllllIIIlllIlllllIlIIIlI, final float lllllllllllllIIIlllIlllllIlIIIIl) {
        final float lllllllllllllIIIlllIlllllIllIIII = lllllllllllllIIIlllIlllllIllIllI.innerRotation + lllllllllllllIIIlllIlllllIlIIIIl;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllIIIlllIlllllIllIlIl, (float)lllllllllllllIIIlllIlllllIlIIlII, (float)lllllllllllllIIIlllIlllllIlIIIll);
        this.bindTexture(RenderEnderCrystal.ENDER_CRYSTAL_TEXTURES);
        float lllllllllllllIIIlllIlllllIlIllll = MathHelper.sin(lllllllllllllIIIlllIlllllIllIIII * 0.2f) / 2.0f + 0.5f;
        lllllllllllllIIIlllIlllllIlIllll += lllllllllllllIIIlllIlllllIlIllll * lllllllllllllIIIlllIlllllIlIllll;
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIIlllIlllllIllIllI));
        }
        if (lllllllllllllIIIlllIlllllIllIllI.shouldShowBottom()) {
            this.modelEnderCrystal.render(lllllllllllllIIIlllIlllllIllIllI, 0.0f, lllllllllllllIIIlllIlllllIllIIII * 3.0f, lllllllllllllIIIlllIlllllIlIllll * 0.2f, 0.0f, 0.0f, 0.0625f);
        }
        else {
            this.modelEnderCrystalNoBase.render(lllllllllllllIIIlllIlllllIllIllI, 0.0f, lllllllllllllIIIlllIlllllIllIIII * 3.0f, lllllllllllllIIIlllIlllllIlIllll * 0.2f, 0.0f, 0.0f, 0.0625f);
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        final BlockPos lllllllllllllIIIlllIlllllIlIlllI = lllllllllllllIIIlllIlllllIllIllI.getBeamTarget();
        if (lllllllllllllIIIlllIlllllIlIlllI != null) {
            this.bindTexture(RenderDragon.ENDERCRYSTAL_BEAM_TEXTURES);
            final float lllllllllllllIIIlllIlllllIlIllIl = lllllllllllllIIIlllIlllllIlIlllI.getX() + 0.5f;
            final float lllllllllllllIIIlllIlllllIlIllII = lllllllllllllIIIlllIlllllIlIlllI.getY() + 0.5f;
            final float lllllllllllllIIIlllIlllllIlIlIll = lllllllllllllIIIlllIlllllIlIlllI.getZ() + 0.5f;
            final double lllllllllllllIIIlllIlllllIlIlIlI = lllllllllllllIIIlllIlllllIlIllIl - lllllllllllllIIIlllIlllllIllIllI.posX;
            final double lllllllllllllIIIlllIlllllIlIlIIl = lllllllllllllIIIlllIlllllIlIllII - lllllllllllllIIIlllIlllllIllIllI.posY;
            final double lllllllllllllIIIlllIlllllIlIlIII = lllllllllllllIIIlllIlllllIlIlIll - lllllllllllllIIIlllIlllllIllIllI.posZ;
            RenderDragon.renderCrystalBeams(lllllllllllllIIIlllIlllllIllIlIl + lllllllllllllIIIlllIlllllIlIlIlI, lllllllllllllIIIlllIlllllIlIIlII - 0.3 + lllllllllllllIIIlllIlllllIlIllll * 0.4f + lllllllllllllIIIlllIlllllIlIlIIl, lllllllllllllIIIlllIlllllIlIIIll + lllllllllllllIIIlllIlllllIlIlIII, lllllllllllllIIIlllIlllllIlIIIIl, lllllllllllllIIIlllIlllllIlIllIl, lllllllllllllIIIlllIlllllIlIllII, lllllllllllllIIIlllIlllllIlIlIll, lllllllllllllIIIlllIlllllIllIllI.innerRotation, lllllllllllllIIIlllIlllllIllIllI.posX, lllllllllllllIIIlllIlllllIllIllI.posY, lllllllllllllIIIlllIlllllIllIllI.posZ);
        }
        super.doRender(lllllllllllllIIIlllIlllllIllIllI, lllllllllllllIIIlllIlllllIllIlIl, lllllllllllllIIIlllIlllllIlIIlII, lllllllllllllIIIlllIlllllIlIIIll, lllllllllllllIIIlllIlllllIlIIIlI, lllllllllllllIIIlllIlllllIlIIIIl);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEnderCrystal lllllllllllllIIIlllIlllllIIlIllI) {
        return RenderEnderCrystal.ENDER_CRYSTAL_TEXTURES;
    }
    
    public RenderEnderCrystal(final RenderManager lllllllllllllIIIlllIllllllIIlIlI) {
        super(lllllllllllllIIIlllIllllllIIlIlI);
        this.modelEnderCrystal = new ModelEnderCrystal(0.0f, true);
        this.modelEnderCrystalNoBase = new ModelEnderCrystal(0.0f, false);
        this.shadowSize = 0.5f;
    }
}
