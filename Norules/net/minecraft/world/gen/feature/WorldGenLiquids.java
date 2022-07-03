package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class WorldGenLiquids extends WorldGenerator
{
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World llllllllllllllIllIIIlIIlIllIIIII, final Random llllllllllllllIllIIIlIIlIllIlIIl, final BlockPos llllllllllllllIllIIIlIIlIlIlllIl) {
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.up()).getBlock() != Blocks.STONE) {
            return false;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.down()).getBlock() != Blocks.STONE) {
            return false;
        }
        final IBlockState llllllllllllllIllIIIlIIlIllIIlll = llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl);
        if (llllllllllllllIllIIIlIIlIllIIlll.getMaterial() != Material.AIR && llllllllllllllIllIIIlIIlIllIIlll.getBlock() != Blocks.STONE) {
            return false;
        }
        int llllllllllllllIllIIIlIIlIllIIllI = 0;
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.west()).getBlock() == Blocks.STONE) {
            ++llllllllllllllIllIIIlIIlIllIIllI;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.east()).getBlock() == Blocks.STONE) {
            ++llllllllllllllIllIIIlIIlIllIIllI;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.north()).getBlock() == Blocks.STONE) {
            ++llllllllllllllIllIIIlIIlIllIIllI;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.getBlockState(llllllllllllllIllIIIlIIlIlIlllIl.south()).getBlock() == Blocks.STONE) {
            ++llllllllllllllIllIIIlIIlIllIIllI;
        }
        int llllllllllllllIllIIIlIIlIllIIlIl = 0;
        if (llllllllllllllIllIIIlIIlIllIIIII.isAirBlock(llllllllllllllIllIIIlIIlIlIlllIl.west())) {
            ++llllllllllllllIllIIIlIIlIllIIlIl;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.isAirBlock(llllllllllllllIllIIIlIIlIlIlllIl.east())) {
            ++llllllllllllllIllIIIlIIlIllIIlIl;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.isAirBlock(llllllllllllllIllIIIlIIlIlIlllIl.north())) {
            ++llllllllllllllIllIIIlIIlIllIIlIl;
        }
        if (llllllllllllllIllIIIlIIlIllIIIII.isAirBlock(llllllllllllllIllIIIlIIlIlIlllIl.south())) {
            ++llllllllllllllIllIIIlIIlIllIIlIl;
        }
        if (llllllllllllllIllIIIlIIlIllIIllI == 3 && llllllllllllllIllIIIlIIlIllIIlIl == 1) {
            final IBlockState llllllllllllllIllIIIlIIlIllIIIll = this.block.getDefaultState();
            llllllllllllllIllIIIlIIlIllIIIII.setBlockState(llllllllllllllIllIIIlIIlIlIlllIl, llllllllllllllIllIIIlIIlIllIIIll, 2);
            llllllllllllllIllIIIlIIlIllIIIII.immediateBlockTick(llllllllllllllIllIIIlIIlIlIlllIl, llllllllllllllIllIIIlIIlIllIIIll, llllllllllllllIllIIIlIIlIllIlIIl);
        }
        return true;
    }
    
    public WorldGenLiquids(final Block llllllllllllllIllIIIlIIllIIIIIII) {
        this.block = llllllllllllllIllIIIlIIllIIIIIII;
    }
}
