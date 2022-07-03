package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class LayerCape implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer llllllllllllllllIIIllllIIIIIlIIl, final float llllllllllllllllIIIllllIIIIIlIII, final float llllllllllllllllIIIllllIIIIIIlll, final float llllllllllllllllIIIllllIIIIIIllI, final float llllllllllllllllIIIllllIIIIIIlIl, final float llllllllllllllllIIIllllIIIIIIlII, final float llllllllllllllllIIIllllIIIIIIIll, final float llllllllllllllllIIIllllIIIIIIIlI) {
        if (llllllllllllllllIIIllllIIIIIlIIl.hasPlayerInfo() && !llllllllllllllllIIIllllIIIIIlIIl.isInvisible() && llllllllllllllllIIIllllIIIIIlIIl.isWearing(EnumPlayerModelParts.CAPE)) {
            final ItemStack llllllllllllllllIIIllllIIIIIIIIl = llllllllllllllllIIIllllIIIIIlIIl.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (llllllllllllllllIIIllllIIIIIIIIl.getItem() != Items.ELYTRA && llllllllllllllllIIIllllIIIIIlIIl.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0f, 0.0f, 0.125f);
                final double llllllllllllllllIIIllllIIIIIIIII = llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosX + (llllllllllllllllIIIllllIIIIIlIIl.chasingPosX - llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosX) * llllllllllllllllIIIllllIIIIIIllI - (llllllllllllllllIIIllllIIIIIlIIl.prevPosX + (llllllllllllllllIIIllllIIIIIlIIl.posX - llllllllllllllllIIIllllIIIIIlIIl.prevPosX) * llllllllllllllllIIIllllIIIIIIllI);
                final double llllllllllllllllIIIlllIlllllllll = llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosY + (llllllllllllllllIIIllllIIIIIlIIl.chasingPosY - llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosY) * llllllllllllllllIIIllllIIIIIIllI - (llllllllllllllllIIIllllIIIIIlIIl.prevPosY + (llllllllllllllllIIIllllIIIIIlIIl.posY - llllllllllllllllIIIllllIIIIIlIIl.prevPosY) * llllllllllllllllIIIllllIIIIIIllI);
                final double llllllllllllllllIIIlllIllllllllI = llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosZ + (llllllllllllllllIIIllllIIIIIlIIl.chasingPosZ - llllllllllllllllIIIllllIIIIIlIIl.prevChasingPosZ) * llllllllllllllllIIIllllIIIIIIllI - (llllllllllllllllIIIllllIIIIIlIIl.prevPosZ + (llllllllllllllllIIIllllIIIIIlIIl.posZ - llllllllllllllllIIIllllIIIIIlIIl.prevPosZ) * llllllllllllllllIIIllllIIIIIIllI);
                final float llllllllllllllllIIIlllIlllllllIl = llllllllllllllllIIIllllIIIIIlIIl.prevRenderYawOffset + (llllllllllllllllIIIllllIIIIIlIIl.renderYawOffset - llllllllllllllllIIIllllIIIIIlIIl.prevRenderYawOffset) * llllllllllllllllIIIllllIIIIIIllI;
                final double llllllllllllllllIIIlllIlllllllII = MathHelper.sin(llllllllllllllllIIIlllIlllllllIl * 0.017453292f);
                final double llllllllllllllllIIIlllIllllllIll = -MathHelper.cos(llllllllllllllllIIIlllIlllllllIl * 0.017453292f);
                float llllllllllllllllIIIlllIllllllIlI = (float)llllllllllllllllIIIlllIlllllllll * 10.0f;
                llllllllllllllllIIIlllIllllllIlI = MathHelper.clamp(llllllllllllllllIIIlllIllllllIlI, -6.0f, 32.0f);
                float llllllllllllllllIIIlllIllllllIIl = (float)(llllllllllllllllIIIllllIIIIIIIII * llllllllllllllllIIIlllIlllllllII + llllllllllllllllIIIlllIllllllllI * llllllllllllllllIIIlllIllllllIll) * 100.0f;
                final float llllllllllllllllIIIlllIllllllIII = (float)(llllllllllllllllIIIllllIIIIIIIII * llllllllllllllllIIIlllIllllllIll - llllllllllllllllIIIlllIllllllllI * llllllllllllllllIIIlllIlllllllII) * 100.0f;
                if (llllllllllllllllIIIlllIllllllIIl < 0.0f) {
                    llllllllllllllllIIIlllIllllllIIl = 0.0f;
                }
                if (llllllllllllllllIIIlllIllllllIIl > 165.0f) {
                    llllllllllllllllIIIlllIllllllIIl = 165.0f;
                }
                final float llllllllllllllllIIIlllIlllllIlll = llllllllllllllllIIIllllIIIIIlIIl.prevCameraYaw + (llllllllllllllllIIIllllIIIIIlIIl.cameraYaw - llllllllllllllllIIIllllIIIIIlIIl.prevCameraYaw) * llllllllllllllllIIIllllIIIIIIllI;
                llllllllllllllllIIIlllIllllllIlI += MathHelper.sin((llllllllllllllllIIIllllIIIIIlIIl.prevDistanceWalkedModified + (llllllllllllllllIIIllllIIIIIlIIl.distanceWalkedModified - llllllllllllllllIIIllllIIIIIlIIl.prevDistanceWalkedModified) * llllllllllllllllIIIllllIIIIIIllI) * 6.0f) * 32.0f * llllllllllllllllIIIlllIlllllIlll;
                if (llllllllllllllllIIIllllIIIIIlIIl.isSneaking()) {
                    llllllllllllllllIIIlllIllllllIlI += 25.0f;
                    GlStateManager.translate(0.0f, 0.142f, -0.0178f);
                }
                GlStateManager.rotate(6.0f + llllllllllllllllIIIlllIllllllIIl / 2.0f + llllllllllllllllIIIlllIllllllIlI, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllllllIIIlllIllllllIII / 2.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(-llllllllllllllllIIIlllIllllllIII / 2.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                this.playerRenderer.getMainModel().renderCape(0.0625f);
                GlStateManager.popMatrix();
            }
        }
    }
    
    public LayerCape(final RenderPlayer llllllllllllllllIIIllllIIIIllIll) {
        this.playerRenderer = llllllllllllllllIIIllllIIIIllIll;
    }
}
