package net.minecraft.server.management;

import com.google.common.base.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.world.*;
import it.unimi.dsi.fastutil.longs.*;
import com.google.common.collect.*;

public class PlayerChunkMap
{
    private /* synthetic */ int playerViewRadius;
    private final /* synthetic */ Long2ObjectMap<PlayerChunkMapEntry> playerInstances;
    private static final /* synthetic */ Predicate<EntityPlayerMP> NOT_SPECTATOR;
    private static final /* synthetic */ Predicate<EntityPlayerMP> CAN_GENERATE_CHUNKS;
    private final /* synthetic */ Set<PlayerChunkMapEntry> playerInstancesToUpdate;
    private final /* synthetic */ List<PlayerChunkMapEntry> playersNeedingChunks;
    private final /* synthetic */ WorldServer theWorldServer;
    private final /* synthetic */ List<PlayerChunkMapEntry> playerInstanceList;
    private /* synthetic */ boolean sortSendToPlayers;
    private final /* synthetic */ List<PlayerChunkMapEntry> pendingSendToPlayers;
    private /* synthetic */ long previousTotalWorldTime;
    private /* synthetic */ boolean sortMissingChunks;
    private final /* synthetic */ List<EntityPlayerMP> players;
    
    public void setPlayerViewRadius(int lllllllllllllIIlIIlllIIllIIllIll) {
        lllllllllllllIIlIIlllIIllIIllIll = MathHelper.clamp(lllllllllllllIIlIIlllIIllIIllIll, 3, 32);
        if (lllllllllllllIIlIIlllIIllIIllIll != this.playerViewRadius) {
            final int lllllllllllllIIlIIlllIIllIlIIlIl = lllllllllllllIIlIIlllIIllIIllIll - this.playerViewRadius;
            for (final EntityPlayerMP lllllllllllllIIlIIlllIIllIlIIlII : Lists.newArrayList((Iterable)this.players)) {
                final int lllllllllllllIIlIIlllIIllIlIIIll = (int)lllllllllllllIIlIIlllIIllIlIIlII.posX >> 4;
                final int lllllllllllllIIlIIlllIIllIlIIIlI = (int)lllllllllllllIIlIIlllIIllIlIIlII.posZ >> 4;
                if (lllllllllllllIIlIIlllIIllIlIIlIl > 0) {
                    for (int lllllllllllllIIlIIlllIIllIlIIIIl = lllllllllllllIIlIIlllIIllIlIIIll - lllllllllllllIIlIIlllIIllIIllIll; lllllllllllllIIlIIlllIIllIlIIIIl <= lllllllllllllIIlIIlllIIllIlIIIll + lllllllllllllIIlIIlllIIllIIllIll; ++lllllllllllllIIlIIlllIIllIlIIIIl) {
                        for (int lllllllllllllIIlIIlllIIllIlIIIII = lllllllllllllIIlIIlllIIllIlIIIlI - lllllllllllllIIlIIlllIIllIIllIll; lllllllllllllIIlIIlllIIllIlIIIII <= lllllllllllllIIlIIlllIIllIlIIIlI + lllllllllllllIIlIIlllIIllIIllIll; ++lllllllllllllIIlIIlllIIllIlIIIII) {
                            final PlayerChunkMapEntry lllllllllllllIIlIIlllIIllIIlllll = this.getOrCreateEntry(lllllllllllllIIlIIlllIIllIlIIIIl, lllllllllllllIIlIIlllIIllIlIIIII);
                            if (!lllllllllllllIIlIIlllIIllIIlllll.containsPlayer(lllllllllllllIIlIIlllIIllIlIIlII)) {
                                lllllllllllllIIlIIlllIIllIIlllll.addPlayer(lllllllllllllIIlIIlllIIllIlIIlII);
                            }
                        }
                    }
                }
                else {
                    for (int lllllllllllllIIlIIlllIIllIIllllI = lllllllllllllIIlIIlllIIllIlIIIll - this.playerViewRadius; lllllllllllllIIlIIlllIIllIIllllI <= lllllllllllllIIlIIlllIIllIlIIIll + this.playerViewRadius; ++lllllllllllllIIlIIlllIIllIIllllI) {
                        for (int lllllllllllllIIlIIlllIIllIIlllIl = lllllllllllllIIlIIlllIIllIlIIIlI - this.playerViewRadius; lllllllllllllIIlIIlllIIllIIlllIl <= lllllllllllllIIlIIlllIIllIlIIIlI + this.playerViewRadius; ++lllllllllllllIIlIIlllIIllIIlllIl) {
                            if (!this.overlaps(lllllllllllllIIlIIlllIIllIIllllI, lllllllllllllIIlIIlllIIllIIlllIl, lllllllllllllIIlIIlllIIllIlIIIll, lllllllllllllIIlIIlllIIllIlIIIlI, lllllllllllllIIlIIlllIIllIIllIll)) {
                                this.getOrCreateEntry(lllllllllllllIIlIIlllIIllIIllllI, lllllllllllllIIlIIlllIIllIIlllIl).removePlayer(lllllllllllllIIlIIlllIIllIlIIlII);
                            }
                        }
                    }
                }
            }
            this.playerViewRadius = lllllllllllllIIlIIlllIIllIIllIll;
            this.markSortPending();
        }
    }
    
    public void removePlayer(final EntityPlayerMP lllllllllllllIIlIIlllIlIIIIIlIIl) {
        final int lllllllllllllIIlIIlllIlIIIIIllll = (int)lllllllllllllIIlIIlllIlIIIIIlIIl.managedPosX >> 4;
        final int lllllllllllllIIlIIlllIlIIIIIlllI = (int)lllllllllllllIIlIIlllIlIIIIIlIIl.managedPosZ >> 4;
        for (int lllllllllllllIIlIIlllIlIIIIIllIl = lllllllllllllIIlIIlllIlIIIIIllll - this.playerViewRadius; lllllllllllllIIlIIlllIlIIIIIllIl <= lllllllllllllIIlIIlllIlIIIIIllll + this.playerViewRadius; ++lllllllllllllIIlIIlllIlIIIIIllIl) {
            for (int lllllllllllllIIlIIlllIlIIIIIllII = lllllllllllllIIlIIlllIlIIIIIlllI - this.playerViewRadius; lllllllllllllIIlIIlllIlIIIIIllII <= lllllllllllllIIlIIlllIlIIIIIlllI + this.playerViewRadius; ++lllllllllllllIIlIIlllIlIIIIIllII) {
                final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIIIIlIll = this.getEntry(lllllllllllllIIlIIlllIlIIIIIllIl, lllllllllllllIIlIIlllIlIIIIIllII);
                if (lllllllllllllIIlIIlllIlIIIIIlIll != null) {
                    lllllllllllllIIlIIlllIlIIIIIlIll.removePlayer(lllllllllllllIIlIIlllIlIIIIIlIIl);
                }
            }
        }
        this.players.remove(lllllllllllllIIlIIlllIlIIIIIlIIl);
        this.markSortPending();
    }
    
    static {
        NOT_SPECTATOR = (Predicate)new Predicate<EntityPlayerMP>() {
            public boolean apply(@Nullable final EntityPlayerMP llllllllllllllIIIIllllIlIIlIIIlI) {
                return llllllllllllllIIIIllllIlIIlIIIlI != null && !llllllllllllllIIIIllllIlIIlIIIlI.isSpectator();
            }
        };
        CAN_GENERATE_CHUNKS = (Predicate)new Predicate<EntityPlayerMP>() {
            public boolean apply(@Nullable final EntityPlayerMP lllllllllllllIlIIIlIlIlIIllllllI) {
                return lllllllllllllIlIIIlIlIlIIllllllI != null && (!lllllllllllllIlIIIlIlIlIIllllllI.isSpectator() || lllllllllllllIlIIIlIlIlIIllllllI.getServerWorld().getGameRules().getBoolean("spectatorsGenerateChunks"));
            }
        };
    }
    
    private PlayerChunkMapEntry getOrCreateEntry(final int lllllllllllllIIlIIlllIlIIlIIIIlI, final int lllllllllllllIIlIIlllIlIIlIIIIIl) {
        final long lllllllllllllIIlIIlllIlIIlIIIIII = getIndex(lllllllllllllIIlIIlllIlIIlIIIIlI, lllllllllllllIIlIIlllIlIIlIIIIIl);
        PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIIllllll = (PlayerChunkMapEntry)this.playerInstances.get(lllllllllllllIIlIIlllIlIIlIIIIII);
        if (lllllllllllllIIlIIlllIlIIIllllll == null) {
            lllllllllllllIIlIIlllIlIIIllllll = new PlayerChunkMapEntry(this, lllllllllllllIIlIIlllIlIIlIIIIlI, lllllllllllllIIlIIlllIlIIlIIIIIl);
            this.playerInstances.put(lllllllllllllIIlIIlllIlIIlIIIIII, (Object)lllllllllllllIIlIIlllIlIIIllllll);
            this.playerInstanceList.add(lllllllllllllIIlIIlllIlIIIllllll);
            if (lllllllllllllIIlIIlllIlIIIllllll.getChunk() == null) {
                this.playersNeedingChunks.add(lllllllllllllIIlIIlllIlIIIllllll);
            }
            if (!lllllllllllllIIlIIlllIlIIIllllll.sendToPlayers()) {
                this.pendingSendToPlayers.add(lllllllllllllIIlIIlllIlIIIllllll);
            }
        }
        return lllllllllllllIIlIIlllIlIIIllllll;
    }
    
    public void markBlockForUpdate(final BlockPos lllllllllllllIIlIIlllIlIIIllIIll) {
        final int lllllllllllllIIlIIlllIlIIIllIIlI = lllllllllllllIIlIIlllIlIIIllIIll.getX() >> 4;
        final int lllllllllllllIIlIIlllIlIIIllIIIl = lllllllllllllIIlIIlllIlIIIllIIll.getZ() >> 4;
        final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIIllIIII = this.getEntry(lllllllllllllIIlIIlllIlIIIllIIlI, lllllllllllllIIlIIlllIlIIIllIIIl);
        if (lllllllllllllIIlIIlllIlIIIllIIII != null) {
            lllllllllllllIIlIIlllIlIIIllIIII.blockChanged(lllllllllllllIIlIIlllIlIIIllIIll.getX() & 0xF, lllllllllllllIIlIIlllIlIIIllIIll.getY(), lllllllllllllIIlIIlllIlIIIllIIll.getZ() & 0xF);
        }
    }
    
    public void removeEntry(final PlayerChunkMapEntry lllllllllllllIIlIIlllIIlIlllIlIl) {
        final ChunkPos lllllllllllllIIlIIlllIIlIllllIIl = lllllllllllllIIlIIlllIIlIlllIlIl.getPos();
        final long lllllllllllllIIlIIlllIIlIllllIII = getIndex(lllllllllllllIIlIIlllIIlIllllIIl.chunkXPos, lllllllllllllIIlIIlllIIlIllllIIl.chunkZPos);
        lllllllllllllIIlIIlllIIlIlllIlIl.updateChunkInhabitedTime();
        this.playerInstances.remove(lllllllllllllIIlIIlllIIlIllllIII);
        this.playerInstanceList.remove(lllllllllllllIIlIIlllIIlIlllIlIl);
        this.playerInstancesToUpdate.remove(lllllllllllllIIlIIlllIIlIlllIlIl);
        this.pendingSendToPlayers.remove(lllllllllllllIIlIIlllIIlIlllIlIl);
        this.playersNeedingChunks.remove(lllllllllllllIIlIIlllIIlIlllIlIl);
        final Chunk lllllllllllllIIlIIlllIIlIlllIlll = lllllllllllllIIlIIlllIIlIlllIlIl.getChunk();
        if (lllllllllllllIIlIIlllIIlIlllIlll != null) {
            this.getWorldServer().getChunkProvider().unload(lllllllllllllIIlIIlllIIlIlllIlll);
        }
    }
    
    public void addEntry(final PlayerChunkMapEntry lllllllllllllIIlIIlllIIllIIIIIIl) {
        this.playerInstancesToUpdate.add(lllllllllllllIIlIIlllIIllIIIIIIl);
    }
    
    private boolean overlaps(final int lllllllllllllIIlIIlllIIlllllIlII, final int lllllllllllllIIlIIlllIIlllllIIll, final int lllllllllllllIIlIIlllIIllllllIIl, final int lllllllllllllIIlIIlllIIllllllIII, final int lllllllllllllIIlIIlllIIlllllIlll) {
        final int lllllllllllllIIlIIlllIIlllllIllI = lllllllllllllIIlIIlllIIlllllIlII - lllllllllllllIIlIIlllIIllllllIIl;
        final int lllllllllllllIIlIIlllIIlllllIlIl = lllllllllllllIIlIIlllIIlllllIIll - lllllllllllllIIlIIlllIIllllllIII;
        return lllllllllllllIIlIIlllIIlllllIllI >= -lllllllllllllIIlIIlllIIlllllIlll && lllllllllllllIIlIIlllIIlllllIllI <= lllllllllllllIIlIIlllIIlllllIlll && (lllllllllllllIIlIIlllIIlllllIlIl >= -lllllllllllllIIlIIlllIIlllllIlll && lllllllllllllIIlIIlllIIlllllIlIl <= lllllllllllllIIlIIlllIIlllllIlll);
    }
    
    private static long getIndex(final int lllllllllllllIIlIIlllIIllIIIlIlI, final int lllllllllllllIIlIIlllIIllIIIlIIl) {
        return lllllllllllllIIlIIlllIIllIIIlIlI + 2147483647L | lllllllllllllIIlIIlllIIllIIIlIIl + 2147483647L << 32;
    }
    
    public void addPlayer(final EntityPlayerMP lllllllllllllIIlIIlllIlIIIIlllIl) {
        final int lllllllllllllIIlIIlllIlIIIlIIIlI = (int)lllllllllllllIIlIIlllIlIIIIlllIl.posX >> 4;
        final int lllllllllllllIIlIIlllIlIIIlIIIIl = (int)lllllllllllllIIlIIlllIlIIIIlllIl.posZ >> 4;
        lllllllllllllIIlIIlllIlIIIIlllIl.managedPosX = lllllllllllllIIlIIlllIlIIIIlllIl.posX;
        lllllllllllllIIlIIlllIlIIIIlllIl.managedPosZ = lllllllllllllIIlIIlllIlIIIIlllIl.posZ;
        for (int lllllllllllllIIlIIlllIlIIIlIIIII = lllllllllllllIIlIIlllIlIIIlIIIlI - this.playerViewRadius; lllllllllllllIIlIIlllIlIIIlIIIII <= lllllllllllllIIlIIlllIlIIIlIIIlI + this.playerViewRadius; ++lllllllllllllIIlIIlllIlIIIlIIIII) {
            for (int lllllllllllllIIlIIlllIlIIIIlllll = lllllllllllllIIlIIlllIlIIIlIIIIl - this.playerViewRadius; lllllllllllllIIlIIlllIlIIIIlllll <= lllllllllllllIIlIIlllIlIIIlIIIIl + this.playerViewRadius; ++lllllllllllllIIlIIlllIlIIIIlllll) {
                this.getOrCreateEntry(lllllllllllllIIlIIlllIlIIIlIIIII, lllllllllllllIIlIIlllIlIIIIlllll).addPlayer(lllllllllllllIIlIIlllIlIIIIlllIl);
            }
        }
        this.players.add(lllllllllllllIIlIIlllIlIIIIlllIl);
        this.markSortPending();
    }
    
    public void tick() {
        final long lllllllllllllIIlIIlllIlIIlllIIlI = this.theWorldServer.getTotalWorldTime();
        if (lllllllllllllIIlIIlllIlIIlllIIlI - this.previousTotalWorldTime > 8000L) {
            this.previousTotalWorldTime = lllllllllllllIIlIIlllIlIIlllIIlI;
            for (int lllllllllllllIIlIIlllIlIIlllIIIl = 0; lllllllllllllIIlIIlllIlIIlllIIIl < this.playerInstanceList.size(); ++lllllllllllllIIlIIlllIlIIlllIIIl) {
                final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIlllIIII = this.playerInstanceList.get(lllllllllllllIIlIIlllIlIIlllIIIl);
                lllllllllllllIIlIIlllIlIIlllIIII.update();
                lllllllllllllIIlIIlllIlIIlllIIII.updateChunkInhabitedTime();
            }
        }
        if (!this.playerInstancesToUpdate.isEmpty()) {
            for (final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIllIllll : this.playerInstancesToUpdate) {
                lllllllllllllIIlIIlllIlIIllIllll.update();
            }
            this.playerInstancesToUpdate.clear();
        }
        if (this.sortMissingChunks && lllllllllllllIIlIIlllIlIIlllIIlI % 4L == 0L) {
            this.sortMissingChunks = false;
            Collections.sort(this.playersNeedingChunks, new Comparator<PlayerChunkMapEntry>() {
                @Override
                public int compare(final PlayerChunkMapEntry lllllllllllllIlIlIlIlIIlIlllIlIl, final PlayerChunkMapEntry lllllllllllllIlIlIlIlIIlIlllIllI) {
                    return ComparisonChain.start().compare(lllllllllllllIlIlIlIlIIlIlllIlIl.getClosestPlayerDistance(), lllllllllllllIlIlIlIlIIlIlllIllI.getClosestPlayerDistance()).result();
                }
            });
        }
        if (this.sortSendToPlayers && lllllllllllllIIlIIlllIlIIlllIIlI % 4L == 2L) {
            this.sortSendToPlayers = false;
            Collections.sort(this.pendingSendToPlayers, new Comparator<PlayerChunkMapEntry>() {
                @Override
                public int compare(final PlayerChunkMapEntry llllllllllllllIIIIIlIlIIIIIllIIl, final PlayerChunkMapEntry llllllllllllllIIIIIlIlIIIIIllIII) {
                    return ComparisonChain.start().compare(llllllllllllllIIIIIlIlIIIIIllIIl.getClosestPlayerDistance(), llllllllllllllIIIIIlIlIIIIIllIII.getClosestPlayerDistance()).result();
                }
            });
        }
        if (!this.playersNeedingChunks.isEmpty()) {
            final long lllllllllllllIIlIIlllIlIIllIlllI = System.nanoTime() + 50000000L;
            int lllllllllllllIIlIIlllIlIIllIllIl = 49;
            final Iterator<PlayerChunkMapEntry> lllllllllllllIIlIIlllIlIIllIllII = this.playersNeedingChunks.iterator();
            while (lllllllllllllIIlIIlllIlIIllIllII.hasNext()) {
                final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIllIlIll = lllllllllllllIIlIIlllIlIIllIllII.next();
                if (lllllllllllllIIlIIlllIlIIllIlIll.getChunk() == null) {
                    final boolean lllllllllllllIIlIIlllIlIIllIlIlI = lllllllllllllIIlIIlllIlIIllIlIll.hasPlayerMatching(PlayerChunkMap.CAN_GENERATE_CHUNKS);
                    if (!lllllllllllllIIlIIlllIlIIllIlIll.providePlayerChunk(lllllllllllllIIlIIlllIlIIllIlIlI)) {
                        continue;
                    }
                    lllllllllllllIIlIIlllIlIIllIllII.remove();
                    if (lllllllllllllIIlIIlllIlIIllIlIll.sendToPlayers()) {
                        this.pendingSendToPlayers.remove(lllllllllllllIIlIIlllIlIIllIlIll);
                    }
                    if (--lllllllllllllIIlIIlllIlIIllIllIl < 0) {
                        break;
                    }
                    if (System.nanoTime() > lllllllllllllIIlIIlllIlIIllIlllI) {
                        break;
                    }
                    continue;
                }
            }
        }
        if (!this.pendingSendToPlayers.isEmpty()) {
            int lllllllllllllIIlIIlllIlIIllIlIIl = 81;
            final Iterator<PlayerChunkMapEntry> lllllllllllllIIlIIlllIlIIllIlIII = this.pendingSendToPlayers.iterator();
            while (lllllllllllllIIlIIlllIlIIllIlIII.hasNext()) {
                final PlayerChunkMapEntry lllllllllllllIIlIIlllIlIIllIIlll = lllllllllllllIIlIIlllIlIIllIlIII.next();
                if (lllllllllllllIIlIIlllIlIIllIIlll.sendToPlayers()) {
                    lllllllllllllIIlIIlllIlIIllIlIII.remove();
                    if (--lllllllllllllIIlIIlllIlIIllIlIIl < 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        if (this.players.isEmpty()) {
            final WorldProvider lllllllllllllIIlIIlllIlIIllIIllI = this.theWorldServer.provider;
            if (!lllllllllllllIIlIIlllIlIIllIIllI.canRespawnHere()) {
                this.theWorldServer.getChunkProvider().unloadAllChunks();
            }
        }
    }
    
    public boolean isPlayerWatchingChunk(final EntityPlayerMP lllllllllllllIIlIIlllIIllIllIlIl, final int lllllllllllllIIlIIlllIIllIlllIIl, final int lllllllllllllIIlIIlllIIllIlllIII) {
        final PlayerChunkMapEntry lllllllllllllIIlIIlllIIllIllIlll = this.getEntry(lllllllllllllIIlIIlllIIllIlllIIl, lllllllllllllIIlIIlllIIllIlllIII);
        return lllllllllllllIIlIIlllIIllIllIlll != null && lllllllllllllIIlIIlllIIllIllIlll.containsPlayer(lllllllllllllIIlIIlllIIllIllIlIl) && lllllllllllllIIlIIlllIIllIllIlll.isSentToPlayers();
    }
    
    public void updateMovingPlayer(final EntityPlayerMP lllllllllllllIIlIIlllIIlllIlllIl) {
        final int lllllllllllllIIlIIlllIIlllIlllII = (int)lllllllllllllIIlIIlllIIlllIlllIl.posX >> 4;
        final int lllllllllllllIIlIIlllIIlllIllIll = (int)lllllllllllllIIlIIlllIIlllIlllIl.posZ >> 4;
        final double lllllllllllllIIlIIlllIIlllIllIlI = lllllllllllllIIlIIlllIIlllIlllIl.managedPosX - lllllllllllllIIlIIlllIIlllIlllIl.posX;
        final double lllllllllllllIIlIIlllIIlllIllIIl = lllllllllllllIIlIIlllIIlllIlllIl.managedPosZ - lllllllllllllIIlIIlllIIlllIlllIl.posZ;
        final double lllllllllllllIIlIIlllIIlllIllIII = lllllllllllllIIlIIlllIIlllIllIlI * lllllllllllllIIlIIlllIIlllIllIlI + lllllllllllllIIlIIlllIIlllIllIIl * lllllllllllllIIlIIlllIIlllIllIIl;
        if (lllllllllllllIIlIIlllIIlllIllIII >= 64.0) {
            final int lllllllllllllIIlIIlllIIlllIlIlll = (int)lllllllllllllIIlIIlllIIlllIlllIl.managedPosX >> 4;
            final int lllllllllllllIIlIIlllIIlllIlIllI = (int)lllllllllllllIIlIIlllIIlllIlllIl.managedPosZ >> 4;
            final int lllllllllllllIIlIIlllIIlllIlIlIl = this.playerViewRadius;
            final int lllllllllllllIIlIIlllIIlllIlIlII = lllllllllllllIIlIIlllIIlllIlllII - lllllllllllllIIlIIlllIIlllIlIlll;
            final int lllllllllllllIIlIIlllIIlllIlIIll = lllllllllllllIIlIIlllIIlllIllIll - lllllllllllllIIlIIlllIIlllIlIllI;
            if (lllllllllllllIIlIIlllIIlllIlIlII != 0 || lllllllllllllIIlIIlllIIlllIlIIll != 0) {
                for (int lllllllllllllIIlIIlllIIlllIlIIlI = lllllllllllllIIlIIlllIIlllIlllII - lllllllllllllIIlIIlllIIlllIlIlIl; lllllllllllllIIlIIlllIIlllIlIIlI <= lllllllllllllIIlIIlllIIlllIlllII + lllllllllllllIIlIIlllIIlllIlIlIl; ++lllllllllllllIIlIIlllIIlllIlIIlI) {
                    for (int lllllllllllllIIlIIlllIIlllIlIIIl = lllllllllllllIIlIIlllIIlllIllIll - lllllllllllllIIlIIlllIIlllIlIlIl; lllllllllllllIIlIIlllIIlllIlIIIl <= lllllllllllllIIlIIlllIIlllIllIll + lllllllllllllIIlIIlllIIlllIlIlIl; ++lllllllllllllIIlIIlllIIlllIlIIIl) {
                        if (!this.overlaps(lllllllllllllIIlIIlllIIlllIlIIlI, lllllllllllllIIlIIlllIIlllIlIIIl, lllllllllllllIIlIIlllIIlllIlIlll, lllllllllllllIIlIIlllIIlllIlIllI, lllllllllllllIIlIIlllIIlllIlIlIl)) {
                            this.getOrCreateEntry(lllllllllllllIIlIIlllIIlllIlIIlI, lllllllllllllIIlIIlllIIlllIlIIIl).addPlayer(lllllllllllllIIlIIlllIIlllIlllIl);
                        }
                        if (!this.overlaps(lllllllllllllIIlIIlllIIlllIlIIlI - lllllllllllllIIlIIlllIIlllIlIlII, lllllllllllllIIlIIlllIIlllIlIIIl - lllllllllllllIIlIIlllIIlllIlIIll, lllllllllllllIIlIIlllIIlllIlllII, lllllllllllllIIlIIlllIIlllIllIll, lllllllllllllIIlIIlllIIlllIlIlIl)) {
                            final PlayerChunkMapEntry lllllllllllllIIlIIlllIIlllIlIIII = this.getEntry(lllllllllllllIIlIIlllIIlllIlIIlI - lllllllllllllIIlIIlllIIlllIlIlII, lllllllllllllIIlIIlllIIlllIlIIIl - lllllllllllllIIlIIlllIIlllIlIIll);
                            if (lllllllllllllIIlIIlllIIlllIlIIII != null) {
                                lllllllllllllIIlIIlllIIlllIlIIII.removePlayer(lllllllllllllIIlIIlllIIlllIlllIl);
                            }
                        }
                    }
                }
                lllllllllllllIIlIIlllIIlllIlllIl.managedPosX = lllllllllllllIIlIIlllIIlllIlllIl.posX;
                lllllllllllllIIlIIlllIIlllIlllIl.managedPosZ = lllllllllllllIIlIIlllIIlllIlllIl.posZ;
                this.markSortPending();
            }
        }
    }
    
    public Iterator<Chunk> getChunkIterator() {
        final Iterator<PlayerChunkMapEntry> lllllllllllllIIlIIlllIlIIllllllI = this.playerInstanceList.iterator();
        return (Iterator<Chunk>)new AbstractIterator<Chunk>() {
            protected Chunk computeNext() {
                while (lllllllllllllIIlIIlllIlIIllllllI.hasNext()) {
                    final PlayerChunkMapEntry lllllllllllllIIIIIIIlIllIlllIlll = lllllllllllllIIlIIlllIlIIllllllI.next();
                    final Chunk lllllllllllllIIIIIIIlIllIlllIllI = lllllllllllllIIIIIIIlIllIlllIlll.getChunk();
                    if (lllllllllllllIIIIIIIlIllIlllIllI == null) {
                        continue;
                    }
                    if (!lllllllllllllIIIIIIIlIllIlllIllI.isLightPopulated() && lllllllllllllIIIIIIIlIllIlllIllI.isTerrainPopulated()) {
                        return lllllllllllllIIIIIIIlIllIlllIllI;
                    }
                    if (!lllllllllllllIIIIIIIlIllIlllIllI.isChunkTicked()) {
                        return lllllllllllllIIIIIIIlIllIlllIllI;
                    }
                    if (!lllllllllllllIIIIIIIlIllIlllIlll.hasPlayerMatchingInRange(128.0, PlayerChunkMap.NOT_SPECTATOR)) {
                        continue;
                    }
                    return lllllllllllllIIIIIIIlIllIlllIllI;
                }
                return (Chunk)this.endOfData();
            }
        };
    }
    
    public WorldServer getWorldServer() {
        return this.theWorldServer;
    }
    
    @Nullable
    public PlayerChunkMapEntry getEntry(final int lllllllllllllIIlIIlllIlIIlIIllIl, final int lllllllllllllIIlIIlllIlIIlIIllII) {
        return (PlayerChunkMapEntry)this.playerInstances.get(getIndex(lllllllllllllIIlIIlllIlIIlIIllIl, lllllllllllllIIlIIlllIlIIlIIllII));
    }
    
    public PlayerChunkMap(final WorldServer lllllllllllllIIlIIlllIlIlIIIIlIl) {
        this.players = (List<EntityPlayerMP>)Lists.newArrayList();
        this.playerInstances = (Long2ObjectMap<PlayerChunkMapEntry>)new Long2ObjectOpenHashMap(4096);
        this.playerInstancesToUpdate = (Set<PlayerChunkMapEntry>)Sets.newHashSet();
        this.pendingSendToPlayers = (List<PlayerChunkMapEntry>)Lists.newLinkedList();
        this.playersNeedingChunks = (List<PlayerChunkMapEntry>)Lists.newLinkedList();
        this.playerInstanceList = (List<PlayerChunkMapEntry>)Lists.newArrayList();
        this.sortMissingChunks = true;
        this.sortSendToPlayers = true;
        this.theWorldServer = lllllllllllllIIlIIlllIlIlIIIIlIl;
        this.setPlayerViewRadius(lllllllllllllIIlIIlllIlIlIIIIlIl.getMinecraftServer().getPlayerList().getViewDistance());
    }
    
    private void markSortPending() {
        this.sortMissingChunks = true;
        this.sortSendToPlayers = true;
    }
    
    public static int getFurthestViewableBlock(final int lllllllllllllIIlIIlllIIllIIIllIl) {
        return lllllllllllllIIlIIlllIIllIIIllIl * 16 - 16;
    }
    
    public boolean contains(final int lllllllllllllIIlIIlllIlIIlIlIlII, final int lllllllllllllIIlIIlllIlIIlIlIIll) {
        final long lllllllllllllIIlIIlllIlIIlIlIllI = getIndex(lllllllllllllIIlIIlllIlIIlIlIlII, lllllllllllllIIlIIlllIlIIlIlIIll);
        return this.playerInstances.get(lllllllllllllIIlIIlllIlIIlIlIllI) != null;
    }
}
