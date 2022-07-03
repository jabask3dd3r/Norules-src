package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class CPacketResourcePackStatus implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllIIllllIlII) {
        lllIIllllIlII.handleResourcePackStatus(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIIlllllIII) throws IOException {
        lllIIlllllIII.writeEnumValue(this.action);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllIlIIIIIIII) throws IOException {
        this.action = lllIlIIIIIIII.readEnumValue(Action.class);
    }
    
    public CPacketResourcePackStatus() {
    }
    
    public CPacketResourcePackStatus(final Action lllIlIIIIIlII) {
        this.action = lllIlIIIIIlII;
    }
    
    public enum Action
    {
        SUCCESSFULLY_LOADED("SUCCESSFULLY_LOADED", 0), 
        FAILED_DOWNLOAD("FAILED_DOWNLOAD", 2), 
        ACCEPTED("ACCEPTED", 3), 
        DECLINED("DECLINED", 1);
        
        private Action(final String lllllllllllllIlIlllllIlIlIllIlII, final int lllllllllllllIlIlllllIlIlIllIIll) {
        }
    }
}
