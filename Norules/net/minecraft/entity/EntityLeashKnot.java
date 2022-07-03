package net.minecraft.entity;

import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class EntityLeashKnot extends EntityHanging
{
    @Override
    protected void updateBoundingBox() {
        this.posX = this.hangingPosition.getX() + 0.5;
        this.posY = this.hangingPosition.getY() + 0.5;
        this.posZ = this.hangingPosition.getZ() + 0.5;
    }
    
    public EntityLeashKnot(final World lllllllllllllIIIllllIlllIlIlIIIl) {
        super(lllllllllllllIIIllllIlllIlIlIIIl);
    }
    
    @Override
    public void onBroken(@Nullable final Entity lllllllllllllIIIllllIlllIIlIIlII) {
        this.playSound(SoundEvents.ENTITY_LEASHKNOT_BREAK, 1.0f, 1.0f);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIllllIlllIIIlllIl) {
    }
    
    @Override
    public float getEyeHeight() {
        return -0.0625f;
    }
    
    public static EntityLeashKnot createKnot(final World lllllllllllllIIIllllIlllIIIIIIII, final BlockPos lllllllllllllIIIllllIllIllllllII) {
        final EntityLeashKnot lllllllllllllIIIllllIllIlllllllI = new EntityLeashKnot(lllllllllllllIIIllllIlllIIIIIIII, lllllllllllllIIIllllIllIllllllII);
        lllllllllllllIIIllllIlllIIIIIIII.spawnEntityInWorld(lllllllllllllIIIllllIllIlllllllI);
        lllllllllllllIIIllllIllIlllllllI.playPlaceSound();
        return lllllllllllllIIIllllIllIlllllllI;
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer lllllllllllllIIIllllIlllIIIlIlII, final EnumHand lllllllllllllIIIllllIlllIIIlIIll) {
        if (this.world.isRemote) {
            return true;
        }
        boolean lllllllllllllIIIllllIlllIIIlIIlI = false;
        final double lllllllllllllIIIllllIlllIIIlIIIl = 7.0;
        final List<EntityLiving> lllllllllllllIIIllllIlllIIIlIIII = this.world.getEntitiesWithinAABB((Class<? extends EntityLiving>)EntityLiving.class, new AxisAlignedBB(this.posX - 7.0, this.posY - 7.0, this.posZ - 7.0, this.posX + 7.0, this.posY + 7.0, this.posZ + 7.0));
        for (final EntityLiving lllllllllllllIIIllllIlllIIIIllll : lllllllllllllIIIllllIlllIIIlIIII) {
            if (lllllllllllllIIIllllIlllIIIIllll.getLeashed() && lllllllllllllIIIllllIlllIIIIllll.getLeashedToEntity() == lllllllllllllIIIllllIlllIIIlIlII) {
                lllllllllllllIIIllllIlllIIIIllll.setLeashedToEntity(this, true);
                lllllllllllllIIIllllIlllIIIlIIlI = true;
            }
        }
        if (!lllllllllllllIIIllllIlllIIIlIIlI) {
            this.setDead();
            if (lllllllllllllIIIllllIlllIIIlIlII.capabilities.isCreativeMode) {
                for (final EntityLiving lllllllllllllIIIllllIlllIIIIlllI : lllllllllllllIIIllllIlllIIIlIIII) {
                    if (lllllllllllllIIIllllIlllIIIIlllI.getLeashed() && lllllllllllllIIIllllIlllIIIIlllI.getLeashedToEntity() == this) {
                        lllllllllllllIIIllllIlllIIIIlllI.clearLeashed(true, false);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public void setPosition(final double lllllllllllllIIIllllIlllIIlllIIl, final double lllllllllllllIIIllllIlllIIlllIII, final double lllllllllllllIIIllllIlllIIllIIll) {
        super.setPosition(MathHelper.floor(lllllllllllllIIIllllIlllIIlllIIl) + 0.5, MathHelper.floor(lllllllllllllIIIllllIlllIIlllIII) + 0.5, MathHelper.floor(lllllllllllllIIIllllIlllIIllIIll) + 0.5);
    }
    
    @Override
    public int getWidthPixels() {
        return 9;
    }
    
    @Override
    public boolean writeToNBTOptional(final NBTTagCompound lllllllllllllIIIllllIlllIIlIIIIl) {
        return false;
    }
    
    @Override
    public int getHeightPixels() {
        return 9;
    }
    
    @Override
    public void playPlaceSound() {
        this.playSound(SoundEvents.ENTITY_LEASHKNOT_PLACE, 1.0f, 1.0f);
    }
    
    public void updateFacingWithBoundingBox(final EnumFacing lllllllllllllIIIllllIlllIIlIlllI) {
    }
    
    public EntityLeashKnot(final World lllllllllllllIIIllllIlllIlIIlIIl, final BlockPos lllllllllllllIIIllllIlllIlIIlIII) {
        super(lllllllllllllIIIllllIlllIlIIlIIl, lllllllllllllIIIllllIlllIlIIlIII);
        this.setPosition(lllllllllllllIIIllllIlllIlIIlIII.getX() + 0.5, lllllllllllllIIIllllIlllIlIIlIII.getY() + 0.5, lllllllllllllIIIllllIlllIlIIlIII.getZ() + 0.5);
        final float lllllllllllllIIIllllIlllIlIIIlll = 0.125f;
        final float lllllllllllllIIIllllIlllIlIIIllI = 0.1875f;
        final float lllllllllllllIIIllllIlllIlIIIlIl = 0.25f;
        this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.1875, this.posY - 0.25 + 0.125, this.posZ - 0.1875, this.posX + 0.1875, this.posY + 0.25 + 0.125, this.posZ + 0.1875));
        this.forceSpawn = true;
    }
    
    @Override
    public boolean onValidSurface() {
        return this.world.getBlockState(this.hangingPosition).getBlock() instanceof BlockFence;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIllllIlllIIIlllll) {
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllIIIllllIlllIIlIIlll) {
        return lllllllllllllIIIllllIlllIIlIIlll < 1024.0;
    }
    
    @Nullable
    public static EntityLeashKnot getKnotForPosition(final World lllllllllllllIIIllllIllIlllIllIl, final BlockPos lllllllllllllIIIllllIllIlllIllII) {
        final int lllllllllllllIIIllllIllIllllIIIl = lllllllllllllIIIllllIllIlllIllII.getX();
        final int lllllllllllllIIIllllIllIllllIIII = lllllllllllllIIIllllIllIlllIllII.getY();
        final int lllllllllllllIIIllllIllIlllIllll = lllllllllllllIIIllllIllIlllIllII.getZ();
        for (final EntityLeashKnot lllllllllllllIIIllllIllIlllIlllI : lllllllllllllIIIllllIllIlllIllIl.getEntitiesWithinAABB((Class<? extends Entity>)EntityLeashKnot.class, new AxisAlignedBB(lllllllllllllIIIllllIllIllllIIIl - 1.0, lllllllllllllIIIllllIllIllllIIII - 1.0, lllllllllllllIIIllllIllIlllIllll - 1.0, lllllllllllllIIIllllIllIllllIIIl + 1.0, lllllllllllllIIIllllIllIllllIIII + 1.0, lllllllllllllIIIllllIllIlllIllll + 1.0))) {
            if (lllllllllllllIIIllllIllIlllIlllI.getHangingPosition().equals(lllllllllllllIIIllllIllIlllIllII)) {
                return lllllllllllllIIIllllIllIlllIlllI;
            }
        }
        return null;
    }
}
