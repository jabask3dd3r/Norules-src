package net.minecraft.client.renderer.chunk;

import java.util.concurrent.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import com.google.common.util.concurrent.*;
import com.google.common.primitives.*;

public class ChunkRenderDispatcher
{
    private final /* synthetic */ PriorityBlockingQueue<ChunkCompileTaskGenerator> queueChunkUpdates;
    private final /* synthetic */ List<ChunkRenderWorker> listThreadedWorkers;
    private final /* synthetic */ int countRenderBuilders;
    private final /* synthetic */ VertexBufferUploader vertexUploader;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<Thread> listWorkerThreads;
    private final /* synthetic */ WorldVertexBufferUploader worldVertexUploader;
    private static final /* synthetic */ ThreadFactory THREAD_FACTORY;
    private final /* synthetic */ Queue<PendingUpload> queueChunkUploads;
    private final /* synthetic */ BlockingQueue<RegionRenderCacheBuilder> queueFreeRenderBuilders;
    private final /* synthetic */ ChunkRenderWorker renderWorker;
    
    public boolean hasNoFreeRenderBuilders() {
        return this.queueFreeRenderBuilders.isEmpty();
    }
    
    public boolean hasChunkUpdates() {
        return this.queueChunkUpdates.isEmpty() && this.queueChunkUploads.isEmpty();
    }
    
    public ChunkRenderDispatcher() {
        this(-1);
    }
    
    public void stopWorkerThreads() {
        this.clearChunkUpdates();
        for (final ChunkRenderWorker llllllllllllllIIIllIIllllIIIllll : this.listThreadedWorkers) {
            llllllllllllllIIIllIIllllIIIllll.notifyToStop();
        }
        for (final Thread llllllllllllllIIIllIIllllIIIlllI : this.listWorkerThreads) {
            try {
                llllllllllllllIIIllIIllllIIIlllI.interrupt();
                llllllllllllllIIIllIIllllIIIlllI.join();
            }
            catch (InterruptedException llllllllllllllIIIllIIllllIIIllIl) {
                ChunkRenderDispatcher.LOGGER.warn("Interrupted whilst waiting for worker to die", (Throwable)llllllllllllllIIIllIIllllIIIllIl);
            }
        }
        this.queueFreeRenderBuilders.clear();
    }
    
    public boolean updateChunkLater(final RenderChunk llllllllllllllIIIllIlIIIIIIIlllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIIIllIlIIIIIIIlIII */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskChunk:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIIIllIlIIIIIIIIllI */
        //    12: aload_3         /* llllllllllllllIIIllIlIIIIIIIlIll */
        //    13: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1;
        //    16: dup            
        //    17: aload_0         /* llllllllllllllIIIllIlIIIIIIIlIIl */
        //    18: aload_3         /* llllllllllllllIIIllIlIIIIIIIlIll */
        //    19: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    22: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.addFinishRunnable:(Ljava/lang/Runnable;)V
        //    25: aload_0         /* llllllllllllllIIIllIlIIIIIIIlIIl */
        //    26: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.queueChunkUpdates:Ljava/util/concurrent/PriorityBlockingQueue;
        //    29: aload_3         /* llllllllllllllIIIllIlIIIIIIIlIll */
        //    30: invokevirtual   java/util/concurrent/PriorityBlockingQueue.offer:(Ljava/lang/Object;)Z
        //    33: istore          llllllllllllllIIIllIlIIIIIIIlIlI
        //    35: iload           llllllllllllllIIIllIlIIIIIIIlIlI
        //    37: ifne            44
        //    40: aload_3         /* llllllllllllllIIIllIlIIIIIIIlIll */
        //    41: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.finish:()V
        //    44: iload           llllllllllllllIIIllIlIIIIIIIlIlI
        //    46: istore_2        /* llllllllllllllIIIllIlIIIIIIIIlll */
        //    47: goto            62
        //    50: astore          llllllllllllllIIIllIlIIIIIIIIlII
        //    52: aload_1         /* llllllllllllllIIIllIlIIIIIIIlIII */
        //    53: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    56: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    59: aload           llllllllllllllIIIllIlIIIIIIIIlII
        //    61: athrow         
        //    62: aload_1         /* llllllllllllllIIIllIlIIIIIIIlIII */
        //    63: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    66: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    69: iload_2         /* llllllllllllllIIIllIlIIIIIIIllII */
        //    70: ireturn        
        //    StackMapTable: 00 03 FE 00 2C 00 07 00 9E 01 FF 00 05 00 02 07 00 02 07 00 8C 00 01 07 00 BE FE 00 0B 01 07 00 9E 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      50     50     62     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void clearChunkUpdates() {
        while (!this.queueChunkUpdates.isEmpty()) {
            final ChunkCompileTaskGenerator llllllllllllllIIIllIIllllIIllIlI = this.queueChunkUpdates.poll();
            if (llllllllllllllIIIllIIllllIIllIlI != null) {
                llllllllllllllIIIllIIllllIIllIlI.finish();
            }
        }
    }
    
    public boolean updateTransparencyLater(final RenderChunk llllllllllllllIIIllIIlllllIIllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIIIllIIlllllIlIllI */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskTransparency:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIIIllIIlllllIIllIl */
        //    12: aload_3         /* llllllllllllllIIIllIIlllllIlIIll */
        //    13: ifnull          53
        //    16: aload_3         /* llllllllllllllIIIllIIlllllIlIIll */
        //    17: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2;
        //    20: dup            
        //    21: aload_0         /* llllllllllllllIIIllIIlllllIlIlll */
        //    22: aload_3         /* llllllllllllllIIIllIIlllllIlIIll */
        //    23: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    26: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.addFinishRunnable:(Ljava/lang/Runnable;)V
        //    29: aload_0         /* llllllllllllllIIIllIIlllllIlIlll */
        //    30: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.queueChunkUpdates:Ljava/util/concurrent/PriorityBlockingQueue;
        //    33: aload_3         /* llllllllllllllIIIllIIlllllIlIIll */
        //    34: invokevirtual   java/util/concurrent/PriorityBlockingQueue.offer:(Ljava/lang/Object;)Z
        //    37: istore          llllllllllllllIIIllIIlllllIlIIlI
        //    39: iload           llllllllllllllIIIllIIlllllIlIIlI
        //    41: istore          llllllllllllllIIIllIIlllllIIlIlI
        //    43: aload_1         /* llllllllllllllIIIllIIlllllIlIllI */
        //    44: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    47: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    50: iload           llllllllllllllIIIllIIlllllIIlIlI
        //    52: ireturn        
        //    53: iconst_1       
        //    54: istore          llllllllllllllIIIllIIlllllIlIIIl
        //    56: iload           llllllllllllllIIIllIIlllllIlIIIl
        //    58: istore_2        /* llllllllllllllIIIllIIlllllIlIlIl */
        //    59: goto            74
        //    62: astore          llllllllllllllIIIllIIlllllIIlIll
        //    64: aload_1         /* llllllllllllllIIIllIIlllllIlIllI */
        //    65: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    68: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    71: aload           llllllllllllllIIIllIIlllllIIlIll
        //    73: athrow         
        //    74: aload_1         /* llllllllllllllIIIllIIlllllIlIllI */
        //    75: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    78: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    81: iload_2         /* llllllllllllllIIIllIIlllllIlIlII */
        //    82: ireturn        
        //    StackMapTable: 00 03 FD 00 35 00 07 00 9E FF 00 08 00 02 07 00 02 07 00 8C 00 01 07 00 BE FE 00 0B 01 07 00 9E 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      43     62     74     Any
        //  53     62     62     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ChunkCompileTaskGenerator getNextChunkUpdate() throws InterruptedException {
        return this.queueChunkUpdates.take();
    }
    
    private void uploadDisplayList(final BufferBuilder llllllllllllllIIIllIIllllIlIllIl, final int llllllllllllllIIIllIIllllIlIlIII, final RenderChunk llllllllllllllIIIllIIllllIlIIlll) {
        GlStateManager.glNewList(llllllllllllllIIIllIIllllIlIlIII, 4864);
        GlStateManager.pushMatrix();
        llllllllllllllIIIllIIllllIlIIlll.multModelviewMatrix();
        this.worldVertexUploader.draw(llllllllllllllIIIllIIllllIlIllIl);
        GlStateManager.popMatrix();
        GlStateManager.glEndList();
    }
    
    public boolean updateChunkNow(final RenderChunk llllllllllllllIIIllIIlllllllllII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* llllllllllllllIIIllIIlllllllIlll */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskChunk:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* llllllllllllllIIIllIIlllllllIlIl */
        //    12: aload_0         /* llllllllllllllIIIllIIllllllllIII */
        //    13: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.renderWorker:Lnet/minecraft/client/renderer/chunk/ChunkRenderWorker;
        //    16: aload_3         /* llllllllllllllIIIllIIllllllllIIl */
        //    17: invokevirtual   net/minecraft/client/renderer/chunk/ChunkRenderWorker.processTask:(Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    20: goto            25
        //    23: astore          llllllllllllllIIIllIIlllllllIlII
        //    25: iconst_1       
        //    26: istore_2        /* llllllllllllllIIIllIIllllllllIll */
        //    27: goto            42
        //    30: astore          llllllllllllllIIIllIIlllllllIIll
        //    32: aload_1         /* llllllllllllllIIIllIIlllllllIlll */
        //    33: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           llllllllllllllIIIllIIlllllllIIll
        //    41: athrow         
        //    42: aload_1         /* llllllllllllllIIIllIIlllllllIlll */
        //    43: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    46: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    49: iload_2         /* llllllllllllllIIIllIIllllllllIlI */
        //    50: ireturn        
        //    StackMapTable: 00 04 FF 00 17 00 04 07 00 02 07 00 8C 00 07 00 9E 00 01 07 00 4D 01 FF 00 04 00 02 07 00 02 07 00 8C 00 01 07 00 BE FD 00 0B 01 07 00 9E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  12     20     23     25     Ljava/lang/InterruptedException;
        //  7      30     30     42     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean runChunkUploads(final long llllllllllllllIIIllIlIIIIIIllIlI) {
        boolean llllllllllllllIIIllIlIIIIIIlllll = false;
        boolean llllllllllllllIIIllIlIIIIIIllllI;
        do {
            llllllllllllllIIIllIlIIIIIIllllI = false;
            if (this.listWorkerThreads.isEmpty()) {
                final ChunkCompileTaskGenerator llllllllllllllIIIllIlIIIIIIlllIl = this.queueChunkUpdates.poll();
                if (llllllllllllllIIIllIlIIIIIIlllIl != null) {
                    try {
                        this.renderWorker.processTask(llllllllllllllIIIllIlIIIIIIlllIl);
                        llllllllllllllIIIllIlIIIIIIllllI = true;
                    }
                    catch (InterruptedException llllllllllllllIIIllIlIIIIIIlllII) {
                        ChunkRenderDispatcher.LOGGER.warn("Skipped task due to interrupt");
                    }
                }
            }
            synchronized (this.queueChunkUploads) {
                if (!this.queueChunkUploads.isEmpty()) {
                    this.queueChunkUploads.poll().uploadTask.run();
                    llllllllllllllIIIllIlIIIIIIllllI = true;
                    llllllllllllllIIIllIlIIIIIIlllll = true;
                }
            }
            // monitorexit(this.queueChunkUploads)
        } while (llllllllllllllIIIllIlIIIIIIllIlI != 0L && llllllllllllllIIIllIlIIIIIIllllI && llllllllllllllIIIllIlIIIIIIllIlI >= System.nanoTime());
        return llllllllllllllIIIllIlIIIIIIlllll;
    }
    
    public String getDebugInfo() {
        return this.listWorkerThreads.isEmpty() ? String.format("pC: %03d, single-threaded", this.queueChunkUpdates.size()) : String.format("pC: %03d, pU: %1d, aB: %1d", this.queueChunkUpdates.size(), this.queueChunkUploads.size(), this.queueFreeRenderBuilders.size());
    }
    
    public RegionRenderCacheBuilder allocateRenderBuilder() throws InterruptedException {
        return this.queueFreeRenderBuilders.take();
    }
    
    public ChunkRenderDispatcher(final int llllllllllllllIIIllIlIIIIIllIIII) {
        this.listWorkerThreads = (List<Thread>)Lists.newArrayList();
        this.listThreadedWorkers = (List<ChunkRenderWorker>)Lists.newArrayList();
        this.queueChunkUpdates = (PriorityBlockingQueue<ChunkCompileTaskGenerator>)Queues.newPriorityBlockingQueue();
        this.worldVertexUploader = new WorldVertexBufferUploader();
        this.vertexUploader = new VertexBufferUploader();
        this.queueChunkUploads = (Queue<PendingUpload>)Queues.newPriorityQueue();
        final int llllllllllllllIIIllIlIIIIIllIlll = Math.max(1, (int)(Runtime.getRuntime().maxMemory() * 0.3) / 10485760);
        final int llllllllllllllIIIllIlIIIIIllIllI = Math.max(1, MathHelper.clamp(Runtime.getRuntime().availableProcessors(), 1, llllllllllllllIIIllIlIIIIIllIlll / 5));
        if (llllllllllllllIIIllIlIIIIIllIIII < 0) {
            this.countRenderBuilders = MathHelper.clamp(llllllllllllllIIIllIlIIIIIllIllI, 1, llllllllllllllIIIllIlIIIIIllIlll);
        }
        else {
            this.countRenderBuilders = llllllllllllllIIIllIlIIIIIllIIII;
        }
        if (llllllllllllllIIIllIlIIIIIllIllI > 1) {
            for (int llllllllllllllIIIllIlIIIIIllIlIl = 0; llllllllllllllIIIllIlIIIIIllIlIl < llllllllllllllIIIllIlIIIIIllIllI; ++llllllllllllllIIIllIlIIIIIllIlIl) {
                final ChunkRenderWorker llllllllllllllIIIllIlIIIIIllIlII = new ChunkRenderWorker(this);
                final Thread llllllllllllllIIIllIlIIIIIllIIll = ChunkRenderDispatcher.THREAD_FACTORY.newThread(llllllllllllllIIIllIlIIIIIllIlII);
                llllllllllllllIIIllIlIIIIIllIIll.start();
                this.listThreadedWorkers.add(llllllllllllllIIIllIlIIIIIllIlII);
                this.listWorkerThreads.add(llllllllllllllIIIllIlIIIIIllIIll);
            }
        }
        this.queueFreeRenderBuilders = (BlockingQueue<RegionRenderCacheBuilder>)Queues.newArrayBlockingQueue(this.countRenderBuilders);
        for (int llllllllllllllIIIllIlIIIIIllIIlI = 0; llllllllllllllIIIllIlIIIIIllIIlI < this.countRenderBuilders; ++llllllllllllllIIIllIlIIIIIllIIlI) {
            this.queueFreeRenderBuilders.add(new RegionRenderCacheBuilder());
        }
        this.renderWorker = new ChunkRenderWorker(this, new RegionRenderCacheBuilder());
    }
    
    public void freeRenderBuilder(final RegionRenderCacheBuilder llllllllllllllIIIllIIllllllIIlll) {
        this.queueFreeRenderBuilders.add(llllllllllllllIIIllIIllllllIIlll);
    }
    
    private void uploadVertexBuffer(final BufferBuilder llllllllllllllIIIllIIllllIlIIIlI, final VertexBuffer llllllllllllllIIIllIIllllIIllllI) {
        this.vertexUploader.setVertexBuffer(llllllllllllllIIIllIIllllIIllllI);
        this.vertexUploader.draw(llllllllllllllIIIllIIllllIlIIIlI);
    }
    
    public void stopChunkUpdates() {
        this.clearChunkUpdates();
        final List<RegionRenderCacheBuilder> llllllllllllllIIIllIIllllllIlllI = (List<RegionRenderCacheBuilder>)Lists.newArrayList();
        while (llllllllllllllIIIllIIllllllIlllI.size() != this.countRenderBuilders) {
            this.runChunkUploads(Long.MAX_VALUE);
            try {
                llllllllllllllIIIllIIllllllIlllI.add(this.allocateRenderBuilder());
            }
            catch (InterruptedException ex) {}
        }
        this.queueFreeRenderBuilders.addAll((Collection<?>)llllllllllllllIIIllIIllllllIlllI);
    }
    
    public ListenableFuture<Object> uploadChunk(final BlockRenderLayer llllllllllllllIIIllIIlllllIIIIII, final BufferBuilder llllllllllllllIIIllIIllllIlllIII, final RenderChunk llllllllllllllIIIllIIllllIllIlll, final CompiledChunk llllllllllllllIIIllIIllllIllllIl, final double llllllllllllllIIIllIIllllIllIlIl) {
        if (Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
            if (OpenGlHelper.useVbo()) {
                this.uploadVertexBuffer(llllllllllllllIIIllIIllllIlllIII, llllllllllllllIIIllIIllllIllIlll.getVertexBufferByLayer(llllllllllllllIIIllIIlllllIIIIII.ordinal()));
            }
            else {
                this.uploadDisplayList(llllllllllllllIIIllIIllllIlllIII, ((ListedRenderChunk)llllllllllllllIIIllIIllllIllIlll).getDisplayList(llllllllllllllIIIllIIlllllIIIIII, llllllllllllllIIIllIIllllIllllIl), llllllllllllllIIIllIIllllIllIlll);
            }
            llllllllllllllIIIllIIllllIlllIII.setTranslation(0.0, 0.0, 0.0);
            return (ListenableFuture<Object>)Futures.immediateFuture((Object)null);
        }
        final ListenableFutureTask<Object> llllllllllllllIIIllIIllllIlllIll = (ListenableFutureTask<Object>)ListenableFutureTask.create((Runnable)new Runnable() {
            @Override
            public void run() {
                ChunkRenderDispatcher.this.uploadChunk(llllllllllllllIIIllIIlllllIIIIII, llllllllllllllIIIllIIllllIlllIII, llllllllllllllIIIllIIllllIllIlll, llllllllllllllIIIllIIllllIllllIl, llllllllllllllIIIllIIllllIllIlIl);
            }
        }, (Object)null);
        synchronized (this.queueChunkUploads) {
            this.queueChunkUploads.add(new PendingUpload(llllllllllllllIIIllIIllllIlllIll, llllllllllllllIIIllIIllllIllIlIl));
            final ListenableFutureTask<Object> listenableFutureTask = llllllllllllllIIIllIIllllIlllIll;
            // monitorexit(this.queueChunkUploads)
            return (ListenableFuture<Object>)listenableFutureTask;
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("Chunk Batcher %d").setDaemon(true).build();
    }
    
    class PendingUpload implements Comparable<PendingUpload>
    {
        private final /* synthetic */ double distanceSq;
        private final /* synthetic */ ListenableFutureTask<Object> uploadTask;
        
        @Override
        public int compareTo(final PendingUpload llIIIIIIIIlIllI) {
            return Doubles.compare(this.distanceSq, llIIIIIIIIlIllI.distanceSq);
        }
        
        public PendingUpload(final ListenableFutureTask<Object> llIIIIIIIlIIIIl, final double llIIIIIIIlIIIII) {
            this.uploadTask = llIIIIIIIlIIIIl;
            this.distanceSq = llIIIIIIIlIIIII;
        }
    }
}
