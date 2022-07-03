package optifine;

import net.minecraft.util.math.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import java.util.*;

public class NaturalProperties
{
    public /* synthetic */ boolean flip;
    private /* synthetic */ Map[] quadMaps;
    public /* synthetic */ int rotation;
    
    public boolean isValid() {
        return this.rotation == 2 || this.rotation == 4 || this.flip;
    }
    
    private boolean equalsDelta(final float lllllllllllllIIlIlIlllIIIlIIllIl, final float lllllllllllllIIlIlIlllIIIlIIlIII, final float lllllllllllllIIlIlIlllIIIlIIlIll) {
        final float lllllllllllllIIlIlIlllIIIlIIlIlI = MathHelper.abs(lllllllllllllIIlIlIlllIIIlIIllIl - lllllllllllllIIlIlIlllIIIlIIlIII);
        return lllllllllllllIIlIlIlllIIIlIIlIlI < lllllllllllllIIlIlIlllIIIlIIlIll;
    }
    
    private int[] transformVertexData(final int[] lllllllllllllIIlIlIlllIIlIIlIlll, final int lllllllllllllIIlIlIlllIIlIIIllIl, final boolean lllllllllllllIIlIlIlllIIlIIlIlIl) {
        final int[] lllllllllllllIIlIlIlllIIlIIlIlII = lllllllllllllIIlIlIlllIIlIIlIlll.clone();
        int lllllllllllllIIlIlIlllIIlIIlIIll = 4 - lllllllllllllIIlIlIlllIIlIIIllIl;
        if (lllllllllllllIIlIlIlllIIlIIlIlIl) {
            lllllllllllllIIlIlIlllIIlIIlIIll += 3;
        }
        lllllllllllllIIlIlIlllIIlIIlIIll %= 4;
        final int lllllllllllllIIlIlIlllIIlIIlIIlI = lllllllllllllIIlIlIlllIIlIIlIlII.length / 4;
        for (int lllllllllllllIIlIlIlllIIlIIlIIIl = 0; lllllllllllllIIlIlIlllIIlIIlIIIl < 4; ++lllllllllllllIIlIlIlllIIlIIlIIIl) {
            final int lllllllllllllIIlIlIlllIIlIIlIIII = lllllllllllllIIlIlIlllIIlIIlIIIl * lllllllllllllIIlIlIlllIIlIIlIIlI;
            final int lllllllllllllIIlIlIlllIIlIIIllll = lllllllllllllIIlIlIlllIIlIIlIIll * lllllllllllllIIlIlIlllIIlIIlIIlI;
            lllllllllllllIIlIlIlllIIlIIlIlII[lllllllllllllIIlIlIlllIIlIIIllll + 4] = lllllllllllllIIlIlIlllIIlIIlIlll[lllllllllllllIIlIlIlllIIlIIlIIII + 4];
            lllllllllllllIIlIlIlllIIlIIlIlII[lllllllllllllIIlIlIlllIIlIIIllll + 4 + 1] = lllllllllllllIIlIlIlllIIlIIlIlll[lllllllllllllIIlIlIlllIIlIIlIIII + 4 + 1];
            if (lllllllllllllIIlIlIlllIIlIIlIlIl) {
                if (--lllllllllllllIIlIlIlllIIlIIlIIll < 0) {
                    lllllllllllllIIlIlIlllIIlIIlIIll = 3;
                }
            }
            else if (++lllllllllllllIIlIlIlllIIlIIlIIll > 3) {
                lllllllllllllIIlIlIlllIIlIIlIIll = 0;
            }
        }
        return lllllllllllllIIlIlIlllIIlIIlIlII;
    }
    
    private boolean isFullSprite(final BakedQuad lllllllllllllIIlIlIlllIIIllIIIlI) {
        final TextureAtlasSprite lllllllllllllIIlIlIlllIIIlllIIlI = lllllllllllllIIlIlIlllIIIllIIIlI.getSprite();
        final float lllllllllllllIIlIlIlllIIIlllIIIl = lllllllllllllIIlIlIlllIIIlllIIlI.getMinU();
        final float lllllllllllllIIlIlIlllIIIlllIIII = lllllllllllllIIlIlIlllIIIlllIIlI.getMaxU();
        final float lllllllllllllIIlIlIlllIIIllIllll = lllllllllllllIIlIlIlllIIIlllIIII - lllllllllllllIIlIlIlllIIIlllIIIl;
        final float lllllllllllllIIlIlIlllIIIllIlllI = lllllllllllllIIlIlIlllIIIllIllll / 256.0f;
        final float lllllllllllllIIlIlIlllIIIllIllIl = lllllllllllllIIlIlIlllIIIlllIIlI.getMinV();
        final float lllllllllllllIIlIlIlllIIIllIllII = lllllllllllllIIlIlIlllIIIlllIIlI.getMaxV();
        final float lllllllllllllIIlIlIlllIIIllIlIll = lllllllllllllIIlIlIlllIIIllIllII - lllllllllllllIIlIlIlllIIIllIllIl;
        final float lllllllllllllIIlIlIlllIIIllIlIlI = lllllllllllllIIlIlIlllIIIllIlIll / 256.0f;
        final int[] lllllllllllllIIlIlIlllIIIllIlIIl = lllllllllllllIIlIlIlllIIIllIIIlI.getVertexData();
        final int lllllllllllllIIlIlIlllIIIllIlIII = lllllllllllllIIlIlIlllIIIllIlIIl.length / 4;
        for (int lllllllllllllIIlIlIlllIIIllIIlll = 0; lllllllllllllIIlIlIlllIIIllIIlll < 4; ++lllllllllllllIIlIlIlllIIIllIIlll) {
            final int lllllllllllllIIlIlIlllIIIllIIllI = lllllllllllllIIlIlIlllIIIllIIlll * lllllllllllllIIlIlIlllIIIllIlIII;
            final float lllllllllllllIIlIlIlllIIIllIIlIl = Float.intBitsToFloat(lllllllllllllIIlIlIlllIIIllIlIIl[lllllllllllllIIlIlIlllIIIllIIllI + 4]);
            final float lllllllllllllIIlIlIlllIIIllIIlII = Float.intBitsToFloat(lllllllllllllIIlIlIlllIIIllIlIIl[lllllllllllllIIlIlIlllIIIllIIllI + 4 + 1]);
            if (!this.equalsDelta(lllllllllllllIIlIlIlllIIIllIIlIl, lllllllllllllIIlIlIlllIIIlllIIIl, lllllllllllllIIlIlIlllIIIllIlllI) && !this.equalsDelta(lllllllllllllIIlIlIlllIIIllIIlIl, lllllllllllllIIlIlIlllIIIlllIIII, lllllllllllllIIlIlIlllIIIllIlllI)) {
                return false;
            }
            if (!this.equalsDelta(lllllllllllllIIlIlIlllIIIllIIlII, lllllllllllllIIlIlIlllIIIllIllIl, lllllllllllllIIlIlIlllIIIllIlIlI) && !this.equalsDelta(lllllllllllllIIlIlIlllIIIllIIlII, lllllllllllllIIlIlIlllIIIllIllII, lllllllllllllIIlIlIlllIIIllIlIlI)) {
                return false;
            }
        }
        return true;
    }
    
    private BakedQuad makeQuad(final BakedQuad lllllllllllllIIlIlIlllIIlIllIIlI, int lllllllllllllIIlIlIlllIIlIlIlIII, final boolean lllllllllllllIIlIlIlllIIlIllIIII) {
        int[] lllllllllllllIIlIlIlllIIlIlIllll = lllllllllllllIIlIlIlllIIlIllIIlI.getVertexData();
        final int lllllllllllllIIlIlIlllIIlIlIlllI = lllllllllllllIIlIlIlllIIlIllIIlI.getTintIndex();
        final EnumFacing lllllllllllllIIlIlIlllIIlIlIllIl = lllllllllllllIIlIlIlllIIlIllIIlI.getFace();
        final TextureAtlasSprite lllllllllllllIIlIlIlllIIlIlIllII = lllllllllllllIIlIlIlllIIlIllIIlI.getSprite();
        if (!this.isFullSprite(lllllllllllllIIlIlIlllIIlIllIIlI)) {
            lllllllllllllIIlIlIlllIIlIlIlIII = 0;
        }
        lllllllllllllIIlIlIlllIIlIlIllll = this.transformVertexData(lllllllllllllIIlIlIlllIIlIlIllll, (int)lllllllllllllIIlIlIlllIIlIlIlIII, lllllllllllllIIlIlIlllIIlIllIIII);
        final BakedQuad lllllllllllllIIlIlIlllIIlIlIlIll = new BakedQuad(lllllllllllllIIlIlIlllIIlIlIllll, lllllllllllllIIlIlIlllIIlIlIlllI, lllllllllllllIIlIlIlllIIlIlIllIl, lllllllllllllIIlIlIlllIIlIlIllII);
        return lllllllllllllIIlIlIlllIIlIlIlIll;
    }
    
    public synchronized BakedQuad getQuad(final BakedQuad lllllllllllllIIlIlIlllIIllIIlIIl, final int lllllllllllllIIlIlIlllIIllIIIIIl, final boolean lllllllllllllIIlIlIlllIIllIIIlll) {
        int lllllllllllllIIlIlIlllIIllIIIllI = lllllllllllllIIlIlIlllIIllIIIIIl;
        if (lllllllllllllIIlIlIlllIIllIIIlll) {
            lllllllllllllIIlIlIlllIIllIIIllI = (lllllllllllllIIlIlIlllIIllIIIIIl | 0x4);
        }
        if (lllllllllllllIIlIlIlllIIllIIIllI > 0 && lllllllllllllIIlIlIlllIIllIIIllI < this.quadMaps.length) {
            Map lllllllllllllIIlIlIlllIIllIIIlIl = this.quadMaps[lllllllllllllIIlIlIlllIIllIIIllI];
            if (lllllllllllllIIlIlIlllIIllIIIlIl == null) {
                lllllllllllllIIlIlIlllIIllIIIlIl = new IdentityHashMap(1);
                this.quadMaps[lllllllllllllIIlIlIlllIIllIIIllI] = lllllllllllllIIlIlIlllIIllIIIlIl;
            }
            BakedQuad lllllllllllllIIlIlIlllIIllIIIlII = lllllllllllllIIlIlIlllIIllIIIlIl.get(lllllllllllllIIlIlIlllIIllIIlIIl);
            if (lllllllllllllIIlIlIlllIIllIIIlII == null) {
                lllllllllllllIIlIlIlllIIllIIIlII = this.makeQuad(lllllllllllllIIlIlIlllIIllIIlIIl, lllllllllllllIIlIlIlllIIllIIIIIl, lllllllllllllIIlIlIlllIIllIIIlll);
                lllllllllllllIIlIlIlllIIllIIIlIl.put(lllllllllllllIIlIlIlllIIllIIlIIl, lllllllllllllIIlIlIlllIIllIIIlII);
            }
            return lllllllllllllIIlIlIlllIIllIIIlII;
        }
        return lllllllllllllIIlIlIlllIIllIIlIIl;
    }
    
    public NaturalProperties(final String lllllllllllllIIlIlIlllIIllIlIlIl) {
        this.rotation = 1;
        this.flip = false;
        this.quadMaps = new Map[8];
        if (lllllllllllllIIlIlIlllIIllIlIlIl.equals("4")) {
            this.rotation = 4;
        }
        else if (lllllllllllllIIlIlIlllIIllIlIlIl.equals("2")) {
            this.rotation = 2;
        }
        else if (lllllllllllllIIlIlIlllIIllIlIlIl.equals("F")) {
            this.flip = true;
        }
        else if (lllllllllllllIIlIlIlllIIllIlIlIl.equals("4F")) {
            this.rotation = 4;
            this.flip = true;
        }
        else if (lllllllllllllIIlIlIlllIIllIlIlIl.equals("2F")) {
            this.rotation = 2;
            this.flip = true;
        }
        else {
            Config.warn(String.valueOf(new StringBuilder("NaturalTextures: Unknown type: ").append(lllllllllllllIIlIlIlllIIllIlIlIl)));
        }
    }
}
