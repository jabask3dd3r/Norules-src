package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class WorldGenShrub extends WorldGenTrees
{
    private final /* synthetic */ IBlockState leavesMetadata;
    private final /* synthetic */ IBlockState woodMetadata;
    
    @Override
    public boolean generate(final World llllllllllllllllIIIlllllIlIIlIIl, final Random llllllllllllllllIIIlllllIIlllIIl, BlockPos llllllllllllllllIIIlllllIIlllIII) {
        for (IBlockState llllllllllllllllIIIlllllIlIIIllI = llllllllllllllllIIIlllllIlIIlIIl.getBlockState((BlockPos)llllllllllllllllIIIlllllIIlllIII); (llllllllllllllllIIIlllllIlIIIllI.getMaterial() == Material.AIR || llllllllllllllllIIIlllllIlIIIllI.getMaterial() == Material.LEAVES) && ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getY() > 0; llllllllllllllllIIIlllllIIlllIII = ((BlockPos)llllllllllllllllIIIlllllIIlllIII).down(), llllllllllllllllIIIlllllIlIIIllI = llllllllllllllllIIIlllllIlIIlIIl.getBlockState((BlockPos)llllllllllllllllIIIlllllIIlllIII)) {}
        final Block llllllllllllllllIIIlllllIlIIIlIl = llllllllllllllllIIIlllllIlIIlIIl.getBlockState((BlockPos)llllllllllllllllIIIlllllIIlllIII).getBlock();
        if (llllllllllllllllIIIlllllIlIIIlIl == Blocks.DIRT || llllllllllllllllIIIlllllIlIIIlIl == Blocks.GRASS) {
            llllllllllllllllIIIlllllIIlllIII = ((BlockPos)llllllllllllllllIIIlllllIIlllIII).up();
            this.setBlockAndNotifyAdequately(llllllllllllllllIIIlllllIlIIlIIl, (BlockPos)llllllllllllllllIIIlllllIIlllIII, this.woodMetadata);
            for (int llllllllllllllllIIIlllllIlIIIlII = ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getY(); llllllllllllllllIIIlllllIlIIIlII <= ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getY() + 2; ++llllllllllllllllIIIlllllIlIIIlII) {
                final int llllllllllllllllIIIlllllIlIIIIll = llllllllllllllllIIIlllllIlIIIlII - ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getY();
                for (int llllllllllllllllIIIlllllIlIIIIlI = 2 - llllllllllllllllIIIlllllIlIIIIll, llllllllllllllllIIIlllllIlIIIIIl = ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getX() - llllllllllllllllIIIlllllIlIIIIlI; llllllllllllllllIIIlllllIlIIIIIl <= ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getX() + llllllllllllllllIIIlllllIlIIIIlI; ++llllllllllllllllIIIlllllIlIIIIIl) {
                    final int llllllllllllllllIIIlllllIlIIIIII = llllllllllllllllIIIlllllIlIIIIIl - ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getX();
                    for (int llllllllllllllllIIIlllllIIllllll = ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getZ() - llllllllllllllllIIIlllllIlIIIIlI; llllllllllllllllIIIlllllIIllllll <= ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getZ() + llllllllllllllllIIIlllllIlIIIIlI; ++llllllllllllllllIIIlllllIIllllll) {
                        final int llllllllllllllllIIIlllllIIlllllI = llllllllllllllllIIIlllllIIllllll - ((Vec3i)llllllllllllllllIIIlllllIIlllIII).getZ();
                        if (Math.abs(llllllllllllllllIIIlllllIlIIIIII) != llllllllllllllllIIIlllllIlIIIIlI || Math.abs(llllllllllllllllIIIlllllIIlllllI) != llllllllllllllllIIIlllllIlIIIIlI || llllllllllllllllIIIlllllIIlllIIl.nextInt(2) != 0) {
                            final BlockPos llllllllllllllllIIIlllllIIllllIl = new BlockPos(llllllllllllllllIIIlllllIlIIIIIl, llllllllllllllllIIIlllllIlIIIlII, llllllllllllllllIIIlllllIIllllll);
                            final Material llllllllllllllllIIIlllllIIllllII = llllllllllllllllIIIlllllIlIIlIIl.getBlockState(llllllllllllllllIIIlllllIIllllIl).getMaterial();
                            if (llllllllllllllllIIIlllllIIllllII == Material.AIR || llllllllllllllllIIIlllllIIllllII == Material.LEAVES) {
                                this.setBlockAndNotifyAdequately(llllllllllllllllIIIlllllIlIIlIIl, llllllllllllllllIIIlllllIIllllIl, this.leavesMetadata);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenShrub(final IBlockState llllllllllllllllIIIlllllIlIllIlI, final IBlockState llllllllllllllllIIIlllllIlIllIIl) {
        super(false);
        this.woodMetadata = llllllllllllllllIIIlllllIlIllIlI;
        this.leavesMetadata = llllllllllllllllIIIlllllIlIllIIl;
    }
}
