package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketHeldItemChange implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int slotId;
    
    public CPacketHeldItemChange() {
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIlIIIllIllIIIII) throws IOException {
        lllllllllllllIllIIlIIIllIllIIIII.writeShort(this.slotId);
    }
    
    public CPacketHeldItemChange(final int lllllllllllllIllIIlIIIllIlllIllI) {
        this.slotId = lllllllllllllIllIIlIIIllIlllIllI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllIIlIIIllIlIlIlIl) {
        lllllllllllllIllIIlIIIllIlIlIlIl.processHeldItemChange(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIlIIIllIllIlIll) throws IOException {
        this.slotId = lllllllllllllIllIIlIIIllIllIlIll.readShort();
    }
}
