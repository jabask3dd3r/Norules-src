package me.nrules.utils.player;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;

public enum MouseUtil
{
    INSTANCE("INSTANCE", 0);
    
    private ScaledResolution sr() {
        return new ScaledResolution(Minecraft.getMinecraft());
    }
    
    public int getMouseX() {
        return Mouse.getX() * this.sr().getScaledWidth() / Minecraft.getMinecraft().displayWidth;
    }
    
    public boolean isHovered(final float llllllllllllllIIlIlllIlllIIIlIll, final float llllllllllllllIIlIlllIlllIIIlIlI, final float llllllllllllllIIlIlllIlllIIIlllI, final float llllllllllllllIIlIlllIlllIIIllIl) {
        return this.getMouseX() > llllllllllllllIIlIlllIlllIIIlIll && this.getMouseX() < llllllllllllllIIlIlllIlllIIIlllI && this.getMouseY() > llllllllllllllIIlIlllIlllIIIlIlI && this.getMouseY() < llllllllllllllIIlIlllIlllIIIllIl;
    }
    
    private MouseUtil(final String llllllllllllllIIlIlllIlllIIlllll, final int llllllllllllllIIlIlllIlllIIllllI) {
    }
    
    public int getMouseY() {
        return this.sr().getScaledHeight() - Mouse.getY() * this.sr().getScaledHeight() / Minecraft.getMinecraft().displayHeight - 1;
    }
}
