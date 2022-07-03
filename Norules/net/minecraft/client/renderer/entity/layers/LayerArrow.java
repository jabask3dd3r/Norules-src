package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.projectile.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class LayerArrow implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ RenderLivingBase<?> renderer;
    
    public LayerArrow(final RenderLivingBase<?> llllllllllllllIlIIIlIIIIllIIlIll) {
        this.renderer = llllllllllllllIlIIIlIIIIllIIlIll;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllllIlIIIlIIIIlIIllIll, final float llllllllllllllIlIIIlIIIIlIllIIll, final float llllllllllllllIlIIIlIIIIlIllIIlI, final float llllllllllllllIlIIIlIIIIlIllIIIl, final float llllllllllllllIlIIIlIIIIlIllIIII, final float llllllllllllllIlIIIlIIIIlIlIllll, final float llllllllllllllIlIIIlIIIIlIlIlllI, final float llllllllllllllIlIIIlIIIIlIlIllIl) {
        final int llllllllllllllIlIIIlIIIIlIlIllII = llllllllllllllIlIIIlIIIIlIIllIll.getArrowCountInEntity();
        if (llllllllllllllIlIIIlIIIIlIlIllII > 0) {
            final Entity llllllllllllllIlIIIlIIIIlIlIlIll = new EntityTippedArrow(llllllllllllllIlIIIlIIIIlIIllIll.world, llllllllllllllIlIIIlIIIIlIIllIll.posX, llllllllllllllIlIIIlIIIIlIIllIll.posY, llllllllllllllIlIIIlIIIIlIIllIll.posZ);
            final Random llllllllllllllIlIIIlIIIIlIlIlIlI = new Random(llllllllllllllIlIIIlIIIIlIIllIll.getEntityId());
            RenderHelper.disableStandardItemLighting();
            for (int llllllllllllllIlIIIlIIIIlIlIlIIl = 0; llllllllllllllIlIIIlIIIIlIlIlIIl < llllllllllllllIlIIIlIIIIlIlIllII; ++llllllllllllllIlIIIlIIIIlIlIlIIl) {
                GlStateManager.pushMatrix();
                final ModelRenderer llllllllllllllIlIIIlIIIIlIlIlIII = this.renderer.getMainModel().getRandomModelBox(llllllllllllllIlIIIlIIIIlIlIlIlI);
                final ModelBox llllllllllllllIlIIIlIIIIlIlIIlll = llllllllllllllIlIIIlIIIIlIlIlIII.cubeList.get(llllllllllllllIlIIIlIIIIlIlIlIlI.nextInt(llllllllllllllIlIIIlIIIIlIlIlIII.cubeList.size()));
                llllllllllllllIlIIIlIIIIlIlIlIII.postRender(0.0625f);
                float llllllllllllllIlIIIlIIIIlIlIIllI = llllllllllllllIlIIIlIIIIlIlIlIlI.nextFloat();
                float llllllllllllllIlIIIlIIIIlIlIIlIl = llllllllllllllIlIIIlIIIIlIlIlIlI.nextFloat();
                float llllllllllllllIlIIIlIIIIlIlIIlII = llllllllllllllIlIIIlIIIIlIlIlIlI.nextFloat();
                final float llllllllllllllIlIIIlIIIIlIlIIIll = (llllllllllllllIlIIIlIIIIlIlIIlll.posX1 + (llllllllllllllIlIIIlIIIIlIlIIlll.posX2 - llllllllllllllIlIIIlIIIIlIlIIlll.posX1) * llllllllllllllIlIIIlIIIIlIlIIllI) / 16.0f;
                final float llllllllllllllIlIIIlIIIIlIlIIIlI = (llllllllllllllIlIIIlIIIIlIlIIlll.posY1 + (llllllllllllllIlIIIlIIIIlIlIIlll.posY2 - llllllllllllllIlIIIlIIIIlIlIIlll.posY1) * llllllllllllllIlIIIlIIIIlIlIIlIl) / 16.0f;
                final float llllllllllllllIlIIIlIIIIlIlIIIIl = (llllllllllllllIlIIIlIIIIlIlIIlll.posZ1 + (llllllllllllllIlIIIlIIIIlIlIIlll.posZ2 - llllllllllllllIlIIIlIIIIlIlIIlll.posZ1) * llllllllllllllIlIIIlIIIIlIlIIlII) / 16.0f;
                GlStateManager.translate(llllllllllllllIlIIIlIIIIlIlIIIll, llllllllllllllIlIIIlIIIIlIlIIIlI, llllllllllllllIlIIIlIIIIlIlIIIIl);
                llllllllllllllIlIIIlIIIIlIlIIllI = llllllllllllllIlIIIlIIIIlIlIIllI * 2.0f - 1.0f;
                llllllllllllllIlIIIlIIIIlIlIIlIl = llllllllllllllIlIIIlIIIIlIlIIlIl * 2.0f - 1.0f;
                llllllllllllllIlIIIlIIIIlIlIIlII = llllllllllllllIlIIIlIIIIlIlIIlII * 2.0f - 1.0f;
                llllllllllllllIlIIIlIIIIlIlIIllI *= -1.0f;
                llllllllllllllIlIIIlIIIIlIlIIlIl *= -1.0f;
                llllllllllllllIlIIIlIIIIlIlIIlII *= -1.0f;
                final float llllllllllllllIlIIIlIIIIlIlIIIII = MathHelper.sqrt(llllllllllllllIlIIIlIIIIlIlIIllI * llllllllllllllIlIIIlIIIIlIlIIllI + llllllllllllllIlIIIlIIIIlIlIIlII * llllllllllllllIlIIIlIIIIlIlIIlII);
                llllllllllllllIlIIIlIIIIlIlIlIll.rotationYaw = (float)(Math.atan2(llllllllllllllIlIIIlIIIIlIlIIllI, llllllllllllllIlIIIlIIIIlIlIIlII) * 57.29577951308232);
                llllllllllllllIlIIIlIIIIlIlIlIll.rotationPitch = (float)(Math.atan2(llllllllllllllIlIIIlIIIIlIlIIlIl, llllllllllllllIlIIIlIIIIlIlIIIII) * 57.29577951308232);
                llllllllllllllIlIIIlIIIIlIlIlIll.prevRotationYaw = llllllllllllllIlIIIlIIIIlIlIlIll.rotationYaw;
                llllllllllllllIlIIIlIIIIlIlIlIll.prevRotationPitch = llllllllllllllIlIIIlIIIIlIlIlIll.rotationPitch;
                final double llllllllllllllIlIIIlIIIIlIIlllll = 0.0;
                final double llllllllllllllIlIIIlIIIIlIIllllI = 0.0;
                final double llllllllllllllIlIIIlIIIIlIIlllIl = 0.0;
                this.renderer.getRenderManager().doRenderEntity(llllllllllllllIlIIIlIIIIlIlIlIll, 0.0, 0.0, 0.0, 0.0f, llllllllllllllIlIIIlIIIIlIllIIIl, false);
                GlStateManager.popMatrix();
            }
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
