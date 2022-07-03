package optifine;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;

public class ModelUtils
{
    public static void dbgModel(final IBakedModel llllllllllllllIIllIIlIlIlIlIIIII) {
        if (llllllllllllllIIllIIlIlIlIlIIIII != null) {
            Config.dbg(String.valueOf(new StringBuilder("Model: ").append(llllllllllllllIIllIIlIlIlIlIIIII).append(", ao: ").append(llllllllllllllIIllIIlIlIlIlIIIII.isAmbientOcclusion()).append(", gui3d: ").append(llllllllllllllIIllIIlIlIlIlIIIII.isGui3d()).append(", builtIn: ").append(llllllllllllllIIllIIlIlIlIlIIIII.isBuiltInRenderer()).append(", particle: ").append(llllllllllllllIIllIIlIlIlIlIIIII.getParticleTexture())));
            final EnumFacing[] llllllllllllllIIllIIlIlIlIIlllll = EnumFacing.VALUES;
            for (int llllllllllllllIIllIIlIlIlIIllllI = 0; llllllllllllllIIllIIlIlIlIIllllI < llllllllllllllIIllIIlIlIlIIlllll.length; ++llllllllllllllIIllIIlIlIlIIllllI) {
                final EnumFacing llllllllllllllIIllIIlIlIlIIlllIl = llllllllllllllIIllIIlIlIlIIlllll[llllllllllllllIIllIIlIlIlIIllllI];
                final List llllllllllllllIIllIIlIlIlIIlllII = llllllllllllllIIllIIlIlIlIlIIIII.getQuads(null, llllllllllllllIIllIIlIlIlIIlllIl, 0L);
                dbgQuads(llllllllllllllIIllIIlIlIlIIlllIl.getName(), llllllllllllllIIllIIlIlIlIIlllII, "  ");
            }
            final List llllllllllllllIIllIIlIlIlIIllIll = llllllllllllllIIllIIlIlIlIlIIIII.getQuads(null, null, 0L);
            dbgQuads("General", llllllllllllllIIllIIlIlIlIIllIll, "  ");
        }
    }
    
    private static void dbgQuads(final String llllllllllllllIIllIIlIlIlIIIllII, final List llllllllllllllIIllIIlIlIlIIIllll, final String llllllllllllllIIllIIlIlIlIIIlIlI) {
        for (final Object llllllllllllllIIllIIlIlIlIIIllIl : llllllllllllllIIllIIlIlIlIIIllll) {
            dbgQuad(llllllllllllllIIllIIlIlIlIIIllII, (BakedQuad)llllllllllllllIIllIIlIlIlIIIllIl, llllllllllllllIIllIIlIlIlIIIlIlI);
        }
    }
    
    public static void dbgVertexData(final int[] llllllllllllllIIllIIlIlIIllIlIII, final String llllllllllllllIIllIIlIlIIlllIIlI) {
        final int llllllllllllllIIllIIlIlIIlllIIIl = llllllllllllllIIllIIlIlIIllIlIII.length / 4;
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlIIlllIIlI)).append("Length: ").append(llllllllllllllIIllIIlIlIIllIlIII.length).append(", step: ").append(llllllllllllllIIllIIlIlIIlllIIIl)));
        for (int llllllllllllllIIllIIlIlIIlllIIII = 0; llllllllllllllIIllIIlIlIIlllIIII < 4; ++llllllllllllllIIllIIlIlIIlllIIII) {
            final int llllllllllllllIIllIIlIlIIllIllll = llllllllllllllIIllIIlIlIIlllIIII * llllllllllllllIIllIIlIlIIlllIIIl;
            final float llllllllllllllIIllIIlIlIIllIlllI = Float.intBitsToFloat(llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 0]);
            final float llllllllllllllIIllIIlIlIIllIllIl = Float.intBitsToFloat(llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 1]);
            final float llllllllllllllIIllIIlIlIIllIllII = Float.intBitsToFloat(llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 2]);
            final int llllllllllllllIIllIIlIlIIllIlIll = llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 3];
            final float llllllllllllllIIllIIlIlIIllIlIlI = Float.intBitsToFloat(llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 4]);
            final float llllllllllllllIIllIIlIlIIllIlIIl = Float.intBitsToFloat(llllllllllllllIIllIIlIlIIllIlIII[llllllllllllllIIllIIlIlIIllIllll + 5]);
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlIIlllIIlI)).append(llllllllllllllIIllIIlIlIIlllIIII).append(" xyz: ").append(llllllllllllllIIllIIlIlIIllIlllI).append(",").append(llllllllllllllIIllIIlIlIIllIllIl).append(",").append(llllllllllllllIIllIIlIlIIllIllII).append(" col: ").append(llllllllllllllIIllIIlIlIIllIlIll).append(" u,v: ").append(llllllllllllllIIllIIlIlIIllIlIlI).append(",").append(llllllllllllllIIllIIlIlIIllIlIIl)));
        }
    }
    
    public static void dbgQuad(final String llllllllllllllIIllIIlIlIlIIIIlII, final BakedQuad llllllllllllllIIllIIlIlIlIIIIIII, final String llllllllllllllIIllIIlIlIlIIIIIlI) {
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIlIlIlIIIIIlI)).append("Quad: ").append(llllllllllllllIIllIIlIlIlIIIIIII.getClass().getName()).append(", type: ").append(llllllllllllllIIllIIlIlIlIIIIlII).append(", face: ").append(llllllllllllllIIllIIlIlIlIIIIIII.getFace()).append(", tint: ").append(llllllllllllllIIllIIlIlIlIIIIIII.getTintIndex()).append(", sprite: ").append(llllllllllllllIIllIIlIlIlIIIIIII.getSprite())));
        dbgVertexData(llllllllllllllIIllIIlIlIlIIIIIII.getVertexData(), String.valueOf(new StringBuilder("  ").append(llllllllllllllIIllIIlIlIlIIIIIlI)));
    }
    
    public static IBakedModel duplicateModel(final IBakedModel llllllllllllllIIllIIlIlIIlIIllII) {
        final List llllllllllllllIIllIIlIlIIlIlIlII = duplicateQuadList(llllllllllllllIIllIIlIlIIlIIllII.getQuads(null, null, 0L));
        final EnumFacing[] llllllllllllllIIllIIlIlIIlIlIIll = EnumFacing.VALUES;
        final Map<EnumFacing, List<BakedQuad>> llllllllllllllIIllIIlIlIIlIlIIlI = new HashMap<EnumFacing, List<BakedQuad>>();
        for (int llllllllllllllIIllIIlIlIIlIlIIIl = 0; llllllllllllllIIllIIlIlIIlIlIIIl < llllllllllllllIIllIIlIlIIlIlIIll.length; ++llllllllllllllIIllIIlIlIIlIlIIIl) {
            final EnumFacing llllllllllllllIIllIIlIlIIlIlIIII = llllllllllllllIIllIIlIlIIlIlIIll[llllllllllllllIIllIIlIlIIlIlIIIl];
            final List llllllllllllllIIllIIlIlIIlIIllll = llllllllllllllIIllIIlIlIIlIIllII.getQuads(null, llllllllllllllIIllIIlIlIIlIlIIII, 0L);
            final List llllllllllllllIIllIIlIlIIlIIlllI = duplicateQuadList(llllllllllllllIIllIIlIlIIlIIllll);
            llllllllllllllIIllIIlIlIIlIlIIlI.put(llllllllllllllIIllIIlIlIIlIlIIII, llllllllllllllIIllIIlIlIIlIIlllI);
        }
        final SimpleBakedModel llllllllllllllIIllIIlIlIIlIIllIl = new SimpleBakedModel(llllllllllllllIIllIIlIlIIlIlIlII, llllllllllllllIIllIIlIlIIlIlIIlI, llllllllllllllIIllIIlIlIIlIIllII.isAmbientOcclusion(), llllllllllllllIIllIIlIlIIlIIllII.isGui3d(), llllllllllllllIIllIIlIlIIlIIllII.getParticleTexture(), llllllllllllllIIllIIlIlIIlIIllII.getItemCameraTransforms(), llllllllllllllIIllIIlIlIIlIIllII.getOverrides());
        return llllllllllllllIIllIIlIlIIlIIllIl;
    }
    
    public static List duplicateQuadList(final List llllllllllllllIIllIIlIlIIIlllIll) {
        final List llllllllllllllIIllIIlIlIIIlllllI = new ArrayList();
        for (final Object llllllllllllllIIllIIlIlIIIllllIl : llllllllllllllIIllIIlIlIIIlllIll) {
            final BakedQuad llllllllllllllIIllIIlIlIIIllllII = duplicateQuad((BakedQuad)llllllllllllllIIllIIlIlIIIllllIl);
            llllllllllllllIIllIIlIlIIIlllllI.add(llllllllllllllIIllIIlIlIIIllllII);
        }
        return llllllllllllllIIllIIlIlIIIlllllI;
    }
    
    public static BakedQuad duplicateQuad(final BakedQuad llllllllllllllIIllIIlIlIIIllIIlI) {
        final BakedQuad llllllllllllllIIllIIlIlIIIllIIll = new BakedQuad(llllllllllllllIIllIIlIlIIIllIIlI.getVertexData().clone(), llllllllllllllIIllIIlIlIIIllIIlI.getTintIndex(), llllllllllllllIIllIIlIlIIIllIIlI.getFace(), llllllllllllllIIllIIlIlIIIllIIlI.getSprite());
        return llllllllllllllIIllIIlIlIIIllIIll;
    }
}
