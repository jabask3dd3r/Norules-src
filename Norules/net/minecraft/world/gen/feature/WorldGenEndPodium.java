package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;

public class WorldGenEndPodium extends WorldGenerator
{
    private final /* synthetic */ boolean activePortal;
    public static final /* synthetic */ BlockPos END_PODIUM_LOCATION;
    
    public WorldGenEndPodium(final boolean llllllllllllllIIlIlllIlIIIIIllIl) {
        this.activePortal = llllllllllllllIIlIlllIlIIIIIllIl;
    }
    
    static {
        END_PODIUM_LOCATION = BlockPos.ORIGIN;
        END_PODIUM_CHUNK_POS = new BlockPos(WorldGenEndPodium.END_PODIUM_LOCATION.getX() - 4 & 0xFFFFFFF0, 0, WorldGenEndPodium.END_PODIUM_LOCATION.getZ() - 4 & 0xFFFFFFF0);
    }
    
    @Override
    public boolean generate(final World llllllllllllllIIlIlllIIllllllIlI, final Random llllllllllllllIIlIlllIlIIIIIIIlI, final BlockPos llllllllllllllIIlIlllIIllllllIIl) {
        for (final BlockPos.MutableBlockPos llllllllllllllIIlIlllIlIIIIIIIII : BlockPos.getAllInBoxMutable(new BlockPos(llllllllllllllIIlIlllIIllllllIIl.getX() - 4, llllllllllllllIIlIlllIIllllllIIl.getY() - 1, llllllllllllllIIlIlllIIllllllIIl.getZ() - 4), new BlockPos(llllllllllllllIIlIlllIIllllllIIl.getX() + 4, llllllllllllllIIlIlllIIllllllIIl.getY() + 32, llllllllllllllIIlIlllIIllllllIIl.getZ() + 4))) {
            final double llllllllllllllIIlIlllIIlllllllll = llllllllllllllIIlIlllIlIIIIIIIII.getDistance(llllllllllllllIIlIlllIIllllllIIl.getX(), llllllllllllllIIlIlllIlIIIIIIIII.getY(), llllllllllllllIIlIlllIIllllllIIl.getZ());
            if (llllllllllllllIIlIlllIIlllllllll <= 3.5) {
                if (llllllllllllllIIlIlllIlIIIIIIIII.getY() < llllllllllllllIIlIlllIIllllllIIl.getY()) {
                    if (llllllllllllllIIlIlllIIlllllllll <= 2.5) {
                        this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIlIIIIIIIII, Blocks.BEDROCK.getDefaultState());
                    }
                    else {
                        if (llllllllllllllIIlIlllIlIIIIIIIII.getY() >= llllllllllllllIIlIlllIIllllllIIl.getY()) {
                            continue;
                        }
                        this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIlIIIIIIIII, Blocks.END_STONE.getDefaultState());
                    }
                }
                else if (llllllllllllllIIlIlllIlIIIIIIIII.getY() > llllllllllllllIIlIlllIIllllllIIl.getY()) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIlIIIIIIIII, Blocks.AIR.getDefaultState());
                }
                else if (llllllllllllllIIlIlllIIlllllllll > 2.5) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIlIIIIIIIII, Blocks.BEDROCK.getDefaultState());
                }
                else if (this.activePortal) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, new BlockPos(llllllllllllllIIlIlllIlIIIIIIIII), Blocks.END_PORTAL.getDefaultState());
                }
                else {
                    this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, new BlockPos(llllllllllllllIIlIlllIlIIIIIIIII), Blocks.AIR.getDefaultState());
                }
            }
        }
        for (int llllllllllllllIIlIlllIIllllllllI = 0; llllllllllllllIIlIlllIIllllllllI < 4; ++llllllllllllllIIlIlllIIllllllllI) {
            this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIIllllllIIl.up(llllllllllllllIIlIlllIIllllllllI), Blocks.BEDROCK.getDefaultState());
        }
        final BlockPos llllllllllllllIIlIlllIIlllllllIl = llllllllllllllIIlIlllIIllllllIIl.up(2);
        for (final EnumFacing llllllllllllllIIlIlllIIlllllllII : EnumFacing.Plane.HORIZONTAL) {
            this.setBlockAndNotifyAdequately(llllllllllllllIIlIlllIIllllllIlI, llllllllllllllIIlIlllIIlllllllIl.offset(llllllllllllllIIlIlllIIlllllllII), Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllllIIlIlllIIlllllllII));
        }
        return true;
    }
}
