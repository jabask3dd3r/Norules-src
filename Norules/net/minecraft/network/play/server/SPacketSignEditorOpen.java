package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketSignEditorOpen implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockPos signPosition;
    
    public BlockPos getSignPosition() {
        return this.signPosition;
    }
    
    public SPacketSignEditorOpen(final BlockPos lllllllllllllIIIlllIIllIIIIlIIII) {
        this.signPosition = lllllllllllllIIIlllIIllIIIIlIIII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlllIIlIlllllllII) throws IOException {
        lllllllllllllIIIlllIIlIlllllllII.writeBlockPos(this.signPosition);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlllIIllIIIIIlIII) {
        lllllllllllllIIIlllIIllIIIIIlIII.handleSignEditorOpen(this);
    }
    
    public SPacketSignEditorOpen() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlllIIllIIIIIIlII) throws IOException {
        this.signPosition = lllllllllllllIIIlllIIllIIIIIIlII.readBlockPos();
    }
}
