package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketConfirmTeleport implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int telportId;
    
    public int getTeleportId() {
        return this.telportId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIIlIlIlIlIII) throws IOException {
        lllIIlIlIlIlIII.writeVarIntToBuffer(this.telportId);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllIIlIlIlIlllI) throws IOException {
        this.telportId = lllIIlIlIlIlllI.readVarIntFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllIIlIlIlIIIlI) {
        lllIIlIlIlIIIlI.processConfirmTeleport(this);
    }
    
    public CPacketConfirmTeleport(final int lllIIlIlIllIIlI) {
        this.telportId = lllIIlIlIllIIlI;
    }
    
    public CPacketConfirmTeleport() {
    }
}
