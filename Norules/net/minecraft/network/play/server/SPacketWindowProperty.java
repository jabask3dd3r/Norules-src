package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketWindowProperty implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int value;
    private /* synthetic */ int windowId;
    private /* synthetic */ int property;
    
    public int getProperty() {
        return this.property;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIIlIllIIIIllIlll) {
        lllllllllllllllIIIlIllIIIIllIlll.handleWindowProperty(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIlIllIIIIlIlIlI) throws IOException {
        this.windowId = lllllllllllllllIIIlIllIIIIlIlIlI.readUnsignedByte();
        this.property = lllllllllllllllIIIlIllIIIIlIlIlI.readShort();
        this.value = lllllllllllllllIIIlIllIIIIlIlIlI.readShort();
    }
    
    public int getValue() {
        return this.value;
    }
    
    public SPacketWindowProperty() {
    }
    
    public SPacketWindowProperty(final int lllllllllllllllIIIlIllIIIlIIlIlI, final int lllllllllllllllIIIlIllIIIlIIlIIl, final int lllllllllllllllIIIlIllIIIlIIIlll) {
        this.windowId = lllllllllllllllIIIlIllIIIlIIlIlI;
        this.property = lllllllllllllllIIIlIllIIIlIIlIIl;
        this.value = lllllllllllllllIIIlIllIIIlIIIlll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIlIllIIIIlIIllI) throws IOException {
        lllllllllllllllIIIlIllIIIIlIIllI.writeByte(this.windowId);
        lllllllllllllllIIIlIllIIIIlIIllI.writeShort(this.property);
        lllllllllllllllIIIlIllIIIIlIIllI.writeShort(this.value);
    }
}
