package net.minecraft.item;

import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;

public class ItemBoat extends Item
{
    private final /* synthetic */ EntityBoat.Type type;
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World llllllllllllllIlIIIllIIlIIIlIIlI, final EntityPlayer llllllllllllllIlIIIllIIlIIIlIIIl, final EnumHand llllllllllllllIlIIIllIIIllllIIlI) {
        final ItemStack llllllllllllllIlIIIllIIlIIIIllll = llllllllllllllIlIIIllIIlIIIlIIIl.getHeldItem(llllllllllllllIlIIIllIIIllllIIlI);
        final float llllllllllllllIlIIIllIIlIIIIlllI = 1.0f;
        final float llllllllllllllIlIIIllIIlIIIIllIl = llllllllllllllIlIIIllIIlIIIlIIIl.prevRotationPitch + (llllllllllllllIlIIIllIIlIIIlIIIl.rotationPitch - llllllllllllllIlIIIllIIlIIIlIIIl.prevRotationPitch) * 1.0f;
        final float llllllllllllllIlIIIllIIlIIIIllII = llllllllllllllIlIIIllIIlIIIlIIIl.prevRotationYaw + (llllllllllllllIlIIIllIIlIIIlIIIl.rotationYaw - llllllllllllllIlIIIllIIlIIIlIIIl.prevRotationYaw) * 1.0f;
        final double llllllllllllllIlIIIllIIlIIIIlIll = llllllllllllllIlIIIllIIlIIIlIIIl.prevPosX + (llllllllllllllIlIIIllIIlIIIlIIIl.posX - llllllllllllllIlIIIllIIlIIIlIIIl.prevPosX) * 1.0;
        final double llllllllllllllIlIIIllIIlIIIIlIlI = llllllllllllllIlIIIllIIlIIIlIIIl.prevPosY + (llllllllllllllIlIIIllIIlIIIlIIIl.posY - llllllllllllllIlIIIllIIlIIIlIIIl.prevPosY) * 1.0 + llllllllllllllIlIIIllIIlIIIlIIIl.getEyeHeight();
        final double llllllllllllllIlIIIllIIlIIIIlIIl = llllllllllllllIlIIIllIIlIIIlIIIl.prevPosZ + (llllllllllllllIlIIIllIIlIIIlIIIl.posZ - llllllllllllllIlIIIllIIlIIIlIIIl.prevPosZ) * 1.0;
        final Vec3d llllllllllllllIlIIIllIIlIIIIlIII = new Vec3d(llllllllllllllIlIIIllIIlIIIIlIll, llllllllllllllIlIIIllIIlIIIIlIlI, llllllllllllllIlIIIllIIlIIIIlIIl);
        final float llllllllllllllIlIIIllIIlIIIIIlll = MathHelper.cos(-llllllllllllllIlIIIllIIlIIIIllII * 0.017453292f - 3.1415927f);
        final float llllllllllllllIlIIIllIIlIIIIIllI = MathHelper.sin(-llllllllllllllIlIIIllIIlIIIIllII * 0.017453292f - 3.1415927f);
        final float llllllllllllllIlIIIllIIlIIIIIlIl = -MathHelper.cos(-llllllllllllllIlIIIllIIlIIIIllIl * 0.017453292f);
        final float llllllllllllllIlIIIllIIlIIIIIlII = MathHelper.sin(-llllllllllllllIlIIIllIIlIIIIllIl * 0.017453292f);
        final float llllllllllllllIlIIIllIIlIIIIIIll = llllllllllllllIlIIIllIIlIIIIIllI * llllllllllllllIlIIIllIIlIIIIIlIl;
        final float llllllllllllllIlIIIllIIlIIIIIIlI = llllllllllllllIlIIIllIIlIIIIIlll * llllllllllllllIlIIIllIIlIIIIIlIl;
        final double llllllllllllllIlIIIllIIlIIIIIIIl = 5.0;
        final Vec3d llllllllllllllIlIIIllIIlIIIIIIII = llllllllllllllIlIIIllIIlIIIIlIII.addVector(llllllllllllllIlIIIllIIlIIIIIIll * 5.0, llllllllllllllIlIIIllIIlIIIIIlII * 5.0, llllllllllllllIlIIIllIIlIIIIIIlI * 5.0);
        final RayTraceResult llllllllllllllIlIIIllIIIllllllll = llllllllllllllIlIIIllIIlIIIlIIlI.rayTraceBlocks(llllllllllllllIlIIIllIIlIIIIlIII, llllllllllllllIlIIIllIIlIIIIIIII, true);
        if (llllllllllllllIlIIIllIIIllllllll == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, llllllllllllllIlIIIllIIlIIIIllll);
        }
        final Vec3d llllllllllllllIlIIIllIIIlllllllI = llllllllllllllIlIIIllIIlIIIlIIIl.getLook(1.0f);
        boolean llllllllllllllIlIIIllIIIllllllIl = false;
        final List<Entity> llllllllllllllIlIIIllIIIllllllII = llllllllllllllIlIIIllIIlIIIlIIlI.getEntitiesWithinAABBExcludingEntity(llllllllllllllIlIIIllIIlIIIlIIIl, llllllllllllllIlIIIllIIlIIIlIIIl.getEntityBoundingBox().addCoord(llllllllllllllIlIIIllIIIlllllllI.xCoord * 5.0, llllllllllllllIlIIIllIIIlllllllI.yCoord * 5.0, llllllllllllllIlIIIllIIIlllllllI.zCoord * 5.0).expandXyz(1.0));
        for (int llllllllllllllIlIIIllIIIlllllIll = 0; llllllllllllllIlIIIllIIIlllllIll < llllllllllllllIlIIIllIIIllllllII.size(); ++llllllllllllllIlIIIllIIIlllllIll) {
            final Entity llllllllllllllIlIIIllIIIlllllIlI = llllllllllllllIlIIIllIIIllllllII.get(llllllllllllllIlIIIllIIIlllllIll);
            if (llllllllllllllIlIIIllIIIlllllIlI.canBeCollidedWith()) {
                final AxisAlignedBB llllllllllllllIlIIIllIIIlllllIIl = llllllllllllllIlIIIllIIIlllllIlI.getEntityBoundingBox().expandXyz(llllllllllllllIlIIIllIIIlllllIlI.getCollisionBorderSize());
                if (llllllllllllllIlIIIllIIIlllllIIl.isVecInside(llllllllllllllIlIIIllIIlIIIIlIII)) {
                    llllllllllllllIlIIIllIIIllllllIl = true;
                }
            }
        }
        if (llllllllllllllIlIIIllIIIllllllIl) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, llllllllllllllIlIIIllIIlIIIIllll);
        }
        if (llllllllllllllIlIIIllIIIllllllll.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, llllllllllllllIlIIIllIIlIIIIllll);
        }
        final Block llllllllllllllIlIIIllIIIlllllIII = llllllllllllllIlIIIllIIlIIIlIIlI.getBlockState(llllllllllllllIlIIIllIIIllllllll.getBlockPos()).getBlock();
        final boolean llllllllllllllIlIIIllIIIllllIlll = llllllllllllllIlIIIllIIIlllllIII == Blocks.WATER || llllllllllllllIlIIIllIIIlllllIII == Blocks.FLOWING_WATER;
        final EntityBoat llllllllllllllIlIIIllIIIllllIllI = new EntityBoat(llllllllllllllIlIIIllIIlIIIlIIlI, llllllllllllllIlIIIllIIIllllllll.hitVec.xCoord, llllllllllllllIlIIIllIIIllllIlll ? (llllllllllllllIlIIIllIIIllllllll.hitVec.yCoord - 0.12) : llllllllllllllIlIIIllIIIllllllll.hitVec.yCoord, llllllllllllllIlIIIllIIIllllllll.hitVec.zCoord);
        llllllllllllllIlIIIllIIIllllIllI.setBoatType(this.type);
        llllllllllllllIlIIIllIIIllllIllI.rotationYaw = llllllllllllllIlIIIllIIlIIIlIIIl.rotationYaw;
        if (!llllllllllllllIlIIIllIIlIIIlIIlI.getCollisionBoxes(llllllllllllllIlIIIllIIIllllIllI, llllllllllllllIlIIIllIIIllllIllI.getEntityBoundingBox().expandXyz(-0.1)).isEmpty()) {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, llllllllllllllIlIIIllIIlIIIIllll);
        }
        if (!llllllllllllllIlIIIllIIlIIIlIIlI.isRemote) {
            llllllllllllllIlIIIllIIlIIIlIIlI.spawnEntityInWorld(llllllllllllllIlIIIllIIIllllIllI);
        }
        if (!llllllllllllllIlIIIllIIlIIIlIIIl.capabilities.isCreativeMode) {
            llllllllllllllIlIIIllIIlIIIIllll.func_190918_g(1);
        }
        llllllllllllllIlIIIllIIlIIIlIIIl.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, llllllllllllllIlIIIllIIlIIIIllll);
    }
    
    public ItemBoat(final EntityBoat.Type llllllllllllllIlIIIllIIlIIlIllll) {
        this.type = llllllllllllllIlIIIllIIlIIlIllll;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        this.setUnlocalizedName(String.valueOf(new StringBuilder("boat.").append(llllllllllllllIlIIIllIIlIIlIllll.getName())));
    }
}
