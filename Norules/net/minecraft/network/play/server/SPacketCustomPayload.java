package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import io.netty.buffer.*;
import java.io.*;

public class SPacketCustomPayload implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ PacketBuffer data;
    private /* synthetic */ String channel;
    
    public String getChannelName() {
        return this.channel;
    }
    
    public SPacketCustomPayload(final String llllllllllllllIlIllIIIIIIllIIIII, final PacketBuffer llllllllllllllIlIllIIIIIIlIlllll) {
        this.channel = llllllllllllllIlIllIIIIIIllIIIII;
        this.data = llllllllllllllIlIllIIIIIIlIlllll;
        if (llllllllllllllIlIllIIIIIIlIlllll.writerIndex() > 1048576) {
            throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
        }
    }
    
    public SPacketCustomPayload() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIllIIIIIIlIIlIlI) {
        llllllllllllllIlIllIIIIIIlIIlIlI.handleCustomPayload(this);
    }
    
    public PacketBuffer getBufferData() {
        return this.data;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIllIIIIIIlIlIIlI) throws IOException {
        llllllllllllllIlIllIIIIIIlIlIIlI.writeString(this.channel);
        llllllllllllllIlIllIIIIIIlIlIIlI.writeBytes(this.data);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIllIIIIIIlIllIlI) throws IOException {
        this.channel = llllllllllllllIlIllIIIIIIlIllIlI.readStringFromBuffer(20);
        final int llllllllllllllIlIllIIIIIIlIllIIl = llllllllllllllIlIllIIIIIIlIllIlI.readableBytes();
        if (llllllllllllllIlIllIIIIIIlIllIIl >= 0 && llllllllllllllIlIllIIIIIIlIllIIl <= 1048576) {
            this.data = new PacketBuffer(llllllllllllllIlIllIIIIIIlIllIlI.readBytes(llllllllllllllIlIllIIIIIIlIllIIl));
            return;
        }
        throw new IOException("Payload may not be larger than 1048576 bytes");
    }
}
