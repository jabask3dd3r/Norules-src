package net.minecraft.network.status.server;

import net.minecraft.network.status.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketPong implements Packet<INetHandlerStatusClient>
{
    private /* synthetic */ long clientTime;
    
    public SPacketPong() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllIIllIIlIlIl) throws IOException {
        this.clientTime = llllIIllIIlIlIl.readLong();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllIIllIIlIIIl) throws IOException {
        llllIIllIIlIIIl.writeLong(this.clientTime);
    }
    
    @Override
    public void processPacket(final INetHandlerStatusClient llllIIllIIIlIll) {
        llllIIllIIIlIll.handlePong(this);
    }
    
    public SPacketPong(final long llllIIllIIlllIl) {
        this.clientTime = llllIIllIIlllIl;
    }
}
