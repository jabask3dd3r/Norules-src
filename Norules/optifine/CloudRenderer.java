package optifine;

import net.minecraft.util.math.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class CloudRenderer
{
    private /* synthetic */ int glListClouds;
    private /* synthetic */ Vec3d updateCloudColor;
    private /* synthetic */ boolean updated;
    private /* synthetic */ double updatePlayerX;
    private /* synthetic */ double updatePlayerY;
    private /* synthetic */ Minecraft mc;
    /* synthetic */ int cloudTickCounter;
    private /* synthetic */ int updateCloudTickCounter;
    private /* synthetic */ boolean renderFancy;
    /* synthetic */ float partialTicks;
    private /* synthetic */ boolean updateRenderFancy;
    private /* synthetic */ double updatePlayerZ;
    private /* synthetic */ Vec3d cloudColor;
    
    public void reset() {
        this.updated = false;
    }
    
    public CloudRenderer(final Minecraft lllllllllllllIlIIlIIIIIIIlIIIlll) {
        this.updated = false;
        this.renderFancy = false;
        this.updateRenderFancy = false;
        this.updateCloudTickCounter = 0;
        this.updateCloudColor = new Vec3d(-1.0, -1.0, -1.0);
        this.updatePlayerX = 0.0;
        this.updatePlayerY = 0.0;
        this.updatePlayerZ = 0.0;
        this.glListClouds = -1;
        this.mc = lllllllllllllIlIIlIIIIIIIlIIIlll;
        this.glListClouds = GLAllocation.generateDisplayLists(1);
    }
    
    public void endUpdateGlList() {
        GL11.glEndList();
        this.updateRenderFancy = this.renderFancy;
        this.updateCloudTickCounter = this.cloudTickCounter;
        this.updateCloudColor = this.cloudColor;
        this.updatePlayerX = this.mc.getRenderViewEntity().prevPosX;
        this.updatePlayerY = this.mc.getRenderViewEntity().prevPosY;
        this.updatePlayerZ = this.mc.getRenderViewEntity().prevPosZ;
        this.updated = true;
        GlStateManager.resetColor();
    }
    
    public void renderGlList() {
        final Entity lllllllllllllIlIIlIIIIIIIIIllIIl = this.mc.getRenderViewEntity();
        final double lllllllllllllIlIIlIIIIIIIIIllIII = lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosX + (lllllllllllllIlIIlIIIIIIIIIllIIl.posX - lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosX) * this.partialTicks;
        final double lllllllllllllIlIIlIIIIIIIIIlIlll = lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosY + (lllllllllllllIlIIlIIIIIIIIIllIIl.posY - lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosY) * this.partialTicks;
        final double lllllllllllllIlIIlIIIIIIIIIlIllI = lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosZ + (lllllllllllllIlIIlIIIIIIIIIllIIl.posZ - lllllllllllllIlIIlIIIIIIIIIllIIl.prevPosZ) * this.partialTicks;
        final double lllllllllllllIlIIlIIIIIIIIIlIlIl = this.cloudTickCounter - this.updateCloudTickCounter + this.partialTicks;
        final float lllllllllllllIlIIlIIIIIIIIIlIlII = (float)(lllllllllllllIlIIlIIIIIIIIIllIII - this.updatePlayerX + lllllllllllllIlIIlIIIIIIIIIlIlIl * 0.03);
        final float lllllllllllllIlIIlIIIIIIIIIlIIll = (float)(lllllllllllllIlIIlIIIIIIIIIlIlll - this.updatePlayerY);
        final float lllllllllllllIlIIlIIIIIIIIIlIIlI = (float)(lllllllllllllIlIIlIIIIIIIIIlIllI - this.updatePlayerZ);
        GlStateManager.pushMatrix();
        if (this.renderFancy) {
            GlStateManager.translate(-lllllllllllllIlIIlIIIIIIIIIlIlII / 12.0f, -lllllllllllllIlIIlIIIIIIIIIlIIll, -lllllllllllllIlIIlIIIIIIIIIlIIlI / 12.0f);
        }
        else {
            GlStateManager.translate(-lllllllllllllIlIIlIIIIIIIIIlIlII, -lllllllllllllIlIIlIIIIIIIIIlIIll, -lllllllllllllIlIIlIIIIIIIIIlIIlI);
        }
        GlStateManager.callList(this.glListClouds);
        GlStateManager.popMatrix();
        GlStateManager.resetColor();
    }
    
    public void startUpdateGlList() {
        GL11.glNewList(this.glListClouds, 4864);
    }
    
    public void prepareToRender(final boolean lllllllllllllIlIIlIIIIIIIIlllIIl, final int lllllllllllllIlIIlIIIIIIIIlllIII, final float lllllllllllllIlIIlIIIIIIIIllIlll, final Vec3d lllllllllllllIlIIlIIIIIIIIllIllI) {
        this.renderFancy = lllllllllllllIlIIlIIIIIIIIlllIIl;
        this.cloudTickCounter = lllllllllllllIlIIlIIIIIIIIlllIII;
        this.partialTicks = lllllllllllllIlIIlIIIIIIIIllIlll;
        this.cloudColor = lllllllllllllIlIIlIIIIIIIIllIllI;
    }
    
    public boolean shouldUpdateGlList() {
        if (!this.updated) {
            return true;
        }
        if (this.renderFancy != this.updateRenderFancy) {
            return true;
        }
        if (this.cloudTickCounter >= this.updateCloudTickCounter + 20) {
            return true;
        }
        if (Math.abs(this.cloudColor.xCoord - this.updateCloudColor.xCoord) > 0.003) {
            return true;
        }
        if (Math.abs(this.cloudColor.yCoord - this.updateCloudColor.yCoord) > 0.003) {
            return true;
        }
        if (Math.abs(this.cloudColor.zCoord - this.updateCloudColor.zCoord) > 0.003) {
            return true;
        }
        final Entity lllllllllllllIlIIlIIIIIIIIllIIII = this.mc.getRenderViewEntity();
        final boolean lllllllllllllIlIIlIIIIIIIIlIllll = this.updatePlayerY + lllllllllllllIlIIlIIIIIIIIllIIII.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f;
        final boolean lllllllllllllIlIIlIIIIIIIIlIlllI = lllllllllllllIlIIlIIIIIIIIllIIII.prevPosY + lllllllllllllIlIIlIIIIIIIIllIIII.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f;
        return lllllllllllllIlIIlIIIIIIIIlIlllI ^ lllllllllllllIlIIlIIIIIIIIlIllll;
    }
}
