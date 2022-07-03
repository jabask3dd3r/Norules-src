package net.minecraft.entity.projectile;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;

public class EntityLargeFireball extends EntityFireball
{
    public /* synthetic */ int explosionPower;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIlIIllIllIlIlII) {
        super.readEntityFromNBT(llllllllllllllIIlIlIIllIllIlIlII);
        if (llllllllllllllIIlIlIIllIllIlIlII.hasKey("ExplosionPower", 99)) {
            this.explosionPower = llllllllllllllIIlIlIIllIllIlIlII.getInteger("ExplosionPower");
        }
    }
    
    public EntityLargeFireball(final World llllllllllllllIIlIlIIllIllllIIII, final EntityLivingBase llllllllllllllIIlIlIIllIllllIlIl, final double llllllllllllllIIlIlIIllIlllIlllI, final double llllllllllllllIIlIlIIllIllllIIll, final double llllllllllllllIIlIlIIllIllllIIlI) {
        super(llllllllllllllIIlIlIIllIllllIIII, llllllllllllllIIlIlIIllIllllIlIl, llllllllllllllIIlIlIIllIlllIlllI, llllllllllllllIIlIlIIllIllllIIll, llllllllllllllIIlIlIIllIllllIIlI);
        this.explosionPower = 1;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIlIIllIllIlllII) {
        super.writeEntityToNBT(llllllllllllllIIlIlIIllIllIlllII);
        llllllllllllllIIlIlIIllIllIlllII.setInteger("ExplosionPower", this.explosionPower);
    }
    
    @Override
    protected void onImpact(final RayTraceResult llllllllllllllIIlIlIIllIlllIIlll) {
        if (!this.world.isRemote) {
            if (llllllllllllllIIlIlIIllIlllIIlll.entityHit != null) {
                llllllllllllllIIlIlIIllIlllIIlll.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0f);
                this.applyEnchantments(this.shootingEntity, llllllllllllllIIlIlIIllIlllIIlll.entityHit);
            }
            final boolean llllllllllllllIIlIlIIllIlllIIllI = this.world.getGameRules().getBoolean("mobGriefing");
            this.world.newExplosion(null, this.posX, this.posY, this.posZ, (float)this.explosionPower, llllllllllllllIIlIlIIllIlllIIllI, llllllllllllllIIlIlIIllIlllIIllI);
            this.setDead();
        }
    }
    
    public EntityLargeFireball(final World llllllllllllllIIlIlIIlllIIIlIllI) {
        super(llllllllllllllIIlIlIIlllIIIlIllI);
        this.explosionPower = 1;
    }
    
    public EntityLargeFireball(final World llllllllllllllIIlIlIIlllIIIIllII, final double llllllllllllllIIlIlIIlllIIIIlIll, final double llllllllllllllIIlIlIIlllIIIIIIlI, final double llllllllllllllIIlIlIIlllIIIIlIIl, final double llllllllllllllIIlIlIIlllIIIIlIII, final double llllllllllllllIIlIlIIllIllllllll, final double llllllllllllllIIlIlIIllIlllllllI) {
        super(llllllllllllllIIlIlIIlllIIIIllII, llllllllllllllIIlIlIIlllIIIIlIll, llllllllllllllIIlIlIIlllIIIIIIlI, llllllllllllllIIlIlIIlllIIIIlIIl, llllllllllllllIIlIlIIlllIIIIlIII, llllllllllllllIIlIlIIllIllllllll, llllllllllllllIIlIlIIllIlllllllI);
        this.explosionPower = 1;
    }
    
    public static void registerFixesLargeFireball(final DataFixer llllllllllllllIIlIlIIllIlllIIIIl) {
        EntityFireball.registerFixesFireball(llllllllllllllIIlIlIIllIlllIIIIl, "Fireball");
    }
}
