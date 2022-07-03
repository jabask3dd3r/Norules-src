package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;

public class MapGenCaves extends MapGenBase
{
    protected static final /* synthetic */ IBlockState BLK_LAVA;
    protected static final /* synthetic */ IBlockState BLK_AIR;
    
    protected void addRoom(final long lllllllllllllllIlIIlIIlIIIIllIlI, final int lllllllllllllllIlIIlIIlIIIIllIIl, final int lllllllllllllllIlIIlIIlIIIIllIII, final ChunkPrimer lllllllllllllllIlIIlIIlIIIIlIlll, final double lllllllllllllllIlIIlIIlIIIIllllI, final double lllllllllllllllIlIIlIIlIIIIlllIl, final double lllllllllllllllIlIIlIIlIIIIlllII) {
        this.addTunnel(lllllllllllllllIlIIlIIlIIIIllIlI, lllllllllllllllIlIIlIIlIIIIllIIl, lllllllllllllllIlIIlIIlIIIIllIII, lllllllllllllllIlIIlIIlIIIIlIlll, lllllllllllllllIlIIlIIlIIIIllllI, lllllllllllllllIlIIlIIlIIIIlllIl, lllllllllllllllIlIIlIIlIIIIlllII, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    static {
        BLK_LAVA = Blocks.LAVA.getDefaultState();
        BLK_AIR = Blocks.AIR.getDefaultState();
        BLK_SANDSTONE = Blocks.SANDSTONE.getDefaultState();
        BLK_RED_SANDSTONE = Blocks.RED_SANDSTONE.getDefaultState();
    }
    
    protected boolean canReplaceBlock(final IBlockState lllllllllllllllIlIIlIIIlIlllIlll, final IBlockState lllllllllllllllIlIIlIIIlIllllIII) {
        return lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.STONE || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.DIRT || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.GRASS || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.HARDENED_CLAY || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.STAINED_HARDENED_CLAY || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.SANDSTONE || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.RED_SANDSTONE || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.MYCELIUM || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.SNOW_LAYER || ((lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.SAND || lllllllllllllllIlIIlIIIlIlllIlll.getBlock() == Blocks.GRAVEL) && lllllllllllllllIlIIlIIIlIllllIII.getMaterial() != Material.WATER);
    }
    
    @Override
    protected void recursiveGenerate(final World lllllllllllllllIlIIlIIIlIlIlIlII, final int lllllllllllllllIlIIlIIIlIlIlIIll, final int lllllllllllllllIlIIlIIIlIlIlIIlI, final int lllllllllllllllIlIIlIIIlIlIlIIIl, final int lllllllllllllllIlIIlIIIlIlIlIIII, final ChunkPrimer lllllllllllllllIlIIlIIIlIlIIllll) {
        int lllllllllllllllIlIIlIIIlIlIIlllI = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
        if (this.rand.nextInt(7) != 0) {
            lllllllllllllllIlIIlIIIlIlIIlllI = 0;
        }
        for (int lllllllllllllllIlIIlIIIlIlIIllIl = 0; lllllllllllllllIlIIlIIIlIlIIllIl < lllllllllllllllIlIIlIIIlIlIIlllI; ++lllllllllllllllIlIIlIIIlIlIIllIl) {
            final double lllllllllllllllIlIIlIIIlIlIIllII = lllllllllllllllIlIIlIIIlIlIlIIll * 16 + this.rand.nextInt(16);
            final double lllllllllllllllIlIIlIIIlIlIIlIll = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final double lllllllllllllllIlIIlIIIlIlIIlIlI = lllllllllllllllIlIIlIIIlIlIlIIlI * 16 + this.rand.nextInt(16);
            int lllllllllllllllIlIIlIIIlIlIIlIIl = 1;
            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), lllllllllllllllIlIIlIIIlIlIlIIIl, lllllllllllllllIlIIlIIIlIlIlIIII, lllllllllllllllIlIIlIIIlIlIIllll, lllllllllllllllIlIIlIIIlIlIIllII, lllllllllllllllIlIIlIIIlIlIIlIll, lllllllllllllllIlIIlIIIlIlIIlIlI);
                lllllllllllllllIlIIlIIIlIlIIlIIl += this.rand.nextInt(4);
            }
            for (int lllllllllllllllIlIIlIIIlIlIIlIII = 0; lllllllllllllllIlIIlIIIlIlIIlIII < lllllllllllllllIlIIlIIIlIlIIlIIl; ++lllllllllllllllIlIIlIIIlIlIIlIII) {
                final float lllllllllllllllIlIIlIIIlIlIIIlll = this.rand.nextFloat() * 6.2831855f;
                final float lllllllllllllllIlIIlIIIlIlIIIllI = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float lllllllllllllllIlIIlIIIlIlIIIlIl = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                if (this.rand.nextInt(10) == 0) {
                    lllllllllllllllIlIIlIIIlIlIIIlIl *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0f + 1.0f;
                }
                this.addTunnel(this.rand.nextLong(), lllllllllllllllIlIIlIIIlIlIlIIIl, lllllllllllllllIlIIlIIIlIlIlIIII, lllllllllllllllIlIIlIIIlIlIIllll, lllllllllllllllIlIIlIIIlIlIIllII, lllllllllllllllIlIIlIIIlIlIIlIll, lllllllllllllllIlIIlIIIlIlIIlIlI, lllllllllllllllIlIIlIIIlIlIIIlIl, lllllllllllllllIlIIlIIIlIlIIIlll, lllllllllllllllIlIIlIIIlIlIIIllI, 0, 0, 1.0);
            }
        }
    }
    
    protected void addTunnel(final long lllllllllllllllIlIIlIIIllIlIlllI, final int lllllllllllllllIlIIlIIIllIlIllIl, final int lllllllllllllllIlIIlIIIllllIIIII, final ChunkPrimer lllllllllllllllIlIIlIIIllIlIlIll, double lllllllllllllllIlIIlIIIllIlIlIlI, double lllllllllllllllIlIIlIIIllIlIlIIl, double lllllllllllllllIlIIlIIIllIlIlIII, final float lllllllllllllllIlIIlIIIlllIllIll, float lllllllllllllllIlIIlIIIllIlIIllI, float lllllllllllllllIlIIlIIIllIlIIlIl, int lllllllllllllllIlIIlIIIllIlIIlII, int lllllllllllllllIlIIlIIIllIlIIIll, final double lllllllllllllllIlIIlIIIlllIlIllI) {
        final double lllllllllllllllIlIIlIIIlllIlIlIl = lllllllllllllllIlIIlIIIllIlIllIl * 16 + 8;
        final double lllllllllllllllIlIIlIIIlllIlIlII = lllllllllllllllIlIIlIIIllllIIIII * 16 + 8;
        float lllllllllllllllIlIIlIIIlllIlIIll = 0.0f;
        float lllllllllllllllIlIIlIIIlllIlIIlI = 0.0f;
        final Random lllllllllllllllIlIIlIIIlllIlIIIl = new Random(lllllllllllllllIlIIlIIIllIlIlllI);
        if (lllllllllllllllIlIIlIIIllIlIIIll <= 0) {
            final int lllllllllllllllIlIIlIIIlllIlIIII = this.range * 16 - 16;
            lllllllllllllllIlIIlIIIllIlIIIll = lllllllllllllllIlIIlIIIlllIlIIII - lllllllllllllllIlIIlIIIlllIlIIIl.nextInt(lllllllllllllllIlIIlIIIlllIlIIII / 4);
        }
        boolean lllllllllllllllIlIIlIIIlllIIllll = false;
        if (lllllllllllllllIlIIlIIIllIlIIlII == -1) {
            lllllllllllllllIlIIlIIIllIlIIlII = (double)(lllllllllllllllIlIIlIIIllIlIIIll / 2);
            lllllllllllllllIlIIlIIIlllIIllll = true;
        }
        final int lllllllllllllllIlIIlIIIlllIIlllI = (int)(lllllllllllllllIlIIlIIIlllIlIIIl.nextInt((int)(lllllllllllllllIlIIlIIIllIlIIIll / 2)) + lllllllllllllllIlIIlIIIllIlIIIll / 4);
        final boolean lllllllllllllllIlIIlIIIlllIIllIl = lllllllllllllllIlIIlIIIlllIlIIIl.nextInt(6) == 0;
        while (lllllllllllllllIlIIlIIIllIlIIlII < lllllllllllllllIlIIlIIIllIlIIIll) {
            final double lllllllllllllllIlIIlIIIlllIIllII = 1.5 + MathHelper.sin((float)lllllllllllllllIlIIlIIIllIlIIlII * 3.1415927f / (float)lllllllllllllllIlIIlIIIllIlIIIll) * lllllllllllllllIlIIlIIIlllIllIll;
            final double lllllllllllllllIlIIlIIIlllIIlIll = lllllllllllllllIlIIlIIIlllIIllII * lllllllllllllllIlIIlIIIlllIlIllI;
            final float lllllllllllllllIlIIlIIIlllIIlIlI = MathHelper.cos((float)lllllllllllllllIlIIlIIIllIlIIlIl);
            final float lllllllllllllllIlIIlIIIlllIIlIIl = MathHelper.sin((float)lllllllllllllllIlIIlIIIllIlIIlIl);
            lllllllllllllllIlIIlIIIllIlIlIlI += MathHelper.cos(lllllllllllllllIlIIlIIIllIlIIllI) * lllllllllllllllIlIIlIIIlllIIlIlI;
            lllllllllllllllIlIIlIIIllIlIlIIl += lllllllllllllllIlIIlIIIlllIIlIIl;
            lllllllllllllllIlIIlIIIllIlIlIII += MathHelper.sin(lllllllllllllllIlIIlIIIllIlIIllI) * lllllllllllllllIlIIlIIIlllIIlIlI;
            if (lllllllllllllllIlIIlIIIlllIIllIl) {
                lllllllllllllllIlIIlIIIllIlIIlIl *= 0.92f;
            }
            else {
                lllllllllllllllIlIIlIIIllIlIIlIl *= 0.7f;
            }
            lllllllllllllllIlIIlIIIllIlIIlIl += lllllllllllllllIlIIlIIIlllIlIIlI * 0.1f;
            lllllllllllllllIlIIlIIIllIlIIllI += lllllllllllllllIlIIlIIIlllIlIIll * 0.1f;
            lllllllllllllllIlIIlIIIlllIlIIlI *= 0.9f;
            lllllllllllllllIlIIlIIIlllIlIIll *= 0.75f;
            lllllllllllllllIlIIlIIIlllIlIIlI += (lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() - lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat()) * lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() * 2.0f;
            lllllllllllllllIlIIlIIIlllIlIIll += (lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() - lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat()) * lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() * 4.0f;
            if (!lllllllllllllllIlIIlIIIlllIIllll && lllllllllllllllIlIIlIIIllIlIIlII == lllllllllllllllIlIIlIIIlllIIlllI && lllllllllllllllIlIIlIIIlllIllIll > 1.0f && lllllllllllllllIlIIlIIIllIlIIIll > 0) {
                this.addTunnel(lllllllllllllllIlIIlIIIlllIlIIIl.nextLong(), lllllllllllllllIlIIlIIIllIlIllIl, lllllllllllllllIlIIlIIIllllIIIII, lllllllllllllllIlIIlIIIllIlIlIll, lllllllllllllllIlIIlIIIllIlIlIlI, (double)lllllllllllllllIlIIlIIIllIlIlIIl, lllllllllllllllIlIIlIIIllIlIlIII, lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() * 0.5f + 0.5f, lllllllllllllllIlIIlIIIllIlIIllI - 1.5707964f, (float)(lllllllllllllllIlIIlIIIllIlIIlIl / 3.0f), (int)lllllllllllllllIlIIlIIIllIlIIlII, (int)lllllllllllllllIlIIlIIIllIlIIIll, 1.0);
                this.addTunnel(lllllllllllllllIlIIlIIIlllIlIIIl.nextLong(), lllllllllllllllIlIIlIIIllIlIllIl, lllllllllllllllIlIIlIIIllllIIIII, lllllllllllllllIlIIlIIIllIlIlIll, lllllllllllllllIlIIlIIIllIlIlIlI, (double)lllllllllllllllIlIIlIIIllIlIlIIl, lllllllllllllllIlIIlIIIllIlIlIII, lllllllllllllllIlIIlIIIlllIlIIIl.nextFloat() * 0.5f + 0.5f, lllllllllllllllIlIIlIIIllIlIIllI + 1.5707964f, (float)(lllllllllllllllIlIIlIIIllIlIIlIl / 3.0f), (int)lllllllllllllllIlIIlIIIllIlIIlII, (int)lllllllllllllllIlIIlIIIllIlIIIll, 1.0);
                return;
            }
            if (lllllllllllllllIlIIlIIIlllIIllll || lllllllllllllllIlIIlIIIlllIlIIIl.nextInt(4) != 0) {
                final double lllllllllllllllIlIIlIIIlllIIlIII = lllllllllllllllIlIIlIIIllIlIlIlI - lllllllllllllllIlIIlIIIlllIlIlIl;
                final double lllllllllllllllIlIIlIIIlllIIIlll = lllllllllllllllIlIIlIIIllIlIlIII - lllllllllllllllIlIIlIIIlllIlIlII;
                final double lllllllllllllllIlIIlIIIlllIIIllI = (double)(lllllllllllllllIlIIlIIIllIlIIIll - lllllllllllllllIlIIlIIIllIlIIlII);
                final double lllllllllllllllIlIIlIIIlllIIIlIl = lllllllllllllllIlIIlIIIlllIllIll + 2.0f + 16.0f;
                if (lllllllllllllllIlIIlIIIlllIIlIII * lllllllllllllllIlIIlIIIlllIIlIII + lllllllllllllllIlIIlIIIlllIIIlll * lllllllllllllllIlIIlIIIlllIIIlll - lllllllllllllllIlIIlIIIlllIIIllI * lllllllllllllllIlIIlIIIlllIIIllI > lllllllllllllllIlIIlIIIlllIIIlIl * lllllllllllllllIlIIlIIIlllIIIlIl) {
                    return;
                }
                if (lllllllllllllllIlIIlIIIllIlIlIlI >= lllllllllllllllIlIIlIIIlllIlIlIl - 16.0 - lllllllllllllllIlIIlIIIlllIIllII * 2.0 && lllllllllllllllIlIIlIIIllIlIlIII >= lllllllllllllllIlIIlIIIlllIlIlII - 16.0 - lllllllllllllllIlIIlIIIlllIIllII * 2.0 && lllllllllllllllIlIIlIIIllIlIlIlI <= lllllllllllllllIlIIlIIIlllIlIlIl + 16.0 + lllllllllllllllIlIIlIIIlllIIllII * 2.0 && lllllllllllllllIlIIlIIIllIlIlIII <= lllllllllllllllIlIIlIIIlllIlIlII + 16.0 + lllllllllllllllIlIIlIIIlllIIllII * 2.0) {
                    int lllllllllllllllIlIIlIIIlllIIIlII = MathHelper.floor(lllllllllllllllIlIIlIIIllIlIlIlI - lllllllllllllllIlIIlIIIlllIIllII) - lllllllllllllllIlIIlIIIllIlIllIl * 16 - 1;
                    int lllllllllllllllIlIIlIIIlllIIIIll = MathHelper.floor(lllllllllllllllIlIIlIIIllIlIlIlI + lllllllllllllllIlIIlIIIlllIIllII) - lllllllllllllllIlIIlIIIllIlIllIl * 16 + 1;
                    int lllllllllllllllIlIIlIIIlllIIIIlI = MathHelper.floor((double)(lllllllllllllllIlIIlIIIllIlIlIIl - lllllllllllllllIlIIlIIIlllIIlIll)) - 1;
                    int lllllllllllllllIlIIlIIIlllIIIIIl = MathHelper.floor((double)(lllllllllllllllIlIIlIIIllIlIlIIl + lllllllllllllllIlIIlIIIlllIIlIll)) + 1;
                    int lllllllllllllllIlIIlIIIlllIIIIII = MathHelper.floor(lllllllllllllllIlIIlIIIllIlIlIII - lllllllllllllllIlIIlIIIlllIIllII) - lllllllllllllllIlIIlIIIllllIIIII * 16 - 1;
                    int lllllllllllllllIlIIlIIIllIllllll = MathHelper.floor(lllllllllllllllIlIIlIIIllIlIlIII + lllllllllllllllIlIIlIIIlllIIllII) - lllllllllllllllIlIIlIIIllllIIIII * 16 + 1;
                    if (lllllllllllllllIlIIlIIIlllIIIlII < 0) {
                        lllllllllllllllIlIIlIIIlllIIIlII = 0;
                    }
                    if (lllllllllllllllIlIIlIIIlllIIIIll > 16) {
                        lllllllllllllllIlIIlIIIlllIIIIll = 16;
                    }
                    if (lllllllllllllllIlIIlIIIlllIIIIlI < 1) {
                        lllllllllllllllIlIIlIIIlllIIIIlI = 1;
                    }
                    if (lllllllllllllllIlIIlIIIlllIIIIIl > 248) {
                        lllllllllllllllIlIIlIIIlllIIIIIl = 248;
                    }
                    if (lllllllllllllllIlIIlIIIlllIIIIII < 0) {
                        lllllllllllllllIlIIlIIIlllIIIIII = 0;
                    }
                    if (lllllllllllllllIlIIlIIIllIllllll > 16) {
                        lllllllllllllllIlIIlIIIllIllllll = 16;
                    }
                    boolean lllllllllllllllIlIIlIIIllIlllllI = false;
                    for (int lllllllllllllllIlIIlIIIllIllllIl = lllllllllllllllIlIIlIIIlllIIIlII; !lllllllllllllllIlIIlIIIllIlllllI && lllllllllllllllIlIIlIIIllIllllIl < lllllllllllllllIlIIlIIIlllIIIIll; ++lllllllllllllllIlIIlIIIllIllllIl) {
                        for (int lllllllllllllllIlIIlIIIllIllllII = lllllllllllllllIlIIlIIIlllIIIIII; !lllllllllllllllIlIIlIIIllIlllllI && lllllllllllllllIlIIlIIIllIllllII < lllllllllllllllIlIIlIIIllIllllll; ++lllllllllllllllIlIIlIIIllIllllII) {
                            for (int lllllllllllllllIlIIlIIIllIlllIll = lllllllllllllllIlIIlIIIlllIIIIIl + 1; !lllllllllllllllIlIIlIIIllIlllllI && lllllllllllllllIlIIlIIIllIlllIll >= lllllllllllllllIlIIlIIIlllIIIIlI - 1; --lllllllllllllllIlIIlIIIllIlllIll) {
                                if (lllllllllllllllIlIIlIIIllIlllIll >= 0 && lllllllllllllllIlIIlIIIllIlllIll < 256) {
                                    final IBlockState lllllllllllllllIlIIlIIIllIlllIlI = lllllllllllllllIlIIlIIIllIlIlIll.getBlockState(lllllllllllllllIlIIlIIIllIllllIl, lllllllllllllllIlIIlIIIllIlllIll, lllllllllllllllIlIIlIIIllIllllII);
                                    if (lllllllllllllllIlIIlIIIllIlllIlI.getBlock() == Blocks.FLOWING_WATER || lllllllllllllllIlIIlIIIllIlllIlI.getBlock() == Blocks.WATER) {
                                        lllllllllllllllIlIIlIIIllIlllllI = true;
                                    }
                                    if (lllllllllllllllIlIIlIIIllIlllIll != lllllllllllllllIlIIlIIIlllIIIIlI - 1 && lllllllllllllllIlIIlIIIllIllllIl != lllllllllllllllIlIIlIIIlllIIIlII && lllllllllllllllIlIIlIIIllIllllIl != lllllllllllllllIlIIlIIIlllIIIIll - 1 && lllllllllllllllIlIIlIIIllIllllII != lllllllllllllllIlIIlIIIlllIIIIII && lllllllllllllllIlIIlIIIllIllllII != lllllllllllllllIlIIlIIIllIllllll - 1) {
                                        lllllllllllllllIlIIlIIIllIlllIll = lllllllllllllllIlIIlIIIlllIIIIlI;
                                    }
                                }
                            }
                        }
                    }
                    if (!lllllllllllllllIlIIlIIIllIlllllI) {
                        final BlockPos.MutableBlockPos lllllllllllllllIlIIlIIIllIlllIIl = new BlockPos.MutableBlockPos();
                        for (int lllllllllllllllIlIIlIIIllIlllIII = lllllllllllllllIlIIlIIIlllIIIlII; lllllllllllllllIlIIlIIIllIlllIII < lllllllllllllllIlIIlIIIlllIIIIll; ++lllllllllllllllIlIIlIIIllIlllIII) {
                            final double lllllllllllllllIlIIlIIIllIllIlll = (lllllllllllllllIlIIlIIIllIlllIII + lllllllllllllllIlIIlIIIllIlIllIl * 16 + 0.5 - lllllllllllllllIlIIlIIIllIlIlIlI) / lllllllllllllllIlIIlIIIlllIIllII;
                            for (int lllllllllllllllIlIIlIIIllIllIllI = lllllllllllllllIlIIlIIIlllIIIIII; lllllllllllllllIlIIlIIIllIllIllI < lllllllllllllllIlIIlIIIllIllllll; ++lllllllllllllllIlIIlIIIllIllIllI) {
                                final double lllllllllllllllIlIIlIIIllIllIlIl = (lllllllllllllllIlIIlIIIllIllIllI + lllllllllllllllIlIIlIIIllllIIIII * 16 + 0.5 - lllllllllllllllIlIIlIIIllIlIlIII) / lllllllllllllllIlIIlIIIlllIIllII;
                                boolean lllllllllllllllIlIIlIIIllIllIlII = false;
                                if (lllllllllllllllIlIIlIIIllIllIlll * lllllllllllllllIlIIlIIIllIllIlll + lllllllllllllllIlIIlIIIllIllIlIl * lllllllllllllllIlIIlIIIllIllIlIl < 1.0) {
                                    for (int lllllllllllllllIlIIlIIIllIllIIll = lllllllllllllllIlIIlIIIlllIIIIIl; lllllllllllllllIlIIlIIIllIllIIll > lllllllllllllllIlIIlIIIlllIIIIlI; --lllllllllllllllIlIIlIIIllIllIIll) {
                                        final double lllllllllllllllIlIIlIIIllIllIIlI = (double)((lllllllllllllllIlIIlIIIllIllIIll - 1 + 0.5 - lllllllllllllllIlIIlIIIllIlIlIIl) / lllllllllllllllIlIIlIIIlllIIlIll);
                                        if (lllllllllllllllIlIIlIIIllIllIIlI > -0.7 && lllllllllllllllIlIIlIIIllIllIlll * lllllllllllllllIlIIlIIIllIllIlll + lllllllllllllllIlIIlIIIllIllIIlI * lllllllllllllllIlIIlIIIllIllIIlI + lllllllllllllllIlIIlIIIllIllIlIl * lllllllllllllllIlIIlIIIllIllIlIl < 1.0) {
                                            final IBlockState lllllllllllllllIlIIlIIIllIllIIIl = lllllllllllllllIlIIlIIIllIlIlIll.getBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll, lllllllllllllllIlIIlIIIllIllIllI);
                                            final IBlockState lllllllllllllllIlIIlIIIllIllIIII = (IBlockState)MoreObjects.firstNonNull((Object)lllllllllllllllIlIIlIIIllIlIlIll.getBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll + 1, lllllllllllllllIlIIlIIIllIllIllI), (Object)MapGenCaves.BLK_AIR);
                                            if (lllllllllllllllIlIIlIIIllIllIIIl.getBlock() == Blocks.GRASS || lllllllllllllllIlIIlIIIllIllIIIl.getBlock() == Blocks.MYCELIUM) {
                                                lllllllllllllllIlIIlIIIllIllIlII = true;
                                            }
                                            if (this.canReplaceBlock(lllllllllllllllIlIIlIIIllIllIIIl, lllllllllllllllIlIIlIIIllIllIIII)) {
                                                if (lllllllllllllllIlIIlIIIllIllIIll - 1 < 10) {
                                                    lllllllllllllllIlIIlIIIllIlIlIll.setBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll, lllllllllllllllIlIIlIIIllIllIllI, MapGenCaves.BLK_LAVA);
                                                }
                                                else {
                                                    lllllllllllllllIlIIlIIIllIlIlIll.setBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll, lllllllllllllllIlIIlIIIllIllIllI, MapGenCaves.BLK_AIR);
                                                    if (lllllllllllllllIlIIlIIIllIllIlII && lllllllllllllllIlIIlIIIllIlIlIll.getBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll - 1, lllllllllllllllIlIIlIIIllIllIllI).getBlock() == Blocks.DIRT) {
                                                        lllllllllllllllIlIIlIIIllIlllIIl.setPos(lllllllllllllllIlIIlIIIllIlllIII + lllllllllllllllIlIIlIIIllIlIllIl * 16, 0, lllllllllllllllIlIIlIIIllIllIllI + lllllllllllllllIlIIlIIIllllIIIII * 16);
                                                        lllllllllllllllIlIIlIIIllIlIlIll.setBlockState(lllllllllllllllIlIIlIIIllIlllIII, lllllllllllllllIlIIlIIIllIllIIll - 1, lllllllllllllllIlIIlIIIllIllIllI, this.worldObj.getBiome(lllllllllllllllIlIIlIIIllIlllIIl).topBlock.getBlock().getDefaultState());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllllllIlIIlIIIlllIIllll) {
                            break;
                        }
                    }
                }
            }
            ++lllllllllllllllIlIIlIIIllIlIIlII;
        }
    }
}
