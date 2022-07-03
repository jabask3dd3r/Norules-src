package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class EntityAIFollowOwnerFlying extends EntityAIFollowOwner
{
    public EntityAIFollowOwnerFlying(final EntityTameable lllllllllllllIIIlIlIlIIlIllIlIII, final double lllllllllllllIIIlIlIlIIlIllIllII, final float lllllllllllllIIIlIlIlIIlIllIlIll, final float lllllllllllllIIIlIlIlIIlIllIlIlI) {
        super(lllllllllllllIIIlIlIlIIlIllIlIII, lllllllllllllIIIlIlIlIIlIllIllII, lllllllllllllIIIlIlIlIIlIllIlIll, lllllllllllllIIIlIlIlIIlIllIlIlI);
    }
    
    @Override
    protected boolean func_192381_a(final int lllllllllllllIIIlIlIlIIlIlIlIlIl, final int lllllllllllllIIIlIlIlIIlIlIllIll, final int lllllllllllllIIIlIlIlIIlIlIlIIll, final int lllllllllllllIIIlIlIlIIlIlIllIIl, final int lllllllllllllIIIlIlIlIIlIlIlIIIl) {
        final IBlockState lllllllllllllIIIlIlIlIIlIlIlIlll = this.theWorld.getBlockState(new BlockPos(lllllllllllllIIIlIlIlIIlIlIlIlIl + lllllllllllllIIIlIlIlIIlIlIllIIl, lllllllllllllIIIlIlIlIIlIlIlIIll - 1, lllllllllllllIIIlIlIlIIlIlIllIll + lllllllllllllIIIlIlIlIIlIlIlIIIl));
        return (lllllllllllllIIIlIlIlIIlIlIlIlll.isFullyOpaque() || lllllllllllllIIIlIlIlIIlIlIlIlll.getMaterial() == Material.LEAVES) && this.theWorld.isAirBlock(new BlockPos(lllllllllllllIIIlIlIlIIlIlIlIlIl + lllllllllllllIIIlIlIlIIlIlIllIIl, lllllllllllllIIIlIlIlIIlIlIlIIll, lllllllllllllIIIlIlIlIIlIlIllIll + lllllllllllllIIIlIlIlIIlIlIlIIIl)) && this.theWorld.isAirBlock(new BlockPos(lllllllllllllIIIlIlIlIIlIlIlIlIl + lllllllllllllIIIlIlIlIIlIlIllIIl, lllllllllllllIIIlIlIlIIlIlIlIIll + 1, lllllllllllllIIIlIlIlIIlIlIllIll + lllllllllllllIIIlIlIlIIlIlIlIIIl));
    }
}
