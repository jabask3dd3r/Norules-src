package net.minecraft.entity.monster;

import net.minecraft.entity.ai.attributes.*;
import net.minecraft.item.*;
import net.minecraft.network.datasync.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.entity.projectile.*;

public class EntityShulker extends EntityGolem implements IMob
{
    private static final /* synthetic */ AttributeModifier COVERED_ARMOR_BONUS_MODIFIER;
    private /* synthetic */ float peekAmount;
    private static final /* synthetic */ UUID COVERED_ARMOR_BONUS_ID;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ DataParameter<EnumFacing> ATTACHED_FACE;
    protected static final /* synthetic */ DataParameter<Optional<BlockPos>> ATTACHED_BLOCK_POS;
    private /* synthetic */ float prevPeekAmount;
    protected static final /* synthetic */ DataParameter<Byte> PEEK_TICK;
    protected static final /* synthetic */ DataParameter<Byte> field_190770_bw;
    public static final /* synthetic */ EnumDyeColor field_190771_bx;
    private /* synthetic */ int clientSideTeleportInterpolation;
    private /* synthetic */ BlockPos currentAttachmentPosition;
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIlIIlIIIllllllIlll, final float lllllllllllllIIlIIlIIIllllllIllI) {
        if (this.isClosed()) {
            final Entity lllllllllllllIIlIIlIIIlllllllIIl = lllllllllllllIIlIIlIIIllllllIlll.getSourceOfDamage();
            if (lllllllllllllIIlIIlIIIlllllllIIl instanceof EntityArrow) {
                return false;
            }
        }
        if (super.attackEntityFrom(lllllllllllllIIlIIlIIIllllllIlll, lllllllllllllIIlIIlIIIllllllIllI)) {
            if (this.getHealth() < this.getMaxHealth() * 0.5 && this.rand.nextInt(4) == 0) {
                this.tryTeleportToNewPosition();
            }
            return true;
        }
        return false;
    }
    
    public EntityShulker(final World lllllllllllllIIlIIlIIlIIllIIIIIl) {
        super(lllllllllllllIIlIIlIIlIIllIIIIIl);
        this.setSize(1.0f, 1.0f);
        this.prevRenderYawOffset = 180.0f;
        this.renderYawOffset = 180.0f;
        this.isImmuneToFire = true;
        this.currentAttachmentPosition = null;
        this.experienceValue = 5;
    }
    
    static {
        COVERED_ARMOR_BONUS_ID = UUID.fromString("7E0292F2-9434-48D5-A29F-9583AF7DF27F");
        COVERED_ARMOR_BONUS_MODIFIER = new AttributeModifier(EntityShulker.COVERED_ARMOR_BONUS_ID, "Covered armor bonus", 20.0, 0).setSaved(false);
        ATTACHED_FACE = EntityDataManager.createKey(EntityShulker.class, DataSerializers.FACING);
        ATTACHED_BLOCK_POS = EntityDataManager.createKey(EntityShulker.class, DataSerializers.OPTIONAL_BLOCK_POS);
        PEEK_TICK = EntityDataManager.createKey(EntityShulker.class, DataSerializers.BYTE);
        field_190770_bw = EntityDataManager.createKey(EntityShulker.class, DataSerializers.BYTE);
        field_190771_bx = EnumDyeColor.PURPLE;
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return 180;
    }
    
    @Override
    public float getCollisionBorderSize() {
        return 0.0f;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0);
    }
    
    @Override
    public void applyEntityCollision(final Entity lllllllllllllIIlIIlIIIllllIIlIIl) {
    }
    
    @Override
    public float getEyeHeight() {
        return 0.5f;
    }
    
    public int getPeekTick() {
        return this.dataManager.get(EntityShulker.PEEK_TICK);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIlIIlIIlIIlIIlIIII) {
        super.readEntityFromNBT(lllllllllllllIIlIIlIIlIIlIIlIIII);
        this.dataManager.set(EntityShulker.ATTACHED_FACE, EnumFacing.getFront(lllllllllllllIIlIIlIIlIIlIIlIIII.getByte("AttachFace")));
        this.dataManager.set(EntityShulker.PEEK_TICK, lllllllllllllIIlIIlIIlIIlIIlIIII.getByte("Peek"));
        this.dataManager.set(EntityShulker.field_190770_bw, lllllllllllllIIlIIlIIlIIlIIlIIII.getByte("Color"));
        if (lllllllllllllIIlIIlIIlIIlIIlIIII.hasKey("APX")) {
            final int lllllllllllllIIlIIlIIlIIlIIlIlII = lllllllllllllIIlIIlIIlIIlIIlIIII.getInteger("APX");
            final int lllllllllllllIIlIIlIIlIIlIIlIIll = lllllllllllllIIlIIlIIlIIlIIlIIII.getInteger("APY");
            final int lllllllllllllIIlIIlIIlIIlIIlIIlI = lllllllllllllIIlIIlIIlIIlIIlIIII.getInteger("APZ");
            this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.of((Object)new BlockPos(lllllllllllllIIlIIlIIlIIlIIlIlII, lllllllllllllIIlIIlIIlIIlIIlIIll, lllllllllllllIIlIIlIIlIIlIIlIIlI)));
        }
        else {
            this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.absent());
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHULKER_AMBIENT;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        BlockPos lllllllllllllIIlIIlIIlIIIlllIIlI = (BlockPos)this.dataManager.get(EntityShulker.ATTACHED_BLOCK_POS).orNull();
        if (lllllllllllllIIlIIlIIlIIIlllIIlI == null && !this.world.isRemote) {
            lllllllllllllIIlIIlIIlIIIlllIIlI = new BlockPos(this);
            this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.of((Object)lllllllllllllIIlIIlIIlIIIlllIIlI));
        }
        if (this.isRiding()) {
            lllllllllllllIIlIIlIIlIIIlllIIlI = null;
            final float lllllllllllllIIlIIlIIlIIIlllIIIl = this.getRidingEntity().rotationYaw;
            this.rotationYaw = lllllllllllllIIlIIlIIlIIIlllIIIl;
            this.renderYawOffset = lllllllllllllIIlIIlIIlIIIlllIIIl;
            this.prevRenderYawOffset = lllllllllllllIIlIIlIIlIIIlllIIIl;
            this.clientSideTeleportInterpolation = 0;
        }
        else if (!this.world.isRemote) {
            final IBlockState lllllllllllllIIlIIlIIlIIIlllIIII = this.world.getBlockState(lllllllllllllIIlIIlIIlIIIlllIIlI);
            if (lllllllllllllIIlIIlIIlIIIlllIIII.getMaterial() != Material.AIR) {
                if (lllllllllllllIIlIIlIIlIIIlllIIII.getBlock() == Blocks.PISTON_EXTENSION) {
                    final EnumFacing lllllllllllllIIlIIlIIlIIIllIllll = lllllllllllllIIlIIlIIlIIIlllIIII.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING);
                    if (this.world.isAirBlock(lllllllllllllIIlIIlIIlIIIlllIIlI.offset(lllllllllllllIIlIIlIIlIIIllIllll))) {
                        lllllllllllllIIlIIlIIlIIIlllIIlI = lllllllllllllIIlIIlIIlIIIlllIIlI.offset(lllllllllllllIIlIIlIIlIIIllIllll);
                        this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.of((Object)lllllllllllllIIlIIlIIlIIIlllIIlI));
                    }
                    else {
                        this.tryTeleportToNewPosition();
                    }
                }
                else if (lllllllllllllIIlIIlIIlIIIlllIIII.getBlock() == Blocks.PISTON_HEAD) {
                    final EnumFacing lllllllllllllIIlIIlIIlIIIllIlllI = lllllllllllllIIlIIlIIlIIIlllIIII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING);
                    if (this.world.isAirBlock(lllllllllllllIIlIIlIIlIIIlllIIlI.offset(lllllllllllllIIlIIlIIlIIIllIlllI))) {
                        lllllllllllllIIlIIlIIlIIIlllIIlI = lllllllllllllIIlIIlIIlIIIlllIIlI.offset(lllllllllllllIIlIIlIIlIIIllIlllI);
                        this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.of((Object)lllllllllllllIIlIIlIIlIIIlllIIlI));
                    }
                    else {
                        this.tryTeleportToNewPosition();
                    }
                }
                else {
                    this.tryTeleportToNewPosition();
                }
            }
            BlockPos lllllllllllllIIlIIlIIlIIIllIllIl = lllllllllllllIIlIIlIIlIIIlllIIlI.offset(this.getAttachmentFacing());
            if (!this.world.isBlockNormalCube(lllllllllllllIIlIIlIIlIIIllIllIl, false)) {
                boolean lllllllllllllIIlIIlIIlIIIllIllII = false;
                final Exception lllllllllllllIIlIIlIIlIIIlIlIlll;
                final boolean lllllllllllllIIlIIlIIlIIIlIllIII = ((EnumFacing[])(Object)(lllllllllllllIIlIIlIIlIIIlIlIlll = (Exception)(Object)EnumFacing.values())).length != 0;
                for (float lllllllllllllIIlIIlIIlIIIlIllIIl = 0; lllllllllllllIIlIIlIIlIIIlIllIIl < (lllllllllllllIIlIIlIIlIIIlIllIII ? 1 : 0); ++lllllllllllllIIlIIlIIlIIIlIllIIl) {
                    final EnumFacing lllllllllllllIIlIIlIIlIIIllIlIll = lllllllllllllIIlIIlIIlIIIlIlIlll[lllllllllllllIIlIIlIIlIIIlIllIIl];
                    lllllllllllllIIlIIlIIlIIIllIllIl = lllllllllllllIIlIIlIIlIIIlllIIlI.offset(lllllllllllllIIlIIlIIlIIIllIlIll);
                    if (this.world.isBlockNormalCube(lllllllllllllIIlIIlIIlIIIllIllIl, false)) {
                        this.dataManager.set(EntityShulker.ATTACHED_FACE, lllllllllllllIIlIIlIIlIIIllIlIll);
                        lllllllllllllIIlIIlIIlIIIllIllII = true;
                        break;
                    }
                }
                if (!lllllllllllllIIlIIlIIlIIIllIllII) {
                    this.tryTeleportToNewPosition();
                }
            }
            final BlockPos lllllllllllllIIlIIlIIlIIIllIlIlI = lllllllllllllIIlIIlIIlIIIlllIIlI.offset(this.getAttachmentFacing().getOpposite());
            if (this.world.isBlockNormalCube(lllllllllllllIIlIIlIIlIIIllIlIlI, false)) {
                this.tryTeleportToNewPosition();
            }
        }
        final float lllllllllllllIIlIIlIIlIIIllIlIIl = this.getPeekTick() * 0.01f;
        this.prevPeekAmount = this.peekAmount;
        if (this.peekAmount > lllllllllllllIIlIIlIIlIIIllIlIIl) {
            this.peekAmount = MathHelper.clamp(this.peekAmount - 0.05f, lllllllllllllIIlIIlIIlIIIllIlIIl, 1.0f);
        }
        else if (this.peekAmount < lllllllllllllIIlIIlIIlIIIllIlIIl) {
            this.peekAmount = MathHelper.clamp(this.peekAmount + 0.05f, 0.0f, lllllllllllllIIlIIlIIlIIIllIlIIl);
        }
        if (lllllllllllllIIlIIlIIlIIIlllIIlI != null) {
            if (this.world.isRemote) {
                if (this.clientSideTeleportInterpolation > 0 && this.currentAttachmentPosition != null) {
                    --this.clientSideTeleportInterpolation;
                }
                else {
                    this.currentAttachmentPosition = lllllllllllllIIlIIlIIlIIIlllIIlI;
                }
            }
            this.posX = lllllllllllllIIlIIlIIlIIIlllIIlI.getX() + 0.5;
            this.posY = lllllllllllllIIlIIlIIlIIIlllIIlI.getY();
            this.posZ = lllllllllllllIIlIIlIIlIIIlllIIlI.getZ() + 0.5;
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.lastTickPosX = this.posX;
            this.lastTickPosY = this.posY;
            this.lastTickPosZ = this.posZ;
            final double lllllllllllllIIlIIlIIlIIIllIlIII = 0.5 - MathHelper.sin((0.5f + this.peekAmount) * 3.1415927f) * 0.5;
            final double lllllllllllllIIlIIlIIlIIIllIIlll = 0.5 - MathHelper.sin((0.5f + this.prevPeekAmount) * 3.1415927f) * 0.5;
            final double lllllllllllllIIlIIlIIlIIIllIIllI = lllllllllllllIIlIIlIIlIIIllIlIII - lllllllllllllIIlIIlIIlIIIllIIlll;
            double lllllllllllllIIlIIlIIlIIIllIIlIl = 0.0;
            double lllllllllllllIIlIIlIIlIIIllIIlII = 0.0;
            double lllllllllllllIIlIIlIIlIIIllIIIll = 0.0;
            final EnumFacing lllllllllllllIIlIIlIIlIIIllIIIlI = this.getAttachmentFacing();
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIlIIlIIlIIIllIIIlI.ordinal()]) {
                case 1: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5, this.posY, this.posZ - 0.5, this.posX + 0.5, this.posY + 1.0 + lllllllllllllIIlIIlIIlIIIllIlIII, this.posZ + 0.5));
                    lllllllllllllIIlIIlIIlIIIllIIlII = lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
                case 2: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5, this.posY - lllllllllllllIIlIIlIIlIIIllIlIII, this.posZ - 0.5, this.posX + 0.5, this.posY + 1.0, this.posZ + 0.5));
                    lllllllllllllIIlIIlIIlIIIllIIlII = -lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
                case 3: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5, this.posY, this.posZ - 0.5, this.posX + 0.5, this.posY + 1.0, this.posZ + 0.5 + lllllllllllllIIlIIlIIlIIIllIlIII));
                    lllllllllllllIIlIIlIIlIIIllIIIll = lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
                case 4: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5, this.posY, this.posZ - 0.5 - lllllllllllllIIlIIlIIlIIIllIlIII, this.posX + 0.5, this.posY + 1.0, this.posZ + 0.5));
                    lllllllllllllIIlIIlIIlIIIllIIIll = -lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
                case 5: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5, this.posY, this.posZ - 0.5, this.posX + 0.5 + lllllllllllllIIlIIlIIlIIIllIlIII, this.posY + 1.0, this.posZ + 0.5));
                    lllllllllllllIIlIIlIIlIIIllIIlIl = lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
                case 6: {
                    this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.5 - lllllllllllllIIlIIlIIlIIIllIlIII, this.posY, this.posZ - 0.5, this.posX + 0.5, this.posY + 1.0, this.posZ + 0.5));
                    lllllllllllllIIlIIlIIlIIIllIIlIl = -lllllllllllllIIlIIlIIlIIIllIIllI;
                    break;
                }
            }
            if (lllllllllllllIIlIIlIIlIIIllIIllI > 0.0) {
                final List<Entity> lllllllllllllIIlIIlIIlIIIllIIIIl = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
                if (!lllllllllllllIIlIIlIIlIIIllIIIIl.isEmpty()) {
                    for (final Entity lllllllllllllIIlIIlIIlIIIllIIIII : lllllllllllllIIlIIlIIlIIIllIIIIl) {
                        if (!(lllllllllllllIIlIIlIIlIIIllIIIII instanceof EntityShulker) && !lllllllllllllIIlIIlIIlIIIllIIIII.noClip) {
                            lllllllllllllIIlIIlIIlIIIllIIIII.moveEntity(MoverType.SHULKER, lllllllllllllIIlIIlIIlIIIllIIlIl, lllllllllllllIIlIIlIIlIIIllIIlII, lllllllllllllIIlIIlIIlIIIllIIIll);
                        }
                    }
                }
            }
        }
    }
    
    private boolean isClosed() {
        return this.getPeekTick() == 0;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIlIIlIIlIIlIllIlll, @Nullable final IEntityLivingData lllllllllllllIIlIIlIIlIIlIllIllI) {
        this.renderYawOffset = 180.0f;
        this.prevRenderYawOffset = 180.0f;
        this.rotationYaw = 180.0f;
        this.prevRotationYaw = 180.0f;
        this.rotationYawHead = 180.0f;
        this.prevRotationYawHead = 180.0f;
        return super.onInitialSpawn(lllllllllllllIIlIIlIIlIIlIllIlll, lllllllllllllIIlIIlIIlIIlIllIllI);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityShulker.ATTACHED_FACE, EnumFacing.DOWN);
        this.dataManager.register(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.absent());
        this.dataManager.register(EntityShulker.PEEK_TICK, (Byte)0);
        this.dataManager.register(EntityShulker.field_190770_bw, (byte)EntityShulker.field_190771_bx.getMetadata());
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return this.isEntityAlive() ? this.getEntityBoundingBox() : null;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = EntityShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final byte lllllllllllllIIlIIlIIIlllIllllIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIIlIIIlllIllllIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EntityShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIlIIlIIIlllIllllIl;
    }
    
    @Override
    public void setPositionAndRotationDirect(final double lllllllllllllIIlIIlIIlIIIIIIlIII, final double lllllllllllllIIlIIlIIlIIIIIIIlll, final double lllllllllllllIIlIIlIIlIIIIIIIllI, final float lllllllllllllIIlIIlIIlIIIIIIIlIl, final float lllllllllllllIIlIIlIIlIIIIIIIlII, final int lllllllllllllIIlIIlIIlIIIIIIIIll, final boolean lllllllllllllIIlIIlIIlIIIIIIIIlI) {
        this.newPosRotationIncrements = 0;
    }
    
    protected boolean tryTeleportToNewPosition() {
        if (!this.isAIDisabled() && this.isEntityAlive()) {
            final BlockPos lllllllllllllIIlIIlIIlIIIIlIIlII = new BlockPos(this);
            for (int lllllllllllllIIlIIlIIlIIIIlIIIll = 0; lllllllllllllIIlIIlIIlIIIIlIIIll < 5; ++lllllllllllllIIlIIlIIlIIIIlIIIll) {
                final BlockPos lllllllllllllIIlIIlIIlIIIIlIIIlI = lllllllllllllIIlIIlIIlIIIIlIIlII.add(8 - this.rand.nextInt(17), 8 - this.rand.nextInt(17), 8 - this.rand.nextInt(17));
                if (lllllllllllllIIlIIlIIlIIIIlIIIlI.getY() > 0 && this.world.isAirBlock(lllllllllllllIIlIIlIIlIIIIlIIIlI) && this.world.func_191503_g(this) && this.world.getCollisionBoxes(this, new AxisAlignedBB(lllllllllllllIIlIIlIIlIIIIlIIIlI)).isEmpty()) {
                    boolean lllllllllllllIIlIIlIIlIIIIlIIIIl = false;
                    final Exception lllllllllllllIIlIIlIIlIIIIIlIlll;
                    final short lllllllllllllIIlIIlIIlIIIIIllIII = (short)((EnumFacing[])(Object)(lllllllllllllIIlIIlIIlIIIIIlIlll = (Exception)(Object)EnumFacing.values())).length;
                    for (char lllllllllllllIIlIIlIIlIIIIIllIIl = '\0'; lllllllllllllIIlIIlIIlIIIIIllIIl < lllllllllllllIIlIIlIIlIIIIIllIII; ++lllllllllllllIIlIIlIIlIIIIIllIIl) {
                        final EnumFacing lllllllllllllIIlIIlIIlIIIIlIIIII = lllllllllllllIIlIIlIIlIIIIIlIlll[lllllllllllllIIlIIlIIlIIIIIllIIl];
                        if (this.world.isBlockNormalCube(lllllllllllllIIlIIlIIlIIIIlIIIlI.offset(lllllllllllllIIlIIlIIlIIIIlIIIII), false)) {
                            this.dataManager.set(EntityShulker.ATTACHED_FACE, lllllllllllllIIlIIlIIlIIIIlIIIII);
                            lllllllllllllIIlIIlIIlIIIIlIIIIl = true;
                            break;
                        }
                    }
                    if (lllllllllllllIIlIIlIIlIIIIlIIIIl) {
                        this.playSound(SoundEvents.ENTITY_SHULKER_TELEPORT, 1.0f, 1.0f);
                        this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.of((Object)lllllllllllllIIlIIlIIlIIIIlIIIlI));
                        this.dataManager.set(EntityShulker.PEEK_TICK, (Byte)0);
                        this.setAttackTarget(null);
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIlIIlIIlIIlIlIlIIl) {
        return this.isClosed() ? SoundEvents.ENTITY_SHULKER_HURT_CLOSED : SoundEvents.ENTITY_SHULKER_HURT;
    }
    
    @Override
    public void playLivingSound() {
        if (!this.isClosed()) {
            super.playLivingSound();
        }
    }
    
    @Override
    public void moveEntity(final MoverType lllllllllllllIIlIIlIIlIIIlIIlIIl, final double lllllllllllllIIlIIlIIlIIIlIIIIll, final double lllllllllllllIIlIIlIIlIIIlIIIlll, final double lllllllllllllIIlIIlIIlIIIlIIIIIl) {
        if (lllllllllllllIIlIIlIIlIIIlIIlIIl == MoverType.SHULKER_BOX) {
            this.tryTeleportToNewPosition();
        }
        else {
            super.moveEntity(lllllllllllllIIlIIlIIlIIIlIIlIIl, lllllllllllllIIlIIlIIlIIIlIIIIll, lllllllllllllIIlIIlIIlIIIlIIIlll, lllllllllllllIIlIIlIIlIIIlIIIIIl);
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public int getHorizontalFaceSpeed() {
        return 180;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SHULKER;
    }
    
    public void setAttachmentPos(@Nullable final BlockPos lllllllllllllIIlIIlIIIlllllIIIll) {
        this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, (Optional<BlockPos>)Optional.fromNullable((Object)lllllllllllllIIlIIlIIIlllllIIIll));
    }
    
    public EnumDyeColor func_190769_dn() {
        return EnumDyeColor.byMetadata(this.dataManager.get(EntityShulker.field_190770_bw));
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIIlIIlIIlIIIIIIllll) {
        if (EntityShulker.ATTACHED_BLOCK_POS.equals(lllllllllllllIIlIIlIIlIIIIIIllll) && this.world.isRemote && !this.isRiding()) {
            final BlockPos lllllllllllllIIlIIlIIlIIIIIIlllI = this.getAttachmentPos();
            if (lllllllllllllIIlIIlIIlIIIIIIlllI != null) {
                if (this.currentAttachmentPosition == null) {
                    this.currentAttachmentPosition = lllllllllllllIIlIIlIIlIIIIIIlllI;
                }
                else {
                    this.clientSideTeleportInterpolation = 6;
                }
                this.posX = lllllllllllllIIlIIlIIlIIIIIIlllI.getX() + 0.5;
                this.posY = lllllllllllllIIlIIlIIlIIIIIIlllI.getY();
                this.posZ = lllllllllllllIIlIIlIIlIIIIIIlllI.getZ() + 0.5;
                this.prevPosX = this.posX;
                this.prevPosY = this.posY;
                this.prevPosZ = this.posZ;
                this.lastTickPosX = this.posX;
                this.lastTickPosY = this.posY;
                this.lastTickPosZ = this.posZ;
            }
        }
        super.notifyDataManagerChange(lllllllllllllIIlIIlIIlIIIIIIllll);
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }
    
    public boolean isAttachedToBlock() {
        return this.currentAttachmentPosition != null && this.getAttachmentPos() != null;
    }
    
    public BlockPos getOldAttachPos() {
        return this.currentAttachmentPosition;
    }
    
    public void updateArmorModifier(final int lllllllllllllIIlIIlIIIllllIllIlI) {
        if (!this.world.isRemote) {
            this.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(EntityShulker.COVERED_ARMOR_BONUS_MODIFIER);
            if (lllllllllllllIIlIIlIIIllllIllIlI == 0) {
                this.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(EntityShulker.COVERED_ARMOR_BONUS_MODIFIER);
                this.playSound(SoundEvents.ENTITY_SHULKER_CLOSE, 1.0f, 1.0f);
            }
            else {
                this.playSound(SoundEvents.ENTITY_SHULKER_OPEN, 1.0f, 1.0f);
            }
        }
        this.dataManager.set(EntityShulker.PEEK_TICK, (byte)lllllllllllllIIlIIlIIIllllIllIlI);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevRenderYawOffset = 180.0f;
        this.renderYawOffset = 180.0f;
        this.rotationYaw = 180.0f;
    }
    
    @Override
    public void setPosition(final double lllllllllllllIIlIIlIIlIIIIllIIll, final double lllllllllllllIIlIIlIIlIIIIllIIlI, final double lllllllllllllIIlIIlIIlIIIIllIlll) {
        super.setPosition(lllllllllllllIIlIIlIIlIIIIllIIll, lllllllllllllIIlIIlIIlIIIIllIIlI, lllllllllllllIIlIIlIIlIIIIllIlll);
        if (this.dataManager != null && this.ticksExisted != 0) {
            final Optional<BlockPos> lllllllllllllIIlIIlIIlIIIIllIllI = this.dataManager.get(EntityShulker.ATTACHED_BLOCK_POS);
            final Optional<BlockPos> lllllllllllllIIlIIlIIlIIIIllIlIl = (Optional<BlockPos>)Optional.of((Object)new BlockPos(lllllllllllllIIlIIlIIlIIIIllIIll, lllllllllllllIIlIIlIIlIIIIllIIlI, lllllllllllllIIlIIlIIlIIIIllIlll));
            if (!lllllllllllllIIlIIlIIlIIIIllIlIl.equals((Object)lllllllllllllIIlIIlIIlIIIIllIllI)) {
                this.dataManager.set(EntityShulker.ATTACHED_BLOCK_POS, lllllllllllllIIlIIlIIlIIIIllIlIl);
                this.dataManager.set(EntityShulker.PEEK_TICK, (Byte)0);
                this.isAirBorne = true;
            }
        }
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHULKER_DEATH;
    }
    
    public int getClientTeleportInterp() {
        return this.clientSideTeleportInterpolation;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIlIIlIIlIIlIIIlIII) {
        super.writeEntityToNBT(lllllllllllllIIlIIlIIlIIlIIIlIII);
        lllllllllllllIIlIIlIIlIIlIIIlIII.setByte("AttachFace", (byte)this.dataManager.get(EntityShulker.ATTACHED_FACE).getIndex());
        lllllllllllllIIlIIlIIlIIlIIIlIII.setByte("Peek", this.dataManager.get(EntityShulker.PEEK_TICK));
        lllllllllllllIIlIIlIIlIIlIIIlIII.setByte("Color", this.dataManager.get(EntityShulker.field_190770_bw));
        final BlockPos lllllllllllllIIlIIlIIlIIlIIIIlll = this.getAttachmentPos();
        if (lllllllllllllIIlIIlIIlIIlIIIIlll != null) {
            lllllllllllllIIlIIlIIlIIlIIIlIII.setInteger("APX", lllllllllllllIIlIIlIIlIIlIIIIlll.getX());
            lllllllllllllIIlIIlIIlIIlIIIlIII.setInteger("APY", lllllllllllllIIlIIlIIlIIlIIIIlll.getY());
            lllllllllllllIIlIIlIIlIIlIIIlIII.setInteger("APZ", lllllllllllllIIlIIlIIlIIlIIIIlll.getZ());
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new AIAttack());
        this.tasks.addTask(7, new AIPeek((AIPeek)null));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new AIAttackNearest(this));
        this.targetTasks.addTask(3, new AIDefenseAttack(this));
    }
    
    @Nullable
    public BlockPos getAttachmentPos() {
        return (BlockPos)this.dataManager.get(EntityShulker.ATTACHED_BLOCK_POS).orNull();
    }
    
    public float getClientPeekAmount(final float lllllllllllllIIlIIlIIIllllIlIllI) {
        return this.prevPeekAmount + (this.peekAmount - this.prevPeekAmount) * lllllllllllllIIlIIlIIIllllIlIllI;
    }
    
    public EnumFacing getAttachmentFacing() {
        return this.dataManager.get(EntityShulker.ATTACHED_FACE);
    }
    
    @Override
    protected EntityBodyHelper createBodyHelper() {
        return new BodyHelper(this);
    }
    
    public static void registerFixesShulker(final DataFixer lllllllllllllIIlIIlIIlIIlIIlllII) {
        EntityLiving.registerFixesMob(lllllllllllllIIlIIlIIlIIlIIlllII, EntityShulker.class);
    }
    
    class AIAttackNearest extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        public AIAttackNearest(final EntityShulker llllllllllllllllIIIIIllIIIIlIlll) {
            super(llllllllllllllllIIIIIllIIIIlIlll, EntityPlayer.class, true);
        }
        
        @Override
        protected AxisAlignedBB getTargetableArea(final double llllllllllllllllIIIIIllIIIIIllII) {
            final EnumFacing llllllllllllllllIIIIIllIIIIIlllI = ((EntityShulker)this.taskOwner).getAttachmentFacing();
            if (llllllllllllllllIIIIIllIIIIIlllI.getAxis() == EnumFacing.Axis.X) {
                return this.taskOwner.getEntityBoundingBox().expand(4.0, llllllllllllllllIIIIIllIIIIIllII, llllllllllllllllIIIIIllIIIIIllII);
            }
            return (llllllllllllllllIIIIIllIIIIIlllI.getAxis() == EnumFacing.Axis.Z) ? this.taskOwner.getEntityBoundingBox().expand(llllllllllllllllIIIIIllIIIIIllII, llllllllllllllllIIIIIllIIIIIllII, 4.0) : this.taskOwner.getEntityBoundingBox().expand(llllllllllllllllIIIIIllIIIIIllII, 4.0, llllllllllllllllIIIIIllIIIIIllII);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityShulker.this.world.getDifficulty() != EnumDifficulty.PEACEFUL && super.shouldExecute();
        }
    }
    
    class BodyHelper extends EntityBodyHelper
    {
        public BodyHelper(final EntityLivingBase llIlIlllIIlllII) {
            super(llIlIlllIIlllII);
        }
        
        @Override
        public void updateRenderAngles() {
        }
    }
    
    static class AIDefenseAttack extends EntityAINearestAttackableTarget<EntityLivingBase>
    {
        public AIDefenseAttack(final EntityShulker lllllllllllllIIllllIllIIIIIIIIll) {
            super(lllllllllllllIIllllIllIIIIIIIIll, EntityLivingBase.class, 10, true, false, (com.google.common.base.Predicate<? super EntityLivingBase>)new Predicate<EntityLivingBase>() {
                public boolean apply(@Nullable final EntityLivingBase llllllllllllllllIlllIlIlllIlllll) {
                    return llllllllllllllllIlllIlIlllIlllll instanceof IMob;
                }
            });
        }
        
        @Override
        public boolean shouldExecute() {
            return this.taskOwner.getTeam() != null && super.shouldExecute();
        }
        
        @Override
        protected AxisAlignedBB getTargetableArea(final double lllllllllllllIIllllIlIlllllllIIl) {
            final EnumFacing lllllllllllllIIllllIlIlllllllIII = ((EntityShulker)this.taskOwner).getAttachmentFacing();
            if (lllllllllllllIIllllIlIlllllllIII.getAxis() == EnumFacing.Axis.X) {
                return this.taskOwner.getEntityBoundingBox().expand(4.0, lllllllllllllIIllllIlIlllllllIIl, lllllllllllllIIllllIlIlllllllIIl);
            }
            return (lllllllllllllIIllllIlIlllllllIII.getAxis() == EnumFacing.Axis.Z) ? this.taskOwner.getEntityBoundingBox().expand(lllllllllllllIIllllIlIlllllllIIl, lllllllllllllIIllllIlIlllllllIIl, 4.0) : this.taskOwner.getEntityBoundingBox().expand(lllllllllllllIIllllIlIlllllllIIl, 4.0, lllllllllllllIIllllIlIlllllllIIl);
        }
    }
    
    class AIPeek extends EntityAIBase
    {
        private /* synthetic */ int peekTime;
        
        private AIPeek() {
        }
        
        @Override
        public boolean continueExecuting() {
            return EntityShulker.this.getAttackTarget() == null && this.peekTime > 0;
        }
        
        @Override
        public boolean shouldExecute() {
            return EntityShulker.this.getAttackTarget() == null && EntityShulker.this.rand.nextInt(40) == 0;
        }
        
        @Override
        public void resetTask() {
            if (EntityShulker.this.getAttackTarget() == null) {
                EntityShulker.this.updateArmorModifier(0);
            }
        }
        
        @Override
        public void startExecuting() {
            this.peekTime = 20 * (1 + EntityShulker.this.rand.nextInt(3));
            EntityShulker.this.updateArmorModifier(30);
        }
        
        @Override
        public void updateTask() {
            --this.peekTime;
        }
    }
    
    class AIAttack extends EntityAIBase
    {
        private /* synthetic */ int attackTime;
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase lllllIllIIIIlII = EntityShulker.this.getAttackTarget();
            return lllllIllIIIIlII != null && lllllIllIIIIlII.isEntityAlive() && EntityShulker.this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
        }
        
        @Override
        public void startExecuting() {
            this.attackTime = 20;
            EntityShulker.this.updateArmorModifier(100);
        }
        
        @Override
        public void resetTask() {
            EntityShulker.this.updateArmorModifier(0);
        }
        
        @Override
        public void updateTask() {
            if (EntityShulker.this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
                --this.attackTime;
                final EntityLivingBase lllllIlIlllIllI = EntityShulker.this.getAttackTarget();
                EntityShulker.this.getLookHelper().setLookPositionWithEntity(lllllIlIlllIllI, 180.0f, 180.0f);
                final double lllllIlIlllIlIl = EntityShulker.this.getDistanceSqToEntity(lllllIlIlllIllI);
                if (lllllIlIlllIlIl < 400.0) {
                    if (this.attackTime <= 0) {
                        this.attackTime = 20 + EntityShulker.this.rand.nextInt(10) * 20 / 2;
                        final EntityShulkerBullet lllllIlIlllIlII = new EntityShulkerBullet(EntityShulker.this.world, EntityShulker.this, lllllIlIlllIllI, EntityShulker.this.getAttachmentFacing().getAxis());
                        EntityShulker.this.world.spawnEntityInWorld(lllllIlIlllIlII);
                        EntityShulker.this.playSound(SoundEvents.ENTITY_SHULKER_SHOOT, 2.0f, (EntityShulker.this.rand.nextFloat() - EntityShulker.this.rand.nextFloat()) * 0.2f + 1.0f);
                    }
                }
                else {
                    EntityShulker.this.setAttackTarget(null);
                }
                super.updateTask();
            }
        }
        
        public AIAttack() {
            this.setMutexBits(3);
        }
    }
}
