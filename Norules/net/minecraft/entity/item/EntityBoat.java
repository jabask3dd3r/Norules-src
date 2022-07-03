package net.minecraft.entity.item;

import javax.annotation.*;
import net.minecraft.network.datasync.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class EntityBoat extends Entity
{
    private /* synthetic */ boolean leftInputDown;
    private /* synthetic */ float boatGlide;
    private /* synthetic */ double boatYaw;
    private static final /* synthetic */ DataParameter<Boolean>[] DATA_ID_PADDLE;
    private static final /* synthetic */ DataParameter<Float> DAMAGE_TAKEN;
    private /* synthetic */ double lerpZ;
    private /* synthetic */ float outOfControlTicks;
    private /* synthetic */ int lerpSteps;
    private /* synthetic */ double lastYd;
    private /* synthetic */ Status status;
    private /* synthetic */ boolean rightInputDown;
    private /* synthetic */ double waterLevel;
    private /* synthetic */ boolean backInputDown;
    private /* synthetic */ Status previousStatus;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Type;
    private static final /* synthetic */ DataParameter<Integer> FORWARD_DIRECTION;
    private final /* synthetic */ float[] paddlePositions;
    private static final /* synthetic */ DataParameter<Integer> TIME_SINCE_HIT;
    private static final /* synthetic */ DataParameter<Integer> BOAT_TYPE;
    private /* synthetic */ boolean forwardInputDown;
    private /* synthetic */ float momentum;
    private /* synthetic */ float deltaRotation;
    private /* synthetic */ double lerpY;
    private /* synthetic */ double boatPitch;
    private /* synthetic */ double lerpXRot;
    
    public Item getItemBoat() {
        switch ($SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Type()[this.getBoatType().ordinal()]) {
            default: {
                return Items.BOAT;
            }
            case 2: {
                return Items.SPRUCE_BOAT;
            }
            case 3: {
                return Items.BIRCH_BOAT;
            }
            case 4: {
                return Items.JUNGLE_BOAT;
            }
            case 5: {
                return Items.ACACIA_BOAT;
            }
            case 6: {
                return Items.DARK_OAK_BOAT;
            }
        }
    }
    
    public void setBoatType(final Type llllllllllllllIIIlIlIIlIlIIIlllI) {
        this.dataManager.set(EntityBoat.BOAT_TYPE, llllllllllllllIIIlIlIIlIlIIIlllI.ordinal());
    }
    
    @Override
    public void applyEntityCollision(final Entity llllllllllllllIIIlIlIlIIIlIIIIlI) {
        if (llllllllllllllIIIlIlIlIIIlIIIIlI instanceof EntityBoat) {
            if (llllllllllllllIIIlIlIlIIIlIIIIlI.getEntityBoundingBox().minY < this.getEntityBoundingBox().maxY) {
                super.applyEntityCollision(llllllllllllllIIIlIlIlIIIlIIIIlI);
            }
        }
        else if (llllllllllllllIIIlIlIlIIIlIIIIlI.getEntityBoundingBox().minY <= this.getEntityBoundingBox().minY) {
            super.applyEntityCollision(llllllllllllllIIIlIlIlIIIlIIIIlI);
        }
    }
    
    public EntityBoat(final World llllllllllllllIIIlIlIlIIIllllIll) {
        super(llllllllllllllIIIlIlIlIIIllllIll);
        this.paddlePositions = new float[2];
        this.preventEntitySpawning = true;
        this.setSize(1.375f, 0.5625f);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return this.getEntityBoundingBox();
    }
    
    public void setDamageTaken(final float llllllllllllllIIIlIlIIlIlIlIlIll) {
        this.dataManager.set(EntityBoat.DAMAGE_TAKEN, llllllllllllllIIIlIlIIlIlIlIlIll);
    }
    
    static {
        TIME_SINCE_HIT = EntityDataManager.createKey(EntityBoat.class, DataSerializers.VARINT);
        FORWARD_DIRECTION = EntityDataManager.createKey(EntityBoat.class, DataSerializers.VARINT);
        DAMAGE_TAKEN = EntityDataManager.createKey(EntityBoat.class, DataSerializers.FLOAT);
        BOAT_TYPE = EntityDataManager.createKey(EntityBoat.class, DataSerializers.VARINT);
        DATA_ID_PADDLE = new DataParameter[] { EntityDataManager.createKey(EntityBoat.class, DataSerializers.BOOLEAN), EntityDataManager.createKey(EntityBoat.class, DataSerializers.BOOLEAN) };
    }
    
    @Nullable
    private Status getUnderwaterStatus() {
        final AxisAlignedBB llllllllllllllIIIlIlIIllIIllIlII = this.getEntityBoundingBox();
        final double llllllllllllllIIIlIlIIllIIllIIll = llllllllllllllIIIlIlIIllIIllIlII.maxY + 0.001;
        final int llllllllllllllIIIlIlIIllIIllIIlI = MathHelper.floor(llllllllllllllIIIlIlIIllIIllIlII.minX);
        final int llllllllllllllIIIlIlIIllIIllIIIl = MathHelper.ceil(llllllllllllllIIIlIlIIllIIllIlII.maxX);
        final int llllllllllllllIIIlIlIIllIIllIIII = MathHelper.floor(llllllllllllllIIIlIlIIllIIllIlII.maxY);
        final int llllllllllllllIIIlIlIIllIIlIllll = MathHelper.ceil(llllllllllllllIIIlIlIIllIIllIIll);
        final int llllllllllllllIIIlIlIIllIIlIlllI = MathHelper.floor(llllllllllllllIIIlIlIIllIIllIlII.minZ);
        final int llllllllllllllIIIlIlIIllIIlIllIl = MathHelper.ceil(llllllllllllllIIIlIlIIllIIllIlII.maxZ);
        boolean llllllllllllllIIIlIlIIllIIlIllII = false;
        final BlockPos.PooledMutableBlockPos llllllllllllllIIIlIlIIllIIlIlIll = BlockPos.PooledMutableBlockPos.retain();
        try {
            for (int llllllllllllllIIIlIlIIllIIlIlIlI = llllllllllllllIIIlIlIIllIIllIIlI; llllllllllllllIIIlIlIIllIIlIlIlI < llllllllllllllIIIlIlIIllIIllIIIl; ++llllllllllllllIIIlIlIIllIIlIlIlI) {
                for (int llllllllllllllIIIlIlIIllIIlIlIIl = llllllllllllllIIIlIlIIllIIllIIII; llllllllllllllIIIlIlIIllIIlIlIIl < llllllllllllllIIIlIlIIllIIlIllll; ++llllllllllllllIIIlIlIIllIIlIlIIl) {
                    for (int llllllllllllllIIIlIlIIllIIlIlIII = llllllllllllllIIIlIlIIllIIlIlllI; llllllllllllllIIIlIlIIllIIlIlIII < llllllllllllllIIIlIlIIllIIlIllIl; ++llllllllllllllIIIlIlIIllIIlIlIII) {
                        llllllllllllllIIIlIlIIllIIlIlIll.setPos(llllllllllllllIIIlIlIIllIIlIlIlI, llllllllllllllIIIlIlIIllIIlIlIIl, llllllllllllllIIIlIlIIllIIlIlIII);
                        final IBlockState llllllllllllllIIIlIlIIllIIlIIlll = this.world.getBlockState(llllllllllllllIIIlIlIIllIIlIlIll);
                        if (llllllllllllllIIIlIlIIllIIlIIlll.getMaterial() == Material.WATER && llllllllllllllIIIlIlIIllIIllIIll < BlockLiquid.func_190972_g(llllllllllllllIIIlIlIIllIIlIIlll, this.world, llllllllllllllIIIlIlIIllIIlIlIll)) {
                            if (llllllllllllllIIIlIlIIllIIlIIlll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) != 0) {
                                final int llllllllllllllIIIlIlIIllIIIlIlII;
                                final Status llllllllllllllIIIlIlIIllIIlIIllI = (Status)(llllllllllllllIIIlIlIIllIIIlIlII = (int)Status.UNDER_FLOWING_WATER);
                                return (Status)llllllllllllllIIIlIlIIllIIIlIlII;
                            }
                            llllllllllllllIIIlIlIIllIIlIllII = true;
                        }
                    }
                }
            }
        }
        finally {
            llllllllllllllIIIlIlIIllIIlIlIll.release();
        }
        llllllllllllllIIIlIlIIllIIlIlIll.release();
        return llllllllllllllIIIlIlIIllIIlIllII ? Status.UNDER_WATER : null;
    }
    
    @Override
    protected void updateFallState(final double llllllllllllllIIIlIlIIlIlIllIlll, final boolean llllllllllllllIIIlIlIIlIlIllllIl, final IBlockState llllllllllllllIIIlIlIIlIlIllllII, final BlockPos llllllllllllllIIIlIlIIlIlIlllIll) {
        this.lastYd = this.motionY;
        if (!this.isRiding()) {
            if (llllllllllllllIIIlIlIIlIlIllllIl) {
                if (this.fallDistance > 3.0f) {
                    if (this.status != Status.ON_LAND) {
                        this.fallDistance = 0.0f;
                        return;
                    }
                    this.fall(this.fallDistance, 1.0f);
                    if (!this.world.isRemote && !this.isDead) {
                        this.setDead();
                        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
                            for (int llllllllllllllIIIlIlIIlIlIlllIlI = 0; llllllllllllllIIIlIlIIlIlIlllIlI < 3; ++llllllllllllllIIIlIlIIlIlIlllIlI) {
                                this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.PLANKS), 1, this.getBoatType().getMetadata()), 0.0f);
                            }
                            for (int llllllllllllllIIIlIlIIlIlIlllIIl = 0; llllllllllllllIIIlIlIIlIlIlllIIl < 2; ++llllllllllllllIIIlIlIIlIlIlllIIl) {
                                this.dropItemWithOffset(Items.STICK, 1, 0.0f);
                            }
                        }
                    }
                }
                this.fallDistance = 0.0f;
            }
            else if (this.world.getBlockState(new BlockPos(this).down()).getMaterial() != Material.WATER && llllllllllllllIIIlIlIIlIlIllIlll < 0.0) {
                this.fallDistance -= (float)llllllllllllllIIIlIlIIlIlIllIlll;
            }
        }
    }
    
    @Override
    public void updatePassenger(final Entity llllllllllllllIIIlIlIIlIlllIllIl) {
        if (this.isPassenger(llllllllllllllIIIlIlIIlIlllIllIl)) {
            float llllllllllllllIIIlIlIIlIllllIIll = 0.0f;
            final float llllllllllllllIIIlIlIIlIllllIIlI = (float)((this.isDead ? 0.009999999776482582 : this.getMountedYOffset()) + llllllllllllllIIIlIlIIlIlllIllIl.getYOffset());
            if (this.getPassengers().size() > 1) {
                final int llllllllllllllIIIlIlIIlIllllIIIl = this.getPassengers().indexOf(llllllllllllllIIIlIlIIlIlllIllIl);
                if (llllllllllllllIIIlIlIIlIllllIIIl == 0) {
                    llllllllllllllIIIlIlIIlIllllIIll = 0.2f;
                }
                else {
                    llllllllllllllIIIlIlIIlIllllIIll = -0.6f;
                }
                if (llllllllllllllIIIlIlIIlIlllIllIl instanceof EntityAnimal) {
                    llllllllllllllIIIlIlIIlIllllIIll += (float)0.2;
                }
            }
            final Vec3d llllllllllllllIIIlIlIIlIllllIIII = new Vec3d(llllllllllllllIIIlIlIIlIllllIIll, 0.0, 0.0).rotateYaw(-this.rotationYaw * 0.017453292f - 1.5707964f);
            llllllllllllllIIIlIlIIlIlllIllIl.setPosition(this.posX + llllllllllllllIIIlIlIIlIllllIIII.xCoord, this.posY + llllllllllllllIIIlIlIIlIllllIIlI, this.posZ + llllllllllllllIIIlIlIIlIllllIIII.zCoord);
            llllllllllllllIIIlIlIIlIlllIllIl.rotationYaw += this.deltaRotation;
            llllllllllllllIIIlIlIIlIlllIllIl.setRotationYawHead(llllllllllllllIIIlIlIIlIlllIllIl.getRotationYawHead() + this.deltaRotation);
            this.applyYawToEntity(llllllllllllllIIIlIlIIlIlllIllIl);
            if (llllllllllllllIIIlIlIIlIlllIllIl instanceof EntityAnimal && this.getPassengers().size() > 1) {
                final int llllllllllllllIIIlIlIIlIlllIllll = (llllllllllllllIIIlIlIIlIlllIllIl.getEntityId() % 2 == 0) ? 90 : 270;
                llllllllllllllIIIlIlIIlIlllIllIl.setRenderYawOffset(((EntityAnimal)llllllllllllllIIIlIlIIlIlllIllIl).renderYawOffset + llllllllllllllIIIlIlIIlIlllIllll);
                llllllllllllllIIIlIlIIlIlllIllIl.setRotationYawHead(llllllllllllllIIIlIlIIlIlllIllIl.getRotationYawHead() + llllllllllllllIIIlIlIIlIlllIllll);
            }
        }
    }
    
    @Override
    public void applyOrientationToEntity(final Entity llllllllllllllIIIlIlIIlIllIllIIl) {
        this.applyYawToEntity(llllllllllllllIIIlIlIIlIllIllIIl);
    }
    
    public float getWaterLevelAbove() {
        final AxisAlignedBB llllllllllllllIIIlIlIIllllIIllIl = this.getEntityBoundingBox();
        final int llllllllllllllIIIlIlIIllllIIllII = MathHelper.floor(llllllllllllllIIIlIlIIllllIIllIl.minX);
        final int llllllllllllllIIIlIlIIllllIIlIll = MathHelper.ceil(llllllllllllllIIIlIlIIllllIIllIl.maxX);
        final int llllllllllllllIIIlIlIIllllIIlIlI = MathHelper.floor(llllllllllllllIIIlIlIIllllIIllIl.maxY);
        final int llllllllllllllIIIlIlIIllllIIlIIl = MathHelper.ceil(llllllllllllllIIIlIlIIllllIIllIl.maxY - this.lastYd);
        final int llllllllllllllIIIlIlIIllllIIlIII = MathHelper.floor(llllllllllllllIIIlIlIIllllIIllIl.minZ);
        final int llllllllllllllIIIlIlIIllllIIIlll = MathHelper.ceil(llllllllllllllIIIlIlIIllllIIllIl.maxZ);
        final BlockPos.PooledMutableBlockPos llllllllllllllIIIlIlIIllllIIIllI = BlockPos.PooledMutableBlockPos.retain();
        try {
            int llllllllllllllIIIlIlIIllllIIIlIl = llllllllllllllIIIlIlIIllllIIlIlI;
        Label_0203_Outer:
            while (llllllllllllllIIIlIlIIllllIIIlIl < llllllllllllllIIIlIlIIllllIIlIIl) {
                float llllllllllllllIIIlIlIIllllIIIlII = 0.0f;
                int llllllllllllllIIIlIlIIllllIIIIll = llllllllllllllIIIlIlIIllllIIllII;
            Label_0203:
                while (true) {
                    while (llllllllllllllIIIlIlIIllllIIIIll < llllllllllllllIIIlIlIIllllIIlIll) {
                        for (int llllllllllllllIIIlIlIIllllIIIIIl = llllllllllllllIIIlIlIIllllIIlIII; llllllllllllllIIIlIlIIllllIIIIIl < llllllllllllllIIIlIlIIllllIIIlll; ++llllllllllllllIIIlIlIIllllIIIIIl) {
                            llllllllllllllIIIlIlIIllllIIIllI.setPos(llllllllllllllIIIlIlIIllllIIIIll, llllllllllllllIIIlIlIIllllIIIlIl, llllllllllllllIIIlIlIIllllIIIIIl);
                            final IBlockState llllllllllllllIIIlIlIIllllIIIIII = this.world.getBlockState(llllllllllllllIIIlIlIIllllIIIllI);
                            if (llllllllllllllIIIlIlIIllllIIIIII.getMaterial() == Material.WATER) {
                                llllllllllllllIIIlIlIIllllIIIlII = Math.max(llllllllllllllIIIlIlIIllllIIIlII, BlockLiquid.func_190973_f(llllllllllllllIIIlIlIIllllIIIIII, this.world, llllllllllllllIIIlIlIIllllIIIllI));
                            }
                            if (llllllllllllllIIIlIlIIllllIIIlII >= 1.0f) {
                                break Label_0203;
                            }
                        }
                        ++llllllllllllllIIIlIlIIllllIIIIll;
                        continue Label_0203_Outer;
                        ++llllllllllllllIIIlIlIIllllIIIlIl;
                        continue Label_0203_Outer;
                    }
                    if (llllllllllllllIIIlIlIIllllIIIlII < 1.0f) {
                        final double llllllllllllllIIIlIlIIlllIlIllll;
                        final float llllllllllllllIIIlIlIIllllIIIIlI = (float)(llllllllllllllIIIlIlIIlllIlIllll = llllllllllllllIIIlIlIIllllIIIllI.getY() + llllllllllllllIIIlIlIIllllIIIlII);
                        return (float)llllllllllllllIIIlIlIIlllIlIllll;
                    }
                    continue Label_0203;
                }
            }
            double llllllllllllllIIIlIlIIlllIlIllll;
            final float llllllllllllllIIIlIlIIlllIllllll = (float)(llllllllllllllIIIlIlIIlllIlIllll = (float)(llllllllllllllIIIlIlIIllllIIlIIl + 1));
            return (float)llllllllllllllIIIlIlIIlllIlIllll;
        }
        finally {
            llllllllllllllIIIlIlIIllllIIIllI.release();
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBox(final Entity llllllllllllllIIIlIlIlIIIlIllIlI) {
        return llllllllllllllIIIlIlIlIIIlIllIlI.canBePushed() ? llllllllllllllIIIlIlIlIIIlIllIlI.getEntityBoundingBox() : null;
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityBoat.TIME_SINCE_HIT, 0);
        this.dataManager.register(EntityBoat.FORWARD_DIRECTION, 1);
        this.dataManager.register(EntityBoat.DAMAGE_TAKEN, 0.0f);
        this.dataManager.register(EntityBoat.BOAT_TYPE, Type.OAK.ordinal());
        final int llllllllllllllIIIlIlIlIIIlIlllIl;
        final Exception llllllllllllllIIIlIlIlIIIlIllllI = (Exception)((DataParameter<Boolean>[])(Object)(llllllllllllllIIIlIlIlIIIlIlllIl = (int)(Object)EntityBoat.DATA_ID_PADDLE)).length;
        for (char llllllllllllllIIIlIlIlIIIlIlllll = '\0'; llllllllllllllIIIlIlIlIIIlIlllll < llllllllllllllIIIlIlIlIIIlIllllI; ++llllllllllllllIIIlIlIlIIIlIlllll) {
            final DataParameter<Boolean> llllllllllllllIIIlIlIlIIIllIIIlI = llllllllllllllIIIlIlIlIIIlIlllIl[llllllllllllllIIIlIlIlIIIlIlllll];
            this.dataManager.register(llllllllllllllIIIlIlIlIIIllIIIlI, false);
        }
    }
    
    @Nullable
    @Override
    public Entity getControllingPassenger() {
        final List<Entity> llllllllllllllIIIlIlIIlIlIIIIIll = this.getPassengers();
        return llllllllllllllIIIlIlIIlIlIIIIIll.isEmpty() ? null : llllllllllllllIIIlIlIIlIlIIIIIll.get(0);
    }
    
    public void updateInputs(final boolean llllllllllllllIIIlIlIIlIIllllIlI, final boolean llllllllllllllIIIlIlIIlIIllllIIl, final boolean llllllllllllllIIIlIlIIlIIlllIIll, final boolean llllllllllllllIIIlIlIIlIIlllIlll) {
        this.leftInputDown = llllllllllllllIIIlIlIIlIIllllIlI;
        this.rightInputDown = llllllllllllllIIIlIlIIlIIllllIIl;
        this.forwardInputDown = llllllllllllllIIIlIlIIlIIlllIIll;
        this.backInputDown = llllllllllllllIIIlIlIIlIIlllIlll;
    }
    
    public boolean getPaddleState(final int llllllllllllllIIIlIlIIlIlIllIIIl) {
        return this.dataManager.get(EntityBoat.DATA_ID_PADDLE[llllllllllllllIIIlIlIIlIlIllIIIl]) && this.getControllingPassenger() != null;
    }
    
    public float getBoatGlide() {
        final AxisAlignedBB llllllllllllllIIIlIlIIlllIIllIlI = this.getEntityBoundingBox();
        final AxisAlignedBB llllllllllllllIIIlIlIIlllIIllIIl = new AxisAlignedBB(llllllllllllllIIIlIlIIlllIIllIlI.minX, llllllllllllllIIIlIlIIlllIIllIlI.minY - 0.001, llllllllllllllIIIlIlIIlllIIllIlI.minZ, llllllllllllllIIIlIlIIlllIIllIlI.maxX, llllllllllllllIIIlIlIIlllIIllIlI.minY, llllllllllllllIIIlIlIIlllIIllIlI.maxZ);
        final int llllllllllllllIIIlIlIIlllIIllIII = MathHelper.floor(llllllllllllllIIIlIlIIlllIIllIIl.minX) - 1;
        final int llllllllllllllIIIlIlIIlllIIlIlll = MathHelper.ceil(llllllllllllllIIIlIlIIlllIIllIIl.maxX) + 1;
        final int llllllllllllllIIIlIlIIlllIIlIllI = MathHelper.floor(llllllllllllllIIIlIlIIlllIIllIIl.minY) - 1;
        final int llllllllllllllIIIlIlIIlllIIlIlIl = MathHelper.ceil(llllllllllllllIIIlIlIIlllIIllIIl.maxY) + 1;
        final int llllllllllllllIIIlIlIIlllIIlIlII = MathHelper.floor(llllllllllllllIIIlIlIIlllIIllIIl.minZ) - 1;
        final int llllllllllllllIIIlIlIIlllIIlIIll = MathHelper.ceil(llllllllllllllIIIlIlIIlllIIllIIl.maxZ) + 1;
        final List<AxisAlignedBB> llllllllllllllIIIlIlIIlllIIlIIlI = (List<AxisAlignedBB>)Lists.newArrayList();
        float llllllllllllllIIIlIlIIlllIIlIIIl = 0.0f;
        int llllllllllllllIIIlIlIIlllIIlIIII = 0;
        final BlockPos.PooledMutableBlockPos llllllllllllllIIIlIlIIlllIIIllll = BlockPos.PooledMutableBlockPos.retain();
        try {
            for (int llllllllllllllIIIlIlIIlllIIIlllI = llllllllllllllIIIlIlIIlllIIllIII; llllllllllllllIIIlIlIIlllIIIlllI < llllllllllllllIIIlIlIIlllIIlIlll; ++llllllllllllllIIIlIlIIlllIIIlllI) {
                for (int llllllllllllllIIIlIlIIlllIIIllIl = llllllllllllllIIIlIlIIlllIIlIlII; llllllllllllllIIIlIlIIlllIIIllIl < llllllllllllllIIIlIlIIlllIIlIIll; ++llllllllllllllIIIlIlIIlllIIIllIl) {
                    final int llllllllllllllIIIlIlIIlllIIIllII = ((llllllllllllllIIIlIlIIlllIIIlllI == llllllllllllllIIIlIlIIlllIIllIII || llllllllllllllIIIlIlIIlllIIIlllI == llllllllllllllIIIlIlIIlllIIlIlll - 1) + (llllllllllllllIIIlIlIIlllIIIllIl == llllllllllllllIIIlIlIIlllIIlIlII || llllllllllllllIIIlIlIIlllIIIllIl == llllllllllllllIIIlIlIIlllIIlIIll - 1)) ? 1 : 0;
                    if (llllllllllllllIIIlIlIIlllIIIllII != 2) {
                        for (int llllllllllllllIIIlIlIIlllIIIlIll = llllllllllllllIIIlIlIIlllIIlIllI; llllllllllllllIIIlIlIIlllIIIlIll < llllllllllllllIIIlIlIIlllIIlIlIl; ++llllllllllllllIIIlIlIIlllIIIlIll) {
                            if (llllllllllllllIIIlIlIIlllIIIllII <= 0 || (llllllllllllllIIIlIlIIlllIIIlIll != llllllllllllllIIIlIlIIlllIIlIllI && llllllllllllllIIIlIlIIlllIIIlIll != llllllllllllllIIIlIlIIlllIIlIlIl - 1)) {
                                llllllllllllllIIIlIlIIlllIIIllll.setPos(llllllllllllllIIIlIlIIlllIIIlllI, llllllllllllllIIIlIlIIlllIIIlIll, llllllllllllllIIIlIlIIlllIIIllIl);
                                final IBlockState llllllllllllllIIIlIlIIlllIIIlIlI = this.world.getBlockState(llllllllllllllIIIlIlIIlllIIIllll);
                                llllllllllllllIIIlIlIIlllIIIlIlI.addCollisionBoxToList(this.world, llllllllllllllIIIlIlIIlllIIIllll, llllllllllllllIIIlIlIIlllIIllIIl, llllllllllllllIIIlIlIIlllIIlIIlI, this, false);
                                if (!llllllllllllllIIIlIlIIlllIIlIIlI.isEmpty()) {
                                    llllllllllllllIIIlIlIIlllIIlIIIl += llllllllllllllIIIlIlIIlllIIIlIlI.getBlock().slipperiness;
                                    ++llllllllllllllIIIlIlIIlllIIlIIII;
                                }
                                llllllllllllllIIIlIlIIlllIIlIIlI.clear();
                            }
                        }
                    }
                }
            }
        }
        finally {
            llllllllllllllIIIlIlIIlllIIIllll.release();
        }
        llllllllllllllIIIlIlIIlllIIIllll.release();
        return llllllllllllllIIIlIlIIlllIIlIIIl / llllllllllllllIIIlIlIIlllIIlIIII;
    }
    
    public void setPaddleState(final boolean llllllllllllllIIIlIlIIllllllIlIl, final boolean llllllllllllllIIIlIlIIllllllIIIl) {
        this.dataManager.set(EntityBoat.DATA_ID_PADDLE[0], llllllllllllllIIIlIlIIllllllIlIl);
        this.dataManager.set(EntityBoat.DATA_ID_PADDLE[1], llllllllllllllIIIlIlIIllllllIIIl);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public void setTimeSinceHit(final int llllllllllllllIIIlIlIIlIlIlIIIlI) {
        this.dataManager.set(EntityBoat.TIME_SINCE_HIT, llllllllllllllIIIlIlIIlIlIlIIIlI);
    }
    
    private boolean checkInWater() {
        final AxisAlignedBB llllllllllllllIIIlIlIIllIllIIlIl = this.getEntityBoundingBox();
        final int llllllllllllllIIIlIlIIllIllIIlII = MathHelper.floor(llllllllllllllIIIlIlIIllIllIIlIl.minX);
        final int llllllllllllllIIIlIlIIllIllIIIll = MathHelper.ceil(llllllllllllllIIIlIlIIllIllIIlIl.maxX);
        final int llllllllllllllIIIlIlIIllIllIIIlI = MathHelper.floor(llllllllllllllIIIlIlIIllIllIIlIl.minY);
        final int llllllllllllllIIIlIlIIllIllIIIIl = MathHelper.ceil(llllllllllllllIIIlIlIIllIllIIlIl.minY + 0.001);
        final int llllllllllllllIIIlIlIIllIllIIIII = MathHelper.floor(llllllllllllllIIIlIlIIllIllIIlIl.minZ);
        final int llllllllllllllIIIlIlIIllIlIlllll = MathHelper.ceil(llllllllllllllIIIlIlIIllIllIIlIl.maxZ);
        boolean llllllllllllllIIIlIlIIllIlIllllI = false;
        this.waterLevel = Double.MIN_VALUE;
        final BlockPos.PooledMutableBlockPos llllllllllllllIIIlIlIIllIlIlllIl = BlockPos.PooledMutableBlockPos.retain();
        try {
            for (int llllllllllllllIIIlIlIIllIlIlllII = llllllllllllllIIIlIlIIllIllIIlII; llllllllllllllIIIlIlIIllIlIlllII < llllllllllllllIIIlIlIIllIllIIIll; ++llllllllllllllIIIlIlIIllIlIlllII) {
                for (int llllllllllllllIIIlIlIIllIlIllIll = llllllllllllllIIIlIlIIllIllIIIlI; llllllllllllllIIIlIlIIllIlIllIll < llllllllllllllIIIlIlIIllIllIIIIl; ++llllllllllllllIIIlIlIIllIlIllIll) {
                    for (int llllllllllllllIIIlIlIIllIlIllIlI = llllllllllllllIIIlIlIIllIllIIIII; llllllllllllllIIIlIlIIllIlIllIlI < llllllllllllllIIIlIlIIllIlIlllll; ++llllllllllllllIIIlIlIIllIlIllIlI) {
                        llllllllllllllIIIlIlIIllIlIlllIl.setPos(llllllllllllllIIIlIlIIllIlIlllII, llllllllllllllIIIlIlIIllIlIllIll, llllllllllllllIIIlIlIIllIlIllIlI);
                        final IBlockState llllllllllllllIIIlIlIIllIlIllIIl = this.world.getBlockState(llllllllllllllIIIlIlIIllIlIlllIl);
                        if (llllllllllllllIIIlIlIIllIlIllIIl.getMaterial() == Material.WATER) {
                            final float llllllllllllllIIIlIlIIllIlIllIII = BlockLiquid.func_190972_g(llllllllllllllIIIlIlIIllIlIllIIl, this.world, llllllllllllllIIIlIlIIllIlIlllIl);
                            this.waterLevel = Math.max(llllllllllllllIIIlIlIIllIlIllIII, this.waterLevel);
                            llllllllllllllIIIlIlIIllIlIllllI |= (llllllllllllllIIIlIlIIllIllIIlIl.minY < llllllllllllllIIIlIlIIllIlIllIII);
                        }
                    }
                }
            }
        }
        finally {
            llllllllllllllIIIlIlIIllIlIlllIl.release();
        }
        llllllllllllllIIIlIlIIllIlIlllIl.release();
        return llllllllllllllIIIlIlIIllIlIllllI;
    }
    
    @Override
    public void setPositionAndRotationDirect(final double llllllllllllllIIIlIlIlIIIIllIIIl, final double llllllllllllllIIIlIlIlIIIIllIIII, final double llllllllllllllIIIlIlIlIIIIlIllll, final float llllllllllllllIIIlIlIlIIIIlIIllI, final float llllllllllllllIIIlIlIlIIIIlIIlIl, final int llllllllllllllIIIlIlIlIIIIlIllII, final boolean llllllllllllllIIIlIlIlIIIIlIlIll) {
        this.boatPitch = llllllllllllllIIIlIlIlIIIIllIIIl;
        this.lerpY = llllllllllllllIIIlIlIlIIIIllIIII;
        this.lerpZ = llllllllllllllIIIlIlIlIIIIlIllll;
        this.boatYaw = llllllllllllllIIIlIlIlIIIIlIIllI;
        this.lerpXRot = llllllllllllllIIIlIlIlIIIIlIIlIl;
        this.lerpSteps = 10;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Type() {
        final int[] $switch_TABLE$net$minecraft$entity$item$EntityBoat$Type = EntityBoat.$SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Type;
        if ($switch_TABLE$net$minecraft$entity$item$EntityBoat$Type != null) {
            return $switch_TABLE$net$minecraft$entity$item$EntityBoat$Type;
        }
        final char llllllllllllllIIIlIlIIlIIlllIIII = (Object)new int[Type.values().length];
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIlIlIIlIIlllIIII[Type.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EntityBoat.$SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Type = (int[])(Object)llllllllllllllIIIlIlIIlIIlllIIII;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIlIlIIlIllIlIIIl) {
        llllllllllllllIIIlIlIIlIllIlIIIl.setString("Type", this.getBoatType().getName());
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIlIlIIlIllIIlIll) {
        if (llllllllllllllIIIlIlIIlIllIIlIll.hasKey("Type", 8)) {
            this.setBoatType(Type.getTypeFromString(llllllllllllllIIIlIlIIlIllIIlIll.getString("Type")));
        }
    }
    
    private void controlBoat() {
        if (this.isBeingRidden()) {
            float llllllllllllllIIIlIlIIlIlllllllI = 0.0f;
            if (this.leftInputDown) {
                --this.deltaRotation;
            }
            if (this.rightInputDown) {
                ++this.deltaRotation;
            }
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown) {
                llllllllllllllIIIlIlIIlIlllllllI += 0.005f;
            }
            this.rotationYaw += this.deltaRotation;
            if (this.forwardInputDown) {
                llllllllllllllIIIlIlIIlIlllllllI += 0.04f;
            }
            if (this.backInputDown) {
                llllllllllllllIIIlIlIIlIlllllllI -= 0.005f;
            }
            this.motionX += MathHelper.sin(-this.rotationYaw * 0.017453292f) * llllllllllllllIIIlIlIIlIlllllllI;
            this.motionZ += MathHelper.cos(this.rotationYaw * 0.017453292f) * llllllllllllllIIIlIlIIlIlllllllI;
            this.setPaddleState((this.rightInputDown && !this.leftInputDown) || this.forwardInputDown, (this.leftInputDown && !this.rightInputDown) || this.forwardInputDown);
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIIlIlIlIIIlIIlllI, final float llllllllllllllIIIlIlIlIIIlIIllIl) {
        if (this.isEntityInvulnerable(llllllllllllllIIIlIlIlIIIlIIlllI)) {
            return false;
        }
        if (this.world.isRemote || this.isDead) {
            return true;
        }
        if (llllllllllllllIIIlIlIlIIIlIIlllI instanceof EntityDamageSourceIndirect && llllllllllllllIIIlIlIlIIIlIIlllI.getEntity() != null && this.isPassenger(llllllllllllllIIIlIlIlIIIlIIlllI.getEntity())) {
            return false;
        }
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() + llllllllllllllIIIlIlIlIIIlIIllIl * 10.0f);
        this.setBeenAttacked();
        final boolean llllllllllllllIIIlIlIlIIIlIIllII = llllllllllllllIIIlIlIlIIIlIIlllI.getEntity() instanceof EntityPlayer && ((EntityPlayer)llllllllllllllIIIlIlIlIIIlIIlllI.getEntity()).capabilities.isCreativeMode;
        if (llllllllllllllIIIlIlIlIIIlIIllII || this.getDamageTaken() > 40.0f) {
            if (!llllllllllllllIIIlIlIlIIIlIIllII && this.world.getGameRules().getBoolean("doEntityDrops")) {
                this.dropItemWithOffset(this.getItemBoat(), 1, 0.0f);
            }
            this.setDead();
        }
        return true;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    public void setForwardDirection(final int llllllllllllllIIIlIlIIlIlIIlIlll) {
        this.dataManager.set(EntityBoat.FORWARD_DIRECTION, llllllllllllllIIIlIlIIlIlIIlIlll);
    }
    
    @Override
    public EnumFacing getAdjustedHorizontalFacing() {
        return this.getHorizontalFacing().rotateY();
    }
    
    @Override
    public boolean canBePushed() {
        return true;
    }
    
    private void updateMotion() {
        final double llllllllllllllIIIlIlIIllIIIIllII = -0.03999999910593033;
        double llllllllllllllIIIlIlIIllIIIIlIll = this.hasNoGravity() ? 0.0 : -0.03999999910593033;
        double llllllllllllllIIIlIlIIllIIIIlIlI = 0.0;
        this.momentum = 0.05f;
        if (this.previousStatus == Status.IN_AIR && this.status != Status.IN_AIR && this.status != Status.ON_LAND) {
            this.waterLevel = this.getEntityBoundingBox().minY + this.height;
            this.setPosition(this.posX, this.getWaterLevelAbove() - this.height + 0.101, this.posZ);
            this.motionY = 0.0;
            this.lastYd = 0.0;
            this.status = Status.IN_WATER;
        }
        else {
            if (this.status == Status.IN_WATER) {
                llllllllllllllIIIlIlIIllIIIIlIlI = (this.waterLevel - this.getEntityBoundingBox().minY) / this.height;
                this.momentum = 0.9f;
            }
            else if (this.status == Status.UNDER_FLOWING_WATER) {
                llllllllllllllIIIlIlIIllIIIIlIll = -7.0E-4;
                this.momentum = 0.9f;
            }
            else if (this.status == Status.UNDER_WATER) {
                llllllllllllllIIIlIlIIllIIIIlIlI = 0.009999999776482582;
                this.momentum = 0.45f;
            }
            else if (this.status == Status.IN_AIR) {
                this.momentum = 0.9f;
            }
            else if (this.status == Status.ON_LAND) {
                this.momentum = this.boatGlide;
                if (this.getControllingPassenger() instanceof EntityPlayer) {
                    this.boatGlide /= 2.0f;
                }
            }
            this.motionX *= this.momentum;
            this.motionZ *= this.momentum;
            this.deltaRotation *= this.momentum;
            this.motionY += llllllllllllllIIIlIlIIllIIIIlIll;
            if (llllllllllllllIIIlIlIIllIIIIlIlI > 0.0) {
                final double llllllllllllllIIIlIlIIllIIIIlIIl = 0.65;
                this.motionY += llllllllllllllIIIlIlIIllIIIIlIlI * 0.06153846016296973;
                final double llllllllllllllIIIlIlIIllIIIIlIII = 0.75;
                this.motionY *= 0.75;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Status() {
        final int[] $switch_TABLE$net$minecraft$entity$item$EntityBoat$Status = EntityBoat.$SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Status;
        if ($switch_TABLE$net$minecraft$entity$item$EntityBoat$Status != null) {
            return $switch_TABLE$net$minecraft$entity$item$EntityBoat$Status;
        }
        final float llllllllllllllIIIlIlIIlIIllIlllI = (Object)new int[Status.values().length];
        try {
            llllllllllllllIIIlIlIIlIIllIlllI[Status.IN_AIR.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIlIlIIlIIllIlllI[Status.IN_WATER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIlIlIIlIIllIlllI[Status.ON_LAND.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIlIlIIlIIllIlllI[Status.UNDER_FLOWING_WATER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIlIlIIlIIllIlllI[Status.UNDER_WATER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return EntityBoat.$SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Status = (int[])(Object)llllllllllllllIIIlIlIIlIIllIlllI;
    }
    
    public float getDamageTaken() {
        return this.dataManager.get(EntityBoat.DAMAGE_TAKEN);
    }
    
    private void tickLerp() {
        if (this.lerpSteps > 0 && !this.canPassengerSteer()) {
            final double llllllllllllllIIIlIlIlIIIIIIIIlI = this.posX + (this.boatPitch - this.posX) / this.lerpSteps;
            final double llllllllllllllIIIlIlIlIIIIIIIIIl = this.posY + (this.lerpY - this.posY) / this.lerpSteps;
            final double llllllllllllllIIIlIlIlIIIIIIIIII = this.posZ + (this.lerpZ - this.posZ) / this.lerpSteps;
            final double llllllllllllllIIIlIlIIllllllllll = MathHelper.wrapDegrees(this.boatYaw - this.rotationYaw);
            this.rotationYaw += (float)(llllllllllllllIIIlIlIIllllllllll / this.lerpSteps);
            this.rotationPitch += (float)((this.lerpXRot - this.rotationPitch) / this.lerpSteps);
            --this.lerpSteps;
            this.setPosition(llllllllllllllIIIlIlIlIIIIIIIIlI, llllllllllllllIIIlIlIlIIIIIIIIIl, llllllllllllllIIIlIlIlIIIIIIIIII);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer llllllllllllllIIIlIlIIlIllIIIlII, final EnumHand llllllllllllllIIIlIlIIlIllIIIllI) {
        if (llllllllllllllIIIlIlIIlIllIIIlII.isSneaking()) {
            return false;
        }
        if (!this.world.isRemote && this.outOfControlTicks < 60.0f) {
            llllllllllllllIIIlIlIIlIllIIIlII.startRiding(this);
        }
        return true;
    }
    
    public EntityBoat(final World llllllllllllllIIIlIlIlIIIllIllIl, final double llllllllllllllIIIlIlIlIIIlllIIIl, final double llllllllllllllIIIlIlIlIIIlllIIII, final double llllllllllllllIIIlIlIlIIIllIllll) {
        this(llllllllllllllIIIlIlIlIIIllIllIl);
        this.setPosition(llllllllllllllIIIlIlIlIIIlllIIIl, llllllllllllllIIIlIlIlIIIlllIIII, llllllllllllllIIIlIlIlIIIllIllll);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = llllllllllllllIIIlIlIlIIIlllIIIl;
        this.prevPosY = llllllllllllllIIIlIlIlIIIlllIIII;
        this.prevPosZ = llllllllllllllIIIlIlIlIIIllIllll;
    }
    
    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }
    
    @Override
    public void onUpdate() {
        this.previousStatus = this.status;
        this.status = this.getBoatStatus();
        if (this.status != Status.UNDER_WATER && this.status != Status.UNDER_FLOWING_WATER) {
            this.outOfControlTicks = 0.0f;
        }
        else {
            ++this.outOfControlTicks;
        }
        if (!this.world.isRemote && this.outOfControlTicks >= 60.0f) {
            this.removePassengers();
        }
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        super.onUpdate();
        this.tickLerp();
        if (this.canPassengerSteer()) {
            if (this.getPassengers().isEmpty() || !(this.getPassengers().get(0) instanceof EntityPlayer)) {
                this.setPaddleState(false, false);
            }
            this.updateMotion();
            if (this.world.isRemote) {
                this.controlBoat();
                this.world.sendPacketToServer(new CPacketSteerBoat(this.getPaddleState(0), this.getPaddleState(1)));
            }
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }
        else {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
        }
        for (int llllllllllllllIIIlIlIlIIIIIllIlI = 0; llllllllllllllIIIlIlIlIIIIIllIlI <= 1; ++llllllllllllllIIIlIlIlIIIIIllIlI) {
            if (this.getPaddleState(llllllllllllllIIIlIlIlIIIIIllIlI)) {
                if (!this.isSilent() && this.paddlePositions[llllllllllllllIIIlIlIlIIIIIllIlI] % 6.2831855f <= 0.7853981633974483 && (this.paddlePositions[llllllllllllllIIIlIlIlIIIIIllIlI] + 0.39269909262657166) % 6.283185307179586 >= 0.7853981633974483) {
                    final SoundEvent llllllllllllllIIIlIlIlIIIIIllIIl = this.func_193047_k();
                    if (llllllllllllllIIIlIlIlIIIIIllIIl != null) {
                        final Vec3d llllllllllllllIIIlIlIlIIIIIllIII = this.getLook(1.0f);
                        final double llllllllllllllIIIlIlIlIIIIIlIlll = (llllllllllllllIIIlIlIlIIIIIllIlI == 1) ? (-llllllllllllllIIIlIlIlIIIIIllIII.zCoord) : llllllllllllllIIIlIlIlIIIIIllIII.zCoord;
                        final double llllllllllllllIIIlIlIlIIIIIlIllI = (llllllllllllllIIIlIlIlIIIIIllIlI == 1) ? llllllllllllllIIIlIlIlIIIIIllIII.xCoord : (-llllllllllllllIIIlIlIlIIIIIllIII.xCoord);
                        this.world.playSound(null, this.posX + llllllllllllllIIIlIlIlIIIIIlIlll, this.posY, this.posZ + llllllllllllllIIIlIlIlIIIIIlIllI, llllllllllllllIIIlIlIlIIIIIllIIl, this.getSoundCategory(), 1.0f, 0.8f + 0.4f * this.rand.nextFloat());
                    }
                }
                this.paddlePositions[llllllllllllllIIIlIlIlIIIIIllIlI] += 0.39269909262657166;
            }
            else {
                this.paddlePositions[llllllllllllllIIIlIlIlIIIIIllIlI] = 0.0f;
            }
        }
        this.doBlockCollisions();
        final List<Entity> llllllllllllllIIIlIlIlIIIIIlIlIl = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224, -0.009999999776482582, 0.20000000298023224), EntitySelectors.getTeamCollisionPredicate(this));
        if (!llllllllllllllIIIlIlIlIIIIIlIlIl.isEmpty()) {
            final boolean llllllllllllllIIIlIlIlIIIIIlIlII = !this.world.isRemote && !(this.getControllingPassenger() instanceof EntityPlayer);
            for (int llllllllllllllIIIlIlIlIIIIIlIIll = 0; llllllllllllllIIIlIlIlIIIIIlIIll < llllllllllllllIIIlIlIlIIIIIlIlIl.size(); ++llllllllllllllIIIlIlIlIIIIIlIIll) {
                final Entity llllllllllllllIIIlIlIlIIIIIlIIlI = llllllllllllllIIIlIlIlIIIIIlIlIl.get(llllllllllllllIIIlIlIlIIIIIlIIll);
                if (!llllllllllllllIIIlIlIlIIIIIlIIlI.isPassenger(this)) {
                    if (llllllllllllllIIIlIlIlIIIIIlIlII && this.getPassengers().size() < 2 && !llllllllllllllIIIlIlIlIIIIIlIIlI.isRiding() && llllllllllllllIIIlIlIlIIIIIlIIlI.width < this.width && llllllllllllllIIIlIlIlIIIIIlIIlI instanceof EntityLivingBase && !(llllllllllllllIIIlIlIlIIIIIlIIlI instanceof EntityWaterMob) && !(llllllllllllllIIIlIlIlIIIIIlIIlI instanceof EntityPlayer)) {
                        llllllllllllllIIIlIlIlIIIIIlIIlI.startRiding(this);
                    }
                    else {
                        this.applyEntityCollision(llllllllllllllIIIlIlIlIIIIIlIIlI);
                    }
                }
            }
        }
    }
    
    private Status getBoatStatus() {
        final Status llllllllllllllIIIlIlIIlllllIIIll = this.getUnderwaterStatus();
        if (llllllllllllllIIIlIlIIlllllIIIll != null) {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return llllllllllllllIIIlIlIIlllllIIIll;
        }
        if (this.checkInWater()) {
            return Status.IN_WATER;
        }
        final float llllllllllllllIIIlIlIIlllllIIIlI = this.getBoatGlide();
        if (llllllllllllllIIIlIlIIlllllIIIlI > 0.0f) {
            this.boatGlide = llllllllllllllIIIlIlIIlllllIIIlI;
            return Status.ON_LAND;
        }
        return Status.IN_AIR;
    }
    
    @Override
    protected boolean canFitPassenger(final Entity llllllllllllllIIIlIlIIlIlIIIlIII) {
        return this.getPassengers().size() < 2;
    }
    
    public int getTimeSinceHit() {
        return this.dataManager.get(EntityBoat.TIME_SINCE_HIT);
    }
    
    @Override
    public double getMountedYOffset() {
        return -0.1;
    }
    
    public int getForwardDirection() {
        return this.dataManager.get(EntityBoat.FORWARD_DIRECTION);
    }
    
    @Nullable
    protected SoundEvent func_193047_k() {
        switch ($SWITCH_TABLE$net$minecraft$entity$item$EntityBoat$Status()[this.getBoatStatus().ordinal()]) {
            case 1:
            case 2:
            case 3: {
                return SoundEvents.field_193779_I;
            }
            case 4: {
                return SoundEvents.field_193778_H;
            }
            default: {
                return null;
            }
        }
    }
    
    public float getRowingTime(final int llllllllllllllIIIlIlIIlllllIllII, final float llllllllllllllIIIlIlIIlllllIlIII) {
        return this.getPaddleState(llllllllllllllIIIlIlIIlllllIllII) ? ((float)MathHelper.clampedLerp(this.paddlePositions[llllllllllllllIIIlIlIIlllllIllII] - 0.39269909262657166, this.paddlePositions[llllllllllllllIIIlIlIIlllllIllII], llllllllllllllIIIlIlIIlllllIlIII)) : 0.0f;
    }
    
    public Type getBoatType() {
        return Type.byId(this.dataManager.get(EntityBoat.BOAT_TYPE));
    }
    
    protected void applyYawToEntity(final Entity llllllllllllllIIIlIlIIlIllIlllll) {
        llllllllllllllIIIlIlIIlIllIlllll.setRenderYawOffset(this.rotationYaw);
        final float llllllllllllllIIIlIlIIlIlllIIIlI = MathHelper.wrapDegrees(llllllllllllllIIIlIlIIlIllIlllll.rotationYaw - this.rotationYaw);
        final float llllllllllllllIIIlIlIIlIlllIIIIl = MathHelper.clamp(llllllllllllllIIIlIlIIlIlllIIIlI, -105.0f, 105.0f);
        llllllllllllllIIIlIlIIlIllIlllll.prevRotationYaw += llllllllllllllIIIlIlIIlIlllIIIIl - llllllllllllllIIIlIlIIlIlllIIIlI;
        llllllllllllllIIIlIlIIlIllIlllll.rotationYaw += llllllllllllllIIIlIlIIlIlllIIIIl - llllllllllllllIIIlIlIIlIlllIIIlI;
        llllllllllllllIIIlIlIIlIllIlllll.setRotationYawHead(llllllllllllllIIIlIlIIlIllIlllll.rotationYaw);
    }
    
    public enum Status
    {
        UNDER_WATER("UNDER_WATER", 1), 
        IN_AIR("IN_AIR", 4), 
        UNDER_FLOWING_WATER("UNDER_FLOWING_WATER", 2), 
        ON_LAND("ON_LAND", 3), 
        IN_WATER("IN_WATER", 0);
        
        private Status(final String lllllllllllllIIlIIIIlIlIIIIIllIl, final int lllllllllllllIIlIIIIlIlIIIIIllII) {
        }
    }
    
    public enum Type
    {
        DARK_OAK("DARK_OAK", 5, BlockPlanks.EnumType.DARK_OAK.getMetadata(), "dark_oak"), 
        BIRCH("BIRCH", 2, BlockPlanks.EnumType.BIRCH.getMetadata(), "birch");
        
        private final /* synthetic */ String name;
        
        JUNGLE("JUNGLE", 3, BlockPlanks.EnumType.JUNGLE.getMetadata(), "jungle");
        
        private final /* synthetic */ int metadata;
        
        SPRUCE("SPRUCE", 1, BlockPlanks.EnumType.SPRUCE.getMetadata(), "spruce"), 
        ACACIA("ACACIA", 4, BlockPlanks.EnumType.ACACIA.getMetadata(), "acacia"), 
        OAK("OAK", 0, BlockPlanks.EnumType.OAK.getMetadata(), "oak");
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static Type byId(int lllllllllllllllllIIlIIIIlIIIIIII) {
            if (lllllllllllllllllIIlIIIIlIIIIIII < 0 || lllllllllllllllllIIlIIIIlIIIIIII >= values().length) {
                lllllllllllllllllIIlIIIIlIIIIIII = 0;
            }
            return values()[lllllllllllllllllIIlIIIIlIIIIIII];
        }
        
        private Type(final String lllllllllllllllllIIlIIIIlIIIllll, final int lllllllllllllllllIIlIIIIlIIIlllI, final int lllllllllllllllllIIlIIIIlIIlIIlI, final String lllllllllllllllllIIlIIIIlIIIllII) {
            this.name = lllllllllllllllllIIlIIIIlIIIllII;
            this.metadata = lllllllllllllllllIIlIIIIlIIlIIlI;
        }
        
        public String getName() {
            return this.name;
        }
        
        public static Type getTypeFromString(final String lllllllllllllllllIIlIIIIIlllllIl) {
            for (int lllllllllllllllllIIlIIIIIlllllII = 0; lllllllllllllllllIIlIIIIIlllllII < values().length; ++lllllllllllllllllIIlIIIIIlllllII) {
                if (values()[lllllllllllllllllIIlIIIIIlllllII].getName().equals(lllllllllllllllllIIlIIIIIlllllIl)) {
                    return values()[lllllllllllllllllIIlIIIIIlllllII];
                }
            }
            return values()[0];
        }
        
        public int getMetadata() {
            return this.metadata;
        }
    }
}
