package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import me.nrules.utils.player.*;
import net.minecraft.util.math.*;

public class JumpEvent extends Event
{
    public void setJumpHeight(final int llllllllllllllIlIIlIlllIllllllll) {
        Minecraft.getMinecraft().player.motionY = llllllllllllllIlIIlIlllIllllllll;
    }
    
    public void setMotion(final Entity llllllllllllllIlIIlIllllIIIIIlIl, final double llllllllllllllIlIIlIllllIIIIIlII) {
        llllllllllllllIlIIlIllllIIIIIlIl.motionX = -MathHelper.sin((float)MoveUtil.getDirection()) * llllllllllllllIlIIlIllllIIIIIlII;
        llllllllllllllIlIIlIllllIIIIIlIl.motionZ = MathHelper.cos((float)MoveUtil.getDirection()) * llllllllllllllIlIIlIllllIIIIIlII;
    }
}
