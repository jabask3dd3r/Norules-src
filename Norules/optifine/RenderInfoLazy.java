package optifine;

import net.minecraft.client.renderer.chunk.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class RenderInfoLazy
{
    private /* synthetic */ RenderChunk renderChunk;
    private /* synthetic */ RenderGlobal.ContainerLocalRenderInformation renderInfo;
    
    public RenderGlobal.ContainerLocalRenderInformation getRenderInfo() {
        if (this.renderInfo == null) {
            this.renderInfo = new RenderGlobal.ContainerLocalRenderInformation(this.renderChunk, null, 0);
        }
        return this.renderInfo;
    }
    
    public RenderChunk getRenderChunk() {
        return this.renderChunk;
    }
    
    public void setRenderChunk(final RenderChunk lllllllllllllIIIIIlIllllIIIIllll) {
        this.renderChunk = lllllllllllllIIIIIlIllllIIIIllll;
        this.renderInfo = null;
    }
}
