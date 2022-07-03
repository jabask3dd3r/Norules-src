package net.minecraft.entity;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;

public abstract class EntityFlying extends EntityLiving
{
    @Override
    public void func_191986_a(final float lllllllllllllIlllIlllIIlIIIlIIII, final float lllllllllllllIlllIlllIIlIIIllIII, final float lllllllllllllIlllIlllIIlIIIIlllI) {
        if (this.isInWater()) {
            this.func_191958_b(lllllllllllllIlllIlllIIlIIIlIIII, lllllllllllllIlllIlllIIlIIIllIII, lllllllllllllIlllIlllIIlIIIIlllI, 0.02f);
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.800000011920929;
            this.motionZ *= 0.800000011920929;
        }
        else if (this.isInLava()) {
            this.func_191958_b(lllllllllllllIlllIlllIIlIIIlIIII, lllllllllllllIlllIlllIIlIIIllIII, lllllllllllllIlllIlllIIlIIIIlllI, 0.02f);
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        else {
            float lllllllllllllIlllIlllIIlIIIlIllI = 0.91f;
            if (this.onGround) {
                lllllllllllllIlllIlllIIlIIIlIllI = this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ))).getBlock().slipperiness * 0.91f;
            }
            final float lllllllllllllIlllIlllIIlIIIlIlIl = 0.16277136f / (lllllllllllllIlllIlllIIlIIIlIllI * lllllllllllllIlllIlllIIlIIIlIllI * lllllllllllllIlllIlllIIlIIIlIllI);
            this.func_191958_b(lllllllllllllIlllIlllIIlIIIlIIII, lllllllllllllIlllIlllIIlIIIllIII, lllllllllllllIlllIlllIIlIIIIlllI, this.onGround ? (0.1f * lllllllllllllIlllIlllIIlIIIlIlIl) : 0.02f);
            lllllllllllllIlllIlllIIlIIIlIllI = 0.91f;
            if (this.onGround) {
                lllllllllllllIlllIlllIIlIIIlIllI = this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ))).getBlock().slipperiness * 0.91f;
            }
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= lllllllllllllIlllIlllIIlIIIlIllI;
            this.motionY *= lllllllllllllIlllIlllIIlIIIlIllI;
            this.motionZ *= lllllllllllllIlllIlllIIlIIIlIllI;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lllllllllllllIlllIlllIIlIIIlIlII = this.posX - this.prevPosX;
        final double lllllllllllllIlllIlllIIlIIIlIIll = this.posZ - this.prevPosZ;
        float lllllllllllllIlllIlllIIlIIIlIIlI = MathHelper.sqrt(lllllllllllllIlllIlllIIlIIIlIlII * lllllllllllllIlllIlllIIlIIIlIlII + lllllllllllllIlllIlllIIlIIIlIIll * lllllllllllllIlllIlllIIlIIIlIIll) * 4.0f;
        if (lllllllllllllIlllIlllIIlIIIlIIlI > 1.0f) {
            lllllllllllllIlllIlllIIlIIIlIIlI = 1.0f;
        }
        this.limbSwingAmount += (lllllllllllllIlllIlllIIlIIIlIIlI - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    @Override
    public boolean isOnLadder() {
        return false;
    }
    
    @Override
    protected void updateFallState(final double lllllllllllllIlllIlllIIlIIlIIllI, final boolean lllllllllllllIlllIlllIIlIIlIIlIl, final IBlockState lllllllllllllIlllIlllIIlIIlIIlII, final BlockPos lllllllllllllIlllIlllIIlIIlIIIll) {
    }
    
    @Override
    public void fall(final float lllllllllllllIlllIlllIIlIIlIlIIl, final float lllllllllllllIlllIlllIIlIIlIlIII) {
    }
    
    public EntityFlying(final World lllllllllllllIlllIlllIIlIIlIllIl) {
        super(lllllllllllllIlllIlllIIlIIlIllIl);
    }
}
