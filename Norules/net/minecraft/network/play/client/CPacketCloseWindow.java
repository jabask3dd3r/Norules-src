package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketCloseWindow implements Packet<INetHandlerPlayServer>
{
    public /* synthetic */ int windowId;
    
    public CPacketCloseWindow() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIlIIIIIlllIlII) throws IOException {
        lllllllllllllllIIlIlIIIIIlllIlII.writeByte(this.windowId);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllIIlIlIIIIlIIIIIlI) {
        lllllllllllllllIIlIlIIIIlIIIIIlI.processCloseWindow(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIlIIIIIllllIlI) throws IOException {
        this.windowId = lllllllllllllllIIlIlIIIIIllllIlI.readByte();
    }
    
    public CPacketCloseWindow(final int lllllllllllllllIIlIlIIIIlIIIlIII) {
        this.windowId = lllllllllllllllIIlIlIIIIlIIIlIII;
    }
}
