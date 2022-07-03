package com.kisman.nr.cc.util;

public class TimerUtils
{
    private /* synthetic */ long prevMS;
    private /* synthetic */ long lastMS;
    private /* synthetic */ long nanoTime;
    
    public long getMicro() {
        return this.convertNanoToMicro(this.nanoTime);
    }
    
    public boolean passedSec(final long llllllllllllllllIIlllIlllIIIlIlI) {
        return this.passedNano(this.convertSecToNano(llllllllllllllllIIlllIlllIIIlIlI));
    }
    
    public boolean passedMicro(final long llllllllllllllllIIlllIlllIIlIllI) {
        return this.passedNano(this.convertMicroToNano(llllllllllllllllIIlllIlllIIlIllI));
    }
    
    public long convertMicroToNano(final long llllllllllllllllIIlllIllIlIIIIII) {
        return llllllllllllllllIIlllIllIlIIIIII * 1000L;
    }
    
    public void setLastMS() {
        this.lastMS = System.currentTimeMillis();
    }
    
    public boolean passedNano(final long llllllllllllllllIIlllIlllIIlllII) {
        return System.nanoTime() - this.nanoTime >= llllllllllllllllIIlllIlllIIlllII;
    }
    
    public boolean hasTimeElapsed(final long llllllllllllllllIIlllIlllllIIlIl, final boolean llllllllllllllllIIlllIlllllIIlII) {
        if (llllllllllllllllIIlllIlllllIIlIl < 150L) {
            if (this.getTime() >= llllllllllllllllIIlllIlllllIIlIl / 1.63) {
                if (llllllllllllllllIIlllIlllllIIlII) {
                    this.reset();
                }
                return true;
            }
        }
        else if (this.getTime() >= llllllllllllllllIIlllIlllllIIlIl) {
            if (llllllllllllllllIIlllIlllllIIlII) {
                this.reset();
            }
            return true;
        }
        return false;
    }
    
    public long convertMillisToMicro(final long llllllllllllllllIIlllIllIlIIlIll) {
        return llllllllllllllllIIlllIllIlIIlIll * 1000L;
    }
    
    public long convertNanoToTicks(final long llllllllllllllllIIlllIllIllIIlII) {
        return this.convertMillisToTicks(this.convertNanoToMillis(llllllllllllllllIIlllIllIllIIlII));
    }
    
    public boolean passedTicks(final long llllllllllllllllIIlllIlllIlIIIII) {
        return this.passedNano(this.convertTicksToNano(llllllllllllllllIIlllIlllIlIIIII));
    }
    
    public long getNano() {
        return this.nanoTime;
    }
    
    public long convertNanoToMicro(final long llllllllllllllllIIlllIllIIllllII) {
        return llllllllllllllllIIlllIllIIllllII / 1000L;
    }
    
    public void setLastMS(final long llllllllllllllllIIlllIllllIllIlI) {
        this.lastMS = llllllllllllllllIIlllIllllIllIlI;
    }
    
    public long convertMicroToMillis(final long llllllllllllllllIIlllIllIIlIllII) {
        return llllllllllllllllIIlllIllIIlIllII / 1000L;
    }
    
    public long convertSecToMillis(final long llllllllllllllllIIlllIllIlIllIll) {
        return llllllllllllllllIIlllIllIlIllIll * 1000L;
    }
    
    public int convertToMS(final int llllllllllllllllIIlllIllllIlIlII) {
        return 1000 / llllllllllllllllIIlllIllllIlIlII;
    }
    
    public void setSec(final long llllllllllllllllIIlllIlllIllIlll) {
        this.nanoTime = System.nanoTime() - this.convertSecToNano(llllllllllllllllIIlllIlllIllIlll);
    }
    
    public long convertTicksToNano(final long llllllllllllllllIIlllIllIllIIIII) {
        return this.convertMillisToNano(this.convertTicksToMillis(llllllllllllllllIIlllIllIllIIIII));
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
    
    public void resetTimeSkipTo(final long llllllllllllllllIIlllIllIllllIll) {
        this.lastMS = this.getCurrentMS() + llllllllllllllllIIlllIllIllllIll;
        this.nanoTime = System.nanoTime();
    }
    
    public void reset() {
        this.lastMS = this.getCurrentMS();
        this.nanoTime = System.nanoTime();
    }
    
    public long convertMillisToNano(final long llllllllllllllllIIlllIllIlIIIllI) {
        return this.convertMicroToNano(this.convertMillisToMicro(llllllllllllllllIIlllIllIlIIIllI));
    }
    
    public long convertNanoToSec(final long llllllllllllllllIIlllIllIIllIIlI) {
        return this.convertMillisToSec(this.convertMicroToMillis(this.convertNanoToMicro(llllllllllllllllIIlllIllIIllIIlI)));
    }
    
    public void setMillis(final long llllllllllllllllIIlllIlllIllllIl) {
        this.nanoTime = System.nanoTime() - this.convertMillisToNano(llllllllllllllllIIlllIlllIllllIl);
    }
    
    public long convertSecToNano(final long llllllllllllllllIIlllIllIlIIlllI) {
        return this.convertMicroToNano(this.convertMillisToMicro(this.convertSecToMillis(llllllllllllllllIIlllIllIlIIlllI)));
    }
    
    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getMillis() {
        return this.convertNanoToMillis(this.nanoTime);
    }
    
    public void setTicks(final long llllllllllllllllIIlllIllllIIllIl) {
        this.nanoTime = System.nanoTime() - this.convertTicksToNano(llllllllllllllllIIlllIllllIIllIl);
    }
    
    public long convertMicroToSec(final long llllllllllllllllIIlllIllIIlIIllI) {
        return this.convertMillisToSec(this.convertMicroToMillis(llllllllllllllllIIlllIllIIlIIllI));
    }
    
    public long getTicks() {
        return this.convertNanoToTicks(this.nanoTime);
    }
    
    public void setMicro(final long llllllllllllllllIIlllIllllIIIIIl) {
        this.nanoTime = System.nanoTime() - this.convertMicroToNano(llllllllllllllllIIlllIllllIIIIIl);
    }
    
    public long getSec() {
        return this.convertNanoToSec(this.nanoTime);
    }
    
    public long convertTicksToMillis(final long llllllllllllllllIIlllIllIllIlIlI) {
        return llllllllllllllllIIlllIllIllIlIlI * 50L;
    }
    
    public long convertSecToMicro(final long llllllllllllllllIIlllIllIlIlIlII) {
        return this.convertMillisToMicro(this.convertSecToMillis(llllllllllllllllIIlllIllIlIlIlII));
    }
    
    public long convertNanoToMillis(final long llllllllllllllllIIlllIllIIlllIII) {
        return this.convertMicroToMillis(this.convertNanoToMicro(llllllllllllllllIIlllIllIIlllIII));
    }
    
    public void setNano(final long llllllllllllllllIIlllIllllIIlIIl) {
        this.nanoTime = System.nanoTime() - llllllllllllllllIIlllIllllIIlIIl;
    }
    
    public long convertMillisToSec(final long llllllllllllllllIIlllIllIIlIIIll) {
        return llllllllllllllllIIlllIllIIlIIIll / 1000L;
    }
    
    public long convertMillisToTicks(final long llllllllllllllllIIlllIllIllIllll) {
        return llllllllllllllllIIlllIllIllIllll / 50L;
    }
    
    public boolean hasReached(final float llllllllllllllllIIlllIlllIIIIIlI) {
        return this.getCurrentMS() - this.lastMS >= llllllllllllllllIIlllIlllIIIIIlI;
    }
    
    public boolean isDelay(final long llllllllllllllllIIlllIlllllIlIlI) {
        return System.currentTimeMillis() - this.lastMS >= llllllllllllllllIIlllIlllllIlIlI;
    }
    
    public boolean passedMillis(final long llllllllllllllllIIlllIlllIIlIIII) {
        return this.passedNano(this.convertMillisToNano(llllllllllllllllIIlllIlllIIlIIII));
    }
    
    public TimerUtils() {
        this.lastMS = 0L;
        this.prevMS = 0L;
        this.nanoTime = -1L;
    }
    
    public boolean delay(final float llllllllllllllllIIlllIllIlllIlIl) {
        return this.getTime() - this.prevMS >= llllllllllllllllIIlllIllIlllIlIl;
    }
}
