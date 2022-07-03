package net.minecraft.entity.monster;

import javax.annotation.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityVex extends EntityMob
{
    protected static final /* synthetic */ DataParameter<Byte> field_190664_a;
    private /* synthetic */ int field_190668_bx;
    private /* synthetic */ boolean field_190667_bw;
    @Nullable
    private /* synthetic */ BlockPos field_190666_c;
    private /* synthetic */ EntityLiving field_190665_b;
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    private void func_190660_a(final int lllllllllllllIIIlIlIIlIIIllllIIl, final boolean lllllllllllllIIIlIlIIlIIIllllIII) {
        int lllllllllllllIIIlIlIIlIIIlllIlll = this.dataManager.get(EntityVex.field_190664_a);
        if (lllllllllllllIIIlIlIIlIIIllllIII) {
            lllllllllllllIIIlIlIIlIIIlllIlll |= lllllllllllllIIIlIlIIlIIIllllIIl;
        }
        else {
            lllllllllllllIIIlIlIIlIIIlllIlll &= ~lllllllllllllIIIlIlIIlIIIllllIIl;
        }
        this.dataManager.set(EntityVex.field_190664_a, (byte)(lllllllllllllIIIlIlIIlIIIlllIlll & 0xFF));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIlIlIIlIIlIIlIlII) {
        super.writeEntityToNBT(lllllllllllllIIIlIlIIlIIlIIlIlII);
        if (this.field_190666_c != null) {
            lllllllllllllIIIlIlIIlIIlIIlIlII.setInteger("BoundX", this.field_190666_c.getX());
            lllllllllllllIIIlIlIIlIIlIIlIlII.setInteger("BoundY", this.field_190666_c.getY());
            lllllllllllllIIIlIlIIlIIlIIlIlII.setInteger("BoundZ", this.field_190666_c.getZ());
        }
        if (this.field_190667_bw) {
            lllllllllllllIIIlIlIIlIIlIIlIlII.setInteger("LifeTicks", this.field_190668_bx);
        }
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
    
    static {
        field_190664_a = EntityDataManager.createKey(EntityVex.class, DataSerializers.BYTE);
    }
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllIIIlIlIIlIIIlIIlIll) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.setDropChance(EntityEquipmentSlot.MAINHAND, 0.0f);
    }
    
    public void func_190653_a(final int lllllllllllllIIIlIlIIlIIIllIIIII) {
        this.field_190667_bw = true;
        this.field_190668_bx = lllllllllllllIIIlIlIIlIIIllIIIII;
    }
    
    @Nullable
    public BlockPos func_190646_di() {
        return this.field_190666_c;
    }
    
    public void func_190651_g(@Nullable final BlockPos lllllllllllllIIIlIlIIlIIlIIIlIII) {
        this.field_190666_c = lllllllllllllIIIlIlIIlIIlIIIlIII;
    }
    
    public void func_190648_a(final boolean lllllllllllllIIIlIlIIlIIIllIllII) {
        this.func_190660_a(1, lllllllllllllIIIlIlIIlIIIllIllII);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.field_191264_hc;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityVex.field_190664_a, (Byte)0);
    }
    
    public static void func_190663_b(final DataFixer lllllllllllllIIIlIlIIlIIlIlIIIII) {
        EntityLiving.registerFixesMob(lllllllllllllIIIlIlIIlIIlIlIIIII, EntityVex.class);
    }
    
    private boolean func_190656_b(final int lllllllllllllIIIlIlIIlIIlIIIIIll) {
        final int lllllllllllllIIIlIlIIlIIlIIIIIlI = this.dataManager.get(EntityVex.field_190664_a);
        return (lllllllllllllIIIlIlIIlIIlIIIIIlI & lllllllllllllIIIlIlIIlIIlIIIIIll) != 0x0;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIlIlIIlIIIlIllIlI) {
        return SoundEvents.field_191267_hf;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191188_ax;
    }
    
    @Override
    public void onUpdate() {
        this.noClip = true;
        super.onUpdate();
        this.noClip = false;
        this.setNoGravity(true);
        if (this.field_190667_bw && --this.field_190668_bx <= 0) {
            this.field_190668_bx = 20;
            this.attackEntityFrom(DamageSource.starve, 1.0f);
        }
    }
    
    public void func_190658_a(final EntityLiving lllllllllllllIIIlIlIIlIIIllIIlII) {
        this.field_190665_b = lllllllllllllIIIlIlIIlIIIllIIlII;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_191266_he;
    }
    
    public EntityLiving func_190645_o() {
        return this.field_190665_b;
    }
    
    public EntityVex(final World lllllllllllllIIIlIlIIlIIlIlllllI) {
        super(lllllllllllllIIIlIlIIlIIlIlllllI);
        this.isImmuneToFire = true;
        this.moveHelper = new AIMoveControl(this);
        this.setSize(0.4f, 0.8f);
        this.experienceValue = 3;
    }
    
    public boolean func_190647_dj() {
        return this.func_190656_b(1);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIlIlIIlIIlIIlllII) {
        super.readEntityFromNBT(lllllllllllllIIIlIlIIlIIlIIlllII);
        if (lllllllllllllIIIlIlIIlIIlIIlllII.hasKey("BoundX")) {
            this.field_190666_c = new BlockPos(lllllllllllllIIIlIlIIlIIlIIlllII.getInteger("BoundX"), lllllllllllllIIIlIlIIlIIlIIlllII.getInteger("BoundY"), lllllllllllllIIIlIlIIlIIlIIlllII.getInteger("BoundZ"));
        }
        if (lllllllllllllIIIlIlIIlIIlIIlllII.hasKey("LifeTicks")) {
            this.func_190653_a(lllllllllllllIIIlIlIIlIIlIIlllII.getInteger("LifeTicks"));
        }
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIlIlIIlIIIlIIllll, @Nullable final IEntityLivingData lllllllllllllIIIlIlIIlIIIlIlIIIl) {
        this.setEquipmentBasedOnDifficulty(lllllllllllllIIIlIlIIlIIIlIIllll);
        this.setEnchantmentBasedOnDifficulty(lllllllllllllIIIlIlIIlIIIlIIllll);
        return super.onInitialSpawn(lllllllllllllIIIlIlIIlIIIlIIllll, lllllllllllllIIIlIlIIlIIIlIlIIIl);
    }
    
    @Override
    public void moveEntity(final MoverType lllllllllllllIIIlIlIIlIIlIllIIlI, final double lllllllllllllIIIlIlIIlIIlIllIIIl, final double lllllllllllllIIIlIlIIlIIlIllIIII, final double lllllllllllllIIIlIlIIlIIlIlIllll) {
        super.moveEntity(lllllllllllllIIIlIlIIlIIlIllIIlI, lllllllllllllIIIlIlIIlIIlIllIIIl, lllllllllllllIIIlIlIIlIIlIllIIII, lllllllllllllIIIlIlIIlIIlIlIllll);
        this.doBlockCollisions();
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new AIChargeAttack());
        this.tasks.addTask(8, new AIMoveRandom());
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[] { EntityVex.class }));
        this.targetTasks.addTask(2, new AICopyOwnerTarget(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
    }
    
    class AICopyOwnerTarget extends EntityAITarget
    {
        @Override
        public void startExecuting() {
            EntityVex.this.setAttackTarget(EntityVex.this.field_190665_b.getAttackTarget());
            super.startExecuting();
        }
        
        public AICopyOwnerTarget(final EntityCreature lllllllllllllIIIIllIIIllIlIllIIl) {
            super(lllllllllllllIIIIllIIIllIlIllIIl, false);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityVex.this.field_190665_b != null && EntityVex.this.field_190665_b.getAttackTarget() != null && this.isSuitableTarget(EntityVex.this.field_190665_b.getAttackTarget(), false);
        }
    }
    
    class AIChargeAttack extends EntityAIBase
    {
        @Override
        public void updateTask() {
            final EntityLivingBase lllllllllllllllIlIIlIlIIlIIIlIIl = EntityVex.this.getAttackTarget();
            if (EntityVex.this.getEntityBoundingBox().intersectsWith(lllllllllllllllIlIIlIlIIlIIIlIIl.getEntityBoundingBox())) {
                EntityVex.this.attackEntityAsMob(lllllllllllllllIlIIlIlIIlIIIlIIl);
                EntityVex.this.func_190648_a(false);
            }
            else {
                final double lllllllllllllllIlIIlIlIIlIIIlIII = EntityVex.this.getDistanceSqToEntity(lllllllllllllllIlIIlIlIIlIIIlIIl);
                if (lllllllllllllllIlIIlIlIIlIIIlIII < 9.0) {
                    final Vec3d lllllllllllllllIlIIlIlIIlIIIIlll = lllllllllllllllIlIIlIlIIlIIIlIIl.getPositionEyes(1.0f);
                    EntityVex.this.moveHelper.setMoveTo(lllllllllllllllIlIIlIlIIlIIIIlll.xCoord, lllllllllllllllIlIIlIlIIlIIIIlll.yCoord, lllllllllllllllIlIIlIlIIlIIIIlll.zCoord, 1.0);
                }
            }
        }
        
        @Override
        public void startExecuting() {
            final EntityLivingBase lllllllllllllllIlIIlIlIIlIIlIllI = EntityVex.this.getAttackTarget();
            final Vec3d lllllllllllllllIlIIlIlIIlIIlIlIl = lllllllllllllllIlIIlIlIIlIIlIllI.getPositionEyes(1.0f);
            EntityVex.this.moveHelper.setMoveTo(lllllllllllllllIlIIlIlIIlIIlIlIl.xCoord, lllllllllllllllIlIIlIlIIlIIlIlIl.yCoord, lllllllllllllllIlIIlIlIIlIIlIlIl.zCoord, 1.0);
            EntityVex.this.func_190648_a(true);
            EntityVex.this.playSound(SoundEvents.field_191265_hd, 1.0f, 1.0f);
        }
        
        public AIChargeAttack() {
            this.setMutexBits(1);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityVex.this.getAttackTarget() != null && !EntityVex.this.getMoveHelper().isUpdating() && EntityVex.this.rand.nextInt(7) == 0 && EntityVex.this.getDistanceSqToEntity(EntityVex.this.getAttackTarget()) > 4.0;
        }
        
        @Override
        public void resetTask() {
            EntityVex.this.func_190648_a(false);
        }
        
        @Override
        public boolean continueExecuting() {
            return EntityVex.this.getMoveHelper().isUpdating() && EntityVex.this.func_190647_dj() && EntityVex.this.getAttackTarget() != null && EntityVex.this.getAttackTarget().isEntityAlive();
        }
    }
    
    class AIMoveRandom extends EntityAIBase
    {
        public AIMoveRandom() {
            this.setMutexBits(1);
        }
        
        @Override
        public void updateTask() {
            BlockPos lllllllllllllIlIlIIlllllllIllIlI = EntityVex.this.func_190646_di();
            if (lllllllllllllIlIlIIlllllllIllIlI == null) {
                lllllllllllllIlIlIIlllllllIllIlI = new BlockPos(EntityVex.this);
            }
            int lllllllllllllIlIlIIlllllllIllIIl = 0;
            while (lllllllllllllIlIlIIlllllllIllIIl < 3) {
                final BlockPos lllllllllllllIlIlIIlllllllIllIII = lllllllllllllIlIlIIlllllllIllIlI.add(EntityVex.this.rand.nextInt(15) - 7, EntityVex.this.rand.nextInt(11) - 5, EntityVex.this.rand.nextInt(15) - 7);
                if (EntityVex.this.world.isAirBlock(lllllllllllllIlIlIIlllllllIllIII)) {
                    EntityVex.this.moveHelper.setMoveTo(lllllllllllllIlIlIIlllllllIllIII.getX() + 0.5, lllllllllllllIlIlIIlllllllIllIII.getY() + 0.5, lllllllllllllIlIlIIlllllllIllIII.getZ() + 0.5, 0.25);
                    if (EntityVex.this.getAttackTarget() == null) {
                        EntityVex.this.getLookHelper().setLookPosition(lllllllllllllIlIlIIlllllllIllIII.getX() + 0.5, lllllllllllllIlIlIIlllllllIllIII.getY() + 0.5, lllllllllllllIlIlIIlllllllIllIII.getZ() + 0.5, 180.0f, 20.0f);
                        break;
                    }
                    break;
                }
                else {
                    ++lllllllllllllIlIlIIlllllllIllIIl;
                }
            }
        }
        
        @Override
        public boolean shouldExecute() {
            return !EntityVex.this.getMoveHelper().isUpdating() && EntityVex.this.rand.nextInt(7) == 0;
        }
        
        @Override
        public boolean continueExecuting() {
            return false;
        }
    }
    
    class AIMoveControl extends EntityMoveHelper
    {
        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO) {
                final double lllllllllllllIlllIlllllllllIIlll = this.posX - EntityVex.this.posX;
                final double lllllllllllllIlllIlllllllllIIllI = this.posY - EntityVex.this.posY;
                final double lllllllllllllIlllIlllllllllIIlIl = this.posZ - EntityVex.this.posZ;
                double lllllllllllllIlllIlllllllllIIlII = lllllllllllllIlllIlllllllllIIlll * lllllllllllllIlllIlllllllllIIlll + lllllllllllllIlllIlllllllllIIllI * lllllllllllllIlllIlllllllllIIllI + lllllllllllllIlllIlllllllllIIlIl * lllllllllllllIlllIlllllllllIIlIl;
                lllllllllllllIlllIlllllllllIIlII = MathHelper.sqrt(lllllllllllllIlllIlllllllllIIlII);
                if (lllllllllllllIlllIlllllllllIIlII < EntityVex.this.getEntityBoundingBox().getAverageEdgeLength()) {
                    this.action = Action.WAIT;
                    final EntityVex this$0 = EntityVex.this;
                    this$0.motionX *= 0.5;
                    final EntityVex this$2 = EntityVex.this;
                    this$2.motionY *= 0.5;
                    final EntityVex this$3 = EntityVex.this;
                    this$3.motionZ *= 0.5;
                }
                else {
                    final EntityVex this$4 = EntityVex.this;
                    this$4.motionX += lllllllllllllIlllIlllllllllIIlll / lllllllllllllIlllIlllllllllIIlII * 0.05 * this.speed;
                    final EntityVex this$5 = EntityVex.this;
                    this$5.motionY += lllllllllllllIlllIlllllllllIIllI / lllllllllllllIlllIlllllllllIIlII * 0.05 * this.speed;
                    final EntityVex this$6 = EntityVex.this;
                    this$6.motionZ += lllllllllllllIlllIlllllllllIIlIl / lllllllllllllIlllIlllllllllIIlII * 0.05 * this.speed;
                    if (EntityVex.this.getAttackTarget() == null) {
                        EntityVex.this.rotationYaw = -(float)MathHelper.atan2(EntityVex.this.motionX, EntityVex.this.motionZ) * 57.295776f;
                        EntityVex.this.renderYawOffset = EntityVex.this.rotationYaw;
                    }
                    else {
                        final double lllllllllllllIlllIlllllllllIIIll = EntityVex.this.getAttackTarget().posX - EntityVex.this.posX;
                        final double lllllllllllllIlllIlllllllllIIIlI = EntityVex.this.getAttackTarget().posZ - EntityVex.this.posZ;
                        EntityVex.this.rotationYaw = -(float)MathHelper.atan2(lllllllllllllIlllIlllllllllIIIll, lllllllllllllIlllIlllllllllIIIlI) * 57.295776f;
                        EntityVex.this.renderYawOffset = EntityVex.this.rotationYaw;
                    }
                }
            }
        }
        
        public AIMoveControl(final EntityVex lllllllllllllIlllIllllllllllIIll) {
            super(lllllllllllllIlllIllllllllllIIll);
        }
    }
}
