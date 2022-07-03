package optifine;

import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;

public class SmartLeaves
{
    private static /* synthetic */ IBakedModel modelLeavesCullJungle;
    private static /* synthetic */ IBakedModel modelLeavesDoubleJungle;
    private static /* synthetic */ List generalQuadsCullJungle;
    private static /* synthetic */ IBakedModel modelLeavesCullBirch;
    private static /* synthetic */ List generalQuadsCullOak;
    private static /* synthetic */ IBakedModel modelLeavesDoubleOak;
    private static /* synthetic */ IBakedModel modelLeavesCullAcacia;
    private static /* synthetic */ IBakedModel modelLeavesDoubleBirch;
    private static /* synthetic */ List generalQuadsCullBirch;
    private static /* synthetic */ IBakedModel modelLeavesDoubleAcacia;
    private static /* synthetic */ IBakedModel modelLeavesCullOak;
    private static /* synthetic */ IBakedModel modelLeavesCullSpruce;
    private static /* synthetic */ IBakedModel modelLeavesDoubleSpruce;
    private static /* synthetic */ List generalQuadsCullDarkOak;
    private static /* synthetic */ IBakedModel modelLeavesDoubleDarkOak;
    private static /* synthetic */ List generalQuadsCullAcacia;
    private static /* synthetic */ List generalQuadsCullSpruce;
    private static /* synthetic */ IBakedModel modelLeavesCullDarkOak;
    
    private static List getGeneralQuadsSafe(final IBakedModel lllllllllllllIllllIlllIlIIIIllll) {
        return (lllllllllllllIllllIlllIlIIIIllll == null) ? null : lllllllllllllIllllIlllIlIIIIllll.getQuads(null, null, 0L);
    }
    
    static {
        SmartLeaves.modelLeavesCullAcacia = null;
        SmartLeaves.modelLeavesCullBirch = null;
        SmartLeaves.modelLeavesCullDarkOak = null;
        SmartLeaves.modelLeavesCullJungle = null;
        SmartLeaves.modelLeavesCullOak = null;
        SmartLeaves.modelLeavesCullSpruce = null;
        SmartLeaves.generalQuadsCullAcacia = null;
        SmartLeaves.generalQuadsCullBirch = null;
        SmartLeaves.generalQuadsCullDarkOak = null;
        SmartLeaves.generalQuadsCullJungle = null;
        SmartLeaves.generalQuadsCullOak = null;
        SmartLeaves.generalQuadsCullSpruce = null;
        SmartLeaves.modelLeavesDoubleAcacia = null;
        SmartLeaves.modelLeavesDoubleBirch = null;
        SmartLeaves.modelLeavesDoubleDarkOak = null;
        SmartLeaves.modelLeavesDoubleJungle = null;
        SmartLeaves.modelLeavesDoubleOak = null;
        SmartLeaves.modelLeavesDoubleSpruce = null;
    }
    
    private static IBakedModel getModelDoubleFace(final IBakedModel lllllllllllllIllllIlllIIlllIIIIl) {
        if (lllllllllllllIllllIlllIIlllIIIIl == null) {
            return null;
        }
        if (lllllllllllllIllllIlllIIlllIIIIl.getQuads(null, null, 0L).size() > 0) {
            Config.warn(String.valueOf(new StringBuilder("SmartLeaves: Model is not cube, general quads: ").append(lllllllllllllIllllIlllIIlllIIIIl.getQuads(null, null, 0L).size()).append(", model: ").append(lllllllllllllIllllIlllIIlllIIIIl)));
            return lllllllllllllIllllIlllIIlllIIIIl;
        }
        final EnumFacing[] lllllllllllllIllllIlllIIlllIIIII = EnumFacing.VALUES;
        for (int lllllllllllllIllllIlllIIllIlllll = 0; lllllllllllllIllllIlllIIllIlllll < lllllllllllllIllllIlllIIlllIIIII.length; ++lllllllllllllIllllIlllIIllIlllll) {
            final EnumFacing lllllllllllllIllllIlllIIllIllllI = lllllllllllllIllllIlllIIlllIIIII[lllllllllllllIllllIlllIIllIlllll];
            final List<BakedQuad> lllllllllllllIllllIlllIIllIlllIl = lllllllllllllIllllIlllIIlllIIIIl.getQuads(null, lllllllllllllIllllIlllIIllIllllI, 0L);
            if (lllllllllllllIllllIlllIIllIlllIl.size() != 1) {
                Config.warn(String.valueOf(new StringBuilder("SmartLeaves: Model is not cube, side: ").append(lllllllllllllIllllIlllIIllIllllI).append(", quads: ").append(lllllllllllllIllllIlllIIllIlllIl.size()).append(", model: ").append(lllllllllllllIllllIlllIIlllIIIIl)));
                return lllllllllllllIllllIlllIIlllIIIIl;
            }
        }
        final IBakedModel lllllllllllllIllllIlllIIllIlllII = ModelUtils.duplicateModel(lllllllllllllIllllIlllIIlllIIIIl);
        final List[] lllllllllllllIllllIlllIIllIllIll = new List[lllllllllllllIllllIlllIIlllIIIII.length];
        for (int lllllllllllllIllllIlllIIllIllIlI = 0; lllllllllllllIllllIlllIIllIllIlI < lllllllllllllIllllIlllIIlllIIIII.length; ++lllllllllllllIllllIlllIIllIllIlI) {
            final EnumFacing lllllllllllllIllllIlllIIllIllIIl = lllllllllllllIllllIlllIIlllIIIII[lllllllllllllIllllIlllIIllIllIlI];
            final List<BakedQuad> lllllllllllllIllllIlllIIllIllIII = lllllllllllllIllllIlllIIllIlllII.getQuads(null, lllllllllllllIllllIlllIIllIllIIl, 0L);
            final BakedQuad lllllllllllllIllllIlllIIllIlIlll = lllllllllllllIllllIlllIIllIllIII.get(0);
            final BakedQuad lllllllllllllIllllIlllIIllIlIllI = new BakedQuad(lllllllllllllIllllIlllIIllIlIlll.getVertexData().clone(), lllllllllllllIllllIlllIIllIlIlll.getTintIndex(), lllllllllllllIllllIlllIIllIlIlll.getFace(), lllllllllllllIllllIlllIIllIlIlll.getSprite());
            final int[] lllllllllllllIllllIlllIIllIlIlIl = lllllllllllllIllllIlllIIllIlIllI.getVertexData();
            final int[] lllllllllllllIllllIlllIIllIlIlII = lllllllllllllIllllIlllIIllIlIlIl.clone();
            final int lllllllllllllIllllIlllIIllIlIIll = lllllllllllllIllllIlllIIllIlIlIl.length / 4;
            System.arraycopy(lllllllllllllIllllIlllIIllIlIlIl, 0 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIlII, 3 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIIll);
            System.arraycopy(lllllllllllllIllllIlllIIllIlIlIl, 1 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIlII, 2 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIIll);
            System.arraycopy(lllllllllllllIllllIlllIIllIlIlIl, 2 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIlII, 1 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIIll);
            System.arraycopy(lllllllllllllIllllIlllIIllIlIlIl, 3 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIlII, 0 * lllllllllllllIllllIlllIIllIlIIll, lllllllllllllIllllIlllIIllIlIIll);
            System.arraycopy(lllllllllllllIllllIlllIIllIlIlII, 0, lllllllllllllIllllIlllIIllIlIlIl, 0, lllllllllllllIllllIlllIIllIlIlII.length);
            lllllllllllllIllllIlllIIllIllIII.add(lllllllllllllIllllIlllIIllIlIllI);
        }
        return lllllllllllllIllllIlllIIllIlllII;
    }
    
    static IBakedModel getModelCull(final String lllllllllllllIllllIlllIlIIIIIIlI, final List lllllllllllllIllllIlllIIllllIlll) {
        final ModelManager lllllllllllllIllllIlllIlIIIIIIII = Config.getModelManager();
        if (lllllllllllllIllllIlllIlIIIIIIII == null) {
            return null;
        }
        final ResourceLocation lllllllllllllIllllIlllIIllllllll = new ResourceLocation(String.valueOf(new StringBuilder("blockstates/").append(lllllllllllllIllllIlllIlIIIIIIlI).append("_leaves.json")));
        if (Config.getDefiningResourcePack(lllllllllllllIllllIlllIIllllllll) != Config.getDefaultResourcePack()) {
            return null;
        }
        final ResourceLocation lllllllllllllIllllIlllIIlllllllI = new ResourceLocation(String.valueOf(new StringBuilder("models/block/").append(lllllllllllllIllllIlllIlIIIIIIlI).append("_leaves.json")));
        if (Config.getDefiningResourcePack(lllllllllllllIllllIlllIIlllllllI) != Config.getDefaultResourcePack()) {
            return null;
        }
        final ModelResourceLocation lllllllllllllIllllIlllIIllllllIl = new ModelResourceLocation(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlllIlIIIIIIlI)).append("_leaves")), "normal");
        final IBakedModel lllllllllllllIllllIlllIIllllllII = lllllllllllllIllllIlllIlIIIIIIII.getModel(lllllllllllllIllllIlllIIllllllIl);
        if (lllllllllllllIllllIlllIIllllllII == null || lllllllllllllIllllIlllIIllllllII == lllllllllllllIllllIlllIlIIIIIIII.getMissingModel()) {
            return null;
        }
        final List lllllllllllllIllllIlllIIlllllIll = lllllllllllllIllllIlllIIllllllII.getQuads(null, null, 0L);
        if (lllllllllllllIllllIlllIIlllllIll.size() == 0) {
            return lllllllllllllIllllIlllIIllllllII;
        }
        if (lllllllllllllIllllIlllIIlllllIll.size() != 6) {
            return null;
        }
        for (final Object lllllllllllllIllllIlllIIlllllIlI : lllllllllllllIllllIlllIIlllllIll) {
            final List lllllllllllllIllllIlllIIlllllIIl = lllllllllllllIllllIlllIIllllllII.getQuads(null, ((BakedQuad)lllllllllllllIllllIlllIIlllllIlI).getFace(), 0L);
            if (lllllllllllllIllllIlllIIlllllIIl.size() > 0) {
                return null;
            }
            lllllllllllllIllllIlllIIlllllIIl.add(lllllllllllllIllllIlllIIlllllIlI);
        }
        lllllllllllllIllllIlllIIlllllIll.clear();
        lllllllllllllIllllIlllIIllllIlll.add(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlllIlIIIIIIlI)).append("_leaves")));
        return lllllllllllllIllllIlllIIllllllII;
    }
    
    public static void updateLeavesModels() {
        final List lllllllllllllIllllIlllIlIIIlIIlI = new ArrayList();
        SmartLeaves.modelLeavesCullAcacia = getModelCull("acacia", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.modelLeavesCullBirch = getModelCull("birch", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.modelLeavesCullDarkOak = getModelCull("dark_oak", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.modelLeavesCullJungle = getModelCull("jungle", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.modelLeavesCullOak = getModelCull("oak", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.modelLeavesCullSpruce = getModelCull("spruce", lllllllllllllIllllIlllIlIIIlIIlI);
        SmartLeaves.generalQuadsCullAcacia = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullAcacia);
        SmartLeaves.generalQuadsCullBirch = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullBirch);
        SmartLeaves.generalQuadsCullDarkOak = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullDarkOak);
        SmartLeaves.generalQuadsCullJungle = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullJungle);
        SmartLeaves.generalQuadsCullOak = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullOak);
        SmartLeaves.generalQuadsCullSpruce = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullSpruce);
        SmartLeaves.modelLeavesDoubleAcacia = getModelDoubleFace(SmartLeaves.modelLeavesCullAcacia);
        SmartLeaves.modelLeavesDoubleBirch = getModelDoubleFace(SmartLeaves.modelLeavesCullBirch);
        SmartLeaves.modelLeavesDoubleDarkOak = getModelDoubleFace(SmartLeaves.modelLeavesCullDarkOak);
        SmartLeaves.modelLeavesDoubleJungle = getModelDoubleFace(SmartLeaves.modelLeavesCullJungle);
        SmartLeaves.modelLeavesDoubleOak = getModelDoubleFace(SmartLeaves.modelLeavesCullOak);
        SmartLeaves.modelLeavesDoubleSpruce = getModelDoubleFace(SmartLeaves.modelLeavesCullSpruce);
        if (lllllllllllllIllllIlllIlIIIlIIlI.size() > 0) {
            Config.dbg(String.valueOf(new StringBuilder("Enable face culling: ").append(Config.arrayToString(lllllllllllllIllllIlllIlIIIlIIlI.toArray()))));
        }
    }
    
    public static boolean isSameLeaves(final IBlockState lllllllllllllIllllIlllIlIIIlIlll, final IBlockState lllllllllllllIllllIlllIlIIIlIllI) {
        if (lllllllllllllIllllIlllIlIIIlIlll == lllllllllllllIllllIlllIlIIIlIllI) {
            return true;
        }
        final Block lllllllllllllIllllIlllIlIIIllIIl = lllllllllllllIllllIlllIlIIIlIlll.getBlock();
        final Block lllllllllllllIllllIlllIlIIIllIII = lllllllllllllIllllIlllIlIIIlIllI.getBlock();
        if (lllllllllllllIllllIlllIlIIIllIIl != lllllllllllllIllllIlllIlIIIllIII) {
            return false;
        }
        if (lllllllllllllIllllIlllIlIIIllIIl instanceof BlockOldLeaf) {
            return lllllllllllllIllllIlllIlIIIlIlll.getValue(BlockOldLeaf.VARIANT).equals(lllllllllllllIllllIlllIlIIIlIllI.getValue(BlockOldLeaf.VARIANT));
        }
        return lllllllllllllIllllIlllIlIIIllIIl instanceof BlockNewLeaf && lllllllllllllIllllIlllIlIIIlIlll.getValue(BlockNewLeaf.VARIANT).equals(lllllllllllllIllllIlllIlIIIlIllI.getValue(BlockNewLeaf.VARIANT));
    }
    
    public static IBakedModel getLeavesModel(final IBakedModel lllllllllllllIllllIlllIlIIlIIlIl, final IBlockState lllllllllllllIllllIlllIlIIlIIIIl) {
        if (!Config.isTreesSmart()) {
            return lllllllllllllIllllIlllIlIIlIIlIl;
        }
        final List lllllllllllllIllllIlllIlIIlIIIll = lllllllllllllIllllIlllIlIIlIIlIl.getQuads(lllllllllllllIllllIlllIlIIlIIIIl, null, 0L);
        if (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullAcacia) {
            return SmartLeaves.modelLeavesDoubleAcacia;
        }
        if (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullBirch) {
            return SmartLeaves.modelLeavesDoubleBirch;
        }
        if (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullDarkOak) {
            return SmartLeaves.modelLeavesDoubleDarkOak;
        }
        if (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullJungle) {
            return SmartLeaves.modelLeavesDoubleJungle;
        }
        if (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullOak) {
            return SmartLeaves.modelLeavesDoubleOak;
        }
        return (lllllllllllllIllllIlllIlIIlIIIll == SmartLeaves.generalQuadsCullSpruce) ? SmartLeaves.modelLeavesDoubleSpruce : lllllllllllllIllllIlllIlIIlIIlIl;
    }
}
