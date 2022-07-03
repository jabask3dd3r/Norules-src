package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketHeldItemChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int heldItemHotbarIndex;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIllllIlIlllIIIll) {
        llllllllllllllIIIllllIlIlllIIIll.handleHeldItemChange(this);
    }
    
    public int getHeldItemHotbarIndex() {
        return this.heldItemHotbarIndex;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIllllIlIlllIllll) throws IOException {
        this.heldItemHotbarIndex = llllllllllllllIIIllllIlIlllIllll.readByte();
    }
    
    public SPacketHeldItemChange(final int llllllllllllllIIIllllIlIllllIlll) {
        this.heldItemHotbarIndex = llllllllllllllIIIllllIlIllllIlll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIllllIlIlllIlIll) throws IOException {
        llllllllllllllIIIllllIlIlllIlIll.writeByte(this.heldItemHotbarIndex);
    }
    
    public SPacketHeldItemChange() {
    }
}
