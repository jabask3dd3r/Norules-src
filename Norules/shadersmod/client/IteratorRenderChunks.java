package shadersmod.client;

import java.util.*;
import net.minecraft.client.renderer.chunk.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class IteratorRenderChunks implements Iterator<RenderChunk>
{
    private /* synthetic */ Iterator3d Iterator3d;
    private /* synthetic */ BlockPosM posBlock;
    private /* synthetic */ ViewFrustum viewFrustum;
    
    @Override
    public void remove() {
        throw new RuntimeException("Not implemented");
    }
    
    @Override
    public boolean hasNext() {
        return this.Iterator3d.hasNext();
    }
    
    @Override
    public RenderChunk next() {
        final BlockPos llllllllllllllIlIlIIlllIIIlIIlII = this.Iterator3d.next();
        this.posBlock.setXyz(llllllllllllllIlIlIIlllIIIlIIlII.getX() << 4, llllllllllllllIlIlIIlllIIIlIIlII.getY() << 4, llllllllllllllIlIlIIlllIIIlIIlII.getZ() << 4);
        final RenderChunk llllllllllllllIlIlIIlllIIIlIIIll = this.viewFrustum.getRenderChunk(this.posBlock);
        return llllllllllllllIlIlIIlllIIIlIIIll;
    }
    
    public IteratorRenderChunks(final ViewFrustum llllllllllllllIlIlIIlllIIIllIIII, final BlockPos llllllllllllllIlIlIIlllIIIlIllll, final BlockPos llllllllllllllIlIlIIlllIIIlIlllI, final int llllllllllllllIlIlIIlllIIIlIllIl, final int llllllllllllllIlIlIIlllIIIlIllII) {
        this.posBlock = new BlockPosM(0, 0, 0);
        this.viewFrustum = llllllllllllllIlIlIIlllIIIllIIII;
        this.Iterator3d = new Iterator3d(llllllllllllllIlIlIIlllIIIlIllll, llllllllllllllIlIlIIlllIIIlIlllI, llllllllllllllIlIlIIlllIIIlIllIl, llllllllllllllIlIlIIlllIIIlIllII);
    }
}
