package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketKeepAlive implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ long id;
    
    public long getId() {
        return this.id;
    }
    
    public SPacketKeepAlive(final long llllllllllllllIIlllIlIlIllIIlIll) {
        this.id = llllllllllllllIIlllIlIlIllIIlIll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlllIlIlIllIIIlll) {
        llllllllllllllIIlllIlIlIllIIIlll.handleKeepAlive(this);
    }
    
    public SPacketKeepAlive() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlllIlIlIllIIIIIl) throws IOException {
        this.id = llllllllllllllIIlllIlIlIllIIIIIl.readLong();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlllIlIlIlIlllIIl) throws IOException {
        llllllllllllllIIlllIlIlIlIlllIIl.writeLong(this.id);
    }
}
