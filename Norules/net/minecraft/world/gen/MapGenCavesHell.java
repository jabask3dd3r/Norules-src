package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.world.*;

public class MapGenCavesHell extends MapGenBase
{
    protected static final /* synthetic */ IBlockState AIR;
    
    protected void addTunnel(final long lllllllllllllllIlllllIllllllIlll, final int lllllllllllllllIlllllIllllllIllI, final int lllllllllllllllIlllllIllllIIIlII, final ChunkPrimer lllllllllllllllIlllllIllllllIlII, double lllllllllllllllIlllllIllllIIIIlI, double lllllllllllllllIlllllIllllIIIIIl, double lllllllllllllllIlllllIllllIIIIII, final float lllllllllllllllIlllllIlllIllllll, float lllllllllllllllIlllllIlllIlllllI, float lllllllllllllllIlllllIlllIllllIl, int lllllllllllllllIlllllIlllIllllII, int lllllllllllllllIlllllIlllIlllIll, final double lllllllllllllllIlllllIlllllIlIll) {
        final double lllllllllllllllIlllllIlllllIlIlI = lllllllllllllllIlllllIllllllIllI * 16 + 8;
        final double lllllllllllllllIlllllIlllllIlIIl = lllllllllllllllIlllllIllllIIIlII * 16 + 8;
        float lllllllllllllllIlllllIlllllIlIII = 0.0f;
        float lllllllllllllllIlllllIlllllIIlll = 0.0f;
        final Random lllllllllllllllIlllllIlllllIIllI = new Random(lllllllllllllllIlllllIllllllIlll);
        if (lllllllllllllllIlllllIlllIlllIll <= 0) {
            final int lllllllllllllllIlllllIlllllIIlIl = this.range * 16 - 16;
            lllllllllllllllIlllllIlllIlllIll = lllllllllllllllIlllllIlllllIIlIl - lllllllllllllllIlllllIlllllIIllI.nextInt(lllllllllllllllIlllllIlllllIIlIl / 4);
        }
        boolean lllllllllllllllIlllllIlllllIIlII = false;
        if (lllllllllllllllIlllllIlllIllllII == -1) {
            lllllllllllllllIlllllIlllIllllII = lllllllllllllllIlllllIlllIlllIll / 2;
            lllllllllllllllIlllllIlllllIIlII = true;
        }
        final int lllllllllllllllIlllllIlllllIIIll = lllllllllllllllIlllllIlllllIIllI.nextInt(lllllllllllllllIlllllIlllIlllIll / 2) + lllllllllllllllIlllllIlllIlllIll / 4;
        final boolean lllllllllllllllIlllllIlllllIIIlI = lllllllllllllllIlllllIlllllIIllI.nextInt(6) == 0;
        while (lllllllllllllllIlllllIlllIllllII < lllllllllllllllIlllllIlllIlllIll) {
            final double lllllllllllllllIlllllIlllllIIIIl = 1.5 + MathHelper.sin((float)lllllllllllllllIlllllIlllIllllII * 3.1415927f / lllllllllllllllIlllllIlllIlllIll) * lllllllllllllllIlllllIlllIllllll;
            final double lllllllllllllllIlllllIlllllIIIII = lllllllllllllllIlllllIlllllIIIIl * lllllllllllllllIlllllIlllllIlIll;
            final float lllllllllllllllIlllllIllllIlllll = MathHelper.cos(lllllllllllllllIlllllIlllIllllIl);
            final float lllllllllllllllIlllllIllllIllllI = MathHelper.sin(lllllllllllllllIlllllIlllIllllIl);
            lllllllllllllllIlllllIllllIIIIlI += MathHelper.cos(lllllllllllllllIlllllIlllIlllllI) * lllllllllllllllIlllllIllllIlllll;
            lllllllllllllllIlllllIllllIIIIIl += lllllllllllllllIlllllIllllIllllI;
            lllllllllllllllIlllllIllllIIIIII += MathHelper.sin(lllllllllllllllIlllllIlllIlllllI) * lllllllllllllllIlllllIllllIlllll;
            if (lllllllllllllllIlllllIlllllIIIlI) {
                lllllllllllllllIlllllIlllIllllIl *= 0.92f;
            }
            else {
                lllllllllllllllIlllllIlllIllllIl *= 0.7f;
            }
            lllllllllllllllIlllllIlllIllllIl += lllllllllllllllIlllllIlllllIIlll * 0.1f;
            lllllllllllllllIlllllIlllIlllllI += lllllllllllllllIlllllIlllllIlIII * 0.1f;
            lllllllllllllllIlllllIlllllIIlll *= 0.9f;
            lllllllllllllllIlllllIlllllIlIII *= 0.75f;
            lllllllllllllllIlllllIlllllIIlll += (lllllllllllllllIlllllIlllllIIllI.nextFloat() - lllllllllllllllIlllllIlllllIIllI.nextFloat()) * lllllllllllllllIlllllIlllllIIllI.nextFloat() * 2.0f;
            lllllllllllllllIlllllIlllllIlIII += (lllllllllllllllIlllllIlllllIIllI.nextFloat() - lllllllllllllllIlllllIlllllIIllI.nextFloat()) * lllllllllllllllIlllllIlllllIIllI.nextFloat() * 4.0f;
            if (!lllllllllllllllIlllllIlllllIIlII && lllllllllllllllIlllllIlllIllllII == lllllllllllllllIlllllIlllllIIIll && lllllllllllllllIlllllIlllIllllll > 1.0f) {
                this.addTunnel(lllllllllllllllIlllllIlllllIIllI.nextLong(), lllllllllllllllIlllllIllllllIllI, lllllllllllllllIlllllIllllIIIlII, lllllllllllllllIlllllIllllllIlII, lllllllllllllllIlllllIllllIIIIlI, lllllllllllllllIlllllIllllIIIIIl, lllllllllllllllIlllllIllllIIIIII, lllllllllllllllIlllllIlllllIIllI.nextFloat() * 0.5f + 0.5f, lllllllllllllllIlllllIlllIlllllI - 1.5707964f, lllllllllllllllIlllllIlllIllllIl / 3.0f, (int)lllllllllllllllIlllllIlllIllllII, lllllllllllllllIlllllIlllIlllIll, 1.0);
                this.addTunnel(lllllllllllllllIlllllIlllllIIllI.nextLong(), lllllllllllllllIlllllIllllllIllI, lllllllllllllllIlllllIllllIIIlII, lllllllllllllllIlllllIllllllIlII, lllllllllllllllIlllllIllllIIIIlI, lllllllllllllllIlllllIllllIIIIIl, lllllllllllllllIlllllIllllIIIIII, lllllllllllllllIlllllIlllllIIllI.nextFloat() * 0.5f + 0.5f, lllllllllllllllIlllllIlllIlllllI + 1.5707964f, lllllllllllllllIlllllIlllIllllIl / 3.0f, (int)lllllllllllllllIlllllIlllIllllII, lllllllllllllllIlllllIlllIlllIll, 1.0);
                return;
            }
            if (lllllllllllllllIlllllIlllllIIlII || lllllllllllllllIlllllIlllllIIllI.nextInt(4) != 0) {
                final double lllllllllllllllIlllllIllllIlllIl = lllllllllllllllIlllllIllllIIIIlI - lllllllllllllllIlllllIlllllIlIlI;
                final double lllllllllllllllIlllllIllllIlllII = lllllllllllllllIlllllIllllIIIIII - lllllllllllllllIlllllIlllllIlIIl;
                final double lllllllllllllllIlllllIllllIllIll = lllllllllllllllIlllllIlllIlllIll - lllllllllllllllIlllllIlllIllllII;
                final double lllllllllllllllIlllllIllllIllIlI = lllllllllllllllIlllllIlllIllllll + 2.0f + 16.0f;
                if (lllllllllllllllIlllllIllllIlllIl * lllllllllllllllIlllllIllllIlllIl + lllllllllllllllIlllllIllllIlllII * lllllllllllllllIlllllIllllIlllII - lllllllllllllllIlllllIllllIllIll * lllllllllllllllIlllllIllllIllIll > lllllllllllllllIlllllIllllIllIlI * lllllllllllllllIlllllIllllIllIlI) {
                    return;
                }
                if (lllllllllllllllIlllllIllllIIIIlI >= lllllllllllllllIlllllIlllllIlIlI - 16.0 - lllllllllllllllIlllllIlllllIIIIl * 2.0 && lllllllllllllllIlllllIllllIIIIII >= lllllllllllllllIlllllIlllllIlIIl - 16.0 - lllllllllllllllIlllllIlllllIIIIl * 2.0 && lllllllllllllllIlllllIllllIIIIlI <= lllllllllllllllIlllllIlllllIlIlI + 16.0 + lllllllllllllllIlllllIlllllIIIIl * 2.0 && lllllllllllllllIlllllIllllIIIIII <= lllllllllllllllIlllllIlllllIlIIl + 16.0 + lllllllllllllllIlllllIlllllIIIIl * 2.0) {
                    int lllllllllllllllIlllllIllllIllIIl = MathHelper.floor(lllllllllllllllIlllllIllllIIIIlI - lllllllllllllllIlllllIlllllIIIIl) - lllllllllllllllIlllllIllllllIllI * 16 - 1;
                    int lllllllllllllllIlllllIllllIllIII = MathHelper.floor(lllllllllllllllIlllllIllllIIIIlI + lllllllllllllllIlllllIlllllIIIIl) - lllllllllllllllIlllllIllllllIllI * 16 + 1;
                    int lllllllllllllllIlllllIllllIlIlll = MathHelper.floor(lllllllllllllllIlllllIllllIIIIIl - lllllllllllllllIlllllIlllllIIIII) - 1;
                    int lllllllllllllllIlllllIllllIlIllI = MathHelper.floor(lllllllllllllllIlllllIllllIIIIIl + lllllllllllllllIlllllIlllllIIIII) + 1;
                    int lllllllllllllllIlllllIllllIlIlIl = MathHelper.floor(lllllllllllllllIlllllIllllIIIIII - lllllllllllllllIlllllIlllllIIIIl) - lllllllllllllllIlllllIllllIIIlII * 16 - 1;
                    int lllllllllllllllIlllllIllllIlIlII = MathHelper.floor(lllllllllllllllIlllllIllllIIIIII + lllllllllllllllIlllllIlllllIIIIl) - lllllllllllllllIlllllIllllIIIlII * 16 + 1;
                    if (lllllllllllllllIlllllIllllIllIIl < 0) {
                        lllllllllllllllIlllllIllllIllIIl = 0;
                    }
                    if (lllllllllllllllIlllllIllllIllIII > 16) {
                        lllllllllllllllIlllllIllllIllIII = 16;
                    }
                    if (lllllllllllllllIlllllIllllIlIlll < 1) {
                        lllllllllllllllIlllllIllllIlIlll = 1;
                    }
                    if (lllllllllllllllIlllllIllllIlIllI > 120) {
                        lllllllllllllllIlllllIllllIlIllI = 120;
                    }
                    if (lllllllllllllllIlllllIllllIlIlIl < 0) {
                        lllllllllllllllIlllllIllllIlIlIl = 0;
                    }
                    if (lllllllllllllllIlllllIllllIlIlII > 16) {
                        lllllllllllllllIlllllIllllIlIlII = 16;
                    }
                    boolean lllllllllllllllIlllllIllllIlIIll = false;
                    for (int lllllllllllllllIlllllIllllIlIIlI = lllllllllllllllIlllllIllllIllIIl; !lllllllllllllllIlllllIllllIlIIll && lllllllllllllllIlllllIllllIlIIlI < lllllllllllllllIlllllIllllIllIII; ++lllllllllllllllIlllllIllllIlIIlI) {
                        for (int lllllllllllllllIlllllIllllIlIIIl = lllllllllllllllIlllllIllllIlIlIl; !lllllllllllllllIlllllIllllIlIIll && lllllllllllllllIlllllIllllIlIIIl < lllllllllllllllIlllllIllllIlIlII; ++lllllllllllllllIlllllIllllIlIIIl) {
                            for (int lllllllllllllllIlllllIllllIlIIII = lllllllllllllllIlllllIllllIlIllI + 1; !lllllllllllllllIlllllIllllIlIIll && lllllllllllllllIlllllIllllIlIIII >= lllllllllllllllIlllllIllllIlIlll - 1; --lllllllllllllllIlllllIllllIlIIII) {
                                if (lllllllllllllllIlllllIllllIlIIII >= 0 && lllllllllllllllIlllllIllllIlIIII < 128) {
                                    final IBlockState lllllllllllllllIlllllIllllIIllll = lllllllllllllllIlllllIllllllIlII.getBlockState(lllllllllllllllIlllllIllllIlIIlI, lllllllllllllllIlllllIllllIlIIII, lllllllllllllllIlllllIllllIlIIIl);
                                    if (lllllllllllllllIlllllIllllIIllll.getBlock() == Blocks.FLOWING_LAVA || lllllllllllllllIlllllIllllIIllll.getBlock() == Blocks.LAVA) {
                                        lllllllllllllllIlllllIllllIlIIll = true;
                                    }
                                    if (lllllllllllllllIlllllIllllIlIIII != lllllllllllllllIlllllIllllIlIlll - 1 && lllllllllllllllIlllllIllllIlIIlI != lllllllllllllllIlllllIllllIllIIl && lllllllllllllllIlllllIllllIlIIlI != lllllllllllllllIlllllIllllIllIII - 1 && lllllllllllllllIlllllIllllIlIIIl != lllllllllllllllIlllllIllllIlIlIl && lllllllllllllllIlllllIllllIlIIIl != lllllllllllllllIlllllIllllIlIlII - 1) {
                                        lllllllllllllllIlllllIllllIlIIII = lllllllllllllllIlllllIllllIlIlll;
                                    }
                                }
                            }
                        }
                    }
                    if (!lllllllllllllllIlllllIllllIlIIll) {
                        for (int lllllllllllllllIlllllIllllIIlllI = lllllllllllllllIlllllIllllIllIIl; lllllllllllllllIlllllIllllIIlllI < lllllllllllllllIlllllIllllIllIII; ++lllllllllllllllIlllllIllllIIlllI) {
                            final double lllllllllllllllIlllllIllllIIllIl = (lllllllllllllllIlllllIllllIIlllI + lllllllllllllllIlllllIllllllIllI * 16 + 0.5 - lllllllllllllllIlllllIllllIIIIlI) / lllllllllllllllIlllllIlllllIIIIl;
                            for (int lllllllllllllllIlllllIllllIIllII = lllllllllllllllIlllllIllllIlIlIl; lllllllllllllllIlllllIllllIIllII < lllllllllllllllIlllllIllllIlIlII; ++lllllllllllllllIlllllIllllIIllII) {
                                final double lllllllllllllllIlllllIllllIIlIll = (lllllllllllllllIlllllIllllIIllII + lllllllllllllllIlllllIllllIIIlII * 16 + 0.5 - lllllllllllllllIlllllIllllIIIIII) / lllllllllllllllIlllllIlllllIIIIl;
                                for (int lllllllllllllllIlllllIllllIIlIlI = lllllllllllllllIlllllIllllIlIllI; lllllllllllllllIlllllIllllIIlIlI > lllllllllllllllIlllllIllllIlIlll; --lllllllllllllllIlllllIllllIIlIlI) {
                                    final double lllllllllllllllIlllllIllllIIlIIl = (lllllllllllllllIlllllIllllIIlIlI - 1 + 0.5 - lllllllllllllllIlllllIllllIIIIIl) / lllllllllllllllIlllllIlllllIIIII;
                                    if (lllllllllllllllIlllllIllllIIlIIl > -0.7 && lllllllllllllllIlllllIllllIIllIl * lllllllllllllllIlllllIllllIIllIl + lllllllllllllllIlllllIllllIIlIIl * lllllllllllllllIlllllIllllIIlIIl + lllllllllllllllIlllllIllllIIlIll * lllllllllllllllIlllllIllllIIlIll < 1.0) {
                                        final IBlockState lllllllllllllllIlllllIllllIIlIII = lllllllllllllllIlllllIllllllIlII.getBlockState(lllllllllllllllIlllllIllllIIlllI, lllllllllllllllIlllllIllllIIlIlI, lllllllllllllllIlllllIllllIIllII);
                                        if (lllllllllllllllIlllllIllllIIlIII.getBlock() == Blocks.NETHERRACK || lllllllllllllllIlllllIllllIIlIII.getBlock() == Blocks.DIRT || lllllllllllllllIlllllIllllIIlIII.getBlock() == Blocks.GRASS) {
                                            lllllllllllllllIlllllIllllllIlII.setBlockState(lllllllllllllllIlllllIllllIIlllI, lllllllllllllllIlllllIllllIIlIlI, lllllllllllllllIlllllIllllIIllII, MapGenCavesHell.AIR);
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllllllIlllllIlllllIIlII) {
                            break;
                        }
                    }
                }
            }
            ++lllllllllllllllIlllllIlllIllllII;
        }
    }
    
    static {
        AIR = Blocks.AIR.getDefaultState();
    }
    
    @Override
    protected void recursiveGenerate(final World lllllllllllllllIlllllIlllIIIlIIl, final int lllllllllllllllIlllllIlllIIIlIII, final int lllllllllllllllIlllllIlllIIIIlll, final int lllllllllllllllIlllllIlllIIIIllI, final int lllllllllllllllIlllllIlllIIIIlIl, final ChunkPrimer lllllllllllllllIlllllIllIlllIlII) {
        int lllllllllllllllIlllllIlllIIIIIll = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(10) + 1) + 1);
        if (this.rand.nextInt(5) != 0) {
            lllllllllllllllIlllllIlllIIIIIll = 0;
        }
        for (int lllllllllllllllIlllllIlllIIIIIlI = 0; lllllllllllllllIlllllIlllIIIIIlI < lllllllllllllllIlllllIlllIIIIIll; ++lllllllllllllllIlllllIlllIIIIIlI) {
            final double lllllllllllllllIlllllIlllIIIIIIl = lllllllllllllllIlllllIlllIIIlIII * 16 + this.rand.nextInt(16);
            final double lllllllllllllllIlllllIlllIIIIIII = this.rand.nextInt(128);
            final double lllllllllllllllIlllllIllIlllllll = lllllllllllllllIlllllIlllIIIIlll * 16 + this.rand.nextInt(16);
            int lllllllllllllllIlllllIllIllllllI = 1;
            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), lllllllllllllllIlllllIlllIIIIllI, lllllllllllllllIlllllIlllIIIIlIl, lllllllllllllllIlllllIllIlllIlII, lllllllllllllllIlllllIlllIIIIIIl, lllllllllllllllIlllllIlllIIIIIII, lllllllllllllllIlllllIllIlllllll);
                lllllllllllllllIlllllIllIllllllI += this.rand.nextInt(4);
            }
            for (int lllllllllllllllIlllllIllIlllllIl = 0; lllllllllllllllIlllllIllIlllllIl < lllllllllllllllIlllllIllIllllllI; ++lllllllllllllllIlllllIllIlllllIl) {
                final float lllllllllllllllIlllllIllIlllllII = this.rand.nextFloat() * 6.2831855f;
                final float lllllllllllllllIlllllIllIllllIll = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float lllllllllllllllIlllllIllIllllIlI = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                this.addTunnel(this.rand.nextLong(), lllllllllllllllIlllllIlllIIIIllI, lllllllllllllllIlllllIlllIIIIlIl, lllllllllllllllIlllllIllIlllIlII, lllllllllllllllIlllllIlllIIIIIIl, lllllllllllllllIlllllIlllIIIIIII, lllllllllllllllIlllllIllIlllllll, lllllllllllllllIlllllIllIllllIlI * 2.0f, lllllllllllllllIlllllIllIlllllII, lllllllllllllllIlllllIllIllllIll, 0, 0, 0.5);
            }
        }
    }
    
    protected void addRoom(final long lllllllllllllllIllllllIIIIllIlII, final int lllllllllllllllIllllllIIIIllIIll, final int lllllllllllllllIllllllIIIIllIIlI, final ChunkPrimer lllllllllllllllIllllllIIIIlIlIIl, final double lllllllllllllllIllllllIIIIlIlIII, final double lllllllllllllllIllllllIIIIlIllll, final double lllllllllllllllIllllllIIIIlIlllI) {
        this.addTunnel(lllllllllllllllIllllllIIIIllIlII, lllllllllllllllIllllllIIIIllIIll, lllllllllllllllIllllllIIIIllIIlI, lllllllllllllllIllllllIIIIlIlIIl, lllllllllllllllIllllllIIIIlIlIII, lllllllllllllllIllllllIIIIlIllll, lllllllllllllllIllllllIIIIlIlllI, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
}
