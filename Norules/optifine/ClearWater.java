package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;

public class ClearWater
{
    public static void updateWaterOpacity(final GameSettings lllllllllllllllIllIIIIlIlIllIIll, final World lllllllllllllllIllIIIIlIlIIlIlll) {
        if (lllllllllllllllIllIIIIlIlIllIIll != null) {
            int lllllllllllllllIllIIIIlIlIllIIIl = 3;
            if (lllllllllllllllIllIIIIlIlIllIIll.ofClearWater) {
                lllllllllllllllIllIIIIlIlIllIIIl = 1;
            }
            BlockAir.setLightOpacity(Blocks.WATER, lllllllllllllllIllIIIIlIlIllIIIl);
            BlockAir.setLightOpacity(Blocks.FLOWING_WATER, lllllllllllllllIllIIIIlIlIllIIIl);
        }
        if (lllllllllllllllIllIIIIlIlIIlIlll != null) {
            final IChunkProvider lllllllllllllllIllIIIIlIlIllIIII = lllllllllllllllIllIIIIlIlIIlIlll.getChunkProvider();
            if (lllllllllllllllIllIIIIlIlIllIIII != null) {
                final Entity lllllllllllllllIllIIIIlIlIlIllll = Config.getMinecraft().getRenderViewEntity();
                if (lllllllllllllllIllIIIIlIlIlIllll != null) {
                    final int lllllllllllllllIllIIIIlIlIlIlllI = (int)lllllllllllllllIllIIIIlIlIlIllll.posX / 16;
                    final int lllllllllllllllIllIIIIlIlIlIllIl = (int)lllllllllllllllIllIIIIlIlIlIllll.posZ / 16;
                    final int lllllllllllllllIllIIIIlIlIlIllII = lllllllllllllllIllIIIIlIlIlIlllI - 512;
                    final int lllllllllllllllIllIIIIlIlIlIlIll = lllllllllllllllIllIIIIlIlIlIlllI + 512;
                    final int lllllllllllllllIllIIIIlIlIlIlIlI = lllllllllllllllIllIIIIlIlIlIllIl - 512;
                    final int lllllllllllllllIllIIIIlIlIlIlIIl = lllllllllllllllIllIIIIlIlIlIllIl + 512;
                    int lllllllllllllllIllIIIIlIlIlIlIII = 0;
                    for (int lllllllllllllllIllIIIIlIlIlIIlll = lllllllllllllllIllIIIIlIlIlIllII; lllllllllllllllIllIIIIlIlIlIIlll < lllllllllllllllIllIIIIlIlIlIlIll; ++lllllllllllllllIllIIIIlIlIlIIlll) {
                        for (int lllllllllllllllIllIIIIlIlIlIIllI = lllllllllllllllIllIIIIlIlIlIlIlI; lllllllllllllllIllIIIIlIlIlIIllI < lllllllllllllllIllIIIIlIlIlIlIIl; ++lllllllllllllllIllIIIIlIlIlIIllI) {
                            final Chunk lllllllllllllllIllIIIIlIlIlIIlIl = lllllllllllllllIllIIIIlIlIllIIII.getLoadedChunk(lllllllllllllllIllIIIIlIlIlIIlll, lllllllllllllllIllIIIIlIlIlIIllI);
                            if (lllllllllllllllIllIIIIlIlIlIIlIl != null && !(lllllllllllllllIllIIIIlIlIlIIlIl instanceof EmptyChunk)) {
                                final int lllllllllllllllIllIIIIlIlIlIIlII = lllllllllllllllIllIIIIlIlIlIIlll << 4;
                                final int lllllllllllllllIllIIIIlIlIlIIIll = lllllllllllllllIllIIIIlIlIlIIllI << 4;
                                final int lllllllllllllllIllIIIIlIlIlIIIlI = lllllllllllllllIllIIIIlIlIlIIlII + 16;
                                final int lllllllllllllllIllIIIIlIlIlIIIIl = lllllllllllllllIllIIIIlIlIlIIIll + 16;
                                final BlockPosM lllllllllllllllIllIIIIlIlIlIIIII = new BlockPosM(0, 0, 0);
                                final BlockPosM lllllllllllllllIllIIIIlIlIIlllll = new BlockPosM(0, 0, 0);
                                for (int lllllllllllllllIllIIIIlIlIIllllI = lllllllllllllllIllIIIIlIlIlIIlII; lllllllllllllllIllIIIIlIlIIllllI < lllllllllllllllIllIIIIlIlIlIIIlI; ++lllllllllllllllIllIIIIlIlIIllllI) {
                                    for (int lllllllllllllllIllIIIIlIlIIlllIl = lllllllllllllllIllIIIIlIlIlIIIll; lllllllllllllllIllIIIIlIlIIlllIl < lllllllllllllllIllIIIIlIlIlIIIIl; ++lllllllllllllllIllIIIIlIlIIlllIl) {
                                        lllllllllllllllIllIIIIlIlIlIIIII.setXyz(lllllllllllllllIllIIIIlIlIIllllI, 0, lllllllllllllllIllIIIIlIlIIlllIl);
                                        final BlockPos lllllllllllllllIllIIIIlIlIIlllII = lllllllllllllllIllIIIIlIlIIlIlll.getPrecipitationHeight(lllllllllllllllIllIIIIlIlIlIIIII);
                                        for (int lllllllllllllllIllIIIIlIlIIllIll = 0; lllllllllllllllIllIIIIlIlIIllIll < lllllllllllllllIllIIIIlIlIIlllII.getY(); ++lllllllllllllllIllIIIIlIlIIllIll) {
                                            lllllllllllllllIllIIIIlIlIIlllll.setXyz(lllllllllllllllIllIIIIlIlIIllllI, lllllllllllllllIllIIIIlIlIIllIll, lllllllllllllllIllIIIIlIlIIlllIl);
                                            final IBlockState lllllllllllllllIllIIIIlIlIIllIlI = lllllllllllllllIllIIIIlIlIIlIlll.getBlockState(lllllllllllllllIllIIIIlIlIIlllll);
                                            if (lllllllllllllllIllIIIIlIlIIllIlI.getMaterial() == Material.WATER) {
                                                lllllllllllllllIllIIIIlIlIIlIlll.markBlocksDirtyVertical(lllllllllllllllIllIIIIlIlIIllllI, lllllllllllllllIllIIIIlIlIIlllIl, lllllllllllllllIllIIIIlIlIIlllll.getY(), lllllllllllllllIllIIIIlIlIIlllII.getY());
                                                ++lllllllllllllllIllIIIIlIlIlIlIII;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (lllllllllllllllIllIIIIlIlIlIlIII > 0) {
                        String lllllllllllllllIllIIIIlIlIIllIIl = "server";
                        if (Config.isMinecraftThread()) {
                            lllllllllllllllIllIIIIlIlIIllIIl = "client";
                        }
                        Config.dbg(String.valueOf(new StringBuilder("ClearWater (").append(lllllllllllllllIllIIIIlIlIIllIIl).append(") relighted ").append(lllllllllllllllIllIIIIlIlIlIlIII).append(" chunks")));
                    }
                }
            }
        }
    }
}
