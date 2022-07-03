package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.world.*;

public class SPacketUseBed implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockPos bedPos;
    private /* synthetic */ int playerID;
    
    public SPacketUseBed(final EntityPlayer llllllllllllllIlIlIlllllIlllIIII, final BlockPos llllllllllllllIlIlIlllllIlllIIlI) {
        this.playerID = llllllllllllllIlIlIlllllIlllIIII.getEntityId();
        this.bedPos = llllllllllllllIlIlIlllllIlllIIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIlIlllllIlIlllIl) {
        llllllllllllllIlIlIlllllIlIlllIl.handleUseBed(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIlllllIllIlIIl) throws IOException {
        this.playerID = llllllllllllllIlIlIlllllIllIlIIl.readVarIntFromBuffer();
        this.bedPos = llllllllllllllIlIlIlllllIllIlIIl.readBlockPos();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIlllllIllIIlIl) throws IOException {
        llllllllllllllIlIlIlllllIllIIlIl.writeVarIntToBuffer(this.playerID);
        llllllllllllllIlIlIlllllIllIIlIl.writeBlockPos(this.bedPos);
    }
    
    public EntityPlayer getPlayer(final World llllllllllllllIlIlIlllllIlIllIIl) {
        return (EntityPlayer)llllllllllllllIlIlIlllllIlIllIIl.getEntityByID(this.playerID);
    }
    
    public SPacketUseBed() {
    }
    
    public BlockPos getBedPosition() {
        return this.bedPos;
    }
}
