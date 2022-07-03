package me.nrules.utils.world;

public class TimerHelper
{
    private /* synthetic */ long prevMS;
    private /* synthetic */ long lastMS;
    private /* synthetic */ long previousTime;
    public static /* synthetic */ float timerSpeed;
    
    private long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
    
    public void setDifference(final long lllllllllllllIlIIlllIlIIlIIlllIl) {
        this.prevMS = this.getTime() - lllllllllllllIlIIlllIlIIlIIlllIl;
    }
    
    public long getTime() {
        return this.getCurrentMS() - this.lastMS;
    }
    
    public TimerHelper() {
        this.previousTime = -1L;
        this.prevMS = 0L;
    }
    
    public void setTime(final long lllllllllllllIlIIlllIlIIIllIlllI) {
        this.lastMS = lllllllllllllIlIIlllIlIIIllIlllI;
    }
    
    static {
        TimerHelper.timerSpeed = 1.0f;
    }
    
    public boolean check(final double lllllllllllllIlIIlllIlIIlIllIIIl) {
        return (float)(this.getCurrentTime() - this.previousTime) >= lllllllllllllIlIIlllIlIIlIllIIIl;
    }
    
    public boolean hasTimeElapsed(final long lllllllllllllIlIIlllIlIIllIIIlII, final boolean lllllllllllllIlIIlllIlIIllIIIIII) {
        if (System.currentTimeMillis() - this.lastMS > lllllllllllllIlIIlllIlIIllIIIlII) {
            if (lllllllllllllIlIIlllIlIIllIIIIII) {
                this.reset();
            }
            return true;
        }
        return false;
    }
    
    public boolean delay(final float lllllllllllllIlIIlllIlIIIllllIll) {
        return this.getTime() - this.prevMS >= lllllllllllllIlIIlllIlIIIllllIll;
    }
    
    public long getPrevMS() {
        return this.prevMS;
    }
    
    public long getDifference() {
        return this.getTime() - this.prevMS;
    }
    
    public void reset() {
        this.lastMS = this.getCurrentMS();
    }
    
    public boolean hasReached(final double lllllllllllllIlIIlllIlIIlIIIllIl) {
        return this.getCurrentMS() - this.lastMS >= lllllllllllllIlIIlllIlIIlIIIllIl;
    }
}
