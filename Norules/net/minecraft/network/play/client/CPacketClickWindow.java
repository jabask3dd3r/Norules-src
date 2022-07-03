package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketClickWindow implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ ItemStack clickedItem;
    private /* synthetic */ int usedButton;
    private /* synthetic */ ClickType mode;
    private /* synthetic */ short actionNumber;
    private /* synthetic */ int slotId;
    
    public CPacketClickWindow() {
        this.clickedItem = ItemStack.field_190927_a;
    }
    
    public short getActionNumber() {
        return this.actionNumber;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIllIIllIIIIlllII) throws IOException {
        this.windowId = llllllllllllllIIIllIIllIIIIlllII.readByte();
        this.slotId = llllllllllllllIIIllIIllIIIIlllII.readShort();
        this.usedButton = llllllllllllllIIIllIIllIIIIlllII.readByte();
        this.actionNumber = llllllllllllllIIIllIIllIIIIlllII.readShort();
        this.mode = llllllllllllllIIIllIIllIIIIlllII.readEnumValue(ClickType.class);
        this.clickedItem = llllllllllllllIIIllIIllIIIIlllII.readItemStackFromBuffer();
    }
    
    public ClickType getClickType() {
        return this.mode;
    }
    
    public int getUsedButton() {
        return this.usedButton;
    }
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public ItemStack getClickedItem() {
        return this.clickedItem;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIIllIIllIIIlIIIlI) {
        llllllllllllllIIIllIIllIIIlIIIlI.processClickWindow(this);
    }
    
    public CPacketClickWindow(final int llllllllllllllIIIllIIllIIIlIllIl, final int llllllllllllllIIIllIIllIIIlIllII, final int llllllllllllllIIIllIIllIIIlIlIll, final ClickType llllllllllllllIIIllIIllIIIlIlIlI, final ItemStack llllllllllllllIIIllIIllIIIlIlIIl, final short llllllllllllllIIIllIIllIIIlIlIII) {
        this.clickedItem = ItemStack.field_190927_a;
        this.windowId = llllllllllllllIIIllIIllIIIlIllIl;
        this.slotId = llllllllllllllIIIllIIllIIIlIllII;
        this.usedButton = llllllllllllllIIIllIIllIIIlIlIll;
        this.clickedItem = llllllllllllllIIIllIIllIIIlIlIIl.copy();
        this.actionNumber = llllllllllllllIIIllIIllIIIlIlIII;
        this.mode = llllllllllllllIIIllIIllIIIlIlIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIllIIllIIIIlIllI) throws IOException {
        llllllllllllllIIIllIIllIIIIlIllI.writeByte(this.windowId);
        llllllllllllllIIIllIIllIIIIlIllI.writeShort(this.slotId);
        llllllllllllllIIIllIIllIIIIlIllI.writeByte(this.usedButton);
        llllllllllllllIIIllIIllIIIIlIllI.writeShort(this.actionNumber);
        llllllllllllllIIIllIIllIIIIlIllI.writeEnumValue(this.mode);
        llllllllllllllIIIllIIllIIIIlIllI.writeItemStackToBuffer(this.clickedItem);
    }
}
