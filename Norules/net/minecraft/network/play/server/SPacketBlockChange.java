package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import java.io.*;

public class SPacketBlockChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ IBlockState blockState;
    private /* synthetic */ BlockPos blockPosition;
    
    public SPacketBlockChange(final World llllllllllllllIlIIlIIlllIlIllIII, final BlockPos llllllllllllllIlIIlIIlllIlIlIlll) {
        this.blockPosition = llllllllllllllIlIIlIIlllIlIlIlll;
        this.blockState = llllllllllllllIlIIlIIlllIlIllIII.getBlockState(llllllllllllllIlIIlIIlllIlIlIlll);
    }
    
    public BlockPos getBlockPosition() {
        return this.blockPosition;
    }
    
    public SPacketBlockChange() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIlIIlllIlIIlIII) throws IOException {
        llllllllllllllIlIIlIIlllIlIIlIII.writeBlockPos(this.blockPosition);
        llllllllllllllIlIIlIIlllIlIIlIII.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.blockState));
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIlIIlllIlIIIIlI) {
        llllllllllllllIlIIlIIlllIlIIIIlI.handleBlockChange(this);
    }
    
    public IBlockState getBlockState() {
        return this.blockState;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIlIIlllIlIIlllI) throws IOException {
        this.blockPosition = llllllllllllllIlIIlIIlllIlIIlllI.readBlockPos();
        this.blockState = Block.BLOCK_STATE_IDS.getByValue(llllllllllllllIlIIlIIlllIlIIlllI.readVarIntFromBuffer());
    }
}
