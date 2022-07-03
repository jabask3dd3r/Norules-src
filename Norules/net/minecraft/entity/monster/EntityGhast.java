package net.minecraft.entity.monster;

import net.minecraft.entity.projectile.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityGhast extends EntityFlying implements IMob
{
    private /* synthetic */ int explosionStrength;
    private static final /* synthetic */ DataParameter<Boolean> ATTACKING;
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIllIIIIIlllIIlIlI, final float lllllllllllllllIllIIIIIlllIIlIIl) {
        if (this.isEntityInvulnerable(lllllllllllllllIllIIIIIlllIIlIlI)) {
            return false;
        }
        if (lllllllllllllllIllIIIIIlllIIlIlI.getSourceOfDamage() instanceof EntityLargeFireball && lllllllllllllllIllIIIIIlllIIlIlI.getEntity() instanceof EntityPlayer) {
            super.attackEntityFrom(lllllllllllllllIllIIIIIlllIIlIlI, 1000.0f);
            return true;
        }
        return super.attackEntityFrom(lllllllllllllllIllIIIIIlllIIlIlI, lllllllllllllllIllIIIIIlllIIlIIl);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityGhast.ATTACKING, false);
    }
    
    @Override
    protected float getSoundVolume() {
        return 10.0f;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIllIIIIIllIllIIIl) {
        super.writeEntityToNBT(lllllllllllllllIllIIIIIllIllIIIl);
        lllllllllllllllIllIIIIIllIllIIIl.setInteger("ExplosionPower", this.explosionStrength);
    }
    
    public EntityGhast(final World lllllllllllllllIllIIIIIllllIIllI) {
        super(lllllllllllllllIllIIIIIllllIIllI);
        this.explosionStrength = 1;
        this.setSize(4.0f, 4.0f);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
        this.moveHelper = new GhastMoveHelper(this);
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllIllIIIIIllIllllll) {
        return SoundEvents.ENTITY_GHAST_HURT;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    public static void registerFixesGhast(final DataFixer lllllllllllllllIllIIIIIllIllIllI) {
        EntityLiving.registerFixesMob(lllllllllllllllIllIIIIIllIllIllI, EntityGhast.class);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }
    
    public void setAttacking(final boolean lllllllllllllllIllIIIIIlllIllIII) {
        this.dataManager.set(EntityGhast.ATTACKING, lllllllllllllllIllIIIIIlllIllIII);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIllIIIIIllIlIlIIl) {
        super.readEntityFromNBT(lllllllllllllllIllIIIIIllIlIlIIl);
        if (lllllllllllllllIllIIIIIllIlIlIIl.hasKey("ExplosionPower", 99)) {
            this.explosionStrength = lllllllllllllllIllIIIIIllIlIlIIl.getInteger("ExplosionPower");
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(5, new AIRandomFly(this));
        this.tasks.addTask(7, new AILookAround(this));
        this.tasks.addTask(7, new AIFireballAttack(this));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
    }
    
    public int getFireballStrength() {
        return this.explosionStrength;
    }
    
    static {
        ATTACKING = EntityDataManager.createKey(EntityGhast.class, DataSerializers.BOOLEAN);
    }
    
    public boolean isAttacking() {
        return this.dataManager.get(EntityGhast.ATTACKING);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_GHAST;
    }
    
    @Override
    public float getEyeHeight() {
        return 2.6f;
    }
    
    static class AIRandomFly extends EntityAIBase
    {
        private final /* synthetic */ EntityGhast parentEntity;
        
        @Override
        public void startExecuting() {
            final Random llllllllllllllIlIllIllIllIllIIll = this.parentEntity.getRNG();
            final double llllllllllllllIlIllIllIllIllIIlI = this.parentEntity.posX + (llllllllllllllIlIllIllIllIllIIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double llllllllllllllIlIllIllIllIllIIIl = this.parentEntity.posY + (llllllllllllllIlIllIllIllIllIIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            final double llllllllllllllIlIllIllIllIllIIII = this.parentEntity.posZ + (llllllllllllllIlIllIllIllIllIIll.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.parentEntity.getMoveHelper().setMoveTo(llllllllllllllIlIllIllIllIllIIlI, llllllllllllllIlIllIllIllIllIIIl, llllllllllllllIlIllIllIllIllIIII, 1.0);
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityMoveHelper llllllllllllllIlIllIllIlllIIIlIl = this.parentEntity.getMoveHelper();
            if (!llllllllllllllIlIllIllIlllIIIlIl.isUpdating()) {
                return true;
            }
            final double llllllllllllllIlIllIllIlllIIIlII = llllllllllllllIlIllIllIlllIIIlIl.getX() - this.parentEntity.posX;
            final double llllllllllllllIlIllIllIlllIIIIll = llllllllllllllIlIllIllIlllIIIlIl.getY() - this.parentEntity.posY;
            final double llllllllllllllIlIllIllIlllIIIIlI = llllllllllllllIlIllIllIlllIIIlIl.getZ() - this.parentEntity.posZ;
            final double llllllllllllllIlIllIllIlllIIIIIl = llllllllllllllIlIllIllIlllIIIlII * llllllllllllllIlIllIllIlllIIIlII + llllllllllllllIlIllIllIlllIIIIll * llllllllllllllIlIllIllIlllIIIIll + llllllllllllllIlIllIllIlllIIIIlI * llllllllllllllIlIllIllIlllIIIIlI;
            return llllllllllllllIlIllIllIlllIIIIIl < 1.0 || llllllllllllllIlIllIllIlllIIIIIl > 3600.0;
        }
        
        public AIRandomFly() {
            this.setMutexBits(1);
        }
        
        @Override
        public boolean continueExecuting() {
            return false;
        }
    }
    
    static class AILookAround extends EntityAIBase
    {
        private final /* synthetic */ EntityGhast parentEntity;
        
        @Override
        public void updateTask() {
            if (this.parentEntity.getAttackTarget() == null) {
                this.parentEntity.rotationYaw = -(float)MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ) * 57.295776f;
                this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
            }
            else {
                final EntityLivingBase llIIIIIlllIIIIl = this.parentEntity.getAttackTarget();
                final double llIIIIIlllIIIII = 64.0;
                if (llIIIIIlllIIIIl.getDistanceSqToEntity(this.parentEntity) < 4096.0) {
                    final double llIIIIIllIlllll = llIIIIIlllIIIIl.posX - this.parentEntity.posX;
                    final double llIIIIIllIllllI = llIIIIIlllIIIIl.posZ - this.parentEntity.posZ;
                    this.parentEntity.rotationYaw = -(float)MathHelper.atan2(llIIIIIllIlllll, llIIIIIllIllllI) * 57.295776f;
                    this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
                }
            }
        }
        
        public AILookAround() {
            this.setMutexBits(2);
        }
        
        @Override
        public boolean shouldExecute() {
            return true;
        }
    }
    
    static class GhastMoveHelper extends EntityMoveHelper
    {
        private final /* synthetic */ EntityGhast parentEntity;
        private /* synthetic */ int courseChangeCooldown;
        
        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO) {
                final double lllllllllllllllIllIllIlIlIIIIlIl = this.posX - this.parentEntity.posX;
                final double lllllllllllllllIllIllIlIlIIIIlII = this.posY - this.parentEntity.posY;
                final double lllllllllllllllIllIllIlIlIIIIIll = this.posZ - this.parentEntity.posZ;
                double lllllllllllllllIllIllIlIlIIIIIlI = lllllllllllllllIllIllIlIlIIIIlIl * lllllllllllllllIllIllIlIlIIIIlIl + lllllllllllllllIllIllIlIlIIIIlII * lllllllllllllllIllIllIlIlIIIIlII + lllllllllllllllIllIllIlIlIIIIIll * lllllllllllllllIllIllIlIlIIIIIll;
                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    lllllllllllllllIllIllIlIlIIIIIlI = MathHelper.sqrt(lllllllllllllllIllIllIlIlIIIIIlI);
                    if (this.isNotColliding(this.posX, this.posY, this.posZ, lllllllllllllllIllIllIlIlIIIIIlI)) {
                        final EntityGhast parentEntity = this.parentEntity;
                        parentEntity.motionX += lllllllllllllllIllIllIlIlIIIIlIl / lllllllllllllllIllIllIlIlIIIIIlI * 0.1;
                        final EntityGhast parentEntity2 = this.parentEntity;
                        parentEntity2.motionY += lllllllllllllllIllIllIlIlIIIIlII / lllllllllllllllIllIllIlIlIIIIIlI * 0.1;
                        final EntityGhast parentEntity3 = this.parentEntity;
                        parentEntity3.motionZ += lllllllllllllllIllIllIlIlIIIIIll / lllllllllllllllIllIllIlIlIIIIIlI * 0.1;
                    }
                    else {
                        this.action = Action.WAIT;
                    }
                }
            }
        }
        
        public GhastMoveHelper() {
            super(EntityGhast.this);
        }
        
        private boolean isNotColliding(final double lllllllllllllllIllIllIlIIlllIIIl, final double lllllllllllllllIllIllIlIIlllIIII, final double lllllllllllllllIllIllIlIIllIllll, final double lllllllllllllllIllIllIlIIllIlllI) {
            final double lllllllllllllllIllIllIlIIllIllIl = (lllllllllllllllIllIllIlIIlllIIIl - this.parentEntity.posX) / lllllllllllllllIllIllIlIIllIlllI;
            final double lllllllllllllllIllIllIlIIllIllII = (lllllllllllllllIllIllIlIIlllIIII - this.parentEntity.posY) / lllllllllllllllIllIllIlIIllIlllI;
            final double lllllllllllllllIllIllIlIIllIlIll = (lllllllllllllllIllIllIlIIllIllll - this.parentEntity.posZ) / lllllllllllllllIllIllIlIIllIlllI;
            AxisAlignedBB lllllllllllllllIllIllIlIIllIlIlI = this.parentEntity.getEntityBoundingBox();
            for (int lllllllllllllllIllIllIlIIllIlIIl = 1; lllllllllllllllIllIllIlIIllIlIIl < lllllllllllllllIllIllIlIIllIlllI; ++lllllllllllllllIllIllIlIIllIlIIl) {
                lllllllllllllllIllIllIlIIllIlIlI = lllllllllllllllIllIllIlIIllIlIlI.offset(lllllllllllllllIllIllIlIIllIllIl, lllllllllllllllIllIllIlIIllIllII, lllllllllllllllIllIllIlIIllIlIll);
                if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, lllllllllllllllIllIllIlIIllIlIlI).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }
    
    static class AIFireballAttack extends EntityAIBase
    {
        public /* synthetic */ int attackTimer;
        private final /* synthetic */ EntityGhast parentEntity;
        
        @Override
        public void updateTask() {
            final EntityLivingBase llllllllllllllIIIIIlIlIlIlIIIIIl = this.parentEntity.getAttackTarget();
            final double llllllllllllllIIIIIlIlIlIlIIIIII = 64.0;
            if (llllllllllllllIIIIIlIlIlIlIIIIIl.getDistanceSqToEntity(this.parentEntity) < 4096.0 && this.parentEntity.canEntityBeSeen(llllllllllllllIIIIIlIlIlIlIIIIIl)) {
                final World llllllllllllllIIIIIlIlIlIIllllll = this.parentEntity.world;
                ++this.attackTimer;
                if (this.attackTimer == 10) {
                    llllllllllllllIIIIIlIlIlIIllllll.playEvent(null, 1015, new BlockPos(this.parentEntity), 0);
                }
                if (this.attackTimer == 20) {
                    final double llllllllllllllIIIIIlIlIlIIlllllI = 4.0;
                    final Vec3d llllllllllllllIIIIIlIlIlIIllllIl = this.parentEntity.getLook(1.0f);
                    final double llllllllllllllIIIIIlIlIlIIllllII = llllllllllllllIIIIIlIlIlIlIIIIIl.posX - (this.parentEntity.posX + llllllllllllllIIIIIlIlIlIIllllIl.xCoord * 4.0);
                    final double llllllllllllllIIIIIlIlIlIIlllIll = llllllllllllllIIIIIlIlIlIlIIIIIl.getEntityBoundingBox().minY + llllllllllllllIIIIIlIlIlIlIIIIIl.height / 2.0f - (0.5 + this.parentEntity.posY + this.parentEntity.height / 2.0f);
                    final double llllllllllllllIIIIIlIlIlIIlllIlI = llllllllllllllIIIIIlIlIlIlIIIIIl.posZ - (this.parentEntity.posZ + llllllllllllllIIIIIlIlIlIIllllIl.zCoord * 4.0);
                    llllllllllllllIIIIIlIlIlIIllllll.playEvent(null, 1016, new BlockPos(this.parentEntity), 0);
                    final EntityLargeFireball llllllllllllllIIIIIlIlIlIIlllIIl = new EntityLargeFireball(llllllllllllllIIIIIlIlIlIIllllll, this.parentEntity, llllllllllllllIIIIIlIlIlIIllllII, llllllllllllllIIIIIlIlIlIIlllIll, llllllllllllllIIIIIlIlIlIIlllIlI);
                    llllllllllllllIIIIIlIlIlIIlllIIl.explosionPower = this.parentEntity.getFireballStrength();
                    llllllllllllllIIIIIlIlIlIIlllIIl.posX = this.parentEntity.posX + llllllllllllllIIIIIlIlIlIIllllIl.xCoord * 4.0;
                    llllllllllllllIIIIIlIlIlIIlllIIl.posY = this.parentEntity.posY + this.parentEntity.height / 2.0f + 0.5;
                    llllllllllllllIIIIIlIlIlIIlllIIl.posZ = this.parentEntity.posZ + llllllllllllllIIIIIlIlIlIIllllIl.zCoord * 4.0;
                    llllllllllllllIIIIIlIlIlIIllllll.spawnEntityInWorld(llllllllllllllIIIIIlIlIlIIlllIIl);
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
            this.parentEntity.setAttacking(this.attackTimer > 10);
        }
        
        @Override
        public void startExecuting() {
            this.attackTimer = 0;
        }
        
        @Override
        public void resetTask() {
            this.parentEntity.setAttacking(false);
        }
        
        @Override
        public boolean shouldExecute() {
            return this.parentEntity.getAttackTarget() != null;
        }
        
        public AIFireballAttack() {
        }
    }
}
