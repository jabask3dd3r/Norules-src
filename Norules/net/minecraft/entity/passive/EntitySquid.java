package net.minecraft.entity.passive;

import net.minecraft.entity.ai.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntitySquid extends EntityWaterMob
{
    private /* synthetic */ float randomMotionVecX;
    private /* synthetic */ float randomMotionVecY;
    public /* synthetic */ float squidYaw;
    public /* synthetic */ float squidRotation;
    private /* synthetic */ float randomMotionVecZ;
    public /* synthetic */ float prevSquidYaw;
    public /* synthetic */ float prevSquidRotation;
    public /* synthetic */ float prevSquidPitch;
    public /* synthetic */ float lastTentacleAngle;
    private /* synthetic */ float randomMotionSpeed;
    private /* synthetic */ float rotateSpeed;
    public /* synthetic */ float squidPitch;
    public /* synthetic */ float tentacleAngle;
    private /* synthetic */ float rotationVelocity;
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new AIMoveRandom(this));
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SQUID;
    }
    
    public void setMovementVector(final float llIlIlIlIIIIIII, final float llIlIlIIlllllll, final float llIlIlIIllllllI) {
        this.randomMotionVecX = llIlIlIlIIIIIII;
        this.randomMotionVecY = llIlIlIIlllllll;
        this.randomMotionVecZ = llIlIlIIllllllI;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0 && this.posY < this.world.getSeaLevel() && super.getCanSpawnHere();
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    public EntitySquid(final World llIlIlIlIllIIIl) {
        super(llIlIlIlIllIIIl);
        this.setSize(0.8f, 0.8f);
        this.rand.setSeed(1 + this.getEntityId());
        this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
    }
    
    public boolean hasMovementVector() {
        return this.randomMotionVecX != 0.0f || this.randomMotionVecY != 0.0f || this.randomMotionVecZ != 0.0f;
    }
    
    public static void registerFixesSquid(final DataFixer llIlIlIlIlIllIl) {
        EntityLiving.registerFixesMob(llIlIlIlIlIllIl, EntitySquid.class);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if (this.squidRotation > 6.283185307179586) {
            if (this.world.isRemote) {
                this.squidRotation = 6.2831855f;
            }
            else {
                this.squidRotation -= (float)6.283185307179586;
                if (this.rand.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0f / (this.rand.nextFloat() + 1.0f) * 0.2f;
                }
                this.world.setEntityState(this, (byte)19);
            }
        }
        if (this.inWater) {
            if (this.squidRotation < 3.1415927f) {
                final float llIlIlIlIIllIII = this.squidRotation / 3.1415927f;
                this.tentacleAngle = MathHelper.sin(llIlIlIlIIllIII * llIlIlIlIIllIII * 3.1415927f) * 3.1415927f * 0.25f;
                if (llIlIlIlIIllIII > 0.75) {
                    this.randomMotionSpeed = 1.0f;
                    this.rotateSpeed = 1.0f;
                }
                else {
                    this.rotateSpeed *= 0.8f;
                }
            }
            else {
                this.tentacleAngle = 0.0f;
                this.randomMotionSpeed *= 0.9f;
                this.rotateSpeed *= 0.99f;
            }
            if (!this.world.isRemote) {
                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
            }
            final float llIlIlIlIIlIlll = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-(float)MathHelper.atan2(this.motionX, this.motionZ) * 57.295776f - this.renderYawOffset) * 0.1f;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += (float)(3.141592653589793 * this.rotateSpeed * 1.5);
            this.squidPitch += (-(float)MathHelper.atan2(llIlIlIlIIlIlll, this.motionY) * 57.295776f - this.squidPitch) * 0.1f;
        }
        else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * 3.1415927f * 0.25f;
            if (!this.world.isRemote) {
                this.motionX = 0.0;
                this.motionZ = 0.0;
                if (this.isPotionActive(MobEffects.LEVITATION)) {
                    this.motionY += 0.05 * (this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY;
                }
                else if (!this.hasNoGravity()) {
                    this.motionY -= 0.08;
                }
                this.motionY *= 0.9800000190734863;
            }
            this.squidPitch += (float)((-90.0f - this.squidPitch) * 0.02);
        }
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.5f;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public void func_191986_a(final float llIlIlIlIIlIIlI, final float llIlIlIlIIlIIIl, final float llIlIlIlIIlIIII) {
        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }
    
    @Override
    public void handleStatusUpdate(final byte llIlIlIlIIIlIII) {
        if (llIlIlIlIIIlIII == 19) {
            this.squidRotation = 0.0f;
        }
        else {
            super.handleStatusUpdate(llIlIlIlIIIlIII);
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llIlIlIlIlIIIII) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }
    
    static class AIMoveRandom extends EntityAIBase
    {
        private final /* synthetic */ EntitySquid squid;
        
        @Override
        public boolean shouldExecute() {
            return true;
        }
        
        @Override
        public void updateTask() {
            final int lllllllllllllIIIIllIlllIIIIlIllI = this.squid.getAge();
            if (lllllllllllllIIIIllIlllIIIIlIllI > 100) {
                this.squid.setMovementVector(0.0f, 0.0f, 0.0f);
            }
            else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.hasMovementVector()) {
                final float lllllllllllllIIIIllIlllIIIIlIlIl = this.squid.getRNG().nextFloat() * 6.2831855f;
                final float lllllllllllllIIIIllIlllIIIIlIlII = MathHelper.cos(lllllllllllllIIIIllIlllIIIIlIlIl) * 0.2f;
                final float lllllllllllllIIIIllIlllIIIIlIIll = -0.1f + this.squid.getRNG().nextFloat() * 0.2f;
                final float lllllllllllllIIIIllIlllIIIIlIIlI = MathHelper.sin(lllllllllllllIIIIllIlllIIIIlIlIl) * 0.2f;
                this.squid.setMovementVector(lllllllllllllIIIIllIlllIIIIlIlII, lllllllllllllIIIIllIlllIIIIlIIll, lllllllllllllIIIIllIlllIIIIlIIlI);
            }
        }
        
        public AIMoveRandom() {
        }
    }
}
