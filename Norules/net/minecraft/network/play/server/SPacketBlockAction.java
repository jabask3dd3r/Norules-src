package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketBlockAction implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int instrument;
    private /* synthetic */ int pitch;
    private /* synthetic */ Block block;
    private /* synthetic */ BlockPos blockPosition;
    
    public SPacketBlockAction() {
    }
    
    public BlockPos getBlockPosition() {
        return this.blockPosition;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlllIlIllIIllIIIlll) throws IOException {
        lllllllllllllIlllIlIllIIllIIIlll.writeBlockPos(this.blockPosition);
        lllllllllllllIlllIlIllIIllIIIlll.writeByte(this.instrument);
        lllllllllllllIlllIlIllIIllIIIlll.writeByte(this.pitch);
        lllllllllllllIlllIlIllIIllIIIlll.writeVarIntToBuffer(Block.getIdFromBlock(this.block) & 0xFFF);
    }
    
    public int getData1() {
        return this.instrument;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlllIlIllIIllIIIIIl) {
        lllllllllllllIlllIlIllIIllIIIIIl.handleBlockAction(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlllIlIllIIllIIlIll) throws IOException {
        this.blockPosition = lllllllllllllIlllIlIllIIllIIlIll.readBlockPos();
        this.instrument = lllllllllllllIlllIlIllIIllIIlIll.readUnsignedByte();
        this.pitch = lllllllllllllIlllIlIllIIllIIlIll.readUnsignedByte();
        this.block = Block.getBlockById(lllllllllllllIlllIlIllIIllIIlIll.readVarIntFromBuffer() & 0xFFF);
    }
    
    public SPacketBlockAction(final BlockPos lllllllllllllIlllIlIllIIllIlIlII, final Block lllllllllllllIlllIlIllIIllIlIIll, final int lllllllllllllIlllIlIllIIllIlIIlI, final int lllllllllllllIlllIlIllIIllIlIIIl) {
        this.blockPosition = lllllllllllllIlllIlIllIIllIlIlII;
        this.instrument = lllllllllllllIlllIlIllIIllIlIIlI;
        this.pitch = lllllllllllllIlllIlIllIIllIlIIIl;
        this.block = lllllllllllllIlllIlIllIIllIlIIll;
    }
    
    public int getData2() {
        return this.pitch;
    }
    
    public Block getBlockType() {
        return this.block;
    }
}
