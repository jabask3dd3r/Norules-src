package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.client.*;

public class ParticleFirework
{
    public static class Overlay extends Particle
    {
        @Override
        public void renderParticle(final BufferBuilder lllllllllllllllIlllIIIlllllIIllI, final Entity lllllllllllllllIlllIIIlllllIIlII, final float lllllllllllllllIlllIIIlllllIIIlI, final float lllllllllllllllIlllIIIllllIIIIlI, final float lllllllllllllllIlllIIIllllIIIIIl, final float lllllllllllllllIlllIIIlllIllllll, final float lllllllllllllllIlllIIIlllIllllIl, final float lllllllllllllllIlllIIIlllIlllIll) {
            final float lllllllllllllllIlllIIIllllIllIIl = 0.25f;
            final float lllllllllllllllIlllIIIllllIlIlll = 0.5f;
            final float lllllllllllllllIlllIIIllllIlIllI = 0.125f;
            final float lllllllllllllllIlllIIIllllIlIlII = 0.375f;
            final float lllllllllllllllIlllIIIllllIlIIIl = 7.1f * MathHelper.sin((this.particleAge + lllllllllllllllIlllIIIlllllIIIlI - 1.0f) * 0.25f * 3.1415927f);
            this.setAlphaF(0.6f - (this.particleAge + lllllllllllllllIlllIIIlllllIIIlI - 1.0f) * 0.25f * 0.5f);
            final float lllllllllllllllIlllIIIllllIIllll = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllllIlllIIIlllllIIIlI - Overlay.interpPosX);
            final float lllllllllllllllIlllIIIllllIIllIl = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllllIlllIIIlllllIIIlI - Overlay.interpPosY);
            final float lllllllllllllllIlllIIIllllIIllII = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllllIlllIIIlllllIIIlI - Overlay.interpPosZ);
            final int lllllllllllllllIlllIIIllllIIlIll = this.getBrightnessForRender(lllllllllllllllIlllIIIlllllIIIlI);
            final int lllllllllllllllIlllIIIllllIIlIlI = lllllllllllllllIlllIIIllllIIlIll >> 16 & 0xFFFF;
            final int lllllllllllllllIlllIIIllllIIlIIl = lllllllllllllllIlllIIIllllIIlIll & 0xFFFF;
            lllllllllllllllIlllIIIlllllIIllI.pos(lllllllllllllllIlllIIIllllIIllll - lllllllllllllllIlllIIIllllIIIIlI * lllllllllllllllIlllIIIllllIlIIIl - lllllllllllllllIlllIIIlllIllllIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllIl - lllllllllllllllIlllIIIllllIIIIIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllII - lllllllllllllllIlllIIIlllIllllll * lllllllllllllllIlllIIIllllIlIIIl - lllllllllllllllIlllIIIlllIlllIll * lllllllllllllllIlllIIIllllIlIIIl).tex(0.5, 0.375).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllllIlllIIIllllIIlIlI, lllllllllllllllIlllIIIllllIIlIIl).endVertex();
            lllllllllllllllIlllIIIlllllIIllI.pos(lllllllllllllllIlllIIIllllIIllll - lllllllllllllllIlllIIIllllIIIIlI * lllllllllllllllIlllIIIllllIlIIIl + lllllllllllllllIlllIIIlllIllllIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllIl + lllllllllllllllIlllIIIllllIIIIIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllII - lllllllllllllllIlllIIIlllIllllll * lllllllllllllllIlllIIIllllIlIIIl + lllllllllllllllIlllIIIlllIlllIll * lllllllllllllllIlllIIIllllIlIIIl).tex(0.5, 0.125).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllllIlllIIIllllIIlIlI, lllllllllllllllIlllIIIllllIIlIIl).endVertex();
            lllllllllllllllIlllIIIlllllIIllI.pos(lllllllllllllllIlllIIIllllIIllll + lllllllllllllllIlllIIIllllIIIIlI * lllllllllllllllIlllIIIllllIlIIIl + lllllllllllllllIlllIIIlllIllllIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllIl + lllllllllllllllIlllIIIllllIIIIIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllII + lllllllllllllllIlllIIIlllIllllll * lllllllllllllllIlllIIIllllIlIIIl + lllllllllllllllIlllIIIlllIlllIll * lllllllllllllllIlllIIIllllIlIIIl).tex(0.25, 0.125).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllllIlllIIIllllIIlIlI, lllllllllllllllIlllIIIllllIIlIIl).endVertex();
            lllllllllllllllIlllIIIlllllIIllI.pos(lllllllllllllllIlllIIIllllIIllll + lllllllllllllllIlllIIIllllIIIIlI * lllllllllllllllIlllIIIllllIlIIIl - lllllllllllllllIlllIIIlllIllllIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllIl - lllllllllllllllIlllIIIllllIIIIIl * lllllllllllllllIlllIIIllllIlIIIl, lllllllllllllllIlllIIIllllIIllII + lllllllllllllllIlllIIIlllIllllll * lllllllllllllllIlllIIIllllIlIIIl - lllllllllllllllIlllIIIlllIlllIll * lllllllllllllllIlllIIIllllIlIIIl).tex(0.25, 0.375).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllllIlllIIIllllIIlIlI, lllllllllllllllIlllIIIllllIIlIIl).endVertex();
        }
        
        protected Overlay(final World lllllllllllllllIlllIIlIIIIlIIlll, final double lllllllllllllllIlllIIlIIIIllIIII, final double lllllllllllllllIlllIIlIIIIlIlllI, final double lllllllllllllllIlllIIlIIIIlIIIll) {
            super(lllllllllllllllIlllIIlIIIIlIIlll, lllllllllllllllIlllIIlIIIIllIIII, lllllllllllllllIlllIIlIIIIlIlllI, lllllllllllllllIlllIIlIIIIlIIIll);
            this.particleMaxAge = 4;
        }
    }
    
    public static class Starter extends Particle
    {
        /* synthetic */ boolean twinkle;
        private /* synthetic */ NBTTagList fireworkExplosions;
        private /* synthetic */ int fireworkAge;
        private final /* synthetic */ ParticleManager theEffectRenderer;
        
        public Starter(final World lllllllllllllllIIIlIIlllIlIlIlll, final double lllllllllllllllIIIlIIlllIlIlIlIl, final double lllllllllllllllIIIlIIlllIlIlIIll, final double lllllllllllllllIIIlIIlllIIllllII, final double lllllllllllllllIIIlIIlllIlIIllll, final double lllllllllllllllIIIlIIlllIlIIlllI, final double lllllllllllllllIIIlIIlllIlIIllIl, final ParticleManager lllllllllllllllIIIlIIlllIlIIllII, @Nullable final NBTTagCompound lllllllllllllllIIIlIIlllIIllIIlI) {
            super(lllllllllllllllIIIlIIlllIlIlIlll, lllllllllllllllIIIlIIlllIlIlIlIl, lllllllllllllllIIIlIIlllIlIlIIll, lllllllllllllllIIIlIIlllIIllllII, 0.0, 0.0, 0.0);
            this.motionX = lllllllllllllllIIIlIIlllIlIIllll;
            this.motionY = lllllllllllllllIIIlIIlllIlIIlllI;
            this.motionZ = lllllllllllllllIIIlIIlllIlIIllIl;
            this.theEffectRenderer = lllllllllllllllIIIlIIlllIlIIllII;
            this.particleMaxAge = 8;
            if (lllllllllllllllIIIlIIlllIIllIIlI != null) {
                this.fireworkExplosions = lllllllllllllllIIIlIIlllIIllIIlI.getTagList("Explosions", 10);
                if (this.fireworkExplosions.hasNoTags()) {
                    this.fireworkExplosions = null;
                }
                else {
                    this.particleMaxAge = this.fireworkExplosions.tagCount() * 2 - 1;
                    for (int lllllllllllllllIIIlIIlllIlIIlIlI = 0; lllllllllllllllIIIlIIlllIlIIlIlI < this.fireworkExplosions.tagCount(); ++lllllllllllllllIIIlIIlllIlIIlIlI) {
                        final NBTTagCompound lllllllllllllllIIIlIIlllIlIIlIIl = this.fireworkExplosions.getCompoundTagAt(lllllllllllllllIIIlIIlllIlIIlIlI);
                        if (lllllllllllllllIIIlIIlllIlIIlIIl.getBoolean("Flicker")) {
                            this.twinkle = true;
                            this.particleMaxAge += 15;
                            break;
                        }
                    }
                }
            }
        }
        
        private void createShaped(final double lllllllllllllllIIIlIIllIIIIIlIIl, final double[][] lllllllllllllllIIIlIIllIIIIIlIII, final int[] lllllllllllllllIIIlIIllIIIIIIlll, final int[] lllllllllllllllIIIlIIlIllllIlIll, final boolean lllllllllllllllIIIlIIllIIIIIIlIl, final boolean lllllllllllllllIIIlIIllIIIIIIlII, final boolean lllllllllllllllIIIlIIlIllllIlIII) {
            final double lllllllllllllllIIIlIIllIIIIIIIlI = lllllllllllllllIIIlIIllIIIIIlIII[0][0];
            final double lllllllllllllllIIIlIIllIIIIIIIIl = lllllllllllllllIIIlIIllIIIIIlIII[0][1];
            this.createParticle(this.posX, this.posY, this.posZ, lllllllllllllllIIIlIIllIIIIIIIlI * lllllllllllllllIIIlIIllIIIIIlIIl, lllllllllllllllIIIlIIllIIIIIIIIl * lllllllllllllllIIIlIIllIIIIIlIIl, 0.0, lllllllllllllllIIIlIIllIIIIIIlll, lllllllllllllllIIIlIIlIllllIlIll, lllllllllllllllIIIlIIllIIIIIIlIl, lllllllllllllllIIIlIIllIIIIIIlII);
            final float lllllllllllllllIIIlIIllIIIIIIIII = this.rand.nextFloat() * 3.1415927f;
            final double lllllllllllllllIIIlIIlIlllllllll = lllllllllllllllIIIlIIlIllllIlIII ? 0.034 : 0.34;
            for (int lllllllllllllllIIIlIIlIllllllllI = 0; lllllllllllllllIIIlIIlIllllllllI < 3; ++lllllllllllllllIIIlIIlIllllllllI) {
                final double lllllllllllllllIIIlIIlIlllllllIl = lllllllllllllllIIIlIIllIIIIIIIII + lllllllllllllllIIIlIIlIllllllllI * 3.1415927f * lllllllllllllllIIIlIIlIlllllllll;
                double lllllllllllllllIIIlIIlIlllllllII = lllllllllllllllIIIlIIllIIIIIIIlI;
                double lllllllllllllllIIIlIIlIllllllIll = lllllllllllllllIIIlIIllIIIIIIIIl;
                for (int lllllllllllllllIIIlIIlIllllllIlI = 1; lllllllllllllllIIIlIIlIllllllIlI < lllllllllllllllIIIlIIllIIIIIlIII.length; ++lllllllllllllllIIIlIIlIllllllIlI) {
                    final double lllllllllllllllIIIlIIlIllllllIIl = lllllllllllllllIIIlIIllIIIIIlIII[lllllllllllllllIIIlIIlIllllllIlI][0];
                    final double lllllllllllllllIIIlIIlIllllllIII = lllllllllllllllIIIlIIllIIIIIlIII[lllllllllllllllIIIlIIlIllllllIlI][1];
                    for (double lllllllllllllllIIIlIIlIlllllIlll = 0.25; lllllllllllllllIIIlIIlIlllllIlll <= 1.0; lllllllllllllllIIIlIIlIlllllIlll += 0.25) {
                        double lllllllllllllllIIIlIIlIlllllIllI = (lllllllllllllllIIIlIIlIlllllllII + (lllllllllllllllIIIlIIlIllllllIIl - lllllllllllllllIIIlIIlIlllllllII) * lllllllllllllllIIIlIIlIlllllIlll) * lllllllllllllllIIIlIIllIIIIIlIIl;
                        final double lllllllllllllllIIIlIIlIlllllIlIl = (lllllllllllllllIIIlIIlIllllllIll + (lllllllllllllllIIIlIIlIllllllIII - lllllllllllllllIIIlIIlIllllllIll) * lllllllllllllllIIIlIIlIlllllIlll) * lllllllllllllllIIIlIIllIIIIIlIIl;
                        final double lllllllllllllllIIIlIIlIlllllIlII = lllllllllllllllIIIlIIlIlllllIllI * Math.sin(lllllllllllllllIIIlIIlIlllllllIl);
                        lllllllllllllllIIIlIIlIlllllIllI *= Math.cos(lllllllllllllllIIIlIIlIlllllllIl);
                        for (double lllllllllllllllIIIlIIlIlllllIIll = -1.0; lllllllllllllllIIIlIIlIlllllIIll <= 1.0; lllllllllllllllIIIlIIlIlllllIIll += 2.0) {
                            this.createParticle(this.posX, this.posY, this.posZ, lllllllllllllllIIIlIIlIlllllIllI * lllllllllllllllIIIlIIlIlllllIIll, lllllllllllllllIIIlIIlIlllllIlIl, lllllllllllllllIIIlIIlIlllllIlII * lllllllllllllllIIIlIIlIlllllIIll, lllllllllllllllIIIlIIllIIIIIIlll, lllllllllllllllIIIlIIlIllllIlIll, lllllllllllllllIIIlIIllIIIIIIlIl, lllllllllllllllIIIlIIllIIIIIIlII);
                        }
                    }
                    lllllllllllllllIIIlIIlIlllllllII = lllllllllllllllIIIlIIlIllllllIIl;
                    lllllllllllllllIIIlIIlIllllllIll = lllllllllllllllIIIlIIlIllllllIII;
                }
            }
        }
        
        private void createBurst(final int[] lllllllllllllllIIIlIIlIlllIIlllI, final int[] lllllllllllllllIIIlIIlIlllIIllIl, final boolean lllllllllllllllIIIlIIlIlllIIllII, final boolean lllllllllllllllIIIlIIlIlllIIlIll) {
            final double lllllllllllllllIIIlIIlIlllIIlIlI = this.rand.nextGaussian() * 0.05;
            final double lllllllllllllllIIIlIIlIlllIIlIIl = this.rand.nextGaussian() * 0.05;
            for (int lllllllllllllllIIIlIIlIlllIIlIII = 0; lllllllllllllllIIIlIIlIlllIIlIII < 70; ++lllllllllllllllIIIlIIlIlllIIlIII) {
                final double lllllllllllllllIIIlIIlIlllIIIlll = this.motionX * 0.5 + this.rand.nextGaussian() * 0.15 + lllllllllllllllIIIlIIlIlllIIlIlI;
                final double lllllllllllllllIIIlIIlIlllIIIllI = this.motionZ * 0.5 + this.rand.nextGaussian() * 0.15 + lllllllllllllllIIIlIIlIlllIIlIIl;
                final double lllllllllllllllIIIlIIlIlllIIIlIl = this.motionY * 0.5 + this.rand.nextDouble() * 0.5;
                this.createParticle(this.posX, this.posY, this.posZ, lllllllllllllllIIIlIIlIlllIIIlll, lllllllllllllllIIIlIIlIlllIIIlIl, lllllllllllllllIIIlIIlIlllIIIllI, lllllllllllllllIIIlIIlIlllIIlllI, lllllllllllllllIIIlIIlIlllIIllIl, lllllllllllllllIIIlIIlIlllIIllII, lllllllllllllllIIIlIIlIlllIIlIll);
            }
        }
        
        @Override
        public void renderParticle(final BufferBuilder lllllllllllllllIIIlIIlllIIlIlllI, final Entity lllllllllllllllIIIlIIlllIIlIllIl, final float lllllllllllllllIIIlIIlllIIlIllII, final float lllllllllllllllIIIlIIlllIIlIlIll, final float lllllllllllllllIIIlIIlllIIlIlIlI, final float lllllllllllllllIIIlIIlllIIlIlIIl, final float lllllllllllllllIIIlIIlllIIlIlIII, final float lllllllllllllllIIIlIIlllIIlIIlll) {
        }
        
        private void createParticle(final double lllllllllllllllIIIlIIllIlIIIIlIl, final double lllllllllllllllIIIlIIllIlIIlIIIl, final double lllllllllllllllIIIlIIllIlIIlIIII, final double lllllllllllllllIIIlIIllIlIIIIIlI, final double lllllllllllllllIIIlIIllIlIIIlllI, final double lllllllllllllllIIIlIIllIlIIIllIl, final int[] lllllllllllllllIIIlIIllIlIIIllII, final int[] lllllllllllllllIIIlIIllIlIIIlIll, final boolean lllllllllllllllIIIlIIllIlIIIlIlI, final boolean lllllllllllllllIIIlIIllIIlllllII) {
            final Spark lllllllllllllllIIIlIIllIlIIIlIII = new Spark(this.worldObj, lllllllllllllllIIIlIIllIlIIIIlIl, lllllllllllllllIIIlIIllIlIIlIIIl, lllllllllllllllIIIlIIllIlIIlIIII, lllllllllllllllIIIlIIllIlIIIIIlI, lllllllllllllllIIIlIIllIlIIIlllI, lllllllllllllllIIIlIIllIlIIIllIl, this.theEffectRenderer);
            lllllllllllllllIIIlIIllIlIIIlIII.setAlphaF(0.99f);
            lllllllllllllllIIIlIIllIlIIIlIII.setTrail(lllllllllllllllIIIlIIllIlIIIlIlI);
            lllllllllllllllIIIlIIllIlIIIlIII.setTwinkle(lllllllllllllllIIIlIIllIIlllllII);
            final int lllllllllllllllIIIlIIllIlIIIIlll = this.rand.nextInt(lllllllllllllllIIIlIIllIlIIIllII.length);
            lllllllllllllllIIIlIIllIlIIIlIII.setColor(lllllllllllllllIIIlIIllIlIIIllII[lllllllllllllllIIIlIIllIlIIIIlll]);
            if (lllllllllllllllIIIlIIllIlIIIlIll != null && lllllllllllllllIIIlIIllIlIIIlIll.length > 0) {
                lllllllllllllllIIIlIIllIlIIIlIII.setColorFade(lllllllllllllllIIIlIIllIlIIIlIll[this.rand.nextInt(lllllllllllllllIIIlIIllIlIIIlIll.length)]);
            }
            this.theEffectRenderer.addEffect(lllllllllllllllIIIlIIllIlIIIlIII);
        }
        
        @Override
        public void onUpdate() {
            if (this.fireworkAge == 0 && this.fireworkExplosions != null) {
                final boolean lllllllllllllllIIIlIIllIllllIllI = this.isFarFromCamera();
                boolean lllllllllllllllIIIlIIllIllllIlIl = false;
                if (this.fireworkExplosions.tagCount() >= 3) {
                    lllllllllllllllIIIlIIllIllllIlIl = true;
                }
                else {
                    for (int lllllllllllllllIIIlIIllIllllIIll = 0; lllllllllllllllIIIlIIllIllllIIll < this.fireworkExplosions.tagCount(); ++lllllllllllllllIIIlIIllIllllIIll) {
                        final NBTTagCompound lllllllllllllllIIIlIIllIllllIIIl = this.fireworkExplosions.getCompoundTagAt(lllllllllllllllIIIlIIllIllllIIll);
                        if (lllllllllllllllIIIlIIllIllllIIIl.getByte("Type") == 1) {
                            lllllllllllllllIIIlIIllIllllIlIl = true;
                            break;
                        }
                    }
                }
                SoundEvent lllllllllllllllIIIlIIllIlllIlllI = null;
                if (lllllllllllllllIIIlIIllIllllIlIl) {
                    final SoundEvent lllllllllllllllIIIlIIllIlllIllll = lllllllllllllllIIIlIIllIllllIllI ? SoundEvents.ENTITY_FIREWORK_LARGE_BLAST_FAR : SoundEvents.ENTITY_FIREWORK_LARGE_BLAST;
                }
                else {
                    lllllllllllllllIIIlIIllIlllIlllI = (lllllllllllllllIIIlIIllIllllIllI ? SoundEvents.ENTITY_FIREWORK_BLAST_FAR : SoundEvents.ENTITY_FIREWORK_BLAST);
                }
                this.worldObj.playSound(this.posX, this.posY, this.posZ, lllllllllllllllIIIlIIllIlllIlllI, SoundCategory.AMBIENT, 20.0f, 0.95f + this.rand.nextFloat() * 0.1f, true);
            }
            if (this.fireworkAge % 2 == 0 && this.fireworkExplosions != null && this.fireworkAge / 2 < this.fireworkExplosions.tagCount()) {
                final int lllllllllllllllIIIlIIllIlllIllII = this.fireworkAge / 2;
                final NBTTagCompound lllllllllllllllIIIlIIllIlllIlIlI = this.fireworkExplosions.getCompoundTagAt(lllllllllllllllIIIlIIllIlllIllII);
                final int lllllllllllllllIIIlIIllIlllIlIII = lllllllllllllllIIIlIIllIlllIlIlI.getByte("Type");
                final boolean lllllllllllllllIIIlIIllIlllIIllI = lllllllllllllllIIIlIIllIlllIlIlI.getBoolean("Trail");
                final boolean lllllllllllllllIIIlIIllIlllIIlII = lllllllllllllllIIIlIIllIlllIlIlI.getBoolean("Flicker");
                int[] lllllllllllllllIIIlIIllIlllIIIlI = lllllllllllllllIIIlIIllIlllIlIlI.getIntArray("Colors");
                final int[] lllllllllllllllIIIlIIllIlllIIIII = lllllllllllllllIIIlIIllIlllIlIlI.getIntArray("FadeColors");
                if (lllllllllllllllIIIlIIllIlllIIIlI.length == 0) {
                    lllllllllllllllIIIlIIllIlllIIIlI = new int[] { ItemDye.DYE_COLORS[0] };
                }
                if (lllllllllllllllIIIlIIllIlllIlIII == 1) {
                    this.createBall(0.5, 4, lllllllllllllllIIIlIIllIlllIIIlI, lllllllllllllllIIIlIIllIlllIIIII, lllllllllllllllIIIlIIllIlllIIllI, lllllllllllllllIIIlIIllIlllIIlII);
                }
                else if (lllllllllllllllIIIlIIllIlllIlIII == 2) {
                    this.createShaped(0.5, new double[][] { { 0.0, 1.0 }, { 0.3455, 0.309 }, { 0.9511, 0.309 }, { 0.3795918367346939, -0.12653061224489795 }, { 0.6122448979591837, -0.8040816326530612 }, { 0.0, -0.35918367346938773 } }, lllllllllllllllIIIlIIllIlllIIIlI, lllllllllllllllIIIlIIllIlllIIIII, lllllllllllllllIIIlIIllIlllIIllI, lllllllllllllllIIIlIIllIlllIIlII, false);
                }
                else if (lllllllllllllllIIIlIIllIlllIlIII == 3) {
                    this.createShaped(0.5, new double[][] { { 0.0, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.6 }, { 0.6, 0.6 }, { 0.6, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.0 }, { 0.4, 0.0 }, { 0.4, -0.6 }, { 0.2, -0.6 }, { 0.2, -0.4 }, { 0.0, -0.4 } }, lllllllllllllllIIIlIIllIlllIIIlI, lllllllllllllllIIIlIIllIlllIIIII, lllllllllllllllIIIlIIllIlllIIllI, lllllllllllllllIIIlIIllIlllIIlII, true);
                }
                else if (lllllllllllllllIIIlIIllIlllIlIII == 4) {
                    this.createBurst(lllllllllllllllIIIlIIllIlllIIIlI, lllllllllllllllIIIlIIllIlllIIIII, lllllllllllllllIIIlIIllIlllIIllI, lllllllllllllllIIIlIIllIlllIIlII);
                }
                else {
                    this.createBall(0.25, 2, lllllllllllllllIIIlIIllIlllIIIlI, lllllllllllllllIIIlIIllIlllIIIII, lllllllllllllllIIIlIIllIlllIIllI, lllllllllllllllIIIlIIllIlllIIlII);
                }
                final int lllllllllllllllIIIlIIllIllIllllI = lllllllllllllllIIIlIIllIlllIIIlI[0];
                final float lllllllllllllllIIIlIIllIllIlllII = ((lllllllllllllllIIIlIIllIllIllllI & 0xFF0000) >> 16) / 255.0f;
                final float lllllllllllllllIIIlIIllIllIllIll = ((lllllllllllllllIIIlIIllIllIllllI & 0xFF00) >> 8) / 255.0f;
                final float lllllllllllllllIIIlIIllIllIllIlI = ((lllllllllllllllIIIlIIllIllIllllI & 0xFF) >> 0) / 255.0f;
                final Overlay lllllllllllllllIIIlIIllIllIllIIl = new Overlay(this.worldObj, this.posX, this.posY, this.posZ);
                lllllllllllllllIIIlIIllIllIllIIl.setRBGColorF(lllllllllllllllIIIlIIllIllIlllII, lllllllllllllllIIIlIIllIllIllIll, lllllllllllllllIIIlIIllIllIllIlI);
                this.theEffectRenderer.addEffect(lllllllllllllllIIIlIIllIllIllIIl);
            }
            ++this.fireworkAge;
            if (this.fireworkAge > this.particleMaxAge) {
                if (this.twinkle) {
                    final boolean lllllllllllllllIIIlIIllIllIllIII = this.isFarFromCamera();
                    final SoundEvent lllllllllllllllIIIlIIllIllIlIlll = lllllllllllllllIIIlIIllIllIllIII ? SoundEvents.ENTITY_FIREWORK_TWINKLE_FAR : SoundEvents.ENTITY_FIREWORK_TWINKLE;
                    this.worldObj.playSound(this.posX, this.posY, this.posZ, lllllllllllllllIIIlIIllIllIlIlll, SoundCategory.AMBIENT, 20.0f, 0.9f + this.rand.nextFloat() * 0.15f, true);
                }
                this.setExpired();
            }
        }
        
        private boolean isFarFromCamera() {
            final Minecraft lllllllllllllllIIIlIIllIlIllIlll = Minecraft.getMinecraft();
            return lllllllllllllllIIIlIIllIlIllIlll == null || lllllllllllllllIIIlIIllIlIllIlll.getRenderViewEntity() == null || lllllllllllllllIIIlIIllIlIllIlll.getRenderViewEntity().getDistanceSq(this.posX, this.posY, this.posZ) >= 256.0;
        }
        
        private void createBall(final double lllllllllllllllIIIlIIllIIlIIlllI, final int lllllllllllllllIIIlIIllIIIllIIIl, final int[] lllllllllllllllIIIlIIllIIlIIlIll, final int[] lllllllllllllllIIIlIIllIIIlIllll, final boolean lllllllllllllllIIIlIIllIIIlIlllI, final boolean lllllllllllllllIIIlIIllIIlIIIllI) {
            final double lllllllllllllllIIIlIIllIIlIIIlII = this.posX;
            final double lllllllllllllllIIIlIIllIIlIIIIll = this.posY;
            final double lllllllllllllllIIIlIIllIIlIIIIIl = this.posZ;
            for (int lllllllllllllllIIIlIIllIIlIIIIII = -lllllllllllllllIIIlIIllIIIllIIIl; lllllllllllllllIIIlIIllIIlIIIIII <= lllllllllllllllIIIlIIllIIIllIIIl; ++lllllllllllllllIIIlIIllIIlIIIIII) {
                for (int lllllllllllllllIIIlIIllIIIlllllI = -lllllllllllllllIIIlIIllIIIllIIIl; lllllllllllllllIIIlIIllIIIlllllI <= lllllllllllllllIIIlIIllIIIllIIIl; ++lllllllllllllllIIIlIIllIIIlllllI) {
                    for (int lllllllllllllllIIIlIIllIIIllllII = -lllllllllllllllIIIlIIllIIIllIIIl; lllllllllllllllIIIlIIllIIIllllII <= lllllllllllllllIIIlIIllIIIllIIIl; ++lllllllllllllllIIIlIIllIIIllllII) {
                        final double lllllllllllllllIIIlIIllIIIlllIll = lllllllllllllllIIIlIIllIIIlllllI + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double lllllllllllllllIIIlIIllIIIlllIlI = lllllllllllllllIIIlIIllIIlIIIIII + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double lllllllllllllllIIIlIIllIIIlllIII = lllllllllllllllIIIlIIllIIIllllII + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double lllllllllllllllIIIlIIllIIIllIllI = MathHelper.sqrt(lllllllllllllllIIIlIIllIIIlllIll * lllllllllllllllIIIlIIllIIIlllIll + lllllllllllllllIIIlIIllIIIlllIlI * lllllllllllllllIIIlIIllIIIlllIlI + lllllllllllllllIIIlIIllIIIlllIII * lllllllllllllllIIIlIIllIIIlllIII) / lllllllllllllllIIIlIIllIIlIIlllI + this.rand.nextGaussian() * 0.05;
                        this.createParticle(lllllllllllllllIIIlIIllIIlIIIlII, lllllllllllllllIIIlIIllIIlIIIIll, lllllllllllllllIIIlIIllIIlIIIIIl, lllllllllllllllIIIlIIllIIIlllIll / lllllllllllllllIIIlIIllIIIllIllI, lllllllllllllllIIIlIIllIIIlllIlI / lllllllllllllllIIIlIIllIIIllIllI, lllllllllllllllIIIlIIllIIIlllIII / lllllllllllllllIIIlIIllIIIllIllI, lllllllllllllllIIIlIIllIIlIIlIll, lllllllllllllllIIIlIIllIIIlIllll, lllllllllllllllIIIlIIllIIIlIlllI, lllllllllllllllIIIlIIllIIlIIIllI);
                        if (lllllllllllllllIIIlIIllIIlIIIIII != -lllllllllllllllIIIlIIllIIIllIIIl && lllllllllllllllIIIlIIllIIlIIIIII != lllllllllllllllIIIlIIllIIIllIIIl && lllllllllllllllIIIlIIllIIIlllllI != -lllllllllllllllIIIlIIllIIIllIIIl && lllllllllllllllIIIlIIllIIIlllllI != lllllllllllllllIIIlIIllIIIllIIIl) {
                            lllllllllllllllIIIlIIllIIIllllII += lllllllllllllllIIIlIIllIIIllIIIl * 2 - 1;
                        }
                    }
                }
            }
        }
        
        @Override
        public int getFXLayer() {
            return 0;
        }
    }
    
    public static class Spark extends ParticleSimpleAnimated
    {
        private /* synthetic */ boolean hasFadeColour;
        private /* synthetic */ boolean trail;
        private /* synthetic */ float fadeColourGreen;
        private /* synthetic */ float fadeColourRed;
        private final /* synthetic */ ParticleManager effectRenderer;
        private /* synthetic */ boolean twinkle;
        private /* synthetic */ float fadeColourBlue;
        
        public void setTwinkle(final boolean lllllllllllllIlIlIlIIIIIlIlIlIlI) {
            this.twinkle = lllllllllllllIlIlIlIIIIIlIlIlIlI;
        }
        
        @Override
        public boolean isTransparent() {
            return true;
        }
        
        @Override
        public void onUpdate() {
            super.onUpdate();
            if (this.trail && this.particleAge < this.particleMaxAge / 2 && (this.particleAge + this.particleMaxAge) % 2 == 0) {
                final Spark lllllllllllllIlIlIlIIIIIlIIIlIlI = new Spark(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, this.effectRenderer);
                lllllllllllllIlIlIlIIIIIlIIIlIlI.setAlphaF(0.99f);
                lllllllllllllIlIlIlIIIIIlIIIlIlI.setRBGColorF(this.particleRed, this.particleGreen, this.particleBlue);
                lllllllllllllIlIlIlIIIIIlIIIlIlI.particleAge = lllllllllllllIlIlIlIIIIIlIIIlIlI.particleMaxAge / 2;
                if (this.hasFadeColour) {
                    lllllllllllllIlIlIlIIIIIlIIIlIlI.hasFadeColour = true;
                    lllllllllllllIlIlIlIIIIIlIIIlIlI.fadeColourRed = this.fadeColourRed;
                    lllllllllllllIlIlIlIIIIIlIIIlIlI.fadeColourGreen = this.fadeColourGreen;
                    lllllllllllllIlIlIlIIIIIlIIIlIlI.fadeColourBlue = this.fadeColourBlue;
                }
                lllllllllllllIlIlIlIIIIIlIIIlIlI.twinkle = this.twinkle;
                this.effectRenderer.addEffect(lllllllllllllIlIlIlIIIIIlIIIlIlI);
            }
        }
        
        @Override
        public void renderParticle(final BufferBuilder lllllllllllllIlIlIlIIIIIlIIllllI, final Entity lllllllllllllIlIlIlIIIIIlIIlIlII, final float lllllllllllllIlIlIlIIIIIlIIlIIll, final float lllllllllllllIlIlIlIIIIIlIIllIll, final float lllllllllllllIlIlIlIIIIIlIIlIIIl, final float lllllllllllllIlIlIlIIIIIlIIlIIII, final float lllllllllllllIlIlIlIIIIIlIIIllll, final float lllllllllllllIlIlIlIIIIIlIIIlllI) {
            if (!this.twinkle || this.particleAge < this.particleMaxAge / 3 || (this.particleAge + this.particleMaxAge) / 3 % 2 == 0) {
                super.renderParticle(lllllllllllllIlIlIlIIIIIlIIllllI, lllllllllllllIlIlIlIIIIIlIIlIlII, lllllllllllllIlIlIlIIIIIlIIlIIll, lllllllllllllIlIlIlIIIIIlIIllIll, lllllllllllllIlIlIlIIIIIlIIlIIIl, lllllllllllllIlIlIlIIIIIlIIlIIII, lllllllllllllIlIlIlIIIIIlIIIllll, lllllllllllllIlIlIlIIIIIlIIIlllI);
            }
        }
        
        public Spark(final World lllllllllllllIlIlIlIIIIIllIIIllI, final double lllllllllllllIlIlIlIIIIIllIIIlIl, final double lllllllllllllIlIlIlIIIIIllIIIlII, final double lllllllllllllIlIlIlIIIIIllIIIIll, final double lllllllllllllIlIlIlIIIIIlIlllIIl, final double lllllllllllllIlIlIlIIIIIlIlllIII, final double lllllllllllllIlIlIlIIIIIllIIIIII, final ParticleManager lllllllllllllIlIlIlIIIIIlIllIllI) {
            super(lllllllllllllIlIlIlIIIIIllIIIllI, lllllllllllllIlIlIlIIIIIllIIIlIl, lllllllllllllIlIlIlIIIIIllIIIlII, lllllllllllllIlIlIlIIIIIllIIIIll, 160, 8, -0.004f);
            this.motionX = lllllllllllllIlIlIlIIIIIlIlllIIl;
            this.motionY = lllllllllllllIlIlIlIIIIIlIlllIII;
            this.motionZ = lllllllllllllIlIlIlIIIIIllIIIIII;
            this.effectRenderer = lllllllllllllIlIlIlIIIIIlIllIllI;
            this.particleScale *= 0.75f;
            this.particleMaxAge = 48 + this.rand.nextInt(12);
        }
        
        public void setTrail(final boolean lllllllllllllIlIlIlIIIIIlIllIIII) {
            this.trail = lllllllllllllIlIlIlIIIIIlIllIIII;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIlllllllIlIIlIllllll, final World llllllllllllIlllllllIlIIlIlllllI, final double llllllllllllIlllllllIlIIlIllllIl, final double llllllllllllIlllllllIlIIlIllllII, final double llllllllllllIlllllllIlIIlIllIIIl, final double llllllllllllIlllllllIlIIlIllIIII, final double llllllllllllIlllllllIlIIlIlIllll, final double llllllllllllIlllllllIlIIlIlllIII, final int... llllllllllllIlllllllIlIIlIllIlll) {
            final Spark llllllllllllIlllllllIlIIlIllIllI = new Spark(llllllllllllIlllllllIlIIlIlllllI, llllllllllllIlllllllIlIIlIllllIl, llllllllllllIlllllllIlIIlIllllII, llllllllllllIlllllllIlIIlIllIIIl, llllllllllllIlllllllIlIIlIllIIII, llllllllllllIlllllllIlIIlIlIllll, llllllllllllIlllllllIlIIlIlllIII, Minecraft.getMinecraft().effectRenderer);
            llllllllllllIlllllllIlIIlIllIllI.setAlphaF(0.99f);
            return llllllllllllIlllllllIlIIlIllIllI;
        }
    }
}
