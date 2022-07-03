package me.nrules.utils.render;

public final class Stopwatch
{
    private /* synthetic */ long ms;
    
    public final boolean elapsed(final long lllllllllllllllIlllllIIlllIIIlll) {
        return this.getCurrentMS() - this.ms > lllllllllllllllIlllllIIlllIIIlll;
    }
    
    public final void reset() {
        this.ms = this.getCurrentMS();
    }
    
    public Stopwatch() {
        this.ms = this.getCurrentMS();
    }
    
    public final long getElapsedTime() {
        return this.getCurrentMS() - this.ms;
    }
    
    private long getCurrentMS() {
        return System.currentTimeMillis();
    }
}
