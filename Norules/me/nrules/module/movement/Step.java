package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.utils.world.*;
import me.nrules.notifications.*;
import me.nrules.event.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import me.nrules.module.*;
import java.util.*;
import me.nrules.event.events.*;

public class Step extends Module
{
    public /* synthetic */ Setting stepMode;
    public static /* synthetic */ TimerHelper time;
    public static /* synthetic */ TimerHelper lastStep;
    public /* synthetic */ Setting vanillaHeight;
    /* synthetic */ boolean resetTimer;
    
    static {
        Step.lastStep = new TimerHelper();
        Step.time = new TimerHelper();
    }
    
    @Override
    public void onDisable() {
        Step.mc.player.stepHeight = 0.625f;
        Step.mc.timer.timerSpeed = 1.0f;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onStepConfirm(final EventStep lllllllllllllIIlIIIIIIllIlIIIIII) {
        if (this.stepMode.getValString().equalsIgnoreCase("Matrix")) {
            final float lllllllllllllIIlIIIIIIllIlIIIlIl = 0.37f;
            if (this.resetTimer) {
                this.resetTimer = false;
                Step.mc.timer.timerSpeed = 1.0f;
            }
            if (lllllllllllllIIlIIIIIIllIlIIIIII.isPre()) {
                if (Step.mc.player.isCollidedVertically && !Step.mc.gameSettings.keyBindJump.isPressed()) {
                    lllllllllllllIIlIIIIIIllIlIIIIII.setStepHeight(1.0);
                    lllllllllllllIIlIIIIIIllIlIIIIII.setActive(true);
                }
            }
            else {
                final double lllllllllllllIIlIIIIIIllIlIIIIll = Step.mc.player.getEntityBoundingBox().minY - Step.mc.player.posY;
                final boolean lllllllllllllIIlIIIIIIllIlIIIIlI;
                final boolean lllllllllllllIIlIIIIIIllIlIIIlII = lllllllllllllIIlIIIIIIllIlIIIIlI = (lllllllllllllIIlIIIIIIllIlIIIIll >= 0.625);
                if (lllllllllllllIIlIIIIIIllIlIIIlII) {
                    Step.lastStep.reset();
                    Step.time.reset();
                }
                if (lllllllllllllIIlIIIIIIllIlIIIlII) {
                    this.matrixStep(lllllllllllllIIlIIIIIIllIlIIIIll);
                    this.resetTimer = true;
                    Step.mc.timer.timerSpeed = ((lllllllllllllIIlIIIIIIllIlIIIIll < 2.0) ? 0.6f : 0.3f);
                }
            }
        }
    }
    
    void matrixStep(final double lllllllllllllIIlIIIIIIllIIllIllI) {
        final double lllllllllllllIIlIIIIIIllIIllIlIl = Step.mc.player.posX;
        final double lllllllllllllIIlIIIIIIllIIllIlII = Step.mc.player.posZ;
        final double lllllllllllllIIlIIIIIIllIIllIIll = Step.mc.player.posY;
        final double lllllllllllllIIlIIIIIIllIIllIIlI = 0.42;
        Step.mc.player.connection.sendPacket(new CPacketPlayer.Position(lllllllllllllIIlIIIIIIllIIllIlIl, lllllllllllllIIlIIIIIIllIIllIIll + lllllllllllllIIlIIIIIIllIIllIIlI, lllllllllllllIIlIIIIIIllIIllIlII, false));
    }
    
    public Step() {
        super("Step", 0, Category.MOVEMENT);
        this.stepMode = new Setting("Mode", this, "Matrix", new ArrayList<String>(Arrays.asList("Matrix", "Vanilla")));
        this.vanillaHeight = new Setting("VanillaHeight", this, 2.0, 0.0, 100.0, true);
        Step.sm.Property(this.stepMode);
        Step.sm.Property(this.vanillaHeight);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIlIIIIIIllIIlIlIII) {
        if (this.stepMode.getValString().equalsIgnoreCase("Vanilla")) {
            Step.mc.player.stepHeight = this.vanillaHeight.getValFloat();
        }
        else {
            Step.mc.player.stepHeight = 0.625f;
        }
    }
}
