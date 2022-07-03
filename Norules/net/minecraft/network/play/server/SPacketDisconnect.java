package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.text.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketDisconnect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ITextComponent reason;
    
    public SPacketDisconnect() {
    }
    
    public SPacketDisconnect(final ITextComponent lllllllllllllllIIllIlIlllIIllIlI) {
        this.reason = lllllllllllllllIIllIlIlllIIllIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIlIlllIIlIIlI) throws IOException {
        this.reason = lllllllllllllllIIllIlIlllIIlIIlI.readTextComponent();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIlIlllIIIllII) throws IOException {
        lllllllllllllllIIllIlIlllIIIllII.writeTextComponent(this.reason);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllIlIlllIIIIllI) {
        lllllllllllllllIIllIlIlllIIIIllI.handleDisconnect(this);
    }
    
    public ITextComponent getReason() {
        return this.reason;
    }
}
