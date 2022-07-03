package net.minecraft.client.renderer.chunk;

import java.util.*;
import java.util.concurrent.locks.*;
import net.minecraft.client.renderer.*;
import com.google.common.primitives.*;
import com.google.common.collect.*;

public class ChunkCompileTaskGenerator implements Comparable<ChunkCompileTaskGenerator>
{
    private /* synthetic */ CompiledChunk compiledChunk;
    private /* synthetic */ Status status;
    private final /* synthetic */ List<Runnable> listFinishRunnables;
    private final /* synthetic */ RenderChunk renderChunk;
    private final /* synthetic */ Type type;
    private final /* synthetic */ ReentrantLock lock;
    private /* synthetic */ RegionRenderCacheBuilder regionRenderCacheBuilder;
    private /* synthetic */ boolean finished;
    private final /* synthetic */ double distanceSq;
    
    public Status getStatus() {
        return this.status;
    }
    
    public void finish() {
        this.lock.lock();
        try {
            if (this.type == Type.REBUILD_CHUNK && this.status != Status.DONE) {
                this.renderChunk.setNeedsUpdate(false);
            }
            this.finished = true;
            this.status = Status.DONE;
            for (final Runnable lllllllllllllIIlllIlllIIllIIIlII : this.listFinishRunnables) {
                lllllllllllllIIlllIlllIIllIIIlII.run();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public RegionRenderCacheBuilder getRegionRenderCacheBuilder() {
        return this.regionRenderCacheBuilder;
    }
    
    public void setRegionRenderCacheBuilder(final RegionRenderCacheBuilder lllllllllllllIIlllIlllIIllIlIlII) {
        this.regionRenderCacheBuilder = lllllllllllllIIlllIlllIIllIlIlII;
    }
    
    @Override
    public int compareTo(final ChunkCompileTaskGenerator lllllllllllllIIlllIlllIIlIlIlIIl) {
        return Doubles.compare(this.distanceSq, lllllllllllllIIlllIlllIIlIlIlIIl.distanceSq);
    }
    
    public ReentrantLock getLock() {
        return this.lock;
    }
    
    public double getDistanceSq() {
        return this.distanceSq;
    }
    
    public ChunkCompileTaskGenerator(final RenderChunk lllllllllllllIIlllIlllIIllllIIII, final Type lllllllllllllIIlllIlllIIlllIlIll, final double lllllllllllllIIlllIlllIIlllIlIlI) {
        this.lock = new ReentrantLock();
        this.listFinishRunnables = (List<Runnable>)Lists.newArrayList();
        this.status = Status.PENDING;
        this.renderChunk = lllllllllllllIIlllIlllIIllllIIII;
        this.type = lllllllllllllIIlllIlllIIlllIlIll;
        this.distanceSq = lllllllllllllIIlllIlllIIlllIlIlI;
    }
    
    public void setStatus(final Status lllllllllllllIIlllIlllIIllIIllIl) {
        this.lock.lock();
        try {
            this.status = lllllllllllllIIlllIlllIIllIIllIl;
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public RenderChunk getRenderChunk() {
        return this.renderChunk;
    }
    
    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }
    
    public boolean isFinished() {
        return this.finished;
    }
    
    public void addFinishRunnable(final Runnable lllllllllllllIIlllIlllIIlIlllIIl) {
        this.lock.lock();
        try {
            this.listFinishRunnables.add(lllllllllllllIIlllIlllIIlIlllIIl);
            if (this.finished) {
                lllllllllllllIIlllIlllIIlIlllIIl.run();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public void setCompiledChunk(final CompiledChunk lllllllllllllIIlllIlllIIllIlllIl) {
        this.compiledChunk = lllllllllllllIIlllIlllIIllIlllIl;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public enum Type
    {
        RESORT_TRANSPARENCY("RESORT_TRANSPARENCY", 1), 
        REBUILD_CHUNK("REBUILD_CHUNK", 0);
        
        private Type(final String lllllllllllllIIIlIlllIIlllIIlllI, final int lllllllllllllIIIlIlllIIlllIIllIl) {
        }
    }
    
    public enum Status
    {
        UPLOADING("UPLOADING", 2), 
        COMPILING("COMPILING", 1), 
        DONE("DONE", 3), 
        PENDING("PENDING", 0);
        
        private Status(final String lllllllllllllllIlIlIIllIIlIlllll, final int lllllllllllllllIlIlIIllIIlIllllI) {
        }
    }
}
