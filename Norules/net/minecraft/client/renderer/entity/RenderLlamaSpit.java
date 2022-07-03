package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderLlamaSpit extends Render<EntityLlamaSpit>
{
    private static final /* synthetic */ ResourceLocation field_191333_a;
    private final /* synthetic */ ModelLlamaSpit field_191334_f;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLlamaSpit llllllllllllllIIIIlIlIIIIIlIIlII) {
        return RenderLlamaSpit.field_191333_a;
    }
    
    public RenderLlamaSpit(final RenderManager llllllllllllllIIIIlIlIIIIIlllIll) {
        super(llllllllllllllIIIIlIlIIIIIlllIll);
        this.field_191334_f = new ModelLlamaSpit();
    }
    
    static {
        field_191333_a = new ResourceLocation("textures/entity/llama/spit.png");
    }
    
    @Override
    public void doRender(final EntityLlamaSpit llllllllllllllIIIIlIlIIIIIllIIlI, final double llllllllllllllIIIIlIlIIIIIllIIIl, final double llllllllllllllIIIIlIlIIIIIllIIII, final double llllllllllllllIIIIlIlIIIIIlIllll, final float llllllllllllllIIIIlIlIIIIIlIlllI, final float llllllllllllllIIIIlIlIIIIIlIllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIIIIlIlIIIIIllIIIl, (float)llllllllllllllIIIIlIlIIIIIllIIII + 0.15f, (float)llllllllllllllIIIIlIlIIIIIlIllll);
        GlStateManager.rotate(llllllllllllllIIIIlIlIIIIIllIIlI.prevRotationYaw + (llllllllllllllIIIIlIlIIIIIllIIlI.rotationYaw - llllllllllllllIIIIlIlIIIIIllIIlI.prevRotationYaw) * llllllllllllllIIIIlIlIIIIIlIllIl - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllllIIIIlIlIIIIIllIIlI.prevRotationPitch + (llllllllllllllIIIIlIlIIIIIllIIlI.rotationPitch - llllllllllllllIIIIlIlIIIIIllIIlI.prevRotationPitch) * llllllllllllllIIIIlIlIIIIIlIllIl, 0.0f, 0.0f, 1.0f);
        this.bindEntityTexture(llllllllllllllIIIIlIlIIIIIllIIlI);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIIIIlIlIIIIIllIIlI));
        }
        this.field_191334_f.render(llllllllllllllIIIIlIlIIIIIllIIlI, llllllllllllllIIIIlIlIIIIIlIllIl, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIIIlIlIIIIIllIIlI, llllllllllllllIIIIlIlIIIIIllIIIl, llllllllllllllIIIIlIlIIIIIllIIII, llllllllllllllIIIIlIlIIIIIlIllll, llllllllllllllIIIIlIlIIIIIlIlllI, llllllllllllllIIIIlIlIIIIIlIllIl);
    }
}
