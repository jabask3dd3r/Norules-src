package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;

public final class ProjectileHelper
{
    public static final void rotateTowardsMovement(final Entity llllllllllllllIIIIlIIIlIIIllllll, final float llllllllllllllIIIIlIIIlIIIlllllI) {
        final double llllllllllllllIIIIlIIIlIIlIIIIll = llllllllllllllIIIIlIIIlIIIllllll.motionX;
        final double llllllllllllllIIIIlIIIlIIlIIIIlI = llllllllllllllIIIIlIIIlIIIllllll.motionY;
        final double llllllllllllllIIIIlIIIlIIlIIIIIl = llllllllllllllIIIIlIIIlIIIllllll.motionZ;
        final float llllllllllllllIIIIlIIIlIIlIIIIII = MathHelper.sqrt(llllllllllllllIIIIlIIIlIIlIIIIll * llllllllllllllIIIIlIIIlIIlIIIIll + llllllllllllllIIIIlIIIlIIlIIIIIl * llllllllllllllIIIIlIIIlIIlIIIIIl);
        llllllllllllllIIIIlIIIlIIIllllll.rotationYaw = (float)(MathHelper.atan2(llllllllllllllIIIIlIIIlIIlIIIIIl, llllllllllllllIIIIlIIIlIIlIIIIll) * 57.29577951308232) + 90.0f;
        llllllllllllllIIIIlIIIlIIIllllll.rotationPitch = (float)(MathHelper.atan2(llllllllllllllIIIIlIIIlIIlIIIIII, llllllllllllllIIIIlIIIlIIlIIIIlI) * 57.29577951308232) - 90.0f;
        while (llllllllllllllIIIIlIIIlIIIllllll.rotationPitch - llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch < -180.0f) {
            llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch -= 360.0f;
        }
        while (llllllllllllllIIIIlIIIlIIIllllll.rotationPitch - llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch >= 180.0f) {
            llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch += 360.0f;
        }
        while (llllllllllllllIIIIlIIIlIIIllllll.rotationYaw - llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw < -180.0f) {
            llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw -= 360.0f;
        }
        while (llllllllllllllIIIIlIIIlIIIllllll.rotationYaw - llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw >= 180.0f) {
            llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw += 360.0f;
        }
        llllllllllllllIIIIlIIIlIIIllllll.rotationPitch = llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch + (llllllllllllllIIIIlIIIlIIIllllll.rotationPitch - llllllllllllllIIIIlIIIlIIIllllll.prevRotationPitch) * llllllllllllllIIIIlIIIlIIIlllllI;
        llllllllllllllIIIIlIIIlIIIllllll.rotationYaw = llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw + (llllllllllllllIIIIlIIIlIIIllllll.rotationYaw - llllllllllllllIIIIlIIIlIIIllllll.prevRotationYaw) * llllllllllllllIIIIlIIIlIIIlllllI;
    }
    
    public static RayTraceResult forwardsRaycast(final Entity llllllllllllllIIIIlIIIlIIllIIIIl, final boolean llllllllllllllIIIIlIIIlIIlllIllI, final boolean llllllllllllllIIIIlIIIlIIlllIlIl, final Entity llllllllllllllIIIIlIIIlIIlllIlII) {
        final double llllllllllllllIIIIlIIIlIIlllIIll = llllllllllllllIIIIlIIIlIIllIIIIl.posX;
        final double llllllllllllllIIIIlIIIlIIlllIIlI = llllllllllllllIIIIlIIIlIIllIIIIl.posY;
        final double llllllllllllllIIIIlIIIlIIlllIIIl = llllllllllllllIIIIlIIIlIIllIIIIl.posZ;
        final double llllllllllllllIIIIlIIIlIIlllIIII = llllllllllllllIIIIlIIIlIIllIIIIl.motionX;
        final double llllllllllllllIIIIlIIIlIIllIllll = llllllllllllllIIIIlIIIlIIllIIIIl.motionY;
        final double llllllllllllllIIIIlIIIlIIllIlllI = llllllllllllllIIIIlIIIlIIllIIIIl.motionZ;
        final World llllllllllllllIIIIlIIIlIIllIllIl = llllllllllllllIIIIlIIIlIIllIIIIl.world;
        final Vec3d llllllllllllllIIIIlIIIlIIllIllII = new Vec3d(llllllllllllllIIIIlIIIlIIlllIIll, llllllllllllllIIIIlIIIlIIlllIIlI, llllllllllllllIIIIlIIIlIIlllIIIl);
        Vec3d llllllllllllllIIIIlIIIlIIllIlIll = new Vec3d(llllllllllllllIIIIlIIIlIIlllIIll + llllllllllllllIIIIlIIIlIIlllIIII, llllllllllllllIIIIlIIIlIIlllIIlI + llllllllllllllIIIIlIIIlIIllIllll, llllllllllllllIIIIlIIIlIIlllIIIl + llllllllllllllIIIIlIIIlIIllIlllI);
        RayTraceResult llllllllllllllIIIIlIIIlIIllIlIlI = llllllllllllllIIIIlIIIlIIllIllIl.rayTraceBlocks(llllllllllllllIIIIlIIIlIIllIllII, llllllllllllllIIIIlIIIlIIllIlIll, false, true, false);
        if (llllllllllllllIIIIlIIIlIIlllIllI) {
            if (llllllllllllllIIIIlIIIlIIllIlIlI != null) {
                llllllllllllllIIIIlIIIlIIllIlIll = new Vec3d(llllllllllllllIIIIlIIIlIIllIlIlI.hitVec.xCoord, llllllllllllllIIIIlIIIlIIllIlIlI.hitVec.yCoord, llllllllllllllIIIIlIIIlIIllIlIlI.hitVec.zCoord);
            }
            Entity llllllllllllllIIIIlIIIlIIllIlIIl = null;
            final List<Entity> llllllllllllllIIIIlIIIlIIllIlIII = llllllllllllllIIIIlIIIlIIllIllIl.getEntitiesWithinAABBExcludingEntity(llllllllllllllIIIIlIIIlIIllIIIIl, llllllllllllllIIIIlIIIlIIllIIIIl.getEntityBoundingBox().addCoord(llllllllllllllIIIIlIIIlIIlllIIII, llllllllllllllIIIIlIIIlIIllIllll, llllllllllllllIIIIlIIIlIIllIlllI).expandXyz(1.0));
            double llllllllllllllIIIIlIIIlIIllIIlll = 0.0;
            for (int llllllllllllllIIIIlIIIlIIllIIllI = 0; llllllllllllllIIIIlIIIlIIllIIllI < llllllllllllllIIIIlIIIlIIllIlIII.size(); ++llllllllllllllIIIIlIIIlIIllIIllI) {
                final Entity llllllllllllllIIIIlIIIlIIllIIlIl = llllllllllllllIIIIlIIIlIIllIlIII.get(llllllllllllllIIIIlIIIlIIllIIllI);
                if (llllllllllllllIIIIlIIIlIIllIIlIl.canBeCollidedWith() && (llllllllllllllIIIIlIIIlIIlllIlIl || !llllllllllllllIIIIlIIIlIIllIIlIl.isEntityEqual(llllllllllllllIIIIlIIIlIIlllIlII)) && !llllllllllllllIIIIlIIIlIIllIIlIl.noClip) {
                    final AxisAlignedBB llllllllllllllIIIIlIIIlIIllIIlII = llllllllllllllIIIIlIIIlIIllIIlIl.getEntityBoundingBox().expandXyz(0.30000001192092896);
                    final RayTraceResult llllllllllllllIIIIlIIIlIIllIIIll = llllllllllllllIIIIlIIIlIIllIIlII.calculateIntercept(llllllllllllllIIIIlIIIlIIllIllII, llllllllllllllIIIIlIIIlIIllIlIll);
                    if (llllllllllllllIIIIlIIIlIIllIIIll != null) {
                        final double llllllllllllllIIIIlIIIlIIllIIIlI = llllllllllllllIIIIlIIIlIIllIllII.squareDistanceTo(llllllllllllllIIIIlIIIlIIllIIIll.hitVec);
                        if (llllllllllllllIIIIlIIIlIIllIIIlI < llllllllllllllIIIIlIIIlIIllIIlll || llllllllllllllIIIIlIIIlIIllIIlll == 0.0) {
                            llllllllllllllIIIIlIIIlIIllIlIIl = llllllllllllllIIIIlIIIlIIllIIlIl;
                            llllllllllllllIIIIlIIIlIIllIIlll = llllllllllllllIIIIlIIIlIIllIIIlI;
                        }
                    }
                }
            }
            if (llllllllllllllIIIIlIIIlIIllIlIIl != null) {
                llllllllllllllIIIIlIIIlIIllIlIlI = new RayTraceResult(llllllllllllllIIIIlIIIlIIllIlIIl);
            }
        }
        return llllllllllllllIIIIlIIIlIIllIlIlI;
    }
}
