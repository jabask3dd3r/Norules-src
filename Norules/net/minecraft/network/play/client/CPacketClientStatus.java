package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketClientStatus implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ State status;
    
    public CPacketClientStatus(final State lllllllllllllIllIIIlllIlIIlllIll) {
        this.status = lllllllllllllIllIIIlllIlIIlllIll;
    }
    
    public CPacketClientStatus() {
    }
    
    public State getStatus() {
        return this.status;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIIlllIlIIllIlll) throws IOException {
        this.status = lllllllllllllIllIIIlllIlIIllIlll.readEnumValue(State.class);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIIlllIlIIlIllll) throws IOException {
        lllllllllllllIllIIIlllIlIIlIllll.writeEnumValue(this.status);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllIIIlllIlIIlIlIll) {
        lllllllllllllIllIIIlllIlIIlIlIll.processClientStatus(this);
    }
    
    public enum State
    {
        REQUEST_STATS("REQUEST_STATS", 1), 
        PERFORM_RESPAWN("PERFORM_RESPAWN", 0);
        
        private State(final String llllllllllllllIIIllIIIlIlIlIllIl, final int llllllllllllllIIIllIIIlIlIlIllII) {
        }
    }
}
