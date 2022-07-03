package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;

public class RenderBoat extends Render<EntityBoat>
{
    private static final /* synthetic */ ResourceLocation[] BOAT_TEXTURES;
    protected /* synthetic */ ModelBase modelBoat;
    
    public void setupTranslation(final double llllllllllllllIlIIIIIIIlIlIIllll, final double llllllllllllllIlIIIIIIIlIlIIlIll, final double llllllllllllllIlIIIIIIIlIlIIllIl) {
        GlStateManager.translate((float)llllllllllllllIlIIIIIIIlIlIIllll, (float)llllllllllllllIlIIIIIIIlIlIIlIll + 0.375f, (float)llllllllllllllIlIIIIIIIlIlIIllIl);
    }
    
    public RenderBoat(final RenderManager llllllllllllllIlIIIIIIIlIllllIIl) {
        super(llllllllllllllIlIIIIIIIlIllllIIl);
        this.modelBoat = new ModelBoat();
        this.shadowSize = 0.5f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityBoat llllllllllllllIlIIIIIIIlIlIIIlll) {
        return RenderBoat.BOAT_TEXTURES[llllllllllllllIlIIIIIIIlIlIIIlll.getBoatType().ordinal()];
    }
    
    @Override
    public boolean isMultipass() {
        return true;
    }
    
    static {
        BOAT_TEXTURES = new ResourceLocation[] { new ResourceLocation("textures/entity/boat/boat_oak.png"), new ResourceLocation("textures/entity/boat/boat_spruce.png"), new ResourceLocation("textures/entity/boat/boat_birch.png"), new ResourceLocation("textures/entity/boat/boat_jungle.png"), new ResourceLocation("textures/entity/boat/boat_acacia.png"), new ResourceLocation("textures/entity/boat/boat_darkoak.png") };
    }
    
    public void setupRotation(final EntityBoat llllllllllllllIlIIIIIIIlIlIllIII, final float llllllllllllllIlIIIIIIIlIlIlllII, final float llllllllllllllIlIIIIIIIlIlIllIll) {
        GlStateManager.rotate(180.0f - llllllllllllllIlIIIIIIIlIlIlllII, 0.0f, 1.0f, 0.0f);
        final float llllllllllllllIlIIIIIIIlIlIllIlI = llllllllllllllIlIIIIIIIlIlIllIII.getTimeSinceHit() - llllllllllllllIlIIIIIIIlIlIllIll;
        float llllllllllllllIlIIIIIIIlIlIllIIl = llllllllllllllIlIIIIIIIlIlIllIII.getDamageTaken() - llllllllllllllIlIIIIIIIlIlIllIll;
        if (llllllllllllllIlIIIIIIIlIlIllIIl < 0.0f) {
            llllllllllllllIlIIIIIIIlIlIllIIl = 0.0f;
        }
        if (llllllllllllllIlIIIIIIIlIlIllIlI > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(llllllllllllllIlIIIIIIIlIlIllIlI) * llllllllllllllIlIIIIIIIlIlIllIlI * llllllllllllllIlIIIIIIIlIlIllIIl / 10.0f * llllllllllllllIlIIIIIIIlIlIllIII.getForwardDirection(), 1.0f, 0.0f, 0.0f);
        }
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
    }
    
    @Override
    public void doRender(final EntityBoat llllllllllllllIlIIIIIIIlIllIlIIl, final double llllllllllllllIlIIIIIIIlIllIlIII, final double llllllllllllllIlIIIIIIIlIllIIlll, final double llllllllllllllIlIIIIIIIlIllIllIl, final float llllllllllllllIlIIIIIIIlIllIIlIl, final float llllllllllllllIlIIIIIIIlIllIlIll) {
        GlStateManager.pushMatrix();
        this.setupTranslation(llllllllllllllIlIIIIIIIlIllIlIII, llllllllllllllIlIIIIIIIlIllIIlll, llllllllllllllIlIIIIIIIlIllIllIl);
        this.setupRotation(llllllllllllllIlIIIIIIIlIllIlIIl, llllllllllllllIlIIIIIIIlIllIIlIl, llllllllllllllIlIIIIIIIlIllIlIll);
        this.bindEntityTexture(llllllllllllllIlIIIIIIIlIllIlIIl);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIlIIIIIIIlIllIlIIl));
        }
        this.modelBoat.render(llllllllllllllIlIIIIIIIlIllIlIIl, llllllllllllllIlIIIIIIIlIllIlIll, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIlIIIIIIIlIllIlIIl, llllllllllllllIlIIIIIIIlIllIlIII, llllllllllllllIlIIIIIIIlIllIIlll, llllllllllllllIlIIIIIIIlIllIllIl, llllllllllllllIlIIIIIIIlIllIIlIl, llllllllllllllIlIIIIIIIlIllIlIll);
    }
    
    @Override
    public void renderMultipass(final EntityBoat llllllllllllllIlIIIIIIIlIIllIlIl, final double llllllllllllllIlIIIIIIIlIIllIlII, final double llllllllllllllIlIIIIIIIlIIlllIlI, final double llllllllllllllIlIIIIIIIlIIlllIIl, final float llllllllllllllIlIIIIIIIlIIllIIIl, final float llllllllllllllIlIIIIIIIlIIllIIII) {
        GlStateManager.pushMatrix();
        this.setupTranslation(llllllllllllllIlIIIIIIIlIIllIlII, llllllllllllllIlIIIIIIIlIIlllIlI, llllllllllllllIlIIIIIIIlIIlllIIl);
        this.setupRotation(llllllllllllllIlIIIIIIIlIIllIlIl, llllllllllllllIlIIIIIIIlIIllIIIl, llllllllllllllIlIIIIIIIlIIllIIII);
        this.bindEntityTexture(llllllllllllllIlIIIIIIIlIIllIlIl);
        ((IMultipassModel)this.modelBoat).renderMultipass(llllllllllllllIlIIIIIIIlIIllIlIl, llllllllllllllIlIIIIIIIlIIllIIII, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }
}
