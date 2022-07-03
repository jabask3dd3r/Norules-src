package net.minecraft.entity.projectile;

import net.minecraft.entity.player.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.item.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.network.datasync.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;

public class EntityFishHook extends Entity
{
    private /* synthetic */ int ticksCatchable;
    private static final /* synthetic */ DataParameter<Integer> DATA_HOOKED_ENTITY;
    private /* synthetic */ int field_191519_ax;
    public /* synthetic */ Entity caughtEntity;
    private /* synthetic */ int ticksInAir;
    private /* synthetic */ EntityPlayer angler;
    private /* synthetic */ int ticksInGround;
    private /* synthetic */ float fishApproachAngle;
    private /* synthetic */ boolean inGround;
    private /* synthetic */ int ticksCatchableDelay;
    private /* synthetic */ int ticksCaughtDelay;
    private /* synthetic */ State field_190627_av;
    private /* synthetic */ int field_191518_aw;
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIIlIIlIlIIllIIIIll) {
        final double llllllllllllllIIlIIlIlIIllIIIIlI = 64.0;
        return llllllllllllllIIlIIlIlIIllIIIIll < 4096.0;
    }
    
    @Override
    public void setDead() {
        super.setDead();
        if (this.angler != null) {
            this.angler.fishEntity = null;
        }
    }
    
    protected void bringInHookedEntity() {
        if (this.angler != null) {
            final double llllllllllllllIIlIIlIIllllllIIll = this.angler.posX - this.posX;
            final double llllllllllllllIIlIIlIIllllllIIlI = this.angler.posY - this.posY;
            final double llllllllllllllIIlIIlIIllllllIIIl = this.angler.posZ - this.posZ;
            final double llllllllllllllIIlIIlIIllllllIIII = 0.1;
            final Entity caughtEntity = this.caughtEntity;
            caughtEntity.motionX += llllllllllllllIIlIIlIIllllllIIll * 0.1;
            final Entity caughtEntity2 = this.caughtEntity;
            caughtEntity2.motionY += llllllllllllllIIlIIlIIllllllIIlI * 0.1;
            final Entity caughtEntity3 = this.caughtEntity;
            caughtEntity3.motionZ += llllllllllllllIIlIIlIIllllllIIIl * 0.1;
        }
    }
    
    public int handleHookRetraction() {
        if (!this.world.isRemote && this.angler != null) {
            int llllllllllllllIIlIIlIlIIIIIlIlIl = 0;
            if (this.caughtEntity != null) {
                this.bringInHookedEntity();
                this.world.setEntityState(this, (byte)31);
                llllllllllllllIIlIIlIlIIIIIlIlIl = ((this.caughtEntity instanceof EntityItem) ? 3 : 5);
            }
            else if (this.ticksCatchable > 0) {
                final LootContext.Builder llllllllllllllIIlIIlIlIIIIIlIlII = new LootContext.Builder((WorldServer)this.world);
                llllllllllllllIIlIIlIlIIIIIlIlII.withLuck(this.field_191518_aw + this.angler.getLuck());
                for (final ItemStack llllllllllllllIIlIIlIlIIIIIlIIll : this.world.getLootTableManager().getLootTableFromLocation(LootTableList.GAMEPLAY_FISHING).generateLootForPools(this.rand, llllllllllllllIIlIIlIlIIIIIlIlII.build())) {
                    final EntityItem llllllllllllllIIlIIlIlIIIIIlIIlI = new EntityItem(this.world, this.posX, this.posY, this.posZ, llllllllllllllIIlIIlIlIIIIIlIIll);
                    final double llllllllllllllIIlIIlIlIIIIIlIIIl = this.angler.posX - this.posX;
                    final double llllllllllllllIIlIIlIlIIIIIlIIII = this.angler.posY - this.posY;
                    final double llllllllllllllIIlIIlIlIIIIIIllll = this.angler.posZ - this.posZ;
                    final double llllllllllllllIIlIIlIlIIIIIIlllI = MathHelper.sqrt(llllllllllllllIIlIIlIlIIIIIlIIIl * llllllllllllllIIlIIlIlIIIIIlIIIl + llllllllllllllIIlIIlIlIIIIIlIIII * llllllllllllllIIlIIlIlIIIIIlIIII + llllllllllllllIIlIIlIlIIIIIIllll * llllllllllllllIIlIIlIlIIIIIIllll);
                    final double llllllllllllllIIlIIlIlIIIIIIllIl = 0.1;
                    llllllllllllllIIlIIlIlIIIIIlIIlI.motionX = llllllllllllllIIlIIlIlIIIIIlIIIl * 0.1;
                    llllllllllllllIIlIIlIlIIIIIlIIlI.motionY = llllllllllllllIIlIIlIlIIIIIlIIII * 0.1 + MathHelper.sqrt(llllllllllllllIIlIIlIlIIIIIIlllI) * 0.08;
                    llllllllllllllIIlIIlIlIIIIIlIIlI.motionZ = llllllllllllllIIlIIlIlIIIIIIllll * 0.1;
                    this.world.spawnEntityInWorld(llllllllllllllIIlIIlIlIIIIIlIIlI);
                    this.angler.world.spawnEntityInWorld(new EntityXPOrb(this.angler.world, this.angler.posX, this.angler.posY + 0.5, this.angler.posZ + 0.5, this.rand.nextInt(6) + 1));
                    final Item llllllllllllllIIlIIlIlIIIIIIllII = llllllllllllllIIlIIlIlIIIIIlIIll.getItem();
                    if (llllllllllllllIIlIIlIlIIIIIIllII == Items.FISH || llllllllllllllIIlIIlIlIIIIIIllII == Items.COOKED_FISH) {
                        this.angler.addStat(StatList.FISH_CAUGHT, 1);
                    }
                }
                llllllllllllllIIlIIlIlIIIIIlIlIl = 1;
            }
            if (this.inGround) {
                llllllllllllllIIlIIlIlIIIIIlIlIl = 2;
            }
            this.setDead();
            return llllllllllllllIIlIIlIlIIIIIlIlIl;
        }
        return 0;
    }
    
    protected boolean canBeHooked(final Entity llllllllllllllIIlIIlIlIIIIllIllI) {
        return llllllllllllllIIlIIlIlIIIIllIllI.canBeCollidedWith() || llllllllllllllIIlIIlIlIIIIllIllI instanceof EntityItem;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIIlIlIIIIllIIlI) {
    }
    
    private void func_190624_r() {
        Vec3d llllllllllllllIIlIIlIlIIlIIIIlII = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d llllllllllllllIIlIIlIlIIlIIIIIll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult llllllllllllllIIlIIlIlIIlIIIIIlI = this.world.rayTraceBlocks(llllllllllllllIIlIIlIlIIlIIIIlII, llllllllllllllIIlIIlIlIIlIIIIIll, false, true, false);
        llllllllllllllIIlIIlIlIIlIIIIlII = new Vec3d(this.posX, this.posY, this.posZ);
        llllllllllllllIIlIIlIlIIlIIIIIll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (llllllllllllllIIlIIlIlIIlIIIIIlI != null) {
            llllllllllllllIIlIIlIlIIlIIIIIll = new Vec3d(llllllllllllllIIlIIlIlIIlIIIIIlI.hitVec.xCoord, llllllllllllllIIlIIlIlIIlIIIIIlI.hitVec.yCoord, llllllllllllllIIlIIlIlIIlIIIIIlI.hitVec.zCoord);
        }
        Entity llllllllllllllIIlIIlIlIIlIIIIIIl = null;
        final List<Entity> llllllllllllllIIlIIlIlIIlIIIIIII = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expandXyz(1.0));
        double llllllllllllllIIlIIlIlIIIlllllll = 0.0;
        for (final Entity llllllllllllllIIlIIlIlIIIllllllI : llllllllllllllIIlIIlIlIIlIIIIIII) {
            if (this.canBeHooked(llllllllllllllIIlIIlIlIIIllllllI) && (llllllllllllllIIlIIlIlIIIllllllI != this.angler || this.ticksInAir >= 5)) {
                final AxisAlignedBB llllllllllllllIIlIIlIlIIIlllllIl = llllllllllllllIIlIIlIlIIIllllllI.getEntityBoundingBox().expandXyz(0.30000001192092896);
                final RayTraceResult llllllllllllllIIlIIlIlIIIlllllII = llllllllllllllIIlIIlIlIIIlllllIl.calculateIntercept(llllllllllllllIIlIIlIlIIlIIIIlII, llllllllllllllIIlIIlIlIIlIIIIIll);
                if (llllllllllllllIIlIIlIlIIIlllllII == null) {
                    continue;
                }
                final double llllllllllllllIIlIIlIlIIIllllIll = llllllllllllllIIlIIlIlIIlIIIIlII.squareDistanceTo(llllllllllllllIIlIIlIlIIIlllllII.hitVec);
                if (llllllllllllllIIlIIlIlIIIllllIll >= llllllllllllllIIlIIlIlIIIlllllll && llllllllllllllIIlIIlIlIIIlllllll != 0.0) {
                    continue;
                }
                llllllllllllllIIlIIlIlIIlIIIIIIl = llllllllllllllIIlIIlIlIIIllllllI;
                llllllllllllllIIlIIlIlIIIlllllll = llllllllllllllIIlIIlIlIIIllllIll;
            }
        }
        if (llllllllllllllIIlIIlIlIIlIIIIIIl != null) {
            llllllllllllllIIlIIlIlIIlIIIIIlI = new RayTraceResult(llllllllllllllIIlIIlIlIIlIIIIIIl);
        }
        if (llllllllllllllIIlIIlIlIIlIIIIIlI != null && llllllllllllllIIlIIlIlIIlIIIIIlI.typeOfHit != RayTraceResult.Type.MISS) {
            if (llllllllllllllIIlIIlIlIIlIIIIIlI.typeOfHit == RayTraceResult.Type.ENTITY) {
                this.caughtEntity = llllllllllllllIIlIIlIlIIlIIIIIlI.entityHit;
                this.func_190622_s();
            }
            else {
                this.inGround = true;
            }
        }
    }
    
    private boolean func_190625_o() {
        final ItemStack llllllllllllllIIlIIlIlIIlIlIIIII = this.angler.getHeldItemMainhand();
        final ItemStack llllllllllllllIIlIIlIlIIlIIlllll = this.angler.getHeldItemOffhand();
        final boolean llllllllllllllIIlIIlIlIIlIIllllI = llllllllllllllIIlIIlIlIIlIlIIIII.getItem() == Items.FISHING_ROD;
        final boolean llllllllllllllIIlIIlIlIIlIIlllIl = llllllllllllllIIlIIlIlIIlIIlllll.getItem() == Items.FISHING_ROD;
        if (!this.angler.isDead && this.angler.isEntityAlive() && (llllllllllllllIIlIIlIlIIlIIllllI || llllllllllllllIIlIIlIlIIlIIlllIl) && this.getDistanceSqToEntity(this.angler) <= 1024.0) {
            return false;
        }
        this.setDead();
        return true;
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllIIlIIlIIlllllllIlI) {
        if (llllllllllllllIIlIIlIIlllllllIlI == 31 && this.world.isRemote && this.caughtEntity instanceof EntityPlayer && ((EntityPlayer)this.caughtEntity).isUser()) {
            this.bringInHookedEntity();
        }
        super.handleStatusUpdate(llllllllllllllIIlIIlIIlllllllIlI);
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIIlIIlIlIIllIIlIll) {
        if (EntityFishHook.DATA_HOOKED_ENTITY.equals(llllllllllllllIIlIIlIlIIllIIlIll)) {
            final int llllllllllllllIIlIIlIlIIllIIlIlI = this.getDataManager().get(EntityFishHook.DATA_HOOKED_ENTITY);
            this.caughtEntity = ((llllllllllllllIIlIIlIlIIllIIlIlI > 0) ? this.world.getEntityByID(llllllllllllllIIlIIlIlIIllIIlIlI - 1) : null);
        }
        super.notifyDataManagerChange(llllllllllllllIIlIIlIlIIllIIlIll);
    }
    
    private void func_190626_a(final EntityPlayer llllllllllllllIIlIIlIlIlIIIIIlIl) {
        this.setSize(0.25f, 0.25f);
        this.ignoreFrustumCheck = true;
        this.angler = llllllllllllllIIlIIlIlIlIIIIIlIl;
        this.angler.fishEntity = this;
    }
    
    private void func_190621_a(final BlockPos llllllllllllllIIlIIlIlIIIlIlllII) {
        final WorldServer llllllllllllllIIlIIlIlIIIlIllIll = (WorldServer)this.world;
        int llllllllllllllIIlIIlIlIIIlIllIlI = 1;
        final BlockPos llllllllllllllIIlIIlIlIIIlIllIIl = llllllllllllllIIlIIlIlIIIlIlllII.up();
        if (this.rand.nextFloat() < 0.25f && this.world.isRainingAt(llllllllllllllIIlIIlIlIIIlIllIIl)) {
            ++llllllllllllllIIlIIlIlIIIlIllIlI;
        }
        if (this.rand.nextFloat() < 0.5f && !this.world.canSeeSky(llllllllllllllIIlIIlIlIIIlIllIIl)) {
            --llllllllllllllIIlIIlIlIIIlIllIlI;
        }
        if (this.ticksCatchable > 0) {
            --this.ticksCatchable;
            if (this.ticksCatchable <= 0) {
                this.ticksCaughtDelay = 0;
                this.ticksCatchableDelay = 0;
            }
            else {
                this.motionY -= 0.2 * this.rand.nextFloat() * this.rand.nextFloat();
            }
        }
        else if (this.ticksCatchableDelay > 0) {
            this.ticksCatchableDelay -= llllllllllllllIIlIIlIlIIIlIllIlI;
            if (this.ticksCatchableDelay > 0) {
                this.fishApproachAngle += (float)(this.rand.nextGaussian() * 4.0);
                final float llllllllllllllIIlIIlIlIIIlIllIII = this.fishApproachAngle * 0.017453292f;
                final float llllllllllllllIIlIIlIlIIIlIlIlll = MathHelper.sin(llllllllllllllIIlIIlIlIIIlIllIII);
                final float llllllllllllllIIlIIlIlIIIlIlIllI = MathHelper.cos(llllllllllllllIIlIIlIlIIIlIllIII);
                final double llllllllllllllIIlIIlIlIIIlIlIlIl = this.posX + llllllllllllllIIlIIlIlIIIlIlIlll * this.ticksCatchableDelay * 0.1f;
                final double llllllllllllllIIlIIlIlIIIlIlIlII = MathHelper.floor(this.getEntityBoundingBox().minY) + 1.0f;
                final double llllllllllllllIIlIIlIlIIIlIlIIll = this.posZ + llllllllllllllIIlIIlIlIIIlIlIllI * this.ticksCatchableDelay * 0.1f;
                final Block llllllllllllllIIlIIlIlIIIlIlIIlI = llllllllllllllIIlIIlIlIIIlIllIll.getBlockState(new BlockPos(llllllllllllllIIlIIlIlIIIlIlIlIl, llllllllllllllIIlIIlIlIIIlIlIlII - 1.0, llllllllllllllIIlIIlIlIIIlIlIIll)).getBlock();
                if (llllllllllllllIIlIIlIlIIIlIlIIlI == Blocks.WATER || llllllllllllllIIlIIlIlIIIlIlIIlI == Blocks.FLOWING_WATER) {
                    if (this.rand.nextFloat() < 0.15f) {
                        llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_BUBBLE, llllllllllllllIIlIIlIlIIIlIlIlIl, llllllllllllllIIlIIlIlIIIlIlIlII - 0.10000000149011612, llllllllllllllIIlIIlIlIIIlIlIIll, 1, llllllllllllllIIlIIlIlIIIlIlIlll, 0.1, llllllllllllllIIlIIlIlIIIlIlIllI, 0.0, new int[0]);
                    }
                    final float llllllllllllllIIlIIlIlIIIlIlIIIl = llllllllllllllIIlIIlIlIIIlIlIlll * 0.04f;
                    final float llllllllllllllIIlIIlIlIIIlIlIIII = llllllllllllllIIlIIlIlIIIlIlIllI * 0.04f;
                    llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_WAKE, llllllllllllllIIlIIlIlIIIlIlIlIl, llllllllllllllIIlIIlIlIIIlIlIlII, llllllllllllllIIlIIlIlIIIlIlIIll, 0, llllllllllllllIIlIIlIlIIIlIlIIII, 0.01, -llllllllllllllIIlIIlIlIIIlIlIIIl, 1.0, new int[0]);
                    llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_WAKE, llllllllllllllIIlIIlIlIIIlIlIlIl, llllllllllllllIIlIIlIlIIIlIlIlII, llllllllllllllIIlIIlIlIIIlIlIIll, 0, -llllllllllllllIIlIIlIlIIIlIlIIII, 0.01, llllllllllllllIIlIIlIlIIIlIlIIIl, 1.0, new int[0]);
                }
            }
            else {
                this.motionY = -0.4f * MathHelper.nextFloat(this.rand, 0.6f, 1.0f);
                this.playSound(SoundEvents.ENTITY_BOBBER_SPLASH, 0.25f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                final double llllllllllllllIIlIIlIlIIIlIIllll = this.getEntityBoundingBox().minY + 0.5;
                llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX, llllllllllllllIIlIIlIlIIIlIIllll, this.posZ, (int)(1.0f + this.width * 20.0f), this.width, 0.0, this.width, 0.20000000298023224, new int[0]);
                llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_WAKE, this.posX, llllllllllllllIIlIIlIlIIIlIIllll, this.posZ, (int)(1.0f + this.width * 20.0f), this.width, 0.0, this.width, 0.20000000298023224, new int[0]);
                this.ticksCatchable = MathHelper.getInt(this.rand, 20, 40);
            }
        }
        else if (this.ticksCaughtDelay > 0) {
            this.ticksCaughtDelay -= llllllllllllllIIlIIlIlIIIlIllIlI;
            float llllllllllllllIIlIIlIlIIIlIIlllI = 0.15f;
            if (this.ticksCaughtDelay < 20) {
                llllllllllllllIIlIIlIlIIIlIIlllI += (float)((20 - this.ticksCaughtDelay) * 0.05);
            }
            else if (this.ticksCaughtDelay < 40) {
                llllllllllllllIIlIIlIlIIIlIIlllI += (float)((40 - this.ticksCaughtDelay) * 0.02);
            }
            else if (this.ticksCaughtDelay < 60) {
                llllllllllllllIIlIIlIlIIIlIIlllI += (float)((60 - this.ticksCaughtDelay) * 0.01);
            }
            if (this.rand.nextFloat() < llllllllllllllIIlIIlIlIIIlIIlllI) {
                final float llllllllllllllIIlIIlIlIIIlIIllIl = MathHelper.nextFloat(this.rand, 0.0f, 360.0f) * 0.017453292f;
                final float llllllllllllllIIlIIlIlIIIlIIllII = MathHelper.nextFloat(this.rand, 25.0f, 60.0f);
                final double llllllllllllllIIlIIlIlIIIlIIlIll = this.posX + MathHelper.sin(llllllllllllllIIlIIlIlIIIlIIllIl) * llllllllllllllIIlIIlIlIIIlIIllII * 0.1f;
                final double llllllllllllllIIlIIlIlIIIlIIlIlI = MathHelper.floor(this.getEntityBoundingBox().minY) + 1.0f;
                final double llllllllllllllIIlIIlIlIIIlIIlIIl = this.posZ + MathHelper.cos(llllllllllllllIIlIIlIlIIIlIIllIl) * llllllllllllllIIlIIlIlIIIlIIllII * 0.1f;
                final Block llllllllllllllIIlIIlIlIIIlIIlIII = llllllllllllllIIlIIlIlIIIlIllIll.getBlockState(new BlockPos((int)llllllllllllllIIlIIlIlIIIlIIlIll, (int)llllllllllllllIIlIIlIlIIIlIIlIlI - 1, (int)llllllllllllllIIlIIlIlIIIlIIlIIl)).getBlock();
                if (llllllllllllllIIlIIlIlIIIlIIlIII == Blocks.WATER || llllllllllllllIIlIIlIlIIIlIIlIII == Blocks.FLOWING_WATER) {
                    llllllllllllllIIlIIlIlIIIlIllIll.spawnParticle(EnumParticleTypes.WATER_SPLASH, llllllllllllllIIlIIlIlIIIlIIlIll, llllllllllllllIIlIIlIlIIIlIIlIlI, llllllllllllllIIlIIlIlIIIlIIlIIl, 2 + this.rand.nextInt(2), 0.10000000149011612, 0.0, 0.10000000149011612, 0.0, new int[0]);
                }
            }
            if (this.ticksCaughtDelay <= 0) {
                this.fishApproachAngle = MathHelper.nextFloat(this.rand, 0.0f, 360.0f);
                this.ticksCatchableDelay = MathHelper.getInt(this.rand, 20, 80);
            }
        }
        else {
            this.ticksCaughtDelay = MathHelper.getInt(this.rand, 100, 600);
            this.ticksCaughtDelay -= this.field_191519_ax * 20 * 5;
        }
    }
    
    public EntityFishHook(final World llllllllllllllIIlIIlIlIlIIIlIllI, final EntityPlayer llllllllllllllIIlIIlIlIlIIIlIlIl, final double llllllllllllllIIlIIlIlIlIIIllIlI, final double llllllllllllllIIlIIlIlIlIIIlIIll, final double llllllllllllllIIlIIlIlIlIIIlIIlI) {
        super(llllllllllllllIIlIIlIlIlIIIlIllI);
        this.field_190627_av = State.FLYING;
        this.func_190626_a(llllllllllllllIIlIIlIlIlIIIlIlIl);
        this.setPosition(llllllllllllllIIlIIlIlIlIIIllIlI, llllllllllllllIIlIIlIlIlIIIlIIll, llllllllllllllIIlIIlIlIlIIIlIIlI);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }
    
    public void func_191516_a(final int llllllllllllllIIlIIlIlIIllllllIl) {
        this.field_191519_ax = llllllllllllllIIlIIlIlIIllllllIl;
    }
    
    public EntityFishHook(final World llllllllllllllIIlIIlIlIlIIIIllIl, final EntityPlayer llllllllllllllIIlIIlIlIlIIIIllII) {
        super(llllllllllllllIIlIIlIlIlIIIIllIl);
        this.field_190627_av = State.FLYING;
        this.func_190626_a(llllllllllllllIIlIIlIlIlIIIIllII);
        this.func_190620_n();
    }
    
    public EntityPlayer func_190619_l() {
        return this.angler;
    }
    
    private void func_190623_q() {
        final float llllllllllllllIIlIIlIlIIlIIlIlII = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, llllllllllllllIIlIIlIlIIlIIlIlII) * 57.29577951308232);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
    }
    
    private void func_190622_s() {
        this.getDataManager().set(EntityFishHook.DATA_HOOKED_ENTITY, this.caughtEntity.getEntityId() + 1);
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityFishHook.DATA_HOOKED_ENTITY, 0);
    }
    
    static {
        DATA_HOOKED_ENTITY = EntityDataManager.createKey(EntityFishHook.class, DataSerializers.VARINT);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.angler == null) {
            this.setDead();
        }
        else if (this.world.isRemote || !this.func_190625_o()) {
            if (this.inGround) {
                ++this.ticksInGround;
                if (this.ticksInGround >= 1200) {
                    this.setDead();
                    return;
                }
            }
            float llllllllllllllIIlIIlIlIIlIllIIIl = 0.0f;
            final BlockPos llllllllllllllIIlIIlIlIIlIllIIII = new BlockPos(this);
            final IBlockState llllllllllllllIIlIIlIlIIlIlIllll = this.world.getBlockState(llllllllllllllIIlIIlIlIIlIllIIII);
            if (llllllllllllllIIlIIlIlIIlIlIllll.getMaterial() == Material.WATER) {
                llllllllllllllIIlIIlIlIIlIllIIIl = BlockLiquid.func_190973_f(llllllllllllllIIlIIlIlIIlIlIllll, this.world, llllllllllllllIIlIIlIlIIlIllIIII);
            }
            if (this.field_190627_av == State.FLYING) {
                if (this.caughtEntity != null) {
                    this.motionX = 0.0;
                    this.motionY = 0.0;
                    this.motionZ = 0.0;
                    this.field_190627_av = State.HOOKED_IN_ENTITY;
                    return;
                }
                if (llllllllllllllIIlIIlIlIIlIllIIIl > 0.0f) {
                    this.motionX *= 0.3;
                    this.motionY *= 0.2;
                    this.motionZ *= 0.3;
                    this.field_190627_av = State.BOBBING;
                    return;
                }
                if (!this.world.isRemote) {
                    this.func_190624_r();
                }
                if (!this.inGround && !this.onGround && !this.isCollidedHorizontally) {
                    ++this.ticksInAir;
                }
                else {
                    this.ticksInAir = 0;
                    this.motionX = 0.0;
                    this.motionY = 0.0;
                    this.motionZ = 0.0;
                }
            }
            else {
                if (this.field_190627_av == State.HOOKED_IN_ENTITY) {
                    if (this.caughtEntity != null) {
                        if (this.caughtEntity.isDead) {
                            this.caughtEntity = null;
                            this.field_190627_av = State.FLYING;
                        }
                        else {
                            this.posX = this.caughtEntity.posX;
                            final double llllllllllllllIIlIIlIlIIlIlIlllI = this.caughtEntity.height;
                            this.posY = this.caughtEntity.getEntityBoundingBox().minY + llllllllllllllIIlIIlIlIIlIlIlllI * 0.8;
                            this.posZ = this.caughtEntity.posZ;
                            this.setPosition(this.posX, this.posY, this.posZ);
                        }
                    }
                    return;
                }
                if (this.field_190627_av == State.BOBBING) {
                    this.motionX *= 0.9;
                    this.motionZ *= 0.9;
                    double llllllllllllllIIlIIlIlIIlIlIllIl = this.posY + this.motionY - llllllllllllllIIlIIlIlIIlIllIIII.getY() - llllllllllllllIIlIIlIlIIlIllIIIl;
                    if (Math.abs(llllllllllllllIIlIIlIlIIlIlIllIl) < 0.01) {
                        llllllllllllllIIlIIlIlIIlIlIllIl += Math.signum(llllllllllllllIIlIIlIlIIlIlIllIl) * 0.1;
                    }
                    this.motionY -= llllllllllllllIIlIIlIlIIlIlIllIl * this.rand.nextFloat() * 0.2;
                    if (!this.world.isRemote && llllllllllllllIIlIIlIlIIlIllIIIl > 0.0f) {
                        this.func_190621_a(llllllllllllllIIlIIlIlIIlIllIIII);
                    }
                }
            }
            if (llllllllllllllIIlIIlIlIIlIlIllll.getMaterial() != Material.WATER) {
                this.motionY -= 0.03;
            }
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.func_190623_q();
            final double llllllllllllllIIlIIlIlIIlIlIllII = 0.92;
            this.motionX *= 0.92;
            this.motionY *= 0.92;
            this.motionZ *= 0.92;
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }
    
    private void func_190620_n() {
        final float llllllllllllllIIlIIlIlIIlllIlIIl = this.angler.prevRotationPitch + (this.angler.rotationPitch - this.angler.prevRotationPitch);
        final float llllllllllllllIIlIIlIlIIlllIlIII = this.angler.prevRotationYaw + (this.angler.rotationYaw - this.angler.prevRotationYaw);
        final float llllllllllllllIIlIIlIlIIlllIIlll = MathHelper.cos(-llllllllllllllIIlIIlIlIIlllIlIII * 0.017453292f - 3.1415927f);
        final float llllllllllllllIIlIIlIlIIlllIIllI = MathHelper.sin(-llllllllllllllIIlIIlIlIIlllIlIII * 0.017453292f - 3.1415927f);
        final float llllllllllllllIIlIIlIlIIlllIIlIl = -MathHelper.cos(-llllllllllllllIIlIIlIlIIlllIlIIl * 0.017453292f);
        final float llllllllllllllIIlIIlIlIIlllIIlII = MathHelper.sin(-llllllllllllllIIlIIlIlIIlllIlIIl * 0.017453292f);
        final double llllllllllllllIIlIIlIlIIlllIIIll = this.angler.prevPosX + (this.angler.posX - this.angler.prevPosX) - llllllllllllllIIlIIlIlIIlllIIllI * 0.3;
        final double llllllllllllllIIlIIlIlIIlllIIIlI = this.angler.prevPosY + (this.angler.posY - this.angler.prevPosY) + this.angler.getEyeHeight();
        final double llllllllllllllIIlIIlIlIIlllIIIIl = this.angler.prevPosZ + (this.angler.posZ - this.angler.prevPosZ) - llllllllllllllIIlIIlIlIIlllIIlll * 0.3;
        this.setLocationAndAngles(llllllllllllllIIlIIlIlIIlllIIIll, llllllllllllllIIlIIlIlIIlllIIIlI, llllllllllllllIIlIIlIlIIlllIIIIl, llllllllllllllIIlIIlIlIIlllIlIII, llllllllllllllIIlIIlIlIIlllIlIIl);
        this.motionX = -llllllllllllllIIlIIlIlIIlllIIllI;
        this.motionY = MathHelper.clamp(-(llllllllllllllIIlIIlIlIIlllIIlII / llllllllllllllIIlIIlIlIIlllIIlIl), -5.0f, 5.0f);
        this.motionZ = -llllllllllllllIIlIIlIlIIlllIIlll;
        final float llllllllllllllIIlIIlIlIIlllIIIII = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX *= 0.6 / llllllllllllllIIlIIlIlIIlllIIIII + 0.5 + this.rand.nextGaussian() * 0.0045;
        this.motionY *= 0.6 / llllllllllllllIIlIIlIlIIlllIIIII + 0.5 + this.rand.nextGaussian() * 0.0045;
        this.motionZ *= 0.6 / llllllllllllllIIlIIlIlIIlllIIIII + 0.5 + this.rand.nextGaussian() * 0.0045;
        final float llllllllllllllIIlIIlIlIIllIlllll = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, llllllllllllllIIlIIlIlIIllIlllll) * 57.29577951308232);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIIlIlIIIIllIlII) {
    }
    
    @Override
    public void setPositionAndRotationDirect(final double llllllllllllllIIlIIlIlIIlIlllllI, final double llllllllllllllIIlIIlIlIIlIllllIl, final double llllllllllllllIIlIIlIlIIlIllllII, final float llllllllllllllIIlIIlIlIIlIlllIll, final float llllllllllllllIIlIIlIlIIlIlllIlI, final int llllllllllllllIIlIIlIlIIlIlllIIl, final boolean llllllllllllllIIlIIlIlIIlIlllIII) {
    }
    
    public void func_191517_b(final int llllllllllllllIIlIIlIlIIlllllIIl) {
        this.field_191518_aw = llllllllllllllIIlIIlIlIIlllllIIl;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    enum State
    {
        BOBBING("BOBBING", 2), 
        HOOKED_IN_ENTITY("HOOKED_IN_ENTITY", 1), 
        FLYING("FLYING", 0);
        
        private State(final String lllllllllllllIllllIIIlIllIllllII, final int lllllllllllllIllllIIIlIllIlllIll) {
        }
    }
}
