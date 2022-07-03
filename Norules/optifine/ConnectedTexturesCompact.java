package optifine;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;

public class ConnectedTexturesCompact
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$optifine$ConnectedTexturesCompact$Dir;
    
    private static BakedQuad getQuadCompact(final TextureAtlasSprite lllllllllllllIllllIIIlIIIIlIlIll, final Dir lllllllllllllIllllIIIlIIIIlllIII, final int lllllllllllllIllllIIIlIIIIlIlIIl, final int lllllllllllllIllllIIIlIIIIlIlIII, final int lllllllllllllIllllIIIlIIIIllIlIl, final int lllllllllllllIllllIIIlIIIIllIlII, final int lllllllllllllIllllIIIlIIIIlIIlIl, final BakedQuad lllllllllllllIllllIIIlIIIIllIIlI, final RenderEnv lllllllllllllIllllIIIlIIIIllIIIl) {
        final Map[][] lllllllllllllIllllIIIlIIIIllIIII = ConnectedTextures.getSpriteQuadCompactMaps();
        if (lllllllllllllIllllIIIlIIIIllIIII == null) {
            return lllllllllllllIllllIIIlIIIIllIIlI;
        }
        final int lllllllllllllIllllIIIlIIIIlIllll = lllllllllllllIllllIIIlIIIIlIlIll.getIndexInMap();
        if (lllllllllllllIllllIIIlIIIIlIllll >= 0 && lllllllllllllIllllIIIlIIIIlIllll < lllllllllllllIllllIIIlIIIIllIIII.length) {
            Map[] lllllllllllllIllllIIIlIIIIlIlllI = lllllllllllllIllllIIIlIIIIllIIII[lllllllllllllIllllIIIlIIIIlIllll];
            if (lllllllllllllIllllIIIlIIIIlIlllI == null) {
                lllllllllllllIllllIIIlIIIIlIlllI = new Map[Dir.VALUES.length];
                lllllllllllllIllllIIIlIIIIllIIII[lllllllllllllIllllIIIlIIIIlIllll] = lllllllllllllIllllIIIlIIIIlIlllI;
            }
            Map<BakedQuad, BakedQuad> lllllllllllllIllllIIIlIIIIlIllIl = (Map<BakedQuad, BakedQuad>)lllllllllllllIllllIIIlIIIIlIlllI[lllllllllllllIllllIIIlIIIIlllIII.ordinal()];
            if (lllllllllllllIllllIIIlIIIIlIllIl == null) {
                lllllllllllllIllllIIIlIIIIlIllIl = new IdentityHashMap<BakedQuad, BakedQuad>(1);
                lllllllllllllIllllIIIlIIIIlIlllI[lllllllllllllIllllIIIlIIIIlllIII.ordinal()] = lllllllllllllIllllIIIlIIIIlIllIl;
            }
            BakedQuad lllllllllllllIllllIIIlIIIIlIllII = lllllllllllllIllllIIIlIIIIlIllIl.get(lllllllllllllIllllIIIlIIIIllIIlI);
            if (lllllllllllllIllllIIIlIIIIlIllII == null) {
                lllllllllllllIllllIIIlIIIIlIllII = makeSpriteQuadCompact(lllllllllllllIllllIIIlIIIIllIIlI, lllllllllllllIllllIIIlIIIIlIlIll, lllllllllllllIllllIIIlIIIIlIIlIl, lllllllllllllIllllIIIlIIIIlIlIIl, lllllllllllllIllllIIIlIIIIlIlIII, lllllllllllllIllllIIIlIIIIllIlIl, lllllllllllllIllllIIIlIIIIllIlII);
                lllllllllllllIllllIIIlIIIIlIllIl.put(lllllllllllllIllllIIIlIIIIllIIlI, lllllllllllllIllllIIIlIIIIlIllII);
            }
            return lllllllllllllIllllIIIlIIIIlIllII;
        }
        return lllllllllllllIllllIIIlIIIIllIIlI;
    }
    
    private static BakedQuad getQuadCompact(final TextureAtlasSprite lllllllllllllIllllIIIlIIIlIIlIll, final Dir lllllllllllllIllllIIIlIIIlIIlIlI, final int lllllllllllllIllllIIIlIIIlIIlIIl, final BakedQuad lllllllllllllIllllIIIlIIIlIIlIII, final RenderEnv lllllllllllllIllllIIIlIIIlIIIlll) {
        switch ($SWITCH_TABLE$optifine$ConnectedTexturesCompact$Dir()[lllllllllllllIllllIIIlIIIlIIlIlI.ordinal()]) {
            case 1: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 0, 0, 16, 8, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 2: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 8, 0, 16, 8, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 3: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 8, 0, 16, 16, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 4: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 8, 8, 16, 16, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 5: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 0, 8, 16, 16, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 6: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 0, 8, 8, 16, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 7: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 0, 0, 8, 16, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            case 8: {
                return getQuadCompact(lllllllllllllIllllIIIlIIIlIIlIll, lllllllllllllIllllIIIlIIIlIIlIlI, 0, 0, 8, 8, lllllllllllllIllllIIIlIIIlIIlIIl, lllllllllllllIllllIIIlIIIlIIlIII, lllllllllllllIllllIIIlIIIlIIIlll);
            }
            default: {
                return lllllllllllllIllllIIIlIIIlIIlIII;
            }
        }
    }
    
    private static BakedQuad[] getQuadsCompact(final Dir lllllllllllllIllllIIIlIIIllIIlIl, final int lllllllllllllIllllIIIlIIIllllIll, final Dir lllllllllllllIllllIIIlIIIllllIlI, final int lllllllllllllIllllIIIlIIIllllIIl, final Dir lllllllllllllIllllIIIlIIIllIIIIl, final int lllllllllllllIllllIIIlIIIlllIlll, final Dir lllllllllllllIllllIIIlIIIlIlllll, final int lllllllllllllIllllIIIlIIIlllIlII, final TextureAtlasSprite[] lllllllllllllIllllIIIlIIIlllIIlI, final int lllllllllllllIllllIIIlIIIlllIIII, final BakedQuad lllllllllllllIllllIIIlIIIllIlllI, final RenderEnv lllllllllllllIllllIIIlIIIllIllII) {
        final BakedQuad lllllllllllllIllllIIIlIIIllIlIlI = getQuadCompact(lllllllllllllIllllIIIlIIIlllIIlI[lllllllllllllIllllIIIlIIIllllIll], lllllllllllllIllllIIIlIIIllIIlIl, lllllllllllllIllllIIIlIIIlllIIII, lllllllllllllIllllIIIlIIIllIlllI, lllllllllllllIllllIIIlIIIllIllII);
        final BakedQuad lllllllllllllIllllIIIlIIIllIlIIl = getQuadCompact(lllllllllllllIllllIIIlIIIlllIIlI[lllllllllllllIllllIIIlIIIllllIIl], lllllllllllllIllllIIIlIIIllllIlI, lllllllllllllIllllIIIlIIIlllIIII, lllllllllllllIllllIIIlIIIllIlllI, lllllllllllllIllllIIIlIIIllIllII);
        final BakedQuad lllllllllllllIllllIIIlIIIllIlIII = getQuadCompact(lllllllllllllIllllIIIlIIIlllIIlI[lllllllllllllIllllIIIlIIIlllIlll], lllllllllllllIllllIIIlIIIllIIIIl, lllllllllllllIllllIIIlIIIlllIIII, lllllllllllllIllllIIIlIIIllIlllI, lllllllllllllIllllIIIlIIIllIllII);
        final BakedQuad lllllllllllllIllllIIIlIIIllIIllI = getQuadCompact(lllllllllllllIllllIIIlIIIlllIIlI[lllllllllllllIllllIIIlIIIlllIlII], lllllllllllllIllllIIIlIIIlIlllll, lllllllllllllIllllIIIlIIIlllIIII, lllllllllllllIllllIIIlIIIllIlllI, lllllllllllllIllllIIIlIIIllIllII);
        return lllllllllllllIllllIIIlIIIllIllII.getArrayQuadsCtm(lllllllllllllIllllIIIlIIIllIlIlI, lllllllllllllIllllIIIlIIIllIlIIl, lllllllllllllIllllIIIlIIIllIlIII, lllllllllllllIllllIIIlIIIllIIllI);
    }
    
    public static BakedQuad[] getConnectedTextureCtmCompact(final int lllllllllllllIllllIIIlIlIllIllIl, final ConnectedProperties lllllllllllllIllllIIIlIlIlllIIlI, final int lllllllllllllIllllIIIlIlIllIlIll, final BakedQuad lllllllllllllIllllIIIlIlIllIlIlI, final RenderEnv lllllllllllllIllllIIIlIlIllIllll) {
        if (lllllllllllllIllllIIIlIlIlllIIlI.ctmTileIndexes != null && lllllllllllllIllllIIIlIlIllIllIl >= 0 && lllllllllllllIllllIIIlIlIllIllIl < lllllllllllllIllllIIIlIlIlllIIlI.ctmTileIndexes.length) {
            final int lllllllllllllIllllIIIlIlIllIlllI = lllllllllllllIllllIIIlIlIlllIIlI.ctmTileIndexes[lllllllllllllIllllIIIlIlIllIllIl];
            if (lllllllllllllIllllIIIlIlIllIlllI >= 0 && lllllllllllllIllllIIIlIlIllIlllI <= lllllllllllllIllllIIIlIlIlllIIlI.tileIcons.length) {
                return getQuadsCompact(lllllllllllllIllllIIIlIlIllIlllI, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
        }
        switch (lllllllllllllIllllIIIlIlIllIllIl) {
            case 1: {
                return getQuadsCompactH(0, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 2: {
                return getQuadsCompact(3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 3: {
                return getQuadsCompactH(3, 0, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 4: {
                return getQuadsCompact4(0, 3, 2, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 5: {
                return getQuadsCompact4(3, 0, 4, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 6: {
                return getQuadsCompact4(2, 4, 2, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 7: {
                return getQuadsCompact4(3, 3, 4, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 8: {
                return getQuadsCompact4(4, 1, 4, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 9: {
                return getQuadsCompact4(4, 4, 4, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 10: {
                return getQuadsCompact4(1, 4, 1, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 11: {
                return getQuadsCompact4(1, 1, 4, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 12: {
                return getQuadsCompactV(0, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 13: {
                return getQuadsCompact4(0, 3, 2, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 14: {
                return getQuadsCompactV(3, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 15: {
                return getQuadsCompact4(3, 0, 1, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 16: {
                return getQuadsCompact4(2, 4, 0, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 17: {
                return getQuadsCompact4(4, 2, 3, 0, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 18: {
                return getQuadsCompact4(4, 4, 3, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 19: {
                return getQuadsCompact4(4, 2, 4, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 20: {
                return getQuadsCompact4(1, 4, 4, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 21: {
                return getQuadsCompact4(4, 4, 1, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 22: {
                return getQuadsCompact4(4, 4, 1, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 23: {
                return getQuadsCompact4(4, 1, 4, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 24: {
                return getQuadsCompact(2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 25: {
                return getQuadsCompactH(2, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 26: {
                return getQuadsCompact(1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 27: {
                return getQuadsCompactH(1, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 28: {
                return getQuadsCompact4(2, 4, 2, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 29: {
                return getQuadsCompact4(3, 3, 1, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 30: {
                return getQuadsCompact4(2, 1, 2, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 31: {
                return getQuadsCompact4(3, 3, 4, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 32: {
                return getQuadsCompact4(1, 1, 1, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 33: {
                return getQuadsCompact4(1, 1, 4, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 34: {
                return getQuadsCompact4(4, 1, 1, 4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 35: {
                return getQuadsCompact4(1, 4, 4, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 36: {
                return getQuadsCompactV(2, 0, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 37: {
                return getQuadsCompact4(2, 1, 0, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 38: {
                return getQuadsCompactV(1, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 39: {
                return getQuadsCompact4(1, 2, 3, 0, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 40: {
                return getQuadsCompact4(4, 1, 3, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 41: {
                return getQuadsCompact4(1, 2, 4, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 42: {
                return getQuadsCompact4(1, 4, 3, 3, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 43: {
                return getQuadsCompact4(4, 2, 1, 2, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 44: {
                return getQuadsCompact4(1, 4, 1, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 45: {
                return getQuadsCompact4(4, 1, 1, 1, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIll, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            case 46: {
                return getQuadsCompact(4, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
            default: {
                return getQuadsCompact(0, lllllllllllllIllllIIIlIlIlllIIlI.tileIcons, lllllllllllllIllllIIIlIlIllIlIlI, lllllllllllllIllllIIIlIlIllIllll);
            }
        }
    }
    
    private static BakedQuad[] getQuadsCompact4(final int lllllllllllllIllllIIIlIlIIllIIll, final int lllllllllllllIllllIIIlIlIIllIIlI, final int lllllllllllllIllllIIIlIlIIllIIII, final int lllllllllllllIllllIIIlIlIIlllIII, final TextureAtlasSprite[] lllllllllllllIllllIIIlIlIIlIlllI, final int lllllllllllllIllllIIIlIlIIllIllI, final BakedQuad lllllllllllllIllllIIIlIlIIllIlIl, final RenderEnv lllllllllllllIllllIIIlIlIIlIlIlI) {
        if (lllllllllllllIllllIIIlIlIIllIIll == lllllllllllllIllllIIIlIlIIllIIlI) {
            return (lllllllllllllIllllIIIlIlIIllIIII == lllllllllllllIllllIIIlIlIIlllIII) ? getQuadsCompact(Dir.UP, lllllllllllllIllllIIIlIlIIllIIll, Dir.DOWN, lllllllllllllIllllIIIlIlIIllIIII, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI) : getQuadsCompact(Dir.UP, lllllllllllllIllllIIIlIlIIllIIll, Dir.DOWN_LEFT, lllllllllllllIllllIIIlIlIIllIIII, Dir.DOWN_RIGHT, lllllllllllllIllllIIIlIlIIlllIII, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI);
        }
        if (lllllllllllllIllllIIIlIlIIllIIII == lllllllllllllIllllIIIlIlIIlllIII) {
            return getQuadsCompact(Dir.UP_LEFT, lllllllllllllIllllIIIlIlIIllIIll, Dir.UP_RIGHT, lllllllllllllIllllIIIlIlIIllIIlI, Dir.DOWN, lllllllllllllIllllIIIlIlIIllIIII, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI);
        }
        if (lllllllllllllIllllIIIlIlIIllIIll == lllllllllllllIllllIIIlIlIIllIIII) {
            return (lllllllllllllIllllIIIlIlIIllIIlI == lllllllllllllIllllIIIlIlIIlllIII) ? getQuadsCompact(Dir.LEFT, lllllllllllllIllllIIIlIlIIllIIll, Dir.RIGHT, lllllllllllllIllllIIIlIlIIllIIlI, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI) : getQuadsCompact(Dir.LEFT, lllllllllllllIllllIIIlIlIIllIIll, Dir.UP_RIGHT, lllllllllllllIllllIIIlIlIIllIIlI, Dir.DOWN_RIGHT, lllllllllllllIllllIIIlIlIIlllIII, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI);
        }
        return (lllllllllllllIllllIIIlIlIIllIIlI == lllllllllllllIllllIIIlIlIIlllIII) ? getQuadsCompact(Dir.UP_LEFT, lllllllllllllIllllIIIlIlIIllIIll, Dir.DOWN_LEFT, lllllllllllllIllllIIIlIlIIllIIII, Dir.RIGHT, lllllllllllllIllllIIIlIlIIllIIlI, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI) : getQuadsCompact(Dir.UP_LEFT, lllllllllllllIllllIIIlIlIIllIIll, Dir.UP_RIGHT, lllllllllllllIllllIIIlIlIIllIIlI, Dir.DOWN_LEFT, lllllllllllllIllllIIIlIlIIllIIII, Dir.DOWN_RIGHT, lllllllllllllIllllIIIlIlIIlllIII, lllllllllllllIllllIIIlIlIIlIlllI, lllllllllllllIllllIIIlIlIIllIllI, lllllllllllllIllllIIIlIlIIllIlIl, lllllllllllllIllllIIIlIlIIlIlIlI);
    }
    
    private static BakedQuad[] getQuadsCompact(final Dir lllllllllllllIllllIIIlIIllllllIl, final int lllllllllllllIllllIIIlIIlllIlIll, final Dir lllllllllllllIllllIIIlIIlllllIII, final int lllllllllllllIllllIIIlIIlllIIlll, final TextureAtlasSprite[] lllllllllllllIllllIIIlIIllllIlII, final int lllllllllllllIllllIIIlIIlllIIIll, final BakedQuad lllllllllllllIllllIIIlIIllllIIII, final RenderEnv lllllllllllllIllllIIIlIIlllIIIIl) {
        final BakedQuad lllllllllllllIllllIIIlIIlllIlllI = getQuadCompact(lllllllllllllIllllIIIlIIllllIlII[lllllllllllllIllllIIIlIIlllIlIll], lllllllllllllIllllIIIlIIllllllIl, lllllllllllllIllllIIIlIIlllIIIll, lllllllllllllIllllIIIlIIllllIIII, lllllllllllllIllllIIIlIIlllIIIIl);
        final BakedQuad lllllllllllllIllllIIIlIIlllIllIl = getQuadCompact(lllllllllllllIllllIIIlIIllllIlII[lllllllllllllIllllIIIlIIlllIIlll], lllllllllllllIllllIIIlIIlllllIII, lllllllllllllIllllIIIlIIlllIIIll, lllllllllllllIllllIIIlIIllllIIII, lllllllllllllIllllIIIlIIlllIIIIl);
        return lllllllllllllIllllIIIlIIlllIIIIl.getArrayQuadsCtm(lllllllllllllIllllIIIlIIlllIlllI, lllllllllllllIllllIIIlIIlllIllIl);
    }
    
    private static BakedQuad makeSpriteQuadCompact(final BakedQuad lllllllllllllIllllIIIlIIIIIlIlII, final TextureAtlasSprite lllllllllllllIllllIIIlIIIIIlIIll, final int lllllllllllllIllllIIIlIIIIIIIlll, final int lllllllllllllIllllIIIlIIIIIlIIIl, final int lllllllllllllIllllIIIlIIIIIlIIII, final int lllllllllllllIllllIIIlIIIIIIIlII, final int lllllllllllllIllllIIIlIIIIIIlllI) {
        final int[] lllllllllllllIllllIIIlIIIIIIllIl = lllllllllllllIllllIIIlIIIIIlIlII.getVertexData().clone();
        final TextureAtlasSprite lllllllllllllIllllIIIlIIIIIIllII = lllllllllllllIllllIIIlIIIIIlIlII.getSprite();
        for (int lllllllllllllIllllIIIlIIIIIIlIll = 0; lllllllllllllIllllIIIlIIIIIIlIll < 4; ++lllllllllllllIllllIIIlIIIIIIlIll) {
            fixVertexCompact(lllllllllllllIllllIIIlIIIIIIllIl, lllllllllllllIllllIIIlIIIIIIlIll, lllllllllllllIllllIIIlIIIIIIllII, lllllllllllllIllllIIIlIIIIIlIIll, lllllllllllllIllllIIIlIIIIIIIlll, lllllllllllllIllllIIIlIIIIIlIIIl, lllllllllllllIllllIIIlIIIIIlIIII, lllllllllllllIllllIIIlIIIIIIIlII, lllllllllllllIllllIIIlIIIIIIlllI);
        }
        final BakedQuad lllllllllllllIllllIIIlIIIIIIlIlI = new BakedQuad(lllllllllllllIllllIIIlIIIIIIllIl, lllllllllllllIllllIIIlIIIIIlIlII.getTintIndex(), lllllllllllllIllllIIIlIIIIIlIlII.getFace(), lllllllllllllIllllIIIlIIIIIlIIll);
        return lllllllllllllIllllIIIlIIIIIIlIlI;
    }
    
    private static BakedQuad[] getQuadsCompact(final Dir lllllllllllllIllllIIIlIIllIIlIII, final int lllllllllllllIllllIIIlIIlIllIlIl, final Dir lllllllllllllIllllIIIlIIllIIIlII, final int lllllllllllllIllllIIIlIIllIIIIll, final Dir lllllllllllllIllllIIIlIIllIIIIlI, final int lllllllllllllIllllIIIlIIllIIIIIl, final TextureAtlasSprite[] lllllllllllllIllllIIIlIIlIlIlIlI, final int lllllllllllllIllllIIIlIIlIllllll, final BakedQuad lllllllllllllIllllIIIlIIlIllllIl, final RenderEnv lllllllllllllIllllIIIlIIlIllllII) {
        final BakedQuad lllllllllllllIllllIIIlIIlIlllIll = getQuadCompact(lllllllllllllIllllIIIlIIlIlIlIlI[lllllllllllllIllllIIIlIIlIllIlIl], lllllllllllllIllllIIIlIIllIIlIII, lllllllllllllIllllIIIlIIlIllllll, lllllllllllllIllllIIIlIIlIllllIl, lllllllllllllIllllIIIlIIlIllllII);
        final BakedQuad lllllllllllllIllllIIIlIIlIlllIlI = getQuadCompact(lllllllllllllIllllIIIlIIlIlIlIlI[lllllllllllllIllllIIIlIIllIIIIll], lllllllllllllIllllIIIlIIllIIIlII, lllllllllllllIllllIIIlIIlIllllll, lllllllllllllIllllIIIlIIlIllllIl, lllllllllllllIllllIIIlIIlIllllII);
        final BakedQuad lllllllllllllIllllIIIlIIlIlllIIl = getQuadCompact(lllllllllllllIllllIIIlIIlIlIlIlI[lllllllllllllIllllIIIlIIllIIIIIl], lllllllllllllIllllIIIlIIllIIIIlI, lllllllllllllIllllIIIlIIlIllllll, lllllllllllllIllllIIIlIIlIllllIl, lllllllllllllIllllIIIlIIlIllllII);
        return lllllllllllllIllllIIIlIIlIllllII.getArrayQuadsCtm(lllllllllllllIllllIIIlIIlIlllIll, lllllllllllllIllllIIIlIIlIlllIlI, lllllllllllllIllllIIIlIIlIlllIIl);
    }
    
    static {
        COMPACT_NONE = 0;
        COMPACT_V = 2;
        COMPACT_H = 3;
        COMPACT_ALL = 1;
        COMPACT_HV = 4;
    }
    
    private static BakedQuad[] getQuadsCompact(final int lllllllllllllIllllIIIlIlIIIlIllI, final TextureAtlasSprite[] lllllllllllllIllllIIIlIlIIIllllI, final BakedQuad lllllllllllllIllllIIIlIlIIIlllII, final RenderEnv lllllllllllllIllllIIIlIlIIIlIIIl) {
        final TextureAtlasSprite lllllllllllllIllllIIIlIlIIIllIII = lllllllllllllIllllIIIlIlIIIllllI[lllllllllllllIllllIIIlIlIIIlIllI];
        return ConnectedTextures.getQuads(lllllllllllllIllllIIIlIlIIIllIII, lllllllllllllIllllIIIlIlIIIlllII, lllllllllllllIllllIIIlIlIIIlIIIl);
    }
    
    private static void fixVertexCompact(final int[] lllllllllllllIllllIIIIllllIIIlll, final int lllllllllllllIllllIIIIlllllIlIII, final TextureAtlasSprite lllllllllllllIllllIIIIlllllIIlll, final TextureAtlasSprite lllllllllllllIllllIIIIllllIIIlII, final int lllllllllllllIllllIIIIlllllIIlIl, final int lllllllllllllIllllIIIIllllIIIIlI, final int lllllllllllllIllllIIIIllllIIIIIl, final int lllllllllllllIllllIIIIlllllIIIlI, final int lllllllllllllIllllIIIIlllllIIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_4       
        //     3: idiv           
        //     4: istore          lllllllllllllIllllIIIIlllllIIIII
        //     6: iload           lllllllllllllIllllIIIIlllllIIIII
        //     8: iload_1         /* lllllllllllllIllllIIIIllllIIIllI */
        //     9: imul           
        //    10: istore          lllllllllllllIllllIIIIllllIlllll
        //    12: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //    13: iload           lllllllllllllIllllIIIIllllIlllll
        //    15: iconst_4       
        //    16: iadd           
        //    17: iaload         
        //    18: invokestatic    java/lang/Float.intBitsToFloat:(I)F
        //    21: fstore          lllllllllllllIllllIIIIllllIllllI
        //    23: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //    24: iload           lllllllllllllIllllIIIIllllIlllll
        //    26: iconst_4       
        //    27: iadd           
        //    28: iconst_1       
        //    29: iadd           
        //    30: iaload         
        //    31: invokestatic    java/lang/Float.intBitsToFloat:(I)F
        //    34: fstore          lllllllllllllIllllIIIIllllIlllIl
        //    36: aload_2         /* lllllllllllllIllllIIIIllllIIIlIl */
        //    37: fload           lllllllllllllIllllIIIIllllIllllI
        //    39: invokevirtual   net/minecraft/client/renderer/texture/TextureAtlasSprite.getSpriteU16:(F)D
        //    42: dstore          lllllllllllllIllllIIIIllllIlllII
        //    44: aload_2         /* lllllllllllllIllllIIIIllllIIIlIl */
        //    45: fload           lllllllllllllIllllIIIIllllIlllIl
        //    47: invokevirtual   net/minecraft/client/renderer/texture/TextureAtlasSprite.getSpriteV16:(F)D
        //    50: dstore          lllllllllllllIllllIIIIllllIllIll
        //    52: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //    53: iload           lllllllllllllIllllIIIIllllIlllll
        //    55: iconst_0       
        //    56: iadd           
        //    57: iaload         
        //    58: invokestatic    java/lang/Float.intBitsToFloat:(I)F
        //    61: fstore          lllllllllllllIllllIIIIllllIllIlI
        //    63: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //    64: iload           lllllllllllllIllllIIIIllllIlllll
        //    66: iconst_1       
        //    67: iadd           
        //    68: iaload         
        //    69: invokestatic    java/lang/Float.intBitsToFloat:(I)F
        //    72: fstore          lllllllllllllIllllIIIIllllIllIIl
        //    74: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //    75: iload           lllllllllllllIllllIIIIllllIlllll
        //    77: iconst_2       
        //    78: iadd           
        //    79: iaload         
        //    80: invokestatic    java/lang/Float.intBitsToFloat:(I)F
        //    83: fstore          lllllllllllllIllllIIIIllllIllIII
        //    85: iload           lllllllllllllIllllIIIIllllIIIIll
        //    87: tableswitch {
        //                0: 124
        //                1: 137
        //                2: 148
        //                3: 163
        //                4: 176
        //                5: 189
        //          default: 204
        //        }
        //   124: fload           lllllllllllllIllllIIIIllllIllIlI
        //   126: fstore          lllllllllllllIllllIIIIllllIlIlll
        //   128: fconst_1       
        //   129: fload           lllllllllllllIllllIIIIllllIllIII
        //   131: fsub           
        //   132: fstore          lllllllllllllIllllIIIIllllIlIIII
        //   134: goto            205
        //   137: fload           lllllllllllllIllllIIIIllllIllIlI
        //   139: fstore          lllllllllllllIllllIIIIllllIlIllI
        //   141: fload           lllllllllllllIllllIIIIllllIllIII
        //   143: fstore          lllllllllllllIllllIIIIllllIIllll
        //   145: goto            205
        //   148: fconst_1       
        //   149: fload           lllllllllllllIllllIIIIllllIllIlI
        //   151: fsub           
        //   152: fstore          lllllllllllllIllllIIIIllllIlIlIl
        //   154: fconst_1       
        //   155: fload           lllllllllllllIllllIIIIllllIllIIl
        //   157: fsub           
        //   158: fstore          lllllllllllllIllllIIIIllllIIlllI
        //   160: goto            205
        //   163: fload           lllllllllllllIllllIIIIllllIllIlI
        //   165: fstore          lllllllllllllIllllIIIIllllIlIlII
        //   167: fconst_1       
        //   168: fload           lllllllllllllIllllIIIIllllIllIIl
        //   170: fsub           
        //   171: fstore          lllllllllllllIllllIIIIllllIIllIl
        //   173: goto            205
        //   176: fload           lllllllllllllIllllIIIIllllIllIII
        //   178: fstore          lllllllllllllIllllIIIIllllIlIIll
        //   180: fconst_1       
        //   181: fload           lllllllllllllIllllIIIIllllIllIIl
        //   183: fsub           
        //   184: fstore          lllllllllllllIllllIIIIllllIIllII
        //   186: goto            205
        //   189: fconst_1       
        //   190: fload           lllllllllllllIllllIIIIllllIllIII
        //   192: fsub           
        //   193: fstore          lllllllllllllIllllIIIIllllIlIIlI
        //   195: fconst_1       
        //   196: fload           lllllllllllllIllllIIIIllllIllIIl
        //   198: fsub           
        //   199: fstore          lllllllllllllIllllIIIIllllIIlIll
        //   201: goto            205
        //   204: return         
        //   205: ldc_w           15.968
        //   208: fstore          lllllllllllllIllllIIIIllllIIlIIl
        //   210: ldc_w           15.968
        //   213: fstore          lllllllllllllIllllIIIIllllIIlIII
        //   215: dload           lllllllllllllIllllIIIIllllIlllII
        //   217: iload           lllllllllllllIllllIIIIlllllIIlII
        //   219: i2d            
        //   220: dcmpg          
        //   221: ifge            246
        //   224: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   226: f2d            
        //   227: iload           lllllllllllllIllllIIIIlllllIIlII
        //   229: i2d            
        //   230: dload           lllllllllllllIllllIIIIllllIlllII
        //   232: dsub           
        //   233: fload           lllllllllllllIllllIIIIllllIIlIIl
        //   235: f2d            
        //   236: ddiv           
        //   237: dadd           
        //   238: d2f            
        //   239: fstore          lllllllllllllIllllIIIIllllIlIIIl
        //   241: iload           lllllllllllllIllllIIIIlllllIIlII
        //   243: i2d            
        //   244: dstore          lllllllllllllIllllIIIIllllIlllII
        //   246: dload           lllllllllllllIllllIIIIllllIlllII
        //   248: iload           lllllllllllllIllllIIIIllllIIIIII
        //   250: i2d            
        //   251: dcmpl          
        //   252: ifle            277
        //   255: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   257: f2d            
        //   258: dload           lllllllllllllIllllIIIIllllIlllII
        //   260: iload           lllllllllllllIllllIIIIllllIIIIII
        //   262: i2d            
        //   263: dsub           
        //   264: fload           lllllllllllllIllllIIIIllllIIlIIl
        //   266: f2d            
        //   267: ddiv           
        //   268: dsub           
        //   269: d2f            
        //   270: fstore          lllllllllllllIllllIIIIllllIlIIIl
        //   272: iload           lllllllllllllIllllIIIIllllIIIIII
        //   274: i2d            
        //   275: dstore          lllllllllllllIllllIIIIllllIlllII
        //   277: dload           lllllllllllllIllllIIIIllllIllIll
        //   279: iload           lllllllllllllIllllIIIIlllllIIIll
        //   281: i2d            
        //   282: dcmpg          
        //   283: ifge            308
        //   286: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   288: f2d            
        //   289: iload           lllllllllllllIllllIIIIlllllIIIll
        //   291: i2d            
        //   292: dload           lllllllllllllIllllIIIIllllIllIll
        //   294: dsub           
        //   295: fload           lllllllllllllIllllIIIIllllIIlIII
        //   297: f2d            
        //   298: ddiv           
        //   299: dadd           
        //   300: d2f            
        //   301: fstore          lllllllllllllIllllIIIIllllIIlIlI
        //   303: iload           lllllllllllllIllllIIIIlllllIIIll
        //   305: i2d            
        //   306: dstore          lllllllllllllIllllIIIIllllIllIll
        //   308: dload           lllllllllllllIllllIIIIllllIllIll
        //   310: iload           lllllllllllllIllllIIIIlllIllllll
        //   312: i2d            
        //   313: dcmpl          
        //   314: ifle            339
        //   317: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   319: f2d            
        //   320: dload           lllllllllllllIllllIIIIllllIllIll
        //   322: iload           lllllllllllllIllllIIIIlllIllllll
        //   324: i2d            
        //   325: dsub           
        //   326: fload           lllllllllllllIllllIIIIllllIIlIII
        //   328: f2d            
        //   329: ddiv           
        //   330: dsub           
        //   331: d2f            
        //   332: fstore          lllllllllllllIllllIIIIllllIIlIlI
        //   334: iload           lllllllllllllIllllIIIIlllIllllll
        //   336: i2d            
        //   337: dstore          lllllllllllllIllllIIIIllllIllIll
        //   339: iload           lllllllllllllIllllIIIIllllIIIIll
        //   341: tableswitch {
        //                0: 380
        //                1: 393
        //                2: 404
        //                3: 419
        //                4: 432
        //                5: 445
        //          default: 460
        //        }
        //   380: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   382: fstore          lllllllllllllIllllIIIIllllIllIlI
        //   384: fconst_1       
        //   385: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   387: fsub           
        //   388: fstore          lllllllllllllIllllIIIIllllIllIII
        //   390: goto            461
        //   393: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   395: fstore          lllllllllllllIllllIIIIllllIllIlI
        //   397: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   399: fstore          lllllllllllllIllllIIIIllllIllIII
        //   401: goto            461
        //   404: fconst_1       
        //   405: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   407: fsub           
        //   408: fstore          lllllllllllllIllllIIIIllllIllIlI
        //   410: fconst_1       
        //   411: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   413: fsub           
        //   414: fstore          lllllllllllllIllllIIIIllllIllIIl
        //   416: goto            461
        //   419: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   421: fstore          lllllllllllllIllllIIIIllllIllIlI
        //   423: fconst_1       
        //   424: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   426: fsub           
        //   427: fstore          lllllllllllllIllllIIIIllllIllIIl
        //   429: goto            461
        //   432: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   434: fstore          lllllllllllllIllllIIIIllllIllIII
        //   436: fconst_1       
        //   437: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   439: fsub           
        //   440: fstore          lllllllllllllIllllIIIIllllIllIIl
        //   442: goto            461
        //   445: fconst_1       
        //   446: fload           lllllllllllllIllllIIIIllllIlIIIl
        //   448: fsub           
        //   449: fstore          lllllllllllllIllllIIIIllllIllIII
        //   451: fconst_1       
        //   452: fload           lllllllllllllIllllIIIIllllIIlIlI
        //   454: fsub           
        //   455: fstore          lllllllllllllIllllIIIIllllIllIIl
        //   457: goto            461
        //   460: return         
        //   461: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //   462: iload           lllllllllllllIllllIIIIllllIlllll
        //   464: iconst_4       
        //   465: iadd           
        //   466: aload_3         /* lllllllllllllIllllIIIIlllllIIllI */
        //   467: dload           lllllllllllllIllllIIIIllllIlllII
        //   469: invokevirtual   net/minecraft/client/renderer/texture/TextureAtlasSprite.getInterpolatedU:(D)F
        //   472: invokestatic    java/lang/Float.floatToRawIntBits:(F)I
        //   475: iastore        
        //   476: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //   477: iload           lllllllllllllIllllIIIIllllIlllll
        //   479: iconst_4       
        //   480: iadd           
        //   481: iconst_1       
        //   482: iadd           
        //   483: aload_3         /* lllllllllllllIllllIIIIlllllIIllI */
        //   484: dload           lllllllllllllIllllIIIIllllIllIll
        //   486: invokevirtual   net/minecraft/client/renderer/texture/TextureAtlasSprite.getInterpolatedV:(D)F
        //   489: invokestatic    java/lang/Float.floatToRawIntBits:(F)I
        //   492: iastore        
        //   493: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //   494: iload           lllllllllllllIllllIIIIllllIlllll
        //   496: iconst_0       
        //   497: iadd           
        //   498: fload           lllllllllllllIllllIIIIllllIllIlI
        //   500: invokestatic    java/lang/Float.floatToRawIntBits:(F)I
        //   503: iastore        
        //   504: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //   505: iload           lllllllllllllIllllIIIIllllIlllll
        //   507: iconst_1       
        //   508: iadd           
        //   509: fload           lllllllllllllIllllIIIIllllIllIIl
        //   511: invokestatic    java/lang/Float.floatToRawIntBits:(F)I
        //   514: iastore        
        //   515: aload_0         /* lllllllllllllIllllIIIIlllllIlIIl */
        //   516: iload           lllllllllllllIllllIIIIllllIlllll
        //   518: iconst_2       
        //   519: iadd           
        //   520: fload           lllllllllllllIllllIIIIllllIllIII
        //   522: invokestatic    java/lang/Float.floatToRawIntBits:(F)I
        //   525: iastore        
        //   526: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException
        //     at java.util.Collections$1.remove(Unknown Source)
        //     at java.util.AbstractCollection.removeAll(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2968)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static BakedQuad[] getQuadsCompactV(final int lllllllllllllIllllIIIlIlIlIIlIIl, final int lllllllllllllIllllIIIlIlIlIIlIII, final TextureAtlasSprite[] lllllllllllllIllllIIIlIlIlIIllIl, final int lllllllllllllIllllIIIlIlIlIIIllI, final BakedQuad lllllllllllllIllllIIIlIlIlIIlIll, final RenderEnv lllllllllllllIllllIIIlIlIlIIlIlI) {
        return getQuadsCompact(Dir.UP, lllllllllllllIllllIIIlIlIlIIlIIl, Dir.DOWN, lllllllllllllIllllIIIlIlIlIIlIII, lllllllllllllIllllIIIlIlIlIIllIl, lllllllllllllIllllIIIlIlIlIIIllI, lllllllllllllIllllIIIlIlIlIIlIll, lllllllllllllIllllIIIlIlIlIIlIlI);
    }
    
    private static BakedQuad[] getQuadsCompactH(final int lllllllllllllIllllIIIlIlIlIllIll, final int lllllllllllllIllllIIIlIlIllIIIII, final TextureAtlasSprite[] lllllllllllllIllllIIIlIlIlIlllll, final int lllllllllllllIllllIIIlIlIlIllllI, final BakedQuad lllllllllllllIllllIIIlIlIlIlIlll, final RenderEnv lllllllllllllIllllIIIlIlIlIlllII) {
        return getQuadsCompact(Dir.LEFT, lllllllllllllIllllIIIlIlIlIllIll, Dir.RIGHT, lllllllllllllIllllIIIlIlIllIIIII, lllllllllllllIllllIIIlIlIlIlllll, lllllllllllllIllllIIIlIlIlIllllI, lllllllllllllIllllIIIlIlIlIlIlll, lllllllllllllIllllIIIlIlIlIlllII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$optifine$ConnectedTexturesCompact$Dir() {
        final int[] $switch_TABLE$optifine$ConnectedTexturesCompact$Dir = ConnectedTexturesCompact.$SWITCH_TABLE$optifine$ConnectedTexturesCompact$Dir;
        if ($switch_TABLE$optifine$ConnectedTexturesCompact$Dir != null) {
            return $switch_TABLE$optifine$ConnectedTexturesCompact$Dir;
        }
        final boolean lllllllllllllIllllIIIIlllIllIIII = (Object)new int[Dir.values().length];
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.DOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.DOWN_LEFT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.DOWN_RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.LEFT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.RIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.UP.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.UP_LEFT.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIllllIIIIlllIllIIII[Dir.UP_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        return ConnectedTexturesCompact.$SWITCH_TABLE$optifine$ConnectedTexturesCompact$Dir = (int[])(Object)lllllllllllllIllllIIIIlllIllIIII;
    }
    
    private enum Dir
    {
        UP_LEFT("UP_LEFT", 7), 
        LEFT("LEFT", 6), 
        DOWN("DOWN", 4), 
        DOWN_LEFT("DOWN_LEFT", 5), 
        UP_RIGHT("UP_RIGHT", 1), 
        UP("UP", 0);
        
        public static final /* synthetic */ Dir[] VALUES;
        
        RIGHT("RIGHT", 2), 
        DOWN_RIGHT("DOWN_RIGHT", 3);
        
        static {
            VALUES = values();
        }
        
        private Dir(final String lllllllllllllllllIlIlIlIIllllllI, final int lllllllllllllllllIlIlIlIIlllllIl) {
        }
    }
}
