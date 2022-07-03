package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;

public class WorldGenTallGrass extends WorldGenerator
{
    private final /* synthetic */ IBlockState tallGrassState;
    
    @Override
    public boolean generate(final World lllllllllllllIIIlIIlIllIIllIllll, final Random lllllllllllllIIIlIIlIllIIlllIlIl, BlockPos lllllllllllllIIIlIIlIllIIllIllIl) {
        for (IBlockState lllllllllllllIIIlIIlIllIIlllIIll = lllllllllllllIIIlIIlIllIIllIllll.getBlockState((BlockPos)lllllllllllllIIIlIIlIllIIllIllIl); (lllllllllllllIIIlIIlIllIIlllIIll.getMaterial() == Material.AIR || lllllllllllllIIIlIIlIllIIlllIIll.getMaterial() == Material.LEAVES) && ((Vec3i)lllllllllllllIIIlIIlIllIIllIllIl).getY() > 0; lllllllllllllIIIlIIlIllIIllIllIl = ((BlockPos)lllllllllllllIIIlIIlIllIIllIllIl).down(), lllllllllllllIIIlIIlIllIIlllIIll = lllllllllllllIIIlIIlIllIIllIllll.getBlockState((BlockPos)lllllllllllllIIIlIIlIllIIllIllIl)) {}
        for (int lllllllllllllIIIlIIlIllIIlllIIlI = 0; lllllllllllllIIIlIIlIllIIlllIIlI < 128; ++lllllllllllllIIIlIIlIllIIlllIIlI) {
            final BlockPos lllllllllllllIIIlIIlIllIIlllIIIl = ((BlockPos)lllllllllllllIIIlIIlIllIIllIllIl).add(lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(8) - lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(8), lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(4) - lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(4), lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(8) - lllllllllllllIIIlIIlIllIIlllIlIl.nextInt(8));
            if (lllllllllllllIIIlIIlIllIIllIllll.isAirBlock(lllllllllllllIIIlIIlIllIIlllIIIl) && Blocks.TALLGRASS.canBlockStay(lllllllllllllIIIlIIlIllIIllIllll, lllllllllllllIIIlIIlIllIIlllIIIl, this.tallGrassState)) {
                lllllllllllllIIIlIIlIllIIllIllll.setBlockState(lllllllllllllIIIlIIlIllIIlllIIIl, this.tallGrassState, 2);
            }
        }
        return true;
    }
    
    public WorldGenTallGrass(final BlockTallGrass.EnumType lllllllllllllIIIlIIlIllIIllllllI) {
        this.tallGrassState = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, lllllllllllllIIIlIIlIllIIllllllI);
    }
}
