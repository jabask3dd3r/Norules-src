package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class MapGenRavine extends MapGenBase
{
    protected static final /* synthetic */ IBlockState FLOWING_LAVA;
    private final /* synthetic */ float[] rs;
    protected static final /* synthetic */ IBlockState AIR;
    
    protected void addTunnel(final long lllllllllllllllllllIIllIlIIIIlII, final int lllllllllllllllllllIIllIIlIlIIII, final int lllllllllllllllllllIIllIIlIIllll, final ChunkPrimer lllllllllllllllllllIIllIIlIIlllI, double lllllllllllllllllllIIllIIlIIllIl, double lllllllllllllllllllIIllIIlIIllII, double lllllllllllllllllllIIllIIlIIlIll, final float lllllllllllllllllllIIllIIlllllIl, float lllllllllllllllllllIIllIIlIIlIIl, float lllllllllllllllllllIIllIIlIIlIII, int lllllllllllllllllllIIllIIlIIIlll, int lllllllllllllllllllIIllIIlIIIllI, final double lllllllllllllllllllIIllIIllllIII) {
        final Random lllllllllllllllllllIIllIIlllIlll = new Random(lllllllllllllllllllIIllIlIIIIlII);
        final double lllllllllllllllllllIIllIIlllIllI = lllllllllllllllllllIIllIIlIlIIII * 16 + 8;
        final double lllllllllllllllllllIIllIIlllIlIl = lllllllllllllllllllIIllIIlIIllll * 16 + 8;
        float lllllllllllllllllllIIllIIlllIlII = 0.0f;
        float lllllllllllllllllllIIllIIlllIIll = 0.0f;
        if (lllllllllllllllllllIIllIIlIIIllI <= 0) {
            final int lllllllllllllllllllIIllIIlllIIlI = this.range * 16 - 16;
            lllllllllllllllllllIIllIIlIIIllI = lllllllllllllllllllIIllIIlllIIlI - lllllllllllllllllllIIllIIlllIlll.nextInt(lllllllllllllllllllIIllIIlllIIlI / 4);
        }
        boolean lllllllllllllllllllIIllIIlllIIIl = false;
        if (lllllllllllllllllllIIllIIlIIIlll == -1) {
            lllllllllllllllllllIIllIIlIIIlll = lllllllllllllllllllIIllIIlIIIllI / 2;
            lllllllllllllllllllIIllIIlllIIIl = true;
        }
        float lllllllllllllllllllIIllIIlllIIII = 1.0f;
        for (int lllllllllllllllllllIIllIIllIllll = 0; lllllllllllllllllllIIllIIllIllll < 256; ++lllllllllllllllllllIIllIIllIllll) {
            if (lllllllllllllllllllIIllIIllIllll == 0 || lllllllllllllllllllIIllIIlllIlll.nextInt(3) == 0) {
                lllllllllllllllllllIIllIIlllIIII = 1.0f + lllllllllllllllllllIIllIIlllIlll.nextFloat() * lllllllllllllllllllIIllIIlllIlll.nextFloat();
            }
            this.rs[lllllllllllllllllllIIllIIllIllll] = lllllllllllllllllllIIllIIlllIIII * lllllllllllllllllllIIllIIlllIIII;
        }
        while (lllllllllllllllllllIIllIIlIIIlll < lllllllllllllllllllIIllIIlIIIllI) {
            double lllllllllllllllllllIIllIIllIlllI = 1.5 + MathHelper.sin(lllllllllllllllllllIIllIIlIIIlll * 3.1415927f / lllllllllllllllllllIIllIIlIIIllI) * lllllllllllllllllllIIllIIlllllIl;
            double lllllllllllllllllllIIllIIllIllIl = lllllllllllllllllllIIllIIllIlllI * lllllllllllllllllllIIllIIllllIII;
            lllllllllllllllllllIIllIIllIlllI *= lllllllllllllllllllIIllIIlllIlll.nextFloat() * 0.25 + 0.75;
            lllllllllllllllllllIIllIIllIllIl *= lllllllllllllllllllIIllIIlllIlll.nextFloat() * 0.25 + 0.75;
            final float lllllllllllllllllllIIllIIllIllII = MathHelper.cos(lllllllllllllllllllIIllIIlIIlIII);
            final float lllllllllllllllllllIIllIIllIlIll = MathHelper.sin(lllllllllllllllllllIIllIIlIIlIII);
            lllllllllllllllllllIIllIIlIIllIl += MathHelper.cos(lllllllllllllllllllIIllIIlIIlIIl) * lllllllllllllllllllIIllIIllIllII;
            lllllllllllllllllllIIllIIlIIllII += lllllllllllllllllllIIllIIllIlIll;
            lllllllllllllllllllIIllIIlIIlIll += MathHelper.sin(lllllllllllllllllllIIllIIlIIlIIl) * lllllllllllllllllllIIllIIllIllII;
            lllllllllllllllllllIIllIIlIIlIII *= 0.7f;
            lllllllllllllllllllIIllIIlIIlIII += lllllllllllllllllllIIllIIlllIIll * 0.05f;
            lllllllllllllllllllIIllIIlIIlIIl += lllllllllllllllllllIIllIIlllIlII * 0.05f;
            lllllllllllllllllllIIllIIlllIIll *= 0.8f;
            lllllllllllllllllllIIllIIlllIlII *= 0.5f;
            lllllllllllllllllllIIllIIlllIIll += (lllllllllllllllllllIIllIIlllIlll.nextFloat() - lllllllllllllllllllIIllIIlllIlll.nextFloat()) * lllllllllllllllllllIIllIIlllIlll.nextFloat() * 2.0f;
            lllllllllllllllllllIIllIIlllIlII += (lllllllllllllllllllIIllIIlllIlll.nextFloat() - lllllllllllllllllllIIllIIlllIlll.nextFloat()) * lllllllllllllllllllIIllIIlllIlll.nextFloat() * 4.0f;
            if (lllllllllllllllllllIIllIIlllIIIl || lllllllllllllllllllIIllIIlllIlll.nextInt(4) != 0) {
                final double lllllllllllllllllllIIllIIllIlIlI = lllllllllllllllllllIIllIIlIIllIl - lllllllllllllllllllIIllIIlllIllI;
                final double lllllllllllllllllllIIllIIllIlIIl = (double)(lllllllllllllllllllIIllIIlIIlIll - lllllllllllllllllllIIllIIlllIlIl);
                final double lllllllllllllllllllIIllIIllIlIII = (double)(lllllllllllllllllllIIllIIlIIIllI - lllllllllllllllllllIIllIIlIIIlll);
                final double lllllllllllllllllllIIllIIllIIlll = lllllllllllllllllllIIllIIlllllIl + 2.0f + 16.0f;
                if (lllllllllllllllllllIIllIIllIlIlI * lllllllllllllllllllIIllIIllIlIlI + lllllllllllllllllllIIllIIllIlIIl * lllllllllllllllllllIIllIIllIlIIl - lllllllllllllllllllIIllIIllIlIII * lllllllllllllllllllIIllIIllIlIII > lllllllllllllllllllIIllIIllIIlll * lllllllllllllllllllIIllIIllIIlll) {
                    return;
                }
                if (lllllllllllllllllllIIllIIlIIllIl >= lllllllllllllllllllIIllIIlllIllI - 16.0 - lllllllllllllllllllIIllIIllIlllI * 2.0 && lllllllllllllllllllIIllIIlIIlIll >= lllllllllllllllllllIIllIIlllIlIl - 16.0 - lllllllllllllllllllIIllIIllIlllI * 2.0 && lllllllllllllllllllIIllIIlIIllIl <= lllllllllllllllllllIIllIIlllIllI + 16.0 + lllllllllllllllllllIIllIIllIlllI * 2.0 && lllllllllllllllllllIIllIIlIIlIll <= lllllllllllllllllllIIllIIlllIlIl + 16.0 + lllllllllllllllllllIIllIIllIlllI * 2.0) {
                    int lllllllllllllllllllIIllIIllIIllI = MathHelper.floor(lllllllllllllllllllIIllIIlIIllIl - lllllllllllllllllllIIllIIllIlllI) - lllllllllllllllllllIIllIIlIlIIII * 16 - 1;
                    int lllllllllllllllllllIIllIIllIIlIl = MathHelper.floor(lllllllllllllllllllIIllIIlIIllIl + lllllllllllllllllllIIllIIllIlllI) - lllllllllllllllllllIIllIIlIlIIII * 16 + 1;
                    int lllllllllllllllllllIIllIIllIIlII = MathHelper.floor(lllllllllllllllllllIIllIIlIIllII - lllllllllllllllllllIIllIIllIllIl) - 1;
                    int lllllllllllllllllllIIllIIllIIIll = MathHelper.floor(lllllllllllllllllllIIllIIlIIllII + lllllllllllllllllllIIllIIllIllIl) + 1;
                    int lllllllllllllllllllIIllIIllIIIlI = MathHelper.floor((double)(lllllllllllllllllllIIllIIlIIlIll - lllllllllllllllllllIIllIIllIlllI)) - lllllllllllllllllllIIllIIlIIllll * 16 - 1;
                    int lllllllllllllllllllIIllIIllIIIIl = MathHelper.floor((double)(lllllllllllllllllllIIllIIlIIlIll + lllllllllllllllllllIIllIIllIlllI)) - lllllllllllllllllllIIllIIlIIllll * 16 + 1;
                    if (lllllllllllllllllllIIllIIllIIllI < 0) {
                        lllllllllllllllllllIIllIIllIIllI = 0;
                    }
                    if (lllllllllllllllllllIIllIIllIIlIl > 16) {
                        lllllllllllllllllllIIllIIllIIlIl = 16;
                    }
                    if (lllllllllllllllllllIIllIIllIIlII < 1) {
                        lllllllllllllllllllIIllIIllIIlII = 1;
                    }
                    if (lllllllllllllllllllIIllIIllIIIll > 248) {
                        lllllllllllllllllllIIllIIllIIIll = 248;
                    }
                    if (lllllllllllllllllllIIllIIllIIIlI < 0) {
                        lllllllllllllllllllIIllIIllIIIlI = 0;
                    }
                    if (lllllllllllllllllllIIllIIllIIIIl > 16) {
                        lllllllllllllllllllIIllIIllIIIIl = 16;
                    }
                    boolean lllllllllllllllllllIIllIIllIIIII = false;
                    for (int lllllllllllllllllllIIllIIlIlllll = lllllllllllllllllllIIllIIllIIllI; !lllllllllllllllllllIIllIIllIIIII && lllllllllllllllllllIIllIIlIlllll < lllllllllllllllllllIIllIIllIIlIl; ++lllllllllllllllllllIIllIIlIlllll) {
                        for (int lllllllllllllllllllIIllIIlIllllI = lllllllllllllllllllIIllIIllIIIlI; !lllllllllllllllllllIIllIIllIIIII && lllllllllllllllllllIIllIIlIllllI < lllllllllllllllllllIIllIIllIIIIl; ++lllllllllllllllllllIIllIIlIllllI) {
                            for (int lllllllllllllllllllIIllIIlIlllIl = lllllllllllllllllllIIllIIllIIIll + 1; !lllllllllllllllllllIIllIIllIIIII && lllllllllllllllllllIIllIIlIlllIl >= lllllllllllllllllllIIllIIllIIlII - 1; --lllllllllllllllllllIIllIIlIlllIl) {
                                if (lllllllllllllllllllIIllIIlIlllIl >= 0 && lllllllllllllllllllIIllIIlIlllIl < 256) {
                                    final IBlockState lllllllllllllllllllIIllIIlIlllII = lllllllllllllllllllIIllIIlIIlllI.getBlockState(lllllllllllllllllllIIllIIlIlllll, lllllllllllllllllllIIllIIlIlllIl, lllllllllllllllllllIIllIIlIllllI);
                                    if (lllllllllllllllllllIIllIIlIlllII.getBlock() == Blocks.FLOWING_WATER || lllllllllllllllllllIIllIIlIlllII.getBlock() == Blocks.WATER) {
                                        lllllllllllllllllllIIllIIllIIIII = true;
                                    }
                                    if (lllllllllllllllllllIIllIIlIlllIl != lllllllllllllllllllIIllIIllIIlII - 1 && lllllllllllllllllllIIllIIlIlllll != lllllllllllllllllllIIllIIllIIllI && lllllllllllllllllllIIllIIlIlllll != lllllllllllllllllllIIllIIllIIlIl - 1 && lllllllllllllllllllIIllIIlIllllI != lllllllllllllllllllIIllIIllIIIlI && lllllllllllllllllllIIllIIlIllllI != lllllllllllllllllllIIllIIllIIIIl - 1) {
                                        lllllllllllllllllllIIllIIlIlllIl = lllllllllllllllllllIIllIIllIIlII;
                                    }
                                }
                            }
                        }
                    }
                    if (!lllllllllllllllllllIIllIIllIIIII) {
                        final BlockPos.MutableBlockPos lllllllllllllllllllIIllIIlIllIll = new BlockPos.MutableBlockPos();
                        for (int lllllllllllllllllllIIllIIlIllIlI = lllllllllllllllllllIIllIIllIIllI; lllllllllllllllllllIIllIIlIllIlI < lllllllllllllllllllIIllIIllIIlIl; ++lllllllllllllllllllIIllIIlIllIlI) {
                            final double lllllllllllllllllllIIllIIlIllIIl = (lllllllllllllllllllIIllIIlIllIlI + lllllllllllllllllllIIllIIlIlIIII * 16 + 0.5 - lllllllllllllllllllIIllIIlIIllIl) / lllllllllllllllllllIIllIIllIlllI;
                            for (int lllllllllllllllllllIIllIIlIllIII = lllllllllllllllllllIIllIIllIIIlI; lllllllllllllllllllIIllIIlIllIII < lllllllllllllllllllIIllIIllIIIIl; ++lllllllllllllllllllIIllIIlIllIII) {
                                final double lllllllllllllllllllIIllIIlIlIlll = (double)((lllllllllllllllllllIIllIIlIllIII + lllllllllllllllllllIIllIIlIIllll * 16 + 0.5 - lllllllllllllllllllIIllIIlIIlIll) / lllllllllllllllllllIIllIIllIlllI);
                                boolean lllllllllllllllllllIIllIIlIlIllI = false;
                                if (lllllllllllllllllllIIllIIlIllIIl * lllllllllllllllllllIIllIIlIllIIl + lllllllllllllllllllIIllIIlIlIlll * lllllllllllllllllllIIllIIlIlIlll < 1.0) {
                                    for (int lllllllllllllllllllIIllIIlIlIlIl = lllllllllllllllllllIIllIIllIIIll; lllllllllllllllllllIIllIIlIlIlIl > lllllllllllllllllllIIllIIllIIlII; --lllllllllllllllllllIIllIIlIlIlIl) {
                                        final double lllllllllllllllllllIIllIIlIlIlII = (lllllllllllllllllllIIllIIlIlIlIl - 1 + 0.5 - lllllllllllllllllllIIllIIlIIllII) / lllllllllllllllllllIIllIIllIllIl;
                                        if ((lllllllllllllllllllIIllIIlIllIIl * lllllllllllllllllllIIllIIlIllIIl + lllllllllllllllllllIIllIIlIlIlll * lllllllllllllllllllIIllIIlIlIlll) * this.rs[lllllllllllllllllllIIllIIlIlIlIl - 1] + lllllllllllllllllllIIllIIlIlIlII * lllllllllllllllllllIIllIIlIlIlII / 6.0 < 1.0) {
                                            final IBlockState lllllllllllllllllllIIllIIlIlIIll = lllllllllllllllllllIIllIIlIIlllI.getBlockState(lllllllllllllllllllIIllIIlIllIlI, lllllllllllllllllllIIllIIlIlIlIl, lllllllllllllllllllIIllIIlIllIII);
                                            if (lllllllllllllllllllIIllIIlIlIIll.getBlock() == Blocks.GRASS) {
                                                lllllllllllllllllllIIllIIlIlIllI = true;
                                            }
                                            if (lllllllllllllllllllIIllIIlIlIIll.getBlock() == Blocks.STONE || lllllllllllllllllllIIllIIlIlIIll.getBlock() == Blocks.DIRT || lllllllllllllllllllIIllIIlIlIIll.getBlock() == Blocks.GRASS) {
                                                if (lllllllllllllllllllIIllIIlIlIlIl - 1 < 10) {
                                                    lllllllllllllllllllIIllIIlIIlllI.setBlockState(lllllllllllllllllllIIllIIlIllIlI, lllllllllllllllllllIIllIIlIlIlIl, lllllllllllllllllllIIllIIlIllIII, MapGenRavine.FLOWING_LAVA);
                                                }
                                                else {
                                                    lllllllllllllllllllIIllIIlIIlllI.setBlockState(lllllllllllllllllllIIllIIlIllIlI, lllllllllllllllllllIIllIIlIlIlIl, lllllllllllllllllllIIllIIlIllIII, MapGenRavine.AIR);
                                                    if (lllllllllllllllllllIIllIIlIlIllI && lllllllllllllllllllIIllIIlIIlllI.getBlockState(lllllllllllllllllllIIllIIlIllIlI, lllllllllllllllllllIIllIIlIlIlIl - 1, lllllllllllllllllllIIllIIlIllIII).getBlock() == Blocks.DIRT) {
                                                        lllllllllllllllllllIIllIIlIllIll.setPos(lllllllllllllllllllIIllIIlIllIlI + lllllllllllllllllllIIllIIlIlIIII * 16, 0, lllllllllllllllllllIIllIIlIllIII + lllllllllllllllllllIIllIIlIIllll * 16);
                                                        lllllllllllllllllllIIllIIlIIlllI.setBlockState(lllllllllllllllllllIIllIIlIllIlI, lllllllllllllllllllIIllIIlIlIlIl - 1, lllllllllllllllllllIIllIIlIllIII, this.worldObj.getBiome(lllllllllllllllllllIIllIIlIllIll).topBlock);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllllllllllIIllIIlllIIIl) {
                            break;
                        }
                    }
                }
            }
            ++lllllllllllllllllllIIllIIlIIIlll;
        }
    }
    
    @Override
    protected void recursiveGenerate(final World lllllllllllllllllllIIllIIIIlIlIl, final int lllllllllllllllllllIIllIIIIlIlII, final int lllllllllllllllllllIIllIIIIlIIll, final int lllllllllllllllllllIIllIIIIlIIlI, final int lllllllllllllllllllIIllIIIIlIIIl, final ChunkPrimer lllllllllllllllllllIIllIIIIlIIII) {
        if (this.rand.nextInt(50) == 0) {
            final double lllllllllllllllllllIIllIIIIIllll = lllllllllllllllllllIIllIIIIlIlII * 16 + this.rand.nextInt(16);
            final double lllllllllllllllllllIIllIIIIIlllI = this.rand.nextInt(this.rand.nextInt(40) + 8) + 20;
            final double lllllllllllllllllllIIllIIIIIllIl = lllllllllllllllllllIIllIIIIlIIll * 16 + this.rand.nextInt(16);
            final int lllllllllllllllllllIIllIIIIIllII = 1;
            for (int lllllllllllllllllllIIllIIIIIlIll = 0; lllllllllllllllllllIIllIIIIIlIll < 1; ++lllllllllllllllllllIIllIIIIIlIll) {
                final float lllllllllllllllllllIIllIIIIIlIlI = this.rand.nextFloat() * 6.2831855f;
                final float lllllllllllllllllllIIllIIIIIlIIl = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float lllllllllllllllllllIIllIIIIIlIII = (this.rand.nextFloat() * 2.0f + this.rand.nextFloat()) * 2.0f;
                this.addTunnel(this.rand.nextLong(), lllllllllllllllllllIIllIIIIlIIlI, lllllllllllllllllllIIllIIIIlIIIl, lllllllllllllllllllIIllIIIIlIIII, lllllllllllllllllllIIllIIIIIllll, lllllllllllllllllllIIllIIIIIlllI, lllllllllllllllllllIIllIIIIIllIl, lllllllllllllllllllIIllIIIIIlIII, lllllllllllllllllllIIllIIIIIlIlI, lllllllllllllllllllIIllIIIIIlIIl, 0, 0, 3.0);
            }
        }
    }
    
    public MapGenRavine() {
        this.rs = new float[1024];
    }
    
    static {
        FLOWING_LAVA = Blocks.FLOWING_LAVA.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
    }
}
