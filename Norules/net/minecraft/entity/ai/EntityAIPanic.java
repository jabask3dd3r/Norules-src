package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import javax.annotation.*;

public class EntityAIPanic extends EntityAIBase
{
    protected /* synthetic */ double randPosY;
    protected /* synthetic */ double randPosZ;
    protected /* synthetic */ double randPosX;
    protected /* synthetic */ double speed;
    protected final /* synthetic */ EntityCreature theEntityCreature;
    
    @Override
    public boolean shouldExecute() {
        if (this.theEntityCreature.getAITarget() == null && !this.theEntityCreature.isBurning()) {
            return false;
        }
        if (this.theEntityCreature.isBurning()) {
            final BlockPos llllllllllllIllllllIllIIIlIlIlII = this.getRandPos(this.theEntityCreature.world, this.theEntityCreature, 5, 4);
            if (llllllllllllIllllllIllIIIlIlIlII != null) {
                this.randPosX = llllllllllllIllllllIllIIIlIlIlII.getX();
                this.randPosY = llllllllllllIllllllIllIIIlIlIlII.getY();
                this.randPosZ = llllllllllllIllllllIllIIIlIlIlII.getZ();
                return true;
            }
        }
        return this.func_190863_f();
    }
    
    public EntityAIPanic(final EntityCreature llllllllllllIllllllIllIIIlIllIIl, final double llllllllllllIllllllIllIIIlIllIll) {
        this.theEntityCreature = llllllllllllIllllllIllIIIlIllIIl;
        this.speed = llllllllllllIllllllIllIIIlIllIll;
        this.setMutexBits(1);
    }
    
    protected boolean func_190863_f() {
        final Vec3d llllllllllllIllllllIllIIIlIIlllI = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 5, 4);
        if (llllllllllllIllllllIllIIIlIIlllI == null) {
            return false;
        }
        this.randPosX = llllllllllllIllllllIllIIIlIIlllI.xCoord;
        this.randPosY = llllllllllllIllllllIllIIIlIIlllI.yCoord;
        this.randPosZ = llllllllllllIllllllIllIIIlIIlllI.zCoord;
        return true;
    }
    
    @Nullable
    private BlockPos getRandPos(final World llllllllllllIllllllIllIIIIlIIlII, final Entity llllllllllllIllllllIllIIIIlIIIll, final int llllllllllllIllllllIllIIIIlIIIlI, final int llllllllllllIllllllIllIIIIllIIIl) {
        final BlockPos llllllllllllIllllllIllIIIIllIIII = new BlockPos(llllllllllllIllllllIllIIIIlIIIll);
        final int llllllllllllIllllllIllIIIIlIllll = llllllllllllIllllllIllIIIIllIIII.getX();
        final int llllllllllllIllllllIllIIIIlIlllI = llllllllllllIllllllIllIIIIllIIII.getY();
        final int llllllllllllIllllllIllIIIIlIllIl = llllllllllllIllllllIllIIIIllIIII.getZ();
        float llllllllllllIllllllIllIIIIlIllII = (float)(llllllllllllIllllllIllIIIIlIIIlI * llllllllllllIllllllIllIIIIlIIIlI * llllllllllllIllllllIllIIIIllIIIl * 2);
        BlockPos llllllllllllIllllllIllIIIIlIlIll = null;
        final BlockPos.MutableBlockPos llllllllllllIllllllIllIIIIlIlIlI = new BlockPos.MutableBlockPos();
        for (int llllllllllllIllllllIllIIIIlIlIIl = llllllllllllIllllllIllIIIIlIllll - llllllllllllIllllllIllIIIIlIIIlI; llllllllllllIllllllIllIIIIlIlIIl <= llllllllllllIllllllIllIIIIlIllll + llllllllllllIllllllIllIIIIlIIIlI; ++llllllllllllIllllllIllIIIIlIlIIl) {
            for (int llllllllllllIllllllIllIIIIlIlIII = llllllllllllIllllllIllIIIIlIlllI - llllllllllllIllllllIllIIIIllIIIl; llllllllllllIllllllIllIIIIlIlIII <= llllllllllllIllllllIllIIIIlIlllI + llllllllllllIllllllIllIIIIllIIIl; ++llllllllllllIllllllIllIIIIlIlIII) {
                for (int llllllllllllIllllllIllIIIIlIIlll = llllllllllllIllllllIllIIIIlIllIl - llllllllllllIllllllIllIIIIlIIIlI; llllllllllllIllllllIllIIIIlIIlll <= llllllllllllIllllllIllIIIIlIllIl + llllllllllllIllllllIllIIIIlIIIlI; ++llllllllllllIllllllIllIIIIlIIlll) {
                    llllllllllllIllllllIllIIIIlIlIlI.setPos(llllllllllllIllllllIllIIIIlIlIIl, llllllllllllIllllllIllIIIIlIlIII, llllllllllllIllllllIllIIIIlIIlll);
                    final IBlockState llllllllllllIllllllIllIIIIlIIllI = llllllllllllIllllllIllIIIIlIIlII.getBlockState(llllllllllllIllllllIllIIIIlIlIlI);
                    if (llllllllllllIllllllIllIIIIlIIllI.getMaterial() == Material.WATER) {
                        final float llllllllllllIllllllIllIIIIlIIlIl = (float)((llllllllllllIllllllIllIIIIlIlIIl - llllllllllllIllllllIllIIIIlIllll) * (llllllllllllIllllllIllIIIIlIlIIl - llllllllllllIllllllIllIIIIlIllll) + (llllllllllllIllllllIllIIIIlIlIII - llllllllllllIllllllIllIIIIlIlllI) * (llllllllllllIllllllIllIIIIlIlIII - llllllllllllIllllllIllIIIIlIlllI) + (llllllllllllIllllllIllIIIIlIIlll - llllllllllllIllllllIllIIIIlIllIl) * (llllllllllllIllllllIllIIIIlIIlll - llllllllllllIllllllIllIIIIlIllIl));
                        if (llllllllllllIllllllIllIIIIlIIlIl < llllllllllllIllllllIllIIIIlIllII) {
                            llllllllllllIllllllIllIIIIlIllII = llllllllllllIllllllIllIIIIlIIlIl;
                            llllllllllllIllllllIllIIIIlIlIll = new BlockPos(llllllllllllIllllllIllIIIIlIlIlI);
                        }
                    }
                }
            }
        }
        return llllllllllllIllllllIllIIIIlIlIll;
    }
    
    @Override
    public void startExecuting() {
        this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntityCreature.getNavigator().noPath();
    }
}
