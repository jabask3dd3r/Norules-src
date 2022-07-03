package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketKeepAlive implements Packet<INetHandlerPlayServer>
{
    public /* synthetic */ long key;
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllllIllllIllIIIlIIl) {
        lllllllllllllllllIllllIllIIIlIIl.processKeepAlive(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllIllllIlIlllllll) throws IOException {
        lllllllllllllllllIllllIlIlllllll.writeLong(this.key);
    }
    
    public long getKey() {
        return this.key;
    }
    
    public CPacketKeepAlive(final long lllllllllllllllllIllllIllIIIllll) {
        this.key = lllllllllllllllllIllllIllIIIllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllIllllIllIIIIIll) throws IOException {
        this.key = lllllllllllllllllIllllIllIIIIIll.readLong();
    }
    
    public CPacketKeepAlive() {
    }
}
