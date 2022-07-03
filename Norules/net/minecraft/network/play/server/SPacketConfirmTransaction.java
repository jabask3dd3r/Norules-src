package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketConfirmTransaction implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ boolean accepted;
    private /* synthetic */ short actionNumber;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllllIIllIlllIIIlI) throws IOException {
        llllllllllllllIllllIIllIlllIIIlI.writeByte(this.windowId);
        llllllllllllllIllllIIllIlllIIIlI.writeShort(this.actionNumber);
        llllllllllllllIllllIIllIlllIIIlI.writeBoolean(this.accepted);
    }
    
    public short getActionNumber() {
        return this.actionNumber;
    }
    
    public SPacketConfirmTransaction(final int llllllllllllllIllllIIlllIIIIlllI, final short llllllllllllllIllllIIlllIIIIlIIl, final boolean llllllllllllllIllllIIlllIIIIIlll) {
        this.windowId = llllllllllllllIllllIIlllIIIIlllI;
        this.actionNumber = llllllllllllllIllllIIlllIIIIlIIl;
        this.accepted = llllllllllllllIllllIIlllIIIIIlll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllllIIllIlllIllIl) throws IOException {
        this.windowId = llllllllllllllIllllIIllIlllIllIl.readUnsignedByte();
        this.actionNumber = llllllllllllllIllllIIllIlllIllIl.readShort();
        this.accepted = llllllllllllllIllllIIllIlllIllIl.readBoolean();
    }
    
    public boolean wasAccepted() {
        return this.accepted;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIllllIIllIllllllIl) {
        llllllllllllllIllllIIllIllllllIl.handleConfirmTransaction(this);
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public SPacketConfirmTransaction() {
    }
}
