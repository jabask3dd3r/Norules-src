package net.minecraft.server.management;

import net.minecraft.world.chunk.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import com.google.common.base.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.server.*;

public class PlayerChunkMapEntry
{
    private /* synthetic */ boolean sentToPlayers;
    private /* synthetic */ int changes;
    private final /* synthetic */ PlayerChunkMap playerChunkMap;
    private final /* synthetic */ short[] changedBlocks;
    private /* synthetic */ long lastUpdateInhabitedTime;
    @Nullable
    private /* synthetic */ Chunk chunk;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<EntityPlayerMP> players;
    private final /* synthetic */ ChunkPos pos;
    private /* synthetic */ int changedSectionFilter;
    
    public boolean isSentToPlayers() {
        return this.sentToPlayers;
    }
    
    public void sendPacket(final Packet<?> lllIllIIIlIlI) {
        if (this.sentToPlayers) {
            for (int lllIllIIIlIIl = 0; lllIllIIIlIIl < this.players.size(); ++lllIllIIIlIIl) {
                this.players.get(lllIllIIIlIIl).connection.sendPacket(lllIllIIIlIlI);
            }
        }
    }
    
    public boolean containsPlayer(final EntityPlayerMP lllIlIllIIIll) {
        return this.players.contains(lllIlIllIIIll);
    }
    
    public void update() {
        if (this.sentToPlayers && this.chunk != null && this.changes != 0) {
            if (this.changes == 1) {
                final int lllIlIllllllI = (this.changedBlocks[0] >> 12 & 0xF) + this.pos.chunkXPos * 16;
                final int lllIlIlllllIl = this.changedBlocks[0] & 0xFF;
                final int lllIlIlllllII = (this.changedBlocks[0] >> 8 & 0xF) + this.pos.chunkZPos * 16;
                final BlockPos lllIlIllllIll = new BlockPos(lllIlIllllllI, lllIlIlllllIl, lllIlIlllllII);
                this.sendPacket(new SPacketBlockChange(this.playerChunkMap.getWorldServer(), lllIlIllllIll));
                if (this.playerChunkMap.getWorldServer().getBlockState(lllIlIllllIll).getBlock().hasTileEntity()) {
                    this.sendBlockEntity(this.playerChunkMap.getWorldServer().getTileEntity(lllIlIllllIll));
                }
            }
            else if (this.changes == 64) {
                this.sendPacket(new SPacketChunkData(this.chunk, this.changedSectionFilter));
            }
            else {
                this.sendPacket(new SPacketMultiBlockChange(this.changes, this.changedBlocks, this.chunk));
                for (int lllIlIllllIlI = 0; lllIlIllllIlI < this.changes; ++lllIlIllllIlI) {
                    final int lllIlIllllIIl = (this.changedBlocks[lllIlIllllIlI] >> 12 & 0xF) + this.pos.chunkXPos * 16;
                    final int lllIlIllllIII = this.changedBlocks[lllIlIllllIlI] & 0xFF;
                    final int lllIlIlllIlll = (this.changedBlocks[lllIlIllllIlI] >> 8 & 0xF) + this.pos.chunkZPos * 16;
                    final BlockPos lllIlIlllIllI = new BlockPos(lllIlIllllIIl, lllIlIllllIII, lllIlIlllIlll);
                    if (this.playerChunkMap.getWorldServer().getBlockState(lllIlIlllIllI).getBlock().hasTileEntity()) {
                        this.sendBlockEntity(this.playerChunkMap.getWorldServer().getTileEntity(lllIlIlllIllI));
                    }
                }
            }
            this.changes = 0;
            this.changedSectionFilter = 0;
        }
    }
    
    public PlayerChunkMapEntry(final PlayerChunkMap lllIlllIIllll, final int lllIlllIIlllI, final int lllIlllIIllIl) {
        this.players = (List<EntityPlayerMP>)Lists.newArrayList();
        this.changedBlocks = new short[64];
        this.playerChunkMap = lllIlllIIllll;
        this.pos = new ChunkPos(lllIlllIIlllI, lllIlllIIllIl);
        this.chunk = lllIlllIIllll.getWorldServer().getChunkProvider().loadChunk(lllIlllIIlllI, lllIlllIIllIl);
    }
    
    public void addPlayer(final EntityPlayerMP lllIlllIIIllI) {
        if (this.players.contains(lllIlllIIIllI)) {
            PlayerChunkMapEntry.LOGGER.debug("Failed to add player. {} already is in chunk {}, {}", (Object)lllIlllIIIllI, (Object)this.pos.chunkXPos, (Object)this.pos.chunkZPos);
        }
        else {
            if (this.players.isEmpty()) {
                this.lastUpdateInhabitedTime = this.playerChunkMap.getWorldServer().getTotalWorldTime();
            }
            this.players.add(lllIlllIIIllI);
            if (this.sentToPlayers) {
                this.sendNearbySpecialEntities(lllIlllIIIllI);
            }
        }
    }
    
    public boolean sendToPlayers() {
        if (this.sentToPlayers) {
            return true;
        }
        if (this.chunk == null) {
            return false;
        }
        if (!this.chunk.isPopulated()) {
            return false;
        }
        this.changes = 0;
        this.changedSectionFilter = 0;
        this.sentToPlayers = true;
        final Packet<?> lllIllIllIIlI = new SPacketChunkData(this.chunk, 65535);
        for (final EntityPlayerMP lllIllIllIIIl : this.players) {
            lllIllIllIIIl.connection.sendPacket(lllIllIllIIlI);
            this.playerChunkMap.getWorldServer().getEntityTracker().sendLeashedEntitiesInChunk(lllIllIllIIIl, this.chunk);
        }
        return true;
    }
    
    public boolean providePlayerChunk(final boolean lllIllIlllIII) {
        if (this.chunk != null) {
            return true;
        }
        if (lllIllIlllIII) {
            this.chunk = this.playerChunkMap.getWorldServer().getChunkProvider().provideChunk(this.pos.chunkXPos, this.pos.chunkZPos);
        }
        else {
            this.chunk = this.playerChunkMap.getWorldServer().getChunkProvider().loadChunk(this.pos.chunkXPos, this.pos.chunkZPos);
        }
        return this.chunk != null;
    }
    
    public void updateChunkInhabitedTime() {
        final long lllIllIlIIIll = this.playerChunkMap.getWorldServer().getTotalWorldTime();
        if (this.chunk != null) {
            this.chunk.setInhabitedTime(this.chunk.getInhabitedTime() + lllIllIlIIIll - this.lastUpdateInhabitedTime);
        }
        this.lastUpdateInhabitedTime = lllIllIlIIIll;
    }
    
    @Nullable
    public Chunk getChunk() {
        return this.chunk;
    }
    
    public ChunkPos getPos() {
        return this.pos;
    }
    
    public void removePlayer(final EntityPlayerMP lllIlllIIIIII) {
        if (this.players.contains(lllIlllIIIIII)) {
            if (this.sentToPlayers) {
                lllIlllIIIIII.connection.sendPacket(new SPacketUnloadChunk(this.pos.chunkXPos, this.pos.chunkZPos));
            }
            this.players.remove(lllIlllIIIIII);
            if (this.players.isEmpty()) {
                this.playerChunkMap.removeEntry(this);
            }
        }
    }
    
    public void blockChanged(final int lllIllIIllIIl, final int lllIllIIllIII, final int lllIllIIlIIIl) {
        if (this.sentToPlayers) {
            if (this.changes == 0) {
                this.playerChunkMap.addEntry(this);
            }
            this.changedSectionFilter |= 1 << (lllIllIIllIII >> 4);
            if (this.changes < 64) {
                final short lllIllIIlIllI = (short)(lllIllIIllIIl << 12 | lllIllIIlIIIl << 8 | lllIllIIllIII);
                for (int lllIllIIlIlIl = 0; lllIllIIlIlIl < this.changes; ++lllIllIIlIlIl) {
                    if (this.changedBlocks[lllIllIIlIlIl] == lllIllIIlIllI) {
                        return;
                    }
                }
                this.changedBlocks[this.changes++] = lllIllIIlIllI;
            }
        }
    }
    
    public void sendNearbySpecialEntities(final EntityPlayerMP lllIllIlIIlll) {
        if (this.sentToPlayers) {
            lllIllIlIIlll.connection.sendPacket(new SPacketChunkData(this.chunk, 65535));
            this.playerChunkMap.getWorldServer().getEntityTracker().sendLeashedEntitiesInChunk(lllIllIlIIlll, this.chunk);
        }
    }
    
    public boolean hasPlayerMatchingInRange(final double lllIlIlIlIIll, final Predicate<EntityPlayerMP> lllIlIlIlIIlI) {
        for (int lllIlIlIlIIIl = 0, lllIlIlIlIIII = this.players.size(); lllIlIlIlIIIl < lllIlIlIlIIII; ++lllIlIlIlIIIl) {
            final EntityPlayerMP lllIlIlIIllll = this.players.get(lllIlIlIlIIIl);
            if (lllIlIlIlIIlI.apply((Object)lllIlIlIIllll) && this.pos.getDistanceSq(lllIlIlIIllll) < lllIlIlIlIIll * lllIlIlIlIIll) {
                return true;
            }
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public boolean hasPlayerMatching(final Predicate<EntityPlayerMP> lllIlIlIlllIl) {
        return Iterables.tryFind((Iterable)this.players, (Predicate)lllIlIlIlllIl).isPresent();
    }
    
    public double getClosestPlayerDistance() {
        double lllIlIIllllII = Double.MAX_VALUE;
        for (final EntityPlayerMP lllIlIIlllIll : this.players) {
            final double lllIlIIlllIlI = this.pos.getDistanceSq(lllIlIIlllIll);
            if (lllIlIIlllIlI < lllIlIIllllII) {
                lllIlIIllllII = lllIlIIlllIlI;
            }
        }
        return lllIlIIllllII;
    }
    
    private void sendBlockEntity(@Nullable final TileEntity lllIlIllIlIll) {
        if (lllIlIllIlIll != null) {
            final SPacketUpdateTileEntity lllIlIllIlIlI = lllIlIllIlIll.getUpdatePacket();
            if (lllIlIllIlIlI != null) {
                this.sendPacket(lllIlIllIlIlI);
            }
        }
    }
}
