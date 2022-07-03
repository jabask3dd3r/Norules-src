package net.minecraft.entity.passive;

import com.google.common.base.*;
import java.util.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.nbt.*;
import net.minecraft.server.management.*;
import net.minecraft.scoreboard.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;

public abstract class EntityTameable extends EntityAnimal implements IEntityOwnable
{
    protected static final /* synthetic */ DataParameter<Optional<UUID>> OWNER_UNIQUE_ID;
    protected /* synthetic */ EntityAISit aiSit;
    protected static final /* synthetic */ DataParameter<Byte> TAMED;
    
    @Override
    public boolean isOnSameTeam(final Entity llllllllllllllllllIlllIIllllIllI) {
        if (this.isTamed()) {
            final EntityLivingBase llllllllllllllllllIlllIIllllIlIl = this.getOwner();
            if (llllllllllllllllllIlllIIllllIllI == llllllllllllllllllIlllIIllllIlIl) {
                return true;
            }
            if (llllllllllllllllllIlllIIllllIlIl != null) {
                return llllllllllllllllllIlllIIllllIlIl.isOnSameTeam(llllllllllllllllllIlllIIllllIllI);
            }
        }
        return super.isOnSameTeam(llllllllllllllllllIlllIIllllIllI);
    }
    
    public boolean isTamed() {
        return (this.dataManager.get(EntityTameable.TAMED) & 0x4) != 0x0;
    }
    
    @Override
    public boolean canBeLeashedTo(final EntityPlayer llllllllllllllllllIlllIlIlIllIII) {
        return !this.getLeashed();
    }
    
    @Nullable
    @Override
    public EntityLivingBase getOwner() {
        try {
            final UUID llllllllllllllllllIlllIlIIIlIIII = this.getOwnerId();
            return (llllllllllllllllllIlllIlIIIlIIII == null) ? null : this.world.getPlayerEntityByUUID(llllllllllllllllllIlllIlIIIlIIII);
        }
        catch (IllegalArgumentException llllllllllllllllllIlllIlIIIIllll) {
            return null;
        }
    }
    
    public EntityTameable(final World llllllllllllllllllIlllIlIlllIlII) {
        super(llllllllllllllllllIlllIlIlllIlII);
        this.setupTamedAI();
    }
    
    public boolean isOwner(final EntityLivingBase llllllllllllllllllIlllIlIIIIlIIl) {
        return llllllllllllllllllIlllIlIIIIlIIl == this.getOwner();
    }
    
    public EntityAISit getAISit() {
        return this.aiSit;
    }
    
    public void func_193101_c(final EntityPlayer llllllllllllllllllIlllIlIIIlIlII) {
        this.setTamed(true);
        this.setOwnerId(llllllllllllllllllIlllIlIIIlIlII.getUniqueID());
        if (llllllllllllllllllIlllIlIIIlIlII instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193136_w.func_193178_a((EntityPlayerMP)llllllllllllllllllIlllIlIIIlIlII, this);
        }
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllllIlllIIlllIllII) {
        if (!this.world.isRemote && this.world.getGameRules().getBoolean("showDeathMessages") && this.getOwner() instanceof EntityPlayerMP) {
            this.getOwner().addChatMessage(this.getCombatTracker().getDeathMessage());
        }
        super.onDeath(llllllllllllllllllIlllIIlllIllII);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllllIlllIlIlIlllIl) {
        super.readEntityFromNBT(llllllllllllllllllIlllIlIlIlllIl);
        String llllllllllllllllllIlllIlIllIIIIl = null;
        if (llllllllllllllllllIlllIlIlIlllIl.hasKey("OwnerUUID", 8)) {
            final String llllllllllllllllllIlllIlIllIIIlI = llllllllllllllllllIlllIlIlIlllIl.getString("OwnerUUID");
        }
        else {
            final String llllllllllllllllllIlllIlIllIIIII = llllllllllllllllllIlllIlIlIlllIl.getString("Owner");
            llllllllllllllllllIlllIlIllIIIIl = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), llllllllllllllllllIlllIlIllIIIII);
        }
        if (!llllllllllllllllllIlllIlIllIIIIl.isEmpty()) {
            try {
                this.setOwnerId(UUID.fromString(llllllllllllllllllIlllIlIllIIIIl));
                this.setTamed(true);
            }
            catch (Throwable llllllllllllllllllIlllIlIlIlllll) {
                this.setTamed(false);
            }
        }
        if (this.aiSit != null) {
            this.aiSit.setSitting(llllllllllllllllllIlllIlIlIlllIl.getBoolean("Sitting"));
        }
        this.setSitting(llllllllllllllllllIlllIlIlIlllIl.getBoolean("Sitting"));
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityTameable.TAMED, (Byte)0);
        this.dataManager.register(EntityTameable.OWNER_UNIQUE_ID, (Optional<UUID>)Optional.absent());
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllllllIlllIlIIlllllI) {
        if (llllllllllllllllllIlllIlIIlllllI == 7) {
            this.playTameEffect(true);
        }
        else if (llllllllllllllllllIlllIlIIlllllI == 6) {
            this.playTameEffect(false);
        }
        else {
            super.handleStatusUpdate(llllllllllllllllllIlllIlIIlllllI);
        }
    }
    
    public boolean shouldAttackEntity(final EntityLivingBase llllllllllllllllllIlllIlIIIIIIlI, final EntityLivingBase llllllllllllllllllIlllIlIIIIIIIl) {
        return true;
    }
    
    @Override
    public Team getTeam() {
        if (this.isTamed()) {
            final EntityLivingBase llllllllllllllllllIlllIIllllllIl = this.getOwner();
            if (llllllllllllllllllIlllIIllllllIl != null) {
                return llllllllllllllllllIlllIIllllllIl.getTeam();
            }
        }
        return super.getTeam();
    }
    
    static {
        TAMED = EntityDataManager.createKey(EntityTameable.class, DataSerializers.BYTE);
        OWNER_UNIQUE_ID = EntityDataManager.createKey(EntityTameable.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    }
    
    public boolean isSitting() {
        return (this.dataManager.get(EntityTameable.TAMED) & 0x1) != 0x0;
    }
    
    @Nullable
    @Override
    public UUID getOwnerId() {
        return (UUID)this.dataManager.get(EntityTameable.OWNER_UNIQUE_ID).orNull();
    }
    
    protected void playTameEffect(final boolean llllllllllllllllllIlllIlIlIIlllI) {
        EnumParticleTypes llllllllllllllllllIlllIlIlIIllIl = EnumParticleTypes.HEART;
        if (!llllllllllllllllllIlllIlIlIIlllI) {
            llllllllllllllllllIlllIlIlIIllIl = EnumParticleTypes.SMOKE_NORMAL;
        }
        for (int llllllllllllllllllIlllIlIlIIllII = 0; llllllllllllllllllIlllIlIlIIllII < 7; ++llllllllllllllllllIlllIlIlIIllII) {
            final double llllllllllllllllllIlllIlIlIIlIll = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllllIlllIlIlIIlIlI = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllllIlllIlIlIIlIIl = this.rand.nextGaussian() * 0.02;
            this.world.spawnParticle(llllllllllllllllllIlllIlIlIIllIl, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllllllIlllIlIlIIlIll, llllllllllllllllllIlllIlIlIIlIlI, llllllllllllllllllIlllIlIlIIlIIl, new int[0]);
        }
    }
    
    public void setTamed(final boolean llllllllllllllllllIlllIlIIllIlII) {
        final byte llllllllllllllllllIlllIlIIllIIll = this.dataManager.get(EntityTameable.TAMED);
        if (llllllllllllllllllIlllIlIIllIlII) {
            this.dataManager.set(EntityTameable.TAMED, (byte)(llllllllllllllllllIlllIlIIllIIll | 0x4));
        }
        else {
            this.dataManager.set(EntityTameable.TAMED, (byte)(llllllllllllllllllIlllIlIIllIIll & 0xFFFFFFFB));
        }
        this.setupTamedAI();
    }
    
    public void setSitting(final boolean llllllllllllllllllIlllIlIIlIIlII) {
        final byte llllllllllllllllllIlllIlIIlIIllI = this.dataManager.get(EntityTameable.TAMED);
        if (llllllllllllllllllIlllIlIIlIIlII) {
            this.dataManager.set(EntityTameable.TAMED, (byte)(llllllllllllllllllIlllIlIIlIIllI | 0x1));
        }
        else {
            this.dataManager.set(EntityTameable.TAMED, (byte)(llllllllllllllllllIlllIlIIlIIllI & 0xFFFFFFFE));
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllllIlllIlIllIlIll) {
        super.writeEntityToNBT(llllllllllllllllllIlllIlIllIlIll);
        if (this.getOwnerId() == null) {
            llllllllllllllllllIlllIlIllIlIll.setString("OwnerUUID", "");
        }
        else {
            llllllllllllllllllIlllIlIllIlIll.setString("OwnerUUID", this.getOwnerId().toString());
        }
        llllllllllllllllllIlllIlIllIlIll.setBoolean("Sitting", this.isSitting());
    }
    
    protected void setupTamedAI() {
    }
    
    public void setOwnerId(@Nullable final UUID llllllllllllllllllIlllIlIIIlllII) {
        this.dataManager.set(EntityTameable.OWNER_UNIQUE_ID, (Optional<UUID>)Optional.fromNullable((Object)llllllllllllllllllIlllIlIIIlllII));
    }
}
