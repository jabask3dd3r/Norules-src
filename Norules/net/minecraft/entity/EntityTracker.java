package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.network.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.chunk.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.math.*;
import java.util.*;

public class EntityTracker
{
    private /* synthetic */ int maxTrackingDistanceThreshold;
    private final /* synthetic */ IntHashMap<EntityTrackerEntry> trackedEntityHashTable;
    private final /* synthetic */ Set<EntityTrackerEntry> trackedEntities;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ WorldServer theWorld;
    
    public void trackEntity(final Entity lllllllllllllllIIlIIllIlIIIlIlll, final int lllllllllllllllIIlIIllIlIIIllIlI, final int lllllllllllllllIIlIIllIlIIIllIIl) {
        this.addEntityToTracker(lllllllllllllllIIlIIllIlIIIlIlll, lllllllllllllllIIlIIllIlIIIllIlI, lllllllllllllllIIlIIllIlIIIllIIl, false);
    }
    
    public void addEntityToTracker(final Entity lllllllllllllllIIlIIllIlIIIIlIlI, final int lllllllllllllllIIlIIllIIllllllll, final int lllllllllllllllIIlIIllIIlllllllI, final boolean lllllllllllllllIIlIIllIIllllllIl) {
        try {
            if (this.trackedEntityHashTable.containsItem(lllllllllllllllIIlIIllIlIIIIlIlI.getEntityId())) {
                throw new IllegalStateException("Entity is already tracked!");
            }
            final EntityTrackerEntry lllllllllllllllIIlIIllIlIIIIIllI = new EntityTrackerEntry(lllllllllllllllIIlIIllIlIIIIlIlI, lllllllllllllllIIlIIllIIllllllll, this.maxTrackingDistanceThreshold, lllllllllllllllIIlIIllIIlllllllI, lllllllllllllllIIlIIllIIllllllIl);
            this.trackedEntities.add(lllllllllllllllIIlIIllIlIIIIIllI);
            this.trackedEntityHashTable.addKey(lllllllllllllllIIlIIllIlIIIIlIlI.getEntityId(), lllllllllllllllIIlIIllIlIIIIIllI);
            lllllllllllllllIIlIIllIlIIIIIllI.updatePlayerEntities(this.theWorld.playerEntities);
        }
        catch (Throwable lllllllllllllllIIlIIllIlIIIIIlIl) {
            final CrashReport lllllllllllllllIIlIIllIlIIIIIlII = CrashReport.makeCrashReport(lllllllllllllllIIlIIllIlIIIIIlIl, "Adding entity to track");
            final CrashReportCategory lllllllllllllllIIlIIllIlIIIIIIll = lllllllllllllllIIlIIllIlIIIIIlII.makeCategory("Entity To Track");
            lllllllllllllllIIlIIllIlIIIIIIll.addCrashSection("Tracking range", String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIlIIllIIllllllll)).append(" blocks")));
            lllllllllllllllIIlIIllIlIIIIIIll.setDetail("Update interval", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    String lllllllllllllIIlllllllllllIlIllI = String.valueOf(new StringBuilder("Once per ").append(lllllllllllllllIIlIIllIIlllllllI).append(" ticks"));
                    if (lllllllllllllllIIlIIllIIlllllllI == Integer.MAX_VALUE) {
                        lllllllllllllIIlllllllllllIlIllI = String.valueOf(new StringBuilder("Maximum (").append(lllllllllllllIIlllllllllllIlIllI).append(")"));
                    }
                    return lllllllllllllIIlllllllllllIlIllI;
                }
            });
            lllllllllllllllIIlIIllIlIIIIlIlI.addEntityCrashInfo(lllllllllllllllIIlIIllIlIIIIIIll);
            this.trackedEntityHashTable.lookup(lllllllllllllllIIlIIllIlIIIIlIlI.getEntityId()).getTrackedEntity().addEntityCrashInfo(lllllllllllllllIIlIIllIlIIIIIlII.makeCategory("Entity That Is Already Tracked"));
            try {
                throw new ReportedException(lllllllllllllllIIlIIllIlIIIIIlII);
            }
            catch (ReportedException lllllllllllllllIIlIIllIlIIIIIIlI) {
                EntityTracker.LOGGER.error("\"Silently\" catching entity tracking error.", (Throwable)lllllllllllllllIIlIIllIlIIIIIIlI);
            }
        }
    }
    
    public void sendToAllTrackingEntity(final Entity lllllllllllllllIIlIIllIIllIIIIlI, final Packet<?> lllllllllllllllIIlIIllIIllIIIIIl) {
        final EntityTrackerEntry lllllllllllllllIIlIIllIIllIIIlII = this.trackedEntityHashTable.lookup(lllllllllllllllIIlIIllIIllIIIIlI.getEntityId());
        if (lllllllllllllllIIlIIllIIllIIIlII != null) {
            lllllllllllllllIIlIIllIIllIIIlII.sendPacketToTrackedPlayers(lllllllllllllllIIlIIllIIllIIIIIl);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void removePlayerFromTrackers(final EntityPlayerMP lllllllllllllllIIlIIllIIlIlIlIll) {
        for (final EntityTrackerEntry lllllllllllllllIIlIIllIIlIlIllIl : this.trackedEntities) {
            lllllllllllllllIIlIIllIIlIlIllIl.removeTrackedPlayerSymmetric(lllllllllllllllIIlIIllIIlIlIlIll);
        }
    }
    
    public void sendToTrackingAndSelf(final Entity lllllllllllllllIIlIIllIIlIlllIlI, final Packet<?> lllllllllllllllIIlIIllIIlIllIlIl) {
        final EntityTrackerEntry lllllllllllllllIIlIIllIIlIlllIII = this.trackedEntityHashTable.lookup(lllllllllllllllIIlIIllIIlIlllIlI.getEntityId());
        if (lllllllllllllllIIlIIllIIlIlllIII != null) {
            lllllllllllllllIIlIIllIIlIlllIII.sendToTrackingAndSelf(lllllllllllllllIIlIIllIIlIllIlIl);
        }
    }
    
    public EntityTracker(final WorldServer lllllllllllllllIIlIIllIlIlIIIIII) {
        this.trackedEntities = (Set<EntityTrackerEntry>)Sets.newHashSet();
        this.trackedEntityHashTable = new IntHashMap<EntityTrackerEntry>();
        this.theWorld = lllllllllllllllIIlIIllIlIlIIIIII;
        this.maxTrackingDistanceThreshold = lllllllllllllllIIlIIllIlIlIIIIII.getMinecraftServer().getPlayerList().getEntityViewDistance();
    }
    
    public void trackEntity(final Entity lllllllllllllllIIlIIllIlIIlIlIII) {
        if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityPlayerMP) {
            this.trackEntity(lllllllllllllllIIlIIllIlIIlIlIII, 512, 2);
            final EntityPlayerMP lllllllllllllllIIlIIllIlIIlIIlll = (EntityPlayerMP)lllllllllllllllIIlIIllIlIIlIlIII;
            for (final EntityTrackerEntry lllllllllllllllIIlIIllIlIIlIIllI : this.trackedEntities) {
                if (lllllllllllllllIIlIIllIlIIlIIllI.getTrackedEntity() != lllllllllllllllIIlIIllIlIIlIIlll) {
                    lllllllllllllllIIlIIllIlIIlIIllI.updatePlayerEntity(lllllllllllllllIIlIIllIlIIlIIlll);
                }
            }
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityFishHook) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 5, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityArrow) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 20, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntitySmallFireball) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityFireball) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntitySnowball) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityLlamaSpit) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityEnderPearl) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityEnderEye) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 4, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityEgg) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityPotion) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityExpBottle) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityFireworkRocket) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityItem) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 20, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityMinecart) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityBoat) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntitySquid) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 64, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityWither) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityShulkerBullet) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityBat) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityDragon) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof IAnimals) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 80, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityTNTPrimed) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 10, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityFallingBlock) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 20, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityHanging) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, Integer.MAX_VALUE, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityArmorStand) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 3, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityXPOrb) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 20, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityAreaEffectCloud) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, Integer.MAX_VALUE, true);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityEnderCrystal) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 256, Integer.MAX_VALUE, false);
        }
        else if (lllllllllllllllIIlIIllIlIIlIlIII instanceof EntityEvokerFangs) {
            this.addEntityToTracker(lllllllllllllllIIlIIllIlIIlIlIII, 160, 2, false);
        }
    }
    
    public void sendLeashedEntitiesInChunk(final EntityPlayerMP lllllllllllllllIIlIIllIIlIIlIllI, final Chunk lllllllllllllllIIlIIllIIlIIlIlIl) {
        final List<Entity> lllllllllllllllIIlIIllIIlIIlllIl = (List<Entity>)Lists.newArrayList();
        final List<Entity> lllllllllllllllIIlIIllIIlIIlllII = (List<Entity>)Lists.newArrayList();
        for (final EntityTrackerEntry lllllllllllllllIIlIIllIIlIIllIll : this.trackedEntities) {
            final Entity lllllllllllllllIIlIIllIIlIIllIlI = lllllllllllllllIIlIIllIIlIIllIll.getTrackedEntity();
            if (lllllllllllllllIIlIIllIIlIIllIlI != lllllllllllllllIIlIIllIIlIIlIllI && lllllllllllllllIIlIIllIIlIIllIlI.chunkCoordX == lllllllllllllllIIlIIllIIlIIlIlIl.xPosition && lllllllllllllllIIlIIllIIlIIllIlI.chunkCoordZ == lllllllllllllllIIlIIllIIlIIlIlIl.zPosition) {
                lllllllllllllllIIlIIllIIlIIllIll.updatePlayerEntity(lllllllllllllllIIlIIllIIlIIlIllI);
                if (lllllllllllllllIIlIIllIIlIIllIlI instanceof EntityLiving && ((EntityLiving)lllllllllllllllIIlIIllIIlIIllIlI).getLeashedToEntity() != null) {
                    lllllllllllllllIIlIIllIIlIIlllIl.add(lllllllllllllllIIlIIllIIlIIllIlI);
                }
                if (lllllllllllllllIIlIIllIIlIIllIlI.getPassengers().isEmpty()) {
                    continue;
                }
                lllllllllllllllIIlIIllIIlIIlllII.add(lllllllllllllllIIlIIllIIlIIllIlI);
            }
        }
        if (!lllllllllllllllIIlIIllIIlIIlllIl.isEmpty()) {
            for (final Entity lllllllllllllllIIlIIllIIlIIllIIl : lllllllllllllllIIlIIllIIlIIlllIl) {
                lllllllllllllllIIlIIllIIlIIlIllI.connection.sendPacket(new SPacketEntityAttach(lllllllllllllllIIlIIllIIlIIllIIl, ((EntityLiving)lllllllllllllllIIlIIllIIlIIllIIl).getLeashedToEntity()));
            }
        }
        if (!lllllllllllllllIIlIIllIIlIIlllII.isEmpty()) {
            for (final Entity lllllllllllllllIIlIIllIIlIIllIII : lllllllllllllllIIlIIllIIlIIlllII) {
                lllllllllllllllIIlIIllIIlIIlIllI.connection.sendPacket(new SPacketSetPassengers(lllllllllllllllIIlIIllIIlIIllIII));
            }
        }
    }
    
    public void updateVisibility(final EntityPlayerMP lllllllllllllllIIlIIllIIllIlIIIl) {
        for (final EntityTrackerEntry lllllllllllllllIIlIIllIIllIlIIII : this.trackedEntities) {
            if (lllllllllllllllIIlIIllIIllIlIIII.getTrackedEntity() == lllllllllllllllIIlIIllIIllIlIIIl) {
                lllllllllllllllIIlIIllIIllIlIIII.updatePlayerEntities(this.theWorld.playerEntities);
            }
            else {
                lllllllllllllllIIlIIllIIllIlIIII.updatePlayerEntity(lllllllllllllllIIlIIllIIllIlIIIl);
            }
        }
    }
    
    public static long getPositionLong(final double lllllllllllllllIIlIIllIlIIlllIll) {
        return MathHelper.lFloor(lllllllllllllllIIlIIllIlIIlllIll * 4096.0);
    }
    
    public void untrackEntity(final Entity lllllllllllllllIIlIIllIIlllIllIl) {
        if (lllllllllllllllIIlIIllIIlllIllIl instanceof EntityPlayerMP) {
            final EntityPlayerMP lllllllllllllllIIlIIllIIllllIIIl = (EntityPlayerMP)lllllllllllllllIIlIIllIIlllIllIl;
            for (final EntityTrackerEntry lllllllllllllllIIlIIllIIllllIIII : this.trackedEntities) {
                lllllllllllllllIIlIIllIIllllIIII.removeFromTrackedPlayers(lllllllllllllllIIlIIllIIllllIIIl);
            }
        }
        final EntityTrackerEntry lllllllllllllllIIlIIllIIlllIllll = this.trackedEntityHashTable.removeObject(lllllllllllllllIIlIIllIIlllIllIl.getEntityId());
        if (lllllllllllllllIIlIIllIIlllIllll != null) {
            this.trackedEntities.remove(lllllllllllllllIIlIIllIIlllIllll);
            lllllllllllllllIIlIIllIIlllIllll.sendDestroyEntityPacketToTrackedPlayers();
        }
    }
    
    public static void updateServerPosition(final Entity lllllllllllllllIIlIIllIlIIllIIlI, final double lllllllllllllllIIlIIllIlIIllIlIl, final double lllllllllllllllIIlIIllIlIIllIIII, final double lllllllllllllllIIlIIllIlIIlIllll) {
        lllllllllllllllIIlIIllIlIIllIIlI.serverPosX = getPositionLong(lllllllllllllllIIlIIllIlIIllIlIl);
        lllllllllllllllIIlIIllIlIIllIIlI.serverPosY = getPositionLong(lllllllllllllllIIlIIllIlIIllIIII);
        lllllllllllllllIIlIIllIlIIllIIlI.serverPosZ = getPositionLong(lllllllllllllllIIlIIllIlIIlIllll);
    }
    
    public void updateTrackedEntities() {
        final List<EntityPlayerMP> lllllllllllllllIIlIIllIIlllIIIlI = (List<EntityPlayerMP>)Lists.newArrayList();
        for (final EntityTrackerEntry lllllllllllllllIIlIIllIIlllIIIIl : this.trackedEntities) {
            lllllllllllllllIIlIIllIIlllIIIIl.updatePlayerList(this.theWorld.playerEntities);
            if (lllllllllllllllIIlIIllIIlllIIIIl.playerEntitiesUpdated) {
                final Entity lllllllllllllllIIlIIllIIlllIIIII = lllllllllllllllIIlIIllIIlllIIIIl.getTrackedEntity();
                if (!(lllllllllllllllIIlIIllIIlllIIIII instanceof EntityPlayerMP)) {
                    continue;
                }
                lllllllllllllllIIlIIllIIlllIIIlI.add((EntityPlayerMP)lllllllllllllllIIlIIllIIlllIIIII);
            }
        }
        for (int lllllllllllllllIIlIIllIIllIlllll = 0; lllllllllllllllIIlIIllIIllIlllll < lllllllllllllllIIlIIllIIlllIIIlI.size(); ++lllllllllllllllIIlIIllIIllIlllll) {
            final EntityPlayerMP lllllllllllllllIIlIIllIIllIllllI = lllllllllllllllIIlIIllIIlllIIIlI.get(lllllllllllllllIIlIIllIIllIlllll);
            for (final EntityTrackerEntry lllllllllllllllIIlIIllIIllIlllIl : this.trackedEntities) {
                if (lllllllllllllllIIlIIllIIllIlllIl.getTrackedEntity() != lllllllllllllllIIlIIllIIllIllllI) {
                    lllllllllllllllIIlIIllIIllIlllIl.updatePlayerEntity(lllllllllllllllIIlIIllIIllIllllI);
                }
            }
        }
    }
    
    public void setViewDistance(final int lllllllllllllllIIlIIllIIlIIIIlll) {
        this.maxTrackingDistanceThreshold = (lllllllllllllllIIlIIllIIlIIIIlll - 1) * 16;
        for (final EntityTrackerEntry lllllllllllllllIIlIIllIIlIIIlIIl : this.trackedEntities) {
            lllllllllllllllIIlIIllIIlIIIlIIl.setMaxRange(this.maxTrackingDistanceThreshold);
        }
    }
}
