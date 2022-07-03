package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;

public class WorldGenFlowers extends WorldGenerator
{
    private /* synthetic */ IBlockState state;
    private /* synthetic */ BlockFlower flower;
    
    public WorldGenFlowers(final BlockFlower lllllllllllllIlIIlllllllIIIIlIIl, final BlockFlower.EnumFlowerType lllllllllllllIlIIlllllllIIIIlIll) {
        this.setGeneratedBlock(lllllllllllllIlIIlllllllIIIIlIIl, lllllllllllllIlIIlllllllIIIIlIll);
    }
    
    @Override
    public boolean generate(final World lllllllllllllIlIIllllllIllllIlll, final Random lllllllllllllIlIIllllllIllllIllI, final BlockPos lllllllllllllIlIIllllllIllllIlIl) {
        for (int lllllllllllllIlIIllllllIllllIlII = 0; lllllllllllllIlIIllllllIllllIlII < 64; ++lllllllllllllIlIIllllllIllllIlII) {
            final BlockPos lllllllllllllIlIIllllllIllllIIll = lllllllllllllIlIIllllllIllllIlIl.add(lllllllllllllIlIIllllllIllllIllI.nextInt(8) - lllllllllllllIlIIllllllIllllIllI.nextInt(8), lllllllllllllIlIIllllllIllllIllI.nextInt(4) - lllllllllllllIlIIllllllIllllIllI.nextInt(4), lllllllllllllIlIIllllllIllllIllI.nextInt(8) - lllllllllllllIlIIllllllIllllIllI.nextInt(8));
            if (lllllllllllllIlIIllllllIllllIlll.isAirBlock(lllllllllllllIlIIllllllIllllIIll) && (!lllllllllllllIlIIllllllIllllIlll.provider.getHasNoSky() || lllllllllllllIlIIllllllIllllIIll.getY() < 255) && this.flower.canBlockStay(lllllllllllllIlIIllllllIllllIlll, lllllllllllllIlIIllllllIllllIIll, this.state)) {
                lllllllllllllIlIIllllllIllllIlll.setBlockState(lllllllllllllIlIIllllllIllllIIll, this.state, 2);
            }
        }
        return true;
    }
    
    public void setGeneratedBlock(final BlockFlower lllllllllllllIlIIlllllllIIIIIIll, final BlockFlower.EnumFlowerType lllllllllllllIlIIllllllIllllllll) {
        this.flower = lllllllllllllIlIIlllllllIIIIIIll;
        this.state = lllllllllllllIlIIlllllllIIIIIIll.getDefaultState().withProperty(lllllllllllllIlIIlllllllIIIIIIll.getTypeProperty(), lllllllllllllIlIIllllllIllllllll);
    }
}
