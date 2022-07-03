package net.minecraft.entity;

import net.minecraft.command.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import me.nrules.*;
import me.nrules.module.player.*;
import me.nrules.module.movement.*;
import me.nrules.event.events.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.crash.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.server.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.datasync.*;
import net.minecraft.block.material.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.enchantment.*;
import com.google.common.collect.*;
import net.minecraft.entity.effect.*;
import net.minecraft.util.math.*;
import me.nrules.module.combat.*;
import net.minecraft.util.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.text.translation.*;

public abstract class Entity implements ICommandSender
{
    public /* synthetic */ double lastTickPosY;
    public /* synthetic */ double prevPosX;
    public /* synthetic */ boolean isInWeb;
    public /* synthetic */ float height;
    protected /* synthetic */ Random rand;
    public /* synthetic */ double prevPosY;
    public /* synthetic */ boolean isAirBorne;
    protected /* synthetic */ UUID entityUniqueID;
    private static final /* synthetic */ AxisAlignedBB ZERO_AABB;
    public /* synthetic */ float rotationPitch;
    public /* synthetic */ double motionX;
    public /* synthetic */ double lastTickPosX;
    protected /* synthetic */ boolean inPortal;
    private static /* synthetic */ int nextEntityID;
    protected /* synthetic */ boolean firstUpdate;
    public /* synthetic */ boolean forceSpawn;
    public /* synthetic */ float stepHeight;
    private /* synthetic */ int field_190534_ay;
    private final /* synthetic */ double[] field_191505_aI;
    public /* synthetic */ boolean onGround;
    protected /* synthetic */ boolean glowing;
    private static final /* synthetic */ DataParameter<Boolean> NO_GRAVITY;
    private static final /* synthetic */ DataParameter<Integer> AIR;
    protected /* synthetic */ int portalCounter;
    private static final /* synthetic */ DataParameter<String> CUSTOM_NAME;
    public /* synthetic */ float entityCollisionReduction;
    private /* synthetic */ int entityId;
    public /* synthetic */ int timeUntilPortal;
    protected /* synthetic */ boolean isImmuneToFire;
    private final /* synthetic */ CommandResultStats cmdResultStats;
    public /* synthetic */ double motionZ;
    public /* synthetic */ float rotationYaw;
    private final /* synthetic */ List<Entity> riddenByEntities;
    protected static final /* synthetic */ DataParameter<Byte> FLAGS;
    public /* synthetic */ Entity ridingEntity;
    protected /* synthetic */ int rideCooldown;
    public /* synthetic */ boolean isCollidedHorizontally;
    public /* synthetic */ double prevPosZ;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    protected /* synthetic */ Vec3d lastPortalVec;
    public /* synthetic */ double posY;
    protected /* synthetic */ EnumFacing teleportDirection;
    public /* synthetic */ double posX;
    public /* synthetic */ double posZ;
    private static /* synthetic */ double renderDistanceWeight;
    public /* synthetic */ float prevDistanceWalkedModified;
    public /* synthetic */ float prevRotationYaw;
    public /* synthetic */ float prevRotationPitch;
    private /* synthetic */ long field_191506_aJ;
    public /* synthetic */ boolean isCollidedVertically;
    private /* synthetic */ float field_191959_ay;
    private static final /* synthetic */ DataParameter<Boolean> SILENT;
    private /* synthetic */ boolean isOutsideBorder;
    private final /* synthetic */ Set<String> tags;
    public /* synthetic */ float fallDistance;
    public /* synthetic */ float distanceWalkedOnStepModified;
    private /* synthetic */ boolean invulnerable;
    private static final /* synthetic */ DataParameter<Boolean> CUSTOM_NAME_VISIBLE;
    public /* synthetic */ int dimension;
    public /* synthetic */ boolean inWater;
    public /* synthetic */ double motionY;
    public /* synthetic */ int nextStepDistance;
    public /* synthetic */ float width;
    protected /* synthetic */ String cachedUniqueIdString;
    private /* synthetic */ boolean isPositionDirty;
    public /* synthetic */ boolean velocityChanged;
    private static final /* synthetic */ List<ItemStack> field_190535_b;
    public /* synthetic */ boolean isCollided;
    public /* synthetic */ World world;
    public /* synthetic */ AxisAlignedBB boundingBox;
    public /* synthetic */ double lastTickPosZ;
    public /* synthetic */ float distanceWalkedModified;
    public /* synthetic */ boolean isDead;
    protected /* synthetic */ EntityDataManager dataManager;
    protected /* synthetic */ BlockPos lastPortalPos;
    public /* synthetic */ boolean noClip;
    
    @Nullable
    public Team getTeam() {
        return this.world.getScoreboard().getPlayersTeam(this.getCachedUniqueIdString());
    }
    
    public boolean isEntityAlive() {
        return !this.isDead;
    }
    
    public void resetPositionToBB() {
        final AxisAlignedBB llllllllllllllllIlIIllIIIllIllIl = this.getEntityBoundingBox();
        this.posX = (llllllllllllllllIlIIllIIIllIllIl.minX + llllllllllllllllIlIIllIIIllIllIl.maxX) / 2.0;
        this.posY = llllllllllllllllIlIIllIIIllIllIl.minY;
        this.posZ = (llllllllllllllllIlIIllIIIllIllIl.minZ + llllllllllllllllIlIIllIIIllIllIl.maxZ) / 2.0;
    }
    
    protected void setFlag(final int llllllllllllllllIlIIlIIIIIIllIll, final boolean llllllllllllllllIlIIlIIIIIIlIllI) {
        final byte llllllllllllllllIlIIlIIIIIIllIIl = this.dataManager.get(Entity.FLAGS);
        if (llllllllllllllllIlIIlIIIIIIlIllI) {
            this.dataManager.set(Entity.FLAGS, (byte)(llllllllllllllllIlIIlIIIIIIllIIl | 1 << llllllllllllllllIlIIlIIIIIIllIll));
        }
        else {
            this.dataManager.set(Entity.FLAGS, (byte)(llllllllllllllllIlIIlIIIIIIllIIl & ~(1 << llllllllllllllllIlIIlIIIIIIllIll)));
        }
    }
    
    public static void setRenderDistanceWeight(final double llllllllllllllllIlIIIlllIlIIlIlI) {
        Entity.renderDistanceWeight = llllllllllllllllIlIIIlllIlIIlIlI;
    }
    
    public AxisAlignedBB getEntityBoundingBox() {
        return this.boundingBox;
    }
    
    public void setEntityInvulnerable(final boolean llllllllllllllllIlIIIllllIlllIlI) {
        this.invulnerable = llllllllllllllllIlIIIllllIlllIlI;
    }
    
    public boolean isInsideOfMaterial(final Material llllllllllllllllIlIIlIllIIllIIll) {
        if (this.getRidingEntity() instanceof EntityBoat) {
            return false;
        }
        final double llllllllllllllllIlIIlIllIIlllIlI = this.posY + this.getEyeHeight();
        final BlockPos llllllllllllllllIlIIlIllIIlllIIl = new BlockPos(this.posX, llllllllllllllllIlIIlIllIIlllIlI, this.posZ);
        final IBlockState llllllllllllllllIlIIlIllIIlllIII = this.world.getBlockState(llllllllllllllllIlIIlIllIIlllIIl);
        if (llllllllllllllllIlIIlIllIIlllIII.getMaterial() == llllllllllllllllIlIIlIllIIllIIll) {
            final float llllllllllllllllIlIIlIllIIllIlll = BlockLiquid.getLiquidHeightPercent(llllllllllllllllIlIIlIllIIlllIII.getBlock().getMetaFromState(llllllllllllllllIlIIlIllIIlllIII)) - 0.11111111f;
            final float llllllllllllllllIlIIlIllIIllIllI = llllllllllllllllIlIIlIllIIlllIIl.getY() + 1 - llllllllllllllllIlIIlIllIIllIlll;
            final boolean llllllllllllllllIlIIlIllIIllIlIl = llllllllllllllllIlIIlIllIIlllIlI < llllllllllllllllIlIIlIllIIllIllI;
            return (llllllllllllllllIlIIlIllIIllIlIl || !(this instanceof EntityPlayer)) && llllllllllllllllIlIIlIllIIllIlIl;
        }
        return false;
    }
    
    public static double getRenderDistanceWeight() {
        return Entity.renderDistanceWeight;
    }
    
    public int getMaxFallHeight() {
        return 3;
    }
    
    public boolean setPositionNonDirty() {
        final boolean llllllllllllllllIlIIIllIlIlIIIll = this.isPositionDirty;
        this.isPositionDirty = false;
        return llllllllllllllllIlIIIllIlIlIIIll;
    }
    
    public void setCustomNameTag(final String llllllllllllllllIlIIIlllIIllllIl) {
        this.dataManager.set(Entity.CUSTOM_NAME, llllllllllllllllIlIIIlllIIllllIl);
    }
    
    public float getMirroredYaw(final Mirror llllllllllllllllIlIIIllIlIlIlIIl) {
        final float llllllllllllllllIlIIIllIlIlIlIll = MathHelper.wrapDegrees(this.rotationYaw);
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllllIlIIIllIlIlIlIIl.ordinal()]) {
            case 2: {
                return -llllllllllllllllIlIIIllIlIlIlIll;
            }
            case 3: {
                return 180.0f - llllllllllllllllIlIIIllIlIlIlIll;
            }
            default: {
                return llllllllllllllllIlIIIllIlIlIlIll;
            }
        }
    }
    
    public void removePassengers() {
        for (int llllllllllllllllIlIIlIIIllIIllll = this.riddenByEntities.size() - 1; llllllllllllllllIlIIlIIIllIIllll >= 0; --llllllllllllllllIlIIlIIIllIIllll) {
            this.riddenByEntities.get(llllllllllllllllIlIIlIIIllIIllll).dismountRidingEntity();
        }
    }
    
    protected NBTTagList newDoubleNBTList(final double... llllllllllllllllIlIIlIIlIlIIlIll) {
        final NBTTagList llllllllllllllllIlIIlIIlIlIIllIl = new NBTTagList();
        final short llllllllllllllllIlIIlIIlIlIIIllI = (Object)llllllllllllllllIlIIlIIlIlIIlIll;
        final float llllllllllllllllIlIIlIIlIlIIIlll = llllllllllllllllIlIIlIIlIlIIlIll.length;
        for (final double llllllllllllllllIlIIlIIlIlIIllII : llllllllllllllllIlIIlIIlIlIIIllI) {
            llllllllllllllllIlIIlIIlIlIIllIl.appendTag(new NBTTagDouble(llllllllllllllllIlIIlIIlIlIIllII));
        }
        return llllllllllllllllIlIIlIIlIlIIllIl;
    }
    
    public boolean hasCustomName() {
        return !this.dataManager.get(Entity.CUSTOM_NAME).isEmpty();
    }
    
    public Vec3d getPositionEyes(final float llllllllllllllllIlIIlIlIIIIIlIIl) {
        if (llllllllllllllllIlIIlIlIIIIIlIIl == 1.0f) {
            return new Vec3d(this.posX, this.posY + this.getEyeHeight(), this.posZ);
        }
        final double llllllllllllllllIlIIlIlIIIIIlIII = this.prevPosX + (this.posX - this.prevPosX) * llllllllllllllllIlIIlIlIIIIIlIIl;
        final double llllllllllllllllIlIIlIlIIIIIIllI = this.prevPosY + (this.posY - this.prevPosY) * llllllllllllllllIlIIlIlIIIIIlIIl + this.getEyeHeight();
        final double llllllllllllllllIlIIlIlIIIIIIlII = this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllllllIlIIlIlIIIIIlIIl;
        return new Vec3d(llllllllllllllllIlIIlIlIIIIIlIII, llllllllllllllllIlIIlIlIIIIIIllI, llllllllllllllllIlIIlIlIIIIIIlII);
    }
    
    public Entity getLowestRidingEntity() {
        Entity llllllllllllllllIlIIIllIIlllIIIl;
        for (llllllllllllllllIlIIIllIIlllIIIl = this; llllllllllllllllIlIIIllIIlllIIIl.isRiding(); llllllllllllllllIlIIIllIIlllIIIl = llllllllllllllllIlIIIllIIlllIIIl.getRidingEntity()) {}
        return llllllllllllllllIlIIIllIIlllIIIl;
    }
    
    public boolean isInRangeToRenderDist(final double llllllllllllllllIlIIlIIllIlIIlII) {
        double llllllllllllllllIlIIlIIllIlIIllI = this.getEntityBoundingBox().getAverageEdgeLength();
        if (Double.isNaN(llllllllllllllllIlIIlIIllIlIIllI)) {
            llllllllllllllllIlIIlIIllIlIIllI = 1.0;
        }
        llllllllllllllllIlIIlIIllIlIIllI = llllllllllllllllIlIIlIIllIlIIllI * 64.0 * Entity.renderDistanceWeight;
        return llllllllllllllllIlIIlIIllIlIIlII < llllllllllllllllIlIIlIIllIlIIllI * llllllllllllllllIlIIlIIllIlIIllI;
    }
    
    public void setAlwaysRenderNameTag(final boolean llllllllllllllllIlIIIlllIIllIIIl) {
        this.dataManager.set(Entity.CUSTOM_NAME_VISIBLE, llllllllllllllllIlIIIlllIIllIIIl);
    }
    
    public void onKillEntity(final EntityLivingBase llllllllllllllllIlIIlIIIIIIIIllI) {
    }
    
    public boolean hasNoGravity() {
        return this.dataManager.get(Entity.NO_GRAVITY);
    }
    
    public boolean writeToNBTOptional(final NBTTagCompound llllllllllllllllIlIIlIIllIIlIIlI) {
        final String llllllllllllllllIlIIlIIllIIlIlII = this.getEntityString();
        if (!this.isDead && llllllllllllllllIlIIlIIllIIlIlII != null && !this.isRiding()) {
            llllllllllllllllIlIIlIIllIIlIIlI.setString("id", llllllllllllllllIlIIlIIllIIlIlII);
            this.writeToNBT(llllllllllllllllIlIIlIIllIIlIIlI);
            return true;
        }
        return false;
    }
    
    protected void kill() {
        this.setDead();
    }
    
    public void addEntityCrashInfo(final CrashReportCategory llllllllllllllllIlIIIlllIlIlllII) {
        llllllllllllllllIlIIIlllIlIlllII.setDetail("Entity Type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(new StringBuilder().append(EntityList.func_191301_a(Entity.this)).append(" (").append(Entity.this.getClass().getCanonicalName()).append(")"));
            }
        });
        llllllllllllllllIlIIIlllIlIlllII.addCrashSection("Entity ID", this.entityId);
        llllllllllllllllIlIIIlllIlIlllII.setDetail("Entity Name", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Entity.this.getName();
            }
        });
        llllllllllllllllIlIIIlllIlIlllII.addCrashSection("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.posX, this.posY, this.posZ));
        llllllllllllllllIlIIIlllIlIlllII.addCrashSection("Entity's Block location", CrashReportCategory.getCoordinateInfo(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ)));
        llllllllllllllllIlIIIlllIlIlllII.addCrashSection("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.motionX, this.motionY, this.motionZ));
        llllllllllllllllIlIIIlllIlIlllII.setDetail("Entity's Passengers", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Entity.this.getPassengers().toString();
            }
        });
        llllllllllllllllIlIIIlllIlIlllII.setDetail("Entity's Vehicle", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Entity.this.getRidingEntity().toString();
            }
        });
    }
    
    protected void playStepSound(final BlockPos llllllllllllllllIlIIllIIIIIIIlll, final Block llllllllllllllllIlIIllIIIIIIIlIl) {
        SoundType llllllllllllllllIlIIllIIIIIIlIIl = llllllllllllllllIlIIllIIIIIIIlIl.getSoundType();
        if (this.world.getBlockState(llllllllllllllllIlIIllIIIIIIIlll.up()).getBlock() == Blocks.SNOW_LAYER) {
            llllllllllllllllIlIIllIIIIIIlIIl = Blocks.SNOW_LAYER.getSoundType();
            this.playSound(llllllllllllllllIlIIllIIIIIIlIIl.getStepSound(), llllllllllllllllIlIIllIIIIIIlIIl.getVolume() * 0.15f, llllllllllllllllIlIIllIIIIIIlIIl.getPitch());
        }
        else if (!llllllllllllllllIlIIllIIIIIIIlIl.getDefaultState().getMaterial().isLiquid()) {
            this.playSound(llllllllllllllllIlIIllIIIIIIlIIl.getStepSound(), llllllllllllllllIlIIllIIIIIIlIIl.getVolume() * 0.15f, llllllllllllllllIlIIllIIIIIIlIIl.getPitch());
        }
    }
    
    public void setPositionAndUpdate(final double llllllllllllllllIlIIIlllIIlIIlII, final double llllllllllllllllIlIIIlllIIlIIIll, final double llllllllllllllllIlIIIlllIIlIIIlI) {
        this.isPositionDirty = true;
        this.setLocationAndAngles(llllllllllllllllIlIIIlllIIlIIlII, llllllllllllllllIlIIIlllIIlIIIll, llllllllllllllllIlIIIlllIIlIIIlI, this.rotationYaw, this.rotationPitch);
        this.world.updateEntityWithOptionalForce(this, false);
    }
    
    protected HoverEvent getHoverEvent() {
        final NBTTagCompound llllllllllllllllIlIIIlllIIIlIIlI = new NBTTagCompound();
        final ResourceLocation llllllllllllllllIlIIIlllIIIlIIIl = EntityList.func_191301_a(this);
        llllllllllllllllIlIIIlllIIIlIIlI.setString("id", this.getCachedUniqueIdString());
        if (llllllllllllllllIlIIIlllIIIlIIIl != null) {
            llllllllllllllllIlIIIlllIIIlIIlI.setString("type", llllllllllllllllIlIIIlllIIIlIIIl.toString());
        }
        llllllllllllllllIlIIIlllIIIlIIlI.setString("name", this.getName());
        return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new TextComponentString(llllllllllllllllIlIIIlllIIIlIIlI.toString()));
    }
    
    public void setDropItemsWhenDead(final boolean llllllllllllllllIlIIllIllllIIlIl) {
    }
    
    @Override
    public void setCommandStat(final CommandResultStats.Type llllllllllllllllIlIIIllIllIlIlll, final int llllllllllllllllIlIIIllIllIllIIl) {
        if (this.world != null && !this.world.isRemote) {
            this.cmdResultStats.setCommandStatForSender(this.world.getMinecraftServer(), this, llllllllllllllllIlIIIllIllIlIlll, llllllllllllllllIlIIIllIllIllIIl);
        }
    }
    
    public float getBrightness() {
        final BlockPos.MutableBlockPos llllllllllllllllIlIIlIllIIIIlIII = new BlockPos.MutableBlockPos(MathHelper.floor(this.posX), 0, MathHelper.floor(this.posZ));
        if (this.world.isBlockLoaded(llllllllllllllllIlIIlIllIIIIlIII)) {
            llllllllllllllllIlIIlIllIIIIlIII.setY(MathHelper.floor(this.posY + this.getEyeHeight()));
            return this.world.getLightBrightness(llllllllllllllllIlIIlIllIIIIlIII);
        }
        return 0.0f;
    }
    
    public boolean isBurning() {
        final boolean llllllllllllllllIlIIlIIIIllIlIll = this.world != null && this.world.isRemote;
        return !this.isImmuneToFire && (this.field_190534_ay > 0 || (llllllllllllllllIlIIlIIIIllIlIll && this.getFlag(0)));
    }
    
    protected void addPassenger(final Entity llllllllllllllllIlIIlIIIllIIIIll) {
        if (llllllllllllllllIlIIlIIIllIIIIll.getRidingEntity() != this) {
            throw new IllegalStateException("Use x.startRiding(y), not y.addPassenger(x)");
        }
        if (!this.world.isRemote && llllllllllllllllIlIIlIIIllIIIIll instanceof EntityPlayer && !(this.getControllingPassenger() instanceof EntityPlayer)) {
            this.riddenByEntities.add(0, llllllllllllllllIlIIlIIIllIIIIll);
        }
        else {
            this.riddenByEntities.add(llllllllllllllllIlIIlIIIllIIIIll);
        }
    }
    
    public Vec3d getLastPortalVec() {
        return this.lastPortalVec;
    }
    
    public void func_191956_a(final Entity llllllllllllllllIlIIlIIlllIIIlll, final int llllllllllllllllIlIIlIIlllIIllII, final DamageSource llllllllllllllllIlIIlIIlllIIlIll) {
        if (llllllllllllllllIlIIlIIlllIIIlll instanceof EntityPlayerMP) {
            CriteriaTriggers.field_192123_c.func_192211_a((EntityPlayerMP)llllllllllllllllIlIIlIIlllIIIlll, this, llllllllllllllllIlIIlIIlllIIlIll);
        }
    }
    
    private void copyDataFromOld(final Entity llllllllllllllllIlIIIllllIlIllIl) {
        final NBTTagCompound llllllllllllllllIlIIIllllIlIllII = llllllllllllllllIlIIIllllIlIllIl.writeToNBT(new NBTTagCompound());
        llllllllllllllllIlIIIllllIlIllII.removeTag("Dimension");
        this.readFromNBT(llllllllllllllllIlIIIllllIlIllII);
        this.timeUntilPortal = llllllllllllllllIlIIIllllIlIllIl.timeUntilPortal;
        this.lastPortalPos = llllllllllllllllIlIIIllllIlIllIl.lastPortalPos;
        this.lastPortalVec = llllllllllllllllIlIIIllllIlIllIl.lastPortalVec;
        this.teleportDirection = llllllllllllllllIlIIIllllIlIllIl.teleportDirection;
    }
    
    public void moveEntity(final MoverType llllllllllllllllIlIIllIlIIlIIlll, double llllllllllllllllIlIIllIIlIlIIIlI, double llllllllllllllllIlIIllIIlIlIIIIl, double llllllllllllllllIlIIllIIlIlIIIII) {
        if (Main.moduleManager.getModule(Freecam.class).isToggled() || NoClip.isNoClip(this)) {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(llllllllllllllllIlIIllIIlIlIIIlI, llllllllllllllllIlIIllIIlIlIIIIl, (double)llllllllllllllllIlIIllIIlIlIIIII));
            this.resetPositionToBB();
            this.noClip = true;
        }
        else {
            if (llllllllllllllllIlIIllIlIIlIIlll == MoverType.PISTON) {
                final long llllllllllllllllIlIIllIlIIIlllll = this.world.getTotalWorldTime();
                if (llllllllllllllllIlIIllIlIIIlllll != this.field_191506_aJ) {
                    Arrays.fill(this.field_191505_aI, 0.0);
                    this.field_191506_aJ = llllllllllllllllIlIIllIlIIIlllll;
                }
                if (llllllllllllllllIlIIllIIlIlIIIlI != 0.0) {
                    final int llllllllllllllllIlIIllIlIIIlllII = EnumFacing.Axis.X.ordinal();
                    final double llllllllllllllllIlIIllIlIIIllIll = MathHelper.clamp(llllllllllllllllIlIIllIIlIlIIIlI + this.field_191505_aI[llllllllllllllllIlIIllIlIIIlllII], -0.51, 0.51);
                    llllllllllllllllIlIIllIIlIlIIIlI = llllllllllllllllIlIIllIlIIIllIll - this.field_191505_aI[llllllllllllllllIlIIllIlIIIlllII];
                    this.field_191505_aI[llllllllllllllllIlIIllIlIIIlllII] = llllllllllllllllIlIIllIlIIIllIll;
                    if (Math.abs(llllllllllllllllIlIIllIIlIlIIIlI) <= 9.999999747378752E-6) {
                        return;
                    }
                }
                else if (llllllllllllllllIlIIllIIlIlIIIIl != 0.0) {
                    final int llllllllllllllllIlIIllIlIIIllIlI = EnumFacing.Axis.Y.ordinal();
                    final double llllllllllllllllIlIIllIlIIIllIII = MathHelper.clamp(llllllllllllllllIlIIllIIlIlIIIIl + this.field_191505_aI[llllllllllllllllIlIIllIlIIIllIlI], -0.51, 0.51);
                    llllllllllllllllIlIIllIIlIlIIIIl = llllllllllllllllIlIIllIlIIIllIII - this.field_191505_aI[llllllllllllllllIlIIllIlIIIllIlI];
                    this.field_191505_aI[llllllllllllllllIlIIllIlIIIllIlI] = llllllllllllllllIlIIllIlIIIllIII;
                    if (Math.abs(llllllllllllllllIlIIllIIlIlIIIIl) <= 9.999999747378752E-6) {
                        return;
                    }
                }
                else {
                    if (llllllllllllllllIlIIllIIlIlIIIII == 0.0) {
                        return;
                    }
                    final int llllllllllllllllIlIIllIlIIIlIllI = EnumFacing.Axis.Z.ordinal();
                    final double llllllllllllllllIlIIllIlIIIlIlII = MathHelper.clamp((double)(llllllllllllllllIlIIllIIlIlIIIII + this.field_191505_aI[llllllllllllllllIlIIllIlIIIlIllI]), -0.51, 0.51);
                    llllllllllllllllIlIIllIIlIlIIIII = llllllllllllllllIlIIllIlIIIlIlII - this.field_191505_aI[llllllllllllllllIlIIllIlIIIlIllI];
                    this.field_191505_aI[llllllllllllllllIlIIllIlIIIlIllI] = llllllllllllllllIlIIllIlIIIlIlII;
                    if (Math.abs((double)llllllllllllllllIlIIllIIlIlIIIII) <= 9.999999747378752E-6) {
                        return;
                    }
                }
            }
            this.world.theProfiler.startSection("move");
            final double llllllllllllllllIlIIllIlIIIlIIlI = this.posX;
            final double llllllllllllllllIlIIllIlIIIlIIIl = this.posY;
            final double llllllllllllllllIlIIllIlIIIIllll = this.posZ;
            if (this.isInWeb) {
                this.isInWeb = false;
                llllllllllllllllIlIIllIIlIlIIIlI *= 0.25;
                llllllllllllllllIlIIllIIlIlIIIIl *= 0.05000000074505806;
                llllllllllllllllIlIIllIIlIlIIIII *= 0.25;
                this.motionX = 0.0;
                this.motionY = (Main.moduleManager.getModule(AirJump.class).isToggled() ? AirJump.pos.getValDouble() : 0.0);
                this.motionZ = 0.0;
            }
            double llllllllllllllllIlIIllIlIIIIllIl = llllllllllllllllIlIIllIIlIlIIIlI;
            final double llllllllllllllllIlIIllIlIIIIllII = llllllllllllllllIlIIllIIlIlIIIIl;
            double llllllllllllllllIlIIllIlIIIIlIll = (double)llllllllllllllllIlIIllIIlIlIIIII;
            if ((llllllllllllllllIlIIllIlIIlIIlll == MoverType.SELF || llllllllllllllllIlIIllIlIIlIIlll == MoverType.PLAYER) && this.onGround && this.isSneaking() && this instanceof EntityPlayer) {
                final double llllllllllllllllIlIIllIlIIIIlIlI = 0.05;
                while (llllllllllllllllIlIIllIIlIlIIIlI != 0.0) {
                    if (!this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(llllllllllllllllIlIIllIIlIlIIIlI, -this.stepHeight, 0.0)).isEmpty()) {
                        break;
                    }
                    if (llllllllllllllllIlIIllIIlIlIIIlI < 0.05 && llllllllllllllllIlIIllIIlIlIIIlI >= -0.05) {
                        llllllllllllllllIlIIllIIlIlIIIlI = 0.0;
                    }
                    else if (llllllllllllllllIlIIllIIlIlIIIlI > 0.0) {
                        llllllllllllllllIlIIllIIlIlIIIlI -= 0.05;
                    }
                    else {
                        llllllllllllllllIlIIllIIlIlIIIlI += 0.05;
                    }
                    llllllllllllllllIlIIllIlIIIIllIl = llllllllllllllllIlIIllIIlIlIIIlI;
                }
                while (llllllllllllllllIlIIllIIlIlIIIII != 0.0) {
                    if (!this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(0.0, -this.stepHeight, (double)llllllllllllllllIlIIllIIlIlIIIII)).isEmpty()) {
                        break;
                    }
                    if (llllllllllllllllIlIIllIIlIlIIIII < 0.05 && llllllllllllllllIlIIllIIlIlIIIII >= -0.05) {
                        llllllllllllllllIlIIllIIlIlIIIII = 0.0;
                    }
                    else if (llllllllllllllllIlIIllIIlIlIIIII > 0.0) {
                        llllllllllllllllIlIIllIIlIlIIIII -= 0.05;
                    }
                    else {
                        llllllllllllllllIlIIllIIlIlIIIII += 0.05;
                    }
                    llllllllllllllllIlIIllIlIIIIlIll = (double)llllllllllllllllIlIIllIIlIlIIIII;
                }
                while (llllllllllllllllIlIIllIIlIlIIIlI != 0.0 && llllllllllllllllIlIIllIIlIlIIIII != 0.0 && this.world.getCollisionBoxes(this, this.getEntityBoundingBox().offset(llllllllllllllllIlIIllIIlIlIIIlI, -this.stepHeight, (double)llllllllllllllllIlIIllIIlIlIIIII)).isEmpty()) {
                    if (llllllllllllllllIlIIllIIlIlIIIlI < 0.05 && llllllllllllllllIlIIllIIlIlIIIlI >= -0.05) {
                        llllllllllllllllIlIIllIIlIlIIIlI = 0.0;
                    }
                    else if (llllllllllllllllIlIIllIIlIlIIIlI > 0.0) {
                        llllllllllllllllIlIIllIIlIlIIIlI -= 0.05;
                    }
                    else {
                        llllllllllllllllIlIIllIIlIlIIIlI += 0.05;
                    }
                    llllllllllllllllIlIIllIlIIIIllIl = llllllllllllllllIlIIllIIlIlIIIlI;
                    if (llllllllllllllllIlIIllIIlIlIIIII < 0.05 && llllllllllllllllIlIIllIIlIlIIIII >= -0.05) {
                        llllllllllllllllIlIIllIIlIlIIIII = 0.0;
                    }
                    else if (llllllllllllllllIlIIllIIlIlIIIII > 0.0) {
                        llllllllllllllllIlIIllIIlIlIIIII -= 0.05;
                    }
                    else {
                        llllllllllllllllIlIIllIIlIlIIIII += 0.05;
                    }
                    llllllllllllllllIlIIllIlIIIIlIll = (double)llllllllllllllllIlIIllIIlIlIIIII;
                }
            }
            final List<AxisAlignedBB> llllllllllllllllIlIIllIlIIIIlIIl = this.world.getCollisionBoxes(this, this.getEntityBoundingBox().addCoord(llllllllllllllllIlIIllIIlIlIIIlI, llllllllllllllllIlIIllIIlIlIIIIl, (double)llllllllllllllllIlIIllIIlIlIIIII));
            final AxisAlignedBB llllllllllllllllIlIIllIlIIIIlIII = this.getEntityBoundingBox();
            if (llllllllllllllllIlIIllIIlIlIIIIl != 0.0) {
                for (int llllllllllllllllIlIIllIlIIIIIlll = 0, llllllllllllllllIlIIllIlIIIIIlIl = llllllllllllllllIlIIllIlIIIIlIIl.size(); llllllllllllllllIlIIllIlIIIIIlll < llllllllllllllllIlIIllIlIIIIIlIl; ++llllllllllllllllIlIIllIlIIIIIlll) {
                    llllllllllllllllIlIIllIIlIlIIIIl = llllllllllllllllIlIIllIlIIIIlIIl.get(llllllllllllllllIlIIllIlIIIIIlll).calculateYOffset(this.getEntityBoundingBox(), llllllllllllllllIlIIllIIlIlIIIIl);
                }
                this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, llllllllllllllllIlIIllIIlIlIIIIl, 0.0));
            }
            if (llllllllllllllllIlIIllIIlIlIIIlI != 0.0) {
                for (int llllllllllllllllIlIIllIlIIIIIIll = 0, llllllllllllllllIlIIllIlIIIIIIIl = llllllllllllllllIlIIllIlIIIIlIIl.size(); llllllllllllllllIlIIllIlIIIIIIll < llllllllllllllllIlIIllIlIIIIIIIl; ++llllllllllllllllIlIIllIlIIIIIIll) {
                    llllllllllllllllIlIIllIIlIlIIIlI = llllllllllllllllIlIIllIlIIIIlIIl.get(llllllllllllllllIlIIllIlIIIIIIll).calculateXOffset(this.getEntityBoundingBox(), llllllllllllllllIlIIllIIlIlIIIlI);
                }
                if (llllllllllllllllIlIIllIIlIlIIIlI != 0.0) {
                    this.setEntityBoundingBox(this.getEntityBoundingBox().offset(llllllllllllllllIlIIllIIlIlIIIlI, 0.0, 0.0));
                }
            }
            if (llllllllllllllllIlIIllIIlIlIIIII != 0.0) {
                for (int llllllllllllllllIlIIllIlIIIIIIII = 0, llllllllllllllllIlIIllIIlllllllI = llllllllllllllllIlIIllIlIIIIlIIl.size(); llllllllllllllllIlIIllIlIIIIIIII < llllllllllllllllIlIIllIIlllllllI; ++llllllllllllllllIlIIllIlIIIIIIII) {
                    llllllllllllllllIlIIllIIlIlIIIII = llllllllllllllllIlIIllIlIIIIlIIl.get(llllllllllllllllIlIIllIlIIIIIIII).calculateZOffset(this.getEntityBoundingBox(), (double)llllllllllllllllIlIIllIIlIlIIIII);
                }
                if (llllllllllllllllIlIIllIIlIlIIIII != 0.0) {
                    this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, 0.0, (double)llllllllllllllllIlIIllIIlIlIIIII));
                }
            }
            final boolean llllllllllllllllIlIIllIIllllllII = this.onGround || (llllllllllllllllIlIIllIlIIIIllII != llllllllllllllllIlIIllIIlIlIIIIl && llllllllllllllllIlIIllIlIIIIllII < 0.0);
            final EventStep llllllllllllllllIlIIllIIlllllIlI = new EventStep(true, this.stepHeight);
            if (this == Minecraft.getMinecraft().player) {
                llllllllllllllllIlIIllIIlllllIlI.call();
            }
            if (llllllllllllllllIlIIllIIlllllIlI.getStepHeight() > 0.0 && llllllllllllllllIlIIllIIllllllII && (llllllllllllllllIlIIllIlIIIIllIl != llllllllllllllllIlIIllIIlIlIIIlI || llllllllllllllllIlIIllIlIIIIlIll != llllllllllllllllIlIIllIIlIlIIIII)) {
                final double llllllllllllllllIlIIllIIlllllIII = llllllllllllllllIlIIllIIlIlIIIlI;
                final double llllllllllllllllIlIIllIIllllIllI = llllllllllllllllIlIIllIIlIlIIIIl;
                final double llllllllllllllllIlIIllIIllllIlIl = (double)llllllllllllllllIlIIllIIlIlIIIII;
                final AxisAlignedBB llllllllllllllllIlIIllIIllllIIll = this.getEntityBoundingBox();
                this.setEntityBoundingBox(llllllllllllllllIlIIllIlIIIIlIII);
                llllllllllllllllIlIIllIIlIlIIIIl = llllllllllllllllIlIIllIIlllllIlI.getStepHeight();
                final List<AxisAlignedBB> llllllllllllllllIlIIllIIllllIIIl = this.world.getCollisionBoxes(this, this.getEntityBoundingBox().addCoord(llllllllllllllllIlIIllIlIIIIllIl, llllllllllllllllIlIIllIIlIlIIIIl, llllllllllllllllIlIIllIlIIIIlIll));
                AxisAlignedBB llllllllllllllllIlIIllIIlllIlllI = this.getEntityBoundingBox();
                final AxisAlignedBB llllllllllllllllIlIIllIIlllIllIl = llllllllllllllllIlIIllIIlllIlllI.addCoord(llllllllllllllllIlIIllIlIIIIllIl, 0.0, llllllllllllllllIlIIllIlIIIIlIll);
                double llllllllllllllllIlIIllIIlllIllII = llllllllllllllllIlIIllIIlIlIIIIl;
                for (int llllllllllllllllIlIIllIIlllIlIll = 0, llllllllllllllllIlIIllIIlllIlIlI = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIlllIlIll < llllllllllllllllIlIIllIIlllIlIlI; ++llllllllllllllllIlIIllIIlllIlIll) {
                    llllllllllllllllIlIIllIIlllIllII = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIlllIlIll).calculateYOffset(llllllllllllllllIlIIllIIlllIllIl, llllllllllllllllIlIIllIIlllIllII);
                }
                llllllllllllllllIlIIllIIlllIlllI = llllllllllllllllIlIIllIIlllIlllI.offset(0.0, llllllllllllllllIlIIllIIlllIllII, 0.0);
                double llllllllllllllllIlIIllIIlllIlIIl = llllllllllllllllIlIIllIlIIIIllIl;
                for (int llllllllllllllllIlIIllIIlllIlIII = 0, llllllllllllllllIlIIllIIlllIIllI = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIlllIlIII < llllllllllllllllIlIIllIIlllIIllI; ++llllllllllllllllIlIIllIIlllIlIII) {
                    llllllllllllllllIlIIllIIlllIlIIl = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIlllIlIII).calculateXOffset(llllllllllllllllIlIIllIIlllIlllI, llllllllllllllllIlIIllIIlllIlIIl);
                }
                llllllllllllllllIlIIllIIlllIlllI = llllllllllllllllIlIIllIIlllIlllI.offset(llllllllllllllllIlIIllIIlllIlIIl, 0.0, 0.0);
                double llllllllllllllllIlIIllIIlllIIlII = llllllllllllllllIlIIllIlIIIIlIll;
                for (int llllllllllllllllIlIIllIIlllIIIll = 0, llllllllllllllllIlIIllIIlllIIIIl = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIlllIIIll < llllllllllllllllIlIIllIIlllIIIIl; ++llllllllllllllllIlIIllIIlllIIIll) {
                    llllllllllllllllIlIIllIIlllIIlII = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIlllIIIll).calculateZOffset(llllllllllllllllIlIIllIIlllIlllI, llllllllllllllllIlIIllIIlllIIlII);
                }
                llllllllllllllllIlIIllIIlllIlllI = llllllllllllllllIlIIllIIlllIlllI.offset(0.0, 0.0, llllllllllllllllIlIIllIIlllIIlII);
                AxisAlignedBB llllllllllllllllIlIIllIIllIlllll = this.getEntityBoundingBox();
                double llllllllllllllllIlIIllIIllIlllIl = llllllllllllllllIlIIllIIlIlIIIIl;
                for (int llllllllllllllllIlIIllIIllIllIll = 0, llllllllllllllllIlIIllIIllIllIII = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIllIllIll < llllllllllllllllIlIIllIIllIllIII; ++llllllllllllllllIlIIllIIllIllIll) {
                    llllllllllllllllIlIIllIIllIlllIl = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIllIllIll).calculateYOffset(llllllllllllllllIlIIllIIllIlllll, llllllllllllllllIlIIllIIllIlllIl);
                }
                llllllllllllllllIlIIllIIllIlllll = llllllllllllllllIlIIllIIllIlllll.offset(0.0, llllllllllllllllIlIIllIIllIlllIl, 0.0);
                double llllllllllllllllIlIIllIIllIlIllI = llllllllllllllllIlIIllIlIIIIllIl;
                for (int llllllllllllllllIlIIllIIllIlIlII = 0, llllllllllllllllIlIIllIIllIlIIlI = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIllIlIlII < llllllllllllllllIlIIllIIllIlIIlI; ++llllllllllllllllIlIIllIIllIlIlII) {
                    llllllllllllllllIlIIllIIllIlIllI = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIllIlIlII).calculateXOffset(llllllllllllllllIlIIllIIllIlllll, llllllllllllllllIlIIllIIllIlIllI);
                }
                llllllllllllllllIlIIllIIllIlllll = llllllllllllllllIlIIllIIllIlllll.offset(llllllllllllllllIlIIllIIllIlIllI, 0.0, 0.0);
                double llllllllllllllllIlIIllIIllIlIIII = llllllllllllllllIlIIllIlIIIIlIll;
                for (int llllllllllllllllIlIIllIIllIIllll = 0, llllllllllllllllIlIIllIIllIIlllI = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIllIIllll < llllllllllllllllIlIIllIIllIIlllI; ++llllllllllllllllIlIIllIIllIIllll) {
                    llllllllllllllllIlIIllIIllIlIIII = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIllIIllll).calculateZOffset(llllllllllllllllIlIIllIIllIlllll, llllllllllllllllIlIIllIIllIlIIII);
                }
                llllllllllllllllIlIIllIIllIlllll = llllllllllllllllIlIIllIIllIlllll.offset(0.0, 0.0, llllllllllllllllIlIIllIIllIlIIII);
                final double llllllllllllllllIlIIllIIllIIllIl = llllllllllllllllIlIIllIIlllIlIIl * llllllllllllllllIlIIllIIlllIlIIl + llllllllllllllllIlIIllIIlllIIlII * llllllllllllllllIlIIllIIlllIIlII;
                final double llllllllllllllllIlIIllIIllIIllII = llllllllllllllllIlIIllIIllIlIllI * llllllllllllllllIlIIllIIllIlIllI + llllllllllllllllIlIIllIIllIlIIII * llllllllllllllllIlIIllIIllIlIIII;
                if (llllllllllllllllIlIIllIIllIIllIl > llllllllllllllllIlIIllIIllIIllII) {
                    llllllllllllllllIlIIllIIlIlIIIlI = llllllllllllllllIlIIllIIlllIlIIl;
                    llllllllllllllllIlIIllIIlIlIIIII = llllllllllllllllIlIIllIIlllIIlII;
                    llllllllllllllllIlIIllIIlIlIIIIl = -llllllllllllllllIlIIllIIlllIllII;
                    this.setEntityBoundingBox(llllllllllllllllIlIIllIIlllIlllI);
                }
                else {
                    llllllllllllllllIlIIllIIlIlIIIlI = llllllllllllllllIlIIllIIllIlIllI;
                    llllllllllllllllIlIIllIIlIlIIIII = llllllllllllllllIlIIllIIllIlIIII;
                    llllllllllllllllIlIIllIIlIlIIIIl = -llllllllllllllllIlIIllIIllIlllIl;
                    this.setEntityBoundingBox(llllllllllllllllIlIIllIIllIlllll);
                }
                for (int llllllllllllllllIlIIllIIllIIlIll = 0, llllllllllllllllIlIIllIIllIIlIIl = llllllllllllllllIlIIllIIllllIIIl.size(); llllllllllllllllIlIIllIIllIIlIll < llllllllllllllllIlIIllIIllIIlIIl; ++llllllllllllllllIlIIllIIllIIlIll) {
                    llllllllllllllllIlIIllIIlIlIIIIl = llllllllllllllllIlIIllIIllllIIIl.get(llllllllllllllllIlIIllIIllIIlIll).calculateYOffset(this.getEntityBoundingBox(), llllllllllllllllIlIIllIIlIlIIIIl);
                }
                this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, llllllllllllllllIlIIllIIlIlIIIIl, 0.0));
                if (llllllllllllllllIlIIllIIlllllIII * llllllllllllllllIlIIllIIlllllIII + llllllllllllllllIlIIllIIllllIlIl * llllllllllllllllIlIIllIIllllIlIl >= llllllllllllllllIlIIllIIlIlIIIlI * llllllllllllllllIlIIllIIlIlIIIlI + llllllllllllllllIlIIllIIlIlIIIII * llllllllllllllllIlIIllIIlIlIIIII) {
                    llllllllllllllllIlIIllIIlIlIIIlI = llllllllllllllllIlIIllIIlllllIII;
                    llllllllllllllllIlIIllIIlIlIIIIl = llllllllllllllllIlIIllIIllllIllI;
                    llllllllllllllllIlIIllIIlIlIIIII = llllllllllllllllIlIIllIIllllIlIl;
                    this.setEntityBoundingBox(llllllllllllllllIlIIllIIllllIIll);
                }
                final EventStep llllllllllllllllIlIIllIIllIIIlll = new EventStep(false, this.stepHeight, 1.0 + llllllllllllllllIlIIllIIlIlIIIIl);
                if (this == Minecraft.getMinecraft().player) {
                    llllllllllllllllIlIIllIIllIIIlll.call();
                }
            }
            this.world.theProfiler.endSection();
            this.world.theProfiler.startSection("rest");
            this.resetPositionToBB();
            this.isCollidedHorizontally = (llllllllllllllllIlIIllIlIIIIllIl != llllllllllllllllIlIIllIIlIlIIIlI || llllllllllllllllIlIIllIlIIIIlIll != llllllllllllllllIlIIllIIlIlIIIII);
            this.isCollidedVertically = (llllllllllllllllIlIIllIlIIIIllII != llllllllllllllllIlIIllIIlIlIIIIl);
            this.onGround = (this.isCollidedVertically && llllllllllllllllIlIIllIlIIIIllII < 0.0);
            this.isCollided = (this.isCollidedHorizontally || this.isCollidedVertically);
            final int llllllllllllllllIlIIllIIllIIIlIl = MathHelper.floor(this.posX);
            final int llllllllllllllllIlIIllIIllIIIIll = MathHelper.floor(this.posY - 0.20000000298023224);
            final int llllllllllllllllIlIIllIIllIIIIIl = MathHelper.floor(this.posZ);
            BlockPos llllllllllllllllIlIIllIIlIllllll = new BlockPos(llllllllllllllllIlIIllIIllIIIlIl, llllllllllllllllIlIIllIIllIIIIll, llllllllllllllllIlIIllIIllIIIIIl);
            IBlockState llllllllllllllllIlIIllIIlIllllIl = this.world.getBlockState(llllllllllllllllIlIIllIIlIllllll);
            if (llllllllllllllllIlIIllIIlIllllIl.getMaterial() == Material.AIR) {
                final BlockPos llllllllllllllllIlIIllIIlIlllIll = llllllllllllllllIlIIllIIlIllllll.down();
                final IBlockState llllllllllllllllIlIIllIIlIlllIIl = this.world.getBlockState(llllllllllllllllIlIIllIIlIlllIll);
                final Block llllllllllllllllIlIIllIIlIlllIII = llllllllllllllllIlIIllIIlIlllIIl.getBlock();
                if (llllllllllllllllIlIIllIIlIlllIII instanceof BlockFence || llllllllllllllllIlIIllIIlIlllIII instanceof BlockWall || llllllllllllllllIlIIllIIlIlllIII instanceof BlockFenceGate) {
                    llllllllllllllllIlIIllIIlIllllIl = llllllllllllllllIlIIllIIlIlllIIl;
                    llllllllllllllllIlIIllIIlIllllll = llllllllllllllllIlIIllIIlIlllIll;
                }
            }
            this.updateFallState(llllllllllllllllIlIIllIIlIlIIIIl, this.onGround, llllllllllllllllIlIIllIIlIllllIl, llllllllllllllllIlIIllIIlIllllll);
            if (llllllllllllllllIlIIllIlIIIIllIl != llllllllllllllllIlIIllIIlIlIIIlI) {
                this.motionX = 0.0;
            }
            if (llllllllllllllllIlIIllIlIIIIlIll != llllllllllllllllIlIIllIIlIlIIIII) {
                this.motionZ = 0.0;
            }
            final Block llllllllllllllllIlIIllIIlIllIlll = llllllllllllllllIlIIllIIlIllllIl.getBlock();
            if (llllllllllllllllIlIIllIlIIIIllII != llllllllllllllllIlIIllIIlIlIIIIl) {
                llllllllllllllllIlIIllIIlIllIlll.onLanded(this.world, this);
            }
            if (this.canTriggerWalking() && (!this.onGround || !this.isSneaking() || !(this instanceof EntityPlayer)) && !this.isRiding()) {
                final double llllllllllllllllIlIIllIIlIllIllI = this.posX - llllllllllllllllIlIIllIlIIIlIIlI;
                double llllllllllllllllIlIIllIIlIllIlIl = this.posY - llllllllllllllllIlIIllIlIIIlIIIl;
                final double llllllllllllllllIlIIllIIlIllIIll = this.posZ - llllllllllllllllIlIIllIlIIIIllll;
                if (llllllllllllllllIlIIllIIlIllIlll != Blocks.LADDER) {
                    llllllllllllllllIlIIllIIlIllIlIl = 0.0;
                }
                if (llllllllllllllllIlIIllIIlIllIlll != null && this.onGround) {
                    llllllllllllllllIlIIllIIlIllIlll.onEntityWalk(this.world, llllllllllllllllIlIIllIIlIllllll, this);
                }
                this.distanceWalkedModified += (float)(MathHelper.sqrt(llllllllllllllllIlIIllIIlIllIllI * llllllllllllllllIlIIllIIlIllIllI + llllllllllllllllIlIIllIIlIllIIll * llllllllllllllllIlIIllIIlIllIIll) * 0.6);
                this.distanceWalkedOnStepModified += (float)(MathHelper.sqrt(llllllllllllllllIlIIllIIlIllIllI * llllllllllllllllIlIIllIIlIllIllI + llllllllllllllllIlIIllIIlIllIlIl * llllllllllllllllIlIIllIIlIllIlIl + llllllllllllllllIlIIllIIlIllIIll * llllllllllllllllIlIIllIIlIllIIll) * 0.6);
                if (this.distanceWalkedOnStepModified > this.nextStepDistance && llllllllllllllllIlIIllIIlIllllIl.getMaterial() != Material.AIR) {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;
                    if (this.isInWater()) {
                        final Entity llllllllllllllllIlIIllIIlIllIIIl = (this.isBeingRidden() && this.getControllingPassenger() != null) ? this.getControllingPassenger() : this;
                        final float llllllllllllllllIlIIllIIlIlIlllI = (llllllllllllllllIlIIllIIlIllIIIl == this) ? 0.35f : 0.4f;
                        float llllllllllllllllIlIIllIIlIlIllIl = MathHelper.sqrt(llllllllllllllllIlIIllIIlIllIIIl.motionX * llllllllllllllllIlIIllIIlIllIIIl.motionX * 0.20000000298023224 + llllllllllllllllIlIIllIIlIllIIIl.motionY * llllllllllllllllIlIIllIIlIllIIIl.motionY + llllllllllllllllIlIIllIIlIllIIIl.motionZ * llllllllllllllllIlIIllIIlIllIIIl.motionZ * 0.20000000298023224) * llllllllllllllllIlIIllIIlIlIlllI;
                        if (llllllllllllllllIlIIllIIlIlIllIl > 1.0f) {
                            llllllllllllllllIlIIllIIlIlIllIl = 1.0f;
                        }
                        this.playSound(this.getSwimSound(), llllllllllllllllIlIIllIIlIlIllIl, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                    }
                    else {
                        this.playStepSound(llllllllllllllllIlIIllIIlIllllll, llllllllllllllllIlIIllIIlIllIlll);
                    }
                }
                else if (this.distanceWalkedOnStepModified > this.field_191959_ay && this.func_191957_ae() && llllllllllllllllIlIIllIIlIllllIl.getMaterial() == Material.AIR) {
                    this.field_191959_ay = this.func_191954_d(this.distanceWalkedOnStepModified);
                }
            }
            try {
                this.doBlockCollisions();
            }
            catch (Throwable llllllllllllllllIlIIllIIlIlIlIll) {
                final CrashReport llllllllllllllllIlIIllIIlIlIlIlI = CrashReport.makeCrashReport(llllllllllllllllIlIIllIIlIlIlIll, "Checking entity block collision");
                final CrashReportCategory llllllllllllllllIlIIllIIlIlIlIII = llllllllllllllllIlIIllIIlIlIlIlI.makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo(llllllllllllllllIlIIllIIlIlIlIII);
                throw new ReportedException(llllllllllllllllIlIIllIIlIlIlIlI);
            }
            final boolean llllllllllllllllIlIIllIIlIlIIllI = this.isWet();
            if (this.world.isFlammableWithin(this.getEntityBoundingBox().contract(0.001))) {
                this.dealFireDamage(1);
                if (!llllllllllllllllIlIIllIIlIlIIllI) {
                    ++this.field_190534_ay;
                    if (this.field_190534_ay == 0) {
                        this.setFire(8);
                    }
                }
            }
            else if (this.field_190534_ay <= 0) {
                this.field_190534_ay = -this.func_190531_bD();
            }
            if (llllllllllllllllIlIIllIIlIlIIllI && this.isBurning()) {
                this.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.7f, 1.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                this.field_190534_ay = -this.func_190531_bD();
            }
            this.world.theProfiler.endSection();
        }
    }
    
    @Nullable
    public EntityItem dropItemWithOffset(final Item llllllllllllllllIlIIlIIlIIlIIlll, final int llllllllllllllllIlIIlIIlIIlIIllI, final float llllllllllllllllIlIIlIIlIIlIIIIl) {
        return this.entityDropItem(new ItemStack(llllllllllllllllIlIIlIIlIIlIIlll, llllllllllllllllIlIIlIIlIIlIIllI, 0), llllllllllllllllIlIIlIIlIIlIIIIl);
    }
    
    public void onEntityUpdate() {
        this.world.theProfiler.startSection("entityBaseTick");
        if (this.isRiding() && this.getRidingEntity().isDead) {
            this.dismountRidingEntity();
        }
        if (this.rideCooldown > 0) {
            --this.rideCooldown;
        }
        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        if (!this.world.isRemote && this.world instanceof WorldServer) {
            this.world.theProfiler.startSection("portal");
            if (this.inPortal) {
                final MinecraftServer llllllllllllllllIlIIllIllIIlIIll = this.world.getMinecraftServer();
                if (llllllllllllllllIlIIllIllIIlIIll.getAllowNether()) {
                    if (!this.isRiding()) {
                        final int llllllllllllllllIlIIllIllIIlIIlI = this.getMaxInPortalTime();
                        if (this.portalCounter++ >= llllllllllllllllIlIIllIllIIlIIlI) {
                            this.portalCounter = llllllllllllllllIlIIllIllIIlIIlI;
                            this.timeUntilPortal = this.getPortalCooldown();
                            int llllllllllllllllIlIIllIllIIlIIII = 0;
                            if (this.world.provider.getDimensionType().getId() == -1) {
                                final int llllllllllllllllIlIIllIllIIlIIIl = 0;
                            }
                            else {
                                llllllllllllllllIlIIllIllIIlIIII = -1;
                            }
                            this.changeDimension(llllllllllllllllIlIIllIllIIlIIII);
                        }
                    }
                    this.inPortal = false;
                }
            }
            else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            this.decrementTimeUntilPortal();
            this.world.theProfiler.endSection();
        }
        this.spawnRunningParticles();
        this.handleWaterMovement();
        if (this.world.isRemote) {
            this.extinguish();
        }
        else if (this.field_190534_ay > 0) {
            if (this.isImmuneToFire) {
                this.field_190534_ay -= 4;
                if (this.field_190534_ay < 0) {
                    this.extinguish();
                }
            }
            else {
                if (this.field_190534_ay % 20 == 0) {
                    this.attackEntityFrom(DamageSource.onFire, 1.0f);
                }
                --this.field_190534_ay;
            }
        }
        if (this.isInLava()) {
            this.setOnFireFromLava();
            this.fallDistance *= 0.5f;
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.world.isRemote) {
            this.setFlag(0, this.field_190534_ay > 0);
        }
        this.firstUpdate = false;
        this.world.theProfiler.endSection();
    }
    
    public float getRotationYawHead() {
        return 0.0f;
    }
    
    public boolean processInitialInteract(final EntityPlayer llllllllllllllllIlIIlIIIlllllllI, final EnumHand llllllllllllllllIlIIlIIIllllllIl) {
        return false;
    }
    
    public double getMountedYOffset() {
        return this.height * 0.75;
    }
    
    public float getExplosionResistance(final Explosion llllllllllllllllIlIIIlllIlllIlIl, final World llllllllllllllllIlIIIlllIlllIlII, final BlockPos llllllllllllllllIlIIIlllIlllIIll, final IBlockState llllllllllllllllIlIIIlllIlllIIlI) {
        return llllllllllllllllIlIIIlllIlllIIlI.getBlock().getExplosionResistance(this);
    }
    
    public boolean isEntityInvulnerable(final DamageSource llllllllllllllllIlIIIlllllIIIIll) {
        return this.invulnerable && llllllllllllllllIlIIIlllllIIIIll != DamageSource.outOfWorld && !llllllllllllllllIlIIIlllllIIIIll.isCreativePlayer();
    }
    
    public boolean isNonBoss() {
        return true;
    }
    
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_GENERIC_SWIM;
    }
    
    public boolean getAlwaysRenderNameTag() {
        return this.dataManager.get(Entity.CUSTOM_NAME_VISIBLE);
    }
    
    public void moveToBlockPosAndAngles(final BlockPos llllllllllllllllIlIIlIlIlllIIlIl, final float llllllllllllllllIlIIlIlIlllIIlII, final float llllllllllllllllIlIIlIlIllIlllll) {
        this.setLocationAndAngles(llllllllllllllllIlIIlIlIlllIIlIl.getX() + 0.5, llllllllllllllllIlIIlIlIlllIIlIl.getY(), llllllllllllllllIlIIlIlIlllIIlIl.getZ() + 0.5, llllllllllllllllIlIIlIlIlllIIlII, llllllllllllllllIlIIlIlIllIlllll);
    }
    
    protected float func_191954_d(final float llllllllllllllllIlIIllIIIIIIIIII) {
        return 0.0f;
    }
    
    public EnumFacing getTeleportDirection() {
        return this.teleportDirection;
    }
    
    public void setEntityBoundingBox(final AxisAlignedBB llllllllllllllllIlIIIlllIIIIIIlI) {
        this.boundingBox = llllllllllllllllIlIIIlllIIIIIIlI;
    }
    
    public void updateRidden() {
        final Entity llllllllllllllllIlIIlIIIllllIlll = this.getRidingEntity();
        if (this.isRiding() && llllllllllllllllIlIIlIIIllllIlll.isDead) {
            this.dismountRidingEntity();
        }
        else {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.onUpdate();
            if (this.isRiding()) {
                llllllllllllllllIlIIlIIIllllIlll.updatePassenger(this);
            }
        }
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return false;
    }
    
    public void setInvisible(final boolean llllllllllllllllIlIIlIIIIIlIIlll) {
        this.setFlag(5, llllllllllllllllIlIIlIIIIIlIIlll);
    }
    
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_GENERIC_SPLASH;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        field_190535_b = Collections.emptyList();
        ZERO_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Entity.renderDistanceWeight = 1.0;
        FLAGS = EntityDataManager.createKey(Entity.class, DataSerializers.BYTE);
        AIR = EntityDataManager.createKey(Entity.class, DataSerializers.VARINT);
        CUSTOM_NAME = EntityDataManager.createKey(Entity.class, DataSerializers.STRING);
        CUSTOM_NAME_VISIBLE = EntityDataManager.createKey(Entity.class, DataSerializers.BOOLEAN);
        SILENT = EntityDataManager.createKey(Entity.class, DataSerializers.BOOLEAN);
        NO_GRAVITY = EntityDataManager.createKey(Entity.class, DataSerializers.BOOLEAN);
    }
    
    public Iterable<ItemStack> getEquipmentAndArmor() {
        return (Iterable<ItemStack>)Iterables.concat((Iterable)this.getHeldEquipment(), (Iterable)this.getArmorInventoryList());
    }
    
    public void setCommandStats(final Entity llllllllllllllllIlIIIllIllIIlIlI) {
        this.cmdResultStats.addAllStats(llllllllllllllllIlIIIllIllIIlIlI.getCommandStats());
    }
    
    public boolean func_191953_am() {
        return this.world.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -20.0, 0.0).contract(0.001), Material.WATER, this);
    }
    
    public boolean isOnScoreboardTeam(final Team llllllllllllllllIlIIlIIIIIlIllll) {
        return this.getTeam() != null && this.getTeam().isSameTeam(llllllllllllllllIlIIlIIIIIlIllll);
    }
    
    public void applyEntityCollision(final Entity llllllllllllllllIlIIlIlIIllIllll) {
        if (!this.isRidingSameEntity(llllllllllllllllIlIIlIlIIllIllll) && !llllllllllllllllIlIIlIlIIllIllll.noClip && !this.noClip) {
            double llllllllllllllllIlIIlIlIIllIlllI = llllllllllllllllIlIIlIlIIllIllll.posX - this.posX;
            double llllllllllllllllIlIIlIlIIllIllIl = llllllllllllllllIlIIlIlIIllIllll.posZ - this.posZ;
            double llllllllllllllllIlIIlIlIIllIllII = MathHelper.absMax(llllllllllllllllIlIIlIlIIllIlllI, llllllllllllllllIlIIlIlIIllIllIl);
            if (llllllllllllllllIlIIlIlIIllIllII >= 0.009999999776482582) {
                llllllllllllllllIlIIlIlIIllIllII = MathHelper.sqrt(llllllllllllllllIlIIlIlIIllIllII);
                llllllllllllllllIlIIlIlIIllIlllI /= llllllllllllllllIlIIlIlIIllIllII;
                llllllllllllllllIlIIlIlIIllIllIl /= llllllllllllllllIlIIlIlIIllIllII;
                double llllllllllllllllIlIIlIlIIllIlIll = 1.0 / llllllllllllllllIlIIlIlIIllIllII;
                if (llllllllllllllllIlIIlIlIIllIlIll > 1.0) {
                    llllllllllllllllIlIIlIlIIllIlIll = 1.0;
                }
                llllllllllllllllIlIIlIlIIllIlllI *= llllllllllllllllIlIIlIlIIllIlIll;
                llllllllllllllllIlIIlIlIIllIllIl *= llllllllllllllllIlIIlIlIIllIlIll;
                llllllllllllllllIlIIlIlIIllIlllI *= 0.05000000074505806;
                llllllllllllllllIlIIlIlIIllIllIl *= 0.05000000074505806;
                llllllllllllllllIlIIlIlIIllIlllI *= 1.0f - this.entityCollisionReduction;
                llllllllllllllllIlIIlIlIIllIllIl *= 1.0f - this.entityCollisionReduction;
                if (!this.isBeingRidden()) {
                    this.addVelocity(-llllllllllllllllIlIIlIlIIllIlllI, 0.0, -llllllllllllllllIlIIlIlIIllIllIl);
                }
                if (!llllllllllllllllIlIIlIlIIllIllll.isBeingRidden()) {
                    llllllllllllllllIlIIlIlIIllIllll.addVelocity(llllllllllllllllIlIIlIlIIllIlllI, 0.0, llllllllllllllllIlIIlIlIIllIllIl);
                }
            }
        }
    }
    
    public AxisAlignedBB getRenderBoundingBox() {
        return this.getEntityBoundingBox();
    }
    
    @Nullable
    public Entity getControllingPassenger() {
        return null;
    }
    
    @Nullable
    public Entity[] getParts() {
        return null;
    }
    
    public boolean ignoreItemEntityData() {
        return false;
    }
    
    public EntityDataManager getDataManager() {
        return this.dataManager;
    }
    
    public EnumFacing getAdjustedHorizontalFacing() {
        return this.getHorizontalFacing();
    }
    
    public int getPortalCooldown() {
        return 300;
    }
    
    protected NBTTagList newFloatNBTList(final float... llllllllllllllllIlIIlIIlIIlllIll) {
        final NBTTagList llllllllllllllllIlIIlIIlIIllllIl = new NBTTagList();
        final byte llllllllllllllllIlIIlIIlIIllIllI = (Object)llllllllllllllllIlIIlIIlIIlllIll;
        final boolean llllllllllllllllIlIIlIIlIIllIlll = llllllllllllllllIlIIlIIlIIlllIll.length != 0;
        for (long llllllllllllllllIlIIlIIlIIlllIII = 0; llllllllllllllllIlIIlIIlIIlllIII < (llllllllllllllllIlIIlIIlIIllIlll ? 1 : 0); ++llllllllllllllllIlIIlIIlIIlllIII) {
            final float llllllllllllllllIlIIlIIlIIllllII = llllllllllllllllIlIIlIIlIIllIllI[llllllllllllllllIlIIlIIlIIlllIII];
            llllllllllllllllIlIIlIIlIIllllIl.appendTag(new NBTTagFloat(llllllllllllllllIlIIlIIlIIllllII));
        }
        return llllllllllllllllIlIIlIIlIIllllIl;
    }
    
    public void onUpdate() {
        if (!this.world.isRemote) {
            this.setFlag(6, this.isGlowing());
        }
        this.onEntityUpdate();
    }
    
    public double getDistanceSqToEntity(final Entity llllllllllllllllIlIIlIlIlIIIIIIl) {
        final double llllllllllllllllIlIIlIlIlIIIIIII = this.posX - llllllllllllllllIlIIlIlIlIIIIIIl.posX;
        final double llllllllllllllllIlIIlIlIIlllllll = this.posY - llllllllllllllllIlIIlIlIlIIIIIIl.posY;
        final double llllllllllllllllIlIIlIlIIllllllI = this.posZ - llllllllllllllllIlIIlIlIlIIIIIIl.posZ;
        return llllllllllllllllIlIIlIlIlIIIIIII * llllllllllllllllIlIIlIlIlIIIIIII + llllllllllllllllIlIIlIlIIlllllll * llllllllllllllllIlIIlIlIIlllllll + llllllllllllllllIlIIlIlIIllllllI * llllllllllllllllIlIIlIlIIllllllI;
    }
    
    public Vec3d getLookVec() {
        return this.getVectorForRotation(this.rotationPitch, this.rotationYaw);
    }
    
    public boolean isOutsideBorder() {
        return this.isOutsideBorder;
    }
    
    @Nullable
    @Override
    public MinecraftServer getServer() {
        return this.world.getMinecraftServer();
    }
    
    protected final Vec3d getVectorForRotation(final float llllllllllllllllIlIIlIlIIIlIIlIl, final float llllllllllllllllIlIIlIlIIIlIlllI) {
        final float llllllllllllllllIlIIlIlIIIlIllIl = MathHelper.cos(-llllllllllllllllIlIIlIlIIIlIlllI * 0.017453292f - 3.1415927f);
        final float llllllllllllllllIlIIlIlIIIlIlIll = MathHelper.sin(-llllllllllllllllIlIIlIlIIIlIlllI * 0.017453292f - 3.1415927f);
        final float llllllllllllllllIlIIlIlIIIlIlIIl = -MathHelper.cos(-llllllllllllllllIlIIlIlIIIlIIlIl * 0.017453292f);
        final float llllllllllllllllIlIIlIlIIIlIIlll = MathHelper.sin(-llllllllllllllllIlIIlIlIIIlIIlIl * 0.017453292f);
        return new Vec3d(llllllllllllllllIlIIlIlIIIlIlIll * llllllllllllllllIlIIlIlIIIlIlIIl, llllllllllllllllIlIIlIlIIIlIIlll, llllllllllllllllIlIIlIlIIIlIllIl * llllllllllllllllIlIIlIlIIIlIlIIl);
    }
    
    public Vec3d getForward() {
        return Vec3d.fromPitchYawVector(this.getPitchYaw());
    }
    
    public boolean isInWater() {
        return this.inWater;
    }
    
    public void addTrackingPlayer(final EntityPlayerMP llllllllllllllllIlIIIllIlIllllII) {
    }
    
    public boolean getAlwaysRenderNameTagForRender() {
        return this.getAlwaysRenderNameTag();
    }
    
    @Override
    public Entity getCommandSenderEntity() {
        return this;
    }
    
    public void setVelocity(final double llllllllllllllllIlIIlIIIlIIIIIII, final double llllllllllllllllIlIIlIIIIlllllll, final double llllllllllllllllIlIIlIIIIllllIlI) {
        this.motionX = llllllllllllllllIlIIlIIIlIIIIIII;
        this.motionY = llllllllllllllllIlIIlIIIIlllllll;
        this.motionZ = llllllllllllllllIlIIlIIIIllllIlI;
    }
    
    public void updatePassenger(final Entity llllllllllllllllIlIIlIIIlllIllll) {
        if (this.isPassenger(llllllllllllllllIlIIlIIIlllIllll)) {
            llllllllllllllllIlIIlIIIlllIllll.setPosition(this.posX, this.posY + this.getMountedYOffset() + llllllllllllllllIlIIlIIIlllIllll.getYOffset(), this.posZ);
        }
    }
    
    private boolean isLiquidPresentInAABB(final AxisAlignedBB llllllllllllllllIlIIllIlIllIIIll) {
        return this.world.getCollisionBoxes(this, llllllllllllllllIlIIllIlIllIIIll).isEmpty() && !this.world.containsAnyLiquid(llllllllllllllllIlIIllIlIllIIIll);
    }
    
    protected abstract void writeEntityToNBT(final NBTTagCompound p0);
    
    public boolean startRiding(final Entity llllllllllllllllIlIIlIIIlllIIIll) {
        return this.startRiding(llllllllllllllllIlIIlIIIlllIIIll, false);
    }
    
    @Nullable
    public RayTraceResult rayTrace(final double llllllllllllllllIlIIlIIllllIlIlI, final float llllllllllllllllIlIIlIIllllIlIIl) {
        final Vec3d llllllllllllllllIlIIlIIllllIlIII = this.getPositionEyes(llllllllllllllllIlIIlIIllllIlIIl);
        final Vec3d llllllllllllllllIlIIlIIllllIIlll = this.getLook(llllllllllllllllIlIIlIIllllIlIIl);
        final Vec3d llllllllllllllllIlIIlIIllllIIllI = llllllllllllllllIlIIlIIllllIlIII.addVector(llllllllllllllllIlIIlIIllllIIlll.xCoord * llllllllllllllllIlIIlIIllllIlIlI, llllllllllllllllIlIIlIIllllIIlll.yCoord * llllllllllllllllIlIIlIIllllIlIlI, llllllllllllllllIlIIlIIllllIIlll.zCoord * llllllllllllllllIlIIlIIllllIlIlI);
        return this.world.rayTraceBlocks(llllllllllllllllIlIIlIIllllIlIII, llllllllllllllllIlIIlIIllllIIllI, false, false, true);
    }
    
    public void setPositionAndRotation(final double llllllllllllllllIlIIlIlIllllIlll, final double llllllllllllllllIlIIlIlIlllIllll, final double llllllllllllllllIlIIlIlIlllIlllI, final float llllllllllllllllIlIIlIlIlllIllIl, float llllllllllllllllIlIIlIlIlllIllII) {
        this.posX = MathHelper.clamp(llllllllllllllllIlIIlIlIllllIlll, -3.0E7, 3.0E7);
        this.posY = llllllllllllllllIlIIlIlIlllIllll;
        this.posZ = MathHelper.clamp(llllllllllllllllIlIIlIlIlllIlllI, -3.0E7, 3.0E7);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        llllllllllllllllIlIIlIlIlllIllII = MathHelper.clamp(llllllllllllllllIlIIlIlIlllIllII, -90.0f, 90.0f);
        this.rotationYaw = llllllllllllllllIlIIlIlIlllIllIl;
        this.rotationPitch = llllllllllllllllIlIIlIlIlllIllII;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        final double llllllllllllllllIlIIlIlIllllIIlI = this.prevRotationYaw - llllllllllllllllIlIIlIlIlllIllIl;
        if (llllllllllllllllIlIIlIlIllllIIlI < -180.0) {
            this.prevRotationYaw += 360.0f;
        }
        if (llllllllllllllllIlIIlIlIllllIIlI >= 180.0) {
            this.prevRotationYaw -= 360.0f;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setRotation(llllllllllllllllIlIIlIlIlllIllIl, llllllllllllllllIlIIlIlIlllIllII);
    }
    
    public void dismountRidingEntity() {
        if (this.ridingEntity != null) {
            final Entity llllllllllllllllIlIIlIIIllIIlIIl = this.ridingEntity;
            this.ridingEntity = null;
            llllllllllllllllIlIIlIIIllIIlIIl.removePassenger(this);
        }
    }
    
    public boolean isSprinting() {
        return this.getFlag(3);
    }
    
    protected boolean getFlag(final int llllllllllllllllIlIIlIIIIIlIIIIl) {
        return (this.dataManager.get(Entity.FLAGS) & 1 << llllllllllllllllIlIIlIIIIIlIIIIl) != 0x0;
    }
    
    protected boolean canTriggerWalking() {
        return true;
    }
    
    protected boolean canFitPassenger(final Entity llllllllllllllllIlIIlIIIlIlllIII) {
        return this.getPassengers().size() < 1;
    }
    
    @Nullable
    public EntityItem entityDropItem(final ItemStack llllllllllllllllIlIIlIIlIIIllIll, final float llllllllllllllllIlIIlIIlIIIllIlI) {
        if (llllllllllllllllIlIIlIIlIIIllIll.func_190926_b()) {
            return null;
        }
        final EntityItem llllllllllllllllIlIIlIIlIIIllIIl = new EntityItem(this.world, this.posX, this.posY + llllllllllllllllIlIIlIIlIIIllIlI, this.posZ, llllllllllllllllIlIIlIIlIIIllIll);
        llllllllllllllllIlIIlIIlIIIllIIl.setDefaultPickupDelay();
        this.world.spawnEntityInWorld(llllllllllllllllIlIIlIIlIIIllIIl);
        return llllllllllllllllIlIIlIIlIIIllIIl;
    }
    
    public boolean isSilent() {
        return this.dataManager.get(Entity.SILENT);
    }
    
    protected void resetHeight() {
        final Entity llllllllllllllllIlIIlIllIllIlIll = (this.isBeingRidden() && this.getControllingPassenger() != null) ? this.getControllingPassenger() : this;
        final float llllllllllllllllIlIIlIllIllIlIlI = (llllllllllllllllIlIIlIllIllIlIll == this) ? 0.2f : 0.9f;
        float llllllllllllllllIlIIlIllIllIlIIl = MathHelper.sqrt(llllllllllllllllIlIIlIllIllIlIll.motionX * llllllllllllllllIlIIlIllIllIlIll.motionX * 0.20000000298023224 + llllllllllllllllIlIIlIllIllIlIll.motionY * llllllllllllllllIlIIlIllIllIlIll.motionY + llllllllllllllllIlIIlIllIllIlIll.motionZ * llllllllllllllllIlIIlIllIllIlIll.motionZ * 0.20000000298023224) * llllllllllllllllIlIIlIllIllIlIlI;
        if (llllllllllllllllIlIIlIllIllIlIIl > 1.0f) {
            llllllllllllllllIlIIlIllIllIlIIl = 1.0f;
        }
        this.playSound(this.getSplashSound(), llllllllllllllllIlIIlIllIllIlIIl, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
        final float llllllllllllllllIlIIlIllIllIlIII = (float)MathHelper.floor(this.getEntityBoundingBox().minY);
        for (int llllllllllllllllIlIIlIllIllIIlll = 0; llllllllllllllllIlIIlIllIllIIlll < 1.0f + this.width * 20.0f; ++llllllllllllllllIlIIlIllIllIIlll) {
            final float llllllllllllllllIlIIlIllIllIIllI = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            final float llllllllllllllllIlIIlIllIllIIlIl = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + llllllllllllllllIlIIlIllIllIIllI, llllllllllllllllIlIIlIllIllIlIII + 1.0f, this.posZ + llllllllllllllllIlIIlIllIllIIlIl, this.motionX, this.motionY - this.rand.nextFloat() * 0.2f, this.motionZ, new int[0]);
        }
        for (int llllllllllllllllIlIIlIllIllIIlII = 0; llllllllllllllllIlIIlIllIllIIlII < 1.0f + this.width * 20.0f; ++llllllllllllllllIlIIlIllIllIIlII) {
            final float llllllllllllllllIlIIlIllIllIIIll = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            final float llllllllllllllllIlIIlIllIllIIIlI = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + llllllllllllllllIlIIlIllIllIIIll, llllllllllllllllIlIIlIllIllIlIII + 1.0f, this.posZ + llllllllllllllllIlIIlIllIllIIIlI, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
    }
    
    public double getDistanceSq(final double llllllllllllllllIlIIlIlIlIlIlllI, final double llllllllllllllllIlIIlIlIlIllIlII, final double llllllllllllllllIlIIlIlIlIlIllII) {
        final double llllllllllllllllIlIIlIlIlIllIIlI = this.posX - llllllllllllllllIlIIlIlIlIlIlllI;
        final double llllllllllllllllIlIIlIlIlIllIIIl = this.posY - llllllllllllllllIlIIlIlIlIllIlII;
        final double llllllllllllllllIlIIlIlIlIllIIII = this.posZ - llllllllllllllllIlIIlIlIlIlIllII;
        return llllllllllllllllIlIIlIlIlIllIIlI * llllllllllllllllIlIIlIlIlIllIIlI + llllllllllllllllIlIIlIlIlIllIIIl * llllllllllllllllIlIIlIlIlIllIIIl + llllllllllllllllIlIIlIlIlIllIIII * llllllllllllllllIlIIlIlIlIllIIII;
    }
    
    public double getDistanceSqToCenter(final BlockPos llllllllllllllllIlIIlIlIlIIlllll) {
        return llllllllllllllllIlIIlIlIlIIlllll.distanceSqToCenter(this.posX, this.posY, this.posZ);
    }
    
    public boolean isSpectatedByPlayer(final EntityPlayerMP llllllllllllllllIlIIIlllIIIIllII) {
        return true;
    }
    
    public void setDead() {
        this.isDead = true;
    }
    
    public void addVelocity(final double llllllllllllllllIlIIlIlIIlIllIll, final double llllllllllllllllIlIIlIlIIlIllIlI, final double llllllllllllllllIlIIlIlIIlIllIIl) {
        this.motionX += llllllllllllllllIlIIlIlIIlIllIll;
        this.motionY += llllllllllllllllIlIIlIlIIlIllIlI;
        this.motionZ += llllllllllllllllIlIIlIlIIlIllIIl;
        this.isAirBorne = true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = Entity.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final boolean llllllllllllllllIlIIIllIIlIlIIII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIlIIIllIIlIlIIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIlIIIllIIlIlIIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIlIIIllIIlIlIIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIlIIIllIIlIlIIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Entity.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIlIIIllIIlIlIIII;
    }
    
    public EnumPushReaction getPushReaction() {
        return EnumPushReaction.NORMAL;
    }
    
    public void setAngles(final float llllllllllllllllIlIIllIllIllIIll, final float llllllllllllllllIlIIllIllIlIllIl) {
        final float llllllllllllllllIlIIllIllIllIIIl = this.rotationPitch;
        final float llllllllllllllllIlIIllIllIllIIII = this.rotationYaw;
        this.rotationYaw += (float)(llllllllllllllllIlIIllIllIllIIll * 0.15);
        this.rotationPitch -= (float)(llllllllllllllllIlIIllIllIlIllIl * 0.15);
        this.rotationPitch = MathHelper.clamp(this.rotationPitch, -90.0f, 90.0f);
        this.prevRotationPitch += this.rotationPitch - llllllllllllllllIlIIllIllIllIIIl;
        this.prevRotationYaw += this.rotationYaw - llllllllllllllllIlIIllIllIllIIII;
        if (this.ridingEntity != null) {
            this.ridingEntity.applyOrientationToEntity(this);
        }
    }
    
    public float getEyeHeight() {
        return this.height * 0.85f;
    }
    
    @Override
    public int hashCode() {
        return this.entityId;
    }
    
    protected void setBeenAttacked() {
        this.velocityChanged = true;
    }
    
    public void onKillCommand() {
        this.setDead();
    }
    
    public void setOutsideBorder(final boolean llllllllllllllllIlIIIllIllllIllI) {
        this.isOutsideBorder = llllllllllllllllIlIIIllIllllIllI;
    }
    
    @Override
    public World getEntityWorld() {
        return this.world;
    }
    
    public float getDistanceToEntity(final Entity llllllllllllllllIlIIlIlIllIIIllI) {
        final float llllllllllllllllIlIIlIlIllIIIlIl = (float)(this.posX - llllllllllllllllIlIIlIlIllIIIllI.posX);
        final float llllllllllllllllIlIIlIlIllIIIlII = (float)(this.posY - llllllllllllllllIlIIlIlIllIIIllI.posY);
        final float llllllllllllllllIlIIlIlIllIIIIll = (float)(this.posZ - llllllllllllllllIlIIlIlIllIIIllI.posZ);
        return MathHelper.sqrt(llllllllllllllllIlIIlIlIllIIIlIl * llllllllllllllllIlIIlIlIllIIIlIl + llllllllllllllllIlIIlIlIllIIIlII * llllllllllllllllIlIIlIlIllIIIlII + llllllllllllllllIlIIlIlIllIIIIll * llllllllllllllllIlIIlIlIllIIIIll);
    }
    
    public boolean isInvisibleToPlayer(final EntityPlayer llllllllllllllllIlIIlIIIIlIIIIII) {
        if (llllllllllllllllIlIIlIIIIlIIIIII.isSpectator()) {
            return false;
        }
        final Team llllllllllllllllIlIIlIIIIIllllll = this.getTeam();
        return (llllllllllllllllIlIIlIIIIIllllll == null || llllllllllllllllIlIIlIIIIlIIIIII == null || llllllllllllllllIlIIlIIIIlIIIIII.getTeam() != llllllllllllllllIlIIlIIIIIllllll || !llllllllllllllllIlIIlIIIIIllllll.getSeeFriendlyInvisiblesEnabled()) && this.isInvisible();
    }
    
    protected void removePassenger(final Entity llllllllllllllllIlIIlIIIlIlllIll) {
        if (llllllllllllllllIlIIlIIIlIlllIll.getRidingEntity() == this) {
            throw new IllegalStateException("Use x.stopRiding(y), not y.removePassenger(x)");
        }
        this.riddenByEntities.remove(llllllllllllllllIlIIlIIIlIlllIll);
        llllllllllllllllIlIIlIIIlIlllIll.rideCooldown = 60;
    }
    
    public void setPosition(final double llllllllllllllllIlIIllIlllIIIlII, final double llllllllllllllllIlIIllIllIllllIl, final double llllllllllllllllIlIIllIllIllllII) {
        this.posX = llllllllllllllllIlIIllIlllIIIlII;
        this.posY = llllllllllllllllIlIIllIllIllllIl;
        this.posZ = llllllllllllllllIlIIllIllIllllII;
        final float llllllllllllllllIlIIllIlllIIIIIl = this.width / 2.0f;
        final float llllllllllllllllIlIIllIlllIIIIII = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(llllllllllllllllIlIIllIlllIIIlII - llllllllllllllllIlIIllIlllIIIIIl, llllllllllllllllIlIIllIllIllllIl, llllllllllllllllIlIIllIllIllllII - llllllllllllllllIlIIllIlllIIIIIl, llllllllllllllllIlIIllIlllIIIlII + llllllllllllllllIlIIllIlllIIIIIl, llllllllllllllllIlIIllIllIllllIl + llllllllllllllllIlIIllIlllIIIIII, llllllllllllllllIlIIllIllIllllII + llllllllllllllllIlIIllIlllIIIIIl));
    }
    
    public void setUniqueId(final UUID llllllllllllllllIlIIIlllIlIlIIll) {
        this.entityUniqueID = llllllllllllllllIlIIIlllIlIlIIll;
        this.cachedUniqueIdString = this.entityUniqueID.toString();
    }
    
    public void fall(final float llllllllllllllllIlIIlIlllIIIIlll, final float llllllllllllllllIlIIlIlllIIIlIlI) {
        if (this.isBeingRidden()) {
            for (final Entity llllllllllllllllIlIIlIlllIIIlIIl : this.getPassengers()) {
                llllllllllllllllIlIIlIlllIIIlIIl.fall(llllllllllllllllIlIIlIlllIIIIlll, llllllllllllllllIlIIlIlllIIIlIlI);
            }
        }
    }
    
    public boolean isInLava() {
        return this.world.isMaterialInBB(this.getEntityBoundingBox().expand(-0.10000000149011612, -0.4000000059604645, -0.10000000149011612), Material.LAVA);
    }
    
    public CommandResultStats getCommandStats() {
        return this.cmdResultStats;
    }
    
    @Override
    public Vec3d getPositionVector() {
        return new Vec3d(this.posX, this.posY, this.posZ);
    }
    
    public boolean addTag(final String llllllllllllllllIlIIlllIIIIIIIlI) {
        if (this.tags.size() >= 1024) {
            return false;
        }
        this.tags.add(llllllllllllllllIlIIlllIIIIIIIlI);
        return true;
    }
    
    public void readFromNBT(final NBTTagCompound llllllllllllllllIlIIlIIlIllIIIll) {
        try {
            final NBTTagList llllllllllllllllIlIIlIIlIllIllIl = llllllllllllllllIlIIlIIlIllIIIll.getTagList("Pos", 6);
            final NBTTagList llllllllllllllllIlIIlIIlIllIllII = llllllllllllllllIlIIlIIlIllIIIll.getTagList("Motion", 6);
            final NBTTagList llllllllllllllllIlIIlIIlIllIlIll = llllllllllllllllIlIIlIIlIllIIIll.getTagList("Rotation", 5);
            this.motionX = llllllllllllllllIlIIlIIlIllIllII.getDoubleAt(0);
            this.motionY = llllllllllllllllIlIIlIIlIllIllII.getDoubleAt(1);
            this.motionZ = llllllllllllllllIlIIlIIlIllIllII.getDoubleAt(2);
            if (Math.abs(this.motionX) > 10.0) {
                this.motionX = 0.0;
            }
            if (Math.abs(this.motionY) > 10.0) {
                this.motionY = 0.0;
            }
            if (Math.abs(this.motionZ) > 10.0) {
                this.motionZ = 0.0;
            }
            this.posX = llllllllllllllllIlIIlIIlIllIllIl.getDoubleAt(0);
            this.posY = llllllllllllllllIlIIlIIlIllIllIl.getDoubleAt(1);
            this.posZ = llllllllllllllllIlIIlIIlIllIllIl.getDoubleAt(2);
            this.lastTickPosX = this.posX;
            this.lastTickPosY = this.posY;
            this.lastTickPosZ = this.posZ;
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.rotationYaw = llllllllllllllllIlIIlIIlIllIlIll.getFloatAt(0);
            this.rotationPitch = llllllllllllllllIlIIlIIlIllIlIll.getFloatAt(1);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
            this.setRotationYawHead(this.rotationYaw);
            this.setRenderYawOffset(this.rotationYaw);
            this.fallDistance = llllllllllllllllIlIIlIIlIllIIIll.getFloat("FallDistance");
            this.field_190534_ay = llllllllllllllllIlIIlIIlIllIIIll.getShort("Fire");
            this.setAir(llllllllllllllllIlIIlIIlIllIIIll.getShort("Air"));
            this.onGround = llllllllllllllllIlIIlIIlIllIIIll.getBoolean("OnGround");
            if (llllllllllllllllIlIIlIIlIllIIIll.hasKey("Dimension")) {
                this.dimension = llllllllllllllllIlIIlIIlIllIIIll.getInteger("Dimension");
            }
            this.invulnerable = llllllllllllllllIlIIlIIlIllIIIll.getBoolean("Invulnerable");
            this.timeUntilPortal = llllllllllllllllIlIIlIIlIllIIIll.getInteger("PortalCooldown");
            if (llllllllllllllllIlIIlIIlIllIIIll.hasUniqueId("UUID")) {
                this.entityUniqueID = llllllllllllllllIlIIlIIlIllIIIll.getUniqueId("UUID");
                this.cachedUniqueIdString = this.entityUniqueID.toString();
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (llllllllllllllllIlIIlIIlIllIIIll.hasKey("CustomName", 8)) {
                this.setCustomNameTag(llllllllllllllllIlIIlIIlIllIIIll.getString("CustomName"));
            }
            this.setAlwaysRenderNameTag(llllllllllllllllIlIIlIIlIllIIIll.getBoolean("CustomNameVisible"));
            this.cmdResultStats.readStatsFromNBT(llllllllllllllllIlIIlIIlIllIIIll);
            this.setSilent(llllllllllllllllIlIIlIIlIllIIIll.getBoolean("Silent"));
            this.setNoGravity(llllllllllllllllIlIIlIIlIllIIIll.getBoolean("NoGravity"));
            this.setGlowing(llllllllllllllllIlIIlIIlIllIIIll.getBoolean("Glowing"));
            if (llllllllllllllllIlIIlIIlIllIIIll.hasKey("Tags", 9)) {
                this.tags.clear();
                final NBTTagList llllllllllllllllIlIIlIIlIllIlIlI = llllllllllllllllIlIIlIIlIllIIIll.getTagList("Tags", 8);
                for (int llllllllllllllllIlIIlIIlIllIlIIl = Math.min(llllllllllllllllIlIIlIIlIllIlIlI.tagCount(), 1024), llllllllllllllllIlIIlIIlIllIlIII = 0; llllllllllllllllIlIIlIIlIllIlIII < llllllllllllllllIlIIlIIlIllIlIIl; ++llllllllllllllllIlIIlIIlIllIlIII) {
                    this.tags.add(llllllllllllllllIlIIlIIlIllIlIlI.getStringTagAt(llllllllllllllllIlIIlIIlIllIlIII));
                }
            }
            this.readEntityFromNBT(llllllllllllllllIlIIlIIlIllIIIll);
            if (this.shouldSetPosAfterLoading()) {
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        catch (Throwable llllllllllllllllIlIIlIIlIllIIlll) {
            final CrashReport llllllllllllllllIlIIlIIlIllIIllI = CrashReport.makeCrashReport(llllllllllllllllIlIIlIIlIllIIlll, "Loading entity NBT");
            final CrashReportCategory llllllllllllllllIlIIlIIlIllIIlIl = llllllllllllllllIlIIlIIlIllIIllI.makeCategory("Entity being loaded");
            this.addEntityCrashInfo(llllllllllllllllIlIIlIIlIllIIlIl);
            throw new ReportedException(llllllllllllllllIlIIlIIlIllIIllI);
        }
    }
    
    protected abstract void entityInit();
    
    public void setLocationAndAngles(final double llllllllllllllllIlIIlIlIllIlIlll, final double llllllllllllllllIlIIlIlIllIlIllI, final double llllllllllllllllIlIIlIlIllIIllll, final float llllllllllllllllIlIIlIlIllIIlllI, final float llllllllllllllllIlIIlIlIllIIllIl) {
        this.posX = llllllllllllllllIlIIlIlIllIlIlll;
        this.posY = llllllllllllllllIlIIlIlIllIlIllI;
        this.posZ = llllllllllllllllIlIIlIlIllIIllll;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        this.rotationYaw = llllllllllllllllIlIIlIlIllIIlllI;
        this.rotationPitch = llllllllllllllllIlIIlIlIllIIllIl;
        this.setPosition(this.posX, this.posY, this.posZ);
    }
    
    public int getBrightnessForRender() {
        final BlockPos.MutableBlockPos llllllllllllllllIlIIlIllIIIIlllI = new BlockPos.MutableBlockPos(MathHelper.floor(this.posX), 0, MathHelper.floor(this.posZ));
        if (this.world.isBlockLoaded(llllllllllllllllIlIIlIllIIIIlllI)) {
            llllllllllllllllIlIIlIllIIIIlllI.setY(MathHelper.floor(this.posY + this.getEyeHeight()));
            return this.world.getCombinedLight(llllllllllllllllIlIIlIllIIIIlllI, 0);
        }
        return 0;
    }
    
    public void playSound(final SoundEvent llllllllllllllllIlIIlIlllllIIIll, final float llllllllllllllllIlIIlIlllllIIIIl, final float llllllllllllllllIlIIlIlllllIIlll) {
        if (!this.isSilent()) {
            this.world.playSound(null, this.posX, this.posY, this.posZ, llllllllllllllllIlIIlIlllllIIIll, this.getSoundCategory(), llllllllllllllllIlIIlIlllllIIIIl, llllllllllllllllIlIIlIlllllIIlll);
        }
    }
    
    public void setRotationYawHead(final float llllllllllllllllIlIIIlllllIIllll) {
    }
    
    public Collection<Entity> getRecursivePassengers() {
        final Set<Entity> llllllllllllllllIlIIIllIlIIIlllI = (Set<Entity>)Sets.newHashSet();
        this.getRecursivePassengersByType(Entity.class, llllllllllllllllIlIIIllIlIIIlllI);
        return llllllllllllllllIlIIIllIlIIIlllI;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllllIlIIlIIllIIIIllI) {
        try {
            llllllllllllllllIlIIlIIllIIIIllI.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY, this.posZ));
            llllllllllllllllIlIIlIIllIIIIllI.setTag("Motion", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
            llllllllllllllllIlIIlIIllIIIIllI.setTag("Rotation", this.newFloatNBTList(this.rotationYaw, this.rotationPitch));
            llllllllllllllllIlIIlIIllIIIIllI.setFloat("FallDistance", this.fallDistance);
            llllllllllllllllIlIIlIIllIIIIllI.setShort("Fire", (short)this.field_190534_ay);
            llllllllllllllllIlIIlIIllIIIIllI.setShort("Air", (short)this.getAir());
            llllllllllllllllIlIIlIIllIIIIllI.setBoolean("OnGround", this.onGround);
            llllllllllllllllIlIIlIIllIIIIllI.setInteger("Dimension", this.dimension);
            llllllllllllllllIlIIlIIllIIIIllI.setBoolean("Invulnerable", this.invulnerable);
            llllllllllllllllIlIIlIIllIIIIllI.setInteger("PortalCooldown", this.timeUntilPortal);
            llllllllllllllllIlIIlIIllIIIIllI.setUniqueId("UUID", this.getUniqueID());
            if (this.hasCustomName()) {
                llllllllllllllllIlIIlIIllIIIIllI.setString("CustomName", this.getCustomNameTag());
            }
            if (this.getAlwaysRenderNameTag()) {
                llllllllllllllllIlIIlIIllIIIIllI.setBoolean("CustomNameVisible", this.getAlwaysRenderNameTag());
            }
            this.cmdResultStats.writeStatsToNBT(llllllllllllllllIlIIlIIllIIIIllI);
            if (this.isSilent()) {
                llllllllllllllllIlIIlIIllIIIIllI.setBoolean("Silent", this.isSilent());
            }
            if (this.hasNoGravity()) {
                llllllllllllllllIlIIlIIllIIIIllI.setBoolean("NoGravity", this.hasNoGravity());
            }
            if (this.glowing) {
                llllllllllllllllIlIIlIIllIIIIllI.setBoolean("Glowing", this.glowing);
            }
            if (!this.tags.isEmpty()) {
                final NBTTagList llllllllllllllllIlIIlIIllIIIIlIl = new NBTTagList();
                for (final String llllllllllllllllIlIIlIIllIIIIlII : this.tags) {
                    llllllllllllllllIlIIlIIllIIIIlIl.appendTag(new NBTTagString(llllllllllllllllIlIIlIIllIIIIlII));
                }
                llllllllllllllllIlIIlIIllIIIIllI.setTag("Tags", llllllllllllllllIlIIlIIllIIIIlIl);
            }
            this.writeEntityToNBT(llllllllllllllllIlIIlIIllIIIIllI);
            if (this.isBeingRidden()) {
                final NBTTagList llllllllllllllllIlIIlIIllIIIIIll = new NBTTagList();
                for (final Entity llllllllllllllllIlIIlIIllIIIIIlI : this.getPassengers()) {
                    final NBTTagCompound llllllllllllllllIlIIlIIllIIIIIIl = new NBTTagCompound();
                    if (llllllllllllllllIlIIlIIllIIIIIlI.writeToNBTAtomically(llllllllllllllllIlIIlIIllIIIIIIl)) {
                        llllllllllllllllIlIIlIIllIIIIIll.appendTag(llllllllllllllllIlIIlIIllIIIIIIl);
                    }
                }
                if (!llllllllllllllllIlIIlIIllIIIIIll.hasNoTags()) {
                    llllllllllllllllIlIIlIIllIIIIllI.setTag("Passengers", llllllllllllllllIlIIlIIllIIIIIll);
                }
            }
            return llllllllllllllllIlIIlIIllIIIIllI;
        }
        catch (Throwable llllllllllllllllIlIIlIIllIIIIIII) {
            final CrashReport llllllllllllllllIlIIlIIlIlllllll = CrashReport.makeCrashReport(llllllllllllllllIlIIlIIllIIIIIII, "Saving entity NBT");
            final CrashReportCategory llllllllllllllllIlIIlIIlIllllllI = llllllllllllllllIlIIlIIlIlllllll.makeCategory("Entity being saved");
            this.addEntityCrashInfo(llllllllllllllllIlIIlIIlIllllllI);
            throw new ReportedException(llllllllllllllllIlIIlIIlIlllllll);
        }
    }
    
    protected void setSize(final float llllllllllllllllIlIIllIlllIllIII, final float llllllllllllllllIlIIllIlllIlllIl) {
        if (llllllllllllllllIlIIllIlllIllIII != this.width || llllllllllllllllIlIIllIlllIlllIl != this.height) {
            final float llllllllllllllllIlIIllIlllIlllII = this.width;
            this.width = llllllllllllllllIlIIllIlllIllIII;
            this.height = llllllllllllllllIlIIllIlllIlllIl;
            if (this.width < llllllllllllllllIlIIllIlllIlllII) {
                final double llllllllllllllllIlIIllIlllIllIll = llllllllllllllllIlIIllIlllIllIII / 2.0;
                this.setEntityBoundingBox(new AxisAlignedBB(this.posX - llllllllllllllllIlIIllIlllIllIll, this.posY, this.posZ - llllllllllllllllIlIIllIlllIllIll, this.posX + llllllllllllllllIlIIllIlllIllIll, this.posY + this.height, this.posZ + llllllllllllllllIlIIllIlllIllIll));
                return;
            }
            final AxisAlignedBB llllllllllllllllIlIIllIlllIllIlI = this.getEntityBoundingBox();
            this.setEntityBoundingBox(new AxisAlignedBB(llllllllllllllllIlIIllIlllIllIlI.minX, llllllllllllllllIlIIllIlllIllIlI.minY, llllllllllllllllIlIIllIlllIllIlI.minZ, llllllllllllllllIlIIllIlllIllIlI.minX + this.width, llllllllllllllllIlIIllIlllIllIlI.minY + this.height, llllllllllllllllIlIIllIlllIllIlI.minZ + this.width));
            if (this.width > llllllllllllllllIlIIllIlllIlllII && !this.firstUpdate && !this.world.isRemote) {
                this.moveEntity(MoverType.SELF, llllllllllllllllIlIIllIlllIlllII - this.width, 0.0, llllllllllllllllIlIIllIlllIlllII - this.width);
            }
        }
    }
    
    public void handleStatusUpdate(final byte llllllllllllllllIlIIlIIIIllllIII) {
    }
    
    public boolean startRiding(final Entity llllllllllllllllIlIIlIIIllIlllIl, final boolean llllllllllllllllIlIIlIIIllIlllII) {
        for (Entity llllllllllllllllIlIIlIIIllIllIll = llllllllllllllllIlIIlIIIllIlllIl; llllllllllllllllIlIIlIIIllIllIll.ridingEntity != null; llllllllllllllllIlIIlIIIllIllIll = llllllllllllllllIlIIlIIIllIllIll.ridingEntity) {
            if (llllllllllllllllIlIIlIIIllIllIll.ridingEntity == this) {
                return false;
            }
        }
        if (llllllllllllllllIlIIlIIIllIlllII || (this.canBeRidden(llllllllllllllllIlIIlIIIllIlllIl) && llllllllllllllllIlIIlIIIllIlllIl.canFitPassenger(this))) {
            if (this.isRiding()) {
                this.dismountRidingEntity();
            }
            this.ridingEntity = llllllllllllllllIlIIlIIIllIlllIl;
            this.ridingEntity.addPassenger(this);
            return true;
        }
        return false;
    }
    
    public boolean handleWaterMovement() {
        if (this.getRidingEntity() instanceof EntityBoat) {
            this.inWater = false;
        }
        else if (this.world.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -0.4000000059604645, 0.0).contract(0.001), Material.WATER, this)) {
            if (!this.inWater && !this.firstUpdate) {
                this.resetHeight();
            }
            this.fallDistance = 0.0f;
            this.inWater = true;
            this.extinguish();
        }
        else {
            this.inWater = false;
        }
        return this.inWater;
    }
    
    public boolean isOffsetPositionInLiquid(final double llllllllllllllllIlIIllIlIllIlIlI, final double llllllllllllllllIlIIllIlIllIlIIl, final double llllllllllllllllIlIIllIlIllIlIII) {
        final AxisAlignedBB llllllllllllllllIlIIllIlIllIllII = this.getEntityBoundingBox().offset(llllllllllllllllIlIIllIlIllIlIlI, llllllllllllllllIlIIllIlIllIlIIl, llllllllllllllllIlIIllIlIllIlIII);
        return this.isLiquidPresentInAABB(llllllllllllllllIlIIllIlIllIllII);
    }
    
    public boolean isRidingOrBeingRiddenBy(final Entity llllllllllllllllIlIIIllIIllIIIll) {
        for (final Entity llllllllllllllllIlIIIllIIllIIIlI : this.getPassengers()) {
            if (llllllllllllllllIlIIIllIIllIIIlI.equals(llllllllllllllllIlIIIllIIllIIIll)) {
                return true;
            }
            if (llllllllllllllllIlIIIllIIllIIIlI.isRidingOrBeingRiddenBy(llllllllllllllllIlIIIllIIllIIIll)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isRidingSameEntity(final Entity llllllllllllllllIlIIIllIIllIlIll) {
        return this.getLowestRidingEntity() == llllllllllllllllIlIIIllIIllIlIll.getLowestRidingEntity();
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public boolean hitByEntity(final Entity llllllllllllllllIlIIIlllllIIlIlI) {
        return false;
    }
    
    protected void setRotation(final float llllllllllllllllIlIIllIlllIIllIl, final float llllllllllllllllIlIIllIlllIIllll) {
        this.rotationYaw = llllllllllllllllIlIIllIlllIIllIl % 360.0f;
        this.rotationPitch = llllllllllllllllIlIIllIlllIIllll % 360.0f;
    }
    
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIlIIlIlIIlIlIIlI, final float llllllllllllllllIlIIlIlIIlIlIIIl) {
        if (this.isEntityInvulnerable(llllllllllllllllIlIIlIlIIlIlIIlI)) {
            return false;
        }
        this.setBeenAttacked();
        return false;
    }
    
    protected void applyEnchantments(final EntityLivingBase llllllllllllllllIlIIIllIllIIIIIl, final Entity llllllllllllllllIlIIIllIlIlllllI) {
        if (llllllllllllllllIlIIIllIlIlllllI instanceof EntityLivingBase) {
            EnchantmentHelper.applyThornEnchantments((EntityLivingBase)llllllllllllllllIlIIIllIlIlllllI, llllllllllllllllIlIIIllIllIIIIIl);
        }
        EnchantmentHelper.applyArthropodEnchantments(llllllllllllllllIlIIIllIllIIIIIl, llllllllllllllllIlIIIllIlIlllllI);
    }
    
    public boolean canPassengerSteer() {
        final Entity llllllllllllllllIlIIIllIIlIllIlI = this.getControllingPassenger();
        if (llllllllllllllllIlIIIllIIlIllIlI instanceof EntityPlayer) {
            return ((EntityPlayer)llllllllllllllllIlIIIllIIlIllIlI).isUser();
        }
        return !this.world.isRemote;
    }
    
    public void setSilent(final boolean llllllllllllllllIlIIlIllllIIllll) {
        this.dataManager.set(Entity.SILENT, llllllllllllllllIlIIlIllllIIllll);
    }
    
    public boolean isPassenger(final Entity llllllllllllllllIlIIIllIlIIlIlII) {
        for (final Entity llllllllllllllllIlIIIllIlIIlIllI : this.getPassengers()) {
            if (llllllllllllllllIlIIIllIlIIlIllI.equals(llllllllllllllllIlIIIllIlIIlIlII)) {
                return true;
            }
        }
        return false;
    }
    
    public Vec3d getLook(final float llllllllllllllllIlIIlIlIIlIIlIIl) {
        if (llllllllllllllllIlIIlIlIIlIIlIIl == 1.0f) {
            return this.getVectorForRotation(this.rotationPitch, this.rotationYaw);
        }
        final float llllllllllllllllIlIIlIlIIlIIlIII = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * llllllllllllllllIlIIlIlIIlIIlIIl;
        final float llllllllllllllllIlIIlIlIIlIIIlll = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * llllllllllllllllIlIIlIlIIlIIlIIl;
        return this.getVectorForRotation(llllllllllllllllIlIIlIlIIlIIlIII, llllllllllllllllIlIIlIlIIlIIIlll);
    }
    
    public void setGlowing(final boolean llllllllllllllllIlIIlIIIIlIIlIlI) {
        this.glowing = llllllllllllllllIlIIlIIIIlIIlIlI;
        if (!this.world.isRemote) {
            this.setFlag(6, this.glowing);
        }
    }
    
    public int getMaxInPortalTime() {
        return 1;
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox() {
        return null;
    }
    
    protected boolean canBeRidden(final Entity llllllllllllllllIlIIlIIIllIlIlII) {
        return this.rideCooldown <= 0;
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    public void setRenderYawOffset(final float llllllllllllllllIlIIIlllllIIllIl) {
    }
    
    public void setSprinting(final boolean llllllllllllllllIlIIlIIIIlIlIIll) {
        this.setFlag(3, llllllllllllllllIlIIlIIIIlIlIIll);
    }
    
    @Nullable
    public Entity changeDimension(final int llllllllllllllllIlIIIllllIIIIlIl) {
        if (!this.world.isRemote && !this.isDead) {
            this.world.theProfiler.startSection("changeDimension");
            final MinecraftServer llllllllllllllllIlIIIllllIIllIIl = this.getServer();
            final int llllllllllllllllIlIIIllllIIllIII = this.dimension;
            final WorldServer llllllllllllllllIlIIIllllIIlIlll = llllllllllllllllIlIIIllllIIllIIl.worldServerForDimension(llllllllllllllllIlIIIllllIIllIII);
            WorldServer llllllllllllllllIlIIIllllIIlIllI = llllllllllllllllIlIIIllllIIllIIl.worldServerForDimension(llllllllllllllllIlIIIllllIIIIlIl);
            this.dimension = llllllllllllllllIlIIIllllIIIIlIl;
            if (llllllllllllllllIlIIIllllIIllIII == 1 && llllllllllllllllIlIIIllllIIIIlIl == 1) {
                llllllllllllllllIlIIIllllIIlIllI = llllllllllllllllIlIIIllllIIllIIl.worldServerForDimension(0);
                this.dimension = 0;
            }
            this.world.removeEntity(this);
            this.isDead = false;
            this.world.theProfiler.startSection("reposition");
            BlockPos llllllllllllllllIlIIIllllIIlIIlI = null;
            if (llllllllllllllllIlIIIllllIIIIlIl == 1) {
                final BlockPos llllllllllllllllIlIIIllllIIlIlII = llllllllllllllllIlIIIllllIIlIllI.getSpawnCoordinate();
            }
            else {
                double llllllllllllllllIlIIIllllIIlIIII = this.posX;
                double llllllllllllllllIlIIIllllIIIllll = this.posZ;
                final double llllllllllllllllIlIIIllllIIIllIl = 8.0;
                if (llllllllllllllllIlIIIllllIIIIlIl == -1) {
                    llllllllllllllllIlIIIllllIIlIIII = MathHelper.clamp(llllllllllllllllIlIIIllllIIlIIII / 8.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().minX() + 16.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().maxX() - 16.0);
                    llllllllllllllllIlIIIllllIIIllll = MathHelper.clamp(llllllllllllllllIlIIIllllIIIllll / 8.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().minZ() + 16.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().maxZ() - 16.0);
                }
                else if (llllllllllllllllIlIIIllllIIIIlIl == 0) {
                    llllllllllllllllIlIIIllllIIlIIII = MathHelper.clamp(llllllllllllllllIlIIIllllIIlIIII * 8.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().minX() + 16.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().maxX() - 16.0);
                    llllllllllllllllIlIIIllllIIIllll = MathHelper.clamp(llllllllllllllllIlIIIllllIIIllll * 8.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().minZ() + 16.0, llllllllllllllllIlIIIllllIIlIllI.getWorldBorder().maxZ() - 16.0);
                }
                llllllllllllllllIlIIIllllIIlIIII = MathHelper.clamp((int)llllllllllllllllIlIIIllllIIlIIII, -29999872, 29999872);
                llllllllllllllllIlIIIllllIIIllll = MathHelper.clamp((int)llllllllllllllllIlIIIllllIIIllll, -29999872, 29999872);
                final float llllllllllllllllIlIIIllllIIIllII = this.rotationYaw;
                this.setLocationAndAngles(llllllllllllllllIlIIIllllIIlIIII, this.posY, llllllllllllllllIlIIIllllIIIllll, 90.0f, 0.0f);
                final Teleporter llllllllllllllllIlIIIllllIIIlIlI = llllllllllllllllIlIIIllllIIlIllI.getDefaultTeleporter();
                llllllllllllllllIlIIIllllIIIlIlI.placeInExistingPortal(this, llllllllllllllllIlIIIllllIIIllII);
                llllllllllllllllIlIIIllllIIlIIlI = new BlockPos(this);
            }
            llllllllllllllllIlIIIllllIIlIlll.updateEntityWithOptionalForce(this, false);
            this.world.theProfiler.endStartSection("reloading");
            final Entity llllllllllllllllIlIIIllllIIIlIIl = EntityList.func_191304_a(this.getClass(), llllllllllllllllIlIIIllllIIlIllI);
            if (llllllllllllllllIlIIIllllIIIlIIl != null) {
                llllllllllllllllIlIIIllllIIIlIIl.copyDataFromOld(this);
                if (llllllllllllllllIlIIIllllIIllIII == 1 && llllllllllllllllIlIIIllllIIIIlIl == 1) {
                    final BlockPos llllllllllllllllIlIIIllllIIIlIII = llllllllllllllllIlIIIllllIIlIllI.getTopSolidOrLiquidBlock(llllllllllllllllIlIIIllllIIlIllI.getSpawnPoint());
                    llllllllllllllllIlIIIllllIIIlIIl.moveToBlockPosAndAngles(llllllllllllllllIlIIIllllIIIlIII, llllllllllllllllIlIIIllllIIIlIIl.rotationYaw, llllllllllllllllIlIIIllllIIIlIIl.rotationPitch);
                }
                else {
                    llllllllllllllllIlIIIllllIIIlIIl.moveToBlockPosAndAngles(llllllllllllllllIlIIIllllIIlIIlI, llllllllllllllllIlIIIllllIIIlIIl.rotationYaw, llllllllllllllllIlIIIllllIIIlIIl.rotationPitch);
                }
                final boolean llllllllllllllllIlIIIllllIIIIlll = llllllllllllllllIlIIIllllIIIlIIl.forceSpawn;
                llllllllllllllllIlIIIllllIIIlIIl.forceSpawn = true;
                llllllllllllllllIlIIIllllIIlIllI.spawnEntityInWorld(llllllllllllllllIlIIIllllIIIlIIl);
                llllllllllllllllIlIIIllllIIIlIIl.forceSpawn = llllllllllllllllIlIIIllllIIIIlll;
                llllllllllllllllIlIIIllllIIlIllI.updateEntityWithOptionalForce(llllllllllllllllIlIIIllllIIIlIIl, false);
            }
            this.isDead = true;
            this.world.theProfiler.endSection();
            llllllllllllllllIlIIIllllIIlIlll.resetUpdateEntityTick();
            llllllllllllllllIlIIIllllIIlIllI.resetUpdateEntityTick();
            this.world.theProfiler.endSection();
            return llllllllllllllllIlIIIllllIIIlIIl;
        }
        return null;
    }
    
    public double getYOffset() {
        return 0.0;
    }
    
    public static void func_190533_a(final DataFixer llllllllllllllllIlIIlIIllIIIlllI) {
        llllllllllllllllIlIIlIIllIIIlllI.registerWalker(FixTypes.ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llllllllllllllIIIlIIIIIllIlllIIl, final NBTTagCompound llllllllllllllIIIlIIIIIllIlllIII, final int llllllllllllllIIIlIIIIIllIllIlll) {
                if (llllllllllllllIIIlIIIIIllIlllIII.hasKey("Passengers", 9)) {
                    final NBTTagList llllllllllllllIIIlIIIIIllIlllIll = llllllllllllllIIIlIIIIIllIlllIII.getTagList("Passengers", 10);
                    for (int llllllllllllllIIIlIIIIIllIlllIlI = 0; llllllllllllllIIIlIIIIIllIlllIlI < llllllllllllllIIIlIIIIIllIlllIll.tagCount(); ++llllllllllllllIIIlIIIIIllIlllIlI) {
                        llllllllllllllIIIlIIIIIllIlllIll.set(llllllllllllllIIIlIIIIIllIlllIlI, llllllllllllllIIIlIIIIIllIlllIIl.process(FixTypes.ENTITY, llllllllllllllIIIlIIIIIllIlllIll.getCompoundTagAt(llllllllllllllIIIlIIIIIllIlllIlI), llllllllllllllIIIlIIIIIllIllIlll));
                    }
                }
                return llllllllllllllIIIlIIIIIllIlllIII;
            }
        });
    }
    
    public boolean isOnSameTeam(final Entity llllllllllllllllIlIIlIIIIIllIlIl) {
        return this.isOnScoreboardTeam(llllllllllllllllIlIIlIIIIIllIlIl.getTeam());
    }
    
    public Set<String> getTags() {
        return this.tags;
    }
    
    protected void doBlockCollisions() {
        final AxisAlignedBB llllllllllllllllIlIIllIIIlIIIIII = this.getEntityBoundingBox();
        final BlockPos.PooledMutableBlockPos llllllllllllllllIlIIllIIIIllllll = BlockPos.PooledMutableBlockPos.retain(llllllllllllllllIlIIllIIIlIIIIII.minX + 0.001, llllllllllllllllIlIIllIIIlIIIIII.minY + 0.001, llllllllllllllllIlIIllIIIlIIIIII.minZ + 0.001);
        final BlockPos.PooledMutableBlockPos llllllllllllllllIlIIllIIIIlllllI = BlockPos.PooledMutableBlockPos.retain(llllllllllllllllIlIIllIIIlIIIIII.maxX - 0.001, llllllllllllllllIlIIllIIIlIIIIII.maxY - 0.001, llllllllllllllllIlIIllIIIlIIIIII.maxZ - 0.001);
        final BlockPos.PooledMutableBlockPos llllllllllllllllIlIIllIIIIllllIl = BlockPos.PooledMutableBlockPos.retain();
        if (this.world.isAreaLoaded(llllllllllllllllIlIIllIIIIllllll, llllllllllllllllIlIIllIIIIlllllI)) {
            for (int llllllllllllllllIlIIllIIIIllllII = llllllllllllllllIlIIllIIIIllllll.getX(); llllllllllllllllIlIIllIIIIllllII <= llllllllllllllllIlIIllIIIIlllllI.getX(); ++llllllllllllllllIlIIllIIIIllllII) {
                for (int llllllllllllllllIlIIllIIIIlllIll = llllllllllllllllIlIIllIIIIllllll.getY(); llllllllllllllllIlIIllIIIIlllIll <= llllllllllllllllIlIIllIIIIlllllI.getY(); ++llllllllllllllllIlIIllIIIIlllIll) {
                    for (int llllllllllllllllIlIIllIIIIlllIIl = llllllllllllllllIlIIllIIIIllllll.getZ(); llllllllllllllllIlIIllIIIIlllIIl <= llllllllllllllllIlIIllIIIIlllllI.getZ(); ++llllllllllllllllIlIIllIIIIlllIIl) {
                        llllllllllllllllIlIIllIIIIllllIl.setPos(llllllllllllllllIlIIllIIIIllllII, llllllllllllllllIlIIllIIIIlllIll, llllllllllllllllIlIIllIIIIlllIIl);
                        final IBlockState llllllllllllllllIlIIllIIIIllIlll = this.world.getBlockState(llllllllllllllllIlIIllIIIIllllIl);
                        try {
                            llllllllllllllllIlIIllIIIIllIlll.getBlock().onEntityCollidedWithBlock(this.world, llllllllllllllllIlIIllIIIIllllIl, llllllllllllllllIlIIllIIIIllIlll, this);
                            this.func_191955_a(llllllllllllllllIlIIllIIIIllIlll);
                        }
                        catch (Throwable llllllllllllllllIlIIllIIIIllIlIl) {
                            final CrashReport llllllllllllllllIlIIllIIIIllIIll = CrashReport.makeCrashReport(llllllllllllllllIlIIllIIIIllIlIl, "Colliding entity with block");
                            final CrashReportCategory llllllllllllllllIlIIllIIIIllIIIl = llllllllllllllllIlIIllIIIIllIIll.makeCategory("Block being collided with");
                            CrashReportCategory.addBlockInfo(llllllllllllllllIlIIllIIIIllIIIl, llllllllllllllllIlIIllIIIIllllIl, llllllllllllllllIlIIllIIIIllIlll);
                            throw new ReportedException(llllllllllllllllIlIIllIIIIllIIll);
                        }
                    }
                }
            }
        }
        llllllllllllllllIlIIllIIIIllllll.release();
        llllllllllllllllIlIIllIIIIlllllI.release();
        llllllllllllllllIlIIllIIIIllllIl.release();
    }
    
    public boolean writeToNBTAtomically(final NBTTagCompound llllllllllllllllIlIIlIIllIIllllI) {
        final String llllllllllllllllIlIIlIIllIIlllIl = this.getEntityString();
        if (!this.isDead && llllllllllllllllIlIIlIIllIIlllIl != null) {
            llllllllllllllllIlIIlIIllIIllllI.setString("id", llllllllllllllllIlIIlIIllIIlllIl);
            this.writeToNBT(llllllllllllllllIlIIlIIllIIllllI);
            return true;
        }
        return false;
    }
    
    public void setAir(final int llllllllllllllllIlIIlIIIIIIIlllI) {
        this.dataManager.set(Entity.AIR, llllllllllllllllIlIIlIIIIIIIlllI);
    }
    
    public double getDistanceSq(final BlockPos llllllllllllllllIlIIlIlIlIlIIIll) {
        return llllllllllllllllIlIIlIlIlIlIIIll.distanceSq(this.posX, this.posY, this.posZ);
    }
    
    public void setItemStackToSlot(final EntityEquipmentSlot llllllllllllllllIlIIlIIIIlllIIII, final ItemStack llllllllllllllllIlIIlIIIIllIllll) {
    }
    
    public boolean canBeAttackedWithItem() {
        return true;
    }
    
    public boolean removeTag(final String llllllllllllllllIlIIllIlllllllII) {
        return this.tags.remove(llllllllllllllllIlIIllIlllllllII);
    }
    
    public void setInWeb() {
        this.isInWeb = true;
        this.fallDistance = 0.0f;
    }
    
    public boolean isPushedByWater() {
        return true;
    }
    
    public void setPortal(final BlockPos llllllllllllllllIlIIlIIIlIIlIIIl) {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = this.getPortalCooldown();
        }
        else {
            if (!this.world.isRemote && !llllllllllllllllIlIIlIIIlIIlIIIl.equals(this.lastPortalPos)) {
                this.lastPortalPos = new BlockPos(llllllllllllllllIlIIlIIIlIIlIIIl);
                final BlockPattern.PatternHelper llllllllllllllllIlIIlIIIlIIlIIII = Blocks.PORTAL.createPatternHelper(this.world, this.lastPortalPos);
                final double llllllllllllllllIlIIlIIIlIIIllll = (llllllllllllllllIlIIlIIIlIIlIIII.getForwards().getAxis() == EnumFacing.Axis.X) ? llllllllllllllllIlIIlIIIlIIlIIII.getFrontTopLeft().getZ() : ((double)llllllllllllllllIlIIlIIIlIIlIIII.getFrontTopLeft().getX());
                double llllllllllllllllIlIIlIIIlIIIlllI = (llllllllllllllllIlIIlIIIlIIlIIII.getForwards().getAxis() == EnumFacing.Axis.X) ? this.posZ : this.posX;
                llllllllllllllllIlIIlIIIlIIIlllI = Math.abs(MathHelper.pct(llllllllllllllllIlIIlIIIlIIIlllI - (double)((llllllllllllllllIlIIlIIIlIIlIIII.getForwards().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) ? 1 : 0), llllllllllllllllIlIIlIIIlIIIllll, llllllllllllllllIlIIlIIIlIIIllll - llllllllllllllllIlIIlIIIlIIlIIII.getWidth()));
                final double llllllllllllllllIlIIlIIIlIIIllIl = MathHelper.pct(this.posY - 1.0, llllllllllllllllIlIIlIIIlIIlIIII.getFrontTopLeft().getY(), llllllllllllllllIlIIlIIIlIIlIIII.getFrontTopLeft().getY() - llllllllllllllllIlIIlIIIlIIlIIII.getHeight());
                this.lastPortalVec = new Vec3d(llllllllllllllllIlIIlIIIlIIIlllI, llllllllllllllllIlIIlIIIlIIIllIl, 0.0);
                this.teleportDirection = llllllllllllllllIlIIlIIIlIIlIIII.getForwards();
            }
            this.inPortal = true;
        }
    }
    
    private <T extends Entity> void getRecursivePassengersByType(final Class<T> llllllllllllllllIlIIIllIIlllllII, final Set<T> llllllllllllllllIlIIIllIIlllIlll) {
        for (final Entity llllllllllllllllIlIIIllIIllllIlI : this.getPassengers()) {
            if (llllllllllllllllIlIIIllIIlllllII.isAssignableFrom(llllllllllllllllIlIIIllIIllllIlI.getClass())) {
                llllllllllllllllIlIIIllIIlllIlll.add((T)llllllllllllllllIlIIIllIIllllIlI);
            }
            llllllllllllllllIlIIIllIIllllIlI.getRecursivePassengersByType((Class<Entity>)llllllllllllllllIlIIIllIIlllllII, (Set<Entity>)llllllllllllllllIlIIIllIIlllIlll);
        }
    }
    
    public void setNoGravity(final boolean llllllllllllllllIlIIlIllllIIIIIl) {
        this.dataManager.set(Entity.NO_GRAVITY, llllllllllllllllIlIIlIllllIIIIIl);
    }
    
    public void applyOrientationToEntity(final Entity llllllllllllllllIlIIlIIIlllIllIl) {
    }
    
    protected int func_190531_bD() {
        return 1;
    }
    
    public boolean verifyExplosion(final Explosion llllllllllllllllIlIIIlllIllIlllI, final World llllllllllllllllIlIIIlllIllIllIl, final BlockPos llllllllllllllllIlIIIlllIllIllII, final IBlockState llllllllllllllllIlIIIlllIllIlIll, final float llllllllllllllllIlIIIlllIllIlIlI) {
        return true;
    }
    
    public void setFire(final int llllllllllllllllIlIIllIllIIIIIII) {
        int llllllllllllllllIlIIllIlIlllllll = llllllllllllllllIlIIllIllIIIIIII * 20;
        if (this instanceof EntityLivingBase) {
            llllllllllllllllIlIIllIlIlllllll = EnchantmentProtection.getFireTimeForEntity((EntityLivingBase)this, llllllllllllllllIlIIllIlIlllllll);
        }
        if (this.field_190534_ay < llllllllllllllllIlIIllIlIlllllll) {
            this.field_190534_ay = llllllllllllllllIlIIllIlIlllllll;
        }
    }
    
    public boolean isSneaking() {
        return this.getFlag(1);
    }
    
    public List<Entity> getPassengers() {
        return this.riddenByEntities.isEmpty() ? Collections.emptyList() : Lists.newArrayList((Iterable)this.riddenByEntities);
    }
    
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllllIlIIlIIIIIIIlIIl) {
        this.attackEntityFrom(DamageSource.lightningBolt, 5.0f);
        ++this.field_190534_ay;
        if (this.field_190534_ay == 0) {
            this.setFire(8);
        }
    }
    
    public Vec2f getPitchYaw() {
        return new Vec2f(this.rotationPitch, this.rotationYaw);
    }
    
    public double getDistance(final double llllllllllllllllIlIIlIlIlIIIllIl, final double llllllllllllllllIlIIlIlIlIIlIIll, final double llllllllllllllllIlIIlIlIlIIlIIlI) {
        final double llllllllllllllllIlIIlIlIlIIlIIIl = this.posX - llllllllllllllllIlIIlIlIlIIIllIl;
        final double llllllllllllllllIlIIlIlIlIIlIIII = this.posY - llllllllllllllllIlIIlIlIlIIlIIll;
        final double llllllllllllllllIlIIlIlIlIIIllll = this.posZ - llllllllllllllllIlIIlIlIlIIlIIlI;
        return MathHelper.sqrt(llllllllllllllllIlIIlIlIlIIlIIIl * llllllllllllllllIlIIlIlIlIIlIIIl + llllllllllllllllIlIIlIlIlIIlIIII * llllllllllllllllIlIIlIlIlIIlIIII + llllllllllllllllIlIIlIlIlIIIllll * llllllllllllllllIlIIlIlIlIIIllll);
    }
    
    public boolean func_190530_aW() {
        return this.invulnerable;
    }
    
    protected void createRunningParticles() {
        final int llllllllllllllllIlIIlIllIlIIllll = MathHelper.floor(this.posX);
        final int llllllllllllllllIlIIlIllIlIIlllI = MathHelper.floor(this.posY - 0.20000000298023224);
        final int llllllllllllllllIlIIlIllIlIIllIl = MathHelper.floor(this.posZ);
        final BlockPos llllllllllllllllIlIIlIllIlIIllII = new BlockPos(llllllllllllllllIlIIlIllIlIIllll, llllllllllllllllIlIIlIllIlIIlllI, llllllllllllllllIlIIlIllIlIIllIl);
        final IBlockState llllllllllllllllIlIIlIllIlIIlIll = this.world.getBlockState(llllllllllllllllIlIIlIllIlIIllII);
        if (llllllllllllllllIlIIlIllIlIIlIll.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5) * this.width, this.getEntityBoundingBox().minY + 0.1, this.posZ + (this.rand.nextFloat() - 0.5) * this.width, -this.motionX * 4.0, 1.5, -this.motionZ * 4.0, Block.getStateId(llllllllllllllllIlIIlIllIlIIlIll));
        }
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBox(final Entity llllllllllllllllIlIIlIIIlllllIll) {
        return null;
    }
    
    protected void setOnFireFromLava() {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.lava, 4.0f);
            this.setFire(15);
        }
    }
    
    public Iterable<ItemStack> getArmorInventoryList() {
        return Entity.field_190535_b;
    }
    
    @Override
    public void addChatMessage(final ITextComponent llllllllllllllllIlIIIllIlllIllll) {
    }
    
    protected void func_191955_a(final IBlockState llllllllllllllllIlIIllIIIIIlIlII) {
    }
    
    public float getCollisionBorderSize() {
        if (Main.moduleManager.getModule(HitBox.class).isToggled()) {
            return (float)(0.0 + HitBox.size.getValDouble());
        }
        return 0.0f;
    }
    
    public void extinguish() {
        this.field_190534_ay = 0;
    }
    
    public boolean isInvisible() {
        return this.getFlag(5);
    }
    
    public String getCustomNameTag() {
        return this.dataManager.get(Entity.CUSTOM_NAME);
    }
    
    public EnumFacing getHorizontalFacing() {
        return EnumFacing.getHorizontal(MathHelper.floor(this.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3);
    }
    
    public Iterable<ItemStack> getHeldEquipment() {
        return Entity.field_190535_b;
    }
    
    public void setEntityId(final int llllllllllllllllIlIIlllIIIIIllIl) {
        this.entityId = llllllllllllllllIlIIlllIIIIIllIl;
    }
    
    public boolean replaceItemInInventory(final int llllllllllllllllIlIIIllIllllIIlI, final ItemStack llllllllllllllllIlIIIllIllllIIIl) {
        return false;
    }
    
    public int getAir() {
        return this.dataManager.get(Entity.AIR);
    }
    
    public boolean isImmuneToExplosions() {
        return false;
    }
    
    public boolean canRenderOnFire() {
        return this.isBurning();
    }
    
    @Nullable
    public Entity getRidingEntity() {
        return this.ridingEntity;
    }
    
    public EnumActionResult applyPlayerInteraction(final EntityPlayer llllllllllllllllIlIIIllIllIIlIII, final Vec3d llllllllllllllllIlIIIllIllIIIlll, final EnumHand llllllllllllllllIlIIIllIllIIIllI) {
        return EnumActionResult.PASS;
    }
    
    public boolean isEntityEqual(final Entity llllllllllllllllIlIIIlllllIlIIlI) {
        return this == llllllllllllllllIlIIIlllllIlIIlI;
    }
    
    public SoundCategory getSoundCategory() {
        return SoundCategory.NEUTRAL;
    }
    
    public final boolean isImmuneToFire() {
        return this.isImmuneToFire;
    }
    
    public float getRotatedYaw(final Rotation llllllllllllllllIlIIIllIlIllIIlI) {
        final float llllllllllllllllIlIIIllIlIllIlII = MathHelper.wrapDegrees(this.rotationYaw);
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIlIIIllIlIllIIlI.ordinal()]) {
            case 3: {
                return llllllllllllllllIlIIIllIlIllIlII + 180.0f;
            }
            case 4: {
                return llllllllllllllllIlIIIllIlIllIlII + 270.0f;
            }
            case 2: {
                return llllllllllllllllIlIIIllIlIllIlII + 90.0f;
            }
            default: {
                return llllllllllllllllIlIIIllIlIllIlII;
            }
        }
    }
    
    @Nullable
    public EntityItem dropItem(final Item llllllllllllllllIlIIlIIlIIlIlllI, final int llllllllllllllllIlIIlIIlIIllIIII) {
        return this.dropItemWithOffset(llllllllllllllllIlIIlIIlIIlIlllI, llllllllllllllllIlIIlIIlIIllIIII, 0.0f);
    }
    
    public boolean isEntityInsideOpaqueBlock() {
        if (this.noClip) {
            return false;
        }
        final BlockPos.PooledMutableBlockPos llllllllllllllllIlIIlIIlIIIIlIlI = BlockPos.PooledMutableBlockPos.retain();
        for (int llllllllllllllllIlIIlIIlIIIIlIIl = 0; llllllllllllllllIlIIlIIlIIIIlIIl < 8; ++llllllllllllllllIlIIlIIlIIIIlIIl) {
            final int llllllllllllllllIlIIlIIlIIIIlIII = MathHelper.floor(this.posY + ((llllllllllllllllIlIIlIIlIIIIlIIl >> 0) % 2 - 0.5f) * 0.1f + this.getEyeHeight());
            final int llllllllllllllllIlIIlIIlIIIIIlll = MathHelper.floor(this.posX + ((llllllllllllllllIlIIlIIlIIIIlIIl >> 1) % 2 - 0.5f) * this.width * 0.8f);
            final int llllllllllllllllIlIIlIIlIIIIIllI = MathHelper.floor(this.posZ + ((llllllllllllllllIlIIlIIlIIIIlIIl >> 2) % 2 - 0.5f) * this.width * 0.8f);
            if (llllllllllllllllIlIIlIIlIIIIlIlI.getX() != llllllllllllllllIlIIlIIlIIIIIlll || llllllllllllllllIlIIlIIlIIIIlIlI.getY() != llllllllllllllllIlIIlIIlIIIIlIII || llllllllllllllllIlIIlIIlIIIIlIlI.getZ() != llllllllllllllllIlIIlIIlIIIIIllI) {
                llllllllllllllllIlIIlIIlIIIIlIlI.setPos(llllllllllllllllIlIIlIIlIIIIIlll, llllllllllllllllIlIIlIIlIIIIlIII, llllllllllllllllIlIIlIIlIIIIIllI);
                if (this.world.getBlockState(llllllllllllllllIlIIlIIlIIIIlIlI).func_191058_s()) {
                    llllllllllllllllIlIIlIIlIIIIlIlI.release();
                    return true;
                }
            }
        }
        llllllllllllllllIlIIlIIlIIIIlIlI.release();
        return false;
    }
    
    protected boolean shouldSetPosAfterLoading() {
        return true;
    }
    
    public void copyLocationAndAnglesFrom(final Entity llllllllllllllllIlIIIllllIllIlII) {
        this.setLocationAndAngles(llllllllllllllllIlIIIllllIllIlII.posX, llllllllllllllllIlIIIllllIllIlII.posY, llllllllllllllllIlIIIllllIllIlII.posZ, llllllllllllllllIlIIIllllIllIlII.rotationYaw, llllllllllllllllIlIIIllllIllIlII.rotationPitch);
    }
    
    public boolean isInRangeToRender3d(final double llllllllllllllllIlIIlIIllIlllIlI, final double llllllllllllllllIlIIlIIllIllIIIl, final double llllllllllllllllIlIIlIIllIllIIII) {
        final double llllllllllllllllIlIIlIIllIllIlll = this.posX - llllllllllllllllIlIIlIIllIlllIlI;
        final double llllllllllllllllIlIIlIIllIllIllI = this.posY - llllllllllllllllIlIIlIIllIllIIIl;
        final double llllllllllllllllIlIIlIIllIllIlIl = this.posZ - llllllllllllllllIlIIlIIllIllIIII;
        final double llllllllllllllllIlIIlIIllIllIlII = llllllllllllllllIlIIlIIllIllIlll * llllllllllllllllIlIIlIIllIllIlll + llllllllllllllllIlIIlIIllIllIllI * llllllllllllllllIlIIlIIllIllIllI + llllllllllllllllIlIIlIIllIllIlIl * llllllllllllllllIlIIlIIllIllIlIl;
        return this.isInRangeToRenderDist(llllllllllllllllIlIIlIIllIllIlII);
    }
    
    protected boolean func_191957_ae() {
        return false;
    }
    
    public void setPositionAndRotationDirect(final double llllllllllllllllIlIIlIIIlIlIllll, final double llllllllllllllllIlIIlIIIlIlIlllI, final double llllllllllllllllIlIIlIIIlIlIllIl, final float llllllllllllllllIlIIlIIIlIlIIlII, final float llllllllllllllllIlIIlIIIlIlIlIll, final int llllllllllllllllIlIIlIIIlIlIlIlI, final boolean llllllllllllllllIlIIlIIIlIlIlIIl) {
        this.setPosition(llllllllllllllllIlIIlIIIlIlIllll, llllllllllllllllIlIIlIIIlIlIlllI, llllllllllllllllIlIIlIIIlIlIllIl);
        this.setRotation(llllllllllllllllIlIIlIIIlIlIIlII, llllllllllllllllIlIIlIIIlIlIlIll);
    }
    
    public void setWorld(final World llllllllllllllllIlIIlIllIIIIIIII) {
        this.world = llllllllllllllllIlIIlIllIIIIIIII;
    }
    
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllllIlIIIlllIIIlllIl) {
    }
    
    protected void preparePlayerToSpawn() {
        if (this.world != null) {
            while (this.posY > 0.0 && this.posY < 256.0) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty()) {
                    break;
                }
                ++this.posY;
            }
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.rotationPitch = 0.0f;
        }
    }
    
    public void performHurtAnimation() {
    }
    
    public Entity(final World llllllllllllllllIlIIlllIIIIlIlII) {
        this.entityId = Entity.nextEntityID++;
        this.riddenByEntities = (List<Entity>)Lists.newArrayList();
        this.boundingBox = Entity.ZERO_AABB;
        this.width = 0.6f;
        this.height = 1.8f;
        this.nextStepDistance = 1;
        this.field_191959_ay = 1.0f;
        this.rand = new Random();
        this.field_190534_ay = -this.func_190531_bD();
        this.firstUpdate = true;
        this.entityUniqueID = MathHelper.getRandomUUID(this.rand);
        this.cachedUniqueIdString = this.entityUniqueID.toString();
        this.cmdResultStats = new CommandResultStats();
        this.tags = (Set<String>)Sets.newHashSet();
        this.field_191505_aI = new double[] { 0.0, 0.0, 0.0 };
        this.world = llllllllllllllllIlIIlllIIIIlIlII;
        this.setPosition(0.0, 0.0, 0.0);
        if (llllllllllllllllIlIIlllIIIIlIlII != null) {
            this.dimension = llllllllllllllllIlIIlllIIIIlIlII.provider.getDimensionType().getId();
        }
        this.dataManager = new EntityDataManager(this);
        this.dataManager.register(Entity.FLAGS, (Byte)0);
        this.dataManager.register(Entity.AIR, 300);
        this.dataManager.register(Entity.CUSTOM_NAME_VISIBLE, false);
        this.dataManager.register(Entity.CUSTOM_NAME, "");
        this.dataManager.register(Entity.SILENT, false);
        this.dataManager.register(Entity.NO_GRAVITY, false);
        this.entityInit();
    }
    
    public <T extends Entity> Collection<T> getRecursivePassengersByType(final Class<T> llllllllllllllllIlIIIllIlIIIIlll) {
        final Set<T> llllllllllllllllIlIIIllIlIIIIllI = (Set<T>)Sets.newHashSet();
        this.getRecursivePassengersByType(llllllllllllllllIlIIIllIlIIIIlll, llllllllllllllllIlIIIllIlIIIIllI);
        return llllllllllllllllIlIIIllIlIIIIllI;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIlIIllIlllllIIlI) {
        return llllllllllllllllIlIIllIlllllIIlI instanceof Entity && ((Entity)llllllllllllllllIlIIllIlllllIIlI).entityId == this.entityId;
    }
    
    protected void updateFallState(final double llllllllllllllllIlIIlIlllIlIIlIl, final boolean llllllllllllllllIlIIlIlllIlIIlII, final IBlockState llllllllllllllllIlIIlIlllIlIIIll, final BlockPos llllllllllllllllIlIIlIlllIlIIIlI) {
        if (llllllllllllllllIlIIlIlllIlIIlII) {
            if (this.fallDistance > 0.0f) {
                llllllllllllllllIlIIlIlllIlIIIll.getBlock().onFallenUpon(this.world, llllllllllllllllIlIIlIlllIlIIIlI, this, this.fallDistance);
            }
            this.fallDistance = 0.0f;
        }
        else if (llllllllllllllllIlIIlIlllIlIIlIl < 0.0) {
            this.fallDistance -= (float)llllllllllllllllIlIIlIlllIlIIlIl;
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = Entity.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final int llllllllllllllllIlIIIllIIlIIlllI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllllIlIIIllIIlIIlllI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIlIIIllIIlIIlllI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIlIIIllIIlIIlllI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Entity.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllllIlIIIllIIlIIlllI;
    }
    
    protected void decrementTimeUntilPortal() {
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
    }
    
    public boolean isGlowing() {
        return this.glowing || (this.world.isRemote && this.getFlag(6));
    }
    
    public String getCachedUniqueIdString() {
        return this.cachedUniqueIdString;
    }
    
    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }
    
    public void spawnRunningParticles() {
        if (this.isSprinting() && !this.isInWater()) {
            this.createRunningParticles();
        }
    }
    
    @Override
    public ITextComponent getDisplayName() {
        final TextComponentString llllllllllllllllIlIIIlllIlIIIlIl = new TextComponentString(ScorePlayerTeam.formatPlayerName(this.getTeam(), this.getName()));
        llllllllllllllllIlIIIlllIlIIIlIl.getStyle().setHoverEvent(this.getHoverEvent());
        llllllllllllllllIlIIIlllIlIIIlIl.getStyle().setInsertion(this.getCachedUniqueIdString());
        return llllllllllllllllIlIIIlllIlIIIlIl;
    }
    
    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        String llllllllllllllllIlIIIlllllIllIll = EntityList.getEntityString(this);
        if (llllllllllllllllIlIIIlllllIllIll == null) {
            llllllllllllllllIlIIIlllllIllIll = "generic";
        }
        return I18n.translateToLocal(String.valueOf(new StringBuilder("entity.").append(llllllllllllllllIlIIIlllllIllIll).append(".name")));
    }
    
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Nullable
    protected final String getEntityString() {
        final ResourceLocation llllllllllllllllIlIIlIIlIlIllIII = EntityList.func_191301_a(this);
        return (llllllllllllllllIlIIlIIlIlIllIII == null) ? null : llllllllllllllllIlIIlIIlIlIllIII.toString();
    }
    
    public UUID getUniqueID() {
        return this.entityUniqueID;
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }
    
    protected abstract void readEntityFromNBT(final NBTTagCompound p0);
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllllllIlIIIllIlllIllIl, final String llllllllllllllllIlIIIllIlllIllII) {
        return true;
    }
    
    public void removeTrackingPlayer(final EntityPlayerMP llllllllllllllllIlIIIllIlIlllIlI) {
    }
    
    public boolean isRiding() {
        return this.getRidingEntity() != null;
    }
    
    public boolean isBeingRidden() {
        return !this.getPassengers().isEmpty();
    }
    
    protected boolean pushOutOfBlocks(final double llllllllllllllllIlIIIllllllllIII, final double llllllllllllllllIlIIIlllllllIlll, final double llllllllllllllllIlIIIllllllIlIII) {
        final BlockPos llllllllllllllllIlIIIlllllllIlIl = new BlockPos(llllllllllllllllIlIIIllllllllIII, llllllllllllllllIlIIIlllllllIlll, llllllllllllllllIlIIIllllllIlIII);
        final double llllllllllllllllIlIIIlllllllIlII = llllllllllllllllIlIIIllllllllIII - llllllllllllllllIlIIIlllllllIlIl.getX();
        final double llllllllllllllllIlIIIlllllllIIll = llllllllllllllllIlIIIlllllllIlll - llllllllllllllllIlIIIlllllllIlIl.getY();
        final double llllllllllllllllIlIIIlllllllIIlI = llllllllllllllllIlIIIllllllIlIII - llllllllllllllllIlIIIlllllllIlIl.getZ();
        if (!this.world.collidesWithAnyBlock(this.getEntityBoundingBox())) {
            return false;
        }
        EnumFacing llllllllllllllllIlIIIlllllllIIIl = EnumFacing.UP;
        double llllllllllllllllIlIIIlllllllIIII = Double.MAX_VALUE;
        if (!this.world.isBlockFullCube(llllllllllllllllIlIIIlllllllIlIl.west()) && llllllllllllllllIlIIIlllllllIlII < llllllllllllllllIlIIIlllllllIIII) {
            llllllllllllllllIlIIIlllllllIIII = llllllllllllllllIlIIIlllllllIlII;
            llllllllllllllllIlIIIlllllllIIIl = EnumFacing.WEST;
        }
        if (!this.world.isBlockFullCube(llllllllllllllllIlIIIlllllllIlIl.east()) && 1.0 - llllllllllllllllIlIIIlllllllIlII < llllllllllllllllIlIIIlllllllIIII) {
            llllllllllllllllIlIIIlllllllIIII = 1.0 - llllllllllllllllIlIIIlllllllIlII;
            llllllllllllllllIlIIIlllllllIIIl = EnumFacing.EAST;
        }
        if (!this.world.isBlockFullCube(llllllllllllllllIlIIIlllllllIlIl.north()) && llllllllllllllllIlIIIlllllllIIlI < llllllllllllllllIlIIIlllllllIIII) {
            llllllllllllllllIlIIIlllllllIIII = llllllllllllllllIlIIIlllllllIIlI;
            llllllllllllllllIlIIIlllllllIIIl = EnumFacing.NORTH;
        }
        if (!this.world.isBlockFullCube(llllllllllllllllIlIIIlllllllIlIl.south()) && 1.0 - llllllllllllllllIlIIIlllllllIIlI < llllllllllllllllIlIIIlllllllIIII) {
            llllllllllllllllIlIIIlllllllIIII = 1.0 - llllllllllllllllIlIIIlllllllIIlI;
            llllllllllllllllIlIIIlllllllIIIl = EnumFacing.SOUTH;
        }
        if (!this.world.isBlockFullCube(llllllllllllllllIlIIIlllllllIlIl.up()) && 1.0 - llllllllllllllllIlIIIlllllllIIll < llllllllllllllllIlIIIlllllllIIII) {
            llllllllllllllllIlIIIlllllllIIII = 1.0 - llllllllllllllllIlIIIlllllllIIll;
            llllllllllllllllIlIIIlllllllIIIl = EnumFacing.UP;
        }
        final float llllllllllllllllIlIIIllllllIllll = this.rand.nextFloat() * 0.2f + 0.1f;
        final float llllllllllllllllIlIIIllllllIlllI = (float)llllllllllllllllIlIIIlllllllIIIl.getAxisDirection().getOffset();
        if (llllllllllllllllIlIIIlllllllIIIl.getAxis() == EnumFacing.Axis.X) {
            this.motionX = llllllllllllllllIlIIIllllllIlllI * llllllllllllllllIlIIIllllllIllll;
            this.motionY *= 0.75;
            this.motionZ *= 0.75;
        }
        else if (llllllllllllllllIlIIIlllllllIIIl.getAxis() == EnumFacing.Axis.Y) {
            this.motionX *= 0.75;
            this.motionY = llllllllllllllllIlIIIllllllIlllI * llllllllllllllllIlIIIllllllIllll;
            this.motionZ *= 0.75;
        }
        else if (llllllllllllllllIlIIIlllllllIIIl.getAxis() == EnumFacing.Axis.Z) {
            this.motionX *= 0.75;
            this.motionY *= 0.75;
            this.motionZ = llllllllllllllllIlIIIllllllIlllI * llllllllllllllllIlIIIllllllIllll;
        }
        return true;
    }
    
    public void func_191958_b(float llllllllllllllllIlIIlIllIIIllIII, float llllllllllllllllIlIIlIllIIIlllll, float llllllllllllllllIlIIlIllIIIllllI, final float llllllllllllllllIlIIlIllIIIlllIl) {
        float llllllllllllllllIlIIlIllIIIlllII = llllllllllllllllIlIIlIllIIIllIII * llllllllllllllllIlIIlIllIIIllIII + llllllllllllllllIlIIlIllIIIlllll * llllllllllllllllIlIIlIllIIIlllll + llllllllllllllllIlIIlIllIIIllllI * llllllllllllllllIlIIlIllIIIllllI;
        if (llllllllllllllllIlIIlIllIIIlllII >= 1.0E-4f) {
            llllllllllllllllIlIIlIllIIIlllII = MathHelper.sqrt(llllllllllllllllIlIIlIllIIIlllII);
            if (llllllllllllllllIlIIlIllIIIlllII < 1.0f) {
                llllllllllllllllIlIIlIllIIIlllII = 1.0f;
            }
            llllllllllllllllIlIIlIllIIIlllII = llllllllllllllllIlIIlIllIIIlllIl / llllllllllllllllIlIIlIllIIIlllII;
            llllllllllllllllIlIIlIllIIIllIII *= llllllllllllllllIlIIlIllIIIlllII;
            llllllllllllllllIlIIlIllIIIlllll *= llllllllllllllllIlIIlIllIIIlllII;
            llllllllllllllllIlIIlIllIIIllllI *= llllllllllllllllIlIIlIllIIIlllII;
            final float llllllllllllllllIlIIlIllIIIllIll = MathHelper.sin(this.rotationYaw * 0.017453292f);
            final float llllllllllllllllIlIIlIllIIIllIlI = MathHelper.cos(this.rotationYaw * 0.017453292f);
            this.motionX += llllllllllllllllIlIIlIllIIIllIII * llllllllllllllllIlIIlIllIIIllIlI - llllllllllllllllIlIIlIllIIIllllI * llllllllllllllllIlIIlIllIIIllIll;
            this.motionY += llllllllllllllllIlIIlIllIIIlllll;
            this.motionZ += llllllllllllllllIlIIlIllIIIllllI * llllllllllllllllIlIIlIllIIIllIlI + llllllllllllllllIlIIlIllIIIllIII * llllllllllllllllIlIIlIllIIIllIll;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.getName(), this.entityId, (this.world == null) ? "~NULL~" : this.world.getWorldInfo().getWorldName(), this.posX, this.posY, this.posZ);
    }
    
    public boolean isWet() {
        if (this.inWater) {
            return true;
        }
        final BlockPos.PooledMutableBlockPos llllllllllllllllIlIIlIlllIIIIIII = BlockPos.PooledMutableBlockPos.retain(this.posX, this.posY, this.posZ);
        if (!this.world.isRainingAt(llllllllllllllllIlIIlIlllIIIIIII) && !this.world.isRainingAt(llllllllllllllllIlIIlIlllIIIIIII.setPos(this.posX, this.posY + this.height, this.posZ))) {
            llllllllllllllllIlIIlIlllIIIIIII.release();
            return false;
        }
        llllllllllllllllIlIIlIlllIIIIIII.release();
        return true;
    }
    
    public void onCollideWithPlayer(final EntityPlayer llllllllllllllllIlIIlIlIIlllIlll) {
    }
    
    protected void dealFireDamage(final int llllllllllllllllIlIIlIlllIIlIlIl) {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.inFire, (float)llllllllllllllllIlIIlIlllIIlIlIl);
        }
    }
    
    public void setSneaking(final boolean llllllllllllllllIlIIlIIIIlIllIlI) {
        this.setFlag(1, llllllllllllllllIlIIlIIIIlIllIlI);
    }
}
