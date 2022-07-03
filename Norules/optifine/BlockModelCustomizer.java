package optifine;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.block.model.*;

public class BlockModelCustomizer
{
    private static final /* synthetic */ List<BakedQuad> NO_QUADS;
    
    public static List<BakedQuad> getRenderQuads(List<BakedQuad> llllllllllllllIIIIIIlIIIlIllllIl, final IBlockAccess llllllllllllllIIIIIIlIIIlIlIllll, final IBlockState llllllllllllllIIIIIIlIIIlIlllIll, final BlockPos llllllllllllllIIIIIIlIIIlIlIllIl, final EnumFacing llllllllllllllIIIIIIlIIIlIlllIIl, final long llllllllllllllIIIIIIlIIIlIlllIII, final RenderEnv llllllllllllllIIIIIIlIIIlIllIlll) {
        if (llllllllllllllIIIIIIlIIIlIlllIIl != null) {
            if (llllllllllllllIIIIIIlIIIlIllIlll.isSmartLeaves() && SmartLeaves.isSameLeaves(llllllllllllllIIIIIIlIIIlIlIllll.getBlockState(llllllllllllllIIIIIIlIIIlIlIllIl.offset(llllllllllllllIIIIIIlIIIlIlllIIl)), llllllllllllllIIIIIIlIIIlIlllIll)) {
                return BlockModelCustomizer.NO_QUADS;
            }
            if (!llllllllllllllIIIIIIlIIIlIllIlll.isBreakingAnimation(llllllllllllllIIIIIIlIIIlIllllIl) && Config.isBetterGrass()) {
                llllllllllllllIIIIIIlIIIlIllllIl = (List<BakedQuad>)BetterGrass.getFaceQuads(llllllllllllllIIIIIIlIIIlIlIllll, llllllllllllllIIIIIIlIIIlIlllIll, llllllllllllllIIIIIIlIIIlIlIllIl, llllllllllllllIIIIIIlIIIlIlllIIl, llllllllllllllIIIIIIlIIIlIllllIl);
            }
        }
        final List<BakedQuad> llllllllllllllIIIIIIlIIIlIllIllI = llllllllllllllIIIIIIlIIIlIllIlll.getListQuadsCustomizer();
        llllllllllllllIIIIIIlIIIlIllIllI.clear();
        for (int llllllllllllllIIIIIIlIIIlIllIlIl = 0; llllllllllllllIIIIIIlIIIlIllIlIl < llllllllllllllIIIIIIlIIIlIllllIl.size(); ++llllllllllllllIIIIIIlIIIlIllIlIl) {
            final BakedQuad llllllllllllllIIIIIIlIIIlIllIlII = llllllllllllllIIIIIIlIIIlIllllIl.get(llllllllllllllIIIIIIlIIIlIllIlIl);
            final BakedQuad[] llllllllllllllIIIIIIlIIIlIllIIll = getRenderQuads(llllllllllllllIIIIIIlIIIlIllIlII, llllllllllllllIIIIIIlIIIlIlIllll, llllllllllllllIIIIIIlIIIlIlllIll, llllllllllllllIIIIIIlIIIlIlIllIl, llllllllllllllIIIIIIlIIIlIlllIIl, llllllllllllllIIIIIIlIIIlIlllIII, llllllllllllllIIIIIIlIIIlIllIlll);
            if (llllllllllllllIIIIIIlIIIlIllIlIl == 0 && llllllllllllllIIIIIIlIIIlIllllIl.size() == 1 && llllllllllllllIIIIIIlIIIlIllIIll.length == 1 && llllllllllllllIIIIIIlIIIlIllIIll[0] == llllllllllllllIIIIIIlIIIlIllIlII) {
                return llllllllllllllIIIIIIlIIIlIllllIl;
            }
            for (int llllllllllllllIIIIIIlIIIlIllIIlI = 0; llllllllllllllIIIIIIlIIIlIllIIlI < llllllllllllllIIIIIIlIIIlIllIIll.length; ++llllllllllllllIIIIIIlIIIlIllIIlI) {
                final BakedQuad llllllllllllllIIIIIIlIIIlIllIIIl = llllllllllllllIIIIIIlIIIlIllIIll[llllllllllllllIIIIIIlIIIlIllIIlI];
                llllllllllllllIIIIIIlIIIlIllIllI.add(llllllllllllllIIIIIIlIIIlIllIIIl);
            }
        }
        return llllllllllllllIIIIIIlIIIlIllIllI;
    }
    
    private static BakedQuad[] getRenderQuads(BakedQuad llllllllllllllIIIIIIlIIIlIIlIIll, final IBlockAccess llllllllllllllIIIIIIlIIIlIIllIll, final IBlockState llllllllllllllIIIIIIlIIIlIIlIIIl, final BlockPos llllllllllllllIIIIIIlIIIlIIllIIl, final EnumFacing llllllllllllllIIIIIIlIIIlIIllIII, final long llllllllllllllIIIIIIlIIIlIIlIlll, final RenderEnv llllllllllllllIIIIIIlIIIlIIlIllI) {
        if (llllllllllllllIIIIIIlIIIlIIlIllI.isBreakingAnimation(llllllllllllllIIIIIIlIIIlIIlIIll)) {
            return llllllllllllllIIIIIIlIIIlIIlIllI.getArrayQuadsCtm(llllllllllllllIIIIIIlIIIlIIlIIll);
        }
        final BakedQuad llllllllllllllIIIIIIlIIIlIIlIlIl = llllllllllllllIIIIIIlIIIlIIlIIll;
        if (Config.isConnectedTextures()) {
            final BakedQuad[] llllllllllllllIIIIIIlIIIlIIlIlII = ConnectedTextures.getConnectedTexture(llllllllllllllIIIIIIlIIIlIIllIll, llllllllllllllIIIIIIlIIIlIIlIIIl, llllllllllllllIIIIIIlIIIlIIllIIl, llllllllllllllIIIIIIlIIIlIIlIIll, llllllllllllllIIIIIIlIIIlIIlIllI);
            if (llllllllllllllIIIIIIlIIIlIIlIlII.length != 1 || llllllllllllllIIIIIIlIIIlIIlIlII[0] != llllllllllllllIIIIIIlIIIlIIlIIll) {
                return llllllllllllllIIIIIIlIIIlIIlIlII;
            }
        }
        if (Config.isNaturalTextures()) {
            llllllllllllllIIIIIIlIIIlIIlIIll = NaturalTextures.getNaturalTexture(llllllllllllllIIIIIIlIIIlIIllIIl, llllllllllllllIIIIIIlIIIlIIlIIll);
            if (llllllllllllllIIIIIIlIIIlIIlIIll != llllllllllllllIIIIIIlIIIlIIlIlIl) {
                return llllllllllllllIIIIIIlIIIlIIlIllI.getArrayQuadsCtm(llllllllllllllIIIIIIlIIIlIIlIIll);
            }
        }
        return llllllllllllllIIIIIIlIIIlIIlIllI.getArrayQuadsCtm(llllllllllllllIIIIIIlIIIlIIlIIll);
    }
    
    static {
        NO_QUADS = (List)ImmutableList.of();
    }
    
    public static IBakedModel getRenderModel(IBakedModel llllllllllllllIIIIIIlIIIllIIllIl, final IBlockState llllllllllllllIIIIIIlIIIllIIllII, final RenderEnv llllllllllllllIIIIIIlIIIllIIlllI) {
        if (llllllllllllllIIIIIIlIIIllIIlllI.isSmartLeaves()) {
            llllllllllllllIIIIIIlIIIllIIllIl = SmartLeaves.getLeavesModel(llllllllllllllIIIIIIlIIIllIIllIl, llllllllllllllIIIIIIlIIIllIIllII);
        }
        return llllllllllllllIIIIIIlIIIllIIllIl;
    }
}
