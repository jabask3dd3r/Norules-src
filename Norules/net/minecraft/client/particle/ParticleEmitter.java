package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;

public class ParticleEmitter extends Particle
{
    private final /* synthetic */ EnumParticleTypes particleTypes;
    private final /* synthetic */ Entity attachedEntity;
    private final /* synthetic */ int lifetime;
    private /* synthetic */ int age;
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllIllIlIIIlllIlIIll, final Entity lllllllllllllllIllIlIIIlllIlIIlI, final float lllllllllllllllIllIlIIIlllIlIIIl, final float lllllllllllllllIllIlIIIlllIlIIII, final float lllllllllllllllIllIlIIIlllIIllll, final float lllllllllllllllIllIlIIIlllIIlllI, final float lllllllllllllllIllIlIIIlllIIllIl, final float lllllllllllllllIllIlIIIlllIIllII) {
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    public ParticleEmitter(final World lllllllllllllllIllIlIIIlllIllIII, final Entity lllllllllllllllIllIlIIIlllIlIlll, final EnumParticleTypes lllllllllllllllIllIlIIIlllIlIllI, final int lllllllllllllllIllIlIIIlllIllIlI) {
        super(lllllllllllllllIllIlIIIlllIllIII, lllllllllllllllIllIlIIIlllIlIlll.posX, lllllllllllllllIllIlIIIlllIlIlll.getEntityBoundingBox().minY + lllllllllllllllIllIlIIIlllIlIlll.height / 2.0f, lllllllllllllllIllIlIIIlllIlIlll.posZ, lllllllllllllllIllIlIIIlllIlIlll.motionX, lllllllllllllllIllIlIIIlllIlIlll.motionY, lllllllllllllllIllIlIIIlllIlIlll.motionZ);
        this.attachedEntity = lllllllllllllllIllIlIIIlllIlIlll;
        this.lifetime = lllllllllllllllIllIlIIIlllIllIlI;
        this.particleTypes = lllllllllllllllIllIlIIIlllIlIllI;
        this.onUpdate();
    }
    
    @Override
    public void onUpdate() {
        for (int lllllllllllllllIllIlIIIlllIIIIlI = 0; lllllllllllllllIllIlIIIlllIIIIlI < 16; ++lllllllllllllllIllIlIIIlllIIIIlI) {
            final double lllllllllllllllIllIlIIIlllIIIIIl = this.rand.nextFloat() * 2.0f - 1.0f;
            final double lllllllllllllllIllIlIIIlllIIIIII = this.rand.nextFloat() * 2.0f - 1.0f;
            final double lllllllllllllllIllIlIIIllIllllll = this.rand.nextFloat() * 2.0f - 1.0f;
            if (lllllllllllllllIllIlIIIlllIIIIIl * lllllllllllllllIllIlIIIlllIIIIIl + lllllllllllllllIllIlIIIlllIIIIII * lllllllllllllllIllIlIIIlllIIIIII + lllllllllllllllIllIlIIIllIllllll * lllllllllllllllIllIlIIIllIllllll <= 1.0) {
                final double lllllllllllllllIllIlIIIllIlllllI = this.attachedEntity.posX + lllllllllllllllIllIlIIIlllIIIIIl * this.attachedEntity.width / 4.0;
                final double lllllllllllllllIllIlIIIllIllllIl = this.attachedEntity.getEntityBoundingBox().minY + this.attachedEntity.height / 2.0f + lllllllllllllllIllIlIIIlllIIIIII * this.attachedEntity.height / 4.0;
                final double lllllllllllllllIllIlIIIllIllllII = this.attachedEntity.posZ + lllllllllllllllIllIlIIIllIllllll * this.attachedEntity.width / 4.0;
                this.worldObj.spawnParticle(this.particleTypes, false, lllllllllllllllIllIlIIIllIlllllI, lllllllllllllllIllIlIIIllIllllIl, lllllllllllllllIllIlIIIllIllllII, lllllllllllllllIllIlIIIlllIIIIIl, lllllllllllllllIllIlIIIlllIIIIII + 0.2, lllllllllllllllIllIlIIIllIllllll, new int[0]);
            }
        }
        ++this.age;
        if (this.age >= this.lifetime) {
            this.setExpired();
        }
    }
    
    public ParticleEmitter(final World lllllllllllllllIllIlIIIllllIlIlI, final Entity lllllllllllllllIllIlIIIllllIIlIl, final EnumParticleTypes lllllllllllllllIllIlIIIllllIIlII) {
        this(lllllllllllllllIllIlIIIllllIlIlI, lllllllllllllllIllIlIIIllllIIlIl, lllllllllllllllIllIlIIIllllIIlII, 3);
    }
}
