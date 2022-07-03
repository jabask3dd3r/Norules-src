package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.item.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketCreativeInventoryAction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int slotId;
    private /* synthetic */ ItemStack stack;
    
    @Override
    public void processPacket(final INetHandlerPlayServer lIlIlllllIllllI) {
        lIlIlllllIllllI.processCreativeInventoryAction(this);
    }
    
    public CPacketCreativeInventoryAction() {
        this.stack = ItemStack.field_190927_a;
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIlIlllllIllIII) throws IOException {
        this.slotId = lIlIlllllIllIII.readShort();
        this.stack = lIlIlllllIllIII.readItemStackFromBuffer();
    }
    
    public CPacketCreativeInventoryAction(final int lIlIllllllIlIII, final ItemStack lIlIllllllIIlII) {
        this.stack = ItemStack.field_190927_a;
        this.slotId = lIlIllllllIlIII;
        this.stack = lIlIllllllIIlII.copy();
    }
    
    public ItemStack getStack() {
        return this.stack;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIlIlllllIlIlII) throws IOException {
        lIlIlllllIlIlII.writeShort(this.slotId);
        lIlIlllllIlIlII.writeItemStackToBuffer(this.stack);
    }
}
