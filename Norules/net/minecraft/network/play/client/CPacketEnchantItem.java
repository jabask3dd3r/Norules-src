package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketEnchantItem implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ int button;
    
    public CPacketEnchantItem() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIlIlllIlIllIIIIII) {
        llllllllllllllIIlIlllIlIllIIIIII.processEnchantItem(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIlllIlIlIlllIlI) throws IOException {
        this.windowId = llllllllllllllIIlIlllIlIlIlllIlI.readByte();
        this.button = llllllllllllllIIlIlllIlIlIlllIlI.readByte();
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public CPacketEnchantItem(final int llllllllllllllIIlIlllIlIllIIIlll, final int llllllllllllllIIlIlllIlIllIIlIIl) {
        this.windowId = llllllllllllllIIlIlllIlIllIIIlll;
        this.button = llllllllllllllIIlIlllIlIllIIlIIl;
    }
    
    public int getButton() {
        return this.button;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIlllIlIlIllIllI) throws IOException {
        llllllllllllllIIlIlllIlIlIllIllI.writeByte(this.windowId);
        llllllllllllllIIlIlllIlIlIllIllI.writeByte(this.button);
    }
}
