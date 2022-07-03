package net.minecraft.network.status.client;

import net.minecraft.network.status.*;
import net.minecraft.network.*;
import java.io.*;

public class CPacketPing implements Packet<INetHandlerStatusServer>
{
    private /* synthetic */ long clientTime;
    
    public CPacketPing(final long lllllllllllllllllIIlllIIIlIllIIl) {
        this.clientTime = lllllllllllllllllIIlllIIIlIllIIl;
    }
    
    public long getClientTime() {
        return this.clientTime;
    }
    
    @Override
    public void processPacket(final INetHandlerStatusServer lllllllllllllllllIIlllIIIlIIlIIl) {
        lllllllllllllllllIIlllIIIlIIlIIl.processPing(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIIlllIIIlIIllll) throws IOException {
        lllllllllllllllllIIlllIIIlIIllll.writeLong(this.clientTime);
    }
    
    public CPacketPing() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIIlllIIIlIlIIll) throws IOException {
        this.clientTime = lllllllllllllllllIIlllIIIlIlIIll.readLong();
    }
}
