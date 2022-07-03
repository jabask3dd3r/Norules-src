package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketWindowItems implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ List<ItemStack> itemStacks;
    
    public List<ItemStack> getItemStacks() {
        return this.itemStacks;
    }
    
    public SPacketWindowItems() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllIllIlIIlllIlllII) {
        lllllllllllllIllIllIlIIlllIlllII.handleWindowItems(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIllIlIIlllllIIll) throws IOException {
        this.windowId = lllllllllllllIllIllIlIIlllllIIll.readUnsignedByte();
        final int lllllllllllllIllIllIlIIlllllIIlI = lllllllllllllIllIllIlIIlllllIIll.readShort();
        this.itemStacks = NonNullList.func_191197_a(lllllllllllllIllIllIlIIlllllIIlI, ItemStack.field_190927_a);
        for (int lllllllllllllIllIllIlIIlllllIIIl = 0; lllllllllllllIllIllIlIIlllllIIIl < lllllllllllllIllIllIlIIlllllIIlI; ++lllllllllllllIllIllIlIIlllllIIIl) {
            this.itemStacks.set(lllllllllllllIllIllIlIIlllllIIIl, lllllllllllllIllIllIlIIlllllIIll.readItemStackFromBuffer());
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIllIlIIllllIIlll) throws IOException {
        lllllllllllllIllIllIlIIllllIIlll.writeByte(this.windowId);
        lllllllllllllIllIllIlIIllllIIlll.writeShort(this.itemStacks.size());
        for (final ItemStack lllllllllllllIllIllIlIIllllIIllI : this.itemStacks) {
            lllllllllllllIllIllIlIIllllIIlll.writeItemStackToBuffer(lllllllllllllIllIllIlIIllllIIllI);
        }
    }
    
    public SPacketWindowItems(final int lllllllllllllIllIllIlIlIIIIIIIIl, final NonNullList<ItemStack> lllllllllllllIllIllIlIlIIIIIIIII) {
        this.windowId = lllllllllllllIllIllIlIlIIIIIIIIl;
        this.itemStacks = NonNullList.func_191197_a(lllllllllllllIllIllIlIlIIIIIIIII.size(), ItemStack.field_190927_a);
        for (int lllllllllllllIllIllIlIIlllllllll = 0; lllllllllllllIllIllIlIIlllllllll < this.itemStacks.size(); ++lllllllllllllIllIllIlIIlllllllll) {
            final ItemStack lllllllllllllIllIllIlIIllllllllI = lllllllllllllIllIllIlIlIIIIIIIII.get(lllllllllllllIllIllIlIIlllllllll);
            this.itemStacks.set(lllllllllllllIllIllIlIIlllllllll, lllllllllllllIllIllIlIIllllllllI.copy());
        }
    }
    
    public int getWindowId() {
        return this.windowId;
    }
}
