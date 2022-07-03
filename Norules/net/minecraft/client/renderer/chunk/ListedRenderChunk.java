package net.minecraft.client.renderer.chunk;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ListedRenderChunk extends RenderChunk
{
    private final /* synthetic */ int baseDisplayList;
    
    public ListedRenderChunk(final World lllllllllllllIlllIIllllllIIIlIll, final RenderGlobal lllllllllllllIlllIIllllllIIIIllI, final int lllllllllllllIlllIIllllllIIIIlIl) {
        super(lllllllllllllIlllIIllllllIIIlIll, lllllllllllllIlllIIllllllIIIIllI, lllllllllllllIlllIIllllllIIIIlIl);
        this.baseDisplayList = GLAllocation.generateDisplayLists(BlockRenderLayer.values().length);
    }
    
    @Override
    public void deleteGlResources() {
        super.deleteGlResources();
        GLAllocation.deleteDisplayLists(this.baseDisplayList, BlockRenderLayer.values().length);
    }
    
    public int getDisplayList(final BlockRenderLayer lllllllllllllIlllIIlllllIlllllIl, final CompiledChunk lllllllllllllIlllIIlllllIlllllII) {
        return lllllllllllllIlllIIlllllIlllllII.isLayerEmpty(lllllllllllllIlllIIlllllIlllllIl) ? -1 : (this.baseDisplayList + lllllllllllllIlllIIlllllIlllllIl.ordinal());
    }
}
