package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.init.*;

public class ParticleBreaking extends Particle
{
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllllIllIIlIlIIIllIl, final Entity lllllllllllllllllIllIIlIlIIIllII, final float lllllllllllllllllIllIIlIIllllIII, final float lllllllllllllllllIllIIlIlIIIlIlI, final float lllllllllllllllllIllIIlIIlllIllI, final float lllllllllllllllllIllIIlIIlllIlIl, final float lllllllllllllllllIllIIlIIlllIlII, final float lllllllllllllllllIllIIlIIlllIIll) {
        float lllllllllllllllllIllIIlIlIIIIlIl = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float lllllllllllllllllIllIIlIlIIIIlII = lllllllllllllllllIllIIlIlIIIIlIl + 0.015609375f;
        float lllllllllllllllllIllIIlIlIIIIIll = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float lllllllllllllllllIllIIlIlIIIIIlI = lllllllllllllllllIllIIlIlIIIIIll + 0.015609375f;
        final float lllllllllllllllllIllIIlIlIIIIIIl = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllllllllIllIIlIlIIIIlIl = this.particleTexture.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            lllllllllllllllllIllIIlIlIIIIlII = this.particleTexture.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            lllllllllllllllllIllIIlIlIIIIIll = this.particleTexture.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            lllllllllllllllllIllIIlIlIIIIIlI = this.particleTexture.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float lllllllllllllllllIllIIlIlIIIIIII = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllllllIllIIlIIllllIII - ParticleBreaking.interpPosX);
        final float lllllllllllllllllIllIIlIIlllllll = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllllllIllIIlIIllllIII - ParticleBreaking.interpPosY);
        final float lllllllllllllllllIllIIlIIllllllI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllllllIllIIlIIllllIII - ParticleBreaking.interpPosZ);
        final int lllllllllllllllllIllIIlIIlllllIl = this.getBrightnessForRender(lllllllllllllllllIllIIlIIllllIII);
        final int lllllllllllllllllIllIIlIIlllllII = lllllllllllllllllIllIIlIIlllllIl >> 16 & 0xFFFF;
        final int lllllllllllllllllIllIIlIIllllIll = lllllllllllllllllIllIIlIIlllllIl & 0xFFFF;
        lllllllllllllllllIllIIlIlIIIllIl.pos(lllllllllllllllllIllIIlIlIIIIIII - lllllllllllllllllIllIIlIlIIIlIlI * lllllllllllllllllIllIIlIlIIIIIIl - lllllllllllllllllIllIIlIIlllIlII * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIlllllll - lllllllllllllllllIllIIlIIlllIllI * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIllllllI - lllllllllllllllllIllIIlIIlllIlIl * lllllllllllllllllIllIIlIlIIIIIIl - lllllllllllllllllIllIIlIIlllIIll * lllllllllllllllllIllIIlIlIIIIIIl).tex(lllllllllllllllllIllIIlIlIIIIlIl, lllllllllllllllllIllIIlIlIIIIIlI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllllllIllIIlIIlllllII, lllllllllllllllllIllIIlIIllllIll).endVertex();
        lllllllllllllllllIllIIlIlIIIllIl.pos(lllllllllllllllllIllIIlIlIIIIIII - lllllllllllllllllIllIIlIlIIIlIlI * lllllllllllllllllIllIIlIlIIIIIIl + lllllllllllllllllIllIIlIIlllIlII * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIlllllll + lllllllllllllllllIllIIlIIlllIllI * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIllllllI - lllllllllllllllllIllIIlIIlllIlIl * lllllllllllllllllIllIIlIlIIIIIIl + lllllllllllllllllIllIIlIIlllIIll * lllllllllllllllllIllIIlIlIIIIIIl).tex(lllllllllllllllllIllIIlIlIIIIlIl, lllllllllllllllllIllIIlIlIIIIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllllllIllIIlIIlllllII, lllllllllllllllllIllIIlIIllllIll).endVertex();
        lllllllllllllllllIllIIlIlIIIllIl.pos(lllllllllllllllllIllIIlIlIIIIIII + lllllllllllllllllIllIIlIlIIIlIlI * lllllllllllllllllIllIIlIlIIIIIIl + lllllllllllllllllIllIIlIIlllIlII * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIlllllll + lllllllllllllllllIllIIlIIlllIllI * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIllllllI + lllllllllllllllllIllIIlIIlllIlIl * lllllllllllllllllIllIIlIlIIIIIIl + lllllllllllllllllIllIIlIIlllIIll * lllllllllllllllllIllIIlIlIIIIIIl).tex(lllllllllllllllllIllIIlIlIIIIlII, lllllllllllllllllIllIIlIlIIIIIll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllllllIllIIlIIlllllII, lllllllllllllllllIllIIlIIllllIll).endVertex();
        lllllllllllllllllIllIIlIlIIIllIl.pos(lllllllllllllllllIllIIlIlIIIIIII + lllllllllllllllllIllIIlIlIIIlIlI * lllllllllllllllllIllIIlIlIIIIIIl - lllllllllllllllllIllIIlIIlllIlII * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIlllllll - lllllllllllllllllIllIIlIIlllIllI * lllllllllllllllllIllIIlIlIIIIIIl, lllllllllllllllllIllIIlIIllllllI + lllllllllllllllllIllIIlIIlllIlIl * lllllllllllllllllIllIIlIlIIIIIIl - lllllllllllllllllIllIIlIIlllIIll * lllllllllllllllllIllIIlIlIIIIIIl).tex(lllllllllllllllllIllIIlIlIIIIlII, lllllllllllllllllIllIIlIlIIIIIlI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllllllIllIIlIIlllllII, lllllllllllllllllIllIIlIIllllIll).endVertex();
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected ParticleBreaking(final World lllllllllllllllllIllIIlIllIlllIl, final double lllllllllllllllllIllIIlIllIllIll, final double lllllllllllllllllIllIIlIllIllIlI, final double lllllllllllllllllIllIIlIllIllIII, final double lllllllllllllllllIllIIlIlllIIllI, final double lllllllllllllllllIllIIlIlllIIlIl, final double lllllllllllllllllIllIIlIllIlIIll, final Item lllllllllllllllllIllIIlIllIlIIII, final int lllllllllllllllllIllIIlIllIIlllI) {
        this(lllllllllllllllllIllIIlIllIlllIl, lllllllllllllllllIllIIlIllIllIll, lllllllllllllllllIllIIlIllIllIlI, lllllllllllllllllIllIIlIllIllIII, lllllllllllllllllIllIIlIllIlIIII, lllllllllllllllllIllIIlIllIIlllI);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllllllIllIIlIlllIIllI;
        this.motionY += lllllllllllllllllIllIIlIlllIIlIl;
        this.motionZ += lllllllllllllllllIllIIlIllIlIIll;
    }
    
    protected ParticleBreaking(final World lllllllllllllllllIllIIlIlIlllIII, final double lllllllllllllllllIllIIlIlIlIlIlI, final double lllllllllllllllllIllIIlIlIlIlIII, final double lllllllllllllllllIllIIlIlIlIIlll, final Item lllllllllllllllllIllIIlIlIlIIlIl, final int lllllllllllllllllIllIIlIlIlIlllI) {
        super(lllllllllllllllllIllIIlIlIlllIII, lllllllllllllllllIllIIlIlIlIlIlI, lllllllllllllllllIllIIlIlIlIlIII, lllllllllllllllllIllIIlIlIlIIlll, 0.0, 0.0, 0.0);
        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(lllllllllllllllllIllIIlIlIlIIlIl, lllllllllllllllllIllIIlIlIlIlllI));
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleGravity = Blocks.SNOW.blockParticleGravity;
        this.particleScale /= 2.0f;
    }
    
    protected ParticleBreaking(final World lllllllllllllllllIllIIllIIIIlIlI, final double lllllllllllllllllIllIIllIIIIlIII, final double lllllllllllllllllIllIIllIIIIIllI, final double lllllllllllllllllIllIIllIIIIllIl, final Item lllllllllllllllllIllIIllIIIIllII) {
        this(lllllllllllllllllIllIIllIIIIlIlI, lllllllllllllllllIllIIllIIIIlIII, lllllllllllllllllIllIIllIIIIIllI, lllllllllllllllllIllIIllIIIIllIl, lllllllllllllllllIllIIllIIIIllII, 0);
    }
    
    public static class SlimeFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIIIIIIlIlIlIllIIll, final World lllllllllllllIIIIIIIlIlIlIllIIlI, final double lllllllllllllIIIIIIIlIlIlIlIlIIl, final double lllllllllllllIIIIIIIlIlIlIlIlIII, final double lllllllllllllIIIIIIIlIlIlIlIIlll, final double lllllllllllllIIIIIIIlIlIlIlIlllI, final double lllllllllllllIIIIIIIlIlIlIlIllIl, final double lllllllllllllIIIIIIIlIlIlIlIllII, final int... lllllllllllllIIIIIIIlIlIlIlIlIll) {
            return new ParticleBreaking(lllllllllllllIIIIIIIlIlIlIllIIlI, lllllllllllllIIIIIIIlIlIlIlIlIIl, lllllllllllllIIIIIIIlIlIlIlIlIII, lllllllllllllIIIIIIIlIlIlIlIIlll, Items.SLIME_BALL);
        }
    }
    
    public static class SnowballFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIllIIlIIllIlIIIlll, final World llllllllllllllIllIIlIIllIlIIIllI, final double llllllllllllllIllIIlIIllIIllllIl, final double llllllllllllllIllIIlIIllIIllllII, final double llllllllllllllIllIIlIIllIIlllIll, final double llllllllllllllIllIIlIIllIlIIIIlI, final double llllllllllllllIllIIlIIllIlIIIIIl, final double llllllllllllllIllIIlIIllIlIIIIII, final int... llllllllllllllIllIIlIIllIIllllll) {
            return new ParticleBreaking(llllllllllllllIllIIlIIllIlIIIllI, llllllllllllllIllIIlIIllIIllllIl, llllllllllllllIllIIlIIllIIllllII, llllllllllllllIllIIlIIllIIlllIll, Items.SNOWBALL);
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIlIIlIIIlIllIIll, final World lllllllllllllIIlIlIIlIIIlIlIlIII, final double lllllllllllllIIlIlIIlIIIlIlIIlll, final double lllllllllllllIIlIlIIlIIIlIlIIllI, final double lllllllllllllIIlIlIIlIIIlIlIIlIl, final double lllllllllllllIIlIlIIlIIIlIlIIlII, final double lllllllllllllIIlIlIIlIIIlIlIllIl, final double lllllllllllllIIlIlIIlIIIlIlIllII, final int... lllllllllllllIIlIlIIlIIIlIlIIIIl) {
            final int lllllllllllllIIlIlIIlIIIlIlIlIlI = (lllllllllllllIIlIlIIlIIIlIlIIIIl.length > 1) ? lllllllllllllIIlIlIIlIIIlIlIIIIl[1] : 0;
            return new ParticleBreaking(lllllllllllllIIlIlIIlIIIlIlIlIII, lllllllllllllIIlIlIIlIIIlIlIIlll, lllllllllllllIIlIlIIlIIIlIlIIllI, lllllllllllllIIlIlIIlIIIlIlIIlIl, lllllllllllllIIlIlIIlIIIlIlIIlII, lllllllllllllIIlIlIIlIIIlIlIllIl, lllllllllllllIIlIlIIlIIIlIlIllII, Item.getItemById(lllllllllllllIIlIlIIlIIIlIlIIIIl[0]), lllllllllllllIIlIlIIlIIIlIlIlIlI);
        }
    }
}
