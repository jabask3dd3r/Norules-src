package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;

public abstract class WorldGenAbstractTree extends WorldGenerator
{
    protected boolean canGrowInto(final Block llllllllllllIlllllIllIlIlIlllIII) {
        final Material llllllllllllIlllllIllIlIlIllIlll = llllllllllllIlllllIllIlIlIlllIII.getDefaultState().getMaterial();
        return llllllllllllIlllllIllIlIlIllIlll == Material.AIR || llllllllllllIlllllIllIlIlIllIlll == Material.LEAVES || llllllllllllIlllllIllIlIlIlllIII == Blocks.GRASS || llllllllllllIlllllIllIlIlIlllIII == Blocks.DIRT || llllllllllllIlllllIllIlIlIlllIII == Blocks.LOG || llllllllllllIlllllIllIlIlIlllIII == Blocks.LOG2 || llllllllllllIlllllIllIlIlIlllIII == Blocks.SAPLING || llllllllllllIlllllIllIlIlIlllIII == Blocks.VINE;
    }
    
    public void generateSaplings(final World llllllllllllIlllllIllIlIlIllIIll, final Random llllllllllllIlllllIllIlIlIllIIlI, final BlockPos llllllllllllIlllllIllIlIlIllIIIl) {
    }
    
    protected void setDirtAt(final World llllllllllllIlllllIllIlIlIlIllII, final BlockPos llllllllllllIlllllIllIlIlIlIlIll) {
        if (llllllllllllIlllllIllIlIlIlIllII.getBlockState(llllllllllllIlllllIllIlIlIlIlIll).getBlock() != Blocks.DIRT) {
            this.setBlockAndNotifyAdequately(llllllllllllIlllllIllIlIlIlIllII, llllllllllllIlllllIllIlIlIlIlIll, Blocks.DIRT.getDefaultState());
        }
    }
    
    public WorldGenAbstractTree(final boolean llllllllllllIlllllIllIlIlIllllII) {
        super(llllllllllllIlllllIllIlIlIllllII);
    }
}
