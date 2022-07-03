package me.nrules.module.render;

import clickui.settings.*;
import java.util.*;
import me.nrules.event.*;
import me.nrules.event.events.*;
import net.minecraft.entity.player.*;
import me.nrules.utils.friend.*;
import me.nrules.module.combat.*;
import net.minecraft.entity.*;
import java.util.concurrent.*;
import me.nrules.module.*;
import me.nrules.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import java.text.*;
import me.nrules.utils.render.*;
import font.*;

public class DamageParticle extends Module
{
    public static /* synthetic */ Setting rainbowParticles;
    private /* synthetic */ EntityLivingBase lastTarget;
    private /* synthetic */ ArrayList<hit> hits;
    private /* synthetic */ float lastHealth;
    public static /* synthetic */ Setting particleHue;
    
    @EventTarget
    public void b(final Event3D lllllllllllllIIlIlllIlIIIIlIlIIl) {
        try {
            for (final hit lllllllllllllIIlIlllIlIIIIlIlIII : this.hits) {
                if (lllllllllllllIIlIlllIlIIIIlIlIII.isFinished()) {
                    this.hits.remove(lllllllllllllIIlIlllIlIIIIlIlIII);
                }
                else {
                    lllllllllllllIIlIlllIlIIIIlIlIII.onRender();
                }
            }
        }
        catch (Exception ex) {}
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIlIlllIlIIIIllIIlI) {
        for (final EntityPlayer lllllllllllllIIlIlllIlIIIIllIIIl : DamageParticle.mc.world.playerEntities) {
            if (lllllllllllllIIlIlllIlIIIIllIIIl != DamageParticle.mc.player && !lllllllllllllIIlIlllIlIIIIllIIIl.isGlowing() && !FriendManager.isFriend(lllllllllllllIIlIlllIlIIIIllIIIl.getName()) && !lllllllllllllIIlIlllIlIIIIllIIIl.isDead && Killaura.attackCheck(lllllllllllllIIlIlllIlIIIIllIIIl)) {
                if (lllllllllllllIIlIlllIlIIIIllIIIl == null) {
                    this.lastHealth = 20.0f;
                    this.lastTarget = null;
                    return;
                }
                if (this.lastTarget == null || lllllllllllllIIlIlllIlIIIIllIIIl != this.lastTarget) {
                    this.lastTarget = lllllllllllllIIlIlllIlIIIIllIIIl;
                    this.lastHealth = lllllllllllllIIlIlllIlIIIIllIIIl.getHealth();
                    return;
                }
                if (lllllllllllllIIlIlllIlIIIIllIIIl.getHealth() == this.lastHealth) {
                    continue;
                }
                if (lllllllllllllIIlIlllIlIIIIllIIIl.getHealth() < this.lastHealth) {
                    this.hits.add(new hit(lllllllllllllIIlIlllIlIIIIllIIIl.getPosition().add(ThreadLocalRandom.current().nextDouble(-0.5, 0.5), ThreadLocalRandom.current().nextDouble(1.0, 1.5), ThreadLocalRandom.current().nextDouble(-0.5, 0.5)), this.lastHealth - lllllllllllllIIlIlllIlIIIIllIIIl.getHealth()));
                }
                this.lastHealth = lllllllllllllIIlIlllIlIIIIllIIIl.getHealth();
            }
        }
    }
    
    public DamageParticle() {
        super("DamageParticle", 0, Category.RENDER);
        this.hits = new ArrayList<hit>();
        this.lastTarget = null;
        Main.settingsManager.Property(DamageParticle.particleHue = new Setting("Particle Hue", this, 0.800000011920929, 0.0, 1.0, false));
        Main.settingsManager.Property(DamageParticle.rainbowParticles = new Setting("Rainbow Particles", this, false));
    }
    
    class hit
    {
        protected /* synthetic */ Minecraft mc;
        private /* synthetic */ double healthVal;
        private /* synthetic */ long startTime;
        private /* synthetic */ long maxTime;
        private /* synthetic */ BlockPos pos;
        
        public void onRender() {
            final double lllllllllllllIIlllIlllIlIIlllllI = this.pos.getX() + (this.pos.getX() - this.pos.getX()) * this.mc.timer.renderPartialTicks - this.mc.getRenderManager().viewerPosX + 1.5;
            final double lllllllllllllIIlllIlllIlIIllllIl = this.pos.getY() + (this.pos.getY() - this.pos.getY()) * this.mc.timer.renderPartialTicks - this.mc.getRenderManager().viewerPosY;
            final double lllllllllllllIIlllIlllIlIIllllII = this.pos.getZ() + (this.pos.getZ() - this.pos.getZ()) * this.mc.timer.renderPartialTicks - this.mc.getRenderManager().viewerPosZ;
            final float lllllllllllllIIlllIlllIlIIlllIll = (this.mc.gameSettings.thirdPersonView == 2) ? -1.0f : 1.0f;
            final double lllllllllllllIIlllIlllIlIIlllIlI = 2.5;
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GL11.glDisable(3553);
            GL11.glDisable(2929);
            Minecraft.getMinecraft().entityRenderer.setupCameraTransform(this.mc.timer.renderPartialTicks, 0);
            GL11.glTranslated(lllllllllllllIIlllIlllIlIIlllllI, lllllllllllllIIlllIlllIlIIllllIl, lllllllllllllIIlllIlllIlIIllllII);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-this.mc.getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.mc.getRenderManager().playerViewX, lllllllllllllIIlllIlllIlIIlllIll, 0.0f, 0.0f);
            GL11.glScaled(-0.041666668839752674, -0.041666668839752674, 0.041666668839752674);
            final long lllllllllllllIIlllIlllIlIIllIlll = this.startTime + this.maxTime - System.currentTimeMillis();
            float lllllllllllllIIlllIlllIlIIllIllI = 0.0f;
            float lllllllllllllIIlllIlllIlIIlllIII = 0.0f;
            if (lllllllllllllIIlllIlllIlIIllIlll < 75L) {
                final float lllllllllllllIIlllIlllIlIIlllIIl = Math.min(lllllllllllllIIlllIlllIlIIllIlll / 75.0f, 1.0f);
                lllllllllllllIIlllIlllIlIIllIllI = Math.min(lllllllllllllIIlllIlllIlIIllIlll / 75.0f, 1.0f);
            }
            else {
                lllllllllllllIIlllIlllIlIIlllIII = Math.min((System.currentTimeMillis() - this.startTime) / 300.0f, 1.0f);
                lllllllllllllIIlllIlllIlIIllIllI = Math.min((System.currentTimeMillis() - this.startTime) / 600.0f, 1.0f);
            }
            GlStateManager.scale(0.8 * lllllllllllllIIlllIlllIlIIlllIII, 0.8 * lllllllllllllIIlllIlllIlIIlllIII, 0.8 * lllllllllllllIIlllIlllIlIIlllIII);
            Gui.drawRect(-100.0, -100.0, 100.0, 100.0, new Color(255, 0, 0, 0).getRGB());
            final Color lllllllllllllIIlllIlllIlIIllIlIl = Color.getHSBColor(DamageParticle.particleHue.getValFloat(), 1.0f, 1.0f);
            final MinecraftFontRenderer lllllllllllllIIlllIlllIlIIllIlII = FontLoader.INSTANCE.hind_19;
            if (DamageParticle.rainbowParticles.getValBoolean()) {
                lllllllllllllIIlllIlllIlIIllIlII.drawStringWithShadow(new DecimalFormat("#.#").format(this.healthVal), 0, (int)(-lllllllllllllIIlllIlllIlIIllIllI), RenderUtils.astofloc(6000));
            }
            else {
                lllllllllllllIIlllIlllIlIIllIlII.drawStringWithShadow(new DecimalFormat("#.#").format(this.healthVal), 0, (int)(-lllllllllllllIIlllIlllIlIIllIllI), lllllllllllllIIlllIlllIlIIllIlIl.getRGB());
            }
            GL11.glDisable(3042);
            GL11.glEnable(3553);
            GL11.glDisable(2848);
            GL11.glDisable(3042);
            GL11.glEnable(2929);
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
        
        public hit(final BlockPos lllllllllllllIIlllIlllIlIlIIllII, final double lllllllllllllIIlllIlllIlIlIIlIll) {
            this.mc = Minecraft.getMinecraft();
            this.startTime = System.currentTimeMillis();
            this.maxTime = 1000L;
            this.startTime = System.currentTimeMillis();
            this.pos = lllllllllllllIIlllIlllIlIlIIllII;
            this.healthVal = lllllllllllllIIlllIlllIlIlIIlIll;
        }
        
        public boolean isFinished() {
            return System.currentTimeMillis() - this.startTime >= this.maxTime;
        }
    }
}
