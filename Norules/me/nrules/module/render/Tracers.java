package me.nrules.module.render;

import me.nrules.notifications.*;
import me.nrules.event.events.*;
import org.lwjgl.opengl.*;
import me.nrules.utils.render.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import me.nrules.event.*;
import me.nrules.module.*;

public class Tracers extends Module
{
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onEvent3D(final Event3D lllllllllllllIlIIllIIIIIIllllIII) {
        final boolean lllllllllllllIlIIllIIIIIIlllIlll = Tracers.mc.gameSettings.viewBobbing;
        Tracers.mc.gameSettings.viewBobbing = false;
        Tracers.mc.entityRenderer.setupCameraTransform(lllllllllllllIlIIllIIIIIIllllIII.getPartialTicks(), 2);
        Tracers.mc.gameSettings.viewBobbing = lllllllllllllIlIIllIIIIIIlllIlll;
        GL11.glPushMatrix();
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        RenderUtils.startSmooth();
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(0.6f);
        for (final Entity lllllllllllllIlIIllIIIIIIlllIllI : Tracers.mc.world.loadedEntityList) {
            if (lllllllllllllIlIIllIIIIIIlllIllI != Tracers.mc.player) {
                if (!(lllllllllllllIlIIllIIIIIIlllIllI instanceof EntityPlayer)) {
                    continue;
                }
                assert Tracers.mc.getRenderViewEntity() != null;
                Tracers.mc.getRenderViewEntity().getDistanceToEntity(lllllllllllllIlIIllIIIIIIlllIllI);
                final double lllllllllllllIlIIllIIIIIIlllIlIl = lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosX + (lllllllllllllIlIIllIIIIIIlllIllI.posX - lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosX) - Tracers.mc.getRenderManager().viewerPosX;
                final double lllllllllllllIlIIllIIIIIIlllIlII = lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosY + (lllllllllllllIlIIllIIIIIIlllIllI.posY - lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosY) - Tracers.mc.getRenderManager().viewerPosY;
                final double lllllllllllllIlIIllIIIIIIlllIIll = lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosZ + (lllllllllllllIlIIllIIIIIIlllIllI.posZ - lllllllllllllIlIIllIIIIIIlllIllI.lastTickPosZ) - Tracers.mc.getRenderManager().viewerPosZ;
                GL11.glColor4f(255.0f, 255.0f, 255.0f, 255.0f);
                Vec3d lllllllllllllIlIIllIIIIIIlllIIlI = new Vec3d(0.0, 0.0, 1.0);
                lllllllllllllIlIIllIIIIIIlllIIlI = lllllllllllllIlIIllIIIIIIlllIIlI.rotatePitch(-(float)Math.toRadians(Tracers.mc.player.rotationPitch));
                final Vec3d lllllllllllllIlIIllIIIIIIlllIIIl = lllllllllllllIlIIllIIIIIIlllIIlI.rotateYaw(-(float)Math.toRadians(Tracers.mc.player.rotationYaw));
                GL11.glBegin(2);
                GL11.glVertex3d(lllllllllllllIlIIllIIIIIIlllIIIl.xCoord, Tracers.mc.player.getEyeHeight() + lllllllllllllIlIIllIIIIIIlllIIIl.yCoord, lllllllllllllIlIIllIIIIIIlllIIIl.zCoord);
                GL11.glVertex3d(lllllllllllllIlIIllIIIIIIlllIlIl, lllllllllllllIlIIllIIIIIIlllIlII + 1.1, lllllllllllllIlIIllIIIIIIlllIIll);
                GL11.glEnd();
            }
        }
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        RenderUtils.endSmooth();
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public Tracers() {
        super("Tracers", 0, Category.RENDER);
    }
}
