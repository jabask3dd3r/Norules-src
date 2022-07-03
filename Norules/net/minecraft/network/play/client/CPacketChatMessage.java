package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketChatMessage implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String message;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIllIllIIIlIlll) throws IOException {
        this.message = llllllllllllllIlIlIllIllIIIlIlll.readStringFromBuffer(256);
    }
    
    public CPacketChatMessage() {
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIlIlIllIllIIIIlIll) {
        llllllllllllllIlIlIllIllIIIIlIll.processChatMessage(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIllIllIIIlIIIl) throws IOException {
        llllllllllllllIlIlIllIllIIIlIIIl.writeString(this.message);
    }
    
    public CPacketChatMessage(String llllllllllllllIlIlIllIllIIIllIll) {
        if (llllllllllllllIlIlIllIllIIIllIll.length() > 256) {
            llllllllllllllIlIlIllIllIIIllIll = llllllllllllllIlIlIllIllIIIllIll.substring(0, 256);
        }
        this.message = llllllllllllllIlIlIllIllIIIllIll;
    }
}
