package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketCloseWindow implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int windowId;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllllIllllllIlIIIlI) throws IOException {
        lllllllllllllIllllIllllllIlIIIlI.writeByte(this.windowId);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllllIllllllIlIlllI) {
        lllllllllllllIllllIllllllIlIlllI.handleCloseWindow(this);
    }
    
    public SPacketCloseWindow() {
    }
    
    public SPacketCloseWindow(final int lllllllllllllIllllIllllllIllIllI) {
        this.windowId = lllllllllllllIllllIllllllIllIllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllllIllllllIlIlIII) throws IOException {
        this.windowId = lllllllllllllIllllIllllllIlIlIII.readUnsignedByte();
    }
}
