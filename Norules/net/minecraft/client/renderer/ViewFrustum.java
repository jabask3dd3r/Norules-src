package net.minecraft.client.renderer;

import net.minecraft.world.*;
import net.minecraft.client.renderer.chunk.*;
import javax.annotation.*;
import net.minecraft.util.math.*;

public class ViewFrustum
{
    protected /* synthetic */ int countChunksZ;
    protected /* synthetic */ int countChunksY;
    protected final /* synthetic */ World world;
    public /* synthetic */ RenderChunk[] renderChunks;
    protected /* synthetic */ int countChunksX;
    protected final /* synthetic */ RenderGlobal renderGlobal;
    
    private int getBaseCoordinate(final int llllllllllllllllIlIllIIllIlIllIl, final int llllllllllllllllIlIllIIllIlIllII, final int llllllllllllllllIlIllIIllIlIlIll) {
        final int llllllllllllllllIlIllIIllIlIllll = llllllllllllllllIlIllIIllIlIlIll * 16;
        int llllllllllllllllIlIllIIllIlIlllI = llllllllllllllllIlIllIIllIlIllll - llllllllllllllllIlIllIIllIlIllIl + llllllllllllllllIlIllIIllIlIllII / 2;
        if (llllllllllllllllIlIllIIllIlIlllI < 0) {
            llllllllllllllllIlIllIIllIlIlllI -= llllllllllllllllIlIllIIllIlIllII - 1;
        }
        return llllllllllllllllIlIllIIllIlIllll - llllllllllllllllIlIllIIllIlIlllI / llllllllllllllllIlIllIIllIlIllII * llllllllllllllllIlIllIIllIlIllII;
    }
    
    protected void createRenderChunks(final IRenderChunkFactory llllllllllllllllIlIllIlIIIIIIIll) {
        final int llllllllllllllllIlIllIlIIIIIIIlI = this.countChunksX * this.countChunksY * this.countChunksZ;
        this.renderChunks = new RenderChunk[llllllllllllllllIlIllIlIIIIIIIlI];
        int llllllllllllllllIlIllIlIIIIIIIIl = 0;
        for (int llllllllllllllllIlIllIlIIIIIIIII = 0; llllllllllllllllIlIllIlIIIIIIIII < this.countChunksX; ++llllllllllllllllIlIllIlIIIIIIIII) {
            for (int llllllllllllllllIlIllIIlllllllll = 0; llllllllllllllllIlIllIIlllllllll < this.countChunksY; ++llllllllllllllllIlIllIIlllllllll) {
                for (int llllllllllllllllIlIllIIllllllllI = 0; llllllllllllllllIlIllIIllllllllI < this.countChunksZ; ++llllllllllllllllIlIllIIllllllllI) {
                    final int llllllllllllllllIlIllIIlllllllIl = (llllllllllllllllIlIllIIllllllllI * this.countChunksY + llllllllllllllllIlIllIIlllllllll) * this.countChunksX + llllllllllllllllIlIllIlIIIIIIIII;
                    (this.renderChunks[llllllllllllllllIlIllIIlllllllIl] = llllllllllllllllIlIllIlIIIIIIIll.create(this.world, this.renderGlobal, llllllllllllllllIlIllIlIIIIIIIIl++)).setPosition(llllllllllllllllIlIllIlIIIIIIIII * 16, llllllllllllllllIlIllIIlllllllll * 16, llllllllllllllllIlIllIIllllllllI * 16);
                }
            }
        }
    }
    
    @Nullable
    public RenderChunk getRenderChunk(final BlockPos llllllllllllllllIlIllIIlIlIllIIl) {
        int llllllllllllllllIlIllIIlIlIllllI = llllllllllllllllIlIllIIlIlIllIIl.getX() >> 4;
        final int llllllllllllllllIlIllIIlIlIlllIl = llllllllllllllllIlIllIIlIlIllIIl.getY() >> 4;
        int llllllllllllllllIlIllIIlIlIlllII = llllllllllllllllIlIllIIlIlIllIIl.getZ() >> 4;
        if (llllllllllllllllIlIllIIlIlIlllIl >= 0 && llllllllllllllllIlIllIIlIlIlllIl < this.countChunksY) {
            llllllllllllllllIlIllIIlIlIllllI %= this.countChunksX;
            if (llllllllllllllllIlIllIIlIlIllllI < 0) {
                llllllllllllllllIlIllIIlIlIllllI += this.countChunksX;
            }
            llllllllllllllllIlIllIIlIlIlllII %= this.countChunksZ;
            if (llllllllllllllllIlIllIIlIlIlllII < 0) {
                llllllllllllllllIlIllIIlIlIlllII += this.countChunksZ;
            }
            final int llllllllllllllllIlIllIIlIlIllIll = (llllllllllllllllIlIllIIlIlIlllII * this.countChunksY + llllllllllllllllIlIllIIlIlIlllIl) * this.countChunksX + llllllllllllllllIlIllIIlIlIllllI;
            return this.renderChunks[llllllllllllllllIlIllIIlIlIllIll];
        }
        return null;
    }
    
    public void updateChunkPositions(final double llllllllllllllllIlIllIIlllIlIIIl, final double llllllllllllllllIlIllIIlllIIIIll) {
        final int llllllllllllllllIlIllIIlllIIllll = MathHelper.floor(llllllllllllllllIlIllIIlllIlIIIl) - 8;
        final int llllllllllllllllIlIllIIlllIIlllI = MathHelper.floor(llllllllllllllllIlIllIIlllIIIIll) - 8;
        final int llllllllllllllllIlIllIIlllIIllIl = this.countChunksX * 16;
        for (int llllllllllllllllIlIllIIlllIIllII = 0; llllllllllllllllIlIllIIlllIIllII < this.countChunksX; ++llllllllllllllllIlIllIIlllIIllII) {
            final int llllllllllllllllIlIllIIlllIIlIll = this.getBaseCoordinate(llllllllllllllllIlIllIIlllIIllll, llllllllllllllllIlIllIIlllIIllIl, llllllllllllllllIlIllIIlllIIllII);
            for (int llllllllllllllllIlIllIIlllIIlIlI = 0; llllllllllllllllIlIllIIlllIIlIlI < this.countChunksZ; ++llllllllllllllllIlIllIIlllIIlIlI) {
                final int llllllllllllllllIlIllIIlllIIlIIl = this.getBaseCoordinate(llllllllllllllllIlIllIIlllIIlllI, llllllllllllllllIlIllIIlllIIllIl, llllllllllllllllIlIllIIlllIIlIlI);
                for (int llllllllllllllllIlIllIIlllIIlIII = 0; llllllllllllllllIlIllIIlllIIlIII < this.countChunksY; ++llllllllllllllllIlIllIIlllIIlIII) {
                    final int llllllllllllllllIlIllIIlllIIIlll = llllllllllllllllIlIllIIlllIIlIII * 16;
                    final RenderChunk llllllllllllllllIlIllIIlllIIIllI = this.renderChunks[(llllllllllllllllIlIllIIlllIIlIlI * this.countChunksY + llllllllllllllllIlIllIIlllIIlIII) * this.countChunksX + llllllllllllllllIlIllIIlllIIllII];
                    llllllllllllllllIlIllIIlllIIIllI.setPosition(llllllllllllllllIlIllIIlllIIlIll, llllllllllllllllIlIllIIlllIIIlll, llllllllllllllllIlIllIIlllIIlIIl);
                }
            }
        }
    }
    
    public ViewFrustum(final World llllllllllllllllIlIllIlIIIIlIIII, final int llllllllllllllllIlIllIlIIIIIllll, final RenderGlobal llllllllllllllllIlIllIlIIIIlIIll, final IRenderChunkFactory llllllllllllllllIlIllIlIIIIlIIlI) {
        this.renderGlobal = llllllllllllllllIlIllIlIIIIlIIll;
        this.world = llllllllllllllllIlIllIlIIIIlIIII;
        this.setCountChunksXYZ(llllllllllllllllIlIllIlIIIIIllll);
        this.createRenderChunks(llllllllllllllllIlIllIlIIIIlIIlI);
    }
    
    protected void setCountChunksXYZ(final int llllllllllllllllIlIllIIllllIIlII) {
        final int llllllllllllllllIlIllIIllllIIIll = llllllllllllllllIlIllIIllllIIlII * 2 + 1;
        this.countChunksX = llllllllllllllllIlIllIIllllIIIll;
        this.countChunksY = 16;
        this.countChunksZ = llllllllllllllllIlIllIIllllIIIll;
    }
    
    public void deleteGlResources() {
        final byte llllllllllllllllIlIllIIllllIlIIl;
        final Exception llllllllllllllllIlIllIIllllIlIlI = (Exception)((RenderChunk[])(Object)(llllllllllllllllIlIllIIllllIlIIl = (byte)(Object)this.renderChunks)).length;
        for (float llllllllllllllllIlIllIIllllIlIll = 0; llllllllllllllllIlIllIIllllIlIll < llllllllllllllllIlIllIIllllIlIlI; ++llllllllllllllllIlIllIIllllIlIll) {
            final RenderChunk llllllllllllllllIlIllIIllllIlllI = llllllllllllllllIlIllIIllllIlIIl[llllllllllllllllIlIllIIllllIlIll];
            llllllllllllllllIlIllIIllllIlllI.deleteGlResources();
        }
    }
    
    public void markBlocksForUpdate(final int llllllllllllllllIlIllIIllIIlIIIl, final int llllllllllllllllIlIllIIlIllllIlI, final int llllllllllllllllIlIllIIllIIIllll, final int llllllllllllllllIlIllIIllIIIlllI, final int llllllllllllllllIlIllIIllIIIllIl, final int llllllllllllllllIlIllIIlIlllIllI, final boolean llllllllllllllllIlIllIIlIlllIlIl) {
        final int llllllllllllllllIlIllIIllIIIlIlI = MathHelper.intFloorDiv(llllllllllllllllIlIllIIllIIlIIIl, 16);
        final int llllllllllllllllIlIllIIllIIIlIIl = MathHelper.intFloorDiv(llllllllllllllllIlIllIIlIllllIlI, 16);
        final int llllllllllllllllIlIllIIllIIIlIII = MathHelper.intFloorDiv(llllllllllllllllIlIllIIllIIIllll, 16);
        final int llllllllllllllllIlIllIIllIIIIlll = MathHelper.intFloorDiv(llllllllllllllllIlIllIIllIIIlllI, 16);
        final int llllllllllllllllIlIllIIllIIIIllI = MathHelper.intFloorDiv(llllllllllllllllIlIllIIllIIIllIl, 16);
        final int llllllllllllllllIlIllIIllIIIIlIl = MathHelper.intFloorDiv(llllllllllllllllIlIllIIlIlllIllI, 16);
        for (int llllllllllllllllIlIllIIllIIIIlII = llllllllllllllllIlIllIIllIIIlIlI; llllllllllllllllIlIllIIllIIIIlII <= llllllllllllllllIlIllIIllIIIIlll; ++llllllllllllllllIlIllIIllIIIIlII) {
            int llllllllllllllllIlIllIIllIIIIIll = llllllllllllllllIlIllIIllIIIIlII % this.countChunksX;
            if (llllllllllllllllIlIllIIllIIIIIll < 0) {
                llllllllllllllllIlIllIIllIIIIIll += this.countChunksX;
            }
            for (int llllllllllllllllIlIllIIllIIIIIlI = llllllllllllllllIlIllIIllIIIlIIl; llllllllllllllllIlIllIIllIIIIIlI <= llllllllllllllllIlIllIIllIIIIllI; ++llllllllllllllllIlIllIIllIIIIIlI) {
                int llllllllllllllllIlIllIIllIIIIIIl = llllllllllllllllIlIllIIllIIIIIlI % this.countChunksY;
                if (llllllllllllllllIlIllIIllIIIIIIl < 0) {
                    llllllllllllllllIlIllIIllIIIIIIl += this.countChunksY;
                }
                for (int llllllllllllllllIlIllIIllIIIIIII = llllllllllllllllIlIllIIllIIIlIII; llllllllllllllllIlIllIIllIIIIIII <= llllllllllllllllIlIllIIllIIIIlIl; ++llllllllllllllllIlIllIIllIIIIIII) {
                    int llllllllllllllllIlIllIIlIlllllll = llllllllllllllllIlIllIIllIIIIIII % this.countChunksZ;
                    if (llllllllllllllllIlIllIIlIlllllll < 0) {
                        llllllllllllllllIlIllIIlIlllllll += this.countChunksZ;
                    }
                    final int llllllllllllllllIlIllIIlIllllllI = (llllllllllllllllIlIllIIlIlllllll * this.countChunksY + llllllllllllllllIlIllIIllIIIIIIl) * this.countChunksX + llllllllllllllllIlIllIIllIIIIIll;
                    final RenderChunk llllllllllllllllIlIllIIlIlllllIl = this.renderChunks[llllllllllllllllIlIllIIlIllllllI];
                    llllllllllllllllIlIllIIlIlllllIl.setNeedsUpdate(llllllllllllllllIlIllIIlIlllIlIl);
                }
            }
        }
    }
}
