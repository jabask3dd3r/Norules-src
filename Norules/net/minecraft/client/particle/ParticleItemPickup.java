package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class ParticleItemPickup extends Particle
{
    private final /* synthetic */ float yOffset;
    private final /* synthetic */ Entity target;
    private final /* synthetic */ RenderManager renderManager;
    private final /* synthetic */ int maxAge;
    private final /* synthetic */ Entity item;
    private /* synthetic */ int age;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllIllllllIllIlIlIIlI, final Entity llllllllllllllIllllllIllIlIlIIIl, final float llllllllllllllIllllllIllIIlllIll, final float llllllllllllllIllllllIllIlIIllll, final float llllllllllllllIllllllIllIlIIlllI, final float llllllllllllllIllllllIllIlIIllIl, final float llllllllllllllIllllllIllIlIIllII, final float llllllllllllllIllllllIllIlIIlIll) {
        int llllllllllllllIllllllIllIlIIlIlI = 0;
        if (Config.isShaders()) {
            llllllllllllllIllllllIllIlIIlIlI = Shaders.activeProgram;
            Shaders.nextEntity(this.item);
        }
        float llllllllllllllIllllllIllIlIIlIIl = (this.age + llllllllllllllIllllllIllIIlllIll) / this.maxAge;
        llllllllllllllIllllllIllIlIIlIIl *= llllllllllllllIllllllIllIlIIlIIl;
        final double llllllllllllllIllllllIllIlIIlIII = this.item.posX;
        final double llllllllllllllIllllllIllIlIIIlll = this.item.posY;
        final double llllllllllllllIllllllIllIlIIIllI = this.item.posZ;
        final double llllllllllllllIllllllIllIlIIIlIl = this.target.lastTickPosX + (this.target.posX - this.target.lastTickPosX) * llllllllllllllIllllllIllIIlllIll;
        final double llllllllllllllIllllllIllIlIIIlII = this.target.lastTickPosY + (this.target.posY - this.target.lastTickPosY) * llllllllllllllIllllllIllIIlllIll + this.yOffset;
        final double llllllllllllllIllllllIllIlIIIIll = this.target.lastTickPosZ + (this.target.posZ - this.target.lastTickPosZ) * llllllllllllllIllllllIllIIlllIll;
        double llllllllllllllIllllllIllIlIIIIlI = llllllllllllllIllllllIllIlIIlIII + (llllllllllllllIllllllIllIlIIIlIl - llllllllllllllIllllllIllIlIIlIII) * llllllllllllllIllllllIllIlIIlIIl;
        double llllllllllllllIllllllIllIlIIIIIl = llllllllllllllIllllllIllIlIIIlll + (llllllllllllllIllllllIllIlIIIlII - llllllllllllllIllllllIllIlIIIlll) * llllllllllllllIllllllIllIlIIlIIl;
        double llllllllllllllIllllllIllIlIIIIII = llllllllllllllIllllllIllIlIIIllI + (llllllllllllllIllllllIllIlIIIIll - llllllllllllllIllllllIllIlIIIllI) * llllllllllllllIllllllIllIlIIlIIl;
        final int llllllllllllllIllllllIllIIllllll = this.getBrightnessForRender(llllllllllllllIllllllIllIIlllIll);
        final int llllllllllllllIllllllIllIIlllllI = llllllllllllllIllllllIllIIllllll % 65536;
        final int llllllllllllllIllllllIllIIllllIl = llllllllllllllIllllllIllIIllllll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllllIllllllIllIIlllllI, (float)llllllllllllllIllllllIllIIllllIl);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        llllllllllllllIllllllIllIlIIIIlI -= ParticleItemPickup.interpPosX;
        llllllllllllllIllllllIllIlIIIIIl -= ParticleItemPickup.interpPosY;
        llllllllllllllIllllllIllIlIIIIII -= ParticleItemPickup.interpPosZ;
        GlStateManager.enableLighting();
        this.renderManager.doRenderEntity(this.item, llllllllllllllIllllllIllIlIIIIlI, llllllllllllllIllllllIllIlIIIIIl, llllllllllllllIllllllIllIlIIIIII, this.item.rotationYaw, llllllllllllllIllllllIllIIlllIll, false);
        if (Config.isShaders()) {
            Shaders.useProgram(llllllllllllllIllllllIllIlIIlIlI);
        }
    }
    
    public ParticleItemPickup(final World llllllllllllllIllllllIllIllIllII, final Entity llllllllllllllIllllllIllIllIIllI, final Entity llllllllllllllIllllllIllIllIIlIl, final float llllllllllllllIllllllIllIllIIlII) {
        super(llllllllllllllIllllllIllIllIllII, llllllllllllllIllllllIllIllIIllI.posX, llllllllllllllIllllllIllIllIIllI.posY, llllllllllllllIllllllIllIllIIllI.posZ, llllllllllllllIllllllIllIllIIllI.motionX, llllllllllllllIllllllIllIllIIllI.motionY, llllllllllllllIllllllIllIllIIllI.motionZ);
        this.renderManager = Minecraft.getMinecraft().getRenderManager();
        this.item = llllllllllllllIllllllIllIllIIllI;
        this.target = llllllllllllllIllllllIllIllIIlIl;
        this.maxAge = 3;
        this.yOffset = llllllllllllllIllllllIllIllIIlII;
    }
    
    @Override
    public void onUpdate() {
        ++this.age;
        if (this.age == this.maxAge) {
            this.setExpired();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
}
