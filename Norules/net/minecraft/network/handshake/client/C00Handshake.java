package net.minecraft.network.handshake.client;

import net.minecraft.network.handshake.*;
import net.minecraft.network.*;
import java.io.*;

public class C00Handshake implements Packet<INetHandlerHandshakeServer>
{
    private /* synthetic */ int protocolVersion;
    private /* synthetic */ String ip;
    private /* synthetic */ int port;
    private /* synthetic */ EnumConnectionState requestedState;
    
    public EnumConnectionState getRequestedState() {
        return this.requestedState;
    }
    
    public int getProtocolVersion() {
        return this.protocolVersion;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllIllIIIIlllIIllll) throws IOException {
        this.protocolVersion = llllllllllllllllIllIIIIlllIIllll.readVarIntFromBuffer();
        this.ip = llllllllllllllllIllIIIIlllIIllll.readStringFromBuffer(255);
        this.port = llllllllllllllllIllIIIIlllIIllll.readUnsignedShort();
        this.requestedState = EnumConnectionState.getById(llllllllllllllllIllIIIIlllIIllll.readVarIntFromBuffer());
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllIllIIIIlllIIlIll) throws IOException {
        llllllllllllllllIllIIIIlllIIlIll.writeVarIntToBuffer(this.protocolVersion);
        llllllllllllllllIllIIIIlllIIlIll.writeString(this.ip);
        llllllllllllllllIllIIIIlllIIlIll.writeShort(this.port);
        llllllllllllllllIllIIIIlllIIlIll.writeVarIntToBuffer(this.requestedState.getId());
    }
    
    @Override
    public void processPacket(final INetHandlerHandshakeServer llllllllllllllllIllIIIIlllIIIIll) {
        llllllllllllllllIllIIIIlllIIIIll.processHandshake(this);
    }
    
    public C00Handshake(final String llllllllllllllllIllIIIIlllIllIll, final int llllllllllllllllIllIIIIlllIlIllI, final EnumConnectionState llllllllllllllllIllIIIIlllIlIlIl) {
        this.protocolVersion = 340;
        this.ip = llllllllllllllllIllIIIIlllIllIll;
        this.port = llllllllllllllllIllIIIIlllIlIllI;
        this.requestedState = llllllllllllllllIllIIIIlllIlIlIl;
    }
    
    public C00Handshake() {
    }
}
