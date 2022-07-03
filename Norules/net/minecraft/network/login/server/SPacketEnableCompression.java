package net.minecraft.network.login.server;

import net.minecraft.network.login.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketEnableCompression implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ int compressionThreshold;
    
    public int getCompressionThreshold() {
        return this.compressionThreshold;
    }
    
    public SPacketEnableCompression() {
    }
    
    public SPacketEnableCompression(final int lllllllllllllIIllIIlIIllIIllIlll) {
        this.compressionThreshold = lllllllllllllIIllIIlIIllIIllIlll;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient lllllllllllllIIllIIlIIllIIlIIlIl) {
        lllllllllllllIIllIIlIIllIIlIIlIl.handleEnableCompression(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIIlIIllIIlIlIll) throws IOException {
        lllllllllllllIIllIIlIIllIIlIlIll.writeVarIntToBuffer(this.compressionThreshold);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIIlIIllIIllIIIl) throws IOException {
        this.compressionThreshold = lllllllllllllIIllIIlIIllIIllIIIl.readVarIntFromBuffer();
    }
}
