package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.item.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketCooldown implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int ticks;
    private /* synthetic */ Item item;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlllIlIlIIlIlllll) throws IOException {
        this.item = Item.getItemById(llllllllllllllIIlllIlIlIIlIlllll.readVarIntFromBuffer());
        this.ticks = llllllllllllllIIlllIlIlIIlIlllll.readVarIntFromBuffer();
    }
    
    public SPacketCooldown(final Item llllllllllllllIIlllIlIlIIllIIlll, final int llllllllllllllIIlllIlIlIIllIIllI) {
        this.item = llllllllllllllIIlllIlIlIIllIIlll;
        this.ticks = llllllllllllllIIlllIlIlIIllIIllI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlllIlIlIIlIlIIll) {
        llllllllllllllIIlllIlIlIIlIlIIll.handleCooldown(this);
    }
    
    public SPacketCooldown() {
    }
    
    public int getTicks() {
        return this.ticks;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlllIlIlIIlIlIlll) throws IOException {
        llllllllllllllIIlllIlIlIIlIlIlll.writeVarIntToBuffer(Item.getIdFromItem(this.item));
        llllllllllllllIIlllIlIlIIlIlIlll.writeVarIntToBuffer(this.ticks);
    }
}
