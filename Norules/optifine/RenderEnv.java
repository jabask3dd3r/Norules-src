package optifine;

import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import java.util.*;

public class RenderEnv
{
    private /* synthetic */ List<BakedQuad> listQuadsCtmMultipass;
    private /* synthetic */ int breakingAnimation;
    private /* synthetic */ BitSet boundsFlags;
    private /* synthetic */ BakedQuad[] arrayQuadsCtm1;
    private /* synthetic */ int blockId;
    private /* synthetic */ boolean[] borderFlags2;
    private /* synthetic */ List<BakedQuad> listQuadsCustomizer;
    private /* synthetic */ RegionRenderCacheBuilder regionRenderCacheBuilder;
    private /* synthetic */ BlockPos blockPos;
    private /* synthetic */ BakedQuad[] arrayQuadsCtm2;
    private /* synthetic */ BlockModelRenderer.AmbientOcclusionFace aoFace;
    private /* synthetic */ BlockPosM colorizerBlockPosM;
    private /* synthetic */ EnumFacing[] borderDirections;
    private /* synthetic */ float[] quadBounds;
    private /* synthetic */ boolean[] borderFlags3;
    private /* synthetic */ IBlockState blockState;
    private /* synthetic */ ListQuadsOverlay[] listsQuadsOverlay;
    private /* synthetic */ BakedQuad[] arrayQuadsCtm3;
    private /* synthetic */ BakedQuad[] arrayQuadsCtm4;
    private /* synthetic */ int smartLeaves;
    private /* synthetic */ int metadata;
    private /* synthetic */ IBlockAccess blockAccess;
    private /* synthetic */ boolean overlaysRendered;
    private /* synthetic */ boolean[] borderFlags;
    
    public BakedQuad[] getArrayQuadsCtm(final BakedQuad llllllllllllllIIIIllIllllIIllllI, final BakedQuad llllllllllllllIIIIllIllllIIlllIl, final BakedQuad llllllllllllllIIIIllIllllIIlIlll, final BakedQuad llllllllllllllIIIIllIllllIIlIllI) {
        this.arrayQuadsCtm4[0] = llllllllllllllIIIIllIllllIIllllI;
        this.arrayQuadsCtm4[1] = llllllllllllllIIIIllIllllIIlllIl;
        this.arrayQuadsCtm4[2] = llllllllllllllIIIIllIllllIIlIlll;
        this.arrayQuadsCtm4[3] = llllllllllllllIIIIllIllllIIlIllI;
        return this.arrayQuadsCtm4;
    }
    
    public ListQuadsOverlay getListQuadsOverlay(final BlockRenderLayer llllllllllllllIIIIllIlllIlllllII) {
        ListQuadsOverlay llllllllllllllIIIIllIlllIllllIll = this.listsQuadsOverlay[llllllllllllllIIIIllIlllIlllllII.ordinal()];
        if (llllllllllllllIIIIllIlllIllllIll == null) {
            llllllllllllllIIIIllIlllIllllIll = new ListQuadsOverlay();
            this.listsQuadsOverlay[llllllllllllllIIIIllIlllIlllllII.ordinal()] = llllllllllllllIIIIllIlllIllllIll;
        }
        return llllllllllllllIIIIllIlllIllllIll;
    }
    
    public boolean isBreakingAnimation(final List llllllllllllllIIIIllIlllllllIlIl) {
        if (this.breakingAnimation == -1 && llllllllllllllIIIIllIlllllllIlIl.size() > 0) {
            if (llllllllllllllIIIIllIlllllllIlIl.get(0) instanceof BakedQuadRetextured) {
                this.breakingAnimation = 1;
            }
            else {
                this.breakingAnimation = 0;
            }
        }
        return this.breakingAnimation == 1;
    }
    
    public BlockModelRenderer.AmbientOcclusionFace getAoFace() {
        return this.aoFace;
    }
    
    public EnumFacing[] getBorderDirections() {
        if (this.borderDirections == null) {
            this.borderDirections = new EnumFacing[4];
        }
        return this.borderDirections;
    }
    
    public float[] getQuadBounds() {
        return this.quadBounds;
    }
    
    public int getMetadata() {
        if (this.metadata < 0) {
            if (this.blockState instanceof BlockStateBase) {
                final BlockStateBase llllllllllllllIIIIlllIIIIIIIIlII = (BlockStateBase)this.blockState;
                this.metadata = llllllllllllllIIIIlllIIIIIIIIlII.getMetadata();
            }
            else {
                this.metadata = this.blockState.getBlock().getMetaFromState(this.blockState);
            }
        }
        return this.metadata;
    }
    
    public boolean isBreakingAnimation() {
        return this.breakingAnimation == 1;
    }
    
    public List<BakedQuad> getListQuadsCustomizer() {
        return this.listQuadsCustomizer;
    }
    
    public boolean isOverlaysRendered() {
        return this.overlaysRendered;
    }
    
    public int getBlockId() {
        if (this.blockId < 0) {
            if (this.blockState instanceof BlockStateBase) {
                final BlockStateBase llllllllllllllIIIIlllIIIIIIIlIlI = (BlockStateBase)this.blockState;
                this.blockId = llllllllllllllIIIIlllIIIIIIIlIlI.getBlockId();
            }
            else {
                this.blockId = Block.getIdFromBlock(this.blockState.getBlock());
            }
        }
        return this.blockId;
    }
    
    public boolean isBreakingAnimation(final BakedQuad llllllllllllllIIIIllIllllllIllIl) {
        if (this.breakingAnimation < 0) {
            if (llllllllllllllIIIIllIllllllIllIl instanceof BakedQuadRetextured) {
                this.breakingAnimation = 1;
            }
            else {
                this.breakingAnimation = 0;
            }
        }
        return this.breakingAnimation == 1;
    }
    
    public void setRegionRenderCacheBuilder(final RegionRenderCacheBuilder llllllllllllllIIIIllIllllIIIIIll) {
        this.regionRenderCacheBuilder = llllllllllllllIIIIllIllllIIIIIll;
    }
    
    public EnumFacing[] getBorderDirections(final EnumFacing llllllllllllllIIIIllIlllllIlIIII, final EnumFacing llllllllllllllIIIIllIlllllIIllll, final EnumFacing llllllllllllllIIIIllIlllllIIlIII, final EnumFacing llllllllllllllIIIIllIlllllIIIlll) {
        final EnumFacing[] llllllllllllllIIIIllIlllllIIllII = this.getBorderDirections();
        llllllllllllllIIIIllIlllllIIllII[0] = llllllllllllllIIIIllIlllllIlIIII;
        llllllllllllllIIIIllIlllllIIllII[1] = llllllllllllllIIIIllIlllllIIllll;
        llllllllllllllIIIIllIlllllIIllII[2] = llllllllllllllIIIIllIlllllIIlIII;
        llllllllllllllIIIIllIlllllIIllII[3] = llllllllllllllIIIIllIlllllIIIlll;
        return llllllllllllllIIIIllIlllllIIllII;
    }
    
    public BakedQuad[] getArrayQuadsCtm(final BakedQuad llllllllllllllIIIIllIllllIlllIlI) {
        this.arrayQuadsCtm1[0] = llllllllllllllIIIIllIllllIlllIlI;
        return this.arrayQuadsCtm1;
    }
    
    public boolean isSmartLeaves() {
        if (this.smartLeaves == -1) {
            if (Config.isTreesSmart() && this.blockState.getBlock() instanceof BlockLeaves) {
                this.smartLeaves = 1;
            }
            else {
                this.smartLeaves = 0;
            }
        }
        return this.smartLeaves == 1;
    }
    
    static {
        FALSE = 0;
        UNKNOWN = -1;
        TRUE = 1;
    }
    
    public RegionRenderCacheBuilder getRegionRenderCacheBuilder() {
        return this.regionRenderCacheBuilder;
    }
    
    public RenderEnv(final IBlockAccess llllllllllllllIIIIlllIIIIIlIIIII, final IBlockState llllllllllllllIIIIlllIIIIIIllIll, final BlockPos llllllllllllllIIIIlllIIIIIIllllI) {
        this.blockId = -1;
        this.metadata = -1;
        this.breakingAnimation = -1;
        this.smartLeaves = -1;
        this.quadBounds = new float[EnumFacing.VALUES.length * 2];
        this.boundsFlags = new BitSet(3);
        this.aoFace = new BlockModelRenderer.AmbientOcclusionFace();
        this.colorizerBlockPosM = null;
        this.borderFlags = null;
        this.borderFlags2 = null;
        this.borderFlags3 = null;
        this.borderDirections = null;
        this.listQuadsCustomizer = new ArrayList<BakedQuad>();
        this.listQuadsCtmMultipass = new ArrayList<BakedQuad>();
        this.arrayQuadsCtm1 = new BakedQuad[1];
        this.arrayQuadsCtm2 = new BakedQuad[2];
        this.arrayQuadsCtm3 = new BakedQuad[3];
        this.arrayQuadsCtm4 = new BakedQuad[4];
        this.regionRenderCacheBuilder = null;
        this.listsQuadsOverlay = new ListQuadsOverlay[BlockRenderLayer.values().length];
        this.overlaysRendered = false;
        this.blockAccess = llllllllllllllIIIIlllIIIIIlIIIII;
        this.blockState = llllllllllllllIIIIlllIIIIIIllIll;
        this.blockPos = llllllllllllllIIIIlllIIIIIIllllI;
    }
    
    public boolean[] getBorderFlags2() {
        if (this.borderFlags2 == null) {
            this.borderFlags2 = new boolean[4];
        }
        return this.borderFlags2;
    }
    
    public List<BakedQuad> getListQuadsCtmMultipass(final BakedQuad[] llllllllllllllIIIIllIllllIIIllII) {
        this.listQuadsCtmMultipass.clear();
        if (llllllllllllllIIIIllIllllIIIllII != null) {
            for (int llllllllllllllIIIIllIllllIIIllll = 0; llllllllllllllIIIIllIllllIIIllll < llllllllllllllIIIIllIllllIIIllII.length; ++llllllllllllllIIIIllIllllIIIllll) {
                final BakedQuad llllllllllllllIIIIllIllllIIIlllI = llllllllllllllIIIIllIllllIIIllII[llllllllllllllIIIIllIllllIIIllll];
                this.listQuadsCtmMultipass.add(llllllllllllllIIIIllIllllIIIlllI);
            }
        }
        return this.listQuadsCtmMultipass;
    }
    
    public boolean[] getBorderFlags() {
        if (this.borderFlags == null) {
            this.borderFlags = new boolean[4];
        }
        return this.borderFlags;
    }
    
    public BakedQuad[] getArrayQuadsCtm(final BakedQuad llllllllllllllIIIIllIllllIllIIlI, final BakedQuad llllllllllllllIIIIllIllllIllIIIl) {
        this.arrayQuadsCtm2[0] = llllllllllllllIIIIllIllllIllIIlI;
        this.arrayQuadsCtm2[1] = llllllllllllllIIIIllIllllIllIIIl;
        return this.arrayQuadsCtm2;
    }
    
    public BlockPosM getColorizerBlockPosM() {
        if (this.colorizerBlockPosM == null) {
            this.colorizerBlockPosM = new BlockPosM(0, 0, 0);
        }
        return this.colorizerBlockPosM;
    }
    
    public BakedQuad[] getArrayQuadsCtm(final BakedQuad llllllllllllllIIIIllIllllIlIIlll, final BakedQuad llllllllllllllIIIIllIllllIlIIllI, final BakedQuad llllllllllllllIIIIllIllllIlIIlIl) {
        this.arrayQuadsCtm3[0] = llllllllllllllIIIIllIllllIlIIlll;
        this.arrayQuadsCtm3[1] = llllllllllllllIIIIllIllllIlIIllI;
        this.arrayQuadsCtm3[2] = llllllllllllllIIIIllIllllIlIIlIl;
        return this.arrayQuadsCtm3;
    }
    
    public void setOverlaysRendered(final boolean llllllllllllllIIIIllIlllIllIllll) {
        this.overlaysRendered = llllllllllllllIIIIllIlllIllIllll;
    }
    
    public IBlockState getBlockState() {
        return this.blockState;
    }
    
    public void reset(final IBlockAccess llllllllllllllIIIIlllIIIIIIlIlII, final IBlockState llllllllllllllIIIIlllIIIIIIlIIll, final BlockPos llllllllllllllIIIIlllIIIIIIlIIlI) {
        if (this.blockAccess != llllllllllllllIIIIlllIIIIIIlIlII || this.blockState != llllllllllllllIIIIlllIIIIIIlIIll || this.blockPos != llllllllllllllIIIIlllIIIIIIlIIlI) {
            this.blockAccess = llllllllllllllIIIIlllIIIIIIlIlII;
            this.blockState = llllllllllllllIIIIlllIIIIIIlIIll;
            this.blockPos = llllllllllllllIIIIlllIIIIIIlIIlI;
            this.blockId = -1;
            this.metadata = -1;
            this.breakingAnimation = -1;
            this.smartLeaves = -1;
            this.boundsFlags.clear();
        }
    }
    
    public boolean[] getBorderFlags3() {
        if (this.borderFlags3 == null) {
            this.borderFlags3 = new boolean[4];
        }
        return this.borderFlags3;
    }
    
    public BitSet getBoundsFlags() {
        return this.boundsFlags;
    }
}
