package net.minecraft.util;

import net.minecraft.client.*;
import net.minecraft.util.math.*;

public class Timer
{
    /* synthetic */ float ticksPerSecond;
    public /* synthetic */ long field_74285_i;
    public /* synthetic */ long lastSyncHRClock;
    public /* synthetic */ float elapsedPartialTicks;
    public /* synthetic */ double timeSyncAdjustment;
    public /* synthetic */ float renderPartialTicks;
    public /* synthetic */ float timerSpeed;
    public /* synthetic */ int elapsedTicks;
    private /* synthetic */ long lastSyncSysClock;
    public /* synthetic */ double lastHRTime;
    
    public void updateTimer() {
        final long llllllllllllllIlllIlIIlIlllIlIIl = Minecraft.getSystemTime();
        final long llllllllllllllIlllIlIIlIlllIlIII = llllllllllllllIlllIlIIlIlllIlIIl - this.lastSyncSysClock;
        final long llllllllllllllIlllIlIIlIlllIIlll = System.nanoTime() / 1000000L;
        final double llllllllllllllIlllIlIIlIlllIIllI = llllllllllllllIlllIlIIlIlllIIlll / 1000.0;
        if (llllllllllllllIlllIlIIlIlllIlIII <= 1000L && llllllllllllllIlllIlIIlIlllIlIII >= 0L) {
            this.field_74285_i += llllllllllllllIlllIlIIlIlllIlIII;
            if (this.field_74285_i > 1000L) {
                final long llllllllllllllIlllIlIIlIlllIIlIl = llllllllllllllIlllIlIIlIlllIIlll - this.lastSyncHRClock;
                final double llllllllllllllIlllIlIIlIlllIIlII = this.field_74285_i / (double)llllllllllllllIlllIlIIlIlllIIlIl;
                this.timeSyncAdjustment += (llllllllllllllIlllIlIIlIlllIIlII - this.timeSyncAdjustment) * 0.20000000298023224;
                this.lastSyncHRClock = llllllllllllllIlllIlIIlIlllIIlll;
                this.field_74285_i = 0L;
            }
            if (this.field_74285_i < 0L) {
                this.lastSyncHRClock = llllllllllllllIlllIlIIlIlllIIlll;
            }
        }
        else {
            this.lastHRTime = llllllllllllllIlllIlIIlIlllIIllI;
        }
        this.lastSyncSysClock = llllllllllllllIlllIlIIlIlllIlIIl;
        double llllllllllllllIlllIlIIlIlllIIIll = (llllllllllllllIlllIlIIlIlllIIllI - this.lastHRTime) * this.timeSyncAdjustment;
        this.lastHRTime = llllllllllllllIlllIlIIlIlllIIllI;
        llllllllllllllIlllIlIIlIlllIIIll = MathHelper.clamp(llllllllllllllIlllIlIIlIlllIIIll, 0.0, 1.0);
        this.elapsedPartialTicks += (float)(llllllllllllllIlllIlIIlIlllIIIll * this.timerSpeed * this.ticksPerSecond);
        this.elapsedTicks = (int)this.elapsedPartialTicks;
        this.elapsedPartialTicks -= this.elapsedTicks;
        if (this.elapsedTicks > 10) {
            this.elapsedTicks = 10;
        }
        this.renderPartialTicks = this.elapsedPartialTicks;
    }
    
    public Timer(final float llllllllllllllIlllIlIIlIllllIIlI) {
        this.timerSpeed = 1.0f;
        this.timeSyncAdjustment = 1.0;
        this.ticksPerSecond = llllllllllllllIlllIlIIlIllllIIlI;
        this.lastSyncSysClock = Minecraft.getSystemTime();
        this.lastSyncHRClock = System.nanoTime() / 1000000L;
    }
}
