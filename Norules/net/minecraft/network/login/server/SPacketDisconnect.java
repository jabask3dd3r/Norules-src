package net.minecraft.network.login.server;

import net.minecraft.network.login.*;
import net.minecraft.util.text.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketDisconnect implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ ITextComponent reason;
    
    public SPacketDisconnect() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIlIllIlIIllIIl) throws IOException {
        this.reason = ITextComponent.Serializer.fromJsonLenient(llllllllllllllIlIlIlIllIlIIllIIl.readStringFromBuffer(32767));
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient llllllllllllllIlIlIlIllIlIIIllIl) {
        llllllllllllllIlIlIlIllIlIIIllIl.handleDisconnect(this);
    }
    
    public SPacketDisconnect(final ITextComponent llllllllllllllIlIlIlIllIlIIlllll) {
        this.reason = llllllllllllllIlIlIlIllIlIIlllll;
    }
    
    public ITextComponent getReason() {
        return this.reason;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIlIllIlIIlIIll) throws IOException {
        llllllllllllllIlIlIlIllIlIIlIIll.writeTextComponent(this.reason);
    }
}
