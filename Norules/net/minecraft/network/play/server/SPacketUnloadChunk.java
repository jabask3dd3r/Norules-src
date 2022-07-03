package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketUnloadChunk implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int x;
    private /* synthetic */ int z;
    
    public SPacketUnloadChunk() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIlIIIIllllllIlI) throws IOException {
        lllllllllllllllIlIlIIIIllllllIlI.writeInt(this.x);
        lllllllllllllllIlIlIIIIllllllIlI.writeInt(this.z);
    }
    
    public SPacketUnloadChunk(final int lllllllllllllllIlIlIIIlIIIIIlIlI, final int lllllllllllllllIlIlIIIlIIIIIIllI) {
        this.x = lllllllllllllllIlIlIIIlIIIIIlIlI;
        this.z = lllllllllllllllIlIlIIIlIIIIIIllI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIlIIIlIIIIIIIlI) throws IOException {
        this.x = lllllllllllllllIlIlIIIlIIIIIIIlI.readInt();
        this.z = lllllllllllllllIlIlIIIlIIIIIIIlI.readInt();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIlIIIIlllllIllI) {
        lllllllllllllllIlIlIIIIlllllIllI.processChunkUnload(this);
    }
    
    public int getZ() {
        return this.z;
    }
    
    public int getX() {
        return this.x;
    }
}
