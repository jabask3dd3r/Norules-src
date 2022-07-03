package net.minecraft.client.renderer;

import java.util.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;

public abstract class ChunkRenderContainer
{
    private /* synthetic */ double viewEntityX;
    protected /* synthetic */ boolean initialized;
    private /* synthetic */ double viewEntityZ;
    protected /* synthetic */ List<RenderChunk> renderChunks;
    private /* synthetic */ double viewEntityY;
    
    public abstract void renderChunkLayer(final BlockRenderLayer p0);
    
    public void addRenderChunk(final RenderChunk lIlllllIlIIIlIl, final BlockRenderLayer lIlllllIlIIIlII) {
        this.renderChunks.add(lIlllllIlIIIlIl);
    }
    
    public void preRenderChunk(final RenderChunk lIlllllIlIIlIlI) {
        final BlockPos lIlllllIlIIllII = lIlllllIlIIlIlI.getPosition();
        GlStateManager.translate((float)(lIlllllIlIIllII.getX() - this.viewEntityX), (float)(lIlllllIlIIllII.getY() - this.viewEntityY), (float)(lIlllllIlIIllII.getZ() - this.viewEntityZ));
    }
    
    public ChunkRenderContainer() {
        this.renderChunks = (List<RenderChunk>)Lists.newArrayListWithCapacity(17424);
    }
    
    public void initialize(final double lIlllllIlIlIlII, final double lIlllllIlIlIlll, final double lIlllllIlIlIllI) {
        this.initialized = true;
        this.renderChunks.clear();
        this.viewEntityX = lIlllllIlIlIlII;
        this.viewEntityY = lIlllllIlIlIlll;
        this.viewEntityZ = lIlllllIlIlIllI;
    }
}
