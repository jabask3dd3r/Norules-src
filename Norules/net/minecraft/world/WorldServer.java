package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.server.management.*;
import net.minecraft.network.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.block.material.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.chunk.*;
import net.minecraft.village.*;
import net.minecraft.scoreboard.*;
import java.io.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.effect.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import org.apache.logging.log4j.*;
import net.minecraft.crash.*;
import java.util.stream.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.storage.*;
import net.minecraft.profiler.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import com.google.common.util.concurrent.*;
import net.minecraft.network.play.server.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.util.math.*;
import java.util.*;

public class WorldServer extends World implements IThreadListener
{
    private final /* synthetic */ Map<UUID, Entity> entitiesByUuid;
    private final /* synthetic */ TreeSet<NextTickListEntry> pendingTickListEntriesTreeSet;
    private final /* synthetic */ Teleporter worldTeleporter;
    private final /* synthetic */ EntityTracker theEntityTracker;
    private final /* synthetic */ Set<NextTickListEntry> pendingTickListEntriesHashSet;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int updateEntityTick;
    private final /* synthetic */ List<NextTickListEntry> pendingTickListEntriesThisTick;
    private /* synthetic */ int blockEventCacheIndex;
    private final /* synthetic */ MinecraftServer mcServer;
    protected final /* synthetic */ VillageSiege villageSiege;
    private /* synthetic */ boolean allPlayersSleeping;
    private final /* synthetic */ ServerBlockEventList[] blockEventQueue;
    private final /* synthetic */ PlayerChunkMap thePlayerManager;
    private final /* synthetic */ WorldEntitySpawner entitySpawner;
    
    @Override
    public boolean addWeatherEffect(final Entity lllllllllllllIlIIlIllIlIIllIlIIl) {
        if (super.addWeatherEffect(lllllllllllllIlIIlIllIlIIllIlIIl)) {
            this.mcServer.getPlayerList().sendToAllNearExcept(null, lllllllllllllIlIIlIllIlIIllIlIIl.posX, lllllllllllllIlIIlIllIlIIllIlIIl.posY, lllllllllllllIlIIlIllIlIIllIlIIl.posZ, 512.0, this.provider.getDimensionType().getId(), new SPacketSpawnGlobalEntity(lllllllllllllIlIIlIllIlIIllIlIIl));
            return true;
        }
        return false;
    }
    
    @Override
    public void updateEntityWithOptionalForce(final Entity lllllllllllllIlIIlIllIllIIlIllIl, final boolean lllllllllllllIlIIlIllIllIIlIllll) {
        if (!this.canSpawnAnimals() && (lllllllllllllIlIIlIllIllIIlIllIl instanceof EntityAnimal || lllllllllllllIlIIlIllIllIIlIllIl instanceof EntityWaterMob)) {
            lllllllllllllIlIIlIllIllIIlIllIl.setDead();
        }
        if (!this.canSpawnNPCs() && lllllllllllllIlIIlIllIllIIlIllIl instanceof INpc) {
            lllllllllllllIlIIlIllIllIIlIllIl.setDead();
        }
        super.updateEntityWithOptionalForce(lllllllllllllIlIIlIllIllIIlIllIl, lllllllllllllIlIIlIllIllIIlIllll);
    }
    
    @Override
    protected IChunkProvider createChunkProvider() {
        final IChunkLoader lllllllllllllIlIIlIllIllIIlIIIlI = this.saveHandler.getChunkLoader(this.provider);
        return new ChunkProviderServer(this, lllllllllllllIlIIlIllIllIIlIIIlI, this.provider.createChunkGenerator());
    }
    
    protected void createBonusChest() {
        final WorldGeneratorBonusChest lllllllllllllIlIIlIllIlIlllIIIII = new WorldGeneratorBonusChest();
        for (int lllllllllllllIlIIlIllIlIllIlllll = 0; lllllllllllllIlIIlIllIlIllIlllll < 10; ++lllllllllllllIlIIlIllIlIllIlllll) {
            final int lllllllllllllIlIIlIllIlIllIllllI = this.worldInfo.getSpawnX() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final int lllllllllllllIlIIlIllIlIllIlllIl = this.worldInfo.getSpawnZ() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final BlockPos lllllllllllllIlIIlIllIlIllIlllII = this.getTopSolidOrLiquidBlock(new BlockPos(lllllllllllllIlIIlIllIlIllIllllI, 0, lllllllllllllIlIIlIllIlIllIlllIl)).up();
            if (lllllllllllllIlIIlIllIlIlllIIIII.generate(this, this.rand, lllllllllllllIlIIlIllIlIllIlllII)) {
                break;
            }
        }
    }
    
    private boolean canAddEntity(final Entity lllllllllllllIlIIlIllIlIlIIlIlIl) {
        if (lllllllllllllIlIIlIllIlIlIIlIlIl.isDead) {
            WorldServer.LOGGER.warn("Tried to add entity {} but it was marked as removed already", (Object)EntityList.func_191301_a(lllllllllllllIlIIlIllIlIlIIlIlIl));
            return false;
        }
        final UUID lllllllllllllIlIIlIllIlIlIIllIII = lllllllllllllIlIIlIllIlIlIIlIlIl.getUniqueID();
        if (this.entitiesByUuid.containsKey(lllllllllllllIlIIlIllIlIlIIllIII)) {
            final Entity lllllllllllllIlIIlIllIlIlIIlIlll = this.entitiesByUuid.get(lllllllllllllIlIIlIllIlIlIIllIII);
            if (this.unloadedEntityList.contains(lllllllllllllIlIIlIllIlIlIIlIlll)) {
                this.unloadedEntityList.remove(lllllllllllllIlIIlIllIlIlIIlIlll);
            }
            else {
                if (!(lllllllllllllIlIIlIllIlIlIIlIlIl instanceof EntityPlayer)) {
                    WorldServer.LOGGER.warn("Keeping entity {} that already exists with UUID {}", (Object)EntityList.func_191301_a(lllllllllllllIlIIlIllIlIlIIlIlll), (Object)lllllllllllllIlIIlIllIlIlIIllIII.toString());
                    return false;
                }
                WorldServer.LOGGER.warn("Force-added player with duplicate UUID {}", (Object)lllllllllllllIlIIlIllIlIlIIllIII.toString());
            }
            this.removeEntityDangerously(lllllllllllllIlIIlIllIlIlIIlIlll);
        }
        return true;
    }
    
    @Override
    protected void onEntityRemoved(final Entity lllllllllllllIlIIlIllIlIIlllIlII) {
        super.onEntityRemoved(lllllllllllllIlIIlIllIlIIlllIlII);
        this.entitiesById.removeObject(lllllllllllllIlIIlIllIlIIlllIlII.getEntityId());
        this.entitiesByUuid.remove(lllllllllllllIlIIlIllIlIIlllIlII.getUniqueID());
        final Entity[] lllllllllllllIlIIlIllIlIIlllIlll = lllllllllllllIlIIlIllIlIIlllIlII.getParts();
        if (lllllllllllllIlIIlIllIlIIlllIlll != null) {
            final byte lllllllllllllIlIIlIllIlIIllIllll;
            final long lllllllllllllIlIIlIllIlIIlllIIII = ((Entity[])(Object)(lllllllllllllIlIIlIllIlIIllIllll = (byte)(Object)lllllllllllllIlIIlIllIlIIlllIlll)).length;
            for (final Entity lllllllllllllIlIIlIllIlIIlllIllI : lllllllllllllIlIIlIllIlIIllIllll) {
                this.entitiesById.removeObject(lllllllllllllIlIIlIllIlIIlllIllI.getEntityId());
            }
        }
    }
    
    public TemplateManager getStructureTemplateManager() {
        return this.saveHandler.getStructureTemplateManager();
    }
    
    @Override
    public ChunkProviderServer getChunkProvider() {
        return (ChunkProviderServer)super.getChunkProvider();
    }
    
    @Override
    public void updateEntities() {
        if (this.playerEntities.isEmpty()) {
            if (this.updateEntityTick++ >= 300) {
                return;
            }
        }
        else {
            this.resetUpdateEntityTick();
        }
        this.provider.onWorldUpdateEntities();
        super.updateEntities();
    }
    
    @Override
    public boolean isBlockTickPending(final BlockPos lllllllllllllIlIIlIllIlllllIllII, final Block lllllllllllllIlIIlIllIlllllIIlll) {
        final NextTickListEntry lllllllllllllIlIIlIllIlllllIlIlI = new NextTickListEntry(lllllllllllllIlIIlIllIlllllIllII, lllllllllllllIlIIlIllIlllllIIlll);
        return this.pendingTickListEntriesThisTick.contains(lllllllllllllIlIIlIllIlllllIlIlI);
    }
    
    @Override
    public void scheduleBlockUpdate(final BlockPos lllllllllllllIlIIlIllIlllIlIllll, final Block lllllllllllllIlIIlIllIlllIlIlllI, final int lllllllllllllIlIIlIllIlllIlIIllI, final int lllllllllllllIlIIlIllIlllIlIllII) {
        final NextTickListEntry lllllllllllllIlIIlIllIlllIlIlIll = new NextTickListEntry(lllllllllllllIlIIlIllIlllIlIllll, lllllllllllllIlIIlIllIlllIlIlllI);
        lllllllllllllIlIIlIllIlllIlIlIll.setPriority(lllllllllllllIlIIlIllIlllIlIllII);
        final Material lllllllllllllIlIIlIllIlllIlIlIlI = lllllllllllllIlIIlIllIlllIlIlllI.getDefaultState().getMaterial();
        if (lllllllllllllIlIIlIllIlllIlIlIlI != Material.AIR) {
            lllllllllllllIlIIlIllIlllIlIlIll.setScheduledTime(lllllllllllllIlIIlIllIlllIlIIllI + this.worldInfo.getWorldTotalTime());
        }
        if (!this.pendingTickListEntriesHashSet.contains(lllllllllllllIlIIlIllIlllIlIlIll)) {
            this.pendingTickListEntriesHashSet.add(lllllllllllllIlIIlIllIlllIlIlIll);
            this.pendingTickListEntriesTreeSet.add(lllllllllllllIlIIlIllIlllIlIlIll);
        }
    }
    
    @Nullable
    public BlockPos getSpawnCoordinate() {
        return this.provider.getSpawnCoordinate();
    }
    
    private boolean fireBlockEvent(final BlockEventData lllllllllllllIlIIlIllIlIIIIlIIll) {
        final IBlockState lllllllllllllIlIIlIllIlIIIIlIlIl = this.getBlockState(lllllllllllllIlIIlIllIlIIIIlIIll.getPosition());
        return lllllllllllllIlIIlIllIlIIIIlIlIl.getBlock() == lllllllllllllIlIIlIllIlIIIIlIIll.getBlock() && lllllllllllllIlIIlIllIlIIIIlIlIl.onBlockEventReceived(this, lllllllllllllIlIIlIllIlIIIIlIIll.getPosition(), lllllllllllllIlIIlIllIlIIIIlIIll.getEventID(), lllllllllllllIlIIlIllIlIIIIlIIll.getEventParameter());
    }
    
    private void resetRainAndThunder() {
        this.worldInfo.setRainTime(0);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThunderTime(0);
        this.worldInfo.setThundering(false);
    }
    
    @Override
    public void scheduleUpdate(final BlockPos lllllllllllllIlIIlIllIllllIlIlII, final Block lllllllllllllIlIIlIllIllllIIllll, final int lllllllllllllIlIIlIllIllllIIlllI) {
        this.updateBlockTick(lllllllllllllIlIIlIllIllllIlIlII, lllllllllllllIlIIlIllIllllIIllll, lllllllllllllIlIIlIllIllllIIlllI, 0);
    }
    
    protected void saveLevel() throws MinecraftException {
        this.checkSessionLock();
        final double lllllllllllllIlIIlIllIlIlIllIIII;
        final long lllllllllllllIlIIlIllIlIlIllIIIl = ((WorldServer[])(Object)(lllllllllllllIlIIlIllIlIlIllIIII = (double)(Object)this.mcServer.worldServers)).length;
        for (float lllllllllllllIlIIlIllIlIlIllIIlI = 0; lllllllllllllIlIIlIllIlIlIllIIlI < lllllllllllllIlIIlIllIlIlIllIIIl; ++lllllllllllllIlIIlIllIlIlIllIIlI) {
            final WorldServer lllllllllllllIlIIlIllIlIlIllIlIl = lllllllllllllIlIIlIllIlIlIllIIII[lllllllllllllIlIIlIllIlIlIllIIlI];
            if (lllllllllllllIlIIlIllIlIlIllIlIl instanceof WorldServerMulti) {
                ((WorldServerMulti)lllllllllllllIlIIlIllIlIlIllIlIl).saveAdditionalData();
            }
        }
        this.worldInfo.setBorderSize(this.getWorldBorder().getDiameter());
        this.worldInfo.getBorderCenterX(this.getWorldBorder().getCenterX());
        this.worldInfo.getBorderCenterZ(this.getWorldBorder().getCenterZ());
        this.worldInfo.setBorderSafeZone(this.getWorldBorder().getDamageBuffer());
        this.worldInfo.setBorderDamagePerBlock(this.getWorldBorder().getDamageAmount());
        this.worldInfo.setBorderWarningDistance(this.getWorldBorder().getWarningDistance());
        this.worldInfo.setBorderWarningTime(this.getWorldBorder().getWarningTime());
        this.worldInfo.setBorderLerpTarget(this.getWorldBorder().getTargetSize());
        this.worldInfo.setBorderLerpTime(this.getWorldBorder().getTimeUntilTarget());
        this.saveHandler.saveWorldInfoWithPlayer(this.worldInfo, this.mcServer.getPlayerList().getHostPlayerData());
        this.mapStorage.saveAllData();
    }
    
    protected void playerCheckLight() {
        this.theProfiler.startSection("playerCheckLight");
        if (!this.playerEntities.isEmpty()) {
            final int lllllllllllllIlIIlIlllIIIlIIlIIl = this.rand.nextInt(this.playerEntities.size());
            final EntityPlayer lllllllllllllIlIIlIlllIIIlIIlIII = this.playerEntities.get(lllllllllllllIlIIlIlllIIIlIIlIIl);
            final int lllllllllllllIlIIlIlllIIIlIIIlll = MathHelper.floor(lllllllllllllIlIIlIlllIIIlIIlIII.posX) + this.rand.nextInt(11) - 5;
            final int lllllllllllllIlIIlIlllIIIlIIIllI = MathHelper.floor(lllllllllllllIlIIlIlllIIIlIIlIII.posY) + this.rand.nextInt(11) - 5;
            final int lllllllllllllIlIIlIlllIIIlIIIlIl = MathHelper.floor(lllllllllllllIlIIlIlllIIIlIIlIII.posZ) + this.rand.nextInt(11) - 5;
            this.checkLight(new BlockPos(lllllllllllllIlIIlIlllIIIlIIIlll, lllllllllllllIlIIlIlllIIIlIIIllI, lllllllllllllIlIIlIlllIIIlIIIlIl));
        }
        this.theProfiler.endSection();
    }
    
    public PlayerChunkMap getPlayerChunkMap() {
        return this.thePlayerManager;
    }
    
    @Nullable
    @Override
    public BlockPos func_190528_a(final String lllllllllllllIlIIlIllIIlIlIlIlII, final BlockPos lllllllllllllIlIIlIllIIlIlIIllll, final boolean lllllllllllllIlIIlIllIIlIlIlIIlI) {
        return this.getChunkProvider().getStrongholdGen(this, lllllllllllllIlIIlIllIIlIlIlIlII, lllllllllllllIlIIlIllIIlIlIIllll, lllllllllllllIlIIlIllIIlIlIlIIlI);
    }
    
    public boolean canCreatureTypeSpawnHere(final EnumCreatureType lllllllllllllIlIIlIlllIIlIIIlIll, final Biome.SpawnListEntry lllllllllllllIlIIlIlllIIlIIIlIlI, final BlockPos lllllllllllllIlIIlIlllIIlIIIlIIl) {
        final List<Biome.SpawnListEntry> lllllllllllllIlIIlIlllIIlIIIllIl = this.getChunkProvider().getPossibleCreatures(lllllllllllllIlIIlIlllIIlIIIlIll, lllllllllllllIlIIlIlllIIlIIIlIIl);
        return lllllllllllllIlIIlIlllIIlIIIllIl != null && !lllllllllllllIlIIlIlllIIlIIIllIl.isEmpty() && lllllllllllllIlIIlIlllIIlIIIllIl.contains(lllllllllllllIlIIlIlllIIlIIIlIlI);
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return this.mcServer.isCallingFromMinecraftThread();
    }
    
    public void spawnParticle(final EntityPlayerMP lllllllllllllIlIIlIllIIllIIlllII, final EnumParticleTypes lllllllllllllIlIIlIllIIllIIllIll, final boolean lllllllllllllIlIIlIllIIllIIIllII, final double lllllllllllllIlIIlIllIIllIIIlIll, final double lllllllllllllIlIIlIllIIllIIIlIlI, final double lllllllllllllIlIIlIllIIllIIlIlll, final int lllllllllllllIlIIlIllIIllIIlIllI, final double lllllllllllllIlIIlIllIIllIIlIlIl, final double lllllllllllllIlIIlIllIIllIIIIllI, final double lllllllllllllIlIIlIllIIllIIlIIll, final double lllllllllllllIlIIlIllIIllIIIIlII, final int... lllllllllllllIlIIlIllIIllIIIIIll) {
        final Packet<?> lllllllllllllIlIIlIllIIllIIlIIII = new SPacketParticles(lllllllllllllIlIIlIllIIllIIllIll, lllllllllllllIlIIlIllIIllIIIllII, (float)lllllllllllllIlIIlIllIIllIIIlIll, (float)lllllllllllllIlIIlIllIIllIIIlIlI, (float)lllllllllllllIlIIlIllIIllIIlIlll, (float)lllllllllllllIlIIlIllIIllIIlIlIl, (float)lllllllllllllIlIIlIllIIllIIIIllI, (float)lllllllllllllIlIIlIllIIllIIlIIll, (float)lllllllllllllIlIIlIllIIllIIIIlII, lllllllllllllIlIIlIllIIllIIlIllI, lllllllllllllIlIIlIllIIllIIIIIll);
        this.sendPacketWithinDistance(lllllllllllllIlIIlIllIIllIIlllII, lllllllllllllIlIIlIllIIllIIIllII, lllllllllllllIlIIlIllIIllIIIlIll, lllllllllllllIlIIlIllIIllIIIlIlI, lllllllllllllIlIIlIllIIllIIlIlll, lllllllllllllIlIIlIllIIllIIlIIII);
    }
    
    public EntityTracker getEntityTracker() {
        return this.theEntityTracker;
    }
    
    public void saveAllChunks(final boolean lllllllllllllIlIIlIllIlIllIIlIll, @Nullable final IProgressUpdate lllllllllllllIlIIlIllIlIllIIlIlI) throws MinecraftException {
        final ChunkProviderServer lllllllllllllIlIIlIllIlIllIIlIIl = this.getChunkProvider();
        if (lllllllllllllIlIIlIllIlIllIIlIIl.canSave()) {
            if (lllllllllllllIlIIlIllIlIllIIlIlI != null) {
                lllllllllllllIlIIlIllIlIllIIlIlI.displaySavingString("Saving level");
            }
            this.saveLevel();
            if (lllllllllllllIlIIlIllIlIllIIlIlI != null) {
                lllllllllllllIlIIlIllIlIllIIlIlI.displayLoadingString("Saving chunks");
            }
            lllllllllllllIlIIlIllIlIllIIlIIl.saveChunks(lllllllllllllIlIIlIllIlIllIIlIll);
            for (final Chunk lllllllllllllIlIIlIllIlIllIIlIII : Lists.newArrayList((Iterable)lllllllllllllIlIIlIllIlIllIIlIIl.getLoadedChunks())) {
                if (lllllllllllllIlIIlIllIlIllIIlIII != null && !this.thePlayerManager.contains(lllllllllllllIlIIlIllIlIllIIlIII.xPosition, lllllllllllllIlIIlIllIlIllIIlIII.zPosition)) {
                    lllllllllllllIlIIlIllIlIllIIlIIl.unload(lllllllllllllIlIIlIllIlIllIIlIII);
                }
            }
        }
    }
    
    private boolean canSpawnNPCs() {
        return this.mcServer.getCanSpawnNPCs();
    }
    
    @Override
    protected void updateWeather() {
        final boolean lllllllllllllIlIIlIllIlIIIIIlIll = this.isRaining();
        super.updateWeather();
        if (this.prevRainingStrength != this.rainingStrength) {
            this.mcServer.getPlayerList().sendPacketToAllPlayersInDimension(new SPacketChangeGameState(7, this.rainingStrength), this.provider.getDimensionType().getId());
        }
        if (this.prevThunderingStrength != this.thunderingStrength) {
            this.mcServer.getPlayerList().sendPacketToAllPlayersInDimension(new SPacketChangeGameState(8, this.thunderingStrength), this.provider.getDimensionType().getId());
        }
        if (lllllllllllllIlIIlIllIlIIIIIlIll != this.isRaining()) {
            if (lllllllllllllIlIIlIllIlIIIIIlIll) {
                this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(2, 0.0f));
            }
            else {
                this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(1, 0.0f));
            }
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(7, this.rainingStrength));
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(8, this.thunderingStrength));
        }
    }
    
    @Override
    public boolean spawnEntityInWorld(final Entity lllllllllllllIlIIlIllIlIlIlIllII) {
        return this.canAddEntity(lllllllllllllIlIIlIllIlIlIlIllII) && super.spawnEntityInWorld(lllllllllllllIlIIlIllIlIlIlIllII);
    }
    
    public boolean areAllPlayersAsleep() {
        if (this.allPlayersSleeping && !this.isRemote) {
            for (final EntityPlayer lllllllllllllIlIIlIlllIIIllIlIlI : this.playerEntities) {
                if (!lllllllllllllIlIIlIlllIIIllIlIlI.isSpectator() && !lllllllllllllIlIIlIlllIIIllIlIlI.isPlayerFullyAsleep()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isUpdateScheduled(final BlockPos lllllllllllllIlIIlIllIllllIlllII, final Block lllllllllllllIlIIlIllIllllIllIll) {
        final NextTickListEntry lllllllllllllIlIIlIllIllllIllllI = new NextTickListEntry(lllllllllllllIlIIlIllIllllIlllII, lllllllllllllIlIIlIllIllllIllIll);
        return this.pendingTickListEntriesHashSet.contains(lllllllllllllIlIIlIllIllllIllllI);
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllllIlIIlIllIIlllIIlIII, final boolean lllllllllllllIlIIlIllIIllIlllIII, final double lllllllllllllIlIIlIllIIllIllIlll, final double lllllllllllllIlIIlIllIIlllIIIlIl, final double lllllllllllllIlIIlIllIIllIllIlIl, final int lllllllllllllIlIIlIllIIllIllIlII, final double lllllllllllllIlIIlIllIIllIllIIll, final double lllllllllllllIlIIlIllIIlllIIIIIl, final double lllllllllllllIlIIlIllIIllIllIIIl, final double lllllllllllllIlIIlIllIIllIllIIII, final int... lllllllllllllIlIIlIllIIllIlllllI) {
        final SPacketParticles lllllllllllllIlIIlIllIIllIllllIl = new SPacketParticles(lllllllllllllIlIIlIllIIlllIIlIII, lllllllllllllIlIIlIllIIllIlllIII, (float)lllllllllllllIlIIlIllIIllIllIlll, (float)lllllllllllllIlIIlIllIIlllIIIlIl, (float)lllllllllllllIlIIlIllIIllIllIlIl, (float)lllllllllllllIlIIlIllIIllIllIIll, (float)lllllllllllllIlIIlIllIIlllIIIIIl, (float)lllllllllllllIlIIlIllIIllIllIIIl, (float)lllllllllllllIlIIlIllIIllIllIIII, lllllllllllllIlIIlIllIIllIllIlII, lllllllllllllIlIIlIllIIllIlllllI);
        for (int lllllllllllllIlIIlIllIIllIllllII = 0; lllllllllllllIlIIlIllIIllIllllII < this.playerEntities.size(); ++lllllllllllllIlIIlIllIIllIllllII) {
            final EntityPlayerMP lllllllllllllIlIIlIllIIllIlllIll = this.playerEntities.get(lllllllllllllIlIIlIllIIllIllllII);
            this.sendPacketWithinDistance(lllllllllllllIlIIlIllIIllIlllIll, lllllllllllllIlIIlIllIIllIlllIII, lllllllllllllIlIIlIllIIllIllIlll, lllllllllllllIlIIlIllIIlllIIIlIl, lllllllllllllIlIIlIllIIllIllIlIl, lllllllllllllIlIIlIllIIllIllllIl);
        }
    }
    
    @Override
    public World init() {
        this.mapStorage = new MapStorage(this.saveHandler);
        final String lllllllllllllIlIIlIlllIIlIllIIII = VillageCollection.fileNameForProvider(this.provider);
        final VillageCollection lllllllllllllIlIIlIlllIIlIlIllll = (VillageCollection)this.mapStorage.getOrLoadData(VillageCollection.class, lllllllllllllIlIIlIlllIIlIllIIII);
        if (lllllllllllllIlIIlIlllIIlIlIllll == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(lllllllllllllIlIIlIlllIIlIllIIII, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = lllllllllllllIlIIlIlllIIlIlIllll;
            this.villageCollectionObj.setWorldsForAll(this);
        }
        this.worldScoreboard = new ServerScoreboard(this.mcServer);
        ScoreboardSaveData lllllllllllllIlIIlIlllIIlIlIlllI = (ScoreboardSaveData)this.mapStorage.getOrLoadData(ScoreboardSaveData.class, "scoreboard");
        if (lllllllllllllIlIIlIlllIIlIlIlllI == null) {
            lllllllllllllIlIIlIlllIIlIlIlllI = new ScoreboardSaveData();
            this.mapStorage.setData("scoreboard", lllllllllllllIlIIlIlllIIlIlIlllI);
        }
        lllllllllllllIlIIlIlllIIlIlIlllI.setScoreboard(this.worldScoreboard);
        ((ServerScoreboard)this.worldScoreboard).addDirtyRunnable(new WorldSavedDataCallableSave(lllllllllllllIlIIlIlllIIlIlIlllI));
        this.lootTable = new LootTableManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "loot_tables"));
        this.field_191951_C = new AdvancementManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "advancements"));
        this.field_193036_D = new FunctionManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "functions"), this.mcServer);
        this.getWorldBorder().setCenter(this.worldInfo.getBorderCenterX(), this.worldInfo.getBorderCenterZ());
        this.getWorldBorder().setDamageAmount(this.worldInfo.getBorderDamagePerBlock());
        this.getWorldBorder().setDamageBuffer(this.worldInfo.getBorderSafeZone());
        this.getWorldBorder().setWarningDistance(this.worldInfo.getBorderWarningDistance());
        this.getWorldBorder().setWarningTime(this.worldInfo.getBorderWarningTime());
        if (this.worldInfo.getBorderLerpTime() > 0L) {
            this.getWorldBorder().setTransition(this.worldInfo.getBorderSize(), this.worldInfo.getBorderLerpTarget(), this.worldInfo.getBorderLerpTime());
        }
        else {
            this.getWorldBorder().setTransition(this.worldInfo.getBorderSize());
        }
        return this;
    }
    
    @Override
    protected void updateBlocks() {
        this.playerCheckLight();
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            final Iterator<Chunk> lllllllllllllIlIIlIlllIIIIlIlIlI = this.thePlayerManager.getChunkIterator();
            while (lllllllllllllIlIIlIlllIIIIlIlIlI.hasNext()) {
                lllllllllllllIlIIlIlllIIIIlIlIlI.next().onTick(false);
            }
        }
        else {
            final int lllllllllllllIlIIlIlllIIIIlIlIIl = this.getGameRules().getInt("randomTickSpeed");
            final boolean lllllllllllllIlIIlIlllIIIIlIlIII = this.isRaining();
            final boolean lllllllllllllIlIIlIlllIIIIlIIlll = this.isThundering();
            this.theProfiler.startSection("pollingChunks");
            final Iterator<Chunk> lllllllllllllIlIIlIlllIIIIlIIllI = this.thePlayerManager.getChunkIterator();
            while (lllllllllllllIlIIlIlllIIIIlIIllI.hasNext()) {
                this.theProfiler.startSection("getChunk");
                final Chunk lllllllllllllIlIIlIlllIIIIlIIlIl = lllllllllllllIlIIlIlllIIIIlIIllI.next();
                final int lllllllllllllIlIIlIlllIIIIlIIlII = lllllllllllllIlIIlIlllIIIIlIIlIl.xPosition * 16;
                final int lllllllllllllIlIIlIlllIIIIlIIIll = lllllllllllllIlIIlIlllIIIIlIIlIl.zPosition * 16;
                this.theProfiler.endStartSection("checkNextLight");
                lllllllllllllIlIIlIlllIIIIlIIlIl.enqueueRelightChecks();
                this.theProfiler.endStartSection("tickChunk");
                lllllllllllllIlIIlIlllIIIIlIIlIl.onTick(false);
                this.theProfiler.endStartSection("thunder");
                if (lllllllllllllIlIIlIlllIIIIlIlIII && lllllllllllllIlIIlIlllIIIIlIIlll && this.rand.nextInt(100000) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int lllllllllllllIlIIlIlllIIIIlIIIlI = this.updateLCG >> 2;
                    final BlockPos lllllllllllllIlIIlIlllIIIIlIIIIl = this.adjustPosToNearbyEntity(new BlockPos(lllllllllllllIlIIlIlllIIIIlIIlII + (lllllllllllllIlIIlIlllIIIIlIIIlI & 0xF), 0, lllllllllllllIlIIlIlllIIIIlIIIll + (lllllllllllllIlIIlIlllIIIIlIIIlI >> 8 & 0xF)));
                    if (this.isRainingAt(lllllllllllllIlIIlIlllIIIIlIIIIl)) {
                        final DifficultyInstance lllllllllllllIlIIlIlllIIIIlIIIII = this.getDifficultyForLocation(lllllllllllllIlIIlIlllIIIIlIIIIl);
                        if (this.getGameRules().getBoolean("doMobSpawning") && this.rand.nextDouble() < lllllllllllllIlIIlIlllIIIIlIIIII.getAdditionalDifficulty() * 0.01) {
                            final EntitySkeletonHorse lllllllllllllIlIIlIlllIIIIIlllll = new EntitySkeletonHorse(this);
                            lllllllllllllIlIIlIlllIIIIIlllll.func_190691_p(true);
                            lllllllllllllIlIIlIlllIIIIIlllll.setGrowingAge(0);
                            lllllllllllllIlIIlIlllIIIIIlllll.setPosition(lllllllllllllIlIIlIlllIIIIlIIIIl.getX(), lllllllllllllIlIIlIlllIIIIlIIIIl.getY(), lllllllllllllIlIIlIlllIIIIlIIIIl.getZ());
                            this.spawnEntityInWorld(lllllllllllllIlIIlIlllIIIIIlllll);
                            this.addWeatherEffect(new EntityLightningBolt(this, lllllllllllllIlIIlIlllIIIIlIIIIl.getX(), lllllllllllllIlIIlIlllIIIIlIIIIl.getY(), lllllllllllllIlIIlIlllIIIIlIIIIl.getZ(), true));
                        }
                        else {
                            this.addWeatherEffect(new EntityLightningBolt(this, lllllllllllllIlIIlIlllIIIIlIIIIl.getX(), lllllllllllllIlIIlIlllIIIIlIIIIl.getY(), lllllllllllllIlIIlIlllIIIIlIIIIl.getZ(), false));
                        }
                    }
                }
                this.theProfiler.endStartSection("iceandsnow");
                if (this.rand.nextInt(16) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int lllllllllllllIlIIlIlllIIIIIllllI = this.updateLCG >> 2;
                    final BlockPos lllllllllllllIlIIlIlllIIIIIlllIl = this.getPrecipitationHeight(new BlockPos(lllllllllllllIlIIlIlllIIIIlIIlII + (lllllllllllllIlIIlIlllIIIIIllllI & 0xF), 0, lllllllllllllIlIIlIlllIIIIlIIIll + (lllllllllllllIlIIlIlllIIIIIllllI >> 8 & 0xF)));
                    final BlockPos lllllllllllllIlIIlIlllIIIIIlllII = lllllllllllllIlIIlIlllIIIIIlllIl.down();
                    if (this.canBlockFreezeNoWater(lllllllllllllIlIIlIlllIIIIIlllII)) {
                        this.setBlockState(lllllllllllllIlIIlIlllIIIIIlllII, Blocks.ICE.getDefaultState());
                    }
                    if (lllllllllllllIlIIlIlllIIIIlIlIII && this.canSnowAt(lllllllllllllIlIIlIlllIIIIIlllIl, true)) {
                        this.setBlockState(lllllllllllllIlIIlIlllIIIIIlllIl, Blocks.SNOW_LAYER.getDefaultState());
                    }
                    if (lllllllllllllIlIIlIlllIIIIlIlIII && this.getBiome(lllllllllllllIlIIlIlllIIIIIlllII).canRain()) {
                        this.getBlockState(lllllllllllllIlIIlIlllIIIIIlllII).getBlock().fillWithRain(this, lllllllllllllIlIIlIlllIIIIIlllII);
                    }
                }
                this.theProfiler.endStartSection("tickBlocks");
                if (lllllllllllllIlIIlIlllIIIIlIlIIl > 0) {
                    ExtendedBlockStorage[] blockStorageArray;
                    for (int length = (blockStorageArray = lllllllllllllIlIIlIlllIIIIlIIlIl.getBlockStorageArray()).length, i = 0; i < length; ++i) {
                        final ExtendedBlockStorage lllllllllllllIlIIlIlllIIIIIllIll = blockStorageArray[i];
                        if (lllllllllllllIlIIlIlllIIIIIllIll != Chunk.NULL_BLOCK_STORAGE && lllllllllllllIlIIlIlllIIIIIllIll.getNeedsRandomTick()) {
                            for (int lllllllllllllIlIIlIlllIIIIIllIlI = 0; lllllllllllllIlIIlIlllIIIIIllIlI < lllllllllllllIlIIlIlllIIIIlIlIIl; ++lllllllllllllIlIIlIlllIIIIIllIlI) {
                                this.updateLCG = this.updateLCG * 3 + 1013904223;
                                final int lllllllllllllIlIIlIlllIIIIIllIIl = this.updateLCG >> 2;
                                final int lllllllllllllIlIIlIlllIIIIIllIII = lllllllllllllIlIIlIlllIIIIIllIIl & 0xF;
                                final int lllllllllllllIlIIlIlllIIIIIlIlll = lllllllllllllIlIIlIlllIIIIIllIIl >> 8 & 0xF;
                                final int lllllllllllllIlIIlIlllIIIIIlIllI = lllllllllllllIlIIlIlllIIIIIllIIl >> 16 & 0xF;
                                final IBlockState lllllllllllllIlIIlIlllIIIIIlIlIl = lllllllllllllIlIIlIlllIIIIIllIll.get(lllllllllllllIlIIlIlllIIIIIllIII, lllllllllllllIlIIlIlllIIIIIlIllI, lllllllllllllIlIIlIlllIIIIIlIlll);
                                final Block lllllllllllllIlIIlIlllIIIIIlIlII = lllllllllllllIlIIlIlllIIIIIlIlIl.getBlock();
                                this.theProfiler.startSection("randomTick");
                                if (lllllllllllllIlIIlIlllIIIIIlIlII.getTickRandomly()) {
                                    lllllllllllllIlIIlIlllIIIIIlIlII.randomTick(this, new BlockPos(lllllllllllllIlIIlIlllIIIIIllIII + lllllllllllllIlIIlIlllIIIIlIIlII, lllllllllllllIlIIlIlllIIIIIlIllI + lllllllllllllIlIIlIlllIIIIIllIll.getYLocation(), lllllllllllllIlIIlIlllIIIIIlIlll + lllllllllllllIlIIlIlllIIIIlIIIll), lllllllllllllIlIIlIlllIIIIIlIlIl, this.rand);
                                }
                                this.theProfiler.endSection();
                            }
                        }
                    }
                }
                this.theProfiler.endSection();
            }
            this.theProfiler.endSection();
        }
    }
    
    public AdvancementManager func_191952_z() {
        return this.field_191951_C;
    }
    
    @Override
    public void loadEntities(final Collection<Entity> lllllllllllllIlIIlIllIlIlIlIIlII) {
        for (final Entity lllllllllllllIlIIlIllIlIlIlIIIll : Lists.newArrayList((Iterable)lllllllllllllIlIIlIllIlIlIlIIlII)) {
            if (this.canAddEntity(lllllllllllllIlIIlIllIlIlIlIIIll)) {
                this.loadedEntityList.add(lllllllllllllIlIIlIllIlIlIlIIIll);
                this.onEntityAdded(lllllllllllllIlIIlIllIlIlIlIIIll);
            }
        }
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllllIlIIlIllIIllllIllIl, final double lllllllllllllIlIIlIllIIllllIIIII, final double lllllllllllllIlIIlIllIIlllIlllll, final double lllllllllllllIlIIlIllIIlllIllllI, final int lllllllllllllIlIIlIllIIlllIlllIl, final double lllllllllllllIlIIlIllIIllllIlIII, final double lllllllllllllIlIIlIllIIllllIIlll, final double lllllllllllllIlIIlIllIIlllIllIlI, final double lllllllllllllIlIIlIllIIllllIIlIl, final int... lllllllllllllIlIIlIllIIllllIIIIl) {
        this.spawnParticle(lllllllllllllIlIIlIllIIllllIllIl, false, lllllllllllllIlIIlIllIIllllIIIII, lllllllllllllIlIIlIllIIlllIlllll, lllllllllllllIlIIlIllIIlllIllllI, lllllllllllllIlIIlIllIIlllIlllIl, lllllllllllllIlIIlIllIIllllIlIII, lllllllllllllIlIIlIllIIllllIIlll, lllllllllllllIlIIlIllIIlllIllIlI, lllllllllllllIlIIlIllIIllllIIlIl, lllllllllllllIlIIlIllIIllllIIIIl);
    }
    
    protected BlockPos adjustPosToNearbyEntity(final BlockPos lllllllllllllIlIIlIllIllllllIlIl) {
        BlockPos lllllllllllllIlIIlIllIlllllllIIl = this.getPrecipitationHeight(lllllllllllllIlIIlIllIllllllIlIl);
        final AxisAlignedBB lllllllllllllIlIIlIllIlllllllIII = new AxisAlignedBB(lllllllllllllIlIIlIllIlllllllIIl, new BlockPos(lllllllllllllIlIIlIllIlllllllIIl.getX(), this.getHeight(), lllllllllllllIlIIlIllIlllllllIIl.getZ())).expandXyz(3.0);
        final List<EntityLivingBase> lllllllllllllIlIIlIllIllllllIlll = this.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, lllllllllllllIlIIlIllIlllllllIII, (com.google.common.base.Predicate<? super EntityLivingBase>)new Predicate<EntityLivingBase>() {
            public boolean apply(@Nullable final EntityLivingBase llllllllllllllIIllIIlllIIlllIlII) {
                return llllllllllllllIIllIIlllIIlllIlII != null && llllllllllllllIIllIIlllIIlllIlII.isEntityAlive() && WorldServer.this.canSeeSky(llllllllllllllIIllIIlllIIlllIlII.getPosition());
            }
        });
        if (!lllllllllllllIlIIlIllIllllllIlll.isEmpty()) {
            return lllllllllllllIlIIlIllIllllllIlll.get(this.rand.nextInt(lllllllllllllIlIIlIllIllllllIlll.size())).getPosition();
        }
        if (lllllllllllllIlIIlIllIlllllllIIl.getY() == -1) {
            lllllllllllllIlIIlIllIlllllllIIl = lllllllllllllIlIIlIllIlllllllIIl.up(2);
        }
        return lllllllllllllIlIIlIllIlllllllIIl;
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getWorldInfo().isHardcoreModeEnabled() && this.getDifficulty() != EnumDifficulty.HARD) {
            this.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
        }
        this.provider.getBiomeProvider().cleanupCache();
        if (this.areAllPlayersAsleep()) {
            if (this.getGameRules().getBoolean("doDaylightCycle")) {
                final long lllllllllllllIlIIlIlllIIlIlIIllI = this.worldInfo.getWorldTime() + 24000L;
                this.worldInfo.setWorldTime(lllllllllllllIlIIlIlllIIlIlIIllI - lllllllllllllIlIIlIlllIIlIlIIllI % 24000L);
            }
            this.wakeAllPlayers();
        }
        this.theProfiler.startSection("mobSpawner");
        if (this.getGameRules().getBoolean("doMobSpawning") && this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.entitySpawner.findChunksForSpawning(this, this.spawnHostileMobs, this.spawnPeacefulMobs, this.worldInfo.getWorldTotalTime() % 400L == 0L);
        }
        this.theProfiler.endStartSection("chunkSource");
        this.chunkProvider.unloadQueuedChunks();
        final int lllllllllllllIlIIlIlllIIlIlIIlIl = this.calculateSkylightSubtracted(1.0f);
        if (lllllllllllllIlIIlIlllIIlIlIIlIl != this.getSkylightSubtracted()) {
            this.setSkylightSubtracted(lllllllllllllIlIIlIlllIIlIlIIlIl);
        }
        this.worldInfo.setWorldTotalTime(this.worldInfo.getWorldTotalTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.worldInfo.setWorldTime(this.worldInfo.getWorldTime() + 1L);
        }
        this.theProfiler.endStartSection("tickPending");
        this.tickUpdates(false);
        this.theProfiler.endStartSection("tickBlocks");
        this.updateBlocks();
        this.theProfiler.endStartSection("chunkMap");
        this.thePlayerManager.tick();
        this.theProfiler.endStartSection("village");
        this.villageCollectionObj.tick();
        this.villageSiege.tick();
        this.theProfiler.endStartSection("portalForcer");
        this.worldTeleporter.removeStalePortalLocations(this.getTotalWorldTime());
        this.theProfiler.endSection();
        this.sendQueuedBlockEvents();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void resetUpdateEntityTick() {
        this.updateEntityTick = 0;
    }
    
    @Override
    protected boolean isChunkLoaded(final int lllllllllllllIlIIlIlllIIIlIlIllI, final int lllllllllllllIlIIlIlllIIIlIlIIIl, final boolean lllllllllllllIlIIlIlllIIIlIlIlII) {
        return this.getChunkProvider().chunkExists(lllllllllllllIlIIlIlllIIIlIlIllI, lllllllllllllIlIIlIlllIIIlIlIIIl);
    }
    
    @Override
    protected void tickPlayers() {
        super.tickPlayers();
        this.theProfiler.endStartSection("players");
        for (int lllllllllllllIlIIlIllIlllIIlIlll = 0; lllllllllllllIlIIlIllIlllIIlIlll < this.playerEntities.size(); ++lllllllllllllIlIIlIllIlllIIlIlll) {
            final Entity lllllllllllllIlIIlIllIlllIIlIllI = this.playerEntities.get(lllllllllllllIlIIlIllIlllIIlIlll);
            final Entity lllllllllllllIlIIlIllIlllIIlIlIl = lllllllllllllIlIIlIllIlllIIlIllI.getRidingEntity();
            if (lllllllllllllIlIIlIllIlllIIlIlIl != null) {
                if (!lllllllllllllIlIIlIllIlllIIlIlIl.isDead && lllllllllllllIlIIlIllIlllIIlIlIl.isPassenger(lllllllllllllIlIIlIllIlllIIlIllI)) {
                    continue;
                }
                lllllllllllllIlIIlIllIlllIIlIllI.dismountRidingEntity();
            }
            this.theProfiler.startSection("tick");
            if (!lllllllllllllIlIIlIllIlllIIlIllI.isDead) {
                try {
                    this.updateEntity(lllllllllllllIlIIlIllIlllIIlIllI);
                }
                catch (Throwable lllllllllllllIlIIlIllIlllIIlIlII) {
                    final CrashReport lllllllllllllIlIIlIllIlllIIlIIll = CrashReport.makeCrashReport(lllllllllllllIlIIlIllIlllIIlIlII, "Ticking player");
                    final CrashReportCategory lllllllllllllIlIIlIllIlllIIlIIlI = lllllllllllllIlIIlIllIlllIIlIIll.makeCategory("Player being ticked");
                    lllllllllllllIlIIlIllIlllIIlIllI.addEntityCrashInfo(lllllllllllllIlIIlIllIlllIIlIIlI);
                    throw new ReportedException(lllllllllllllIlIIlIllIlllIIlIIll);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (lllllllllllllIlIIlIllIlllIIlIllI.isDead) {
                final int lllllllllllllIlIIlIllIlllIIlIIIl = lllllllllllllIlIIlIllIlllIIlIllI.chunkCoordX;
                final int lllllllllllllIlIIlIllIlllIIlIIII = lllllllllllllIlIIlIllIlllIIlIllI.chunkCoordZ;
                if (lllllllllllllIlIIlIllIlllIIlIllI.addedToChunk && this.isChunkLoaded(lllllllllllllIlIIlIllIlllIIlIIIl, lllllllllllllIlIIlIllIlllIIlIIII, true)) {
                    this.getChunkFromChunkCoords(lllllllllllllIlIIlIllIlllIIlIIIl, lllllllllllllIlIIlIllIlllIIlIIII).removeEntity(lllllllllllllIlIIlIllIlllIIlIllI);
                }
                this.loadedEntityList.remove(lllllllllllllIlIIlIllIlllIIlIllI);
                this.onEntityRemoved(lllllllllllllIlIIlIllIlllIIlIllI);
            }
            this.theProfiler.endSection();
        }
    }
    
    @Override
    public boolean tickUpdates(final boolean lllllllllllllIlIIlIllIllIllIlllI) {
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        int lllllllllllllIlIIlIllIllIllllIIl = this.pendingTickListEntriesTreeSet.size();
        if (lllllllllllllIlIIlIllIllIllllIIl != this.pendingTickListEntriesHashSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (lllllllllllllIlIIlIllIllIllllIIl > 65536) {
            lllllllllllllIlIIlIllIllIllllIIl = 65536;
        }
        this.theProfiler.startSection("cleaning");
        for (int lllllllllllllIlIIlIllIllIllllIII = 0; lllllllllllllIlIIlIllIllIllllIII < lllllllllllllIlIIlIllIllIllllIIl; ++lllllllllllllIlIIlIllIllIllllIII) {
            final NextTickListEntry lllllllllllllIlIIlIllIllIlllIlll = this.pendingTickListEntriesTreeSet.first();
            if (!lllllllllllllIlIIlIllIllIllIlllI && lllllllllllllIlIIlIllIllIlllIlll.scheduledTime > this.worldInfo.getWorldTotalTime()) {
                break;
            }
            this.pendingTickListEntriesTreeSet.remove(lllllllllllllIlIIlIllIllIlllIlll);
            this.pendingTickListEntriesHashSet.remove(lllllllllllllIlIIlIllIllIlllIlll);
            this.pendingTickListEntriesThisTick.add(lllllllllllllIlIIlIllIllIlllIlll);
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("ticking");
        final Iterator<NextTickListEntry> lllllllllllllIlIIlIllIllIlllIllI = this.pendingTickListEntriesThisTick.iterator();
        while (lllllllllllllIlIIlIllIllIlllIllI.hasNext()) {
            final NextTickListEntry lllllllllllllIlIIlIllIllIlllIlIl = lllllllllllllIlIIlIllIllIlllIllI.next();
            lllllllllllllIlIIlIllIllIlllIllI.remove();
            final int lllllllllllllIlIIlIllIllIlllIlII = 0;
            if (this.isAreaLoaded(lllllllllllllIlIIlIllIllIlllIlIl.position.add(0, 0, 0), lllllllllllllIlIIlIllIllIlllIlIl.position.add(0, 0, 0))) {
                final IBlockState lllllllllllllIlIIlIllIllIlllIIll = this.getBlockState(lllllllllllllIlIIlIllIllIlllIlIl.position);
                if (lllllllllllllIlIIlIllIllIlllIIll.getMaterial() == Material.AIR || !Block.isEqualTo(lllllllllllllIlIIlIllIllIlllIIll.getBlock(), lllllllllllllIlIIlIllIllIlllIlIl.getBlock())) {
                    continue;
                }
                try {
                    lllllllllllllIlIIlIllIllIlllIIll.getBlock().updateTick(this, lllllllllllllIlIIlIllIllIlllIlIl.position, lllllllllllllIlIIlIllIllIlllIIll, this.rand);
                    continue;
                }
                catch (Throwable lllllllllllllIlIIlIllIllIlllIIlI) {
                    final CrashReport lllllllllllllIlIIlIllIllIlllIIIl = CrashReport.makeCrashReport(lllllllllllllIlIIlIllIllIlllIIlI, "Exception while ticking a block");
                    final CrashReportCategory lllllllllllllIlIIlIllIllIlllIIII = lllllllllllllIlIIlIllIllIlllIIIl.makeCategory("Block being ticked");
                    CrashReportCategory.addBlockInfo(lllllllllllllIlIIlIllIllIlllIIII, lllllllllllllIlIIlIllIllIlllIlIl.position, lllllllllllllIlIIlIllIllIlllIIll);
                    throw new ReportedException(lllllllllllllIlIIlIllIllIlllIIIl);
                }
            }
            this.scheduleUpdate(lllllllllllllIlIIlIllIllIlllIlIl.position, lllllllllllllIlIIlIllIllIlllIlIl.getBlock(), 0);
        }
        this.theProfiler.endSection();
        this.pendingTickListEntriesThisTick.clear();
        return !this.pendingTickListEntriesTreeSet.isEmpty();
    }
    
    protected void wakeAllPlayers() {
        this.allPlayersSleeping = false;
        for (final EntityPlayer lllllllllllllIlIIlIlllIIIlllIlIl : this.playerEntities.stream().filter(EntityPlayer::isPlayerSleeping).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList())) {
            lllllllllllllIlIIlIlllIIIlllIlIl.wakeUpPlayer(false, false, true);
        }
        if (this.getGameRules().getBoolean("doWeatherCycle")) {
            this.resetRainAndThunder();
        }
    }
    
    @Override
    public void addBlockEvent(final BlockPos lllllllllllllIlIIlIllIlIIIllIIll, final Block lllllllllllllIlIIlIllIlIIIllIIlI, final int lllllllllllllIlIIlIllIlIIIllIIIl, final int lllllllllllllIlIIlIllIlIIIllIIII) {
        final BlockEventData lllllllllllllIlIIlIllIlIIIlIllll = new BlockEventData(lllllllllllllIlIIlIllIlIIIllIIll, lllllllllllllIlIIlIllIlIIIllIIlI, lllllllllllllIlIIlIllIlIIIllIIIl, lllllllllllllIlIIlIllIlIIIllIIII);
        for (final BlockEventData lllllllllllllIlIIlIllIlIIIlIlllI : this.blockEventQueue[this.blockEventCacheIndex]) {
            if (lllllllllllllIlIIlIllIlIIIlIlllI.equals(lllllllllllllIlIIlIllIlIIIlIllll)) {
                return;
            }
        }
        this.blockEventQueue[this.blockEventCacheIndex].add(lllllllllllllIlIIlIllIlIIIlIllll);
    }
    
    private void createSpawnPosition(final WorldSettings lllllllllllllIlIIlIllIlIlllllIlI) {
        if (!this.provider.canRespawnHere()) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up(this.provider.getAverageGroundLevel()));
        }
        else if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up());
        }
        else {
            this.findingSpawnPoint = true;
            final BiomeProvider lllllllllllllIlIIlIllIlIlllllIIl = this.provider.getBiomeProvider();
            final List<Biome> lllllllllllllIlIIlIllIlIlllllIII = lllllllllllllIlIIlIllIlIlllllIIl.getBiomesToSpawnIn();
            final Random lllllllllllllIlIIlIllIlIllllIlll = new Random(this.getSeed());
            final BlockPos lllllllllllllIlIIlIllIlIllllIllI = lllllllllllllIlIIlIllIlIlllllIIl.findBiomePosition(0, 0, 256, lllllllllllllIlIIlIllIlIlllllIII, lllllllllllllIlIIlIllIlIllllIlll);
            int lllllllllllllIlIIlIllIlIllllIlIl = 8;
            final int lllllllllllllIlIIlIllIlIllllIlII = this.provider.getAverageGroundLevel();
            int lllllllllllllIlIIlIllIlIllllIIll = 8;
            if (lllllllllllllIlIIlIllIlIllllIllI != null) {
                lllllllllllllIlIIlIllIlIllllIlIl = lllllllllllllIlIIlIllIlIllllIllI.getX();
                lllllllllllllIlIIlIllIlIllllIIll = lllllllllllllIlIIlIllIlIllllIllI.getZ();
            }
            else {
                WorldServer.LOGGER.warn("Unable to find spawn biome");
            }
            int lllllllllllllIlIIlIllIlIllllIIlI = 0;
            while (!this.provider.canCoordinateBeSpawn(lllllllllllllIlIIlIllIlIllllIlIl, lllllllllllllIlIIlIllIlIllllIIll)) {
                lllllllllllllIlIIlIllIlIllllIlIl += lllllllllllllIlIIlIllIlIllllIlll.nextInt(64) - lllllllllllllIlIIlIllIlIllllIlll.nextInt(64);
                lllllllllllllIlIIlIllIlIllllIIll += lllllllllllllIlIIlIllIlIllllIlll.nextInt(64) - lllllllllllllIlIIlIllIlIllllIlll.nextInt(64);
                if (++lllllllllllllIlIIlIllIlIllllIIlI == 1000) {
                    break;
                }
            }
            this.worldInfo.setSpawn(new BlockPos(lllllllllllllIlIIlIllIlIllllIlIl, lllllllllllllIlIIlIllIlIllllIlII, lllllllllllllIlIIlIllIlIllllIIll));
            this.findingSpawnPoint = false;
            if (lllllllllllllIlIIlIllIlIlllllIlI.isBonusChestEnabled()) {
                this.createBonusChest();
            }
        }
    }
    
    @Override
    public void updateBlockTick(final BlockPos lllllllllllllIlIIlIllIlllIllllIl, final Block lllllllllllllIlIIlIllIlllIllllII, int lllllllllllllIlIIlIllIlllIlllIll, final int lllllllllllllIlIIlIllIlllIlllIlI) {
        final Material lllllllllllllIlIIlIllIllllIIIIIl = lllllllllllllIlIIlIllIlllIllllII.getDefaultState().getMaterial();
        if (this.scheduledUpdatesAreImmediate && lllllllllllllIlIIlIllIllllIIIIIl != Material.AIR) {
            if (lllllllllllllIlIIlIllIlllIllllII.requiresUpdates()) {
                if (this.isAreaLoaded(lllllllllllllIlIIlIllIlllIllllIl.add(-8, -8, -8), lllllllllllllIlIIlIllIlllIllllIl.add(8, 8, 8))) {
                    final IBlockState lllllllllllllIlIIlIllIllllIIIIII = this.getBlockState(lllllllllllllIlIIlIllIlllIllllIl);
                    if (lllllllllllllIlIIlIllIllllIIIIII.getMaterial() != Material.AIR && lllllllllllllIlIIlIllIllllIIIIII.getBlock() == lllllllllllllIlIIlIllIlllIllllII) {
                        lllllllllllllIlIIlIllIllllIIIIII.getBlock().updateTick(this, lllllllllllllIlIIlIllIlllIllllIl, lllllllllllllIlIIlIllIllllIIIIII, this.rand);
                    }
                }
                return;
            }
            lllllllllllllIlIIlIllIlllIlllIll = 1;
        }
        final NextTickListEntry lllllllllllllIlIIlIllIlllIllllll = new NextTickListEntry(lllllllllllllIlIIlIllIlllIllllIl, lllllllllllllIlIIlIllIlllIllllII);
        if (this.isBlockLoaded(lllllllllllllIlIIlIllIlllIllllIl)) {
            if (lllllllllllllIlIIlIllIllllIIIIIl != Material.AIR) {
                lllllllllllllIlIIlIllIlllIllllll.setScheduledTime(lllllllllllllIlIIlIllIlllIlllIll + this.worldInfo.getWorldTotalTime());
                lllllllllllllIlIIlIllIlllIllllll.setPriority(lllllllllllllIlIIlIllIlllIlllIlI);
            }
            if (!this.pendingTickListEntriesHashSet.contains(lllllllllllllIlIIlIllIlllIllllll)) {
                this.pendingTickListEntriesHashSet.add(lllllllllllllIlIIlIllIlllIllllll);
                this.pendingTickListEntriesTreeSet.add(lllllllllllllIlIIlIllIlllIllllll);
            }
        }
    }
    
    public WorldServer(final MinecraftServer lllllllllllllIlIIlIlllIIllIlIIll, final ISaveHandler lllllllllllllIlIIlIlllIIllIllIll, final WorldInfo lllllllllllllIlIIlIlllIIllIllIlI, final int lllllllllllllIlIIlIlllIIllIllIII, final Profiler lllllllllllllIlIIlIlllIIllIIlIll) {
        super(lllllllllllllIlIIlIlllIIllIllIll, lllllllllllllIlIIlIlllIIllIllIlI, DimensionType.getById(lllllllllllllIlIIlIlllIIllIllIII).createDimension(), lllllllllllllIlIIlIlllIIllIIlIll, false);
        this.pendingTickListEntriesHashSet = (Set<NextTickListEntry>)Sets.newHashSet();
        this.pendingTickListEntriesTreeSet = new TreeSet<NextTickListEntry>();
        this.entitiesByUuid = (Map<UUID, Entity>)Maps.newHashMap();
        this.entitySpawner = new WorldEntitySpawner();
        this.villageSiege = new VillageSiege(this);
        this.blockEventQueue = new ServerBlockEventList[] { new ServerBlockEventList(null), new ServerBlockEventList(null) };
        this.pendingTickListEntriesThisTick = (List<NextTickListEntry>)Lists.newArrayList();
        this.mcServer = lllllllllllllIlIIlIlllIIllIlIIll;
        this.theEntityTracker = new EntityTracker(this);
        this.thePlayerManager = new PlayerChunkMap(this);
        this.provider.registerWorld(this);
        this.chunkProvider = this.createChunkProvider();
        this.worldTeleporter = new Teleporter(this);
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        this.getWorldBorder().setSize(lllllllllllllIlIIlIlllIIllIlIIll.getMaxWorldSize());
    }
    
    @Nullable
    public Biome.SpawnListEntry getSpawnListEntryForTypeAt(final EnumCreatureType lllllllllllllIlIIlIlllIIlIIlllIl, final BlockPos lllllllllllllIlIIlIlllIIlIIlllII) {
        final List<Biome.SpawnListEntry> lllllllllllllIlIIlIlllIIlIIllIll = this.getChunkProvider().getPossibleCreatures(lllllllllllllIlIIlIlllIIlIIlllIl, lllllllllllllIlIIlIlllIIlIIlllII);
        return (lllllllllllllIlIIlIlllIIlIIllIll != null && !lllllllllllllIlIIlIlllIIlIIllIll.isEmpty()) ? WeightedRandom.getRandomItem(this.rand, lllllllllllllIlIIlIlllIIlIIllIll) : null;
    }
    
    @Override
    public Explosion newExplosion(@Nullable final Entity lllllllllllllIlIIlIllIlIIlIIIllI, final double lllllllllllllIlIIlIllIlIIlIIIlIl, final double lllllllllllllIlIIlIllIlIIlIIIlII, final double lllllllllllllIlIIlIllIlIIlIIIIll, final float lllllllllllllIlIIlIllIlIIlIIllII, final boolean lllllllllllllIlIIlIllIlIIlIIlIll, final boolean lllllllllllllIlIIlIllIlIIlIIIIII) {
        final Explosion lllllllllllllIlIIlIllIlIIlIIlIIl = new Explosion(this, lllllllllllllIlIIlIllIlIIlIIIllI, lllllllllllllIlIIlIllIlIIlIIIlIl, lllllllllllllIlIIlIllIlIIlIIIlII, lllllllllllllIlIIlIllIlIIlIIIIll, lllllllllllllIlIIlIllIlIIlIIllII, lllllllllllllIlIIlIllIlIIlIIlIll, lllllllllllllIlIIlIllIlIIlIIIIII);
        lllllllllllllIlIIlIllIlIIlIIlIIl.doExplosionA();
        lllllllllllllIlIIlIllIlIIlIIlIIl.doExplosionB(false);
        if (!lllllllllllllIlIIlIllIlIIlIIIIII) {
            lllllllllllllIlIIlIllIlIIlIIlIIl.clearAffectedBlockPositions();
        }
        for (final EntityPlayer lllllllllllllIlIIlIllIlIIlIIlIII : this.playerEntities) {
            if (lllllllllllllIlIIlIllIlIIlIIlIII.getDistanceSq(lllllllllllllIlIIlIllIlIIlIIIlIl, lllllllllllllIlIIlIllIlIIlIIIlII, lllllllllllllIlIIlIllIlIIlIIIIll) < 4096.0) {
                ((EntityPlayerMP)lllllllllllllIlIIlIllIlIIlIIlIII).connection.sendPacket(new SPacketExplosion(lllllllllllllIlIIlIllIlIIlIIIlIl, lllllllllllllIlIIlIllIlIIlIIIlII, lllllllllllllIlIIlIllIlIIlIIIIll, lllllllllllllIlIIlIllIlIIlIIllII, lllllllllllllIlIIlIllIlIIlIIlIIl.getAffectedBlockPositions(), lllllllllllllIlIIlIllIlIIlIIlIIl.getPlayerKnockbackMap().get(lllllllllllllIlIIlIllIlIIlIIlIII)));
            }
        }
        return lllllllllllllIlIIlIllIlIIlIIlIIl;
    }
    
    @Override
    public void setEntityState(final Entity lllllllllllllIlIIlIllIlIIllIIIIl, final byte lllllllllllllIlIIlIllIlIIllIIIll) {
        this.getEntityTracker().sendToTrackingAndSelf(lllllllllllllIlIIlIllIlIIllIIIIl, new SPacketEntityStatus(lllllllllllllIlIIlIllIlIIllIIIIl, lllllllllllllIlIIlIllIlIIllIIIll));
    }
    
    public void saveChunkData() {
        final ChunkProviderServer lllllllllllllIlIIlIllIlIlIlllllI = this.getChunkProvider();
        if (lllllllllllllIlIIlIllIlIlIlllllI.canSave()) {
            lllllllllllllIlIIlIllIlIlIlllllI.saveExtraData();
        }
    }
    
    @Override
    public void setInitialSpawnLocation() {
        if (this.worldInfo.getSpawnY() <= 0) {
            this.worldInfo.setSpawnY(this.getSeaLevel() + 1);
        }
        int lllllllllllllIlIIlIlllIIIllIIIIl = this.worldInfo.getSpawnX();
        int lllllllllllllIlIIlIlllIIIllIIIII = this.worldInfo.getSpawnZ();
        int lllllllllllllIlIIlIlllIIIlIlllll = 0;
        while (this.getGroundAboveSeaLevel(new BlockPos(lllllllllllllIlIIlIlllIIIllIIIIl, 0, lllllllllllllIlIIlIlllIIIllIIIII)).getMaterial() == Material.AIR) {
            lllllllllllllIlIIlIlllIIIllIIIIl += this.rand.nextInt(8) - this.rand.nextInt(8);
            lllllllllllllIlIIlIlllIIIllIIIII += this.rand.nextInt(8) - this.rand.nextInt(8);
            if (++lllllllllllllIlIIlIlllIIIlIlllll == 10000) {
                break;
            }
        }
        this.worldInfo.setSpawnX(lllllllllllllIlIIlIlllIIIllIIIIl);
        this.worldInfo.setSpawnZ(lllllllllllllIlIIlIlllIIIllIIIII);
    }
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable lllllllllllllIlIIlIllIIlIlIlllll) {
        return this.mcServer.addScheduledTask(lllllllllllllIlIIlIllIIlIlIlllll);
    }
    
    @Override
    protected void onEntityAdded(final Entity lllllllllllllIlIIlIllIlIlIIIIllI) {
        super.onEntityAdded(lllllllllllllIlIIlIllIlIlIIIIllI);
        this.entitiesById.addKey(lllllllllllllIlIIlIllIlIlIIIIllI.getEntityId(), lllllllllllllIlIIlIllIlIlIIIIllI);
        this.entitiesByUuid.put(lllllllllllllIlIIlIllIlIlIIIIllI.getUniqueID(), lllllllllllllIlIIlIllIlIlIIIIllI);
        final Entity[] lllllllllllllIlIIlIllIlIlIIIlIIl = lllllllllllllIlIIlIllIlIlIIIIllI.getParts();
        if (lllllllllllllIlIIlIllIlIlIIIlIIl != null) {
            final boolean lllllllllllllIlIIlIllIlIlIIIIIIl;
            final boolean lllllllllllllIlIIlIllIlIlIIIIIlI = ((Entity[])(Object)(lllllllllllllIlIIlIllIlIlIIIIIIl = (boolean)(Object)lllllllllllllIlIIlIllIlIlIIIlIIl)).length != 0;
            for (short lllllllllllllIlIIlIllIlIlIIIIIll = 0; lllllllllllllIlIIlIllIlIlIIIIIll < (lllllllllllllIlIIlIllIlIlIIIIIlI ? 1 : 0); ++lllllllllllllIlIIlIllIlIlIIIIIll) {
                final Entity lllllllllllllIlIIlIllIlIlIIIlIII = lllllllllllllIlIIlIllIlIlIIIIIIl[lllllllllllllIlIIlIllIlIlIIIIIll];
                this.entitiesById.addKey(lllllllllllllIlIIlIllIlIlIIIlIII.getEntityId(), lllllllllllllIlIIlIllIlIlIIIlIII);
            }
        }
    }
    
    private boolean canSpawnAnimals() {
        return this.mcServer.getCanSpawnAnimals();
    }
    
    public FunctionManager func_193037_A() {
        return this.field_193036_D;
    }
    
    public Teleporter getDefaultTeleporter() {
        return this.worldTeleporter;
    }
    
    private void sendPacketWithinDistance(final EntityPlayerMP lllllllllllllIlIIlIllIIlIlllIIII, final boolean lllllllllllllIlIIlIllIIlIllIllll, final double lllllllllllllIlIIlIllIIlIlllIllI, final double lllllllllllllIlIIlIllIIlIllIllIl, final double lllllllllllllIlIIlIllIIlIlllIlII, final Packet<?> lllllllllllllIlIIlIllIIlIllIlIll) {
        final BlockPos lllllllllllllIlIIlIllIIlIlllIIlI = lllllllllllllIlIIlIllIIlIlllIIII.getPosition();
        final double lllllllllllllIlIIlIllIIlIlllIIIl = lllllllllllllIlIIlIllIIlIlllIIlI.distanceSq(lllllllllllllIlIIlIllIIlIlllIllI, lllllllllllllIlIIlIllIIlIllIllIl, lllllllllllllIlIIlIllIIlIlllIlII);
        if (lllllllllllllIlIIlIllIIlIlllIIIl <= 1024.0 || (lllllllllllllIlIIlIllIIlIllIllll && lllllllllllllIlIIlIllIIlIlllIIIl <= 262144.0)) {
            lllllllllllllIlIIlIllIIlIlllIIII.connection.sendPacket(lllllllllllllIlIIlIllIIlIllIlIll);
        }
    }
    
    private void sendQueuedBlockEvents() {
        while (!this.blockEventQueue[this.blockEventCacheIndex].isEmpty()) {
            final int lllllllllllllIlIIlIllIlIIIlIIIII = this.blockEventCacheIndex;
            this.blockEventCacheIndex ^= 0x1;
            for (final BlockEventData lllllllllllllIlIIlIllIlIIIIlllll : this.blockEventQueue[lllllllllllllIlIIlIllIlIIIlIIIII]) {
                if (this.fireBlockEvent(lllllllllllllIlIIlIllIlIIIIlllll)) {
                    this.mcServer.getPlayerList().sendToAllNearExcept(null, lllllllllllllIlIIlIllIlIIIIlllll.getPosition().getX(), lllllllllllllIlIIlIllIlIIIIlllll.getPosition().getY(), lllllllllllllIlIIlIllIlIIIIlllll.getPosition().getZ(), 64.0, this.provider.getDimensionType().getId(), new SPacketBlockAction(lllllllllllllIlIIlIllIlIIIIlllll.getPosition(), lllllllllllllIlIIlIllIlIIIIlllll.getBlock(), lllllllllllllIlIIlIllIlIIIIlllll.getEventID(), lllllllllllllIlIIlIllIlIIIIlllll.getEventParameter()));
                }
            }
            this.blockEventQueue[lllllllllllllIlIIlIllIlIIIlIIIII].clear();
        }
    }
    
    @Nullable
    public Entity getEntityFromUuid(final UUID lllllllllllllIlIIlIllIIlIllIIlIl) {
        return this.entitiesByUuid.get(lllllllllllllIlIIlIllIIlIllIIlIl);
    }
    
    public void flush() {
        this.saveHandler.flush();
    }
    
    @Override
    public void initialize(final WorldSettings lllllllllllllIlIIlIllIllIIIlIIII) {
        if (!this.worldInfo.isInitialized()) {
            try {
                this.createSpawnPosition(lllllllllllllIlIIlIllIllIIIlIIII);
                if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
                    this.setDebugWorldSettings();
                }
                super.initialize(lllllllllllllIlIIlIllIllIIIlIIII);
            }
            catch (Throwable lllllllllllllIlIIlIllIllIIIIllll) {
                final CrashReport lllllllllllllIlIIlIllIllIIIIlllI = CrashReport.makeCrashReport(lllllllllllllIlIIlIllIllIIIIllll, "Exception initializing level");
                try {
                    this.addWorldInfoToCrashReport(lllllllllllllIlIIlIllIllIIIIlllI);
                }
                catch (Throwable t) {}
                throw new ReportedException(lllllllllllllIlIIlIllIllIIIIlllI);
            }
            this.worldInfo.setServerInitialized(true);
        }
    }
    
    @Override
    public boolean isBlockModifiable(final EntityPlayer lllllllllllllIlIIlIllIllIIIllIll, final BlockPos lllllllllllllIlIIlIllIllIIIllIlI) {
        return !this.mcServer.isBlockProtected(this, lllllllllllllIlIIlIllIllIIIllIlI, lllllllllllllIlIIlIllIllIIIllIll) && this.getWorldBorder().contains(lllllllllllllIlIIlIllIllIIIllIlI);
    }
    
    @Nullable
    @Override
    public List<NextTickListEntry> getPendingBlockUpdates(final StructureBoundingBox lllllllllllllIlIIlIllIllIIlllIll, final boolean lllllllllllllIlIIlIllIllIIlllIlI) {
        List<NextTickListEntry> lllllllllllllIlIIlIllIllIlIIIIlI = null;
        for (int lllllllllllllIlIIlIllIllIlIIIIIl = 0; lllllllllllllIlIIlIllIllIlIIIIIl < 2; ++lllllllllllllIlIIlIllIllIlIIIIIl) {
            Iterator<NextTickListEntry> lllllllllllllIlIIlIllIllIIllllll = null;
            if (lllllllllllllIlIIlIllIllIlIIIIIl == 0) {
                final Iterator<NextTickListEntry> lllllllllllllIlIIlIllIllIlIIIIII = this.pendingTickListEntriesTreeSet.iterator();
            }
            else {
                lllllllllllllIlIIlIllIllIIllllll = this.pendingTickListEntriesThisTick.iterator();
            }
            while (lllllllllllllIlIIlIllIllIIllllll.hasNext()) {
                final NextTickListEntry lllllllllllllIlIIlIllIllIIlllllI = lllllllllllllIlIIlIllIllIIllllll.next();
                final BlockPos lllllllllllllIlIIlIllIllIIllllIl = lllllllllllllIlIIlIllIllIIlllllI.position;
                if (lllllllllllllIlIIlIllIllIIllllIl.getX() >= lllllllllllllIlIIlIllIllIIlllIll.minX && lllllllllllllIlIIlIllIllIIllllIl.getX() < lllllllllllllIlIIlIllIllIIlllIll.maxX && lllllllllllllIlIIlIllIllIIllllIl.getZ() >= lllllllllllllIlIIlIllIllIIlllIll.minZ && lllllllllllllIlIIlIllIllIIllllIl.getZ() < lllllllllllllIlIIlIllIllIIlllIll.maxZ) {
                    if (lllllllllllllIlIIlIllIllIIlllIlI) {
                        if (lllllllllllllIlIIlIllIllIlIIIIIl == 0) {
                            this.pendingTickListEntriesHashSet.remove(lllllllllllllIlIIlIllIllIIlllllI);
                        }
                        lllllllllllllIlIIlIllIllIIllllll.remove();
                    }
                    if (lllllllllllllIlIIlIllIllIlIIIIlI == null) {
                        lllllllllllllIlIIlIllIllIlIIIIlI = (List<NextTickListEntry>)Lists.newArrayList();
                    }
                    lllllllllllllIlIIlIllIllIlIIIIlI.add(lllllllllllllIlIIlIllIllIIlllllI);
                }
            }
        }
        return lllllllllllllIlIIlIllIllIlIIIIlI;
    }
    
    @Nullable
    @Override
    public MinecraftServer getMinecraftServer() {
        return this.mcServer;
    }
    
    @Override
    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = false;
        if (!this.playerEntities.isEmpty()) {
            int lllllllllllllIlIIlIlllIIlIIIIIIl = 0;
            int lllllllllllllIlIIlIlllIIlIIIIIII = 0;
            for (final EntityPlayer lllllllllllllIlIIlIlllIIIlllllll : this.playerEntities) {
                if (lllllllllllllIlIIlIlllIIIlllllll.isSpectator()) {
                    ++lllllllllllllIlIIlIlllIIlIIIIIIl;
                }
                else {
                    if (!lllllllllllllIlIIlIlllIIIlllllll.isPlayerSleeping()) {
                        continue;
                    }
                    ++lllllllllllllIlIIlIlllIIlIIIIIII;
                }
            }
            this.allPlayersSleeping = (lllllllllllllIlIIlIlllIIlIIIIIII > 0 && lllllllllllllIlIIlIlllIIlIIIIIII >= this.playerEntities.size() - lllllllllllllIlIIlIlllIIlIIIIIIl);
        }
    }
    
    private void setDebugWorldSettings() {
        this.worldInfo.setMapFeaturesEnabled(false);
        this.worldInfo.setAllowCommands(true);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThundering(false);
        this.worldInfo.setCleanWeatherTime(1000000000);
        this.worldInfo.setWorldTime(6000L);
        this.worldInfo.setGameType(GameType.SPECTATOR);
        this.worldInfo.setHardcore(false);
        this.worldInfo.setDifficulty(EnumDifficulty.PEACEFUL);
        this.worldInfo.setDifficultyLocked(true);
        this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
    }
    
    @Nullable
    @Override
    public List<NextTickListEntry> getPendingBlockUpdates(final Chunk lllllllllllllIlIIlIllIllIlIlllII, final boolean lllllllllllllIlIIlIllIllIlIlIIll) {
        final ChunkPos lllllllllllllIlIIlIllIllIlIllIlI = lllllllllllllIlIIlIllIllIlIlllII.getChunkCoordIntPair();
        final int lllllllllllllIlIIlIllIllIlIllIIl = (lllllllllllllIlIIlIllIllIlIllIlI.chunkXPos << 4) - 2;
        final int lllllllllllllIlIIlIllIllIlIllIII = lllllllllllllIlIIlIllIllIlIllIIl + 16 + 2;
        final int lllllllllllllIlIIlIllIllIlIlIlll = (lllllllllllllIlIIlIllIllIlIllIlI.chunkZPos << 4) - 2;
        final int lllllllllllllIlIIlIllIllIlIlIllI = lllllllllllllIlIIlIllIllIlIlIlll + 16 + 2;
        return this.getPendingBlockUpdates(new StructureBoundingBox(lllllllllllllIlIIlIllIllIlIllIIl, 0, lllllllllllllIlIIlIllIllIlIlIlll, lllllllllllllIlIIlIllIllIlIllIII, 256, lllllllllllllIlIIlIllIllIlIlIllI), lllllllllllllIlIIlIllIllIlIlIIll);
    }
    
    static class ServerBlockEventList extends ArrayList<BlockEventData>
    {
        private ServerBlockEventList() {
        }
    }
}
