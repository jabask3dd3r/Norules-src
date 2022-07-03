package me.nrules.utils.player;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;

public class Utils
{
    public static float getDirection() {
        final Minecraft llIlIIllIllIlII = Minecraft.getMinecraft();
        float llIlIIllIllIIll = llIlIIllIllIlII.player.rotationYaw;
        if (llIlIIllIllIlII.player.moveForward < 0.0f) {
            llIlIIllIllIIll += 180.0f;
        }
        float llIlIIllIllIIlI = 1.0f;
        if (llIlIIllIllIlII.player.moveForward < 0.0f) {
            llIlIIllIllIIlI = -0.5f;
        }
        else if (llIlIIllIllIlII.player.moveForward > 0.0f) {
            llIlIIllIllIIlI = 0.5f;
        }
        if (llIlIIllIllIlII.player.moveStrafing > 0.0f) {
            llIlIIllIllIIll -= 90.0f * llIlIIllIllIIlI;
        }
        if (llIlIIllIllIlII.player.moveStrafing < 0.0f) {
            llIlIIllIllIIll += 90.0f * llIlIIllIllIIlI;
        }
        llIlIIllIllIIll *= 0.017453292f;
        return llIlIIllIllIIll;
    }
    
    public static void setSpeed(final double llIlIIllIlIIlll) {
        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown() || Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown() || Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown()) {
            Minecraft.getMinecraft().player.motionX = -MathHelper.sin(getDirection()) * llIlIIllIlIIlll;
            Minecraft.getMinecraft().player.motionZ = MathHelper.cos(getDirection()) * llIlIIllIlIIlll;
        }
        else if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
            Minecraft.getMinecraft().player.motionX = MathHelper.sin(getDirection()) * llIlIIllIlIIlll;
            Minecraft.getMinecraft().player.motionZ = -MathHelper.cos(getDirection()) * llIlIIllIlIIlll;
        }
    }
    
    public static void printMessage(final String llIlIIllIlIIlII) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(llIlIIllIlIIlII));
    }
    
    public static void forward(final double llIlIIllIlIllII) {
        final double llIlIIllIlIlIll = Math.toRadians(Minecraft.getMinecraft().player.rotationYaw);
        Minecraft.getMinecraft().player.setPosition(Minecraft.getMinecraft().player.posX + -Math.sin(llIlIIllIlIlIll) * llIlIIllIlIllII, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ + Math.cos(llIlIIllIlIlIll) * llIlIIllIlIllII);
    }
}
