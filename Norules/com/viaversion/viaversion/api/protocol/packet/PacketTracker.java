package com.viaversion.viaversion.api.protocol.packet;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.configuration.*;

public class PacketTracker
{
    private /* synthetic */ long receivedPackets;
    private /* synthetic */ long startTime;
    private /* synthetic */ int secondsObserved;
    private /* synthetic */ long packetsPerSecond;
    private /* synthetic */ int warnings;
    private /* synthetic */ long intervalPackets;
    private /* synthetic */ long sentPackets;
    private final /* synthetic */ UserConnection connection;
    
    public long getIntervalPackets() {
        return this.intervalPackets;
    }
    
    public long getStartTime() {
        return this.startTime;
    }
    
    public void setWarnings(final int llllllllllllllIllIIlllIIlIIlIIll) {
        this.warnings = llllllllllllllIllIIlllIIlIIlIIll;
    }
    
    public void setStartTime(final long llllllllllllllIllIIlllIIlIllIlll) {
        this.startTime = llllllllllllllIllIIlllIIlIllIlll;
    }
    
    public long getSentPackets() {
        return this.sentPackets;
    }
    
    public void incrementSent() {
        ++this.sentPackets;
    }
    
    public boolean incrementReceived() {
        final long llllllllllllllIllIIlllIIllIllIlI = System.currentTimeMillis() - this.startTime;
        if (llllllllllllllIllIIlllIIllIllIlI >= 1000L) {
            this.packetsPerSecond = this.intervalPackets;
            this.startTime = System.currentTimeMillis();
            this.intervalPackets = 1L;
            return true;
        }
        ++this.intervalPackets;
        ++this.receivedPackets;
        return false;
    }
    
    public void setSentPackets(final long llllllllllllllIllIIlllIIllIIlIIl) {
        this.sentPackets = llllllllllllllIllIIlllIIllIIlIIl;
    }
    
    public void setSecondsObserved(final int llllllllllllllIllIIlllIIlIIlllII) {
        this.secondsObserved = llllllllllllllIllIIlllIIlIIlllII;
    }
    
    public boolean exceedsMaxPPS() {
        if (this.connection.isClientSide()) {
            return false;
        }
        final ViaVersionConfig llllllllllllllIllIIlllIIllIlIlII = Via.getConfig();
        if (llllllllllllllIllIIlllIIllIlIlII.getMaxPPS() > 0 && this.packetsPerSecond >= llllllllllllllIllIIlllIIllIlIlII.getMaxPPS()) {
            this.connection.disconnect(llllllllllllllIllIIlllIIllIlIlII.getMaxPPSKickMessage().replace("%pps", Long.toString(this.packetsPerSecond)));
            return true;
        }
        if (llllllllllllllIllIIlllIIllIlIlII.getMaxWarnings() > 0 && llllllllllllllIllIIlllIIllIlIlII.getTrackingPeriod() > 0) {
            if (this.secondsObserved > llllllllllllllIllIIlllIIllIlIlII.getTrackingPeriod()) {
                this.warnings = 0;
                this.secondsObserved = 1;
            }
            else {
                ++this.secondsObserved;
                if (this.packetsPerSecond >= llllllllllllllIllIIlllIIllIlIlII.getWarningPPS()) {
                    ++this.warnings;
                }
                if (this.warnings >= llllllllllllllIllIIlllIIllIlIlII.getMaxWarnings()) {
                    this.connection.disconnect(llllllllllllllIllIIlllIIllIlIlII.getMaxWarningsKickMessage().replace("%pps", Long.toString(this.packetsPerSecond)));
                    return true;
                }
            }
        }
        return false;
    }
    
    public long getReceivedPackets() {
        return this.receivedPackets;
    }
    
    public int getSecondsObserved() {
        return this.secondsObserved;
    }
    
    public void setReceivedPackets(final long llllllllllllllIllIIlllIIllIIIIII) {
        this.receivedPackets = llllllllllllllIllIIlllIIllIIIIII;
    }
    
    public PacketTracker(final UserConnection llllllllllllllIllIIlllIIlllIIIIl) {
        this.packetsPerSecond = -1L;
        this.connection = llllllllllllllIllIIlllIIlllIIIIl;
    }
    
    public void setPacketsPerSecond(final long llllllllllllllIllIIlllIIlIlIIlIl) {
        this.packetsPerSecond = llllllllllllllIllIIlllIIlIlIIlIl;
    }
    
    public void setIntervalPackets(final long llllllllllllllIllIIlllIIlIlIlllI) {
        this.intervalPackets = llllllllllllllIllIIlllIIlIlIlllI;
    }
    
    public int getWarnings() {
        return this.warnings;
    }
    
    public long getPacketsPerSecond() {
        return this.packetsPerSecond;
    }
}
