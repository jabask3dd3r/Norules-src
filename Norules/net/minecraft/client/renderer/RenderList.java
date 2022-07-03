package net.minecraft.client.renderer;

import net.minecraft.util.*;
import net.minecraft.client.renderer.chunk.*;
import optifine.*;

public class RenderList extends ChunkRenderContainer
{
    @Override
    public void renderChunkLayer(final BlockRenderLayer lllllllllllllIIlIIllIlIlIlIllIlI) {
        if (this.initialized) {
            if (this.renderChunks.size() == 0) {
                return;
            }
            for (final RenderChunk lllllllllllllIIlIIllIlIlIlIllIIl : this.renderChunks) {
                final ListedRenderChunk lllllllllllllIIlIIllIlIlIlIllIII = (ListedRenderChunk)lllllllllllllIIlIIllIlIlIlIllIIl;
                GlStateManager.pushMatrix();
                this.preRenderChunk(lllllllllllllIIlIIllIlIlIlIllIIl);
                GlStateManager.callList(lllllllllllllIIlIIllIlIlIlIllIII.getDisplayList(lllllllllllllIIlIIllIlIlIlIllIlI, lllllllllllllIIlIIllIlIlIlIllIII.getCompiledChunk()));
                GlStateManager.popMatrix();
            }
            if (Config.isMultiTexture()) {
                GlStateManager.bindCurrentTexture();
            }
            GlStateManager.resetColor();
            this.renderChunks.clear();
        }
    }
}
