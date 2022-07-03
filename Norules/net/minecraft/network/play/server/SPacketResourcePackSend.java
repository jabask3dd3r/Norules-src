package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketResourcePackSend implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String url;
    private /* synthetic */ String hash;
    
    public SPacketResourcePackSend() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIllIIIIlIlIIlIlI) {
        llllllllllllllIIIllIIIIlIlIIlIlI.handleResourcePack(this);
    }
    
    public String getURL() {
        return this.url;
    }
    
    public SPacketResourcePackSend(final String llllllllllllllIIIllIIIIlIllIIIII, final String llllllllllllllIIIllIIIIlIlIlllll) {
        this.url = llllllllllllllIIIllIIIIlIllIIIII;
        this.hash = llllllllllllllIIIllIIIIlIlIlllll;
        if (llllllllllllllIIIllIIIIlIlIlllll.length() > 40) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Hash is too long (max 40, was ").append(llllllllllllllIIIllIIIIlIlIlllll.length()).append(")")));
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIllIIIIlIlIllIII) throws IOException {
        this.url = llllllllllllllIIIllIIIIlIlIllIII.readStringFromBuffer(32767);
        this.hash = llllllllllllllIIIllIIIIlIlIllIII.readStringFromBuffer(40);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIllIIIIlIlIlIIII) throws IOException {
        llllllllllllllIIIllIIIIlIlIlIIII.writeString(this.url);
        llllllllllllllIIIllIIIIlIlIlIIII.writeString(this.hash);
    }
    
    public String getHash() {
        return this.hash;
    }
}
