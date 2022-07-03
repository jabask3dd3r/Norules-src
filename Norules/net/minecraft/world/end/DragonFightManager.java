package net.minecraft.world.end;

import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.boss.dragon.phase.*;
import net.minecraft.advancements.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import com.google.common.base.*;

public class DragonFightManager
{
    private /* synthetic */ int ticksSinceCrystalsScanned;
    private /* synthetic */ List<EntityEnderCrystal> crystals;
    private /* synthetic */ DragonSpawnManager respawnState;
    private /* synthetic */ BlockPos exitPortalLocation;
    private /* synthetic */ int aliveCrystals;
    private final /* synthetic */ List<Integer> gateways;
    private final /* synthetic */ WorldServer world;
    private /* synthetic */ int ticksSinceLastPlayerScan;
    private final /* synthetic */ BossInfoServer bossInfo;
    private /* synthetic */ int respawnStateTicks;
    private /* synthetic */ boolean dragonKilled;
    private /* synthetic */ boolean scanForLegacyFight;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Predicate<EntityPlayerMP> VALID_PLAYER;
    private /* synthetic */ UUID dragonUniqueId;
    private /* synthetic */ boolean previouslyKilled;
    private /* synthetic */ int ticksSinceDragonSeen;
    private final /* synthetic */ BlockPattern portalPattern;
    
    public void dragonUpdate(final EntityDragon llllllllllllllIlIlIIIIIlIIlIllIl) {
        if (llllllllllllllIlIlIIIIIlIIlIllIl.getUniqueID().equals(this.dragonUniqueId)) {
            this.bossInfo.setPercent(llllllllllllllIlIlIIIIIlIIlIllIl.getHealth() / llllllllllllllIlIlIIIIIlIIlIllIl.getMaxHealth());
            this.ticksSinceDragonSeen = 0;
            if (llllllllllllllIlIlIIIIIlIIlIllIl.hasCustomName()) {
                this.bossInfo.setName(llllllllllllllIlIlIIIIIlIIlIllIl.getDisplayName());
            }
        }
    }
    
    private void generatePortal(final boolean llllllllllllllIlIlIIIIIlIIlllIlI) {
        final WorldGenEndPodium llllllllllllllIlIlIIIIIlIIllllII = new WorldGenEndPodium(llllllllllllllIlIlIIIIIlIIlllIlI);
        if (this.exitPortalLocation == null) {
            this.exitPortalLocation = this.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION).down();
            while (this.world.getBlockState(this.exitPortalLocation).getBlock() == Blocks.BEDROCK && this.exitPortalLocation.getY() > this.world.getSeaLevel()) {
                this.exitPortalLocation = this.exitPortalLocation.down();
            }
        }
        llllllllllllllIlIlIIIIIlIIllllII.generate(this.world, new Random(), this.exitPortalLocation);
    }
    
    public void onCrystalDestroyed(final EntityEnderCrystal llllllllllllllIlIlIIIIIlIIlIIIII, final DamageSource llllllllllllllIlIlIIIIIlIIlIIIll) {
        if (this.respawnState != null && this.crystals.contains(llllllllllllllIlIlIIIIIlIIlIIIII)) {
            DragonFightManager.LOGGER.debug("Aborting respawn sequence");
            this.respawnState = null;
            this.respawnStateTicks = 0;
            this.resetSpikeCrystals();
            this.generatePortal(true);
        }
        else {
            this.findAliveCrystals();
            final Entity llllllllllllllIlIlIIIIIlIIlIIIlI = this.world.getEntityFromUuid(this.dragonUniqueId);
            if (llllllllllllllIlIlIIIIIlIIlIIIlI instanceof EntityDragon) {
                ((EntityDragon)llllllllllllllIlIlIIIIIlIIlIIIlI).onCrystalDestroyed(llllllllllllllIlIlIIIIIlIIlIIIII, new BlockPos(llllllllllllllIlIlIIIIIlIIlIIIII), llllllllllllllIlIlIIIIIlIIlIIIll);
            }
        }
    }
    
    public void resetSpikeCrystals() {
        final String llllllllllllllIlIlIIIIIIllIIlIIl;
        final boolean llllllllllllllIlIlIIIIIIllIIlIlI = ((WorldGenSpikes.EndSpike[])(Object)(llllllllllllllIlIlIIIIIIllIIlIIl = (String)(Object)BiomeEndDecorator.getSpikesForWorld(this.world))).length != 0;
        for (Exception llllllllllllllIlIlIIIIIIllIIlIll = (Exception)0; llllllllllllllIlIlIIIIIIllIIlIll < llllllllllllllIlIlIIIIIIllIIlIlI; ++llllllllllllllIlIlIIIIIIllIIlIll) {
            final WorldGenSpikes.EndSpike llllllllllllllIlIlIIIIIIllIIllll = llllllllllllllIlIlIIIIIIllIIlIIl[llllllllllllllIlIlIIIIIIllIIlIll];
            for (final EntityEnderCrystal llllllllllllllIlIlIIIIIIllIIlllI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityEnderCrystal.class, llllllllllllllIlIlIIIIIIllIIllll.getTopBoundingBox())) {
                llllllllllllllIlIlIIIIIIllIIlllI.setEntityInvulnerable(false);
                llllllllllllllIlIlIIIIIIllIIlllI.setBeamTarget(null);
            }
        }
    }
    
    private void updateplayers() {
        final Set<EntityPlayerMP> llllllllllllllIlIlIIIIIllIIIIIlI = (Set<EntityPlayerMP>)Sets.newHashSet();
        for (final EntityPlayerMP llllllllllllllIlIlIIIIIllIIIIIII : this.world.getPlayers((Class<? extends Entity>)EntityPlayerMP.class, (com.google.common.base.Predicate<? super Entity>)DragonFightManager.VALID_PLAYER)) {
            this.bossInfo.addPlayer(llllllllllllllIlIlIIIIIllIIIIIII);
            llllllllllllllIlIlIIIIIllIIIIIlI.add(llllllllllllllIlIlIIIIIllIIIIIII);
        }
        final Set<EntityPlayerMP> llllllllllllllIlIlIIIIIlIllllllI = (Set<EntityPlayerMP>)Sets.newHashSet((Iterable)this.bossInfo.getPlayers());
        llllllllllllllIlIlIIIIIlIllllllI.removeAll(llllllllllllllIlIlIIIIIllIIIIIlI);
        for (final EntityPlayerMP llllllllllllllIlIlIIIIIlIlllllII : llllllllllllllIlIlIIIIIlIllllllI) {
            this.bossInfo.removePlayer(llllllllllllllIlIlIIIIIlIlllllII);
        }
    }
    
    private void respawnDragon(final List<EntityEnderCrystal> llllllllllllllIlIlIIIIIIllllllIl) {
        if (this.dragonKilled && this.respawnState == null) {
            for (BlockPattern.PatternHelper llllllllllllllIlIlIIIIIIllllllII = this.findExitPortal(); llllllllllllllIlIlIIIIIIllllllII != null; llllllllllllllIlIlIIIIIIllllllII = this.findExitPortal()) {
                for (int llllllllllllllIlIlIIIIIIlllllIll = 0; llllllllllllllIlIlIIIIIIlllllIll < this.portalPattern.getPalmLength(); ++llllllllllllllIlIlIIIIIIlllllIll) {
                    for (int llllllllllllllIlIlIIIIIIlllllIlI = 0; llllllllllllllIlIlIIIIIIlllllIlI < this.portalPattern.getThumbLength(); ++llllllllllllllIlIlIIIIIIlllllIlI) {
                        for (int llllllllllllllIlIlIIIIIIlllllIIl = 0; llllllllllllllIlIlIIIIIIlllllIIl < this.portalPattern.getFingerLength(); ++llllllllllllllIlIlIIIIIIlllllIIl) {
                            final BlockWorldState llllllllllllllIlIlIIIIIIlllllIII = llllllllllllllIlIlIIIIIIllllllII.translateOffset(llllllllllllllIlIlIIIIIIlllllIll, llllllllllllllIlIlIIIIIIlllllIlI, llllllllllllllIlIlIIIIIIlllllIIl);
                            if (llllllllllllllIlIlIIIIIIlllllIII.getBlockState().getBlock() == Blocks.BEDROCK || llllllllllllllIlIlIIIIIIlllllIII.getBlockState().getBlock() == Blocks.END_PORTAL) {
                                this.world.setBlockState(llllllllllllllIlIlIIIIIIlllllIII.getPos(), Blocks.END_STONE.getDefaultState());
                            }
                        }
                    }
                }
            }
            this.respawnState = DragonSpawnManager.START;
            this.respawnStateTicks = 0;
            this.generatePortal(false);
            this.crystals = llllllllllllllIlIlIIIIIIllllllIl;
        }
    }
    
    private EntityDragon func_192445_m() {
        this.world.getChunkFromBlockCoords(new BlockPos(0, 128, 0));
        final EntityDragon llllllllllllllIlIlIIIIIlIIllIlIl = new EntityDragon(this.world);
        llllllllllllllIlIlIIIIIlIIllIlIl.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
        llllllllllllllIlIlIIIIIlIIllIlIl.setLocationAndAngles(0.0, 128.0, 0.0, this.world.rand.nextFloat() * 360.0f, 0.0f);
        this.world.spawnEntityInWorld(llllllllllllllIlIlIIIIIlIIllIlIl);
        this.dragonUniqueId = llllllllllllllIlIlIIIIIlIIllIlIl.getUniqueID();
        return llllllllllllllIlIlIIIIIlIIllIlIl;
    }
    
    protected void setRespawnState(final DragonSpawnManager llllllllllllllIlIlIIIIIlllIIlllI) {
        if (this.respawnState == null) {
            throw new IllegalStateException("Dragon respawn isn't in progress, can't skip ahead in the animation.");
        }
        this.respawnStateTicks = 0;
        if (llllllllllllllIlIlIIIIIlllIIlllI == DragonSpawnManager.END) {
            this.respawnState = null;
            this.dragonKilled = false;
            final EntityDragon llllllllllllllIlIlIIIIIlllIlIIIl = this.func_192445_m();
            for (final EntityPlayerMP llllllllllllllIlIlIIIIIlllIlIIII : this.bossInfo.getPlayers()) {
                CriteriaTriggers.field_192133_m.func_192229_a(llllllllllllllIlIlIIIIIlllIlIIII, llllllllllllllIlIlIIIIIlllIlIIIl);
            }
        }
        else {
            this.respawnState = llllllllllllllIlIlIIIIIlllIIlllI;
        }
    }
    
    public void processDragonDeath(final EntityDragon llllllllllllllIlIlIIIIIlIlIlIlII) {
        if (llllllllllllllIlIlIIIIIlIlIlIlII.getUniqueID().equals(this.dragonUniqueId)) {
            this.bossInfo.setPercent(0.0f);
            this.bossInfo.setVisible(false);
            this.generatePortal(true);
            this.spawnNewGateway();
            if (!this.previouslyKilled) {
                this.world.setBlockState(this.world.getHeight(WorldGenEndPodium.END_PODIUM_LOCATION), Blocks.DRAGON_EGG.getDefaultState());
            }
            this.previouslyKilled = true;
            this.dragonKilled = true;
        }
    }
    
    private boolean hasDragonBeenKilled() {
        for (int llllllllllllllIlIlIIIIIlllIIIIll = -8; llllllllllllllIlIlIIIIIlllIIIIll <= 8; ++llllllllllllllIlIlIIIIIlllIIIIll) {
            for (int llllllllllllllIlIlIIIIIlllIIIIlI = -8; llllllllllllllIlIlIIIIIlllIIIIlI <= 8; ++llllllllllllllIlIlIIIIIlllIIIIlI) {
                final Chunk llllllllllllllIlIlIIIIIlllIIIIIl = this.world.getChunkFromChunkCoords(llllllllllllllIlIlIIIIIlllIIIIll, llllllllllllllIlIlIIIIIlllIIIIlI);
                for (final TileEntity llllllllllllllIlIlIIIIIlllIIIIII : llllllllllllllIlIlIIIIIlllIIIIIl.getTileEntityMap().values()) {
                    if (llllllllllllllIlIlIIIIIlllIIIIII instanceof TileEntityEndPortal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean hasPreviouslyKilledDragon() {
        return this.previouslyKilled;
    }
    
    public void respawnDragon() {
        if (this.dragonKilled && this.respawnState == null) {
            BlockPos llllllllllllllIlIlIIIIIlIIIlIIlI = this.exitPortalLocation;
            if (llllllllllllllIlIlIIIIIlIIIlIIlI == null) {
                DragonFightManager.LOGGER.debug("Tried to respawn, but need to find the portal first.");
                final BlockPattern.PatternHelper llllllllllllllIlIlIIIIIlIIIlIIIl = this.findExitPortal();
                if (llllllllllllllIlIlIIIIIlIIIlIIIl == null) {
                    DragonFightManager.LOGGER.debug("Couldn't find a portal, so we made one.");
                    this.generatePortal(true);
                }
                else {
                    DragonFightManager.LOGGER.debug("Found the exit portal & temporarily using it.");
                }
                llllllllllllllIlIlIIIIIlIIIlIIlI = this.exitPortalLocation;
            }
            final List<EntityEnderCrystal> llllllllllllllIlIlIIIIIlIIIlIIII = (List<EntityEnderCrystal>)Lists.newArrayList();
            final BlockPos llllllllllllllIlIlIIIIIlIIIIllll = llllllllllllllIlIlIIIIIlIIIlIIlI.up(1);
            for (final EnumFacing llllllllllllllIlIlIIIIIlIIIIlllI : EnumFacing.Plane.HORIZONTAL) {
                final List<EntityEnderCrystal> llllllllllllllIlIlIIIIIlIIIIllIl = this.world.getEntitiesWithinAABB((Class<? extends EntityEnderCrystal>)EntityEnderCrystal.class, new AxisAlignedBB(llllllllllllllIlIlIIIIIlIIIIllll.offset(llllllllllllllIlIlIIIIIlIIIIlllI, 2)));
                if (llllllllllllllIlIlIIIIIlIIIIllIl.isEmpty()) {
                    return;
                }
                llllllllllllllIlIlIIIIIlIIIlIIII.addAll(llllllllllllllIlIlIIIIIlIIIIllIl);
            }
            DragonFightManager.LOGGER.debug("Found all crystals, respawning dragon.");
            this.respawnDragon(llllllllllllllIlIlIIIIIlIIIlIIII);
        }
    }
    
    public int getNumAliveCrystals() {
        return this.aliveCrystals;
    }
    
    public void tick() {
        this.bossInfo.setVisible(!this.dragonKilled);
        if (++this.ticksSinceLastPlayerScan >= 20) {
            this.updateplayers();
            this.ticksSinceLastPlayerScan = 0;
        }
        if (!this.bossInfo.getPlayers().isEmpty()) {
            if (this.scanForLegacyFight) {
                DragonFightManager.LOGGER.info("Scanning for legacy world dragon fight...");
                this.loadChunks();
                this.scanForLegacyFight = false;
                final boolean llllllllllllllIlIlIIIIIllllIIIII = this.hasDragonBeenKilled();
                if (llllllllllllllIlIlIIIIIllllIIIII) {
                    DragonFightManager.LOGGER.info("Found that the dragon has been killed in this world already.");
                    this.previouslyKilled = true;
                }
                else {
                    DragonFightManager.LOGGER.info("Found that the dragon has not yet been killed in this world.");
                    this.previouslyKilled = false;
                    this.generatePortal(false);
                }
                final List<EntityDragon> llllllllllllllIlIlIIIIIlllIlllll = this.world.getEntities((Class<? extends EntityDragon>)EntityDragon.class, (com.google.common.base.Predicate<? super EntityDragon>)EntitySelectors.IS_ALIVE);
                if (llllllllllllllIlIlIIIIIlllIlllll.isEmpty()) {
                    this.dragonKilled = true;
                }
                else {
                    final EntityDragon llllllllllllllIlIlIIIIIlllIllllI = llllllllllllllIlIlIIIIIlllIlllll.get(0);
                    this.dragonUniqueId = llllllllllllllIlIlIIIIIlllIllllI.getUniqueID();
                    DragonFightManager.LOGGER.info("Found that there's a dragon still alive ({})", (Object)llllllllllllllIlIlIIIIIlllIllllI);
                    this.dragonKilled = false;
                    if (!llllllllllllllIlIlIIIIIllllIIIII) {
                        DragonFightManager.LOGGER.info("But we didn't have a portal, let's remove it.");
                        llllllllllllllIlIlIIIIIlllIllllI.setDead();
                        this.dragonUniqueId = null;
                    }
                }
                if (!this.previouslyKilled && this.dragonKilled) {
                    this.dragonKilled = false;
                }
            }
            if (this.respawnState != null) {
                if (this.crystals == null) {
                    this.respawnState = null;
                    this.respawnDragon();
                }
                this.respawnState.process(this.world, this, this.crystals, this.respawnStateTicks++, this.exitPortalLocation);
            }
            if (!this.dragonKilled) {
                if (this.dragonUniqueId == null || ++this.ticksSinceDragonSeen >= 1200) {
                    this.loadChunks();
                    final List<EntityDragon> llllllllllllllIlIlIIIIIlllIlllIl = this.world.getEntities((Class<? extends EntityDragon>)EntityDragon.class, (com.google.common.base.Predicate<? super EntityDragon>)EntitySelectors.IS_ALIVE);
                    if (llllllllllllllIlIlIIIIIlllIlllIl.isEmpty()) {
                        DragonFightManager.LOGGER.debug("Haven't seen the dragon, respawning it");
                        this.func_192445_m();
                    }
                    else {
                        DragonFightManager.LOGGER.debug("Haven't seen our dragon, but found another one to use.");
                        this.dragonUniqueId = llllllllllllllIlIlIIIIIlllIlllIl.get(0).getUniqueID();
                    }
                    this.ticksSinceDragonSeen = 0;
                }
                if (++this.ticksSinceCrystalsScanned >= 100) {
                    this.findAliveCrystals();
                    this.ticksSinceCrystalsScanned = 0;
                }
            }
        }
    }
    
    private void generateGateway(final BlockPos llllllllllllllIlIlIIIIIlIlIIIIlI) {
        this.world.playEvent(3000, llllllllllllllIlIlIIIIIlIlIIIIlI, 0);
        new WorldGenEndGateway().generate(this.world, new Random(), llllllllllllllIlIlIIIIIlIlIIIIlI);
    }
    
    public NBTTagCompound getCompound() {
        final NBTTagCompound llllllllllllllIlIlIIIIIllllIlllI = new NBTTagCompound();
        if (this.dragonUniqueId != null) {
            llllllllllllllIlIlIIIIIllllIlllI.setUniqueId("DragonUUID", this.dragonUniqueId);
        }
        llllllllllllllIlIlIIIIIllllIlllI.setBoolean("DragonKilled", this.dragonKilled);
        llllllllllllllIlIlIIIIIllllIlllI.setBoolean("PreviouslyKilled", this.previouslyKilled);
        if (this.exitPortalLocation != null) {
            llllllllllllllIlIlIIIIIllllIlllI.setTag("ExitPortalLocation", NBTUtil.createPosTag(this.exitPortalLocation));
        }
        final NBTTagList llllllllllllllIlIlIIIIIllllIllIl = new NBTTagList();
        for (final int llllllllllllllIlIlIIIIIllllIlIll : this.gateways) {
            llllllllllllllIlIlIIIIIllllIllIl.appendTag(new NBTTagInt(llllllllllllllIlIlIIIIIllllIlIll));
        }
        llllllllllllllIlIlIIIIIllllIlllI.setTag("Gateways", llllllllllllllIlIlIIIIIllllIllIl);
        return llllllllllllllIlIlIIIIIllllIlllI;
    }
    
    private void spawnNewGateway() {
        if (!this.gateways.isEmpty()) {
            final int llllllllllllllIlIlIIIIIlIlIIlllI = this.gateways.remove(this.gateways.size() - 1);
            final int llllllllllllllIlIlIIIIIlIlIIllIl = (int)(96.0 * Math.cos(2.0 * (-3.141592653589793 + 0.15707963267948966 * llllllllllllllIlIlIIIIIlIlIIlllI)));
            final int llllllllllllllIlIlIIIIIlIlIIllII = (int)(96.0 * Math.sin(2.0 * (-3.141592653589793 + 0.15707963267948966 * llllllllllllllIlIlIIIIIlIlIIlllI)));
            this.generateGateway(new BlockPos(llllllllllllllIlIlIIIIIlIlIIllIl, 75, llllllllllllllIlIlIIIIIlIlIIllII));
        }
    }
    
    public DragonFightManager(final WorldServer llllllllllllllIlIlIIIIIllllllllI, final NBTTagCompound llllllllllllllIlIlIIIIIlllllllIl) {
        this.bossInfo = (BossInfoServer)new BossInfoServer(new TextComponentTranslation("entity.EnderDragon.name", new Object[0]), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS).setPlayEndBossMusic(true).setCreateFog(true);
        this.gateways = (List<Integer>)Lists.newArrayList();
        this.scanForLegacyFight = true;
        this.world = llllllllllllllIlIlIIIIIllllllllI;
        if (llllllllllllllIlIlIIIIIlllllllIl.hasKey("DragonKilled", 99)) {
            if (llllllllllllllIlIlIIIIIlllllllIl.hasUniqueId("DragonUUID")) {
                this.dragonUniqueId = llllllllllllllIlIlIIIIIlllllllIl.getUniqueId("DragonUUID");
            }
            this.dragonKilled = llllllllllllllIlIlIIIIIlllllllIl.getBoolean("DragonKilled");
            this.previouslyKilled = llllllllllllllIlIlIIIIIlllllllIl.getBoolean("PreviouslyKilled");
            if (llllllllllllllIlIlIIIIIlllllllIl.getBoolean("IsRespawning")) {
                this.respawnState = DragonSpawnManager.START;
            }
            if (llllllllllllllIlIlIIIIIlllllllIl.hasKey("ExitPortalLocation", 10)) {
                this.exitPortalLocation = NBTUtil.getPosFromTag(llllllllllllllIlIlIIIIIlllllllIl.getCompoundTag("ExitPortalLocation"));
            }
        }
        else {
            this.dragonKilled = true;
            this.previouslyKilled = true;
        }
        if (llllllllllllllIlIlIIIIIlllllllIl.hasKey("Gateways", 9)) {
            final NBTTagList llllllllllllllIlIlIIIIlIIIIIIIIl = llllllllllllllIlIlIIIIIlllllllIl.getTagList("Gateways", 3);
            for (int llllllllllllllIlIlIIIIlIIIIIIIII = 0; llllllllllllllIlIlIIIIlIIIIIIIII < llllllllllllllIlIlIIIIlIIIIIIIIl.tagCount(); ++llllllllllllllIlIlIIIIlIIIIIIIII) {
                this.gateways.add(llllllllllllllIlIlIIIIlIIIIIIIIl.getIntAt(llllllllllllllIlIlIIIIlIIIIIIIII));
            }
        }
        else {
            this.gateways.addAll((Collection<? extends Integer>)ContiguousSet.create(Range.closedOpen((Comparable)0, (Comparable)20), DiscreteDomain.integers()));
            Collections.shuffle(this.gateways, new Random(llllllllllllllIlIlIIIIIllllllllI.getSeed()));
        }
        this.portalPattern = FactoryBlockPattern.start().aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("  ###  ", " #   # ", "#     #", "#  #  #", "#     #", " #   # ", "  ###  ").aisle("       ", "  ###  ", " ##### ", " ##### ", " ##### ", "  ###  ", "       ").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.BEDROCK))).build();
    }
    
    @Nullable
    private BlockPattern.PatternHelper findExitPortal() {
        for (int llllllllllllllIlIlIIIIIllIllIIII = -8; llllllllllllllIlIlIIIIIllIllIIII <= 8; ++llllllllllllllIlIlIIIIIllIllIIII) {
            for (int llllllllllllllIlIlIIIIIllIlIllll = -8; llllllllllllllIlIlIIIIIllIlIllll <= 8; ++llllllllllllllIlIlIIIIIllIlIllll) {
                final Chunk llllllllllllllIlIlIIIIIllIlIlllI = this.world.getChunkFromChunkCoords(llllllllllllllIlIlIIIIIllIllIIII, llllllllllllllIlIlIIIIIllIlIllll);
                for (final TileEntity llllllllllllllIlIlIIIIIllIlIllIl : llllllllllllllIlIlIIIIIllIlIlllI.getTileEntityMap().values()) {
                    if (llllllllllllllIlIlIIIIIllIlIllIl instanceof TileEntityEndPortal) {
                        final BlockPattern.PatternHelper llllllllllllllIlIlIIIIIllIlIllII = this.portalPattern.match(this.world, llllllllllllllIlIlIIIIIllIlIllIl.getPos());
                        if (llllllllllllllIlIlIIIIIllIlIllII != null) {
                            final BlockPos llllllllllllllIlIlIIIIIllIlIlIll = llllllllllllllIlIlIIIIIllIlIllII.translateOffset(3, 3, 3).getPos();
                            if (this.exitPortalLocation == null && llllllllllllllIlIlIIIIIllIlIlIll.getX() == 0 && llllllllllllllIlIlIIIIIllIlIlIll.getZ() == 0) {
                                this.exitPortalLocation = llllllllllllllIlIlIIIIIllIlIlIll;
                            }
                            return llllllllllllllIlIlIIIIIllIlIllII;
                        }
                        continue;
                    }
                }
            }
        }
        int llllllllllllllIlIlIIIIIllIlIlIIl;
        for (int llllllllllllllIlIlIIIIIllIlIlIlI = llllllllllllllIlIlIIIIIllIlIlIIl = this.world.getHeight(WorldGenEndPodium.END_PODIUM_LOCATION).getY(); llllllllllllllIlIlIIIIIllIlIlIIl >= 0; --llllllllllllllIlIlIIIIIllIlIlIIl) {
            final BlockPattern.PatternHelper llllllllllllllIlIlIIIIIllIlIlIII = this.portalPattern.match(this.world, new BlockPos(WorldGenEndPodium.END_PODIUM_LOCATION.getX(), llllllllllllllIlIlIIIIIllIlIlIIl, WorldGenEndPodium.END_PODIUM_LOCATION.getZ()));
            if (llllllllllllllIlIlIIIIIllIlIlIII != null) {
                if (this.exitPortalLocation == null) {
                    this.exitPortalLocation = llllllllllllllIlIlIIIIIllIlIlIII.translateOffset(3, 3, 3).getPos();
                }
                return llllllllllllllIlIlIIIIIllIlIlIII;
            }
        }
        return null;
    }
    
    private void findAliveCrystals() {
        this.ticksSinceCrystalsScanned = 0;
        this.aliveCrystals = 0;
        final short llllllllllllllIlIlIIIIIlIlIllIlI;
        final int llllllllllllllIlIlIIIIIlIlIllIll = ((WorldGenSpikes.EndSpike[])(Object)(llllllllllllllIlIlIIIIIlIlIllIlI = (short)(Object)BiomeEndDecorator.getSpikesForWorld(this.world))).length;
        for (boolean llllllllllllllIlIlIIIIIlIlIlllII = false; (llllllllllllllIlIlIIIIIlIlIlllII ? 1 : 0) < llllllllllllllIlIlIIIIIlIlIllIll; ++llllllllllllllIlIlIIIIIlIlIlllII) {
            final WorldGenSpikes.EndSpike llllllllllllllIlIlIIIIIlIlIlllll = llllllllllllllIlIlIIIIIlIlIllIlI[llllllllllllllIlIlIIIIIlIlIlllII];
            this.aliveCrystals += this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityEnderCrystal.class, llllllllllllllIlIlIIIIIlIlIlllll.getTopBoundingBox()).size();
        }
        DragonFightManager.LOGGER.debug("Found {} end crystals still alive", (Object)this.aliveCrystals);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        VALID_PLAYER = Predicates.and((Predicate)EntitySelectors.IS_ALIVE, (Predicate)EntitySelectors.withinRange(0.0, 128.0, 0.0, 192.0));
    }
    
    private void loadChunks() {
        for (int llllllllllllllIlIlIIIIIllIIllIll = -8; llllllllllllllIlIlIIIIIllIIllIll <= 8; ++llllllllllllllIlIlIIIIIllIIllIll) {
            for (int llllllllllllllIlIlIIIIIllIIllIlI = -8; llllllllllllllIlIlIIIIIllIIllIlI <= 8; ++llllllllllllllIlIlIIIIIllIIllIlI) {
                this.world.getChunkFromChunkCoords(llllllllllllllIlIlIIIIIllIIllIll, llllllllllllllIlIlIIIIIllIIllIlI);
            }
        }
    }
}
