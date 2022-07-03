package net.minecraft.entity;

import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.inventory.*;
import net.minecraft.util.math.*;
import net.minecraft.potion.*;
import net.minecraft.network.play.server.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.network.datasync.*;

public class EntityTrackerEntry
{
    private final /* synthetic */ int range;
    private /* synthetic */ boolean updatedPlayerVisibility;
    private /* synthetic */ double lastTrackedEntityPosZ;
    private /* synthetic */ double lastTrackedEntityPosY;
    private /* synthetic */ int encodedRotationYaw;
    private /* synthetic */ double motionZ;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ double lastTrackedEntityMotionY;
    public /* synthetic */ int updateCounter;
    private final /* synthetic */ Entity trackedEntity;
    private /* synthetic */ int encodedRotationPitch;
    private /* synthetic */ boolean onGround;
    private /* synthetic */ double lastTrackedEntityPosX;
    private /* synthetic */ int maxRange;
    private /* synthetic */ List<Entity> passengers;
    private /* synthetic */ long encodedPosZ;
    private final /* synthetic */ boolean sendVelocityUpdates;
    private /* synthetic */ long encodedPosY;
    private final /* synthetic */ int updateFrequency;
    public /* synthetic */ boolean playerEntitiesUpdated;
    private final /* synthetic */ Set<EntityPlayerMP> trackingPlayers;
    private /* synthetic */ boolean ridingEntity;
    private /* synthetic */ int ticksSinceLastForcedTeleport;
    private /* synthetic */ long encodedPosX;
    private /* synthetic */ int lastHeadMotion;
    private /* synthetic */ double lastTrackedEntityMotionX;
    
    public void updatePlayerEntities(final List<EntityPlayer> lllllllllllllIllllIIIllIlllIIIll) {
        for (int lllllllllllllIllllIIIllIlllIIlIl = 0; lllllllllllllIllllIIIllIlllIIlIl < lllllllllllllIllllIIIllIlllIIIll.size(); ++lllllllllllllIllllIIIllIlllIIlIl) {
            this.updatePlayerEntity(lllllllllllllIllllIIIllIlllIIIll.get(lllllllllllllIllllIIIllIlllIIlIl));
        }
    }
    
    public Entity getTrackedEntity() {
        return this.trackedEntity;
    }
    
    public void setMaxRange(final int lllllllllllllIllllIIIllIlIllllll) {
        this.maxRange = lllllllllllllIllllIIIllIlIllllll;
    }
    
    @Override
    public int hashCode() {
        return this.trackedEntity.getEntityId();
    }
    
    public void removeFromTrackedPlayers(final EntityPlayerMP lllllllllllllIllllIIIlllIIIlllll) {
        if (this.trackingPlayers.contains(lllllllllllllIllllIIIlllIIIlllll)) {
            this.trackedEntity.removeTrackingPlayer(lllllllllllllIllllIIIlllIIIlllll);
            lllllllllllllIllllIIIlllIIIlllll.removeEntity(this.trackedEntity);
            this.trackingPlayers.remove(lllllllllllllIllllIIIlllIIIlllll);
        }
    }
    
    private boolean isPlayerWatchingThisChunk(final EntityPlayerMP lllllllllllllIllllIIIllIlllIllIl) {
        return lllllllllllllIllllIIIllIlllIllIl.getServerWorld().getPlayerChunkMap().isPlayerWatchingChunk(lllllllllllllIllllIIIllIlllIllIl, this.trackedEntity.chunkCoordX, this.trackedEntity.chunkCoordZ);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllllIIIllllIlIIlIl) {
        return lllllllllllllIllllIIIllllIlIIlIl instanceof EntityTrackerEntry && ((EntityTrackerEntry)lllllllllllllIllllIIIllllIlIIlIl).trackedEntity.getEntityId() == this.trackedEntity.getEntityId();
    }
    
    private Packet<?> createSpawnPacket() {
        if (this.trackedEntity.isDead) {
            EntityTrackerEntry.LOGGER.warn("Fetching addPacket for removed entity");
        }
        if (this.trackedEntity instanceof EntityPlayerMP) {
            return new SPacketSpawnPlayer((EntityPlayer)this.trackedEntity);
        }
        if (this.trackedEntity instanceof IAnimals) {
            this.lastHeadMotion = MathHelper.floor(this.trackedEntity.getRotationYawHead() * 256.0f / 360.0f);
            return new SPacketSpawnMob((EntityLivingBase)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityPainting) {
            return new SPacketSpawnPainting((EntityPainting)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityItem) {
            return new SPacketSpawnObject(this.trackedEntity, 2, 1);
        }
        if (this.trackedEntity instanceof EntityMinecart) {
            final EntityMinecart lllllllllllllIllllIIIllIllIlllII = (EntityMinecart)this.trackedEntity;
            return new SPacketSpawnObject(this.trackedEntity, 10, lllllllllllllIllllIIIllIllIlllII.getType().getId());
        }
        if (this.trackedEntity instanceof EntityBoat) {
            return new SPacketSpawnObject(this.trackedEntity, 1);
        }
        if (this.trackedEntity instanceof EntityXPOrb) {
            return new SPacketSpawnExperienceOrb((EntityXPOrb)this.trackedEntity);
        }
        if (this.trackedEntity instanceof EntityFishHook) {
            final Entity lllllllllllllIllllIIIllIllIllIll = ((EntityFishHook)this.trackedEntity).func_190619_l();
            return new SPacketSpawnObject(this.trackedEntity, 90, (lllllllllllllIllllIIIllIllIllIll == null) ? this.trackedEntity.getEntityId() : lllllllllllllIllllIIIllIllIllIll.getEntityId());
        }
        if (this.trackedEntity instanceof EntitySpectralArrow) {
            final Entity lllllllllllllIllllIIIllIllIllIlI = ((EntitySpectralArrow)this.trackedEntity).shootingEntity;
            return new SPacketSpawnObject(this.trackedEntity, 91, 1 + ((lllllllllllllIllllIIIllIllIllIlI == null) ? this.trackedEntity.getEntityId() : lllllllllllllIllllIIIllIllIllIlI.getEntityId()));
        }
        if (this.trackedEntity instanceof EntityTippedArrow) {
            final Entity lllllllllllllIllllIIIllIllIllIIl = ((EntityArrow)this.trackedEntity).shootingEntity;
            return new SPacketSpawnObject(this.trackedEntity, 60, 1 + ((lllllllllllllIllllIIIllIllIllIIl == null) ? this.trackedEntity.getEntityId() : lllllllllllllIllllIIIllIllIllIIl.getEntityId()));
        }
        if (this.trackedEntity instanceof EntitySnowball) {
            return new SPacketSpawnObject(this.trackedEntity, 61);
        }
        if (this.trackedEntity instanceof EntityLlamaSpit) {
            return new SPacketSpawnObject(this.trackedEntity, 68);
        }
        if (this.trackedEntity instanceof EntityPotion) {
            return new SPacketSpawnObject(this.trackedEntity, 73);
        }
        if (this.trackedEntity instanceof EntityExpBottle) {
            return new SPacketSpawnObject(this.trackedEntity, 75);
        }
        if (this.trackedEntity instanceof EntityEnderPearl) {
            return new SPacketSpawnObject(this.trackedEntity, 65);
        }
        if (this.trackedEntity instanceof EntityEnderEye) {
            return new SPacketSpawnObject(this.trackedEntity, 72);
        }
        if (this.trackedEntity instanceof EntityFireworkRocket) {
            return new SPacketSpawnObject(this.trackedEntity, 76);
        }
        if (this.trackedEntity instanceof EntityFireball) {
            final EntityFireball lllllllllllllIllllIIIllIllIllIII = (EntityFireball)this.trackedEntity;
            SPacketSpawnObject lllllllllllllIllllIIIllIllIlIlll = null;
            int lllllllllllllIllllIIIllIllIlIllI = 63;
            if (this.trackedEntity instanceof EntitySmallFireball) {
                lllllllllllllIllllIIIllIllIlIllI = 64;
            }
            else if (this.trackedEntity instanceof EntityDragonFireball) {
                lllllllllllllIllllIIIllIllIlIllI = 93;
            }
            else if (this.trackedEntity instanceof EntityWitherSkull) {
                lllllllllllllIllllIIIllIllIlIllI = 66;
            }
            if (lllllllllllllIllllIIIllIllIllIII.shootingEntity != null) {
                lllllllllllllIllllIIIllIllIlIlll = new SPacketSpawnObject(this.trackedEntity, lllllllllllllIllllIIIllIllIlIllI, ((EntityFireball)this.trackedEntity).shootingEntity.getEntityId());
            }
            else {
                lllllllllllllIllllIIIllIllIlIlll = new SPacketSpawnObject(this.trackedEntity, lllllllllllllIllllIIIllIllIlIllI, 0);
            }
            lllllllllllllIllllIIIllIllIlIlll.setSpeedX((int)(lllllllllllllIllllIIIllIllIllIII.accelerationX * 8000.0));
            lllllllllllllIllllIIIllIllIlIlll.setSpeedY((int)(lllllllllllllIllllIIIllIllIllIII.accelerationY * 8000.0));
            lllllllllllllIllllIIIllIllIlIlll.setSpeedZ((int)(lllllllllllllIllllIIIllIllIllIII.accelerationZ * 8000.0));
            return lllllllllllllIllllIIIllIllIlIlll;
        }
        if (this.trackedEntity instanceof EntityShulkerBullet) {
            final SPacketSpawnObject lllllllllllllIllllIIIllIllIlIlIl = new SPacketSpawnObject(this.trackedEntity, 67, 0);
            lllllllllllllIllllIIIllIllIlIlIl.setSpeedX((int)(this.trackedEntity.motionX * 8000.0));
            lllllllllllllIllllIIIllIllIlIlIl.setSpeedY((int)(this.trackedEntity.motionY * 8000.0));
            lllllllllllllIllllIIIllIllIlIlIl.setSpeedZ((int)(this.trackedEntity.motionZ * 8000.0));
            return lllllllllllllIllllIIIllIllIlIlIl;
        }
        if (this.trackedEntity instanceof EntityEgg) {
            return new SPacketSpawnObject(this.trackedEntity, 62);
        }
        if (this.trackedEntity instanceof EntityEvokerFangs) {
            return new SPacketSpawnObject(this.trackedEntity, 79);
        }
        if (this.trackedEntity instanceof EntityTNTPrimed) {
            return new SPacketSpawnObject(this.trackedEntity, 50);
        }
        if (this.trackedEntity instanceof EntityEnderCrystal) {
            return new SPacketSpawnObject(this.trackedEntity, 51);
        }
        if (this.trackedEntity instanceof EntityFallingBlock) {
            final EntityFallingBlock lllllllllllllIllllIIIllIllIlIlII = (EntityFallingBlock)this.trackedEntity;
            return new SPacketSpawnObject(this.trackedEntity, 70, Block.getStateId(lllllllllllllIllllIIIllIllIlIlII.getBlock()));
        }
        if (this.trackedEntity instanceof EntityArmorStand) {
            return new SPacketSpawnObject(this.trackedEntity, 78);
        }
        if (this.trackedEntity instanceof EntityItemFrame) {
            final EntityItemFrame lllllllllllllIllllIIIllIllIlIIll = (EntityItemFrame)this.trackedEntity;
            return new SPacketSpawnObject(this.trackedEntity, 71, lllllllllllllIllllIIIllIllIlIIll.facingDirection.getHorizontalIndex(), lllllllllllllIllllIIIllIllIlIIll.getHangingPosition());
        }
        if (this.trackedEntity instanceof EntityLeashKnot) {
            final EntityLeashKnot lllllllllllllIllllIIIllIllIlIIlI = (EntityLeashKnot)this.trackedEntity;
            return new SPacketSpawnObject(this.trackedEntity, 77, 0, lllllllllllllIllllIIIllIllIlIIlI.getHangingPosition());
        }
        if (this.trackedEntity instanceof EntityAreaEffectCloud) {
            return new SPacketSpawnObject(this.trackedEntity, 3);
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to add ").append(this.trackedEntity.getClass()).append("!")));
    }
    
    public void sendDestroyEntityPacketToTrackedPlayers() {
        for (final EntityPlayerMP lllllllllllllIllllIIIlllIIlIIllI : this.trackingPlayers) {
            this.trackedEntity.removeTrackingPlayer(lllllllllllllIllllIIIlllIIlIIllI);
            lllllllllllllIllllIIIlllIIlIIllI.removeEntity(this.trackedEntity);
        }
    }
    
    public void sendPacketToTrackedPlayers(final Packet<?> lllllllllllllIllllIIIlllIIllIllI) {
        for (final EntityPlayerMP lllllllllllllIllllIIIlllIIllIlIl : this.trackingPlayers) {
            lllllllllllllIllllIIIlllIIllIlIl.connection.sendPacket(lllllllllllllIllllIIIlllIIllIllI);
        }
    }
    
    public void resetPlayerVisibility() {
        this.updatedPlayerVisibility = false;
    }
    
    public EntityTrackerEntry(final Entity lllllllllllllIllllIIIlllllIIlIII, final int lllllllllllllIllllIIIllllIlllIll, final int lllllllllllllIllllIIIlllllIIIlII, final int lllllllllllllIllllIIIllllIllIlll, final boolean lllllllllllllIllllIIIllllIllIlIl) {
        this.passengers = Collections.emptyList();
        this.trackingPlayers = (Set<EntityPlayerMP>)Sets.newHashSet();
        this.trackedEntity = lllllllllllllIllllIIIlllllIIlIII;
        this.range = lllllllllllllIllllIIIllllIlllIll;
        this.maxRange = lllllllllllllIllllIIIlllllIIIlII;
        this.updateFrequency = lllllllllllllIllllIIIllllIllIlll;
        this.sendVelocityUpdates = lllllllllllllIllllIIIllllIllIlIl;
        this.encodedPosX = EntityTracker.getPositionLong(lllllllllllllIllllIIIlllllIIlIII.posX);
        this.encodedPosY = EntityTracker.getPositionLong(lllllllllllllIllllIIIlllllIIlIII.posY);
        this.encodedPosZ = EntityTracker.getPositionLong(lllllllllllllIllllIIIlllllIIlIII.posZ);
        this.encodedRotationYaw = MathHelper.floor(lllllllllllllIllllIIIlllllIIlIII.rotationYaw * 256.0f / 360.0f);
        this.encodedRotationPitch = MathHelper.floor(lllllllllllllIllllIIIlllllIIlIII.rotationPitch * 256.0f / 360.0f);
        this.lastHeadMotion = MathHelper.floor(lllllllllllllIllllIIIlllllIIlIII.getRotationYawHead() * 256.0f / 360.0f);
        this.onGround = lllllllllllllIllllIIIlllllIIlIII.onGround;
    }
    
    public void updatePlayerList(final List<EntityPlayer> lllllllllllllIllllIIIlllIllllIll) {
        this.playerEntitiesUpdated = false;
        if (!this.updatedPlayerVisibility || this.trackedEntity.getDistanceSq(this.lastTrackedEntityPosX, this.lastTrackedEntityPosY, this.lastTrackedEntityPosZ) > 16.0) {
            this.lastTrackedEntityPosX = this.trackedEntity.posX;
            this.lastTrackedEntityPosY = this.trackedEntity.posY;
            this.lastTrackedEntityPosZ = this.trackedEntity.posZ;
            this.updatedPlayerVisibility = true;
            this.playerEntitiesUpdated = true;
            this.updatePlayerEntities(lllllllllllllIllllIIIlllIllllIll);
        }
        final List<Entity> lllllllllllllIllllIIIlllIllllIlI = this.trackedEntity.getPassengers();
        if (!lllllllllllllIllllIIIlllIllllIlI.equals(this.passengers)) {
            this.passengers = lllllllllllllIllllIIIlllIllllIlI;
            this.sendPacketToTrackedPlayers(new SPacketSetPassengers(this.trackedEntity));
        }
        if (this.trackedEntity instanceof EntityItemFrame && this.updateCounter % 10 == 0) {
            final EntityItemFrame lllllllllllllIllllIIIlllIllllIIl = (EntityItemFrame)this.trackedEntity;
            final ItemStack lllllllllllllIllllIIIlllIllllIII = lllllllllllllIllllIIIlllIllllIIl.getDisplayedItem();
            if (lllllllllllllIllllIIIlllIllllIII.getItem() instanceof ItemMap) {
                final MapData lllllllllllllIllllIIIlllIlllIlll = Items.FILLED_MAP.getMapData(lllllllllllllIllllIIIlllIllllIII, this.trackedEntity.world);
                for (final EntityPlayer lllllllllllllIllllIIIlllIlllIllI : lllllllllllllIllllIIIlllIllllIll) {
                    final EntityPlayerMP lllllllllllllIllllIIIlllIlllIlIl = (EntityPlayerMP)lllllllllllllIllllIIIlllIlllIllI;
                    lllllllllllllIllllIIIlllIlllIlll.updateVisiblePlayers(lllllllllllllIllllIIIlllIlllIlIl, lllllllllllllIllllIIIlllIllllIII);
                    final Packet<?> lllllllllllllIllllIIIlllIlllIlII = Items.FILLED_MAP.createMapDataPacket(lllllllllllllIllllIIIlllIllllIII, this.trackedEntity.world, lllllllllllllIllllIIIlllIlllIlIl);
                    if (lllllllllllllIllllIIIlllIlllIlII != null) {
                        lllllllllllllIllllIIIlllIlllIlIl.connection.sendPacket(lllllllllllllIllllIIIlllIlllIlII);
                    }
                }
            }
            this.sendMetadataToAllAssociatedPlayers();
        }
        if (this.updateCounter % this.updateFrequency == 0 || this.trackedEntity.isAirBorne || this.trackedEntity.getDataManager().isDirty()) {
            if (this.trackedEntity.isRiding()) {
                final int lllllllllllllIllllIIIlllIlllIIll = MathHelper.floor(this.trackedEntity.rotationYaw * 256.0f / 360.0f);
                final int lllllllllllllIllllIIIlllIlllIIlI = MathHelper.floor(this.trackedEntity.rotationPitch * 256.0f / 360.0f);
                final boolean lllllllllllllIllllIIIlllIlllIIIl = Math.abs(lllllllllllllIllllIIIlllIlllIIll - this.encodedRotationYaw) >= 1 || Math.abs(lllllllllllllIllllIIIlllIlllIIlI - this.encodedRotationPitch) >= 1;
                if (lllllllllllllIllllIIIlllIlllIIIl) {
                    this.sendPacketToTrackedPlayers(new SPacketEntity.S16PacketEntityLook(this.trackedEntity.getEntityId(), (byte)lllllllllllllIllllIIIlllIlllIIll, (byte)lllllllllllllIllllIIIlllIlllIIlI, this.trackedEntity.onGround));
                    this.encodedRotationYaw = lllllllllllllIllllIIIlllIlllIIll;
                    this.encodedRotationPitch = lllllllllllllIllllIIIlllIlllIIlI;
                }
                this.encodedPosX = EntityTracker.getPositionLong(this.trackedEntity.posX);
                this.encodedPosY = EntityTracker.getPositionLong(this.trackedEntity.posY);
                this.encodedPosZ = EntityTracker.getPositionLong(this.trackedEntity.posZ);
                this.sendMetadataToAllAssociatedPlayers();
                this.ridingEntity = true;
            }
            else {
                ++this.ticksSinceLastForcedTeleport;
                final long lllllllllllllIllllIIIlllIlllIIII = EntityTracker.getPositionLong(this.trackedEntity.posX);
                final long lllllllllllllIllllIIIlllIllIllll = EntityTracker.getPositionLong(this.trackedEntity.posY);
                final long lllllllllllllIllllIIIlllIllIlllI = EntityTracker.getPositionLong(this.trackedEntity.posZ);
                final int lllllllllllllIllllIIIlllIllIllIl = MathHelper.floor(this.trackedEntity.rotationYaw * 256.0f / 360.0f);
                final int lllllllllllllIllllIIIlllIllIllII = MathHelper.floor(this.trackedEntity.rotationPitch * 256.0f / 360.0f);
                final long lllllllllllllIllllIIIlllIllIlIll = lllllllllllllIllllIIIlllIlllIIII - this.encodedPosX;
                final long lllllllllllllIllllIIIlllIllIlIlI = lllllllllllllIllllIIIlllIllIllll - this.encodedPosY;
                final long lllllllllllllIllllIIIlllIllIlIIl = lllllllllllllIllllIIIlllIllIlllI - this.encodedPosZ;
                Packet<?> lllllllllllllIllllIIIlllIllIlIII = null;
                final boolean lllllllllllllIllllIIIlllIllIIlll = lllllllllllllIllllIIIlllIllIlIll * lllllllllllllIllllIIIlllIllIlIll + lllllllllllllIllllIIIlllIllIlIlI * lllllllllllllIllllIIIlllIllIlIlI + lllllllllllllIllllIIIlllIllIlIIl * lllllllllllllIllllIIIlllIllIlIIl >= 128L || this.updateCounter % 60 == 0;
                final boolean lllllllllllllIllllIIIlllIllIIllI = Math.abs(lllllllllllllIllllIIIlllIllIllIl - this.encodedRotationYaw) >= 1 || Math.abs(lllllllllllllIllllIIIlllIllIllII - this.encodedRotationPitch) >= 1;
                if (this.updateCounter > 0 || this.trackedEntity instanceof EntityArrow) {
                    if (lllllllllllllIllllIIIlllIllIlIll >= -32768L && lllllllllllllIllllIIIlllIllIlIll < 32768L && lllllllllllllIllllIIIlllIllIlIlI >= -32768L && lllllllllllllIllllIIIlllIllIlIlI < 32768L && lllllllllllllIllllIIIlllIllIlIIl >= -32768L && lllllllllllllIllllIIIlllIllIlIIl < 32768L && this.ticksSinceLastForcedTeleport <= 400 && !this.ridingEntity && this.onGround == this.trackedEntity.onGround) {
                        if ((!lllllllllllllIllllIIIlllIllIIlll || !lllllllllllllIllllIIIlllIllIIllI) && !(this.trackedEntity instanceof EntityArrow)) {
                            if (lllllllllllllIllllIIIlllIllIIlll) {
                                lllllllllllllIllllIIIlllIllIlIII = new SPacketEntity.S15PacketEntityRelMove(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIllIlIll, lllllllllllllIllllIIIlllIllIlIlI, lllllllllllllIllllIIIlllIllIlIIl, this.trackedEntity.onGround);
                            }
                            else if (lllllllllllllIllllIIIlllIllIIllI) {
                                lllllllllllllIllllIIIlllIllIlIII = new SPacketEntity.S16PacketEntityLook(this.trackedEntity.getEntityId(), (byte)lllllllllllllIllllIIIlllIllIllIl, (byte)lllllllllllllIllllIIIlllIllIllII, this.trackedEntity.onGround);
                            }
                        }
                        else {
                            lllllllllllllIllllIIIlllIllIlIII = new SPacketEntity.S17PacketEntityLookMove(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIllIlIll, lllllllllllllIllllIIIlllIllIlIlI, lllllllllllllIllllIIIlllIllIlIIl, (byte)lllllllllllllIllllIIIlllIllIllIl, (byte)lllllllllllllIllllIIIlllIllIllII, this.trackedEntity.onGround);
                        }
                    }
                    else {
                        this.onGround = this.trackedEntity.onGround;
                        this.ticksSinceLastForcedTeleport = 0;
                        this.resetPlayerVisibility();
                        lllllllllllllIllllIIIlllIllIlIII = new SPacketEntityTeleport(this.trackedEntity);
                    }
                }
                boolean lllllllllllllIllllIIIlllIllIIlIl = this.sendVelocityUpdates;
                if (this.trackedEntity instanceof EntityLivingBase && ((EntityLivingBase)this.trackedEntity).isElytraFlying()) {
                    lllllllllllllIllllIIIlllIllIIlIl = true;
                }
                if (lllllllllllllIllllIIIlllIllIIlIl && this.updateCounter > 0) {
                    final double lllllllllllllIllllIIIlllIllIIlII = this.trackedEntity.motionX - this.lastTrackedEntityMotionX;
                    final double lllllllllllllIllllIIIlllIllIIIll = this.trackedEntity.motionY - this.lastTrackedEntityMotionY;
                    final double lllllllllllllIllllIIIlllIllIIIlI = this.trackedEntity.motionZ - this.motionZ;
                    final double lllllllllllllIllllIIIlllIllIIIIl = 0.02;
                    final double lllllllllllllIllllIIIlllIllIIIII = lllllllllllllIllllIIIlllIllIIlII * lllllllllllllIllllIIIlllIllIIlII + lllllllllllllIllllIIIlllIllIIIll * lllllllllllllIllllIIIlllIllIIIll + lllllllllllllIllllIIIlllIllIIIlI * lllllllllllllIllllIIIlllIllIIIlI;
                    if (lllllllllllllIllllIIIlllIllIIIII > 4.0E-4 || (lllllllllllllIllllIIIlllIllIIIII > 0.0 && this.trackedEntity.motionX == 0.0 && this.trackedEntity.motionY == 0.0 && this.trackedEntity.motionZ == 0.0)) {
                        this.lastTrackedEntityMotionX = this.trackedEntity.motionX;
                        this.lastTrackedEntityMotionY = this.trackedEntity.motionY;
                        this.motionZ = this.trackedEntity.motionZ;
                        this.sendPacketToTrackedPlayers(new SPacketEntityVelocity(this.trackedEntity.getEntityId(), this.lastTrackedEntityMotionX, this.lastTrackedEntityMotionY, this.motionZ));
                    }
                }
                if (lllllllllllllIllllIIIlllIllIlIII != null) {
                    this.sendPacketToTrackedPlayers(lllllllllllllIllllIIIlllIllIlIII);
                }
                this.sendMetadataToAllAssociatedPlayers();
                if (lllllllllllllIllllIIIlllIllIIlll) {
                    this.encodedPosX = lllllllllllllIllllIIIlllIlllIIII;
                    this.encodedPosY = lllllllllllllIllllIIIlllIllIllll;
                    this.encodedPosZ = lllllllllllllIllllIIIlllIllIlllI;
                }
                if (lllllllllllllIllllIIIlllIllIIllI) {
                    this.encodedRotationYaw = lllllllllllllIllllIIIlllIllIllIl;
                    this.encodedRotationPitch = lllllllllllllIllllIIIlllIllIllII;
                }
                this.ridingEntity = false;
            }
            final int lllllllllllllIllllIIIlllIlIlllll = MathHelper.floor(this.trackedEntity.getRotationYawHead() * 256.0f / 360.0f);
            if (Math.abs(lllllllllllllIllllIIIlllIlIlllll - this.lastHeadMotion) >= 1) {
                this.sendPacketToTrackedPlayers(new SPacketEntityHeadLook(this.trackedEntity, (byte)lllllllllllllIllllIIIlllIlIlllll));
                this.lastHeadMotion = lllllllllllllIllllIIIlllIlIlllll;
            }
            this.trackedEntity.isAirBorne = false;
        }
        ++this.updateCounter;
        if (this.trackedEntity.velocityChanged) {
            this.sendToTrackingAndSelf(new SPacketEntityVelocity(this.trackedEntity));
            this.trackedEntity.velocityChanged = false;
        }
    }
    
    public void sendToTrackingAndSelf(final Packet<?> lllllllllllllIllllIIIlllIIlIlIll) {
        this.sendPacketToTrackedPlayers(lllllllllllllIllllIIIlllIIlIlIll);
        if (this.trackedEntity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)this.trackedEntity).connection.sendPacket(lllllllllllllIllllIIIlllIIlIlIll);
        }
    }
    
    public void removeTrackedPlayerSymmetric(final EntityPlayerMP lllllllllllllIllllIIIllIllIIlIII) {
        if (this.trackingPlayers.contains(lllllllllllllIllllIIIllIllIIlIII)) {
            this.trackingPlayers.remove(lllllllllllllIllllIIIllIllIIlIII);
            this.trackedEntity.removeTrackingPlayer(lllllllllllllIllllIIIllIllIIlIII);
            lllllllllllllIllllIIIllIllIIlIII.removeEntity(this.trackedEntity);
        }
    }
    
    public void updatePlayerEntity(final EntityPlayerMP lllllllllllllIllllIIIlllIIIlIIlI) {
        if (lllllllllllllIllllIIIlllIIIlIIlI != this.trackedEntity) {
            if (this.isVisibleTo(lllllllllllllIllllIIIlllIIIlIIlI)) {
                if (!this.trackingPlayers.contains(lllllllllllllIllllIIIlllIIIlIIlI) && (this.isPlayerWatchingThisChunk(lllllllllllllIllllIIIlllIIIlIIlI) || this.trackedEntity.forceSpawn)) {
                    this.trackingPlayers.add(lllllllllllllIllllIIIlllIIIlIIlI);
                    final Packet<?> lllllllllllllIllllIIIlllIIIlIIIl = this.createSpawnPacket();
                    lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(lllllllllllllIllllIIIlllIIIlIIIl);
                    if (!this.trackedEntity.getDataManager().isEmpty()) {
                        lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketEntityMetadata(this.trackedEntity.getEntityId(), this.trackedEntity.getDataManager(), true));
                    }
                    boolean lllllllllllllIllllIIIlllIIIlIIII = this.sendVelocityUpdates;
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        final AttributeMap lllllllllllllIllllIIIlllIIIIllll = (AttributeMap)((EntityLivingBase)this.trackedEntity).getAttributeMap();
                        final Collection<IAttributeInstance> lllllllllllllIllllIIIlllIIIIlllI = lllllllllllllIllllIIIlllIIIIllll.getWatchedAttributes();
                        if (!lllllllllllllIllllIIIlllIIIIlllI.isEmpty()) {
                            lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketEntityProperties(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIIIIlllI));
                        }
                        if (((EntityLivingBase)this.trackedEntity).isElytraFlying()) {
                            lllllllllllllIllllIIIlllIIIlIIII = true;
                        }
                    }
                    this.lastTrackedEntityMotionX = this.trackedEntity.motionX;
                    this.lastTrackedEntityMotionY = this.trackedEntity.motionY;
                    this.motionZ = this.trackedEntity.motionZ;
                    if (lllllllllllllIllllIIIlllIIIlIIII && !(lllllllllllllIllllIIIlllIIIlIIIl instanceof SPacketSpawnMob)) {
                        lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketEntityVelocity(this.trackedEntity.getEntityId(), this.trackedEntity.motionX, this.trackedEntity.motionY, this.trackedEntity.motionZ));
                    }
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        final char lllllllllllllIllllIIIlllIIIIIIIl;
                        final boolean lllllllllllllIllllIIIlllIIIIIIlI = ((EntityEquipmentSlot[])(Object)(lllllllllllllIllllIIIlllIIIIIIIl = (char)(Object)EntityEquipmentSlot.values())).length != 0;
                        for (final EntityEquipmentSlot lllllllllllllIllllIIIlllIIIIllIl : lllllllllllllIllllIIIlllIIIIIIIl) {
                            final ItemStack lllllllllllllIllllIIIlllIIIIllII = ((EntityLivingBase)this.trackedEntity).getItemStackFromSlot(lllllllllllllIllllIIIlllIIIIllIl);
                            if (!lllllllllllllIllllIIIlllIIIIllII.func_190926_b()) {
                                lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketEntityEquipment(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIIIIllIl, lllllllllllllIllllIIIlllIIIIllII));
                            }
                        }
                    }
                    if (this.trackedEntity instanceof EntityPlayer) {
                        final EntityPlayer lllllllllllllIllllIIIlllIIIIlIll = (EntityPlayer)this.trackedEntity;
                        if (lllllllllllllIllllIIIlllIIIIlIll.isPlayerSleeping()) {
                            lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketUseBed(lllllllllllllIllllIIIlllIIIIlIll, new BlockPos(this.trackedEntity)));
                        }
                    }
                    if (this.trackedEntity instanceof EntityLivingBase) {
                        final EntityLivingBase lllllllllllllIllllIIIlllIIIIlIlI = (EntityLivingBase)this.trackedEntity;
                        for (final PotionEffect lllllllllllllIllllIIIlllIIIIlIIl : lllllllllllllIllllIIIlllIIIIlIlI.getActivePotionEffects()) {
                            lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketEntityEffect(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIIIIlIIl));
                        }
                    }
                    if (!this.trackedEntity.getPassengers().isEmpty()) {
                        lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketSetPassengers(this.trackedEntity));
                    }
                    if (this.trackedEntity.isRiding()) {
                        lllllllllllllIllllIIIlllIIIlIIlI.connection.sendPacket(new SPacketSetPassengers(this.trackedEntity.getRidingEntity()));
                    }
                    this.trackedEntity.addTrackingPlayer(lllllllllllllIllllIIIlllIIIlIIlI);
                    lllllllllllllIllllIIIlllIIIlIIlI.addEntity(this.trackedEntity);
                }
            }
            else if (this.trackingPlayers.contains(lllllllllllllIllllIIIlllIIIlIIlI)) {
                this.trackingPlayers.remove(lllllllllllllIllllIIIlllIIIlIIlI);
                this.trackedEntity.removeTrackingPlayer(lllllllllllllIllllIIIlllIIIlIIlI);
                lllllllllllllIllllIIIlllIIIlIIlI.removeEntity(this.trackedEntity);
            }
        }
    }
    
    private void sendMetadataToAllAssociatedPlayers() {
        final EntityDataManager lllllllllllllIllllIIIlllIlIIIIlI = this.trackedEntity.getDataManager();
        if (lllllllllllllIllllIIIlllIlIIIIlI.isDirty()) {
            this.sendToTrackingAndSelf(new SPacketEntityMetadata(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIlIIIIlI, false));
        }
        if (this.trackedEntity instanceof EntityLivingBase) {
            final AttributeMap lllllllllllllIllllIIIlllIlIIIIIl = (AttributeMap)((EntityLivingBase)this.trackedEntity).getAttributeMap();
            final Set<IAttributeInstance> lllllllllllllIllllIIIlllIlIIIIII = lllllllllllllIllllIIIlllIlIIIIIl.getAttributeInstanceSet();
            if (!lllllllllllllIllllIIIlllIlIIIIII.isEmpty()) {
                this.sendToTrackingAndSelf(new SPacketEntityProperties(this.trackedEntity.getEntityId(), lllllllllllllIllllIIIlllIlIIIIII));
            }
            lllllllllllllIllllIIIlllIlIIIIII.clear();
        }
    }
    
    public boolean isVisibleTo(final EntityPlayerMP lllllllllllllIllllIIIllIlllllIIl) {
        final double lllllllllllllIllllIIIllIlllllIII = lllllllllllllIllllIIIllIlllllIIl.posX - this.encodedPosX / 4096.0;
        final double lllllllllllllIllllIIIllIllllIlll = lllllllllllllIllllIIIllIlllllIIl.posZ - this.encodedPosZ / 4096.0;
        final int lllllllllllllIllllIIIllIllllIllI = Math.min(this.range, this.maxRange);
        return lllllllllllllIllllIIIllIlllllIII >= -lllllllllllllIllllIIIllIllllIllI && lllllllllllllIllllIIIllIlllllIII <= lllllllllllllIllllIIIllIllllIllI && lllllllllllllIllllIIIllIllllIlll >= -lllllllllllllIllllIIIllIllllIllI && lllllllllllllIllllIIIllIllllIlll <= lllllllllllllIllllIIIllIllllIllI && this.trackedEntity.isSpectatedByPlayer(lllllllllllllIllllIIIllIlllllIIl);
    }
}
