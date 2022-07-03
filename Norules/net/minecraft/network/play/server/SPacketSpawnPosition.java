package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketSpawnPosition implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockPos spawnBlockPos;
    
    @Override
    public void readPacketData(final PacketBuffer lllllIIlIIIlIll) throws IOException {
        this.spawnBlockPos = lllllIIlIIIlIll.readBlockPos();
    }
    
    public SPacketSpawnPosition(final BlockPos lllllIIlIIIllll) {
        this.spawnBlockPos = lllllIIlIIIllll;
    }
    
    public BlockPos getSpawnPos() {
        return this.spawnBlockPos;
    }
    
    public SPacketSpawnPosition() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllIIlIIIIIll) throws IOException {
        lllllIIlIIIIIll.writeBlockPos(this.spawnBlockPos);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllIIIlllllll) {
        lllllIIIlllllll.handleSpawnPosition(this);
    }
}
