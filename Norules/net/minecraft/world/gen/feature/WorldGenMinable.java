package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import com.google.common.base.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class WorldGenMinable extends WorldGenerator
{
    private final /* synthetic */ IBlockState oreBlock;
    private final /* synthetic */ int numberOfBlocks;
    private final /* synthetic */ Predicate<IBlockState> predicate;
    
    @Override
    public boolean generate(final World llllllllllllllllIlIllIIlIIIIlllI, final Random llllllllllllllllIlIllIIlIIIIllIl, final BlockPos llllllllllllllllIlIllIIIlllIllII) {
        final float llllllllllllllllIlIllIIlIIIIlIll = llllllllllllllllIlIllIIlIIIIllIl.nextFloat() * 3.1415927f;
        final double llllllllllllllllIlIllIIlIIIIlIlI = llllllllllllllllIlIllIIIlllIllII.getX() + 8 + MathHelper.sin(llllllllllllllllIlIllIIlIIIIlIll) * this.numberOfBlocks / 8.0f;
        final double llllllllllllllllIlIllIIlIIIIlIIl = llllllllllllllllIlIllIIIlllIllII.getX() + 8 - MathHelper.sin(llllllllllllllllIlIllIIlIIIIlIll) * this.numberOfBlocks / 8.0f;
        final double llllllllllllllllIlIllIIlIIIIlIII = llllllllllllllllIlIllIIIlllIllII.getZ() + 8 + MathHelper.cos(llllllllllllllllIlIllIIlIIIIlIll) * this.numberOfBlocks / 8.0f;
        final double llllllllllllllllIlIllIIlIIIIIlll = llllllllllllllllIlIllIIIlllIllII.getZ() + 8 - MathHelper.cos(llllllllllllllllIlIllIIlIIIIlIll) * this.numberOfBlocks / 8.0f;
        final double llllllllllllllllIlIllIIlIIIIIllI = llllllllllllllllIlIllIIIlllIllII.getY() + llllllllllllllllIlIllIIlIIIIllIl.nextInt(3) - 2;
        final double llllllllllllllllIlIllIIlIIIIIlIl = llllllllllllllllIlIllIIIlllIllII.getY() + llllllllllllllllIlIllIIlIIIIllIl.nextInt(3) - 2;
        for (int llllllllllllllllIlIllIIlIIIIIlII = 0; llllllllllllllllIlIllIIlIIIIIlII < this.numberOfBlocks; ++llllllllllllllllIlIllIIlIIIIIlII) {
            final float llllllllllllllllIlIllIIlIIIIIIll = llllllllllllllllIlIllIIlIIIIIlII / (float)this.numberOfBlocks;
            final double llllllllllllllllIlIllIIlIIIIIIlI = llllllllllllllllIlIllIIlIIIIlIlI + (llllllllllllllllIlIllIIlIIIIlIIl - llllllllllllllllIlIllIIlIIIIlIlI) * llllllllllllllllIlIllIIlIIIIIIll;
            final double llllllllllllllllIlIllIIlIIIIIIIl = llllllllllllllllIlIllIIlIIIIIllI + (llllllllllllllllIlIllIIlIIIIIlIl - llllllllllllllllIlIllIIlIIIIIllI) * llllllllllllllllIlIllIIlIIIIIIll;
            final double llllllllllllllllIlIllIIlIIIIIIII = llllllllllllllllIlIllIIlIIIIlIII + (llllllllllllllllIlIllIIlIIIIIlll - llllllllllllllllIlIllIIlIIIIlIII) * llllllllllllllllIlIllIIlIIIIIIll;
            final double llllllllllllllllIlIllIIIllllllll = llllllllllllllllIlIllIIlIIIIllIl.nextDouble() * this.numberOfBlocks / 16.0;
            final double llllllllllllllllIlIllIIIlllllllI = (MathHelper.sin(3.1415927f * llllllllllllllllIlIllIIlIIIIIIll) + 1.0f) * llllllllllllllllIlIllIIIllllllll + 1.0;
            final double llllllllllllllllIlIllIIIllllllIl = (MathHelper.sin(3.1415927f * llllllllllllllllIlIllIIlIIIIIIll) + 1.0f) * llllllllllllllllIlIllIIIllllllll + 1.0;
            final int llllllllllllllllIlIllIIIllllllII = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIlI - llllllllllllllllIlIllIIIlllllllI / 2.0);
            final int llllllllllllllllIlIllIIIlllllIll = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIIl - llllllllllllllllIlIllIIIllllllIl / 2.0);
            final int llllllllllllllllIlIllIIIlllllIlI = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIII - llllllllllllllllIlIllIIIlllllllI / 2.0);
            final int llllllllllllllllIlIllIIIlllllIIl = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIlI + llllllllllllllllIlIllIIIlllllllI / 2.0);
            final int llllllllllllllllIlIllIIIlllllIII = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIIl + llllllllllllllllIlIllIIIllllllIl / 2.0);
            final int llllllllllllllllIlIllIIIllllIlll = MathHelper.floor(llllllllllllllllIlIllIIlIIIIIIII + llllllllllllllllIlIllIIIlllllllI / 2.0);
            for (int llllllllllllllllIlIllIIIllllIllI = llllllllllllllllIlIllIIIllllllII; llllllllllllllllIlIllIIIllllIllI <= llllllllllllllllIlIllIIIlllllIIl; ++llllllllllllllllIlIllIIIllllIllI) {
                final double llllllllllllllllIlIllIIIllllIlIl = (llllllllllllllllIlIllIIIllllIllI + 0.5 - llllllllllllllllIlIllIIlIIIIIIlI) / (llllllllllllllllIlIllIIIlllllllI / 2.0);
                if (llllllllllllllllIlIllIIIllllIlIl * llllllllllllllllIlIllIIIllllIlIl < 1.0) {
                    for (int llllllllllllllllIlIllIIIllllIlII = llllllllllllllllIlIllIIIlllllIll; llllllllllllllllIlIllIIIllllIlII <= llllllllllllllllIlIllIIIlllllIII; ++llllllllllllllllIlIllIIIllllIlII) {
                        final double llllllllllllllllIlIllIIIllllIIll = (llllllllllllllllIlIllIIIllllIlII + 0.5 - llllllllllllllllIlIllIIlIIIIIIIl) / (llllllllllllllllIlIllIIIllllllIl / 2.0);
                        if (llllllllllllllllIlIllIIIllllIlIl * llllllllllllllllIlIllIIIllllIlIl + llllllllllllllllIlIllIIIllllIIll * llllllllllllllllIlIllIIIllllIIll < 1.0) {
                            for (int llllllllllllllllIlIllIIIllllIIlI = llllllllllllllllIlIllIIIlllllIlI; llllllllllllllllIlIllIIIllllIIlI <= llllllllllllllllIlIllIIIllllIlll; ++llllllllllllllllIlIllIIIllllIIlI) {
                                final double llllllllllllllllIlIllIIIllllIIIl = (llllllllllllllllIlIllIIIllllIIlI + 0.5 - llllllllllllllllIlIllIIlIIIIIIII) / (llllllllllllllllIlIllIIIlllllllI / 2.0);
                                if (llllllllllllllllIlIllIIIllllIlIl * llllllllllllllllIlIllIIIllllIlIl + llllllllllllllllIlIllIIIllllIIll * llllllllllllllllIlIllIIIllllIIll + llllllllllllllllIlIllIIIllllIIIl * llllllllllllllllIlIllIIIllllIIIl < 1.0) {
                                    final BlockPos llllllllllllllllIlIllIIIllllIIII = new BlockPos(llllllllllllllllIlIllIIIllllIllI, llllllllllllllllIlIllIIIllllIlII, llllllllllllllllIlIllIIIllllIIlI);
                                    if (this.predicate.apply((Object)llllllllllllllllIlIllIIlIIIIlllI.getBlockState(llllllllllllllllIlIllIIIllllIIII))) {
                                        llllllllllllllllIlIllIIlIIIIlllI.setBlockState(llllllllllllllllIlIllIIIllllIIII, this.oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenMinable(final IBlockState llllllllllllllllIlIllIIlIIllllIl, final int llllllllllllllllIlIllIIlIIllllII) {
        this(llllllllllllllllIlIllIIlIIllllIl, llllllllllllllllIlIllIIlIIllllII, (Predicate<IBlockState>)new StonePredicate(null));
    }
    
    public WorldGenMinable(final IBlockState llllllllllllllllIlIllIIlIIllIllI, final int llllllllllllllllIlIllIIlIIllIIIl, final Predicate<IBlockState> llllllllllllllllIlIllIIlIIllIIII) {
        this.oreBlock = llllllllllllllllIlIllIIlIIllIllI;
        this.numberOfBlocks = llllllllllllllllIlIllIIlIIllIIIl;
        this.predicate = llllllllllllllllIlIllIIlIIllIIII;
    }
    
    static class StonePredicate implements Predicate<IBlockState>
    {
        public boolean apply(final IBlockState lllllllllllllllllIlllIlIIlIIIlll) {
            if (lllllllllllllllllIlllIlIIlIIIlll != null && lllllllllllllllllIlllIlIIlIIIlll.getBlock() == Blocks.STONE) {
                final BlockStone.EnumType lllllllllllllllllIlllIlIIlIIIllI = lllllllllllllllllIlllIlIIlIIIlll.getValue(BlockStone.VARIANT);
                return lllllllllllllllllIlllIlIIlIIIllI.func_190912_e();
            }
            return false;
        }
        
        private StonePredicate() {
        }
    }
}
