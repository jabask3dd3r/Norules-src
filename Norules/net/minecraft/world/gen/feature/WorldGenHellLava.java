package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class WorldGenHellLava extends WorldGenerator
{
    private final /* synthetic */ boolean insideRock;
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World lllllllllllllllIllIIIIllIIlIIllI, final Random lllllllllllllllIllIIIIllIIIllllI, final BlockPos lllllllllllllllIllIIIIllIIlIIlII) {
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII).getMaterial() != Material.AIR && lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        int lllllllllllllllIllIIIIllIIlIIIll = 0;
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.west()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllllllIllIIIIllIIlIIIll;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.east()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllllllIllIIIIllIIlIIIll;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.north()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllllllIllIIIIllIIlIIIll;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.south()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllllllIllIIIIllIIlIIIll;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.getBlockState(lllllllllllllllIllIIIIllIIlIIlII.down()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllllllIllIIIIllIIlIIIll;
        }
        int lllllllllllllllIllIIIIllIIlIIIlI = 0;
        if (lllllllllllllllIllIIIIllIIlIIllI.isAirBlock(lllllllllllllllIllIIIIllIIlIIlII.west())) {
            ++lllllllllllllllIllIIIIllIIlIIIlI;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.isAirBlock(lllllllllllllllIllIIIIllIIlIIlII.east())) {
            ++lllllllllllllllIllIIIIllIIlIIIlI;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.isAirBlock(lllllllllllllllIllIIIIllIIlIIlII.north())) {
            ++lllllllllllllllIllIIIIllIIlIIIlI;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.isAirBlock(lllllllllllllllIllIIIIllIIlIIlII.south())) {
            ++lllllllllllllllIllIIIIllIIlIIIlI;
        }
        if (lllllllllllllllIllIIIIllIIlIIllI.isAirBlock(lllllllllllllllIllIIIIllIIlIIlII.down())) {
            ++lllllllllllllllIllIIIIllIIlIIIlI;
        }
        if ((!this.insideRock && lllllllllllllllIllIIIIllIIlIIIll == 4 && lllllllllllllllIllIIIIllIIlIIIlI == 1) || lllllllllllllllIllIIIIllIIlIIIll == 5) {
            final IBlockState lllllllllllllllIllIIIIllIIlIIIIl = this.block.getDefaultState();
            lllllllllllllllIllIIIIllIIlIIllI.setBlockState(lllllllllllllllIllIIIIllIIlIIlII, lllllllllllllllIllIIIIllIIlIIIIl, 2);
            lllllllllllllllIllIIIIllIIlIIllI.immediateBlockTick(lllllllllllllllIllIIIIllIIlIIlII, lllllllllllllllIllIIIIllIIlIIIIl, lllllllllllllllIllIIIIllIIIllllI);
        }
        return true;
    }
    
    public WorldGenHellLava(final Block lllllllllllllllIllIIIIllIIllIIll, final boolean lllllllllllllllIllIIIIllIIlIllll) {
        this.block = lllllllllllllllIllIIIIllIIllIIll;
        this.insideRock = lllllllllllllllIllIIIIllIIlIllll;
    }
}
