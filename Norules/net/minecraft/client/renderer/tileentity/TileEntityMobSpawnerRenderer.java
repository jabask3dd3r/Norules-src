package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer<TileEntityMobSpawner>
{
    @Override
    public void func_192841_a(final TileEntityMobSpawner llllllllllllllllIllllIlllIIlIIlI, final double llllllllllllllllIllllIlllIIlIIIl, final double llllllllllllllllIllllIlllIIlIIII, final double llllllllllllllllIllllIlllIIIllll, final float llllllllllllllllIllllIlllIIIlllI, final int llllllllllllllllIllllIlllIIlIlII, final float llllllllllllllllIllllIlllIIlIIll) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllllIllllIlllIIlIIIl + 0.5f, (float)llllllllllllllllIllllIlllIIlIIII, (float)llllllllllllllllIllllIlllIIIllll + 0.5f);
        renderMob(llllllllllllllllIllllIlllIIlIIlI.getSpawnerBaseLogic(), llllllllllllllllIllllIlllIIlIIIl, llllllllllllllllIllllIlllIIlIIII, llllllllllllllllIllllIlllIIIllll, llllllllllllllllIllllIlllIIIlllI);
        GlStateManager.popMatrix();
    }
    
    public static void renderMob(final MobSpawnerBaseLogic llllllllllllllllIllllIllIlllllIl, final double llllllllllllllllIllllIllIlllllII, final double llllllllllllllllIllllIllIllllIll, final double llllllllllllllllIllllIlllIIIIIlI, final float llllllllllllllllIllllIlllIIIIIIl) {
        final Entity llllllllllllllllIllllIlllIIIIIII = llllllllllllllllIllllIllIlllllIl.getCachedEntity();
        if (llllllllllllllllIllllIlllIIIIIII != null) {
            float llllllllllllllllIllllIllIlllllll = 0.53125f;
            final float llllllllllllllllIllllIllIllllllI = Math.max(llllllllllllllllIllllIlllIIIIIII.width, llllllllllllllllIllllIlllIIIIIII.height);
            if (llllllllllllllllIllllIllIllllllI > 1.0) {
                llllllllllllllllIllllIllIlllllll /= llllllllllllllllIllllIllIllllllI;
            }
            GlStateManager.translate(0.0f, 0.4f, 0.0f);
            GlStateManager.rotate((float)(llllllllllllllllIllllIllIlllllIl.getPrevMobRotation() + (llllllllllllllllIllllIllIlllllIl.getMobRotation() - llllllllllllllllIllllIllIlllllIl.getPrevMobRotation()) * llllllllllllllllIllllIlllIIIIIIl) * 10.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.2f, 0.0f);
            GlStateManager.rotate(-30.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.scale(llllllllllllllllIllllIllIlllllll, llllllllllllllllIllllIllIlllllll, llllllllllllllllIllllIllIlllllll);
            llllllllllllllllIllllIlllIIIIIII.setLocationAndAngles(llllllllllllllllIllllIllIlllllII, llllllllllllllllIllllIllIllllIll, llllllllllllllllIllllIlllIIIIIlI, 0.0f, 0.0f);
            Minecraft.getMinecraft().getRenderManager().doRenderEntity(llllllllllllllllIllllIlllIIIIIII, 0.0, 0.0, 0.0, 0.0f, llllllllllllllllIllllIlllIIIIIIl, false);
        }
    }
}
