package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class VboChunkFactory implements IRenderChunkFactory
{
    @Override
    public RenderChunk create(final World llIIIllllIlIIll, final RenderGlobal llIIIllllIIllll, final int llIIIllllIlIIIl) {
        return new RenderChunk(llIIIllllIlIIll, llIIIllllIIllll, llIIIllllIlIIIl);
    }
}
