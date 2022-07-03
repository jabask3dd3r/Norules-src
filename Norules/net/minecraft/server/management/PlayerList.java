package net.minecraft.server.management;

import java.io.*;
import java.text.*;
import net.minecraft.server.*;
import net.minecraft.entity.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.scoreboard.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.advancements.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.potion.*;
import net.minecraft.world.border.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.util.text.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.storage.*;
import net.minecraft.network.play.server.*;
import java.net.*;

public abstract class PlayerList
{
    public static final /* synthetic */ File FILE_PLAYERBANS;
    private /* synthetic */ boolean whiteListEnforced;
    private final /* synthetic */ List<EntityPlayerMP> playerEntityList;
    private final /* synthetic */ Map<UUID, StatisticsManagerServer> playerStatFiles;
    private static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    protected /* synthetic */ int maxPlayers;
    private final /* synthetic */ UserListWhitelist whiteListedPlayers;
    private final /* synthetic */ UserListIPBans bannedIPs;
    private final /* synthetic */ Map<UUID, EntityPlayerMP> uuidToPlayerMap;
    public static final /* synthetic */ File FILE_IPBANS;
    private final /* synthetic */ UserListOps ops;
    public static final /* synthetic */ File FILE_OPS;
    private /* synthetic */ IPlayerFileData playerNBTManagerObj;
    private /* synthetic */ int viewDistance;
    private static final /* synthetic */ Logger LOG;
    private /* synthetic */ GameType gameType;
    public static final /* synthetic */ File FILE_WHITELIST;
    private /* synthetic */ int playerPingIndex;
    private /* synthetic */ boolean commandsAllowedForAll;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ UserListBans bannedPlayers;
    private final /* synthetic */ Map<UUID, PlayerAdvancements> field_192055_p;
    
    public int getCurrentPlayerCount() {
        return this.playerEntityList.size();
    }
    
    private void sendPlayerPermissionLevel(final EntityPlayerMP llllllllllllllllIIIIlIIIIlIIIllI, final int llllllllllllllllIIIIlIIIIlIIlIlI) {
        if (llllllllllllllllIIIIlIIIIlIIIllI != null && llllllllllllllllIIIIlIIIIlIIIllI.connection != null) {
            byte llllllllllllllllIIIIlIIIIlIIIlll = 0;
            if (llllllllllllllllIIIIlIIIIlIIlIlI <= 0) {
                final byte llllllllllllllllIIIIlIIIIlIIlIIl = 24;
            }
            else if (llllllllllllllllIIIIlIIIIlIIlIlI >= 4) {
                final byte llllllllllllllllIIIIlIIIIlIIlIII = 28;
            }
            else {
                llllllllllllllllIIIIlIIIIlIIIlll = (byte)(24 + llllllllllllllllIIIIlIIIIlIIlIlI);
            }
            llllllllllllllllIIIIlIIIIlIIIllI.connection.sendPacket(new SPacketEntityStatus(llllllllllllllllIIIIlIIIIlIIIllI, llllllllllllllllIIIIlIIIIlIIIlll));
        }
    }
    
    public String[] getOppedPlayerNames() {
        return this.ops.getKeys();
    }
    
    public int getViewDistance() {
        return this.viewDistance;
    }
    
    public void updatePermissionLevel(final EntityPlayerMP llllllllllllllllIIIIlIIlIIIIIIIl) {
        final GameProfile llllllllllllllllIIIIlIIlIIIIIIII = llllllllllllllllIIIIlIIlIIIIIIIl.getGameProfile();
        int llllllllllllllllIIIIlIIIllllllll = this.canSendCommands(llllllllllllllllIIIIlIIlIIIIIIII) ? this.ops.getPermissionLevel(llllllllllllllllIIIIlIIlIIIIIIII) : 0;
        llllllllllllllllIIIIlIIIllllllll = ((this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed()) ? 4 : llllllllllllllllIIIIlIIIllllllll);
        llllllllllllllllIIIIlIIIllllllll = (this.commandsAllowedForAll ? 4 : llllllllllllllllIIIIlIIIllllllll);
        this.sendPlayerPermissionLevel(llllllllllllllllIIIIlIIlIIIIIIIl, llllllllllllllllIIIIlIIIllllllll);
    }
    
    private void setPlayerGameTypeBasedOnOther(final EntityPlayerMP llllllllllllllllIIIIIllllIlIIlII, final EntityPlayerMP llllllllllllllllIIIIIllllIIlllll, final World llllllllllllllllIIIIIllllIIllllI) {
        if (llllllllllllllllIIIIIllllIIlllll != null) {
            llllllllllllllllIIIIIllllIlIIlII.interactionManager.setGameType(llllllllllllllllIIIIIllllIIlllll.interactionManager.getGameType());
        }
        else if (this.gameType != null) {
            llllllllllllllllIIIIIllllIlIIlII.interactionManager.setGameType(this.gameType);
        }
        llllllllllllllllIIIIIllllIlIIlII.interactionManager.initializeGameType(llllllllllllllllIIIIIllllIIllllI.getWorldInfo().getGameType());
    }
    
    public boolean bypassesPlayerLimit(final GameProfile llllllllllllllllIIIIIlllIIllllll) {
        return false;
    }
    
    public boolean canJoin(final GameProfile llllllllllllllllIIIIlIIIIlIIIIII) {
        return !this.whiteListEnforced || ((UserList<GameProfile, V>)this.ops).hasEntry(llllllllllllllllIIIIlIIIIlIIIIII) || ((UserList<GameProfile, V>)this.whiteListedPlayers).hasEntry(llllllllllllllllIIIIlIIIIlIIIIII);
    }
    
    public EntityPlayerMP createPlayerForUser(final GameProfile llllllllllllllllIIIIlIIlIIllIlll) {
        final UUID llllllllllllllllIIIIlIIlIIllIllI = EntityPlayer.getUUID(llllllllllllllllIIIIlIIlIIllIlll);
        final List<EntityPlayerMP> llllllllllllllllIIIIlIIlIIllIlIl = (List<EntityPlayerMP>)Lists.newArrayList();
        for (int llllllllllllllllIIIIlIIlIIllIlII = 0; llllllllllllllllIIIIlIIlIIllIlII < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIlIIllIlII) {
            final EntityPlayerMP llllllllllllllllIIIIlIIlIIllIIll = this.playerEntityList.get(llllllllllllllllIIIIlIIlIIllIlII);
            if (llllllllllllllllIIIIlIIlIIllIIll.getUniqueID().equals(llllllllllllllllIIIIlIIlIIllIllI)) {
                llllllllllllllllIIIIlIIlIIllIlIl.add(llllllllllllllllIIIIlIIlIIllIIll);
            }
        }
        final EntityPlayerMP llllllllllllllllIIIIlIIlIIllIIlI = this.uuidToPlayerMap.get(llllllllllllllllIIIIlIIlIIllIlll.getId());
        if (llllllllllllllllIIIIlIIlIIllIIlI != null && !llllllllllllllllIIIIlIIlIIllIlIl.contains(llllllllllllllllIIIIlIIlIIllIIlI)) {
            llllllllllllllllIIIIlIIlIIllIlIl.add(llllllllllllllllIIIIlIIlIIllIIlI);
        }
        for (final EntityPlayerMP llllllllllllllllIIIIlIIlIIllIIIl : llllllllllllllllIIIIlIIlIIllIlIl) {
            llllllllllllllllIIIIlIIlIIllIIIl.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.duplicate_login", new Object[0]));
        }
        PlayerInteractionManager llllllllllllllllIIIIlIIlIIlIllll = null;
        if (this.mcServer.isDemo()) {
            final PlayerInteractionManager llllllllllllllllIIIIlIIlIIllIIII = new DemoPlayerInteractionManager(this.mcServer.worldServerForDimension(0));
        }
        else {
            llllllllllllllllIIIIlIIlIIlIllll = new PlayerInteractionManager(this.mcServer.worldServerForDimension(0));
        }
        return new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(0), llllllllllllllllIIIIlIIlIIllIlll, llllllllllllllllIIIIlIIlIIlIllll);
    }
    
    public void addWhitelistedPlayer(final GameProfile llllllllllllllllIIIIIllllllllIlI) {
        ((UserList<K, UserListWhitelistEntry>)this.whiteListedPlayers).addEntry(new UserListWhitelistEntry(llllllllllllllllIIIIIllllllllIlI));
    }
    
    public void playerLoggedIn(final EntityPlayerMP llllllllllllllllIIIIlIIlIllIlllI) {
        this.playerEntityList.add(llllllllllllllllIIIIlIIlIllIlllI);
        this.uuidToPlayerMap.put(llllllllllllllllIIIIlIIlIllIlllI.getUniqueID(), llllllllllllllllIIIIlIIlIllIlllI);
        this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { llllllllllllllllIIIIlIIlIllIlllI }));
        final WorldServer llllllllllllllllIIIIlIIlIllIllIl = this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIllIlllI.dimension);
        for (int llllllllllllllllIIIIlIIlIllIllII = 0; llllllllllllllllIIIIlIIlIllIllII < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIlIllIllII) {
            llllllllllllllllIIIIlIIlIllIlllI.connection.sendPacket(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { this.playerEntityList.get(llllllllllllllllIIIIlIIlIllIllII) }));
        }
        llllllllllllllllIIIIlIIlIllIllIl.spawnEntityInWorld(llllllllllllllllIIIIlIIlIllIlllI);
        this.preparePlayer(llllllllllllllllIIIIlIIlIllIlllI, null);
    }
    
    public void func_193244_w() {
        for (final PlayerAdvancements llllllllllllllllIIIIIlllIIlllIlI : this.field_192055_p.values()) {
            llllllllllllllllIIIIIlllIIlllIlI.func_193766_b();
        }
    }
    
    public String[] getAllUsernames() {
        final String[] llllllllllllllllIIIIlIIIIlllIIlI = new String[this.playerEntityList.size()];
        for (int llllllllllllllllIIIIlIIIIlllIIIl = 0; llllllllllllllllIIIIlIIIIlllIIIl < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIIlllIIIl) {
            llllllllllllllllIIIIlIIIIlllIIlI[llllllllllllllllIIIIlIIIIlllIIIl] = this.playerEntityList.get(llllllllllllllllIIIIlIIIIlllIIIl).getName();
        }
        return llllllllllllllllIIIIlIIIIlllIIlI;
    }
    
    public EntityPlayerMP recreatePlayerEntity(final EntityPlayerMP llllllllllllllllIIIIlIIlIIIIllll, final int llllllllllllllllIIIIlIIlIIIllIll, final boolean llllllllllllllllIIIIlIIlIIIIllIl) {
        llllllllllllllllIIIIlIIlIIIIllll.getServerWorld().getEntityTracker().removePlayerFromTrackers(llllllllllllllllIIIIlIIlIIIIllll);
        llllllllllllllllIIIIlIIlIIIIllll.getServerWorld().getEntityTracker().untrackEntity(llllllllllllllllIIIIlIIlIIIIllll);
        llllllllllllllllIIIIlIIlIIIIllll.getServerWorld().getPlayerChunkMap().removePlayer(llllllllllllllllIIIIlIIlIIIIllll);
        this.playerEntityList.remove(llllllllllllllllIIIIlIIlIIIIllll);
        this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension).removeEntityDangerously(llllllllllllllllIIIIlIIlIIIIllll);
        final BlockPos llllllllllllllllIIIIlIIlIIIllIIl = llllllllllllllllIIIIlIIlIIIIllll.getBedLocation();
        final boolean llllllllllllllllIIIIlIIlIIIllIII = llllllllllllllllIIIIlIIlIIIIllll.isSpawnForced();
        llllllllllllllllIIIIlIIlIIIIllll.dimension = llllllllllllllllIIIIlIIlIIIllIll;
        PlayerInteractionManager llllllllllllllllIIIIlIIlIIIlIllI = null;
        if (this.mcServer.isDemo()) {
            final PlayerInteractionManager llllllllllllllllIIIIlIIlIIIlIlll = new DemoPlayerInteractionManager(this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension));
        }
        else {
            llllllllllllllllIIIIlIIlIIIlIllI = new PlayerInteractionManager(this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension));
        }
        final EntityPlayerMP llllllllllllllllIIIIlIIlIIIlIlIl = new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension), llllllllllllllllIIIIlIIlIIIIllll.getGameProfile(), llllllllllllllllIIIIlIIlIIIlIllI);
        llllllllllllllllIIIIlIIlIIIlIlIl.connection = llllllllllllllllIIIIlIIlIIIIllll.connection;
        llllllllllllllllIIIIlIIlIIIlIlIl.func_193104_a(llllllllllllllllIIIIlIIlIIIIllll, llllllllllllllllIIIIlIIlIIIIllIl);
        llllllllllllllllIIIIlIIlIIIlIlIl.setEntityId(llllllllllllllllIIIIlIIlIIIIllll.getEntityId());
        llllllllllllllllIIIIlIIlIIIlIlIl.setCommandStats(llllllllllllllllIIIIlIIlIIIIllll);
        llllllllllllllllIIIIlIIlIIIlIlIl.setPrimaryHand(llllllllllllllllIIIIlIIlIIIIllll.getPrimaryHand());
        for (final String llllllllllllllllIIIIlIIlIIIlIlII : llllllllllllllllIIIIlIIlIIIIllll.getTags()) {
            llllllllllllllllIIIIlIIlIIIlIlIl.addTag(llllllllllllllllIIIIlIIlIIIlIlII);
        }
        final WorldServer llllllllllllllllIIIIlIIlIIIlIIll = this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension);
        this.setPlayerGameTypeBasedOnOther(llllllllllllllllIIIIlIIlIIIlIlIl, llllllllllllllllIIIIlIIlIIIIllll, llllllllllllllllIIIIlIIlIIIlIIll);
        if (llllllllllllllllIIIIlIIlIIIllIIl != null) {
            final BlockPos llllllllllllllllIIIIlIIlIIIlIIlI = EntityPlayer.getBedSpawnLocation(this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlIIIIllll.dimension), llllllllllllllllIIIIlIIlIIIllIIl, llllllllllllllllIIIIlIIlIIIllIII);
            if (llllllllllllllllIIIIlIIlIIIlIIlI != null) {
                llllllllllllllllIIIIlIIlIIIlIlIl.setLocationAndAngles(llllllllllllllllIIIIlIIlIIIlIIlI.getX() + 0.5f, llllllllllllllllIIIIlIIlIIIlIIlI.getY() + 0.1f, llllllllllllllllIIIIlIIlIIIlIIlI.getZ() + 0.5f, 0.0f, 0.0f);
                llllllllllllllllIIIIlIIlIIIlIlIl.setSpawnPoint(llllllllllllllllIIIIlIIlIIIllIIl, llllllllllllllllIIIIlIIlIIIllIII);
            }
            else {
                llllllllllllllllIIIIlIIlIIIlIlIl.connection.sendPacket(new SPacketChangeGameState(0, 0.0f));
            }
        }
        llllllllllllllllIIIIlIIlIIIlIIll.getChunkProvider().provideChunk((int)llllllllllllllllIIIIlIIlIIIlIlIl.posX >> 4, (int)llllllllllllllllIIIIlIIlIIIlIlIl.posZ >> 4);
        while (!llllllllllllllllIIIIlIIlIIIlIIll.getCollisionBoxes(llllllllllllllllIIIIlIIlIIIlIlIl, llllllllllllllllIIIIlIIlIIIlIlIl.getEntityBoundingBox()).isEmpty() && llllllllllllllllIIIIlIIlIIIlIlIl.posY < 256.0) {
            llllllllllllllllIIIIlIIlIIIlIlIl.setPosition(llllllllllllllllIIIIlIIlIIIlIlIl.posX, llllllllllllllllIIIIlIIlIIIlIlIl.posY + 1.0, llllllllllllllllIIIIlIIlIIIlIlIl.posZ);
        }
        llllllllllllllllIIIIlIIlIIIlIlIl.connection.sendPacket(new SPacketRespawn(llllllllllllllllIIIIlIIlIIIlIlIl.dimension, llllllllllllllllIIIIlIIlIIIlIlIl.world.getDifficulty(), llllllllllllllllIIIIlIIlIIIlIlIl.world.getWorldInfo().getTerrainType(), llllllllllllllllIIIIlIIlIIIlIlIl.interactionManager.getGameType()));
        final BlockPos llllllllllllllllIIIIlIIlIIIlIIIl = llllllllllllllllIIIIlIIlIIIlIIll.getSpawnPoint();
        llllllllllllllllIIIIlIIlIIIlIlIl.connection.setPlayerLocation(llllllllllllllllIIIIlIIlIIIlIlIl.posX, llllllllllllllllIIIIlIIlIIIlIlIl.posY, llllllllllllllllIIIIlIIlIIIlIlIl.posZ, llllllllllllllllIIIIlIIlIIIlIlIl.rotationYaw, llllllllllllllllIIIIlIIlIIIlIlIl.rotationPitch);
        llllllllllllllllIIIIlIIlIIIlIlIl.connection.sendPacket(new SPacketSpawnPosition(llllllllllllllllIIIIlIIlIIIlIIIl));
        llllllllllllllllIIIIlIIlIIIlIlIl.connection.sendPacket(new SPacketSetExperience(llllllllllllllllIIIIlIIlIIIlIlIl.experience, llllllllllllllllIIIIlIIlIIIlIlIl.experienceTotal, llllllllllllllllIIIIlIIlIIIlIlIl.experienceLevel));
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIIlIIlIIIlIlIl, llllllllllllllllIIIIlIIlIIIlIIll);
        this.updatePermissionLevel(llllllllllllllllIIIIlIIlIIIlIlIl);
        llllllllllllllllIIIIlIIlIIIlIIll.getPlayerChunkMap().addPlayer(llllllllllllllllIIIIlIIlIIIlIlIl);
        llllllllllllllllIIIIlIIlIIIlIIll.spawnEntityInWorld(llllllllllllllllIIIIlIIlIIIlIlIl);
        this.playerEntityList.add(llllllllllllllllIIIIlIIlIIIlIlIl);
        this.uuidToPlayerMap.put(llllllllllllllllIIIIlIIlIIIlIlIl.getUniqueID(), llllllllllllllllIIIIlIIlIIIlIlIl);
        llllllllllllllllIIIIlIIlIIIlIlIl.addSelfToInternalCraftingInventory();
        llllllllllllllllIIIIlIIlIIIlIlIl.setHealth(llllllllllllllllIIIIlIIlIIIlIlIl.getHealth());
        return llllllllllllllllIIIIlIIlIIIlIlIl;
    }
    
    @Nullable
    public EntityPlayerMP getPlayerByUsername(final String llllllllllllllllIIIIlIIIIIlIllll) {
        for (final EntityPlayerMP llllllllllllllllIIIIlIIIIIllIIIl : this.playerEntityList) {
            if (llllllllllllllllIIIIlIIIIIllIIIl.getName().equalsIgnoreCase(llllllllllllllllIIIIlIIIIIlIllll)) {
                return llllllllllllllllIIIIlIIIIIllIIIl;
            }
        }
        return null;
    }
    
    public List<EntityPlayerMP> getPlayersMatchingAddress(final String llllllllllllllllIIIIIllllIlllIlI) {
        final List<EntityPlayerMP> llllllllllllllllIIIIIllllIllllIl = (List<EntityPlayerMP>)Lists.newArrayList();
        for (final EntityPlayerMP llllllllllllllllIIIIIllllIllllII : this.playerEntityList) {
            if (llllllllllllllllIIIIIllllIllllII.getPlayerIP().equals(llllllllllllllllIIIIIllllIlllIlI)) {
                llllllllllllllllIIIIIllllIllllIl.add(llllllllllllllllIIIIIllllIllllII);
            }
        }
        return llllllllllllllllIIIIIllllIllllIl;
    }
    
    protected void sendScoreboard(final ServerScoreboard llllllllllllllllIIIIlIIllIlIllIl, final EntityPlayerMP llllllllllllllllIIIIlIIllIlIllII) {
        final Set<ScoreObjective> llllllllllllllllIIIIlIIllIlIlIll = (Set<ScoreObjective>)Sets.newHashSet();
        for (final ScorePlayerTeam llllllllllllllllIIIIlIIllIlIlIlI : llllllllllllllllIIIIlIIllIlIllIl.getTeams()) {
            llllllllllllllllIIIIlIIllIlIllII.connection.sendPacket(new SPacketTeams(llllllllllllllllIIIIlIIllIlIlIlI, 0));
        }
        for (int llllllllllllllllIIIIlIIllIlIlIIl = 0; llllllllllllllllIIIIlIIllIlIlIIl < 19; ++llllllllllllllllIIIIlIIllIlIlIIl) {
            final ScoreObjective llllllllllllllllIIIIlIIllIlIlIII = llllllllllllllllIIIIlIIllIlIllIl.getObjectiveInDisplaySlot(llllllllllllllllIIIIlIIllIlIlIIl);
            if (llllllllllllllllIIIIlIIllIlIlIII != null && !llllllllllllllllIIIIlIIllIlIlIll.contains(llllllllllllllllIIIIlIIllIlIlIII)) {
                for (final Packet<?> llllllllllllllllIIIIlIIllIlIIlll : llllllllllllllllIIIIlIIllIlIllIl.getCreatePackets(llllllllllllllllIIIIlIIllIlIlIII)) {
                    llllllllllllllllIIIIlIIllIlIllII.connection.sendPacket(llllllllllllllllIIIIlIIllIlIIlll);
                }
                llllllllllllllllIIIIlIIllIlIlIll.add(llllllllllllllllIIIIlIIllIlIlIII);
            }
        }
    }
    
    public void setCommandsAllowedForAll(final boolean llllllllllllllllIIIIIllllIIllIII) {
        this.commandsAllowedForAll = llllllllllllllllIIIIIllllIIllIII;
    }
    
    public void sendToAllNearExcept(@Nullable final EntityPlayer llllllllllllllllIIIIlIIIIIIllllI, final double llllllllllllllllIIIIlIIIIIIlIIII, final double llllllllllllllllIIIIlIIIIIIlllII, final double llllllllllllllllIIIIlIIIIIIllIll, final double llllllllllllllllIIIIlIIIIIIIllIl, final int llllllllllllllllIIIIlIIIIIIIllII, final Packet<?> llllllllllllllllIIIIlIIIIIIllIII) {
        for (int llllllllllllllllIIIIlIIIIIIlIlll = 0; llllllllllllllllIIIIlIIIIIIlIlll < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIIIIlIlll) {
            final EntityPlayerMP llllllllllllllllIIIIlIIIIIIlIllI = this.playerEntityList.get(llllllllllllllllIIIIlIIIIIIlIlll);
            if (llllllllllllllllIIIIlIIIIIIlIllI != llllllllllllllllIIIIlIIIIIIllllI && llllllllllllllllIIIIlIIIIIIlIllI.dimension == llllllllllllllllIIIIlIIIIIIIllII) {
                final double llllllllllllllllIIIIlIIIIIIlIlIl = llllllllllllllllIIIIlIIIIIIlIIII - llllllllllllllllIIIIlIIIIIIlIllI.posX;
                final double llllllllllllllllIIIIlIIIIIIlIlII = llllllllllllllllIIIIlIIIIIIlllII - llllllllllllllllIIIIlIIIIIIlIllI.posY;
                final double llllllllllllllllIIIIlIIIIIIlIIll = llllllllllllllllIIIIlIIIIIIllIll - llllllllllllllllIIIIlIIIIIIlIllI.posZ;
                if (llllllllllllllllIIIIlIIIIIIlIlIl * llllllllllllllllIIIIlIIIIIIlIlIl + llllllllllllllllIIIIlIIIIIIlIlII * llllllllllllllllIIIIlIIIIIIlIlII + llllllllllllllllIIIIlIIIIIIlIIll * llllllllllllllllIIIIlIIIIIIlIIll < llllllllllllllllIIIIlIIIIIIIllIl * llllllllllllllllIIIIlIIIIIIIllIl) {
                    llllllllllllllllIIIIlIIIIIIlIllI.connection.sendPacket(llllllllllllllllIIIIlIIIIIIllIII);
                }
            }
        }
    }
    
    public void reloadWhitelist() {
    }
    
    public StatisticsManagerServer getPlayerStatsFile(final EntityPlayer llllllllllllllllIIIIIlllIlllIlll) {
        final UUID llllllllllllllllIIIIIlllIlllIllI = llllllllllllllllIIIIIlllIlllIlll.getUniqueID();
        StatisticsManagerServer llllllllllllllllIIIIIlllIlllIlIl = (llllllllllllllllIIIIIlllIlllIllI == null) ? null : this.playerStatFiles.get(llllllllllllllllIIIIIlllIlllIllI);
        if (llllllllllllllllIIIIIlllIlllIlIl == null) {
            final File llllllllllllllllIIIIIlllIlllIlII = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "stats");
            final File llllllllllllllllIIIIIlllIlllIIll = new File(llllllllllllllllIIIIIlllIlllIlII, String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIlllIlllIllI).append(".json")));
            if (!llllllllllllllllIIIIIlllIlllIIll.exists()) {
                final File llllllllllllllllIIIIIlllIlllIIlI = new File(llllllllllllllllIIIIIlllIlllIlII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIIlllIlllIlll.getName())).append(".json")));
                if (llllllllllllllllIIIIIlllIlllIIlI.exists() && llllllllllllllllIIIIIlllIlllIIlI.isFile()) {
                    llllllllllllllllIIIIIlllIlllIIlI.renameTo(llllllllllllllllIIIIIlllIlllIIll);
                }
            }
            llllllllllllllllIIIIIlllIlllIlIl = new StatisticsManagerServer(this.mcServer, llllllllllllllllIIIIIlllIlllIIll);
            llllllllllllllllIIIIIlllIlllIlIl.readStatFile();
            this.playerStatFiles.put(llllllllllllllllIIIIIlllIlllIllI, llllllllllllllllIIIIIlllIlllIlIl);
        }
        return llllllllllllllllIIIIIlllIlllIlIl;
    }
    
    public void sendMessageToAllTeamMembers(final EntityPlayer llllllllllllllllIIIIlIIIlIlIIIll, final ITextComponent llllllllllllllllIIIIlIIIlIlIIIlI) {
        final Team llllllllllllllllIIIIlIIIlIlIIIIl = llllllllllllllllIIIIlIIIlIlIIIll.getTeam();
        if (llllllllllllllllIIIIlIIIlIlIIIIl != null) {
            for (final String llllllllllllllllIIIIlIIIlIlIIIII : llllllllllllllllIIIIlIIIlIlIIIIl.getMembershipCollection()) {
                final EntityPlayerMP llllllllllllllllIIIIlIIIlIIlllll = this.getPlayerByUsername(llllllllllllllllIIIIlIIIlIlIIIII);
                if (llllllllllllllllIIIIlIIIlIIlllll != null && llllllllllllllllIIIIlIIIlIIlllll != llllllllllllllllIIIIlIIIlIlIIIll) {
                    llllllllllllllllIIIIlIIIlIIlllll.addChatMessage(llllllllllllllllIIIIlIIIlIlIIIlI);
                }
            }
        }
    }
    
    static {
        FILE_PLAYERBANS = new File("banned-players.json");
        FILE_IPBANS = new File("banned-ips.json");
        FILE_OPS = new File("ops.json");
        FILE_WHITELIST = new File("whitelist.json");
        LOG = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    }
    
    public EntityPlayerMP getPlayerByUUID(final UUID llllllllllllllllIIIIIlllIlIIIIIl) {
        return this.uuidToPlayerMap.get(llllllllllllllllIIIIIlllIlIIIIIl);
    }
    
    public void sendPacketToAllPlayersInDimension(final Packet<?> llllllllllllllllIIIIlIIIlIllIlII, final int llllllllllllllllIIIIlIIIlIlIlllI) {
        for (int llllllllllllllllIIIIlIIIlIllIIlI = 0; llllllllllllllllIIIIlIIIlIllIIlI < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIlIllIIlI) {
            final EntityPlayerMP llllllllllllllllIIIIlIIIlIllIIIl = this.playerEntityList.get(llllllllllllllllIIIIlIIIlIllIIlI);
            if (llllllllllllllllIIIIlIIIlIllIIIl.dimension == llllllllllllllllIIIIlIIIlIlIlllI) {
                llllllllllllllllIIIIlIIIlIllIIIl.connection.sendPacket(llllllllllllllllIIIIlIIIlIllIlII);
            }
        }
    }
    
    @Nullable
    public NBTTagCompound readPlayerDataFromFile(final EntityPlayerMP llllllllllllllllIIIIlIIllIIIIIlI) {
        final NBTTagCompound llllllllllllllllIIIIlIIllIIIIllI = this.mcServer.worldServers[0].getWorldInfo().getPlayerNBTTagCompound();
        NBTTagCompound llllllllllllllllIIIIlIIllIIIIlII = null;
        if (llllllllllllllllIIIIlIIllIIIIIlI.getName().equals(this.mcServer.getServerOwner()) && llllllllllllllllIIIIlIIllIIIIllI != null) {
            final NBTTagCompound llllllllllllllllIIIIlIIllIIIIlIl = llllllllllllllllIIIIlIIllIIIIllI;
            llllllllllllllllIIIIlIIllIIIIIlI.readFromNBT(llllllllllllllllIIIIlIIllIIIIllI);
            PlayerList.LOG.debug("loading single player");
        }
        else {
            llllllllllllllllIIIIlIIllIIIIlII = this.playerNBTManagerObj.readPlayerData(llllllllllllllllIIIIlIIllIIIIIlI);
        }
        return llllllllllllllllIIIIlIIllIIIIlII;
    }
    
    public MinecraftServer getServerInstance() {
        return this.mcServer;
    }
    
    public void sendPacketToAllPlayers(final Packet<?> llllllllllllllllIIIIlIIIlIllllll) {
        for (int llllllllllllllllIIIIlIIIlIlllllI = 0; llllllllllllllllIIIIlIIIlIlllllI < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIlIlllllI) {
            this.playerEntityList.get(llllllllllllllllIIIIlIIIlIlllllI).connection.sendPacket(llllllllllllllllIIIIlIIIlIllllll);
        }
    }
    
    public void transferEntityToWorld(final Entity llllllllllllllllIIIIlIIIllIIllll, final int llllllllllllllllIIIIlIIIllIllIII, final WorldServer llllllllllllllllIIIIlIIIllIIllIl, final WorldServer llllllllllllllllIIIIlIIIllIIllII) {
        double llllllllllllllllIIIIlIIIllIlIlIl = llllllllllllllllIIIIlIIIllIIllll.posX;
        double llllllllllllllllIIIIlIIIllIlIlII = llllllllllllllllIIIIlIIIllIIllll.posZ;
        final double llllllllllllllllIIIIlIIIllIlIIll = 8.0;
        final float llllllllllllllllIIIIlIIIllIlIIlI = llllllllllllllllIIIIlIIIllIIllll.rotationYaw;
        llllllllllllllllIIIIlIIIllIIllIl.theProfiler.startSection("moving");
        if (llllllllllllllllIIIIlIIIllIIllll.dimension == -1) {
            llllllllllllllllIIIIlIIIllIlIlIl = MathHelper.clamp(llllllllllllllllIIIIlIIIllIlIlIl / 8.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().minX() + 16.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().maxX() - 16.0);
            llllllllllllllllIIIIlIIIllIlIlII = MathHelper.clamp(llllllllllllllllIIIIlIIIllIlIlII / 8.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().minZ() + 16.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().maxZ() - 16.0);
            llllllllllllllllIIIIlIIIllIIllll.setLocationAndAngles(llllllllllllllllIIIIlIIIllIlIlIl, llllllllllllllllIIIIlIIIllIIllll.posY, llllllllllllllllIIIIlIIIllIlIlII, llllllllllllllllIIIIlIIIllIIllll.rotationYaw, llllllllllllllllIIIIlIIIllIIllll.rotationPitch);
            if (llllllllllllllllIIIIlIIIllIIllll.isEntityAlive()) {
                llllllllllllllllIIIIlIIIllIIllIl.updateEntityWithOptionalForce(llllllllllllllllIIIIlIIIllIIllll, false);
            }
        }
        else if (llllllllllllllllIIIIlIIIllIIllll.dimension == 0) {
            llllllllllllllllIIIIlIIIllIlIlIl = MathHelper.clamp(llllllllllllllllIIIIlIIIllIlIlIl * 8.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().minX() + 16.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().maxX() - 16.0);
            llllllllllllllllIIIIlIIIllIlIlII = MathHelper.clamp(llllllllllllllllIIIIlIIIllIlIlII * 8.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().minZ() + 16.0, llllllllllllllllIIIIlIIIllIIllII.getWorldBorder().maxZ() - 16.0);
            llllllllllllllllIIIIlIIIllIIllll.setLocationAndAngles(llllllllllllllllIIIIlIIIllIlIlIl, llllllllllllllllIIIIlIIIllIIllll.posY, llllllllllllllllIIIIlIIIllIlIlII, llllllllllllllllIIIIlIIIllIIllll.rotationYaw, llllllllllllllllIIIIlIIIllIIllll.rotationPitch);
            if (llllllllllllllllIIIIlIIIllIIllll.isEntityAlive()) {
                llllllllllllllllIIIIlIIIllIIllIl.updateEntityWithOptionalForce(llllllllllllllllIIIIlIIIllIIllll, false);
            }
        }
        else {
            BlockPos llllllllllllllllIIIIlIIIllIlIIII = null;
            if (llllllllllllllllIIIIlIIIllIllIII == 1) {
                final BlockPos llllllllllllllllIIIIlIIIllIlIIIl = llllllllllllllllIIIIlIIIllIIllII.getSpawnPoint();
            }
            else {
                llllllllllllllllIIIIlIIIllIlIIII = llllllllllllllllIIIIlIIIllIIllII.getSpawnCoordinate();
            }
            llllllllllllllllIIIIlIIIllIlIlIl = llllllllllllllllIIIIlIIIllIlIIII.getX();
            llllllllllllllllIIIIlIIIllIIllll.posY = llllllllllllllllIIIIlIIIllIlIIII.getY();
            llllllllllllllllIIIIlIIIllIlIlII = llllllllllllllllIIIIlIIIllIlIIII.getZ();
            llllllllllllllllIIIIlIIIllIIllll.setLocationAndAngles(llllllllllllllllIIIIlIIIllIlIlIl, llllllllllllllllIIIIlIIIllIIllll.posY, llllllllllllllllIIIIlIIIllIlIlII, 90.0f, 0.0f);
            if (llllllllllllllllIIIIlIIIllIIllll.isEntityAlive()) {
                llllllllllllllllIIIIlIIIllIIllIl.updateEntityWithOptionalForce(llllllllllllllllIIIIlIIIllIIllll, false);
            }
        }
        llllllllllllllllIIIIlIIIllIIllIl.theProfiler.endSection();
        if (llllllllllllllllIIIIlIIIllIllIII != 1) {
            llllllllllllllllIIIIlIIIllIIllIl.theProfiler.startSection("placing");
            llllllllllllllllIIIIlIIIllIlIlIl = MathHelper.clamp((int)llllllllllllllllIIIIlIIIllIlIlIl, -29999872, 29999872);
            llllllllllllllllIIIIlIIIllIlIlII = MathHelper.clamp((int)llllllllllllllllIIIIlIIIllIlIlII, -29999872, 29999872);
            if (llllllllllllllllIIIIlIIIllIIllll.isEntityAlive()) {
                llllllllllllllllIIIIlIIIllIIllll.setLocationAndAngles(llllllllllllllllIIIIlIIIllIlIlIl, llllllllllllllllIIIIlIIIllIIllll.posY, llllllllllllllllIIIIlIIIllIlIlII, llllllllllllllllIIIIlIIIllIIllll.rotationYaw, llllllllllllllllIIIIlIIIllIIllll.rotationPitch);
                llllllllllllllllIIIIlIIIllIIllII.getDefaultTeleporter().placeInPortal(llllllllllllllllIIIIlIIIllIIllll, llllllllllllllllIIIIlIIIllIlIIlI);
                llllllllllllllllIIIIlIIIllIIllII.spawnEntityInWorld(llllllllllllllllIIIIlIIIllIIllll);
                llllllllllllllllIIIIlIIIllIIllII.updateEntityWithOptionalForce(llllllllllllllllIIIIlIIIllIIllll, false);
            }
            llllllllllllllllIIIIlIIIllIIllIl.theProfiler.endSection();
        }
        llllllllllllllllIIIIlIIIllIIllll.setWorld(llllllllllllllllIIIIlIIIllIIllII);
    }
    
    public UserListWhitelist getWhitelistedPlayers() {
        return this.whiteListedPlayers;
    }
    
    public void removeOp(final GameProfile llllllllllllllllIIIIlIIIIlIlIIlI) {
        ((UserList<GameProfile, V>)this.ops).removeEntry(llllllllllllllllIIIIlIIIIlIlIIlI);
        this.sendPlayerPermissionLevel(this.getPlayerByUUID(llllllllllllllllIIIIlIIIIlIlIIlI.getId()), 0);
    }
    
    public PlayerList(final MinecraftServer llllllllllllllllIIIIlIIllllIlllI) {
        this.playerEntityList = (List<EntityPlayerMP>)Lists.newArrayList();
        this.uuidToPlayerMap = (Map<UUID, EntityPlayerMP>)Maps.newHashMap();
        this.bannedPlayers = new UserListBans(PlayerList.FILE_PLAYERBANS);
        this.bannedIPs = new UserListIPBans(PlayerList.FILE_IPBANS);
        this.ops = new UserListOps(PlayerList.FILE_OPS);
        this.whiteListedPlayers = new UserListWhitelist(PlayerList.FILE_WHITELIST);
        this.playerStatFiles = (Map<UUID, StatisticsManagerServer>)Maps.newHashMap();
        this.field_192055_p = (Map<UUID, PlayerAdvancements>)Maps.newHashMap();
        this.mcServer = llllllllllllllllIIIIlIIllllIlllI;
        this.bannedPlayers.setLanServer(false);
        this.bannedIPs.setLanServer(false);
        this.maxPlayers = 8;
    }
    
    public void preparePlayer(final EntityPlayerMP llllllllllllllllIIIIlIIllIIlIIlI, @Nullable final WorldServer llllllllllllllllIIIIlIIllIIlIlII) {
        final WorldServer llllllllllllllllIIIIlIIllIIlIIll = llllllllllllllllIIIIlIIllIIlIIlI.getServerWorld();
        if (llllllllllllllllIIIIlIIllIIlIlII != null) {
            llllllllllllllllIIIIlIIllIIlIlII.getPlayerChunkMap().removePlayer(llllllllllllllllIIIIlIIllIIlIIlI);
        }
        llllllllllllllllIIIIlIIllIIlIIll.getPlayerChunkMap().addPlayer(llllllllllllllllIIIIlIIllIIlIIlI);
        llllllllllllllllIIIIlIIllIIlIIll.getChunkProvider().provideChunk((int)llllllllllllllllIIIIlIIllIIlIIlI.posX >> 4, (int)llllllllllllllllIIIIlIIllIIlIIlI.posZ >> 4);
        if (llllllllllllllllIIIIlIIllIIlIlII != null) {
            CriteriaTriggers.field_193134_u.func_193143_a(llllllllllllllllIIIIlIIllIIlIIlI, llllllllllllllllIIIIlIIllIIlIlII.provider.getDimensionType(), llllllllllllllllIIIIlIIllIIlIIll.provider.getDimensionType());
            if (llllllllllllllllIIIIlIIllIIlIlII.provider.getDimensionType() == DimensionType.NETHER && llllllllllllllllIIIIlIIllIIlIIlI.world.provider.getDimensionType() == DimensionType.OVERWORLD && llllllllllllllllIIIIlIIllIIlIIlI.func_193106_Q() != null) {
                CriteriaTriggers.field_193131_B.func_193168_a(llllllllllllllllIIIIlIIllIIlIIlI, llllllllllllllllIIIIlIIllIIlIIlI.func_193106_Q());
            }
        }
    }
    
    public GameProfile[] getAllProfiles() {
        final GameProfile[] llllllllllllllllIIIIlIIIIllIlIIl = new GameProfile[this.playerEntityList.size()];
        for (int llllllllllllllllIIIIlIIIIllIlIII = 0; llllllllllllllllIIIIlIIIIllIlIII < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIIllIlIII) {
            llllllllllllllllIIIIlIIIIllIlIIl[llllllllllllllllIIIIlIIIIllIlIII] = this.playerEntityList.get(llllllllllllllllIIIIlIIIIllIlIII).getGameProfile();
        }
        return llllllllllllllllIIIIlIIIIllIlIIl;
    }
    
    public String getFormattedListOfPlayers(final boolean llllllllllllllllIIIIlIIIIllllIlI) {
        String llllllllllllllllIIIIlIIIIllllllI = "";
        final List<EntityPlayerMP> llllllllllllllllIIIIlIIIIlllllIl = (List<EntityPlayerMP>)Lists.newArrayList((Iterable)this.playerEntityList);
        for (int llllllllllllllllIIIIlIIIIlllllII = 0; llllllllllllllllIIIIlIIIIlllllII < llllllllllllllllIIIIlIIIIlllllIl.size(); ++llllllllllllllllIIIIlIIIIlllllII) {
            if (llllllllllllllllIIIIlIIIIlllllII > 0) {
                llllllllllllllllIIIIlIIIIllllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIIIllllllI)).append(", "));
            }
            llllllllllllllllIIIIlIIIIllllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIIIllllllI)).append(llllllllllllllllIIIIlIIIIlllllIl.get(llllllllllllllllIIIIlIIIIlllllII).getName()));
            if (llllllllllllllllIIIIlIIIIllllIlI) {
                llllllllllllllllIIIIlIIIIllllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIIIllllllI)).append(" (").append(llllllllllllllllIIIIlIIIIlllllIl.get(llllllllllllllllIIIIlIIIIlllllII).getCachedUniqueIdString()).append(")"));
            }
        }
        return llllllllllllllllIIIIlIIIIllllllI;
    }
    
    public void syncPlayerInventory(final EntityPlayerMP llllllllllllllllIIIIIlllllIlIlII) {
        llllllllllllllllIIIIIlllllIlIlII.sendContainerToPlayer(llllllllllllllllIIIIIlllllIlIlII.inventoryContainer);
        llllllllllllllllIIIIIlllllIlIlII.setPlayerHealthUpdated();
        llllllllllllllllIIIIIlllllIlIlII.connection.sendPacket(new SPacketHeldItemChange(llllllllllllllllIIIIIlllllIlIlII.inventory.currentItem));
    }
    
    public void playerLoggedOut(final EntityPlayerMP llllllllllllllllIIIIlIIlIlIlIlIl) {
        final WorldServer llllllllllllllllIIIIlIIlIlIllIll = llllllllllllllllIIIIlIIlIlIlIlIl.getServerWorld();
        llllllllllllllllIIIIlIIlIlIlIlIl.addStat(StatList.LEAVE_GAME);
        this.writePlayerData(llllllllllllllllIIIIlIIlIlIlIlIl);
        if (llllllllllllllllIIIIlIIlIlIlIlIl.isRiding()) {
            final Entity llllllllllllllllIIIIlIIlIlIllIlI = llllllllllllllllIIIIlIIlIlIlIlIl.getLowestRidingEntity();
            if (llllllllllllllllIIIIlIIlIlIllIlI.getRecursivePassengersByType(EntityPlayerMP.class).size() == 1) {
                PlayerList.LOG.debug("Removing player mount");
                llllllllllllllllIIIIlIIlIlIlIlIl.dismountRidingEntity();
                llllllllllllllllIIIIlIIlIlIllIll.removeEntityDangerously(llllllllllllllllIIIIlIIlIlIllIlI);
                for (final Entity llllllllllllllllIIIIlIIlIlIllIIl : llllllllllllllllIIIIlIIlIlIllIlI.getRecursivePassengers()) {
                    llllllllllllllllIIIIlIIlIlIllIll.removeEntityDangerously(llllllllllllllllIIIIlIIlIlIllIIl);
                }
                llllllllllllllllIIIIlIIlIlIllIll.getChunkFromChunkCoords(llllllllllllllllIIIIlIIlIlIlIlIl.chunkCoordX, llllllllllllllllIIIIlIIlIlIlIlIl.chunkCoordZ).setChunkModified();
            }
        }
        llllllllllllllllIIIIlIIlIlIllIll.removeEntity(llllllllllllllllIIIIlIIlIlIlIlIl);
        llllllllllllllllIIIIlIIlIlIllIll.getPlayerChunkMap().removePlayer(llllllllllllllllIIIIlIIlIlIlIlIl);
        llllllllllllllllIIIIlIIlIlIlIlIl.func_192039_O().func_192745_a();
        this.playerEntityList.remove(llllllllllllllllIIIIlIIlIlIlIlIl);
        final UUID llllllllllllllllIIIIlIIlIlIllIII = llllllllllllllllIIIIlIIlIlIlIlIl.getUniqueID();
        final EntityPlayerMP llllllllllllllllIIIIlIIlIlIlIlll = this.uuidToPlayerMap.get(llllllllllllllllIIIIlIIlIlIllIII);
        if (llllllllllllllllIIIIlIIlIlIlIlll == llllllllllllllllIIIIlIIlIlIlIlIl) {
            this.uuidToPlayerMap.remove(llllllllllllllllIIIIlIIlIlIllIII);
            this.playerStatFiles.remove(llllllllllllllllIIIIlIIlIlIllIII);
            this.field_192055_p.remove(llllllllllllllllIIIIlIIlIlIllIII);
        }
        this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.REMOVE_PLAYER, new EntityPlayerMP[] { llllllllllllllllIIIIlIIlIlIlIlIl }));
    }
    
    public void sendChatMsgImpl(final ITextComponent llllllllllllllllIIIIIllllIIIlIII, final boolean llllllllllllllllIIIIIllllIIIIlll) {
        this.mcServer.addChatMessage(llllllllllllllllIIIIIllllIIIlIII);
        final ChatType llllllllllllllllIIIIIllllIIIlIlI = llllllllllllllllIIIIIllllIIIIlll ? ChatType.SYSTEM : ChatType.CHAT;
        this.sendPacketToAllPlayers(new SPacketChat(llllllllllllllllIIIIIllllIIIlIII, llllllllllllllllIIIIIllllIIIlIlI));
    }
    
    public UserListOps getOppedPlayers() {
        return this.ops;
    }
    
    public int getEntityViewDistance() {
        return PlayerChunkMap.getFurthestViewableBlock(this.getViewDistance());
    }
    
    public void setGameType(final GameType llllllllllllllllIIIIIllllIlIllII) {
        this.gameType = llllllllllllllllIIIIIllllIlIllII;
    }
    
    public void changePlayerDimension(final EntityPlayerMP llllllllllllllllIIIIlIIIlllIlIlI, final int llllllllllllllllIIIIlIIIlllIlIIl) {
        final int llllllllllllllllIIIIlIIIlllIllll = llllllllllllllllIIIIlIIIlllIlIlI.dimension;
        final WorldServer llllllllllllllllIIIIlIIIlllIlllI = this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIIlllIlIlI.dimension);
        llllllllllllllllIIIIlIIIlllIlIlI.dimension = llllllllllllllllIIIIlIIIlllIlIIl;
        final WorldServer llllllllllllllllIIIIlIIIlllIllIl = this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIIlllIlIlI.dimension);
        llllllllllllllllIIIIlIIIlllIlIlI.connection.sendPacket(new SPacketRespawn(llllllllllllllllIIIIlIIIlllIlIlI.dimension, llllllllllllllllIIIIlIIIlllIlIlI.world.getDifficulty(), llllllllllllllllIIIIlIIIlllIlIlI.world.getWorldInfo().getTerrainType(), llllllllllllllllIIIIlIIIlllIlIlI.interactionManager.getGameType()));
        this.updatePermissionLevel(llllllllllllllllIIIIlIIIlllIlIlI);
        llllllllllllllllIIIIlIIIlllIlllI.removeEntityDangerously(llllllllllllllllIIIIlIIIlllIlIlI);
        llllllllllllllllIIIIlIIIlllIlIlI.isDead = false;
        this.transferEntityToWorld(llllllllllllllllIIIIlIIIlllIlIlI, llllllllllllllllIIIIlIIIlllIllll, llllllllllllllllIIIIlIIIlllIlllI, llllllllllllllllIIIIlIIIlllIllIl);
        this.preparePlayer(llllllllllllllllIIIIlIIIlllIlIlI, llllllllllllllllIIIIlIIIlllIlllI);
        llllllllllllllllIIIIlIIIlllIlIlI.connection.setPlayerLocation(llllllllllllllllIIIIlIIIlllIlIlI.posX, llllllllllllllllIIIIlIIIlllIlIlI.posY, llllllllllllllllIIIIlIIIlllIlIlI.posZ, llllllllllllllllIIIIlIIIlllIlIlI.rotationYaw, llllllllllllllllIIIIlIIIlllIlIlI.rotationPitch);
        llllllllllllllllIIIIlIIIlllIlIlI.interactionManager.setWorld(llllllllllllllllIIIIlIIIlllIllIl);
        llllllllllllllllIIIIlIIIlllIlIlI.connection.sendPacket(new SPacketPlayerAbilities(llllllllllllllllIIIIlIIIlllIlIlI.capabilities));
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIIlIIIlllIlIlI, llllllllllllllllIIIIlIIIlllIllIl);
        this.syncPlayerInventory(llllllllllllllllIIIIlIIIlllIlIlI);
        for (final PotionEffect llllllllllllllllIIIIlIIIlllIllII : llllllllllllllllIIIIlIIIlllIlIlI.getActivePotionEffects()) {
            llllllllllllllllIIIIlIIIlllIlIlI.connection.sendPacket(new SPacketEntityEffect(llllllllllllllllIIIIlIIIlllIlIlI.getEntityId(), llllllllllllllllIIIIlIIIlllIllII));
        }
    }
    
    public PlayerAdvancements func_192054_h(final EntityPlayerMP llllllllllllllllIIIIIlllIlIlllIl) {
        final UUID llllllllllllllllIIIIIlllIllIIIlI = llllllllllllllllIIIIIlllIlIlllIl.getUniqueID();
        PlayerAdvancements llllllllllllllllIIIIIlllIllIIIIl = this.field_192055_p.get(llllllllllllllllIIIIIlllIllIIIlI);
        if (llllllllllllllllIIIIIlllIllIIIIl == null) {
            final File llllllllllllllllIIIIIlllIllIIIII = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "advancements");
            final File llllllllllllllllIIIIIlllIlIlllll = new File(llllllllllllllllIIIIIlllIllIIIII, String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIlllIllIIIlI).append(".json")));
            llllllllllllllllIIIIIlllIllIIIIl = new PlayerAdvancements(this.mcServer, llllllllllllllllIIIIIlllIlIlllll, llllllllllllllllIIIIIlllIlIlllIl);
            this.field_192055_p.put(llllllllllllllllIIIIIlllIllIIIlI, llllllllllllllllIIIIIlllIllIIIIl);
        }
        llllllllllllllllIIIIIlllIllIIIIl.func_192739_a(llllllllllllllllIIIIIlllIlIlllIl);
        return llllllllllllllllIIIIIlllIllIIIIl;
    }
    
    public void onTick() {
        if (++this.playerPingIndex > 600) {
            this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.UPDATE_LATENCY, this.playerEntityList));
            this.playerPingIndex = 0;
        }
    }
    
    public void sendMessageToTeamOrAllPlayers(final EntityPlayer llllllllllllllllIIIIlIIIlIIlIIII, final ITextComponent llllllllllllllllIIIIlIIIlIIIlIIl) {
        final Team llllllllllllllllIIIIlIIIlIIIlllI = llllllllllllllllIIIIlIIIlIIlIIII.getTeam();
        if (llllllllllllllllIIIIlIIIlIIIlllI == null) {
            this.sendChatMsg(llllllllllllllllIIIIlIIIlIIIlIIl);
        }
        else {
            for (int llllllllllllllllIIIIlIIIlIIIllIl = 0; llllllllllllllllIIIIlIIIlIIIllIl < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIlIIIllIl) {
                final EntityPlayerMP llllllllllllllllIIIIlIIIlIIIllII = this.playerEntityList.get(llllllllllllllllIIIIlIIIlIIIllIl);
                if (llllllllllllllllIIIIlIIIlIIIllII.getTeam() != llllllllllllllllIIIIlIIIlIIIlllI) {
                    llllllllllllllllIIIIlIIIlIIIllII.addChatMessage(llllllllllllllllIIIIlIIIlIIIlIIl);
                }
            }
        }
    }
    
    public void sendChatMsg(final ITextComponent llllllllllllllllIIIIIllllIIIIIlI) {
        this.sendChatMsgImpl(llllllllllllllllIIIIIllllIIIIIlI, true);
    }
    
    public void addOp(final GameProfile llllllllllllllllIIIIlIIIIlIllIlI) {
        final int llllllllllllllllIIIIlIIIIlIllIIl = this.mcServer.getOpPermissionLevel();
        ((UserList<K, UserListOpsEntry>)this.ops).addEntry(new UserListOpsEntry(llllllllllllllllIIIIlIIIIlIllIlI, this.mcServer.getOpPermissionLevel(), this.ops.bypassesPlayerLimit(llllllllllllllllIIIIlIIIIlIllIlI)));
        this.sendPlayerPermissionLevel(this.getPlayerByUUID(llllllllllllllllIIIIlIIIIlIllIlI.getId()), llllllllllllllllIIIIlIIIIlIllIIl);
    }
    
    public void saveAllPlayerData() {
        for (int llllllllllllllllIIIIlIIIIIIIIIlI = 0; llllllllllllllllIIIIlIIIIIIIIIlI < this.playerEntityList.size(); ++llllllllllllllllIIIIlIIIIIIIIIlI) {
            this.writePlayerData(this.playerEntityList.get(llllllllllllllllIIIIlIIIIIIIIIlI));
        }
    }
    
    public UserListBans getBannedPlayers() {
        return this.bannedPlayers;
    }
    
    public void setPlayerManager(final WorldServer[] llllllllllllllllIIIIlIIllIIllIlI) {
        this.playerNBTManagerObj = llllllllllllllllIIIIlIIllIIllIlI[0].getSaveHandler().getPlayerNBTManager();
        llllllllllllllllIIIIlIIllIIllIlI[0].getWorldBorder().addListener(new IBorderListener() {
            @Override
            public void onWarningTimeChanged(final WorldBorder lllllllllllllllIllllIIlIIIIIIlII, final int lllllllllllllllIllllIIlIIIIIIIll) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(lllllllllllllllIllllIIlIIIIIIlII, SPacketWorldBorder.Action.SET_WARNING_TIME));
            }
            
            @Override
            public void onCenterChanged(final WorldBorder lllllllllllllllIllllIIlIIIIIlIII, final double lllllllllllllllIllllIIlIIIIIlIll, final double lllllllllllllllIllllIIlIIIIIlIlI) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(lllllllllllllllIllllIIlIIIIIlIII, SPacketWorldBorder.Action.SET_CENTER));
            }
            
            @Override
            public void onDamageAmountChanged(final WorldBorder lllllllllllllllIllllIIIllllllIII, final double lllllllllllllllIllllIIIlllllIlll) {
            }
            
            @Override
            public void onWarningDistanceChanged(final WorldBorder lllllllllllllllIllllIIIlllllllIl, final int lllllllllllllllIllllIIIlllllllII) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(lllllllllllllllIllllIIIlllllllIl, SPacketWorldBorder.Action.SET_WARNING_BLOCKS));
            }
            
            @Override
            public void onDamageBufferChanged(final WorldBorder lllllllllllllllIllllIIIlllllIlIl, final double lllllllllllllllIllllIIIlllllIlII) {
            }
            
            @Override
            public void onSizeChanged(final WorldBorder lllllllllllllllIllllIIlIIIIllIIl, final double lllllllllllllllIllllIIlIIIIllIll) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(lllllllllllllllIllllIIlIIIIllIIl, SPacketWorldBorder.Action.SET_SIZE));
            }
            
            @Override
            public void onTransitionStarted(final WorldBorder lllllllllllllllIllllIIlIIIIlIlIl, final double lllllllllllllllIllllIIlIIIIlIlII, final double lllllllllllllllIllllIIlIIIIlIIll, final long lllllllllllllllIllllIIlIIIIlIIlI) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(lllllllllllllllIllllIIlIIIIlIlIl, SPacketWorldBorder.Action.LERP_SIZE));
            }
        });
    }
    
    public void setWhiteListEnabled(final boolean llllllllllllllllIIIIIlllllIIIlIl) {
        this.whiteListEnforced = llllllllllllllllIIIIIlllllIIIlIl;
    }
    
    public void initializeConnectionToPlayer(final NetworkManager llllllllllllllllIIIIlIIlllIllIlI, final EntityPlayerMP llllllllllllllllIIIIlIIlllIIIlIl) {
        final GameProfile llllllllllllllllIIIIlIIlllIllIII = llllllllllllllllIIIIlIIlllIIIlIl.getGameProfile();
        final PlayerProfileCache llllllllllllllllIIIIlIIlllIlIlll = this.mcServer.getPlayerProfileCache();
        final GameProfile llllllllllllllllIIIIlIIlllIlIllI = llllllllllllllllIIIIlIIlllIlIlll.getProfileByUUID(llllllllllllllllIIIIlIIlllIllIII.getId());
        final String llllllllllllllllIIIIlIIlllIlIlIl = (llllllllllllllllIIIIlIIlllIlIllI == null) ? llllllllllllllllIIIIlIIlllIllIII.getName() : llllllllllllllllIIIIlIIlllIlIllI.getName();
        llllllllllllllllIIIIlIIlllIlIlll.addEntry(llllllllllllllllIIIIlIIlllIllIII);
        final NBTTagCompound llllllllllllllllIIIIlIIlllIlIlII = this.readPlayerDataFromFile(llllllllllllllllIIIIlIIlllIIIlIl);
        llllllllllllllllIIIIlIIlllIIIlIl.setWorld(this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlllIIIlIl.dimension));
        llllllllllllllllIIIIlIIlllIIIlIl.interactionManager.setWorld((WorldServer)llllllllllllllllIIIIlIIlllIIIlIl.world);
        String llllllllllllllllIIIIlIIlllIlIIll = "local";
        if (llllllllllllllllIIIIlIIlllIllIlI.getRemoteAddress() != null) {
            llllllllllllllllIIIIlIIlllIlIIll = llllllllllllllllIIIIlIIlllIllIlI.getRemoteAddress().toString();
        }
        PlayerList.LOG.info("{}[{}] logged in with entity id {} at ({}, {}, {})", (Object)llllllllllllllllIIIIlIIlllIIIlIl.getName(), (Object)llllllllllllllllIIIIlIIlllIlIIll, (Object)llllllllllllllllIIIIlIIlllIIIlIl.getEntityId(), (Object)llllllllllllllllIIIIlIIlllIIIlIl.posX, (Object)llllllllllllllllIIIIlIIlllIIIlIl.posY, (Object)llllllllllllllllIIIIlIIlllIIIlIl.posZ);
        final WorldServer llllllllllllllllIIIIlIIlllIlIIlI = this.mcServer.worldServerForDimension(llllllllllllllllIIIIlIIlllIIIlIl.dimension);
        final WorldInfo llllllllllllllllIIIIlIIlllIlIIIl = llllllllllllllllIIIIlIIlllIlIIlI.getWorldInfo();
        this.setPlayerGameTypeBasedOnOther(llllllllllllllllIIIIlIIlllIIIlIl, null, llllllllllllllllIIIIlIIlllIlIIlI);
        final NetHandlerPlayServer llllllllllllllllIIIIlIIlllIlIIII = new NetHandlerPlayServer(this.mcServer, llllllllllllllllIIIIlIIlllIllIlI, llllllllllllllllIIIIlIIlllIIIlIl);
        llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketJoinGame(llllllllllllllllIIIIlIIlllIIIlIl.getEntityId(), llllllllllllllllIIIIlIIlllIIIlIl.interactionManager.getGameType(), llllllllllllllllIIIIlIIlllIlIIIl.isHardcoreModeEnabled(), llllllllllllllllIIIIlIIlllIlIIlI.provider.getDimensionType().getId(), llllllllllllllllIIIIlIIlllIlIIlI.getDifficulty(), this.getMaxPlayers(), llllllllllllllllIIIIlIIlllIlIIIl.getTerrainType(), llllllllllllllllIIIIlIIlllIlIIlI.getGameRules().getBoolean("reducedDebugInfo")));
        llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(this.getServerInstance().getServerModName())));
        llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketServerDifficulty(llllllllllllllllIIIIlIIlllIlIIIl.getDifficulty(), llllllllllllllllIIIIlIIlllIlIIIl.isDifficultyLocked()));
        llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketPlayerAbilities(llllllllllllllllIIIIlIIlllIIIlIl.capabilities));
        llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketHeldItemChange(llllllllllllllllIIIIlIIlllIIIlIl.inventory.currentItem));
        this.updatePermissionLevel(llllllllllllllllIIIIlIIlllIIIlIl);
        llllllllllllllllIIIIlIIlllIIIlIl.getStatFile().markAllDirty();
        llllllllllllllllIIIIlIIlllIIIlIl.func_192037_E().func_192826_c(llllllllllllllllIIIIlIIlllIIIlIl);
        this.sendScoreboard((ServerScoreboard)llllllllllllllllIIIIlIIlllIlIIlI.getScoreboard(), llllllllllllllllIIIIlIIlllIIIlIl);
        this.mcServer.refreshStatusNextTick();
        TextComponentTranslation llllllllllllllllIIIIlIIlllIIlllI = null;
        if (llllllllllllllllIIIIlIIlllIIIlIl.getName().equalsIgnoreCase(llllllllllllllllIIIIlIIlllIlIlIl)) {
            final TextComponentTranslation llllllllllllllllIIIIlIIlllIIllll = new TextComponentTranslation("multiplayer.player.joined", new Object[] { llllllllllllllllIIIIlIIlllIIIlIl.getDisplayName() });
        }
        else {
            llllllllllllllllIIIIlIIlllIIlllI = new TextComponentTranslation("multiplayer.player.joined.renamed", new Object[] { llllllllllllllllIIIIlIIlllIIIlIl.getDisplayName(), llllllllllllllllIIIIlIIlllIlIlIl });
        }
        llllllllllllllllIIIIlIIlllIIlllI.getStyle().setColor(TextFormatting.YELLOW);
        this.sendChatMsg(llllllllllllllllIIIIlIIlllIIlllI);
        this.playerLoggedIn(llllllllllllllllIIIIlIIlllIIIlIl);
        llllllllllllllllIIIIlIIlllIlIIII.setPlayerLocation(llllllllllllllllIIIIlIIlllIIIlIl.posX, llllllllllllllllIIIIlIIlllIIIlIl.posY, llllllllllllllllIIIIlIIlllIIIlIl.posZ, llllllllllllllllIIIIlIIlllIIIlIl.rotationYaw, llllllllllllllllIIIIlIIlllIIIlIl.rotationPitch);
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIIlIIlllIIIlIl, llllllllllllllllIIIIlIIlllIlIIlI);
        if (!this.mcServer.getResourcePackUrl().isEmpty()) {
            llllllllllllllllIIIIlIIlllIIIlIl.loadResourcePack(this.mcServer.getResourcePackUrl(), this.mcServer.getResourcePackHash());
        }
        for (final PotionEffect llllllllllllllllIIIIlIIlllIIllIl : llllllllllllllllIIIIlIIlllIIIlIl.getActivePotionEffects()) {
            llllllllllllllllIIIIlIIlllIlIIII.sendPacket(new SPacketEntityEffect(llllllllllllllllIIIIlIIlllIIIlIl.getEntityId(), llllllllllllllllIIIIlIIlllIIllIl));
        }
        if (llllllllllllllllIIIIlIIlllIlIlII != null && llllllllllllllllIIIIlIIlllIlIlII.hasKey("RootVehicle", 10)) {
            final NBTTagCompound llllllllllllllllIIIIlIIlllIIllII = llllllllllllllllIIIIlIIlllIlIlII.getCompoundTag("RootVehicle");
            final Entity llllllllllllllllIIIIlIIlllIIlIll = AnvilChunkLoader.readWorldEntity(llllllllllllllllIIIIlIIlllIIllII.getCompoundTag("Entity"), llllllllllllllllIIIIlIIlllIlIIlI, true);
            if (llllllllllllllllIIIIlIIlllIIlIll != null) {
                final UUID llllllllllllllllIIIIlIIlllIIlIlI = llllllllllllllllIIIIlIIlllIIllII.getUniqueId("Attach");
                if (llllllllllllllllIIIIlIIlllIIlIll.getUniqueID().equals(llllllllllllllllIIIIlIIlllIIlIlI)) {
                    llllllllllllllllIIIIlIIlllIIIlIl.startRiding(llllllllllllllllIIIIlIIlllIIlIll, true);
                }
                else {
                    for (final Entity llllllllllllllllIIIIlIIlllIIlIIl : llllllllllllllllIIIIlIIlllIIlIll.getRecursivePassengers()) {
                        if (llllllllllllllllIIIIlIIlllIIlIIl.getUniqueID().equals(llllllllllllllllIIIIlIIlllIIlIlI)) {
                            llllllllllllllllIIIIlIIlllIIIlIl.startRiding(llllllllllllllllIIIIlIIlllIIlIIl, true);
                            break;
                        }
                    }
                }
                if (!llllllllllllllllIIIIlIIlllIIIlIl.isRiding()) {
                    PlayerList.LOG.warn("Couldn't reattach entity to player");
                    llllllllllllllllIIIIlIIlllIlIIlI.removeEntityDangerously(llllllllllllllllIIIIlIIlllIIlIll);
                    for (final Entity llllllllllllllllIIIIlIIlllIIlIII : llllllllllllllllIIIIlIIlllIIlIll.getRecursivePassengers()) {
                        llllllllllllllllIIIIlIIlllIlIIlI.removeEntityDangerously(llllllllllllllllIIIIlIIlllIIlIII);
                    }
                }
            }
        }
        llllllllllllllllIIIIlIIlllIIIlIl.addSelfToInternalCraftingInventory();
    }
    
    public int getMaxPlayers() {
        return this.maxPlayers;
    }
    
    public void removeAllPlayers() {
        for (int llllllllllllllllIIIIIllllIIlIlII = 0; llllllllllllllllIIIIIllllIIlIlII < this.playerEntityList.size(); ++llllllllllllllllIIIIIllllIIlIlII) {
            this.playerEntityList.get(llllllllllllllllIIIIIllllIIlIlII).connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.server_shutdown", new Object[0]));
        }
    }
    
    public UserListIPBans getBannedIPs() {
        return this.bannedIPs;
    }
    
    public void serverUpdateMovingPlayer(final EntityPlayerMP llllllllllllllllIIIIlIIlIllIIlIl) {
        llllllllllllllllIIIIlIIlIllIIlIl.getServerWorld().getPlayerChunkMap().updateMovingPlayer(llllllllllllllllIIIIlIIlIllIIlIl);
    }
    
    public void setViewDistance(final int llllllllllllllllIIIIIlllIlIlIIIl) {
        this.viewDistance = llllllllllllllllIIIIIlllIlIlIIIl;
        if (this.mcServer.worldServers != null) {
            final long llllllllllllllllIIIIIlllIlIIlIlI;
            final double llllllllllllllllIIIIIlllIlIIlIll = ((WorldServer[])(Object)(llllllllllllllllIIIIIlllIlIIlIlI = (long)(Object)this.mcServer.worldServers)).length;
            for (final WorldServer llllllllllllllllIIIIIlllIlIlIIII : llllllllllllllllIIIIIlllIlIIlIlI) {
                if (llllllllllllllllIIIIIlllIlIlIIII != null) {
                    llllllllllllllllIIIIIlllIlIlIIII.getPlayerChunkMap().setPlayerViewRadius(llllllllllllllllIIIIIlllIlIlIIIl);
                    llllllllllllllllIIIIIlllIlIlIIII.getEntityTracker().setViewDistance(llllllllllllllllIIIIIlllIlIlIIIl);
                }
            }
        }
    }
    
    public List<EntityPlayerMP> getPlayerList() {
        return this.playerEntityList;
    }
    
    public void updateTimeAndWeatherForPlayer(final EntityPlayerMP llllllllllllllllIIIIIllllllIIIII, final WorldServer llllllllllllllllIIIIIlllllIllIlI) {
        final WorldBorder llllllllllllllllIIIIIlllllIllllI = this.mcServer.worldServers[0].getWorldBorder();
        llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketWorldBorder(llllllllllllllllIIIIIlllllIllllI, SPacketWorldBorder.Action.INITIALIZE));
        llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketTimeUpdate(llllllllllllllllIIIIIlllllIllIlI.getTotalWorldTime(), llllllllllllllllIIIIIlllllIllIlI.getWorldTime(), llllllllllllllllIIIIIlllllIllIlI.getGameRules().getBoolean("doDaylightCycle")));
        final BlockPos llllllllllllllllIIIIIlllllIlllIl = llllllllllllllllIIIIIlllllIllIlI.getSpawnPoint();
        llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketSpawnPosition(llllllllllllllllIIIIIlllllIlllIl));
        if (llllllllllllllllIIIIIlllllIllIlI.isRaining()) {
            llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketChangeGameState(1, 0.0f));
            llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketChangeGameState(7, llllllllllllllllIIIIIlllllIllIlI.getRainStrength(1.0f)));
            llllllllllllllllIIIIIllllllIIIII.connection.sendPacket(new SPacketChangeGameState(8, llllllllllllllllIIIIIlllllIllIlI.getThunderStrength(1.0f)));
        }
    }
    
    public boolean canSendCommands(final GameProfile llllllllllllllllIIIIlIIIIIlllIlI) {
        return ((UserList<GameProfile, V>)this.ops).hasEntry(llllllllllllllllIIIIlIIIIIlllIlI) || (this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(llllllllllllllllIIIIlIIIIIlllIlI.getName())) || this.commandsAllowedForAll;
    }
    
    public String[] getWhitelistedPlayerNames() {
        return this.whiteListedPlayers.getKeys();
    }
    
    public String[] getAvailablePlayerDat() {
        return this.mcServer.worldServers[0].getSaveHandler().getPlayerNBTManager().getAvailablePlayerDat();
    }
    
    public void removePlayerFromWhitelist(final GameProfile llllllllllllllllIIIIIlllllllIllI) {
        ((UserList<GameProfile, V>)this.whiteListedPlayers).removeEntry(llllllllllllllllIIIIIlllllllIllI);
    }
    
    protected void writePlayerData(final EntityPlayerMP llllllllllllllllIIIIlIIlIllllIlI) {
        this.playerNBTManagerObj.writePlayerData(llllllllllllllllIIIIlIIlIllllIlI);
        final StatisticsManagerServer llllllllllllllllIIIIlIIlIllllIIl = this.playerStatFiles.get(llllllllllllllllIIIIlIIlIllllIlI.getUniqueID());
        if (llllllllllllllllIIIIlIIlIllllIIl != null) {
            llllllllllllllllIIIIlIIlIllllIIl.saveStatFile();
        }
        final PlayerAdvancements llllllllllllllllIIIIlIIlIllllIII = this.field_192055_p.get(llllllllllllllllIIIIlIIlIllllIlI.getUniqueID());
        if (llllllllllllllllIIIIlIIlIllllIII != null) {
            llllllllllllllllIIIIlIIlIllllIII.func_192749_b();
        }
    }
    
    public NBTTagCompound getHostPlayerData() {
        return null;
    }
    
    public String allowUserToConnect(final SocketAddress llllllllllllllllIIIIlIIlIlIIIIll, final GameProfile llllllllllllllllIIIIlIIlIlIIIIlI) {
        if (this.bannedPlayers.isBanned(llllllllllllllllIIIIlIIlIlIIIIlI)) {
            final UserListBansEntry llllllllllllllllIIIIlIIlIlIIlIII = this.bannedPlayers.getEntry(llllllllllllllllIIIIlIIlIlIIIIlI);
            String llllllllllllllllIIIIlIIlIlIIIlll = String.valueOf(new StringBuilder("You are banned from this server!\nReason: ").append(llllllllllllllllIIIIlIIlIlIIlIII.getBanReason()));
            if (llllllllllllllllIIIIlIIlIlIIlIII.getBanEndDate() != null) {
                llllllllllllllllIIIIlIIlIlIIIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIlIlIIIlll)).append("\nYour ban will be removed on ").append(PlayerList.DATE_FORMAT.format(llllllllllllllllIIIIlIIlIlIIlIII.getBanEndDate())));
            }
            return llllllllllllllllIIIIlIIlIlIIIlll;
        }
        if (!this.canJoin(llllllllllllllllIIIIlIIlIlIIIIlI)) {
            return "You are not white-listed on this server!";
        }
        if (this.bannedIPs.isBanned(llllllllllllllllIIIIlIIlIlIIIIll)) {
            final UserListIPBansEntry llllllllllllllllIIIIlIIlIlIIIllI = this.bannedIPs.getBanEntry(llllllllllllllllIIIIlIIlIlIIIIll);
            String llllllllllllllllIIIIlIIlIlIIIlIl = String.valueOf(new StringBuilder("Your IP address is banned from this server!\nReason: ").append(llllllllllllllllIIIIlIIlIlIIIllI.getBanReason()));
            if (llllllllllllllllIIIIlIIlIlIIIllI.getBanEndDate() != null) {
                llllllllllllllllIIIIlIIlIlIIIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIIIIlIIlIlIIIlIl)).append("\nYour ban will be removed on ").append(PlayerList.DATE_FORMAT.format(llllllllllllllllIIIIlIIlIlIIIllI.getBanEndDate())));
            }
            return llllllllllllllllIIIIlIIlIlIIIlIl;
        }
        return (this.playerEntityList.size() >= this.maxPlayers && !this.bypassesPlayerLimit(llllllllllllllllIIIIlIIlIlIIIIlI)) ? "The server is full!" : null;
    }
}
