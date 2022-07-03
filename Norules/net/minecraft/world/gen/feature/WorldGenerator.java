package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import java.util.*;

public abstract class WorldGenerator
{
    private final /* synthetic */ boolean doBlockNotify;
    
    public WorldGenerator() {
        this(false);
    }
    
    public void setDecorationDefaults() {
    }
    
    protected void setBlockAndNotifyAdequately(final World lllllllllllllIIlIIIlIIllIIllllIl, final BlockPos lllllllllllllIIlIIIlIIllIIllllII, final IBlockState lllllllllllllIIlIIIlIIllIIlllIll) {
        if (this.doBlockNotify) {
            lllllllllllllIIlIIIlIIllIIllllIl.setBlockState(lllllllllllllIIlIIIlIIllIIllllII, lllllllllllllIIlIIIlIIllIIlllIll, 3);
        }
        else {
            lllllllllllllIIlIIIlIIllIIllllIl.setBlockState(lllllllllllllIIlIIIlIIllIIllllII, lllllllllllllIIlIIIlIIllIIlllIll, 2);
        }
    }
    
    public abstract boolean generate(final World p0, final Random p1, final BlockPos p2);
    
    public WorldGenerator(final boolean lllllllllllllIIlIIIlIIllIlIIlIII) {
        this.doBlockNotify = lllllllllllllIIlIIIlIIllIlIIlIII;
    }
}
