package net.minecraft.entity.projectile;

import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class EntityEvokerFangs extends Entity
{
    private /* synthetic */ boolean field_190554_b;
    private /* synthetic */ int field_190555_c;
    private /* synthetic */ UUID field_190558_f;
    private /* synthetic */ boolean field_190556_d;
    private /* synthetic */ EntityLivingBase field_190557_e;
    private /* synthetic */ int field_190553_a;
    
    public EntityEvokerFangs(final World lllllllllllllIllIIIlIllIlIlIlIll) {
        super(lllllllllllllIllIIIlIllIlIlIlIll);
        this.field_190555_c = 22;
        this.setSize(0.5f, 0.8f);
    }
    
    public EntityEvokerFangs(final World lllllllllllllIllIIIlIllIlIIlIlll, final double lllllllllllllIllIIIlIllIlIIllllI, final double lllllllllllllIllIIIlIllIlIIlllIl, final double lllllllllllllIllIIIlIllIlIIlIlII, final float lllllllllllllIllIIIlIllIlIIllIll, final int lllllllllllllIllIIIlIllIlIIlIIlI, final EntityLivingBase lllllllllllllIllIIIlIllIlIIllIIl) {
        this(lllllllllllllIllIIIlIllIlIIlIlll);
        this.field_190553_a = lllllllllllllIllIIIlIllIlIIlIIlI;
        this.func_190549_a(lllllllllllllIllIIIlIllIlIIllIIl);
        this.rotationYaw = lllllllllllllIllIIIlIllIlIIllIll * 57.295776f;
        this.setPosition(lllllllllllllIllIIIlIllIlIIllllI, lllllllllllllIllIIIlIllIlIIlllIl, lllllllllllllIllIIIlIllIlIIlIlII);
    }
    
    public void func_190549_a(@Nullable final EntityLivingBase lllllllllllllIllIIIlIllIlIIIlIlI) {
        this.field_190557_e = lllllllllllllIllIIIlIllIlIIIlIlI;
        this.field_190558_f = ((lllllllllllllIllIIIlIllIlIIIlIlI == null) ? null : lllllllllllllIllIIIlIllIlIIIlIlI.getUniqueID());
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIllIIIlIllIIlIlIIlI) {
        super.handleStatusUpdate(lllllllllllllIllIIIlIllIIlIlIIlI);
        if (lllllllllllllIllIIIlIllIIlIlIIlI == 4) {
            this.field_190556_d = true;
            if (!this.isSilent()) {
                this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.field_191242_bl, this.getSoundCategory(), 1.0f, this.rand.nextFloat() * 0.2f + 0.85f, false);
            }
        }
    }
    
    @Nullable
    public EntityLivingBase func_190552_j() {
        if (this.field_190557_e == null && this.field_190558_f != null && this.world instanceof WorldServer) {
            final Entity lllllllllllllIllIIIlIllIlIIIIllI = ((WorldServer)this.world).getEntityFromUuid(this.field_190558_f);
            if (lllllllllllllIllIIIlIllIlIIIIllI instanceof EntityLivingBase) {
                this.field_190557_e = (EntityLivingBase)lllllllllllllIllIIIlIllIlIIIIllI;
            }
        }
        return this.field_190557_e;
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIIIlIllIIllllIII) {
        lllllllllllllIllIIIlIllIIllllIII.setInteger("Warmup", this.field_190553_a);
        if (this.field_190558_f != null) {
            lllllllllllllIllIIIlIllIIllllIII.setUniqueId("OwnerUUID", this.field_190558_f);
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIIIlIllIIllllllI) {
        this.field_190553_a = lllllllllllllIllIIIlIllIIllllllI.getInteger("Warmup");
        this.field_190558_f = lllllllllllllIllIIIlIllIIllllllI.getUniqueId("OwnerUUID");
    }
    
    public float func_190550_a(final float lllllllllllllIllIIIlIllIIlIIlIII) {
        if (!this.field_190556_d) {
            return 0.0f;
        }
        final int lllllllllllllIllIIIlIllIIlIIlIlI = this.field_190555_c - 2;
        return (lllllllllllllIllIIIlIllIIlIIlIlI <= 0) ? 1.0f : (1.0f - (lllllllllllllIllIIIlIllIIlIIlIlI - lllllllllllllIllIIIlIllIIlIIlIII) / 20.0f);
    }
    
    private void func_190551_c(final EntityLivingBase lllllllllllllIllIIIlIllIIlIlIlll) {
        final EntityLivingBase lllllllllllllIllIIIlIllIIlIllIIl = this.func_190552_j();
        if (lllllllllllllIllIIIlIllIIlIlIlll.isEntityAlive() && !lllllllllllllIllIIIlIllIIlIlIlll.func_190530_aW() && lllllllllllllIllIIIlIllIIlIlIlll != lllllllllllllIllIIIlIllIIlIllIIl) {
            if (lllllllllllllIllIIIlIllIIlIllIIl == null) {
                lllllllllllllIllIIIlIllIIlIlIlll.attackEntityFrom(DamageSource.magic, 6.0f);
            }
            else {
                if (lllllllllllllIllIIIlIllIIlIllIIl.isOnSameTeam(lllllllllllllIllIIIlIllIIlIlIlll)) {
                    return;
                }
                lllllllllllllIllIIIlIllIIlIlIlll.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, lllllllllllllIllIIIlIllIIlIllIIl), 6.0f);
            }
        }
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote) {
            if (this.field_190556_d) {
                --this.field_190555_c;
                if (this.field_190555_c == 14) {
                    for (int lllllllllllllIllIIIlIllIIllIlllI = 0; lllllllllllllIllIIIlIllIIllIlllI < 12; ++lllllllllllllIllIIIlIllIIllIlllI) {
                        final double lllllllllllllIllIIIlIllIIllIllIl = this.posX + (this.rand.nextDouble() * 2.0 - 1.0) * this.width * 0.5;
                        final double lllllllllllllIllIIIlIllIIllIllII = this.posY + 0.05 + this.rand.nextDouble() * 1.0;
                        final double lllllllllllllIllIIIlIllIIllIlIll = this.posZ + (this.rand.nextDouble() * 2.0 - 1.0) * this.width * 0.5;
                        final double lllllllllllllIllIIIlIllIIllIlIlI = (this.rand.nextDouble() * 2.0 - 1.0) * 0.3;
                        final double lllllllllllllIllIIIlIllIIllIlIIl = 0.3 + this.rand.nextDouble() * 0.3;
                        final double lllllllllllllIllIIIlIllIIllIlIII = (this.rand.nextDouble() * 2.0 - 1.0) * 0.3;
                        this.world.spawnParticle(EnumParticleTypes.CRIT, lllllllllllllIllIIIlIllIIllIllIl, lllllllllllllIllIIIlIllIIllIllII + 1.0, lllllllllllllIllIIIlIllIIllIlIll, lllllllllllllIllIIIlIllIIllIlIlI, lllllllllllllIllIIIlIllIIllIlIIl, lllllllllllllIllIIIlIllIIllIlIII, new int[0]);
                    }
                }
            }
        }
        else if (--this.field_190553_a < 0) {
            if (this.field_190553_a == -8) {
                for (final EntityLivingBase lllllllllllllIllIIIlIllIIllIIlll : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, this.getEntityBoundingBox().expand(0.2, 0.0, 0.2))) {
                    this.func_190551_c(lllllllllllllIllIIIlIllIIllIIlll);
                }
            }
            if (!this.field_190554_b) {
                this.world.setEntityState(this, (byte)4);
                this.field_190554_b = true;
            }
            if (--this.field_190555_c < 0) {
                this.setDead();
            }
        }
    }
}
