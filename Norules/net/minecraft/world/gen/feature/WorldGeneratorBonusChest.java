package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;

public class WorldGeneratorBonusChest extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIIIIIlIIllllIIlIlI, final Random lllllllllllllIIIIIIlIIllllIIlIIl, BlockPos lllllllllllllIIIIIIlIIlllIllllIl) {
        for (IBlockState lllllllllllllIIIIIIlIIllllIIIlll = lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState((BlockPos)lllllllllllllIIIIIIlIIlllIllllIl); (lllllllllllllIIIIIIlIIllllIIIlll.getMaterial() == Material.AIR || lllllllllllllIIIIIIlIIllllIIIlll.getMaterial() == Material.LEAVES) && ((Vec3i)lllllllllllllIIIIIIlIIlllIllllIl).getY() > 1; lllllllllllllIIIIIIlIIlllIllllIl = ((BlockPos)lllllllllllllIIIIIIlIIlllIllllIl).down(), lllllllllllllIIIIIIlIIllllIIIlll = lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState((BlockPos)lllllllllllllIIIIIIlIIlllIllllIl)) {}
        if (((Vec3i)lllllllllllllIIIIIIlIIlllIllllIl).getY() < 1) {
            return false;
        }
        lllllllllllllIIIIIIlIIlllIllllIl = ((BlockPos)lllllllllllllIIIIIIlIIlllIllllIl).up();
        for (int lllllllllllllIIIIIIlIIllllIIIllI = 0; lllllllllllllIIIIIIlIIllllIIIllI < 4; ++lllllllllllllIIIIIIlIIllllIIIllI) {
            final BlockPos lllllllllllllIIIIIIlIIllllIIIlIl = ((BlockPos)lllllllllllllIIIIIIlIIlllIllllIl).add(lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(4) - lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(4), lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(3) - lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(3), lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(4) - lllllllllllllIIIIIIlIIllllIIlIIl.nextInt(4));
            if (lllllllllllllIIIIIIlIIllllIIlIlI.isAirBlock(lllllllllllllIIIIIIlIIllllIIIlIl) && lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState(lllllllllllllIIIIIIlIIllllIIIlIl.down()).isFullyOpaque()) {
                lllllllllllllIIIIIIlIIllllIIlIlI.setBlockState(lllllllllllllIIIIIIlIIllllIIIlIl, Blocks.CHEST.getDefaultState(), 2);
                final TileEntity lllllllllllllIIIIIIlIIllllIIIlII = lllllllllllllIIIIIIlIIllllIIlIlI.getTileEntity(lllllllllllllIIIIIIlIIllllIIIlIl);
                if (lllllllllllllIIIIIIlIIllllIIIlII instanceof TileEntityChest) {
                    ((TileEntityChest)lllllllllllllIIIIIIlIIllllIIIlII).setLootTable(LootTableList.CHESTS_SPAWN_BONUS_CHEST, lllllllllllllIIIIIIlIIllllIIlIIl.nextLong());
                }
                final BlockPos lllllllllllllIIIIIIlIIllllIIIIll = lllllllllllllIIIIIIlIIllllIIIlIl.east();
                final BlockPos lllllllllllllIIIIIIlIIllllIIIIlI = lllllllllllllIIIIIIlIIllllIIIlIl.west();
                final BlockPos lllllllllllllIIIIIIlIIllllIIIIIl = lllllllllllllIIIIIIlIIllllIIIlIl.north();
                final BlockPos lllllllllllllIIIIIIlIIllllIIIIII = lllllllllllllIIIIIIlIIllllIIIlIl.south();
                if (lllllllllllllIIIIIIlIIllllIIlIlI.isAirBlock(lllllllllllllIIIIIIlIIllllIIIIlI) && lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState(lllllllllllllIIIIIIlIIllllIIIIlI.down()).isFullyOpaque()) {
                    lllllllllllllIIIIIIlIIllllIIlIlI.setBlockState(lllllllllllllIIIIIIlIIllllIIIIlI, Blocks.TORCH.getDefaultState(), 2);
                }
                if (lllllllllllllIIIIIIlIIllllIIlIlI.isAirBlock(lllllllllllllIIIIIIlIIllllIIIIll) && lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState(lllllllllllllIIIIIIlIIllllIIIIll.down()).isFullyOpaque()) {
                    lllllllllllllIIIIIIlIIllllIIlIlI.setBlockState(lllllllllllllIIIIIIlIIllllIIIIll, Blocks.TORCH.getDefaultState(), 2);
                }
                if (lllllllllllllIIIIIIlIIllllIIlIlI.isAirBlock(lllllllllllllIIIIIIlIIllllIIIIIl) && lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState(lllllllllllllIIIIIIlIIllllIIIIIl.down()).isFullyOpaque()) {
                    lllllllllllllIIIIIIlIIllllIIlIlI.setBlockState(lllllllllllllIIIIIIlIIllllIIIIIl, Blocks.TORCH.getDefaultState(), 2);
                }
                if (lllllllllllllIIIIIIlIIllllIIlIlI.isAirBlock(lllllllllllllIIIIIIlIIllllIIIIII) && lllllllllllllIIIIIIlIIllllIIlIlI.getBlockState(lllllllllllllIIIIIIlIIllllIIIIII.down()).isFullyOpaque()) {
                    lllllllllllllIIIIIIlIIllllIIlIlI.setBlockState(lllllllllllllIIIIIIlIIllllIIIIII, Blocks.TORCH.getDefaultState(), 2);
                }
                return true;
            }
        }
        return false;
    }
}
