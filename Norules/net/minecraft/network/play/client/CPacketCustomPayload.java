package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import io.netty.buffer.*;
import java.io.*;

public class CPacketCustomPayload implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String channel;
    private /* synthetic */ PacketBuffer data;
    
    public String getChannelName() {
        return this.channel;
    }
    
    public CPacketCustomPayload(final String lllllllllllllIllIIlIIIllIllllllI, final PacketBuffer lllllllllllllIllIIlIIIllIlllllIl) {
        this.channel = lllllllllllllIllIIlIIIllIllllllI;
        this.data = lllllllllllllIllIIlIIIllIlllllIl;
        if (lllllllllllllIllIIlIIIllIlllllIl.writerIndex() > 32767) {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }
    
    public CPacketCustomPayload() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIlIIIllIlIllIlI) throws IOException {
        lllllllllllllIllIIlIIIllIlIllIlI.writeString(this.channel);
        lllllllllllllIllIIlIIIllIlIllIlI.writeBytes(this.data);
    }
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllIIlIIIllIlIIlllI) {
        lllllllllllllIllIIlIIIllIlIIlllI.processCustomPayload(this);
        if (this.data != null) {
            this.data.release();
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIlIIIllIllIlIIl) throws IOException {
        this.channel = lllllllllllllIllIIlIIIllIllIlIIl.readStringFromBuffer(20);
        final int lllllllllllllIllIIlIIIllIllIlIII = lllllllllllllIllIIlIIIllIllIlIIl.readableBytes();
        if (lllllllllllllIllIIlIIIllIllIlIII >= 0 && lllllllllllllIllIIlIIIllIllIlIII <= 32767) {
            this.data = new PacketBuffer(lllllllllllllIllIIlIIIllIllIlIIl.readBytes(lllllllllllllIllIIlIIIllIllIlIII));
            return;
        }
        throw new IOException("Payload may not be larger than 32767 bytes");
    }
}
