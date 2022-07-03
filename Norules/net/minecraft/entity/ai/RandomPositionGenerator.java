package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.pathfinding.*;
import java.util.*;
import net.minecraft.block.material.*;

public class RandomPositionGenerator
{
    private static /* synthetic */ Vec3d staticVector;
    
    @Nullable
    private static Vec3d func_191379_a(final EntityCreature lllllllllllllIIllIlIlIllllIlIlIl, final int lllllllllllllIIllIlIlIllllIlIlII, final int lllllllllllllIIllIlIlIllllIlIIll, @Nullable final Vec3d lllllllllllllIIllIlIlIlllIlllIll, final boolean lllllllllllllIIllIlIlIllllIlIIIl) {
        final PathNavigate lllllllllllllIIllIlIlIllllIlIIII = lllllllllllllIIllIlIlIllllIlIlIl.getNavigator();
        final Random lllllllllllllIIllIlIlIllllIIllll = lllllllllllllIIllIlIlIllllIlIlIl.getRNG();
        boolean lllllllllllllIIllIlIlIllllIIllIl;
        if (lllllllllllllIIllIlIlIllllIlIlIl.hasHome()) {
            final double lllllllllllllIIllIlIlIllllIIllII = lllllllllllllIIllIlIlIllllIlIlIl.getHomePosition().distanceSq(MathHelper.floor(lllllllllllllIIllIlIlIllllIlIlIl.posX), MathHelper.floor(lllllllllllllIIllIlIlIllllIlIlIl.posY), MathHelper.floor(lllllllllllllIIllIlIlIllllIlIlIl.posZ)) + 4.0;
            final double lllllllllllllIIllIlIlIllllIIlIll = lllllllllllllIIllIlIlIllllIlIlIl.getMaximumHomeDistance() + lllllllllllllIIllIlIlIllllIlIlII;
            final boolean lllllllllllllIIllIlIlIllllIIlllI = lllllllllllllIIllIlIlIllllIIllII < lllllllllllllIIllIlIlIllllIIlIll * lllllllllllllIIllIlIlIllllIIlIll;
        }
        else {
            lllllllllllllIIllIlIlIllllIIllIl = false;
        }
        boolean lllllllllllllIIllIlIlIllllIIlIlI = false;
        float lllllllllllllIIllIlIlIllllIIlIIl = -99999.0f;
        int lllllllllllllIIllIlIlIllllIIlIII = 0;
        int lllllllllllllIIllIlIlIllllIIIlll = 0;
        int lllllllllllllIIllIlIlIllllIIIllI = 0;
        for (int lllllllllllllIIllIlIlIllllIIIlIl = 0; lllllllllllllIIllIlIlIllllIIIlIl < 10; ++lllllllllllllIIllIlIlIllllIIIlIl) {
            int lllllllllllllIIllIlIlIllllIIIlII = lllllllllllllIIllIlIlIllllIIllll.nextInt(2 * lllllllllllllIIllIlIlIllllIlIlII + 1) - lllllllllllllIIllIlIlIllllIlIlII;
            final int lllllllllllllIIllIlIlIllllIIIIll = lllllllllllllIIllIlIlIllllIIllll.nextInt(2 * lllllllllllllIIllIlIlIllllIlIIll + 1) - lllllllllllllIIllIlIlIllllIlIIll;
            int lllllllllllllIIllIlIlIllllIIIIlI = lllllllllllllIIllIlIlIllllIIllll.nextInt(2 * lllllllllllllIIllIlIlIllllIlIlII + 1) - lllllllllllllIIllIlIlIllllIlIlII;
            if (lllllllllllllIIllIlIlIlllIlllIll == null || lllllllllllllIIllIlIlIllllIIIlII * lllllllllllllIIllIlIlIlllIlllIll.xCoord + lllllllllllllIIllIlIlIllllIIIIlI * lllllllllllllIIllIlIlIlllIlllIll.zCoord >= 0.0) {
                if (lllllllllllllIIllIlIlIllllIlIlIl.hasHome() && lllllllllllllIIllIlIlIllllIlIlII > 1) {
                    final BlockPos lllllllllllllIIllIlIlIllllIIIIIl = lllllllllllllIIllIlIlIllllIlIlIl.getHomePosition();
                    if (lllllllllllllIIllIlIlIllllIlIlIl.posX > lllllllllllllIIllIlIlIllllIIIIIl.getX()) {
                        lllllllllllllIIllIlIlIllllIIIlII -= lllllllllllllIIllIlIlIllllIIllll.nextInt(lllllllllllllIIllIlIlIllllIlIlII / 2);
                    }
                    else {
                        lllllllllllllIIllIlIlIllllIIIlII += lllllllllllllIIllIlIlIllllIIllll.nextInt(lllllllllllllIIllIlIlIllllIlIlII / 2);
                    }
                    if (lllllllllllllIIllIlIlIllllIlIlIl.posZ > lllllllllllllIIllIlIlIllllIIIIIl.getZ()) {
                        lllllllllllllIIllIlIlIllllIIIIlI -= lllllllllllllIIllIlIlIllllIIllll.nextInt(lllllllllllllIIllIlIlIllllIlIlII / 2);
                    }
                    else {
                        lllllllllllllIIllIlIlIllllIIIIlI += lllllllllllllIIllIlIlIllllIIllll.nextInt(lllllllllllllIIllIlIlIllllIlIlII / 2);
                    }
                }
                BlockPos lllllllllllllIIllIlIlIllllIIIIII = new BlockPos(lllllllllllllIIllIlIlIllllIIIlII + lllllllllllllIIllIlIlIllllIlIlIl.posX, lllllllllllllIIllIlIlIllllIIIIll + lllllllllllllIIllIlIlIllllIlIlIl.posY, lllllllllllllIIllIlIlIllllIIIIlI + lllllllllllllIIllIlIlIllllIlIlIl.posZ);
                if ((!lllllllllllllIIllIlIlIllllIIllIl || lllllllllllllIIllIlIlIllllIlIlIl.isWithinHomeDistanceFromPosition(lllllllllllllIIllIlIlIllllIIIIII)) && lllllllllllllIIllIlIlIllllIlIIII.canEntityStandOnPos(lllllllllllllIIllIlIlIllllIIIIII)) {
                    if (!lllllllllllllIIllIlIlIllllIlIIIl) {
                        lllllllllllllIIllIlIlIllllIIIIII = func_191378_a(lllllllllllllIIllIlIlIllllIIIIII, lllllllllllllIIllIlIlIllllIlIlIl);
                        if (func_191380_b(lllllllllllllIIllIlIlIllllIIIIII, lllllllllllllIIllIlIlIllllIlIlIl)) {
                            continue;
                        }
                    }
                    final float lllllllllllllIIllIlIlIlllIllllll = lllllllllllllIIllIlIlIllllIlIlIl.getBlockPathWeight(lllllllllllllIIllIlIlIllllIIIIII);
                    if (lllllllllllllIIllIlIlIlllIllllll > lllllllllllllIIllIlIlIllllIIlIIl) {
                        lllllllllllllIIllIlIlIllllIIlIIl = lllllllllllllIIllIlIlIlllIllllll;
                        lllllllllllllIIllIlIlIllllIIlIII = lllllllllllllIIllIlIlIllllIIIlII;
                        lllllllllllllIIllIlIlIllllIIIlll = lllllllllllllIIllIlIlIllllIIIIll;
                        lllllllllllllIIllIlIlIllllIIIllI = lllllllllllllIIllIlIlIllllIIIIlI;
                        lllllllllllllIIllIlIlIllllIIlIlI = true;
                    }
                }
            }
        }
        if (lllllllllllllIIllIlIlIllllIIlIlI) {
            return new Vec3d(lllllllllllllIIllIlIlIllllIIlIII + lllllllllllllIIllIlIlIllllIlIlIl.posX, lllllllllllllIIllIlIlIllllIIIlll + lllllllllllllIIllIlIlIllllIlIlIl.posY, lllllllllllllIIllIlIlIllllIIIllI + lllllllllllllIIllIlIlIllllIlIlIl.posZ);
        }
        return null;
    }
    
    @Nullable
    public static Vec3d findRandomTargetBlockAwayFrom(final EntityCreature lllllllllllllIIllIlIlIllllllllII, final int lllllllllllllIIllIlIlIlllllllIll, final int lllllllllllllIIllIlIlIllllllIllI, final Vec3d lllllllllllllIIllIlIlIlllllllIIl) {
        RandomPositionGenerator.staticVector = new Vec3d(lllllllllllllIIllIlIlIllllllllII.posX, lllllllllllllIIllIlIlIllllllllII.posY, lllllllllllllIIllIlIlIllllllllII.posZ).subtract(lllllllllllllIIllIlIlIlllllllIIl);
        return findRandomTargetBlock(lllllllllllllIIllIlIlIllllllllII, lllllllllllllIIllIlIlIlllllllIll, lllllllllllllIIllIlIlIllllllIllI, RandomPositionGenerator.staticVector);
    }
    
    static {
        RandomPositionGenerator.staticVector = Vec3d.ZERO;
    }
    
    @Nullable
    public static Vec3d findRandomTarget(final EntityCreature lllllllllllllIIllIlIllIIIIIllIll, final int lllllllllllllIIllIlIllIIIIIllIlI, final int lllllllllllllIIllIlIllIIIIIllIIl) {
        return findRandomTargetBlock(lllllllllllllIIllIlIllIIIIIllIll, lllllllllllllIIllIlIllIIIIIllIlI, lllllllllllllIIllIlIllIIIIIllIIl, null);
    }
    
    @Nullable
    private static Vec3d findRandomTargetBlock(final EntityCreature lllllllllllllIIllIlIlIlllllIllII, final int lllllllllllllIIllIlIlIlllllIllll, final int lllllllllllllIIllIlIlIlllllIlIlI, @Nullable final Vec3d lllllllllllllIIllIlIlIlllllIlIIl) {
        return func_191379_a(lllllllllllllIIllIlIlIlllllIllII, lllllllllllllIIllIlIlIlllllIllll, lllllllllllllIIllIlIlIlllllIlIlI, lllllllllllllIIllIlIlIlllllIlIIl, true);
    }
    
    private static BlockPos func_191378_a(final BlockPos lllllllllllllIIllIlIlIlllIlIlIII, final EntityCreature lllllllllllllIIllIlIlIlllIlIIlII) {
        if (!lllllllllllllIIllIlIlIlllIlIIlII.world.getBlockState(lllllllllllllIIllIlIlIlllIlIlIII).getMaterial().isSolid()) {
            return lllllllllllllIIllIlIlIlllIlIlIII;
        }
        BlockPos lllllllllllllIIllIlIlIlllIlIIllI;
        for (lllllllllllllIIllIlIlIlllIlIIllI = lllllllllllllIIllIlIlIlllIlIlIII.up(); lllllllllllllIIllIlIlIlllIlIIllI.getY() < lllllllllllllIIllIlIlIlllIlIIlII.world.getHeight() && lllllllllllllIIllIlIlIlllIlIIlII.world.getBlockState(lllllllllllllIIllIlIlIlllIlIIllI).getMaterial().isSolid(); lllllllllllllIIllIlIlIlllIlIIllI = lllllllllllllIIllIlIlIlllIlIIllI.up()) {}
        return lllllllllllllIIllIlIlIlllIlIIllI;
    }
    
    @Nullable
    public static Vec3d func_191377_b(final EntityCreature lllllllllllllIIllIlIllIIIIIIllll, final int lllllllllllllIIllIlIllIIIIIIlllI, final int lllllllllllllIIllIlIllIIIIIlIIII) {
        return func_191379_a(lllllllllllllIIllIlIllIIIIIIllll, lllllllllllllIIllIlIllIIIIIIlllI, lllllllllllllIIllIlIllIIIIIlIIII, null, false);
    }
    
    private static boolean func_191380_b(final BlockPos lllllllllllllIIllIlIlIlllIlIIIII, final EntityCreature lllllllllllllIIllIlIlIlllIIlllll) {
        return lllllllllllllIIllIlIlIlllIIlllll.world.getBlockState(lllllllllllllIIllIlIlIlllIlIIIII).getMaterial() == Material.WATER;
    }
    
    @Nullable
    public static Vec3d findRandomTargetBlockTowards(final EntityCreature lllllllllllllIIllIlIllIIIIIIlIII, final int lllllllllllllIIllIlIllIIIIIIIIll, final int lllllllllllllIIllIlIllIIIIIIIIlI, final Vec3d lllllllllllllIIllIlIllIIIIIIIlIl) {
        RandomPositionGenerator.staticVector = lllllllllllllIIllIlIllIIIIIIIlIl.subtract(lllllllllllllIIllIlIllIIIIIIlIII.posX, lllllllllllllIIllIlIllIIIIIIlIII.posY, lllllllllllllIIllIlIllIIIIIIlIII.posZ);
        return findRandomTargetBlock(lllllllllllllIIllIlIllIIIIIIlIII, lllllllllllllIIllIlIllIIIIIIIIll, lllllllllllllIIllIlIllIIIIIIIIlI, RandomPositionGenerator.staticVector);
    }
}
