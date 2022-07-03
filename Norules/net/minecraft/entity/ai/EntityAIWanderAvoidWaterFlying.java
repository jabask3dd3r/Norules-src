package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.*;
import javax.annotation.*;
import net.minecraft.entity.*;

public class EntityAIWanderAvoidWaterFlying extends EntityAIWanderAvoidWater
{
    @Nullable
    private Vec3d func_192385_j() {
        final BlockPos lllllllllllllIlllIIlllllllllllll = new BlockPos(this.entity);
        final BlockPos.MutableBlockPos lllllllllllllIlllIIllllllllllllI = new BlockPos.MutableBlockPos();
        final BlockPos.MutableBlockPos lllllllllllllIlllIIlllllllllllIl = new BlockPos.MutableBlockPos();
        final Iterable<BlockPos.MutableBlockPos> lllllllllllllIlllIIlllllllllllII = BlockPos.func_191531_b(MathHelper.floor(this.entity.posX - 3.0), MathHelper.floor(this.entity.posY - 6.0), MathHelper.floor(this.entity.posZ - 3.0), MathHelper.floor(this.entity.posX + 3.0), MathHelper.floor(this.entity.posY + 6.0), MathHelper.floor(this.entity.posZ + 3.0));
        for (final BlockPos lllllllllllllIlllIIllllllllllIlI : lllllllllllllIlllIIlllllllllllII) {
            if (!lllllllllllllIlllIIlllllllllllll.equals(lllllllllllllIlllIIllllllllllIlI)) {
                final Block lllllllllllllIlllIIllllllllllIIl = this.entity.world.getBlockState(lllllllllllllIlllIIlllllllllllIl.setPos(lllllllllllllIlllIIllllllllllIlI).move(EnumFacing.DOWN)).getBlock();
                final boolean lllllllllllllIlllIIllllllllllIII = lllllllllllllIlllIIllllllllllIIl instanceof BlockLeaves || lllllllllllllIlllIIllllllllllIIl == Blocks.LOG || lllllllllllllIlllIIllllllllllIIl == Blocks.LOG2;
                if (lllllllllllllIlllIIllllllllllIII && this.entity.world.isAirBlock(lllllllllllllIlllIIllllllllllIlI) && this.entity.world.isAirBlock(lllllllllllllIlllIIllllllllllllI.setPos(lllllllllllllIlllIIllllllllllIlI).move(EnumFacing.UP))) {
                    return new Vec3d(lllllllllllllIlllIIllllllllllIlI.getX(), lllllllllllllIlllIIllllllllllIlI.getY(), lllllllllllllIlllIIllllllllllIlI.getZ());
                }
                continue;
            }
        }
        return null;
    }
    
    @Nullable
    @Override
    protected Vec3d func_190864_f() {
        Vec3d lllllllllllllIlllIlIIIIIIIIIllII = null;
        if (this.entity.isInWater() || this.entity.func_191953_am()) {
            lllllllllllllIlllIlIIIIIIIIIllII = RandomPositionGenerator.func_191377_b(this.entity, 15, 15);
        }
        if (this.entity.getRNG().nextFloat() >= this.field_190865_h) {
            lllllllllllllIlllIlIIIIIIIIIllII = this.func_192385_j();
        }
        return (lllllllllllllIlllIlIIIIIIIIIllII == null) ? super.func_190864_f() : lllllllllllllIlllIlIIIIIIIIIllII;
    }
    
    public EntityAIWanderAvoidWaterFlying(final EntityCreature lllllllllllllIlllIlIIIIIIIIlIIIl, final double lllllllllllllIlllIlIIIIIIIIlIIll) {
        super(lllllllllllllIlllIlIIIIIIIIlIIIl, lllllllllllllIlllIlIIIIIIIIlIIll);
    }
}
