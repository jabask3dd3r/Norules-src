package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class BetterSnow
{
    private static /* synthetic */ IBakedModel modelSnowLayer;
    
    public static IBlockState getStateSnowLayer() {
        return Blocks.SNOW_LAYER.getDefaultState();
    }
    
    private static boolean checkBlock(final Block llllllllllllllllIIlIlIIllllIlllI, final IBlockState llllllllllllllllIIlIlIIllllIlIlI) {
        if (llllllllllllllllIIlIlIIllllIlIlI.isFullCube()) {
            return false;
        }
        if (llllllllllllllllIIlIlIIllllIlIlI.isOpaqueCube()) {
            return false;
        }
        if (llllllllllllllllIIlIlIIllllIlllI instanceof BlockSnow) {
            return false;
        }
        if (llllllllllllllllIIlIlIIllllIlllI instanceof BlockBush && (llllllllllllllllIIlIlIIllllIlllI instanceof BlockDoublePlant || llllllllllllllllIIlIlIIllllIlllI instanceof BlockFlower || llllllllllllllllIIlIlIIllllIlllI instanceof BlockMushroom || llllllllllllllllIIlIlIIllllIlllI instanceof BlockSapling || llllllllllllllllIIlIlIIllllIlllI instanceof BlockTallGrass)) {
            return true;
        }
        if (llllllllllllllllIIlIlIIllllIlllI instanceof BlockFence || llllllllllllllllIIlIlIIllllIlllI instanceof BlockFenceGate || llllllllllllllllIIlIlIIllllIlllI instanceof BlockFlowerPot || llllllllllllllllIIlIlIIllllIlllI instanceof BlockPane || llllllllllllllllIIlIlIIllllIlllI instanceof BlockReed || llllllllllllllllIIlIlIIllllIlllI instanceof BlockWall) {
            return true;
        }
        if (llllllllllllllllIIlIlIIllllIlllI instanceof BlockRedstoneTorch && llllllllllllllllIIlIlIIllllIlIlI.getValue((IProperty<Comparable>)BlockTorch.FACING) == EnumFacing.UP) {
            return true;
        }
        if (llllllllllllllllIIlIlIIllllIlllI instanceof BlockLever) {
            final Object llllllllllllllllIIlIlIIllllIllII = llllllllllllllllIIlIlIIllllIlIlI.getValue(BlockLever.FACING);
            if (llllllllllllllllIIlIlIIllllIllII == BlockLever.EnumOrientation.UP_X || llllllllllllllllIIlIlIIllllIllII == BlockLever.EnumOrientation.UP_Z) {
                return true;
            }
        }
        return false;
    }
    
    public static void update() {
        BetterSnow.modelSnowLayer = Config.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(Blocks.SNOW_LAYER.getDefaultState());
    }
    
    static {
        BetterSnow.modelSnowLayer = null;
    }
    
    public static IBakedModel getModelSnowLayer() {
        return BetterSnow.modelSnowLayer;
    }
    
    private static boolean hasSnowNeighbours(final IBlockAccess llllllllllllllllIIlIlIIlllllIlII, final BlockPos llllllllllllllllIIlIlIIlllllIllI) {
        final Block llllllllllllllllIIlIlIIlllllIlIl = Blocks.SNOW_LAYER;
        return (llllllllllllllllIIlIlIIlllllIlII.getBlockState(llllllllllllllllIIlIlIIlllllIllI.north()).getBlock() == llllllllllllllllIIlIlIIlllllIlIl || llllllllllllllllIIlIlIIlllllIlII.getBlockState(llllllllllllllllIIlIlIIlllllIllI.south()).getBlock() == llllllllllllllllIIlIlIIlllllIlIl || llllllllllllllllIIlIlIIlllllIlII.getBlockState(llllllllllllllllIIlIlIIlllllIllI.west()).getBlock() == llllllllllllllllIIlIlIIlllllIlIl || llllllllllllllllIIlIlIIlllllIlII.getBlockState(llllllllllllllllIIlIlIIlllllIllI.east()).getBlock() == llllllllllllllllIIlIlIIlllllIlIl) && llllllllllllllllIIlIlIIlllllIlII.getBlockState(llllllllllllllllIIlIlIIlllllIllI.down()).isOpaqueCube();
    }
    
    public static boolean shouldRender(final IBlockAccess llllllllllllllllIIlIlIlIIIIIIIlI, final IBlockState llllllllllllllllIIlIlIlIIIIIIIIl, final BlockPos llllllllllllllllIIlIlIlIIIIIIIII) {
        final Block llllllllllllllllIIlIlIIlllllllll = llllllllllllllllIIlIlIlIIIIIIIIl.getBlock();
        return checkBlock(llllllllllllllllIIlIlIIlllllllll, llllllllllllllllIIlIlIlIIIIIIIIl) && hasSnowNeighbours(llllllllllllllllIIlIlIlIIIIIIIlI, llllllllllllllllIIlIlIlIIIIIIIII);
    }
}
