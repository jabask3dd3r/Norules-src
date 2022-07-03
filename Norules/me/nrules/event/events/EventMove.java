package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.client.*;
import net.minecraft.potion.*;

public class EventMove extends Event
{
    private /* synthetic */ double z;
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    
    public void setY(final double lllllllllllllIIlIIIIlllllIllIIll) {
        this.y = lllllllllllllIIlIIIIlllllIllIIll;
    }
    
    public double getMovementSpeed() {
        double lllllllllllllIIlIIIIlllllIlIllIl = 0.2873;
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(1))) {
            final int lllllllllllllIIlIIIIlllllIlIllII = Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(1)).getAmplifier();
            lllllllllllllIIlIIIIlllllIlIllIl *= 1.0 + 0.2 * (lllllllllllllIIlIIIIlllllIlIllII + 1);
        }
        return lllllllllllllIIlIIIIlllllIlIllIl;
    }
    
    public EventMove(final double lllllllllllllIIlIIIIllllllIIlIII, final double lllllllllllllIIlIIIIllllllIIlIll, final double lllllllllllllIIlIIIIllllllIIIllI) {
        this.x = lllllllllllllIIlIIIIllllllIIlIII;
        this.y = lllllllllllllIIlIIIIllllllIIlIll;
        this.z = lllllllllllllIIlIIIIllllllIIIllI;
    }
    
    public void setZ(final double lllllllllllllIIlIIIIlllllIIlllII) {
        this.z = lllllllllllllIIlIIIIlllllIIlllII;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setX(final double lllllllllllllIIlIIIIlllllIlllIIl) {
        this.x = lllllllllllllIIlIIIIlllllIlllIIl;
    }
    
    public double getLegitMotion() {
        return 0.41999998688697815;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getMotionY(double lllllllllllllIIlIIIIlllllIIlIlIl) {
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(8))) {
            lllllllllllllIIlIIIIlllllIIlIlIl += (Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(8)).getAmplifier() + 1) * 0.1;
        }
        return lllllllllllllIIlIIIIlllllIIlIlIl;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getMovementSpeed(final double lllllllllllllIIlIIIIlllllIlIIlIl) {
        double lllllllllllllIIlIIIIlllllIlIIlII = lllllllllllllIIlIIIIlllllIlIIlIl;
        if (Minecraft.getMinecraft().player.isPotionActive(Potion.getPotionById(1))) {
            final int lllllllllllllIIlIIIIlllllIlIIIll = Minecraft.getMinecraft().player.getActivePotionEffect(Potion.getPotionById(1)).getAmplifier();
            return lllllllllllllIIlIIIIlllllIlIIlII *= 1.0 + 0.2 * (lllllllllllllIIlIIIIlllllIlIIIll + 1);
        }
        return lllllllllllllIIlIIIIlllllIlIIlII;
    }
}
