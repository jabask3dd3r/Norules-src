package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public interface IRenderChunkFactory
{
    RenderChunk create(final World p0, final RenderGlobal p1, final int p2);
}
