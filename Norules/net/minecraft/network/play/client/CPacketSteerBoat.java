package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class CPacketSteerBoat implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ boolean right;
    private /* synthetic */ boolean left;
    
    public boolean getLeft() {
        return this.left;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllllIIIlIllllIIlll) throws IOException {
        lllllllllllllIllllIIIlIllllIIlll.writeBoolean(this.left);
        lllllllllllllIllllIIIlIllllIIlll.writeBoolean(this.right);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllllIIIlIllllIllll) throws IOException {
        this.left = lllllllllllllIllllIIIlIllllIllll.readBoolean();
        this.right = lllllllllllllIllllIIIlIllllIllll.readBoolean();
    }
    
    public boolean getRight() {
        return this.right;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllllIIIlIllllIIIIl) {
        lllllllllllllIllllIIIlIllllIIIIl.processSteerBoat(this);
    }
    
    public CPacketSteerBoat() {
    }
    
    public CPacketSteerBoat(final boolean lllllllllllllIllllIIIlIlllllIlII, final boolean lllllllllllllIllllIIIlIlllllIllI) {
        this.left = lllllllllllllIllllIIIlIlllllIlII;
        this.right = lllllllllllllIllllIIIlIlllllIllI;
    }
}
