package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderEvokerFangs extends Render<EntityEvokerFangs>
{
    private final /* synthetic */ ModelEvokerFangs field_191330_f;
    private static final /* synthetic */ ResourceLocation field_191329_a;
    
    @Override
    public void doRender(final EntityEvokerFangs llllllllllllllIlIlIlllIlIIlllIIl, final double llllllllllllllIlIlIlllIlIIlllIII, final double llllllllllllllIlIlIlllIlIlIIIIIl, final double llllllllllllllIlIlIlllIlIlIIIIII, final float llllllllllllllIlIlIlllIlIIllllll, final float llllllllllllllIlIlIlllIlIIlllllI) {
        final float llllllllllllllIlIlIlllIlIIllllIl = llllllllllllllIlIlIlllIlIIlllIIl.func_190550_a(llllllllllllllIlIlIlllIlIIlllllI);
        if (llllllllllllllIlIlIlllIlIIllllIl != 0.0f) {
            float llllllllllllllIlIlIlllIlIIllllII = 2.0f;
            if (llllllllllllllIlIlIlllIlIIllllIl > 0.9f) {
                llllllllllllllIlIlIlllIlIIllllII *= (float)((1.0 - llllllllllllllIlIlIlllIlIIllllIl) / 0.10000000149011612);
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            this.bindEntityTexture(llllllllllllllIlIlIlllIlIIlllIIl);
            GlStateManager.translate((float)llllllllllllllIlIlIlllIlIIlllIII, (float)llllllllllllllIlIlIlllIlIlIIIIIl, (float)llllllllllllllIlIlIlllIlIlIIIIII);
            GlStateManager.rotate(90.0f - llllllllllllllIlIlIlllIlIIlllIIl.rotationYaw, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(-llllllllllllllIlIlIlllIlIIllllII, -llllllllllllllIlIlIlllIlIIllllII, llllllllllllllIlIlIlllIlIIllllII);
            final float llllllllllllllIlIlIlllIlIIlllIll = 0.03125f;
            GlStateManager.translate(0.0f, -0.626f, 0.0f);
            this.field_191330_f.render(llllllllllllllIlIlIlllIlIIlllIIl, llllllllllllllIlIlIlllIlIIllllIl, 0.0f, 0.0f, llllllllllllllIlIlIlllIlIIlllIIl.rotationYaw, llllllllllllllIlIlIlllIlIIlllIIl.rotationPitch, 0.03125f);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
            super.doRender(llllllllllllllIlIlIlllIlIIlllIIl, llllllllllllllIlIlIlllIlIIlllIII, llllllllllllllIlIlIlllIlIlIIIIIl, llllllllllllllIlIlIlllIlIlIIIIII, llllllllllllllIlIlIlllIlIIllllll, llllllllllllllIlIlIlllIlIIlllllI);
        }
    }
    
    public RenderEvokerFangs(final RenderManager llllllllllllllIlIlIlllIlIlIIllll) {
        super(llllllllllllllIlIlIlllIlIlIIllll);
        this.field_191330_f = new ModelEvokerFangs();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEvokerFangs llllllllllllllIlIlIlllIlIIlIllll) {
        return RenderEvokerFangs.field_191329_a;
    }
    
    static {
        field_191329_a = new ResourceLocation("textures/entity/illager/fangs.png");
    }
}
