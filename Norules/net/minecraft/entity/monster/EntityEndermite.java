package net.minecraft.entity.monster;

import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;

public class EntityEndermite extends EntityMob
{
    private /* synthetic */ int lifetime;
    private /* synthetic */ boolean playerSpawned;
    
    public void setSpawnedByPlayer(final boolean lllllllllllllIlIlIlllIllllIIIllI) {
        this.playerSpawned = lllllllllllllIlIlIlllIllllIIIllI;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote) {
            for (int lllllllllllllIlIlIlllIllllIIIIII = 0; lllllllllllllIlIlIlllIllllIIIIII < 2; ++lllllllllllllIlIlIlllIllllIIIIII) {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        else {
            if (!this.isNoDespawnRequired()) {
                ++this.lifetime;
            }
            if (this.lifetime >= 2400) {
                this.setDead();
            }
        }
    }
    
    @Override
    public double getYOffset() {
        return 0.1;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0, false));
        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
    }
    
    @Override
    protected void playStepSound(final BlockPos lllllllllllllIlIlIlllIlllllIlIIl, final Block lllllllllllllIlIlIlllIlllllIlIII) {
        this.playSound(SoundEvents.ENTITY_ENDERMITE_STEP, 0.15f, 1.0f);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERMITE_AMBIENT;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIlIlllIllllIlIlll) {
        super.writeEntityToNBT(lllllllllllllIlIlIlllIllllIlIlll);
        lllllllllllllIlIlIlllIllllIlIlll.setInteger("Lifetime", this.lifetime);
        lllllllllllllIlIlIlllIllllIlIlll.setBoolean("PlayerSpawned", this.playerSpawned);
    }
    
    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIlIlIlllIlllllIllIl) {
        return SoundEvents.ENTITY_ENDERMITE_HURT;
    }
    
    @Override
    public void setRenderYawOffset(final float lllllllllllllIlIlIlllIllllIlIIII) {
        this.rotationYaw = lllllllllllllIlIlIlllIllllIlIIII;
        super.setRenderYawOffset(lllllllllllllIlIlIlllIllllIlIIII);
    }
    
    public EntityEndermite(final World lllllllllllllIlIlIlllIlllllllIlI) {
        super(lllllllllllllIlIlIlllIlllllllIlI);
        this.experienceValue = 3;
        this.setSize(0.4f, 0.3f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            final EntityPlayer lllllllllllllIlIlIlllIlllIlllIIl = this.world.getClosestPlayerToEntity(this, 5.0);
            return lllllllllllllIlIlIlllIlllIlllIIl == null;
        }
        return false;
    }
    
    public boolean isSpawnedByPlayer() {
        return this.playerSpawned;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIlIlllIllllIlllIl) {
        super.readEntityFromNBT(lllllllllllllIlIlIlllIllllIlllIl);
        this.lifetime = lllllllllllllIlIlIlllIllllIlllIl.getInteger("Lifetime");
        this.playerSpawned = lllllllllllllIlIlIlllIllllIlllIl.getBoolean("PlayerSpawned");
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ENDERMITE;
    }
    
    public static void registerFixesEndermite(final DataFixer lllllllllllllIlIlIlllIlllllIIIll) {
        EntityLiving.registerFixesMob(lllllllllllllIlIlIlllIlllllIIIll, EntityEndermite.class);
    }
    
    @Override
    public float getEyeHeight() {
        return 0.1f;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMITE_DEATH;
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
}
