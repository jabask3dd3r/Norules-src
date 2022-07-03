package net.minecraft.client.particle;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import java.util.*;

public class Particle
{
    protected /* synthetic */ float prevParticleAngle;
    protected /* synthetic */ int particleTextureIndexX;
    protected /* synthetic */ TextureAtlasSprite particleTexture;
    private /* synthetic */ AxisAlignedBB boundingBox;
    protected /* synthetic */ float height;
    protected /* synthetic */ Random rand;
    protected /* synthetic */ float width;
    protected /* synthetic */ double motionY;
    protected /* synthetic */ float particleRed;
    protected /* synthetic */ double motionX;
    protected /* synthetic */ float particleGreen;
    protected /* synthetic */ double prevPosX;
    public static /* synthetic */ double interpPosX;
    protected /* synthetic */ float particleTextureJitterX;
    protected /* synthetic */ int particleAge;
    protected /* synthetic */ boolean isExpired;
    protected /* synthetic */ float particleScale;
    protected /* synthetic */ float particleBlue;
    protected /* synthetic */ float particleGravity;
    protected /* synthetic */ float particleAngle;
    protected /* synthetic */ double posY;
    protected /* synthetic */ double prevPosY;
    protected /* synthetic */ int particleMaxAge;
    private static final /* synthetic */ AxisAlignedBB EMPTY_AABB;
    public static /* synthetic */ double interpPosY;
    protected /* synthetic */ double motionZ;
    protected /* synthetic */ double prevPosZ;
    protected /* synthetic */ boolean isCollided;
    public static /* synthetic */ double interpPosZ;
    protected /* synthetic */ int particleTextureIndexY;
    protected /* synthetic */ double posZ;
    protected /* synthetic */ float particleTextureJitterY;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ float particleAlpha;
    public static /* synthetic */ Vec3d cameraViewDir;
    protected /* synthetic */ boolean canCollide;
    protected /* synthetic */ double posX;
    
    public void setEntityBoundingBox(final AxisAlignedBB lllllllllllllIlIlllIIllIIIlIlIIl) {
        this.boundingBox = lllllllllllllIlIlllIIllIIIlIlIIl;
    }
    
    public float getBlueColorF() {
        return this.particleBlue;
    }
    
    public Particle multiplyVelocity(final float lllllllllllllIlIlllIIlllIIIlIlIl) {
        this.motionX *= lllllllllllllIlIlllIIlllIIIlIlIl;
        this.motionY = (this.motionY - 0.10000000149011612) * lllllllllllllIlIlllIIlllIIIlIlIl + 0.10000000149011612;
        this.motionZ *= lllllllllllllIlIlllIIlllIIIlIlIl;
        return this;
    }
    
    protected void setSize(final float lllllllllllllIlIlllIIllIIlllIIIl, final float lllllllllllllIlIlllIIllIIllIllII) {
        if (lllllllllllllIlIlllIIllIIlllIIIl != this.width || lllllllllllllIlIlllIIllIIllIllII != this.height) {
            this.width = lllllllllllllIlIlllIIllIIlllIIIl;
            this.height = lllllllllllllIlIlllIIllIIllIllII;
            final AxisAlignedBB lllllllllllllIlIlllIIllIIllIllll = this.getEntityBoundingBox();
            this.setEntityBoundingBox(new AxisAlignedBB(lllllllllllllIlIlllIIllIIllIllll.minX, lllllllllllllIlIlllIIllIIllIllll.minY, lllllllllllllIlIlllIIllIIllIllll.minZ, lllllllllllllIlIlllIIllIIllIllll.minX + this.width, lllllllllllllIlIlllIIllIIllIllll.minY + this.height, lllllllllllllIlIlllIIllIIllIllll.minZ + this.width));
        }
    }
    
    protected Particle(final World lllllllllllllIlIlllIIlllIIllllll, final double lllllllllllllIlIlllIIlllIIlllllI, final double lllllllllllllIlIlllIIlllIIlllIII, final double lllllllllllllIlIlllIIlllIIllIlll) {
        this.boundingBox = Particle.EMPTY_AABB;
        this.width = 0.6f;
        this.height = 1.8f;
        this.rand = new Random();
        this.particleAlpha = 1.0f;
        this.worldObj = lllllllllllllIlIlllIIlllIIllllll;
        this.setSize(0.2f, 0.2f);
        this.setPosition(lllllllllllllIlIlllIIlllIIlllllI, lllllllllllllIlIlllIIlllIIlllIII, lllllllllllllIlIlllIIlllIIllIlll);
        this.prevPosX = lllllllllllllIlIlllIIlllIIlllllI;
        this.prevPosY = lllllllllllllIlIlllIIlllIIlllIII;
        this.prevPosZ = lllllllllllllIlIlllIIlllIIllIlll;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleTextureJitterX = this.rand.nextFloat() * 3.0f;
        this.particleTextureJitterY = this.rand.nextFloat() * 3.0f;
        this.particleScale = (this.rand.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.particleMaxAge = (int)(4.0f / (this.rand.nextFloat() * 0.9f + 0.1f));
        this.particleAge = 0;
        this.canCollide = true;
    }
    
    public void setParticleTextureIndex(final int lllllllllllllIlIlllIIllIlIIIIIII) {
        if (this.getFXLayer() != 0) {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        this.particleTextureIndexX = lllllllllllllIlIlllIIllIlIIIIIII % 16;
        this.particleTextureIndexY = lllllllllllllIlIlllIIllIlIIIIIII / 16;
    }
    
    public void setMaxAge(final int lllllllllllllIlIlllIIllIlllIlIll) {
        this.particleMaxAge = lllllllllllllIlIlllIIllIlllIlIll;
    }
    
    public void renderParticle(final BufferBuilder lllllllllllllIlIlllIIllIlIlIlIIl, final Entity lllllllllllllIlIlllIIllIllIIlIII, final float lllllllllllllIlIlllIIllIlIlIlIII, final float lllllllllllllIlIlllIIllIlIlIIlll, final float lllllllllllllIlIlllIIllIllIIIlII, final float lllllllllllllIlIlllIIllIlIlIIlIl, final float lllllllllllllIlIlllIIllIlIlIIlII, final float lllllllllllllIlIlllIIllIlIllllll) {
        float lllllllllllllIlIlllIIllIlIllllIl = this.particleTextureIndexX / 16.0f;
        float lllllllllllllIlIlllIIllIlIllllII = lllllllllllllIlIlllIIllIlIllllIl + 0.0624375f;
        float lllllllllllllIlIlllIIllIlIlllIll = this.particleTextureIndexY / 16.0f;
        float lllllllllllllIlIlllIIllIlIlllIlI = lllllllllllllIlIlllIIllIlIlllIll + 0.0624375f;
        final float lllllllllllllIlIlllIIllIlIlllIIl = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllllIlIlllIIllIlIllllIl = this.particleTexture.getMinU();
            lllllllllllllIlIlllIIllIlIllllII = this.particleTexture.getMaxU();
            lllllllllllllIlIlllIIllIlIlllIll = this.particleTexture.getMinV();
            lllllllllllllIlIlllIIllIlIlllIlI = this.particleTexture.getMaxV();
        }
        final float lllllllllllllIlIlllIIllIlIlllIII = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllIlIlllIIllIlIlIlIII - Particle.interpPosX);
        final float lllllllllllllIlIlllIIllIlIllIlll = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllIlIlllIIllIlIlIlIII - Particle.interpPosY);
        final float lllllllllllllIlIlllIIllIlIllIllI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllIlIlllIIllIlIlIlIII - Particle.interpPosZ);
        final int lllllllllllllIlIlllIIllIlIllIlIl = this.getBrightnessForRender(lllllllllllllIlIlllIIllIlIlIlIII);
        final int lllllllllllllIlIlllIIllIlIllIlII = lllllllllllllIlIlllIIllIlIllIlIl >> 16 & 0xFFFF;
        final int lllllllllllllIlIlllIIllIlIllIIll = lllllllllllllIlIlllIIllIlIllIlIl & 0xFFFF;
        final Vec3d[] lllllllllllllIlIlllIIllIlIllIIlI = { new Vec3d(-lllllllllllllIlIlllIIllIlIlIIlll * lllllllllllllIlIlllIIllIlIlllIIl - lllllllllllllIlIlllIIllIlIlIIlII * lllllllllllllIlIlllIIllIlIlllIIl, -lllllllllllllIlIlllIIllIllIIIlII * lllllllllllllIlIlllIIllIlIlllIIl, -lllllllllllllIlIlllIIllIlIlIIlIl * lllllllllllllIlIlllIIllIlIlllIIl - lllllllllllllIlIlllIIllIlIllllll * lllllllllllllIlIlllIIllIlIlllIIl), new Vec3d(-lllllllllllllIlIlllIIllIlIlIIlll * lllllllllllllIlIlllIIllIlIlllIIl + lllllllllllllIlIlllIIllIlIlIIlII * lllllllllllllIlIlllIIllIlIlllIIl, lllllllllllllIlIlllIIllIllIIIlII * lllllllllllllIlIlllIIllIlIlllIIl, -lllllllllllllIlIlllIIllIlIlIIlIl * lllllllllllllIlIlllIIllIlIlllIIl + lllllllllllllIlIlllIIllIlIllllll * lllllllllllllIlIlllIIllIlIlllIIl), new Vec3d(lllllllllllllIlIlllIIllIlIlIIlll * lllllllllllllIlIlllIIllIlIlllIIl + lllllllllllllIlIlllIIllIlIlIIlII * lllllllllllllIlIlllIIllIlIlllIIl, lllllllllllllIlIlllIIllIllIIIlII * lllllllllllllIlIlllIIllIlIlllIIl, lllllllllllllIlIlllIIllIlIlIIlIl * lllllllllllllIlIlllIIllIlIlllIIl + lllllllllllllIlIlllIIllIlIllllll * lllllllllllllIlIlllIIllIlIlllIIl), new Vec3d(lllllllllllllIlIlllIIllIlIlIIlll * lllllllllllllIlIlllIIllIlIlllIIl - lllllllllllllIlIlllIIllIlIlIIlII * lllllllllllllIlIlllIIllIlIlllIIl, -lllllllllllllIlIlllIIllIllIIIlII * lllllllllllllIlIlllIIllIlIlllIIl, lllllllllllllIlIlllIIllIlIlIIlIl * lllllllllllllIlIlllIIllIlIlllIIl - lllllllllllllIlIlllIIllIlIllllll * lllllllllllllIlIlllIIllIlIlllIIl) };
        if (this.particleAngle != 0.0f) {
            final float lllllllllllllIlIlllIIllIlIllIIIl = this.particleAngle + (this.particleAngle - this.prevParticleAngle) * lllllllllllllIlIlllIIllIlIlIlIII;
            final float lllllllllllllIlIlllIIllIlIllIIII = MathHelper.cos(lllllllllllllIlIlllIIllIlIllIIIl * 0.5f);
            final float lllllllllllllIlIlllIIllIlIlIllll = MathHelper.sin(lllllllllllllIlIlllIIllIlIllIIIl * 0.5f) * (float)Particle.cameraViewDir.xCoord;
            final float lllllllllllllIlIlllIIllIlIlIlllI = MathHelper.sin(lllllllllllllIlIlllIIllIlIllIIIl * 0.5f) * (float)Particle.cameraViewDir.yCoord;
            final float lllllllllllllIlIlllIIllIlIlIllIl = MathHelper.sin(lllllllllllllIlIlllIIllIlIllIIIl * 0.5f) * (float)Particle.cameraViewDir.zCoord;
            final Vec3d lllllllllllllIlIlllIIllIlIlIllII = new Vec3d(lllllllllllllIlIlllIIllIlIlIllll, lllllllllllllIlIlllIIllIlIlIlllI, lllllllllllllIlIlllIIllIlIlIllIl);
            for (int lllllllllllllIlIlllIIllIlIlIlIll = 0; lllllllllllllIlIlllIIllIlIlIlIll < 4; ++lllllllllllllIlIlllIIllIlIlIlIll) {
                lllllllllllllIlIlllIIllIlIllIIlI[lllllllllllllIlIlllIIllIlIlIlIll] = lllllllllllllIlIlllIIllIlIlIllII.scale(2.0 * lllllllllllllIlIlllIIllIlIllIIlI[lllllllllllllIlIlllIIllIlIlIlIll].dotProduct(lllllllllllllIlIlllIIllIlIlIllII)).add(lllllllllllllIlIlllIIllIlIllIIlI[lllllllllllllIlIlllIIllIlIlIlIll].scale(lllllllllllllIlIlllIIllIlIllIIII * lllllllllllllIlIlllIIllIlIllIIII - lllllllllllllIlIlllIIllIlIlIllII.dotProduct(lllllllllllllIlIlllIIllIlIlIllII))).add(lllllllllllllIlIlllIIllIlIlIllII.crossProduct(lllllllllllllIlIlllIIllIlIllIIlI[lllllllllllllIlIlllIIllIlIlIlIll]).scale(2.0f * lllllllllllllIlIlllIIllIlIllIIII));
            }
        }
        lllllllllllllIlIlllIIllIlIlIlIIl.pos(lllllllllllllIlIlllIIllIlIlllIII + lllllllllllllIlIlllIIllIlIllIIlI[0].xCoord, lllllllllllllIlIlllIIllIlIllIlll + lllllllllllllIlIlllIIllIlIllIIlI[0].yCoord, lllllllllllllIlIlllIIllIlIllIllI + lllllllllllllIlIlllIIllIlIllIIlI[0].zCoord).tex(lllllllllllllIlIlllIIllIlIllllII, lllllllllllllIlIlllIIllIlIlllIlI).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllIlIlllIIllIlIllIlII, lllllllllllllIlIlllIIllIlIllIIll).endVertex();
        lllllllllllllIlIlllIIllIlIlIlIIl.pos(lllllllllllllIlIlllIIllIlIlllIII + lllllllllllllIlIlllIIllIlIllIIlI[1].xCoord, lllllllllllllIlIlllIIllIlIllIlll + lllllllllllllIlIlllIIllIlIllIIlI[1].yCoord, lllllllllllllIlIlllIIllIlIllIllI + lllllllllllllIlIlllIIllIlIllIIlI[1].zCoord).tex(lllllllllllllIlIlllIIllIlIllllII, lllllllllllllIlIlllIIllIlIlllIll).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllIlIlllIIllIlIllIlII, lllllllllllllIlIlllIIllIlIllIIll).endVertex();
        lllllllllllllIlIlllIIllIlIlIlIIl.pos(lllllllllllllIlIlllIIllIlIlllIII + lllllllllllllIlIlllIIllIlIllIIlI[2].xCoord, lllllllllllllIlIlllIIllIlIllIlll + lllllllllllllIlIlllIIllIlIllIIlI[2].yCoord, lllllllllllllIlIlllIIllIlIllIllI + lllllllllllllIlIlllIIllIlIllIIlI[2].zCoord).tex(lllllllllllllIlIlllIIllIlIllllIl, lllllllllllllIlIlllIIllIlIlllIll).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllIlIlllIIllIlIllIlII, lllllllllllllIlIlllIIllIlIllIIll).endVertex();
        lllllllllllllIlIlllIIllIlIlIlIIl.pos(lllllllllllllIlIlllIIllIlIlllIII + lllllllllllllIlIlllIIllIlIllIIlI[3].xCoord, lllllllllllllIlIlllIIllIlIllIlll + lllllllllllllIlIlllIIllIlIllIIlI[3].yCoord, lllllllllllllIlIlllIIllIlIllIllI + lllllllllllllIlIlllIIllIlIllIIlI[3].zCoord).tex(lllllllllllllIlIlllIIllIlIllllIl, lllllllllllllIlIlllIIllIlIlllIlI).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllllIlIlllIIllIlIllIlII, lllllllllllllIlIlllIIllIlIllIIll).endVertex();
    }
    
    public void setRBGColorF(final float lllllllllllllIlIlllIIlllIIIIIIll, final float lllllllllllllIlIlllIIlllIIIIIIlI, final float lllllllllllllIlIlllIIlllIIIIIlIl) {
        this.particleRed = lllllllllllllIlIlllIIlllIIIIIIll;
        this.particleGreen = lllllllllllllIlIlllIIlllIIIIIIlI;
        this.particleBlue = lllllllllllllIlIlllIIlllIIIIIlIl;
    }
    
    public float getRedColorF() {
        return this.particleRed;
    }
    
    public void setExpired() {
        this.isExpired = true;
    }
    
    public int getBrightnessForRender(final float lllllllllllllIlIlllIIllIIIllIllI) {
        final BlockPos lllllllllllllIlIlllIIllIIIllIlIl = new BlockPos(this.posX, this.posY, this.posZ);
        return this.worldObj.isBlockLoaded(lllllllllllllIlIlllIIllIIIllIlIl) ? this.worldObj.getCombinedLight(lllllllllllllIlIlllIIllIIIllIlIl, 0) : 0;
    }
    
    public void moveEntity(double lllllllllllllIlIlllIIllIIlIIIllI, double lllllllllllllIlIlllIIllIIlIIIlIl, double lllllllllllllIlIlllIIllIIlIIIlII) {
        final double lllllllllllllIlIlllIIllIIlIIllII = lllllllllllllIlIlllIIllIIlIIIlIl;
        if (this.canCollide) {
            final List<AxisAlignedBB> lllllllllllllIlIlllIIllIIlIIlIll = this.worldObj.getCollisionBoxes(null, this.getEntityBoundingBox().addCoord(lllllllllllllIlIlllIIllIIlIIIllI, lllllllllllllIlIlllIIllIIlIIIlIl, lllllllllllllIlIlllIIllIIlIIIlII));
            for (final AxisAlignedBB lllllllllllllIlIlllIIllIIlIIlIlI : lllllllllllllIlIlllIIllIIlIIlIll) {
                lllllllllllllIlIlllIIllIIlIIIlIl = lllllllllllllIlIlllIIllIIlIIlIlI.calculateYOffset(this.getEntityBoundingBox(), lllllllllllllIlIlllIIllIIlIIIlIl);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, lllllllllllllIlIlllIIllIIlIIIlIl, 0.0));
            for (final AxisAlignedBB lllllllllllllIlIlllIIllIIlIIlIIl : lllllllllllllIlIlllIIllIIlIIlIll) {
                lllllllllllllIlIlllIIllIIlIIIllI = lllllllllllllIlIlllIIllIIlIIlIIl.calculateXOffset(this.getEntityBoundingBox(), lllllllllllllIlIlllIIllIIlIIIllI);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIlIlllIIllIIlIIIllI, 0.0, 0.0));
            for (final AxisAlignedBB lllllllllllllIlIlllIIllIIlIIlIII : lllllllllllllIlIlllIIllIIlIIlIll) {
                lllllllllllllIlIlllIIllIIlIIIlII = lllllllllllllIlIlllIIllIIlIIlIII.calculateZOffset(this.getEntityBoundingBox(), lllllllllllllIlIlllIIllIIlIIIlII);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, 0.0, lllllllllllllIlIlllIIllIIlIIIlII));
        }
        else {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIlIlllIIllIIlIIIllI, lllllllllllllIlIlllIIllIIlIIIlIl, lllllllllllllIlIlllIIllIIlIIIlII));
        }
        this.resetPositionToBB();
        this.isCollided = (lllllllllllllIlIlllIIllIIlIIIlIl != lllllllllllllIlIlllIIllIIlIIIlIl && lllllllllllllIlIlllIIllIIlIIllII < 0.0);
        if (lllllllllllllIlIlllIIllIIlIIIllI != lllllllllllllIlIlllIIllIIlIIIllI) {
            this.motionX = 0.0;
        }
        if (lllllllllllllIlIlllIIllIIlIIIlII != lllllllllllllIlIlllIIllIIlIIIlII) {
            this.motionZ = 0.0;
        }
    }
    
    static {
        EMPTY_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    
    public int getFXLayer() {
        return 0;
    }
    
    public void setAlphaF(final float lllllllllllllIlIlllIIllIlllllIll) {
        this.particleAlpha = lllllllllllllIlIlllIIllIlllllIll;
    }
    
    public AxisAlignedBB getEntityBoundingBox() {
        return this.boundingBox;
    }
    
    public void nextTextureIndexX() {
        ++this.particleTextureIndexX;
    }
    
    public void setPosition(final double lllllllllllllIlIlllIIllIIlIlllIl, final double lllllllllllllIlIlllIIllIIllIIIlI, final double lllllllllllllIlIlllIIllIIllIIIIl) {
        this.posX = lllllllllllllIlIlllIIllIIlIlllIl;
        this.posY = lllllllllllllIlIlllIIllIIllIIIlI;
        this.posZ = lllllllllllllIlIlllIIllIIllIIIIl;
        final float lllllllllllllIlIlllIIllIIllIIIII = this.width / 2.0f;
        final float lllllllllllllIlIlllIIllIIlIlllll = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(lllllllllllllIlIlllIIllIIlIlllIl - lllllllllllllIlIlllIIllIIllIIIII, lllllllllllllIlIlllIIllIIllIIIlI, lllllllllllllIlIlllIIllIIllIIIIl - lllllllllllllIlIlllIIllIIllIIIII, lllllllllllllIlIlllIIllIIlIlllIl + lllllllllllllIlIlllIIllIIllIIIII, lllllllllllllIlIlllIIllIIllIIIlI + lllllllllllllIlIlllIIllIIlIlllll, lllllllllllllIlIlllIIllIIllIIIIl + lllllllllllllIlIlllIIllIIllIIIII));
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.motionY -= 0.04 * this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.getClass().getSimpleName())).append(", Pos (").append(this.posX).append(",").append(this.posY).append(",").append(this.posZ).append("), RGBA (").append(this.particleRed).append(",").append(this.particleGreen).append(",").append(this.particleBlue).append(",").append(this.particleAlpha).append("), Age ").append(this.particleAge));
    }
    
    public Particle multipleParticleScaleBy(final float lllllllllllllIlIlllIIlllIIIIllll) {
        this.setSize(0.2f * lllllllllllllIlIlllIIlllIIIIllll, 0.2f * lllllllllllllIlIlllIIlllIIIIllll);
        this.particleScale *= lllllllllllllIlIlllIIlllIIIIllll;
        return this;
    }
    
    public boolean isAlive() {
        return !this.isExpired;
    }
    
    protected void resetPositionToBB() {
        final AxisAlignedBB lllllllllllllIlIlllIIllIIIllllII = this.getEntityBoundingBox();
        this.posX = (lllllllllllllIlIlllIIllIIIllllII.minX + lllllllllllllIlIlllIIllIIIllllII.maxX) / 2.0;
        this.posY = lllllllllllllIlIlllIIllIIIllllII.minY;
        this.posZ = (lllllllllllllIlIlllIIllIIIllllII.minZ + lllllllllllllIlIlllIIllIIIllllII.maxZ) / 2.0;
    }
    
    public boolean isTransparent() {
        return false;
    }
    
    public void setParticleTexture(final TextureAtlasSprite lllllllllllllIlIlllIIllIlIIIIlll) {
        final int lllllllllllllIlIlllIIllIlIIIlIIl = this.getFXLayer();
        if (lllllllllllllIlIlllIIllIlIIIlIIl == 1) {
            this.particleTexture = lllllllllllllIlIlllIIllIlIIIIlll;
            return;
        }
        throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
    }
    
    public float getGreenColorF() {
        return this.particleGreen;
    }
    
    public Particle(final World lllllllllllllIlIlllIIlllIIlIlIll, final double lllllllllllllIlIlllIIlllIIlIlIlI, final double lllllllllllllIlIlllIIlllIIIlllll, final double lllllllllllllIlIlllIIlllIIIllllI, final double lllllllllllllIlIlllIIlllIIlIIlll, final double lllllllllllllIlIlllIIlllIIIlllII, final double lllllllllllllIlIlllIIlllIIIllIll) {
        this(lllllllllllllIlIlllIIlllIIlIlIll, lllllllllllllIlIlllIIlllIIlIlIlI, lllllllllllllIlIlllIIlllIIIlllll, lllllllllllllIlIlllIIlllIIIllllI);
        this.motionX = lllllllllllllIlIlllIIlllIIlIIlll + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionY = lllllllllllllIlIlllIIlllIIIlllII + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionZ = lllllllllllllIlIlllIIlllIIIllIll + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        final float lllllllllllllIlIlllIIlllIIlIIlII = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        final float lllllllllllllIlIlllIIlllIIlIIIll = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / lllllllllllllIlIlllIIlllIIlIIIll * lllllllllllllIlIlllIIlllIIlIIlII * 0.4000000059604645;
        this.motionY = this.motionY / lllllllllllllIlIlllIIlllIIlIIIll * lllllllllllllIlIlllIIlllIIlIIlII * 0.4000000059604645 + 0.10000000149011612;
        this.motionZ = this.motionZ / lllllllllllllIlIlllIIlllIIlIIIll * lllllllllllllIlIlllIIlllIIlIIlII * 0.4000000059604645;
    }
}
