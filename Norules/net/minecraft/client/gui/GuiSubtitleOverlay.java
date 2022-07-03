package net.minecraft.client.gui;

import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.client.audio.*;

public class GuiSubtitleOverlay extends Gui implements ISoundEventListener
{
    private final /* synthetic */ Minecraft client;
    private /* synthetic */ boolean enabled;
    private final /* synthetic */ List<Subtitle> subtitles;
    
    public GuiSubtitleOverlay(final Minecraft lllllllllllllIIlllIIlIIlIllIIlII) {
        this.subtitles = (List<Subtitle>)Lists.newArrayList();
        this.client = lllllllllllllIIlllIIlIIlIllIIlII;
    }
    
    public void renderSubtitles(final ScaledResolution lllllllllllllIIlllIIlIIlIlIIlIlI) {
        if (!this.enabled && this.client.gameSettings.showSubtitles) {
            this.client.getSoundHandler().addListener(this);
            this.enabled = true;
        }
        else if (this.enabled && !this.client.gameSettings.showSubtitles) {
            this.client.getSoundHandler().removeListener(this);
            this.enabled = false;
        }
        if (this.enabled && !this.subtitles.isEmpty()) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            final Vec3d lllllllllllllIIlllIIlIIlIlIIlIIl = new Vec3d(this.client.player.posX, this.client.player.posY + this.client.player.getEyeHeight(), this.client.player.posZ);
            final Vec3d lllllllllllllIIlllIIlIIlIlIIlIII = new Vec3d(0.0, 0.0, -1.0).rotatePitch(-this.client.player.rotationPitch * 0.017453292f).rotateYaw(-this.client.player.rotationYaw * 0.017453292f);
            final Vec3d lllllllllllllIIlllIIlIIlIlIIIlll = new Vec3d(0.0, 1.0, 0.0).rotatePitch(-this.client.player.rotationPitch * 0.017453292f).rotateYaw(-this.client.player.rotationYaw * 0.017453292f);
            final Vec3d lllllllllllllIIlllIIlIIlIlIIIllI = lllllllllllllIIlllIIlIIlIlIIlIII.crossProduct(lllllllllllllIIlllIIlIIlIlIIIlll);
            int lllllllllllllIIlllIIlIIlIlIIIlIl = 0;
            int lllllllllllllIIlllIIlIIlIlIIIlII = 0;
            final Iterator<Subtitle> lllllllllllllIIlllIIlIIlIlIIIIll = this.subtitles.iterator();
            while (lllllllllllllIIlllIIlIIlIlIIIIll.hasNext()) {
                final Subtitle lllllllllllllIIlllIIlIIlIlIIIIlI = lllllllllllllIIlllIIlIIlIlIIIIll.next();
                if (lllllllllllllIIlllIIlIIlIlIIIIlI.getStartTime() + 3000L <= Minecraft.getSystemTime()) {
                    lllllllllllllIIlllIIlIIlIlIIIIll.remove();
                }
                else {
                    lllllllllllllIIlllIIlIIlIlIIIlII = Math.max(lllllllllllllIIlllIIlIIlIlIIIlII, this.client.fontRendererObj.getStringWidth(lllllllllllllIIlllIIlIIlIlIIIIlI.getString()));
                }
            }
            lllllllllllllIIlllIIlIIlIlIIIlII = lllllllllllllIIlllIIlIIlIlIIIlII + this.client.fontRendererObj.getStringWidth("<") + this.client.fontRendererObj.getStringWidth(" ") + this.client.fontRendererObj.getStringWidth(">") + this.client.fontRendererObj.getStringWidth(" ");
            for (final Subtitle lllllllllllllIIlllIIlIIlIlIIIIIl : this.subtitles) {
                final int lllllllllllllIIlllIIlIIlIlIIIIII = 255;
                final String lllllllllllllIIlllIIlIIlIIllllll = lllllllllllllIIlllIIlIIlIlIIIIIl.getString();
                final Vec3d lllllllllllllIIlllIIlIIlIIlllllI = lllllllllllllIIlllIIlIIlIlIIIIIl.getLocation().subtract(lllllllllllllIIlllIIlIIlIlIIlIIl).normalize();
                final double lllllllllllllIIlllIIlIIlIIllllIl = -lllllllllllllIIlllIIlIIlIlIIIllI.dotProduct(lllllllllllllIIlllIIlIIlIIlllllI);
                final double lllllllllllllIIlllIIlIIlIIllllII = -lllllllllllllIIlllIIlIIlIlIIlIII.dotProduct(lllllllllllllIIlllIIlIIlIIlllllI);
                final boolean lllllllllllllIIlllIIlIIlIIlllIll = lllllllllllllIIlllIIlIIlIIllllII > 0.5;
                final int lllllllllllllIIlllIIlIIlIIlllIlI = lllllllllllllIIlllIIlIIlIlIIIlII / 2;
                final int lllllllllllllIIlllIIlIIlIIlllIIl = this.client.fontRendererObj.FONT_HEIGHT;
                final int lllllllllllllIIlllIIlIIlIIlllIII = lllllllllllllIIlllIIlIIlIIlllIIl / 2;
                final float lllllllllllllIIlllIIlIIlIIllIlll = 1.0f;
                final int lllllllllllllIIlllIIlIIlIIllIllI = this.client.fontRendererObj.getStringWidth(lllllllllllllIIlllIIlIIlIIllllll);
                final int lllllllllllllIIlllIIlIIlIIllIlIl = MathHelper.floor(MathHelper.clampedLerp(255.0, 75.0, (Minecraft.getSystemTime() - lllllllllllllIIlllIIlIIlIlIIIIIl.getStartTime()) / 3000.0f));
                final int lllllllllllllIIlllIIlIIlIIllIlII = lllllllllllllIIlllIIlIIlIIllIlIl << 16 | lllllllllllllIIlllIIlIIlIIllIlIl << 8 | lllllllllllllIIlllIIlIIlIIllIlIl;
                GlStateManager.pushMatrix();
                GlStateManager.translate(lllllllllllllIIlllIIlIIlIlIIlIlI.getScaledWidth() - lllllllllllllIIlllIIlIIlIIlllIlI * 1.0f - 2.0f, lllllllllllllIIlllIIlIIlIlIIlIlI.getScaledHeight() - 30 - lllllllllllllIIlllIIlIIlIlIIIlIl * (lllllllllllllIIlllIIlIIlIIlllIIl + 1) * 1.0f, 0.0f);
                GlStateManager.scale(1.0f, 1.0f, 1.0f);
                Gui.drawRect(-lllllllllllllIIlllIIlIIlIIlllIlI - 1, -lllllllllllllIIlllIIlIIlIIlllIII - 1, lllllllllllllIIlllIIlIIlIIlllIlI + 1, lllllllllllllIIlllIIlIIlIIlllIII + 1, -872415232);
                GlStateManager.enableBlend();
                if (!lllllllllllllIIlllIIlIIlIIlllIll) {
                    if (lllllllllllllIIlllIIlIIlIIllllIl > 0.0) {
                        this.client.fontRendererObj.drawString(">", lllllllllllllIIlllIIlIIlIIlllIlI - this.client.fontRendererObj.getStringWidth(">"), -lllllllllllllIIlllIIlIIlIIlllIII, lllllllllllllIIlllIIlIIlIIllIlII - 16777216);
                    }
                    else if (lllllllllllllIIlllIIlIIlIIllllIl < 0.0) {
                        this.client.fontRendererObj.drawString("<", -lllllllllllllIIlllIIlIIlIIlllIlI, -lllllllllllllIIlllIIlIIlIIlllIII, lllllllllllllIIlllIIlIIlIIllIlII - 16777216);
                    }
                }
                this.client.fontRendererObj.drawString(lllllllllllllIIlllIIlIIlIIllllll, -lllllllllllllIIlllIIlIIlIIllIllI / 2, -lllllllllllllIIlllIIlIIlIIlllIII, lllllllllllllIIlllIIlIIlIIllIlII - 16777216);
                GlStateManager.popMatrix();
                ++lllllllllllllIIlllIIlIIlIlIIIlIl;
            }
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void soundPlay(final ISound lllllllllllllIIlllIIlIIlIIIIllll, final SoundEventAccessor lllllllllllllIIlllIIlIIlIIIIlllI) {
        if (lllllllllllllIIlllIIlIIlIIIIlllI.getSubtitle() != null) {
            final String lllllllllllllIIlllIIlIIlIIIlIIlI = lllllllllllllIIlllIIlIIlIIIIlllI.getSubtitle().getFormattedText();
            if (!this.subtitles.isEmpty()) {
                for (final Subtitle lllllllllllllIIlllIIlIIlIIIlIIIl : this.subtitles) {
                    if (lllllllllllllIIlllIIlIIlIIIlIIIl.getString().equals(lllllllllllllIIlllIIlIIlIIIlIIlI)) {
                        lllllllllllllIIlllIIlIIlIIIlIIIl.refresh(new Vec3d(lllllllllllllIIlllIIlIIlIIIIllll.getXPosF(), lllllllllllllIIlllIIlIIlIIIIllll.getYPosF(), lllllllllllllIIlllIIlIIlIIIIllll.getZPosF()));
                        return;
                    }
                }
            }
            this.subtitles.add(new Subtitle(lllllllllllllIIlllIIlIIlIIIlIIlI, new Vec3d(lllllllllllllIIlllIIlIIlIIIIllll.getXPosF(), lllllllllllllIIlllIIlIIlIIIIllll.getYPosF(), lllllllllllllIIlllIIlIIlIIIIllll.getZPosF())));
        }
    }
    
    public class Subtitle
    {
        private /* synthetic */ long startTime;
        private /* synthetic */ Vec3d location;
        private final /* synthetic */ String subtitle;
        
        public String getString() {
            return this.subtitle;
        }
        
        public long getStartTime() {
            return this.startTime;
        }
        
        public Subtitle(final String lllllllllllllIlIIIlIIlIIIIlIIlII, final Vec3d lllllllllllllIlIIIlIIlIIIIIlllll) {
            this.subtitle = lllllllllllllIlIIIlIIlIIIIlIIlII;
            this.location = lllllllllllllIlIIIlIIlIIIIIlllll;
            this.startTime = Minecraft.getSystemTime();
        }
        
        public void refresh(final Vec3d lllllllllllllIlIIIlIIlIIIIIlIIII) {
            this.location = lllllllllllllIlIIIlIIlIIIIIlIIII;
            this.startTime = Minecraft.getSystemTime();
        }
        
        public Vec3d getLocation() {
            return this.location;
        }
    }
}
