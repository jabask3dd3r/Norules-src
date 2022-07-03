package net.minecraft.entity.passive;

import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.math.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class EntityBat extends EntityAmbientCreature
{
    private /* synthetic */ BlockPos spawnPosition;
    private static final /* synthetic */ DataParameter<Byte> HANGING;
    
    @Override
    public boolean getCanSpawnHere() {
        final BlockPos llIlllll = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
        if (llIlllll.getY() >= this.world.getSeaLevel()) {
            return false;
        }
        final int llIllllI = this.world.getLightFromNeighbors(llIlllll);
        int llIlllIl = 4;
        if (this.isDateAroundHalloween(this.world.getCurrentDate())) {
            llIlllIl = 7;
        }
        else if (this.rand.nextBoolean()) {
            return false;
        }
        return llIllllI <= this.rand.nextInt(llIlllIl) && super.getCanSpawnHere();
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lIIllIllI) {
        return SoundEvents.ENTITY_BAT_HURT;
    }
    
    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }
    
    @Override
    protected void updateFallState(final double lIIIIIIIl, final boolean lIIIIIIII, final IBlockState llllllll, final BlockPos lllllllI) {
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_BAT;
    }
    
    public boolean getIsBatHanging() {
        return (this.dataManager.get(EntityBat.HANGING) & 0x1) != 0x0;
    }
    
    private boolean isDateAroundHalloween(final Calendar llIlIlIl) {
        return (llIlIlIl.get(2) + 1 == 10 && llIlIlIl.get(5) >= 20) || (llIlIlIl.get(2) + 1 == 11 && llIlIlIl.get(5) <= 3);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllIllIl) {
        super.readEntityFromNBT(lllIllIl);
        this.dataManager.set(EntityBat.HANGING, lllIllIl.getByte("BatFlags"));
    }
    
    static {
        HANGING = EntityDataManager.createKey(EntityBat.class, DataSerializers.BYTE);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllIlIl, final float llllIlII) {
        if (this.isEntityInvulnerable(llllIlIl)) {
            return false;
        }
        if (!this.world.isRemote && this.getIsBatHanging()) {
            this.setIsBatHanging(false);
        }
        return super.attackEntityFrom(llllIlIl, llllIlII);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getIsBatHanging()) {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.posY = MathHelper.floor(this.posY) + 1.0 - this.height;
        }
        else {
            this.motionY *= 0.6000000238418579;
        }
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.1f;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height / 2.0f;
    }
    
    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95f;
    }
    
    public static void registerFixesBat(final DataFixer llllIIIl) {
        EntityLiving.registerFixesMob(llllIIIl, EntityBat.class);
    }
    
    @Override
    public void fall(final float lIIIIIlII, final float lIIIIIIll) {
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
    }
    
    @Override
    protected void collideWithEntity(final Entity lIIllIIlI) {
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        final BlockPos lIIIlIlIl = new BlockPos(this);
        final BlockPos lIIIlIlII = lIIIlIlIl.up();
        if (this.getIsBatHanging()) {
            if (this.world.getBlockState(lIIIlIlII).isNormalCube()) {
                if (this.rand.nextInt(200) == 0) {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }
                if (this.world.getNearestPlayerNotCreative(this, 4.0) != null) {
                    this.setIsBatHanging(false);
                    this.world.playEvent(null, 1025, lIIIlIlIl, 0);
                }
            }
            else {
                this.setIsBatHanging(false);
                this.world.playEvent(null, 1025, lIIIlIlIl, 0);
            }
        }
        else {
            if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
                this.spawnPosition = null;
            }
            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0) {
                this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }
            final double lIIIlIIll = this.spawnPosition.getX() + 0.5 - this.posX;
            final double lIIIlIIlI = this.spawnPosition.getY() + 0.1 - this.posY;
            final double lIIIlIIIl = this.spawnPosition.getZ() + 0.5 - this.posZ;
            this.motionX += (Math.signum(lIIIlIIll) * 0.5 - this.motionX) * 0.10000000149011612;
            this.motionY += (Math.signum(lIIIlIIlI) * 0.699999988079071 - this.motionY) * 0.10000000149011612;
            this.motionZ += (Math.signum(lIIIlIIIl) * 0.5 - this.motionZ) * 0.10000000149011612;
            final float lIIIlIIII = (float)(MathHelper.atan2(this.motionZ, this.motionX) * 57.29577951308232) - 90.0f;
            final float lIIIIllll = MathHelper.wrapDegrees(lIIIlIIII - this.rotationYaw);
            this.field_191988_bg = 0.5f;
            this.rotationYaw += lIIIIllll;
            if (this.rand.nextInt(100) == 0 && this.world.getBlockState(lIIIlIlII).isNormalCube()) {
                this.setIsBatHanging(true);
            }
        }
    }
    
    @Nullable
    public SoundEvent getAmbientSound() {
        return (this.getIsBatHanging() && this.rand.nextInt(4) != 0) ? null : SoundEvents.ENTITY_BAT_AMBIENT;
    }
    
    public EntityBat(final World lIlIIIIlI) {
        super(lIlIIIIlI);
        this.setSize(0.5f, 0.9f);
        this.setIsBatHanging(true);
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllIIlIl) {
        super.writeEntityToNBT(lllIIlIl);
        lllIIlIl.setByte("BatFlags", this.dataManager.get(EntityBat.HANGING));
    }
    
    public void setIsBatHanging(final boolean lIIlIIIll) {
        final byte lIIlIIlIl = this.dataManager.get(EntityBat.HANGING);
        if (lIIlIIIll) {
            this.dataManager.set(EntityBat.HANGING, (byte)(lIIlIIlIl | 0x1));
        }
        else {
            this.dataManager.set(EntityBat.HANGING, (byte)(lIIlIIlIl & 0xFFFFFFFE));
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityBat.HANGING, (Byte)0);
    }
    
    @Override
    protected void collideWithNearbyEntities() {
    }
}
