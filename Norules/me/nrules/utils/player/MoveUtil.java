package me.nrules.utils.player;

import net.minecraft.client.*;
import net.minecraft.util.*;

public final class MoveUtil
{
    private static /* synthetic */ Minecraft mc;
    
    public static void strafe(final float lllllllllllllllllIlllIlIlIlIllIl) {
        if (!isMoving()) {
            return;
        }
        final double lllllllllllllllllIlllIlIlIlIllII = getDirection();
        MoveUtil.mc.player.motionX = -Math.sin(lllllllllllllllllIlllIlIlIlIllII) * lllllllllllllllllIlllIlIlIlIllIl;
        MoveUtil.mc.player.motionZ = Math.cos(lllllllllllllllllIlllIlIlIlIllII) * lllllllllllllllllIlllIlIlIlIllIl;
    }
    
    public static void forward(final double lllllllllllllllllIlllIlIlIlIIlII) {
        final double lllllllllllllllllIlllIlIlIlIIIll = Math.toRadians(Minecraft.getMinecraft().player.rotationYaw);
        Minecraft.getMinecraft().player.setPosition(Minecraft.getMinecraft().player.posX + -Math.sin(lllllllllllllllllIlllIlIlIlIIIll) * lllllllllllllllllIlllIlIlIlIIlII, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ + Math.cos(lllllllllllllllllIlllIlIlIlIIIll) * lllllllllllllllllIlllIlIlIlIIlII);
    }
    
    public static boolean isMoving() {
        return MoveUtil.mc.player != null && (MoveUtil.mc.player.movementInput.field_192832_b != 0.0f || MovementInput.moveStrafe != 0.0f);
    }
    
    public static float getSpeed() {
        return (float)Math.sqrt(Minecraft.getMinecraft().player.motionX * Minecraft.getMinecraft().player.motionX + Minecraft.getMinecraft().player.motionZ * Minecraft.getMinecraft().player.motionZ);
    }
    
    public static double getDirection() {
        float lllllllllllllllllIlllIlIlIIllIlI = Minecraft.getMinecraft().player.rotationYaw;
        if (Minecraft.getMinecraft().player.moveForward < 0.0f) {
            lllllllllllllllllIlllIlIlIIllIlI += 180.0f;
        }
        float lllllllllllllllllIlllIlIlIIllIII = 1.0f;
        if (Minecraft.getMinecraft().player.moveForward < 0.0f) {
            lllllllllllllllllIlllIlIlIIllIII = -0.5f;
        }
        else if (Minecraft.getMinecraft().player.moveForward > 0.0f) {
            lllllllllllllllllIlllIlIlIIllIII = 0.5f;
        }
        if (Minecraft.getMinecraft().player.moveStrafing > 0.0f) {
            lllllllllllllllllIlllIlIlIIllIlI -= 90.0f * lllllllllllllllllIlllIlIlIIllIII;
        }
        if (Minecraft.getMinecraft().player.moveStrafing < 0.0f) {
            lllllllllllllllllIlllIlIlIIllIlI += 90.0f * lllllllllllllllllIlllIlIlIIllIII;
        }
        return Math.toRadians(lllllllllllllllllIlllIlIlIIllIlI);
    }
    
    public static float getDirection2() {
        float lllllllllllllllllIlllIlIlIIIlIll = Minecraft.getMinecraft().player.rotationYaw;
        if (Minecraft.getMinecraft().player.moveForward < 0.0f) {
            lllllllllllllllllIlllIlIlIIIlIll += 180.0f;
        }
        float lllllllllllllllllIlllIlIlIIIlIlI = 1.0f;
        if (Minecraft.getMinecraft().player.moveForward < 0.0f) {
            lllllllllllllllllIlllIlIlIIIlIlI = -0.5f;
        }
        else if (Minecraft.getMinecraft().player.moveForward > 0.0f) {
            lllllllllllllllllIlllIlIlIIIlIlI = 0.5f;
        }
        if (Minecraft.getMinecraft().player.moveStrafing > 0.0f) {
            lllllllllllllllllIlllIlIlIIIlIll -= 90.0f * lllllllllllllllllIlllIlIlIIIlIlI;
        }
        if (Minecraft.getMinecraft().player.moveStrafing < 0.0f) {
            lllllllllllllllllIlllIlIlIIIlIll += 90.0f * lllllllllllllllllIlllIlIlIIIlIlI;
        }
        return lllllllllllllllllIlllIlIlIIIlIll *= 0.017453292f;
    }
    
    static {
        MoveUtil.mc = Minecraft.getMinecraft();
    }
}
