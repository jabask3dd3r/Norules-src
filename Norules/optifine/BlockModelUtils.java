package optifine;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import java.util.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.renderer.block.model.*;

public class BlockModelUtils
{
    private static float snapVertexCoord(final float lllllllllllllIIIIIIlIlIIlIIlIIlI) {
        if (lllllllllllllIIIIIIlIlIIlIIlIIlI > -1.0E-6f && lllllllllllllIIIIIIlIlIIlIIlIIlI < 1.0E-6f) {
            return 0.0f;
        }
        return (lllllllllllllIIIIIIlIlIIlIIlIIlI > 0.999999f && lllllllllllllIIIIIIlIlIIlIIlIIlI < 1.000001f) ? 1.0f : lllllllllllllIIIIIIlIlIIlIIlIIlI;
    }
    
    public static IBakedModel makeModel(final String lllllllllllllIIIIIIlIlIIllIllllI, final TextureAtlasSprite lllllllllllllIIIIIIlIlIIllIlllII, final TextureAtlasSprite lllllllllllllIIIIIIlIlIIllIIIllI) {
        if (lllllllllllllIIIIIIlIlIIllIlllII == null || lllllllllllllIIIIIIlIlIIllIIIllI == null) {
            return null;
        }
        final ModelManager lllllllllllllIIIIIIlIlIIllIllIIl = Config.getModelManager();
        if (lllllllllllllIIIIIIlIlIIllIllIIl == null) {
            return null;
        }
        final ModelResourceLocation lllllllllllllIIIIIIlIlIIllIlIlll = new ModelResourceLocation(lllllllllllllIIIIIIlIlIIllIllllI, "normal");
        final IBakedModel lllllllllllllIIIIIIlIlIIllIlIlIl = lllllllllllllIIIIIIlIlIIllIllIIl.getModel(lllllllllllllIIIIIIlIlIIllIlIlll);
        if (lllllllllllllIIIIIIlIlIIllIlIlIl != null && lllllllllllllIIIIIIlIlIIllIlIlIl != lllllllllllllIIIIIIlIlIIllIllIIl.getMissingModel()) {
            final IBakedModel lllllllllllllIIIIIIlIlIIllIlIlII = ModelUtils.duplicateModel(lllllllllllllIIIIIIlIlIIllIlIlIl);
            final EnumFacing[] lllllllllllllIIIIIIlIlIIllIlIIll = EnumFacing.VALUES;
            for (int lllllllllllllIIIIIIlIlIIllIlIIIl = 0; lllllllllllllIIIIIIlIlIIllIlIIIl < lllllllllllllIIIIIIlIlIIllIlIIll.length; ++lllllllllllllIIIIIIlIlIIllIlIIIl) {
                final EnumFacing lllllllllllllIIIIIIlIlIIllIIllll = lllllllllllllIIIIIIlIlIIllIlIIll[lllllllllllllIIIIIIlIlIIllIlIIIl];
                final List<BakedQuad> lllllllllllllIIIIIIlIlIIllIIllIl = lllllllllllllIIIIIIlIlIIllIlIlII.getQuads(null, lllllllllllllIIIIIIlIlIIllIIllll, 0L);
                replaceTexture(lllllllllllllIIIIIIlIlIIllIIllIl, lllllllllllllIIIIIIlIlIIllIlllII, lllllllllllllIIIIIIlIlIIllIIIllI);
            }
            final List<BakedQuad> lllllllllllllIIIIIIlIlIIllIIlIll = lllllllllllllIIIIIIlIlIIllIlIlII.getQuads(null, null, 0L);
            replaceTexture(lllllllllllllIIIIIIlIlIIllIIlIll, lllllllllllllIIIIIIlIlIIllIlllII, lllllllllllllIIIIIIlIlIIllIIIllI);
            return lllllllllllllIIIIIIlIlIIllIlIlII;
        }
        return null;
    }
    
    public static IBakedModel makeModel(final String lllllllllllllIIIIIIlIlIIllllllII, final String lllllllllllllIIIIIIlIlIIllllIlIl, final String lllllllllllllIIIIIIlIlIIllllIlII) {
        final TextureMap lllllllllllllIIIIIIlIlIIlllllIIl = Config.getMinecraft().getTextureMapBlocks();
        final TextureAtlasSprite lllllllllllllIIIIIIlIlIIlllllIII = lllllllllllllIIIIIIlIlIIlllllIIl.getSpriteSafe(lllllllllllllIIIIIIlIlIIllllIlIl);
        final TextureAtlasSprite lllllllllllllIIIIIIlIlIIllllIlll = lllllllllllllIIIIIIlIlIIlllllIIl.getSpriteSafe(lllllllllllllIIIIIIlIlIIllllIlII);
        return makeModel(lllllllllllllIIIIIIlIlIIllllllII, lllllllllllllIIIIIIlIlIIlllllIII, lllllllllllllIIIIIIlIlIIllllIlll);
    }
    
    private static void replaceTexture(final List<BakedQuad> lllllllllllllIIIIIIlIlIIlIlIlIII, final TextureAtlasSprite lllllllllllllIIIIIIlIlIIlIlIIllI, final TextureAtlasSprite lllllllllllllIIIIIIlIlIIlIIlllII) {
        final List<BakedQuad> lllllllllllllIIIIIIlIlIIlIlIIIll = new ArrayList<BakedQuad>();
        for (final BakedQuad lllllllllllllIIIIIIlIlIIlIlIIIlI : lllllllllllllIIIIIIlIlIIlIlIlIII) {
            if (lllllllllllllIIIIIIlIlIIlIlIIIlI.getSprite() != lllllllllllllIIIIIIlIlIIlIlIIllI) {
                lllllllllllllIIIIIIlIlIIlIlIIIll.add(lllllllllllllIIIIIIlIlIIlIlIIIlI);
                break;
            }
            final BakedQuad lllllllllllllIIIIIIlIlIIlIlIIIIl = new BakedQuadRetextured(lllllllllllllIIIIIIlIlIIlIlIIIlI, lllllllllllllIIIIIIlIlIIlIIlllII);
            lllllllllllllIIIIIIlIlIIlIlIIIll.add(lllllllllllllIIIIIIlIlIIlIlIIIIl);
        }
        lllllllllllllIIIIIIlIlIIlIlIlIII.clear();
        lllllllllllllIIIIIIlIlIIlIlIlIII.addAll(lllllllllllllIIIIIIlIlIIlIlIIIll);
    }
    
    public static IBakedModel makeModelCube(final String lllllllllllllIIIIIIlIlIlIllIllIl, final int lllllllllllllIIIIIIlIlIlIllIlIIl) {
        final TextureAtlasSprite lllllllllllllIIIIIIlIlIlIllIlIll = Config.getMinecraft().getTextureMapBlocks().getAtlasSprite(lllllllllllllIIIIIIlIlIlIllIllIl);
        return makeModelCube(lllllllllllllIIIIIIlIlIlIllIlIll, lllllllllllllIIIIIIlIlIlIllIlIIl);
    }
    
    public static AxisAlignedBB getOffsetBoundingBox(final AxisAlignedBB lllllllllllllIIIIIIlIlIIIlllllll, final Block.EnumOffsetType lllllllllllllIIIIIIlIlIIIllllllI, final BlockPos lllllllllllllIIIIIIlIlIIIlllllIl) {
        final int lllllllllllllIIIIIIlIlIIlIIIIlIl = lllllllllllllIIIIIIlIlIIIlllllIl.getX();
        final int lllllllllllllIIIIIIlIlIIlIIIIlII = lllllllllllllIIIIIIlIlIIIlllllIl.getZ();
        long lllllllllllllIIIIIIlIlIIlIIIIIll = (long)(lllllllllllllIIIIIIlIlIIlIIIIlIl * 3129871) ^ lllllllllllllIIIIIIlIlIIlIIIIlII * 116129781L;
        lllllllllllllIIIIIIlIlIIlIIIIIll = lllllllllllllIIIIIIlIlIIlIIIIIll * lllllllllllllIIIIIIlIlIIlIIIIIll * 42317861L + lllllllllllllIIIIIIlIlIIlIIIIIll * 11L;
        final double lllllllllllllIIIIIIlIlIIlIIIIIlI = ((lllllllllllllIIIIIIlIlIIlIIIIIll >> 16 & 0xFL) / 15.0f - 0.5) * 0.5;
        final double lllllllllllllIIIIIIlIlIIlIIIIIIl = ((lllllllllllllIIIIIIlIlIIlIIIIIll >> 24 & 0xFL) / 15.0f - 0.5) * 0.5;
        double lllllllllllllIIIIIIlIlIIlIIIIIII = 0.0;
        if (lllllllllllllIIIIIIlIlIIIllllllI == Block.EnumOffsetType.XYZ) {
            lllllllllllllIIIIIIlIlIIlIIIIIII = ((lllllllllllllIIIIIIlIlIIlIIIIIll >> 20 & 0xFL) / 15.0f - 1.0) * 0.2;
        }
        return lllllllllllllIIIIIIlIlIIIlllllll.offset(lllllllllllllIIIIIIlIlIIlIIIIIlI, lllllllllllllIIIIIIlIlIIlIIIIIII, lllllllllllllIIIIIIlIlIIlIIIIIIl);
    }
    
    public static IBakedModel makeModelCube(final TextureAtlasSprite lllllllllllllIIIIIIlIlIlIlIlIlIl, final int lllllllllllllIIIIIIlIlIlIlIlIlII) {
        final List lllllllllllllIIIIIIlIlIlIlIlllIl = new ArrayList();
        final EnumFacing[] lllllllllllllIIIIIIlIlIlIlIlllII = EnumFacing.VALUES;
        final Map<EnumFacing, List<BakedQuad>> lllllllllllllIIIIIIlIlIlIlIllIll = new HashMap<EnumFacing, List<BakedQuad>>();
        for (int lllllllllllllIIIIIIlIlIlIlIllIlI = 0; lllllllllllllIIIIIIlIlIlIlIllIlI < lllllllllllllIIIIIIlIlIlIlIlllII.length; ++lllllllllllllIIIIIIlIlIlIlIllIlI) {
            final EnumFacing lllllllllllllIIIIIIlIlIlIlIllIIl = lllllllllllllIIIIIIlIlIlIlIlllII[lllllllllllllIIIIIIlIlIlIlIllIlI];
            final List lllllllllllllIIIIIIlIlIlIlIllIII = new ArrayList();
            lllllllllllllIIIIIIlIlIlIlIllIII.add(makeBakedQuad(lllllllllllllIIIIIIlIlIlIlIllIIl, lllllllllllllIIIIIIlIlIlIlIlIlIl, lllllllllllllIIIIIIlIlIlIlIlIlII));
            lllllllllllllIIIIIIlIlIlIlIllIll.put(lllllllllllllIIIIIIlIlIlIlIllIIl, lllllllllllllIIIIIIlIlIlIlIllIII);
        }
        final ItemOverrideList lllllllllllllIIIIIIlIlIlIlIlIlll = new ItemOverrideList(new ArrayList<ItemOverride>());
        final IBakedModel lllllllllllllIIIIIIlIlIlIlIlIllI = new SimpleBakedModel(lllllllllllllIIIIIIlIlIlIlIlllIl, lllllllllllllIIIIIIlIlIlIlIllIll, true, true, lllllllllllllIIIIIIlIlIlIlIlIlIl, ItemCameraTransforms.DEFAULT, lllllllllllllIIIIIIlIlIlIlIlIlll);
        return lllllllllllllIIIIIIlIlIlIlIlIllI;
    }
    
    public static BakedQuad makeBakedQuad(final EnumFacing lllllllllllllIIIIIIlIlIlIIIIllll, final TextureAtlasSprite lllllllllllllIIIIIIlIlIlIIIIlllI, final int lllllllllllllIIIIIIlIlIlIIIIllIl) {
        final Vector3f lllllllllllllIIIIIIlIlIlIIIllIIl = new Vector3f(0.0f, 0.0f, 0.0f);
        final Vector3f lllllllllllllIIIIIIlIlIlIIIllIII = new Vector3f(16.0f, 16.0f, 16.0f);
        final BlockFaceUV lllllllllllllIIIIIIlIlIlIIIlIlll = new BlockFaceUV(new float[] { 0.0f, 0.0f, 16.0f, 16.0f }, 0);
        final BlockPartFace lllllllllllllIIIIIIlIlIlIIIlIllI = new BlockPartFace(lllllllllllllIIIIIIlIlIlIIIIllll, lllllllllllllIIIIIIlIlIlIIIIllIl, String.valueOf(new StringBuilder("#").append(lllllllllllllIIIIIIlIlIlIIIIllll.getName())), lllllllllllllIIIIIIlIlIlIIIlIlll);
        final ModelRotation lllllllllllllIIIIIIlIlIlIIIlIlIl = ModelRotation.X0_Y0;
        final BlockPartRotation lllllllllllllIIIIIIlIlIlIIIlIlII = null;
        final boolean lllllllllllllIIIIIIlIlIlIIIlIIll = false;
        final boolean lllllllllllllIIIIIIlIlIlIIIlIIlI = true;
        final FaceBakery lllllllllllllIIIIIIlIlIlIIIlIIIl = new FaceBakery();
        final BakedQuad lllllllllllllIIIIIIlIlIlIIIlIIII = lllllllllllllIIIIIIlIlIlIIIlIIIl.makeBakedQuad(lllllllllllllIIIIIIlIlIlIIIllIIl, lllllllllllllIIIIIIlIlIlIIIllIII, lllllllllllllIIIIIIlIlIlIIIlIllI, lllllllllllllIIIIIIlIlIlIIIIlllI, lllllllllllllIIIIIIlIlIlIIIIllll, lllllllllllllIIIIIIlIlIlIIIlIlIl, lllllllllllllIIIIIIlIlIlIIIlIlII, lllllllllllllIIIIIIlIlIlIIIlIIll, lllllllllllllIIIIIIlIlIlIIIlIIlI);
        return lllllllllllllIIIIIIlIlIlIIIlIIII;
    }
    
    public static IBakedModel joinModelsCube(final IBakedModel lllllllllllllIIIIIIlIlIlIIllIlII, final IBakedModel lllllllllllllIIIIIIlIlIlIlIIIIIl) {
        final List<BakedQuad> lllllllllllllIIIIIIlIlIlIlIIIIII = new ArrayList<BakedQuad>();
        lllllllllllllIIIIIIlIlIlIlIIIIII.addAll(lllllllllllllIIIIIIlIlIlIIllIlII.getQuads(null, null, 0L));
        lllllllllllllIIIIIIlIlIlIlIIIIII.addAll(lllllllllllllIIIIIIlIlIlIlIIIIIl.getQuads(null, null, 0L));
        final EnumFacing[] lllllllllllllIIIIIIlIlIlIIllllll = EnumFacing.VALUES;
        final Map<EnumFacing, List<BakedQuad>> lllllllllllllIIIIIIlIlIlIIlllllI = new HashMap<EnumFacing, List<BakedQuad>>();
        for (int lllllllllllllIIIIIIlIlIlIIllllIl = 0; lllllllllllllIIIIIIlIlIlIIllllIl < lllllllllllllIIIIIIlIlIlIIllllll.length; ++lllllllllllllIIIIIIlIlIlIIllllIl) {
            final EnumFacing lllllllllllllIIIIIIlIlIlIIllllII = lllllllllllllIIIIIIlIlIlIIllllll[lllllllllllllIIIIIIlIlIlIIllllIl];
            final List lllllllllllllIIIIIIlIlIlIIlllIll = new ArrayList();
            lllllllllllllIIIIIIlIlIlIIlllIll.addAll(lllllllllllllIIIIIIlIlIlIIllIlII.getQuads(null, lllllllllllllIIIIIIlIlIlIIllllII, 0L));
            lllllllllllllIIIIIIlIlIlIIlllIll.addAll(lllllllllllllIIIIIIlIlIlIlIIIIIl.getQuads(null, lllllllllllllIIIIIIlIlIlIIllllII, 0L));
            lllllllllllllIIIIIIlIlIlIIlllllI.put(lllllllllllllIIIIIIlIlIlIIllllII, lllllllllllllIIIIIIlIlIlIIlllIll);
        }
        final boolean lllllllllllllIIIIIIlIlIlIIlllIlI = lllllllllllllIIIIIIlIlIlIIllIlII.isAmbientOcclusion();
        final boolean lllllllllllllIIIIIIlIlIlIIlllIIl = lllllllllllllIIIIIIlIlIlIIllIlII.isBuiltInRenderer();
        final TextureAtlasSprite lllllllllllllIIIIIIlIlIlIIlllIII = lllllllllllllIIIIIIlIlIlIIllIlII.getParticleTexture();
        final ItemCameraTransforms lllllllllllllIIIIIIlIlIlIIllIlll = lllllllllllllIIIIIIlIlIlIIllIlII.getItemCameraTransforms();
        final ItemOverrideList lllllllllllllIIIIIIlIlIlIIllIllI = lllllllllllllIIIIIIlIlIlIIllIlII.getOverrides();
        final IBakedModel lllllllllllllIIIIIIlIlIlIIllIlIl = new SimpleBakedModel(lllllllllllllIIIIIIlIlIlIlIIIIII, lllllllllllllIIIIIIlIlIlIIlllllI, lllllllllllllIIIIIIlIlIlIIlllIlI, lllllllllllllIIIIIIlIlIlIIlllIIl, lllllllllllllIIIIIIlIlIlIIlllIII, lllllllllllllIIIIIIlIlIlIIllIlll, lllllllllllllIIIIIIlIlIlIIllIllI);
        return lllllllllllllIIIIIIlIlIlIIllIlIl;
    }
    
    public static void snapVertexPosition(final Vector3f lllllllllllllIIIIIIlIlIIlIIlIllI) {
        lllllllllllllIIIIIIlIlIIlIIlIllI.setX(snapVertexCoord(lllllllllllllIIIIIIlIlIIlIIlIllI.getX()));
        lllllllllllllIIIIIIlIlIIlIIlIllI.setY(snapVertexCoord(lllllllllllllIIIIIIlIlIIlIIlIllI.getY()));
        lllllllllllllIIIIIIlIlIIlIIlIllI.setZ(snapVertexCoord(lllllllllllllIIIIIIlIlIIlIIlIllI.getZ()));
    }
}
