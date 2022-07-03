package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.*;
import net.minecraft.crash.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import com.google.common.util.concurrent.*;
import javax.annotation.*;
import java.util.concurrent.*;
import net.minecraft.world.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class ChunkRenderWorker implements Runnable
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ RegionRenderCacheBuilder regionRenderCacheBuilder;
    private final /* synthetic */ ChunkRenderDispatcher chunkRenderDispatcher;
    private /* synthetic */ boolean shouldRun;
    
    private void freeRenderBuilder(final ChunkCompileTaskGenerator llllllllllllllIlIIlIIIIlIIIIlIll) {
        if (this.regionRenderCacheBuilder == null) {
            this.chunkRenderDispatcher.freeRenderBuilder(llllllllllllllIlIIlIIIIlIIIIlIll.getRegionRenderCacheBuilder());
        }
    }
    
    public void notifyToStop() {
        this.shouldRun = false;
    }
    
    @Override
    public void run() {
        while (this.shouldRun) {
            try {
                this.processTask(this.chunkRenderDispatcher.getNextChunkUpdate());
            }
            catch (InterruptedException llllllllllllllIlIIlIIIIlIlIIllII) {
                ChunkRenderWorker.LOGGER.debug("Stopping chunk worker due to interrupt");
            }
            catch (Throwable llllllllllllllIlIIlIIIIlIlIIlIll) {
                final CrashReport llllllllllllllIlIIlIIIIlIlIIlIlI = CrashReport.makeCrashReport(llllllllllllllIlIIlIIIIlIlIIlIll, "Batching chunks");
                Minecraft.getMinecraft().crashed(Minecraft.getMinecraft().addGraphicsAndWorldToCrashReport(llllllllllllllIlIIlIIIIlIlIIlIlI));
            }
        }
    }
    
    protected void processTask(final ChunkCompileTaskGenerator llllllllllllllIlIIlIIIIlIIlllIII) throws InterruptedException {
        llllllllllllllIlIIlIIIIlIIlllIII.getLock().lock();
        try {
            if (llllllllllllllIlIIlIIIIlIIlllIII.getStatus() != ChunkCompileTaskGenerator.Status.PENDING) {
                if (!llllllllllllllIlIIlIIIIlIIlllIII.isFinished()) {
                    ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be pending; ignoring task", (Object)llllllllllllllIlIIlIIIIlIIlllIII.getStatus());
                }
                return;
            }
            final BlockPos llllllllllllllIlIIlIIIIlIIllIlll = new BlockPos(Minecraft.getMinecraft().player);
            final BlockPos llllllllllllllIlIIlIIIIlIIllIllI = llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk().getPosition();
            final int llllllllllllllIlIIlIIIIlIIllIlIl = 16;
            final int llllllllllllllIlIIlIIIIlIIllIlII = 8;
            final int llllllllllllllIlIIlIIIIlIIllIIll = 24;
            if (llllllllllllllIlIIlIIIIlIIllIllI.add(8, 8, 8).distanceSq(llllllllllllllIlIIlIIIIlIIllIlll) > 576.0) {
                final World llllllllllllllIlIIlIIIIlIIllIIlI = llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk().getWorld();
                final BlockPos.MutableBlockPos llllllllllllllIlIIlIIIIlIIllIIIl = new BlockPos.MutableBlockPos(llllllllllllllIlIIlIIIIlIIllIllI);
                if (!this.isChunkExisting(llllllllllllllIlIIlIIIIlIIllIIIl.setPos(llllllllllllllIlIIlIIIIlIIllIllI).move(EnumFacing.WEST, 16), llllllllllllllIlIIlIIIIlIIllIIlI) || !this.isChunkExisting(llllllllllllllIlIIlIIIIlIIllIIIl.setPos(llllllllllllllIlIIlIIIIlIIllIllI).move(EnumFacing.NORTH, 16), llllllllllllllIlIIlIIIIlIIllIIlI) || !this.isChunkExisting(llllllllllllllIlIIlIIIIlIIllIIIl.setPos(llllllllllllllIlIIlIIIIlIIllIllI).move(EnumFacing.EAST, 16), llllllllllllllIlIIlIIIIlIIllIIlI) || !this.isChunkExisting(llllllllllllllIlIIlIIIIlIIllIIIl.setPos(llllllllllllllIlIIlIIIIlIIllIllI).move(EnumFacing.SOUTH, 16), llllllllllllllIlIIlIIIIlIIllIIlI)) {
                    return;
                }
            }
            llllllllllllllIlIIlIIIIlIIlllIII.setStatus(ChunkCompileTaskGenerator.Status.COMPILING);
        }
        finally {
            llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
        }
        llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
        final Entity llllllllllllllIlIIlIIIIlIIllIIII = Minecraft.getMinecraft().getRenderViewEntity();
        if (llllllllllllllIlIIlIIIIlIIllIIII == null) {
            llllllllllllllIlIIlIIIIlIIlllIII.finish();
        }
        else {
            llllllllllllllIlIIlIIIIlIIlllIII.setRegionRenderCacheBuilder(this.getRegionRenderCacheBuilder());
            final float llllllllllllllIlIIlIIIIlIIlIllll = (float)llllllllllllllIlIIlIIIIlIIllIIII.posX;
            final float llllllllllllllIlIIlIIIIlIIlIlllI = (float)llllllllllllllIlIIlIIIIlIIllIIII.posY + llllllllllllllIlIIlIIIIlIIllIIII.getEyeHeight();
            final float llllllllllllllIlIIlIIIIlIIlIllIl = (float)llllllllllllllIlIIlIIIIlIIllIIII.posZ;
            final ChunkCompileTaskGenerator.Type llllllllllllllIlIIlIIIIlIIlIllII = llllllllllllllIlIIlIIIIlIIlllIII.getType();
            if (llllllllllllllIlIIlIIIIlIIlIllII == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk().rebuildChunk(llllllllllllllIlIIlIIIIlIIlIllll, llllllllllllllIlIIlIIIIlIIlIlllI, llllllllllllllIlIIlIIIIlIIlIllIl, llllllllllllllIlIIlIIIIlIIlllIII);
            }
            else if (llllllllllllllIlIIlIIIIlIIlIllII == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk().resortTransparency(llllllllllllllIlIIlIIIIlIIlIllll, llllllllllllllIlIIlIIIIlIIlIlllI, llllllllllllllIlIIlIIIIlIIlIllIl, llllllllllllllIlIIlIIIIlIIlllIII);
            }
            llllllllllllllIlIIlIIIIlIIlllIII.getLock().lock();
            try {
                if (llllllllllllllIlIIlIIIIlIIlllIII.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                    if (!llllllllllllllIlIIlIIIIlIIlllIII.isFinished()) {
                        ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be compiling; aborting task", (Object)llllllllllllllIlIIlIIIIlIIlllIII.getStatus());
                    }
                    this.freeRenderBuilder(llllllllllllllIlIIlIIIIlIIlllIII);
                    return;
                }
                llllllllllllllIlIIlIIIIlIIlllIII.setStatus(ChunkCompileTaskGenerator.Status.UPLOADING);
            }
            finally {
                llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
            }
            llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
            final CompiledChunk llllllllllllllIlIIlIIIIlIIlIlIll = llllllllllllllIlIIlIIIIlIIlllIII.getCompiledChunk();
            final ArrayList llllllllllllllIlIIlIIIIlIIlIlIlI = Lists.newArrayList();
            if (llllllllllllllIlIIlIIIIlIIlIllII == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                String llllllllllllllIlIIlIIIIlIIIllIll;
                for (short llllllllllllllIlIIlIIIIlIIIlllII = (short)((BlockRenderLayer[])(Object)(llllllllllllllIlIIlIIIIlIIIllIll = (String)(Object)BlockRenderLayer.values())).length, llllllllllllllIlIIlIIIIlIIIlllIl = 0; llllllllllllllIlIIlIIIIlIIIlllIl < llllllllllllllIlIIlIIIIlIIIlllII; ++llllllllllllllIlIIlIIIIlIIIlllIl) {
                    final BlockRenderLayer llllllllllllllIlIIlIIIIlIIlIlIIl = llllllllllllllIlIIlIIIIlIIIllIll[llllllllllllllIlIIlIIIIlIIIlllIl];
                    if (llllllllllllllIlIIlIIIIlIIlIlIll.isLayerStarted(llllllllllllllIlIIlIIIIlIIlIlIIl)) {
                        llllllllllllllIlIIlIIIIlIIlIlIlI.add(this.chunkRenderDispatcher.uploadChunk(llllllllllllllIlIIlIIIIlIIlIlIIl, llllllllllllllIlIIlIIIIlIIlllIII.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllllIlIIlIIIIlIIlIlIIl), llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk(), llllllllllllllIlIIlIIIIlIIlIlIll, llllllllllllllIlIIlIIIIlIIlllIII.getDistanceSq()));
                    }
                }
            }
            else if (llllllllllllllIlIIlIIIIlIIlIllII == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                llllllllllllllIlIIlIIIIlIIlIlIlI.add(this.chunkRenderDispatcher.uploadChunk(BlockRenderLayer.TRANSLUCENT, llllllllllllllIlIIlIIIIlIIlllIII.getRegionRenderCacheBuilder().getWorldRendererByLayer(BlockRenderLayer.TRANSLUCENT), llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk(), llllllllllllllIlIIlIIIIlIIlIlIll, llllllllllllllIlIIlIIIIlIIlllIII.getDistanceSq()));
            }
            final ListenableFuture<List<Object>> llllllllllllllIlIIlIIIIlIIlIlIII = (ListenableFuture<List<Object>>)Futures.allAsList((Iterable)llllllllllllllIlIIlIIIIlIIlIlIlI);
            llllllllllllllIlIIlIIIIlIIlllIII.addFinishRunnable(new Runnable() {
                @Override
                public void run() {
                    llllllllllllllIlIIlIIIIlIIlIlIII.cancel(false);
                }
            });
            Futures.addCallback((ListenableFuture)llllllllllllllIlIIlIIIIlIIlIlIII, (FutureCallback)new FutureCallback<List<Object>>() {
                public void onSuccess(@Nullable final List<Object> lllllllllllllIIllIllllIIllllIIII) {
                    ChunkRenderWorker.this.freeRenderBuilder(llllllllllllllIlIIlIIIIlIIlllIII);
                    llllllllllllllIlIIlIIIIlIIlllIII.getLock().lock();
                    try {
                        if (llllllllllllllIlIIlIIIIlIIlllIII.getStatus() != ChunkCompileTaskGenerator.Status.UPLOADING) {
                            if (!llllllllllllllIlIIlIIIIlIIlllIII.isFinished()) {
                                ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be uploading; aborting task", (Object)llllllllllllllIlIIlIIIIlIIlllIII.getStatus());
                            }
                            return;
                        }
                        llllllllllllllIlIIlIIIIlIIlllIII.setStatus(ChunkCompileTaskGenerator.Status.DONE);
                    }
                    finally {
                        llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
                    }
                    llllllllllllllIlIIlIIIIlIIlllIII.getLock().unlock();
                    llllllllllllllIlIIlIIIIlIIlllIII.getRenderChunk().setCompiledChunk(llllllllllllllIlIIlIIIIlIIlIlIll);
                }
                
                public void onFailure(final Throwable lllllllllllllIIllIllllIIlllIlIII) {
                    ChunkRenderWorker.this.freeRenderBuilder(llllllllllllllIlIIlIIIIlIIlllIII);
                    if (!(lllllllllllllIIllIllllIIlllIlIII instanceof CancellationException) && !(lllllllllllllIIllIllllIIlllIlIII instanceof InterruptedException)) {
                        Minecraft.getMinecraft().crashed(CrashReport.makeCrashReport(lllllllllllllIIllIllllIIlllIlIII, "Rendering chunk"));
                    }
                }
            });
        }
    }
    
    private boolean isChunkExisting(final BlockPos llllllllllllllIlIIlIIIIlIIIlIlIl, final World llllllllllllllIlIIlIIIIlIIIlIlII) {
        return llllllllllllllIlIIlIIIIlIIIlIlII != null && !llllllllllllllIlIIlIIIIlIIIlIlII.getChunkFromChunkCoords(llllllllllllllIlIIlIIIIlIIIlIlIl.getX() >> 4, llllllllllllllIlIIlIIIIlIIIlIlIl.getZ() >> 4).isEmpty();
    }
    
    public ChunkRenderWorker(final ChunkRenderDispatcher llllllllllllllIlIIlIIIIlIlIllIlI) {
        this(llllllllllllllIlIIlIIIIlIlIllIlI, null);
    }
    
    public ChunkRenderWorker(final ChunkRenderDispatcher llllllllllllllIlIIlIIIIlIlIlIlIl, @Nullable final RegionRenderCacheBuilder llllllllllllllIlIIlIIIIlIlIlIlII) {
        this.shouldRun = true;
        this.chunkRenderDispatcher = llllllllllllllIlIIlIIIIlIlIlIlIl;
        this.regionRenderCacheBuilder = llllllllllllllIlIIlIIIIlIlIlIlII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private RegionRenderCacheBuilder getRegionRenderCacheBuilder() throws InterruptedException {
        return (this.regionRenderCacheBuilder != null) ? this.regionRenderCacheBuilder : this.chunkRenderDispatcher.allocateRenderBuilder();
    }
}
