package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketSetSlot implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int slot;
    private /* synthetic */ ItemStack item;
    private /* synthetic */ int windowId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllIIIlIlIllI) {
        llllIIIlIlIllI.handleSetSlot(this);
    }
    
    public SPacketSetSlot() {
        this.item = ItemStack.field_190927_a;
    }
    
    public int getSlot() {
        return this.slot;
    }
    
    public ItemStack getStack() {
        return this.item;
    }
    
    public SPacketSetSlot(final int llllIIIlIlllII, final int llllIIIlIllIll, final ItemStack llllIIIlIllIlI) {
        this.item = ItemStack.field_190927_a;
        this.windowId = llllIIIlIlllII;
        this.slot = llllIIIlIllIll;
        this.item = llllIIIlIllIlI.copy();
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllIIIlIIlIlI) throws IOException {
        llllIIIlIIlIlI.writeByte(this.windowId);
        llllIIIlIIlIlI.writeShort(this.slot);
        llllIIIlIIlIlI.writeItemStackToBuffer(this.item);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllIIIlIlIIII) throws IOException {
        this.windowId = llllIIIlIlIIII.readByte();
        this.slot = llllIIIlIlIIII.readShort();
        this.item = llllIIIlIlIIII.readItemStackFromBuffer();
    }
}
