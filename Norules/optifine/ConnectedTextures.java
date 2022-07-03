package optifine;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.world.biome.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;

public class ConnectedTextures
{
    private static final /* synthetic */ BlockDir[] SIDES_Z_NEG_NORTH;
    public static final /* synthetic */ IBlockState AIR_DEFAULT_STATE;
    private static final /* synthetic */ BlockDir[] EDGES_X_POS_EAST_X_AXIS;
    private static /* synthetic */ ConnectedProperties[][] tileProperties;
    private static final /* synthetic */ BlockDir[] SIDES_X_POS_EAST;
    private static final /* synthetic */ BlockDir[] EDGES_Z_NEG_NORTH_Z_AXIS;
    private static final /* synthetic */ BlockDir[] SIDES_Z_NEG_NORTH_Z_AXIS;
    private static /* synthetic */ boolean multipass;
    private static /* synthetic */ Map[] spriteQuadMaps;
    private static final /* synthetic */ BlockDir[] EDGES_X_NEG_WEST;
    private static /* synthetic */ Map[][] spriteQuadCompactMaps;
    private static final /* synthetic */ BlockDir[] SIDES_Y_POS_UP;
    private static final /* synthetic */ BlockDir[] SIDES_X_POS_EAST_X_AXIS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static /* synthetic */ TextureAtlasSprite emptySprite;
    private static final /* synthetic */ BlockDir[] SIDES_Y_NEG_DOWN;
    private static final /* synthetic */ BlockDir[] SIDES_Z_POS_SOUTH;
    private static final /* synthetic */ BlockDir[] EDGES_Z_POS_SOUTH;
    private static final /* synthetic */ BlockDir[] SIDES_X_NEG_WEST;
    private static final /* synthetic */ BlockDir[] EDGES_Y_NEG_DOWN;
    private static final /* synthetic */ BlockDir[] EDGES_Y_POS_UP;
    private static /* synthetic */ Map[] spriteQuadFullMaps;
    private static final /* synthetic */ BlockDir[] EDGES_Z_NEG_NORTH;
    private static /* synthetic */ ConnectedProperties[][] blockProperties;
    private static final /* synthetic */ BlockDir[] EDGES_X_POS_EAST;
    
    private static ConnectedProperties[][] propertyListToArray(final List llllllllllllllIIIIIlllIIllIlllII) {
        final ConnectedProperties[][] llllllllllllllIIIIIlllIIlllIIIII = new ConnectedProperties[llllllllllllllIIIIIlllIIllIlllII.size()][];
        for (int llllllllllllllIIIIIlllIIllIlllll = 0; llllllllllllllIIIIIlllIIllIlllll < llllllllllllllIIIIIlllIIllIlllII.size(); ++llllllllllllllIIIIIlllIIllIlllll) {
            final List llllllllllllllIIIIIlllIIllIllllI = llllllllllllllIIIIIlllIIllIlllII.get(llllllllllllllIIIIIlllIIllIlllll);
            if (llllllllllllllIIIIIlllIIllIllllI != null) {
                final ConnectedProperties[] llllllllllllllIIIIIlllIIllIlllIl = llllllllllllllIIIIIlllIIllIllllI.toArray(new ConnectedProperties[llllllllllllllIIIIIlllIIllIllllI.size()]);
                llllllllllllllIIIIIlllIIlllIIIII[llllllllllllllIIIIIlllIIllIlllll] = llllllllllllllIIIIIlllIIllIlllIl;
            }
        }
        return llllllllllllllIIIIIlllIIlllIIIII;
    }
    
    private static TextureAtlasSprite getConnectedTextureHorizontalVertical(final ConnectedProperties llllllllllllllIIIIIlllIllIIIIIll, final IBlockAccess llllllllllllllIIIIIlllIllIIIIIlI, final IBlockState llllllllllllllIIIIIlllIllIIIIIIl, final BlockPos llllllllllllllIIIIIlllIllIIIlIll, final int llllllllllllllIIIIIlllIllIIIlIlI, final int llllllllllllllIIIIIlllIllIIIlIIl, final TextureAtlasSprite llllllllllllllIIIIIlllIlIlllllIl, final int llllllllllllllIIIIIlllIllIIIIlll) {
        final TextureAtlasSprite[] llllllllllllllIIIIIlllIllIIIIllI = llllllllllllllIIIIIlllIllIIIIIll.tileIcons;
        final TextureAtlasSprite llllllllllllllIIIIIlllIllIIIIlIl = getConnectedTextureHorizontal(llllllllllllllIIIIIlllIllIIIIIll, llllllllllllllIIIIIlllIllIIIIIlI, llllllllllllllIIIIIlllIllIIIIIIl, llllllllllllllIIIIIlllIllIIIlIll, llllllllllllllIIIIIlllIllIIIlIlI, llllllllllllllIIIIIlllIllIIIlIIl, llllllllllllllIIIIIlllIlIlllllIl, llllllllllllllIIIIIlllIllIIIIlll);
        if (llllllllllllllIIIIIlllIllIIIIlIl != null && llllllllllllllIIIIIlllIllIIIIlIl != llllllllllllllIIIIIlllIlIlllllIl && llllllllllllllIIIIIlllIllIIIIlIl != llllllllllllllIIIIIlllIllIIIIllI[3]) {
            return llllllllllllllIIIIIlllIllIIIIlIl;
        }
        final TextureAtlasSprite llllllllllllllIIIIIlllIllIIIIlII = getConnectedTextureVertical(llllllllllllllIIIIIlllIllIIIIIll, llllllllllllllIIIIIlllIllIIIIIlI, llllllllllllllIIIIIlllIllIIIIIIl, llllllllllllllIIIIIlllIllIIIlIll, llllllllllllllIIIIIlllIllIIIlIlI, llllllllllllllIIIIIlllIllIIIlIIl, llllllllllllllIIIIIlllIlIlllllIl, llllllllllllllIIIIIlllIllIIIIlll);
        if (llllllllllllllIIIIIlllIllIIIIlII == llllllllllllllIIIIIlllIllIIIIllI[0]) {
            return llllllllllllllIIIIIlllIllIIIIllI[4];
        }
        if (llllllllllllllIIIIIlllIllIIIIlII == llllllllllllllIIIIIlllIllIIIIllI[1]) {
            return llllllllllllllIIIIIlllIllIIIIllI[5];
        }
        return (llllllllllllllIIIIIlllIllIIIIlII == llllllllllllllIIIIIlllIllIIIIllI[2]) ? llllllllllllllIIIIIlllIllIIIIllI[6] : llllllllllllllIIIIIlllIllIIIIlII;
    }
    
    private static BakedQuad[] getConnectedTextureOverlay(final ConnectedProperties llllllllllllllIIIIIllllIlllllllI, final IBlockAccess llllllllllllllIIIIIlllllIIlIllll, final IBlockState llllllllllllllIIIIIlllllIIlIllIl, final BlockPos llllllllllllllIIIIIllllIlllllIlI, final int llllllllllllllIIIIIlllllIIlIlIIl, final int llllllllllllllIIIIIllllIlllllIII, final BakedQuad llllllllllllllIIIIIlllllIIlIIlII, final int llllllllllllllIIIIIlllllIIlIIIll, final RenderEnv llllllllllllllIIIIIllllIllllIIlI) {
        if (!llllllllllllllIIIIIlllllIIlIIlII.isFullQuad()) {
            return null;
        }
        final TextureAtlasSprite llllllllllllllIIIIIlllllIIlIIIIl = llllllllllllllIIIIIlllllIIlIIlII.getSprite();
        final BlockDir[] llllllllllllllIIIIIlllllIIlIIIII = getSideDirections(llllllllllllllIIIIIllllIlllllIII, llllllllllllllIIIIIlllllIIlIlIIl);
        final boolean[] llllllllllllllIIIIIlllllIIIlllll = llllllllllllllIIIIIllllIllllIIlI.getBorderFlags();
        for (int llllllllllllllIIIIIlllllIIIllllI = 0; llllllllllllllIIIIIlllllIIIllllI < 4; ++llllllllllllllIIIIIlllllIIIllllI) {
            llllllllllllllIIIIIlllllIIIlllll[llllllllllllllIIIIIlllllIIIllllI] = isNeighbourOverlay(llllllllllllllIIIIIllllIlllllllI, llllllllllllllIIIIIlllllIIlIllll, llllllllllllllIIIIIlllllIIlIllIl, llllllllllllllIIIIIlllllIIlIIIII[llllllllllllllIIIIIlllllIIIllllI].offset(llllllllllllllIIIIIllllIlllllIlI), llllllllllllllIIIIIllllIlllllIII, llllllllllllllIIIIIlllllIIlIIIIl, llllllllllllllIIIIIlllllIIlIIIll);
        }
        final ListQuadsOverlay llllllllllllllIIIIIlllllIIIlllIl = llllllllllllllIIIIIllllIllllIIlI.getListQuadsOverlay(llllllllllllllIIIIIllllIlllllllI.layer);
        try {
            if (!llllllllllllllIIIIIlllllIIIlllll[0] || !llllllllllllllIIIIIlllllIIIlllll[1] || !llllllllllllllIIIIIlllllIIIlllll[2] || !llllllllllllllIIIIIlllllIIIlllll[3]) {
                if (llllllllllllllIIIIIlllllIIIlllll[0] && llllllllllllllIIIIIlllllIIIlllll[1] && llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[5], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    final Object llllllllllllllIIIIIlllllIIIlllII = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIlllII;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[0] && llllllllllllllIIIIIlllllIIIlllll[2] && llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[6], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    final Object llllllllllllllIIIIIlllllIIIllIll = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIllIll;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[1] && llllllllllllllIIIIIlllllIIIlllll[2] && llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[12], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    final Object llllllllllllllIIIIIlllllIIIllIIl = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIllIIl;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[0] && llllllllllllllIIIIIlllllIIIlllll[1] && llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[13], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    final Object llllllllllllllIIIIIlllllIIIlIlll = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIlIlll;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                final BlockDir[] llllllllllllllIIIIIlllllIIIlIIlI = getEdgeDirections(llllllllllllllIIIIIllllIlllllIII, llllllllllllllIIIIIlllllIIlIlIIl);
                final boolean[] llllllllllllllIIIIIlllllIIIlIIII = llllllllllllllIIIIIllllIllllIIlI.getBorderFlags2();
                for (int llllllllllllllIIIIIlllllIIIIlllI = 0; llllllllllllllIIIIIlllllIIIIlllI < 4; ++llllllllllllllIIIIIlllllIIIIlllI) {
                    llllllllllllllIIIIIlllllIIIlIIII[llllllllllllllIIIIIlllllIIIIlllI] = isNeighbourOverlay(llllllllllllllIIIIIllllIlllllllI, llllllllllllllIIIIIlllllIIlIllll, llllllllllllllIIIIIlllllIIlIllIl, llllllllllllllIIIIIlllllIIIlIIlI[llllllllllllllIIIIIlllllIIIIlllI].offset(llllllllllllllIIIIIllllIlllllIlI), llllllllllllllIIIIIllllIlllllIII, llllllllllllllIIIIIlllllIIlIIIIl, llllllllllllllIIIIIlllllIIlIIIll);
                }
                if (llllllllllllllIIIIIlllllIIIlllll[1] && llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[3], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    if (llllllllllllllIIIIIlllllIIIlIIII[3]) {
                        llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[16], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    }
                    final Object llllllllllllllIIIIIlllllIIIIllII = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIIllII;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[0] && llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[4], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    if (llllllllllllllIIIIIlllllIIIlIIII[2]) {
                        llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[14], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    }
                    final Object llllllllllllllIIIIIlllllIIIIlIlI = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIIlIlI;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[1] && llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[10], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    if (llllllllllllllIIIIIlllllIIIlIIII[1]) {
                        llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[2], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    }
                    final Object llllllllllllllIIIIIlllllIIIIlIII = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIIlIII;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                if (llllllllllllllIIIIIlllllIIIlllll[0] && llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[11], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    if (llllllllllllllIIIIIlllllIIIlIIII[0]) {
                        llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[0], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                    }
                    final Object llllllllllllllIIIIIlllllIIIIIllI = null;
                    final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIIIllI;
                    return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
                }
                final boolean[] llllllllllllllIIIIIlllllIIIIIlII = llllllllllllllIIIIIllllIllllIIlI.getBorderFlags3();
                for (int llllllllllllllIIIIIlllllIIIIIIlI = 0; llllllllllllllIIIIIlllllIIIIIIlI < 4; ++llllllllllllllIIIIIlllllIIIIIIlI) {
                    llllllllllllllIIIIIlllllIIIIIlII[llllllllllllllIIIIIlllllIIIIIIlI] = isNeighbourMatching(llllllllllllllIIIIIllllIlllllllI, llllllllllllllIIIIIlllllIIlIllll, llllllllllllllIIIIIlllllIIlIllIl, llllllllllllllIIIIIlllllIIlIIIII[llllllllllllllIIIIIlllllIIIIIIlI].offset(llllllllllllllIIIIIllllIlllllIlI), llllllllllllllIIIIIllllIlllllIII, llllllllllllllIIIIIlllllIIlIIIIl, llllllllllllllIIIIIlllllIIlIIIll);
                }
                if (llllllllllllllIIIIIlllllIIIlllll[0]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[9], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlllll[1]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[7], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[1], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[15], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlIIII[0] && (llllllllllllllIIIIIlllllIIIIIlII[1] || llllllllllllllIIIIIlllllIIIIIlII[2]) && !llllllllllllllIIIIIlllllIIIlllll[1] && !llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[0], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlIIII[1] && (llllllllllllllIIIIIlllllIIIIIlII[0] || llllllllllllllIIIIIlllllIIIIIlII[2]) && !llllllllllllllIIIIIlllllIIIlllll[0] && !llllllllllllllIIIIIlllllIIIlllll[2]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[2], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlIIII[2] && (llllllllllllllIIIIIlllllIIIIIlII[1] || llllllllllllllIIIIIlllllIIIIIlII[3]) && !llllllllllllllIIIIIlllllIIIlllll[1] && !llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[14], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                if (llllllllllllllIIIIIlllllIIIlIIII[3] && (llllllllllllllIIIIIlllllIIIIIlII[0] || llllllllllllllIIIIIlllllIIIIIlII[3]) && !llllllllllllllIIIIIlllllIIIlllll[0] && !llllllllllllllIIIIIlllllIIIlllll[3]) {
                    llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[16], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                }
                final Object llllllllllllllIIIIIlllllIIIIIIII = null;
                final String llllllllllllllIIIIIllllIlllIIIIl = (Object)llllllllllllllIIIIIlllllIIIIIIII;
                return (BakedQuad[])(Object)llllllllllllllIIIIIllllIlllIIIIl;
            }
            else {
                llllllllllllllIIIIIlllllIIIlllIl.addQuad(getQuadFull(llllllllllllllIIIIIllllIlllllllI.tileIcons[8], llllllllllllllIIIIIlllllIIlIIlII, llllllllllllllIIIIIllllIlllllllI.tintIndex), llllllllllllllIIIIIllllIlllllllI.tintBlockState);
                final Object llllllllllllllIIIIIlllllIIIlIllI = null;
            }
        }
        finally {
            if (llllllllllllllIIIIIlllllIIIlllIl.size() > 0) {
                llllllllllllllIIIIIllllIllllIIlI.setOverlaysRendered(true);
            }
        }
        if (llllllllllllllIIIIIlllllIIIlllIl.size() > 0) {
            llllllllllllllIIIIIllllIllllIIlI.setOverlaysRendered(true);
        }
        final Object llllllllllllllIIIIIlllllIIIlIlII;
        return (BakedQuad[])llllllllllllllIIIIIlllllIIIlIlII;
    }
    
    private static boolean isNeighbourOverlay(final ConnectedProperties llllllllllllllIIIIIllllIIllIlIll, final IBlockAccess llllllllllllllIIIIIllllIIllIlIlI, final IBlockState llllllllllllllIIIIIllllIIlllIlII, final BlockPos llllllllllllllIIIIIllllIIlllIIll, final int llllllllllllllIIIIIllllIIllIIlll, final TextureAtlasSprite llllllllllllllIIIIIllllIIllIIllI, final int llllllllllllllIIIIIllllIIlllIIII) {
        final IBlockState llllllllllllllIIIIIllllIIllIllll = llllllllllllllIIIIIllllIIllIlIlI.getBlockState(llllllllllllllIIIIIllllIIlllIIll);
        if (!isFullCubeModel(llllllllllllllIIIIIllllIIllIllll)) {
            return false;
        }
        if (llllllllllllllIIIIIllllIIllIlIll.connectBlocks != null) {
            final BlockStateBase llllllllllllllIIIIIllllIIllIlllI = (BlockStateBase)llllllllllllllIIIIIllllIIllIllll;
            if (!Matches.block(llllllllllllllIIIIIllllIIllIlllI.getBlockId(), llllllllllllllIIIIIllllIIllIlllI.getMetadata(), llllllllllllllIIIIIllllIIllIlIll.connectBlocks)) {
                return false;
            }
        }
        if (llllllllllllllIIIIIllllIIllIlIll.connectTileIcons != null) {
            final TextureAtlasSprite llllllllllllllIIIIIllllIIllIllIl = getNeighbourIcon(llllllllllllllIIIIIllllIIllIlIlI, llllllllllllllIIIIIllllIIlllIlII, llllllllllllllIIIIIllllIIlllIIll, llllllllllllllIIIIIllllIIllIllll, llllllllllllllIIIIIllllIIllIIlll);
            if (!Config.isSameOne(llllllllllllllIIIIIllllIIllIllIl, llllllllllllllIIIIIllllIIllIlIll.connectTileIcons)) {
                return false;
            }
        }
        final IBlockState llllllllllllllIIIIIllllIIllIllII = llllllllllllllIIIIIllllIIllIlIlI.getBlockState(llllllllllllllIIIIIllllIIlllIIll.offset(getFacing(llllllllllllllIIIIIllllIIllIIlll)));
        return !llllllllllllllIIIIIllllIIllIllII.isOpaqueCube() && (llllllllllllllIIIIIllllIIllIIlll != 1 || llllllllllllllIIIIIllllIIllIllII.getBlock() != Blocks.SNOW_LAYER) && !isNeighbour(llllllllllllllIIIIIllllIIllIlIll, llllllllllllllIIIIIllllIIllIlIlI, llllllllllllllIIIIIllllIIlllIlII, llllllllllllllIIIIIllllIIlllIIll, llllllllllllllIIIIIllllIIllIllll, llllllllllllllIIIIIllllIIllIIlll, llllllllllllllIIIIIllllIIllIIllI, llllllllllllllIIIIIllllIIlllIIII);
    }
    
    private static boolean isFullCubeModel(final IBlockState llllllllllllllIIIIIllllIIlIllllI) {
        if (llllllllllllllIIIIIllllIIlIllllI.isFullCube()) {
            return true;
        }
        final Block llllllllllllllIIIIIllllIIlIlllll = llllllllllllllIIIIIllllIIlIllllI.getBlock();
        return llllllllllllllIIIIIllllIIlIlllll instanceof BlockGlass || llllllllllllllIIIIIllllIIlIlllll instanceof BlockStainedGlass;
    }
    
    private static void addToTileList(final ConnectedProperties llllllllllllllIIIIIlllIIllIlIIlI, final List llllllllllllllIIIIIlllIIllIlIIIl) {
        if (llllllllllllllIIIIIlllIIllIlIIlI.matchTileIcons != null) {
            for (int llllllllllllllIIIIIlllIIllIlIIII = 0; llllllllllllllIIIIIlllIIllIlIIII < llllllllllllllIIIIIlllIIllIlIIlI.matchTileIcons.length; ++llllllllllllllIIIIIlllIIllIlIIII) {
                final TextureAtlasSprite llllllllllllllIIIIIlllIIllIIllll = llllllllllllllIIIIIlllIIllIlIIlI.matchTileIcons[llllllllllllllIIIIIlllIIllIlIIII];
                if (!(llllllllllllllIIIIIlllIIllIIllll instanceof TextureAtlasSprite)) {
                    Config.warn(String.valueOf(new StringBuilder("TextureAtlasSprite is not TextureAtlasSprite: ").append(llllllllllllllIIIIIlllIIllIIllll).append(", name: ").append(llllllllllllllIIIIIlllIIllIIllll.getIconName())));
                }
                else {
                    final int llllllllllllllIIIIIlllIIllIIlllI = llllllllllllllIIIIIlllIIllIIllll.getIndexInMap();
                    if (llllllllllllllIIIIIlllIIllIIlllI < 0) {
                        Config.warn(String.valueOf(new StringBuilder("Invalid tile ID: ").append(llllllllllllllIIIIIlllIIllIIlllI).append(", icon: ").append(llllllllllllllIIIIIlllIIllIIllll.getIconName())));
                    }
                    else {
                        addToList(llllllllllllllIIIIIlllIIllIlIIlI, llllllllllllllIIIIIlllIIllIlIIIl, llllllllllllllIIIIIlllIIllIIlllI);
                    }
                }
            }
        }
    }
    
    private static int getConnectedTextureCtmIndex(final ConnectedProperties llllllllllllllIIIIIllllIlIIlIllI, final IBlockAccess llllllllllllllIIIIIllllIlIIlIlIl, final IBlockState llllllllllllllIIIIIllllIlIIlllll, final BlockPos llllllllllllllIIIIIllllIlIIlIIll, final int llllllllllllllIIIIIllllIlIIlIIlI, final int llllllllllllllIIIIIllllIlIIlIIIl, final TextureAtlasSprite llllllllllllllIIIIIllllIlIIllIll, final int llllllllllllllIIIIIllllIlIIIllll, final RenderEnv llllllllllllllIIIIIllllIlIIllIIl) {
        final boolean[] llllllllllllllIIIIIllllIlIIllIII = llllllllllllllIIIIIllllIlIIllIIl.getBorderFlags();
        switch (llllllllllllllIIIIIllllIlIIlIIIl) {
            case 0: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 1: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 2: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                if (llllllllllllllIIIIIllllIlIIlIIlI == 1) {
                    switchValues(0, 1, llllllllllllllIIIIIllllIlIIllIII);
                    switchValues(2, 3, llllllllllllllIIIIIllllIlIIllIII);
                    break;
                }
                break;
            }
            case 3: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 4: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 5: {
                llllllllllllllIIIIIllllIlIIllIII[0] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                if (llllllllllllllIIIIIllllIlIIlIIlI == 2) {
                    switchValues(0, 1, llllllllllllllIIIIIllllIlIIllIII);
                    switchValues(2, 3, llllllllllllllIIIIIllllIlIIllIII);
                    break;
                }
                break;
            }
        }
        int llllllllllllllIIIIIllllIlIIlIlll = 0;
        if (llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 3;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 1;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 12;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 36;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 2;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 24;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 15;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 39;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 13;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 37;
        }
        else if (!llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 25;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & !llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 27;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & !llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 38;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 14;
        }
        else if (llllllllllllllIIIIIllllIlIIllIII[0] & llllllllllllllIIIIIllllIlIIllIII[1] & llllllllllllllIIIIIllllIlIIllIII[2] & llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 26;
        }
        if (llllllllllllllIIIIIllllIlIIlIlll == 0) {
            return llllllllllllllIIIIIllllIlIIlIlll;
        }
        if (!Config.isConnectedTexturesFancy()) {
            return llllllllllllllIIIIIllllIlIIlIlll;
        }
        switch (llllllllllllllIIIIIllllIlIIlIIIl) {
            case 0: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 1: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 2: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                if (llllllllllllllIIIIIllllIlIIlIIlI == 1) {
                    switchValues(0, 3, llllllllllllllIIIIIllllIlIIllIII);
                    switchValues(1, 2, llllllllllllllIIIIIllllIlIIllIII);
                    break;
                }
                break;
            }
            case 3: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().down(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.east().up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.west().up(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 4: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                break;
            }
            case 5: {
                llllllllllllllIIIIIllllIlIIllIII[0] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[1] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.down().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[2] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up().north(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                llllllllllllllIIIIIllllIlIIllIII[3] = !isNeighbour(llllllllllllllIIIIIllllIlIIlIllI, llllllllllllllIIIIIllllIlIIlIlIl, llllllllllllllIIIIIllllIlIIlllll, llllllllllllllIIIIIllllIlIIlIIll.up().south(), llllllllllllllIIIIIllllIlIIlIIIl, llllllllllllllIIIIIllllIlIIllIll, llllllllllllllIIIIIllllIlIIIllll);
                if (llllllllllllllIIIIIllllIlIIlIIlI == 2) {
                    switchValues(0, 3, llllllllllllllIIIIIllllIlIIllIII);
                    switchValues(1, 2, llllllllllllllIIIIIllllIlIIllIII);
                    break;
                }
                break;
            }
        }
        if (llllllllllllllIIIIIllllIlIIlIlll == 13 && llllllllllllllIIIIIllllIlIIllIII[0]) {
            llllllllllllllIIIIIllllIlIIlIlll = 4;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 15 && llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 5;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 37 && llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 16;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 39 && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 17;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 14 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 7;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 25 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 6;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 27 && llllllllllllllIIIIIllllIlIIllIII[3] && llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 19;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 38 && llllllllllllllIIIIIllllIlIIllIII[3] && llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 18;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 14 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 31;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 25 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 30;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 27 && !llllllllllllllIIIIIllllIlIIllIII[3] && llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 41;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 38 && llllllllllllllIIIIIllllIlIIllIII[3] && !llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 40;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 14 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 29;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 25 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 28;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 27 && llllllllllllllIIIIIllllIlIIllIII[3] && !llllllllllllllIIIIIllllIlIIllIII[1]) {
            llllllllllllllIIIIIllllIlIIlIlll = 43;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 38 && !llllllllllllllIIIIIllllIlIIllIII[3] && llllllllllllllIIIIIllllIlIIllIII[2]) {
            llllllllllllllIIIIIllllIlIIlIlll = 42;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 46;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 9;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 21;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 8;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 20;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 11;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 22;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 23;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 10;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 34;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 35;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 32;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 33;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && llllllllllllllIIIIIllllIlIIllIII[2] && !llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 44;
        }
        else if (llllllllllllllIIIIIllllIlIIlIlll == 26 && !llllllllllllllIIIIIllllIlIIllIII[0] && !llllllllllllllIIIIIllllIlIIllIII[1] && !llllllllllllllIIIIIllllIlIIllIII[2] && llllllllllllllIIIIIllllIlIIllIII[3]) {
            llllllllllllllIIIIIllllIlIIlIlll = 45;
        }
        return llllllllllllllIIIIIllllIlIIlIlll;
    }
    
    private static boolean isNeighbour(final ConnectedProperties llllllllllllllIIIIIllllIIIllIIIl, final IBlockAccess llllllllllllllIIIIIllllIIIllIIII, final IBlockState llllllllllllllIIIIIllllIIIllIlll, final BlockPos llllllllllllllIIIIIllllIIIllIllI, final int llllllllllllllIIIIIllllIIIlIllIl, final TextureAtlasSprite llllllllllllllIIIIIllllIIIlIllII, final int llllllllllllllIIIIIllllIIIllIIll) {
        final IBlockState llllllllllllllIIIIIllllIIIllIIlI = llllllllllllllIIIIIllllIIIllIIII.getBlockState(llllllllllllllIIIIIllllIIIllIllI);
        return isNeighbour(llllllllllllllIIIIIllllIIIllIIIl, llllllllllllllIIIIIllllIIIllIIII, llllllllllllllIIIIIllllIIIllIlll, llllllllllllllIIIIIllllIIIllIllI, llllllllllllllIIIIIllllIIIllIIlI, llllllllllllllIIIIIllllIIIlIllIl, llllllllllllllIIIIIllllIIIlIllII, llllllllllllllIIIIIllllIIIllIIll);
    }
    
    public static BakedQuad[] getConnectedTextureSingle(final IBlockAccess llllllllllllllIIIIlIIIIIIllllIII, final IBlockState llllllllllllllIIIIlIIIIIIlllIlll, final BlockPos llllllllllllllIIIIlIIIIIlIIIllIl, final EnumFacing llllllllllllllIIIIlIIIIIIlllIlIl, final BakedQuad llllllllllllllIIIIlIIIIIIlllIlII, final boolean llllllllllllllIIIIlIIIIIlIIIlIlI, final int llllllllllllllIIIIlIIIIIlIIIlIIl, final RenderEnv llllllllllllllIIIIlIIIIIlIIIlIII) {
        final Block llllllllllllllIIIIlIIIIIlIIIIlll = llllllllllllllIIIIlIIIIIIlllIlll.getBlock();
        if (!(llllllllllllllIIIIlIIIIIIlllIlll instanceof BlockStateBase)) {
            return llllllllllllllIIIIlIIIIIlIIIlIII.getArrayQuadsCtm(llllllllllllllIIIIlIIIIIIlllIlII);
        }
        final BlockStateBase llllllllllllllIIIIlIIIIIlIIIIllI = (BlockStateBase)llllllllllllllIIIIlIIIIIIlllIlll;
        final TextureAtlasSprite llllllllllllllIIIIlIIIIIlIIIIlIl = llllllllllllllIIIIlIIIIIIlllIlII.getSprite();
        if (ConnectedTextures.tileProperties != null) {
            final int llllllllllllllIIIIlIIIIIlIIIIlII = llllllllllllllIIIIlIIIIIlIIIIlIl.getIndexInMap();
            if (llllllllllllllIIIIlIIIIIlIIIIlII >= 0 && llllllllllllllIIIIlIIIIIlIIIIlII < ConnectedTextures.tileProperties.length) {
                final ConnectedProperties[] llllllllllllllIIIIlIIIIIlIIIIIll = ConnectedTextures.tileProperties[llllllllllllllIIIIlIIIIIlIIIIlII];
                if (llllllllllllllIIIIlIIIIIlIIIIIll != null) {
                    final int llllllllllllllIIIIlIIIIIlIIIIIlI = getSide(llllllllllllllIIIIlIIIIIIlllIlIl);
                    for (int llllllllllllllIIIIlIIIIIlIIIIIIl = 0; llllllllllllllIIIIlIIIIIlIIIIIIl < llllllllllllllIIIIlIIIIIlIIIIIll.length; ++llllllllllllllIIIIlIIIIIlIIIIIIl) {
                        final ConnectedProperties llllllllllllllIIIIlIIIIIlIIIIIII = llllllllllllllIIIIlIIIIIlIIIIIll[llllllllllllllIIIIlIIIIIlIIIIIIl];
                        if (llllllllllllllIIIIlIIIIIlIIIIIII != null && llllllllllllllIIIIlIIIIIlIIIIIII.matchesBlockId(llllllllllllllIIIIlIIIIIlIIIIllI.getBlockId())) {
                            final BakedQuad[] llllllllllllllIIIIlIIIIIIlllllll = getConnectedTexture(llllllllllllllIIIIlIIIIIlIIIIIII, llllllllllllllIIIIlIIIIIIllllIII, llllllllllllllIIIIlIIIIIlIIIIllI, llllllllllllllIIIIlIIIIIlIIIllIl, llllllllllllllIIIIlIIIIIlIIIIIlI, llllllllllllllIIIIlIIIIIIlllIlII, llllllllllllllIIIIlIIIIIlIIIlIIl, llllllllllllllIIIIlIIIIIlIIIlIII);
                            if (llllllllllllllIIIIlIIIIIIlllllll != null) {
                                return llllllllllllllIIIIlIIIIIIlllllll;
                            }
                        }
                    }
                }
            }
        }
        if (ConnectedTextures.blockProperties != null && llllllllllllllIIIIlIIIIIlIIIlIlI) {
            final int llllllllllllllIIIIlIIIIIIllllllI = llllllllllllllIIIIlIIIIIlIIIlIII.getBlockId();
            if (llllllllllllllIIIIlIIIIIIllllllI >= 0 && llllllllllllllIIIIlIIIIIIllllllI < ConnectedTextures.blockProperties.length) {
                final ConnectedProperties[] llllllllllllllIIIIlIIIIIIlllllIl = ConnectedTextures.blockProperties[llllllllllllllIIIIlIIIIIIllllllI];
                if (llllllllllllllIIIIlIIIIIIlllllIl != null) {
                    final int llllllllllllllIIIIlIIIIIIlllllII = getSide(llllllllllllllIIIIlIIIIIIlllIlIl);
                    for (int llllllllllllllIIIIlIIIIIIllllIll = 0; llllllllllllllIIIIlIIIIIIllllIll < llllllllllllllIIIIlIIIIIIlllllIl.length; ++llllllllllllllIIIIlIIIIIIllllIll) {
                        final ConnectedProperties llllllllllllllIIIIlIIIIIIllllIlI = llllllllllllllIIIIlIIIIIIlllllIl[llllllllllllllIIIIlIIIIIIllllIll];
                        if (llllllllllllllIIIIlIIIIIIllllIlI != null && llllllllllllllIIIIlIIIIIIllllIlI.matchesIcon(llllllllllllllIIIIlIIIIIlIIIIlIl)) {
                            final BakedQuad[] llllllllllllllIIIIlIIIIIIllllIIl = getConnectedTexture(llllllllllllllIIIIlIIIIIIllllIlI, llllllllllllllIIIIlIIIIIIllllIII, llllllllllllllIIIIlIIIIIlIIIIllI, llllllllllllllIIIIlIIIIIlIIIllIl, llllllllllllllIIIIlIIIIIIlllllII, llllllllllllllIIIIlIIIIIIlllIlII, llllllllllllllIIIIlIIIIIlIIIlIIl, llllllllllllllIIIIlIIIIIlIIIlIII);
                            if (llllllllllllllIIIIlIIIIIIllllIIl != null) {
                                return llllllllllllllIIIIlIIIIIIllllIIl;
                            }
                        }
                    }
                }
            }
        }
        return llllllllllllllIIIIlIIIIIlIIIlIII.getArrayQuadsCtm(llllllllllllllIIIIlIIIIIIlllIlII);
    }
    
    private static void switchValues(final int llllllllllllllIIIIIllllIlIIIIIll, final int llllllllllllllIIIIIllllIlIIIIllI, final boolean[] llllllllllllllIIIIIllllIlIIIIIIl) {
        final boolean llllllllllllllIIIIIllllIlIIIIlII = llllllllllllllIIIIIllllIlIIIIIIl[llllllllllllllIIIIIllllIlIIIIIll];
        llllllllllllllIIIIIllllIlIIIIIIl[llllllllllllllIIIIIllllIlIIIIIll] = llllllllllllllIIIIIllllIlIIIIIIl[llllllllllllllIIIIIllllIlIIIIllI];
        llllllllllllllIIIIIllllIlIIIIIIl[llllllllllllllIIIIIllllIlIIIIllI] = llllllllllllllIIIIIllllIlIIIIlII;
    }
    
    private static void addToBlockList(final ConnectedProperties llllllllllllllIIIIIlllIIllIIIIII, final List llllllllllllllIIIIIlllIIllIIIIll) {
        if (llllllllllllllIIIIIlllIIllIIIIII.matchBlocks != null) {
            for (int llllllllllllllIIIIIlllIIllIIIIlI = 0; llllllllllllllIIIIIlllIIllIIIIlI < llllllllllllllIIIIIlllIIllIIIIII.matchBlocks.length; ++llllllllllllllIIIIIlllIIllIIIIlI) {
                final int llllllllllllllIIIIIlllIIllIIIIIl = llllllllllllllIIIIIlllIIllIIIIII.matchBlocks[llllllllllllllIIIIIlllIIllIIIIlI].getBlockId();
                if (llllllllllllllIIIIIlllIIllIIIIIl < 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid block ID: ").append(llllllllllllllIIIIIlllIIllIIIIIl)));
                }
                else {
                    addToList(llllllllllllllIIIIIlllIIllIIIIII, llllllllllllllIIIIIlllIIllIIIIll, llllllllllllllIIIIIlllIIllIIIIIl);
                }
            }
        }
    }
    
    private static BakedQuad[] getConnectedTextureMultiPass(final IBlockAccess llllllllllllllIIIIlIIIIIlIlIllIl, final IBlockState llllllllllllllIIIIlIIIIIlIlllIlI, final BlockPos llllllllllllllIIIIlIIIIIlIlIlIll, final EnumFacing llllllllllllllIIIIlIIIIIlIlIlIlI, final BakedQuad llllllllllllllIIIIlIIIIIlIllIlll, final RenderEnv llllllllllllllIIIIlIIIIIlIlIlIII) {
        final BakedQuad[] llllllllllllllIIIIlIIIIIlIllIlIl = getConnectedTextureSingle(llllllllllllllIIIIlIIIIIlIlIllIl, llllllllllllllIIIIlIIIIIlIlllIlI, llllllllllllllIIIIlIIIIIlIlIlIll, llllllllllllllIIIIlIIIIIlIlIlIlI, llllllllllllllIIIIlIIIIIlIllIlll, true, 0, llllllllllllllIIIIlIIIIIlIlIlIII);
        if (!ConnectedTextures.multipass) {
            return llllllllllllllIIIIlIIIIIlIllIlIl;
        }
        if (llllllllllllllIIIIlIIIIIlIllIlIl.length == 1 && llllllllllllllIIIIlIIIIIlIllIlIl[0] == llllllllllllllIIIIlIIIIIlIllIlll) {
            return llllllllllllllIIIIlIIIIIlIllIlIl;
        }
        final List<BakedQuad> llllllllllllllIIIIlIIIIIlIllIlII = llllllllllllllIIIIlIIIIIlIlIlIII.getListQuadsCtmMultipass(llllllllllllllIIIIlIIIIIlIllIlIl);
        for (int llllllllllllllIIIIlIIIIIlIllIIll = 0; llllllllllllllIIIIlIIIIIlIllIIll < llllllllllllllIIIIlIIIIIlIllIlII.size(); ++llllllllllllllIIIIlIIIIIlIllIIll) {
            BakedQuad llllllllllllllIIIIlIIIIIlIllIIIl;
            final BakedQuad llllllllllllllIIIIlIIIIIlIllIIlI = llllllllllllllIIIIlIIIIIlIllIIIl = llllllllllllllIIIIlIIIIIlIllIlII.get(llllllllllllllIIIIlIIIIIlIllIIll);
            for (int llllllllllllllIIIIlIIIIIlIllIIII = 0; llllllllllllllIIIIlIIIIIlIllIIII < 3; ++llllllllllllllIIIIlIIIIIlIllIIII) {
                final BakedQuad[] llllllllllllllIIIIlIIIIIlIlIllll = getConnectedTextureSingle(llllllllllllllIIIIlIIIIIlIlIllIl, llllllllllllllIIIIlIIIIIlIlllIlI, llllllllllllllIIIIlIIIIIlIlIlIll, llllllllllllllIIIIlIIIIIlIlIlIlI, llllllllllllllIIIIlIIIIIlIllIIIl, false, llllllllllllllIIIIlIIIIIlIllIIII + 1, llllllllllllllIIIIlIIIIIlIlIlIII);
                if (llllllllllllllIIIIlIIIIIlIlIllll.length != 1) {
                    break;
                }
                if (llllllllllllllIIIIlIIIIIlIlIllll[0] == llllllllllllllIIIIlIIIIIlIllIIIl) {
                    break;
                }
                llllllllllllllIIIIlIIIIIlIllIIIl = llllllllllllllIIIIlIIIIIlIlIllll[0];
            }
            llllllllllllllIIIIlIIIIIlIllIlII.set(llllllllllllllIIIIlIIIIIlIllIIll, llllllllllllllIIIIlIIIIIlIllIIIl);
        }
        for (int llllllllllllllIIIIlIIIIIlIlIlllI = 0; llllllllllllllIIIIlIIIIIlIlIlllI < llllllllllllllIIIIlIIIIIlIllIlIl.length; ++llllllllllllllIIIIlIIIIIlIlIlllI) {
            llllllllllllllIIIIlIIIIIlIllIlIl[llllllllllllllIIIIlIIIIIlIlIlllI] = llllllllllllllIIIIlIIIIIlIllIlII.get(llllllllllllllIIIIlIIIIIlIlIlllI);
        }
        return llllllllllllllIIIIlIIIIIlIllIlIl;
    }
    
    private static String[] getDefaultCtmPaths() {
        final List llllllllllllllIIIIIlllIIlIlIlIll = new ArrayList();
        final String llllllllllllllIIIIIlllIIlIlIlIlI = "mcpatcher/ctm/default/";
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/glass.png"))) {
            llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append("glass.properties")));
            llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append("glasspane.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/bookshelf.png"))) {
            llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append("bookshelf.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/sandstone_normal.png"))) {
            llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append("sandstone.properties")));
        }
        final String[] llllllllllllllIIIIIlllIIlIlIlIIl = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black" };
        for (int llllllllllllllIIIIIlllIIlIlIlIII = 0; llllllllllllllIIIIIlllIIlIlIlIII < llllllllllllllIIIIIlllIIlIlIlIIl.length; ++llllllllllllllIIIIIlllIIlIlIlIII) {
            final String llllllllllllllIIIIIlllIIlIlIIlll = llllllllllllllIIIIIlllIIlIlIlIIl[llllllllllllllIIIIIlllIIlIlIlIII];
            if (Config.isFromDefaultResourcePack(new ResourceLocation(String.valueOf(new StringBuilder("textures/blocks/glass_").append(llllllllllllllIIIIIlllIIlIlIIlll).append(".png"))))) {
                llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append(llllllllllllllIIIIIlllIIlIlIlIII).append("_glass_").append(llllllllllllllIIIIIlllIIlIlIIlll).append("/glass_").append(llllllllllllllIIIIIlllIIlIlIIlll).append(".properties")));
                llllllllllllllIIIIIlllIIlIlIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIIlllIIlIlIlIlI)).append(llllllllllllllIIIIIlllIIlIlIlIII).append("_glass_").append(llllllllllllllIIIIIlllIIlIlIIlll).append("/glass_pane_").append(llllllllllllllIIIIIlllIIlIlIIlll).append(".properties")));
            }
        }
        final String[] llllllllllllllIIIIIlllIIlIlIIllI = llllllllllllllIIIIIlllIIlIlIlIll.toArray(new String[llllllllllllllIIIIIlllIIlIlIlIll.size()]);
        return llllllllllllllIIIIIlllIIlIlIIllI;
    }
    
    private static TextureAtlasSprite getConnectedTextureFixed(final ConnectedProperties llllllllllllllIIIIlIIIIIIIIIIlll) {
        return llllllllllllllIIIIlIIIIIIIIIIlll.tileIcons[0];
    }
    
    private static int fixSideByAxis(final int llllllllllllllIIIIlIIIIIIIllIIll, final int llllllllllllllIIIIlIIIIIIIllIIlI) {
        switch (llllllllllllllIIIIlIIIIIIIllIIlI) {
            case 0: {
                return llllllllllllllIIIIlIIIIIIIllIIll;
            }
            case 1: {
                switch (llllllllllllllIIIIlIIIIIIIllIIll) {
                    case 0: {
                        return 2;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 1;
                    }
                    case 3: {
                        return 0;
                    }
                    default: {
                        return llllllllllllllIIIIlIIIIIIIllIIll;
                    }
                }
                break;
            }
            case 2: {
                switch (llllllllllllllIIIIlIIIIIIIllIIll) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 5;
                    }
                    default: {
                        return llllllllllllllIIIIlIIIIIIIllIIll;
                    }
                    case 4: {
                        return 1;
                    }
                    case 5: {
                        return 0;
                    }
                }
                break;
            }
            default: {
                return llllllllllllllIIIIlIIIIIIIllIIll;
            }
        }
    }
    
    private static boolean isNeighbour(final ConnectedProperties llllllllllllllIIIIIllllIIIIllllI, final IBlockAccess llllllllllllllIIIIIllllIIIIlllIl, final IBlockState llllllllllllllIIIIIllllIIIIlllII, final BlockPos llllllllllllllIIIIIllllIIIIllIll, final IBlockState llllllllllllllIIIIIllllIIIIllIlI, final int llllllllllllllIIIIIllllIIIIIllIl, final TextureAtlasSprite llllllllllllllIIIIIllllIIIIIllII, final int llllllllllllllIIIIIllllIIIIIlIll) {
        if (llllllllllllllIIIIIllllIIIIlllII == llllllllllllllIIIIIllllIIIIllIlI) {
            return true;
        }
        if (llllllllllllllIIIIIllllIIIIllllI.connect == 2) {
            if (llllllllllllllIIIIIllllIIIIllIlI == null) {
                return false;
            }
            if (llllllllllllllIIIIIllllIIIIllIlI == ConnectedTextures.AIR_DEFAULT_STATE) {
                return false;
            }
            final TextureAtlasSprite llllllllllllllIIIIIllllIIIIlIllI = getNeighbourIcon(llllllllllllllIIIIIllllIIIIlllIl, llllllllllllllIIIIIllllIIIIlllII, llllllllllllllIIIIIllllIIIIllIll, llllllllllllllIIIIIllllIIIIllIlI, llllllllllllllIIIIIllllIIIIIllIl);
            return llllllllllllllIIIIIllllIIIIlIllI == llllllllllllllIIIIIllllIIIIIllII;
        }
        else {
            if (llllllllllllllIIIIIllllIIIIllllI.connect == 3) {
                return llllllllllllllIIIIIllllIIIIllIlI != null && llllllllllllllIIIIIllllIIIIllIlI != ConnectedTextures.AIR_DEFAULT_STATE && llllllllllllllIIIIIllllIIIIllIlI.getMaterial() == llllllllllllllIIIIIllllIIIIlllII.getMaterial();
            }
            if (!(llllllllllllllIIIIIllllIIIIllIlI instanceof BlockStateBase)) {
                return false;
            }
            final BlockStateBase llllllllllllllIIIIIllllIIIIlIlIl = (BlockStateBase)llllllllllllllIIIIIllllIIIIllIlI;
            final Block llllllllllllllIIIIIllllIIIIlIlII = llllllllllllllIIIIIllllIIIIlIlIl.getBlock();
            final int llllllllllllllIIIIIllllIIIIlIIll = llllllllllllllIIIIIllllIIIIlIlIl.getMetadata();
            return llllllllllllllIIIIIllllIIIIlIlII == llllllllllllllIIIIIllllIIIIlllII.getBlock() && llllllllllllllIIIIIllllIIIIlIIll == llllllllllllllIIIIIllllIIIIIlIll;
        }
    }
    
    private static TextureAtlasSprite getConnectedTextureRepeat(final ConnectedProperties llllllllllllllIIIIIlllllllllllIl, final BlockPos llllllllllllllIIIIIlllllllllllII, final int llllllllllllllIIIIIllllllllllIll) {
        if (llllllllllllllIIIIIlllllllllllIl.tileIcons.length == 1) {
            return llllllllllllllIIIIIlllllllllllIl.tileIcons[0];
        }
        final int llllllllllllllIIIIIllllllllllIlI = llllllllllllllIIIIIlllllllllllII.getX();
        final int llllllllllllllIIIIIllllllllllIIl = llllllllllllllIIIIIlllllllllllII.getY();
        final int llllllllllllllIIIIIllllllllllIII = llllllllllllllIIIIIlllllllllllII.getZ();
        int llllllllllllllIIIIIlllllllllIlll = 0;
        int llllllllllllllIIIIIlllllllllIllI = 0;
        switch (llllllllllllllIIIIIllllllllllIll) {
            case 0: {
                llllllllllllllIIIIIlllllllllIlll = llllllllllllllIIIIIllllllllllIlI;
                llllllllllllllIIIIIlllllllllIllI = llllllllllllllIIIIIllllllllllIII;
                break;
            }
            case 1: {
                llllllllllllllIIIIIlllllllllIlll = llllllllllllllIIIIIllllllllllIlI;
                llllllllllllllIIIIIlllllllllIllI = llllllllllllllIIIIIllllllllllIII;
                break;
            }
            case 2: {
                llllllllllllllIIIIIlllllllllIlll = -llllllllllllllIIIIIllllllllllIlI - 1;
                llllllllllllllIIIIIlllllllllIllI = -llllllllllllllIIIIIllllllllllIIl;
                break;
            }
            case 3: {
                llllllllllllllIIIIIlllllllllIlll = llllllllllllllIIIIIllllllllllIlI;
                llllllllllllllIIIIIlllllllllIllI = -llllllllllllllIIIIIllllllllllIIl;
                break;
            }
            case 4: {
                llllllllllllllIIIIIlllllllllIlll = llllllllllllllIIIIIllllllllllIII;
                llllllllllllllIIIIIlllllllllIllI = -llllllllllllllIIIIIllllllllllIIl;
                break;
            }
            case 5: {
                llllllllllllllIIIIIlllllllllIlll = -llllllllllllllIIIIIllllllllllIII - 1;
                llllllllllllllIIIIIlllllllllIllI = -llllllllllllllIIIIIllllllllllIIl;
                break;
            }
        }
        llllllllllllllIIIIIlllllllllIlll %= llllllllllllllIIIIIlllllllllllIl.width;
        llllllllllllllIIIIIlllllllllIllI %= llllllllllllllIIIIIlllllllllllIl.height;
        if (llllllllllllllIIIIIlllllllllIlll < 0) {
            llllllllllllllIIIIIlllllllllIlll += llllllllllllllIIIIIlllllllllllIl.width;
        }
        if (llllllllllllllIIIIIlllllllllIllI < 0) {
            llllllllllllllIIIIIlllllllllIllI += llllllllllllllIIIIIlllllllllllIl.height;
        }
        final int llllllllllllllIIIIIlllllllllIlIl = llllllllllllllIIIIIlllllllllIllI * llllllllllllllIIIIIlllllllllllIl.width + llllllllllllllIIIIIlllllllllIlll;
        return llllllllllllllIIIIIlllllllllllIl.tileIcons[llllllllllllllIIIIIlllllllllIlIl];
    }
    
    public static void updateIcons(final TextureMap llllllllllllllIIIIIlllIlIIlIIIll, final IResourcePack llllllllllllllIIIIIlllIlIIIlIlIl) {
        final String[] llllllllllllllIIIIIlllIlIIlIIIIl = ResUtils.collectFiles(llllllllllllllIIIIIlllIlIIIlIlIl, "mcpatcher/ctm/", ".properties", getDefaultCtmPaths());
        Arrays.sort(llllllllllllllIIIIIlllIlIIlIIIIl);
        final List llllllllllllllIIIIIlllIlIIlIIIII = makePropertyList(ConnectedTextures.tileProperties);
        final List llllllllllllllIIIIIlllIlIIIlllll = makePropertyList(ConnectedTextures.blockProperties);
        for (int llllllllllllllIIIIIlllIlIIIllllI = 0; llllllllllllllIIIIIlllIlIIIllllI < llllllllllllllIIIIIlllIlIIlIIIIl.length; ++llllllllllllllIIIIIlllIlIIIllllI) {
            final String llllllllllllllIIIIIlllIlIIIlllIl = llllllllllllllIIIIIlllIlIIlIIIIl[llllllllllllllIIIIIlllIlIIIllllI];
            Config.dbg(String.valueOf(new StringBuilder("ConnectedTextures: ").append(llllllllllllllIIIIIlllIlIIIlllIl)));
            try {
                final ResourceLocation llllllllllllllIIIIIlllIlIIIlllII = new ResourceLocation(llllllllllllllIIIIIlllIlIIIlllIl);
                final InputStream llllllllllllllIIIIIlllIlIIIllIll = llllllllllllllIIIIIlllIlIIIlIlIl.getInputStream(llllllllllllllIIIIIlllIlIIIlllII);
                if (llllllllllllllIIIIIlllIlIIIllIll == null) {
                    Config.warn(String.valueOf(new StringBuilder("ConnectedTextures file not found: ").append(llllllllllllllIIIIIlllIlIIIlllIl)));
                }
                else {
                    final Properties llllllllllllllIIIIIlllIlIIIllIlI = new Properties();
                    llllllllllllllIIIIIlllIlIIIllIlI.load(llllllllllllllIIIIIlllIlIIIllIll);
                    final ConnectedProperties llllllllllllllIIIIIlllIlIIIllIIl = new ConnectedProperties(llllllllllllllIIIIIlllIlIIIllIlI, llllllllllllllIIIIIlllIlIIIlllIl);
                    if (llllllllllllllIIIIIlllIlIIIllIIl.isValid(llllllllllllllIIIIIlllIlIIIlllIl)) {
                        llllllllllllllIIIIIlllIlIIIllIIl.updateIcons(llllllllllllllIIIIIlllIlIIlIIIll);
                        addToTileList(llllllllllllllIIIIIlllIlIIIllIIl, llllllllllllllIIIIIlllIlIIlIIIII);
                        addToBlockList(llllllllllllllIIIIIlllIlIIIllIIl, llllllllllllllIIIIIlllIlIIIlllll);
                    }
                }
            }
            catch (FileNotFoundException llllllllllllllIIIIIlllIlIIIllIII) {
                Config.warn(String.valueOf(new StringBuilder("ConnectedTextures file not found: ").append(llllllllllllllIIIIIlllIlIIIlllIl)));
            }
            catch (Exception llllllllllllllIIIIIlllIlIIIlIlll) {
                llllllllllllllIIIIIlllIlIIIlIlll.printStackTrace();
            }
        }
        ConnectedTextures.blockProperties = propertyListToArray(llllllllllllllIIIIIlllIlIIIlllll);
        ConnectedTextures.tileProperties = propertyListToArray(llllllllllllllIIIIIlllIlIIlIIIII);
        ConnectedTextures.multipass = detectMultipass();
        Config.dbg(String.valueOf(new StringBuilder("Multipass connected textures: ").append(ConnectedTextures.multipass)));
    }
    
    private static EnumFacing getFacing(final int llllllllllllllIIIIlIIIIIIllIIIll) {
        switch (llllllllllllllIIIIlIIIIIIllIIIll) {
            case 0: {
                return EnumFacing.DOWN;
            }
            case 1: {
                return EnumFacing.UP;
            }
            case 2: {
                return EnumFacing.NORTH;
            }
            case 3: {
                return EnumFacing.SOUTH;
            }
            case 4: {
                return EnumFacing.WEST;
            }
            case 5: {
                return EnumFacing.EAST;
            }
            default: {
                return EnumFacing.UP;
            }
        }
    }
    
    private static void fixVertex(final int[] llllllllllllllIIIIlIIIIIllIlIIlI, final int llllllllllllllIIIIlIIIIIllIlIIIl, final TextureAtlasSprite llllllllllllllIIIIlIIIIIllIllIlI, final TextureAtlasSprite llllllllllllllIIIIlIIIIIllIllIIl) {
        final int llllllllllllllIIIIlIIIIIllIllIII = llllllllllllllIIIIlIIIIIllIlIIlI.length / 4;
        final int llllllllllllllIIIIlIIIIIllIlIlll = llllllllllllllIIIIlIIIIIllIllIII * llllllllllllllIIIIlIIIIIllIlIIIl;
        final float llllllllllllllIIIIlIIIIIllIlIllI = Float.intBitsToFloat(llllllllllllllIIIIlIIIIIllIlIIlI[llllllllllllllIIIIlIIIIIllIlIlll + 4]);
        final float llllllllllllllIIIIlIIIIIllIlIlIl = Float.intBitsToFloat(llllllllllllllIIIIlIIIIIllIlIIlI[llllllllllllllIIIIlIIIIIllIlIlll + 4 + 1]);
        final double llllllllllllllIIIIlIIIIIllIlIlII = llllllllllllllIIIIlIIIIIllIllIlI.getSpriteU16(llllllllllllllIIIIlIIIIIllIlIllI);
        final double llllllllllllllIIIIlIIIIIllIlIIll = llllllllllllllIIIIlIIIIIllIllIlI.getSpriteV16(llllllllllllllIIIIlIIIIIllIlIlIl);
        llllllllllllllIIIIlIIIIIllIlIIlI[llllllllllllllIIIIlIIIIIllIlIlll + 4] = Float.floatToRawIntBits(llllllllllllllIIIIlIIIIIllIllIIl.getInterpolatedU(llllllllllllllIIIIlIIIIIllIlIlII));
        llllllllllllllIIIIlIIIIIllIlIIlI[llllllllllllllIIIIlIIIIIllIlIlll + 4 + 1] = Float.floatToRawIntBits(llllllllllllllIIIIlIIIIIllIllIIl.getInterpolatedV(llllllllllllllIIIIlIIIIIllIlIIll));
    }
    
    private static void updateIconEmpty(final TextureMap llllllllllllllIIIIIlllIlIIlIllll) {
    }
    
    private static TextureAtlasSprite getNeighbourIcon(final IBlockAccess llllllllllllllIIIIIlllIlllllIIIl, final IBlockState llllllllllllllIIIIIlllIlllllllII, final BlockPos llllllllllllllIIIIIlllIllllllIll, IBlockState llllllllllllllIIIIIlllIllllIllll, final int llllllllllllllIIIIIlllIllllllIIl) {
        llllllllllllllIIIIIlllIllllIllll = llllllllllllllIIIIIlllIllllIllll.getBlock().getActualState(llllllllllllllIIIIIlllIllllIllll, llllllllllllllIIIIIlllIlllllIIIl, llllllllllllllIIIIIlllIllllllIll);
        final IBakedModel llllllllllllllIIIIIlllIllllllIII = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(llllllllllllllIIIIIlllIllllIllll);
        if (llllllllllllllIIIIIlllIllllllIII == null) {
            return null;
        }
        final EnumFacing llllllllllllllIIIIIlllIlllllIlll = getFacing(llllllllllllllIIIIIlllIllllllIIl);
        List llllllllllllllIIIIIlllIlllllIllI = llllllllllllllIIIIIlllIllllllIII.getQuads(llllllllllllllIIIIIlllIllllIllll, llllllllllllllIIIIIlllIlllllIlll, 0L);
        if (Config.isBetterGrass()) {
            llllllllllllllIIIIIlllIlllllIllI = BetterGrass.getFaceQuads(llllllllllllllIIIIIlllIlllllIIIl, llllllllllllllIIIIIlllIllllIllll, llllllllllllllIIIIIlllIllllllIll, llllllllllllllIIIIIlllIlllllIlll, llllllllllllllIIIIIlllIlllllIllI);
        }
        if (llllllllllllllIIIIIlllIlllllIllI.size() > 0) {
            final BakedQuad llllllllllllllIIIIIlllIlllllIlIl = llllllllllllllIIIIIlllIlllllIllI.get(0);
            return llllllllllllllIIIIIlllIlllllIlIl.getSprite();
        }
        final List llllllllllllllIIIIIlllIlllllIlII = llllllllllllllIIIIIlllIllllllIII.getQuads(llllllllllllllIIIIIlllIllllIllll, null, 0L);
        for (int llllllllllllllIIIIIlllIlllllIIll = 0; llllllllllllllIIIIIlllIlllllIIll < llllllllllllllIIIIIlllIlllllIlII.size(); ++llllllllllllllIIIIIlllIlllllIIll) {
            final BakedQuad llllllllllllllIIIIIlllIlllllIIlI = llllllllllllllIIIIIlllIlllllIlII.get(llllllllllllllIIIIIlllIlllllIIll);
            if (llllllllllllllIIIIIlllIlllllIIlI.getFace() == llllllllllllllIIIIIlllIlllllIlll) {
                return llllllllllllllIIIIIlllIlllllIIlI.getSprite();
            }
        }
        return null;
    }
    
    private static BlockDir[] getEdgeDirections(final int llllllllllllllIIIIIllllIlIlllllI, final int llllllllllllllIIIIIllllIllIIIIIl) {
        switch (llllllllllllllIIIIIllllIlIlllllI) {
            case 0: {
                return ConnectedTextures.EDGES_Y_NEG_DOWN;
            }
            case 1: {
                return ConnectedTextures.EDGES_Y_POS_UP;
            }
            case 2: {
                if (llllllllllllllIIIIIllllIllIIIIIl == 1) {
                    return ConnectedTextures.EDGES_Z_NEG_NORTH_Z_AXIS;
                }
                return ConnectedTextures.EDGES_Z_NEG_NORTH;
            }
            case 3: {
                return ConnectedTextures.EDGES_Z_POS_SOUTH;
            }
            case 4: {
                return ConnectedTextures.EDGES_X_NEG_WEST;
            }
            case 5: {
                if (llllllllllllllIIIIIllllIllIIIIIl == 2) {
                    return ConnectedTextures.EDGES_X_POS_EAST_X_AXIS;
                }
                return ConnectedTextures.EDGES_X_POS_EAST;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown side: ").append(llllllllllllllIIIIIllllIlIlllllI)));
            }
        }
    }
    
    private static void addToList(final ConnectedProperties llllllllllllllIIIIIlllIIlIllIlII, final List llllllllllllllIIIIIlllIIlIllIlll, final int llllllllllllllIIIIIlllIIlIllIIlI) {
        while (llllllllllllllIIIIIlllIIlIllIIlI >= llllllllllllllIIIIIlllIIlIllIlll.size()) {
            llllllllllllllIIIIIlllIIlIllIlll.add(null);
        }
        List llllllllllllllIIIIIlllIIlIllIlIl = llllllllllllllIIIIIlllIIlIllIlll.get(llllllllllllllIIIIIlllIIlIllIIlI);
        if (llllllllllllllIIIIIlllIIlIllIlIl == null) {
            llllllllllllllIIIIIlllIIlIllIlIl = new ArrayList();
            llllllllllllllIIIIIlllIIlIllIlll.set(llllllllllllllIIIIIlllIIlIllIIlI, llllllllllllllIIIIIlllIIlIllIlIl);
        }
        llllllllllllllIIIIIlllIIlIllIlIl.add(llllllllllllllIIIIIlllIIlIllIlII);
    }
    
    public static synchronized BakedQuad[] getConnectedTexture(final IBlockAccess llllllllllllllIIIIlIIIIlIlIllIlI, final IBlockState llllllllllllllIIIIlIIIIlIlIlIIII, final BlockPos llllllllllllllIIIIlIIIIlIlIIllll, BakedQuad llllllllllllllIIIIlIIIIlIlIIlllI, final RenderEnv llllllllllllllIIIIlIIIIlIlIIllIl) {
        final TextureAtlasSprite llllllllllllllIIIIlIIIIlIlIlIlIl = llllllllllllllIIIIlIIIIlIlIIlllI.getSprite();
        if (llllllllllllllIIIIlIIIIlIlIlIlIl == null) {
            return llllllllllllllIIIIlIIIIlIlIIllIl.getArrayQuadsCtm(llllllllllllllIIIIlIIIIlIlIIlllI);
        }
        final Block llllllllllllllIIIIlIIIIlIlIlIlII = llllllllllllllIIIIlIIIIlIlIlIIII.getBlock();
        if (skipConnectedTexture(llllllllllllllIIIIlIIIIlIlIllIlI, llllllllllllllIIIIlIIIIlIlIlIIII, llllllllllllllIIIIlIIIIlIlIIllll, llllllllllllllIIIIlIIIIlIlIIlllI, llllllllllllllIIIIlIIIIlIlIIllIl)) {
            llllllllllllllIIIIlIIIIlIlIIlllI = getQuad(ConnectedTextures.emptySprite, llllllllllllllIIIIlIIIIlIlIIlllI);
            return llllllllllllllIIIIlIIIIlIlIIllIl.getArrayQuadsCtm(llllllllllllllIIIIlIIIIlIlIIlllI);
        }
        final EnumFacing llllllllllllllIIIIlIIIIlIlIlIIll = llllllllllllllIIIIlIIIIlIlIIlllI.getFace();
        final BakedQuad[] llllllllllllllIIIIlIIIIlIlIlIIlI = getConnectedTextureMultiPass(llllllllllllllIIIIlIIIIlIlIllIlI, llllllllllllllIIIIlIIIIlIlIlIIII, llllllllllllllIIIIlIIIIlIlIIllll, llllllllllllllIIIIlIIIIlIlIlIIll, llllllllllllllIIIIlIIIIlIlIIlllI, llllllllllllllIIIIlIIIIlIlIIllIl);
        return llllllllllllllIIIIlIIIIlIlIlIIlI;
    }
    
    private static TextureAtlasSprite getConnectedTextureVerticalHorizontal(final ConnectedProperties llllllllllllllIIIIIlllIlIllIIIlI, final IBlockAccess llllllllllllllIIIIIlllIlIllIIIIl, final IBlockState llllllllllllllIIIIIlllIlIllIlIll, final BlockPos llllllllllllllIIIIIlllIlIllIlIlI, final int llllllllllllllIIIIIlllIlIlIllllI, final int llllllllllllllIIIIIlllIlIllIlIII, final TextureAtlasSprite llllllllllllllIIIIIlllIlIlIlllII, final int llllllllllllllIIIIIlllIlIlIllIll) {
        final TextureAtlasSprite[] llllllllllllllIIIIIlllIlIllIIlIl = llllllllllllllIIIIIlllIlIllIIIlI.tileIcons;
        final TextureAtlasSprite llllllllllllllIIIIIlllIlIllIIlII = getConnectedTextureVertical(llllllllllllllIIIIIlllIlIllIIIlI, llllllllllllllIIIIIlllIlIllIIIIl, llllllllllllllIIIIIlllIlIllIlIll, llllllllllllllIIIIIlllIlIllIlIlI, llllllllllllllIIIIIlllIlIlIllllI, llllllllllllllIIIIIlllIlIllIlIII, llllllllllllllIIIIIlllIlIlIlllII, llllllllllllllIIIIIlllIlIlIllIll);
        if (llllllllllllllIIIIIlllIlIllIIlII != null && llllllllllllllIIIIIlllIlIllIIlII != llllllllllllllIIIIIlllIlIlIlllII && llllllllllllllIIIIIlllIlIllIIlII != llllllllllllllIIIIIlllIlIllIIlIl[3]) {
            return llllllllllllllIIIIIlllIlIllIIlII;
        }
        final TextureAtlasSprite llllllllllllllIIIIIlllIlIllIIIll = getConnectedTextureHorizontal(llllllllllllllIIIIIlllIlIllIIIlI, llllllllllllllIIIIIlllIlIllIIIIl, llllllllllllllIIIIIlllIlIllIlIll, llllllllllllllIIIIIlllIlIllIlIlI, llllllllllllllIIIIIlllIlIlIllllI, llllllllllllllIIIIIlllIlIllIlIII, llllllllllllllIIIIIlllIlIlIlllII, llllllllllllllIIIIIlllIlIlIllIll);
        if (llllllllllllllIIIIIlllIlIllIIIll == llllllllllllllIIIIIlllIlIllIIlIl[0]) {
            return llllllllllllllIIIIIlllIlIllIIlIl[4];
        }
        if (llllllllllllllIIIIIlllIlIllIIIll == llllllllllllllIIIIIlllIlIllIIlIl[1]) {
            return llllllllllllllIIIIIlllIlIllIIlIl[5];
        }
        return (llllllllllllllIIIIIlllIlIllIIIll == llllllllllllllIIIIIlllIlIllIIlIl[2]) ? llllllllllllllIIIIIlllIlIllIIlIl[6] : llllllllllllllIIIIIlllIlIllIIIll;
    }
    
    private static boolean isNeighbourMatching(final ConnectedProperties llllllllllllllIIIIIllllIIlIIlIIl, final IBlockAccess llllllllllllllIIIIIllllIIlIIlIII, final IBlockState llllllllllllllIIIIIllllIIlIlIIlI, final BlockPos llllllllllllllIIIIIllllIIlIIIllI, final int llllllllllllllIIIIIllllIIlIlIIII, final TextureAtlasSprite llllllllllllllIIIIIllllIIlIIllll, final int llllllllllllllIIIIIllllIIlIIlllI) {
        final IBlockState llllllllllllllIIIIIllllIIlIIllIl = llllllllllllllIIIIIllllIIlIIlIII.getBlockState(llllllllllllllIIIIIllllIIlIIIllI);
        if (llllllllllllllIIIIIllllIIlIIllIl == ConnectedTextures.AIR_DEFAULT_STATE) {
            return false;
        }
        if (llllllllllllllIIIIIllllIIlIIlIIl.matchBlocks != null && llllllllllllllIIIIIllllIIlIIllIl instanceof BlockStateBase) {
            final BlockStateBase llllllllllllllIIIIIllllIIlIIllII = (BlockStateBase)llllllllllllllIIIIIllllIIlIIllIl;
            if (!llllllllllllllIIIIIllllIIlIIlIIl.matchesBlock(llllllllllllllIIIIIllllIIlIIllII.getBlockId(), llllllllllllllIIIIIllllIIlIIllII.getMetadata())) {
                return false;
            }
        }
        if (llllllllllllllIIIIIllllIIlIIlIIl.matchTileIcons != null) {
            final TextureAtlasSprite llllllllllllllIIIIIllllIIlIIlIll = getNeighbourIcon(llllllllllllllIIIIIllllIIlIIlIII, llllllllllllllIIIIIllllIIlIlIIlI, llllllllllllllIIIIIllllIIlIIIllI, llllllllllllllIIIIIllllIIlIIllIl, llllllllllllllIIIIIllllIIlIlIIII);
            if (llllllllllllllIIIIIllllIIlIIlIll != llllllllllllllIIIIIllllIIlIIllll) {
                return false;
            }
        }
        final IBlockState llllllllllllllIIIIIllllIIlIIlIlI = llllllllllllllIIIIIllllIIlIIlIII.getBlockState(llllllllllllllIIIIIllllIIlIIIllI.offset(getFacing(llllllllllllllIIIIIllllIIlIlIIII)));
        return !llllllllllllllIIIIIllllIIlIIlIlI.isOpaqueCube() && (llllllllllllllIIIIIllllIIlIlIIII != 1 || llllllllllllllIIIIIllllIIlIIlIlI.getBlock() != Blocks.SNOW_LAYER);
    }
    
    private static BakedQuad[] getConnectedTexture(final ConnectedProperties llllllllllllllIIIIlIIIIIIlIlIIll, final IBlockAccess llllllllllllllIIIIlIIIIIIlIlIIlI, final BlockStateBase llllllllllllllIIIIlIIIIIIlIlIIIl, final BlockPos llllllllllllllIIIIlIIIIIIlIlIIII, final int llllllllllllllIIIIlIIIIIIlIIllll, final BakedQuad llllllllllllllIIIIlIIIIIIIlllllI, final int llllllllllllllIIIIlIIIIIIlIIllIl, final RenderEnv llllllllllllllIIIIlIIIIIIIllllII) {
        int llllllllllllllIIIIlIIIIIIlIIlIll = 0;
        int llllllllllllllIIIIlIIIIIIlIIlIIl;
        final int llllllllllllllIIIIlIIIIIIlIIlIlI = llllllllllllllIIIIlIIIIIIlIIlIIl = llllllllllllllIIIIlIIIIIIlIlIIIl.getMetadata();
        final Block llllllllllllllIIIIlIIIIIIlIIlIII = llllllllllllllIIIIlIIIIIIlIlIIIl.getBlock();
        if (llllllllllllllIIIIlIIIIIIlIIlIII instanceof BlockRotatedPillar) {
            llllllllllllllIIIIlIIIIIIlIIlIll = getWoodAxis(llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIlIlI);
            if (llllllllllllllIIIIlIIIIIIlIlIIll.getMetadataMax() <= 3) {
                llllllllllllllIIIIlIIIIIIlIIlIIl = (llllllllllllllIIIIlIIIIIIlIIlIlI & 0x3);
            }
        }
        if (llllllllllllllIIIIlIIIIIIlIIlIII instanceof BlockQuartz) {
            llllllllllllllIIIIlIIIIIIlIIlIll = getQuartzAxis(llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIlIlI);
            if (llllllllllllllIIIIlIIIIIIlIlIIll.getMetadataMax() <= 2 && llllllllllllllIIIIlIIIIIIlIIlIIl > 2) {
                llllllllllllllIIIIlIIIIIIlIIlIIl = 2;
            }
        }
        if (!llllllllllllllIIIIlIIIIIIlIlIIll.matchesBlock(llllllllllllllIIIIlIIIIIIlIlIIIl.getBlockId(), llllllllllllllIIIIlIIIIIIlIIlIIl)) {
            return null;
        }
        if (llllllllllllllIIIIlIIIIIIlIIllll >= 0 && llllllllllllllIIIIlIIIIIIlIlIIll.faces != 63) {
            int llllllllllllllIIIIlIIIIIIlIIIlll = llllllllllllllIIIIlIIIIIIlIIllll;
            if (llllllllllllllIIIIlIIIIIIlIIlIll != 0) {
                llllllllllllllIIIIlIIIIIIlIIIlll = fixSideByAxis(llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIlIll);
            }
            if ((1 << llllllllllllllIIIIlIIIIIIlIIIlll & llllllllllllllIIIIlIIIIIIlIlIIll.faces) == 0x0) {
                return null;
            }
        }
        final int llllllllllllllIIIIlIIIIIIlIIIllI = llllllllllllllIIIIlIIIIIIlIlIIII.getY();
        if (llllllllllllllIIIIlIIIIIIlIIIllI >= llllllllllllllIIIIlIIIIIIlIlIIll.minHeight && llllllllllllllIIIIlIIIIIIlIIIllI <= llllllllllllllIIIIlIIIIIIlIlIIll.maxHeight) {
            if (llllllllllllllIIIIlIIIIIIlIlIIll.biomes != null) {
                final Biome llllllllllllllIIIIlIIIIIIlIIIlIl = llllllllllllllIIIIlIIIIIIlIlIIlI.getBiome(llllllllllllllIIIIlIIIIIIlIlIIII);
                if (!llllllllllllllIIIIlIIIIIIlIlIIll.matchesBiome(llllllllllllllIIIIlIIIIIIlIIIlIl)) {
                    return null;
                }
            }
            final TextureAtlasSprite llllllllllllllIIIIlIIIIIIlIIIlII = llllllllllllllIIIIlIIIIIIIlllllI.getSprite();
            switch (llllllllllllllIIIIlIIIIIIlIlIIll.method) {
                case 1: {
                    return getQuads(getConnectedTextureCtm(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI, llllllllllllllIIIIlIIIIIIIllllII), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 2: {
                    return getQuads(getConnectedTextureHorizontal(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 3: {
                    return getQuads(getConnectedTextureTop(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 4: {
                    return getQuads(getConnectedTextureRandom(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIllll), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 5: {
                    return getQuads(getConnectedTextureRepeat(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIllll), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 6: {
                    return getQuads(getConnectedTextureVertical(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 7: {
                    return getQuads(getConnectedTextureFixed(llllllllllllllIIIIlIIIIIIlIlIIll), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 8: {
                    return getQuads(getConnectedTextureHorizontalVertical(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 9: {
                    return getQuads(getConnectedTextureVerticalHorizontal(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIlIIIlII, llllllllllllllIIIIlIIIIIIlIIlIlI), llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIIllllII);
                }
                case 10: {
                    if (llllllllllllllIIIIlIIIIIIlIIllIl == 0) {
                        return getConnectedTextureCtmCompact(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIlIIlIlI, llllllllllllllIIIIlIIIIIIIllllII);
                    }
                    break;
                }
                case 11: {
                    return getConnectedTextureOverlay(llllllllllllllIIIIlIIIIIIlIlIIll, llllllllllllllIIIIlIIIIIIlIlIIlI, llllllllllllllIIIIlIIIIIIlIlIIIl, llllllllllllllIIIIlIIIIIIlIlIIII, llllllllllllllIIIIlIIIIIIlIIlIll, llllllllllllllIIIIlIIIIIIlIIllll, llllllllllllllIIIIlIIIIIIIlllllI, llllllllllllllIIIIlIIIIIIlIIlIlI, llllllllllllllIIIIlIIIIIIIllllII);
                }
            }
            return null;
        }
        return null;
    }
    
    static {
        Y_NEG_DOWN = 0;
        X_AXIS = 2;
        Z_NEG_NORTH = 2;
        Z_POS_SOUTH = 3;
        Z_AXIS = 1;
        Y_AXIS = 0;
        UNKNOWN = -1;
        X_POS_EAST = 5;
        X_NEG_WEST = 4;
        Y_POS_UP = 1;
        ConnectedTextures.spriteQuadMaps = null;
        ConnectedTextures.spriteQuadFullMaps = null;
        ConnectedTextures.spriteQuadCompactMaps = null;
        ConnectedTextures.blockProperties = null;
        ConnectedTextures.tileProperties = null;
        ConnectedTextures.multipass = false;
        AIR_DEFAULT_STATE = Blocks.AIR.getDefaultState();
        ConnectedTextures.emptySprite = null;
        SIDES_Y_NEG_DOWN = new BlockDir[] { BlockDir.WEST, BlockDir.EAST, BlockDir.NORTH, BlockDir.SOUTH };
        SIDES_Y_POS_UP = new BlockDir[] { BlockDir.WEST, BlockDir.EAST, BlockDir.SOUTH, BlockDir.NORTH };
        SIDES_Z_NEG_NORTH = new BlockDir[] { BlockDir.EAST, BlockDir.WEST, BlockDir.DOWN, BlockDir.UP };
        SIDES_Z_POS_SOUTH = new BlockDir[] { BlockDir.WEST, BlockDir.EAST, BlockDir.DOWN, BlockDir.UP };
        SIDES_X_NEG_WEST = new BlockDir[] { BlockDir.NORTH, BlockDir.SOUTH, BlockDir.DOWN, BlockDir.UP };
        SIDES_X_POS_EAST = new BlockDir[] { BlockDir.SOUTH, BlockDir.NORTH, BlockDir.DOWN, BlockDir.UP };
        SIDES_Z_NEG_NORTH_Z_AXIS = new BlockDir[] { BlockDir.WEST, BlockDir.EAST, BlockDir.UP, BlockDir.DOWN };
        SIDES_X_POS_EAST_X_AXIS = new BlockDir[] { BlockDir.NORTH, BlockDir.SOUTH, BlockDir.UP, BlockDir.DOWN };
        EDGES_Y_NEG_DOWN = new BlockDir[] { BlockDir.NORTH_EAST, BlockDir.NORTH_WEST, BlockDir.SOUTH_EAST, BlockDir.SOUTH_WEST };
        EDGES_Y_POS_UP = new BlockDir[] { BlockDir.SOUTH_EAST, BlockDir.SOUTH_WEST, BlockDir.NORTH_EAST, BlockDir.NORTH_WEST };
        EDGES_Z_NEG_NORTH = new BlockDir[] { BlockDir.DOWN_WEST, BlockDir.DOWN_EAST, BlockDir.UP_WEST, BlockDir.UP_EAST };
        EDGES_Z_POS_SOUTH = new BlockDir[] { BlockDir.DOWN_EAST, BlockDir.DOWN_WEST, BlockDir.UP_EAST, BlockDir.UP_WEST };
        EDGES_X_NEG_WEST = new BlockDir[] { BlockDir.DOWN_SOUTH, BlockDir.DOWN_NORTH, BlockDir.UP_SOUTH, BlockDir.UP_NORTH };
        EDGES_X_POS_EAST = new BlockDir[] { BlockDir.DOWN_NORTH, BlockDir.DOWN_SOUTH, BlockDir.UP_NORTH, BlockDir.UP_SOUTH };
        EDGES_Z_NEG_NORTH_Z_AXIS = new BlockDir[] { BlockDir.UP_EAST, BlockDir.UP_WEST, BlockDir.DOWN_EAST, BlockDir.DOWN_WEST };
        EDGES_X_POS_EAST_X_AXIS = new BlockDir[] { BlockDir.UP_SOUTH, BlockDir.UP_NORTH, BlockDir.DOWN_SOUTH, BlockDir.DOWN_NORTH };
    }
    
    private static TextureAtlasSprite getConnectedTextureCtm(final ConnectedProperties llllllllllllllIIIIIllllllllIIIIl, final IBlockAccess llllllllllllllIIIIIlllllllIlIllI, final IBlockState llllllllllllllIIIIIlllllllIlllll, final BlockPos llllllllllllllIIIIIlllllllIlIlII, final int llllllllllllllIIIIIlllllllIlIIll, final int llllllllllllllIIIIIlllllllIlIIlI, final TextureAtlasSprite llllllllllllllIIIIIlllllllIllIll, final int llllllllllllllIIIIIlllllllIllIlI, final RenderEnv llllllllllllllIIIIIlllllllIllIIl) {
        final int llllllllllllllIIIIIlllllllIllIII = getConnectedTextureCtmIndex(llllllllllllllIIIIIllllllllIIIIl, llllllllllllllIIIIIlllllllIlIllI, llllllllllllllIIIIIlllllllIlllll, llllllllllllllIIIIIlllllllIlIlII, llllllllllllllIIIIIlllllllIlIIll, llllllllllllllIIIIIlllllllIlIIlI, llllllllllllllIIIIIlllllllIllIll, llllllllllllllIIIIIlllllllIllIlI, llllllllllllllIIIIIlllllllIllIIl);
        return llllllllllllllIIIIIllllllllIIIIl.tileIcons[llllllllllllllIIIIIlllllllIllIII];
    }
    
    private static boolean detectMultipass() {
        final List llllllllllllllIIIIIlllIIllllIllI = new ArrayList();
        for (int llllllllllllllIIIIIlllIIllllIlIl = 0; llllllllllllllIIIIIlllIIllllIlIl < ConnectedTextures.tileProperties.length; ++llllllllllllllIIIIIlllIIllllIlIl) {
            final ConnectedProperties[] llllllllllllllIIIIIlllIIllllIlII = ConnectedTextures.tileProperties[llllllllllllllIIIIIlllIIllllIlIl];
            if (llllllllllllllIIIIIlllIIllllIlII != null) {
                llllllllllllllIIIIIlllIIllllIllI.addAll(Arrays.asList(llllllllllllllIIIIIlllIIllllIlII));
            }
        }
        for (int llllllllllllllIIIIIlllIIllllIIll = 0; llllllllllllllIIIIIlllIIllllIIll < ConnectedTextures.blockProperties.length; ++llllllllllllllIIIIIlllIIllllIIll) {
            final ConnectedProperties[] llllllllllllllIIIIIlllIIllllIIlI = ConnectedTextures.blockProperties[llllllllllllllIIIIIlllIIllllIIll];
            if (llllllllllllllIIIIIlllIIllllIIlI != null) {
                llllllllllllllIIIIIlllIIllllIllI.addAll(Arrays.asList(llllllllllllllIIIIIlllIIllllIIlI));
            }
        }
        final ConnectedProperties[] llllllllllllllIIIIIlllIIllllIIIl = llllllllllllllIIIIIlllIIllllIllI.toArray(new ConnectedProperties[llllllllllllllIIIIIlllIIllllIllI.size()]);
        final Set llllllllllllllIIIIIlllIIllllIIII = new HashSet();
        final Set llllllllllllllIIIIIlllIIlllIllll = new HashSet();
        for (int llllllllllllllIIIIIlllIIlllIlllI = 0; llllllllllllllIIIIIlllIIlllIlllI < llllllllllllllIIIIIlllIIllllIIIl.length; ++llllllllllllllIIIIIlllIIlllIlllI) {
            final ConnectedProperties llllllllllllllIIIIIlllIIlllIllIl = llllllllllllllIIIIIlllIIllllIIIl[llllllllllllllIIIIIlllIIlllIlllI];
            if (llllllllllllllIIIIIlllIIlllIllIl.matchTileIcons != null) {
                llllllllllllllIIIIIlllIIllllIIII.addAll(Arrays.asList(llllllllllllllIIIIIlllIIlllIllIl.matchTileIcons));
            }
            if (llllllllllllllIIIIIlllIIlllIllIl.tileIcons != null) {
                llllllllllllllIIIIIlllIIlllIllll.addAll(Arrays.asList(llllllllllllllIIIIIlllIIlllIllIl.tileIcons));
            }
        }
        llllllllllllllIIIIIlllIIllllIIII.retainAll(llllllllllllllIIIIIlllIIlllIllll);
        return !llllllllllllllIIIIIlllIIllllIIII.isEmpty();
    }
    
    protected static BakedQuad[] getQuads(final TextureAtlasSprite llllllllllllllIIIIlIIIIlIIlIIlII, final BakedQuad llllllllllllllIIIIlIIIIlIIIllllI, final RenderEnv llllllllllllllIIIIlIIIIlIIlIIIlI) {
        if (llllllllllllllIIIIlIIIIlIIlIIlII == null) {
            return null;
        }
        final BakedQuad llllllllllllllIIIIlIIIIlIIlIIIIl = getQuad(llllllllllllllIIIIlIIIIlIIlIIlII, llllllllllllllIIIIlIIIIlIIIllllI);
        final BakedQuad[] llllllllllllllIIIIlIIIIlIIlIIIII = llllllllllllllIIIIlIIIIlIIlIIIlI.getArrayQuadsCtm(llllllllllllllIIIIlIIIIlIIlIIIIl);
        return llllllllllllllIIIIlIIIIlIIlIIIII;
    }
    
    public static int getSide(final EnumFacing llllllllllllllIIIIlIIIIIIllIIlIl) {
        if (llllllllllllllIIIIlIIIIIIllIIlIl == null) {
            return -1;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIlIIIIIIllIIlIl.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 6: {
                return 5;
            }
            case 5: {
                return 4;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
    
    private static int getQuartzAxis(final int llllllllllllllIIIIlIIIIIIIlIIlll, final int llllllllllllllIIIIlIIIIIIIlIIllI) {
        switch (llllllllllllllIIIIlIIIIIIIlIIllI) {
            case 3: {
                return 2;
            }
            case 4: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = ConnectedTextures.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllllIIIIIlllIIlIIlllll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIIlllIIlIIlllll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return ConnectedTextures.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIIlllIIlIIlllll;
    }
    
    private static BlockDir[] getSideDirections(final int llllllllllllllIIIIIllllIllIlIlII, final int llllllllllllllIIIIIllllIllIlIIlI) {
        switch (llllllllllllllIIIIIllllIllIlIlII) {
            case 0: {
                return ConnectedTextures.SIDES_Y_NEG_DOWN;
            }
            case 1: {
                return ConnectedTextures.SIDES_Y_POS_UP;
            }
            case 2: {
                if (llllllllllllllIIIIIllllIllIlIIlI == 1) {
                    return ConnectedTextures.SIDES_Z_NEG_NORTH_Z_AXIS;
                }
                return ConnectedTextures.SIDES_Z_NEG_NORTH;
            }
            case 3: {
                return ConnectedTextures.SIDES_Z_POS_SOUTH;
            }
            case 4: {
                return ConnectedTextures.SIDES_X_NEG_WEST;
            }
            case 5: {
                if (llllllllllllllIIIIIllllIllIlIIlI == 2) {
                    return ConnectedTextures.SIDES_X_POS_EAST_X_AXIS;
                }
                return ConnectedTextures.SIDES_X_POS_EAST;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown side: ").append(llllllllllllllIIIIIllllIllIlIlII)));
            }
        }
    }
    
    private static TextureAtlasSprite getConnectedTextureVertical(final ConnectedProperties llllllllllllllIIIIIlllIllIlIIlII, final IBlockAccess llllllllllllllIIIIIlllIllIlIlllI, final IBlockState llllllllllllllIIIIIlllIllIlIllIl, final BlockPos llllllllllllllIIIIIlllIllIlIllII, final int llllllllllllllIIIIIlllIllIlIIIII, final int llllllllllllllIIIIIlllIllIlIlIlI, final TextureAtlasSprite llllllllllllllIIIIIlllIllIlIlIIl, final int llllllllllllllIIIIIlllIllIlIlIII) {
        boolean llllllllllllllIIIIIlllIllIlIIlll = false;
        boolean llllllllllllllIIIIIlllIllIlIIllI = false;
        switch (llllllllllllllIIIIIlllIllIlIIIII) {
            case 0: {
                if (llllllllllllllIIIIIlllIllIlIlIlI == 1) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.south(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.north(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                if (llllllllllllllIIIIIlllIllIlIlIlI == 0) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.north(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.south(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.down(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.up(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                break;
            }
            case 1: {
                if (llllllllllllllIIIIIlllIllIlIlIlI == 3) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.down(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.up(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                if (llllllllllllllIIIIIlllIllIlIlIlI == 2) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.up(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.down(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.south(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.north(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                break;
            }
            case 2: {
                if (llllllllllllllIIIIIlllIllIlIlIlI == 5) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.up(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.down(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                if (llllllllllllllIIIIIlllIllIlIlIlI == 4) {
                    llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.down(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.up(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                    break;
                }
                llllllllllllllIIIIIlllIllIlIIlll = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.west(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                llllllllllllllIIIIIlllIllIlIIllI = isNeighbour(llllllllllllllIIIIIlllIllIlIIlII, llllllllllllllIIIIIlllIllIlIlllI, llllllllllllllIIIIIlllIllIlIllIl, llllllllllllllIIIIIlllIllIlIllII.east(), llllllllllllllIIIIIlllIllIlIlIlI, llllllllllllllIIIIIlllIllIlIlIIl, llllllllllllllIIIIIlllIllIlIlIII);
                break;
            }
        }
        int llllllllllllllIIIIIlllIllIlIIlIl = 3;
        if (llllllllllllllIIIIIlllIllIlIIlll) {
            if (llllllllllllllIIIIIlllIllIlIIllI) {
                llllllllllllllIIIIIlllIllIlIIlIl = 1;
            }
            else {
                llllllllllllllIIIIIlllIllIlIIlIl = 2;
            }
        }
        else if (llllllllllllllIIIIIlllIllIlIIllI) {
            llllllllllllllIIIIIlllIllIlIIlIl = 0;
        }
        else {
            llllllllllllllIIIIIlllIllIlIIlIl = 3;
        }
        return llllllllllllllIIIIIlllIllIlIIlII.tileIcons[llllllllllllllIIIIIlllIllIlIIlIl];
    }
    
    private static List makePropertyList(final ConnectedProperties[][] llllllllllllllIIIIIlllIlIIIIIllI) {
        final List llllllllllllllIIIIIlllIlIIIIIlIl = new ArrayList();
        if (llllllllllllllIIIIIlllIlIIIIIllI != null) {
            for (int llllllllllllllIIIIIlllIlIIIIIlII = 0; llllllllllllllIIIIIlllIlIIIIIlII < llllllllllllllIIIIIlllIlIIIIIllI.length; ++llllllllllllllIIIIIlllIlIIIIIlII) {
                final ConnectedProperties[] llllllllllllllIIIIIlllIlIIIIIIll = llllllllllllllIIIIIlllIlIIIIIllI[llllllllllllllIIIIIlllIlIIIIIlII];
                List llllllllllllllIIIIIlllIlIIIIIIlI = null;
                if (llllllllllllllIIIIIlllIlIIIIIIll != null) {
                    llllllllllllllIIIIIlllIlIIIIIIlI = new ArrayList(Arrays.asList(llllllllllllllIIIIIlllIlIIIIIIll));
                }
                llllllllllllllIIIIIlllIlIIIIIlIl.add(llllllllllllllIIIIIlllIlIIIIIIlI);
            }
        }
        return llllllllllllllIIIIIlllIlIIIIIlIl;
    }
    
    private static BakedQuad[] getConnectedTextureCtmCompact(final ConnectedProperties llllllllllllllIIIIIlllllllIIIIlI, final IBlockAccess llllllllllllllIIIIIlllllllIIIIIl, final IBlockState llllllllllllllIIIIIlllllllIIIIII, final BlockPos llllllllllllllIIIIIllllllIllIlII, final int llllllllllllllIIIIIllllllIlllllI, final int llllllllllllllIIIIIllllllIllIIlI, final BakedQuad llllllllllllllIIIIIllllllIllllII, final int llllllllllllllIIIIIllllllIlllIll, final RenderEnv llllllllllllllIIIIIllllllIlIllll) {
        final TextureAtlasSprite llllllllllllllIIIIIllllllIlllIIl = llllllllllllllIIIIIllllllIllllII.getSprite();
        final int llllllllllllllIIIIIllllllIlllIII = getConnectedTextureCtmIndex(llllllllllllllIIIIIlllllllIIIIlI, llllllllllllllIIIIIlllllllIIIIIl, llllllllllllllIIIIIlllllllIIIIII, llllllllllllllIIIIIllllllIllIlII, llllllllllllllIIIIIllllllIlllllI, llllllllllllllIIIIIllllllIllIIlI, llllllllllllllIIIIIllllllIlllIIl, llllllllllllllIIIIIllllllIlllIll, llllllllllllllIIIIIllllllIlIllll);
        return ConnectedTexturesCompact.getConnectedTextureCtmCompact(llllllllllllllIIIIIllllllIlllIII, llllllllllllllIIIIIlllllllIIIIlI, llllllllllllllIIIIIllllllIllIIlI, llllllllllllllIIIIIllllllIllllII, llllllllllllllIIIIIllllllIlIllll);
    }
    
    private static BakedQuad getQuad(final TextureAtlasSprite llllllllllllllIIIIlIIIIlIIIlIlIl, final BakedQuad llllllllllllllIIIIlIIIIlIIIIllll) {
        if (ConnectedTextures.spriteQuadMaps == null) {
            return llllllllllllllIIIIlIIIIlIIIIllll;
        }
        final int llllllllllllllIIIIlIIIIlIIIlIIll = llllllllllllllIIIIlIIIIlIIIlIlIl.getIndexInMap();
        if (llllllllllllllIIIIlIIIIlIIIlIIll >= 0 && llllllllllllllIIIIlIIIIlIIIlIIll < ConnectedTextures.spriteQuadMaps.length) {
            Map llllllllllllllIIIIlIIIIlIIIlIIlI = ConnectedTextures.spriteQuadMaps[llllllllllllllIIIIlIIIIlIIIlIIll];
            if (llllllllllllllIIIIlIIIIlIIIlIIlI == null) {
                llllllllllllllIIIIlIIIIlIIIlIIlI = new IdentityHashMap(1);
                ConnectedTextures.spriteQuadMaps[llllllllllllllIIIIlIIIIlIIIlIIll] = llllllllllllllIIIIlIIIIlIIIlIIlI;
            }
            BakedQuad llllllllllllllIIIIlIIIIlIIIlIIIl = llllllllllllllIIIIlIIIIlIIIlIIlI.get(llllllllllllllIIIIlIIIIlIIIIllll);
            if (llllllllllllllIIIIlIIIIlIIIlIIIl == null) {
                llllllllllllllIIIIlIIIIlIIIlIIIl = makeSpriteQuad(llllllllllllllIIIIlIIIIlIIIIllll, llllllllllllllIIIIlIIIIlIIIlIlIl);
                llllllllllllllIIIIlIIIIlIIIlIIlI.put(llllllllllllllIIIIlIIIIlIIIIllll, llllllllllllllIIIIlIIIIlIIIlIIIl);
            }
            return llllllllllllllIIIIlIIIIlIIIlIIIl;
        }
        return llllllllllllllIIIIlIIIIlIIIIllll;
    }
    
    private static TextureAtlasSprite getConnectedTextureRandom(final ConnectedProperties llllllllllllllIIIIlIIIIIIIIlIIlI, final BlockPos llllllllllllllIIIIlIIIIIIIIllIlI, final int llllllllllllllIIIIlIIIIIIIIllIIl) {
        if (llllllllllllllIIIIlIIIIIIIIlIIlI.tileIcons.length == 1) {
            return llllllllllllllIIIIlIIIIIIIIlIIlI.tileIcons[0];
        }
        final int llllllllllllllIIIIlIIIIIIIIllIII = llllllllllllllIIIIlIIIIIIIIllIIl / llllllllllllllIIIIlIIIIIIIIlIIlI.symmetry * llllllllllllllIIIIlIIIIIIIIlIIlI.symmetry;
        final int llllllllllllllIIIIlIIIIIIIIlIlll = Config.getRandom(llllllllllllllIIIIlIIIIIIIIllIlI, llllllllllllllIIIIlIIIIIIIIllIII) & Integer.MAX_VALUE;
        int llllllllllllllIIIIlIIIIIIIIlIllI = 0;
        if (llllllllllllllIIIIlIIIIIIIIlIIlI.weights == null) {
            llllllllllllllIIIIlIIIIIIIIlIllI = llllllllllllllIIIIlIIIIIIIIlIlll % llllllllllllllIIIIlIIIIIIIIlIIlI.tileIcons.length;
        }
        else {
            final int llllllllllllllIIIIlIIIIIIIIlIlIl = llllllllllllllIIIIlIIIIIIIIlIlll % llllllllllllllIIIIlIIIIIIIIlIIlI.sumAllWeights;
            final int[] llllllllllllllIIIIlIIIIIIIIlIlII = llllllllllllllIIIIlIIIIIIIIlIIlI.sumWeights;
            for (int llllllllllllllIIIIlIIIIIIIIlIIll = 0; llllllllllllllIIIIlIIIIIIIIlIIll < llllllllllllllIIIIlIIIIIIIIlIlII.length; ++llllllllllllllIIIIlIIIIIIIIlIIll) {
                if (llllllllllllllIIIIlIIIIIIIIlIlIl < llllllllllllllIIIIlIIIIIIIIlIlII[llllllllllllllIIIIlIIIIIIIIlIIll]) {
                    llllllllllllllIIIIlIIIIIIIIlIllI = llllllllllllllIIIIlIIIIIIIIlIIll;
                    break;
                }
            }
        }
        return llllllllllllllIIIIlIIIIIIIIlIIlI.tileIcons[llllllllllllllIIIIlIIIIIIIIlIllI];
    }
    
    private static int getWoodAxis(final int llllllllllllllIIIIlIIIIIIIlIllIl, final int llllllllllllllIIIIlIIIIIIIlIllII) {
        final int llllllllllllllIIIIlIIIIIIIlIlIll = (llllllllllllllIIIIlIIIIIIIlIllII & 0xC) >> 2;
        switch (llllllllllllllIIIIlIIIIIIIlIlIll) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
    
    private static BakedQuad makeSpriteQuad(final BakedQuad llllllllllllllIIIIlIIIIIllllIIIl, final TextureAtlasSprite llllllllllllllIIIIlIIIIIllllIIII) {
        final int[] llllllllllllllIIIIlIIIIIlllIllll = llllllllllllllIIIIlIIIIIllllIIIl.getVertexData().clone();
        final TextureAtlasSprite llllllllllllllIIIIlIIIIIlllIlllI = llllllllllllllIIIIlIIIIIllllIIIl.getSprite();
        for (int llllllllllllllIIIIlIIIIIlllIllIl = 0; llllllllllllllIIIIlIIIIIlllIllIl < 4; ++llllllllllllllIIIIlIIIIIlllIllIl) {
            fixVertex(llllllllllllllIIIIlIIIIIlllIllll, llllllllllllllIIIIlIIIIIlllIllIl, llllllllllllllIIIIlIIIIIlllIlllI, llllllllllllllIIIIlIIIIIllllIIII);
        }
        final BakedQuad llllllllllllllIIIIlIIIIIlllIllII = new BakedQuad(llllllllllllllIIIIlIIIIIlllIllll, llllllllllllllIIIIlIIIIIllllIIIl.getTintIndex(), llllllllllllllIIIIlIIIIIllllIIIl.getFace(), llllllllllllllIIIIlIIIIIllllIIII);
        return llllllllllllllIIIIlIIIIIlllIllII;
    }
    
    private static TextureAtlasSprite getConnectedTextureTop(final ConnectedProperties llllllllllllllIIIIIlllIlIlIIIlIl, final IBlockAccess llllllllllllllIIIIIlllIlIlIIIlII, final IBlockState llllllllllllllIIIIIlllIlIlIIIIll, final BlockPos llllllllllllllIIIIIlllIlIlIIIIlI, final int llllllllllllllIIIIIlllIlIlIIlIlI, final int llllllllllllllIIIIIlllIlIlIIlIIl, final TextureAtlasSprite llllllllllllllIIIIIlllIlIlIIlIII, final int llllllllllllllIIIIIlllIlIlIIIlll) {
        boolean llllllllllllllIIIIIlllIlIlIIIllI = false;
        switch (llllllllllllllIIIIIlllIlIlIIlIlI) {
            case 0: {
                if (llllllllllllllIIIIIlllIlIlIIlIIl == 1 || llllllllllllllIIIIIlllIlIlIIlIIl == 0) {
                    return null;
                }
                llllllllllllllIIIIIlllIlIlIIIllI = isNeighbour(llllllllllllllIIIIIlllIlIlIIIlIl, llllllllllllllIIIIIlllIlIlIIIlII, llllllllllllllIIIIIlllIlIlIIIIll, llllllllllllllIIIIIlllIlIlIIIIlI.up(), llllllllllllllIIIIIlllIlIlIIlIIl, llllllllllllllIIIIIlllIlIlIIlIII, llllllllllllllIIIIIlllIlIlIIIlll);
                break;
            }
            case 1: {
                if (llllllllllllllIIIIIlllIlIlIIlIIl == 3 || llllllllllllllIIIIIlllIlIlIIlIIl == 2) {
                    return null;
                }
                llllllllllllllIIIIIlllIlIlIIIllI = isNeighbour(llllllllllllllIIIIIlllIlIlIIIlIl, llllllllllllllIIIIIlllIlIlIIIlII, llllllllllllllIIIIIlllIlIlIIIIll, llllllllllllllIIIIIlllIlIlIIIIlI.south(), llllllllllllllIIIIIlllIlIlIIlIIl, llllllllllllllIIIIIlllIlIlIIlIII, llllllllllllllIIIIIlllIlIlIIIlll);
                break;
            }
            case 2: {
                if (llllllllllllllIIIIIlllIlIlIIlIIl == 5 || llllllllllllllIIIIIlllIlIlIIlIIl == 4) {
                    return null;
                }
                llllllllllllllIIIIIlllIlIlIIIllI = isNeighbour(llllllllllllllIIIIIlllIlIlIIIlIl, llllllllllllllIIIIIlllIlIlIIIlII, llllllllllllllIIIIIlllIlIlIIIIll, llllllllllllllIIIIIlllIlIlIIIIlI.east(), llllllllllllllIIIIIlllIlIlIIlIIl, llllllllllllllIIIIIlllIlIlIIlIII, llllllllllllllIIIIIlllIlIlIIIlll);
                break;
            }
        }
        if (llllllllllllllIIIIIlllIlIlIIIllI) {
            return llllllllllllllIIIIIlllIlIlIIIlIl.tileIcons[0];
        }
        return null;
    }
    
    private static BakedQuad getQuadFull(final TextureAtlasSprite llllllllllllllIIIIlIIIIIllllllIl, final BakedQuad llllllllllllllIIIIlIIIIlIIIIIIll, final int llllllllllllllIIIIlIIIIlIIIIIIlI) {
        if (ConnectedTextures.spriteQuadFullMaps == null) {
            return llllllllllllllIIIIlIIIIlIIIIIIll;
        }
        final int llllllllllllllIIIIlIIIIlIIIIIIIl = llllllllllllllIIIIlIIIIIllllllIl.getIndexInMap();
        if (llllllllllllllIIIIlIIIIlIIIIIIIl >= 0 && llllllllllllllIIIIlIIIIlIIIIIIIl < ConnectedTextures.spriteQuadFullMaps.length) {
            Map llllllllllllllIIIIlIIIIlIIIIIIII = ConnectedTextures.spriteQuadFullMaps[llllllllllllllIIIIlIIIIlIIIIIIIl];
            if (llllllllllllllIIIIlIIIIlIIIIIIII == null) {
                llllllllllllllIIIIlIIIIlIIIIIIII = new EnumMap(EnumFacing.class);
                ConnectedTextures.spriteQuadFullMaps[llllllllllllllIIIIlIIIIlIIIIIIIl] = llllllllllllllIIIIlIIIIlIIIIIIII;
            }
            final EnumFacing llllllllllllllIIIIlIIIIIllllllll = llllllllllllllIIIIlIIIIlIIIIIIll.getFace();
            BakedQuad llllllllllllllIIIIlIIIIIlllllllI = llllllllllllllIIIIlIIIIlIIIIIIII.get(llllllllllllllIIIIlIIIIIllllllll);
            if (llllllllllllllIIIIlIIIIIlllllllI == null) {
                llllllllllllllIIIIlIIIIIlllllllI = BlockModelUtils.makeBakedQuad(llllllllllllllIIIIlIIIIIllllllll, llllllllllllllIIIIlIIIIIllllllIl, llllllllllllllIIIIlIIIIlIIIIIIlI);
                llllllllllllllIIIIlIIIIlIIIIIIII.put(llllllllllllllIIIIlIIIIIllllllll, llllllllllllllIIIIlIIIIIlllllllI);
            }
            return llllllllllllllIIIIlIIIIIlllllllI;
        }
        return llllllllllllllIIIIlIIIIlIIIIIIll;
    }
    
    private static TextureAtlasSprite getConnectedTextureHorizontal(final ConnectedProperties llllllllllllllIIIIIlllIlllIIIlIl, final IBlockAccess llllllllllllllIIIIIlllIlllIlIIII, final IBlockState llllllllllllllIIIIIlllIlllIIlllI, final BlockPos llllllllllllllIIIIIlllIlllIIIIlI, final int llllllllllllllIIIIIlllIlllIIIIIl, final int llllllllllllllIIIIIlllIlllIIlIll, final TextureAtlasSprite llllllllllllllIIIIIlllIlllIIlIlI, final int llllllllllllllIIIIIlllIlllIIlIIl) {
        boolean llllllllllllllIIIIIlllIlllIIlIII = false;
        boolean llllllllllllllIIIIIlllIlllIIIlll = false;
        Label_0859: {
            switch (llllllllllllllIIIIIlllIlllIIIIIl) {
                case 0: {
                    switch (llllllllllllllIIIIIlllIlllIIlIll) {
                        case 0: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 1: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 2: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 3: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 4: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 5: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (llllllllllllllIIIIIlllIlllIIlIll) {
                        case 0: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 1: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 2: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 3: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.west(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.east(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 4: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.down(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.up(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                        case 5: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.up(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.down(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (llllllllllllllIIIIIlllIlllIIlIll) {
                        case 0: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                        case 1: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                        case 2: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.down(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.up(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                        case 3: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.up(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.down(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                        case 4: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                        case 5: {
                            llllllllllllllIIIIIlllIlllIIlIII = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.north(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            llllllllllllllIIIIIlllIlllIIIlll = isNeighbour(llllllllllllllIIIIIlllIlllIIIlIl, llllllllllllllIIIIIlllIlllIlIIII, llllllllllllllIIIIIlllIlllIIlllI, llllllllllllllIIIIIlllIlllIIIIlI.south(), llllllllllllllIIIIIlllIlllIIlIll, llllllllllllllIIIIIlllIlllIIlIlI, llllllllllllllIIIIIlllIlllIIlIIl);
                            break Label_0859;
                        }
                    }
                    break;
                }
            }
        }
        int llllllllllllllIIIIIlllIlllIIIllI = 3;
        if (llllllllllllllIIIIIlllIlllIIlIII) {
            if (llllllllllllllIIIIIlllIlllIIIlll) {
                llllllllllllllIIIIIlllIlllIIIllI = 1;
            }
            else {
                llllllllllllllIIIIIlllIlllIIIllI = 2;
            }
        }
        else if (llllllllllllllIIIIIlllIlllIIIlll) {
            llllllllllllllIIIIIlllIlllIIIllI = 0;
        }
        else {
            llllllllllllllIIIIIlllIlllIIIllI = 3;
        }
        return llllllllllllllIIIIIlllIlllIIIlIl.tileIcons[llllllllllllllIIIIIlllIlllIIIllI];
    }
    
    public static void updateIcons(final TextureMap llllllllllllllIIIIIlllIlIIllIIll) {
        ConnectedTextures.blockProperties = null;
        ConnectedTextures.tileProperties = null;
        ConnectedTextures.spriteQuadMaps = null;
        ConnectedTextures.spriteQuadCompactMaps = null;
        if (Config.isConnectedTextures()) {
            final IResourcePack[] llllllllllllllIIIIIlllIlIIllIlll = Config.getResourcePacks();
            for (int llllllllllllllIIIIIlllIlIIllIllI = llllllllllllllIIIIIlllIlIIllIlll.length - 1; llllllllllllllIIIIIlllIlIIllIllI >= 0; --llllllllllllllIIIIIlllIlIIllIllI) {
                final IResourcePack llllllllllllllIIIIIlllIlIIllIlIl = llllllllllllllIIIIIlllIlIIllIlll[llllllllllllllIIIIIlllIlIIllIllI];
                updateIcons(llllllllllllllIIIIIlllIlIIllIIll, llllllllllllllIIIIIlllIlIIllIlIl);
            }
            updateIcons(llllllllllllllIIIIIlllIlIIllIIll, Config.getDefaultResourcePack());
            final ResourceLocation llllllllllllllIIIIIlllIlIIllIlII = new ResourceLocation("mcpatcher/ctm/default/empty");
            ConnectedTextures.emptySprite = llllllllllllllIIIIIlllIlIIllIIll.registerSprite(llllllllllllllIIIIIlllIlIIllIlII);
            ConnectedTextures.spriteQuadMaps = new Map[llllllllllllllIIIIIlllIlIIllIIll.getCountRegisteredSprites() + 1];
            ConnectedTextures.spriteQuadFullMaps = new Map[llllllllllllllIIIIIlllIlIIllIIll.getCountRegisteredSprites() + 1];
            ConnectedTextures.spriteQuadCompactMaps = new Map[llllllllllllllIIIIIlllIlIIllIIll.getCountRegisteredSprites() + 1][];
            if (ConnectedTextures.blockProperties.length <= 0) {
                ConnectedTextures.blockProperties = null;
            }
            if (ConnectedTextures.tileProperties.length <= 0) {
                ConnectedTextures.tileProperties = null;
            }
        }
    }
    
    protected static Map[][] getSpriteQuadCompactMaps() {
        return ConnectedTextures.spriteQuadCompactMaps;
    }
    
    private static boolean skipConnectedTexture(final IBlockAccess llllllllllllllIIIIlIIIIlIIlllllI, final IBlockState llllllllllllllIIIIlIIIIlIIllllIl, final BlockPos llllllllllllllIIIIlIIIIlIIllllII, final BakedQuad llllllllllllllIIIIlIIIIlIIllIIII, final RenderEnv llllllllllllllIIIIlIIIIlIIlllIlI) {
        final Block llllllllllllllIIIIlIIIIlIIlllIIl = llllllllllllllIIIIlIIIIlIIllllIl.getBlock();
        if (llllllllllllllIIIIlIIIIlIIlllIIl instanceof BlockPane) {
            final EnumFacing llllllllllllllIIIIlIIIIlIIlllIII = llllllllllllllIIIIlIIIIlIIllIIII.getFace();
            if (llllllllllllllIIIIlIIIIlIIlllIII != EnumFacing.UP && llllllllllllllIIIIlIIIIlIIlllIII != EnumFacing.DOWN) {
                return false;
            }
            if (!llllllllllllllIIIIlIIIIlIIllIIII.isFaceQuad()) {
                return false;
            }
            final BlockPos llllllllllllllIIIIlIIIIlIIllIlll = llllllllllllllIIIIlIIIIlIIllllII.offset(llllllllllllllIIIIlIIIIlIIllIIII.getFace());
            IBlockState llllllllllllllIIIIlIIIIlIIllIllI = llllllllllllllIIIIlIIIIlIIlllllI.getBlockState(llllllllllllllIIIIlIIIIlIIllIlll);
            if (llllllllllllllIIIIlIIIIlIIllIllI.getBlock() != llllllllllllllIIIIlIIIIlIIlllIIl) {
                return false;
            }
            if (llllllllllllllIIIIlIIIIlIIlllIIl == Blocks.STAINED_GLASS_PANE && llllllllllllllIIIIlIIIIlIIllIllI.getValue(BlockStainedGlassPane.COLOR) != llllllllllllllIIIIlIIIIlIIllllIl.getValue(BlockStainedGlassPane.COLOR)) {
                return false;
            }
            llllllllllllllIIIIlIIIIlIIllIllI = llllllllllllllIIIIlIIIIlIIllIllI.getActualState(llllllllllllllIIIIlIIIIlIIlllllI, llllllllllllllIIIIlIIIIlIIllIlll);
            final double llllllllllllllIIIIlIIIIlIIllIlIl = llllllllllllllIIIIlIIIIlIIllIIII.getMidX();
            if (llllllllllllllIIIIlIIIIlIIllIlIl < 0.4) {
                if (llllllllllllllIIIIlIIIIlIIllIllI.getValue((IProperty<Boolean>)BlockPane.WEST)) {
                    return true;
                }
            }
            else if (llllllllllllllIIIIlIIIIlIIllIlIl > 0.6) {
                if (llllllllllllllIIIIlIIIIlIIllIllI.getValue((IProperty<Boolean>)BlockPane.EAST)) {
                    return true;
                }
            }
            else {
                final double llllllllllllllIIIIlIIIIlIIllIlII = llllllllllllllIIIIlIIIIlIIllIIII.getMidZ();
                if (llllllllllllllIIIIlIIIIlIIllIlII < 0.4) {
                    if (llllllllllllllIIIIlIIIIlIIllIllI.getValue((IProperty<Boolean>)BlockPane.NORTH)) {
                        return true;
                    }
                }
                else {
                    if (llllllllllllllIIIIlIIIIlIIllIlII <= 0.6) {
                        return true;
                    }
                    if (llllllllllllllIIIIlIIIIlIIllIllI.getValue((IProperty<Boolean>)BlockPane.SOUTH)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
