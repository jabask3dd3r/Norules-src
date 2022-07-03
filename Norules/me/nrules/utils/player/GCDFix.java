package me.nrules.utils.player;

import net.minecraft.client.*;

public class GCDFix
{
    private /* synthetic */ float pitch;
    private /* synthetic */ float yaw;
    static /* synthetic */ Minecraft mc;
    
    public final void setPitch(final float lllllllllllllIlIlllIIIIlIIlIIIII) {
        this.pitch = lllllllllllllIlIlllIIIIlIIlIIIII;
    }
    
    public GCDFix(final float lllllllllllllIlIlllIIIIlIIlllIlI, final float lllllllllllllIlIlllIIIIlIIllllII) {
        this.yaw = lllllllllllllIlIlllIIIIlIIlllIlI;
        this.pitch = lllllllllllllIlIlllIIIIlIIllllII;
    }
    
    public static float getDeltaMouse(final float lllllllllllllIlIlllIIIIlIIllIIIl) {
        return (float)Math.round(lllllllllllllIlIlllIIIIlIIllIIIl / getGCDValue());
    }
    
    public final void setYaw(final float lllllllllllllIlIlllIIIIlIIlIIlll) {
        this.yaw = lllllllllllllIlIlllIIIIlIIlIIlll;
    }
    
    public static float getGCDValue() {
        return (float)(getGCD() * 0.15);
    }
    
    public final float getPitch() {
        return this.pitch;
    }
    
    static {
        GCDFix.mc = Minecraft.getMinecraft();
    }
    
    public static float getFixedRotation(final float lllllllllllllIlIlllIIIIlIIllIlll) {
        return getDeltaMouse(lllllllllllllIlIlllIIIIlIIllIlll) * getGCDValue();
    }
    
    public final float getYaw() {
        return this.yaw;
    }
    
    public static float getGCD() {
        final float lllllllllllllIlIlllIIIIlIIllIlII;
        return (lllllllllllllIlIlllIIIIlIIllIlII = (float)(GCDFix.mc.gameSettings.mouseSensitivity * 0.6 + 0.2)) * lllllllllllllIlIlllIIIIlIIllIlII * lllllllllllllIlIlllIIIIlIIllIlII * 8.0f;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Rotation(yaw=").append(this.yaw).append(", pitch=").append(this.pitch).append(")"));
    }
    
    @Override
    public int hashCode() {
        return Float.hashCode(this.yaw) * 31 + Float.hashCode(this.pitch);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlllIIIIlIIIlIIII) {
        if (this == lllllllllllllIlIlllIIIIlIIIlIIII) {
            return true;
        }
        if (lllllllllllllIlIlllIIIIlIIIlIIII instanceof GCDFix) {
            final GCDFix lllllllllllllIlIlllIIIIlIIIlIIlI = (GCDFix)lllllllllllllIlIlllIIIIlIIIlIIII;
            return Float.compare(this.yaw, lllllllllllllIlIlllIIIIlIIIlIIlI.yaw) == 0 && Float.compare(this.pitch, lllllllllllllIlIlllIIIIlIIIlIIlI.pitch) == 0;
        }
        return false;
    }
}
