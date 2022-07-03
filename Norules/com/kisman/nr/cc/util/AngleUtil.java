package com.kisman.nr.cc.util;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class AngleUtil
{
    private static /* synthetic */ Minecraft mc;
    
    public static float[] calculateCenter(final Entity lllllllllllllIIIllllIlllllIIllll) {
        return calculateAngle(InterpolationUtil.interpolateEntityTime(AngleUtil.mc.player, AngleUtil.mc.getRenderPartialTicks()), InterpolationUtil.interpolateEntityTime(lllllllllllllIIIllllIlllllIIllll, AngleUtil.mc.getRenderPartialTicks()).add(new Vec3d(lllllllllllllIIIllllIlllllIIllll.width / 2.0f, lllllllllllllIIIllllIlllllIIllll.getEyeHeight() / 2.0f, lllllllllllllIIIllllIlllllIIllll.width / 2.0f)));
    }
    
    public static float[] calculateAngles(final Entity lllllllllllllIIIllllIlllllIlIlIl) {
        return calculateAngle(InterpolationUtil.interpolateEntityTime(AngleUtil.mc.player, AngleUtil.mc.getRenderPartialTicks()), InterpolationUtil.interpolateEntityTime(lllllllllllllIIIllllIlllllIlIlIl, AngleUtil.mc.getRenderPartialTicks()));
    }
    
    public static float[] calculateAngles(final BlockPos lllllllllllllIIIllllIlllllIlIIlI) {
        return calculateAngle(InterpolationUtil.interpolateEntityTime(AngleUtil.mc.player, AngleUtil.mc.getRenderPartialTicks()), new Vec3d(lllllllllllllIIIllllIlllllIlIIlI));
    }
    
    public static float calculateAngleDifference(final float lllllllllllllIIIllllIllllIllIlIl, final float lllllllllllllIIIllllIllllIllIlII) {
        final float lllllllllllllIIIllllIllllIllIIll = Math.abs(lllllllllllllIIIllllIllllIllIlII - lllllllllllllIIIllllIllllIllIlIl) % 360.0f;
        return (lllllllllllllIIIllllIllllIllIIll > 180.0f) ? (360.0f - lllllllllllllIIIllllIllllIllIIll) : lllllllllllllIIIllllIllllIllIIll;
    }
    
    public static float[] calculateCenter(final BlockPos lllllllllllllIIIllllIlllllIIllII) {
        return calculateAngle(InterpolationUtil.interpolateEntityTime(AngleUtil.mc.player, AngleUtil.mc.getRenderPartialTicks()), new Vec3d(lllllllllllllIIIllllIlllllIIllII).add(new Vec3d(0.5, 0.0, 0.5)));
    }
    
    public static float[] calculateAngle(final Vec3d lllllllllllllIIIllllIlllllIIlIII, final Vec3d lllllllllllllIIIllllIlllllIIIlll) {
        return new float[] { (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(lllllllllllllIIIllllIlllllIIIlll.zCoord - lllllllllllllIIIllllIlllllIIlIII.zCoord, lllllllllllllIIIllllIlllllIIIlll.xCoord - lllllllllllllIIIllllIlllllIIlIII.xCoord)) - 90.0), (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2((lllllllllllllIIIllllIlllllIIIlll.yCoord - lllllllllllllIIIllllIlllllIIlIII.yCoord) * -1.0, MathHelper.sqrt(Math.pow(lllllllllllllIIIllllIlllllIIIlll.xCoord - lllllllllllllIIIllllIlllllIIlIII.xCoord, 2.0) + Math.pow(lllllllllllllIIIllllIlllllIIIlll.zCoord - lllllllllllllIIIllllIlllllIIlIII.zCoord, 2.0))))) };
    }
    
    public static float calculateAngleDifference(final float lllllllllllllIIIllllIllllIllllII, final float lllllllllllllIIIllllIllllIlllIll, final double lllllllllllllIIIllllIllllIlllllI, final int lllllllllllllIIIllllIllllIllllIl) {
        return (float)(lllllllllllllIIIllllIllllIllllII - lllllllllllllIIIllllIllllIlllIll / (lllllllllllllIIIllllIllllIlllllI * lllllllllllllIIIllllIllllIllllIl));
    }
    
    static {
        AngleUtil.mc = Minecraft.getMinecraft();
    }
}
