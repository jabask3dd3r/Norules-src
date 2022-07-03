package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketPlayerDigging implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ EnumFacing facing;
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIIIIlIIlIlIIIII) throws IOException {
        lllllllllllllIIllIIIIlIIlIlIIIII.writeEnumValue(this.action);
        lllllllllllllIIllIIIIlIIlIlIIIII.writeBlockPos(this.position);
        lllllllllllllIIllIIIIlIIlIlIIIII.writeByte(this.facing.getIndex());
    }
    
    public CPacketPlayerDigging(final Action lllllllllllllIIllIIIIlIIlIlIllII, final BlockPos lllllllllllllIIllIIIIlIIlIlIlIll, final EnumFacing lllllllllllllIIllIIIIlIIlIlIlIlI) {
        this.action = lllllllllllllIIllIIIIlIIlIlIllII;
        this.position = lllllllllllllIIllIIIIlIIlIlIlIll;
        this.facing = lllllllllllllIIllIIIIlIIlIlIlIlI;
    }
    
    public EnumFacing getFacing() {
        return this.facing;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIIllIIIIlIIlIIllIII) {
        lllllllllllllIIllIIIIlIIlIIllIII.processPlayerDigging(this);
    }
    
    public CPacketPlayerDigging() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIIIIlIIlIlIIllI) throws IOException {
        this.action = lllllllllllllIIllIIIIlIIlIlIIllI.readEnumValue(Action.class);
        this.position = lllllllllllllIIllIIIIlIIlIlIIllI.readBlockPos();
        this.facing = EnumFacing.getFront(lllllllllllllIIllIIIIlIIlIlIIllI.readUnsignedByte());
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public enum Action
    {
        START_DESTROY_BLOCK("START_DESTROY_BLOCK", 0), 
        DROP_ITEM("DROP_ITEM", 4), 
        RELEASE_USE_ITEM("RELEASE_USE_ITEM", 5), 
        DROP_ALL_ITEMS("DROP_ALL_ITEMS", 3), 
        STOP_DESTROY_BLOCK("STOP_DESTROY_BLOCK", 2), 
        SWAP_HELD_ITEMS("SWAP_HELD_ITEMS", 6), 
        ABORT_DESTROY_BLOCK("ABORT_DESTROY_BLOCK", 1);
        
        private Action(final String llllllllllllllIIIIlIIIIllIlIIllI, final int llllllllllllllIIIIlIIIIllIlIIlIl) {
        }
    }
}
