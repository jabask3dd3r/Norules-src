package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketTimeUpdate implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ long worldTime;
    private /* synthetic */ long totalWorldTime;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlllIlllIlllllIIIIl) {
        lllllllllllllIlllIlllIlllllIIIIl.handleTimeUpdate(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlllIlllIlllllIllll) throws IOException {
        this.totalWorldTime = lllllllllllllIlllIlllIlllllIllll.readLong();
        this.worldTime = lllllllllllllIlllIlllIlllllIllll.readLong();
    }
    
    public SPacketTimeUpdate(final long lllllllllllllIlllIlllIlllllllIIl, final long lllllllllllllIlllIlllIllllllIlII, final boolean lllllllllllllIlllIlllIllllllIlll) {
        this.totalWorldTime = lllllllllllllIlllIlllIlllllllIIl;
        this.worldTime = lllllllllllllIlllIlllIllllllIlII;
        if (!lllllllllllllIlllIlllIllllllIlll) {
            this.worldTime = -this.worldTime;
            if (this.worldTime == 0L) {
                this.worldTime = -1L;
            }
        }
    }
    
    public void setTotalWorldTime(final long lllllllllllllIlllIllllIIIIIIIIIl) {
        this.totalWorldTime = lllllllllllllIlllIllllIIIIIIIIIl;
    }
    
    public long getTotalWorldTime() {
        return this.totalWorldTime;
    }
    
    public long getWorldTime() {
        return this.worldTime;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlllIlllIlllllIIlll) throws IOException {
        lllllllllllllIlllIlllIlllllIIlll.writeLong(this.totalWorldTime);
        lllllllllllllIlllIlllIlllllIIlll.writeLong(this.worldTime);
    }
    
    public SPacketTimeUpdate() {
    }
}
