package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import java.util.*;

public class BakedQuadRetextured extends BakedQuad
{
    private final /* synthetic */ TextureAtlasSprite texture;
    private final /* synthetic */ TextureAtlasSprite spriteOld;
    
    public BakedQuadRetextured(final BakedQuad llllllllllllllIllllllIlllIIIIlll, final TextureAtlasSprite llllllllllllllIllllllIlllIIIIllI) {
        super(Arrays.copyOf(llllllllllllllIllllllIlllIIIIlll.getVertexData(), llllllllllllllIllllllIlllIIIIlll.getVertexData().length), llllllllllllllIllllllIlllIIIIlll.tintIndex, FaceBakery.getFacingFromVertexData(llllllllllllllIllllllIlllIIIIlll.getVertexData()), llllllllllllllIllllllIlllIIIIllI);
        this.texture = llllllllllllllIllllllIlllIIIIllI;
        this.format = llllllllllllllIllllllIlllIIIIlll.format;
        this.applyDiffuseLighting = llllllllllllllIllllllIlllIIIIlll.applyDiffuseLighting;
        this.spriteOld = llllllllllllllIllllllIlllIIIIlll.getSprite();
        this.remapQuad();
        this.fixVertexData();
    }
    
    private void remapQuad() {
        for (int llllllllllllllIllllllIllIlllllIl = 0; llllllllllllllIllllllIllIlllllIl < 4; ++llllllllllllllIllllllIllIlllllIl) {
            final int llllllllllllllIllllllIllIlllllII = this.format.getIntegerSize() * llllllllllllllIllllllIllIlllllIl;
            final int llllllllllllllIllllllIllIllllIll = this.format.getUvOffsetById(0) / 4;
            this.vertexData[llllllllllllllIllllllIllIlllllII + llllllllllllllIllllllIllIllllIll] = Float.floatToRawIntBits(this.texture.getInterpolatedU(this.spriteOld.getUnInterpolatedU(Float.intBitsToFloat(this.vertexData[llllllllllllllIllllllIllIlllllII + llllllllllllllIllllllIllIllllIll]))));
            this.vertexData[llllllllllllllIllllllIllIlllllII + llllllllllllllIllllllIllIllllIll + 1] = Float.floatToRawIntBits(this.texture.getInterpolatedV(this.spriteOld.getUnInterpolatedV(Float.intBitsToFloat(this.vertexData[llllllllllllllIllllllIllIlllllII + llllllllllllllIllllllIllIllllIll + 1]))));
        }
    }
}
