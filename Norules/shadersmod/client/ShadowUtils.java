package shadersmod.client;

import net.minecraft.client.multiplayer.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.chunk.*;
import net.minecraft.util.math.*;
import java.util.*;

public class ShadowUtils
{
    public static Iterator<RenderChunk> makeShadowChunkIterator(final WorldClient lllllllllllllIlIIIIIlllllIlIIIIl, final double lllllllllllllIlIIIIIlllllIlIIIII, final Entity lllllllllllllIlIIIIIlllllIIlllll, final int lllllllllllllIlIIIIIlllllIIIlIll, final ViewFrustum lllllllllllllIlIIIIIlllllIIlllIl) {
        final float lllllllllllllIlIIIIIlllllIIlllII = Shaders.getShadowRenderDistance();
        if (lllllllllllllIlIIIIIlllllIIlllII > 0.0f && lllllllllllllIlIIIIIlllllIIlllII < (lllllllllllllIlIIIIIlllllIIIlIll - 1) * 16) {
            final int lllllllllllllIlIIIIIlllllIIllIll = MathHelper.ceil(lllllllllllllIlIIIIIlllllIIlllII / 16.0f) + 1;
            final float lllllllllllllIlIIIIIlllllIIllIlI = lllllllllllllIlIIIIIlllllIlIIIIl.getCelestialAngleRadians((float)lllllllllllllIlIIIIIlllllIlIIIII);
            final float lllllllllllllIlIIIIIlllllIIllIIl = Shaders.sunPathRotation * 0.017453292f;
            final float lllllllllllllIlIIIIIlllllIIllIII = (lllllllllllllIlIIIIIlllllIIllIlI > 1.5707964f && lllllllllllllIlIIIIIlllllIIllIlI < 4.712389f) ? (lllllllllllllIlIIIIIlllllIIllIlI + 3.1415927f) : lllllllllllllIlIIIIIlllllIIllIlI;
            final float lllllllllllllIlIIIIIlllllIIlIlll = -MathHelper.sin(lllllllllllllIlIIIIIlllllIIllIII);
            final float lllllllllllllIlIIIIIlllllIIlIllI = MathHelper.cos(lllllllllllllIlIIIIIlllllIIllIII) * MathHelper.cos(lllllllllllllIlIIIIIlllllIIllIIl);
            final float lllllllllllllIlIIIIIlllllIIlIlIl = -MathHelper.cos(lllllllllllllIlIIIIIlllllIIllIII) * MathHelper.sin(lllllllllllllIlIIIIIlllllIIllIIl);
            final BlockPos lllllllllllllIlIIIIIlllllIIlIlII = new BlockPos(MathHelper.floor(lllllllllllllIlIIIIIlllllIIlllll.posX) >> 4, MathHelper.floor(lllllllllllllIlIIIIIlllllIIlllll.posY) >> 4, MathHelper.floor(lllllllllllllIlIIIIIlllllIIlllll.posZ) >> 4);
            final BlockPos lllllllllllllIlIIIIIlllllIIlIIll = lllllllllllllIlIIIIIlllllIIlIlII.add(-lllllllllllllIlIIIIIlllllIIlIlll * lllllllllllllIlIIIIIlllllIIllIll, -lllllllllllllIlIIIIIlllllIIlIllI * lllllllllllllIlIIIIIlllllIIllIll, -lllllllllllllIlIIIIIlllllIIlIlIl * lllllllllllllIlIIIIIlllllIIllIll);
            final BlockPos lllllllllllllIlIIIIIlllllIIlIIlI = lllllllllllllIlIIIIIlllllIIlIlII.add(lllllllllllllIlIIIIIlllllIIlIlll * lllllllllllllIlIIIIIlllllIIIlIll, lllllllllllllIlIIIIIlllllIIlIllI * lllllllllllllIlIIIIIlllllIIIlIll, lllllllllllllIlIIIIIlllllIIlIlIl * lllllllllllllIlIIIIIlllllIIIlIll);
            final IteratorRenderChunks lllllllllllllIlIIIIIlllllIIlIIIl = new IteratorRenderChunks(lllllllllllllIlIIIIIlllllIIlllIl, lllllllllllllIlIIIIIlllllIIlIIll, lllllllllllllIlIIIIIlllllIIlIIlI, lllllllllllllIlIIIIIlllllIIllIll, lllllllllllllIlIIIIIlllllIIllIll);
            return lllllllllllllIlIIIIIlllllIIlIIIl;
        }
        final List<RenderChunk> lllllllllllllIlIIIIIlllllIIlIIII = Arrays.asList(lllllllllllllIlIIIIIlllllIIlllIl.renderChunks);
        final Iterator<RenderChunk> lllllllllllllIlIIIIIlllllIIIllll = lllllllllllllIlIIIIIlllllIIlIIII.iterator();
        return lllllllllllllIlIIIIIlllllIIIllll;
    }
}
