package net.minecraft.network.status.client;

import net.minecraft.network.status.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketServerQuery implements Packet<INetHandlerStatusServer>
{
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllllIIIIIlIlllIIl) throws IOException {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllllIIIIIlIlllIll) throws IOException {
    }
    
    @Override
    public void processPacket(final INetHandlerStatusServer lllllllllllllIIllllIIIIIlIllIlIl) {
        lllllllllllllIIllllIIIIIlIllIlIl.processServerQuery(this);
    }
}
