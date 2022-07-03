package net.minecraft.client.renderer;

import optifine.*;
import shadersmod.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.client.renderer.vertex.*;

public class VboRenderList extends ChunkRenderContainer
{
    private void setupArrayPointers() {
        if (Config.isShaders()) {
            ShadersRender.setupArrayPointersVbo();
        }
        else {
            GlStateManager.glVertexPointer(3, 5126, 28, 0);
            GlStateManager.glColorPointer(4, 5121, 28, 12);
            GlStateManager.glTexCoordPointer(2, 5126, 28, 16);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.glTexCoordPointer(2, 5122, 28, 24);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
        }
    }
    
    @Override
    public void renderChunkLayer(final BlockRenderLayer llIIIIIlIIlIIIl) {
        if (this.initialized) {
            for (final RenderChunk llIIIIIlIIlIlII : this.renderChunks) {
                final VertexBuffer llIIIIIlIIlIIll = llIIIIIlIIlIlII.getVertexBufferByLayer(llIIIIIlIIlIIIl.ordinal());
                GlStateManager.pushMatrix();
                this.preRenderChunk(llIIIIIlIIlIlII);
                llIIIIIlIIlIlII.multModelviewMatrix();
                llIIIIIlIIlIIll.bindBuffer();
                this.setupArrayPointers();
                llIIIIIlIIlIIll.drawArrays(7);
                GlStateManager.popMatrix();
            }
            OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
            GlStateManager.resetColor();
            this.renderChunks.clear();
        }
    }
}
