package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.math.*;

public class WorldGenLakes extends WorldGenerator
{
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World llllllllllllllIIIlIIIIllIIlIlIII, final Random llllllllllllllIIIlIIIIllIIlIIlll, BlockPos llllllllllllllIIIlIIIIlIlllllllI) {
        for (llllllllllllllIIIlIIIIlIlllllllI = (int)((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(-8, 0, -8); ((Vec3i)llllllllllllllIIIlIIIIlIlllllllI).getY() > 5 && llllllllllllllIIIlIIIIllIIlIlIII.isAirBlock((BlockPos)llllllllllllllIIIlIIIIlIlllllllI); llllllllllllllIIIlIIIIlIlllllllI = (int)((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).down()) {}
        if (((Vec3i)llllllllllllllIIIlIIIIlIlllllllI).getY() <= 4) {
            return false;
        }
        llllllllllllllIIIlIIIIlIlllllllI = (int)((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).down(4);
        final boolean[] llllllllllllllIIIlIIIIllIIlIIlIl = new boolean[2048];
        for (int llllllllllllllIIIlIIIIllIIlIIlII = llllllllllllllIIIlIIIIllIIlIIlll.nextInt(4) + 4, llllllllllllllIIIlIIIIllIIlIIIll = 0; llllllllllllllIIIlIIIIllIIlIIIll < llllllllllllllIIIlIIIIllIIlIIlII; ++llllllllllllllIIIlIIIIllIIlIIIll) {
            final double llllllllllllllIIIlIIIIllIIlIIIlI = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * 6.0 + 3.0;
            final double llllllllllllllIIIlIIIIllIIlIIIIl = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * 4.0 + 2.0;
            final double llllllllllllllIIIlIIIIllIIlIIIII = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * 6.0 + 3.0;
            final double llllllllllllllIIIlIIIIllIIIlllll = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * (16.0 - llllllllllllllIIIlIIIIllIIlIIIlI - 2.0) + 1.0 + llllllllllllllIIIlIIIIllIIlIIIlI / 2.0;
            final double llllllllllllllIIIlIIIIllIIIllllI = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * (8.0 - llllllllllllllIIIlIIIIllIIlIIIIl - 4.0) + 2.0 + llllllllllllllIIIlIIIIllIIlIIIIl / 2.0;
            final double llllllllllllllIIIlIIIIllIIIlllIl = llllllllllllllIIIlIIIIllIIlIIlll.nextDouble() * (16.0 - llllllllllllllIIIlIIIIllIIlIIIII - 2.0) + 1.0 + llllllllllllllIIIlIIIIllIIlIIIII / 2.0;
            for (int llllllllllllllIIIlIIIIllIIIlllII = 1; llllllllllllllIIIlIIIIllIIIlllII < 15; ++llllllllllllllIIIlIIIIllIIIlllII) {
                for (int llllllllllllllIIIlIIIIllIIIllIll = 1; llllllllllllllIIIlIIIIllIIIllIll < 15; ++llllllllllllllIIIlIIIIllIIIllIll) {
                    for (int llllllllllllllIIIlIIIIllIIIllIlI = 1; llllllllllllllIIIlIIIIllIIIllIlI < 7; ++llllllllllllllIIIlIIIIllIIIllIlI) {
                        final double llllllllllllllIIIlIIIIllIIIllIIl = (llllllllllllllIIIlIIIIllIIIlllII - llllllllllllllIIIlIIIIllIIIlllll) / (llllllllllllllIIIlIIIIllIIlIIIlI / 2.0);
                        final double llllllllllllllIIIlIIIIllIIIllIII = (llllllllllllllIIIlIIIIllIIIllIlI - llllllllllllllIIIlIIIIllIIIllllI) / (llllllllllllllIIIlIIIIllIIlIIIIl / 2.0);
                        final double llllllllllllllIIIlIIIIllIIIlIlll = (llllllllllllllIIIlIIIIllIIIllIll - llllllllllllllIIIlIIIIllIIIlllIl) / (llllllllllllllIIIlIIIIllIIlIIIII / 2.0);
                        final double llllllllllllllIIIlIIIIllIIIlIllI = llllllllllllllIIIlIIIIllIIIllIIl * llllllllllllllIIIlIIIIllIIIllIIl + llllllllllllllIIIlIIIIllIIIllIII * llllllllllllllIIIlIIIIllIIIllIII + llllllllllllllIIIlIIIIllIIIlIlll * llllllllllllllIIIlIIIIllIIIlIlll;
                        if (llllllllllllllIIIlIIIIllIIIlIllI < 1.0) {
                            llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlllII * 16 + llllllllllllllIIIlIIIIllIIIllIll) * 8 + llllllllllllllIIIlIIIIllIIIllIlI] = true;
                        }
                    }
                }
            }
        }
        for (int llllllllllllllIIIlIIIIllIIIlIlIl = 0; llllllllllllllIIIlIIIIllIIIlIlIl < 16; ++llllllllllllllIIIlIIIIllIIIlIlIl) {
            for (int llllllllllllllIIIlIIIIllIIIlIlII = 0; llllllllllllllIIIlIIIIllIIIlIlII < 16; ++llllllllllllllIIIlIIIIllIIIlIlII) {
                for (int llllllllllllllIIIlIIIIllIIIlIIll = 0; llllllllllllllIIIlIIIIllIIIlIIll < 8; ++llllllllllllllIIIlIIIIllIIIlIIll) {
                    final boolean llllllllllllllIIIlIIIIllIIIlIIlI = !llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIlIl * 16 + llllllllllllllIIIlIIIIllIIIlIlII) * 8 + llllllllllllllIIIlIIIIllIIIlIIll] && ((llllllllllllllIIIlIIIIllIIIlIlIl < 15 && llllllllllllllIIIlIIIIllIIlIIlIl[((llllllllllllllIIIlIIIIllIIIlIlIl + 1) * 16 + llllllllllllllIIIlIIIIllIIIlIlII) * 8 + llllllllllllllIIIlIIIIllIIIlIIll]) || (llllllllllllllIIIlIIIIllIIIlIlIl > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[((llllllllllllllIIIlIIIIllIIIlIlIl - 1) * 16 + llllllllllllllIIIlIIIIllIIIlIlII) * 8 + llllllllllllllIIIlIIIIllIIIlIIll]) || (llllllllllllllIIIlIIIIllIIIlIlII < 15 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIlIl * 16 + llllllllllllllIIIlIIIIllIIIlIlII + 1) * 8 + llllllllllllllIIIlIIIIllIIIlIIll]) || (llllllllllllllIIIlIIIIllIIIlIlII > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIlIl * 16 + (llllllllllllllIIIlIIIIllIIIlIlII - 1)) * 8 + llllllllllllllIIIlIIIIllIIIlIIll]) || (llllllllllllllIIIlIIIIllIIIlIIll < 7 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIlIl * 16 + llllllllllllllIIIlIIIIllIIIlIlII) * 8 + llllllllllllllIIIlIIIIllIIIlIIll + 1]) || (llllllllllllllIIIlIIIIllIIIlIIll > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIlIl * 16 + llllllllllllllIIIlIIIIllIIIlIlII) * 8 + (llllllllllllllIIIlIIIIllIIIlIIll - 1)]));
                    if (llllllllllllllIIIlIIIIllIIIlIIlI) {
                        final Material llllllllllllllIIIlIIIIllIIIlIIIl = llllllllllllllIIIlIIIIllIIlIlIII.getBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIlIlIl, llllllllllllllIIIlIIIIllIIIlIIll, llllllllllllllIIIlIIIIllIIIlIlII)).getMaterial();
                        if (llllllllllllllIIIlIIIIllIIIlIIll >= 4 && llllllllllllllIIIlIIIIllIIIlIIIl.isLiquid()) {
                            return false;
                        }
                        if (llllllllllllllIIIlIIIIllIIIlIIll < 4 && !llllllllllllllIIIlIIIIllIIIlIIIl.isSolid() && llllllllllllllIIIlIIIIllIIlIlIII.getBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIlIlIl, llllllllllllllIIIlIIIIllIIIlIIll, llllllllllllllIIIlIIIIllIIIlIlII)).getBlock() != this.block) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int llllllllllllllIIIlIIIIllIIIlIIII = 0; llllllllllllllIIIlIIIIllIIIlIIII < 16; ++llllllllllllllIIIlIIIIllIIIlIIII) {
            for (int llllllllllllllIIIlIIIIllIIIIllll = 0; llllllllllllllIIIlIIIIllIIIIllll < 16; ++llllllllllllllIIIlIIIIllIIIIllll) {
                for (int llllllllllllllIIIlIIIIllIIIIlllI = 0; llllllllllllllIIIlIIIIllIIIIlllI < 8; ++llllllllllllllIIIlIIIIllIIIIlllI) {
                    if (llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIlIIII * 16 + llllllllllllllIIIlIIIIllIIIIllll) * 8 + llllllllllllllIIIlIIIIllIIIIlllI]) {
                        llllllllllllllIIIlIIIIllIIlIlIII.setBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIlIIII, llllllllllllllIIIlIIIIllIIIIlllI, llllllllllllllIIIlIIIIllIIIIllll), (llllllllllllllIIIlIIIIllIIIIlllI >= 4) ? Blocks.AIR.getDefaultState() : this.block.getDefaultState(), 2);
                    }
                }
            }
        }
        for (int llllllllllllllIIIlIIIIllIIIIllIl = 0; llllllllllllllIIIlIIIIllIIIIllIl < 16; ++llllllllllllllIIIlIIIIllIIIIllIl) {
            for (int llllllllllllllIIIlIIIIllIIIIllII = 0; llllllllllllllIIIlIIIIllIIIIllII < 16; ++llllllllllllllIIIlIIIIllIIIIllII) {
                for (int llllllllllllllIIIlIIIIllIIIIlIll = 4; llllllllllllllIIIlIIIIllIIIIlIll < 8; ++llllllllllllllIIIlIIIIllIIIIlIll) {
                    if (llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIllIl * 16 + llllllllllllllIIIlIIIIllIIIIllII) * 8 + llllllllllllllIIIlIIIIllIIIIlIll]) {
                        final BlockPos llllllllllllllIIIlIIIIllIIIIlIlI = ((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIllIl, llllllllllllllIIIlIIIIllIIIIlIll - 1, llllllllllllllIIIlIIIIllIIIIllII);
                        if (llllllllllllllIIIlIIIIllIIlIlIII.getBlockState(llllllllllllllIIIlIIIIllIIIIlIlI).getBlock() == Blocks.DIRT && llllllllllllllIIIlIIIIllIIlIlIII.getLightFor(EnumSkyBlock.SKY, ((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIllIl, llllllllllllllIIIlIIIIllIIIIlIll, llllllllllllllIIIlIIIIllIIIIllII)) > 0) {
                            final Biome llllllllllllllIIIlIIIIllIIIIlIIl = llllllllllllllIIIlIIIIllIIlIlIII.getBiome(llllllllllllllIIIlIIIIllIIIIlIlI);
                            if (llllllllllllllIIIlIIIIllIIIIlIIl.topBlock.getBlock() == Blocks.MYCELIUM) {
                                llllllllllllllIIIlIIIIllIIlIlIII.setBlockState(llllllllllllllIIIlIIIIllIIIIlIlI, Blocks.MYCELIUM.getDefaultState(), 2);
                            }
                            else {
                                llllllllllllllIIIlIIIIllIIlIlIII.setBlockState(llllllllllllllIIIlIIIIllIIIIlIlI, Blocks.GRASS.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        if (this.block.getDefaultState().getMaterial() == Material.LAVA) {
            for (int llllllllllllllIIIlIIIIllIIIIlIII = 0; llllllllllllllIIIlIIIIllIIIIlIII < 16; ++llllllllllllllIIIlIIIIllIIIIlIII) {
                for (int llllllllllllllIIIlIIIIllIIIIIlll = 0; llllllllllllllIIIlIIIIllIIIIIlll < 16; ++llllllllllllllIIIlIIIIllIIIIIlll) {
                    for (int llllllllllllllIIIlIIIIllIIIIIllI = 0; llllllllllllllIIIlIIIIllIIIIIllI < 8; ++llllllllllllllIIIlIIIIllIIIIIllI) {
                        final boolean llllllllllllllIIIlIIIIllIIIIIlIl = !llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIlIII * 16 + llllllllllllllIIIlIIIIllIIIIIlll) * 8 + llllllllllllllIIIlIIIIllIIIIIllI] && ((llllllllllllllIIIlIIIIllIIIIlIII < 15 && llllllllllllllIIIlIIIIllIIlIIlIl[((llllllllllllllIIIlIIIIllIIIIlIII + 1) * 16 + llllllllllllllIIIlIIIIllIIIIIlll) * 8 + llllllllllllllIIIlIIIIllIIIIIllI]) || (llllllllllllllIIIlIIIIllIIIIlIII > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[((llllllllllllllIIIlIIIIllIIIIlIII - 1) * 16 + llllllllllllllIIIlIIIIllIIIIIlll) * 8 + llllllllllllllIIIlIIIIllIIIIIllI]) || (llllllllllllllIIIlIIIIllIIIIIlll < 15 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIlIII * 16 + llllllllllllllIIIlIIIIllIIIIIlll + 1) * 8 + llllllllllllllIIIlIIIIllIIIIIllI]) || (llllllllllllllIIIlIIIIllIIIIIlll > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIlIII * 16 + (llllllllllllllIIIlIIIIllIIIIIlll - 1)) * 8 + llllllllllllllIIIlIIIIllIIIIIllI]) || (llllllllllllllIIIlIIIIllIIIIIllI < 7 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIlIII * 16 + llllllllllllllIIIlIIIIllIIIIIlll) * 8 + llllllllllllllIIIlIIIIllIIIIIllI + 1]) || (llllllllllllllIIIlIIIIllIIIIIllI > 0 && llllllllllllllIIIlIIIIllIIlIIlIl[(llllllllllllllIIIlIIIIllIIIIlIII * 16 + llllllllllllllIIIlIIIIllIIIIIlll) * 8 + (llllllllllllllIIIlIIIIllIIIIIllI - 1)]));
                        if (llllllllllllllIIIlIIIIllIIIIIlIl && (llllllllllllllIIIlIIIIllIIIIIllI < 4 || llllllllllllllIIIlIIIIllIIlIIlll.nextInt(2) != 0) && llllllllllllllIIIlIIIIllIIlIlIII.getBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIlIII, llllllllllllllIIIlIIIIllIIIIIllI, llllllllllllllIIIlIIIIllIIIIIlll)).getMaterial().isSolid()) {
                            llllllllllllllIIIlIIIIllIIlIlIII.setBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIlIII, llllllllllllllIIIlIIIIllIIIIIllI, llllllllllllllIIIlIIIIllIIIIIlll), Blocks.STONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        if (this.block.getDefaultState().getMaterial() == Material.WATER) {
            for (int llllllllllllllIIIlIIIIllIIIIIlII = 0; llllllllllllllIIIlIIIIllIIIIIlII < 16; ++llllllllllllllIIIlIIIIllIIIIIlII) {
                for (int llllllllllllllIIIlIIIIllIIIIIIll = 0; llllllllllllllIIIlIIIIllIIIIIIll < 16; ++llllllllllllllIIIlIIIIllIIIIIIll) {
                    final int llllllllllllllIIIlIIIIllIIIIIIlI = 4;
                    if (llllllllllllllIIIlIIIIllIIlIlIII.canBlockFreezeWater(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIIlII, 4, llllllllllllllIIIlIIIIllIIIIIIll))) {
                        llllllllllllllIIIlIIIIllIIlIlIII.setBlockState(((BlockPos)llllllllllllllIIIlIIIIlIlllllllI).add(llllllllllllllIIIlIIIIllIIIIIlII, 4, llllllllllllllIIIlIIIIllIIIIIIll), Blocks.ICE.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenLakes(final Block llllllllllllllIIIlIIIIllIlIIIIII) {
        this.block = llllllllllllllIIIlIIIIllIlIIIIII;
    }
}
