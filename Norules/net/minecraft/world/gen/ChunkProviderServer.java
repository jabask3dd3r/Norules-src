package net.minecraft.world.gen;

import net.minecraft.world.chunk.storage.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import it.unimi.dsi.fastutil.objects.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.*;
import net.minecraft.world.biome.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import java.util.*;
import com.google.common.collect.*;
import it.unimi.dsi.fastutil.longs.*;

public class ChunkProviderServer implements IChunkProvider
{
    private final /* synthetic */ IChunkLoader chunkLoader;
    private final /* synthetic */ WorldServer worldObj;
    private final /* synthetic */ Set<Long> droppedChunksSet;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ IChunkGenerator chunkGenerator;
    private final /* synthetic */ Long2ObjectMap<Chunk> id2ChunkMap;
    
    public boolean func_193413_a(final World llllllllllllllIlIIlIIIIllIlIIlIl, final String llllllllllllllIlIIlIIIIllIlIIlII, final BlockPos llllllllllllllIlIIlIIIIllIlIIIll) {
        return this.chunkGenerator.func_193414_a(llllllllllllllIlIIlIIIIllIlIIlIl, llllllllllllllIlIIlIIIIllIlIIlII, llllllllllllllIlIIlIIIIllIlIIIll);
    }
    
    @Nullable
    public Chunk loadChunk(final int llllllllllllllIlIIlIIIlIIIlIlIll, final int llllllllllllllIlIIlIIIlIIIlIlIlI) {
        Chunk llllllllllllllIlIIlIIIlIIIlIllIl = this.getLoadedChunk(llllllllllllllIlIIlIIIlIIIlIlIll, llllllllllllllIlIIlIIIlIIIlIlIlI);
        if (llllllllllllllIlIIlIIIlIIIlIllIl == null) {
            llllllllllllllIlIIlIIIlIIIlIllIl = this.loadChunkFromFile(llllllllllllllIlIIlIIIlIIIlIlIll, llllllllllllllIlIIlIIIlIIIlIlIlI);
            if (llllllllllllllIlIIlIIIlIIIlIllIl != null) {
                this.id2ChunkMap.put(ChunkPos.asLong(llllllllllllllIlIIlIIIlIIIlIlIll, llllllllllllllIlIIlIIIlIIIlIlIlI), (Object)llllllllllllllIlIIlIIIlIIIlIllIl);
                llllllllllllllIlIIlIIIlIIIlIllIl.onChunkLoad();
                llllllllllllllIlIIlIIIlIIIlIllIl.populateChunk(this, this.chunkGenerator);
            }
        }
        return llllllllllllllIlIIlIIIlIIIlIllIl;
    }
    
    private void saveChunkExtraData(final Chunk llllllllllllllIlIIlIIIIlllllllII) {
        try {
            this.chunkLoader.saveExtraChunkData(this.worldObj, llllllllllllllIlIIlIIIIlllllllII);
        }
        catch (Exception llllllllllllllIlIIlIIIIllllllllI) {
            ChunkProviderServer.LOGGER.error("Couldn't save entities", (Throwable)llllllllllllllIlIIlIIIIllllllllI);
        }
    }
    
    public int getLoadedChunkCount() {
        return this.id2ChunkMap.size();
    }
    
    @Nullable
    public BlockPos getStrongholdGen(final World llllllllllllllIlIIlIIIIllIllIlll, final String llllllllllllllIlIIlIIIIllIllIIIl, final BlockPos llllllllllllllIlIIlIIIIllIllIlIl, final boolean llllllllllllllIlIIlIIIIllIlIllll) {
        return this.chunkGenerator.getStrongholdGen(llllllllllllllIlIIlIIIIllIllIlll, llllllllllllllIlIIlIIIIllIllIIIl, llllllllllllllIlIIlIIIIllIllIlIl, llllllllllllllIlIIlIIIIllIlIllll);
    }
    
    @Override
    public boolean func_191062_e(final int llllllllllllllIlIIlIIIIllIIlIIlI, final int llllllllllllllIlIIlIIIIllIIlIIIl) {
        return this.id2ChunkMap.containsKey(ChunkPos.asLong(llllllllllllllIlIIlIIIIllIIlIIlI, llllllllllllllIlIIlIIIIllIIlIIIl)) || this.chunkLoader.func_191063_a(llllllllllllllIlIIlIIIIllIIlIIlI, llllllllllllllIlIIlIIIIllIIlIIIl);
    }
    
    @Nullable
    @Override
    public Chunk getLoadedChunk(final int llllllllllllllIlIIlIIIlIIIlllIII, final int llllllllllllllIlIIlIIIlIIIllllII) {
        final long llllllllllllllIlIIlIIIlIIIlllIll = ChunkPos.asLong(llllllllllllllIlIIlIIIlIIIlllIII, llllllllllllllIlIIlIIIlIIIllllII);
        final Chunk llllllllllllllIlIIlIIIlIIIlllIlI = (Chunk)this.id2ChunkMap.get(llllllllllllllIlIIlIIIlIIIlllIll);
        if (llllllllllllllIlIIlIIIlIIIlllIlI != null) {
            llllllllllllllIlIIlIIIlIIIlllIlI.unloaded = false;
        }
        return llllllllllllllIlIIlIIIlIIIlllIlI;
    }
    
    public void unloadAllChunks() {
        for (final Chunk llllllllllllllIlIIlIIIlIIlIIIlll : this.id2ChunkMap.values()) {
            this.unload(llllllllllllllIlIIlIIIlIIlIIIlll);
        }
    }
    
    public boolean saveChunks(final boolean llllllllllllllIlIIlIIIIllllIlIIl) {
        int llllllllllllllIlIIlIIIIllllIlIII = 0;
        final List<Chunk> llllllllllllllIlIIlIIIIllllIIlll = (List<Chunk>)Lists.newArrayList((Iterable)this.id2ChunkMap.values());
        for (int llllllllllllllIlIIlIIIIllllIIllI = 0; llllllllllllllIlIIlIIIIllllIIllI < llllllllllllllIlIIlIIIIllllIIlll.size(); ++llllllllllllllIlIIlIIIIllllIIllI) {
            final Chunk llllllllllllllIlIIlIIIIllllIIlIl = llllllllllllllIlIIlIIIIllllIIlll.get(llllllllllllllIlIIlIIIIllllIIllI);
            if (llllllllllllllIlIIlIIIIllllIlIIl) {
                this.saveChunkExtraData(llllllllllllllIlIIlIIIIllllIIlIl);
            }
            if (llllllllllllllIlIIlIIIIllllIIlIl.needsSaving(llllllllllllllIlIIlIIIIllllIlIIl)) {
                this.saveChunkData(llllllllllllllIlIIlIIIIllllIIlIl);
                llllllllllllllIlIIlIIIIllllIIlIl.setModified(false);
                if (++llllllllllllllIlIIlIIIIllllIlIII == 24 && !llllllllllllllIlIIlIIIIllllIlIIl) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void saveExtraData() {
        this.chunkLoader.saveExtraData();
    }
    
    public Collection<Chunk> getLoadedChunks() {
        return (Collection<Chunk>)this.id2ChunkMap.values();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public boolean chunkExists(final int llllllllllllllIlIIlIIIIllIIllIII, final int llllllllllllllIlIIlIIIIllIIlIlll) {
        return this.id2ChunkMap.containsKey(ChunkPos.asLong(llllllllllllllIlIIlIIIIllIIllIII, llllllllllllllIlIIlIIIIllIIlIlll));
    }
    
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType llllllllllllllIlIIlIIIIllIllllll, final BlockPos llllllllllllllIlIIlIIIIllIlllllI) {
        return this.chunkGenerator.getPossibleCreatures(llllllllllllllIlIIlIIIIllIllllll, llllllllllllllIlIIlIIIIllIlllllI);
    }
    
    public void unload(final Chunk llllllllllllllIlIIlIIIlIIlIIllIl) {
        if (this.worldObj.provider.canDropChunk(llllllllllllllIlIIlIIIlIIlIIllIl.xPosition, llllllllllllllIlIIlIIIlIIlIIllIl.zPosition)) {
            this.droppedChunksSet.add(ChunkPos.asLong(llllllllllllllIlIIlIIIlIIlIIllIl.xPosition, llllllllllllllIlIIlIIIlIIlIIllIl.zPosition));
            llllllllllllllIlIIlIIIlIIlIIllIl.unloaded = true;
        }
    }
    
    private void saveChunkData(final Chunk llllllllllllllIlIIlIIIIlllllIIlI) {
        try {
            llllllllllllllIlIIlIIIIlllllIIlI.setLastSaveTime(this.worldObj.getTotalWorldTime());
            this.chunkLoader.saveChunk(this.worldObj, llllllllllllllIlIIlIIIIlllllIIlI);
        }
        catch (IOException llllllllllllllIlIIlIIIIlllllIlIl) {
            ChunkProviderServer.LOGGER.error("Couldn't save chunk", (Throwable)llllllllllllllIlIIlIIIIlllllIlIl);
        }
        catch (MinecraftException llllllllllllllIlIIlIIIIlllllIlII) {
            ChunkProviderServer.LOGGER.error("Couldn't save chunk; already in use by another instance of Minecraft?", (Throwable)llllllllllllllIlIIlIIIIlllllIlII);
        }
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllllIlIIlIIIlIIIIlIlll, final int llllllllllllllIlIIlIIIlIIIIlIllI) {
        Chunk llllllllllllllIlIIlIIIlIIIIlllIl = this.loadChunk(llllllllllllllIlIIlIIIlIIIIlIlll, llllllllllllllIlIIlIIIlIIIIlIllI);
        if (llllllllllllllIlIIlIIIlIIIIlllIl == null) {
            final long llllllllllllllIlIIlIIIlIIIIlllII = ChunkPos.asLong(llllllllllllllIlIIlIIIlIIIIlIlll, llllllllllllllIlIIlIIIlIIIIlIllI);
            try {
                llllllllllllllIlIIlIIIlIIIIlllIl = this.chunkGenerator.provideChunk(llllllllllllllIlIIlIIIlIIIIlIlll, llllllllllllllIlIIlIIIlIIIIlIllI);
            }
            catch (Throwable llllllllllllllIlIIlIIIlIIIIllIll) {
                final CrashReport llllllllllllllIlIIlIIIlIIIIllIlI = CrashReport.makeCrashReport(llllllllllllllIlIIlIIIlIIIIllIll, "Exception generating new chunk");
                final CrashReportCategory llllllllllllllIlIIlIIIlIIIIllIIl = llllllllllllllIlIIlIIIlIIIIllIlI.makeCategory("Chunk to be generated");
                llllllllllllllIlIIlIIIlIIIIllIIl.addCrashSection("Location", String.format("%d,%d", llllllllllllllIlIIlIIIlIIIIlIlll, llllllllllllllIlIIlIIIlIIIIlIllI));
                llllllllllllllIlIIlIIIlIIIIllIIl.addCrashSection("Position hash", llllllllllllllIlIIlIIIlIIIIlllII);
                llllllllllllllIlIIlIIIlIIIIllIIl.addCrashSection("Generator", this.chunkGenerator);
                throw new ReportedException(llllllllllllllIlIIlIIIlIIIIllIlI);
            }
            this.id2ChunkMap.put(llllllllllllllIlIIlIIIlIIIIlllII, (Object)llllllllllllllIlIIlIIIlIIIIlllIl);
            llllllllllllllIlIIlIIIlIIIIlllIl.onChunkLoad();
            llllllllllllllIlIIlIIIlIIIIlllIl.populateChunk(this, this.chunkGenerator);
        }
        return llllllllllllllIlIIlIIIlIIIIlllIl;
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        if (!this.worldObj.disableLevelSaving) {
            if (!this.droppedChunksSet.isEmpty()) {
                final Iterator<Long> llllllllllllllIlIIlIIIIlllIlIlIl = this.droppedChunksSet.iterator();
                int llllllllllllllIlIIlIIIIlllIlIlII = 0;
                while (llllllllllllllIlIIlIIIIlllIlIlII < 100 && llllllllllllllIlIIlIIIIlllIlIlIl.hasNext()) {
                    final Long llllllllllllllIlIIlIIIIlllIlIIll = llllllllllllllIlIIlIIIIlllIlIlIl.next();
                    final Chunk llllllllllllllIlIIlIIIIlllIlIIlI = (Chunk)this.id2ChunkMap.get((Object)llllllllllllllIlIIlIIIIlllIlIIll);
                    if (llllllllllllllIlIIlIIIIlllIlIIlI != null && llllllllllllllIlIIlIIIIlllIlIIlI.unloaded) {
                        llllllllllllllIlIIlIIIIlllIlIIlI.onChunkUnload();
                        this.saveChunkData(llllllllllllllIlIIlIIIIlllIlIIlI);
                        this.saveChunkExtraData(llllllllllllllIlIIlIIIIlllIlIIlI);
                        this.id2ChunkMap.remove((Object)llllllllllllllIlIIlIIIIlllIlIIll);
                        ++llllllllllllllIlIIlIIIIlllIlIlII;
                    }
                    llllllllllllllIlIIlIIIIlllIlIlIl.remove();
                }
            }
            this.chunkLoader.chunkTick();
        }
        return false;
    }
    
    @Override
    public String makeString() {
        return String.valueOf(new StringBuilder("ServerChunkCache: ").append(this.id2ChunkMap.size()).append(" Drop: ").append(this.droppedChunksSet.size()));
    }
    
    public ChunkProviderServer(final WorldServer llllllllllllllIlIIlIIIlIIlIllIII, final IChunkLoader llllllllllllllIlIIlIIIlIIlIlIlll, final IChunkGenerator llllllllllllllIlIIlIIIlIIlIlIllI) {
        this.droppedChunksSet = (Set<Long>)Sets.newHashSet();
        this.id2ChunkMap = (Long2ObjectMap<Chunk>)new Long2ObjectOpenHashMap(8192);
        this.worldObj = llllllllllllllIlIIlIIIlIIlIllIII;
        this.chunkLoader = llllllllllllllIlIIlIIIlIIlIlIlll;
        this.chunkGenerator = llllllllllllllIlIIlIIIlIIlIlIllI;
    }
    
    public boolean canSave() {
        return !this.worldObj.disableLevelSaving;
    }
    
    @Nullable
    private Chunk loadChunkFromFile(final int llllllllllllllIlIIlIIIlIIIIIIllI, final int llllllllllllllIlIIlIIIlIIIIIIlIl) {
        try {
            final Chunk llllllllllllllIlIIlIIIlIIIIIlIIl = this.chunkLoader.loadChunk(this.worldObj, llllllllllllllIlIIlIIIlIIIIIIllI, llllllllllllllIlIIlIIIlIIIIIIlIl);
            if (llllllllllllllIlIIlIIIlIIIIIlIIl != null) {
                llllllllllllllIlIIlIIIlIIIIIlIIl.setLastSaveTime(this.worldObj.getTotalWorldTime());
                this.chunkGenerator.recreateStructures(llllllllllllllIlIIlIIIlIIIIIlIIl, llllllllllllllIlIIlIIIlIIIIIIllI, llllllllllllllIlIIlIIIlIIIIIIlIl);
            }
            return llllllllllllllIlIIlIIIlIIIIIlIIl;
        }
        catch (Exception llllllllllllllIlIIlIIIlIIIIIlIII) {
            ChunkProviderServer.LOGGER.error("Couldn't load chunk", (Throwable)llllllllllllllIlIIlIIIlIIIIIlIII);
            return null;
        }
    }
}
