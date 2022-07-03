package net.minecraft.world.chunk.storage;

import net.minecraft.world.storage.*;
import net.minecraft.world.chunk.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO
{
    private final /* synthetic */ Map<ChunkPos, NBTTagCompound> chunksToRemove;
    private final /* synthetic */ Set<ChunkPos> field_193415_c;
    private final /* synthetic */ DataFixer field_193416_e;
    private /* synthetic */ boolean savingExtraData;
    private final /* synthetic */ File chunkSaveLocation;
    private static final /* synthetic */ Logger LOGGER;
    
    protected void addChunkToPending(final ChunkPos llllllllllllllIlIllIIlIlIlIllllI, final NBTTagCompound llllllllllllllIlIllIIlIlIlIlllIl) {
        if (!this.field_193415_c.contains(llllllllllllllIlIllIIlIlIlIllllI)) {
            this.chunksToRemove.put(llllllllllllllIlIllIIlIlIlIllllI, llllllllllllllIlIllIIlIlIlIlllIl);
        }
        ThreadedFileIOBase.getThreadedIOInstance().queueIO(this);
    }
    
    @Override
    public void saveExtraData() {
        try {
            this.savingExtraData = true;
            while (this.writeNextIO()) {}
        }
        finally {
            this.savingExtraData = false;
        }
        this.savingExtraData = false;
    }
    
    private void writeChunkToNBT(final Chunk llllllllllllllIlIllIIlIIlllIIIIl, final World llllllllllllllIlIllIIlIIlllIIIII, final NBTTagCompound llllllllllllllIlIllIIlIIllIlllll) {
        llllllllllllllIlIllIIlIIllIlllll.setInteger("xPos", llllllllllllllIlIllIIlIIlllIIIIl.xPosition);
        llllllllllllllIlIllIIlIIllIlllll.setInteger("zPos", llllllllllllllIlIllIIlIIlllIIIIl.zPosition);
        llllllllllllllIlIllIIlIIllIlllll.setLong("LastUpdate", llllllllllllllIlIllIIlIIlllIIIII.getTotalWorldTime());
        llllllllllllllIlIllIIlIIllIlllll.setIntArray("HeightMap", llllllllllllllIlIllIIlIIlllIIIIl.getHeightMap());
        llllllllllllllIlIllIIlIIllIlllll.setBoolean("TerrainPopulated", llllllllllllllIlIllIIlIIlllIIIIl.isTerrainPopulated());
        llllllllllllllIlIllIIlIIllIlllll.setBoolean("LightPopulated", llllllllllllllIlIllIIlIIlllIIIIl.isLightPopulated());
        llllllllllllllIlIllIIlIIllIlllll.setLong("InhabitedTime", llllllllllllllIlIllIIlIIlllIIIIl.getInhabitedTime());
        final ExtendedBlockStorage[] llllllllllllllIlIllIIlIIllllIllI = llllllllllllllIlIllIIlIIlllIIIIl.getBlockStorageArray();
        final NBTTagList llllllllllllllIlIllIIlIIllllIlIl = new NBTTagList();
        final boolean llllllllllllllIlIllIIlIIllllIlII = llllllllllllllIlIllIIlIIlllIIIII.provider.func_191066_m();
        float llllllllllllllIlIllIIlIIllIllIII;
        for (int length = (llllllllllllllIlIllIIlIIllIllIII = (float)(Object)llllllllllllllIlIllIIlIIllllIllI).length, i = 0; i < length; ++i) {
            final ExtendedBlockStorage llllllllllllllIlIllIIlIIllllIIll = llllllllllllllIlIllIIlIIllIllIII[i];
            if (llllllllllllllIlIllIIlIIllllIIll != Chunk.NULL_BLOCK_STORAGE) {
                final NBTTagCompound llllllllllllllIlIllIIlIIllllIIlI = new NBTTagCompound();
                llllllllllllllIlIllIIlIIllllIIlI.setByte("Y", (byte)(llllllllllllllIlIllIIlIIllllIIll.getYLocation() >> 4 & 0xFF));
                final byte[] llllllllllllllIlIllIIlIIllllIIIl = new byte[4096];
                final NibbleArray llllllllllllllIlIllIIlIIllllIIII = new NibbleArray();
                final NibbleArray llllllllllllllIlIllIIlIIlllIllll = llllllllllllllIlIllIIlIIllllIIll.getData().getDataForNBT(llllllllllllllIlIllIIlIIllllIIIl, llllllllllllllIlIllIIlIIllllIIII);
                llllllllllllllIlIllIIlIIllllIIlI.setByteArray("Blocks", llllllllllllllIlIllIIlIIllllIIIl);
                llllllllllllllIlIllIIlIIllllIIlI.setByteArray("Data", llllllllllllllIlIllIIlIIllllIIII.getData());
                if (llllllllllllllIlIllIIlIIlllIllll != null) {
                    llllllllllllllIlIllIIlIIllllIIlI.setByteArray("Add", llllllllllllllIlIllIIlIIlllIllll.getData());
                }
                llllllllllllllIlIllIIlIIllllIIlI.setByteArray("BlockLight", llllllllllllllIlIllIIlIIllllIIll.getBlocklightArray().getData());
                if (llllllllllllllIlIllIIlIIllllIlII) {
                    llllllllllllllIlIllIIlIIllllIIlI.setByteArray("SkyLight", llllllllllllllIlIllIIlIIllllIIll.getSkylightArray().getData());
                }
                else {
                    llllllllllllllIlIllIIlIIllllIIlI.setByteArray("SkyLight", new byte[llllllllllllllIlIllIIlIIllllIIll.getBlocklightArray().getData().length]);
                }
                llllllllllllllIlIllIIlIIllllIlIl.appendTag(llllllllllllllIlIllIIlIIllllIIlI);
            }
        }
        llllllllllllllIlIllIIlIIllIlllll.setTag("Sections", llllllllllllllIlIllIIlIIllllIlIl);
        llllllllllllllIlIllIIlIIllIlllll.setByteArray("Biomes", llllllllllllllIlIllIIlIIlllIIIIl.getBiomeArray());
        llllllllllllllIlIllIIlIIlllIIIIl.setHasEntities(false);
        final NBTTagList llllllllllllllIlIllIIlIIlllIlllI = new NBTTagList();
        for (int llllllllllllllIlIllIIlIIlllIllIl = 0; llllllllllllllIlIllIIlIIlllIllIl < llllllllllllllIlIllIIlIIlllIIIIl.getEntityLists().length; ++llllllllllllllIlIllIIlIIlllIllIl) {
            llllllllllllllIlIllIIlIIllIllIII = (float)llllllllllllllIlIllIIlIIlllIIIIl.getEntityLists()[llllllllllllllIlIllIIlIIlllIllIl].iterator();
            while (((Iterator)llllllllllllllIlIllIIlIIllIllIII).hasNext()) {
                final Entity llllllllllllllIlIllIIlIIlllIllII = ((Iterator<Entity>)llllllllllllllIlIllIIlIIllIllIII).next();
                final NBTTagCompound llllllllllllllIlIllIIlIIlllIlIll = new NBTTagCompound();
                if (llllllllllllllIlIllIIlIIlllIllII.writeToNBTOptional(llllllllllllllIlIllIIlIIlllIlIll)) {
                    llllllllllllllIlIllIIlIIlllIIIIl.setHasEntities(true);
                    llllllllllllllIlIllIIlIIlllIlllI.appendTag(llllllllllllllIlIllIIlIIlllIlIll);
                }
            }
        }
        llllllllllllllIlIllIIlIIllIlllll.setTag("Entities", llllllllllllllIlIllIIlIIlllIlllI);
        final NBTTagList llllllllllllllIlIllIIlIIlllIlIlI = new NBTTagList();
        llllllllllllllIlIllIIlIIllIllIII = (float)llllllllllllllIlIllIIlIIlllIIIIl.getTileEntityMap().values().iterator();
        while (((Iterator)llllllllllllllIlIllIIlIIllIllIII).hasNext()) {
            final TileEntity llllllllllllllIlIllIIlIIlllIlIIl = ((Iterator<TileEntity>)llllllllllllllIlIllIIlIIllIllIII).next();
            final NBTTagCompound llllllllllllllIlIllIIlIIlllIlIII = llllllllllllllIlIllIIlIIlllIlIIl.writeToNBT(new NBTTagCompound());
            llllllllllllllIlIllIIlIIlllIlIlI.appendTag(llllllllllllllIlIllIIlIIlllIlIII);
        }
        llllllllllllllIlIllIIlIIllIlllll.setTag("TileEntities", llllllllllllllIlIllIIlIIlllIlIlI);
        final List<NextTickListEntry> llllllllllllllIlIllIIlIIlllIIlll = llllllllllllllIlIllIIlIIlllIIIII.getPendingBlockUpdates(llllllllllllllIlIllIIlIIlllIIIIl, false);
        if (llllllllllllllIlIllIIlIIlllIIlll != null) {
            final long llllllllllllllIlIllIIlIIlllIIllI = llllllllllllllIlIllIIlIIlllIIIII.getTotalWorldTime();
            final NBTTagList llllllllllllllIlIllIIlIIlllIIlIl = new NBTTagList();
            for (final NextTickListEntry llllllllllllllIlIllIIlIIlllIIlII : llllllllllllllIlIllIIlIIlllIIlll) {
                final NBTTagCompound llllllllllllllIlIllIIlIIlllIIIll = new NBTTagCompound();
                final ResourceLocation llllllllllllllIlIllIIlIIlllIIIlI = Block.REGISTRY.getNameForObject(llllllllllllllIlIllIIlIIlllIIlII.getBlock());
                llllllllllllllIlIllIIlIIlllIIIll.setString("i", (llllllllllllllIlIllIIlIIlllIIIlI == null) ? "" : llllllllllllllIlIllIIlIIlllIIIlI.toString());
                llllllllllllllIlIllIIlIIlllIIIll.setInteger("x", llllllllllllllIlIllIIlIIlllIIlII.position.getX());
                llllllllllllllIlIllIIlIIlllIIIll.setInteger("y", llllllllllllllIlIllIIlIIlllIIlII.position.getY());
                llllllllllllllIlIllIIlIIlllIIIll.setInteger("z", llllllllllllllIlIllIIlIIlllIIlII.position.getZ());
                llllllllllllllIlIllIIlIIlllIIIll.setInteger("t", (int)(llllllllllllllIlIllIIlIIlllIIlII.scheduledTime - llllllllllllllIlIllIIlIIlllIIllI));
                llllllllllllllIlIllIIlIIlllIIIll.setInteger("p", llllllllllllllIlIllIIlIIlllIIlII.priority);
                llllllllllllllIlIllIIlIIlllIIlIl.appendTag(llllllllllllllIlIllIIlIIlllIIIll);
            }
            llllllllllllllIlIllIIlIIllIlllll.setTag("TileTicks", llllllllllllllIlIllIIlIIlllIIlIl);
        }
    }
    
    @Override
    public void saveExtraChunkData(final World llllllllllllllIlIllIIlIlIIIllIIl, final Chunk llllllllllllllIlIllIIlIlIIIllIII) throws IOException {
    }
    
    private void writeChunkData(final ChunkPos llllllllllllllIlIllIIlIlIIIlllll, final NBTTagCompound llllllllllllllIlIllIIlIlIIIllllI) throws IOException {
        final DataOutputStream llllllllllllllIlIllIIlIlIIlIIIll = RegionFileCache.getChunkOutputStream(this.chunkSaveLocation, llllllllllllllIlIllIIlIlIIIlllll.chunkXPos, llllllllllllllIlIllIIlIlIIIlllll.chunkZPos);
        CompressedStreamTools.write(llllllllllllllIlIllIIlIlIIIllllI, llllllllllllllIlIllIIlIlIIlIIIll);
        llllllllllllllIlIllIIlIlIIlIIIll.close();
    }
    
    public static void spawnEntity(final Entity llllllllllllllIlIllIIlIIIlIlIIIl, final World llllllllllllllIlIllIIlIIIlIlIIll) {
        if (llllllllllllllIlIllIIlIIIlIlIIll.spawnEntityInWorld(llllllllllllllIlIllIIlIIIlIlIIIl) && llllllllllllllIlIllIIlIIIlIlIIIl.isBeingRidden()) {
            for (final Entity llllllllllllllIlIllIIlIIIlIlIIlI : llllllllllllllIlIllIIlIIIlIlIIIl.getPassengers()) {
                spawnEntity(llllllllllllllIlIllIIlIIIlIlIIlI, llllllllllllllIlIllIIlIIIlIlIIll);
            }
        }
    }
    
    public static void registerFixes(final DataFixer llllllllllllllIlIllIIlIlIIIIllII) {
        llllllllllllllIlIllIIlIlIIIIllII.registerWalker(FixTypes.CHUNK, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llIllIlIlllIlI, final NBTTagCompound llIllIlIllIIIl, final int llIllIlIllIIII) {
                if (llIllIlIllIIIl.hasKey("Level", 10)) {
                    final NBTTagCompound llIllIlIllIlll = llIllIlIllIIIl.getCompoundTag("Level");
                    if (llIllIlIllIlll.hasKey("Entities", 9)) {
                        final NBTTagList llIllIlIllIllI = llIllIlIllIlll.getTagList("Entities", 10);
                        for (int llIllIlIllIlIl = 0; llIllIlIllIlIl < llIllIlIllIllI.tagCount(); ++llIllIlIllIlIl) {
                            llIllIlIllIllI.set(llIllIlIllIlIl, llIllIlIlllIlI.process(FixTypes.ENTITY, (NBTTagCompound)llIllIlIllIllI.get(llIllIlIllIlIl), llIllIlIllIIII));
                        }
                    }
                    if (llIllIlIllIlll.hasKey("TileEntities", 9)) {
                        final NBTTagList llIllIlIllIlII = llIllIlIllIlll.getTagList("TileEntities", 10);
                        for (int llIllIlIllIIll = 0; llIllIlIllIIll < llIllIlIllIlII.tagCount(); ++llIllIlIllIIll) {
                            llIllIlIllIlII.set(llIllIlIllIIll, llIllIlIlllIlI.process(FixTypes.BLOCK_ENTITY, (NBTTagCompound)llIllIlIllIlII.get(llIllIlIllIIll), llIllIlIllIIII));
                        }
                    }
                }
                return llIllIlIllIIIl;
            }
        });
    }
    
    @Nullable
    protected Chunk checkedReadChunkFromNBT(final World llllllllllllllIlIllIIlIllIIlIIll, final int llllllllllllllIlIllIIlIllIIlIIIl, final int llllllllllllllIlIllIIlIllIIlllII, final NBTTagCompound llllllllllllllIlIllIIlIllIIllIlI) {
        if (!llllllllllllllIlIllIIlIllIIllIlI.hasKey("Level", 10)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is missing level data, skipping", (Object)llllllllllllllIlIllIIlIllIIlIIIl, (Object)llllllllllllllIlIllIIlIllIIlllII);
            return null;
        }
        final NBTTagCompound llllllllllllllIlIllIIlIllIIllIII = llllllllllllllIlIllIIlIllIIllIlI.getCompoundTag("Level");
        if (!llllllllllllllIlIllIIlIllIIllIII.hasKey("Sections", 9)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is missing block data, skipping", (Object)llllllllllllllIlIllIIlIllIIlIIIl, (Object)llllllllllllllIlIllIIlIllIIlllII);
            return null;
        }
        Chunk llllllllllllllIlIllIIlIllIIlIlll = this.readChunkFromNBT(llllllllllllllIlIllIIlIllIIlIIll, llllllllllllllIlIllIIlIllIIllIII);
        if (!llllllllllllllIlIllIIlIllIIlIlll.isAtLocation(llllllllllllllIlIllIIlIllIIlIIIl, llllllllllllllIlIllIIlIllIIlllII)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is in the wrong location; relocating. (Expected {}, {}, got {}, {})", (Object)llllllllllllllIlIllIIlIllIIlIIIl, (Object)llllllllllllllIlIllIIlIllIIlllII, (Object)llllllllllllllIlIllIIlIllIIlIIIl, (Object)llllllllllllllIlIllIIlIllIIlllII, (Object)llllllllllllllIlIllIIlIllIIlIlll.xPosition, (Object)llllllllllllllIlIllIIlIllIIlIlll.zPosition);
            llllllllllllllIlIllIIlIllIIllIII.setInteger("xPos", llllllllllllllIlIllIIlIllIIlIIIl);
            llllllllllllllIlIllIIlIllIIllIII.setInteger("zPos", llllllllllllllIlIllIIlIllIIlllII);
            llllllllllllllIlIllIIlIllIIlIlll = this.readChunkFromNBT(llllllllllllllIlIllIIlIllIIlIIll, llllllllllllllIlIllIIlIllIIllIII);
        }
        return llllllllllllllIlIllIIlIllIIlIlll;
    }
    
    @Override
    public boolean writeNextIO() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //     4: invokeinterface java/util/Map.isEmpty:()Z
        //     9: ifeq            39
        //    12: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    13: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.savingExtraData:Z
        //    16: ifeq            37
        //    19: getstatic       net/minecraft/world/chunk/storage/AnvilChunkLoader.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    22: ldc_w           "ThreadedAnvilChunkStorage ({}): All chunks are saved"
        //    25: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    26: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunkSaveLocation:Ljava/io/File;
        //    29: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //    32: invokeinterface org/apache/logging/log4j/Logger.info:(Ljava/lang/String;Ljava/lang/Object;)V
        //    37: iconst_0       
        //    38: ireturn        
        //    39: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    40: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //    43: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    48: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    53: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    58: checkcast       Lnet/minecraft/util/math/ChunkPos;
        //    61: astore_1        /* llllllllllllllIlIllIIlIlIIlllIlI */
        //    62: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    63: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //    66: aload_1         /* llllllllllllllIlIllIIlIlIlIIIIll */
        //    67: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //    72: pop            
        //    73: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    74: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //    77: aload_1         /* llllllllllllllIlIllIIlIlIlIIIIll */
        //    78: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    83: checkcast       Lnet/minecraft/nbt/NBTTagCompound;
        //    86: astore_3        /* llllllllllllllIlIllIIlIlIIllllll */
        //    87: aload_3         /* llllllllllllllIlIllIIlIlIIllllll */
        //    88: ifnull          115
        //    91: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //    92: aload_1         /* llllllllllllllIlIllIIlIlIlIIIIll */
        //    93: aload_3         /* llllllllllllllIlIllIIlIlIIllllll */
        //    94: invokespecial   net/minecraft/world/chunk/storage/AnvilChunkLoader.writeChunkData:(Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/nbt/NBTTagCompound;)V
        //    97: goto            115
        //   100: astore          llllllllllllllIlIllIIlIlIIlllllI
        //   102: getstatic       net/minecraft/world/chunk/storage/AnvilChunkLoader.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   105: ldc_w           "Failed to save chunk"
        //   108: aload           llllllllllllllIlIllIIlIlIIlllllI
        //   110: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   115: iconst_1       
        //   116: istore_2        /* llllllllllllllIlIllIIlIlIlIIIIIl */
        //   117: goto            136
        //   120: astore          llllllllllllllIlIllIIlIlIIllIlII
        //   122: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //   123: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //   126: aload_1         /* llllllllllllllIlIllIIlIlIlIIIIll */
        //   127: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //   132: pop            
        //   133: aload           llllllllllllllIlIllIIlIlIIllIlII
        //   135: athrow         
        //   136: aload_0         /* llllllllllllllIlIllIIlIlIlIIIlII */
        //   137: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //   140: aload_1         /* llllllllllllllIlIllIIlIlIlIIIIll */
        //   141: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //   146: pop            
        //   147: iload_2         /* llllllllllllllIlIllIIlIlIlIIIIII */
        //   148: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  91     97     100    115    Ljava/lang/Exception;
        //  62     120    120    136    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public AnvilChunkLoader(final File llllllllllllllIlIllIIlIllllIIIll, final DataFixer llllllllllllllIlIllIIlIlllIllllI) {
        this.chunksToRemove = (Map<ChunkPos, NBTTagCompound>)Maps.newConcurrentMap();
        this.field_193415_c = Collections.newSetFromMap((Map<ChunkPos, Boolean>)Maps.newConcurrentMap());
        this.chunkSaveLocation = llllllllllllllIlIllIIlIllllIIIll;
        this.field_193416_e = llllllllllllllIlIllIIlIlllIllllI;
    }
    
    @Nullable
    public static Entity readChunkEntity(final NBTTagCompound llllllllllllllIlIllIIlIIlIIIllIl, final World llllllllllllllIlIllIIlIIlIIIllII, final Chunk llllllllllllllIlIllIIlIIlIIIlIll) {
        final Entity llllllllllllllIlIllIIlIIlIIIlIlI = createEntityFromNBT(llllllllllllllIlIllIIlIIlIIIllIl, llllllllllllllIlIllIIlIIlIIIllII);
        if (llllllllllllllIlIllIIlIIlIIIlIlI == null) {
            return null;
        }
        llllllllllllllIlIllIIlIIlIIIlIll.addEntity(llllllllllllllIlIllIIlIIlIIIlIlI);
        if (llllllllllllllIlIllIIlIIlIIIllIl.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIllIIlIIlIIIlIIl = llllllllllllllIlIllIIlIIlIIIllIl.getTagList("Passengers", 10);
            for (int llllllllllllllIlIllIIlIIlIIIlIII = 0; llllllllllllllIlIllIIlIIlIIIlIII < llllllllllllllIlIllIIlIIlIIIlIIl.tagCount(); ++llllllllllllllIlIllIIlIIlIIIlIII) {
                final Entity llllllllllllllIlIllIIlIIlIIIIlll = readChunkEntity(llllllllllllllIlIllIIlIIlIIIlIIl.getCompoundTagAt(llllllllllllllIlIllIIlIIlIIIlIII), llllllllllllllIlIllIIlIIlIIIllII, llllllllllllllIlIllIIlIIlIIIlIll);
                if (llllllllllllllIlIllIIlIIlIIIIlll != null) {
                    llllllllllllllIlIllIIlIIlIIIIlll.startRiding(llllllllllllllIlIllIIlIIlIIIlIlI, true);
                }
            }
        }
        return llllllllllllllIlIllIIlIIlIIIlIlI;
    }
    
    @Nullable
    public static Entity readWorldEntity(final NBTTagCompound llllllllllllllIlIllIIlIIIlIIIllI, final World llllllllllllllIlIllIIlIIIlIIIlIl, final boolean llllllllllllllIlIllIIlIIIIllllIl) {
        final Entity llllllllllllllIlIllIIlIIIlIIIIll = createEntityFromNBT(llllllllllllllIlIllIIlIIIlIIIllI, llllllllllllllIlIllIIlIIIlIIIlIl);
        if (llllllllllllllIlIllIIlIIIlIIIIll == null) {
            return null;
        }
        if (llllllllllllllIlIllIIlIIIIllllIl && !llllllllllllllIlIllIIlIIIlIIIlIl.spawnEntityInWorld(llllllllllllllIlIllIIlIIIlIIIIll)) {
            return null;
        }
        if (llllllllllllllIlIllIIlIIIlIIIllI.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIllIIlIIIlIIIIlI = llllllllllllllIlIllIIlIIIlIIIllI.getTagList("Passengers", 10);
            for (int llllllllllllllIlIllIIlIIIlIIIIIl = 0; llllllllllllllIlIllIIlIIIlIIIIIl < llllllllllllllIlIllIIlIIIlIIIIlI.tagCount(); ++llllllllllllllIlIllIIlIIIlIIIIIl) {
                final Entity llllllllllllllIlIllIIlIIIlIIIIII = readWorldEntity(llllllllllllllIlIllIIlIIIlIIIIlI.getCompoundTagAt(llllllllllllllIlIllIIlIIIlIIIIIl), llllllllllllllIlIllIIlIIIlIIIlIl, llllllllllllllIlIllIIlIIIIllllIl);
                if (llllllllllllllIlIllIIlIIIlIIIIII != null) {
                    llllllllllllllIlIllIIlIIIlIIIIII.startRiding(llllllllllllllIlIllIIlIIIlIIIIll, true);
                }
            }
        }
        return llllllllllllllIlIllIIlIIIlIIIIll;
    }
    
    @Nullable
    @Override
    public Chunk loadChunk(final World llllllllllllllIlIllIIlIlllIIlllI, final int llllllllllllllIlIllIIlIlllIIIlII, final int llllllllllllllIlIllIIlIlllIIllII) throws IOException {
        final ChunkPos llllllllllllllIlIllIIlIlllIIlIll = new ChunkPos(llllllllllllllIlIllIIlIlllIIIlII, llllllllllllllIlIllIIlIlllIIllII);
        NBTTagCompound llllllllllllllIlIllIIlIlllIIlIlI = this.chunksToRemove.get(llllllllllllllIlIllIIlIlllIIlIll);
        if (llllllllllllllIlIllIIlIlllIIlIlI == null) {
            final DataInputStream llllllllllllllIlIllIIlIlllIIlIIl = RegionFileCache.getChunkInputStream(this.chunkSaveLocation, llllllllllllllIlIllIIlIlllIIIlII, llllllllllllllIlIllIIlIlllIIllII);
            if (llllllllllllllIlIllIIlIlllIIlIIl == null) {
                return null;
            }
            llllllllllllllIlIllIIlIlllIIlIlI = this.field_193416_e.process(FixTypes.CHUNK, CompressedStreamTools.read(llllllllllllllIlIllIIlIlllIIlIIl));
        }
        return this.checkedReadChunkFromNBT(llllllllllllllIlIllIIlIlllIIlllI, llllllllllllllIlIllIIlIlllIIIlII, llllllllllllllIlIllIIlIlllIIllII, llllllllllllllIlIllIIlIlllIIlIlI);
    }
    
    @Override
    public boolean func_191063_a(final int llllllllllllllIlIllIIlIllIllIIlI, final int llllllllllllllIlIllIIlIllIllIIIl) {
        final ChunkPos llllllllllllllIlIllIIlIllIllIIII = new ChunkPos(llllllllllllllIlIllIIlIllIllIIlI, llllllllllllllIlIllIIlIllIllIIIl);
        final NBTTagCompound llllllllllllllIlIllIIlIllIlIllll = this.chunksToRemove.get(llllllllllllllIlIllIIlIllIllIIII);
        return llllllllllllllIlIllIIlIllIlIllll != null || RegionFileCache.func_191064_f(this.chunkSaveLocation, llllllllllllllIlIllIIlIllIllIIlI, llllllllllllllIlIllIIlIllIllIIIl);
    }
    
    private Chunk readChunkFromNBT(final World llllllllllllllIlIllIIlIIllIIIIII, final NBTTagCompound llllllllllllllIlIllIIlIIlIllllll) {
        final int llllllllllllllIlIllIIlIIlIlllllI = llllllllllllllIlIllIIlIIlIllllll.getInteger("xPos");
        final int llllllllllllllIlIllIIlIIlIllllIl = llllllllllllllIlIllIIlIIlIllllll.getInteger("zPos");
        final Chunk llllllllllllllIlIllIIlIIlIllllII = new Chunk(llllllllllllllIlIllIIlIIllIIIIII, llllllllllllllIlIllIIlIIlIlllllI, llllllllllllllIlIllIIlIIlIllllIl);
        llllllllllllllIlIllIIlIIlIllllII.setHeightMap(llllllllllllllIlIllIIlIIlIllllll.getIntArray("HeightMap"));
        llllllllllllllIlIllIIlIIlIllllII.setTerrainPopulated(llllllllllllllIlIllIIlIIlIllllll.getBoolean("TerrainPopulated"));
        llllllllllllllIlIllIIlIIlIllllII.setLightPopulated(llllllllllllllIlIllIIlIIlIllllll.getBoolean("LightPopulated"));
        llllllllllllllIlIllIIlIIlIllllII.setInhabitedTime(llllllllllllllIlIllIIlIIlIllllll.getLong("InhabitedTime"));
        final NBTTagList llllllllllllllIlIllIIlIIlIlllIll = llllllllllllllIlIllIIlIIlIllllll.getTagList("Sections", 10);
        final int llllllllllllllIlIllIIlIIlIlllIlI = 16;
        final ExtendedBlockStorage[] llllllllllllllIlIllIIlIIlIlllIIl = new ExtendedBlockStorage[16];
        final boolean llllllllllllllIlIllIIlIIlIlllIII = llllllllllllllIlIllIIlIIllIIIIII.provider.func_191066_m();
        for (int llllllllllllllIlIllIIlIIlIllIlll = 0; llllllllllllllIlIllIIlIIlIllIlll < llllllllllllllIlIllIIlIIlIlllIll.tagCount(); ++llllllllllllllIlIllIIlIIlIllIlll) {
            final NBTTagCompound llllllllllllllIlIllIIlIIlIllIllI = llllllllllllllIlIllIIlIIlIlllIll.getCompoundTagAt(llllllllllllllIlIllIIlIIlIllIlll);
            final int llllllllllllllIlIllIIlIIlIllIlIl = llllllllllllllIlIllIIlIIlIllIllI.getByte("Y");
            final ExtendedBlockStorage llllllllllllllIlIllIIlIIlIllIlII = new ExtendedBlockStorage(llllllllllllllIlIllIIlIIlIllIlIl << 4, llllllllllllllIlIllIIlIIlIlllIII);
            final byte[] llllllllllllllIlIllIIlIIlIllIIll = llllllllllllllIlIllIIlIIlIllIllI.getByteArray("Blocks");
            final NibbleArray llllllllllllllIlIllIIlIIlIllIIlI = new NibbleArray(llllllllllllllIlIllIIlIIlIllIllI.getByteArray("Data"));
            final NibbleArray llllllllllllllIlIllIIlIIlIllIIIl = llllllllllllllIlIllIIlIIlIllIllI.hasKey("Add", 7) ? new NibbleArray(llllllllllllllIlIllIIlIIlIllIllI.getByteArray("Add")) : null;
            llllllllllllllIlIllIIlIIlIllIlII.getData().setDataFromNBT(llllllllllllllIlIllIIlIIlIllIIll, llllllllllllllIlIllIIlIIlIllIIlI, llllllllllllllIlIllIIlIIlIllIIIl);
            llllllllllllllIlIllIIlIIlIllIlII.setBlocklightArray(new NibbleArray(llllllllllllllIlIllIIlIIlIllIllI.getByteArray("BlockLight")));
            if (llllllllllllllIlIllIIlIIlIlllIII) {
                llllllllllllllIlIllIIlIIlIllIlII.setSkylightArray(new NibbleArray(llllllllllllllIlIllIIlIIlIllIllI.getByteArray("SkyLight")));
            }
            llllllllllllllIlIllIIlIIlIllIlII.removeInvalidBlocks();
            llllllllllllllIlIllIIlIIlIlllIIl[llllllllllllllIlIllIIlIIlIllIlIl] = llllllllllllllIlIllIIlIIlIllIlII;
        }
        llllllllllllllIlIllIIlIIlIllllII.setStorageArrays(llllllllllllllIlIllIIlIIlIlllIIl);
        if (llllllllllllllIlIllIIlIIlIllllll.hasKey("Biomes", 7)) {
            llllllllllllllIlIllIIlIIlIllllII.setBiomeArray(llllllllllllllIlIllIIlIIlIllllll.getByteArray("Biomes"));
        }
        final NBTTagList llllllllllllllIlIllIIlIIlIllIIII = llllllllllllllIlIllIIlIIlIllllll.getTagList("Entities", 10);
        for (int llllllllllllllIlIllIIlIIlIlIllll = 0; llllllllllllllIlIllIIlIIlIlIllll < llllllllllllllIlIllIIlIIlIllIIII.tagCount(); ++llllllllllllllIlIllIIlIIlIlIllll) {
            final NBTTagCompound llllllllllllllIlIllIIlIIlIlIlllI = llllllllllllllIlIllIIlIIlIllIIII.getCompoundTagAt(llllllllllllllIlIllIIlIIlIlIllll);
            readChunkEntity(llllllllllllllIlIllIIlIIlIlIlllI, llllllllllllllIlIllIIlIIllIIIIII, llllllllllllllIlIllIIlIIlIllllII);
            llllllllllllllIlIllIIlIIlIllllII.setHasEntities(true);
        }
        final NBTTagList llllllllllllllIlIllIIlIIlIlIllIl = llllllllllllllIlIllIIlIIlIllllll.getTagList("TileEntities", 10);
        for (int llllllllllllllIlIllIIlIIlIlIllII = 0; llllllllllllllIlIllIIlIIlIlIllII < llllllllllllllIlIllIIlIIlIlIllIl.tagCount(); ++llllllllllllllIlIllIIlIIlIlIllII) {
            final NBTTagCompound llllllllllllllIlIllIIlIIlIlIlIll = llllllllllllllIlIllIIlIIlIlIllIl.getCompoundTagAt(llllllllllllllIlIllIIlIIlIlIllII);
            final TileEntity llllllllllllllIlIllIIlIIlIlIlIlI = TileEntity.create(llllllllllllllIlIllIIlIIllIIIIII, llllllllllllllIlIllIIlIIlIlIlIll);
            if (llllllllllllllIlIllIIlIIlIlIlIlI != null) {
                llllllllllllllIlIllIIlIIlIllllII.addTileEntity(llllllllllllllIlIllIIlIIlIlIlIlI);
            }
        }
        if (llllllllllllllIlIllIIlIIlIllllll.hasKey("TileTicks", 9)) {
            final NBTTagList llllllllllllllIlIllIIlIIlIlIlIIl = llllllllllllllIlIllIIlIIlIllllll.getTagList("TileTicks", 10);
            for (int llllllllllllllIlIllIIlIIlIlIlIII = 0; llllllllllllllIlIllIIlIIlIlIlIII < llllllllllllllIlIllIIlIIlIlIlIIl.tagCount(); ++llllllllllllllIlIllIIlIIlIlIlIII) {
                final NBTTagCompound llllllllllllllIlIllIIlIIlIlIIlll = llllllllllllllIlIllIIlIIlIlIlIIl.getCompoundTagAt(llllllllllllllIlIllIIlIIlIlIlIII);
                Block llllllllllllllIlIllIIlIIlIlIIlIl = null;
                if (llllllllllllllIlIllIIlIIlIlIIlll.hasKey("i", 8)) {
                    final Block llllllllllllllIlIllIIlIIlIlIIllI = Block.getBlockFromName(llllllllllllllIlIllIIlIIlIlIIlll.getString("i"));
                }
                else {
                    llllllllllllllIlIllIIlIIlIlIIlIl = Block.getBlockById(llllllllllllllIlIllIIlIIlIlIIlll.getInteger("i"));
                }
                llllllllllllllIlIllIIlIIllIIIIII.scheduleBlockUpdate(new BlockPos(llllllllllllllIlIllIIlIIlIlIIlll.getInteger("x"), llllllllllllllIlIllIIlIIlIlIIlll.getInteger("y"), llllllllllllllIlIllIIlIIlIlIIlll.getInteger("z")), llllllllllllllIlIllIIlIIlIlIIlIl, llllllllllllllIlIllIIlIIlIlIIlll.getInteger("t"), llllllllllllllIlIllIIlIIlIlIIlll.getInteger("p"));
            }
        }
        return llllllllllllllIlIllIIlIIlIllllII;
    }
    
    @Override
    public void saveChunk(final World llllllllllllllIlIllIIlIlIllllIII, final Chunk llllllllllllllIlIllIIlIlIllIllII) throws MinecraftException, IOException {
        llllllllllllllIlIllIIlIlIllllIII.checkSessionLock();
        try {
            final NBTTagCompound llllllllllllllIlIllIIlIlIlllIllI = new NBTTagCompound();
            final NBTTagCompound llllllllllllllIlIllIIlIlIlllIlII = new NBTTagCompound();
            llllllllllllllIlIllIIlIlIlllIllI.setTag("Level", llllllllllllllIlIllIIlIlIlllIlII);
            llllllllllllllIlIllIIlIlIlllIllI.setInteger("DataVersion", 1343);
            this.writeChunkToNBT(llllllllllllllIlIllIIlIlIllIllII, llllllllllllllIlIllIIlIlIllllIII, llllllllllllllIlIllIIlIlIlllIlII);
            this.addChunkToPending(llllllllllllllIlIllIIlIlIllIllII.getChunkCoordIntPair(), llllllllllllllIlIllIIlIlIlllIllI);
        }
        catch (Exception llllllllllllllIlIllIIlIlIlllIIlI) {
            AnvilChunkLoader.LOGGER.error("Failed to save chunk", (Throwable)llllllllllllllIlIllIIlIlIlllIIlI);
        }
    }
    
    @Override
    public void chunkTick() {
    }
    
    @Nullable
    public static Entity readWorldEntityPos(final NBTTagCompound llllllllllllllIlIllIIlIIIllIlIll, final World llllllllllllllIlIllIIlIIIlllIlII, final double llllllllllllllIlIllIIlIIIllIlIIl, final double llllllllllllllIlIllIIlIIIlllIIlI, final double llllllllllllllIlIllIIlIIIlllIIIl, final boolean llllllllllllllIlIllIIlIIIlllIIII) {
        final Entity llllllllllllllIlIllIIlIIIllIllll = createEntityFromNBT(llllllllllllllIlIllIIlIIIllIlIll, llllllllllllllIlIllIIlIIIlllIlII);
        if (llllllllllllllIlIllIIlIIIllIllll == null) {
            return null;
        }
        llllllllllllllIlIllIIlIIIllIllll.setLocationAndAngles(llllllllllllllIlIllIIlIIIllIlIIl, llllllllllllllIlIllIIlIIIlllIIlI, llllllllllllllIlIllIIlIIIlllIIIl, llllllllllllllIlIllIIlIIIllIllll.rotationYaw, llllllllllllllIlIllIIlIIIllIllll.rotationPitch);
        if (llllllllllllllIlIllIIlIIIlllIIII && !llllllllllllllIlIllIIlIIIlllIlII.spawnEntityInWorld(llllllllllllllIlIllIIlIIIllIllll)) {
            return null;
        }
        if (llllllllllllllIlIllIIlIIIllIlIll.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIllIIlIIIllIlllI = llllllllllllllIlIllIIlIIIllIlIll.getTagList("Passengers", 10);
            for (int llllllllllllllIlIllIIlIIIllIllIl = 0; llllllllllllllIlIllIIlIIIllIllIl < llllllllllllllIlIllIIlIIIllIlllI.tagCount(); ++llllllllllllllIlIllIIlIIIllIllIl) {
                final Entity llllllllllllllIlIllIIlIIIllIllII = readWorldEntityPos(llllllllllllllIlIllIIlIIIllIlllI.getCompoundTagAt(llllllllllllllIlIllIIlIIIllIllIl), llllllllllllllIlIllIIlIIIlllIlII, llllllllllllllIlIllIIlIIIllIlIIl, llllllllllllllIlIllIIlIIIlllIIlI, llllllllllllllIlIllIIlIIIlllIIIl, llllllllllllllIlIllIIlIIIlllIIII);
                if (llllllllllllllIlIllIIlIIIllIllII != null) {
                    llllllllllllllIlIllIIlIIIllIllII.startRiding(llllllllllllllIlIllIIlIIIllIllll, true);
                }
            }
        }
        return llllllllllllllIlIllIIlIIIllIllll;
    }
    
    @Nullable
    protected static Entity createEntityFromNBT(final NBTTagCompound llllllllllllllIlIllIIlIIIlIllIll, final World llllllllllllllIlIllIIlIIIlIlllIl) {
        try {
            return EntityList.createEntityFromNBT(llllllllllllllIlIllIIlIIIlIllIll, llllllllllllllIlIllIIlIIIlIlllIl);
        }
        catch (RuntimeException llllllllllllllIlIllIIlIIIlIlllII) {
            return null;
        }
    }
}
