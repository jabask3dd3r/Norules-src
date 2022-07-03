package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class ListChunkFactory implements IRenderChunkFactory
{
    @Override
    public RenderChunk create(final World lllllllllllllIlIlIlIlIIllIIllIIl, final RenderGlobal lllllllllllllIlIlIlIlIIllIIllIII, final int lllllllllllllIlIlIlIlIIllIIllIlI) {
        return new ListedRenderChunk(lllllllllllllIlIlIlIlIIllIIllIIl, lllllllllllllIlIlIlIlIIllIIllIII, lllllllllllllIlIlIlIlIIllIIllIlI);
    }
}
