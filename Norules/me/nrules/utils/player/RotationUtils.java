package me.nrules.utils.player;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import com.kisman.nr.cc.util.*;

public class RotationUtils
{
    private static /* synthetic */ Minecraft mc;
    
    static {
        RotationUtils.mc = Minecraft.getMinecraft();
    }
    
    public static float[] getLookNeeded(final Entity llllllllllllllIIlIIlllIIIIIlIllI, final double llllllllllllllIIlIIlllIIIIIlIlII, final double llllllllllllllIIlIIlllIIIIIllllI, final double llllllllllllllIIlIIlllIIIIIlIIlI) {
        final double llllllllllllllIIlIIlllIIIIIlllII = llllllllllllllIIlIIlllIIIIIlIlII + 0.5 - llllllllllllllIIlIIlllIIIIIlIllI.posX;
        final double llllllllllllllIIlIIlllIIIIIllIll = llllllllllllllIIlIIlllIIIIIllllI - llllllllllllllIIlIIlllIIIIIlIllI.posY;
        final double llllllllllllllIIlIIlllIIIIIllIlI = llllllllllllllIIlIIlllIIIIIlIIlI + 0.5 - llllllllllllllIIlIIlllIIIIIlIllI.posZ;
        final double llllllllllllllIIlIIlllIIIIIllIIl = Math.sqrt(llllllllllllllIIlIIlllIIIIIlllII * llllllllllllllIIlIIlllIIIIIlllII + llllllllllllllIIlIIlllIIIIIllIlI * llllllllllllllIIlIIlllIIIIIllIlI);
        final float llllllllllllllIIlIIlllIIIIIllIII = (float)(Math.atan2(llllllllllllllIIlIIlllIIIIIllIlI, llllllllllllllIIlIIlllIIIIIlllII) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIIlIIlllIIIIIlIlll = (float)(-(Math.atan2(llllllllllllllIIlIIlllIIIIIllIll, llllllllllllllIIlIIlllIIIIIllIIl) * 180.0 / 3.141592653589793));
        return new float[] { llllllllllllllIIlIIlllIIIIIllIII, llllllllllllllIIlIIlllIIIIIlIlll };
    }
    
    public static boolean isInFOV(final Entity llllllllllllllIIlIIllIllllllIIlI, final double llllllllllllllIIlIIllIllllllIIIl) {
        return isInFOV(RotationUtils.mc.player, llllllllllllllIIlIIllIllllllIIlI, llllllllllllllIIlIIllIllllllIIIl);
    }
    
    public static boolean isInFOV(final Entity llllllllllllllIIlIIllIlllllllIII, final Entity llllllllllllllIIlIIllIlllllllIll, double llllllllllllllIIlIIllIllllllIllI) {
        final double llllllllllllllIIlIIllIlllllllIIl = getAngle360(llllllllllllllIIlIIllIlllllllIII.rotationYaw, getLookNeeded(llllllllllllllIIlIIllIlllllllIII, llllllllllllllIIlIIllIlllllllIll.posX, llllllllllllllIIlIIllIlllllllIll.posY, llllllllllllllIIlIIllIlllllllIll.posZ)[0]);
        return (llllllllllllllIIlIIllIlllllllIIl > 0.0 && llllllllllllllIIlIIllIlllllllIIl < (llllllllllllllIIlIIllIllllllIllI *= 0.5)) || (-llllllllllllllIIlIIllIllllllIllI < llllllllllllllIIlIIllIlllllllIIl && llllllllllllllIIlIIllIlllllllIIl < 0.0);
    }
    
    public static float[] getRatations(final Entity llllllllllllllIIlIIllIlllllIIlll) {
        final double llllllllllllllIIlIIllIlllllIIllI = llllllllllllllIIlIIllIlllllIIlll.posX - RotationUtils.mc.player.posX;
        final double llllllllllllllIIlIIllIlllllIIlIl = llllllllllllllIIlIIllIlllllIIlll.posZ - RotationUtils.mc.player.posZ;
        double llllllllllllllIIlIIllIlllllIIIll = 0.0;
        if (llllllllllllllIIlIIllIlllllIIlll instanceof EntityLivingBase) {
            final double llllllllllllllIIlIIllIlllllIIlII = llllllllllllllIIlIIllIlllllIIlll.posY + llllllllllllllIIlIIllIlllllIIlll.getEyeHeight() - (RotationUtils.mc.player.posY + RotationUtils.mc.player.getEyeHeight()) - 0.4;
        }
        else {
            llllllllllllllIIlIIllIlllllIIIll = (llllllllllllllIIlIIllIlllllIIlll.getEntityBoundingBox().minY + llllllllllllllIIlIIllIlllllIIlll.getEntityBoundingBox().maxY) / 2.0 - (RotationUtils.mc.player.posY + RotationUtils.mc.player.getEyeHeight());
        }
        final double llllllllllllllIIlIIllIlllllIIIlI = MathHelper.sqrt(llllllllllllllIIlIIllIlllllIIllI * llllllllllllllIIlIIllIlllllIIllI + llllllllllllllIIlIIllIlllllIIlIl * llllllllllllllIIlIIllIlllllIIlIl);
        float llllllllllllllIIlIIllIlllllIIIIl = (float)(Math.atan2(llllllllllllllIIlIIllIlllllIIlIl, llllllllllllllIIlIIllIlllllIIllI) * 180.0 / 3.141592653589793 - 90.0) + RandomUtils.nextFloat(-2.0f, 2.0f);
        float llllllllllllllIIlIIllIlllllIIIII = (float)(-(Math.atan2(llllllllllllllIIlIIllIlllllIIIll, llllllllllllllIIlIIllIlllllIIIlI) * 180.0 / 3.141592653589793)) + RandomUtils.nextFloat(-2.0f, 2.0f);
        llllllllllllllIIlIIllIlllllIIIIl = RotationUtils.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(llllllllllllllIIlIIllIlllllIIIIl - RotationUtils.mc.player.rotationYaw));
        llllllllllllllIIlIIllIlllllIIIII = RotationUtils.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(llllllllllllllIIlIIllIlllllIIIII - RotationUtils.mc.player.rotationPitch));
        llllllllllllllIIlIIllIlllllIIIII = MathHelper.clamp(llllllllllllllIIlIIllIlllllIIIII, -90.0f, 90.0f);
        return new float[] { llllllllllllllIIlIIllIlllllIIIIl, llllllllllllllIIlIIllIlllllIIIII };
    }
    
    public static float[] getRotationFromPosition(final double llllllllllllllIIlIIllIlllIlIlllI, final double llllllllllllllIIlIIllIlllIllIllI, final double llllllllllllllIIlIIllIlllIlIllII) {
        final double llllllllllllllIIlIIllIlllIllIlII = llllllllllllllIIlIIllIlllIlIlllI - Minecraft.getMinecraft().player.posX;
        final double llllllllllllllIIlIIllIlllIllIIll = llllllllllllllIIlIIllIlllIllIllI - Minecraft.getMinecraft().player.posZ;
        final double llllllllllllllIIlIIllIlllIllIIlI = llllllllllllllIIlIIllIlllIlIllII - Minecraft.getMinecraft().player.posY - 1.7;
        final double llllllllllllllIIlIIllIlllIllIIIl = MathHelper.sqrt(llllllllllllllIIlIIllIlllIllIlII * llllllllllllllIIlIIllIlllIllIlII + llllllllllllllIIlIIllIlllIllIIll * llllllllllllllIIlIIllIlllIllIIll);
        final float llllllllllllllIIlIIllIlllIllIIII = (float)(Math.atan2(llllllllllllllIIlIIllIlllIllIIll, llllllllllllllIIlIIllIlllIllIlII) * 180.0 / 3.141592653589793) - 90.0f;
        final float llllllllllllllIIlIIllIlllIlIllll = (float)(-(Math.atan2(llllllllllllllIIlIIllIlllIllIIlI, llllllllllllllIIlIIllIlllIllIIIl) * 180.0 / 3.141592653589793));
        return new float[] { llllllllllllllIIlIIllIlllIllIIII, llllllllllllllIIlIIllIlllIlIllll };
    }
    
    public static void setPlayerRotations(final float llllllllllllllIIlIIllIllllIIIlII, final float llllllllllllllIIlIIllIllllIIIIIl) {
        RotationUtils.mc.player.rotationYaw = llllllllllllllIIlIIllIllllIIIlII;
        RotationUtils.mc.player.rotationYawHead = llllllllllllllIIlIIllIllllIIIlII;
        RotationUtils.mc.player.rotationPitch = llllllllllllllIIlIIllIllllIIIIIl;
    }
    
    private static float getAngle360(final float llllllllllllllIIlIIlllIIIIIIIlII, final float llllllllllllllIIlIIlllIIIIIIIlll) {
        final float llllllllllllllIIlIIlllIIIIIIIllI = Math.abs(llllllllllllllIIlIIlllIIIIIIIlll - llllllllllllllIIlIIlllIIIIIIIlII) % 360.0f;
        final float llllllllllllllIIlIIlllIIIIIIIlIl = (llllllllllllllIIlIIlllIIIIIIIllI > 180.0f) ? (360.0f - llllllllllllllIIlIIlllIIIIIIIllI) : llllllllllllllIIlIIlllIIIIIIIllI;
        return llllllllllllllIIlIIlllIIIIIIIlIl;
    }
    
    public static float[] getRotations(final Entity llllllllllllllIIlIIllIllllIlIIII) {
        final double llllllllllllllIIlIIllIllllIlIIll = llllllllllllllIIlIIllIllllIlIIII.posX;
        final double llllllllllllllIIlIIllIllllIlIIlI = llllllllllllllIIlIIllIllllIlIIII.posZ;
        final double llllllllllllllIIlIIllIllllIlIIIl = llllllllllllllIIlIIllIllllIlIIII.posY + llllllllllllllIIlIIllIllllIlIIII.getEyeHeight() / 2.0f;
        return getRotationFromPosition(llllllllllllllIIlIIllIllllIlIIll, llllllllllllllIIlIIllIllllIlIIlI, llllllllllllllIIlIIllIllllIlIIIl);
    }
    
    public static void lookAtVec3d(final Vec3d llllllllllllllIIlIIllIllllIIlIII) {
        final float[] llllllllllllllIIlIIllIllllIIlIIl = AngleUtil.calculateAngle(RotationUtils.mc.player.getPositionEyes(RotationUtils.mc.getRenderPartialTicks()), new Vec3d(llllllllllllllIIlIIllIllllIIlIII.xCoord, llllllllllllllIIlIIllIllllIIlIII.yCoord, llllllllllllllIIlIIllIllllIIlIII.zCoord));
        setPlayerRotations(llllllllllllllIIlIIllIllllIIlIIl[0], llllllllllllllIIlIIllIllllIIlIIl[1]);
    }
}
