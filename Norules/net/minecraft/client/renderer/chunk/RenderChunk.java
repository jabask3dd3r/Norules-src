package net.minecraft.client.renderer.chunk;

import net.minecraft.tileentity.*;
import net.minecraft.world.chunk.*;
import java.nio.*;
import java.util.concurrent.locks.*;
import net.minecraft.client.multiplayer.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.vertex.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import shadersmod.client.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.tileentity.*;
import optifine.*;

public class RenderChunk
{
    private /* synthetic */ int frameIndex;
    private /* synthetic */ World world;
    private /* synthetic */ boolean fixBlockLayer;
    private final /* synthetic */ Set<TileEntity> setTileEntities;
    private /* synthetic */ boolean playerUpdate;
    private final /* synthetic */ VertexBuffer[] vertexBuffers;
    private /* synthetic */ BlockRenderLayer[] blockLayersSingle;
    private /* synthetic */ ChunkCompileTaskGenerator compileTask;
    private /* synthetic */ boolean needsUpdateCustom;
    public /* synthetic */ CompiledChunk compiledChunk;
    private /* synthetic */ boolean isMipmaps;
    private static /* synthetic */ BlockRenderLayer[] ENUM_WORLD_BLOCK_LAYERS;
    private final /* synthetic */ int index;
    private /* synthetic */ RenderChunk[] renderChunksOfset16;
    private /* synthetic */ Chunk chunk;
    public static /* synthetic */ int renderChunksUpdated;
    private final /* synthetic */ BlockPos.MutableBlockPos[] mapEnumFacing;
    private final /* synthetic */ FloatBuffer modelviewMatrix;
    private final /* synthetic */ ReentrantLock lockCompileTask;
    private /* synthetic */ boolean needsUpdate;
    private final /* synthetic */ BlockPos.MutableBlockPos position;
    private final /* synthetic */ ReentrantLock lockCompiledChunk;
    private final /* synthetic */ RenderGlobal renderGlobal;
    public /* synthetic */ AxisAlignedBB boundingBox;
    
    public RenderChunk getRenderChunkOffset16(final ViewFrustum llllllllllllllllIllIIIllllIlIIlI, final EnumFacing llllllllllllllllIllIIIllllIlIIIl) {
        RenderChunk llllllllllllllllIllIIIllllIlIlIl = this.renderChunksOfset16[llllllllllllllllIllIIIllllIlIIIl.ordinal()];
        if (llllllllllllllllIllIIIllllIlIlIl == null) {
            final BlockPos llllllllllllllllIllIIIllllIlIlII = this.getBlockPosOffset16(llllllllllllllllIllIIIllllIlIIIl);
            llllllllllllllllIllIIIllllIlIlIl = llllllllllllllllIllIIIllllIlIIlI.getRenderChunk(llllllllllllllllIllIIIllllIlIlII);
            this.renderChunksOfset16[llllllllllllllllIllIIIllllIlIIIl.ordinal()] = llllllllllllllllIllIIIllllIlIlIl;
        }
        return llllllllllllllllIllIIIllllIlIlIl;
    }
    
    private void initModelviewMatrix() {
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final float llllllllllllllllIllIIlIIIlIlIlll = 1.000001f;
        GlStateManager.translate(-8.0f, -8.0f, -8.0f);
        GlStateManager.scale(1.000001f, 1.000001f, 1.000001f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.getFloat(2982, this.modelviewMatrix);
        GlStateManager.popMatrix();
    }
    
    protected void finishCompileTask() {
        this.lockCompileTask.lock();
        try {
            if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
                this.compileTask.finish();
                this.compileTask = null;
            }
        }
        finally {
            this.lockCompileTask.unlock();
        }
        this.lockCompileTask.unlock();
    }
    
    public void clearNeedsUpdate() {
        this.needsUpdate = false;
        this.needsUpdateCustom = false;
        this.playerUpdate = false;
    }
    
    public ReentrantLock getLockCompileTask() {
        return this.lockCompileTask;
    }
    
    private boolean isWorldPlayerUpdate() {
        if (this.world instanceof WorldClient) {
            final WorldClient llllllllllllllllIllIIlIIIIIlIlII = (WorldClient)this.world;
            return llllllllllllllllIllIIlIIIIIlIlII.isPlayerUpdate();
        }
        return false;
    }
    
    public RenderChunk(final World llllllllllllllllIllIIlIllIIIllII, final RenderGlobal llllllllllllllllIllIIlIllIIIIlIl, final int llllllllllllllllIllIIlIllIIIlIlI) {
        this.compiledChunk = CompiledChunk.DUMMY;
        this.lockCompileTask = new ReentrantLock();
        this.lockCompiledChunk = new ReentrantLock();
        this.setTileEntities = (Set<TileEntity>)Sets.newHashSet();
        this.modelviewMatrix = GLAllocation.createDirectFloatBuffer(16);
        this.vertexBuffers = new VertexBuffer[BlockRenderLayer.values().length];
        this.frameIndex = -1;
        this.needsUpdate = true;
        this.position = new BlockPos.MutableBlockPos(-1, -1, -1);
        this.mapEnumFacing = new BlockPos.MutableBlockPos[6];
        this.blockLayersSingle = new BlockRenderLayer[1];
        this.isMipmaps = Config.isMipmaps();
        this.fixBlockLayer = !Reflector.BetterFoliageClient.exists();
        this.playerUpdate = false;
        this.renderChunksOfset16 = new RenderChunk[6];
        for (int llllllllllllllllIllIIlIllIIIlIIl = 0; llllllllllllllllIllIIlIllIIIlIIl < this.mapEnumFacing.length; ++llllllllllllllllIllIIlIllIIIlIIl) {
            this.mapEnumFacing[llllllllllllllllIllIIlIllIIIlIIl] = new BlockPos.MutableBlockPos();
        }
        this.world = llllllllllllllllIllIIlIllIIIllII;
        this.renderGlobal = llllllllllllllllIllIIlIllIIIIlIl;
        this.index = llllllllllllllllIllIIlIllIIIlIlI;
        if (OpenGlHelper.useVbo()) {
            for (int llllllllllllllllIllIIlIllIIIlIII = 0; llllllllllllllllIllIIlIllIIIlIII < BlockRenderLayer.values().length; ++llllllllllllllllIllIIlIllIIIlIII) {
                this.vertexBuffers[llllllllllllllllIllIIlIllIIIlIII] = new VertexBuffer(DefaultVertexFormats.BLOCK);
            }
        }
    }
    
    public void resortTransparency(final float llllllllllllllllIllIIlIlIlIlIIlI, final float llllllllllllllllIllIIlIlIlIlIIIl, final float llllllllllllllllIllIIlIlIlIlIIII, final ChunkCompileTaskGenerator llllllllllllllllIllIIlIlIlIIllll) {
        final CompiledChunk llllllllllllllllIllIIlIlIlIlIlIl = llllllllllllllllIllIIlIlIlIIllll.getCompiledChunk();
        if (llllllllllllllllIllIIlIlIlIlIlIl.getState() != null && !llllllllllllllllIllIIlIlIlIlIlIl.isLayerEmpty(BlockRenderLayer.TRANSLUCENT)) {
            final BufferBuilder llllllllllllllllIllIIlIlIlIlIlII = llllllllllllllllIllIIlIlIlIIllll.getRegionRenderCacheBuilder().getWorldRendererByLayer(BlockRenderLayer.TRANSLUCENT);
            this.preRenderBlocks(llllllllllllllllIllIIlIlIlIlIlII, this.position);
            llllllllllllllllIllIIlIlIlIlIlII.setVertexState(llllllllllllllllIllIIlIlIlIlIlIl.getState());
            this.postRenderBlocks(BlockRenderLayer.TRANSLUCENT, llllllllllllllllIllIIlIlIlIlIIlI, llllllllllllllllIllIIlIlIlIlIIIl, llllllllllllllllIllIIlIlIlIlIIII, llllllllllllllllIllIIlIlIlIlIlII, llllllllllllllllIllIIlIlIlIlIlIl);
        }
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    private ChunkCacheOF makeChunkCacheOF() {
        final BlockPos llllllllllllllllIllIIIlllllIIlII = this.position.add(-1, -1, -1);
        final ChunkCache llllllllllllllllIllIIIlllllIIIll = this.createRegionRenderCache(this.world, llllllllllllllllIllIIIlllllIIlII, this.position.add(16, 16, 16), 1);
        if (Reflector.MinecraftForgeClient_onRebuildChunk.exists()) {
            Reflector.call(Reflector.MinecraftForgeClient_onRebuildChunk, this.world, this.position, llllllllllllllllIllIIIlllllIIIll);
        }
        final ChunkCacheOF llllllllllllllllIllIIIlllllIIIlI = new ChunkCacheOF(llllllllllllllllIllIIIlllllIIIll, llllllllllllllllIllIIIlllllIIlII, 1);
        return llllllllllllllllIllIIIlllllIIIlI;
    }
    
    private void postRenderBlocks(final BlockRenderLayer llllllllllllllllIllIIlIIIllIIllI, final float llllllllllllllllIllIIlIIIlllIIII, final float llllllllllllllllIllIIlIIIllIIlII, final float llllllllllllllllIllIIlIIIllIllII, final BufferBuilder llllllllllllllllIllIIlIIIllIIIlI, final CompiledChunk llllllllllllllllIllIIlIIIllIlIII) {
        if (llllllllllllllllIllIIlIIIllIIllI == BlockRenderLayer.TRANSLUCENT && !llllllllllllllllIllIIlIIIllIlIII.isLayerEmpty(llllllllllllllllIllIIlIIIllIIllI)) {
            llllllllllllllllIllIIlIIIllIIIlI.sortVertexData(llllllllllllllllIllIIlIIIlllIIII, llllllllllllllllIllIIlIIIllIIlII, llllllllllllllllIllIIlIIIllIllII);
            llllllllllllllllIllIIlIIIllIlIII.setState(llllllllllllllllIllIIlIIIllIIIlI.getVertexState());
        }
        llllllllllllllllIllIIlIIIllIIIlI.finishDrawing();
    }
    
    public boolean setFrameIndex(final int llllllllllllllllIllIIlIlIlllllll) {
        if (this.frameIndex == llllllllllllllllIllIIlIlIlllllll) {
            return false;
        }
        this.frameIndex = llllllllllllllllIllIIlIlIlllllll;
        return true;
    }
    
    public void stopCompileTask() {
        this.finishCompileTask();
        this.compiledChunk = CompiledChunk.DUMMY;
    }
    
    public boolean isNeedsUpdate() {
        return this.needsUpdate;
    }
    
    public ChunkCompileTaskGenerator makeCompileTaskChunk() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.finishCompileTask:()V
        //    11: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    12: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    15: dup            
        //    16: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    17: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.REBUILD_CHUNK:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    20: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    21: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getDistanceSq:()D
        //    24: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;D)V
        //    27: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    30: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    31: invokespecial   net/minecraft/client/renderer/chunk/RenderChunk.resetChunkCache:()V
        //    34: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    35: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    38: astore_1        /* llllllllllllllllIllIIlIIllIlllll */
        //    39: goto            52
        //    42: astore_2        /* llllllllllllllllIllIIlIIllIlllIl */
        //    43: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    44: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    47: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    50: aload_2         /* llllllllllllllllIllIIlIIllIlllIl */
        //    51: athrow         
        //    52: aload_0         /* llllllllllllllllIllIIlIIlllIIllI */
        //    53: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    56: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    59: aload_1         /* llllllllllllllllIllIIlIIlllIIIll */
        //    60: areturn        
        //    StackMapTable: 00 02 6A 07 00 AB FC 00 09 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      42     42     52     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isNeedsUpdateCustom() {
        return this.needsUpdate && this.needsUpdateCustom;
    }
    
    public void deleteGlResources() {
        this.stopCompileTask();
        this.world = null;
        for (int llllllllllllllllIllIIlIIIIllIlIl = 0; llllllllllllllllIllIIlIIIIllIlIl < BlockRenderLayer.values().length; ++llllllllllllllllIllIIlIIIIllIlIl) {
            if (this.vertexBuffers[llllllllllllllllIllIIlIIIIllIlIl] != null) {
                this.vertexBuffers[llllllllllllllllIllIIlIIIIllIlIl].deleteGlBuffers();
            }
        }
    }
    
    public World getWorld() {
        return this.world;
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    public void multModelviewMatrix() {
        GlStateManager.multMatrix(this.modelviewMatrix);
    }
    
    @Nullable
    public ChunkCompileTaskGenerator makeCompileTaskTransparency() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //     8: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: ifnull          42
        //    14: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    15: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    18: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.getStatus:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    21: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.PENDING:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    24: if_acmpne       42
        //    27: aconst_null    
        //    28: astore_2        /* llllllllllllllllIllIIlIIlIllIllI */
        //    29: aload_2         /* llllllllllllllllIllIIlIIlIllIllI */
        //    30: astore          llllllllllllllllIllIIlIIlIlIlIlI
        //    32: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    33: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           llllllllllllllllIllIIlIIlIlIlIlI
        //    41: areturn        
        //    42: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    43: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    46: ifnull          74
        //    49: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    50: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    53: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.getStatus:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    56: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.DONE:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    59: if_acmpeq       74
        //    62: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    63: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    66: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.finish:()V
        //    69: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    70: aconst_null    
        //    71: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    74: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    75: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    78: dup            
        //    79: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    80: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.RESORT_TRANSPARENCY:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    83: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    84: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getDistanceSq:()D
        //    87: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;D)V
        //    90: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    93: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    94: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    97: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //    98: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compiledChunk:Lnet/minecraft/client/renderer/chunk/CompiledChunk;
        //   101: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.setCompiledChunk:(Lnet/minecraft/client/renderer/chunk/CompiledChunk;)V
        //   104: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //   105: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //   108: astore_2        /* llllllllllllllllIllIIlIIlIllIlII */
        //   109: aload_2         /* llllllllllllllllIllIIlIIlIllIlII */
        //   110: astore_1        /* llllllllllllllllIllIIlIIlIlllIlI */
        //   111: goto            124
        //   114: astore_3        /* llllllllllllllllIllIIlIIlIlIllII */
        //   115: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //   116: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //   119: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   122: aload_3         /* llllllllllllllllIllIIlIIlIlIllII */
        //   123: athrow         
        //   124: aload_0         /* llllllllllllllllIllIIlIIlIllIIlI */
        //   125: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //   128: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   131: aload_1         /* llllllllllllllllIllIIlIIlIlllIII */
        //   132: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 01 E7 00 00
        //    StackMapTable: 00 04 2A 1F 67 07 00 AB FD 00 09 07 00 08 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      32     114    124    Any
        //  42     114    114    124    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setPosition(final int llllllllllllllllIllIIlIlIllIllIl, final int llllllllllllllllIllIIlIlIllIIlll, final int llllllllllllllllIllIIlIlIllIlIll) {
        if (llllllllllllllllIllIIlIlIllIllIl != this.position.getX() || llllllllllllllllIllIIlIlIllIIlll != this.position.getY() || llllllllllllllllIllIIlIlIllIlIll != this.position.getZ()) {
            this.stopCompileTask();
            this.position.setPos(llllllllllllllllIllIIlIlIllIllIl, llllllllllllllllIllIIlIlIllIIlll, llllllllllllllllIllIIlIlIllIlIll);
            this.boundingBox = new AxisAlignedBB(llllllllllllllllIllIIlIlIllIllIl, llllllllllllllllIllIIlIlIllIIlll, llllllllllllllllIllIIlIlIllIlIll, llllllllllllllllIllIIlIlIllIllIl + 16, llllllllllllllllIllIIlIlIllIIlll + 16, llllllllllllllllIllIIlIlIllIlIll + 16);
            long llllllllllllllllIllIIlIlIllIIIlI;
            for (String llllllllllllllllIllIIlIlIllIIIll = (String)((EnumFacing[])(Object)(llllllllllllllllIllIIlIlIllIIIlI = (long)(Object)EnumFacing.VALUES)).length, llllllllllllllllIllIIlIlIllIIlII = (String)0; llllllllllllllllIllIIlIlIllIIlII < llllllllllllllllIllIIlIlIllIIIll; ++llllllllllllllllIllIIlIlIllIIlII) {
                final EnumFacing llllllllllllllllIllIIlIlIllIlIlI = llllllllllllllllIllIIlIlIllIIIlI[llllllllllllllllIllIIlIlIllIIlII];
                this.mapEnumFacing[llllllllllllllllIllIIlIlIllIlIlI.ordinal()].setPos(this.position).move(llllllllllllllllIllIIlIlIllIlIlI, 16);
                this.renderChunksOfset16[llllllllllllllllIllIIlIlIllIlIlI.ordinal()] = null;
            }
            this.chunk = null;
            this.initModelviewMatrix();
        }
    }
    
    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }
    
    private void preRenderBlocks(final BufferBuilder llllllllllllllllIllIIlIIlIIIIlIl, final BlockPos llllllllllllllllIllIIlIIlIIIIIll) {
        llllllllllllllllIllIIlIIlIIIIlIl.begin(7, DefaultVertexFormats.BLOCK);
        llllllllllllllllIllIIlIIlIIIIlIl.setTranslation(-llllllllllllllllIllIIlIIlIIIIIll.getX(), -llllllllllllllllIllIIlIIlIIIIIll.getY(), -llllllllllllllllIllIIlIIlIIIIIll.getZ());
    }
    
    static {
        RenderChunk.ENUM_WORLD_BLOCK_LAYERS = BlockRenderLayer.values();
    }
    
    public BlockPos getBlockPosOffset16(final EnumFacing llllllllllllllllIllIIlIIIIIlllIl) {
        return this.mapEnumFacing[llllllllllllllllIllIIlIIIIIlllIl.ordinal()];
    }
    
    public void setNeedsUpdate(boolean llllllllllllllllIllIIlIIIIlIlIlI) {
        if (this.needsUpdate) {
            llllllllllllllllIllIIlIIIIlIlIlI |= (this.needsUpdateCustom ? 1 : 0);
        }
        this.needsUpdate = true;
        this.needsUpdateCustom = (llllllllllllllllIllIIlIIIIlIlIlI != 0);
        if (this.isWorldPlayerUpdate()) {
            this.playerUpdate = true;
        }
    }
    
    public VertexBuffer getVertexBufferByLayer(final int llllllllllllllllIllIIlIlIllllIIl) {
        return this.vertexBuffers[llllllllllllllllIllIIlIlIllllIIl];
    }
    
    protected ChunkCache createRegionRenderCache(final World llllllllllllllllIllIIIlllIllllll, final BlockPos llllllllllllllllIllIIIllllIIIIlI, final BlockPos llllllllllllllllIllIIIllllIIIIIl, final int llllllllllllllllIllIIIlllIllllII) {
        return new ChunkCache(llllllllllllllllIllIIIlllIllllll, llllllllllllllllIllIIIllllIIIIlI, llllllllllllllllIllIIIllllIIIIIl, llllllllllllllllIllIIIlllIllllII);
    }
    
    public Chunk getChunk(final World llllllllllllllllIllIIIllllIIlIIl) {
        if (this.chunk != null && this.chunk.isLoaded()) {
            return this.chunk;
        }
        this.chunk = llllllllllllllllIllIIIllllIIlIIl.getChunkFromBlockCoords(this.getPosition());
        return this.chunk;
    }
    
    protected double getDistanceSq() {
        final EntityPlayerSP llllllllllllllllIllIIlIIlIIllllI = Minecraft.getMinecraft().player;
        final double llllllllllllllllIllIIlIIlIIlllIl = this.boundingBox.minX + 8.0 - llllllllllllllllIllIIlIIlIIllllI.posX;
        final double llllllllllllllllIllIIlIIlIIllIll = this.boundingBox.minY + 8.0 - llllllllllllllllIllIIlIIlIIllllI.posY;
        final double llllllllllllllllIllIIlIIlIIllIIl = this.boundingBox.minZ + 8.0 - llllllllllllllllIllIIlIIlIIllllI.posZ;
        return llllllllllllllllIllIIlIIlIIlllIl * llllllllllllllllIllIIlIIlIIlllIl + llllllllllllllllIllIIlIIlIIllIll * llllllllllllllllIllIIlIIlIIllIll + llllllllllllllllIllIIlIIlIIllIIl * llllllllllllllllIllIIlIIlIIllIIl;
    }
    
    private BlockRenderLayer fixBlockLayer(final Block llllllllllllllllIllIIlIIIIIIIlll, final BlockRenderLayer llllllllllllllllIllIIlIIIIIIlIIl) {
        if (this.isMipmaps) {
            if (llllllllllllllllIllIIlIIIIIIlIIl == BlockRenderLayer.CUTOUT) {
                if (llllllllllllllllIllIIlIIIIIIIlll instanceof BlockRedstoneWire) {
                    return llllllllllllllllIllIIlIIIIIIlIIl;
                }
                if (llllllllllllllllIllIIlIIIIIIIlll instanceof BlockCactus) {
                    return llllllllllllllllIllIIlIIIIIIlIIl;
                }
                return BlockRenderLayer.CUTOUT_MIPPED;
            }
        }
        else if (llllllllllllllllIllIIlIIIIIIlIIl == BlockRenderLayer.CUTOUT_MIPPED) {
            return BlockRenderLayer.CUTOUT;
        }
        return llllllllllllllllIllIIlIIIIIIlIIl;
    }
    
    public void setCompiledChunk(final CompiledChunk llllllllllllllllIllIIlIIIIllllll) {
        this.lockCompiledChunk.lock();
        try {
            this.compiledChunk = llllllllllllllllIllIIlIIIIllllll;
        }
        finally {
            this.lockCompiledChunk.unlock();
        }
        this.lockCompiledChunk.unlock();
    }
    
    private void postRenderOverlay(final BlockRenderLayer llllllllllllllllIllIIIlllllIlllI, final RegionRenderCacheBuilder llllllllllllllllIllIIIllllllIIlI, final CompiledChunk llllllllllllllllIllIIIllllllIIIl, final boolean[] llllllllllllllllIllIIIllllllIIII) {
        final BufferBuilder llllllllllllllllIllIIIlllllIllll = llllllllllllllllIllIIIllllllIIlI.getWorldRendererByLayer(llllllllllllllllIllIIIlllllIlllI);
        if (llllllllllllllllIllIIIlllllIllll.isDrawing()) {
            llllllllllllllllIllIIIllllllIIIl.setLayerStarted(llllllllllllllllIllIIIlllllIlllI);
            llllllllllllllllIllIIIllllllIIII[llllllllllllllllIllIIIlllllIlllI.ordinal()] = true;
        }
    }
    
    public void rebuildChunk(final float llllllllllllllllIllIIlIlIIllIIII, final float llllllllllllllllIllIIlIlIIlIllll, final float llllllllllllllllIllIIlIlIIlIlllI, final ChunkCompileTaskGenerator llllllllllllllllIllIIlIlIIlIllIl) {
        final CompiledChunk llllllllllllllllIllIIlIlIIlIllII = new CompiledChunk();
        final int llllllllllllllllIllIIlIlIIlIlIll = 1;
        final BlockPos llllllllllllllllIllIIlIlIIlIlIlI = this.position;
        final BlockPos llllllllllllllllIllIIlIlIIlIlIIl = llllllllllllllllIllIIlIlIIlIlIlI.add(15, 15, 15);
        llllllllllllllllIllIIlIlIIlIllIl.getLock().lock();
        try {
            if (llllllllllllllllIllIIlIlIIlIllIl.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                return;
            }
            llllllllllllllllIllIIlIlIIlIllIl.setCompiledChunk(llllllllllllllllIllIIlIlIIlIllII);
        }
        finally {
            llllllllllllllllIllIIlIlIIlIllIl.getLock().unlock();
        }
        llllllllllllllllIllIIlIlIIlIllIl.getLock().unlock();
        final VisGraph llllllllllllllllIllIIlIlIIlIlIII = new VisGraph();
        final HashSet llllllllllllllllIllIIlIlIIlIIlll = Sets.newHashSet();
        if (this.world != null) {
            final ChunkCacheOF llllllllllllllllIllIIlIlIIlIIllI = this.makeChunkCacheOF();
            if (!llllllllllllllllIllIIlIlIIlIIllI.isEmpty()) {
                ++RenderChunk.renderChunksUpdated;
                llllllllllllllllIllIIlIlIIlIIllI.renderStart();
                final boolean[] llllllllllllllllIllIIlIlIIlIIlIl = new boolean[RenderChunk.ENUM_WORLD_BLOCK_LAYERS.length];
                final BlockRendererDispatcher llllllllllllllllIllIIlIlIIlIIlII = Minecraft.getMinecraft().getBlockRendererDispatcher();
                final boolean llllllllllllllllIllIIlIlIIlIIIll = Reflector.ForgeBlock_canRenderInLayer.exists();
                final boolean llllllllllllllllIllIIlIlIIlIIIlI = Reflector.ForgeHooksClient_setRenderLayer.exists();
                for (final Object llllllllllllllllIllIIlIlIIlIIIIl : BlockPosM.getAllInBoxMutable(llllllllllllllllIllIIlIlIIlIlIlI, llllllllllllllllIllIIlIlIIlIlIIl)) {
                    final BlockPosM llllllllllllllllIllIIlIlIIlIIIII = (BlockPosM)llllllllllllllllIllIIlIlIIlIIIIl;
                    final IBlockState llllllllllllllllIllIIlIlIIIlllll = llllllllllllllllIllIIlIlIIlIIllI.getBlockState(llllllllllllllllIllIIlIlIIlIIIII);
                    final Block llllllllllllllllIllIIlIlIIIllllI = llllllllllllllllIllIIlIlIIIlllll.getBlock();
                    if (llllllllllllllllIllIIlIlIIIlllll.isOpaqueCube()) {
                        llllllllllllllllIllIIlIlIIlIlIII.setOpaqueCube(llllllllllllllllIllIIlIlIIlIIIII);
                    }
                    if (ReflectorForge.blockHasTileEntity(llllllllllllllllIllIIlIlIIIlllll)) {
                        final TileEntity llllllllllllllllIllIIlIlIIIlllIl = llllllllllllllllIllIIlIlIIlIIllI.getTileEntity(llllllllllllllllIllIIlIlIIlIIIII, Chunk.EnumCreateEntityType.CHECK);
                        if (llllllllllllllllIllIIlIlIIIlllIl != null) {
                            final TileEntitySpecialRenderer<TileEntity> llllllllllllllllIllIIlIlIIIlllII = TileEntityRendererDispatcher.instance.getSpecialRenderer(llllllllllllllllIllIIlIlIIIlllIl);
                            if (llllllllllllllllIllIIlIlIIIlllII != null) {
                                if (llllllllllllllllIllIIlIlIIIlllII.isGlobalRenderer(llllllllllllllllIllIIlIlIIIlllIl)) {
                                    llllllllllllllllIllIIlIlIIlIIlll.add(llllllllllllllllIllIIlIlIIIlllIl);
                                }
                                else {
                                    llllllllllllllllIllIIlIlIIlIllII.addTileEntity(llllllllllllllllIllIIlIlIIIlllIl);
                                }
                            }
                        }
                    }
                    BlockRenderLayer[] llllllllllllllllIllIIlIlIIIllIlI = null;
                    if (llllllllllllllllIllIIlIlIIlIIIll) {
                        final BlockRenderLayer[] llllllllllllllllIllIIlIlIIIllIll = RenderChunk.ENUM_WORLD_BLOCK_LAYERS;
                    }
                    else {
                        llllllllllllllllIllIIlIlIIIllIlI = this.blockLayersSingle;
                        llllllllllllllllIllIIlIlIIIllIlI[0] = llllllllllllllllIllIIlIlIIIllllI.getBlockLayer();
                    }
                    for (int llllllllllllllllIllIIlIlIIIllIIl = 0; llllllllllllllllIllIIlIlIIIllIIl < llllllllllllllllIllIIlIlIIIllIlI.length; ++llllllllllllllllIllIIlIlIIIllIIl) {
                        BlockRenderLayer llllllllllllllllIllIIlIlIIIllIII = llllllllllllllllIllIIlIlIIIllIlI[llllllllllllllllIllIIlIlIIIllIIl];
                        if (llllllllllllllllIllIIlIlIIlIIIll) {
                            final boolean llllllllllllllllIllIIlIlIIIlIlll = Reflector.callBoolean(llllllllllllllllIllIIlIlIIIllllI, Reflector.ForgeBlock_canRenderInLayer, llllllllllllllllIllIIlIlIIIlllll, llllllllllllllllIllIIlIlIIIllIII);
                            if (!llllllllllllllllIllIIlIlIIIlIlll) {
                                continue;
                            }
                        }
                        if (llllllllllllllllIllIIlIlIIlIIIlI) {
                            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, llllllllllllllllIllIIlIlIIIllIII);
                        }
                        if (this.fixBlockLayer) {
                            llllllllllllllllIllIIlIlIIIllIII = this.fixBlockLayer(llllllllllllllllIllIIlIlIIIllllI, llllllllllllllllIllIIlIlIIIllIII);
                        }
                        final int llllllllllllllllIllIIlIlIIIlIllI = llllllllllllllllIllIIlIlIIIllIII.ordinal();
                        if (llllllllllllllllIllIIlIlIIIllllI.getDefaultState().getRenderType() != EnumBlockRenderType.INVISIBLE) {
                            final BufferBuilder llllllllllllllllIllIIlIlIIIlIlIl = llllllllllllllllIllIIlIlIIlIllIl.getRegionRenderCacheBuilder().getWorldRendererByLayerId(llllllllllllllllIllIIlIlIIIlIllI);
                            llllllllllllllllIllIIlIlIIIlIlIl.setBlockLayer(llllllllllllllllIllIIlIlIIIllIII);
                            final RenderEnv llllllllllllllllIllIIlIlIIIlIlII = llllllllllllllllIllIIlIlIIIlIlIl.getRenderEnv(llllllllllllllllIllIIlIlIIlIIllI, llllllllllllllllIllIIlIlIIIlllll, llllllllllllllllIllIIlIlIIlIIIII);
                            llllllllllllllllIllIIlIlIIIlIlII.setRegionRenderCacheBuilder(llllllllllllllllIllIIlIlIIlIllIl.getRegionRenderCacheBuilder());
                            if (!llllllllllllllllIllIIlIlIIlIllII.isLayerStarted(llllllllllllllllIllIIlIlIIIllIII)) {
                                llllllllllllllllIllIIlIlIIlIllII.setLayerStarted(llllllllllllllllIllIIlIlIIIllIII);
                                this.preRenderBlocks(llllllllllllllllIllIIlIlIIIlIlIl, llllllllllllllllIllIIlIlIIlIlIlI);
                            }
                            final boolean[] array = llllllllllllllllIllIIlIlIIlIIlIl;
                            final int n = llllllllllllllllIllIIlIlIIIlIllI;
                            array[n] |= llllllllllllllllIllIIlIlIIlIIlII.renderBlock(llllllllllllllllIllIIlIlIIIlllll, llllllllllllllllIllIIlIlIIlIIIII, llllllllllllllllIllIIlIlIIlIIllI, llllllllllllllllIllIIlIlIIIlIlIl);
                            if (llllllllllllllllIllIIlIlIIIlIlII.isOverlaysRendered()) {
                                this.postRenderOverlays(llllllllllllllllIllIIlIlIIlIllIl.getRegionRenderCacheBuilder(), llllllllllllllllIllIIlIlIIlIllII, llllllllllllllllIllIIlIlIIlIIlIl);
                                llllllllllllllllIllIIlIlIIIlIlII.setOverlaysRendered(false);
                            }
                        }
                    }
                    if (llllllllllllllllIllIIlIlIIlIIIlI) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, (Object[])null);
                    }
                }
                final String llllllllllllllllIllIIlIIllllllIl;
                final int length = (llllllllllllllllIllIIlIIllllllIl = (String)(Object)RenderChunk.ENUM_WORLD_BLOCK_LAYERS).length;
                for (boolean llllllllllllllllIllIIlIIllllllll = false; (llllllllllllllllIllIIlIIllllllll ? 1 : 0) < length; ++llllllllllllllllIllIIlIIllllllll) {
                    final BlockRenderLayer llllllllllllllllIllIIlIlIIIlIIll = llllllllllllllllIllIIlIIllllllIl[llllllllllllllllIllIIlIIllllllll];
                    if (llllllllllllllllIllIIlIlIIlIIlIl[llllllllllllllllIllIIlIlIIIlIIll.ordinal()]) {
                        llllllllllllllllIllIIlIlIIlIllII.setLayerUsed(llllllllllllllllIllIIlIlIIIlIIll);
                    }
                    if (llllllllllllllllIllIIlIlIIlIllII.isLayerStarted(llllllllllllllllIllIIlIlIIIlIIll)) {
                        if (Config.isShaders()) {
                            SVertexBuilder.calcNormalChunkLayer(llllllllllllllllIllIIlIlIIlIllIl.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllllllIllIIlIlIIIlIIll));
                        }
                        this.postRenderBlocks(llllllllllllllllIllIIlIlIIIlIIll, llllllllllllllllIllIIlIlIIllIIII, llllllllllllllllIllIIlIlIIlIllll, llllllllllllllllIllIIlIlIIlIlllI, llllllllllllllllIllIIlIlIIlIllIl.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllllllIllIIlIlIIIlIIll), llllllllllllllllIllIIlIlIIlIllII);
                    }
                }
                llllllllllllllllIllIIlIlIIlIIllI.renderFinish();
            }
            llllllllllllllllIllIIlIlIIlIllII.setVisibility(llllllllllllllllIllIIlIlIIlIlIII.computeVisibility());
            this.lockCompileTask.lock();
            try {
                final Set<TileEntity> llllllllllllllllIllIIlIlIIIlIIlI = (Set<TileEntity>)Sets.newHashSet((Iterable)llllllllllllllllIllIIlIlIIlIIlll);
                final Set<TileEntity> llllllllllllllllIllIIlIlIIIlIIIl = (Set<TileEntity>)Sets.newHashSet((Iterable)this.setTileEntities);
                llllllllllllllllIllIIlIlIIIlIIlI.removeAll(this.setTileEntities);
                llllllllllllllllIllIIlIlIIIlIIIl.removeAll(llllllllllllllllIllIIlIlIIlIIlll);
                this.setTileEntities.clear();
                this.setTileEntities.addAll(llllllllllllllllIllIIlIlIIlIIlll);
                this.renderGlobal.updateTileEntities(llllllllllllllllIllIIlIlIIIlIIIl, llllllllllllllllIllIIlIlIIIlIIlI);
            }
            finally {
                this.lockCompileTask.unlock();
            }
            this.lockCompileTask.unlock();
        }
    }
    
    private void resetChunkCache() {
        final int llllllllllllllllIllIIlIIllIlIlIl = 1;
    }
    
    private void postRenderOverlays(final RegionRenderCacheBuilder llllllllllllllllIllIIIllllllllII, final CompiledChunk llllllllllllllllIllIIIllllllllll, final boolean[] llllllllllllllllIllIIIlllllllIlI) {
        this.postRenderOverlay(BlockRenderLayer.CUTOUT, llllllllllllllllIllIIIllllllllII, llllllllllllllllIllIIIllllllllll, llllllllllllllllIllIIIlllllllIlI);
        this.postRenderOverlay(BlockRenderLayer.CUTOUT_MIPPED, llllllllllllllllIllIIIllllllllII, llllllllllllllllIllIIIllllllllll, llllllllllllllllIllIIIlllllllIlI);
        this.postRenderOverlay(BlockRenderLayer.TRANSLUCENT, llllllllllllllllIllIIIllllllllII, llllllllllllllllIllIIIllllllllll, llllllllllllllllIllIIIlllllllIlI);
    }
}
