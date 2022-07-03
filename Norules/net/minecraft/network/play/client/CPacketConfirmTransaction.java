package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketConfirmTransaction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ boolean accepted;
    private /* synthetic */ int windowId;
    private /* synthetic */ short uid;
    
    public short getUid() {
        return this.uid;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIIIIIlIIlIIIll) throws IOException {
        this.windowId = llllllllllllllIllIIIIIIlIIlIIIll.readByte();
        this.uid = llllllllllllllIllIIIIIIlIIlIIIll.readShort();
        this.accepted = (llllllllllllllIllIIIIIIlIIlIIIll.readByte() != 0);
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIllIIIIIIlIIlIIlll) {
        llllllllllllllIllIIIIIIlIIlIIlll.processConfirmTransaction(this);
    }
    
    public CPacketConfirmTransaction(final int llllllllllllllIllIIIIIIlIIlIllll, final short llllllllllllllIllIIIIIIlIIlIlllI, final boolean llllllllllllllIllIIIIIIlIIlIllIl) {
        this.windowId = llllllllllllllIllIIIIIIlIIlIllll;
        this.uid = llllllllllllllIllIIIIIIlIIlIlllI;
        this.accepted = llllllllllllllIllIIIIIIlIIlIllIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIIIIIlIIIllIll) throws IOException {
        llllllllllllllIllIIIIIIlIIIllIll.writeByte(this.windowId);
        llllllllllllllIllIIIIIIlIIIllIll.writeShort(this.uid);
        llllllllllllllIllIIIIIIlIIIllIll.writeByte(this.accepted ? 1 : 0);
    }
    
    public CPacketConfirmTransaction() {
    }
}
