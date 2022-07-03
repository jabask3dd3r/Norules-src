package me.nrules.module.render;

import org.lwjgl.opengl.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.math.*;
import me.nrules.utils.render.*;
import net.minecraft.client.entity.*;
import me.nrules.event.*;
import me.nrules.module.*;
import me.nrules.event.events.*;

public class Trajectories extends Module
{
    /* synthetic */ double x;
    /* synthetic */ double motionY;
    /* synthetic */ double y;
    private /* synthetic */ double b;
    /* synthetic */ double motionZ;
    /* synthetic */ double z;
    private /* synthetic */ double r;
    private /* synthetic */ double g;
    /* synthetic */ double motionX;
    
    public void enableDefaults() {
        GL11.glDisable(2896);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glEnable(32925);
        GL11.glDepthMask(false);
    }
    
    private boolean isThrowable(final Item lllllllllllllIlIllIlIIlIIllllIll) {
        return lllllllllllllIlIllIlIIlIIllllIll instanceof ItemBow || lllllllllllllIlIllIlIIlIIllllIll instanceof ItemSnowball || lllllllllllllIlIllIlIIlIIllllIll instanceof ItemEgg || lllllllllllllIlIllIlIIlIIllllIll instanceof ItemEnderPearl;
    }
    
    @EventTarget
    public void onRender(final Event3D lllllllllllllIlIllIlIIlIlIIllIlI) {
        final EntityPlayerSP lllllllllllllIlIllIlIIlIlIIllIIl = Trajectories.mc.player;
        if (lllllllllllllIlIllIlIIlIlIIllIIl.inventory.getCurrentItem() != null && this.isThrowable(lllllllllllllIlIllIlIIlIlIIllIIl.inventory.getCurrentItem().getItem())) {
            this.x = lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosX + (lllllllllllllIlIllIlIIlIlIIllIIl.posX - lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosX) * Trajectories.mc.timer.renderPartialTicks - MathHelper.cos((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationYaw)) * 0.16f;
            this.y = lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosY + (lllllllllllllIlIllIlIIlIlIIllIIl.posY - lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosY) * Trajectories.mc.timer.renderPartialTicks + lllllllllllllIlIllIlIIlIlIIllIIl.getEyeHeight() - 0.100149011612;
            this.z = lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosZ + (lllllllllllllIlIllIlIIlIlIIllIIl.posZ - lllllllllllllIlIllIlIIlIlIIllIIl.lastTickPosZ) * Trajectories.mc.timer.renderPartialTicks - MathHelper.sin((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationYaw)) * 0.16f;
            float lllllllllllllIlIllIlIIlIlIIllIII = 1.0f;
            if (!(lllllllllllllIlIllIlIIlIlIIllIIl.inventory.getCurrentItem().getItem() instanceof ItemBow)) {
                lllllllllllllIlIllIlIIlIlIIllIII = 0.4f;
            }
            this.motionX = -MathHelper.sin((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationYaw)) * MathHelper.cos((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationPitch)) * lllllllllllllIlIllIlIIlIlIIllIII;
            this.motionZ = MathHelper.cos((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationYaw)) * MathHelper.cos((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationPitch)) * lllllllllllllIlIllIlIIlIlIIllIII;
            this.motionY = -MathHelper.sin((float)Math.toRadians(lllllllllllllIlIllIlIIlIlIIllIIl.rotationPitch)) * lllllllllllllIlIllIlIIlIlIIllIII;
            final double lllllllllllllIlIllIlIIlIlIIlIlll = Math.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.motionX /= lllllllllllllIlIllIlIIlIlIIlIlll;
            this.motionY /= lllllllllllllIlIllIlIIlIlIIlIlll;
            this.motionZ /= lllllllllllllIlIllIlIIlIlIIlIlll;
            if (lllllllllllllIlIllIlIIlIlIIllIIl.inventory.getCurrentItem().getItem() instanceof ItemBow) {
                float lllllllllllllIlIllIlIIlIlIIlIllI = (72000 - lllllllllllllIlIllIlIIlIlIIllIIl.getItemInUseCount()) / 20.0f;
                lllllllllllllIlIllIlIIlIlIIlIllI = (lllllllllllllIlIllIlIIlIlIIlIllI * lllllllllllllIlIllIlIIlIlIIlIllI + lllllllllllllIlIllIlIIlIlIIlIllI * 2.0f) / 3.0f;
                if (lllllllllllllIlIllIlIIlIlIIlIllI > 1.0f) {
                    lllllllllllllIlIllIlIIlIlIIlIllI = 1.0f;
                }
                if (lllllllllllllIlIllIlIIlIlIIlIllI <= 0.1f) {
                    lllllllllllllIlIllIlIIlIlIIlIllI = 1.0f;
                }
                lllllllllllllIlIllIlIIlIlIIlIllI *= 2.0f;
                lllllllllllllIlIllIlIIlIlIIlIllI *= 1.5f;
                this.motionX *= lllllllllllllIlIllIlIIlIlIIlIllI;
                this.motionY *= lllllllllllllIlIllIlIIlIlIIlIllI;
                this.motionZ *= lllllllllllllIlIllIlIIlIlIIlIllI;
            }
            else {
                this.motionX *= 1.5;
                this.motionY *= 1.5;
                this.motionZ *= 1.5;
            }
            final Vec3d lllllllllllllIlIllIlIIlIlIIlIlIl = new Vec3d(lllllllllllllIlIllIlIIlIlIIllIIl.posX, lllllllllllllIlIllIlIIlIlIIllIIl.posY + lllllllllllllIlIllIlIIlIlIIllIIl.getEyeHeight(), lllllllllllllIlIllIlIIlIlIIllIIl.posZ);
            GL11.glPushMatrix();
            this.enableDefaults();
            GL11.glLineWidth(1.8f);
            GL11.glColor3d(this.r, this.g, this.b);
            GL11.glBegin(3);
            final double lllllllllllllIlIllIlIIlIlIIlIlII = this.getGravity(lllllllllllllIlIllIlIIlIlIIllIIl.inventory.getCurrentItem().getItem());
            for (int lllllllllllllIlIllIlIIlIlIIlIIll = 0; lllllllllllllIlIllIlIIlIlIIlIIll < 1000; ++lllllllllllllIlIllIlIIlIlIIlIIll) {
                final double lllllllllllllIlIllIlIIlIlIIlIIlI = this.x * 1.0 - RenderManager.renderPosX;
                final double lllllllllllllIlIllIlIIlIlIIlIIIl = this.y * 1.0 - RenderManager.renderPosY;
                final double lllllllllllllIlIllIlIIlIlIIlIIII = this.z * 1.0 - RenderManager.renderPosZ;
                GL11.glVertex3d(lllllllllllllIlIllIlIIlIlIIlIIlI, lllllllllllllIlIllIlIIlIlIIlIIIl, lllllllllllllIlIllIlIIlIlIIlIIII);
                this.x += this.motionX;
                this.y += this.motionY;
                this.z += this.motionZ;
                this.motionX *= 0.99;
                this.motionY *= 0.99;
                this.motionZ *= 0.99;
                this.motionY -= lllllllllllllIlIllIlIIlIlIIlIlII;
                if (Trajectories.mc.world.rayTraceBlocks(lllllllllllllIlIllIlIIlIlIIlIlIl, new Vec3d(this.x, this.y, this.z)) != null) {
                    break;
                }
            }
            GL11.glEnd();
            final AxisAlignedBB lllllllllllllIlIllIlIIlIlIIIllll = new AxisAlignedBB(this.x - 0.5 - RenderManager.renderPosX, this.y - 0.5 - RenderManager.renderPosY, this.z - 0.5 - RenderManager.renderPosZ, this.x - 0.5 - RenderManager.renderPosX + 1.0, this.y - 0.5 - RenderManager.renderPosY + 1.0, this.z - 0.5 - RenderManager.renderPosZ + 1.0);
            GL11.glTranslated(this.x - RenderManager.renderPosX, this.y - RenderManager.renderPosY, this.z - RenderManager.renderPosZ);
            GL11.glRotatef(Trajectories.mc.player.rotationYaw, 0.0f, (float)(this.y - RenderManager.renderPosY), 0.0f);
            GL11.glTranslated(-(this.x - RenderManager.renderPosX), -(this.y - RenderManager.renderPosY), -(this.z - RenderManager.renderPosZ));
            RenderUtils.drawESP(this.x - 0.35 - RenderManager.renderPosX, this.y - 0.5 - RenderManager.renderPosY, this.z - 0.5 - RenderManager.renderPosZ, this.r, this.b, this.g);
            this.disableDefaults();
            GL11.glPopMatrix();
        }
    }
    
    public void disableDefaults() {
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(32925);
        GL11.glDepthMask(true);
        GL11.glDisable(2848);
        GL11.glEnable(2896);
    }
    
    public Trajectories() {
        super("Trajectories", 0, Category.RENDER);
    }
    
    public void drawLine3D(final float lllllllllllllIlIllIlIIlIIlllIIll, final float lllllllllllllIlIllIlIIlIIlllIIlI, final float lllllllllllllIlIllIlIIlIIlllIIIl, final float lllllllllllllIlIllIlIIlIIlllIIII, final float lllllllllllllIlIllIlIIlIIllIlIIl, final float lllllllllllllIlIllIlIIlIIllIlIII) {
        GL11.glVertex3d((double)lllllllllllllIlIllIlIIlIIlllIIll, (double)lllllllllllllIlIllIlIIlIIlllIIlI, (double)lllllllllllllIlIllIlIIlIIlllIIIl);
        GL11.glVertex3d((double)lllllllllllllIlIllIlIIlIIlllIIII, (double)lllllllllllllIlIllIlIIlIIllIlIIl, (double)lllllllllllllIlIllIlIIlIIllIlIII);
    }
    
    private double getGravity(final Item lllllllllllllIlIllIlIIlIlIIIIIII) {
        return (lllllllllllllIlIllIlIIlIlIIIIIII instanceof ItemBow) ? 0.05 : 0.03;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIlIllIlIIlIlIlIIlll) {
        this.r = Trajectories.mc.player.getDistance(this.x, this.y, this.z) / 100.0;
        this.g = 1.0;
        this.b = 0.0;
    }
}
