package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketBlockBreakAnim implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int breakerId;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ int progress;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllIIllIlIIllIIII) throws IOException {
        llllllllllllllllllIIllIlIIllIIII.writeVarIntToBuffer(this.breakerId);
        llllllllllllllllllIIllIlIIllIIII.writeBlockPos(this.position);
        llllllllllllllllllIIllIlIIllIIII.writeByte(this.progress);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllllIIllIlIIlllIII) throws IOException {
        this.breakerId = llllllllllllllllllIIllIlIIlllIII.readVarIntFromBuffer();
        this.position = llllllllllllllllllIIllIlIIlllIII.readBlockPos();
        this.progress = llllllllllllllllllIIllIlIIlllIII.readUnsignedByte();
    }
    
    public SPacketBlockBreakAnim() {
    }
    
    public int getProgress() {
        return this.progress;
    }
    
    public int getBreakerId() {
        return this.breakerId;
    }
    
    public SPacketBlockBreakAnim(final int llllllllllllllllllIIllIlIIlllllI, final BlockPos llllllllllllllllllIIllIlIlIIIIIl, final int llllllllllllllllllIIllIlIlIIIIII) {
        this.breakerId = llllllllllllllllllIIllIlIIlllllI;
        this.position = llllllllllllllllllIIllIlIlIIIIIl;
        this.progress = llllllllllllllllllIIllIlIlIIIIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllllllIIllIlIIlIllII) {
        llllllllllllllllllIIllIlIIlIllII.handleBlockBreakAnim(this);
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
}
